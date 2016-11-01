package com.blg.rtu.protocol.p206.cd96;

import java.io.Serializable;

public class Param_96 implements Serializable{

	private static final long serialVersionUID = 201212101138001L;

	public static final String KEY = Param_96.class.getName() ;

	private Integer newPass_0to9999 ;//新密码
	private String newPass_hex ;//以16进制表示的密码
	
	public String toString(){
		String s = null ;
		if(newPass_0to9999 != null){
			s = "\n新密码: " + newPass_0to9999 + "\n" ;
		}
		if(newPass_hex != null){
			s = "\n新密码: " + newPass_hex + "\n" ;
		}
		return s ;
	}

	public Integer getNewPass_0to9999() {
		return newPass_0to9999;
	}

	public void setNewPass_0to9999(Integer newPass_0to9999) {
		this.newPass_0to9999 = newPass_0to9999;
	}

	public String getNewPass_hex() {
		return newPass_hex;
	}

	public void setNewPass_hex(String netPass_hex) {
		this.newPass_hex = netPass_hex;
	}



}
