package com.blg.rtu;

import android.content.ComponentName;
import android.os.RemoteException;

import com.blg.rtu.aidl.RemoteData;
import com.blg.rtu.aidl.RemoteParcel;
import com.blg.rtu.aidl.ServiceAidl;
import com.blg.rtu.protocol.RtuCommand;

public class ServerProxyHandler {
	
	@SuppressWarnings("unused")
	private static MainActivity mAct ;
	
	//server代理，其根在server端实现，其是在Activity绑定Server时，Server端回传来的server代理
	private static ServiceAidl mServerProxy;

	private static ServerProxyHandler instance ;
	

	private ServerProxyHandler(){
	}
	
	/**
	 * 本方法创建单例，只有Activity创建例本地Server，Server把ServerStub桩的代理实例
	 * 返回给Activity端，此时Activity创建本单例。
	 * @param activityProxy
	 * @return
	 */
	public static ServerProxyHandler createSingle(ServiceAidl mServerProxy, MainActivity mAct){
		/*
		 * 这样不行，当MainActivity重新启动，这个对象好象还有值，不死掉
		if(instance == null){
			instance = new ServerProxyHandler();
			.....
		}
		*/
		instance = new ServerProxyHandler() ;
		ServerProxyHandler.mServerProxy = mServerProxy ;
		ServerProxyHandler.mAct = mAct ;
		return instance ;
	}
	
	/**
	 * 当Activity创建本单例前，调用此方法得到的实例为空
	 * @return
	 */
	public static ServerProxyHandler getInstance(){
		return instance ;
	}
	
	/**
	 * 失去对后台服务的连接
	 * @param className
	 */
	public void onServiceDisconnected(ComponentName className) {
		mServerProxy = null;
	}
	
	
	/**
	 * 通知远程服务器，连接网络
	 * @param url
	 * @param port
	 */
	public void startAndConnectTcpServer(String url, Integer port){
		if(mServerProxy != null){
			try {
				mServerProxy.startTcpConnect(url, port) ;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 询问远程服务，是否连接了网络
	 * 
	 * 此处注意：一般通过StubActivity来接收网络连接状态，后台服务总是每间隔一点时间就通知一下
	 * @return
	 */
	public boolean isTcpConnected(){
		try {
			return mServerProxy.isTcpConnected() ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false ;
	}
	
	/**
	 * 得到server层所查询得来的rtu id
	 * @return
	 */
	public String getRtuId(){
		try {
			return mServerProxy.getRtuId() ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	/**
	 * 通过网络通道发送RTU 命令
	 * @param com
	 */
	public void sendRtuCommandByTcp(RtuCommand com){
		RemoteData rdata = new RemoteData(null, com) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			mServerProxy.sendRtuCommandByTcp(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 所给功能码的命令不在发送
	 * @param com
	 */
	public void notSendCommandByCode(String code){
		try {
			mServerProxy.notSendCommandByCode(code) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 生成短信通道发送的命令
	*/
	public String createSmCommandBySm(RtuCommand com)throws RemoteException {
		String str = null ;
		RemoteData rdata = new RemoteData(null, com) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			str = mServerProxy.createSmCommandBySm(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str ;
	}
	
	/**
	 * 通过网络通道发送非协议文本数据
	 * @param com
	 */
	public void sendRtuNoProtocolTxtDataByTcp(String str){
		RemoteData rdata = new RemoteData(str) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			mServerProxy.sendRtuNoProtocolTxtDataByTcp(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过网络通道发送非协议十六进制数据
	 * @param com
	 */
	public void sendRtuNoProtocolHexDataByTcp(byte[] bs){
		RemoteData rdata = new RemoteData(bs) ;
		RemoteParcel parcel = new RemoteParcel(rdata) ;
		try {
			mServerProxy.sendRtuNoProtocolHexDataByTcp(parcel) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 处理短信通道 收到的RTU上行数据
	 * @param commandData
	 */
	public void dealSmData(String smData){
		try {
			mServerProxy.dealSmData(smData) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 来自界面操作自动查询任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	@SuppressWarnings("finally")
	public String operateAutoQuery(boolean start, boolean pause, boolean resume, boolean stop){
		String info = null ;
		try {
			info = mServerProxy.operateAutoQuery(start, pause, resume, stop) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return info ;
		}
	}
	/**
	 * 来自界面操作自动设置任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	@SuppressWarnings("finally")
	public String operateAutoSet(boolean start, boolean pause, boolean resume, boolean stop){
		String info = null ;
		try {
			info = mServerProxy.operateAutoSet(start, pause, resume, stop) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return info ;
		}
	}
	
	/**
	 * 关闭后台服务
	 */
	public void stopServer(){
		try {
			mServerProxy.stopServer() ;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
