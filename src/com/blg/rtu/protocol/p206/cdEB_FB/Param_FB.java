package com.blg.rtu.protocol.p206.cdEB_FB;

import java.io.Serializable;


public class Param_FB implements Serializable{
	
	private static final long serialVersionUID = 2012120215300234L;

	public static final String KEY = Param_FB.class.getName() ;


	//0 为实测值， 1 为水位高程， 2 为水深， 3 为水位埋深
	public static final int realValue = 0 ; 
	public static final int rangeValue = 1 ; 
	public static final int deepValue = 2 ; 
	public static final int buryValue = 3 ; 
	
	private Integer value_0to3 ;

	public String toString(){
		String s = "\n" ;
		s += "DTU model" + "=" + (this.value_0to3==null?"":
			this.value_0to3.intValue()==realValue?"实测值":
				this.value_0to3.intValue()==rangeValue?"水位高程":
					this.value_0to3.intValue()==deepValue?"水深":
						this.value_0to3.intValue()==buryValue?"水位埋深":
							"出错，未知的DTU工作模式"
			) ;
		return s ;
	}

	public Integer getValue_0to3() {
		return value_0to3;
	}

	public void setValue_0to3(Integer value_0to3) {
		this.value_0to3 = value_0to3;
	}

}
