package com.blg.rtu.protocol.p206.cdE9_F9;

import java.io.Serializable;

public class Param_F9 implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;

	public static final String KEY = Param_F9.class.getName() ;
	
	protected Integer delay_0to255 ;//延时时间
	
	public String toString(){
		String s = "\n仪表上电读值延时时间：\n" ;
		s += "延时时间=" + delay_0to255 + "\n" ;
		return s ;
	}

	public Integer getDelay_0to255() {
		return delay_0to255;
	}

	public void setDelay_0to255(Integer delay_0to255) {
		this.delay_0to255 = delay_0to255;
	}



}
