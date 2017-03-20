package com.blg.rtu.protocol.p206.cd40;

import java.io.Serializable;


public class Param_40 implements Serializable{
	
	private static final long serialVersionUID = 201703201149001L;
	
	public static final String KEY = Param_40.class.getName() ;
	
	private String password ;
	private int loraChannel ;
	private Double waterPure ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	
	public String toString(){
		String s = "\n设置净积流量\n" ;
		s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.loraChannel ;
		s += "净积流量" + "=" + (this.waterPure==null?"":this.waterPure.intValue()) + "(立方米)\n" ;
		return s ;
	}
	
	public String getPassword () {
		return password ;
	}
	
	public void setPassword(String password) {
		this.password = password ;
	}
	
	public int getLoraChannel() {
		return loraChannel ;
	}
	
	public void setLoraChannel(int loraChannel) {
		this.loraChannel = loraChannel ;
	}
	
	public Double getWaterPure() {
		return waterPure;
	}

	public void setWaterPure(Double waterPure) {
		this.waterPure = waterPure;
	}
}
