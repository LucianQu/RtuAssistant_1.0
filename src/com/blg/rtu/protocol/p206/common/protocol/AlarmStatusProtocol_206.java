package com.blg.rtu.protocol.p206.common.protocol;

import com.blg.rtu.protocol.p206.common.data.* ;

public class AlarmStatusProtocol_206 extends AlarmProtocol_206 {
	/*
		1) D0，D1—终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作	状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态；
		2) D2—终端 IC 卡功能是否有效。0：无效；1：有效；
		3) D3—定值控制是否投入。0：退出；1：投入；
		4) D4—水泵工作状态。 0：启动；1：停止；
		5) D5—终端箱门状态。0：开启；1：关闭；
		6) D6—电源工作状态。0：AC220V 供电；1：蓄电池供电；
		7) D7—D15 备用。
	 */
	/**
	 * 分析报警及状态部分
	 */
	public void parse(byte[] b , int index , Data206_2012_AlarmStatus asData) throws Exception {
		super.parse(b, index, asData) ;
		
		int v = b[index + 2] ;
//		int v7 = (v & 0x80) >> 7 ;
		int v6 = (v & 0x40) >> 6 ;
		int v5 = (v & 0x20) >> 5 ;
		int v4 = (v & 0x10) >> 4 ;
		int v3 = (v & 0x8) >> 3 ;
		int v2 = (v & 0x4) >> 2 ;
		int v1 = (v & 0x3) ;
		
		asData.setModelStatus(v1) ;
		asData.setIcCardStatus(v2) ;
		asData.setBindValueStatus(v3) ;
		asData.setPumpStatus(v4) ;
		asData.setBoxDoorStatus(v5) ;
		asData.setPowerStatus(v6) ;
		
	}

}
