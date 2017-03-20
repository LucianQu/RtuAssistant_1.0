package com.blg.rtu.protocol.p206.cd47_77;

import java.io.Serializable;


public class Param_77 implements Serializable{
	
	private static final long serialVersionUID = 201703201150008L;
	
	public static final String KEY = Param_77.class.getName() ;
	
	private int minusNum ;
	
	public String toString(){
		String s = "\n查询负积表号\n" ;
		s += "表号:" + "=" + this.minusNum ;
		return s ;
	}
	
	public int getMinusNum() {
		return minusNum ;
	}
	
	public void setMinusNum(int minusNum) {
		this.minusNum = minusNum ;
	}
}
