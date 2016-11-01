package com.blg.rtu.protocol.p206.cdE6_F6;


public class Data_E6_F6 {
	

	private Integer enable_1 ;//1路AD (有效1 无效0)
	private Integer enable_2 ;//2路AD (有效1 无效0)
	private Integer enable_3 ;//3路AD (有效1 无效0)
	private Integer enable_4 ;//4路AD (有效1 无效0)
	
	private Integer value_1 ;//1路AD采集的校准值
	private Integer value_2 ;//2路AD采集的校准值
	private Integer value_3 ;//3路AD采集的校准值
	private Integer value_4 ;//4路AD采集的校准值
	

	public String toString(){
		String s = "\n" ;
		s += "AD采集校准值：" + "\n" +
				" 1路AD采集校准值：" + (enable_1.intValue() == 1?"有效":"无效") + " 校准值：" + value_1 + "\n" +
				" 2路AD采集校准值：" + (enable_2.intValue() == 1?"有效":"无效") + " 校准值：" + value_2 + "\n" +
				" 3路AD采集校准值：" + (enable_3.intValue() == 1?"有效":"无效") + " 校准值：" + value_3 + "\n" +
				" 4路AD采集校准值：" + (enable_4.intValue() == 1?"有效":"无效") + " 校准值：" + value_4 + "\n" ;
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


	public Integer getValue_1() {
		return value_1;
	}


	public void setValue_1(Integer value_1) {
		this.value_1 = value_1;
	}


	public Integer getValue_2() {
		return value_2;
	}


	public void setValue_2(Integer value_2) {
		this.value_2 = value_2;
	}


	public Integer getValue_3() {
		return value_3;
	}


	public void setValue_3(Integer value_3) {
		this.value_3 = value_3;
	}


	public Integer getValue_4() {
		return value_4;
	}


	public void setValue_4(Integer value_4) {
		this.value_4 = value_4;
	}

	
}
