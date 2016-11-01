package com.blg.rtu.protocol.p206.cd11_51;

public class Data_11_51 {
	private String clock ; //时钟
	private String week ;//星期

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String toString() {
		String s = "\n" ;
		s += "clock : " + (clock == null?"":clock) + "\n" ; //
		s += "week : " + (week == null?"":week) + "\n" ; //
		return s ;
	}

	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}
	

}
