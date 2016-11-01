package com.blg.rtu.protocol.p206.common.data;

import java.io.Serializable;

public class ParamDataType206_2012  implements Serializable{
	private static final long serialVersionUID = 201212021529001L;

	
	////////////////////////////////
	//上报种类
	protected Integer yuLiang_0or1 ;//置“1”为上报雨量数据，清“0”为不上报雨量数据；
	protected Integer shuiWei_0or1 ;//置“1”为上报水位数据，清“0”为不上报水位数据；
	protected Integer liuLiang_0or1 ;//置“1”为上报流量数据，清“0”为不上报流量数据；
	protected Integer liuSu_0or1 ;//置“1”为上报流速数据，清“0”为不上报流速数据；
	protected Integer zhaWei_0or1 ;//置“1”为上报闸位数据，清“0”为不上报闸位数据；
	protected Integer gongLu_0or1 ;//置“1”为上报功率数据，清“0”为不上报功率数据；
	protected Integer qiYa_0or1 ;//置“1”为上报气压数据，清“0”为不上报气压数据；
	protected Integer fengSu_0or1 ;//置“1”为上报风速（风向）数据，清“0”为不上报风速数据；
	protected Integer shuiWen_0or1 ;//置“1”为上报水温数据，清“0”为不上报水温数据；
	protected Integer shuiZhi_0or1 ;//置“1”为上报水质数据，清“0”为不上报水质数据；
	protected Integer tuRang_0or1 ;//置“1”为上报土壤含水率数据，清“0”为不上报土壤含水率数据；
	protected Integer zhengFa_0or1 ;//置“1”为上报蒸发量数据，清“0”为不上报蒸发量数据；

	
//	protected Integer qiWen_0or1 ;//置“1”为上报气温数据，清“0”为不上报气温数据；
//	protected Integer dianChi_0or1 ;//置“1”为上报蓄电池电压数据，清“0”为不上报蓄电池电压数据；
//	protected Integer gsmXinQiang_0or1 ;//置“1”为上报GSM网络信号强度数据，清“0”为不上报GSM网络信号强度数据；

	public String toString(){
		String s = "\n设置报数据种类：\n" ;
		s += "yuLiang" + "=" + (this.yuLiang_0or1==null?"":this.yuLiang_0or1.intValue()) + "\\" ;
		s += "shuiWei" + "=" + (this.shuiWei_0or1==null?"":this.shuiWei_0or1.intValue()) + "\\" ;
		s += "liuLiang" + "=" + (this.liuLiang_0or1==null?"":this.liuLiang_0or1.intValue()) + "\\" ;
		s += "liuSu" + "=" + (this.liuSu_0or1==null?"":this.liuSu_0or1.intValue()) + "\\" ; 
		s += "zhaWei" + "=" + (this.zhaWei_0or1==null?"":this.zhaWei_0or1.intValue()) + "\\" ;
		s += "gongLu" + "=" + (this.gongLu_0or1==null?"":this.gongLu_0or1.intValue()) + "\\" ;
		s += "qiYa" + "=" + (this.qiYa_0or1==null?"":this.qiYa_0or1.intValue()) + "\\" ; 
		s += "fengSu" + "=" + (this.fengSu_0or1==null?"":this.fengSu_0or1.intValue()) + "\\" ; 
		s += "shuiWen" + "=" + (this.shuiWen_0or1==null?"":this.shuiWen_0or1.intValue()) + "\\" ;
		s += "shuiZhi" + "=" + (this.shuiZhi_0or1==null?"":this.shuiZhi_0or1.intValue()) + "\\" ;
		s += "tuRang" + "=" + (this.tuRang_0or1==null?"":this.tuRang_0or1.intValue()) + "\\" ; 
		s += "zhengFa" + "=" + (this.zhengFa_0or1==null?"":this.zhengFa_0or1.intValue()) + "\n" ;

//		s += "qiWen" + "=" + (this.qiWen_0or1==null?"":this.qiWen_0or1.intValue()) + "\n" ;
//		s += "dianChi" + "=" + (this.dianChi_0or1==null?"":this.dianChi_0or1.intValue()) + "\n" ;
//		s += "gsmXinQiang" + "=" + (this.gsmXinQiang_0or1==null?"":this.gsmXinQiang_0or1.intValue()) + "\n" ;
		return s ;
	}
	
	public Integer getYuLiang_0or1() {
		return yuLiang_0or1;
	}
	public void setYuLiang_0or1(Integer yuLiang_0or1) {
		this.yuLiang_0or1 = yuLiang_0or1;
	}
	public Integer getShuiWei_0or1() {
		return shuiWei_0or1;
	}
	public void setShuiWei_0or1(Integer shuiWei_0or1) {
		this.shuiWei_0or1 = shuiWei_0or1;
	}
	public Integer getLiuLiang_0or1() {
		return liuLiang_0or1;
	}
	public void setLiuLiang_0or1(Integer liuLiang_0or1) {
		this.liuLiang_0or1 = liuLiang_0or1;
	}
	public Integer getLiuSu_0or1() {
		return liuSu_0or1;
	}
	public void setLiuSu_0or1(Integer liuSu_0or1) {
		this.liuSu_0or1 = liuSu_0or1;
	}
	public Integer getZhaWei_0or1() {
		return zhaWei_0or1;
	}
	public void setZhaWei_0or1(Integer zhaWei_0or1) {
		this.zhaWei_0or1 = zhaWei_0or1;
	}
	public Integer getGongLu_0or1() {
		return gongLu_0or1;
	}
	public void setGongLu_0or1(Integer gongLu_0or1) {
		this.gongLu_0or1 = gongLu_0or1;
	}
	public Integer getQiYa_0or1() {
		return qiYa_0or1;
	}
	public void setQiYa_0or1(Integer qiYa_0or1) {
		this.qiYa_0or1 = qiYa_0or1;
	}
	public Integer getFengSu_0or1() {
		return fengSu_0or1;
	}
	public void setFengSu_0or1(Integer fengSu_0or1) {
		this.fengSu_0or1 = fengSu_0or1;
	}
	public Integer getShuiWen_0or1() {
		return shuiWen_0or1;
	}
	public void setShuiWen_0or1(Integer shuiWen_0or1) {
		this.shuiWen_0or1 = shuiWen_0or1;
	}
	public Integer getShuiZhi_0or1() {
		return shuiZhi_0or1;
	}
	public void setShuiZhi_0or1(Integer shuiZhi_0or1) {
		this.shuiZhi_0or1 = shuiZhi_0or1;
	}
	public Integer getTuRang_0or1() {
		return tuRang_0or1;
	}
	public void setTuRang_0or1(Integer tuRang_0or1) {
		this.tuRang_0or1 = tuRang_0or1;
	}
	public Integer getZhengFa_0or1() {
		return zhengFa_0or1;
	}
	public void setZhengFa_0or1(Integer zhengFa_0or1) {
		this.zhengFa_0or1 = zhengFa_0or1;
	}
	
//	public Integer getQiWen_0or1() {
//		return qiWen_0or1;
//	}
//
//	public void setQiWen_0or1(Integer qiWen_0or1) {
//		this.qiWen_0or1 = qiWen_0or1;
//	}
//
//	public Integer getDianChi_0or1() {
//		return dianChi_0or1;
//	}
//
//	public void setDianChi_0or1(Integer dianChi_0or1) {
//		this.dianChi_0or1 = dianChi_0or1;
//	}
//
//	public Integer getGsmXinQiang_0or1() {
//		return gsmXinQiang_0or1;
//	}
//
//	public void setGsmXinQiang_0or1(Integer gsmXinQiang_0or1) {
//		this.gsmXinQiang_0or1 = gsmXinQiang_0or1;
//	}
	

}
