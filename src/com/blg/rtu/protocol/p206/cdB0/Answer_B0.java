package com.blg.rtu.protocol.p206.cdB0;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.protocol.AlarmStatusProtocol_206;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Answer_B0 extends ProtocolSupport{

	private static String tag = Answer_B0.class.getName() ;
	
	protected static int len = Constant.Bits_Head 
				+ Constant.Bits_Control
				+ Constant.Bits_RTU_ID 
				+ Constant.Bits_Code 
				+ Constant.Bits_CRC
				+ Constant.Bits_Tail ;
	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param dataCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;
		
		Log.i(tag, "分析<查询遥测终端实时值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	protected void doParse(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		DataMap_B0 dataMap = new DataMap_B0() ;
		d.setSubData(dataMap) ;
		if(ca.FUNCODE == Constant.Up_ControlFunCode_1){
			//雨量参数
			index = this.doParseMultiData(b, index, dataMap, 3, "雨量", false, 10.0D, "mm") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_2){
			//水位参数
			index = this.doParseMultiData(b, index, dataMap, 4, "水位", true, 1000.0D, "m") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_3){
			//流量参数
//			index = this.doParseMultiData(b, index, dataMap, 5, "流量", true, 1000.0D, "m3/h") ;
			index = this.doParseMultiData(b, index, dataMap, 5, "累计流量", true, null, "m3") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_4){
			//流速参数
			index = this.doParseMultiData(b, index, dataMap, 3, "流速", true, 1000.0D, "m/s") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_5){
			//闸位参数
			index = this.doParseMultiData(b, index, dataMap, 3, "闸位", false, 100.0D, "m") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_6){
			//功率参数
			index = this.doParseMultiData(b, index, dataMap, 3, "功率", false, null, "kw") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_7){
			//气压参数
			index = this.doParseMultiData(b, index, dataMap, 3, "气压", false, null, "100pa") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_8){
			//风速参数
			index = this.doParseMultiFengSuData(b, index, dataMap, 3, "风速", "m/s") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_9){
			//水温参数
			index = this.doParseMultiData(b, index, dataMap, 2, "水温", false, 10.0D, "℃") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_10){
			//水质参数
			//index = this.doParseMultiData(b, index, dataMap, 2, "水质", true, true, 10.0D, "℃") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_11){
			//土壤含水率参数
			index = this.doParseMultiData(b, index, dataMap, 2, "土壤含水率", false, 10.0D, "") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_12){
			// 蒸发量参数
			index = this.doParseMultiData(b, index, dataMap, 3, " 蒸发量", false, 10.0D, "mm") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_13){
			// 报警或状态参数 
			//index = this.doParseMultiData(b, index, dataMap, 3, " 报警或状态", false, 10.0D, "") ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_14){
			// 综合参数(2012-12-15,王书超说，此处改为综合参数数据)
			index = this.parseZongHe(b, index, dataMap, ca) ;
		}
//		else if(ca.FUNCODE == Constant.Up_ControlFunCode_14){
//			// 统计雨量参数
//			//index = this.doParseMultiData(b, index, dataMap, 3, " 统计雨量", false, 10.0D, "") ;
//		}
		else if(ca.FUNCODE == Constant.Up_ControlFunCode_15){
			// 水压参数
			index = this.doParseMultiData(b, index, dataMap, 4, " 水压", false, 100.0D, "") ;
		}else{
			throw new Exception("当前实现不支持此数据类型:" + ca.FUNCODE) ;
		}
		
		this.doParseAlarm(b, dataMap) ;
	}
	
	protected int parseZongHe(byte[] b, int index, DataMap_B0 dataMap, ControlProtocol ca) throws Exception {
		//D7    D6    D5         D4      D3        D2     D1        D0
		//雨量   水位       流量（水量） 闸位     风速（风向） 功率    土壤含水率       水质
		int t = (b[index++] + 256) % 256 ;
		int n = (t & 128) >> 7 ;
		if(n == 1){
			//雨量
			index = this.doParseSingleData(b, index, dataMap, 3, "雨量", false, 10.0D, "mm") ;
		}
		n = (t & 64) >> 6 ;
		if(n == 1){
			//水位
			index = this.doParseSingleData(b, index, dataMap, 4, "水位", true, 1000.0D, "m") ;
		}
		n = (t & 32) >> 5 ;
		if(n == 1){
			//流量（水量）此处是累计取水量，无小数
//			index = this.doParseSingleData(b, index, dataMap, 5, "流量", true, 1000.0D, "m3/h") ;
			index = this.doParseSingleData(b, index, dataMap, 5, "累计流量", true, null, "m3") ;
		}
		n = (t & 16) >> 4 ;
		if(n == 1){
			// 闸位
			index = this.doParseSingleData(b, index, dataMap, 3, "闸位", false, 100.0D, "m") ;
		}
		n = (t & 8) >> 3 ;
		if(n == 1){
			// 风速（风向）
			index = this.doParseSingleFengSuData(b, index, dataMap, 3, "风速", "m/s") ;
		}
		n = (t & 4) >> 2 ;
		if(n == 1){
			// 功率
			index = this.doParseSingleData(b, index, dataMap, 3, "功率", false, null, "kw") ;
		}
		n = (t & 2) >> 1 ;
		if(n == 1){
			// 土壤含水率 
			index = this.doParseSingleData(b, index, dataMap, 2, "土壤含水率", false, 10.0D, "") ;
		}
		n = t & 1 ;
		if(n == 1){
			//  水质
			//index = this.doParseSingleData(b, index, dataMap, 2, "水质", true, true, 10.0D, "℃") ;
		}
		
		return index ;
	}
	
	protected int doParseMultiData(byte[] b, int index, DataMap_B0 dataMap, int lenPer, String dataName, boolean hasFuShu, Double cuShu, String unit) throws Exception {
		int total = (b.length - (len + 4))/lenPer ;//最后4 个字节是终端报警状态和终端状态
		
		long bcd = 0 ;
		boolean plus = true ;
		for(int i = 0 ; i < total ; i++){
			plus = true ;
			DataVO dd = new DataVO() ;
			dataMap.setValue(i + 1, dd) ;
			dd.dataName = dataName + (i + 1) ;
			dd.valueUnit = unit ;
			
			if(hasFuShu){
				int temp = b[index + lenPer - 1] ;
				if(temp < 0){
					plus = false ;
					b[index + lenPer - 1] = (byte)(b[index + lenPer - 1] & 0xF) ;
				}
			}
			
			bcd = ByteUtil.BCD2Long_an(b, index, index + lenPer - 1) ;
			
			if(cuShu != null){
				dd.valueDbl = bcd/cuShu ;
			}else{
				dd.valueLng = bcd ;
			}
			
			if(!plus){
				if(cuShu != null){
					dd.valueDbl = - dd.valueDbl ;
				}else{
					dd.valueLng = - dd.valueLng ;
				}
			}
			
			index += lenPer ;
		}
		
		return index ;
		
	}
	protected int doParseSingleData(byte[] b, int index, DataMap_B0 dataMap, int lenPer, String dataName, boolean hasFuShu, Double cuShu, String unit) throws Exception {
		int total = 1 ;
		
		long bcd = 0 ;
		boolean plus = true ;
		for(int i = 0 ; i < total ; i++){
			plus = true ;
			DataVO dd = new DataVO() ;
			dataMap.setValue(i + 1, dd) ;
			dd.dataName = dataName + (i + 1) ;
			dd.valueUnit = unit ;
			
			if(hasFuShu){
				int temp = b[index + lenPer - 1] ;
				if(temp < 0){
					plus = false ;
					b[index + lenPer - 1] = (byte)(b[index + lenPer - 1] & 0xF) ;
				}
			}
			
			bcd = ByteUtil.BCD2Long_an(b, index, index + lenPer - 1) ;
			
			if(cuShu != null){
				dd.valueDbl = bcd/cuShu ;
			}else{
				dd.valueLng = bcd ;
			}
			
			if(!plus){
				if(cuShu != null){
					dd.valueDbl = - dd.valueDbl ;
				}else{
					dd.valueLng = - dd.valueLng ;
				}
			}
			
			index += lenPer ;
		}
		
		return index ;
		
	}

	protected int doParseMultiFengSuData(byte[] b, int index, DataMap_B0 dataMap, int lenPer, String dataName, String unit) throws Exception {
		int total = (b.length - len - lenPer)/lenPer ;
		
		for(int i = 0 ; i < total ; i++){
			DataVO dd = new DataVO() ;
			dataMap.setValue(i + 1, dd) ;
			dd.dataName = dataName + (i + 1) ;
			dd.valueUnit = unit ;
			
			int temp = b[index + lenPer] ;
			dd.fengXiang = temp >> 4 ;
			
			b[index + lenPer] = (byte)(b[index + lenPer] & 0xF) ;
			
			dd.valueLng = ByteUtil.BCD2Long_an(b, index, index + lenPer) ;
			
			index += lenPer ;
		}
		return index ;
	}

	protected int doParseSingleFengSuData(byte[] b, int index, DataMap_B0 dataMap, int lenPer, String dataName, String unit) throws Exception {
		int total = 1 ;
		
		for(int i = 0 ; i < total ; i++){
			DataVO dd = new DataVO() ;
			dataMap.setValue(i + 1, dd) ;
			dd.dataName = dataName + (i + 1) ;
			dd.valueUnit = unit ;
			
			int temp = b[index + lenPer] ;
			dd.fengXiang = temp >> 4 ;
			
			b[index + lenPer] = (byte)(b[index + lenPer] & 0xF) ;
			
			dd.valueLng = ByteUtil.BCD2Long_an(b, index, index + lenPer) ;
			
			index += lenPer ;
		}
		return index ;
	}
	
	protected void doParseAlarm(byte[] b, DataMap_B0 dataMap)throws Exception {
		AlarmStatusProtocol_206 asAgree = new AlarmStatusProtocol_206() ;
		int index = (b.length - 2 - 4) ;
		asAgree.parse(b, index, dataMap) ;
	}

}
