package com.blg.rtu.protocol.p206.cdE2_F2;


public class Data_E2_F2 {
	
	private Integer enable_1 ;//电池电源 (有效1 无效0)
	private Integer enable_2 ;//外部电源(有效1 无效0)
	
	private Integer value_1  ;//电池供电校准系数
	private Integer value_2  ;//外部电源校准系数
	

	public String toString(){
		String s = "\n" ;
		s += "电源采集校准系数：" + "\n" +
		" 电池电源：" + (enable_1.intValue() == 1?"有效":"无效") + " 校准系数：" + value_1 + "\n" +
		" 外部电源：" + (enable_2.intValue() == 1?"有效":"无效") + " 校准系数：" + value_2 + "\n" ;
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



	
}
