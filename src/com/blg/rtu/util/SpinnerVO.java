package com.blg.rtu.util;

public class SpinnerVO {

	private String id ;
	private String name ;
	
	public SpinnerVO(String id , String name){
		this.id = id ;
		this.name = name ;
	}
	
	public String getId(){
		return this.id ;
	}
	
	public String getName(){
		return this.name ;
	}
	
	/**
	 * 给spinner底层API调用，以填充spinner
	 */
	public String toString(){
		return name ;
	}
}
