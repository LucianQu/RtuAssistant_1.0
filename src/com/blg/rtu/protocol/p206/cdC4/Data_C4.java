package com.blg.rtu.protocol.p206.cdC4;

public class Data_C4 {

	protected Long waterInstant ; //瞬时流量(-999999.999～+999999.999，单位为 m3/s)
	protected Long waterConsumption ; //累计水量(立方米,取值范围0～7999999999)
	
	public String toString(){
		String s = "\n流量人工置数：\n" ;
		s += "瞬时流量" + "=" + (this.waterInstant==null?"":this.waterInstant.intValue()) + "(m³/s)\n" ;
		s += "累计水量" + "=" + (this.waterConsumption==null?"":this.waterConsumption.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Long getWaterInstant() {
		return waterInstant;
	}

	public void setWaterInstant(Long waterInstant) {
		this.waterInstant = waterInstant;
	}
	public Long getWaterConsumption() {
		return waterConsumption;
	}

	public void setWaterConsumption(Long waterConsumption) {
		this.waterConsumption = waterConsumption;
	}
}
