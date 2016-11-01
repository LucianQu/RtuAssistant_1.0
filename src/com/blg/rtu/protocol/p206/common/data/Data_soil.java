package com.blg.rtu.protocol.p206.common.data;

public class Data_soil {
	
	protected Double soil ; 

	public String toString(){
		String s = "\n土壤含水率 : " + (this.soil==null?"":this.soil.doubleValue()) + "\n" ;
		return s ;
	}

	public Double getSoil() {
		return soil;
	}

	public void setSoil(
			Double soil) {
		this.soil = soil;
	}

}
