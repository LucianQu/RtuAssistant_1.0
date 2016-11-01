package com.blg.rtu.protocol.p206.cdA0_54;

import com.blg.rtu.protocol.p206.common.data.ReportDataType206_2012;

public class Data_A0_54 extends ReportDataType206_2012 {
	
	////////////////////
	//参量种类   继承父类
	protected Integer neiCun ;//置“1”为查询终端内存数据，清“0”为不查询终端内存数据；
	protected Integer guTai ;//置“1”为查询固态存储数据，清“0”为不查询固态存储数据；
	protected Integer shuiYa ;//置“1”为查询上报水压数据，清“0”为不查询水压数据；


	public String toString(){
		String s = super.toString() ;
		s += "neiCun" + "=" + (this.neiCun==null?"":this.neiCun.intValue()) + "\n" ;
		s += "guTai" + "=" + (this.guTai==null?"":this.guTai.intValue()) + "\n" ;
		s += "shuiYa" + "=" + (this.shuiYa==null?"":this.shuiYa.intValue()) + "\n" ;
		return s ;
	}


	public Integer getNeiCun() {
		return neiCun;
	}


	public void setNeiCun(Integer neiCun_0or1) {
		this.neiCun = neiCun_0or1;
	}


	public Integer getGuTai() {
		return guTai;
	}


	public void setGuTai(Integer guTai_0or1) {
		this.guTai = guTai_0or1;
	}


	public Integer getShuiYa() {
		return shuiYa;
	}


	public void setShuiYa(Integer shuiYa_0or1) {
		this.shuiYa = shuiYa_0or1;
	}
	

}