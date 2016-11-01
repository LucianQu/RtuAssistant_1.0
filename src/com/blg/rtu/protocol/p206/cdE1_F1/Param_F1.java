package com.blg.rtu.protocol.p206.cdE1_F1;

import java.io.Serializable;

public class Param_F1 implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;

	public static final String KEY = Param_F1.class.getName() ;
	
	protected Integer voltage1 ;//报警电压整数部分
	protected Integer voltage2 ;//报警电压小数部分
	
	public String toString(){
		String s = "\n池电压报警值：\n" ;
		s += "数值" + "=" + (voltage1 + "." + voltage2) + "\n" ;
		return s ;
	}

	public Integer getVoltage1() {
		return voltage1;
	}

	public void setVoltage1(Integer voltage1) {
		this.voltage1 = voltage1;
	}

	public Integer getVoltage2() {
		return voltage2;
	}

	public void setVoltage2(Integer voltage2) {
		this.voltage2 = voltage2;
	}

}
