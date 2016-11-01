package com.blg.rtu.protocol.p206.cd1C_60;

public class Data_1C_60 {
	
	protected Integer yinDaoMaChang ;//终端站转发中继引导码长
	
	public String toString(){
		String s = "\n终端站转发中继引导码长：\n" ;
		s += "yinDaoMaChang" + "=" + (this.yinDaoMaChang==null?"":this.yinDaoMaChang.intValue()) + " \n" ;
		return s ;
	}

	public Integer getYinDaoMaChang() {
		return yinDaoMaChang;
	}

	public void setYinDaoMaChang(Integer yinDaoMaChang) {
		this.yinDaoMaChang = yinDaoMaChang;
	}

}
