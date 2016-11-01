package com.blg.rtu.protocol.p206.cdE2_F2;

import java.io.Serializable;


public class Param_F2 implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_F2.class.getName() ;


	private Integer enable_1 ;//电池电源 (有效1 无效0)
	private Integer enable_2 ;//外部电源(有效1 无效0)
	
	private Integer value_1_0to65535 ;//电池供电校准系数
	private Integer value_2_0to65535 ;//外部电源校准系数
	

	public String toString(){
		String s = "\n" ;
		s += "电源采集校准系数：" + "\n" +
		" 电池电源：" + (enable_1.intValue() == 1?"有效":"无效") + " 校准系数：" + value_1_0to65535 + "\n" +
		" 外部电源：" + (enable_2.intValue() == 1?"有效":"无效") + " 校准系数：" + value_2_0to65535 + "\n" ;
		return s ;
	}


	public Integer getEnable_1() {
		return enable_1;
	}


	public void setEnable_1(Integer enable_1) {
		this.enable_1 = enable_1;
	}


	public Integer getEnable_2() {
		return enable_2;
	}


	public void setEnable_2(Integer enable_2) {
		this.enable_2 = enable_2;
	}


	public Integer getValue_1_0to65535() {
		return value_1_0to65535;
	}


	public void setValue_1_0to65535(Integer value_1_0to65535) {
		this.value_1_0to65535 = value_1_0to65535;
	}


	public Integer getValue_2_0to65535() {
		return value_2_0to65535;
	}


	public void setValue_2_0to65535(Integer value_2_0to65535) {
		this.value_2_0to65535 = value_2_0to65535;
	}


}
