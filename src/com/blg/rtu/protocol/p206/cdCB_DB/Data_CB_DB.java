package com.blg.rtu.protocol.p206.cdCB_DB;


public class Data_CB_DB {
	
	//01B代表GPRS通讯方式，10B代表GSM通讯方式，11B代表北斗卫星通讯方式，00B 为无
	
	public static final int none = 0 ;//无
	public static final int gprs = 1 ;//GPRS通讯方式
	public static final int gsm = 2 ;//GSM通讯方式
	public static final int sate = 3 ;//卫星通讯方式
	

	private Integer chMain ;
	private Integer chAssi1 ;
	private Integer chAssi2 ;


	public String toString(){
		String s = "\n" ;
		s += "主通道" + "=" + (this.chMain==null?"":
			this.chMain.intValue()==none?"无":
				this.chMain.intValue()==gprs?"GPRS通道":
					this.chMain.intValue()==gsm?"GSM通道":
						this.chMain.intValue()==sate?"卫星通道":
							"出错，未知"
			) ;
		s += ", 备用通道1" + "=" + (this.chAssi1==null?"":
			this.chAssi1.intValue()==none?"无":
				this.chAssi1.intValue()==gprs?"GPRS通道":
					this.chAssi1.intValue()==gsm?"GSM通道":
						this.chAssi1.intValue()==sate?"卫星通道":
							"出错，未知"
			) ;
		s += ", 备用通道2" + "=" + (this.chAssi2==null?"":
			this.chAssi2.intValue()==none?"无":
				this.chAssi2.intValue()==gprs?"GPRS通道":
					this.chAssi2.intValue()==gsm?"GSM通道":
						this.chAssi2.intValue()==sate?"卫星通道":
							"出错，未知"
			) ;
		return s ;
	}


	public Integer getChMain() {
		return chMain;
	}


	public void setChMain(Integer chMain) {
		this.chMain = chMain;
	}


	public Integer getChAssi1() {
		return chAssi1;
	}


	public void setChAssi1(Integer chAssi1) {
		this.chAssi1 = chAssi1;
	}


	public Integer getChAssi2() {
		return chAssi2;
	}


	public void setChAssi2(Integer chAssi2) {
		this.chAssi2 = chAssi2;
	}

	
}
