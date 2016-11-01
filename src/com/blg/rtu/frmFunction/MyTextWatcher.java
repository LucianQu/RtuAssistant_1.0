package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Preferences;

import android.text.Editable;
import android.text.TextWatcher;

public class MyTextWatcher implements TextWatcher{
	
	private String prefId ;
	
	public MyTextWatcher(String prefId){
		this.prefId = prefId ;
	}
	
	public void afterTextChanged(Editable ev) {
		// s:变化后的所有字符
		String str = ev.toString();
		if (str == null || str.equals("")) {
			Preferences.getInstance().remove(this.prefId);
		} else {
			Preferences.getInstance().putString(this.prefId, str);
		}
	}
	
	/**
	 * s:变化前的所有字符； start:字符开始的位置； count:变化前的总字节数；after:变化后的字节数
	 */
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	/**
	 * s:变化前的所有字符； start:字符开始的位置； count:变化前的总字节数；after:变化后的字节数
	 */
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

}
