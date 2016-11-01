package com.blg.rtu.protocol.p206.cdE4_F4;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtilUnsigned;

public class Write_F4 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 13 ;//数据域长度
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
		Param_F4 param = (Param_F4)params.get(Param_F4.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_level_0To1().intValue() ;
//		enable += param.getEnable_qaulity_0To1().intValue() << 1 ;
		enable += param.getEnable_temperature_0To1().intValue() << 2 ;
		enable += param.getEnable_amount1_0To1().intValue() << 3 ;
		enable += param.getEnable_amount2_0To1().intValue() << 4 ;
		enable += param.getEnable_amount3_0To1().intValue() << 5 ;
		b[fromSite++] = (byte)enable ;
		
		//以下处理方式是避免float转int时的精度缺失问题
		Float f = param.getMeter_level_0To655d35() ;
		int i = Float.valueOf(f * 1000).intValue();
		i = i/10 ;
		ByteUtilUnsigned.short2Bytes_an(b, i, fromSite) ;
		fromSite += 2 ;
		
//		ByteUtilUnsigned.short2Bytes_an(b, ((param.getMeter_qaulity_0To65535()).intValue()), fromSite) ;
		fromSite += 2 ;
		
		f = param.getMeter_temperature_0To655d35() ;
		i = Float.valueOf(f * 100).intValue();
		i = i/10 ;
		ByteUtilUnsigned.short2Bytes_an(b, i, fromSite) ;
		fromSite += 2 ;

		f = Float.valueOf((param.getMeter_amount1_0To6553d5())) ;
		i = Float.valueOf(f * 100).intValue();
		i = i/10 ;
		ByteUtilUnsigned.short2Bytes_an(b, i, fromSite) ;
		fromSite += 2 ;
		
		f = Float.valueOf((param.getMeter_amount2_0To6553d5())) ;
		i = Float.valueOf(f * 100).intValue();
		i = i/10 ;
		ByteUtilUnsigned.short2Bytes_an(b, i, fromSite) ;
		fromSite += 2 ;
		
		f = Float.valueOf((param.getMeter_amount3_0To6553d5())) ;
		i = Float.valueOf(f * 100).intValue();
		i = i/10 ;
		ByteUtilUnsigned.short2Bytes_an(b, i, fromSite) ;
		fromSite += 2 ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
