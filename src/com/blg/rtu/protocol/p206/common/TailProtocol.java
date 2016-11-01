package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.protocol.p206.util.Constant;

public class TailProtocol {

	/**
	 * 分析数据尾
	 * @param b
	 */
	public void checkTail(byte[] b, int dataLen, boolean isCheckCRC) throws Exception{
		int totalLen = Constant.Bits_Head + dataLen + Constant.Bits_CRC + Constant.Bits_Tail ;
		if(b[totalLen - 1] != Constant.TAIL){
			throw new Exception("RTU数据尾字节不是16H") ;
		}
		if(isCheckCRC){
			new CRCProtocol().checkCrc(b, Constant.Site_Control, totalLen - 3, totalLen - 2) ;
		}
	}
	
	/**
	 * 创建数据尾
	 * @param b
	 * @param len
	 * @return
	 */
	public byte[] createTail(byte[] b) throws Exception{
		b = new CRCProtocol().bytesCrc_forRtu(b, Constant.Site_Control, b.length - (Constant.Bits_CRC + Constant.Bits_Tail + 1));
		b[b.length - 1] = Constant.TAIL ;
		return b ;
	}

}
