package com.blg.rtu.protocol.p206.cd18_58;

import java.util.*;

import com.blg.rtu.protocol.p206.common.data.Data206_2012_Alarm;

public class DataMap_58 extends Data206_2012_Alarm{

	private TreeMap<Integer , Data_58> dataMap ;
	
	public DataMap_58(){
		dataMap = new TreeMap<Integer , Data_58>() ;
	}
	
	public String toString(){
		String s = super.toString() ;
		if(dataMap != null){
			Set<Map.Entry<Integer , Data_58>> set = dataMap.entrySet() ;
			Iterator<Map.Entry<Integer , Data_58>> it = set.iterator() ;
			Map.Entry<Integer , Data_58> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Data_58> getDataMap() {
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, Data_58> dataMap) {
		this.dataMap = dataMap;
	}
	
	public void setValue(Integer key , Data_58 value){
		this.dataMap.put(key, value) ;
	}
	
	
}
