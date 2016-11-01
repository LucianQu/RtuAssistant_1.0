package com.blg.rtu.protocol.p206.cdCF_DF;

import java.io.Serializable;


public class Param_DF implements Serializable{
	
	private static final long serialVersionUID = 2012120215300234L;

	public static final String KEY = Param_DF.class.getName() ;


	//DTU 工作模式： 0代表永远在线，1代表唤醒模式，2定时上线模式
	
	public static final int modelForever = 0 ;//永远在线模式
	public static final int modelWake = 1 ;//唤醒模式
	public static final int modelTiming = 2 ;//定时上线
	

	private Integer model_0to2 ;

	public String toString(){
		String s = "\n" ;
		s += "DTU model" + "=" + (this.model_0to2==null?"":
			this.model_0to2.intValue()==modelForever?"永远在线模式":
				this.model_0to2.intValue()==modelWake?"唤醒模式":
					this.model_0to2.intValue()==modelTiming?"定时上线":
							"出错，未知的DTU工作模式"
			) ;
		return s ;
	}

	public Integer getModel_0to2() {
		return model_0to2;
	}

	public void setModel_0to2(Integer model_0to2) {
		this.model_0to2 = model_0to2;
	}

}
