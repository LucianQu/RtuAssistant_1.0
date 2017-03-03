package com.blg.rtu.protocol.p206.cd45_75;

import java.io.Serializable;


public class Param_45 implements Serializable{
	
	private static final long serialVersionUID = 201410152325001L;
	
	public static final String KEY = Param_45.class.getName() ;
	
	private int a01_0or1 ;//a1 净积显示;  1为显示，0为不显示
	private int a02_0or1 ;//a2 正积显示;  1为显示，0为不显示
	private int a03_0or1 ;//a3 负积显示;  1为显示，0为不显示
	private int a04_0or1 ;//a4瞬时流量显示;  1为显示，0为不显示
	private int a05_0or1 ;//a5 日期显示;  1为显示，0为不显示
	private int a06_0or1 ;//a6时间显示;  1为显示，0为不显示
	private int a07_0or1 ;//a7 电压显示;  1为显示，0为不显示
	
	private int showInterval0to9999 ;//刷屏间隔
	
	public String toString(){
		String s = "" ; 
		s += "\n净积显示: " + (a01_0or1==1?"显示":"不显示") ;
		s += "\n正积显示: " + (a02_0or1==1?"显示":"不显示") ;
		s += "\n负积显示: " + (a03_0or1==1?"显示":"不显示") ;
		s += "\n瞬时流量: " + (a04_0or1==1?"显示":"不显示") ;
		s += "\n日期显示: " + (a05_0or1==1?"显示":"不显示") ;
		s += "\n时间显示: " + (a06_0or1==1?"显示":"不显示") ;
		s += "\n电压显示: " + (a07_0or1==1?"显示":"不显示") ;
		
		s += "\n状态量变更: " + showInterval0to9999 ;
		
		return s ;
	}
	
	public int getA01_0or1() {
		return a01_0or1;
	}
	public void setA01_0or1(int a01_0or1) {
		this.a01_0or1 = a01_0or1;
	}
	public int getA02_0or1() {
		return a02_0or1;
	}
	public void setA02_0or1(int a02_0or1) {
		this.a02_0or1 = a02_0or1;
	}
	public int getA03_0or1() {
		return a03_0or1;
	}
	public void setA03_0or1(int a03_0or1) {
		this.a03_0or1 = a03_0or1;
	}
	public int getA04_0or1() {
		return a04_0or1;
	}
	public void setA04_0or1(int a04_0or1) {
		this.a04_0or1 = a04_0or1;
	}
	public int getA05_0or1() {
		return a05_0or1;
	}
	public void setA05_0or1(int a05_0or1) {
		this.a05_0or1 = a05_0or1;
	}
	
	public int getA06_0or1() {
		return a06_0or1;
	}
	public void setA06_0or1(int a06_0or1) {
		this.a06_0or1 = a06_0or1;
	}
	public int getA07_0or1() {
		return a07_0or1;
	}
	public void setA07_0or1(int a07_0or1) {
		this.a07_0or1 = a07_0or1;
	}
	
	public int getShowInterval0to9999() {
		return showInterval0to9999;
	}
	public void setShowInterval0to9999(int showInterval0to9999) {
		this.showInterval0to9999 = showInterval0to9999;
	}
}
