package com.blg.rtu.protocol.p206.cd1D_62;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParamMap_1D implements Serializable{
	
	public static final String KEY = ParamMap_1D.class.getName() ;
	
	private static final long serialVersionUID = 201212051654002L;


	private TreeMap<Integer , Param_1D> paramMap ;
	
	public ParamMap_1D(){
		paramMap = new TreeMap<Integer , Param_1D>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_1D>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_1D>> it = set.iterator() ;
			Map.Entry<Integer , Param_1D> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer, Param_1D> getParamMap() {
		return paramMap;
	}

	public void setParamMap(TreeMap<Integer, Param_1D> dataMap) {
		this.paramMap = dataMap;
	}
	
	public void setValue(Integer key , Param_1D value){
		this.paramMap.put(key, value) ;
	}
	
	

}
