package com.blg.rtu.protocol.p206.common.data;

import java.util.*;

import com.blg.rtu.protocol.p206.common.data.Data206_2012_AlarmStatus;;

public class DataMap  extends Data206_2012_AlarmStatus {
	
	protected TreeMap<Integer , Object> dataMap ;
	
	public DataMap(){
		dataMap = new TreeMap<Integer , Object>() ;
	}
	
	public String toString(){
		String s = super.toString() ;
		if(dataMap != null){
			Set<Map.Entry<Integer , Object>> set = dataMap.entrySet() ;
			Iterator<Map.Entry<Integer , Object>> it = set.iterator() ;
			Map.Entry<Integer , Object> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public void setValue(Integer key , Object value){
		this.dataMap.put(key, value) ;
	}
	
	
}
