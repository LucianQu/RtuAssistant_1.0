package com.blg.rtu.frmChannel.helpCh1;

import com.blg.rtu.frmChannel.ChFragment_01;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * frmChannel01内部行为类
 * @author Administrator
 *
 */
public class ChBusi_01_Action {
	
	private ChFragment_01 chf ;
	
	public ChBusi_01_Action(ChFragment_01 chf){
		this.chf = chf ;
	}
	
	private View.OnFocusChangeListener onFocus_phoneNumber = new View.OnFocusChangeListener(){
		   @Override
		   public void onFocusChange(View v, boolean hasFocus) {
		       if (hasFocus) {
		    	   InputMethodManager imm = (InputMethodManager)chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);
		           imm.showSoftInput(chf.phoneNumber, InputMethodManager.SHOW_IMPLICIT);
		           chf.btnTcp.setChecked(false);
		           chf.btnSm.setChecked(true);
		       }else{
		    	   String phoneNum = chf.phoneNumber.getText().toString() ;
		    	   Preferences.getInstance().putString(Constant.ch_vk_phone, phoneNum) ;
		       }
		   }
	} ;
	
	private View.OnFocusChangeListener onFocus_ip1 = new View.OnFocusChangeListener(){
		   @Override
		   public void onFocusChange(View v, boolean hasFocus) {
		       if (hasFocus) {
					InputMethodManager imm = (InputMethodManager)chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.showSoftInput(chf.ip1, InputMethodManager.SHOW_IMPLICIT);
					chf.btnTcp.setChecked(true);
					chf.btnSm.setChecked(false);
					ipPortClearFocus(chf.ip1);
		       }
		   }
	} ;
	
	private View.OnFocusChangeListener onFocus_ip2 = new View.OnFocusChangeListener(){
		   @Override
		   public void onFocusChange(View v, boolean hasFocus) {
		       if (hasFocus) {
					InputMethodManager imm = (InputMethodManager)chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.showSoftInput(chf.ip2, InputMethodManager.SHOW_IMPLICIT);
					chf.btnTcp.setChecked(true) ;
					chf.btnSm.setChecked(false);
					ipPortClearFocus(chf.ip2) ;
		       }
		   }
	} ;
	
	private View.OnFocusChangeListener onFocus_ip3 = new View.OnFocusChangeListener(){
		   @Override
		   public void onFocusChange(View v, boolean hasFocus) {
		       if (hasFocus) {
					InputMethodManager imm = (InputMethodManager)chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.showSoftInput(chf.ip3, InputMethodManager.SHOW_IMPLICIT);
					chf.btnTcp.setChecked(true) ;
					chf.btnSm.setChecked(false) ;
					ipPortClearFocus(chf.ip3) ;
		       }
		   }
	} ;
	
	private View.OnFocusChangeListener onFocus_ip4 = new View.OnFocusChangeListener(){
		   @Override
		   public void onFocusChange(View v, boolean hasFocus) {
		       if (hasFocus) {
					InputMethodManager imm = (InputMethodManager)chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.showSoftInput(chf.ip4, InputMethodManager.SHOW_IMPLICIT);
					chf.btnTcp.setChecked(true) ;
					chf.btnSm.setChecked(false) ;
					ipPortClearFocus(chf.ip4) ;
		       }
		   }
	} ;
	
	private View.OnFocusChangeListener onFocus_port = new View.OnFocusChangeListener(){
		   @Override
		   public void onFocusChange(View v, boolean hasFocus) {
		       if (hasFocus) {
					InputMethodManager imm = (InputMethodManager)chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.showSoftInput(chf.port, InputMethodManager.SHOW_IMPLICIT);
					chf.btnTcp.setChecked(true) ;
					chf.btnSm.setChecked(false) ;
					ipPortClearFocus(chf.port) ;
		       }
		   }
	} ;
	
	private void ipPortClearFocus(EditText notClearEt){
		if(notClearEt == null){
			chf.ip1.clearFocus() ;
			chf.ip2.clearFocus() ;
			chf.ip3.clearFocus() ;
			chf.ip4.clearFocus() ;
			chf.port.clearFocus() ;
		}else{
			if(chf.ip1 != notClearEt){
				chf.ip1.clearFocus() ;
			}
			if(chf.ip2 != notClearEt){
				chf.ip2.clearFocus() ;
			}
			if(chf.ip3 != notClearEt){
				chf.ip3.clearFocus() ;
			}
			if(chf.ip4 != notClearEt){
				chf.ip4.clearFocus() ;
			}
			if(chf.port != notClearEt){
				chf.port.clearFocus() ;
			}
		}
	}
	
	
	//关闭软键盘  
	 private void closeKeyboard() {  
	     InputMethodManager imm = (InputMethodManager) chf.act.getSystemService(Context.INPUT_METHOD_SERVICE);  
	     imm.hideSoftInputFromWindow(chf.phoneNumber.getWindowToken(), 0);  
	     imm.hideSoftInputFromWindow(chf.ip1.getWindowToken(), 0);  
	     imm.hideSoftInputFromWindow(chf.ip2.getWindowToken(), 0);  
	     imm.hideSoftInputFromWindow(chf.ip3.getWindowToken(), 0);  
	     imm.hideSoftInputFromWindow(chf.ip4.getWindowToken(), 0);  
	     imm.hideSoftInputFromWindow(chf.port.getWindowToken(), 0);  
	}  
	
	/**
	 * 通过划屏，移入本界面
	 */
	public void inThisPage(){
		chf.phoneNumber.setFocusable(true);
		chf.phoneNumber.setFocusableInTouchMode(true);
		//获得焦点自动打开软键盘 
		chf.phoneNumber.setOnFocusChangeListener(onFocus_phoneNumber) ;
		
		chf.ip1.setFocusable(true);
		chf.ip1.setFocusableInTouchMode(true);
		//获得焦点自动打开软键盘 
		chf.ip1.setOnFocusChangeListener(onFocus_ip1) ;
		
		chf.ip2.setFocusable(true);
		chf.ip2.setFocusableInTouchMode(true);
		//获得焦点自动打开软键盘 
		chf.ip2.setOnFocusChangeListener(onFocus_ip2) ;
		
		chf.ip3.setFocusable(true);
		chf.ip3.setFocusableInTouchMode(true);
		//获得焦点自动打开软键盘 
		chf.ip3.setOnFocusChangeListener(onFocus_ip3) ;
		
		chf.ip4.setFocusable(true);
		chf.ip4.setFocusableInTouchMode(true);
		//获得焦点自动打开软键盘 
		chf.ip4.setOnFocusChangeListener(onFocus_ip4) ;
		
		chf.port.setFocusable(true);
		chf.port.setFocusableInTouchMode(true);
		//获得焦点自动打开软键盘 
		chf.port.setOnFocusChangeListener(onFocus_port) ;
	}
	
	/**
	 * 通过划屏，移出本界面
	 */
	public void outThisPage(){
		chf.phoneNumber.clearFocus() ;
		chf.phoneNumber.setFocusable(false);
		chf.phoneNumber.setFocusableInTouchMode(false);
		
		chf.ip1.clearFocus() ;
		chf.ip1.setFocusable(false);
		chf.ip1.setFocusableInTouchMode(false);
		
		chf.ip2.clearFocus() ;
		chf.ip2.setFocusable(false);
		chf.ip2.setFocusableInTouchMode(false);
		
		chf.ip3.clearFocus() ;
		chf.ip3.setFocusable(false);
		chf.ip3.setFocusableInTouchMode(false);
		
		chf.ip4.clearFocus() ;
		chf.ip4.setFocusable(false);
		chf.ip4.setFocusableInTouchMode(false);
		
		chf.port.clearFocus() ;
		chf.port.setFocusable(false);
		chf.port.setFocusableInTouchMode(false);
		
		closeKeyboard() ;
	}
}
