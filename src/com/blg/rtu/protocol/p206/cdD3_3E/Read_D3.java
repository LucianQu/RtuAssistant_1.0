package com.blg.rtu.protocol.p206.cdD3_3E;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.TailProtocol;
import com.blg.rtu.protocol.p206.util.Constant;

public class Read_D3 extends ProtocolSupport {
	private static final int len = Constant.Bits_Head
								 + Constant.Bits_Control
								 + Constant.Bits_RTU_ID
								 + Constant.Bits_Code
								 + Constant.Bits_CRC
								 + Constant.Bits_Tail
								 + 0 ;
	/**
	 * 构造RTU Command
	 * @author QLS
	 * @param code 功能码
	 * @param controlFunCode 控制域功能码
	 * @param rtuId Device ID
	 * @param params 参数
	 * @param password password
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, HashMap<String , Object> params, String password) throws Exception {
		//构造数据
		 byte[] b = new byte[len] ;
		 this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		 
		//数据尾（包括CRC）
		 b = new TailProtocol().createTail(b);
		 
		 return b;
	}
}
