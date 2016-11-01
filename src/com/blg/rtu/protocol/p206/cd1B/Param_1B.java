package com.blg.rtu.protocol.p206.cd1B;

import java.io.Serializable;

public class Param_1B implements Serializable{
	
	private static final long serialVersionUID = 201212021743001L;

	private Long initWaterAmount_0to7999999999 ;//表底值(0至7999999999)

	public String toString(){
		String s = super.toString() ;
		s += "\n设置表底值：\n" ;
		s += "表底值" + "=" + (this.initWaterAmount_0to7999999999==null?"":this.initWaterAmount_0to7999999999.longValue()) + "(立方米)\n" ;
		return s ;
	}

	public Long getInitWaterAmount_0to7999999999() {
		return initWaterAmount_0to7999999999;
	}

	public void setInitWaterAmount_0to7999999999(
			Long initWaterAmount_0to7999999999) {
		this.initWaterAmount_0to7999999999 = initWaterAmount_0to7999999999;
	}


}
