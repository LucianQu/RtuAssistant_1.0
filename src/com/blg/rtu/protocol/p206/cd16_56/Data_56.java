package com.blg.rtu.protocol.p206.cd16_56;

public class Data_56 {
	
	protected Integer waterRemainAlarm ;//剩余水量报警值(立方米,取值范围0～999999)
	protected Long waterRemain ;//剩余水量(立方米,取值范围0～7999999999)
	
	
	public String toString(){
		String s = "\n查询测控终端剩余水量及报警值：\n" ;
		s += "现有剩余水量" + "=" + (this.waterRemain==null?"":this.waterRemain.intValue()) + "(立方米)\n" ;
		s += "剩余水量报警值" + "=" + (this.waterRemainAlarm==null?"":this.waterRemainAlarm.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Integer getWaterRemainAlarm() {
		return waterRemainAlarm;
	}

	public void setWaterRemainAlarm(Integer waterRemainAlarm) {
		this.waterRemainAlarm = waterRemainAlarm;
	}

	public Long getWaterRemain() {
		return waterRemain;
	}

	public void setWaterRemain(Long waterRemain) {
		this.waterRemain = waterRemain;
	}

}
