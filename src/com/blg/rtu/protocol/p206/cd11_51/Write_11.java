package com.blg.rtu.protocol.p206.cd11_51;

import java.util.HashMap;

import com.blg.rtu.util.DateTime;
import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_11 extends ProtocolSupport{

	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 6 ;//数据域长度
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
		//构造数据
		byte[] b = new byte[len];

		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		Param_11 param = null ;
		if(params != null){
			param = (Param_11)params.get(Param_11.KEY) ;
			if(param != null){
				//数据域，时钟
				byte secode = param.getSecond().byteValue() ;
				b[n++] = ByteUtil.int2BCD_an(secode)[0] ;
				
				byte minute = param.getMinute().byteValue() ;
				b[n++] = ByteUtil.int2BCD_an(minute)[0] ;
				
				byte hour = param.getHour().byteValue() ;
				b[n++] = ByteUtil.int2BCD_an(hour)[0] ;

				byte date = param.getDay().byteValue() ;
				b[n++] = ByteUtil.int2BCD_an(date)[0] ;

				b[n++] = (byte)((0 << 5) + ByteUtil.int2BCD_an(param.getMonth())[0]) ;
				
				
				byte year = (byte)(param.getYear() - 2000) ;
				b[n++] = ByteUtil.int2BCD_an(year)[0] ;

			}
		}
		if(params == null || param == null){
			byte secode = ByteUtil.string2byte(DateTime.ss()) ;
			b[n++] = ByteUtil.int2BCD_an(secode)[0] ;
			
			byte minute = ByteUtil.string2byte(DateTime.mm()) ;
			b[n++] = ByteUtil.int2BCD_an(minute)[0] ;
			
			byte hour = ByteUtil.string2byte(DateTime.HH()) ;
			b[n++] = ByteUtil.int2BCD_an(hour)[0] ;

			byte date = ByteUtil.string2byte(DateTime.dd()) ;
			b[n++] = ByteUtil.int2BCD_an(date)[0] ;

			b[n++] = (byte)((DateTime.week_Int() << 5) + ByteUtil.int2BCD_an(ByteUtil.string2byte(DateTime.MM()))[0]) ;
			
			
			byte year = ByteUtil.string2byte(DateTime.yy()) ;
			b[n++] = ByteUtil.int2BCD_an(year)[0] ;
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

}
