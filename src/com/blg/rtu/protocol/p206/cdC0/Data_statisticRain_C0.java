package com.blg.rtu.protocol.p206.cdC0;

import com.blg.rtu.protocol.p206.common.data.Data_rain;

public class Data_statisticRain_C0 extends Data_rain{
	public static final int stageType_5m = 0 ;//5分钟步长的时段降雨量类型
	public static final int stageType_1h = 1 ;//1小时步长的时段降雨量类型
	public static final int stageType_1d = 2 ;//1天步长的时段降雨量类型
	public static final int stageType_t = 3 ;//测试降雨量类型
	
	private Integer stageType ;//时段类型
	private Integer stage ;//时段长度

	public String toString(){
		String s = "\n时段类型 : " + (
				this.stageType==null?"":stageType.intValue() 
						== stageType_5m?"5分钟时段降雨量":(stageType.intValue() 
								== stageType_1h?"小时段降雨量":(stageType.intValue() 
										== stageType_1d?"日时段降雨量":(stageType.intValue()
												== stageType_t?"测试累计降雨量":(""))))) + "\n" ;
		return s ;
	}

	public Integer getStageType() {
		return stageType;
	}

	public void setStageType(Integer stageType) {
		this.stageType = stageType;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}
	
}
