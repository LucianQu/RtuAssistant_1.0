package com.blg.rtu.protocol.p206.cd42_72;

public class Data_42_72 {
	
	public static final String KEY = Param_42.class.getName() ;
	
	protected Integer modbusAddr ;// 
	
	public String toString(){
		String s = "\nModBus地址：\n" ;
		s += "地址=" + modbusAddr + "\n" ;
		return s ;
	}

	public Integer getModbusAddr() {
		return modbusAddr;
	}

	public void setModbusAddr(Integer modbusAddr) {
		this.modbusAddr = modbusAddr;
	}



}
