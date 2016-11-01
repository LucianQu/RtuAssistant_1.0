package com.blg.rtu.protocol.p206.cdCA_DA;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_DA extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 96 ;//数据域长度
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
		Param_DA param = (Param_DA)params.get(Param_DA.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

		String name = param.getName_1to32() ;
		String user = param.getUser_1to32() ;
		String pass = param.getPassword_1to32() ;
		
		byte[] bname = name.getBytes() ;
		byte[] buser = user.getBytes() ;
		byte[] bpass = pass.getBytes() ;
		
		for(int i = 0 ; (i < bname.length && i < 32) ; i++){
			b[fromSite + i] = bname[i] ;
		}
		fromSite += 32 ;
		for(int i = 0 ; (i < buser.length && i < 32) ; i++){
			b[fromSite + i] = buser[i] ;
		}
		fromSite += 32 ;
		for(int i = 0 ; (i < bpass.length && i < 32) ; i++){
			b[fromSite + i] = bpass[i] ;
		}
		fromSite += 32 ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
