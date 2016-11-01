package com.blg.rtu.protocol.p206.cd96;

public class Data_96 {

	private Integer password ;//密码
	private String passwordHex ;//密码16进制
	
	public String toString(){
		String s = "" ;
		if(password != null){
			s += "\n密码: " + password + "\n" ;
		}else if(passwordHex != null){
			s += "\n密码: " + passwordHex + "\n" ;
		}
		
		return s ;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public String getPasswordHex() {
		return passwordHex;
	}

	public void setPasswordHex(String passwordHex) {
		this.passwordHex = passwordHex;
	}
	

}
