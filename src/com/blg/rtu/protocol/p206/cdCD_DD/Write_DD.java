package com.blg.rtu.protocol.p206.cdCD_DD;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_DD extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 129 ;//数据域长度
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
		Param_DD param = (Param_DD)params.get(Param_DD.KEY) ;
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
		
		String phone1 = param.getPhone1() ;
		String phone2 = param.getPhone2() ;
		String phone3 = param.getPhone3() ;
		String phone4 = param.getPhone4() ;
		
		byte[] bphone1 = phone1.getBytes() ;
		byte[] bphone2 = phone2.getBytes() ;
		byte[] bphone3 = phone3.getBytes() ;
		byte[] bphone4 = phone4.getBytes() ;
		
		for(int i = 0 ; (i < bphone1.length && i < 32) ; i++){
			b[fromSite + i] = bphone1[i] ;
		}
		fromSite += 32 ;
		for(int i = 0 ; (i < bphone2.length && i < 32) ; i++){
			b[fromSite + i] = bphone2[i] ;
		}
		fromSite += 32 ;
		for(int i = 0 ; (i < bphone3.length && i < 32) ; i++){
			b[fromSite + i] = bphone3[i] ;
		}
		fromSite += 32 ;
		for(int i = 0 ; (i < bphone4.length && i < 32) ; i++){
			b[fromSite + i] = bphone4[i] ;
		}
		fromSite += 32 ;
	
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
