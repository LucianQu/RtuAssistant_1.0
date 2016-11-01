package com.blg.rtu.protocol.p206.cdD8;

import java.io.Serializable;


public class Param_D8 implements Serializable{
	
	private static final long serialVersionUID = 20140924005700123L;

	public static final String KEY = Param_D8.class.getName() ;


	private Integer type_1Or2 ;//1:10位 AD值  ; 2: 24位AD值
	private Integer channel_0to3 ;//取值0--3
	
	private Double value_0to99d99 ;//校准系数
	

	public String toString(){
		String s = "\n" ;
		s += "AD校准命令：" + "\n" +
		" 类型：" + (type_1Or2.intValue() == 1?"10位 AD值":"24位AD值")+ "\n" + 
		" 通道：" + channel_0to3+ "\n" + 
		" 校准系数：" + value_0to99d99 + "\n" ;
		return s ;
	}


	public Integer getType_1Or2() {
		return type_1Or2;
	}


	public void setType_1Or2(Integer type_1Or2) {
		this.type_1Or2 = type_1Or2;
	}


	public Integer getChannel_0to3() {
		return channel_0to3;
	}


	public void setChannel_0to3(Integer channel_0to3) {
		this.channel_0to3 = channel_0to3;
	}


	public Double getValue_0to99d99() {
		return value_0to99d99;
	}


	public void setValue_0to99d99(Double value_0to99d99) {
		this.value_0to99d99 = value_0to99d99;
	}

}
