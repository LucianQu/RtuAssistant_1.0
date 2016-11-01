package com.blg.rtu.protocol.p206.cdA0_54;

import com.blg.rtu.protocol.p206.common.data.ParamDataType206_2012;

//a) D0——置“1”为查询雨量数据，清“0”为不查询雨量数据；
//b) D1——置“1”为查询水位数据，清“0”为不查询水位数据；
//c) D2——置“1”为查询流量（水量）数据，清“0”为不查询流量（水量）数据；
//d) D3——置“1”为查询流速数据，清“0”为不查询流速数据；
//e) D4——置“1”为查询闸位数据，清“0”为不查询闸位数据；
//f) D5——置“1”为查询功率数据，清“0”为不查询功率数据；
//g) D6——置“1”为查询气压数据，清“0”为不查询气压数据；
//h) D7——置“1”为查询风速数据，清“0”为不查询风速数据；
//i) D8——置“1”为查询水温数据，清“0”为不查询水温数据；
//j) D9——置“1”为查询水质数据，清“0”为不查询水质数据；
//k) D10——置“1”为查询土壤含水率数据，清“0”为不查询土壤含水率数据；
//l) D11——置“1”为查询蒸发量数据，清“0”为不查询蒸发量数据；
//m) D12——置“1”为查询终端内存数据，清“0”为不查询终端内存数据；
//n) D13——置“1”为查询固态存储数据，清“0”为不查询固态存储数据；
//o) D14——置“1”为查询上报水压数据，清“0”为不查询水压数据；
//p) D15 备用。
public class Param_A0 extends ParamDataType206_2012{

	private static final long serialVersionUID = 20121202223701L;

	public static final String KEY = Param_A0.class.getName() ;
	
	////////////////////
	//参量种类   继承父类
	
	protected Integer neiCun_0or1 ;//置“1”为查询终端内存数据，清“0”为不查询终端内存数据；
	protected Integer guTai_0or1 ;//置“1”为查询固态存储数据，清“0”为不查询固态存储数据；
	protected Integer shuiYa_0or1 ;//置“1”为查询上报水压数据，清“0”为不查询水压数据；


	public String toString(){
		String s = super.toString() ;
		s += "neiCun" + "=" + (this.neiCun_0or1==null?"":this.neiCun_0or1.intValue()) + "\n" ;
		s += "guTai" + "=" + (this.guTai_0or1==null?"":this.guTai_0or1.intValue()) + "\n" ;
		s += "shuiYa" + "=" + (this.shuiYa_0or1==null?"":this.shuiYa_0or1.intValue()) + "\n" ;
		return s ;
	}


	public Integer getNeiCun_0or1() {
		return neiCun_0or1;
	}


	public void setNeiCun_0or1(Integer neiCun_0or1) {
		this.neiCun_0or1 = neiCun_0or1;
	}


	public Integer getGuTai_0or1() {
		return guTai_0or1;
	}


	public void setGuTai_0or1(Integer guTai_0or1) {
		this.guTai_0or1 = guTai_0or1;
	}


	public Integer getShuiYa_0or1() {
		return shuiYa_0or1;
	}


	public void setShuiYa_0or1(Integer shuiYa_0or1) {
		this.shuiYa_0or1 = shuiYa_0or1;
	}
	

}
