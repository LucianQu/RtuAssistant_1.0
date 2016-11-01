package com.blg.rtu.protocol.p206.cd34;

public class Data_34 {

	private Long bindValue ;// 定值

	public String toString(){
		String s = super.toString() ;
		s += "\n定值： " + (this.bindValue==null?"":this.bindValue.longValue()) + "\n" ;
		return s ;
	}

	public Long getBindValue() {
		return bindValue;
	}

	public void setBindValue(
			Long bindValue) {
		this.bindValue = bindValue;
	}

}
