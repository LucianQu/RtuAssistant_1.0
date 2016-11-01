package com.blg.rtu.protocol.p206.cdA1_53;

import com.blg.rtu.protocol.p206.common.data.ReportDataType206_2012;

public class Data_A1_53 extends ReportDataType206_2012 {
	
	////////////////////
	//参量种类   继承父类

	protected Short baoJing ;//置“1”为上报报警或状态数据 ，清“0”为不上报报警或状态数据
	protected Short shuiYa ;//置“1”为上报水压数据  ，清“0”为不上报水压数据   
//	protected Short dianYa ;//置“1”为上报电压数据  ，清“0”为不上报电压数据   

	/////////////////////////
	//设置各参量主动自报时间间隔
	protected Short yuLiangReportInterval ;//雨量数据 自报时间间隔(分钟)
	protected Short shuiWeiReportInterval ;//水位数据 自报时间间隔(分钟)
	protected Short liuLiangReportInterval ;//流量数据 自报时间间隔(分钟)
	protected Short liuSuReportInterval ;//流速数据 自报时间间隔(分钟)
	protected Short zhaWeiReportInterval ;//闸位数据 自报时间间隔(分钟)
	protected Short gongLuReportInterval ;//功率数据 自报时间间隔(分钟)
	protected Short qiYaReportInterval ;//气压数据 自报时间间隔(分钟)
	protected Short fengSuReportInterval ;//风速（风向）数据 自报时间间隔(分钟)
	protected Short shuiWenReportInterval ;//水温数据 自报时间间隔(分钟)
	protected Short shuiZhiReportInterval ;//水质数据 自报时间间隔(分钟)
	protected Short tuRangReportInterval ;//土壤含水率数据 自报时间间隔(分钟)
	protected Short zhengFaReportInterval ;//蒸发量数据 自报时间间隔(分钟)

	protected Short baoJingReportInterval ;//报警或状态数据 自报时间间隔(分钟)
	protected Short shuiYaReportInterval ;//水压数据 自报时间间隔(分钟)

	public String toString(){
		String s = super.toString() ;
		s += "报警" + "=" + (this.baoJing==null?"":this.baoJing.shortValue()) + "\n" ;
		s += "水压" + "=" + (this.shuiYa==null?"":this.shuiYa.shortValue()) + "\n" ;
//		s += "电压" + "=" + (this.dianYa==null?"":this.dianYa.shortValue()) + "\n" ;
		s += "\n的数据自报时间间隔：\n" ;
		s += "yuLiangReportInterval" + "=" + (this.yuLiangReportInterval==null?"":this.yuLiangReportInterval.shortValue()) + "\n" ;
		s += "shuiWeiReportInterval" + "=" + (this.shuiWeiReportInterval==null?"":this.shuiWeiReportInterval.shortValue()) + "\n" ;
		s += "liuLiangReportInterval" + "=" + (this.liuLiangReportInterval==null?"":this.liuLiangReportInterval.shortValue()) + "\n" ;
		s += "liuSuReportInterval" + "=" + (this.liuSuReportInterval==null?"":this.liuSuReportInterval.shortValue()) + "\n" ; 
		s += "zhaWeiReportInterval" + "=" + (this.zhaWeiReportInterval==null?"":this.zhaWeiReportInterval.shortValue()) + "\n" ;
		s += "gongLuReportInterval" + "=" + (this.gongLuReportInterval==null?"":this.gongLuReportInterval.shortValue()) + "\n" ;
		s += "qiYaReportInterval" + "=" + (this.qiYaReportInterval==null?"":this.qiYaReportInterval.shortValue()) + "\n" ; 
		s += "fengSuReportInterval" + "=" + (this.fengSuReportInterval==null?"":this.fengSuReportInterval.shortValue()) + "\n" ; 
		s += "shuiWenReportInterval" + "=" + (this.shuiWenReportInterval==null?"":this.shuiWenReportInterval.shortValue()) + "\n" ;
		s += "shuiZhiReportInterval" + "=" + (this.shuiZhiReportInterval==null?"":this.shuiZhiReportInterval.shortValue()) + "\n" ;
		s += "tuRangReportInterval" + "=" + (this.tuRangReportInterval==null?"":this.tuRangReportInterval.shortValue()) + "\n" ; 
		s += "zhengFaReportInterval" + "=" + (this.zhengFaReportInterval==null?"":this.zhengFaReportInterval.shortValue()) + "\n" ;

		s += "baoJingReportInterval" + "=" + (this.baoJingReportInterval==null?"":this.baoJingReportInterval.shortValue()) + "\n" ;
		s += "shuiYaReportInterval" + "=" + (this.shuiYaReportInterval==null?"":this.shuiYaReportInterval.shortValue()) + "\n" ;
		
		return s ;
	}

//	public Short getDianYa() {
//		return dianYa;
//	}
//
//	public void setDianYa(Short dianYa) {
//		this.dianYa = dianYa;
//	}

	public Short getBaoJing() {
		return baoJing;
	}

	public void setBaoJing(Short baoJing) {
		this.baoJing = baoJing;
	}

	public Short getShuiYa() {
		return shuiYa;
	}

	public void setShuiYa(Short shuiYa) {
		this.shuiYa = shuiYa;
	}

	public Short getYuLiangReportInterval() {
		return yuLiangReportInterval;
	}

	public void setYuLiangReportInterval(
			Short yuLiangReportInterval) {
		this.yuLiangReportInterval = yuLiangReportInterval;
	}

	public Short getShuiWeiReportInterval() {
		return shuiWeiReportInterval;
	}

	public void setShuiWeiReportInterval(
			Short shuiWeiReportInterval) {
		this.shuiWeiReportInterval = shuiWeiReportInterval;
	}

	public Short getLiuLiangReportInterval() {
		return liuLiangReportInterval;
	}

	public void setLiuLiangReportInterval(
			Short liuLiangReportInterval) {
		this.liuLiangReportInterval = liuLiangReportInterval;
	}

	public Short getLiuSuReportInterval() {
		return liuSuReportInterval;
	}

	public void setLiuSuReportInterval(Short liuSuReportInterval) {
		this.liuSuReportInterval = liuSuReportInterval;
	}

	public Short getZhaWeiReportInterval() {
		return zhaWeiReportInterval;
	}

	public void setZhaWeiReportInterval(
			Short zhaWeiReportInterval) {
		this.zhaWeiReportInterval = zhaWeiReportInterval;
	}

	public Short getGongLuReportInterval() {
		return gongLuReportInterval;
	}

	public void setGongLuReportInterval(
			Short gongLuReportInterval) {
		this.gongLuReportInterval = gongLuReportInterval;
	}

	public Short getQiYaReportInterval() {
		return qiYaReportInterval;
	}

	public void setQiYaReportInterval(Short qiYaReportInterval) {
		this.qiYaReportInterval = qiYaReportInterval;
	}

	public Short getFengSuReportInterval() {
		return fengSuReportInterval;
	}

	public void setFengSuReportInterval(
			Short fengSuReportInterval) {
		this.fengSuReportInterval = fengSuReportInterval;
	}

	public Short getShuiWenReportInterval() {
		return shuiWenReportInterval;
	}

	public void setShuiWenReportInterval(
			Short shuiWenReportInterval) {
		this.shuiWenReportInterval = shuiWenReportInterval;
	}

	public Short getShuiZhiReportInterval() {
		return shuiZhiReportInterval;
	}

	public void setShuiZhiReportInterval(
			Short shuiZhiReportInterval) {
		this.shuiZhiReportInterval = shuiZhiReportInterval;
	}

	public Short getTuRangReportInterval() {
		return tuRangReportInterval;
	}

	public void setTuRangReportInterval(
			Short tuRangReportInterval) {
		this.tuRangReportInterval = tuRangReportInterval;
	}

	public Short getZhengFaReportInterval() {
		return zhengFaReportInterval;
	}

	public void setZhengFaReportInterval(
			Short zhengFaReportInterval) {
		this.zhengFaReportInterval = zhengFaReportInterval;
	}

	public Short getBaoJingReportInterval() {
		return baoJingReportInterval;
	}

	public void setBaoJingReportInterval(Short baoJingReportInterval) {
		this.baoJingReportInterval = baoJingReportInterval;
	}

	public Short getShuiYaReportInterval() {
		return shuiYaReportInterval;
	}

	public void setShuiYaReportInterval(Short shuiYaReportInterval) {
		this.shuiYaReportInterval = shuiYaReportInterval;
	}


//	public Short getQiWenReportInterval() {
//		return qiWenReportInterval;
//	}
//
//	public void setQiWenReportInterval(Short qiWenReportInterval) {
//		this.qiWenReportInterval = qiWenReportInterval;
//	}
//
//	public Short getDianChiReportInterval() {
//		return dianChiReportInterval;
//	}
//
//	public void setDianChiReportInterval(
//			Short dianChiReportInterval) {
//		this.dianChiReportInterval = dianChiReportInterval;
//	}
//
//	public Short getGsmXinQiangReportInterval() {
//		return gsmXinQiangReportInterval;
//	}
//
//	public void setGsmXinQiangReportInterval(
//			Short gsmXinQiangReportInterval) {
//		this.gsmXinQiangReportInterval = gsmXinQiangReportInterval;
//	}
	

}