package com.blg.rtu.protocol.p206.cdED;

public class Data_ED {
	
	private int index ;//日志序号
	private String logHex ;//日志数据十六进制
	
	public String toString(){
		String s = "\n" ;
		s += index + "：" + logHex ;
		return s ;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getLogHex() {
		return logHex;
	}
	public void setLogHex(String logHex) {
		this.logHex = logHex;
	}

}
