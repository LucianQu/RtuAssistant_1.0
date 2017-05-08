package com.blg.rtu.protocol.p206.cd40_70;

import java.io.Serializable;


public class Param_70 implements Serializable{
	
	private static final long serialVersionUID = 201705031150008L;
	
	public static final String KEY = Param_70.class.getName() ;
	
	private int PureNum ;
	
	public String toString(){
		String s = "\n查询负积表号\n" ;
		s += "表号:" + "=" + this.PureNum ;
		return s ;
	}
	
	public int getPureNum() {
		return PureNum ;
	}
	
	public void setPureNum(int PureNum) {
		this.PureNum = PureNum ;
	}
}
