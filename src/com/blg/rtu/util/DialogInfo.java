package com.blg.rtu.util;

import android.app.Activity;
import android.app.AlertDialog;

import com.blg.rtu3.R;

public class DialogInfo {
	

	/**
	 * 显示信息
	 * @param activity
	 */
	public void showDialog(final Activity activity, final String message){
		new AlertDialog.Builder(activity)
		.setTitle(R.string.showInfo)
		.setMessage(message)
		.setIcon(android.R.drawable.ic_dialog_info)
		.setCancelable(true)
		.setPositiveButton(R.string.txtOk, null)
		.show();
	}
}
