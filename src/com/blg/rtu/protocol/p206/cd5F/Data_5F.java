package com.blg.rtu.protocol.p206.cd5F;

public class Data_5F {

//	A 相电压（V） BIN 2
//	B 相电压（V） BIN 2
//	C 相电压（V） BIN 2
//	A 相电流（A） BIN 2
//	B 相电流（A） BIN 2
//	C 相电流（A） BIN 2
	
	private Integer volt_A ;
	private Integer volt_B ;
	private Integer volt_C ;
	
	private Integer current_A ;
	private Integer current_B ;
	private Integer current_C ;
	
	
	public String toString(){
		String s = "\n" ;
		s += "A 相电压:" + volt_A + " V\n" ;
		s += "B 相电压:" + volt_B + " V\n" ;
		s += "C 相电压:" + volt_C + " V\n" ;
		s += "A 相电流:" + current_A + " I\n" ;
		s += "B 相电流:" + current_B + " I\n" ;
		s += "C 相电流:" + current_C + " I\n" ;
		
		return s ;
	}


	public Integer getVolt_A() {
		return volt_A;
	}


	public void setVolt_A(Integer voltA) {
		volt_A = voltA;
	}


	public Integer getVolt_B() {
		return volt_B;
	}


	public void setVolt_B(Integer voltB) {
		volt_B = voltB;
	}


	public Integer getVolt_C() {
		return volt_C;
	}


	public void setVolt_C(Integer voltC) {
		volt_C = voltC;
	}


	public Integer getCurrent_A() {
		return current_A;
	}


	public void setCurrent_A(Integer currentA) {
		current_A = currentA;
	}


	public Integer getCurrent_B() {
		return current_B;
	}


	public void setCurrent_B(Integer currentB) {
		current_B = currentB;
	}


	public Integer getCurrent_C() {
		return current_C;
	}


	public void setCurrent_C(Integer currentC) {
		current_C = currentC;
	}
	
	
	
}
