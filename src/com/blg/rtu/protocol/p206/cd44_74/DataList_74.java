package com.blg.rtu.protocol.p206.cd44_74;

import java.util.List;


public class DataList_74 {
	
	private List<String> list ;

	public String toString(){
		
		String s = "\n" ;
		for(int i = 0; i < list.size(); i++) {
			s += list.get(i) + "\n";
		}
		return s ;
	}

	public List<String> getRtuId() {
		return this.list;
	}

	public void setRtuId(List<String> rtuId) {
		this.list = rtuId;
	}

}
