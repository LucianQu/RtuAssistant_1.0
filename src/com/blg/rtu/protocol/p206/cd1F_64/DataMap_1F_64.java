package com.blg.rtu.protocol.p206.cd1F_64;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.blg.rtu.protocol.p206.common.data.Data206_2012_Alarm;

public class DataMap_1F_64  extends Data206_2012_Alarm{

	private TreeMap<Integer , Data_1F_64> dataMap ;
	
	public DataMap_1F_64(){
		dataMap = new TreeMap<Integer , Data_1F_64>() ;
	}
	
	public String toString(){
		String s = super.toString() ;
		if(dataMap != null){
			Set<Map.Entry<Integer , Data_1F_64>> set = dataMap.entrySet() ;
			Iterator<Map.Entry<Integer , Data_1F_64>> it = set.iterator() ;
			Map.Entry<Integer , Data_1F_64> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Data_1F_64> getDataMap() {
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, Data_1F_64> dataMap) {
		this.dataMap = dataMap;
	}
	
	public void setValue(Integer key , Data_1F_64 value){
		this.dataMap.put(key, value) ;
	}
	
	
}
