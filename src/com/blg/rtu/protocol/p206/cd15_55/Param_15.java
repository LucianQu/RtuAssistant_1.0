package com.blg.rtu.protocol.p206.cd15_55;

import java.io.Serializable;

public class Param_15 implements Serializable{
	
	private static final long serialVersionUID = 201212021530001L;

	public static final String KEY = Param_15.class.getName() ;
	
	protected Integer waterAmount_0to99999999 ;//充值水量(立方米)
	
	public String toString(){
		String s = "\n" ;
		s += "\n充值水量：\n" ;
		s += "waterAmount_0to99999999" + "=" + (this.waterAmount_0to99999999==null?"":this.waterAmount_0to99999999.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Integer getWaterAmount_0to99999999() {
		return waterAmount_0to99999999;
	}

	public void setWaterAmount_0to99999999(Integer waterAmount_0to99999999) {
		this.waterAmount_0to99999999 = waterAmount_0to99999999;
	}



}
