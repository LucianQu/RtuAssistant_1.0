package com.blg.rtu.protocol.p206.cd10_50;


public class Data_10_50 {
	
	private String rtuId ;
	private String rtuIdHex ;

	public String toString(){
		String s = "\n" ;
		s += "rtuId" + "=" + (this.rtuId==null?"":this.rtuId) ;
		s += "rtuIdHex" + "=" + (this.rtuIdHex==null?"":this.rtuIdHex) ;
		return s ;
	}

	public String getRtuId() {
		return rtuId;
	}

	public void setRtuId(String rtuId) {
		this.rtuId = rtuId;
	}

	public String getRtuIdHex() {
		return rtuIdHex;
	}

	public void setRtuIdHex(String rtuIdHex) {
		this.rtuIdHex = rtuIdHex;
	}


}
