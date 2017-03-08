package com.blg.rtu.protocol.p206.cd47_77;

public class Data_47 {
	
	private String password ;
	private int loraChannel1to8 ;
	private Long waterMinus999999999 ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	
	public String toString(){
		String s = "\n设置负积流量\n" ;
		s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.loraChannel1to8 ;
		s += "负积流量" + "=" + (this.waterMinus999999999==null?"":this.waterMinus999999999.intValue()) + "(立方米)\n" ;
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
	
	public Long getWaterMinus() {
		return waterMinus999999999;
	}

	public void setWaterMinus(Long waterMinus) {
		this.waterMinus999999999 = waterMinus;
	}

}
