package com.blg.rtu2;

import com.blg.rtu.util.Constant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;

public class MainBroadcastReceiver {

	private MainActivity act ;
	private LocalBroadcastManager mLocalBroadcastManager;  
	private BroadcastReceiver mReceiver;  

    public MainBroadcastReceiver(MainActivity act){
    	this.act = act ;
    }

    public void registerAndReceive(){
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this.act);  
  
        IntentFilter filter = new IntentFilter();  
        
        filter.addAction(Constant.Action_ReceiveRtuMs);  
        
        
        mReceiver = new BroadcastReceiver() {  
            @Override  
            public void onReceive(Context context, Intent intent) {  
            	String action = intent.getAction() ;
            	if (action.equals(Constant.Action_ReceiveRtuMs)) {/*
            		//收到RTU短信
            		String phoneNumber = intent.getStringExtra(Constant.msg_key_string1) ;
            		String message = intent.getStringExtra(Constant.msg_key_string2) ;

            		act.mHandler.removeMessages(Constant.msg_main_receiveSm);  
            		Message msg = act.mHandler.obtainMessage(Constant.msg_main_receiveSm); 
            		Bundle b = new Bundle();
            		b.putString(Constant.msg_key_string1, phoneNumber) ;
            		b.putString(Constant.msg_key_string2, message) ;
            		msg.setData(b);
            		act.mHandler.sendMessage(msg);
                */}
            }  
        };  
        mLocalBroadcastManager.registerReceiver(mReceiver, filter);  
    }
    
    
	public void unRegisterBroadcastReceiver(){
		if(mLocalBroadcastManager != null && mReceiver != null){
			mLocalBroadcastManager.unregisterReceiver(mReceiver);  
		}
	}

}
