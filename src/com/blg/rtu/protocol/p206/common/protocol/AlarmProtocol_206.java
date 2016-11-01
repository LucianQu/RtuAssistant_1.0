package com.blg.rtu.protocol.p206.common.protocol;

import com.blg.rtu.protocol.p206.common.data.* ;

public class AlarmProtocol_206 {
	/*
		1) D0—工作交流电停电告警；
		2) D1—蓄电池电压报警；
		3) D2—水位超限报警；
		4) D3—流量超限报警；
		5) D4—水质超限报警；
		6) D5—流量仪表故障报警；
		7) D6—水泵开停状态；
		8) D7—水位仪表故障报警；
		9) D8—水压超限报警；
		10) D9—水温仪表故障；
		11) D10—终端 IC 卡功能报警；
		12) D11—定值控制报警；
		13) D12—剩余水量的下限报警
		14) D13—终端箱门状态报警；
		15) D14—D15 备用
	 */
	/**
	 * 分析报警部分
	 */
	public void parse(byte[] b, int index, Data206_2012_Alarm alarmData) throws Exception {
		this.parseAlarm(b, index, alarmData) ;
	}
	public void parseAlarm(byte[] b , int index , Data206_2012_Alarm alarmData) throws Exception {
		int n = index ; 
	
		int v = b[n++] ;
		int v7 = (v & 0x80) >> 7 ;
		int v6 = (v & 0x40) >> 6 ;
		int v5 = (v & 0x20) >> 5 ;
		int v4 = (v & 0x10) >> 4 ;
		int v3 = (v & 0x8) >> 3 ;
		int v2 = (v & 0x4) >> 2 ;
		int v1 = (v & 0x2) >> 1 ;
		int v0 = (v & 0x1) ;
		alarmData.setPower220StopAlarm(v0) ; 
		alarmData.setStorePowerLowVoltageAlarm(v1) ; 
		alarmData.setWaterLevelAlarm(v2) ;
		alarmData.setWaterAmountOverAlarm(v3) ;
		alarmData.setWaterQualityOverAlarm(v4) ;
		alarmData.setWaterAmountMeterAlarm(v5) ;
		alarmData.setPumpStartStopAlarm(v6) ;
		alarmData.setWaterLevelMeterAlarm(v7) ;
		
		v = b[n++] ;
		int v13 = (v & 0x20) >> 5 ;
		int v12 = (v & 0x10) >> 4 ;
		int v11 = (v & 0x8) >> 3 ;
		int v10 = (v & 0x4) >> 2 ;
		int v9 = (v & 0x2) >> 1 ;
		int v8 = (v & 0x1) ;
		alarmData.setWaterPressOverAlarm(v8) ;
		alarmData.setWaterTemperatureAlarm(v9) ;
		alarmData.setIcCardAlarm(v10) ;
		alarmData.setBindValueControlAlarm(v11) ;
		alarmData.setWaterRemainAlarm(v12) ;
		alarmData.setBoxDoorAlarm(v13) ;
	}

}
