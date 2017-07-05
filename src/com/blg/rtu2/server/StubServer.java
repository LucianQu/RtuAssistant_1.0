package com.blg.rtu2.server;

import android.os.RemoteException;

import com.blg.rtu.aidl.ActivityAidl;
import com.blg.rtu.aidl.RemoteParcel;
import com.blg.rtu.aidl.ServiceAidl;
import com.blg.rtu.server.net.NetManager;
import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.Constant;

public class StubServer extends ServiceAidl.Stub {
	
	private static LocalServer server ;
	
	private static StubServer instance ;
	
	/**
	 * 构造方法
	 * @param server
	 * @param netManager
	 */
	private StubServer(){
	}
	
	/**
	 * 创建单例，只有本地Server创建时，本地Server才创建本单例
	 * @param server
	 * @return
	 */
	public static StubServer creatSingle(LocalServer server){
		/*
		 * 这样不行，当MainActivity重新绑定Server时，因为Server未被系统杀死，与它关联的对象都还活着，当Activity重新绑定Server时，这些对象要重构的，尤其要传进来一些新创建的对象，要把老对象替换
		if(instance == null){
			instance = new StubServer();
			.....
		}
		*/
		
		instance = new StubServer() ;
		StubServer.server = server ;
		return instance ;
	}
	/**
	 * 得到唯一实例，当本地Server未创建本单例时，此方法返回的实例为空
	 * @return
	 */
	public static StubServer getInstance(){
		return instance ;
	}
	
	/**
	 * 注册Activity代理
	 */
	@Override
	public void registerActivityProxy(ActivityAidl activityProxy) throws RemoteException {
		ActivityProxyHandler instance = ActivityProxyHandler.createSingle(activityProxy, server) ;
		server.setActivityProxyHandlerInstance(instance) ;
	}
	/**
	 * 通过TCP网络通道发给RTU的命令
	 */
	@Override
	public void sendRtuCommandByTcp(RemoteParcel parcel) throws RemoteException {
		RtuCommand command = parcel.packet.command ;
		new CoreControl(server).sendRtuCommandByTcp(command, false, true) ;
	}
	/**
	 * 所给功能码的命令不在发送
	*/
	@Override
	public void notSendCommandByCode(String code) throws RemoteException {
		new CoreControl(server).notSendCommandByCode(code) ;
	}

	/**
	 * 生成短信通道发送的命令
	*/
	@Override
	public String createSmCommandBySm(RemoteParcel parcel)throws RemoteException {
		RtuCommand command = parcel.packet.command ;
		return new CoreControl(server).createRtuCommandBySm(command, true) ;
	}

	/**
	 * 通过TCP网络通道发送非协议文本数据
	 */
	@Override
	public void sendRtuNoProtocolTxtDataByTcp(RemoteParcel parcel) throws RemoteException {
		String str = parcel.packet.strData ;
		new CoreControl(server).sendRtuNoProtocolTxtDataByTcp(str) ;
	}

	/**
	 * 通过TCP网络通道发送非协议十六进制数据
	 */
	@Override
	public void sendRtuNoProtocolHexDataByTcp(RemoteParcel parcel) throws RemoteException {
		byte[] bs = parcel.packet.byteDatas ;
		new CoreControl(server).sendRtuNoProtocolHexDataByTcp(bs) ;
	}
	
	/**
	 * 处理短信形式的RTU 上行数据
	*/
	@Override
    public void dealSmData(String smData){
		if(smData != null && smData.length() > 0){
			try{
				byte[] b = ByteUtil.hex2Bytes(smData) ;
				if(b != null && b.length > 0){
					new CoreControl(server).receiveRtuProtocolData(b, Constant.channelSm) ;
				}
			}catch(Exception e){
			}
		}
    }

    /**
	 * 启动网络连接，无异常返回true,否则返回false
	 * 调用此方法时，本地服务Server端已经启动，而本地服务Server端启动时创建了NetManager单例，
	 * 所以此处NetManager.getInstance()得到的单例不会为空
	 */
	@Override
	public boolean startTcpConnect(String url, int port)throws RemoteException {
		// 连接使能
		return NetManager.getInstance().createOrRecreatTcpConnect(url, port);
	}
    /**
	 * 是否连接上了网络
	 * 调用此方法时，本地服务Server端已经启动，而本地服务Server端启动时创建了NetManager单例,
	 * 所以此处NetManager.getInstance()得到的单例不会为空
	*/
	@Override
    public boolean isTcpConnected(){
    	return NetManager.getInstance().isNetConnect() ;
    }
    
    /**
     * 得到后台服务得到的RTU ID
     */
	@Override
   public String getRtuId(){
    	return CoreThread.getInstance().getRtuId() ;
    }
	
	/**
	 * 来自界面操作自动查询任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	@Override
	public String operateAutoQuery(boolean start, boolean pause, boolean resume, boolean stop){
		CoreThread ct = CoreThread.getInstance() ;
		if(ct != null){
			return ct.operateAutoQuery(start, pause, resume, stop) ;
		}else{
			return "内部出错！" ;
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
	@Override
	public String operateAutoSet(boolean start, boolean pause, boolean resume, boolean stop){
		CoreThread ct = CoreThread.getInstance() ;
		if(ct != null){
			return ct.operateAutoSet(start, pause, resume, stop) ;
		}else{
			return "内部出错！" ;
		}
	}


    /**
    * 停止server，解除绑定Server可以系统杀死server，但是什么时杀就不定了
    */
	@Override
    public void stopServer(){
		server.toStopSelf() ;
	}
}
