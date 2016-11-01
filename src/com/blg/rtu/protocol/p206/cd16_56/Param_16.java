package com.blg.rtu.protocol.p206.cd16_56;

import java.io.Serializable;

public class Param_16 implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;

	public static final String KEY = Param_16.class.getName() ;
	
	protected Integer waterRemainAlarm_0to999999 ;//剩余水量报警值(立方米)
	
	public String toString(){
		String s = "\n剩余水量报警值：\n" ;
		s += "waterRemainAlarm_0to999999" + "=" + (this.waterRemainAlarm_0to999999==null?"":this.waterRemainAlarm_0to999999.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Integer getWaterRemainAlarm_0to999999() {
		return waterRemainAlarm_0to999999;
	}

	public void setWaterRemainAlarm_0to999999(Integer waterRemainAlarm_0to999999) {
		this.waterRemainAlarm_0to999999 = waterRemainAlarm_0to999999;
	}

}
