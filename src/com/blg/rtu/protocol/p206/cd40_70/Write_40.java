package com.blg.rtu.protocol.p206.cd40_70;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_40 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 5;//数据域长度
	
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
		Param_40 param = (Param_40)params.get(Param_40.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}

		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
	/*	String pw = param.getPassword();
		
		byte[] bbd = ByteUtil.string2BCD_an(pw);
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		b[n++] =(byte) param.getLoraChannel();*/
		
		Double v = param.getWaterPure();
		
		if(v == null){
			throw new Exception("出错，设置正积为空，其必须提供！") ;
		}
		if(v < -999999.999 || v > 999999.999){
			throw new Exception("出错，设置净积超过其取值范围-999999.999～+999999.999！") ;
		}
		
		boolean plus = true ;
		if(v < 0){
			plus = false ;
			v = -v ;
		}
		
		Long v1 = Double.valueOf(v * 1000.0).longValue() ;
		byte[] bbd = ByteUtil.long2BCD_an(v1) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0xF0 ;
			}
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0xF0 ;
			}
 		}else if(bbd.length == 3){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = 0 ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0xF0 ;
			}
 		}else if(bbd.length == 4){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0xF0 ;
			}
 		}else if(bbd.length == 5){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
			if(plus){
				b[n++] = bbd[4] ;
			}else{
				b[n++] = (byte)(0xF0 | bbd[4]);
			}
 		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}
}
