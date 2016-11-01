package com.blg.rtu.protocol.p206.cd1B;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParamMap_1B implements Serializable{
	
	public static final String KEY = ParamMap_1B.class.getName() ;
	
	private static final long serialVersionUID = 201212021843001L;


	private TreeMap<Integer , Param_1B> paramMap ;
	
	public ParamMap_1B(){
		paramMap = new TreeMap<Integer , Param_1B>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_1B>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_1B>> it = set.iterator() ;
			Map.Entry<Integer , Param_1B> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Param_1B> getParamMap() {
		return paramMap;
	}

	public void setParamMap(TreeMap<Integer, Param_1B> dataMap) {
		this.paramMap = dataMap;
	}
	
	public void setValue(Integer key , Param_1B value){
		this.paramMap.put(key, value) ;
	}
	
	

}
