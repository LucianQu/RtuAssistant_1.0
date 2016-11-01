package com.blg.rtu.protocol.p206.cd02;


public class Data_02 {

	/**
	 * 用于GPRS、CDMA登录、退出登录、在线保持。数据域：1个字节，F0登录，F1退出登录，F2在线保持。
	 */
	private String status ;
	private byte oraData ;//上报的原始数据
	
	public String toString(){
		String s = "\n" ;
		s += "链路测试之状态：" + (this.status==null?"":this.status) ;
		return s ;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte getOraData() {
		return oraData;
	}

	public void setOraData(byte oraData) {
		this.oraData = oraData;
	}

	
}
