package com.blg.rtu.protocol.p206.cd11_51;

import java.io.Serializable;


public class Param_11 implements Serializable{
	
	private static final long serialVersionUID = 201410282335001L;

	public static final String KEY = Param_11.class.getName() ;

	private Integer year ;
	private Integer month ;
	private Integer day ;
	private Integer hour ;
	private Integer minute ;
	private Integer second ;
	
	public String toString(){
		String s = "\n年:" + this.year ;
		s += "\n月:" + this.month ;
		s += "\n日:" + this.day ;
		s += "\n时:" + this.hour ;
		s += "\n分:" + this.minute ;
		s += "\n秒:" + this.second ;
		return s ;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	
	

}
