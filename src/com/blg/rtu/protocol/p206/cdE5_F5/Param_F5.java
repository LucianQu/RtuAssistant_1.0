package com.blg.rtu.protocol.p206.cdE5_F5;

import java.io.Serializable;


public class Param_F5 implements Serializable{
	
	private static final long serialVersionUID = 201409240057001L;

	public static final String KEY = Param_F5.class.getName() ;


	private Integer enable_level_0To1 ;//水位仪表  	1变更有效          0变更无效

	private Double meter_level_n30d999to30d999 ;//水位修正值

	public String toString(){
		String s = "\n" ;
		s += "仪表采集修正值：" + "\n" +
				" 水位仪表：" + (enable_level_0To1.intValue() == 1?"有效":"无效") +  
				
				" 水位修正值：" + meter_level_n30d999to30d999 ;
		return s ;
	}

	public Integer getEnable_level_0To1() {
		return enable_level_0To1;
	}

	public void setEnable_level_0To1(Integer enable_level_0To1) {
		this.enable_level_0To1 = enable_level_0To1;
	}

	public Double getMeter_level_n30d999to30d999() {
		return meter_level_n30d999to30d999;
	}

	public void setMeter_level_n30d999to30d999(Double meter_level_n30d999to30d999) {
		this.meter_level_n30d999to30d999 = meter_level_n30d999to30d999;
	}

	


}
