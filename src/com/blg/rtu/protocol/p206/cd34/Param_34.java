package com.blg.rtu.protocol.p206.cd34;

import java.io.Serializable;

public class Param_34 implements Serializable{

	private static final long serialVersionUID = 201212052150001L;

	public static final String KEY = Param_34.class.getName() ;

	private Long bindValue_0to9999999999 ;// 定值

	public String toString(){
		String s = super.toString() ;
		s += "\n定值： " + (this.bindValue_0to9999999999==null?"":this.bindValue_0to9999999999.longValue()) + "\n" ;
		return s ;
	}

	public Long getBindValue_0to9999999999() {
		return bindValue_0to9999999999;
	}

	public void setBindValue_0to9999999999(
			Long bindValue_0to9999999999) {
		this.bindValue_0to9999999999 = bindValue_0to9999999999;
	}

}
