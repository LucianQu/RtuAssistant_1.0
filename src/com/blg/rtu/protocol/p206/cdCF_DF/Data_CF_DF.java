package com.blg.rtu.protocol.p206.cdCF_DF;


public class Data_CF_DF {
	
	//DTU 工作模式： 0代表永远在线，1代表唤醒模式，2定时上线模式
	
	public static final int modelForever = 0 ;//永远在线模式
	public static final int modelWake = 1 ;//唤醒模式
	public static final int modelTiming = 2 ;//定时上线

	private Integer model ;

	public String toString(){
		String s = "\n" ;
		s += "model" + "=" + (this.model==null?"":
			this.model.intValue()==0?"永远在线模式":
				this.model.intValue()==1?"唤醒模式":
					this.model.intValue()==2?"定时上线":
							"出错，未知的DTU工作模式"
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
