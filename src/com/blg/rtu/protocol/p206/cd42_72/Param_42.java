package com.blg.rtu.protocol.p206.cd42_72;

import java.io.Serializable;

public class Param_42 implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;

	public static final String KEY = Param_42.class.getName() ;
	
	protected Integer modbusAddr ;//
	
	public String toString(){
		String s = "\nModBus地址：\n" ;
		s += "地址=" + modbusAddr + "\n" ;
		return s ;
	}

	public Integer getModBusAddr() {
		return modbusAddr;
	}

	public void setModBusAddr(Integer modbusAddr) {
		this.modbusAddr = modbusAddr;
	}



}
