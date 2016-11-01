package com.blg.rtu.protocol.p206.cdE3_F3;

import java.util.HashMap;

import android.util.Log;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_F3 extends ProtocolSupport{
	
	private static String tag = Write_F3.class.getName() ;
	
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 7 ;//数据域长度
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
		Param_F3 param = (Param_F3)params.get(Param_F3.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}else{
			Log.i(tag, param.toString()) ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_level_0To1().intValue() ;
		enable += param.getEnable_qaulity_0To1().intValue() << 1 ;
		enable += param.getEnable_temperature_0To1().intValue() << 2 ;
		enable += param.getEnable_amount1_0To1().intValue() << 3 ;
		enable += param.getEnable_amount2_0To1().intValue() << 4 ;
		enable += param.getEnable_amount3_0To1().intValue() << 5 ;
		b[fromSite++] = (byte)enable ;
		
		b[fromSite++] = param.getMeter_level_0To255().byteValue() ;
		b[fromSite++] = param.getMeter_qaulity_0To255().byteValue() ;
		b[fromSite++] = param.getMeter_temperature_0To255().byteValue() ;
		b[fromSite++] = param.getMeter_amount1_0To255().byteValue() ;
		b[fromSite++] = param.getMeter_amount2_0To255().byteValue() ;
		b[fromSite++] = param.getMeter_amount3_0To255().byteValue() ;
		
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
