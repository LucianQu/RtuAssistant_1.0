package com.blg.rtu.protocol.p206.cdB1;

import java.io.Serializable;

import com.blg.rtu.protocol.p206.util.Constant;

public class Param_B1 implements Serializable{
	
	private static final long serialVersionUID = 201212051145001L;

	public static final String KEY = Param_B1.class.getName() ;
	
	protected Integer dataType ;//查询的数据类型 对应 数据帧控制域的功能码
	protected Integer dataCount_0to15 ;//被查询参数的编号
	
	protected String startDt ;//查询起始日期(年-月-日 时)
	protected String endDt ;//查询截止日期(年-月-日 时)
	
	
	public String toString(){
		
		String s = "\n查询的数据类型：\n" ;
		s += dataType.intValue() + " ~ " ;
		if((byte)dataType.intValue() == Constant.Down_ControlFunCode_1){
			s += "雨量参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_2){
			s += "水位参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_3){
			s += "流量(水量)参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_4){
			s += "流速参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_5){
			s += "闸位参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_6){
			s += "功率参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_7){
			s += "气压参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_8){
			s += "风速参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_9){
			s += "水温参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_10){
			s += "水质参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_11){
			s += "土壤含水率参数\n" ;
		//}
		//else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_12){
		//	s += "蒸发量参数\n" ;
		//}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_13){
		//	s += "报警或状态参数\n" ;
		//}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_14){
		//	s += "综合参数\n" ;
		}else if((byte)dataType.intValue() == Constant.Down_ControlFunCode_1){
			s += "水压参数\n" ;
		}
		s += "被查询参数的编号 ：" + this.dataCount_0to15 + "\n";
		
		s += "查询起始日期(年-月-日 时) ：" + this.startDt + "\n" ;
		s += "查询截止日期(年-月-日 时) ：" + this.endDt + "\n" ;
		return s ;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
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

	public Integer getDataCount_0to15() {
		return dataCount_0to15;
	}

	public void setDataCount_0to15(Integer dataCount) {
		this.dataCount_0to15 = dataCount;
	}
	
	
}