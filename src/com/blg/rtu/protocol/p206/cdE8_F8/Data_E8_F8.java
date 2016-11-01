package com.blg.rtu.protocol.p206.cdE8_F8;

public class Data_E8_F8 {
	
	public static final String KEY = Param_F8.class.getName() ;
	
	protected Integer hour ;// 
	
	public String toString(){
		String s = "\n上报起始时间：\n" ;
		s += "时=" + hour + "\n" ;
		return s ;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}



}
