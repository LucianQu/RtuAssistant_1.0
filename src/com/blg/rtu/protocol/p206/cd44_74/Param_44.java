package com.blg.rtu.protocol.p206.cd44_74;

import java.io.Serializable;


public class Param_44 implements Serializable{
	private static final long serialVersionUID = 201211292158L;

	public static final String KEY = Param_44.class.getName() ;
	
	private String newId ;
	private String hexNewId ;
	private String selectId ;
	private int selectPosition ;
	
	public String toString(){
		String s = "\n" ;
		if(newId != null){
			s += "newId" + "=" + (this.newId==null?"":this.newId) ;
		}
		if(hexNewId != null){
			s += "hexNewId" + "=" + (this.hexNewId==null?"":this.hexNewId) ;
		}
		if(selectId != null){
			s += "selectId" + "=" + (this.selectId==null?"":this.selectId) ;
		}
		return s ;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}
	
	public int getSelectPosition() {
		return selectPosition;
	}

	public void setSelectPosition(int selectPosition) {
		this.selectPosition = selectPosition;
	}
	
	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	public String getHexNewId() {
		return hexNewId;
	}

	public void setHexNewId(String hexNewId) {
		this.hexNewId = hexNewId;
	}


}
