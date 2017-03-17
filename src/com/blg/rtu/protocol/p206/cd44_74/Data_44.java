package com.blg.rtu.protocol.p206.cd44_74;



public class Data_44 {
	
	private String setRtuId ;

	public String toString(){
		
		String s = "\n" ;
		s +="\n设置RTU: " +  setRtuId ;
		return s ;
	}

	public String getRtuId() {
		return this.setRtuId;
	}

	public void setRtuId(String rtuId) {
		this.setRtuId = rtuId;
	}

}
