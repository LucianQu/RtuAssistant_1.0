package com.blg.rtu.protocol.p206.cdB1;

import java.util.ArrayList;
import java.util.List;

public class DataList_B1 {

	private String startDt ;
	private String endDt ;
	private String dataName ;//参数类型
	private Integer dataCount ;//参数序号
	
	private List<Data_B1> datas  ;
	
	public String toString(){
		String s = super.toString() ;
		
		s += "\n参数类型：" + dataName ;
		s += "\n参数序号：" + dataCount ;
		s += "\n开始时间：" + startDt ;
		s += "\n截止时间：" + endDt ;
		
		for(Data_B1 d : datas){
			s += d.toString() ;
		}

		return s ;
	}
	
	public DataList_B1(){
		this.datas = new ArrayList<Data_B1>() ;
	}

	public List<Data_B1> getDatas() {
		return datas;
	}

	public void setDatas(List<Data_B1> datas) {
		this.datas = datas;
	}
	

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}
	
	
}
