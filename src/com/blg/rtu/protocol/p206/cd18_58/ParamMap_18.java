package com.blg.rtu.protocol.p206.cd18_58;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParamMap_18 implements Serializable{
	
	public static final String KEY = ParamMap_18.class.getName() ;
	
	private static final long serialVersionUID = 201212021744002L;


	private TreeMap<Integer , Param_18> paramMap ;
	
	public ParamMap_18(){
		paramMap = new TreeMap<Integer , Param_18>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_18>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_18>> it = set.iterator() ;
			Map.Entry<Integer , Param_18> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Param_18> getParamMap() {
		return paramMap;
	}

	public void setParamMap(TreeMap<Integer, Param_18> dataMap) {
		this.paramMap = dataMap;
	}
	
	public void setValue(Integer key , Param_18 value){
		this.paramMap.put(key, value) ;
	}
	
	

}
