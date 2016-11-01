package com.blg.rtu.protocol.p206.cd1B;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DataMap_1B implements Serializable{
	
	private static final long serialVersionUID = 201212021843001L;


	private TreeMap<Integer , Data_1B> dataMap ;
	
	public DataMap_1B(){
		dataMap = new TreeMap<Integer , Data_1B>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(dataMap != null){
			Set<Map.Entry<Integer , Data_1B>> set = dataMap.entrySet() ;
			Iterator<Map.Entry<Integer , Data_1B>> it = set.iterator() ;
			Map.Entry<Integer , Data_1B> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}


	public void setValue(Integer key , Data_1B value){
		this.dataMap.put(key, value) ;
	}

	public TreeMap<Integer, Data_1B> getDataMap() {
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, Data_1B> dataMap) {
		this.dataMap = dataMap;
	}
	
	

}
