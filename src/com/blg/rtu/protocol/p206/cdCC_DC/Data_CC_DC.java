package com.blg.rtu.protocol.p206.cdCC_DC;


public class Data_CC_DC {
	

	private Integer enable_1 ;
	private Integer enable_2 ;
	private Integer enable_3 ;
	private Integer enable_4 ;
	
	private Integer ip_1_1 ;
	private Integer ip_1_2 ;
	private Integer ip_1_3 ;
	private Integer ip_1_4 ;

	private Integer ip_2_1 ;
	private Integer ip_2_2 ;
	private Integer ip_2_3 ;
	private Integer ip_2_4 ;

	private Integer ip_3_1 ;
	private Integer ip_3_2 ;
	private Integer ip_3_3 ;
	private Integer ip_3_4 ;

	private Integer ip_4_1 ;
	private Integer ip_4_2 ;
	private Integer ip_4_3 ;
	private Integer ip_4_4 ;
	
	private Integer port_1 ;
	private Integer port_2 ;
	private Integer port_3 ;
	private Integer port_4 ;
	
	private Integer type_1 ;
	private Integer type_2 ;
	private Integer type_3 ;
	private Integer type_4 ;
	

	public String toString(){
		String s = "\n" ;
		s += "中心网址：" + "\n" +
		" 中心1：" + (enable_1.intValue() == 1?"有效":"无效") + " " + (type_1.intValue() == 0?"TCP":"UDP") + "  " + ip_1_1 + "." + ip_1_2 + "." + ip_1_3 + "." + ip_1_4 + "  " + port_1 + "\n" +
		" 中心2：" + (enable_2.intValue() == 1?"有效":"无效") + " " + (type_2.intValue() == 0?"TCP":"UDP") + "  " + ip_2_1 + "." + ip_2_2 + "." + ip_2_3 + "." + ip_2_4 + "  " + port_2 + "\n" +
		" 中心3：" + (enable_3.intValue() == 1?"有效":"无效") + " " + (type_3.intValue() == 0?"TCP":"UDP") + "  " + ip_3_1 + "." + ip_3_2 + "." + ip_3_3 + "." + ip_3_4 + "  " + port_3 + "\n" +
		" 中心4：" + (enable_4.intValue() == 1?"有效":"无效") + " " + (type_4.intValue() == 0?"TCP":"UDP") + "  " + ip_4_1 + "." + ip_4_2 + "." + ip_4_3 + "." + ip_4_4 + "  " + port_4 + "\n" ;
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


	public Integer getIp_1_1() {
		return ip_1_1;
	}


	public void setIp_1_1(Integer ip_1_1) {
		this.ip_1_1 = ip_1_1;
	}


	public Integer getIp_1_2() {
		return ip_1_2;
	}


	public void setIp_1_2(Integer ip_1_2) {
		this.ip_1_2 = ip_1_2;
	}


	public Integer getIp_1_3() {
		return ip_1_3;
	}


	public void setIp_1_3(Integer ip_1_3) {
		this.ip_1_3 = ip_1_3;
	}


	public Integer getIp_1_4() {
		return ip_1_4;
	}


	public void setIp_1_4(Integer ip_1_4) {
		this.ip_1_4 = ip_1_4;
	}


	public Integer getIp_2_1() {
		return ip_2_1;
	}


	public void setIp_2_1(Integer ip_2_1) {
		this.ip_2_1 = ip_2_1;
	}


	public Integer getIp_2_2() {
		return ip_2_2;
	}


	public void setIp_2_2(Integer ip_2_2) {
		this.ip_2_2 = ip_2_2;
	}


	public Integer getIp_2_3() {
		return ip_2_3;
	}


	public void setIp_2_3(Integer ip_2_3) {
		this.ip_2_3 = ip_2_3;
	}


	public Integer getIp_2_4() {
		return ip_2_4;
	}


	public void setIp_2_4(Integer ip_2_4) {
		this.ip_2_4 = ip_2_4;
	}


	public Integer getIp_3_1() {
		return ip_3_1;
	}


	public void setIp_3_1(Integer ip_3_1) {
		this.ip_3_1 = ip_3_1;
	}


	public Integer getIp_3_2() {
		return ip_3_2;
	}


	public void setIp_3_2(Integer ip_3_2) {
		this.ip_3_2 = ip_3_2;
	}


	public Integer getIp_3_3() {
		return ip_3_3;
	}


	public void setIp_3_3(Integer ip_3_3) {
		this.ip_3_3 = ip_3_3;
	}


	public Integer getIp_3_4() {
		return ip_3_4;
	}


	public void setIp_3_4(Integer ip_3_4) {
		this.ip_3_4 = ip_3_4;
	}


	public Integer getIp_4_1() {
		return ip_4_1;
	}


	public void setIp_4_1(Integer ip_4_1) {
		this.ip_4_1 = ip_4_1;
	}


	public Integer getIp_4_2() {
		return ip_4_2;
	}


	public void setIp_4_2(Integer ip_4_2) {
		this.ip_4_2 = ip_4_2;
	}


	public Integer getIp_4_3() {
		return ip_4_3;
	}


	public void setIp_4_3(Integer ip_4_3) {
		this.ip_4_3 = ip_4_3;
	}


	public Integer getIp_4_4() {
		return ip_4_4;
	}


	public void setIp_4_4(Integer ip_4_4) {
		this.ip_4_4 = ip_4_4;
	}


	public Integer getPort_1() {
		return port_1;
	}


	public void setPort_1(Integer port_1) {
		this.port_1 = port_1;
	}


	public Integer getPort_2() {
		return port_2;
	}


	public void setPort_2(Integer port_2) {
		this.port_2 = port_2;
	}


	public Integer getPort_3() {
		return port_3;
	}


	public void setPort_3(Integer port_3) {
		this.port_3 = port_3;
	}


	public Integer getPort_4() {
		return port_4;
	}


	public void setPort_4(Integer port_4) {
		this.port_4 = port_4;
	}


	public Integer getType_1() {
		return type_1;
	}


	public void setType_1(Integer type_1) {
		this.type_1 = type_1;
	}


	public Integer getType_2() {
		return type_2;
	}


	public void setType_2(Integer type_2) {
		this.type_2 = type_2;
	}


	public Integer getType_3() {
		return type_3;
	}


	public void setType_3(Integer type_3) {
		this.type_3 = type_3;
	}


	public Integer getType_4() {
		return type_4;
	}


	public void setType_4(Integer type_4) {
		this.type_4 = type_4;
	}
	
	
	
}
