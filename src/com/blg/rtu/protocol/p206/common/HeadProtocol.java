package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtilUnsigned;

public class HeadProtocol {
	
	public static int len_noUserData = Constant.Bits_Head + //非用户数据域长度
										Constant.Bits_CRC + 
										Constant.Bits_Tail  ;

	

	/**
	 * 分析数据头
	 * @param b
	 */
	public int checkHeadAndGetDataLen(byte[] b) throws Exception{
		int n = 0 ;
		if(b[n++] != Constant.HEAD){
			throw new Exception("RTU数据头第一字节不是68H") ;
		}
		int len = 0 ;
		int bits_len = Constant.Bits_Len;
		
		if(bits_len == 1){
			len = (b[n] + 256) % 256  ;
		}else if(bits_len == 2){
			len = ByteUtilUnsigned.bytes2Short_an(b, n) ;
		}else if(bits_len == 4){
			len = (int)ByteUtilUnsigned.bytes2Int_an(b, n) ;
		}
		if(len != 0 && len > b.length - len_noUserData){
			throw new Exception("RTU数据标识长度(" + len + ")大于实际长度(" + (b.length - len_noUserData) + ")。!") ;
		}
		n++;
		if(b[n++] != Constant.HEAD){
			throw new Exception("RTU数据头第四字节不是68H") ;
		}
		return len ;
	}
	
	/**
	 * 创建数据头
	 * @param b
	 * @param len
	 * @return
	 */
	public byte[] createHead(byte[] b , int len) throws Exception{
		int n = 0 ; 
		b[n++] = Constant.HEAD ;
		
		b[n++] = (byte)(len - len_noUserData) ;
		
		b[n++] = Constant.HEAD ;
		
		return b ;
	}

}
