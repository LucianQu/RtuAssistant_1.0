package com.blg.rtu.protocol.p206.cdEF;

public class Data_EF {
	
	private Integer hard1 ;
	private Integer hard2 ;
	private Integer hard3 ;
	private Integer soft1 ;
	private Integer soft2 ;
	private Integer soft3 ;
	
	public String toString(){
		String s = "硬件版本：" + this.hard1 + "." + hard2 + "." + hard3 + "\n" ;
		s += "软件版本：" + this.soft1 + "." + soft2 + "." + soft3 + "\n" ;
		return s ;
	}

	public Integer getHard1() {
		return hard1;
	}
	public void setHard1(Integer hard1) {
		this.hard1 = hard1;
	}
	public Integer getHard2() {
		return hard2;
	}
	public void setHard2(Integer hard2) {
		this.hard2 = hard2;
	}
	public Integer getHard3() {
		return hard3;
	}
	public void setHard3(Integer hard3) {
		this.hard3 = hard3;
	}
	public Integer getSoft1() {
		return soft1;
	}
	public void setSoft1(Integer soft1) {
		this.soft1 = soft1;
	}
	public Integer getSoft2() {
		return soft2;
	}
	public void setSoft2(Integer soft2) {
		this.soft2 = soft2;
	}
	public Integer getSoft3() {
		return soft3;
	}
	public void setSoft3(Integer soft3) {
		this.soft3 = soft3;
	}
	
	

}
