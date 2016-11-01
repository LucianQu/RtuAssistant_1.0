package com.blg.rtu.protocol.p206.common.data;


public class DateTime206_2012 {

	protected int date ;
	protected int hour ;
	protected int minute ;
	protected int second ;

	
	protected String clock ;//测控终端数据中的日期与时间
	protected long clockDifference_minute ;//测控终端时钟与本地时钟差值(分钟)
	
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public String getClock() {
		return clock;
	}
	public void setClock(String clock) {
		this.clock = clock;
	}
	public long getClockDifference_minute() {
		return clockDifference_minute;
	}
	public void setClockDifference_minute(long clockDifferenceMinute) {
		clockDifference_minute = clockDifferenceMinute;
	}
	
	
}
