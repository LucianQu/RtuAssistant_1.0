package com.blg.rtu.protocol.p206.cdA1_53;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.*;

public class Write_A1 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 30 ;//数据域长度
	
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
		Param_A1 param = (Param_A1)params.get(Param_A1.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}

		int count = 0 ;
		int value = 0 ;
		HashMap<String , byte[]> map = new HashMap<String , byte[]>() ;
		
		Integer d = param.getYuLiang_0or1() ;
		Short dd = param.getYuLiangReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 1440){
			value = value | 0x1 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getShuiWei_0or1() ;
		dd = param.getShuiWeiReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x2 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getLiuLiang_0or1() ;
		dd = param.getLiuLiangReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x4 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getLiuSu_0or1() ;
		dd = param.getLiuSuReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x8;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getZhaWei_0or1() ;
		dd = param.getZhaWeiReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x10 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getGongLu_0or1() ;
		dd = param.getGongLuReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x20 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getQiYa_0or1() ;
		dd = param.getQiYaReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x40 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getFengSu_0or1() ;
		dd = param.getFengSuReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x80 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		byte flag1 = (byte)value ;
		
		value = 0 ;
		d = param.getShuiWen_0or1() ;
		dd = param.getShuiWenReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x1 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getShuiZhi_0or1() ;
		dd = param.getShuiZhiReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x2 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getTuRang_0or1() ;
		dd = param.getTuRangReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x4 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		d = param.getZhengFa_0or1() ;
		dd = param.getZhengFaReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x8 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		
		
		d = param.getBaoJing_0or1() ;
		dd = param.getBaoJingReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x10 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		

		d = param.getShuiYa_0or1() ;
		dd = param.getShuiYaReportInterval_1to9999() ;
		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
			value = value | 0x20 ;
			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
		}else{
			map.put("" + count, null) ;
		}
		count++ ;
		

//		d = param.getDianYa_0or1() ;
//		dd = param.getDianYaReportInterval_1to9999() ;
//		if(d != null && d.intValue() == 1 && dd != null && dd.intValue() >=1 && dd.intValue() <= 9999){
//			value = value | 0x40 ;
//			map.put("" + count, ByteUtil.int2BCD_an(dd)) ;
//		}else{
//			map.put("" + count, null) ;
//		}
//		count++ ;
		
		
		byte flag2 = (byte)value ;
		

		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

		b[n++] = flag1 ;
		b[n++] = flag2 ;
		
		for(int i = 0 ; i < count ; i++){
			byte[] bb = map.get("" + i) ;
			if(bb != null){
				if(bb.length == 1){
					b[n++] = bb[0] ;
					b[n++] = 0 ; 
				}else{
					b[n++] = bb[0] ; 
					b[n++] = bb[1] ; 
				}
			}else{
				b[n++] = 0 ; 
				b[n++] = 0 ;
			}
		}

		this.createDownDataTail(b, password) ;
		
		return b;
	}

}
