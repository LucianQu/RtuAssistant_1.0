package com.blg.rtu.protocol.p206.cdE5_F5;


public class Data_E5_F5 {
	

	private Integer enable_level ;//水位仪表  	1变更有效          0变更无效

	private Double meter_level ;//水位修正值

	public String toString(){
		String s = "\n" ;
		s += "仪表采集修正值：" + "\n" +
				" 水位仪表：" + (enable_level.intValue() == 1?"有效":"无效") +  
				
				" 水位修正值：" + meter_level ;
		return s ;
	}

	public Integer getEnable_level() {
		return enable_level;
	}

	public void setEnable_level(Integer enable_level) {
		this.enable_level = enable_level;
	}

	public Double getMeter_level() {
		return meter_level;
	}

	public void setMeter_level(Double meter_level) {
		this.meter_level = meter_level;
	}
	
}
