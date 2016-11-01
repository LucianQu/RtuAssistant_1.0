package com.blg.rtu.protocol.p206.cd12_52;


public class Data_12_52 {
	
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
	

	private Integer model ;

	public String toString(){
		String s = "\n" ;
		s += "model" + "=" + (this.model==null?"":
			this.model.intValue()==0?"兼容工作状态":
				this.model.intValue()==1?"自报工作状态":
					this.model.intValue()==2?"查询/应答工作状态":
						this.model.intValue()==3?"调试/维修状态":
							"出错，未知的RTU工作模式"
			) ;
		return s ;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}


}
