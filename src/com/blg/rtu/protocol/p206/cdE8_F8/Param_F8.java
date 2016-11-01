package com.blg.rtu.protocol.p206.cdE8_F8;

import java.io.Serializable;

public class Param_F8 implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;

	public static final String KEY = Param_F8.class.getName() ;
	
	protected Integer hour_0to23 ;//延时时间
	
	public String toString(){
		String s = "\n上报起始时间：\n" ;
		s += "时=" + hour_0to23 + "\n" ;
		return s ;
	}

	public Integer getHour_0to23() {
		return hour_0to23;
	}

	public void setHour_0to23(Integer hour_0to23) {
		this.hour_0to23 = hour_0to23;
	}



}
