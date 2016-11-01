package com.blg.rtu.protocol.p206.cdCE_DE;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_DE extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 49 ;//数据域长度
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
		Param_DE param = (Param_DE)params.get(Param_DE.KEY) ;
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
		
		String sate1 = param.getSate1() ;
		String sate2 = param.getSate2() ;
		String sate3 = param.getSate3() ;
		String sate4 = param.getSate4() ;
		
		byte[] bsate1 = sate1.getBytes() ;
		byte[] bsate2 = sate2.getBytes() ;
		byte[] bsate3 = sate3.getBytes() ;
		byte[] bsate4 = sate4.getBytes() ;
		
		for(int i = 0 ; (i < bsate1.length && i < 6) ; i++){
			b[fromSite + i] = bsate1[i] ;
		}
		fromSite += 6 ;
		for(int i = 0 ; (i < bsate2.length && i < 6) ; i++){
			b[fromSite + i] = bsate2[i] ;
		}
		fromSite += 6 ;
		for(int i = 0 ; (i < bsate3.length && i < 6) ; i++){
			b[fromSite + i] = bsate3[i] ;
		}
		fromSite += 6 ;
		for(int i = 0 ; (i < bsate4.length && i < 6) ; i++){
			b[fromSite + i] = bsate4[i] ;
		}
		fromSite += 6 ;
	
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
