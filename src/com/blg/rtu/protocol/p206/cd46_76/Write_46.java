package com.blg.rtu.protocol.p206.cd46_76;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_46 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 8;//数据域长度
	
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
		Param_46 param = (Param_46)params.get(Param_46.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}

		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		String pw = param.getPassword();
		
		byte[] bbd = ByteUtil.string2BCD_an(pw);
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		b[n++] =(byte) param.getLoraChannel();
		
		Long v = param.getWaterPlus();
		
		if(v == null){
			throw new Exception("出错，正积流量为空，其必须提供！") ;
		}
		if(v < 0 || v > 999999999L){
			throw new Exception("出错，输入正积值超过其取值范围0至999999999！") ;
		}
		bbd = ByteUtil.long2BCD_an(v) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbd.length == 3){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbd.length == 4){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 5){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
			b[n++] = (byte)(bbd[4] & 0xF) ;
 		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}
}
