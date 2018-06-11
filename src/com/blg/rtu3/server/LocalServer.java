package com.blg.rtu3.server;

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
	
	//在每个service的生命周期中这个方法会且仅会调用一次，并且它的调用在onStartCommand()以及onBond()之前，我们可以在这个方法中进行一些一次性的初始化工作
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
	
	//当其他组件通过bindService()方法与service相绑定之后，此方法将会被调用。这个方法有一个IBinder的返回值，这意味着在重写它的时候必须
	//返回一个IBinder对象，它是用来支撑其他组件与service之间的通信的——另外，如果你不想让这个service被其他组件所绑定，可以通过在这个方法返回一个null值来实现。
	//返回一个用做信息交互的IBinder接口,它是高性能而设计的轻量级远程调用机制的核心部分
	@Override
	public IBinder onBind(Intent t) {
		return serverStub;
	}
	
	//当其他组件通过startService()方法启动service时，此方法将会被调用。
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		//“非粘性的”。使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统不会自动重启该服务。
		return  START_NOT_STICKY ;
	}

	@Override
	public void onStart(Intent intent, int startId) {
	}
	
	//这是service一生中调用的最后一个方法，当这个方法被调用之后，service就会被销毁。所以我们应当在这个方法里面进行一些资源的清理，比如注册的一些监听器什么的。
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
