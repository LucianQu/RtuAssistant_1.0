package com.blg.rtu.protocol.p206.cd17_57;

public class Data_17_57 {

	protected Double waterLevelBase ;//水位基值(米，范围-7999.99～7999.99，)
	protected Double waterLevelUpLimit ;//水位上限(米，范围0～99.99)
	protected Double waterLevelDownLimit ;//水位下限(米，范围0～99.99)
	
	public String toString(){
		String s = "\n水位基值、水位上下限：\n" ;
		s += "水位基值" + "=" + (this.waterLevelBase==null?"":this.waterLevelBase.doubleValue()) + "(米)\n" ;
		s += "水位上限" + "=" + (this.waterLevelUpLimit==null?"":this.waterLevelUpLimit.doubleValue()) + "(米)\n" ;
		s += "水位下限" + "=" + (this.waterLevelDownLimit==null?"":this.waterLevelDownLimit.doubleValue()) + "(米)\n" ;
		return s ;
	}

	public Double getWaterLevelBase() {
		return waterLevelBase;
	}

	public void setWaterLevelBase(Double waterLevelBase) {
		this.waterLevelBase = waterLevelBase;
	}

	public Double getWaterLevelUpLimit() {
		return waterLevelUpLimit;
	}

	public void setWaterLevelUpLimit(Double waterLevelUpLimit) {
		this.waterLevelUpLimit = waterLevelUpLimit;
	}

	public Double getWaterLevelDownLimit() {
		return waterLevelDownLimit;
	}

	public void setWaterLevelDownLimit(Double waterLevelDownLimit) {
		this.waterLevelDownLimit = waterLevelDownLimit;
	}

}
