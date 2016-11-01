package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class CodeProtocol {
	/**
	 * 得到数据中的功能码(十六进制)
	 * @param b
	 * @return
	 */
	public String parseCode(byte[] b , int fromSite) throws Exception {
		if(b == null){
			throw new Exception("出错，RTU数据为空！") ;
		}
		if(b.length < fromSite){
			throw new Exception("出错，RTU数据长度不合法，不能取出功能码！") ;
		}
		return ByteUtil.bytes2Hex(new byte[]{b[fromSite]}, false) ;
	}
	
	/**
	 * 构造功能码
	 * @param b
	 * @param code
	 * @return
	 */
	public byte[] createCode(byte[] b , String code, int fromSite)throws Exception {
		if(b == null){
			throw new Exception("出错，RTU命令数据为空！") ;
		}
		if(b.length < Constant.Site_Code + 2){
			throw new Exception("出错，RTU命令数据长度不合法，不能构造命令！") ;
		}
		byte[] codei = ByteUtil.hex2Bytes(code + "") ;
		b[fromSite] = codei[0] ;
		return b ;
	}
	
}
