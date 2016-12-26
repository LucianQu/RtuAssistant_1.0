package com.blg.rtu.protocol.p206.cdD3;

public class Data_D3 {
	protected Long waterMeterSerial ;//水表出厂编号协议
	
	public String toString() {
		String s = "\n查询水表出厂编号： \n" ;
		s += "出厂编号" + "=" + (this.waterMeterSerial == null ? "" :this.waterMeterSerial.intValue()+ "\n");
		return s ;
	}
	public Long getWaterMeterSerial() {
		return waterMeterSerial ;
	}
	public void setWaterMeterSerial(Long waterMeterSerial) {
		this.waterMeterSerial = waterMeterSerial ;
	}
}
