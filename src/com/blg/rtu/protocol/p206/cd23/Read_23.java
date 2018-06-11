package com.blg.rtu.protocol.p206.cd23;

import java.util.HashMap;

import android.util.Log;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.TailProtocol;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Read_23  extends ProtocolSupport{
	
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
						//	+ Constant.Bits_Password 
						//	+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 2 ;//数据域长度

	
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
		/////////////////////////////
		Param_23 param = (Param_23)params.get(Param_23.KEY) ;
		//构造数据
		byte[] b = new byte[len];

		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		int year = param.getQueryYear() ;
		int month = param.getQueryMonth() ;
		
		b[n++] =  ByteUtil.int2BCD(year)[0] ;
		Log.i("查询月用水：", "查询年-" + b[n - 1]);
	
		b[n++] =  ByteUtil.int2BCD(month)[0] ;
		Log.i("查询月用水：", "查询月-" + b[n - 1]);
		
		// 数据尾(包括CRC)
		b = new TailProtocol().createTail(b);
		
		return b;
	}

}

