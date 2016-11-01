package com.blg.rtu.protocol.p206.common.data;

public class Data_waterLevel {
	
	protected Double waterLevel ; 

	public String toString(){
		String s = "\n水位: " + (this.waterLevel==null?"":this.waterLevel.doubleValue()) + "(米)\n" ;
		return s ;
	}

	public Double getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(
			Double waterLevel) {
		this.waterLevel = waterLevel;
	}

}
