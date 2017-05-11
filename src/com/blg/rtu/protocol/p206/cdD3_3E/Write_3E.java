package com.blg.rtu.protocol.p206.cdD3_3E;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_3E extends ProtocolSupport{
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
		Param_3E param = (Param_3E)params.get(Param_3E.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		String waterSerical = param.getWaterMeterSerial() ;

		byte[] meterSeri_No = ByteUtil.string2BCD(waterSerical) ;
		if(meterSeri_No == null){
			throw new Exception("出厂ID转成BCD编码时出错！" , null) ;
		}else{
			if(meterSeri_No.length == 1) {
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = meterSeri_No[0] ;
			}else if(meterSeri_No.length == 2) {
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = meterSeri_No[0] ;
				b[fromSite++] = meterSeri_No[1] ;
			}else if(meterSeri_No.length == 3) {
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = meterSeri_No[0] ;
				b[fromSite++] = meterSeri_No[1] ;
				b[fromSite++] = meterSeri_No[2] ;
			}else if(meterSeri_No.length == 4) {
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = meterSeri_No[0] ;
				b[fromSite++] = meterSeri_No[1] ;
				b[fromSite++] = meterSeri_No[2] ;
				b[fromSite++] = meterSeri_No[3] ;
			}else if(meterSeri_No.length == 5) {
				b[fromSite++] = 0 ;
				b[fromSite++] = 0 ;
				b[fromSite++] = meterSeri_No[0] ;
				b[fromSite++] = meterSeri_No[1] ;
				b[fromSite++] = meterSeri_No[2] ;
				b[fromSite++] = meterSeri_No[3] ;
				b[fromSite++] = meterSeri_No[4] ;
			}else if(meterSeri_No.length == 6) {
				b[fromSite++] = 0 ;
				b[fromSite++] = meterSeri_No[0] ;
				b[fromSite++] = meterSeri_No[1] ;
				b[fromSite++] = meterSeri_No[2] ;
				b[fromSite++] = meterSeri_No[3] ;
				b[fromSite++] = meterSeri_No[4] ;
				b[fromSite++] = meterSeri_No[5] ;
			}else if(meterSeri_No.length == 7) {
				b[fromSite++] = meterSeri_No[0] ;
				b[fromSite++] = meterSeri_No[1] ;
				b[fromSite++] = meterSeri_No[2] ;
				b[fromSite++] = meterSeri_No[3] ;
				b[fromSite++] = meterSeri_No[4] ;
				b[fromSite++] = meterSeri_No[5] ;
				b[fromSite++] = meterSeri_No[6] ;
			}
			}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
