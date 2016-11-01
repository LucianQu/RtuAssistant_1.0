package com.blg.rtu.protocol.p206.cd1B;

public class Data_1B{
	

	private Long initWaterAmount ;//表底值(0至9999999999)

	public String toString(){
		String s = super.toString() ;
		s += "\n表底值：\n" ;
		s += "表底值" + "=" + (this.initWaterAmount==null?"":this.initWaterAmount.longValue()) + "(立方米)\n" ;
		return s ;
	}

	public Long getInitWaterAmount() {
		return initWaterAmount;
	}

	public void setInitWaterAmount(
			Long initWaterAmount) {
		this.initWaterAmount = initWaterAmount;
	}


}
