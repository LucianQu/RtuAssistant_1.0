package com.blg.rtu.protocol.p206.cdE6_F6;

import java.io.Serializable;


public class Param_F6 implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_F6.class.getName() ;


	private Integer enable_1 ;//1路AD (有效1 无效0)
	private Integer enable_2 ;//2路AD (有效1 无效0)
	private Integer enable_3 ;//3路AD (有效1 无效0)
	private Integer enable_4 ;//4路AD (有效1 无效0)
	
	private Integer value_1_0to65535 ;//1路AD采集的校准值
	private Integer value_2_0to65535 ;//2路AD采集的校准值
	private Integer value_3_0to65535 ;//3路AD采集的校准值
	private Integer value_4_0to65535 ;//4路AD采集的校准值
	

	public String toString(){
		String s = "\n" ;
		s += "AD采集校准值：" + "\n" +
				" 1路AD采集校准值：" + (enable_1.intValue() == 1?"有效":"无效") + " 校准值：" + value_1_0to65535 + "\n" +
				" 2路AD采集校准值：" + (enable_2.intValue() == 1?"有效":"无效") + " 校准值：" + value_2_0to65535 + "\n" +
				" 3路AD采集校准值：" + (enable_3.intValue() == 1?"有效":"无效") + " 校准值：" + value_3_0to65535 + "\n" +
				" 4路AD采集校准值：" + (enable_4.intValue() == 1?"有效":"无效") + " 校准值：" + value_4_0to65535 + "\n" ;
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


	public Integer getEnable_3() {
		return enable_3;
	}


	public void setEnable_3(Integer enable_3) {
		this.enable_3 = enable_3;
	}


	public Integer getEnable_4() {
		return enable_4;
	}


	public void setEnable_4(Integer enable_4) {
		this.enable_4 = enable_4;
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


	public Integer getValue_3_0to65535() {
		return value_3_0to65535;
	}


	public void setValue_3_0to65535(Integer value_3_0to65535) {
		this.value_3_0to65535 = value_3_0to65535;
	}


	public Integer getValue_4_0to65535() {
		return value_4_0to65535;
	}


	public void setValue_4_0to65535(Integer value_4_0to65535) {
		this.value_4_0to65535 = value_4_0to65535;
	}



}
