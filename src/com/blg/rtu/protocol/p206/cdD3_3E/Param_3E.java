package com.blg.rtu.protocol.p206.cdD3_3E;

import java.io.Serializable;

public class Param_3E implements Serializable{
	
	private static final long serialVersionUID = 2017050915300234L;

	public static final String KEY = Param_3E.class.getName() ;
	
	protected String waterMeterSerial ;//水表出厂编号协议
	
	public String toString() {
		String s = "\n设置水表出厂编号： \n" ;
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
