package com.blg.rtu.protocol.p206.cd1D_62;

import java.io.Serializable;


public class Param_1D implements Serializable{
	private static final long serialVersionUID = 201212051654001L;

	public static final String KEY = Param_1D.class.getName() ;
	
	private String rtuId ;

	public String toString(){
		String s = "\n" ;
		s += "rtuId" + "=" + (this.rtuId==null?"":this.rtuId) ;
		return s ;
	}

	public String getRtuId() {
		return rtuId;
	}

	public void setRtuId(String rtuId) {
		this.rtuId = rtuId;
	}


}
