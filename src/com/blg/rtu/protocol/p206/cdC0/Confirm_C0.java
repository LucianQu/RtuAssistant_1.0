package com.blg.rtu.protocol.p206.cdC0;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.TailProtocol;
import com.blg.rtu.protocol.p206.util.Constant;

public class Confirm_C0  extends ProtocolSupport{
	
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
						//	+ Constant.Bits_Password 
						//	+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 1 ;//数据域长度
	/**
	 * 构造RTU 命令
	 * @param code 功能码
	 * @param controlFunCode 控制域功能码
	 * @param rtuId 终端ID
	 * @param params 参数
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, int setModel, HashMap<String , Object> params, String password) throws Exception {
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		b[index] = (byte)setModel ;
		// 数据尾(包括CRC)
		b = new TailProtocol().createTail(b);
		return b;
	}

}