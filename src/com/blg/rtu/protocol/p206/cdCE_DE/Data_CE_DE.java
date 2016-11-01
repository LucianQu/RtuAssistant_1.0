package com.blg.rtu.protocol.p206.cdCE_DE;


public class Data_CE_DE {
	
	private Integer enable_1 ;
	private Integer enable_2 ;
	private Integer enable_3 ;
	private Integer enable_4 ;
	
	private String sate1 ;
	private String sate2 ;
	private String sate3 ;
	private String sate4 ;
	

	public String toString(){
		String s = "\n" ;
		s += "卫星中心：" + "\n" +
		" 卫星中心1：" + (enable_1.intValue() == 1?"有效":"无效") + " 号码：" + sate1 + "\n" +
		" 卫星中心2：" + (enable_2.intValue() == 1?"有效":"无效") + " 号码：" + sate2 + "\n" +
		" 卫星中心3：" + (enable_3.intValue() == 1?"有效":"无效") + " 号码：" + sate3 + "\n" +
		" 卫星中心4：" + (enable_4.intValue() == 1?"有效":"无效") + " 号码：" + sate4 + "\n" ;
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


	public String getSate1() {
		return sate1;
	}


	public void setSate1(String sate1) {
		this.sate1 = sate1;
	}


	public String getSate2() {
		return sate2;
	}


	public void setSate2(String sate2) {
		this.sate2 = sate2;
	}


	public String getSate3() {
		return sate3;
	}


	public void setSate3(String sate3) {
		this.sate3 = sate3;
	}


	public String getSate4() {
		return sate4;
	}


	public void setSate4(String sate4) {
		this.sate4 = sate4;
	}

	
}
