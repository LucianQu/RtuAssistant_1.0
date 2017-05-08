package com.blg.rtu.protocol.p206.cd4C_7C;

public class Data_4C_7C {
	
	public static final String KEY = Param_4C.class.getName() ;
	
	protected Integer loraCollectTime ; 
	protected int loraCollectCycle ;//
	protected Integer loraTimeWinSet ;// 
	
	
	public String toString(){
		String s = "\nLORA窗口时间配置：\n" ;
		s += "Lora采集时间=" + loraCollectTime.intValue() + "\n" ;
		s += "Lora采集周期=" + loraCollectCycle + "\n" ;
		s += "配置值=" + loraTimeWinSet.intValue() + "\n" ;
		return s ;
	}

	public Integer getLoraCollectTime() {
		return loraCollectTime ;
	}
	public void setLoraCollectTime(Integer loraCollectTime) {
		this.loraCollectTime = loraCollectTime ;
	}
	
	public int getLoraCollectCycle() {
		return loraCollectCycle ;
	}
	public void setLoraCollectCycle(int loraCollectCycle) {
		this.loraCollectCycle = loraCollectCycle ;
	}
	
	public Integer getLoraTimeWinSet() {
		return loraTimeWinSet;
	}

	public void setLoraTimeWinSet(Integer loraTimeWinSet) {
		this.loraTimeWinSet = loraTimeWinSet;
	}

}
