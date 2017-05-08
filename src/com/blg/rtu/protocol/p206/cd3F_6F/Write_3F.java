package com.blg.rtu.protocol.p206.cd3F_6F;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_3F extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
					+ Constant.Bits_Control
					+ Constant.Bits_RTU_ID 
					+ Constant.Bits_Code 
					+ Constant.Bits_Password 
					+ Constant.Bits_Time 
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
		Param_3F param = (Param_3F)params.get(Param_3F.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		Integer 
		v = param.getPulseConstant() ;
		if(v == null){
			throw new Exception("出错，脉冲常数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，脉冲常数超过其取值范围0至9999！") ;
		}
		byte[] bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[index++] = bbd[0] ;
			b[index++] = 0 ;
 		}else if(bbd.length == 2){
			b[index++] = bbd[0] ;
			b[index++] = bbd[1] ;
 		}
				
		this.createDownDataTail(b, password) ;
		return b;
	}


}
