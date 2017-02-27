package com.blg.rtu.protocol.p206.cd43_73;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_43 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 9 ;//数据域长度
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
		Param_43 param = (Param_43)params.get(Param_43.KEY) ;
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
		enable += param.getEnable_5().intValue() << 4 ;
		enable += param.getEnable_6().intValue() << 5 ;
		enable += param.getEnable_7().intValue() << 6 ;
		enable += param.getEnable_8().intValue() << 7 ;
		b[fromSite++] = (byte)enable ;
		
		b[fromSite++] = (byte)param.getModBusAddr1().intValue();
		b[fromSite++] = (byte)param.getModBusAddr2().intValue();
		b[fromSite++] = (byte)param.getModBusAddr3().intValue();
		b[fromSite++] = (byte)param.getModBusAddr4().intValue();
		b[fromSite++] = (byte)param.getModBusAddr5().intValue();
		b[fromSite++] = (byte)param.getModBusAddr6().intValue();
		b[fromSite++] = (byte)param.getModBusAddr7().intValue();
		b[fromSite++] = (byte)param.getModBusAddr8().intValue();
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
