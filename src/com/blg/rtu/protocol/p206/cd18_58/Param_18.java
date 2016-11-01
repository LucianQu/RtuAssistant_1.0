package com.blg.rtu.protocol.p206.cd18_58;

import java.io.Serializable;


public class Param_18 implements Serializable{
	
	private static final long serialVersionUID = 201212021743001L;

	protected Double waterPressUpLimit_0to999999d99 ;//水压上限 (KPa)
	protected Double waterPressDownLimit_0to999999d99 ;//水压下限 (KPa)
	
	public String toString(){
		String s = "\n设置水压上下限：\n" ;
		s += "水压上限" + "=" + (this.waterPressUpLimit_0to999999d99==null?"":this.waterPressUpLimit_0to999999d99.doubleValue()) + "(米)\n" ;
		s += "水压下限" + "=" + (this.waterPressDownLimit_0to999999d99==null?"":this.waterPressDownLimit_0to999999d99.doubleValue()) + "(米)\n" ;
		return s ;
	}


	public Double getWaterPressUpLimit_0to999999d99() {
		return waterPressUpLimit_0to999999d99;
	}

	public void setWaterPressUpLimit_0to999999d99(Double waterLevelUpLimit_0to99d99) {
		this.waterPressUpLimit_0to999999d99 = waterLevelUpLimit_0to99d99;
	}

	public Double getWaterPressDownLimit_0to999999d99() {
		return waterPressDownLimit_0to999999d99;
	}

	public void setWaterPressDownLimit_0to999999d99(Double waterLevelDownLimit_0to99d99) {
		this.waterPressDownLimit_0to999999d99 = waterLevelDownLimit_0to99d99;
	}



}
