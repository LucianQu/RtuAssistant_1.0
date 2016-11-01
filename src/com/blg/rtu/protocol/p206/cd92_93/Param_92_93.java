package com.blg.rtu.protocol.p206.cd92_93;

import java.io.Serializable;

public class Param_92_93 implements Serializable{

	private static final long serialVersionUID = 201212061816001L;

	public static final String KEY = Param_92_93.class.getName() ;

	public static final Integer pumpDevice = 0 ;//水泵
	public static final Integer gateDevice = 15 ;//阀门/闸门
	

	private Integer num_0to15 ;// 水泵或阀门/闸门编码
	
	private Integer device_0or15 ;//类型 ;
	

	public String toString(){
		String s = "\n遥控(启动或关闭)水泵或阀门/闸门： " + (device_0or15==null?"":(device_0or15==pumpDevice?"水泵":(device_0or15==gateDevice?"阀门|闸门":""))) + "\n" ;
		s += "编号：" + num_0to15 ;
		return s ;
	}

	public Integer getNum_0to15() {
		return num_0to15;
	}

	public void setNum_0to15(Integer num) {
		this.num_0to15 = num;
	}

	public Integer getDevice_0or15() {
		return device_0or15;
	}

	public void setDevice_0or15(Integer device) {
		this.device_0or15 = device;
	}

}
