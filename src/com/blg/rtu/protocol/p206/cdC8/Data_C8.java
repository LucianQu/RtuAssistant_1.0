package com.blg.rtu.protocol.p206.cdC8;

public class Data_C8 {
	
	private Integer net1 ;//网络中心1连接状态
	private Integer net2 ;//网络中心2连接状态
	private Integer net3 ;//网络中心3连接状态
	private Integer net4 ;//网络中心4连接状态
	
	private Integer dtuStrong ;//DTU信号强度
	
	private Integer wifi ; //Wifi连接状态
	private Integer wifiOpt ;//Wifi数据参数
	
	private Integer sate1 ;//卫星中心1连接状态
	private Integer sate2 ;//卫星中心2连接状态
	private Integer sate3 ;//卫星中心3连接状态
	private Integer sate4 ;//卫星中心4连接状态
	
	//卫星信号强度
	private Integer sateStrong ;//卫星信号强度
	
	
	public String toString(){
		String s = "RTU在线状态：\n" + 
			       "网络中心1：" + (net1.intValue() == 1?"连接":"断开") + "\n" +
			       "网络中心2：" + (net2.intValue() == 1?"连接":"断开") + "\n" +
			       "网络中心3：" + (net3.intValue() == 1?"连接":"断开") + "\n" +
			       "网络中心4：" + (net4.intValue() == 1?"连接":"断开") + "\n" +
			       "DTU信号强度：" + dtuStrong.intValue() + "\n" +
			       "Wifi连接状态：" + (wifi.intValue() == 1?"连接":"断开") + "\n" +
			       "Wifi数据参数：" + wifiOpt.intValue() + "\n" +
			       "卫星中心1：" + (sate1.intValue() == 1?"连接":"断开") + "\n" +
			       "卫星中心2：" + (sate2.intValue() == 1?"连接":"断开") + "\n" +
			       "卫星中心3：" + (sate3.intValue() == 1?"连接":"断开") + "\n" +
			       "卫星中心4：" + (sate4.intValue() == 1?"连接":"断开") + "\n" +
			       "卫星信号强度：" + sateStrong.intValue() + "\n"  ;
		return s ;
	}


	public Integer getNet1() {
		return net1;
	}


	public void setNet1(Integer net1) {
		this.net1 = net1;
	}


	public Integer getNet2() {
		return net2;
	}


	public void setNet2(Integer net2) {
		this.net2 = net2;
	}


	public Integer getNet3() {
		return net3;
	}


	public void setNet3(Integer net3) {
		this.net3 = net3;
	}


	public Integer getNet4() {
		return net4;
	}


	public void setNet4(Integer net4) {
		this.net4 = net4;
	}


	public Integer getDtuStrong() {
		return dtuStrong;
	}


	public void setDtuStrong(Integer dtuStrong) {
		this.dtuStrong = dtuStrong;
	}


	public Integer getWifi() {
		return wifi;
	}


	public void setWifi(Integer wifi) {
		this.wifi = wifi;
	}


	public Integer getWifiOpt() {
		return wifiOpt;
	}


	public void setWifiOpt(Integer wifiOpt) {
		this.wifiOpt = wifiOpt;
	}


	public Integer getSate1() {
		return sate1;
	}


	public void setSate1(Integer sate1) {
		this.sate1 = sate1;
	}


	public Integer getSate2() {
		return sate2;
	}


	public void setSate2(Integer sate2) {
		this.sate2 = sate2;
	}


	public Integer getSate3() {
		return sate3;
	}


	public void setSate3(Integer sate3) {
		this.sate3 = sate3;
	}


	public Integer getSate4() {
		return sate4;
	}


	public void setSate4(Integer sate4) {
		this.sate4 = sate4;
	}


	public Integer getSateStrong() {
		return sateStrong;
	}


	public void setSateStrong(Integer sateStrong) {
		this.sateStrong = sateStrong;
	}

	

}
