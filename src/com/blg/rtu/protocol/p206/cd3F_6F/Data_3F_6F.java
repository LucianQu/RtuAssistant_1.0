package com.blg.rtu.protocol.p206.cd3F_6F;

public class Data_3F_6F {

	protected int pulseConstant ;//
	public String toString(){
		String s = "\n查询脉冲常数：\n" ;
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
