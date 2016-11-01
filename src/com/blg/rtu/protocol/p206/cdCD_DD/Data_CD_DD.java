package com.blg.rtu.protocol.p206.cdCD_DD;


public class Data_CD_DD {
	
	private Integer enable_1 ;
	private Integer enable_2 ;
	private Integer enable_3 ;
	private Integer enable_4 ;
	
	private String phone1 ;
	private String phone2 ;
	private String phone3 ;
	private String phone4 ;
	

	public String toString(){
		String s = "\n" ;
		s += "短信中心：" + "\n" +
		" 短信中心1：" + (enable_1.intValue() == 1?"有效":"无效") + " 号码：" + phone1 + "\n" +
		" 短信中心2：" + (enable_2.intValue() == 1?"有效":"无效") + " 号码：" + phone2 + "\n" +
		" 短信中心3：" + (enable_3.intValue() == 1?"有效":"无效") + " 号码：" + phone3 + "\n" +
		" 短信中心4：" + (enable_4.intValue() == 1?"有效":"无效") + " 号码：" + phone4 + "\n" ;
		return s ;
	}


	public Integer getEnable_1() {
		return enable_1;
	}


	public void setEnable_1(Integer enable_1) {
		this.enable_1 = enable_1;
	}


	public Integer getEnable_2() {
		return enable_2;
	}


	public void setEnable_2(Integer enable_2) {
		this.enable_2 = enable_2;
	}


	public Integer getEnable_3() {
		return enable_3;
	}


	public void setEnable_3(Integer enable_3) {
		this.enable_3 = enable_3;
	}


	public Integer getEnable_4() {
		return enable_4;
	}


	public void setEnable_4(Integer enable_4) {
		this.enable_4 = enable_4;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getPhone3() {
		return phone3;
	}


	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}


	public String getPhone4() {
		return phone4;
	}


	public void setPhone4(String phone4) {
		this.phone4 = phone4;
	}

	
}
