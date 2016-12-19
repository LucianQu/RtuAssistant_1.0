package com.blg.rtu.protocol.p206.common.data;

public class Data206_2012_Alarm {

	///////////////////////////////////////
	//报警状态
	protected Integer power220StopAlarm ;//工作交流电停电告警；(0未发生报警，1发生报警)
	protected Integer storePowerLowVoltageAlarm ;//蓄电池电压报警；(0未发生报警，1发生报警)
	protected Integer waterLevelAlarm ;//水位上下限报警；(0未发生报警，1发生报警)
	protected Integer waterAmountOverAlarm ;//流量超限报警； (0未发生报警，1发生报警)
	protected Integer waterQualityOverAlarm ;//水质超限报警； (0未发生报警，1发生报警)
	protected Integer waterAmountMeterAlarm ;//流量仪表故障报警； (0未发生报警，1发生报警)
	protected Integer pumpStartStopAlarm ;//水泵开停状态；(0未发生报警，1发生报警)
	protected Integer waterLevelMeterAlarm ;//水位仪表故障报警； (0未发生报警，1发生报警)
	protected Integer waterPressOverAlarm ;//水压超限报警； (0未发生报警，1发生报警)
	protected Integer waterTemperatureAlarm ;//水温仪表故障报警； (0未发生报警，1发生报警)
	protected Integer icCardAlarm ;//终端 IC 卡功能报警； (0未发生报警，1发生报警)
	protected Integer bindValueControlAlarm ;//定值控制报警； (0未发生报警，1发生报警)
	protected Integer waterRemainAlarm ;//剩余水量的下限报警； (0未发生报警，1发生报警)
	protected Integer boxDoorAlarm ;//终端箱门状态报警；(0未发生报警，1发生报警)
	protected Integer waterMeterAlarm;//流量仪表反向报警；(0未发生报警，1发生报警)

	public String toString(){
		String s = "\n报警状态：\n" ;
		s += "工作交流电停电告警：" + (this.power220StopAlarm==null?"":(this.power220StopAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "蓄电池电压报警：" + (this.storePowerLowVoltageAlarm==null?"":(this.storePowerLowVoltageAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "水位超限报警：" + (this.waterLevelAlarm==null?"":(this.waterLevelAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "流量超限报警：" + (this.waterAmountOverAlarm==null?"":(this.waterAmountOverAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "水质超限报警：" + (this.waterQualityOverAlarm==null?"":(this.waterQualityOverAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "流量仪表故障报警：" + (this.waterAmountMeterAlarm==null?"":(this.waterAmountMeterAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "水泵开停状态：" + (this.pumpStartStopAlarm==null?"":(this.pumpStartStopAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "水位仪表故障报警：" + (this.waterLevelMeterAlarm==null?"":(this.waterLevelMeterAlarm.intValue()==1?"有":"无")) + "\n" ; 
		s += "水压超限报警：" + (this.waterPressOverAlarm==null?"":(this.waterPressOverAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "水温仪表故障报警：" + (this.waterTemperatureAlarm==null?"":(this.waterTemperatureAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "终端 IC 卡功能报警：" + (this.icCardAlarm==null?"":(this.icCardAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "定值控制报警：" + (this.bindValueControlAlarm==null?"":(this.bindValueControlAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "剩余水量的下限报警：" + (this.waterRemainAlarm==null?"":(this.waterRemainAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "终端箱门状态报警：" + (this.boxDoorAlarm==null?"":(this.boxDoorAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "流量仪表反向报警：" + (this.waterMeterAlarm==null?"":(this.waterMeterAlarm.intValue()==1?"有":"无")) + "\n" ;
		return s ;
	}

	public Integer getPower220StopAlarm() {
		return power220StopAlarm;
	}
	public void setPower220StopAlarm(Integer power220StopAlt) {
		power220StopAlarm = power220StopAlt;
	}
	public Integer getStorePowerLowVoltageAlarm() {
		return storePowerLowVoltageAlarm;
	}
	public void setStorePowerLowVoltageAlarm(Integer storePowerLowVoltageAlt) {
		storePowerLowVoltageAlarm = storePowerLowVoltageAlt;
	}

	public Integer getWaterLevelAlarm() {
		return waterLevelAlarm;
	}

	public void setWaterLevelAlarm(Integer waterLevelAlarm) {
		this.waterLevelAlarm = waterLevelAlarm;
	}

	public Integer getWaterAmountOverAlarm() {
		return waterAmountOverAlarm;
	}

	public void setWaterAmountOverAlarm(Integer waterAmountOverAlarm) {
		this.waterAmountOverAlarm = waterAmountOverAlarm;
	}

	public Integer getWaterQualityOverAlarm() {
		return waterQualityOverAlarm;
	}

	public void setWaterQualityOverAlarm(Integer waterQualityOverAlarm) {
		this.waterQualityOverAlarm = waterQualityOverAlarm;
	}

	public Integer getWaterAmountMeterAlarm() {
		return waterAmountMeterAlarm;
	}

	public void setWaterAmountMeterAlarm(Integer waterAmountMeterAlarm) {
		this.waterAmountMeterAlarm = waterAmountMeterAlarm;
	}

	public Integer getPumpStartStopAlarm() {
		return pumpStartStopAlarm;
	}

	public void setPumpStartStopAlarm(Integer pumpStartStopAlarm) {
		this.pumpStartStopAlarm = pumpStartStopAlarm;
	}

	public Integer getWaterLevelMeterAlarm() {
		return waterLevelMeterAlarm;
	}

	public void setWaterLevelMeterAlarm(Integer waterLevelMeterAlarm) {
		this.waterLevelMeterAlarm = waterLevelMeterAlarm;
	}

	public Integer getWaterPressOverAlarm() {
		return waterPressOverAlarm;
	}

	public void setWaterPressOverAlarm(Integer waterPressOverAlarm) {
		this.waterPressOverAlarm = waterPressOverAlarm;
	}

	public Integer getIcCardAlarm() {
		return icCardAlarm;
	}

	public void setIcCardAlarm(Integer icCardAlarm) {
		this.icCardAlarm = icCardAlarm;
	}

	public Integer getBindValueControlAlarm() {
		return bindValueControlAlarm;
	}

	public void setBindValueControlAlarm(Integer bindValueControlAlarm) {
		this.bindValueControlAlarm = bindValueControlAlarm;
	}

	public Integer getWaterRemainAlarm() {
		return waterRemainAlarm;
	}

	public void setWaterRemainAlarm(Integer waterRemainAlarm) {
		this.waterRemainAlarm = waterRemainAlarm;
	}

	public Integer getBoxDoorAlarm() {
		return boxDoorAlarm;
	}

	public void setBoxDoorAlarm(Integer boxDoorAlarm) {
		this.boxDoorAlarm = boxDoorAlarm;
	}
	public Integer getWaterMeterAlarm() {
		return waterMeterAlarm;
	}

	public void setWaterMeterAlarm(Integer waterMeterAlarm) {
		this.waterMeterAlarm = waterMeterAlarm;
	}
	public Integer getWaterTemperatureAlarm() {
		return waterTemperatureAlarm;
	}

	public void setWaterTemperatureAlarm(Integer waterTemperatureAlarm) {
		this.waterTemperatureAlarm = waterTemperatureAlarm;
	}

}
