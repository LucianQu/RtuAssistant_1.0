package com.blg.rtu.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.blg.rtu3.R;

public class DialogConfirm {
	
	/**
	 * 回调接口
	 * @author Administrator
	 *
	 */
	public interface CallBackInterface {
		public void dialogCallBack(Object o) ;
	}

	/**
	 * 确认操作
	 * @param activity
	 */
	public void showDialog(final Activity activity, final String message, final CallBackInterface callback){
		new AlertDialog.Builder(activity)
		.setTitle(R.string.operatorConfirm)
		.setMessage(message)
		.setIcon(android.R.drawable.ic_dialog_info)
		.setCancelable(true)
		.setPositiveButton(R.string.txtOk,
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					if(callback != null){
						callback.dialogCallBack(Boolean.valueOf(true)) ;
					}
				}
			})
		.setNegativeButton(R.string.txtCancel, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(callback != null){
					callback.dialogCallBack(Boolean.valueOf(false)) ;
				}
			}
		})
		.show();
	}
}
