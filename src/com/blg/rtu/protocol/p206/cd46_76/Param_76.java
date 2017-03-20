package com.blg.rtu.protocol.p206.cd46_76;

import java.io.Serializable;


public class Param_76 implements Serializable{
	
	private static final long serialVersionUID = 201703201149008L;
	
	public static final String KEY = Param_76.class.getName() ;
	
	private int plusNum ;
	
	public String toString(){
		String s = "\n查询正积表号\n" ;
		s += "表号:" + "=" + this.plusNum ;
		return s ;
	}
	
	public int getPlusNum() {
		return plusNum ;
	}
	
	public void setPlusNum(int plusNum) {
		this.plusNum = plusNum ;
	}
}
