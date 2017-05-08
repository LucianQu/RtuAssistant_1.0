package com.blg.rtu.protocol.p206.cd4F;

import java.io.Serializable;

public class Param_4F implements Serializable{

	private static final long serialVersionUID = 201703201149002L;

	public static final String KEY = Param_4F.class.getName() ;

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
