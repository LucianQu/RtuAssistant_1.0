package com.blg.rtu2;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends Activity {

	private int delayMillis = 800 ;
	private LinearLayout aplashLinear ;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		aplashLinear = (LinearLayout)findViewById(R.id.splashLinear);
//		aplashLinear.setBackground(getResources().getDrawable(R.drawable.splash));
		aplashLinear.setBackgroundDrawable(getResources().getDrawable(R.drawable.splash1)) ;
		
	    TextView versionNumberV = (TextView) findViewById(R.id.versionNumber);
	    versionNumberV.setText(getResources().getString(R.string.txtVersion) + " " + this.getSoftVersion(this));
	   
		//创建快捷方式
	//	if(!Help.IfaddShortCut(this, PrepareActivity.class)){
	//		Help.addShortCut(this, PrepareActivity.class) ;
	//	}
	
	    
	    final Handler handler = new Handler() ;
	    handler.postDelayed(new Runnable(){
	       @Override
	       public void run() {
	           Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
	           startActivity(intent);
	           SplashActivity.this.finish();
	       }
	                   
	   }, delayMillis);
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(aplashLinear != null){
			System.gc() ; //提醒系统及时回收
		}
	}
	
	  
	//得到软件版本信息
	public String getSoftVersion(Activity at){
		PackageManager pm = at.getPackageManager();
      try {
         PackageInfo pi = pm.getPackageInfo("com.blg.rtu", 0);
         return pi.versionName ;
      } catch (NameNotFoundException e) {
         e.printStackTrace();
      }
      return "" ;
	}


}