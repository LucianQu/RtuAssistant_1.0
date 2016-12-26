package com.blg.rtu.protocol.p206.cdED;

public class Data_ED {
	
	private int index ;//日志序号
	private String logHex ;//日志数据十六进制
	
	private String dateTime;
	private String typeNum;
	private String contentType;
	private String commentsType;
	
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

	//////////////////////////////////////
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getTypeNum() {
		return typeNum;
	}
	public void setCommentsType(String commentsType) {
		this.commentsType = commentsType;
	}
	public String getCommentsType() {
		return commentsType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContentType() {
		return contentType;
	}
}
