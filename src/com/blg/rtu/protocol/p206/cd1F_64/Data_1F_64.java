package com.blg.rtu.protocol.p206.cd1F_64;

public class Data_1F_64 {

	private Double waterAmountParamUpLimit ;//流量参数上限值  -999999.999～+999999.999

	public String toString(){
		String s = "\n流量参数上限值 ：\n" ;
		s += "上限值" + "=" + (this.waterAmountParamUpLimit==null?"":this.waterAmountParamUpLimit.doubleValue()) + "(立方米/小时)\n" ;
		return s ;
	}

	public Double getWaterAmountParamUpLimit() {
		return waterAmountParamUpLimit;
	}

	public void setWaterAmountParamUpLimit(
			Double waterAmountParamUpLimit) {
		this.waterAmountParamUpLimit = waterAmountParamUpLimit;
	}

}
