package com.blg.rtu2.sm;

import com.blg.rtu2.MainActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;

public class SmsSender {

	/**
	 * 发送短信
	 * @param mobile
	 * @param content
	 */
	 public static void sendSMS(MainActivity act, String mobile, String content){ 
		 SmsManager smsManager = SmsManager.getDefault();
	     PendingIntent sentIntent = PendingIntent.getBroadcast(act, 0, new Intent(), 0);
	     smsManager.sendTextMessage(mobile, null, content, sentIntent, null);
	     act.getSoundAlert().playSend() ;
	 }

}
