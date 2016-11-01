package com.blg.rtu.protocol.p206.cd17_57;

import java.util.HashMap;
import java.util.TreeMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_17  extends ProtocolSupport{
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
		ParamMap_17 paramMapObj = (ParamMap_17)params.get(ParamMap_17.KEY) ;
		if(paramMapObj == null ){
			throw new Exception("出错，未提供参数Bean集合对象！") ;
		}
		
		TreeMap<Integer , Param_17> paramMap = paramMapObj.getParamMap() ;
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
	
	private int setValue(int count , byte[] b, int n , Param_17 param)throws Exception{
		boolean plus = true ;
		Double wlb = param.getWaterLevelBase_n7999d99to7999d99() ;
		
		if(wlb == null){
			throw new Exception("出错，第" + count + "个水位基值为空，其必须提供！") ;
		}
		Double d1 = -7999.99D, d2 = 7999.99D ;
		if(wlb < d1 || wlb > d2){
			throw new Exception("出错，第" + count + "个水位基值取值超过其取值范围-7999.99至7999.99！") ;
		}
		
		if(wlb < 0.0){
			plus = false ;
			wlb = - wlb ;
		}
		
//		Integer intLvb = wlb.intValue() ;
//		Long dotLvb = Math.round((Double.valueOf(wlb - intLvb)) * 100) ;
//		byte[] bbb = ByteUtil.long2BCD(dotLvb) ;
//		b[n++] = bbb[0] ;
//		byte[] bb = ByteUtil.int2BCD(intLvb) ;
//		if(bb.length == 1){
//			b[n++] = bb[0]  ;
//			b[n] = 0 ;
// 		}else if(bb.length == 2){
//			b[n++] = bb[1] ;
//			b[n] = bb[0] ;
// 		}
//		if(!plus){
//			b[n] = (byte)(b[n] | (byte)128) ;
//		}
//		n ++ ;
		
		Long intLvb = Double.valueOf(wlb * 100.0).longValue() ;

		byte[] bb = ByteUtil.long2BCD_an(intLvb) ;
		if(bb.length == 1){
			b[n++] = bb[0] ;
			b[n++] = 0 ;
			b[n] = 0 ;
 		}else if(bb.length == 2){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n] = 0 ;
 		}else if(bb.length == 3){
			b[n++] = bb[0] ;
			b[n++] = bb[1] ;
			b[n] = bb[2] ;
 		}
		if(!plus){
			b[n] = (byte)(b[n] | (byte)128) ;
		}
		n ++ ;
		
		
		Double wlbd = param.getWaterLevelDownLimit_0to99d99() ;
		
		if(wlbd == null){
			throw new Exception("出错，第" + count + "个水位下限为空，其必须提供！") ;
		}
		if(wlbd < 0 || wlbd > 99.99){
			throw new Exception("出错，第" + count + "个水位下限值超过其取值范围0至99.99！") ;
		}
//		Integer intLvbd = wlbd.intValue() ;
//		Long dotLvbd = Math.round((Double.valueOf(wlbd - intLvbd)) * 100) ;
//		byte[] bbbd = ByteUtil.long2BCD(dotLvbd) ;
//		b[n++] = bbbd[0] ;
//
//		byte[] bbd = ByteUtil.int2BCD(intLvbd) ;
//		b[n++] = bbd[0] ;
		
		Long intLvbd = Double.valueOf(wlbd * 100.0).longValue() ;
		byte[] bbd = ByteUtil.long2BCD_an(intLvbd) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		Double wlbu = param.getWaterLevelUpLimit_0to99d99() ;
		
		if(wlbu == null){
			throw new Exception("出错，第" + count + "个水位上限为空，其必须提供！") ;
		}
		if(wlbu < 0 || wlbu > 99.99){
			throw new Exception("出错，第" + count + "个水位上限值超过其取值范围0至99.99！") ;
		}
//		Integer intLvbu = wlbu.intValue() ;
//		Long dotLvbu = Math.round((Double.valueOf(wlbu - intLvbu)) * 100) ;
//		byte[] bbbu = ByteUtil.long2BCD(dotLvbu) ;
//		b[n++] = bbbu[0] ;
//
//		byte[] bbu = ByteUtil.int2BCD(intLvbu) ;
//		b[n++] = bbu[0] ;
		Long intLvbu = Double.valueOf(wlbu * 100.0).longValue() ;
		byte[] bbu = ByteUtil.long2BCD_an(intLvbu) ;
		if(bbu.length == 1){
			b[n++] = bbu[0] ;
			b[n++] = 0 ;
 		}else if(bbu.length == 2){
			b[n++] = bbu[0] ;
			b[n++] = bbu[1] ;
 		}
		
		return n ;
	}


}
