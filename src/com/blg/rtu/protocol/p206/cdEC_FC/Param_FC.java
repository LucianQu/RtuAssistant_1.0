package com.blg.rtu.protocol.p206.cdEC_FC;

import java.io.Serializable;


public class Param_FC implements Serializable{
	
	private static final long serialVersionUID = 201410152325001L;
	
	public static final String KEY = Param_FC.class.getName() ;
	
	private int a01_0or1 ;//a1 设备复位及启动;  1为保存，0为不存
	private int a02_0or1 ;//a2 传感器运行状态;  1为保存，0为不存
	private int a03_0or1 ;//a3 电池供电状态;  1为保存，0为不存
	private int a04_0or1 ;//a4 电源供电状态 ;  1为保存，0为不存
	private int a05_0or1 ;//a5 开门状态;  1为保存，0为不存
	
	private int b01_0or1 ;//b1 数据初始化;  1为保存，0为不存
	private int b02_0or1 ;//b2 参数变更;  1为保存，0为不存
	private int b03_0or1 ;//b3 状态量变更;  1为保存，0为不存
	private int b04_0or1 ;//b4发报文记录  1为保存，0为不存
	private int b05_0or1 ;//b5收报文记录;  1为保存，0为不存
	private int b06_0or1 ;//b6 补报存储;  1为保存，0为不存
	private int b07_0or1 ;//b7 补报发送;  1为保存，0为不存
	private int b08_0or1 ;//b8时间校准;  1为保存，0为不存
	private int b09_0or1 ;//b9手持设备接入;  1为保存，0为不存
	private int b10_0or1 ;//b10 按键唤醒 ;  1为保存，0为不存
	
	private int c01_0or1 ;//c1密码错误记录;  1为保存，0为不存
	private int c02_0or1 ;//c2电池电压低告警记录;  1为保存，0为不存
	private int c03_0or1 ;//c3 传感器故障;  1为保存，0为不存
	private int c04_0or1 ;//c4水位超限告警记录 ;  1为保存，0为不存
	private int c05_0or1 ;//c5水质参数超限告警记录;  1为保存，0为不存
	private int c06_0or1 ;//c6 连接中心失败;  1为保存，0为不存
	
	
	public String toString(){
		String s = "" ; 
		s += "\n设备复位及启动: " + (a01_0or1==1?"保存":"不存") ;
		s += "\n传感器运行状态: " + (a02_0or1==1?"保存":"不存") ;
		s += "\n电池供电状态: " + (a03_0or1==1?"保存":"不存") ;
		s += "\n电源供电状态: " + (a04_0or1==1?"保存":"不存") ;
		s += "\n开门状态: " + (a05_0or1==1?"保存":"不存") ;
		
		s += "\n数据初始化: " + (b01_0or1==1?"保存":"不存") ;
		s += "\n参数变更: " + (b02_0or1==1?"保存":"不存") ;
		s += "\n状态量变更: " + (b03_0or1==1?"保存":"不存") ;
		s += "\n发报文记录: " + (b04_0or1==1?"保存":"不存") ;
		s += "\n收报文记录: " + (b05_0or1==1?"保存":"不存") ;
		s += "\n补报存储: " + (b06_0or1==1?"保存":"不存") ;
		s += "\n补报发送: " + (b07_0or1==1?"保存":"不存") ;
		s += "\n时间校准: " + (b08_0or1==1?"保存":"不存") ;
		s += "\n手持设备接入: " + (b09_0or1==1?"保存":"不存") ;
		s += "\n按键唤醒: " + (b10_0or1==1?"保存":"不存") ;
		
		s += "\n密码错误记录: " + (c01_0or1==1?"保存":"不存") ;
		s += "\n电池电压低告警记录: " + (c02_0or1==1?"保存":"不存") ;
		s += "\n传感器故障: " + (c03_0or1==1?"保存":"不存") ;
		s += "\n水位超限告警记录: " + (c04_0or1==1?"保存":"不存") ;
		s += "\n水质参数超限告警记录: " + (c05_0or1==1?"保存":"不存") ;
		s += "\n连接中心失败: " + (c06_0or1==1?"保存":"不存") ;
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
	public int getB01_0or1() {
		return b01_0or1;
	}
	public void setB01_0or1(int b01_0or1) {
		this.b01_0or1 = b01_0or1;
	}
	public int getB02_0or1() {
		return b02_0or1;
	}
	public void setB02_0or1(int b02_0or1) {
		this.b02_0or1 = b02_0or1;
	}
	public int getB03_0or1() {
		return b03_0or1;
	}
	public void setB03_0or1(int b03_0or1) {
		this.b03_0or1 = b03_0or1;
	}
	public int getB04_0or1() {
		return b04_0or1;
	}
	public void setB04_0or1(int b04_0or1) {
		this.b04_0or1 = b04_0or1;
	}
	public int getB05_0or1() {
		return b05_0or1;
	}
	public void setB05_0or1(int b05_0or1) {
		this.b05_0or1 = b05_0or1;
	}
	public int getB06_0or1() {
		return b06_0or1;
	}
	public void setB06_0or1(int b06_0or1) {
		this.b06_0or1 = b06_0or1;
	}
	public int getB07_0or1() {
		return b07_0or1;
	}
	public void setB07_0or1(int b07_0or1) {
		this.b07_0or1 = b07_0or1;
	}
	public int getB08_0or1() {
		return b08_0or1;
	}
	public void setB08_0or1(int b08_0or1) {
		this.b08_0or1 = b08_0or1;
	}
	public int getB09_0or1() {
		return b09_0or1;
	}
	public void setB09_0or1(int b09_0or1) {
		this.b09_0or1 = b09_0or1;
	}
	public int getB10_0or1() {
		return b10_0or1;
	}
	public void setB10_0or1(int b10_0or1) {
		this.b10_0or1 = b10_0or1;
	}
	public int getC01_0or1() {
		return c01_0or1;
	}
	public void setC01_0or1(int c01_0or1) {
		this.c01_0or1 = c01_0or1;
	}
	public int getC02_0or1() {
		return c02_0or1;
	}
	public void setC02_0or1(int c02_0or1) {
		this.c02_0or1 = c02_0or1;
	}
	public int getC03_0or1() {
		return c03_0or1;
	}
	public void setC03_0or1(int c03_0or1) {
		this.c03_0or1 = c03_0or1;
	}
	public int getC04_0or1() {
		return c04_0or1;
	}
	public void setC04_0or1(int c04_0or1) {
		this.c04_0or1 = c04_0or1;
	}
	public int getC05_0or1() {
		return c05_0or1;
	}
	public void setC05_0or1(int c05_0or1) {
		this.c05_0or1 = c05_0or1;
	}
	public int getC06_0or1() {
		return c06_0or1;
	}
	public void setC06_0or1(int c06_0or1) {
		this.c06_0or1 = c06_0or1;
	}





}
