package com.blg.rtu.protocol.p206.cd20;

public class Data_20 {
	protected Integer dataType ;//被设置的参数类型
	protected Integer dataCount_1to15 ;//被设置的参数序号
	protected Integer saveInterval_1to255 ;//被设置的参数固态存储时间段间隔(分钟)
	protected Double threshold ; //参数阈值 
	
	
	public String toString(){
		String s = "\n设置的数据类型：\n" ;
		s += dataType.intValue() + " ~ " ;
		if((byte)dataType.intValue() == 0){
			s += "雨量参数\n" ;
		}else if((byte)dataType.intValue() == 1){
			s += "水位参数\n" ;
		}else if((byte)dataType.intValue() == 2){
			s += "流量(水量)参数\n" ;
		}else if((byte)dataType.intValue() == 3){
			s += "流速参数\n" ;
		}else if((byte)dataType.intValue() == 4){
			s += "闸位参数\n" ;
		}else if((byte)dataType.intValue() == 5){
			s += "功率参数\n" ;
		}else if((byte)dataType.intValue() == 6){
			s += "气压参数\n" ;
		}else if((byte)dataType.intValue() == 7){
			s += "风速参数\n" ;
		}else if((byte)dataType.intValue() == 8){
			s += "水温参数\n" ;
		}else if((byte)dataType.intValue() == 9){
			s += "水质参数\n" ;
		}else if((byte)dataType.intValue() == 10){
			s += "土壤含水率参数\n" ;
		}else if((byte)dataType.intValue() == 11){
			s += "蒸发量参数\n" ;
		}else if((byte)dataType.intValue() == 12){
			s += "水压参数\n" ;
		}else{
			s += "出错：参数种类不能识别\n" ;
		}
		
		s += "参数序号: " + dataCount_1to15 + "\n";
		s += "固态存储时间段间隔: " + saveInterval_1to255 + "\n";
		s += "启报阈值: " + threshold + "\n";

		return s ;
	}


	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public Integer getDataCount_1to15() {
		return dataCount_1to15;
	}
	public void setDataCount_1to15(Integer dataCount_1to15) {
		this.dataCount_1to15 = dataCount_1to15;
	}
	public Integer getSaveInterval_1to255() {
		return saveInterval_1to255;
	}
	public void setSaveInterval_1to255(Integer saveInterval_1to255) {
		this.saveInterval_1to255 = saveInterval_1to255;
	}
	public Double getThreshold() {
		return threshold;
	}
	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}
}
