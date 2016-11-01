package com.blg.rtu.util;

public class CallBackReturnVO {
	public Integer channel ;//为1是短信通道，为2是蓝牙通道
	public boolean success ;//是否成功发送出去
	public String message ;//消息
	
	public CallBackReturnVO(Integer channel, boolean success, String message){
		this.channel = channel ;
		this.success = success ;
		this.message = message ;
	}
}
