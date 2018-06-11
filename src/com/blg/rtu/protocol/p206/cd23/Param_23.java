package com.blg.rtu.protocol.p206.cd23;

import java.io.Serializable;


public class Param_23 implements Serializable{
	
	private static final long serialVersionUID = 201703201149008L;
	
	public static final String KEY = Param_23.class.getName() ;
	
	private int queryYear ;
	private int queryMonth ;
	
	public String toString(){
		String s = "\n查询月用水量(参数)\n" ;
		s += "\n查询年" + "=" + this.queryYear + "\n";
		s += "\n查询月" + "=" + this.queryMonth + "\n";
		return s ;
	}
	
	public int getQueryYear() {
		return queryYear ;
	}
	public void setQueryYear(int year) {
		this.queryYear = year ;
	}
	
	public int getQueryMonth() {
		return queryMonth ;
	}
	public void setQueryMonth(int month) {
		this.queryMonth = month ;
	}
}
