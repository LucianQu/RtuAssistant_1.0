package com.blg.rtu.protocol.p206.cdCB_DB;

import java.io.Serializable;


public class Param_DB implements Serializable{
	
	private static final long serialVersionUID = 201409232122002L;

	public static final String KEY = Param_DB.class.getName() ;


	//01B代表GPRS通讯方式，10B代表GSM通讯方式，11B代表北斗卫星通讯方式，00B 为无
	
	public static final int none = 0 ;//无
	public static final int gprs = 1 ;//GPRS通讯方式
	public static final int gsm = 2 ;//GSM通讯方式
	public static final int sate = 3 ;//卫星通讯方式
	

	private Integer chMain_0to3 ;
	private Integer chAssi1_0to3 ;
	private Integer chAssi2_0to3 ;

	public String toString(){
		String s = "\n" ;
		s += "主通道" + "=" + (this.chMain_0to3==null?"":
			this.chMain_0to3.intValue()==none?"GPRS通道":
				this.chMain_0to3.intValue()==gsm?"GSM通道":
					this.chMain_0to3.intValue()==sate?"卫星通道":
							"出错，未知"
			) ;
		s += "备用通道1" + "=" + (this.chAssi1_0to3==null?"":
			this.chAssi1_0to3.intValue()==none?"GPRS通道":
				this.chAssi1_0to3.intValue()==gsm?"GSM通道":
					this.chAssi1_0to3.intValue()==sate?"卫星通道":
							"出错，未知"
			) ;
		s += "备用通道2" + "=" + (this.chAssi2_0to3==null?"":
			this.chAssi2_0to3.intValue()==none?"GPRS通道":
				this.chAssi2_0to3.intValue()==gsm?"GSM通道":
					this.chAssi2_0to3.intValue()==sate?"卫星通道":
							"出错，未知"
			) ;
		return s ;
	}

	public Integer getChMain_0to3() {
		return chMain_0to3;
	}

	public void setChMain_0to3(Integer chMain_0to3) {
		this.chMain_0to3 = chMain_0to3;
	}

	public Integer getChAssi1_0to3() {
		return chAssi1_0to3;
	}

	public void setChAssi1_0to3(Integer chAssi1_0to3) {
		this.chAssi1_0to3 = chAssi1_0to3;
	}

	public Integer getChAssi2_0to3() {
		return chAssi2_0to3;
	}

	public void setChAssi2_0to3(Integer chAssi2_0to3) {
		this.chAssi2_0to3 = chAssi2_0to3;
	}


}
