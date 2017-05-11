package com.blg.rtu.protocol.p206.cdD3_3E;

public class Data_D3_3E {
	protected String waterMeterSerial ;//水表出厂编号协议
	
	public String toString() {
		String s = "\n查询水表出厂编号： \n" ;
		s += "出厂编号" + "=" + (this.waterMeterSerial == null ? "" :waterMeterSerial+ "\n");
		return s ;
	}
	public String getWaterMeterSerial() {
		return waterMeterSerial ;
	}
	public void setWaterMeterSerial(String waterMeterSerial) {
		this.waterMeterSerial = waterMeterSerial ;
	}
}
