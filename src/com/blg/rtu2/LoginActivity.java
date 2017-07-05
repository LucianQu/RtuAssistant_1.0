package com.blg.rtu2;

import android.app.AlertDialog;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.automic.watersource.model.UserInfo;
import com.automic.watersource.utils.Utils;
import com.blg.rtu.util.AppUtils;

public class LoginActivity extends BaseActivity implements OnClickListener {

	public static LoginActivity instance = null ;
	private Button btnLogin;

	public CheckBox cbSavePsw;
	public CheckBox cbWifiConnType;

	private EditText etuser;
	private EditText etpassword;
	
	private UserInfo userInfo;

	private boolean issave=false;
	private boolean isMeter = false ;
	// 退出系统时间
			private long exitTime = 0;
	public LoginActivity() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this ;
		setContentView(R.layout.activity_login);
		setUpViews();
		switchConnectType() ;
	}

	private void setUpViews() {
		
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnLogin.setOnClickListener(this);


		cbSavePsw = (CheckBox) findViewById(R.id.cb_save);
		cbWifiConnType = (CheckBox) findViewById(R.id.cb_wifiConnectType) ;
		cbSavePsw.setOnClickListener(this);
		cbWifiConnType.setOnClickListener(this) ;
		

		etuser = (EditText) findViewById(R.id.et_user);
		etpassword = (EditText) findViewById(R.id.et_pwd);
		userInfo=AppUtils.getUserInfo(this);
		if(!"".equals(userInfo.getUsername())){
			etuser.setText(userInfo.getUsername());
		}
		issave=Utils.getPswisSave(this);
		if(issave){
			etpassword.setText(userInfo.getPassword());
			openActivity(MainActivity.class);
			finish();
		}
	}
	
	private void login(String userName,String pwd){
		//String[] saveUserPassword = Utils.getUserPushInfo(getApplicationContext());
    	if(userInfo.getUsername().equals(userName) && userInfo.getPassword().equals(pwd) 
    			&& userInfo.getUsername() != "" && userInfo.getPassword() != "")   //判断 帐号和密码
        {
    		openActivity(MainActivity.class);
			finish();
         }else if("".equals(userName) || "".equals(pwd))   //判断 帐号和密码
          {
	    	new AlertDialog.Builder(LoginActivity.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("登录错误 ")
			.setMessage("帐号/密码不能为空，\n请输入后再登录！")
			.create().show();
          }
        else{
        	new AlertDialog.Builder(LoginActivity.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("登录失败")
			.setMessage("帐号/密码不正确，\n请检查后重新输入！")
			.create().show();
        }
    	
	}
	
	private void switchConnectType() {
		WifiManager wifiMan = (WifiManager) getSystemService(Context.WIFI_SERVICE) ;
		WifiInfo info = wifiMan.getConnectionInfo() ;
		
		int ipAddress = info.getIpAddress() ;
		String ipString = "";// 本机在WIFI状态下路由分配给的IP地址  
		  
		// 获得IP地址的方法一：  
		if (ipAddress != 0) {  
		       ipString = ((ipAddress & 0xff) + "." + (ipAddress >> 8 & 0xff)) ;  
		}
		if("10.10".equals(ipString)) {
			Utils.saveUserDestroy(getApplicationContext(), true);
		}else{
			Utils.saveUserDestroy(getApplicationContext(), true);
			//Utils.saveUserDestroy(getApplicationContext(), false);
		}
		
	}
	
/*	private String getUrl(String userName,String pwd){
		String url = "http://"+AppUtils.BASEIP+"/servlet/user/login.do?usercode="+userName+"&pass="+pwd+"&app=1&imei=asdhfjldfjlkj";
		return url;
	}*/

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			String usercode = etuser.getText().toString();
			String password = etpassword.getText().toString();
			
			//String[] saveUserPassword = Utils.getUserPushInfo(getApplicationContext());
			//UserInfo userPasswordSave = new UserInfo();
			if("".equals(userInfo.getUsername()) || "".equals(userInfo.getPassword())) {
				if (usercode.equals("admin") || password.equals("password")) {
					//Utils.saveUserPushInfo(getApplicationContext(), "admin", "password");
					userInfo.setUsername("admin");
					userInfo.setPassword("password");
					AppUtils.saveUserInfo(LoginActivity.this, userInfo);
					Toast.makeText(this, "第一次登陆！", Toast.LENGTH_SHORT).show();
					login(usercode, password);
					//showToast("用户名和密码不能为空");
				}else {
					//openDialog("正在登录,请稍等...");
					login(usercode, password);
				}
			}else{
					login(usercode, password);
			}
			break;
		case R.id.cb_save:
			CheckBox cb=(CheckBox)v;
			usercode = etuser.getText().toString();
			password = etpassword.getText().toString();
			//saveUserPassword = Utils.getUserPushInfo(getApplicationContext());
			if(cb.isChecked()){
				if("".equals(userInfo.getUsername()) || "".equals(userInfo.getPassword())) {
					if (usercode.equals("admin") && password.equals("password")) {
						Utils.savePswisSave(getApplicationContext(), true);
					}else {
						cb.setChecked(false);
		        		new AlertDialog.Builder(LoginActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("记住密码错误")
						.setMessage("输入正确的用户名和密码，\n才能记住密码！")
						.create().show();
					}
				}else{
					if (usercode.equals(userInfo.getUsername()) && password.equals(userInfo.getPassword())) {
						Utils.savePswisSave(getApplicationContext(), true);
					}else {
						cb.setChecked(false);
		        		new AlertDialog.Builder(LoginActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("记住密码错误")
						.setMessage("输入正确的用户名和密码，\n才能记住密码！")
						.create().show();
					}
				}
			}else{
				Utils.savePswisSave(getApplicationContext(), false);
			}
			break;
		case R.id.cb_wifiConnectType:
			CheckBox cb1=(CheckBox)v;
			if(cb1.isChecked()){
				//Utils.saveUserDestroy(getApplicationContext(), true);
			}else{
				//Utils.saveUserDestroy(getApplicationContext(), false);
			}
			break;
		default:
			break;
		}
	}
	public void setCbSaveStatus(boolean status) {
		
		Utils.savePswisSave(getApplicationContext(), status);
		if(!status) {
			cbSavePsw.setChecked(false);
		}
	}
	
	public boolean getCbWifiConnecyType() {
		return Utils.getUserDestroy(getApplicationContext()) ;
	}
	
	/**
	 * 功能描述: 添加返回按钮，弹出是否退出应用程序对话框
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
			}
			break;
		}
		return false;
	}


}
