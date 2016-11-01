package com.blg.rtu.protocol.p206.cd82_;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Param_82_WaterLevelList implements Serializable{

	private static final long serialVersionUID = 201410202125001L;

	public static final String KEY = Param_82_WaterLevelList.class.getName() ;


	private TreeMap<Integer , Param_82_WaterLevel> paramMap ;
	
	public Param_82_WaterLevelList(){
		paramMap = new TreeMap<Integer , Param_82_WaterLevel>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_82_WaterLevel>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_82_WaterLevel>> it = set.iterator() ;
			Map.Entry<Integer , Param_82_WaterLevel> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer , Param_82_WaterLevel> getDataList() {
		return paramMap;
	}

	public void setDataList(TreeMap<Integer , Param_82_WaterLevel> paramMap) {
		this.paramMap = paramMap;
	}

}
