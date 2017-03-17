package com.blg.rtu.protocol.p206.cd4D;


public class Data_4D {
	
	private Integer enable_1 ;

	public String toString(){
		String s = "\n" ;
		s += "Lora电源控制命令：" + "\n" +
		" 命令内容：" + (enable_1.intValue() == 1?"开启":"关闭") ;
		return s ;
	}

	public Integer getEnable_1() {
		return enable_1;
	}

	public void setEnable_1(Integer enable_1) {
		this.enable_1 = enable_1;
	}
	
}
