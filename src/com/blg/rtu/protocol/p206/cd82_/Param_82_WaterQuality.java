package com.blg.rtu.protocol.p206.cd82_;

import java.io.Serializable;

public class Param_82_WaterQuality implements Serializable{

	private static final long serialVersionUID = 201410202125003L;

	public static final String KEY = Param_82_WaterQuality.class.getName() ;

	//水质只做基本五参数：水温、Ph值、电导率、溶解氧、浊度等部分的人工置数。
	public Double value_ShuiWen_0to99d9 ; // D0 水温 ℃ N(3，1)
	public Double value_PH_0to99d99 ; // D1 pH 值 N（4，2）
	public Double value_RongJieYang_0to999d9 ; // D2 溶解氧 mg/L N（4，1） 
	public Integer value_DianDaoLu_0to99999 ; // D4 电导率 μs/cm N（5） 
	public Integer value_ZhuoDu_0to999 ; // D6 浊度 度N（3） 
	
	

	public String toString(){
		String s = "\n水质参数种类、上限值：\n" ;
			s += " 水温：" + value_ShuiWen_0to99d9 + " ℃ N(3，1)\n" ;
			s += " pH值：" + value_PH_0to99d99 + " N（4，2）\n" ;
			s += " 溶解氧：" + value_RongJieYang_0to999d9 + " mg/L N（4，1）\n" ;
			s += " 电导率：" + value_DianDaoLu_0to99999 + " μs/cm N（5）\n" ;
			s += "  浊度：" + value_ZhuoDu_0to999 + " 度N（3）\n" ;
		
		return s ;
	}



	public Double getValue_ShuiWen_0to99d9() {
		return value_ShuiWen_0to99d9;
	}



	public void setValue_ShuiWen_0to99d9(Double value_ShuiWen_0to99d9) {
		this.value_ShuiWen_0to99d9 = value_ShuiWen_0to99d9;
	}



	public Double getValue_PH_0to99d99() {
		return value_PH_0to99d99;
	}



	public void setValue_PH_0to99d99(Double value_PH_0to99d99) {
		this.value_PH_0to99d99 = value_PH_0to99d99;
	}



	public Double getValue_RongJieYang_0to999d9() {
		return value_RongJieYang_0to999d9;
	}



	public void setValue_RongJieYang_0to999d9(Double value_RongJieYang_0to999d9) {
		this.value_RongJieYang_0to999d9 = value_RongJieYang_0to999d9;
	}



	public Integer getValue_DianDaoLu_0to99999() {
		return value_DianDaoLu_0to99999;
	}



	public void setValue_DianDaoLu_0to99999(Integer value_DianDaoLu_0to99999) {
		this.value_DianDaoLu_0to99999 = value_DianDaoLu_0to99999;
	}



	public Integer getValue_ZhuoDu_0to999() {
		return value_ZhuoDu_0to999;
	}



	public void setValue_ZhuoDu_0to999(Integer value_ZhuoDu_0to999) {
		this.value_ZhuoDu_0to999 = value_ZhuoDu_0to999;
	}
	
	
}
