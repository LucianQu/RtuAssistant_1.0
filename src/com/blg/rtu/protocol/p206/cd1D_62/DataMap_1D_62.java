package com.blg.rtu.protocol.p206.cd1D_62;

import java.util.*;

public class DataMap_1D_62{

	private TreeMap<Integer , Data_1D_62> dataMap ;
	
	public DataMap_1D_62(){
		dataMap = new TreeMap<Integer , Data_1D_62>() ;
	}
	
	public String toString(){
		String s = super.toString() ;
		if(dataMap != null){
			Set<Map.Entry<Integer , Data_1D_62>> set = dataMap.entrySet() ;
			Iterator<Map.Entry<Integer , Data_1D_62>> it = set.iterator() ;
			Map.Entry<Integer , Data_1D_62> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Data_1D_62> getDataMap() {
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, Data_1D_62> dataMap) {
		this.dataMap = dataMap;
	}
	
	public void setValue(Integer key , Data_1D_62 value){
		this.dataMap.put(key, value) ;
	}
	
	
}
