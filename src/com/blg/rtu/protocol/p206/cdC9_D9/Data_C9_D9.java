package com.blg.rtu.protocol.p206.cdC9_D9;


public class Data_C9_D9 {
	
	private Integer interval ;

	public String toString(){
		String s = "\n" ;
		s += "心跳间隔：" + "=" + (this.interval==null?"":interval) ;
		return s ;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}
}
