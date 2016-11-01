package com.blg.rtu.protocol.p206.cd17_57;

import java.io.Serializable;


public class Param_17 implements Serializable{
	
	private static final long serialVersionUID = 201212021618001L;
	
	protected Double waterLevelBase_n7999d99to7999d99;//水位基值(米，范围-7999.99～7999.99，)
	protected Double waterLevelUpLimit_0to99d99 ;//水位上限(米，范围0～99.99)
	protected Double waterLevelDownLimit_0to99d99 ;//水位下限(米，范围0～99.99)
	
	public String toString(){
		String s = "\n水位基值、水位上下限：\n" ;
		s += "水位基值" + "=" + (this.waterLevelBase_n7999d99to7999d99==null?"":this.waterLevelBase_n7999d99to7999d99.doubleValue()) + "(米)\n" ;
		s += "水位上限" + "=" + (this.waterLevelUpLimit_0to99d99==null?"":this.waterLevelUpLimit_0to99d99.doubleValue()) + "(米)\n" ;
		s += "水位下限" + "=" + (this.waterLevelDownLimit_0to99d99==null?"":this.waterLevelDownLimit_0to99d99.doubleValue()) + "(米)\n" ;
		return s ;
	}

	public Double getWaterLevelBase_n7999d99to7999d99() {
		return waterLevelBase_n7999d99to7999d99;
	}

	public void setWaterLevelBase_n7999d99to7999d99(
			Double waterLevelBaseN7999d99to7999d99) {
		waterLevelBase_n7999d99to7999d99 = waterLevelBaseN7999d99to7999d99;
	}

	public Double getWaterLevelUpLimit_0to99d99() {
		return waterLevelUpLimit_0to99d99;
	}

	public void setWaterLevelUpLimit_0to99d99(Double waterLevelUpLimit_0to99d99) {
		this.waterLevelUpLimit_0to99d99 = waterLevelUpLimit_0to99d99;
	}

	public Double getWaterLevelDownLimit_0to99d99() {
		return waterLevelDownLimit_0to99d99;
	}

	public void setWaterLevelDownLimit_0to99d99(Double waterLevelDownLimit_0to99d99) {
		this.waterLevelDownLimit_0to99d99 = waterLevelDownLimit_0to99d99;
	}



}
