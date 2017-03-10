package com.blg.rtu1;

import android.app.Application;

public class AppContext extends Application {

	private static AppContext mInstance = null;

	public AppContext() {
	}

	@Override
	public void onCreate() {
		super.onCreate();

		mInstance = this;
		//CrashHandler catchHandler = CrashHandler.getInstance();
//		catchHandler.init(getApplicationContext());

	}

	public static AppContext getInstance() {
		return mInstance;
	}

}
