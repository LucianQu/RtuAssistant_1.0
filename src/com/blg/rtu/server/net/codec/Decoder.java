package com.blg.rtu.server.net.codec;

import java.io.*;

import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.core.buffer.*;
import org.apache.mina.core.session.IoSession;

import android.util.Log;

import com.blg.rtu.server.net.NetManager;
import com.blg.rtu.util.ByteUtilUnsigned;
import com.blg.rtu.util.StringValueForServer;

public class Decoder extends CumulativeProtocolDecoder {
	
	private static String tag = Decoder.class.getName() ;

	/**
	 * 解码
	 * @see org.apache.mina.filter.codec.CumulativeProtocolDecoder#doDecode(org.apache.mina.core.session.IoSession,
	 *      org.apache.mina.core.buffer.IoBuffer,
	 *      org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	protected boolean doDecode(IoSession session, 
			IoBuffer in,
			ProtocolDecoderOutput out) throws IOException, Exception {
		int minLen = StringValueForServer.protocolPackageMinLen ;
		if(minLen != 3){
			minLen = 3 ;
		}
		Integer[] flag = prefixedDataAvailable(in, 
				StringValueForServer.protocolPackageHead,
				minLen, 
				StringValueForServer.protocolPackageMaxLen);
		
		boolean banner = false ;
		if(flag[0] == -3){
			banner = false ;
		}else{
			if(flag[0] == -2){
				this.nextDealNoProtocol(in, flag[1], out);
				this.doDecode(session, in, out);// 加上递归
				banner = false ;
			}else{
				if (flag[0] == -1) {
					banner = false ;
					Log.i(tag, "协议数据断包了") ;
				} else if (flag[0] == 0 || flag[0] == 1) {
					this.nextDealProtocol(in, flag[1], out);
					if (flag[0] == 1) {
						Log.i(tag, "协议数据粘包了") ;
						this.doDecode(session, in, out);// 加上递归
						banner = false ;// 加上递归，就得return false
					} else {
						Log.i(tag, "协议数据不断不粘") ;
						banner = true ;
					}
				}
			}
		}
		return banner ;
	}

	/**
	 * 向后传送数据非协议数据
	 * @param in
	 * @param out
	 */
	private void nextDealNoProtocol(IoBuffer in, Integer length, ProtocolDecoderOutput out) {
		byte[] data = new byte[length == null ? in.limit() : length];
		in.get(data);// get一个字节，相应position向后移动一个字节
		NetManager nm = NetManager.getInstance();
		if (nm != null) {
			nm.receiveNoProtocolData(data) ;
		}
	}
	/**
	 * 向后传送数据
	 * @param in
	 * @param out
	 */
	private void nextDealProtocol(IoBuffer in, Integer length, ProtocolDecoderOutput out) {
		Integer len = length;
		if(len == null){
			len = in.limit() ;
		}else{
			len += StringValueForServer.protocolPackageLenNoInclud ;
			if(len > in.limit()){
				len = in.limit() ;
			}
		}
		byte[] data = new byte[len];
		in.get(data);// get一个字节，相应position向后移动一个字节
		out.write(data);
	}

	/**
	 * 断包粘包检查
	 * {@inheritDoc}
	 * @throws Exception
	 */
	private Integer[] prefixedDataAvailable(
			IoBuffer in, 
			int head, 
			int baseMinLength, 
			int maxDataLength) throws Exception {
		int remain = 0 ;
		int oldPosition = 0 ;
		
		remain = in.remaining();
		if (remain == 0 ) {
			return new Integer[] { -3, null };
		}
		
		//////////////////////////////////////////////
		//start 处理非协议部分
		oldPosition = in.position();
		byte[] b = new byte[remain] ;
		in.get(b);
		in.position(oldPosition);
		
		int upHead = 0 ;
		int noProtocolDataLen = 0 ;//非协议数据长度
		for(int i = 0 ; i < b.length ; i++){
			upHead = (b[i] + 256) % 256;
			if(upHead == head){
				if(b.length - i >= baseMinLength){
					upHead = (b[i + 2] + 256) % 256;//后第三个字节数据
					if(upHead == head){//后第三个字节数据是协议头
						noProtocolDataLen = i ;//此处为i
						break;//此处结束for循环处理
					}else{
						noProtocolDataLen = i + 1 ;//此处为i + 1
					}
				}else{
					noProtocolDataLen = i ;//此处为i
					break;//此处结束for循环处理
				}
			}else{
				noProtocolDataLen = i + 1 ;//此处为i + 1
			}
		}
		
		if(noProtocolDataLen > 0){
			return new Integer[] { -2, noProtocolDataLen};
		}
		if (remain < baseMinLength) {
			return new Integer[] { -1, null };
		}
		
		oldPosition = in.position();

		byte[] preByte = new byte[baseMinLength];
		in.get(preByte);
		in.position(oldPosition);

		int upHead1 = (preByte[StringValueForServer.protocolPackageHead_1_index] + 256) % 256;
		if (upHead1 != head) {
			throw new BufferDataException("严重错误，在进行包检查时，数据帧头(" + Integer.toHexString(upHead1) + ")不是" + Integer.toHexString(head) + "。");
		}
		int upHead2 = (preByte[StringValueForServer.protocolPackageHead_2_index] + 256) % 256;
		if (upHead2 != head) {
			throw new BufferDataException("严重错误，在进行包检查时，数据帧头(" + Integer.toHexString(upHead2) + ")不是" + Integer.toHexString(head) + "。");
		}

		int len = 0 ;
		int lenBytes = StringValueForServer.protocolPackageLenEndIndex - StringValueForServer.protocolPackageLenStartIndex + 1 ; 
		if(lenBytes == 1){
			len = (preByte[StringValueForServer.protocolPackageLenStartIndex] + 256) % 256;
		}else if(lenBytes == 2){
			len = ByteUtilUnsigned.bytes2Short(preByte, StringValueForServer.protocolPackageLenStartIndex);
		}else{
			throw new BufferDataException("严重错误，在进行包检查时，数据帧头中数据长度所占节数即不是1也不是2。");
		}
		
		if (len <= 0 || len > maxDataLength) {
			throw new BufferDataException("严重错误，在进行断包与粘包检查时，数据帧的长度(" + len	+ ")不在合法范围。");
		}

		if (remain == len) {
			return new Integer[] { 0, len };
		} else if (remain > len) {
			return new Integer[] { 1, len };
		} else {
			return new Integer[] { -1, null };
		}
	}
}
