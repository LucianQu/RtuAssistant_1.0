package com.blg.rtu.protocol.p206.cd46_76;

public class Data_76 {
	
	//private String password ;
	private int plusNum ;
	private Long waterPlus ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	public String valueError ;
	public String toString(){
		String s = "\n设置正积流量\n" ;
		//s += "密码" + "=" + (this.password==null?"":this.password) ;
		s += "Lora通道" + "=" + this.plusNum ;
		s += "正积流量" + "=" + (this.waterPlus==null? valueError :this.waterPlus.intValue()) + "(立方米)\n" ;
		return s ;
	}
	
	public int getPlusNum() {
		return plusNum ;
	}
	
	public void setPlusNum(int plusNum) {
		this.plusNum = plusNum ;
	}
	
	public Long getWaterPlus() {
		return waterPlus;
	}

	public void setWaterPlus(Long waterPlus) {
		this.waterPlus = waterPlus;
	}

}
