package com.blg.rtu.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

	private static Preferences instance ;
	private static SharedPreferences sp ;
	
	private Preferences(Context ctx){
		//Constructor to create a Preference.
		//SharedPreferences sp = getSharedPreferences("存储xml文件的名字",MODE_PRIVATE); 
		
		sp = ctx.getSharedPreferences(Constant.preferencesFileName, Constant.preferencesFilemode) ;
		 
	}
	
	/**
	 * 初始式
	 * @param ctx
	 * @return
	 */
	public static Preferences initInstance(Context ctx){
		if(instance == null){
			instance = new Preferences(ctx) ;
		}
		return instance ;
	}
	
	
	public static Preferences getInstance(){
		return instance ;
	}
	
	public int getInt(String key){
		if(sp != null){
			try{
				return sp.getInt(key, Constant.errorInt) ;
			}catch(Exception e){
				return Constant.errorInt ;
			}
		}else{
			return Constant.errorInt ;
		}
	}
	public void putInt(String key, int value){
		sp.edit().putInt(key, value).commit() ;
	}
	
	
	public long getLong(String key){
		if(sp != null){
			return sp.getLong(key, Constant.errorLong) ;
		}else{
			return Constant.errorLong ;
		}
	}
	public void putLong(String key, long value){
		sp.edit().putLong(key, value).commit() ;
	}
	
	
	
	public float getFloat(String key){
		if(sp != null){
			return sp.getFloat(key, Constant.errorFloat) ;
		}else{
			return Constant.errorFloat ;
		}
	}
	public void putFloat(String key, float value){
		sp.edit().putFloat(key, value).commit() ;
	}
	
	public String getString(String key){
		if(sp != null){
			return sp.getString(key, Constant.errorStr) ;
		}else{
			return Constant.errorStr ;
		}
	}
	public void putString(String key, String value){
		sp.edit().putString(key, value).commit() ;
	}
	
	public void remove(String key){
		sp.edit().remove(key).commit() ;
	}
	
}
