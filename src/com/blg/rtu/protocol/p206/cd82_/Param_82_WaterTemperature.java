package com.blg.rtu.protocol.p206.cd82_;

import java.io.Serializable;

public class Param_82_WaterTemperature implements Serializable{

	private static final long serialVersionUID = 201410202125002L;

	public static final String KEY = Param_82_WaterTemperature.class.getName() ;

	private Double value_0to99d9 ;
	
	public String toString(){
		String s = "\n" ;
		s += "水温:" + this.value_0to99d9 ;
		return s ;
	}

	public Double getValue_0to99d9() {
		return value_0to99d9;
	}

	public void setValue_0to99d9(Double value_0to99d9) {
		this.value_0to99d9 = value_0to99d9;
	}

}
