package com.blg.rtu.protocol.p206.cd3F_6F;

import java.io.Serializable;

public class Param_3F implements Serializable{
	
	private static final long serialVersionUID = 201705021149014L;

	public static final String KEY = Param_3F.class.getName() ;
	
	protected int pulseConstant ;//
	public String toString(){
		String s = "\n设置脉冲常数：\n" ;
		s += "脉冲常数=" + pulseConstant + "\n" ;
		return s ;
	}

	public int getPulseConstant() {
		return pulseConstant ;
	}
	public void setPulseConstant(int pulseConstant) {
		this.pulseConstant = pulseConstant ;
	}

}
