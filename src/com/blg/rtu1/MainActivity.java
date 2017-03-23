package com.blg.rtu1;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
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
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu.aidl.ServiceAidl;
import com.blg.rtu.frmChannel.helpCh1.ChBusi_01_Operate;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu.util.SoundAlert;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu1.server.LocalServer;



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
	private View pageView_channel ;// Tab第3页
	
	public Boolean tcpConnected;
	public TextView tcpConnectStatus;
	
	public TextView switchFun ;
	public TextView switchOnce ;
	public TextView switchQuery ;
	public TextView switchLog ;
	
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
	//滚动条图片
	private ImageView scrollbar ;
	//滚动条初始偏移量
	private int offset = 0 ;
	//当前页编号
	private int currIndex = 0 ;
	// 滚动条宽度
    private int bmpW ;
    //一倍滚动量
    private int doubleRoll ;
	
	
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
		scrollbar = (ImageView)findViewById(R.id.scrollbar) ;
		pageView_noProtocol = mInflater.inflate(R.layout.activity_main_noprotocol_page, null) ;
		pageView_loopQuery = mInflater.inflate(R.layout.activity_main_loopquery_page, null) ;
		pageView_function = mInflater.inflate(R.layout.activity_main_function_page, null) ;
		pageView_channel = mInflater.inflate(R.layout.activity_main_channel_page, null) ;
		
		listPages = new ArrayList<View>();
		listPages.add(pageView_noProtocol);
		listPages.add(pageView_loopQuery);
		listPages.add(pageView_function);
		listPages.add(pageView_channel);
		
		tcpConnectStatus = (TextView) findViewById(R.id.tcpConnectStatus1);
		switchFun = (TextView) findViewById(R.id.switchFun) ;
		switchOnce = (TextView) findViewById(R.id.switchOnce) ;
		switchQuery = (TextView) findViewById(R.id.switchQuery) ;
		switchLog = (TextView) findViewById(R.id.switchLog) ;
		
		//获取滚动条的宽度
		bmpW = BitmapFactory.decodeResource(this.getResources(), R.drawable.scrollbar).getWidth();
		//为了获取屏幕宽度，新建一个DisplayMetrics对象
		DisplayMetrics displayMetrics = new DisplayMetrics() ;
		//将当前窗口的一些信息放在DisplayMetrics类中
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics) ;
		//得到屏幕的宽度
		int screenW = displayMetrics.widthPixels ;
		//计算出滚动条初始的偏移量
		offset = (screenW / 4 - bmpW) / 2 ;
		//计算出切换一个界面时，滚动条的位移量
		doubleRoll = offset * 2 + bmpW ;
		
		Matrix matrix = new Matrix() ;
		matrix.postTranslate(offset, 0) ;
		//将滚动条的初始位置设置成与左边界间隔一个offset
		scrollbar.setImageMatrix(matrix) ;
		
		mPager.setAdapter(new ViewPagerAdapter(listPages));//绑定适配器
		mPager.setCurrentItem(2);//设置viewPager的初始界面
		defaultAnimation(2) ;
		mPager.setOnPageChangeListener(new FlipPageChangeListener());//切换界面监听
		
		switchQuery.setOnClickListener(new clickLableListener()) ; 
		switchOnce.setOnClickListener(new clickLableListener()) ; 
		switchFun.setOnClickListener(new clickLableListener()) ;
		switchLog.setOnClickListener(new clickLableListener()) ;
		
		//////////////////////////////////////////////////////////////
		//功能子页
	func_scrollView = (ScrollView)pageView_function.findViewById(R.id.f_func_scrollView) ;
       
			/*chLine_01 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_01) ;
		chLine_02 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_02) ;
		chLine_03 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_03) ;*/
		chLine_04 = (LinearLayout)pageView_channel.findViewById(R.id.chLine_04) ;
		
		chLine_04.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View v) {
				pageView_channel_OnLongClick() ;
				return false;
			}
		}) ;
		
		npFragmentLinear_02 = (LinearLayout)pageView_noProtocol.findViewById(R.id.npFragmentLinear_02) ;
		npFragmentLinear_03 = (LinearLayout)pageView_noProtocol.findViewById(R.id.npFragmentLinear_03) ;
       
        ////////////////////////////////////////////////////////
        //帮助类
        //实例化fragment回调类对象
        this.frgCallback = new FragmentCallback(this) ;
        //实例化主界面设置帮助类对象
        this.mainHelp = new MainActivityHelp(this, pageView_noProtocol, pageView_loopQuery, pageView_function, pageView_channel) ;
        //this.mainHelp = new MainActivityHelp(this, pageView_noProtocol, pageView_loopQuery, pageView_function) ;
        //执行初始设置
        this.mainHelp.onCreateView() ;
	}
	
	/**
	 * 最小面部分界面最大小化，其他部分界面隐藏
	 */
	public void pageView_channel_OnLongClick(){
		//int vis = chLine_01.getVisibility() ;
		//if(vis == View.VISIBLE){
		/*	chLine_01.setVisibility(View.GONE) ;
			chLine_02.setVisibility(View.GONE) ;
			chLine_03.setVisibility(View.GONE) ;*/
			
			frgTool.fragment_ch04.setRtuDatasListViewHeight(ResourceUtils.getXmlDef(this, R.dimen.ch_rtuDataListViewHeight_big)) ;
		//}else{
		/*	chLine_01.setVisibility(View.VISIBLE) ;
			chLine_02.setVisibility(View.VISIBLE) ;
			chLine_03.setVisibility(View.VISIBLE) ;*/
			
			//frgTool.fragment_ch04.setRtuDatasListViewHeight(ResourceUtils.getXmlDef(this, R.dimen.ch_rtuDataListViewHeight_small)) ;
		//}
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
	
	public class clickLableListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()) {
			case R.id.switchQuery:
				mPager.setCurrentItem(0);//设置viewPager的初始界面
				defaultAnimation(0) ;
				break ;
			case R.id.switchOnce:
				mPager.setCurrentItem(1) ;
				defaultAnimation(1) ;
				break ;
			case R.id.switchFun:
				mPager.setCurrentItem(2) ;
				defaultAnimation(2) ;
				break ;
			case R.id.switchLog:
				mPager.setCurrentItem(3) ;
				defaultAnimation(3) ;
				break ;
			default :
				mPager.setCurrentItem(2) ;
				defaultAnimation(2) ;
				break ;
			}
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
			   Animation animation = null;
	            switch (arg0) {
	                case 0:
	                        /**
	                         * TranslateAnimation的四个属性分别为
	                         * float fromXDelta 动画开始的点离当前View X坐标上的差值 
	                         * float toXDelta 动画结束的点离当前View X坐标上的差值 
	                         * float fromYDelta 动画开始的点离当前View Y坐标上的差值 
	                         * float toYDelta 动画开始的点离当前View Y坐标上的差值
	                        **/
	                        animation = new TranslateAnimation(doubleRoll, 0, 0, 0);
	                        switchQuery.setTextColor(Color.parseColor("#4c79c5")) ;
	            			switchOnce.setTextColor(Color.parseColor("#b2b2b2")) ;
	            			switchFun.setTextColor(Color.parseColor("#b2b2b2")) ;
	            			switchLog.setTextColor(Color.parseColor("#b2b2b2")) ;
	                    break;
	                case 1:
	                        animation = new TranslateAnimation(doubleRoll + offset, doubleRoll, 0, 0);
	                        switchQuery.setTextColor(Color.parseColor("#b2b2b2")) ;
	            			switchOnce.setTextColor(Color.parseColor("#4c79c5")) ;
	            			switchFun.setTextColor(Color.parseColor("#b2b2b2")) ;
	            			switchLog.setTextColor(Color.parseColor("#b2b2b2")) ;
	                    break;
	                case 2:
                        animation = new TranslateAnimation(2*doubleRoll + offset, 2*doubleRoll, 0, 0);
                        switchQuery.setTextColor(Color.parseColor("#b2b2b2")) ;
            			switchOnce.setTextColor(Color.parseColor("#b2b2b2")) ;
            			switchFun.setTextColor(Color.parseColor("#4c79c5")) ;
            			switchLog.setTextColor(Color.parseColor("#b2b2b2")) ;
                    break;
	                case 3:
                        animation = new TranslateAnimation(3*doubleRoll + offset, 3*doubleRoll, 0, 0);
                        switchQuery.setTextColor(Color.parseColor("#b2b2b2")) ;
            			switchOnce.setTextColor(Color.parseColor("#b2b2b2")) ;
            			switchFun.setTextColor(Color.parseColor("#b2b2b2")) ;
            			switchLog.setTextColor(Color.parseColor("#4c79c5")) ;
                    break;
	            }
	          //arg0为切换到的页的编码
	            currIndex = arg0;
	            // 将此属性设置为true可以使得图片停在动画结束时的位置
	            animation.setFillAfter(true);
	            //动画持续时间，单位为毫秒
	            animation.setDuration(200);
	            //滚动条开始动画
	            scrollbar.startAnimation(animation);
			
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
		
	}
	
	public void defaultAnimation(int arg0) {
		Animation animation = null ;
		switch(arg0) {
		case 0:
			animation = new TranslateAnimation(doubleRoll , 0 , 0 ,0) ;
			switchQuery.setTextColor(Color.parseColor("#4c79c5")) ;
			switchOnce.setTextColor(Color.parseColor("#b2b2b2")) ;
			switchFun.setTextColor(Color.parseColor("#b2b2b2")) ;
			switchLog.setTextColor(Color.parseColor("#b2b2b2")) ;
			break ;
		case 1:
			animation = new TranslateAnimation(doubleRoll + offset, doubleRoll , 0 , 0) ;
			switchQuery.setTextColor(Color.parseColor("#b2b2b2")) ;
			switchOnce.setTextColor(Color.parseColor("#4c79c5")) ;
			switchFun.setTextColor(Color.parseColor("#b2b2b2")) ;
			switchLog.setTextColor(Color.parseColor("#b2b2b2")) ;
			
			break ;
		case 2:
			animation = new TranslateAnimation(2 * doubleRoll + offset, 2 * doubleRoll, 0, 0) ;
			switchQuery.setTextColor(Color.parseColor("#b2b2b2")) ;
			switchOnce.setTextColor(Color.parseColor("#b2b2b2")) ;
			switchFun.setTextColor(Color.parseColor("#4c79c5")) ;
			switchLog.setTextColor(Color.parseColor("#b2b2b2")) ;
			break ;
		 case 3:
             animation = new TranslateAnimation(3*doubleRoll + offset, 3*doubleRoll, 0, 0);
             switchQuery.setTextColor(Color.parseColor("#b2b2b2")) ;
 			switchOnce.setTextColor(Color.parseColor("#b2b2b2")) ;
 			switchFun.setTextColor(Color.parseColor("#b2b2b2")) ;
 			switchLog.setTextColor(Color.parseColor("#4c79c5")) ;
         break;
		}
		currIndex = arg0 ;
		animation.setFillAfter(true) ;
		animation.setDuration(200) ;
		scrollbar.startAnimation(animation) ;
	} 


}