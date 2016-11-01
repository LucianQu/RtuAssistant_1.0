package com.blg.rtu.protocol.p206.cd1F_64;

import java.io.Serializable;

public class Param_1F implements Serializable{
	
	private static final long serialVersionUID = 201212031600001L;

	private Double waterAmountParamUpLimit_n999999d999to999999d999 ;//流量参数上限值  -999999.999～+999999.999

	public String toString(){
		String s = super.toString() ;
		s += "\n设置流量参数上限值 ：\n" ;
		s += "上限值" + "=" + (this.waterAmountParamUpLimit_n999999d999to999999d999==null?"":this.waterAmountParamUpLimit_n999999d999to999999d999.doubleValue()) + "(立方米/小时)\n" ;
		return s ;
	}

	public Double getWaterAmountParamUpLimit_n999999d999to999999d999() {
		return waterAmountParamUpLimit_n999999d999to999999d999;
	}

	public void setWaterAmountParamUpLimit_n999999d999to999999d999(
			Double waterAmountUpLimitN999999d999to999999d999) {
		waterAmountParamUpLimit_n999999d999to999999d999 = waterAmountUpLimitN999999d999to999999d999;
	}

	


}
