package com.blg.rtu.protocol.p206.cd4E;

import java.io.Serializable;


public class Param_4E implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_4E.class.getName() ;


	private Integer enable_1 ;

	public String toString(){
		String s = "\n" ;
		s += "出厂启用：" + "\n" +
		" 命令：" + (enable_1.intValue() == 1?"出厂启用":"取消出厂启用") ;
		return s ;
	}


	public Integer getEnable_1() {
		return enable_1;
	}

	public void setEnable_1(Integer enable_1) {
		this.enable_1 = enable_1;
	}
}