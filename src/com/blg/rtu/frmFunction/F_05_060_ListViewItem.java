package com.blg.rtu.frmFunction;

public class F_05_060_ListViewItem {

	public Integer index ;
	public String logHex ;
	public String logDate ;
	public String logType;
	public String logContent;
	public String logComments;
	
	public Boolean loseLog ;//有log日志漏记了 
	
	public F_05_060_ListViewItem(Integer index,String logDate, String logType, Boolean loseLog, String logContent, String logComments){
		this.index = index ;
		this.logDate = logDate;
		this.logType = logType ;
		this.loseLog = loseLog ;
		this.logContent = logContent;
		this.logComments = logComments;
	}
	
}
