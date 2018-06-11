package com.blg.rtu.protocol.p206.cd97_98;

import java.io.Serializable;


public class Param_97 implements Serializable{
	
	private static final long serialVersionUID = 2012120215300234L;

	public static final String KEY = Param_97.class.getName() ;

	//命令设置： 0代表剩余流量和阀门控制不关联，1代表剩余流量和阀门控制关联
	public static final int modelNoRelev = 0 ;//不关联
	public static final int modelRelev = 1 ;//关联
	

	private Integer model_0to1 ;

	public String toString(){
		String s = "\n" ;
		s += "DTU model" + "=" + (this.model_0to1==null?"":
			this.model_0to1.intValue()==modelNoRelev?"剩余流量和阀门控制不关联":
				this.model_0to1.intValue()==modelRelev?"剩余流量和阀门控制关联":
							"出错，未知的关联状态"
			) ;
		return s ;
	}

	public Integer getModel_0to1() {
		return model_0to1;
	}

	public void setModel_0to1(Integer model_0to1) {
		this.model_0to1 = model_0to1;
	}

}
