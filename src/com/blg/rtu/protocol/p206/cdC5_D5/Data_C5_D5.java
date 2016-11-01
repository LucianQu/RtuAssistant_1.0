package com.blg.rtu.protocol.p206.cdC5_D5;

public class Data_C5_D5 {
	
	public static final String KEY = Param_D5.class.getName() ;
	
	protected Integer hour ;// 
	
	public String toString(){
		String s = "\n定时上报的时刻：\n" ;
		s += "时刻=" + hour + "\n" ;
		return s ;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}



}
