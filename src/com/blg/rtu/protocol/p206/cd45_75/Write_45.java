package com.blg.rtu.protocol.p206.cd45_75;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_45 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 4;//数据域长度
	
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
		Param_45 param = (Param_45)params.get(Param_45.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}

		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

		b[n++] = (byte)((byte)param.getA01_0or1() 
				| (byte)(param.getA02_0or1() << 1) 
				| (byte)(param.getA03_0or1() << 2) 
				| (byte)(param.getA04_0or1() << 3)
				| (byte)(param.getA05_0or1() << 4)
				| (byte)(param.getA06_0or1() << 5)
				| (byte)(param.getA07_0or1() << 6)
				) ;
		n++ ;
		
		Integer v = param.getShowInterval0to9999() ;
		
		if(v == null){
			throw new Exception("出错，表底值为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，表底值超过其取值范围0至9999！") ;
		}
		byte[] bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		this.createDownDataTail(b, password) ;
		
		return b;
	}
}
