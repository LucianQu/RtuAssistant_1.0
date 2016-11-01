package com.blg.rtu.protocol.p206.cdD8;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_D8 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 3 ;//数据域长度
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
		Param_D8 param = (Param_D8)params.get(Param_D8.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		
		b[n++] = (byte)((param.getType_1Or2() << 4) + param.getChannel_0to3()) ;
		
		int temp = (Double.valueOf((param.getValue_0to99d99() * 1000)).intValue())/10  ;
		
		byte[] bd = ByteUtil.int2BCD_an(temp);
		if(bd.length == 1){
			b[n++] = bd[0] ;
			b[n++] = 0 ;
 		}else if(bd.length == 2){
			b[n++] = bd[0] ;
			b[n++] = bd[1] ;
 		}
		
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
