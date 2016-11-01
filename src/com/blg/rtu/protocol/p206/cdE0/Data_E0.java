package com.blg.rtu.protocol.p206.cdE0;

public class Data_E0 {
	
	private Integer type ;
	private Float voltage ;
	
	public static final Integer type0 = 0 ;//"外部供电" ;
	public static final Integer type1 = 1 ;// "电池供电" ;
	
	public String toString(){
		String s = "查询供电方式及电压：\n" ;
		s += "供电方式：" + (type == null?"":(type.intValue() == type0.intValue()?"外部供电":(type.intValue() == type1.intValue()?"电池供电":"未知类型"))) + "\n" ;
		s += "电压：" + voltage.floatValue() + "\n" ;
		return s ;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getVoltage() {
		return voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	

}
