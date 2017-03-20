package com.blg.rtu.protocol.p206.cd4D;

import java.io.Serializable;


public class Param_4D implements Serializable{
	
	private static final long serialVersionUID = 201703201149015L;

	public static final String KEY = Param_4D.class.getName() ;


	private Integer enable_1 ;

	public String toString(){
		String s = "\n" ;
		s += "Lora电源控制：" + "\n" +
		" 命令：" + (enable_1.intValue() == 1?"使能":"不使能") ;
		return s ;
	}


	public Integer getEnable_1() {
		return enable_1;
	}

	public void setEnable_1(Integer enable_1) {
		this.enable_1 = enable_1;
	}
}