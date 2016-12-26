package com.blg.rtu.protocol.p206.cdED;

import java.util.ArrayList;
import java.util.List;

public class DataList_ED {
	
	
	
	private List<Data_ED> datas  ;
	
	public DataList_ED(){
		this.datas = new ArrayList<Data_ED>() ;
	}

	public List<Data_ED> getDatas() {
		return datas;
	}

	public void setDatas(List<Data_ED> datas) {
		this.datas = datas;
	}
	
	
	
}
