package com.blg.rtu.protocol.p206.cd4C_7C;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_4C extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
					+ Constant.Bits_Control
					+ Constant.Bits_RTU_ID 
					+ Constant.Bits_Code 
					+ Constant.Bits_Password 
					+ Constant.Bits_Time 
					+ Constant.Bits_CRC
					+ Constant.Bits_Tail 
					+ 4 ;//数据域长度
	
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
		Param_4C param = (Param_4C)params.get(Param_4C.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		b[index++] = param.getLoraCollectTime().byteValue() ;
		Integer 
		v = param.getLoraCollectCycle() ;
		if(v == null){
			throw new Exception("出错，Lora采集周期为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，Lora采集周期超过其取值范围0至9999！") ;
		}
		byte[] bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[index++] = bbd[0] ;
			b[index++] = 0 ;
 		}else if(bbd.length == 2){
			b[index++] = bbd[0] ;
			b[index++] = bbd[1] ;
 		}
		b[index] = param.getLoraTimeWinSet().byteValue() ;
				
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
