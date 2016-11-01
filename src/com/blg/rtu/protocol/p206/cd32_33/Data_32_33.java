package com.blg.rtu.protocol.p206.cd32_33;

public class Data_32_33 {

	private Boolean setOk ;

	public String toString(){
		String s = "\n设置结果：" ;
		s +=  (this.setOk==null?"":this.setOk.booleanValue()?"成功":"未知") + " \n" ;
		return s ;
	}

	public Boolean isSetOk() {
		return setOk;
	}

	public void setSetOk(Boolean setOk) {
		this.setOk = setOk;
	}
	
	
}
