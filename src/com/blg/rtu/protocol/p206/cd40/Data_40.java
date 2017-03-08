package com.blg.rtu.protocol.p206.cd40;

public class Data_40 {
	
	private String password ;
	private int loraChannel1to8 ;
	private Double waterPure999999999 ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	
	public String toString(){
		String s = "\n设置净积流量\n" ;
		s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.loraChannel1to8 ;
		s += "净积流量" + "=" + (this.waterPure999999999==null?"":this.waterPure999999999.intValue()) + "(立方米)\n" ;
		return s ;
	}
	
	public String getPassword () {
		return password ;
	}
	
	public void setPassword(String password) {
		this.password = password ;
	}
	
	public int getLoraChannel() {
		return loraChannel1to8 ;
	}
	
	public void setLoraChannel(int loraChannel) {
		this.loraChannel1to8 = loraChannel ;
	}
	
	public Double getWaterPure() {
		return waterPure999999999;
	}

	public void setWaterPure(Double waterPure) {
		this.waterPure999999999 = waterPure;
	}

}
