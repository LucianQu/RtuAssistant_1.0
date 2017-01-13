package com.blg.rtu;

import java.util.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu.R;
import com.blg.rtu.aidl.ServiceAidl;
import com.blg.rtu.frmChannel.helpCh1.ChBusi_01_Operate;
import com.blg.rtu.server.LocalServer;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu.util.SoundAlert;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.StringValueForActivity;



@SuppressLint("HandlerLeak")
public class MainActivity  extends Activity { 
	public static MainActivity instance = null ;
//	private static final String TAG = MainActivity.class.getSimpleName() ;
	public ChBusi_01_Operate chb;
	private ViewPager mPager;// Tab页卡 
	private List<View> listPages; // Tab页面列表
	
	private View pageView_noProtocol ;// Tab第0页 
	private View pageView_loopQuery ;// Tab第1页 
	private View pageView_function ;// Tab第2页 
	//private View pageView_channel ;// Tab第3页
	
	public Boolean tcpConnected;
	public TextView tcpConnectStatus;
	
	public ScrollView func_scrollView ;
	
	//通道选择界面实体
	public LinearLayout chLine_01, chLine_02, chLine_03, chLine_04;
	
	//非协议数据界面实体
	public LinearLayout npFragmentLinear_02, npFragmentLinear_03 ;
	
	private MainBroadcastReceiver broadcastReceiver ;
	
	//声音
	private SoundAlert soundAlert ;
	//退出计时
	private long mExitTime;
	
	//fragment工具类对象
	public FragmentTool frgTool ;
	
	//fragment回调类对象
	private FragmentCallback frgCallback; 
	
	//mainActivity的帮助类对象，以设置不属于fragment的界面元素的事件监听器
	private MainActivityHelp mainHelp ;
	
    
	//activity的桩，其代理注册到server端去了
	public StubActivity mActivityStub ;
	//server的代理持有者，server代理的桩在server端
	public ServerProxyHandler mServerProxyHandler ;

	//private boolean wifiOpenStatus = false ;
	private WifiManager wifiManager ;
	
	private ServiceConnection mConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder service) {
			ServiceAidl serverProxy = ServiceAidl.Stub.asInterface(service);
			mServerProxyHandler = ServerProxyHandler.createSingle(serverProxy, MainActivity.this) ;
			try {
				serverProxy.registerActivityProxy(mActivityStub);
			} catch (RemoteException e) {
				Toast.makeText(MainActivity.this, "启动、绑定、连接后台服务时出错：" + e.getMessage(), Toast.LENGTH_SHORT).show();
			}
		}

		public void onServiceDisconnected(ComponentName className) {
			mServerProxyHandler.onServiceDisconnected(className) ;
		}
	};


	//接收从MapBroadcastReceiver发来的消息
	public Handler mHandler = new Handler() {  
        @Override  
        public void handleMessage(Message msg) {  
            switch (msg.what) {  
            case Constant.msg_main_message_long: {  
            	//消息
               	Bundle b = msg.getData();
               	String message = b.getString(Constant.msg_key_string1) ;
               	if(message != null){
               		Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show() ;
               	}
            }
            case Constant.msg_main_message_short: {  
            	//消息
               	Bundle b = msg.getData();
               	String message = b.getString(Constant.msg_key_string1) ;
               	if(message != null){
               		Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show() ;
               	}
            }
            break;  

            case Constant.msg_main_receiveSm: {  
            	//接收到短信的消息
             	Bundle b = msg.getData();
    			String phoneSet = MainActivity.this.frgTool.fragment_ch01.getPhoneNumber() ;
    			if(phoneSet != null && !phoneSet.equals("")){
        			String phoneNumber = b.getString(Constant.msg_key_string1) ;
        			if(phoneNumber.endsWith(phoneSet)){
        				String smData = b.getString(Constant.msg_key_string2) ;
        				if(smData != null && !smData.equals("")){
        					ServerProxyHandler.getInstance().dealSmData(smData) ;
        				}
        			}
    			}
            }
            break;  
            default:  
                super.handleMessage(msg);  
            }  
        }  
    };
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//初始化string.xml文件中配置的数值型数据
		StringValueForActivity.initOnlyOnce(this) ;
		instance = this ;
		//初始化小数据存储
		Preferences.initInstance(this) ;
		 
		this.broadcastReceiver = new MainBroadcastReceiver(this) ;
		this.broadcastReceiver.registerAndReceive() ;
		
		this.setContentView(R.layout.activity_main);
		tcpConnectStatus = (TextView) findViewById(R.id.tcpConnectStatus1);
		
		//创建界面
		this.createView();
		
		//声音
		this.soundAlert = new SoundAlert(this) ;
		
        
        //实例化fragment工具类对象
        this.frgTool = new FragmentTool(this) ;
        
        this.mActivityStub = StubActivity.createSingle(this)  ;

        //wifiOpenStatus = isWiFiActive();
        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if(!wifiManager.isWifiEnabled()) {
        	wifiManager.setWifiEnabled(true);
        }
 		//绑定后台服务，后台服务在接受第一个绑定时会启动自己
        this.bindService(new Intent(MainActivity.this, LocalServer.class), mConnection, Context.BIND_AUTO_CREATE);
        
	}
    
 /*   public boolean isWiFiActive() {    
        ConnectivityManager connectivity = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);    
        if (connectivity != null) {    
            NetworkInfo[] infos = connectivity.getAllNetworkInfo();    
            if (infos != null) {    
            	for(NetworkInfo ni : infos){
            		if(ni.getTypeName().equals("WIFI") && ni.isConnected()){
            			return true;
            		}
            	}
            }    
        }    
        return false;    
    } */
    
    
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();
			} else {
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onResume() {
		super.onResume();
	}
	@Override
	protected void onPause() {
		super.onPause();
	}
	@Override
	protected void onStop() {
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//取消广播接收注册
		broadcastReceiver.unRegisterBroadcastReceiver() ;
		//activity绑定了server，在activity退出前要取消绑定，
		//否则android系统会报错，然后android系统替你完成取消绑定
		if(mActivityStub != null){
			unbindService(mConnection);
		}
		ServerProxyHandler.getInstance().stopServer() ;
	}

	/**
	 * 初始化ViewPager 
	 */
	private void createView() {
		mPager = (ViewPager) findViewById(R.id.vPager);
		LayoutInflater mInflater = this.getLayoutInflater();
		
		pageView_noProtocol = mInflater.inflate(R.layout.activity_main_noprotocol_page, null) ;
		pageView_loopQuery = mInflater.inflate(R.layout.activity_main_loopquery_page, null) ;
		pageView_function = mInflater.inflate(R.layout.activity_main_function_page, null) ;
		//pageView_channel = mInflater.inflate(R.layout.activity_main_channel_page, null) ;
		
		listPages = new ArrayList<View>();
		listPages.add(pageView_noProtocol);
		listPages.add(pageView_loopQuery);
		listPages.add(pageView_function);
		//listPages.add(pageView_channel);
		
		mPager.setAdapter(new ViewPagerAdapter(listPages));
		mPager.setCurrentItem(2);
		mPager.setOnPageChangeListener(new FlipPageChangeListener());
		
		
		//////////////////////////////////////////////////////////////
		//功能子页
	func_scrollView = (ScrollView)pageView_function.findViewById(R.id.f_func_scrollView) ;
       
	/*		chLine_01 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_01) ;
		chLine_02 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_02) ;
		chLine_03 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_03) ;
		chLine_04 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_04) ;
		
		chLine_04.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View v) {
				pageView_channel_OnLongClick() ;
				return false;
			}
		}) ;*/
		
		npFragmentLinear_02 = (LinearLayout)pageView_noProtocol.findViewById(R.id.npFragmentLinear_02) ;
		npFragmentLinear_03 = (LinearLayout)pageView_noProtocol.findViewById(R.id.npFragmentLinear_03) ;
       
        ////////////////////////////////////////////////////////
        //帮助类
        //实例化fragment回调类对象
        this.frgCallback = new FragmentCallback(this) ;
        //实例化主界面设置帮助类对象
        //this.mainHelp = new MainActivityHelp(this, pageView_noProtocol, pageView_loopQuery, pageView_function, pageView_channel) ;
        this.mainHelp = new MainActivityHelp(this, pageView_noProtocol, pageView_loopQuery, pageView_function) ;
        //执行初始设置
        this.mainHelp.onCreateView() ;
	}
	
	/**
	 * 最小面部分界面最大小化，其他部分界面隐藏
	 */
	public void pageView_channel_OnLongClick(){
		int vis = chLine_01.getVisibility() ;
		if(vis == View.VISIBLE){
			chLine_01.setVisibility(View.GONE) ;
			chLine_02.setVisibility(View.GONE) ;
			chLine_03.setVisibility(View.GONE) ;
			
			frgTool.fragment_ch04.setRtuDatasListViewHeight(ResourceUtils.getXmlDef(this, R.dimen.ch_rtuDataListViewHeight_big)) ;
		}else{
			chLine_01.setVisibility(View.VISIBLE) ;
			chLine_02.setVisibility(View.VISIBLE) ;
			chLine_03.setVisibility(View.VISIBLE) ;
			
			frgTool.fragment_ch04.setRtuDatasListViewHeight(ResourceUtils.getXmlDef(this, R.dimen.ch_rtuDataListViewHeight_small)) ;
		}
	}
	
	/**
	 * 响铃
	 * @return
	 */
	public SoundAlert getSoundAlert() {
		return soundAlert;
	}
	
	/**
	 * 得到fragment的工具类对象
	 * @return
	 */
	public FragmentTool getFrgTool() {
		return frgTool;
	}
	
	/**
	 * 得到fragment的回调工具类对象
	 * @return
	 */
	public MainActivityHelp getMainSetHelp() {
		return mainHelp;
	}
	
	/**
	 * 得到fragment的回调工具类对象
	 * @return
	 */
	public FragmentCallback getFrgCallback() {
		return frgCallback;
	}
	
	/**
	 * 得到Activity的桩
	 * @return
	 */
	public StubActivity getActivityStub(){
		return this.mActivityStub ;
	}
	/**
	 * 得到后台服务代理持有者，当没有启动后台服务时，返回空
	 * @return
	 */
	public ServerProxyHandler getServerProxyHandler(){
		return ServerProxyHandler.getInstance() ;
	}
	
	/**
	 * 设置网络连接状态
	 * @param isConnected
	 */
	public void setNetConnectedStatus(boolean isConnected) {
		this.tcpConnected = isConnected ;
		if(this.tcpConnected){
			//网络已经连接
			tcpConnectStatus.setText(this.getResources().getString(R.string.tcpStatus) + this.getResources().getString(R.string.connected)) ;
			tcpConnectStatus.setTextColor(Color.RED);
			
		}else{
			//网络已经断开
			tcpConnectStatus.setText(this.getResources().getString(R.string.tcpStatus) + this.getResources().getString(R.string.disconnected)) ;
			tcpConnectStatus.setTextColor(Color.WHITE);
		}
	}
	
	/**
	 * ViewPager适配器
	 */
	public class ViewPagerAdapter extends PagerAdapter {
		public List<View> mListViews;

		public ViewPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}

	/**
	 *  页卡切换监听
	 *  横隔栏结构如下
	 *  offset bmpW offset offset bmpW offset offset bmpW offset 
	 */
	public class FlipPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int arg0) {
			MainActivity.this.frgTool.pageViewSelected(arg0) ;
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}


}