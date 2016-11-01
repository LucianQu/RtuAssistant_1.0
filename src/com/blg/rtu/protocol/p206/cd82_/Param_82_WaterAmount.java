package com.blg.rtu.protocol.p206.cd82_;

public class Param_82_WaterAmount {
	
	private Long value_0to7999999999 ;
	
	public String toString(){
		String s = "\n" ;
		s += "累计水量:" + this.value_0to7999999999 ;
		return s ;
	}

	public Long getValue_0to7999999999() {
		return value_0to7999999999;
	}

	public void setValue_0to7999999999(Long value_0to7999999999) {
		this.value_0to7999999999 = value_0to7999999999;
	}
}
