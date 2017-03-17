package com.blg.rtu.protocol.p206.cd4B_7B;

import java.io.Serializable;

public class Param_4B implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;
	public static final String KEY = Param_4B.class.getName() ;
	
	public static final int triggerType0 = 0 ;//触发GSM测试
	public static final int triggerType1 = 1 ;//触发LORA测试
	private Integer triggerType ;// 

	public String toString(){
		String s = "\n一键触发：\n" ;
		s += "类型=" + triggerType + "\n" ;
		return s ;
	}

	public Integer getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(Integer triggerType) {
		this.triggerType = triggerType;
	}
}
