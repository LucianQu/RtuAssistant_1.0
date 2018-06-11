package com.blg.rtu.util;

import android.app.AlertDialog;
import android.content.Context;

import com.blg.rtu3.R;

public class DialogAlarm {
	

	/**
	 * 显示信息
	 * @param activity
	 */
	public void showDialog(final Context ctx, final String message){
		new AlertDialog.Builder(ctx)
		.setTitle(R.string.showAlarm)
		.setMessage(message)
		.setIcon(android.R.drawable.ic_dialog_alert)
		.setCancelable(true)
		.setPositiveButton(R.string.txtOk, null)
		.show();
	}
}
