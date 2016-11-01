package com.blg.rtu.protocol.p206.cd1F_64;

import java.util.HashMap;
import java.util.TreeMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_1F  extends ProtocolSupport{
	public static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 0 ;//数据域长度

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
		ParamMap_1F paramMapObj = (ParamMap_1F)params.get(ParamMap_1F.KEY) ;
		if(paramMapObj == null ){
			throw new Exception("出错，未提供参数Bean集合对象！") ;
		}
		
		TreeMap<Integer , Param_1F> paramMap = paramMapObj.getParamMap() ;
		if(paramMap == null ){
			throw new Exception("出错，未提供参数Bean集合！") ;
		}
		if(paramMap.size() == 0){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		int length = len + 5 * paramMap.size() ;
		
		byte[] b = new byte[length];
		
		int index = this.createDownDataHead(rtuId, code, b, length, controlFunCode) ;
		
		int firstKey = paramMap.firstKey() ;
		int count = 1 ;
		for(int i = firstKey ; i < (firstKey + paramMap.size()) ; i++){
			index = this.setValue(count, b, index, paramMap.get(i)) ;
			count ++ ;
		}

		this.createDownDataTail(b, password) ;
		
		return b;
	}
	
	private int setValue(int count , byte[] b, int n , Param_1F param)throws Exception{
		Double v = param.getWaterAmountParamUpLimit_n999999d999to999999d999() ;
		
		if(v == null){
			throw new Exception("出错，第" + count + "个流量参数上限值为空，其必须提供！") ;
		}
		if(v < -999999.999 || v > 999999.999){
			throw new Exception("出错，第" + count + "个流量参数上限值超过其取值范围-999999.999～+999999.999！") ;
		}
		
		boolean plus = true ;
		if(v < 0){
			plus = false ;
			v = -v ;
		}
		
		Long vl = Double.valueOf(v * 1000.0).longValue() ;
		
		byte[] bbd = ByteUtil.long2BCD_an(vl) ;
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
		
		return n ;
	}


}
