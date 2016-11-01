package com.blg.rtu.protocol.p206.cdEC_FC;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_FC extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 6;//数据域长度
	
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
		Param_FC param = (Param_FC)params.get(Param_FC.KEY) ;
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
				) ;
		n++ ;
		
		b[n++] = (byte)((byte)param.getB01_0or1() 
				| (byte)(param.getB02_0or1() << 1) 
				| (byte)(param.getB03_0or1() << 2) 
				| (byte)(param.getB04_0or1() << 3)
				| (byte)(param.getB05_0or1() << 4)
				| (byte)(param.getB06_0or1() << 5)
				| (byte)(param.getB07_0or1() << 6)
				| (byte)(param.getB08_0or1() << 7)
				) ;
		b[n++] = (byte)((byte)param.getB09_0or1() 
				| (byte)(param.getB10_0or1() << 1) 
				) ;
		
		b[n++] = (byte)((byte)param.getC01_0or1() 
				| (byte)(param.getC02_0or1() << 1) 
				| (byte)(param.getC03_0or1() << 2) 
				| (byte)(param.getC04_0or1() << 3)
				| (byte)(param.getC05_0or1() << 4)
				| (byte)(param.getC06_0or1() << 5)
				) ;
		n++ ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

}
