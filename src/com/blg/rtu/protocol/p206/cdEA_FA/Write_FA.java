package com.blg.rtu.protocol.p206.cdEA_FA;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_FA extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 8 ;//数据域长度
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
		Param_FA param = (Param_FA)params.get(Param_FA.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_1().intValue() ;
		enable += param.getEnable_2().intValue() << 1 ;
		enable += param.getEnable_3().intValue() << 2 ;
		b[n++] = (byte)enable ;
		
		Float f = param.getValue_1_n7999d99To7999d99() ;
		
		int flag = f < 0? 1 : 0 ;//0为正数，1为负数 
		
		f = f < 0? (-f): f ;
		
		f = (f * 1000.0F) ;
		int v = f.intValue()/10 ;//*1000再/10是为精度
		
		byte[] bb = ByteUtil.int2BCD_an(v) ;
		if(bb.length == 1){
			b[n++] = bb[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bb.length == 2){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = 0 ;
		}else if(bb.length == 3){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = bb[2] ;
		}
		if(flag == 1){
			b[n-1] = (byte)(b[n-1] + 128) ;
		}
		
		f = param.getValue_2_0To99d99() ;
		
		f = (f * 1000.0F) ;
		v = f.intValue()/10 ;//*1000再/10是为精度
		bb = ByteUtil.int2BCD_an(v) ;
		if(bb.length == 1){
			b[n++] = bb[0] ;
			b[n++] = 0 ;
		}else if(bb.length == 2){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
		}

		
		
		
		f = param.getValue_3_0To99d99() ;
		
		f = (f * 1000.0F) ;
		v = f.intValue()/10 ;//*1000再/10是为精度
		bb = ByteUtil.int2BCD_an(v) ;
		if(bb.length == 1){
			b[n++] = bb[0] ;
			b[n++] = 0 ;
		}else if(bb.length == 2){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
