package com.blg.rtu3.server;

import android.os.RemoteException;

import com.blg.rtu.aidl.ActivityAidl;
import com.blg.rtu.aidl.RemoteData;
import com.blg.rtu.aidl.RemoteParcel;
import com.blg.rtu.protocol.RtuData;

public class ActivityProxyHandler {
	
	@SuppressWarnings("unused")
	private static LocalServer server ;
	private static ActivityProxyHandler instance ;
	
	//activity的代理，其根在activity端实现，其是Activity绑定server时注册过来的
	private static ActivityAidl activityProxy;
	//private RemoteCallbackList callbacklist ;//集合方式，接受多个activity代理

	private ActivityProxyHandler(){
	}
	
	/**
	 * 本方法创建单例，只有Activity创建例本地Server，Server把ServerStub桩的代理实例
	 * 返回给Activity端，Activity把自己的代理实例通过ServerStub桩注册给服务端，ServerStub
	 * 桩此时创建本单例。
	 * @param activityProxy
	 * @return
	 */
	public static ActivityProxyHandler createSingle(ActivityAidl activityProxy, LocalServer server){
		/*
		 * 这样不行，当MainActivity重新绑定Server时，因为Server未被系统杀死，与它关联的对象都还活着，当Activity重新绑定Server时，
		 * 这些对象要重构的，尤其要传进来一些新创建的对象，要把老对象替换
		if(instance == null){
			instance = new ActivityProxyHandler();
			.....
		}
		*/
		instance = new ActivityProxyHandler() ;
		ActivityProxyHandler.server = server ;
		ActivityProxyHandler.activityProxy = activityProxy ;
		//instance.callbacklist.register(callback) ;
		//instance.callbacklist.register(callback, null) ;
		return instance ;
	}
	/**
	 * 当ServerStub桩创建本单例前，调用此方法得到的实例为空
	 * @return
	 */
	public static ActivityProxyHandler getInstance(){
		return instance ;
	}
	
	/**
	 * 把将要下发的RTU命令数据回传给activity回显，以及更新命令发送状态
	 * @param data
	 */
	public void commandSendedCallBack(RtuData data){
		RemoteData rdata = new RemoteData(data, null) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			activityProxy.commandSendedCallBack(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 收到rtu非协议(调试)数据
	 * @param data
	 */
	public void rtuNoProtocolData(byte[] data){
		RemoteData rdata = new RemoteData(data) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			activityProxy.rtuNoPtotocolData(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 收到rtu命令结果数据,把其传Activity层
	 * @param data
	 */
	public void rtuCommandResult(RtuData data){
		RemoteData rdata = new RemoteData(data, null) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			activityProxy.rtuCommandResult(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 收到rtu主动上报数据,把其传Activity层
	 * @param data
	 */
	public void rtuReportData(RtuData data){
		RemoteData rdata = new RemoteData(data, null) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			activityProxy.rtuReportData(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 收到个改RTU ID命令的成功返回
	 * @param data
	 */
	public void newRtuId(String newId){
		try {
			activityProxy.newRtuId(newId) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 网络连接上了,通知Activity层  
	 */
	public void netConnected(){
		try {
			activityProxy.netConnected() ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 网络连接断了,通知Activity层  
	 */
	public void netDisconnect(){
		try {
			activityProxy.netDisconnect() ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向界面通知自动查询状态
	 * @param status
	 * @return
	 */
	public void notifyAutoQueryStatus(String status){
		try {
			activityProxy.notifyAutoQueryStatus(status) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向界面通知自动设置状态
	 * @param status
	 * @return
	 */
	public void notifyAutoSetStatus(String status){
		try {
			activityProxy.notifyAutoSetStatus(status) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 自动查询命令
	 * @param code
	 */
	public void autoQueryCommand(String code){
		try {
			activityProxy.autoQueryCommand(code) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 自动设置命令
	 * @param code
	 */
	public void autoSetCommand(String code){
		try {
			activityProxy.autoSetCommand(code) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	
}
