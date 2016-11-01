package com.blg.rtu.protocol.p206.cdE9_F9;

public class Data_E9_F9 {
	
	public static final String KEY = Param_F9.class.getName() ;
	
	protected Integer delay ;//延时时间
	
	public String toString(){
		String s = "\n仪表上电读值延时时间：\n" ;
		s += "延时时间=" + delay + "\n" ;
		return s ;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}



}
