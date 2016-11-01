package com.blg.rtu.protocol.p206.common.data;

public class Data_rain {
	
	protected Double rain ; 

	public String toString(){
		String s = "\n雨量 = " + (this.rain==null?"":this.rain.doubleValue()) + "(毫米)\n" ;
		return s ;
	}

	public Double getRain() {
		return rain;
	}

	public void setRain(
			Double rain) {
		this.rain = rain;
	}

}
