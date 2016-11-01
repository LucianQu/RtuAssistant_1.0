package com.blg.rtu.protocol.p206.cd15_55;


public class Data_15 {
	
	protected Integer waterAmount ;//最后一次充值水量(立方米)
	
	public String toString(){
		String s = "\n" ;
		s += "\n设置遥测终端本次充值量：\n" ;
		s += "充值量" + "=" + (this.waterAmount==null?"":this.waterAmount.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Integer getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(Integer waterAmount) {
		this.waterAmount = waterAmount;
	}


}
