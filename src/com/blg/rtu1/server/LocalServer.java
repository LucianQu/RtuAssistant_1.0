package com.blg.rtu1.server;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.blg.rtu.server.net.NetManager;
import com.blg.rtu.util.StringValueForServer;

@SuppressLint("HandlerLeak")
public class LocalServer extends Service {

	//server的根，其代理在activity绑定server时返回给activity了
	private StubServer serverStub = null ;
	@SuppressWarnings("unused")
	private ActivityProxyHandler activityProxyHandler ;
	private NetManager netManager;
	private CoreThread coreThread ;
	
	public Handler mHandler = new Handler() {  
        @Override  
        public void handleMessage(Message msg) { 
        	
        }
	} ;

    @Override
	public void onCreate() {
		// 启动后台网络连接
		if(netManager == null){
			netManager = NetManager.createSingle(this) ;
		}
		if(serverStub == null){
			serverStub = StubServer.creatSingle(this)  ;
		}
		if(coreThread == null){
			coreThread = CoreThread.creatSingle(this)  ;
		}
		
		StringValueForServer.initOnlyOnce(this) ;
	}
	
	/**
	 * 当ActivityProxyHandler单例创建时，把实例交给Server端持有
	 * @param activityProxyHandler
	 */
	public void setActivityProxyHandlerInstance(ActivityProxyHandler activityProxyHandler){
		this.activityProxyHandler = activityProxyHandler ;
	}

	@Override
	public IBinder onBind(Intent t) {
		return serverStub;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		//“非粘性的”。使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统不会自动重启该服务。
		return  START_NOT_STICKY ;
	}

	@Override
	public void onStart(Intent intent, int startId) {
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//最后调用onDestroy()
		this.stopSelf() ;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
	}
	
	public void toStopSelf(){
		if(netManager != null){
			netManager.destroy() ;
		}
		//this.stopSelf() ;//放到onDestroy()中
	}
	
	
}
