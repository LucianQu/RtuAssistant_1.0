package com.blg.rtu.protocol.p206.cd30_31;

public class Data_30_31 {

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
