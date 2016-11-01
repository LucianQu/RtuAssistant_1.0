package com.blg.rtu.protocol.p206.cdEC_FC;

public class Data_EC_FC {
	
	private int a01 ;//a1 设备复位及启动;  1为保存，0为不存
	private int a02 ;//a2 传感器运行状态;  1为保存，0为不存
	private int a03 ;//a3 电池供电状态;  1为保存，0为不存
	private int a04 ;//a4 电源供电状态 ;  1为保存，0为不存
	private int a05 ;//a5 开门状态;  1为保存，0为不存
	
	private int b01 ;//b1 数据初始化;  1为保存，0为不存
	private int b02 ;//b2 参数变更;  1为保存，0为不存
	private int b03 ;//b3 状态量变更;  1为保存，0为不存
	private int b04 ;//b4发报文记录  1为保存，0为不存
	private int b05 ;//b5收报文记录;  1为保存，0为不存
	private int b06 ;//b6 补报存储;  1为保存，0为不存
	private int b07 ;//b7 补报发送;  1为保存，0为不存
	private int b08 ;//b8时间校准;  1为保存，0为不存
	private int b09 ;//b9手持设备接入;  1为保存，0为不存
	private int b10 ;//b10 按键唤醒 ;  1为保存，0为不存
	
	private int c01 ;//c1密码错误记录;  1为保存，0为不存
	private int c02 ;//c2电池电压低告警记录;  1为保存，0为不存
	private int c03 ;//c3 传感器故障;  1为保存，0为不存
	private int c04 ;//c4水位超限告警记录 ;  1为保存，0为不存
	private int c05 ;//c5水质参数超限告警记录;  1为保存，0为不存
	private int c06 ;//c6 连接中心失败;  1为保存，0为不存
	
	
	public String toString(){
		String s = "" ; 
		s += "\n设备复位及启动: " + (a01==1?"保存":"不存") ;
		s += "\n传感器运行状态: " + (a02==1?"保存":"不存") ;
		s += "\n电池供电状态: " + (a03==1?"保存":"不存") ;
		s += "\n电源供电状态: " + (a04==1?"保存":"不存") ;
		s += "\n开门状态: " + (a05==1?"保存":"不存") ;
		
		s += "\n数据初始化: " + (b01==1?"保存":"不存") ;
		s += "\n参数变更: " + (b02==1?"保存":"不存") ;
		s += "\n状态量变更: " + (b03==1?"保存":"不存") ;
		s += "\n发报文记录: " + (b04==1?"保存":"不存") ;
		s += "\n收报文记录: " + (b05==1?"保存":"不存") ;
		s += "\n补报存储: " + (b06==1?"保存":"不存") ;
		s += "\n补报发送: " + (b07==1?"保存":"不存") ;
		s += "\n时间校准: " + (b08==1?"保存":"不存") ;
		s += "\n手持设备接入: " + (b09==1?"保存":"不存") ;
		s += "\n按键唤醒: " + (b10==1?"保存":"不存") ;
		
		s += "\n密码错误记录: " + (c01==1?"保存":"不存") ;
		s += "\n电池电压低告警记录: " + (c02==1?"保存":"不存") ;
		s += "\n传感器故障: " + (c03==1?"保存":"不存") ;
		s += "\n水位超限告警记录: " + (c04==1?"保存":"不存") ;
		s += "\n水质参数超限告警记录: " + (c05==1?"保存":"不存") ;
		s += "\n连接中心失败: " + (c06==1?"保存":"不存") ;
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


	public int getB01() {
		return b01;
	}


	public void setB01(int b01) {
		this.b01 = b01;
	}


	public int getB02() {
		return b02;
	}


	public void setB02(int b02) {
		this.b02 = b02;
	}


	public int getB03() {
		return b03;
	}


	public void setB03(int b03) {
		this.b03 = b03;
	}


	public int getB04() {
		return b04;
	}


	public void setB04(int b04) {
		this.b04 = b04;
	}


	public int getB05() {
		return b05;
	}


	public void setB05(int b05) {
		this.b05 = b05;
	}


	public int getB06() {
		return b06;
	}


	public void setB06(int b06) {
		this.b06 = b06;
	}


	public int getB07() {
		return b07;
	}


	public void setB07(int b07) {
		this.b07 = b07;
	}


	public int getB08() {
		return b08;
	}


	public void setB08(int b08) {
		this.b08 = b08;
	}


	public int getB09() {
		return b09;
	}


	public void setB09(int b09) {
		this.b09 = b09;
	}


	public int getB10() {
		return b10;
	}


	public void setB10(int b10) {
		this.b10 = b10;
	}


	public int getC01() {
		return c01;
	}


	public void setC01(int c01) {
		this.c01 = c01;
	}


	public int getC02() {
		return c02;
	}


	public void setC02(int c02) {
		this.c02 = c02;
	}


	public int getC03() {
		return c03;
	}


	public void setC03(int c03) {
		this.c03 = c03;
	}


	public int getC04() {
		return c04;
	}


	public void setC04(int c04) {
		this.c04 = c04;
	}


	public int getC05() {
		return c05;
	}


	public void setC05(int c05) {
		this.c05 = c05;
	}


	public int getC06() {
		return c06;
	}


	public void setC06(int c06) {
		this.c06 = c06;
	}
	
	
}
