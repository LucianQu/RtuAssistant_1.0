package com.blg.rtu.protocol.p206.cd82;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.protocol.AlarmStatusProtocol_206;
import com.blg.rtu.protocol.p206.util.Constant;

public class Report_82  extends ProtocolSupport{

	private static String tag = Report_82.class.getName() ;
	
	protected static int len = Constant.Bits_Head 
				+ Constant.Bits_Control
				+ Constant.Bits_RTU_ID 
				+ Constant.Bits_Code 
				+ Constant.Bits_Time
				+ Constant.Bits_CRC
				+ Constant.Bits_Tail ;
	
	private Integer model ;
	
	public Integer getModel() {
		return model;
	}
	public void setModel(Integer model) {
		this.model = model;
	}
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
		
		Log.i(tag, "分析<人工置数>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	protected void doParse(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		
		if(ca.FUNCODE == Constant.Down_ControlFunCode_1){
			//雨量参数
			this.doParseRain(b, index, d, ca) ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_14){
			//统计雨量 
			this.doParseStaticRain(b, index, d, ca) ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_2){
			//水位参数
			this.doParseWaterLevel(b, index, d, ca) ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_3){
			//流量参数
			this.doParseWaterAmount(b, index, d, ca) ;
		}else if(ca.FUNCODE == Constant.Up_ControlFunCode_11){
			//土壤墒情参数
			this.doParseSoil(b, index, d, ca) ;
		}else{
			throw new Exception("当前实现不支持此数据类型:" + ca.FUNCODE) ;
		}
		
		
	}
	
	
	protected void doParseRain(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		
		DataMap_82 dataMap = new DataMap_82() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		Data_rain_82 dd = new Data_rain_82() ;
		dataMap.setValue(1, dd) ;
		
		bcd = ByteUtil.BCD2Int_an(b, index, index + 2) ;
		dd.setRain(bcd/10.0) ;
		
		index += 3 ;
		
		index = this.parseStatus(b, index, dataMap) ;
//		this.parseTime(d, b, index) ;
	}
	
	protected void doParseStaticRain(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		DataMap_82 dataMap = new DataMap_82() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		Data_statisticRain_82 dd = new Data_statisticRain_82() ;
		dataMap.setValue(1, dd) ;
		
		byte value = b[index++] ;
		dd.setStageType(Integer.valueOf((value & 0xC0) >> 6)) ;
		dd.setStage(Integer.valueOf(value & 0x3F)) ;
		
		bcd = ByteUtil.BCD2Int_an(b, index, index + 2) ;
		dd.setRain(bcd/10.0) ;
		
		index += 3 ;
		index = this.parseStatus(b, index, dataMap) ;
//		this.parseTime(d, b, index) ;
	}
	
	protected void doParseWaterLevel(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		int total = (b.length - len - 4)/4 ;
		DataMap_82 dataMap = new DataMap_82() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		boolean plus = true ;
		for(int i = 0 ; i < total ; i++){
			plus = true ;
			Data_waterLevel_82 dd = new Data_waterLevel_82() ;
			dataMap.setValue(i + 1, dd) ;
			
			int temp = b[index + 3] ;
			temp = temp >> 4 ;
			if(temp > 0){
				plus = false ;
			}
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 3) ;
			if(plus){
				dd.setWaterLevel(bcd/100.0D) ;
			}else{
				dd.setWaterLevel(-(bcd/100.0D)) ;
			}
			
			index += 4 ;
		}
		index = this.parseStatus(b, index, dataMap) ;
//		this.parseTime(d, b, index) ;
	}
	
	protected void doParseWaterAmount(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		int total = (b.length - len - 4)/5 ;
		DataMap_82 dataMap = new DataMap_82() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		boolean plus = true ;
		for(int i = 0 ; i < total ; i++){
			plus = true ;
			Data_waterAmount_82 dd = new Data_waterAmount_82() ;
			dataMap.setValue(i + 1, dd) ;
			
			int temp = b[index + 4] ;
			temp = temp >> 4 ;
			if(temp > 0){
				plus = false ;
			}
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 4) ;
			if(plus){
				dd.setWaterAmount(bcd/1000.0D) ;
			}else{
				dd.setWaterAmount(-(bcd/1000.0D)) ;
			}
			
			index += 5 ;
		}
		index = this.parseStatus(b, index, dataMap) ;
//		this.parseTime(d, b, index) ;
	}
	
	protected void doParseSoil(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		int total = (b.length - len - 4)/2 ;
		DataMap_82 dataMap = new DataMap_82() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		for(int i = 0 ; i < total ; i++){
			Data_soil_82 dd = new Data_soil_82() ;
			dataMap.setValue(i + 1, dd) ;
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 1) ;
			
			dd.setSoil(bcd/10.0D) ;
			
			index += 2 ;
		}
		index = this.parseStatus(b, index, dataMap) ;
//		this.parseTime(d, b, index) ;
	}
	
	protected int parseStatus(byte[] b, int index, DataMap_82 dataMap) throws Exception {
		AlarmStatusProtocol_206 asAgree = new AlarmStatusProtocol_206() ;
		asAgree.parse(b, index, dataMap) ;
		
		this.model = dataMap.getModelStatus() ;
		
		return index + 2 ;
	}

}
