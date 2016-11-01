package com.blg.rtu.protocol.p206.cd1C_60;

import java.io.Serializable;

public class Param_1C implements Serializable{
	
	private static final long serialVersionUID = 201212051625L;

	public static final String KEY = Param_1C.class.getName() ;
	
	protected Integer yinDaoMaChang_0to255 ;//终端站转发中继引导码长
	
	public String toString(){
		String s = "\n终端站转发中继引导码长：\n" ;
		s += "yinDaoMaChang_0to255" + "=" + (this.yinDaoMaChang_0to255==null?"":this.yinDaoMaChang_0to255.intValue()) + " \n" ;
		return s ;
	}

	public Integer getYinDaoMaChang_0to255() {
		return yinDaoMaChang_0to255;
	}

	public void setYinDaoMaChang_0to255(Integer yinDaoMaChang_0to255) {
		this.yinDaoMaChang_0to255 = yinDaoMaChang_0to255;
	}


}
