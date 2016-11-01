package com.blg.rtu.sm;

import com.blg.rtu.util.Constant;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class SmBroadcastSender {

	private Context context ;
	 //广播管理器 
	private LocalBroadcastManager mBroadcastManager;

	public SmBroadcastSender(Context context){
		this.context = context ;
		//广播初始化
        mBroadcastManager = LocalBroadcastManager.getInstance(this.context);  
	}

	/**
	 * 广播接收到RTU短信了
	 * @param dataId
	 * @param data
	 */
	public void broadcastRtuSm(String phoneNumber, String content){
		Intent intent = new Intent(Constant.Action_ReceiveRtuMs) ;
		intent.putExtra(Constant.msg_key_string1, phoneNumber);
		intent.putExtra(Constant.msg_key_string2, content);
		mBroadcastManager.sendBroadcast(intent) ;
	}


}
