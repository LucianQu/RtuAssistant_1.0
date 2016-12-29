package com.blg.rtu.protocol.p206.cdD2_D6;


public class Data_D2_D6 {
	

	public Integer enable_D0 ;
	public Integer reportPrtcl ;
	public Integer reportType ;
	public Integer enable_AccumuTotal ;
	public Integer enable_Instant ;
	

	public String toString() {
		String s = "\n" ;
		s += "定时报协议："    + "\n" +
		"功能码D0是否开启 ："   + (enable_D0.intValue() == 0 ? "开启" : "关闭") + "\n" +
		"定时报协议选择："     + (reportPrtcl.intValue() == 0 ? "C1" : "C0") + "\n" +
		"C0上报累计值类型："   + (reportType.intValue() == 0 ? "正积" : "净积") + "\n" +
		"C0累计值是否上报："   + (enable_AccumuTotal.intValue() == 0 ? "上报" : "不上报") + "\n" +
		"C0瞬时流量是否上报：" + (enable_Instant.intValue() == 0 ? "上报" : "不上报") ;
		return s ;
	} 

	public Integer getEnable_D0() {
		return enable_D0 ;
	}
	public void setEnable_D0(Integer enable_d0) {
		this.enable_D0 = enable_d0 ;
	}
	public Integer getReportPrtcl() {
		return reportPrtcl ;
	}
	public void setReportPrtcl(Integer reportPrtcl) {
		this.reportPrtcl = reportPrtcl ;
	}
	public Integer getReportType() {
		return reportType ;
	}
	public void setReportType(Integer reportType) {
		this.reportType = reportType ;
	}
	public Integer getEnable_AccumuTotal() {
		return enable_AccumuTotal ;
	}
	public void setEnable_AccumuTotal(Integer enable_AccumuTotal) {
		this.enable_AccumuTotal = enable_AccumuTotal ;
	}
	public Integer getEnable_Instant() {
		return enable_Instant ;
	}
	public void setEnable_Instant(Integer enable_Instant) {
		this.enable_Instant = enable_Instant ;
	}
}
