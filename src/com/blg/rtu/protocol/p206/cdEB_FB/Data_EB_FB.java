package com.blg.rtu.protocol.p206.cdEB_FB;


public class Data_EB_FB {
	

	//0 为实测值， 1 为水位高程， 2 为水深， 3 为水位埋深
	public static final int realValue = 0 ; 
	public static final int rangeValue = 1 ; 
	public static final int deepValue = 2 ; 
	public static final int buryValue = 3 ; 
	
	private Integer value ;

	public String toString(){
		String s = "\n" ;
		s += "DTU model" + "=" + (this.value==null?"":
			this.value.intValue()==realValue?"实测值":
				this.value.intValue()==rangeValue?"水位高程":
					this.value.intValue()==deepValue?"水深":
						this.value.intValue()==buryValue?"水位埋深":
							"出错，未知的DTU工作模式"
			) ;
		return s ;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
