package com.blg.rtu.protocol.p206.common.data;

public class Data_waterAmount {
	
	protected Double waterAmount ; 

	public String toString(){
		String s = "\n流量 : " + (this.waterAmount==null?"":this.waterAmount.doubleValue()) + "(立方米/小时)\n" ;
		return s ;
	}

	public Double getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(
			Double waterAmount) {
		this.waterAmount = waterAmount;
	}



}
