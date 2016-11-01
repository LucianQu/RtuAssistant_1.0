package com.blg.rtu.protocol.p206.cdE4_F4;


public class Data_E4_F4 {
	
	private Integer enable_level ;//水位仪表  	1变更有效          0变更无效
//	private Integer enable_qaulity ;//水质仪表  	1变更有效          0变更无效
	private Integer enable_temperature ;//水温仪表  	1变更有效          0变更无效
	private Integer enable_amount1 ;//流量仪表  	1变更有效          0变更无效
	private Integer enable_amount2 ;//流量仪表  	1变更有效          0变更无效
	private Integer enable_amount3 ;//流量仪表  	1变更有效          0变更无效

	private Float meter_level ;//水位仪表量程
//	private Integer meter_qaulity ;//水质仪表量程
	private Float meter_temperature ;//水温仪表量程
	private Float meter_amount1 ;//流量仪表量程
	private Float meter_amount2 ;//流量仪表量程
	private Float meter_amount3 ;//流量仪表量程
	

	public String toString(){
		String s = "\n" ;
		s += "仪表量程：" + "\n" +
				" 水位仪表：" + (enable_level.intValue() == 1?"有效":"无效") + "\n" + 
//				" 水质仪表：" + (enable_qaulity.intValue() == 1?"有效":"无效") + 
				" 水温仪表：" + (enable_temperature.intValue() == 1?"有效":"无效") +  "\n" +
				" 流量仪表1：" + (enable_amount1.intValue() == 1?"有效":"无效") +  "\n" +
				" 流量仪表2：" + (enable_amount2.intValue() == 1?"有效":"无效") + "\n" + 
				" 流量仪表3：" + (enable_amount3.intValue() == 1?"有效":"无效") + "\n" + 
				
				" 水位仪表量程：" + meter_level + "\n" + 
//				" 水质仪表量程：" + meter_qaulity + "\n" +
				" 水温仪表量程：" + meter_temperature + "\n" +  
				" 流量仪表1量程：" + meter_amount1 + "\n" +
				" 流量仪表2量程：" + meter_amount2 + "\n" + 
				" 流量仪表2量程：" + meter_amount3 + "\n"  ;
		return s ;
	}


	public Integer getEnable_level() {
		return enable_level;
	}


	public void setEnable_level(Integer enable_level) {
		this.enable_level = enable_level;
	}


//	public Integer getEnable_qaulity() {
//		return enable_qaulity;
//	}
//
//
//	public void setEnable_qaulity(Integer enable_qaulity) {
//		this.enable_qaulity = enable_qaulity;
//	}


	public Integer getEnable_temperature() {
		return enable_temperature;
	}


	public void setEnable_temperature(Integer enable_temperature) {
		this.enable_temperature = enable_temperature;
	}


	public Integer getEnable_amount1() {
		return enable_amount1;
	}


	public void setEnable_amount1(Integer enable_amount1) {
		this.enable_amount1 = enable_amount1;
	}


	public Integer getEnable_amount2() {
		return enable_amount2;
	}


	public void setEnable_amount2(Integer enable_amount2) {
		this.enable_amount2 = enable_amount2;
	}


	public Integer getEnable_amount3() {
		return enable_amount3;
	}


	public void setEnable_amount3(Integer enable_amount3) {
		this.enable_amount3 = enable_amount3;
	}


	public Float getMeter_level() {
		return meter_level;
	}


	public void setMeter_level(Float meter_level) {
		this.meter_level = meter_level;
	}

//
//	public Integer getMeter_qaulity() {
//		return meter_qaulity;
//	}
//
//
//	public void setMeter_qaulity(Integer meter_qaulity) {
//		this.meter_qaulity = meter_qaulity;
//	}


	public Float getMeter_temperature() {
		return meter_temperature;
	}


	public void setMeter_temperature(Float meter_temperature) {
		this.meter_temperature = meter_temperature;
	}


	public Float getMeter_amount1() {
		return meter_amount1;
	}


	public void setMeter_amount1(Float meter_amount1) {
		this.meter_amount1 = meter_amount1;
	}


	public Float getMeter_amount2() {
		return meter_amount2;
	}


	public void setMeter_amount2(Float meter_amount2) {
		this.meter_amount2 = meter_amount2;
	}


	public Float getMeter_amount3() {
		return meter_amount3;
	}


	public void setMeter_amount3(Float meter_amount3) {
		this.meter_amount3 = meter_amount3;
	}

	
}
