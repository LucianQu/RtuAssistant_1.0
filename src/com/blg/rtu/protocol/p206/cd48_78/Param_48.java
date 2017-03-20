package com.blg.rtu.protocol.p206.cd48_78;

import java.io.Serializable;

public class Param_48 implements Serializable{
	
	private static final long serialVersionUID = 201703201149010L;

	public static final String KEY = Param_48.class.getName() ;
	public static final int diameter_DN50 = 0 ;//口径50
	public static final int diameter_DN80 = 1 ;//口径80
	public static final int diameter_DN100 = 2 ;//口径100
	public static final int diameter_DN150 = 3 ;//口径150
	protected Integer diameter ;//
	
	public String toString(){
		String s = "\n表口径：\n" ;
		s += "口径=" + diameter + "\n" ;
		return s ;
	}

	public Integer getDiameter() {
		return diameter;
	}

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}



}
