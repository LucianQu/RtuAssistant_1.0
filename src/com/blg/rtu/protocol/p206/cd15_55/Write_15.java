package com.blg.rtu.protocol.p206.cd15_55;

import java.util.HashMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_15  extends ProtocolSupport{
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
		Param_15 param = (Param_15)params.get(Param_15.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		Integer waterAmount = param.getWaterAmount_0to99999999() ;
		if(waterAmount == null){
			throw new Exception("出错，充值水量不能为空。") ;
		}
		if(waterAmount < 0 || waterAmount > 99999999){
			throw new Exception("出错，充值水量只能取0至99999999间的数据。") ;
		}
		
		byte[] bb = ByteUtil.int2BCD_an(waterAmount.intValue()) ;
		if(bb.length == 1){
			b[n++] = bb[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bb.length == 2){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bb.length == 3){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = bb[2] ;
			b[n++] = 0 ;
		}else if(bb.length == 4){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n++] = bb[2] ;
			b[n++] = bb[3] ;
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

}
