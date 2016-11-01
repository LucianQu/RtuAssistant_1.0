package com.blg.rtu.protocol.p206.cdCC_DC;

import java.io.Serializable;


public class Param_DC implements Serializable{
	
	private static final long serialVersionUID = 201409232122031L;

	public static final String KEY = Param_DC.class.getName() ;


	private Integer enable_1 ;
	private Integer enable_2 ;
	private Integer enable_3 ;
	private Integer enable_4 ;
	
	private Integer ip_1_1_0to254 ;
	private Integer ip_1_2_0to254 ;
	private Integer ip_1_3_0to254 ;
	private Integer ip_1_4_0to254 ;

	private Integer ip_2_1_0to254 ;
	private Integer ip_2_2_0to254 ;
	private Integer ip_2_3_0to254 ;
	private Integer ip_2_4_0to254 ;

	private Integer ip_3_1_0to254 ;
	private Integer ip_3_2_0to254 ;
	private Integer ip_3_3_0to254 ;
	private Integer ip_3_4_0to254 ;

	private Integer ip_4_1_0to254 ;
	private Integer ip_4_2_0to254 ;
	private Integer ip_4_3_0to254 ;
	private Integer ip_4_4_0to254 ;
	
	private Integer port_1_0to65535 ;
	private Integer port_2_0to65535 ;
	private Integer port_3_0to65535 ;
	private Integer port_4_0to65535 ;
	
	private Integer type_1 ;
	private Integer type_2 ;
	private Integer type_3 ;
	private Integer type_4 ;
	

	public String toString(){
		String s = "\n" ;
		s += "中心网址：" + "\n" +
		" 中心1：" + (enable_1.intValue() == 1?"有效":"无效") + " " + (type_1.intValue() == 0?"TCP":"UDP") + "  " + ip_1_1_0to254 + "." + ip_1_2_0to254 + "." + ip_1_3_0to254 + "." + ip_1_4_0to254 + "  " + port_1_0to65535 + "\n" +
		" 中心2：" + (enable_2.intValue() == 1?"有效":"无效") + " " + (type_2.intValue() == 0?"TCP":"UDP") + "  " + ip_2_1_0to254 + "." + ip_2_2_0to254 + "." + ip_2_3_0to254 + "." + ip_2_4_0to254 + "  " + port_2_0to65535 + "\n" +
		" 中心3：" + (enable_3.intValue() == 1?"有效":"无效") + " " + (type_3.intValue() == 0?"TCP":"UDP") + "  " + ip_3_1_0to254 + "." + ip_3_2_0to254 + "." + ip_3_3_0to254 + "." + ip_3_4_0to254 + "  " + port_3_0to65535 + "\n" +
		" 中心4：" + (enable_4.intValue() == 1?"有效":"无效") + " " + (type_4.intValue() == 0?"TCP":"UDP") + "  " + ip_4_1_0to254 + "." + ip_4_2_0to254 + "." + ip_4_3_0to254 + "." + ip_4_4_0to254 + "  " + port_4_0to65535 + "\n" ;
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


	public Integer getIp_1_1_0to254() {
		return ip_1_1_0to254;
	}


	public void setIp_1_1_0to254(Integer ip_1_1_0to254) {
		this.ip_1_1_0to254 = ip_1_1_0to254;
	}


	public Integer getIp_1_2_0to254() {
		return ip_1_2_0to254;
	}


	public void setIp_1_2_0to254(Integer ip_1_2_0to254) {
		this.ip_1_2_0to254 = ip_1_2_0to254;
	}


	public Integer getIp_1_3_0to254() {
		return ip_1_3_0to254;
	}


	public void setIp_1_3_0to254(Integer ip_1_3_0to254) {
		this.ip_1_3_0to254 = ip_1_3_0to254;
	}


	public Integer getIp_1_4_0to254() {
		return ip_1_4_0to254;
	}


	public void setIp_1_4_0to254(Integer ip_1_4_0to254) {
		this.ip_1_4_0to254 = ip_1_4_0to254;
	}


	public Integer getIp_2_1_0to254() {
		return ip_2_1_0to254;
	}


	public void setIp_2_1_0to254(Integer ip_2_1_0to254) {
		this.ip_2_1_0to254 = ip_2_1_0to254;
	}


	public Integer getIp_2_2_0to254() {
		return ip_2_2_0to254;
	}


	public void setIp_2_2_0to254(Integer ip_2_2_0to254) {
		this.ip_2_2_0to254 = ip_2_2_0to254;
	}


	public Integer getIp_2_3_0to254() {
		return ip_2_3_0to254;
	}


	public void setIp_2_3_0to254(Integer ip_2_3_0to254) {
		this.ip_2_3_0to254 = ip_2_3_0to254;
	}


	public Integer getIp_2_4_0to254() {
		return ip_2_4_0to254;
	}


	public void setIp_2_4_0to254(Integer ip_2_4_0to254) {
		this.ip_2_4_0to254 = ip_2_4_0to254;
	}


	public Integer getIp_3_1_0to254() {
		return ip_3_1_0to254;
	}


	public void setIp_3_1_0to254(Integer ip_3_1_0to254) {
		this.ip_3_1_0to254 = ip_3_1_0to254;
	}


	public Integer getIp_3_2_0to254() {
		return ip_3_2_0to254;
	}


	public void setIp_3_2_0to254(Integer ip_3_2_0to254) {
		this.ip_3_2_0to254 = ip_3_2_0to254;
	}


	public Integer getIp_3_3_0to254() {
		return ip_3_3_0to254;
	}


	public void setIp_3_3_0to254(Integer ip_3_3_0to254) {
		this.ip_3_3_0to254 = ip_3_3_0to254;
	}


	public Integer getIp_3_4_0to254() {
		return ip_3_4_0to254;
	}


	public void setIp_3_4_0to254(Integer ip_3_4_0to254) {
		this.ip_3_4_0to254 = ip_3_4_0to254;
	}


	public Integer getIp_4_1_0to254() {
		return ip_4_1_0to254;
	}


	public void setIp_4_1_0to254(Integer ip_4_1_0to254) {
		this.ip_4_1_0to254 = ip_4_1_0to254;
	}


	public Integer getIp_4_2_0to254() {
		return ip_4_2_0to254;
	}


	public void setIp_4_2_0to254(Integer ip_4_2_0to254) {
		this.ip_4_2_0to254 = ip_4_2_0to254;
	}


	public Integer getIp_4_3_0to254() {
		return ip_4_3_0to254;
	}


	public void setIp_4_3_0to254(Integer ip_4_3_0to254) {
		this.ip_4_3_0to254 = ip_4_3_0to254;
	}


	public Integer getIp_4_4_0to254() {
		return ip_4_4_0to254;
	}


	public void setIp_4_4_0to254(Integer ip_4_4_0to254) {
		this.ip_4_4_0to254 = ip_4_4_0to254;
	}


	public Integer getPort_1_0to65535() {
		return port_1_0to65535;
	}


	public void setPort_1_0to65535(Integer port_1_0to65535) {
		this.port_1_0to65535 = port_1_0to65535;
	}


	public Integer getPort_2_0to65535() {
		return port_2_0to65535;
	}


	public void setPort_2_0to65535(Integer port_2_0to65535) {
		this.port_2_0to65535 = port_2_0to65535;
	}


	public Integer getPort_3_0to65535() {
		return port_3_0to65535;
	}


	public void setPort_3_0to65535(Integer port_3_0to65535) {
		this.port_3_0to65535 = port_3_0to65535;
	}


	public Integer getPort_4_0to65535() {
		return port_4_0to65535;
	}


	public void setPort_4_0to65535(Integer port_4_0to65535) {
		this.port_4_0to65535 = port_4_0to65535;
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
