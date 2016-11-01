package com.blg.rtu.protocol.p206.cdF0;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_F0 extends ProtocolSupport{

	private static String tag = Answer_F0.class.getName() ;

	/**
	 * 解析上行数据
	 * @param rtuId
	 * @param b
	 * @param cp
	 * @param dataCode
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<RTU 查询关键参数>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_F0 dd = new Data_F0() ;
		d.setSubData(dd) ;
		int n = index ;
		
		dd.setType(b[n++]) ;
		dd.setLink(b[n++]) ;
		dd.setSignal(b[n++]) ;
		
		int v = ByteUtil.bytes2Short_an(b, n) ;
		dd.setVoltage(v/100.0) ;
		
		n += 2 ;
		this.parseAlarm(b, n, dd) ;
		
		if(dd.getType() == (byte)0xC4){
			//智能水表
			n += 2 ;
			dd.setAmount((Double)this.doParseCommonData(b, n, 5, true, 1000.0D)) ;
			
			n += 5 ;
			dd.setPlus((Double)this.doParseCommonData(b, n, 5, true, 1000.0D)) ;
			
			n += 5 ;
			dd.setMinus((Double)this.doParseCommonData(b, n, 5, true, 1000.0D)) ;
			
			n += 5 ;
			dd.setInstance((Double)this.doParseCommonData(b, n, 5, true, 1000.0D)) ;
		}
		
		if(dd.getType() == (byte)0xC3){
			//地下水
			n += 2 ;
			dd.setWlType(b[n]) ;
			
			n += 1 ;
			dd.setLevel((Double)this.doParseCommonData(b, n, 4, true, 1000.0D)) ;
			
			n += 4 ;
			dd.setBaseHeight((Double)this.doParseCommonData(b, n, 4, true, 1000.0D)) ;
			
			n += 4 ;
			dd.setBuried((Double)this.doParseCommonData(b, n, 4, true, 1000.0D)) ;
			
			n += 4 ;
			dd.setTemperature((Double)this.doParseCommonData(b, n, 2, false, 10.0D)) ;
		}
		
		return d;
	}
	
	protected Object doParseCommonData(byte[] b, int index, int lenPer, boolean hasFuShu, Double cuShu) throws Exception {
		Double vd = null ;
		Long ld = null ;
		boolean plus = true ;

		if(hasFuShu){
			int temp = b[index + lenPer - 1] ;
			if(temp < 0){
				plus = false ;
				b[index + lenPer - 1] = (byte)(b[index + lenPer - 1] & 0xF) ;
			}
		}
		
		long bcd = ByteUtil.BCD2Long_an(b, index, index + lenPer - 1) ;
		
		if(cuShu != null){
			vd = bcd/cuShu ;
		}else{
			ld = bcd ;
		}
		
		if(!plus){
			if(cuShu != null){
				vd = - vd ;
			}else{
				ld = - ld ;
			}
		}
		
		if(cuShu != null){
			return vd ;
		}else{
			return ld ;
		}
	}

	/*
	1)	D0—工作交流电停电告警；
	2)	D1—蓄电池电压报警；
	3)	D2—水位超限报警；
	4)	D3—流量超限报警；
	5)	D4—水质超限报警；
	6)	D5—流量仪表故障报警；
	7)	D6—水泵开停状态；
	8)	D7—水位仪表故障报警；
	
	9)	D8—水压超限报警；
	10) D9—备用；
	11) D10—终端 IC 卡功能报警；
	12) D11—定值控制报警；
	13) D12—剩余水量的下限报警
	14) D13—终端箱门状态报警；
	15）D14—运行时间告警 N年
	16）D15--强磁攻击告警
	 */

	public void parseAlarm(byte[] b , int index , Data_F0 alarmData) throws Exception {
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
		int v15 = (v & 0x80) >> 7 ;
		int v14 = (v & 0x40) >> 6 ;
		int v13 = (v & 0x20) >> 5 ;
		int v12 = (v & 0x10) >> 4 ;
		int v11 = (v & 0x8) >> 3 ;
		int v10 = (v & 0x4) >> 2 ;
		//int v9 = (v & 0x2) >> 1 ;备用
		int v8 = (v & 0x1) ;
		alarmData.setWaterPressOverAlarm(v8) ;
		alarmData.setIcCardAlarm(v10) ;
		alarmData.setBindValueControlAlarm(v11) ;
		alarmData.setWaterRemainAlarm(v12) ;
		alarmData.setBoxDoorAlarm(v13) ;
		alarmData.setLongRunAlarm(v14) ;
		alarmData.setElectromagneticAlarm(v15) ;
//		protected Integer power220StopAlarm ;//工作交流电停电告警；(0未发生报警，1发生报警)
//		protected Integer storePowerLowVoltageAlarm ;//蓄电池电压报警；(0未发生报警，1发生报警)
//		protected Integer waterLevelAlarm ;//水位上下限报警；(0未发生报警，1发生报警)
//		protected Integer waterAmountOverAlarm ;//流量超限报警； (0未发生报警，1发生报警)
//		protected Integer waterQualityOverAlarm ;//水质超限报警； (0未发生报警，1发生报警)
//		protected Integer waterAmountMeterAlarm ;//流量仪表故障报警； (0未发生报警，1发生报警)
//		protected Integer pumpStartStopAlarm ;//水泵开停状态；(0未发生报警，1发生报警)
//		protected Integer waterLevelMeterAlarm ;//水位仪表故障报警； (0未发生报警，1发生报警)
//		
//		protected Integer waterPressOverAlarm ;//水压超限报警； (0未发生报警，1发生报警)
//		protected Integer icCardAlarm ;//终端 IC 卡功能报警； (0未发生报警，1发生报警)
//		protected Integer bindValueControlAlarm ;//定值控制报警； (0未发生报警，1发生报警)
//		protected Integer waterRemainAlarm ;//剩余水量的下限报警； (0未发生报警，1发生报警)
//		protected Integer boxDoorAlarm ;//终端箱门状态报警；(0未发生报警，1发生报警)
//		
//		protected Integer longRunAlarm ;//运行时间告警 N年；(0未发生报警，1发生报警)
//		protected Integer electromagneticAlarm ;//强磁攻击告警；(0未发生报警，1发生报警)
		
	}
}
