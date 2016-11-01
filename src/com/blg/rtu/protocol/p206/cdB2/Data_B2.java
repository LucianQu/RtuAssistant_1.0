package com.blg.rtu.protocol.p206.cdB2;

public class Data_B2 {
	
	protected String startDt ;//查询起始日期(月-日 时:分)
	protected String endDt ;//查询截止日期(月-日 时:分)
	
	public String toString(){
		String s = "查询起始日期(年-月-日 时:分) ：" + this.startDt + "\n" ;
		s += "查询截止日期(年-月-日 时:分) ：" + this.endDt + "\n" ;
		return s ;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

}
