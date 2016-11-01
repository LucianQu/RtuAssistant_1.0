package com.blg.rtu.protocol.p206.cd16_56;

public class Data_16 {
	
	protected Integer waterRemainAlarm ;//剩余水量报警值(立方米,取值范围0～999999)
	
	
	public String toString(){
		String s = "\n设置测控终端剩余水量报警值：\n" ;
		s += "剩余水量报警值" + "=" + (this.waterRemainAlarm==null?"":this.waterRemainAlarm.intValue()) + "(立方米)\n" ;
		return s ;
	}

	public Integer getWaterRemainAlarm() {
		return waterRemainAlarm;
	}

	public void setWaterRemainAlarm(Integer waterRemainAlarm) {
		this.waterRemainAlarm = waterRemainAlarm;
	}

}
