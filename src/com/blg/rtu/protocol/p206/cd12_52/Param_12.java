package com.blg.rtu.protocol.p206.cd12_52;

import java.io.Serializable;


public class Param_12 implements Serializable{
	
	private static final long serialVersionUID = 2012120215300234L;

	public static final String KEY = Param_12.class.getName() ;

	/*
	工作模式类型=00B，设置遥测终端在兼容工作状态；
	工作模式类型=01B，设置遥测终端在自报工作状态；
	工作模式类型=02B，设置遥测终端在查询/应答工作状态；
	工作模式类型=03B，遥测终端在调试/维修状态。
	*/
	
	public static final int modelCompatible = 0 ;//工作模式类型=00B，设置遥测终端在兼容工作状态；
	public static final int modelAutoReport = 1 ;//工作模式类型=01B，设置遥测终端在自报工作状态；
	public static final int modelReadAnswer = 2 ;//工作模式类型=02B，设置遥测终端在查询/应答工作状态；
	public static final int modelDebug = 3 ;//工作模式类型=03B，遥测终端在调试/维修状态。
	

	private Integer model_0to3 ;

	public String toString(){
		String s = "\n" ;
		s += "model" + "=" + (this.model_0to3==null?"":
			this.model_0to3.intValue()==modelCompatible?"兼容工作状态":
				this.model_0to3.intValue()==modelAutoReport?"自报工作状态":
					this.model_0to3.intValue()==modelReadAnswer?"查询/应答工作状态":
						this.model_0to3.intValue()==modelDebug?"调试/维修状态":
							"出错，未知的RTU工作模式"
			) ;
		return s ;
	}

	public Integer getModel_0to3() {
		return model_0to3;
	}

	public void setModel_0to3(Integer model_0to2) {
		this.model_0to3 = model_0to2;
	}

}
