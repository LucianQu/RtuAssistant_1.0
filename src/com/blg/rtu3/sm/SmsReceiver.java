package com.blg.rtu3.sm;

//import com.blg.rtu.R;
import android.content.*;
import android.os.*;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

	private static SmBroadcastSender bcast;
	
//	private static String rtuSmHead = null ;

	@Override
	public void onReceive(Context context, Intent intent) {
		// 判断是系统短信；
		if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
			// 不再往下传播；
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				// 通过pdus获得接收到的所有短信消息，获取短信内容；
				Object[] pdus = (Object[]) bundle.get("pdus");
				// 构建短信对象数组；
				SmsMessage[] mges = new SmsMessage[pdus.length];
				for (int i = 0; i < pdus.length; i++) {
					// 获取单条短信内容，以pdu格式存,并生成短信对象；
					mges[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
				}
				for (SmsMessage mge : mges) {
					String phoneNumber = mge.getOriginatingAddress() ;
					String content = mge.getMessageBody();
					if(bcast == null){
             		   bcast = new SmBroadcastSender(context) ;
					}
					bcast.broadcastRtuSm(phoneNumber, content) ;
				}
			}
		}
	}

	/**
	 * 判断是否为本系统RTU发来的短信
	 * 
	 * @param context
	 * @param content
	 * @return
	 */
//	private boolean isRtuMessage(Context context, String content) {
//		if(rtuSmHead == null){
//			rtuSmHead = context.getResources().getString(R.string.rtuSmHead) ;
//		}
//		if(content.trim().startsWith(rtuSmHead)){
//			return true ;
//		}
//		return false;
//	}
}
