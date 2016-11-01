package com.blg.rtu.frmFunction;

public class F_05_060_ListViewItem {

	public Integer index ;
	public String logHex ;
	
	public Boolean loseLog ;//有log日志漏记了 
	
	public F_05_060_ListViewItem(Integer index, String logHex, Boolean loseLog){
		this.index = index ;
		this.logHex = logHex ;
		this.loseLog = loseLog ;
	}
	
}
