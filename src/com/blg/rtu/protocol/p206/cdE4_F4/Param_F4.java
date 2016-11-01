package com.blg.rtu.protocol.p206.cdE4_F4;

import java.io.Serializable;


public class Param_F4 implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_F4.class.getName() ;


	private Integer enable_level_0To1 ;//水位仪表  	1变更有效          0变更无效
//	private Integer enable_qaulity_0To1 ;//水质仪表  	1变更有效          0变更无效
	private Integer enable_temperature_0To1 ;//水温仪表  	1变更有效          0变更无效
	private Integer enable_amount1_0To1 ;//流量仪表  	1变更有效          0变更无效
	private Integer enable_amount2_0To1 ;//流量仪表  	1变更有效          0变更无效
	private Integer enable_amount3_0To1 ;//流量仪表  	1变更有效          0变更无效

	private Float meter_level_0To655d35 ;//水位仪表量程
//	private Integer meter_qaulity_0To65535 ;//水质仪表量程
	private Float meter_temperature_0To655d35 ;//水温仪表量程
	private Float meter_amount1_0To6553d5 ;//流量仪表量程
	private Float meter_amount2_0To6553d5 ;//流量仪表量程
	private Float meter_amount3_0To6553d5 ;//流量仪表量程

	public String toString(){
		String s = "\n" ;
		s += "仪表量程：" + "\n" +
				" 水位仪表：" + (enable_level_0To1.intValue() == 1?"有效":"无效") + "\n" + 
//				" 水质仪表：" + (enable_qaulity_0To1.intValue() == 1?"有效":"无效") + 
				" 水温仪表：" + (enable_temperature_0To1.intValue() == 1?"有效":"无效") +  "\n" +
				" 流量仪表1：" + (enable_amount1_0To1.intValue() == 1?"有效":"无效") + "\n" + 
				" 流量仪表2：" + (enable_amount2_0To1.intValue() == 1?"有效":"无效") + "\n" + 
				" 流量仪表3：" + (enable_amount3_0To1.intValue() == 1?"有效":"无效") + "\n" + 
				
				" 水位仪表量程：" + meter_level_0To655d35 + "\n" + 
//				" 水质仪表量程：" + meter_qaulity_0To65535 + "\n" +
				" 水温仪表量程：" + meter_temperature_0To655d35 + "\n" + 
				" 流量仪表1量程：" + meter_amount1_0To6553d5 + "\n" +
				" 流量仪表2量程：" + meter_amount2_0To6553d5 + "\n" +  
				" 流量仪表2量程：" + meter_amount3_0To6553d5 + "\n"   ;
		return s ;
	}

	public Integer getEnable_level_0To1() {
		return enable_level_0To1;
	}

	public void setEnable_level_0To1(Integer enable_level_0To1) {
		this.enable_level_0To1 = enable_level_0To1;
	}

//	public Integer getEnable_qaulity_0To1() {
//		return enable_qaulity_0To1;
//	}
//
//	public void setEnable_qaulity_0To1(Integer enable_qaulity_0To1) {
//		this.enable_qaulity_0To1 = enable_qaulity_0To1;
//	}

	public Integer getEnable_temperature_0To1() {
		return enable_temperature_0To1;
	}

	public void setEnable_temperature_0To1(Integer enable_temperature_0To1) {
		this.enable_temperature_0To1 = enable_temperature_0To1;
	}

	public Integer getEnable_amount1_0To1() {
		return enable_amount1_0To1;
	}

	public void setEnable_amount1_0To1(Integer enable_amount1_0To1) {
		this.enable_amount1_0To1 = enable_amount1_0To1;
	}

	public Integer getEnable_amount2_0To1() {
		return enable_amount2_0To1;
	}

	public void setEnable_amount2_0To1(Integer enable_amount2_0To1) {
		this.enable_amount2_0To1 = enable_amount2_0To1;
	}

	public Integer getEnable_amount3_0To1() {
		return enable_amount3_0To1;
	}

	public void setEnable_amount3_0To1(Integer enable_amount3_0To1) {
		this.enable_amount3_0To1 = enable_amount3_0To1;
	}

	public Float getMeter_level_0To655d35() {
		return meter_level_0To655d35;
	}

	public void setMeter_level_0To655d35(Float meter_level_0To655d35) {
		this.meter_level_0To655d35 = meter_level_0To655d35;
	}

//	public Integer getMeter_qaulity_0To65535() {
//		return meter_qaulity_0To65535;
//	}
//
//	public void setMeter_qaulity_0To65535(Integer meter_qaulity_0To65535) {
//		this.meter_qaulity_0To65535 = meter_qaulity_0To65535;
//	}

	public Float getMeter_temperature_0To655d35() {
		return meter_temperature_0To655d35;
	}

	public void setMeter_temperature_0To655d35(Float meter_temperature_0To65535) {
		this.meter_temperature_0To655d35 = meter_temperature_0To65535;
	}

	public Float getMeter_amount1_0To6553d5() {
		return meter_amount1_0To6553d5;
	}

	public void setMeter_amount1_0To6553d5(Float meter_amount1_0To6553d5) {
		this.meter_amount1_0To6553d5 = meter_amount1_0To6553d5;
	}

	public Float getMeter_amount2_0To6553d5() {
		return meter_amount2_0To6553d5;
	}

	public void setMeter_amount2_0To6553d5(Float meter_amount2_0To6553d5) {
		this.meter_amount2_0To6553d5 = meter_amount2_0To6553d5;
	}

	public Float getMeter_amount3_0To6553d5() {
		return meter_amount3_0To6553d5;
	}

	public void setMeter_amount3_0To6553d5(Float meter_amount3_0To6553d5) {
		this.meter_amount3_0To6553d5 = meter_amount3_0To6553d5;
	}


}
