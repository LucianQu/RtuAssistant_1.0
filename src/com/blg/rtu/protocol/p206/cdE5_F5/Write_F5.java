package com.blg.rtu.protocol.p206.cdE5_F5;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_F5 extends ProtocolSupport{
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
		Param_F5 param = (Param_F5)params.get(Param_F5.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_level_0To1().intValue() ;
		b[fromSite++] = (byte)enable ;
		
		Double db = param.getMeter_level_n30d999to30d999() ;
		db = db * 10000 ;
		
		Integer v = db.intValue() ;
		v = v / 10 ;
		
		short s = v.shortValue() ;
		
		ByteUtil.short2Bytes_an(b, s, fromSite) ;
		fromSite += 2 ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
