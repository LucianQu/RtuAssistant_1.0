package com.blg.rtu.protocol.p206.cdF0;

public class Data_F0 {

	private Byte type ;//项目类型 ： 0xC3 表示地下水（C203简写），0xC4表示智能水表（C204简写）
	private Byte link ;//0x01 正在连接 ，0x02在线，0x03断开(hex格式)
	private Byte signal ;//GSM信号强度  取值0-36 (hex格式)
	
	private Double voltage ;//电池电压0-FFFF(hex格式，低字节在前，高字节在后，保留两位小数，例如1024 对应的为0x400 ,第四字节为： 00  第五字节为：04，转为10进制为1024 表示10.24V)

	private Double amount ;//累计流量
	private Double plus ;//正积
	private Double minus ;//负积
	private Double instance ;//瞬时流量
	
	private Byte wlType ;//水位 上报类型：0 为实测值， 1 为水位高程， 2 为水深， 3 为水位埋深
	private Double level ;//水位
	private Double baseHeight ;//井口高程
	private Double buried ;//探头埋深
	private Double temperature ;//水温
	
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
	protected Integer icCardAlarm ;//终端 IC 卡功能报警； (0未发生报警，1发生报警)
	protected Integer bindValueControlAlarm ;//定值控制报警； (0未发生报警，1发生报警)
	protected Integer waterRemainAlarm ;//剩余水量的下限报警； (0未发生报警，1发生报警)
	protected Integer boxDoorAlarm ;//终端箱门状态报警；(0未发生报警，1发生报警)
	
	protected Integer longRunAlarm ;//运行时间告警 N年；(0未发生报警，1发生报警)
	protected Integer electromagneticAlarm ;//强磁攻击告警；(0未发生报警，1发生报警)

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
		s += "终端 IC 卡功能报警：" + (this.icCardAlarm==null?"":(this.icCardAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "定值控制报警：" + (this.bindValueControlAlarm==null?"":(this.bindValueControlAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "剩余水量的下限报警：" + (this.waterRemainAlarm==null?"":(this.waterRemainAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "终端箱门状态报警：" + (this.boxDoorAlarm==null?"":(this.boxDoorAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "运行时间告警 N年：" + (this.longRunAlarm==null?"":(this.longRunAlarm.intValue()==1?"有":"无")) + "\n" ;
		s += "强磁攻击告警：" + (this.electromagneticAlarm==null?"":(this.electromagneticAlarm.intValue()==1?"有":"无")) + "\n" ;
		return s ;
	}
	
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public Byte getLink() {
		return link;
	}
	public void setLink(Byte link) {
		this.link = link;
	}
	public Byte getSignal() {
		return signal;
	}
	public void setSignal(Byte signal) {
		this.signal = signal;
	}
	public Double getVoltage() {
		return voltage;
	}
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getPlus() {
		return plus;
	}
	public void setPlus(Double plus) {
		this.plus = plus;
	}
	public Double getMinus() {
		return minus;
	}
	public void setMinus(Double minus) {
		this.minus = minus;
	}
	public Double getInstance() {
		return instance;
	}
	public void setInstance(Double instance) {
		this.instance = instance;
	}
	public Byte getWlType() {
		return wlType;
	}
	public void setWlType(Byte wlType) {
		this.wlType = wlType;
	}
	public Double getBaseHeight() {
		return baseHeight;
	}
	public void setBaseHeight(Double baseHeight) {
		this.baseHeight = baseHeight;
	}
	public Double getBuried() {
		return buried;
	}
	public void setBuried(Double buried) {
		this.buried = buried;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getLevel() {
		return level;
	}
	public void setLevel(Double level) {
		this.level = level;
	}

	public Integer getPower220StopAlarm() {
		return power220StopAlarm;
	}

	public void setPower220StopAlarm(Integer power220StopAlarm) {
		this.power220StopAlarm = power220StopAlarm;
	}

	public Integer getStorePowerLowVoltageAlarm() {
		return storePowerLowVoltageAlarm;
	}

	public void setStorePowerLowVoltageAlarm(Integer storePowerLowVoltageAlarm) {
		this.storePowerLowVoltageAlarm = storePowerLowVoltageAlarm;
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

	public Integer getLongRunAlarm() {
		return longRunAlarm;
	}

	public void setLongRunAlarm(Integer longRunAlarm) {
		this.longRunAlarm = longRunAlarm;
	}

	public Integer getElectromagneticAlarm() {
		return electromagneticAlarm;
	}

	public void setElectromagneticAlarm(Integer electromagneticAlarm) {
		this.electromagneticAlarm = electromagneticAlarm;
	}
	
	
}
