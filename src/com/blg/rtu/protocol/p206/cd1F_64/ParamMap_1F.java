package com.blg.rtu.protocol.p206.cd1F_64;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParamMap_1F implements Serializable{
	
	public static final String KEY = ParamMap_1F.class.getName() ;
	
	private static final long serialVersionUID = 201212031600002L;


	private TreeMap<Integer , Param_1F> paramMap ;
	
	public ParamMap_1F(){
		paramMap = new TreeMap<Integer , Param_1F>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_1F>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_1F>> it = set.iterator() ;
			Map.Entry<Integer , Param_1F> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Param_1F> getParamMap() {
		return paramMap;
	}

	public void setParamMap(TreeMap<Integer, Param_1F> dataMap) {
		this.paramMap = dataMap;
	}
	
	public void setValue(Integer key , Param_1F value){
		this.paramMap.put(key, value) ;
	}
	
	

}
