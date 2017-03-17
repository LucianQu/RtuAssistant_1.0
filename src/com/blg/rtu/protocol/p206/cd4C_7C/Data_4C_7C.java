package com.blg.rtu.protocol.p206.cd4C_7C;

public class Data_4C_7C {
	
	public static final String KEY = Param_4C.class.getName() ;
	
	protected Integer loraTimeWinSet ;// 
	
	public String toString(){
		String s = "\nLORA窗口时间配置：\n" ;
		s += "配置值=" + loraTimeWinSet + "\n" ;
		return s ;
	}

	public Integer getLoraTimeWinSet() {
		return loraTimeWinSet;
	}

	public void setLoraTimeWinSet(Integer loraTimeWinSet) {
		this.loraTimeWinSet = loraTimeWinSet;
	}



}
