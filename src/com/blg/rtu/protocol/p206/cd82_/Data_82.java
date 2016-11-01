package com.blg.rtu.protocol.p206.cd82_;

public class Data_82 {
	
	/*
	 *  00B 时遥测终端在兼容工作状态；
	 *  01B 时遥测终端在自报工作状态；
	 *  02B 时遥测终端在查询/应答工作状态；
	 *  03B 时遥测终端在调试/维修状态。
	 */
	private Integer mode ;//
	
	public String toString(){
		String s = "\n遥测终端工作状态： " + (mode==0?"兼容工作状态":(mode==1?"自报工作状态":(mode==2?"查询/应答工作状态":(mode==3?"调试/维修状态":"")))) + "\n" ;
		return s ;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}


}
