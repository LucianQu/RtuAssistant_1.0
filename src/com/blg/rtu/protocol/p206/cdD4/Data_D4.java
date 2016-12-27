package com.blg.rtu.protocol.p206.cdD4;

public class Data_D4 {
	protected String simIccID ;
	
	public String toString() {
		String s = "\n 查询SIM卡ICCID号： \n" ;
		s += "ICCID号" + "=" + (this.simIccID == null ? "" : simIccID + "\n") ;
		return s ;
	}
	public String getSimIccId() {
		return simIccID ;
	}
	public void setSimIccId(String simIccId) {
		this.simIccID = simIccId ;
	}
}
