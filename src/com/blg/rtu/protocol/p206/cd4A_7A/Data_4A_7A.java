package com.blg.rtu.protocol.p206.cd4A_7A;

public class Data_4A_7A {
	
	public static final String KEY = Param_4A.class.getName() ;
	
	protected Integer rfFrePoint ;// 
	
	public String toString(){
		String s = "\nRF频点：\n" ;
		s += "频点=" + rfFrePoint + "\n" ;
		return s ;
	}

	public Integer getRfFrePoint() {
		return rfFrePoint;
	}

	public void setRfFrePoint(Integer rfFrePoint) {
		this.rfFrePoint = rfFrePoint;
	}



}
