package com.blg.rtu.protocol.p206.cd4F;

public class Data_4F {
	
	private String mdbPassword ;//
	
	public String toString(){
		String s = "" ;
		if(mdbPassword != null){
			s += "\nModubs密码: " + mdbPassword + "\n" ;
		}
		return s ;
	}
	public String getModbusPassword() {
		return mdbPassword;
	}
	public void setModbusPassword(String mdbPassword) {
		this.mdbPassword = mdbPassword;
	}
}
