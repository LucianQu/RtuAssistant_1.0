package com.blg.rtu.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


import com.automic.watersource.model.UserInfo;
import com.blg.rtu.AppContext;


public class AppUtils {
	public static final String PREF_USER_INFO = "Preference_User_Info";
	//本地环境
	//public static final String BASEIP="182.92.1.18:8080";
	//现场环境-丽江
	//	public static final String BASEIP="221.3.207.46:10001";
	//现场环境2
//	public static final String BASEIP="124.42.1.116:7010";
	//本地环境
//	public static final String BASEIP="123.57.30.131:8080/langfang";
	public static final String BASEIP="58.18.186.132:8218/appService";
	
	public static final String DOWNLOADPATH="http://58.18.186.132:8916/waterBase";
	
	public static void saveUserInfo(Context context, UserInfo user) {
		SharedPreferences preference = context.getSharedPreferences(
				PREF_USER_INFO, Context.MODE_PRIVATE);
		Editor editor = preference.edit();
		editor.putString("usercode", user.getUsername());
		editor.putString("pass", user.getPassword());
		editor.putString("app", user.getApp());
		editor.putString("adId", user.getAdId());
		editor.putString("unitid", user.getUnitid());
		editor.putString("deviceId", user.getDeviceId());
		editor.putString("roleId", user.getRoleId());
		editor.putString("realName", user.getRealName());
		editor.commit();
	}

	public static UserInfo getUserInfo(Context context) {
		SharedPreferences preference = context.getSharedPreferences(
				PREF_USER_INFO, Context.MODE_PRIVATE);
		String usercode = preference.getString("usercode", "");
		String pass = preference.getString("pass", "");
		String app = preference.getString("app","");
		String adId = preference.getString("adId", "");
		String unitid = preference.getString("unitid", "");
		String deviceId = preference.getString("deviceId", "");
		String roleId = preference.getString("roleId","");
		String realName = preference.getString("realName", "");

		UserInfo user = new UserInfo();
		user.setUsername(usercode);
		user.setPassword(pass);
		user.setApp(app);
		user.setAdId(adId);
		user.setUnitid(unitid);
		user.setDeviceId(deviceId);
		user.setRoleId(roleId);
		user.setRealName(realName);
		return user;
	}
	
	
	/**
	 * 获取当前程序版本
	 * 
	 * @return
	 */
	public static String getPackageVersion() {
		String version = "";
		try {
			PackageManager pm = AppContext.getInstance().getPackageManager();
			PackageInfo pi = null;
			pi = pm.getPackageInfo(AppContext.getInstance().getPackageName(), 0);
			version = pi.versionName;
		} catch (Exception e) {
			version = ""; // failed, ignored
		}
		return version;
	}

	/**
	 * 获取当前程序包名
	 * 
	 * @return
	 */
	public static String getPackageName() {
		String version = "";
		try {
			PackageManager pm = AppContext.getInstance().getPackageManager();
			PackageInfo pi = null;
			pi = pm.getPackageInfo(AppContext.getInstance().getPackageName(), 0);
			version = pi.packageName;
		} catch (Exception e) {
			version = ""; // failed, ignored
		}
		return version;
	}

	/**
	 * 获取当前程序版本code
	 * 
	 * @return
	 */
	public static String getPackageCode() {
		String code = "";
		try {
			PackageManager pm = AppContext.getInstance().getPackageManager();
			PackageInfo pi = null;
			pi = pm.getPackageInfo(AppContext.getInstance().getPackageName(), 0);
			code = pi.versionName;
		} catch (Exception e) {
			code = "1"; // failed, ignored
		}
		return code;
	}
}
