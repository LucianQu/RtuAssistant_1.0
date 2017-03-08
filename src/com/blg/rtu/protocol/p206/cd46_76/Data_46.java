package com.blg.rtu.protocol.p206.cd46_76;

public class Data_46 {
	
	private String password ;
	private int loraChannel1to8 ;
	private Long waterPlus999999999 ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	
	public String toString(){
		String s = "\n设置正积流量\n" ;
		s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.loraChannel1to8 ;
		s += "正积流量" + "=" + (this.waterPlus999999999==null?"":this.waterPlus999999999.intValue()) + "(立方米)\n" ;
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
	
	public Long getWaterPlus() {
		return waterPlus999999999;
	}

	public void setWaterPlus(Long waterPlus) {
		this.waterPlus999999999 = waterPlus;
	}

}
