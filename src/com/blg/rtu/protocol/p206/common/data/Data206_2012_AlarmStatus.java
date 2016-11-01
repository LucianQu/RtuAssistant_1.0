package com.blg.rtu.protocol.p206.common.data;

import com.blg.rtu.protocol.p206.util.Constant;

public class Data206_2012_AlarmStatus extends Data206_2012_Alarm {
	/*
	1) D0，D1—终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作
	状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态；
	2) D2—终端 IC 卡功能是否有效。0：无效；1：有效；
	3) D3—定值控制是否投入。0：退出；1：投入；
	4) D4—水泵工作状态。 0：启动；1：停止；
	5) D5—终端箱门状态。0：开启；1：关闭；
	6) D6—电源工作状态。0：AC220V 供电；1：蓄电池供电；
	*/
	protected Integer modelStatus ;//
	protected Integer icCardStatus ;// 
	protected Integer bindValueStatus ;// 
	protected Integer pumpStatus ;// 
	protected Integer boxDoorStatus ;// 
	protected Integer powerStatus ;// 

	public String toString(){
		String s = super.toString() ;
		s += "\n终端状态：\n" ;
		s += "模式：" + (modelStatus == null?"":(modelStatus == 0?Constant.Model_0:(modelStatus == 1?Constant.Model_1:(modelStatus == 2?Constant.Model_2:(modelStatus == 3?Constant.Model_3:"不可识别"))))) + "\n" ;
		s += (icCardStatus == 0?Constant.ICCard_0:(icCardStatus == 1?Constant.ICCard_1:"不可识别")) + "\n" ;
		s += (bindValueStatus == 0?Constant.BindValue_0:(bindValueStatus == 1?Constant.BindValue_1:"不可识别")) + "\n" ;
		s += (pumpStatus == 0?Constant.Bump_0:(pumpStatus == 1?Constant.Bump_1:"不可识别")) + "\n" ;
		s += (boxDoorStatus == 0?Constant.BoxDoor_0:(boxDoorStatus == 1?Constant.BoxDoor_1:"不可识别")) + "\n" ;
		s += (powerStatus == 0?Constant.Power_0:(powerStatus == 1?Constant.Power_1:"不可识别")) + "\n" ;
		return s ;
	}

	public Integer getModelStatus() {
		return modelStatus;
	}

	public void setModelStatus(Integer model) {
		this.modelStatus = model;
	}

	public Integer getIcCardStatus() {
		return icCardStatus;
	}

	public void setIcCardStatus(Integer icCard) {
		this.icCardStatus = icCard;
	}

	public Integer getBindValueStatus() {
		return bindValueStatus;
	}

	public void setBindValueStatus(Integer bindValue) {
		this.bindValueStatus = bindValue;
	}

	public Integer getPumpStatus() {
		return pumpStatus;
	}

	public void setPumpStatus(Integer bump) {
		this.pumpStatus = bump;
	}

	public Integer getBoxDoorStatus() {
		return boxDoorStatus;
	}

	public void setBoxDoorStatus(Integer boxDoor) {
		this.boxDoorStatus = boxDoor;
	}

	public Integer getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(Integer power) {
		this.powerStatus = power;
	}

}
