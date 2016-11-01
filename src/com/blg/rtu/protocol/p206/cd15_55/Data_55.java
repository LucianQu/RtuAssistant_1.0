package com.blg.rtu.protocol.p206.cd15_55;


public class Data_55 {
	
	protected Integer waterAmount ;//最后一次充值水量(立方米)
	protected Long waterRemain ;//剩余水量(立方米,取值范围0～7999999999)
	
	public String toString(){
		String s = "\n" ;
		s += "\n查询测控终端最近成功充值量和现有剩余水量：\n" ;
		s += "最近成功充值量" + "=" + (this.waterAmount==null?"":this.waterAmount.intValue()) + "(立方米)\n" ;
		s += "现有剩余水量" + "=" + (this.waterRemain==null?"":this.waterRemain.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Integer getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(Integer waterAmount) {
		this.waterAmount = waterAmount;
	}

	public Long getWaterRemain() {
		return waterRemain;
	}

	public void setWaterRemain(Long waterRemain) {
		this.waterRemain = waterRemain;
	}


}
