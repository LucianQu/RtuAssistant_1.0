package com.blg.rtu.protocol.p206.cd4E;


public class Data_4E {
	
	private Integer enable_1 ;

	public String toString(){
		String s = "\n" ;
		s += "出厂启用命令：" + "\n" +
		" 命令：" + (enable_1.intValue() == 1?"出厂启用":"取消出厂启用") ;
		return s ;
	}

	public Integer getEnable_1() {
		return enable_1;
	}

	public void setEnable_1(Integer enable_1) {
		this.enable_1 = enable_1;
	}
	
}
