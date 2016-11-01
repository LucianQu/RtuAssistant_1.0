package com.blg.rtu.protocol.p206.cd1D_62;


public class Data_1D_62 {
	
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
