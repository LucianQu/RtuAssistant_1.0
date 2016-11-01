package com.blg.rtu.protocol.p206.cdED;

import java.io.Serializable;


public class Param_ED implements Serializable{
	
	private static final long serialVersionUID = 201410191903001L;
	
	public static final String KEY = Param_ED.class.getName() ;
	
	private int count_0to1024 ;//读取的日志条数
	
	public String toString(){
		String s = "" ; 
		s += "\n读取的日志条数: " + count_0to1024 ;
		return s ;
	}
	
	public int getCount_0to1024() {
		return count_0to1024;
	}
	public void setCount_0to1024(int count_0to1024) {
		this.count_0to1024 = count_0to1024;
	}
	


}
