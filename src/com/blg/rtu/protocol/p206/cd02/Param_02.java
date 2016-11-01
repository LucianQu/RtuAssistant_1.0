package com.blg.rtu.protocol.p206.cd02;

import java.io.Serializable;


public class Param_02 implements Serializable{
	
	private static final long serialVersionUID = 20121129215801201L;

	public static final String KEY = Param_02.class.getName() ;

	public static final Integer type_F0 = 0xF0 ; ;
	public static final Integer type_F1 = 0xF1 ; ;
	public static final Integer type_F2 = 0xF2 ; ;

	private Integer type ;//。数据域：F0 登录，F1 退出登录，F2 在线保持。

	public String toString(){
		String s = "\n" ;
		s += "type" + "=" + (this.type==null?"":this.type) ;
		return s ;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

}
