package com.blg.rtu.protocol.p206.cd45_75;

public class Data_45_75 {
	
	private int a01 ;//a1 净积显示 ： 1为显示，0为不显示
	private int a02 ;//a2 正积显示 ： 1为显示，0为不显示
	private int a03 ;//a3 负积显示 ： 1为显示，0为不显示
	private int a04 ;//a4 瞬时流量显示 ： 1为显示，0为不显示
	private int a05 ;//a5 日期显示 ： 1为显示，0为不显示
	private int a06 ;//a6 电压显示 ： 1为显示，0为不显示
	private int a07 ;//a7 电压显示 ： 1为显示，0为不显示
	
	private int showInterval ;//0~1000
	
	
	
	public String toString(){
		String s = "" ; 
		s += "\n净积显示: " + (a01==1?"显示":"不显示") ;
		s += "\n正积显示: " + (a02==1?"显示":"不显示") ;
		s += "\n负积显示: " + (a03==1?"显示":"不显示") ;
		s += "\n瞬时流量显示: " + (a04==1?"显示":"不显示") ;
		s += "\n日期显示: " + (a05==1?"显示":"不显示") ;
		s += "\n时间显示: " + (a06==1?"显示":"不显示") ;
		s += "\n电压显示: " + (a07==1?"显示":"不显示") ;
		
		s += "\n刷屏间隔: " + showInterval ;
	
		return s ;
	}


	public int getA01() {
		return a01;
	}


	public void setA01(int a01) {
		this.a01 = a01;
	}


	public int getA02() {
		return a02;
	}


	public void setA02(int a02) {
		this.a02 = a02;
	}


	public int getA03() {
		return a03;
	}


	public void setA03(int a03) {
		this.a03 = a03;
	}


	public int getA04() {
		return a04;
	}


	public void setA04(int a04) {
		this.a04 = a04;
	}


	public int getA05() {
		return a05;
	}


	public void setA05(int a05) {
		this.a05 = a05;
	}
	
	public int getA06() {
		return a06;
	}


	public void setA06(int a06) {
		this.a06 = a06;
	}


	public int getA07() {
		return a07;
	}


	public void setA07(int a07) {
		this.a07 = a07;
	}

	public int getShowInterval() {
		return showInterval;
	}


	public void setShowInterval(int showInterval) {
		this.showInterval = showInterval;
	}
	
}
