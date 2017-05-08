package com.blg.rtu.protocol.p206.cd40_70;

public class Data_70 {
	
	//private String password ;
	//private int minusNum ;
	private Long waterPure ;//瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	public String valueError ;
	
	public String toString(){
		String s = "\n设置净积流量\n" ;
		//s += "密码" + "=" + (this.password==null?"":this.password) ;
		//s += "Lora通道" + "=" + this.minusNum ;
		s += "净积流量" + "=" + (this.waterPure !=null ? this.waterPure.intValue() : valueError) + "(立方米)\n" ;
		return s ;
	}
	
/*	public int getMinusNum() {
		return minusNum ;
	}
	
	public void setMinusNum(int minusNum) {
		this.minusNum = minusNum ;
	}*/
	
	public Long getWaterPure() {
		return waterPure;
	}

	public void setWaterPure(Long waterPure) {
		this.waterPure = waterPure;
	}

}
