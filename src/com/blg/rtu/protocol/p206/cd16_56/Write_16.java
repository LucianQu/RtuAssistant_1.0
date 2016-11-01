package com.blg.rtu.protocol.p206.cd16_56;

import java.util.HashMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_16 extends ProtocolSupport{
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
		Param_16 param = (Param_16)params.get(Param_16.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		Integer v = param.getWaterRemainAlarm_0to999999() ;
		if(v == null){
			throw new Exception("出错，剩余水量报警值不能为空。") ;
		}
		if(v < 0 || v > 999999){
			throw new Exception("出错，剩余水量报警值只能取0～999999间的数据。") ;
		}
		
		byte[] bb = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bb.length == 1){
			b[n++] = bb[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bb.length == 2){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = 0 ;
		}else if(bb.length == 3){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = bb[2] ;
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
