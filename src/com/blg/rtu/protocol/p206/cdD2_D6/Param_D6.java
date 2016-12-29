package com.blg.rtu.protocol.p206.cdD2_D6;

import java.io.Serializable;


public class Param_D6 implements Serializable{
	
	private static final long serialVersionUID = 201409232122031L;

	public static final String KEY = Param_D6.class.getName() ;


	public Integer enable_1 ;
	public Integer enable_2 ;
	public Integer enable_3 ;
	public Integer enable_4 ;
	public Integer enable_5 ;
	

	public String toString() {
		String s = "\n" ;
		s += "定时报协议："    + "\n" +
		"功能码D0是否开启 ："   + (enable_1.intValue() == 0 ? "开启" : "关闭") + "\n" +
		"定时报协议选择："     + (enable_2.intValue() == 0 ? "C1" : "C0") + "\n" +
		"C0上报累计值类型："   + (enable_3.intValue() == 0 ? "正积" : "净积") + "\n" +
		"C0累计值是否上报："   + (enable_4.intValue() == 0 ? "上报" : "不上报") + "\n" +
		"C0瞬时流量是否上报：" + (enable_5.intValue() == 0 ? "上报" : "不上报") ;
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

	public Integer getEnable_5() {
		return enable_5;
	}


	public void setEnable_5(Integer enable_5) {
		this.enable_5 = enable_5;
	}
}
