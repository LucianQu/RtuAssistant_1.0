package com.blg.rtu.protocol.p206.cd18_58;

public class Data_58 {

	protected Double waterPressUpLimit ;//水压上限(KPa)
	protected Double waterPressDownLimit ;//水压下限(KPa)
	
	public String toString(){
		String s = "\n查询水压上下限：\n" ;
		s += "水压上限" + "=" + (this.waterPressUpLimit==null?"":this.waterPressUpLimit.doubleValue()) + "(kpa)\n" ;
		s += "水压下限" + "=" + (this.waterPressDownLimit==null?"":this.waterPressDownLimit.doubleValue()) + "(kpa)\n" ;
		return s ;
	}

	public Double getWaterPressUpLimit() {
		return waterPressUpLimit;
	}

	public void setWaterPressUpLimit(Double waterPressUpLimit) {
		this.waterPressUpLimit = waterPressUpLimit;
	}

	public Double getWaterPressDownLimit() {
		return waterPressDownLimit;
	}

	public void setWaterPressDownLimit(Double waterLevelDownLimit) {
		this.waterPressDownLimit = waterLevelDownLimit;
	}

}
