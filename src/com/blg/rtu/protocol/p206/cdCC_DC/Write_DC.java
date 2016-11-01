package com.blg.rtu.protocol.p206.cdCC_DC;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtilUnsigned;

public class Write_DC extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 57 ;//数据域长度
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
		Param_DC param = (Param_DC)params.get(Param_DC.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_1().intValue() ;
		enable += param.getEnable_2().intValue() << 1 ;
		enable += param.getEnable_3().intValue() << 2 ;
		enable += param.getEnable_4().intValue() << 3 ;
		b[fromSite++] = (byte)enable ;
		
		b[fromSite++] = param.getIp_1_1_0to254().byteValue() ;
		b[fromSite++] = param.getIp_1_2_0to254().byteValue() ;
		b[fromSite++] = param.getIp_1_3_0to254().byteValue() ;
		b[fromSite++] = param.getIp_1_4_0to254().byteValue() ;
		ByteUtilUnsigned.short2Bytes(b, param.getPort_1_0to65535().intValue(), fromSite)  ;
		fromSite += 2 ;
		b[fromSite++] = param.getType_1().byteValue() ;
		
		b[fromSite++] = param.getIp_2_1_0to254().byteValue() ;
		b[fromSite++] = param.getIp_2_2_0to254().byteValue() ;
		b[fromSite++] = param.getIp_2_3_0to254().byteValue() ;
		b[fromSite++] = param.getIp_2_4_0to254().byteValue() ;
		ByteUtilUnsigned.short2Bytes(b, param.getPort_2_0to65535().intValue(), fromSite)  ;
		fromSite += 2 ;
		b[fromSite++] = param.getType_2().byteValue() ;
		
		b[fromSite++] = param.getIp_3_1_0to254().byteValue() ;
		b[fromSite++] = param.getIp_3_2_0to254().byteValue() ;
		b[fromSite++] = param.getIp_3_3_0to254().byteValue() ;
		b[fromSite++] = param.getIp_3_4_0to254().byteValue() ;
		ByteUtilUnsigned.short2Bytes(b, param.getPort_3_0to65535().intValue(), fromSite)  ;
		fromSite += 2 ;
		b[fromSite++] = param.getType_3().byteValue() ;
		
		b[fromSite++] = param.getIp_4_1_0to254().byteValue() ;
		b[fromSite++] = param.getIp_4_2_0to254().byteValue() ;
		b[fromSite++] = param.getIp_4_3_0to254().byteValue() ;
		b[fromSite++] = param.getIp_4_4_0to254().byteValue() ;
		ByteUtilUnsigned.short2Bytes(b, param.getPort_4_0to65535().intValue(), fromSite)  ;
		fromSite += 2 ;
		b[fromSite++] = param.getType_4().byteValue() ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
