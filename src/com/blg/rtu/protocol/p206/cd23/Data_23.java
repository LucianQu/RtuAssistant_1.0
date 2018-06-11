package com.blg.rtu.protocol.p206.cd23;

public class Data_23 {
	
	private int queryYear ;
	private int queryMonth ;
	private Long monthUseWater ;//月用水量(0~99999999，单位为 m3)
	
	public String toString(){
		String s = "\n查询月用水量(应答)\n" ;
		s += "\n查询年" + "=" + this.queryYear + "\n";
		s += "\n查询月" + "=" + this.queryMonth + "\n";
		s += "\n月用水量" + "=" + (this.monthUseWater==null? "---" :this.monthUseWater.intValue()) + "(立方米)\n" ;
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
	
	public Long getMonthUseWater() {
		return monthUseWater;
	}

	public void setMonthUseWater(Long monthUseWater) {
		this.monthUseWater = monthUseWater;
	}
	
}
