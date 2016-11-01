package com.blg.rtu.protocol.p206.cdE2_F2;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtilUnsigned;

public class Write_F2 extends ProtocolSupport{
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
	 * @param params 参数
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, HashMap<String , Object> params, String password) throws Exception {
		Param_F2 param = (Param_F2)params.get(Param_F2.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_1().intValue() ;
		enable += param.getEnable_2().intValue() << 1 ;
		b[fromSite++] = (byte)enable ;
		
		Integer value1 = param.getValue_1_0to65535() ;
		ByteUtilUnsigned.short2Bytes_an(b, value1, fromSite) ;
		fromSite += 2 ;
		
		Integer value2 = param.getValue_2_0to65535() ;
		ByteUtilUnsigned.short2Bytes_an(b, value2, fromSite) ;
		fromSite += 2 ;
		
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
