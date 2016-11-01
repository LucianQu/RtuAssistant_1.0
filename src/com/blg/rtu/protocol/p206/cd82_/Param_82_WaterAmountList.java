package com.blg.rtu.protocol.p206.cd82_;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Param_82_WaterAmountList implements Serializable{

	private static final long serialVersionUID = 2014102021250123L;

	public static final String KEY = Param_82_WaterAmountList.class.getName() ;


	private TreeMap<Integer , Param_82_WaterAmount> paramMap ;
	
	public Param_82_WaterAmountList(){
		paramMap = new TreeMap<Integer , Param_82_WaterAmount>() ;
	}
	
	public String toString(){
		String s = "" ;
		if(paramMap != null){
			Set<Map.Entry<Integer , Param_82_WaterAmount>> set = paramMap.entrySet() ;
			Iterator<Map.Entry<Integer , Param_82_WaterAmount>> it = set.iterator() ;
			Map.Entry<Integer , Param_82_WaterAmount> ent = null ;
			while(it.hasNext()){
				ent = it.next() ;
				s += ent.getKey().intValue() + "=" + ent.getValue().toString() ;
			}
		}
		return s ;
	}

	public TreeMap<Integer , Param_82_WaterAmount> getDataList() {
		return paramMap;
	}

	public void setDataList(TreeMap<Integer , Param_82_WaterAmount> paramMap) {
		this.paramMap = paramMap;
	}

}
