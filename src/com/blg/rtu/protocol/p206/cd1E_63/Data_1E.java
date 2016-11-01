package com.blg.rtu.protocol.p206.cd1E_63;

public class Data_1E {
	
	protected Integer autoWorkChange ;//工作机（值班/备份）自动切换，11 为自动切换，其它为无效
	protected Integer enableRelay ;//工作机中继转发允许， 00 为不允许，11 为允许，其它为无效
	protected Integer autoReportPowerAlarm ;//置“1” 为出现电源报警主动上报，清“0” 为不主动上报
	protected Integer autoReportWorkChange ;//置“1” 为出现工作机切换主动上报，清“0” 为不主动上报；
	protected Integer autoReportFault ;//置“1” 为出现故障主动上报，清“0” 为不主动上报；


	public String toString(){
		String s = "\n工作机（值班/备份）自动切换" + "=" + (this.autoWorkChange==null?"":(autoWorkChange == 1?"是":"否")) ;
		s += "\n工作机中继转发允许" + "=" + (this.enableRelay==null?"":(enableRelay == 1?"是":"否")) ;
		s += "\n电源报警主动上报" + "=" + (this.autoReportPowerAlarm==null?"":(autoReportPowerAlarm == 1?"是":"否")) ;
		s += "\n工作机切换主动上报" + "=" + (this.autoReportWorkChange==null?"":(autoReportWorkChange == 1?"是":"否")) ;
		s += "\n故障主动上报" + "=" + (this.autoReportFault==null?"":(autoReportFault == 1?"是":"否")) + "\n" ;
		return s ;
	}


	public Integer getAutoWorkChange() {
		return autoWorkChange;
	}


	public void setAutoWorkChange(Integer autoWorkChange) {
		this.autoWorkChange = autoWorkChange;
	}


	public Integer getEnableRelay() {
		return enableRelay;
	}


	public void setEnableRelay(Integer enableRelay) {
		this.enableRelay = enableRelay;
	}


	public Integer getAutoReportPowerAlarm() {
		return autoReportPowerAlarm;
	}


	public void setAutoReportPowerAlarm(Integer autoReportPowerAlarm) {
		this.autoReportPowerAlarm = autoReportPowerAlarm;
	}


	public Integer getAutoReportWorkChange() {
		return autoReportWorkChange;
	}


	public void setAutoReportWorkChange(Integer autoReportWorkChange) {
		this.autoReportWorkChange = autoReportWorkChange;
	}


	public Integer getAutoReportFault() {
		return autoReportFault;
	}


	public void setAutoReportFault(Integer autoReportFault) {
		this.autoReportFault = autoReportFault;
	}

	
}
