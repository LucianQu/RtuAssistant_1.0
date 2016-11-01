package com.blg.rtu.protocol.p206.cdA1_53;

import com.blg.rtu.protocol.p206.common.data.ParamDataType206_2012;

//1) D0——置“1”为主动上报雨量数据，清“0”为不上报雨量数据；
//2) D1——置“1”为主动上报水位数据，清“0”为不上报水位数据；
//3) D2——置“1”为主动上报流量（水量）数据，清“0”为不上报流量（水量）数据；
//4) D3——置“1”为主动上报流速数据，清“0”为不上报流速数据；
//5) D4——置“1”为主动上报闸位数据，清“0”为不上报闸位数据；
//6) D5——置“1”为主动上报功率数据，清“0”为不上报功率数据；
//7) D6——置“1”为主动上报气压数据，清“0”为不上报气压数据；
//8) D7——置“1”为出现上报风速（风向）数据，清“0”为不上报风速（风向）数据；
//9) D8——置“1”为主动上报水温数据，清“0”为不上报水温数据；
//10) D9——置“1”为主动上报水质数据，清“0”为不上报水质数据；
//11) D10——置“1”为主动上报土壤含水率数据，清“0”为不上报土壤含水率数据；
//12) D11——置“1”为主动上报蒸发量数据，清“0”为不上报蒸发量数据；
//13) D12——置“1”为主动上报报警或状态数据，清“0”为不上报报警或状态数据；
//14) D13——置“1”为主动上报水压数据，清“0”为不上报水压数据；
//15) D14——置“1”为主动上报电压数据，清“0”为不上报电压数据；

public class Param_A1 extends ParamDataType206_2012{

	private static final long serialVersionUID = 201212021529002L;

	public static final String KEY = Param_A1.class.getName() ;
	
	////////////////////
	//参量种类   继承父类
	
	protected Integer baoJing_0or1 ;//置“1”为上报报警或状态数据，清“0”为不上报
	protected Integer shuiYa_0or1 ;//置“1”为上报水压数据，清“0”为不上报
//	protected Integer dianYa_0or1 ;//置“1”为主动上报电压数据，清“0”为不上报电压数据；

	/////////////////////////
	//设置各参量主动自报时间间隔
	protected Short yuLiangReportInterval_1to9999 ;//雨量数据 自报时间间隔(分钟)
	protected Short shuiWeiReportInterval_1to9999 ;//水位数据 自报时间间隔(分钟)
	protected Short liuLiangReportInterval_1to9999 ;//流量数据 自报时间间隔(分钟)
	protected Short liuSuReportInterval_1to9999 ;//流速数据 自报时间间隔(分钟)
	protected Short zhaWeiReportInterval_1to9999 ;//闸位数据 自报时间间隔(分钟)
	protected Short gongLuReportInterval_1to9999 ;//功率数据 自报时间间隔(分钟)
	protected Short qiYaReportInterval_1to9999 ;//气压数据 自报时间间隔(分钟)
	protected Short fengSuReportInterval_1to9999 ;//风速（风向）数据 自报时间间隔(分钟)
	protected Short shuiWenReportInterval_1to9999 ;//水温数据 自报时间间隔(分钟)
	protected Short shuiZhiReportInterval_1to9999 ;//水质数据 自报时间间隔(分钟)
	protected Short tuRangReportInterval_1to9999 ;//土壤含水率数据 自报时间间隔(分钟)
	protected Short zhengFaReportInterval_1to9999 ;//蒸发量数据 自报时间间隔(分钟)
	
	protected Short baoJingReportInterval_1to9999 ;//报警或状态数据 自报时间间隔(分钟)
	protected Short shuiYaReportInterval_1to9999 ;//水压数据 自报时间间隔(分钟)
//	protected Short dianYaReportInterval_1to9999 ;//电压数据 自报时间间隔(分钟)
	
//	protected Short qiWenReportInterval_1to9999 ;//气温数据 自报时间间隔(分钟)
//	protected Short dianChiReportInterval_1to9999 ;//蓄电池电压数据 自报时间间隔(分钟)
//	protected Short gsmXinQiangReportInterval_1to9999 ;//GSM网络信号强度数据 自报时间间隔(分钟)


	public String toString(){
		String s = super.toString() ;
		s += "baoJing" + "=" + (this.baoJing_0or1==null?"":this.baoJing_0or1.intValue()) + "\n" ;
		s += "shuiYa" + "=" + (this.shuiYa_0or1==null?"":this.shuiYa_0or1.intValue()) + "\n" ;
//		s += "dianYa" + "=" + (this.dianYa_0or1==null?"":this.dianYa_0or1.intValue()) + "\n" ;

		s += "\n设置的数据自报时间间隔：\n" ;
		s += "yuLiangReportInterval" + "=" + (this.yuLiangReportInterval_1to9999==null?"":this.yuLiangReportInterval_1to9999.intValue()) + "\n" ;
		s += "shuiWeiReportInterval" + "=" + (this.shuiWeiReportInterval_1to9999==null?"":this.shuiWeiReportInterval_1to9999.intValue()) + "\n" ;
		s += "liuLiangReportInterval" + "=" + (this.liuLiangReportInterval_1to9999==null?"":this.liuLiangReportInterval_1to9999.intValue()) + "\n" ;
		s += "liuSuReportInterval" + "=" + (this.liuSuReportInterval_1to9999==null?"":this.liuSuReportInterval_1to9999.intValue()) + "\n" ; 
		s += "zhaWeiReportInterval" + "=" + (this.zhaWeiReportInterval_1to9999==null?"":this.zhaWeiReportInterval_1to9999.intValue()) + "\n" ;
		s += "gongLuReportInterval" + "=" + (this.gongLuReportInterval_1to9999==null?"":this.gongLuReportInterval_1to9999.intValue()) + "\n" ;
		s += "qiYaReportInterval" + "=" + (this.qiYaReportInterval_1to9999==null?"":this.qiYaReportInterval_1to9999.intValue()) + "\n" ; 
		s += "fengSuReportInterval" + "=" + (this.fengSuReportInterval_1to9999==null?"":this.fengSuReportInterval_1to9999.intValue()) + "\n" ; 
		s += "shuiWenReportInterval" + "=" + (this.shuiWenReportInterval_1to9999==null?"":this.shuiWenReportInterval_1to9999.intValue()) + "\n" ;
		s += "shuiZhiReportInterval" + "=" + (this.shuiZhiReportInterval_1to9999==null?"":this.shuiZhiReportInterval_1to9999.intValue()) + "\n" ;
		s += "tuRangReportInterval" + "=" + (this.tuRangReportInterval_1to9999==null?"":this.tuRangReportInterval_1to9999.intValue()) + "\n" ; 
		s += "zhengFaReportInterval" + "=" + (this.zhengFaReportInterval_1to9999==null?"":this.zhengFaReportInterval_1to9999.intValue()) + "\n" ;

		s += "baoJingReportInterval" + "=" + (this.baoJingReportInterval_1to9999==null?"":this.baoJingReportInterval_1to9999.intValue()) + "\n" ;
		s += "shuiYaReportInterval" + "=" + (this.shuiYaReportInterval_1to9999==null?"":this.shuiYaReportInterval_1to9999.intValue()) + "\n" ;
//		s += "dianYaReportInterval_1to9999" + "=" + (this.dianYaReportInterval_1to9999==null?"":this.dianYaReportInterval_1to9999.intValue()) + "\n" ;
		
//		s += "qiWenReportInterval" + "=" + (this.qiWenReportInterval_1to9999==null?"":this.qiWenReportInterval_1to9999.intValue()) + "\n" ;
//		s += "dianChiReportInterval" + "=" + (this.dianChiReportInterval_1to9999==null?"":this.dianChiReportInterval_1to9999.intValue()) + "\n" ;
//		s += "gsmXinQiangReportInterval" + "=" + (this.gsmXinQiangReportInterval_1to9999==null?"":this.gsmXinQiangReportInterval_1to9999.intValue()) + "\n" ;
		return s ;
	}
	

//	public Integer getDianYa_0or1() {
//		return dianYa_0or1;
//	}
//
//	public void setDianYa_0or1(Integer dianYa_0or1) {
//		this.dianYa_0or1 = dianYa_0or1;
//	}

	public Integer getBaoJing_0or1() {
		return baoJing_0or1;
	}

	public void setBaoJing_0or1(Integer baoJing_0or1) {
		this.baoJing_0or1 = baoJing_0or1;
	}

	public Integer getShuiYa_0or1() {
		return shuiYa_0or1;
	}

	public void setShuiYa_0or1(Integer shuiYa_0or1) {
		this.shuiYa_0or1 = shuiYa_0or1;
	}

	public Short getYuLiangReportInterval_1to9999() {
		return yuLiangReportInterval_1to9999;
	}

	public void setYuLiangReportInterval_1to9999(
			Short yuLiangReportInterval_1to9999) {
		this.yuLiangReportInterval_1to9999 = yuLiangReportInterval_1to9999;
	}

	public Short getShuiWeiReportInterval_1to9999() {
		return shuiWeiReportInterval_1to9999;
	}

	public void setShuiWeiReportInterval_1to9999(
			Short shuiWeiReportInterval_1to9999) {
		this.shuiWeiReportInterval_1to9999 = shuiWeiReportInterval_1to9999;
	}

	public Short getLiuLiangReportInterval_1to9999() {
		return liuLiangReportInterval_1to9999;
	}

	public void setLiuLiangReportInterval_1to9999(
			Short liuLiangReportInterval_1to9999) {
		this.liuLiangReportInterval_1to9999 = liuLiangReportInterval_1to9999;
	}

	public Short getLiuSuReportInterval_1to9999() {
		return liuSuReportInterval_1to9999;
	}

	public void setLiuSuReportInterval_1to9999(Short liuSuReportInterval_1to9999) {
		this.liuSuReportInterval_1to9999 = liuSuReportInterval_1to9999;
	}

	public Short getZhaWeiReportInterval_1to9999() {
		return zhaWeiReportInterval_1to9999;
	}

	public void setZhaWeiReportInterval_1to9999(
			Short zhaWeiReportInterval_1to9999) {
		this.zhaWeiReportInterval_1to9999 = zhaWeiReportInterval_1to9999;
	}

	public Short getGongLuReportInterval_1to9999() {
		return gongLuReportInterval_1to9999;
	}

	public void setGongLuReportInterval_1to9999(
			Short gongLuReportInterval_1to9999) {
		this.gongLuReportInterval_1to9999 = gongLuReportInterval_1to9999;
	}

	public Short getQiYaReportInterval_1to9999() {
		return qiYaReportInterval_1to9999;
	}

	public void setQiYaReportInterval_1to9999(Short qiYaReportInterval_1to9999) {
		this.qiYaReportInterval_1to9999 = qiYaReportInterval_1to9999;
	}

	public Short getFengSuReportInterval_1to9999() {
		return fengSuReportInterval_1to9999;
	}

	public void setFengSuReportInterval_1to9999(
			Short fengSuReportInterval_1to9999) {
		this.fengSuReportInterval_1to9999 = fengSuReportInterval_1to9999;
	}

	public Short getShuiWenReportInterval_1to9999() {
		return shuiWenReportInterval_1to9999;
	}

	public void setShuiWenReportInterval_1to9999(
			Short shuiWenReportInterval_1to9999) {
		this.shuiWenReportInterval_1to9999 = shuiWenReportInterval_1to9999;
	}

	public Short getShuiZhiReportInterval_1to9999() {
		return shuiZhiReportInterval_1to9999;
	}

	public void setShuiZhiReportInterval_1to9999(
			Short shuiZhiReportInterval_1to9999) {
		this.shuiZhiReportInterval_1to9999 = shuiZhiReportInterval_1to9999;
	}

	public Short getTuRangReportInterval_1to9999() {
		return tuRangReportInterval_1to9999;
	}

	public void setTuRangReportInterval_1to9999(
			Short tuRangReportInterval_1to9999) {
		this.tuRangReportInterval_1to9999 = tuRangReportInterval_1to9999;
	}

	public Short getZhengFaReportInterval_1to9999() {
		return zhengFaReportInterval_1to9999;
	}

	public void setZhengFaReportInterval_1to9999(
			Short zhengFaReportInterval_1to9999) {
		this.zhengFaReportInterval_1to9999 = zhengFaReportInterval_1to9999;
	}

	public Short getBaoJingReportInterval_1to9999() {
		return baoJingReportInterval_1to9999;
	}

	public void setBaoJingReportInterval_1to9999(
			Short baoJingReportInterval_1to9999) {
		this.baoJingReportInterval_1to9999 = baoJingReportInterval_1to9999;
	}

	public Short getShuiYaReportInterval_1to9999() {
		return shuiYaReportInterval_1to9999;
	}

	public void setShuiYaReportInterval_1to9999(Short shuiYaReportInterval_1to9999) {
		this.shuiYaReportInterval_1to9999 = shuiYaReportInterval_1to9999;
	}

//	public Short getDianYaReportInterval_1to9999() {
//		return dianYaReportInterval_1to9999;
//	}
//
//
//	public void setDianYaReportInterval_1to9999(Short dianYaReportInterval_1to9999) {
//		this.dianYaReportInterval_1to9999 = dianYaReportInterval_1to9999;
//	}


}
