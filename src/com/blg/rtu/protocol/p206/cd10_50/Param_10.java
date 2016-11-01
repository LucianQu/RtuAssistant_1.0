package com.blg.rtu.protocol.p206.cd10_50;

import java.io.Serializable;


public class Param_10 implements Serializable{
	private static final long serialVersionUID = 201211292158L;

	public static final String KEY = Param_10.class.getName() ;
	
	private String newId ;
	private String hexNewId ;

	public String toString(){
		String s = "\n" ;
		if(newId != null){
			s += "newId" + "=" + (this.newId==null?"":this.newId) ;
		}
		if(hexNewId != null){
			s += "hexNewId" + "=" + (this.hexNewId==null?"":this.hexNewId) ;
		}
		return s ;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getHexNewId() {
		return hexNewId;
	}

	public void setHexNewId(String hexNewId) {
		this.hexNewId = hexNewId;
	}


}
