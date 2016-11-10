package com.blg.rtu.protocol.p206.cdC4;

import java.io.Serializable;

import com.blg.rtu.protocol.p206.cdA0_54.Param_A0;

public class Param_C4 implements Serializable{
	
	private static final long serialVersionUID = 201611041456001L;
	
	public static final String KEY = Param_C4.class.getName() ;
	private Double waterInstant_n999999d999to999999d999 ;//流量参数上限值  -999999.999～+999999.999
	private Long waterConsumption_0to7999999999;

	public String toString(){
		String s = super.toString() ;
		s += "\n人工置数 ：\n" ;
		s += "瞬时流量" + "=" + (this.waterInstant_n999999d999to999999d999==null?"":this.waterInstant_n999999d999to999999d999.doubleValue()) + "(立方米/小时)\n" ;
		s += "累计水量" + "=" + (this.waterConsumption_0to7999999999==null?"":this.waterConsumption_0to7999999999.longValue()) + "(立方米)\n" ;
		return s ;
	}

	public Double getWaterInstant_n999999d999to999999d999() {
		return waterInstant_n999999d999to999999d999;
	}

	public void setWaterInstant_n999999d999to999999d999(
			Double waterInstant_n999999d999to999999d999) {
		this.waterInstant_n999999d999to999999d999 = waterInstant_n999999d999to999999d999;
	}
	public Long getWaterConsumption_0to7999999999() {
		return waterConsumption_0to7999999999;
	}

	public void setWaterConsumption_0to7999999999(
			Long waterConsumption_0to7999999999) {
		this.waterConsumption_0to7999999999 = waterConsumption_0to7999999999;
	}

	


}
