package com.blg.rtu.protocol.p206.cdC9_D9;

import java.io.Serializable;


public class Param_D9 implements Serializable{
	
	private static final long serialVersionUID = 201409232122004L;

	public static final String KEY = Param_D9.class.getName() ;


	private Integer interval_0to10 ;

	public String toString(){
		String s = "\n" ;
		s += "心跳间隔：" + "=" + (this.interval_0to10==null?"": interval_0to10) ;
		return s ;
	}

	public Integer getInterval_0to10() {
		return interval_0to10;
	}

	public void setInterval_0to10(Integer interval_0to10) {
		this.interval_0to10 = interval_0to10;
	}

}
