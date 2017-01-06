package com.blg.rtu.protocol.p206.cdC4;

import java.util.HashMap;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_C4  extends ProtocolSupport{
	public static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 10 ;//数据域长度

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
		Param_C4 p = (Param_C4)params.get(Param_C4.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		Double waterInstant = p.getWaterInstant_n999999d999to999999d999();
		Long waterConsumption = p.getWaterConsumption_0to7999999999();
		if(waterInstant == null || waterConsumption == null){
			throw new Exception("出错，瞬时流量/累计水量不能为空。") ;
		}
		if(waterInstant < -999999.999 || waterInstant > 999999.999){
			throw new Exception("出错，瞬时流量值超出取值范围-999999.999～999999.999") ;
		}
		if(waterConsumption < 0 ||  waterConsumption> 7999999999L){
			throw new Exception("出错，累计水量超出取值范围0~7999999999") ;
		}
		boolean plus = true ;
		if(waterInstant < 0){
			plus = false ;
			waterInstant = -waterInstant ;
		}
		
		Long vl = Double.valueOf(waterInstant * 1000.0).longValue() ;
		
		byte[] bbd = ByteUtil.long2BCD_an(vl) ;
		byte[] bdd1 = ByteUtil.long2BCD_an(waterConsumption);
		
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
		
		if(bdd1.length == 1){
			b[n++] = bdd1[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0x80 ;
			}
 		}else if(bdd1.length == 2){
			b[n++] = bdd1[0] ;
			b[n++] = bdd1[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0x80 ;
			}
 		}else if(bdd1.length == 3){
			b[n++] = bdd1[0] ;
			b[n++] = bdd1[1] ;
			b[n++] = bdd1[2] ;
			b[n++] = 0 ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0x80 ;
			}
 		}else if(bdd1.length == 4){
			b[n++] = bdd1[0] ;
			b[n++] = bdd1[1] ;
			b[n++] = bdd1[2] ;
			b[n++] = bdd1[3] ;
			if(plus){
				b[n++] = 0 ;
			}else{
				b[n++] = (byte)0x80 ;
			}
 		}else if(bdd1.length == 5){
			b[n++] = bdd1[0] ;
			b[n++] = bdd1[1] ;
			b[n++] = bdd1[2] ;
			b[n++] = bdd1[3] ;
			if(plus){
				b[n++] = bdd1[4] ;
			}else{
				b[n++] = (byte)(0x80 | bdd1[4]);
			}
 		}
		this.createDownDataTail(b, password) ;
		return b;
	}
}
