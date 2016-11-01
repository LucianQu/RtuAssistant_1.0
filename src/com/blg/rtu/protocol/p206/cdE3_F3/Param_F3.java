package com.blg.rtu.protocol.p206.cdE3_F3;

import java.io.Serializable;


public class Param_F3 implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_F3.class.getName() ;


	private Integer enable_level_0To1 ;//水位仪表  	1变更有效          0变更无效
	private Integer enable_qaulity_0To1 ;//水质仪表  	1变更有效          0变更无效
	private Integer enable_temperature_0To1 ;//水温仪表  	1变更有效          0变更无效
	private Integer enable_amount1_0To1 ;//流量仪表  	1变更有效          0变更无效
	private Integer enable_amount2_0To1 ;//流量仪表  	1变更有效          0变更无效
	private Integer enable_amount3_0To1 ;//流量仪表  	1变更有效          0变更无效

	private Integer meter_level_0To255 ;//水位仪表种类
	private Integer meter_qaulity_0To255 ;//水质仪表种类
	private Integer meter_temperature_0To255 ;//水温仪表种类
	private Integer meter_amount1_0To255 ;//流量仪表种类
	private Integer meter_amount2_0To255 ;//流量仪表种类
	private Integer meter_amount3_0To255 ;//流量仪表种类

	public String toString(){
		String s = "\n" ;
		s += "仪表系数：" + "\n" +
				" 水位仪表：" + (enable_level_0To1.intValue() == 1?"有效":"无效") + "\n" + 
				" 水质仪表：" + (enable_qaulity_0To1.intValue() == 1?"有效":"无效") + "\n" +
				" 水温仪表：" + (enable_temperature_0To1.intValue() == 1?"有效":"无效") +  "\n" +
				" 流量仪表1：" + (enable_amount1_0To1.intValue() == 1?"有效":"无效") +  "\n" +
				" 流量仪表2：" + (enable_amount2_0To1.intValue() == 1?"有效":"无效") + "\n" + 
				" 流量仪表3：" + (enable_amount3_0To1.intValue() == 1?"有效":"无效") + "\n" +  
				
				" 水位仪表种类：" + meter_level_0To255 +  "\n" +
				" 水质仪表种类：" + meter_qaulity_0To255 + "\n" +
				" 水温仪表种类：" + meter_temperature_0To255 + "\n" + 
				" 流量仪表1种类：" + meter_amount1_0To255 + "\n" +
				" 流量仪表2种类：" + meter_amount2_0To255 + "\n" +  
				" 流量仪表2种类：" + meter_amount3_0To255   ;
		return s ;
	}

	public Integer getEnable_level_0To1() {
		return enable_level_0To1;
	}

	public void setEnable_level_0To1(Integer enable_level_0To1) {
		this.enable_level_0To1 = enable_level_0To1;
	}

	public Integer getEnable_qaulity_0To1() {
		return enable_qaulity_0To1;
	}

	public void setEnable_qaulity_0To1(Integer enable_qaulity_0To1) {
		this.enable_qaulity_0To1 = enable_qaulity_0To1;
	}

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

	public Integer getMeter_level_0To255() {
		return meter_level_0To255;
	}

	public void setMeter_level_0To255(Integer meter_level_0To255) {
		this.meter_level_0To255 = meter_level_0To255;
	}

	public Integer getMeter_qaulity_0To255() {
		return meter_qaulity_0To255;
	}

	public void setMeter_qaulity_0To255(Integer meter_qaulity_0To255) {
		this.meter_qaulity_0To255 = meter_qaulity_0To255;
	}

	public Integer getMeter_temperature_0To255() {
		return meter_temperature_0To255;
	}

	public void setMeter_temperature_0To255(Integer meter_temperature_0To255) {
		this.meter_temperature_0To255 = meter_temperature_0To255;
	}

	public Integer getMeter_amount1_0To255() {
		return meter_amount1_0To255;
	}

	public void setMeter_amount1_0To255(Integer meter_amount1_0To255) {
		this.meter_amount1_0To255 = meter_amount1_0To255;
	}

	public Integer getMeter_amount2_0To255() {
		return meter_amount2_0To255;
	}

	public void setMeter_amount2_0To255(Integer meter_amount2_0To255) {
		this.meter_amount2_0To255 = meter_amount2_0To255;
	}

	public Integer getMeter_amount3_0To255() {
		return meter_amount3_0To255;
	}

	public void setMeter_amount3_0To255(Integer meter_amount3_0To255) {
		this.meter_amount3_0To255 = meter_amount3_0To255;
	}


}
