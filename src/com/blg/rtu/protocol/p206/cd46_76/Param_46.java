package com.blg.rtu.protocol.p206.cd46_76;

import java.io.Serializable;


public class Param_46 implements Serializable{
	
	private static final long serialVersionUID = 201410152325001L;
	
	public static final String KEY = Param_46.class.getName() ;
	
	private String password ;
	private int loraChannel ;
	private Long waterPure ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	
	public String toString(){
		String s = "\n设置正积流量\n" ;
		s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.loraChannel ;
		s += "累计水量" + "=" + (this.waterPure==null?"":this.waterPure.intValue()) + "(立方米)\n" ;
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
	
	public Long getWaterPure() {
		return waterPure;
	}

	public void setWaterPure(Long waterPure) {
		this.waterPure = waterPure;
	}
}
