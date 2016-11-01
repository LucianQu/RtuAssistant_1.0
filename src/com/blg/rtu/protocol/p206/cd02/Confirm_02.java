package com.blg.rtu.protocol.p206.cd02;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Confirm_02 extends ProtocolSupport{

	private static final int len = Constant.Bits_Head 
										+ Constant.Bits_Control
										+ Constant.Bits_RTU_ID 
										+ Constant.Bits_Code 
										+ Constant.Bits_Password 
										+ Constant.Bits_Time 
										+ Constant.Bits_CRC
										+ Constant.Bits_Tail 
										+ 5 ;//数据域长度

	/**
	 * 构造RTU 命令
	 * @param code 功能码
	 * @param controlFunCode 控制域功能码
	 * @param rtuId 终端ID
	 * @param status 状态(登录、退出、保持)
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, byte status, String password) throws Exception {
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

		b[fromSite] = status ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}
}
