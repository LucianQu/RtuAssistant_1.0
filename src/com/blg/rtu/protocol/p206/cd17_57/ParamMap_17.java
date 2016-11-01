package com.blg.rtu.protocol.p206.cd17_57;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParamMap_17 implements Serializable{
	
	public static final String KEY = ParamMap_17.class.getName() ;
	
	private static final long serialVersionUID = 201212021618002L;


	private TreeMap<Integer , Param_17> paramMap ;
	
	public ParamMap_17(){
		paramMap = new TreeMap<Integer , Param_17>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_17>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_17>> it = set.iterator() ;
			Map.Entry<Integer , Param_17> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Param_17> getParamMap() {
		return paramMap;
	}

	public void setParamMap(TreeMap<Integer, Param_17> dataMap) {
		this.paramMap = dataMap;
	}
	
	public void setValue(Integer key , Param_17 value){
		this.paramMap.put(key, value) ;
	}
	
	

}
