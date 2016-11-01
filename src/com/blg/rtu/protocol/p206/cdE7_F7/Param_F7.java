package com.blg.rtu.protocol.p206.cdE7_F7;

import java.io.Serializable;


public class Param_F7 implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_F7.class.getName() ;

	private Integer enable_01 ;//雨量, 1采集，0不采集； 
	private Integer enable_02 ;//水位, 1采集，0不采集； 
	private Integer enable_03 ;//流量, 1采集，0不采集；  
	private Integer enable_04 ;//流速, 1采集，0不采集；  
	private Integer enable_05 ;//闸位, 1采集，0不采集；  
	private Integer enable_06 ;//功率, 1采集，0不采集；  
	private Integer enable_07 ;//气压, 1采集，0不采集；  
	private Integer enable_08 ;//风速（风向）, 1采集，0不采集；  
	private Integer enable_09 ;//水温, 1采集，0不采集；  
	private Integer enable_10 ;//水质, 1采集，0不采集； 
	private Integer enable_11 ;//土壤墒情, 1采集，0不采集；  
	private Integer enable_12 ;//蒸发量, 1采集，0不采集；  
	private Integer enable_13 ;//报警状态, 1采集，0不采集；  
	private Integer enable_14 ;//水压, 1采集，0不采集；  
	private Integer enable_15 ;//电压, 1采集，0不采集；  

	private Integer value_01_1TO999 ;//雨量采集时间间隔(分钟)
	private Integer value_02_1TO999 ;//水位采集时间间隔(分钟)
	private Integer value_03_1TO999 ;//流量采集时间间隔(分钟)
	private Integer value_04_1TO999 ;//流速采集时间间隔(分钟)
	private Integer value_05_1TO999 ;//闸位采集时间间隔(分钟)
	private Integer value_06_1TO999 ;//功率采集时间间隔(分钟)
	private Integer value_07_1TO999 ;//气压采集时间间隔(分钟)
	private Integer value_08_1TO999 ;//风速（风向）采集时间间隔(分钟)
	private Integer value_09_1TO999 ;//水温采集时间间隔(分钟)
	private Integer value_10_1TO999 ;//水质采集时间间隔(分钟)
	private Integer value_11_1TO999 ;//土壤墒情采集时间间隔(分钟)
	private Integer value_12_1TO999 ;//蒸发量采集时间间隔(分钟)
	private Integer value_13_1TO999 ;//报警状态采集时间间隔(分钟)
	private Integer value_14_1TO999 ;//水压采集时间间隔(分钟)
	private Integer value_15_1TO999 ;//电压采集时间间隔(分钟)
	
	

	public String toString(){
		String s = "\n" ;
		s += "数据采集种类及时间间隔：" + "\n" +
				" 雨量：" + (enable_01==null?"不采集":(enable_01.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_01_1TO999 + "\n" +  //雨量, 1采集，0不采集； 
				" 水位：" + (enable_02==null?"不采集":(enable_02.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_02_1TO999 + "\n" +  //水位, 1采集，0不采集； 
				" 流量：" + (enable_03==null?"不采集":(enable_03.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_03_1TO999 + "\n" +  //流量, 1采集，0不采集；  
				" 流速：" + (enable_04==null?"不采集":(enable_04.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_04_1TO999 + "\n" +  //流速, 1采集，0不采集；  
				" 闸位：" + (enable_05==null?"不采集":(enable_05.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_05_1TO999 + "\n" +  //闸位, 1采集，0不采集；  
				" 功率：" + (enable_06==null?"不采集":(enable_06.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_06_1TO999 + "\n" +  //功率, 1采集，0不采集；  
				" 气压：" + (enable_07==null?"不采集":(enable_07.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_07_1TO999 + "\n" +  //气压, 1采集，0不采集；  
				" 风速：" + (enable_08==null?"不采集":(enable_08.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_08_1TO999 + "\n" +  //风速（风向）, 1采集，0不采集；  
				" 水温：" + (enable_09==null?"不采集":(enable_09.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_09_1TO999 + "\n" +  //水温, 1采集，0不采集；  
				" 水质：" + (enable_10==null?"不采集":(enable_10.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_10_1TO999 + "\n" +  //水质, 1采集，0不采集； 
				" 土壤墒情：" + (enable_11==null?"不采集":(enable_11.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_11_1TO999 + "\n" +  //土壤墒情, 1采集，0不采集；  
				" 蒸发量：" + (enable_12==null?"不采集":(enable_12.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_12_1TO999 + "\n" +  //蒸发量, 1采集，0不采集；  
				" 报警状态：" + (enable_13==null?"不采集":(enable_13.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_13_1TO999 + "\n" +  //报警状态, 1采集，0不采集；  
				" 水压：" + (enable_14==null?"不采集":(enable_14.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_14_1TO999 + "\n" +  //水压, 1采集，0不采集；  
				" 电压：" + (enable_15==null?"不采集":(enable_15.intValue() == 1?"采集":"不采集")) + " 采集间隔：" + value_15_1TO999 + "\n" ;  //电压, 1采集，0不采集；  
		return s ;
	}



	public Integer getEnable_01() {
		return enable_01;
	}



	public void setEnable_01(Integer enable_01) {
		this.enable_01 = enable_01;
	}



	public Integer getEnable_02() {
		return enable_02;
	}



	public void setEnable_02(Integer enable_02) {
		this.enable_02 = enable_02;
	}



	public Integer getEnable_03() {
		return enable_03;
	}



	public void setEnable_03(Integer enable_03) {
		this.enable_03 = enable_03;
	}



	public Integer getEnable_04() {
		return enable_04;
	}



	public void setEnable_04(Integer enable_04) {
		this.enable_04 = enable_04;
	}



	public Integer getEnable_05() {
		return enable_05;
	}



	public void setEnable_05(Integer enable_05) {
		this.enable_05 = enable_05;
	}



	public Integer getEnable_06() {
		return enable_06;
	}



	public void setEnable_06(Integer enable_06) {
		this.enable_06 = enable_06;
	}



	public Integer getEnable_07() {
		return enable_07;
	}



	public void setEnable_07(Integer enable_07) {
		this.enable_07 = enable_07;
	}



	public Integer getEnable_08() {
		return enable_08;
	}



	public void setEnable_08(Integer enable_08) {
		this.enable_08 = enable_08;
	}



	public Integer getEnable_09() {
		return enable_09;
	}



	public void setEnable_09(Integer enable_09) {
		this.enable_09 = enable_09;
	}



	public Integer getEnable_10() {
		return enable_10;
	}



	public void setEnable_10(Integer enable_10) {
		this.enable_10 = enable_10;
	}



	public Integer getEnable_11() {
		return enable_11;
	}



	public void setEnable_11(Integer enable_11) {
		this.enable_11 = enable_11;
	}



	public Integer getEnable_12() {
		return enable_12;
	}



	public void setEnable_12(Integer enable_12) {
		this.enable_12 = enable_12;
	}



	public Integer getEnable_13() {
		return enable_13;
	}



	public void setEnable_13(Integer enable_13) {
		this.enable_13 = enable_13;
	}



	public Integer getEnable_14() {
		return enable_14;
	}



	public void setEnable_14(Integer enable_14) {
		this.enable_14 = enable_14;
	}



	public Integer getEnable_15() {
		return enable_15;
	}



	public void setEnable_15(Integer enable_15) {
		this.enable_15 = enable_15;
	}



	public Integer getValue_01_1TO999() {
		return value_01_1TO999;
	}



	public void setValue_01_1TO999(Integer value_01_1to999) {
		value_01_1TO999 = value_01_1to999;
	}



	public Integer getValue_02_1TO999() {
		return value_02_1TO999;
	}



	public void setValue_02_1TO999(Integer value_02_1to999) {
		value_02_1TO999 = value_02_1to999;
	}



	public Integer getValue_03_1TO999() {
		return value_03_1TO999;
	}



	public void setValue_03_1TO999(Integer value_03_1to999) {
		value_03_1TO999 = value_03_1to999;
	}



	public Integer getValue_04_1TO999() {
		return value_04_1TO999;
	}



	public void setValue_04_1TO999(Integer value_04_1to999) {
		value_04_1TO999 = value_04_1to999;
	}



	public Integer getValue_05_1TO999() {
		return value_05_1TO999;
	}



	public void setValue_05_1TO999(Integer value_05_1to999) {
		value_05_1TO999 = value_05_1to999;
	}



	public Integer getValue_06_1TO999() {
		return value_06_1TO999;
	}



	public void setValue_06_1TO999(Integer value_06_1to999) {
		value_06_1TO999 = value_06_1to999;
	}



	public Integer getValue_07_1TO999() {
		return value_07_1TO999;
	}



	public void setValue_07_1TO999(Integer value_07_1to999) {
		value_07_1TO999 = value_07_1to999;
	}



	public Integer getValue_08_1TO999() {
		return value_08_1TO999;
	}



	public void setValue_08_1TO999(Integer value_08_1to999) {
		value_08_1TO999 = value_08_1to999;
	}



	public Integer getValue_09_1TO999() {
		return value_09_1TO999;
	}



	public void setValue_09_1TO999(Integer value_09_1to999) {
		value_09_1TO999 = value_09_1to999;
	}



	public Integer getValue_10_1TO999() {
		return value_10_1TO999;
	}



	public void setValue_10_1TO999(Integer value_10_1to999) {
		value_10_1TO999 = value_10_1to999;
	}



	public Integer getValue_11_1TO999() {
		return value_11_1TO999;
	}



	public void setValue_11_1TO999(Integer value_11_1to999) {
		value_11_1TO999 = value_11_1to999;
	}



	public Integer getValue_12_1TO999() {
		return value_12_1TO999;
	}



	public void setValue_12_1TO999(Integer value_12_1to999) {
		value_12_1TO999 = value_12_1to999;
	}



	public Integer getValue_13_1TO999() {
		return value_13_1TO999;
	}



	public void setValue_13_1TO999(Integer value_13_1to999) {
		value_13_1TO999 = value_13_1to999;
	}



	public Integer getValue_14_1TO999() {
		return value_14_1TO999;
	}



	public void setValue_14_1TO999(Integer value_14_1to999) {
		value_14_1TO999 = value_14_1to999;
	}



	public Integer getValue_15_1TO999() {
		return value_15_1TO999;
	}



	public void setValue_15_1TO999(Integer value_15_1to999) {
		value_15_1TO999 = value_15_1to999;
	}


}
