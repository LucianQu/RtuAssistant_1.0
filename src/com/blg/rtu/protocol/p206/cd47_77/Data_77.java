package com.blg.rtu.protocol.p206.cd47_77;

public class Data_77 {
	
	//private String password ;
	private int loraChannel ;
	private Long waterMinus ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	
	public String toString(){
		String s = "\n设置负积流量\n" ;
		//s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.loraChannel ;
		s += "负积流量" + "=" + (this.waterMinus==null?"":this.waterMinus.intValue()) + "(立方米)\n" ;
		return s ;
	}
	
	public int getLoraChannel() {
		return loraChannel ;
	}
	
	public void setLoraChannel(int loraChannel) {
		this.loraChannel = loraChannel ;
	}
	
	public Long getWaterMinus() {
		return waterMinus;
	}

	public void setWaterMinus(Long waterMinus) {
		this.waterMinus = waterMinus;
	}

}
