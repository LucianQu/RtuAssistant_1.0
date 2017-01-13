package com.blg.rtu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {
	private  ProgressDialog dialog;
	private AlertDialog.Builder builder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 声明一个等待框以提示用户等待
    	dialog=new ProgressDialog(this);
	}
	
	/**
	 * 显示等待框
	 * @param content
	 */
	public void openDialog(String content){
		dialog.setMessage(content);
		dialog.show();
	}
	
	/**
	 * 关闭等待框
	 */
	public void dismissDialog(){
		dialog.dismiss();
	}
	
	/**
	 * 打开一个Activity
	 * @param cls
	 */
	public void openActivity(Class<?> cls){
		Intent intent =new Intent();
		intent.setClass(this, cls);
		startActivity(intent);
	}	
	
	/**
	 * 显示提示信息
	 * @param msg
	 */
	public void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 显示对话框
	 * 
	 * @param title
	 * @param msg
	 * @param mOkOnClickListener
	 * @param nCancelOnClickListener
	 */
	public void showDialog(String title, String msg,
			DialogInterface.OnClickListener mOkOnClickListener,
			DialogInterface.OnClickListener nCancelOnClickListener) {
		builder = new Builder(this);
		builder.setMessage(msg);
		builder.setTitle(title);
		builder.setPositiveButton("确认", mOkOnClickListener);
		builder.setNegativeButton("取消", nCancelOnClickListener);
		builder.create().show();
	}
}
