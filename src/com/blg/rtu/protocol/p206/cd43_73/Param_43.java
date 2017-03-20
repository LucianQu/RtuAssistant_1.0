package com.blg.rtu.protocol.p206.cd43_73;

import java.io.Serializable;


public class Param_43 implements Serializable{
	
	private static final long serialVersionUID = 201703201149004L;

	public static final String KEY = Param_43.class.getName() ;


	private Integer enable_1 ;
	private Integer enable_2 ;
	private Integer enable_3 ;
	private Integer enable_4 ;
	private Integer enable_5 ;
	private Integer enable_6 ;
	private Integer enable_7 ;
	private Integer enable_8 ;
	
	private Integer modBusAddr1 ;
	private Integer modBusAddr2 ;
	private Integer modBusAddr3 ;
	private Integer modBusAddr4 ;
	private Integer modBusAddr5 ;
	private Integer modBusAddr6 ;
	private Integer modBusAddr7 ;
	private Integer modBusAddr8 ;

	public String toString(){
		String s = "\n" ;
		s += "短信中心：" + "\n" +
		" ModBus地址1：" + (enable_1.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr1 + "\n" +
		" ModBus地址2：" + (enable_2.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr2 + "\n" +
		" ModBus地址3：" + (enable_3.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr3 + "\n" +
		" ModBus地址4：" + (enable_4.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr4 + "\n" +
		" ModBus地址5：" + (enable_5.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr5 + "\n" +
		" ModBus地址6：" + (enable_6.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr6 + "\n" +
		" ModBus地址7：" + (enable_7.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr7 + "\n" +
		" ModBus地址8：" + (enable_8.intValue() == 1?"使能":"不使能") + " 地址：" + modBusAddr8 + "\n" ;
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

	public Integer getEnable_6() {
		return enable_6;
	}

	public void setEnable_6(Integer enable_6) {
		this.enable_6 = enable_6;
	}

	public Integer getEnable_7() {
		return enable_7;
	}

	public void setEnable_7(Integer enable_7) {
		this.enable_7 = enable_7;
	}

	public Integer getEnable_8() {
		return enable_8;
	}

	public void setEnable_8(Integer enable_8) {
		this.enable_8 = enable_8;
	}
	
	public Integer getModBusAddr1() {
		return modBusAddr1;
	}

	public void setModBusAddr1(Integer modBusAddr1) {
		this.modBusAddr1 = modBusAddr1;
	}

	public Integer getModBusAddr2() {
		return modBusAddr2;
	}

	public void setModBusAddr2(Integer modBusAddr2) {
		this.modBusAddr2 = modBusAddr2;
	}

	public Integer getModBusAddr3() {
		return modBusAddr3;
	}

	public void setModBusAddr3(Integer modBusAddr3) {
		this.modBusAddr3 = modBusAddr3;
	}

	public Integer getModBusAddr4() {
		return modBusAddr4;
	}

	public void setModBusAddr4(Integer modBusAddr4) {
		this.modBusAddr4 = modBusAddr4;
	}
	
	public Integer getModBusAddr5() {
		return modBusAddr5;
	}

	public void setModBusAddr5(Integer modBusAddr5) {
		this.modBusAddr5 = modBusAddr5;
	}

	public Integer getModBusAddr6() {
		return modBusAddr6;
	}

	public void setModBusAddr6(Integer modBusAddr6) {
		this.modBusAddr6 = modBusAddr6;
	}

	public Integer getModBusAddr7() {
		return modBusAddr7;
	}

	public void setModBusAddr7(Integer modBusAddr7) {
		this.modBusAddr7 = modBusAddr7;
	}

	public Integer getModBusAddr8() {
		return modBusAddr8;
	}

	public void setModBusAddr8(Integer modBusAddr8) {
		this.modBusAddr8 = modBusAddr8;
	}
}
