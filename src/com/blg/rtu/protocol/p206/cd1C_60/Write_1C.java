package com.blg.rtu.protocol.p206.cd1C_60;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_1C extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
					+ Constant.Bits_Control
					+ Constant.Bits_RTU_ID 
					+ Constant.Bits_Code 
					+ Constant.Bits_Password 
					+ Constant.Bits_Time 
					+ Constant.Bits_CRC
					+ Constant.Bits_Tail 
					+ 1 ;//数据域长度
	
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
		Param_1C param = (Param_1C)params.get(Param_1C.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		Integer v = param.getYinDaoMaChang_0to255() ;
		if(v == null){
			throw new Exception("出错，终端站转发中继引导码长不能为空。") ;
		}
		if(v < 0 || v > 255){
			throw new Exception("出错，终端站转发中继引导码长只能取0～999999间的数据。") ;
		}
		
		b[n++] = (byte)v.intValue() ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

	public static void main(String args[]){
		int i = 255 ;
		byte[] bb = new byte[1] ;
		bb[0] = (byte)i ;
		
		int i1 = bb[0] ;
		int i2 = (i1 + 256) %256 ;
		
		System.out.println(i1);
		System.out.println(i2);
	}

}
