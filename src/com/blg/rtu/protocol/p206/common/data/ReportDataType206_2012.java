package com.blg.rtu.protocol.p206.common.data;

public class ReportDataType206_2012 {
	//协议支持的参量种类
	protected Integer yuLiang ;//置“1”为上报雨量数据，清“0”为不上报雨量数据；
	protected Integer shuiWei ;//置“1”为上报水位数据，清“0”为不上报水位数据；
	protected Integer liuLiang ;//置“1”为上报流量数据，清“0”为不上报流量数据；
	protected Integer liuSu ;//置“1”为上报流速数据，清“0”为不上报流速数据；
	protected Integer zhaWei ;//置“1”为上报闸位数据，清“0”为不上报闸位数据；
	protected Integer gongLu ;//置“1”为上报功率数据，清“0”为不上报功率数据；
	protected Integer qiYa ;//置“1”为上报气压数据，清“0”为不上报气压数据；
	protected Integer fengSu ;//置“1”为上报风速（风向）数据，清“0”为不上报风速数据；
	protected Integer shuiWen ;//置“1”为上报水温数据，清“0”为不上报水温数据；
	protected Integer shuiZhi ;//置“1”为上报水质数据，清“0”为不上报水质数据；
	protected Integer tuRang ;//置“1”为上报土壤含水率数据，清“0”为不上报土壤含水率数据；
	protected Integer zhengFa ;//置“1”为上报蒸发量数据，清“0”为不上报蒸发量数据；

	public String toString(){
		String s = "\n参量自报种类：\n" ;
		s += "雨量" + "=" + (this.yuLiang==null?"":this.yuLiang.intValue()) + "\n" ;
		s += "水位" + "=" + (this.shuiWei==null?"":this.shuiWei.intValue()) + "\n" ;
		s += "水量" + "=" + (this.liuLiang==null?"":this.liuLiang.intValue()) + "\n" ;
		s += "流速" + "=" + (this.liuSu==null?"":this.liuSu.intValue()) + "\n" ; 
		s += "闸位" + "=" + (this.zhaWei==null?"":this.zhaWei.intValue()) + "\n" ;
		s += "功率" + "=" + (this.gongLu==null?"":this.gongLu.intValue()) + "\n" ;
		s += "气压" + "=" + (this.qiYa==null?"":this.qiYa.intValue()) + "\n" ; 
		s += "风速" + "=" + (this.fengSu==null?"":this.fengSu.intValue()) + "\n" ; 
		s += "水温" + "=" + (this.shuiWen==null?"":this.shuiWen.intValue()) + "\n" ;
		s += "水质" + "=" + (this.shuiZhi==null?"":this.shuiZhi.intValue()) + "\n" ;
		s += "土壤" + "=" + (this.tuRang==null?"":this.tuRang.intValue()) + "\n" ; 
		s += "蒸发" + "=" + (this.zhengFa==null?"":this.zhengFa.intValue()) + "\n" ;

		return s ;
	}

	public Integer getYuLiang() {
		return yuLiang;
	}

	public void setYuLiang(Integer yuLiang) {
		this.yuLiang = yuLiang;
	}

	public Integer getShuiWei() {
		return shuiWei;
	}

	public void setShuiWei(Integer shuiWei) {
		this.shuiWei = shuiWei;
	}

	public Integer getLiuLiang() {
		return liuLiang;
	}

	public void setLiuLiang(Integer liuLiang) {
		this.liuLiang = liuLiang;
	}

	public Integer getLiuSu() {
		return liuSu;
	}

	public void setLiuSu(Integer liuSu) {
		this.liuSu = liuSu;
	}

	public Integer getZhaWei() {
		return zhaWei;
	}

	public void setZhaWei(Integer zhaWei) {
		this.zhaWei = zhaWei;
	}

	public Integer getGongLu() {
		return gongLu;
	}

	public void setGongLu(Integer gongLu) {
		this.gongLu = gongLu;
	}

	public Integer getQiYa() {
		return qiYa;
	}

	public void setQiYa(Integer qiYa) {
		this.qiYa = qiYa;
	}

	public Integer getFengSu() {
		return fengSu;
	}

	public void setFengSu(Integer fengSu) {
		this.fengSu = fengSu;
	}

	public Integer getShuiWen() {
		return shuiWen;
	}

	public void setShuiWen(Integer shuiWen) {
		this.shuiWen = shuiWen;
	}

	public Integer getShuiZhi() {
		return shuiZhi;
	}

	public void setShuiZhi(Integer shuiZhi) {
		this.shuiZhi = shuiZhi;
	}

	public Integer getTuRang() {
		return tuRang;
	}

	public void setTuRang(Integer tuRang) {
		this.tuRang = tuRang;
	}

	public Integer getZhengFa() {
		return zhengFa;
	}

	public void setZhengFa(Integer zhengFa) {
		this.zhengFa = zhengFa;
	}


}
