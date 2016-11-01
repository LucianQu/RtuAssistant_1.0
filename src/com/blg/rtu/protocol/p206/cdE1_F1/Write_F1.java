package com.blg.rtu.protocol.p206.cdE1_F1;

import java.util.HashMap;

import com.blg.rtu.util.ByteUtilUnsigned;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_F1 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
					+ Constant.Bits_Control
					+ Constant.Bits_RTU_ID 
					+ Constant.Bits_Code 
					+ Constant.Bits_Password 
					+ Constant.Bits_Time 
					+ Constant.Bits_CRC
					+ Constant.Bits_Tail 
					+ 2 ;//数据域长度
	
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
	public byte[] create(String code, byte controlFunCode, String rtuId, HashMap<String , Object> params, String password) throws Exception {
		Param_F1 param = (Param_F1)params.get(Param_F1.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		Integer v1 = param.getVoltage1() ;//整数部分
		Integer v2 = param.getVoltage2() ;//小数部分
		if(v1 == null || v2 == null){
			throw new Exception("出错，电压报警值不能为空。") ;
		}
		
		Integer v = v1 * 100 + v2 ;
		
		ByteUtilUnsigned.short2Bytes_an(b, v, index) ;
				
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
