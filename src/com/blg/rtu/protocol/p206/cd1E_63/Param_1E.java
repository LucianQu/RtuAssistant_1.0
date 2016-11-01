package com.blg.rtu.protocol.p206.cd1E_63;

import java.io.Serializable;

public class Param_1E implements Serializable{
	
	private static final long serialVersionUID = 201212051907001L;

	public static final String KEY = Param_1E.class.getName() ;

	private Integer autoWorkChange_0or1 ;//工作机（值班/备份）自动切换，11 为自动切换，其它为无效
	private Integer enableRelay_0or1 ;//工作机中继转发允许， 00 为不允许，11 为允许，其它为无效
	private Integer autoReportPowerAlarm_0or1 ;//置“1” 为出现电源报警主动上报，清“0” 为不主动上报
	private Integer autoReportWorkChange_0or1 ;//置“1” 为出现工作机切换主动上报，清“0” 为不主动上报；
	private Integer autoReportFault_0or1 ;//置“1” 为出现故障主动上报，清“0” 为不主动上报；

	public String toString(){
		String s = "\n工作机（值班/备份）自动切换" + "=" + (this.autoWorkChange_0or1==null?"":(autoWorkChange_0or1 == 1?"是":"否")) ;
		s += "\n工作机中继转发允许" + "=" + (this.enableRelay_0or1==null?"":(enableRelay_0or1 == 1?"是":"否")) ;
		s += "\n电源报警主动上报" + "=" + (this.autoReportPowerAlarm_0or1==null?"":(autoReportPowerAlarm_0or1 == 1?"是":"否")) ;
		s += "\n工作机切换主动上报" + "=" + (this.autoReportWorkChange_0or1==null?"":(autoReportWorkChange_0or1 == 1?"是":"否")) ;
		s += "\n故障主动上报" + "=" + (this.autoReportFault_0or1==null?"":(autoReportFault_0or1 == 1?"是":"否")) + "\n" ;
		return s ;
	}

	public Integer getAutoWorkChange_0or1() {
		return autoWorkChange_0or1;
	}

	public void setAutoWorkChange_0or1(Integer autoWorkChange_0or1) {
		this.autoWorkChange_0or1 = autoWorkChange_0or1;
	}

	public Integer getEnableRelay_0or1() {
		return enableRelay_0or1;
	}

	public void setEnableRelay_0or1(Integer enableRelay_0or1) {
		this.enableRelay_0or1 = enableRelay_0or1;
	}

	public Integer getAutoReportPowerAlarm_0or1() {
		return autoReportPowerAlarm_0or1;
	}

	public void setAutoReportPowerAlarm_0or1(Integer autoReportPowerAlarm_0or1) {
		this.autoReportPowerAlarm_0or1 = autoReportPowerAlarm_0or1;
	}

	public Integer getAutoReportWorkChange_0or1() {
		return autoReportWorkChange_0or1;
	}

	public void setAutoReportWorkChange_0or1(Integer autoReportWorkChange_0or1) {
		this.autoReportWorkChange_0or1 = autoReportWorkChange_0or1;
	}

	public Integer getAutoReportFault_0or1() {
		return autoReportFault_0or1;
	}

	public void setAutoReportFault_0or1(Integer autoReportFault_0or1) {
		this.autoReportFault_0or1 = autoReportFault_0or1;
	}


}
