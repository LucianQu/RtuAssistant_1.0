package com.blg.rtu.protocol.p206.cdCA_DA;

import java.io.Serializable;


public class Param_DA implements Serializable{
	
	private static final long serialVersionUID = 201409232122003L;

	public static final String KEY = Param_DA.class.getName() ;


	private String name_1to32 ;
	private String user_1to32 ;
	private String password_1to32 ;

	public String toString(){
		String s = "\n" ;
		s += "GPRS接入点：" + ":" +
				" 名称：" + (this.name_1to32==null?"": name_1to32) +
				" 用户：" + (this.user_1to32==null?"": user_1to32) +
				" 密码：" + (this.password_1to32==null?"": password_1to32) ;
		return s ;
	}

	public String getName_1to32() {
		return name_1to32;
	}

	public void setName_1to32(String name_1to32) {
		this.name_1to32 = name_1to32;
	}

	public String getUser_1to32() {
		return user_1to32;
	}

	public void setUser_1to32(String user_1to32) {
		this.user_1to32 = user_1to32;
	}

	public String getPassword_1to32() {
		return password_1to32;
	}

	public void setPassword_1to32(String password_1to32) {
		this.password_1to32 = password_1to32;
	}

	

}
