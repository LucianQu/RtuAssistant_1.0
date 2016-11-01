package com.blg.rtu.protocol.p206.cd18_58;

import java.util.HashMap;
import java.util.TreeMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_18  extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
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
		ParamMap_18 paramMapObj = (ParamMap_18)params.get(ParamMap_18.KEY) ;
		if(paramMapObj == null ){
			throw new Exception("出错，未提供参数Bean集合对象！") ;
		}
		
		TreeMap<Integer , Param_18> paramMap = paramMapObj.getParamMap() ;
		if(paramMap == null ){
			throw new Exception("出错，未提供参数Bean集合！") ;
		}
		if(paramMap.size() == 0){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		int length = len + 7 * paramMap.size() ;
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
	
	private int setValue(int count , byte[] b, int n , Param_18 param)throws Exception{
		Double wpd = param.getWaterPressDownLimit_0to999999d99() ;
		
		if(wpd == null){
			throw new Exception("出错，第" + count + "个水压下限为空，其必须提供！") ;
		}
		if(wpd < 0 || wpd > 999999.99){
			throw new Exception("出错，第" + count + "个水压下限值超过其取值范围0至999999.99！") ;
		}
		Integer intWbd = wpd.intValue() ;
		Long dotWbd = Math.round((Double.valueOf(wpd - intWbd)) * 100) ;
		byte[] bbbd = ByteUtil.long2BCD_an(dotWbd) ;
		b[n++] = bbbd[0] ;

		byte[] bbd = ByteUtil.int2BCD_an(intWbd) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbd.length == 3){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 4){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
 		}
		
		
		Double wpu = param.getWaterPressUpLimit_0to999999d99() ;
		
		if(wpu == null){
			throw new Exception("出错，第" + count + "个水压上限为空，其必须提供！") ;
		}
		if(wpu < 0 || wpu > 999999.99){
			throw new Exception("出错，第" + count + "个水压上限值超过其取值范围0至999999.99！") ;
		}
		Integer intWbu = wpu.intValue() ;
		Long dotWbu = Math.round((Double.valueOf(wpu - intWbu)) * 100) ;
		byte[] bbbu = ByteUtil.long2BCD_an(dotWbu) ;
		b[n++] = bbbu[0] ;

		byte[] bbu = ByteUtil.int2BCD_an(intWbu) ;
		if(bbu.length == 1){
			b[n++] = bbu[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbu.length == 2){
			b[n++] = bbu[0] ;
			b[n++] = bbu[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
 		}else if(bbu.length == 3){
			b[n++] = bbu[0] ;
			b[n++] = bbu[1] ;
			b[n++] = bbu[2] ;
			b[n++] = 0 ;
 		}else if(bbu.length == 4){
			b[n++] = bbu[0] ;
			b[n++] = bbu[1] ;
			b[n++] = bbu[2] ;
			b[n++] = bbu[3] ;
 		}
		
		return n ;
	}


}
