package com.blg.rtu.protocol.p206.cd17_57;

import java.util.*;

import com.blg.rtu.protocol.p206.common.data.Data206_2012_Alarm;

public class DataMap_17_57 extends Data206_2012_Alarm{

	private TreeMap<Integer , Data_17_57> dataMap ;
	
	public DataMap_17_57(){
		dataMap = new TreeMap<Integer , Data_17_57>() ;
	}
	
	public String toString(){
		String s = super.toString() ;
		if(dataMap != null){
			Set<Map.Entry<Integer , Data_17_57>> set = dataMap.entrySet() ;
			Iterator<Map.Entry<Integer , Data_17_57>> it = set.iterator() ;
			Map.Entry<Integer , Data_17_57> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Data_17_57> getDataMap() {
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, Data_17_57> dataMap) {
		this.dataMap = dataMap;
	}
	
	public void setValue(Integer key , Data_17_57 value){
		this.dataMap.put(key, value) ;
	}
	
	
}
