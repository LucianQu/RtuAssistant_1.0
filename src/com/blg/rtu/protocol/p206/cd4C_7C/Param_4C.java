package com.blg.rtu.protocol.p206.cd4C_7C;

import java.io.Serializable;

public class Param_4C implements Serializable{
	
	private static final long serialVersionUID = 201212021604001L;

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
