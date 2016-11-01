package com.blg.rtu.protocol.p206.cdCA_DA;


public class Data_CA_DA {
	

	private String name ;
	private String user ;
	private String password ;

	public String toString(){
		String s = "\n" ;
		s += "GPRS接入点：" + ":" +
				" 名称：" + (this.name==null?"": name) +
				" 用户：" + (this.user==null?"": user) +
				" 密码：" + (this.password==null?"": password) ;
		return s ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
