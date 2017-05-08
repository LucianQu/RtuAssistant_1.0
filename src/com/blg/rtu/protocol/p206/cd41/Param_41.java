package com.blg.rtu.protocol.p206.cd41;

import java.io.Serializable;

public class Param_41 implements Serializable{

	private static final long serialVersionUID = 201703201149002L;

	public static final String KEY = Param_41.class.getName() ;

	//private String oldPassword ;//旧密码
	private String newPassword ;//新密码
	
	public String toString(){
		String s = "" ;
		s += "\n新密码: " + newPassword + "\n" ;
		/*if(oldPassword != null){
			s += "\n旧密码: " + oldPassword + "\n" ;
		}else if(newPassword != null){
			s += "\n新密码: " + newPassword + "\n" ;
		}*/
		
		return s ;
	}

	/*public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}*/

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	


}
