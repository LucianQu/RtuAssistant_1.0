package com.blg.rtu.server.net;

import java.util.*;

import org.apache.mina.core.session.IoSession;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.StringValueForServer;
import com.blg.rtu2.server.CoreControl;
import com.blg.rtu2.server.LocalServer;

public class NetManager {
	
	class SendData{
		public int sendTimes ;//发送次数
		public String code ;//功能码
		public byte[] data ;//命令数据
		public String rtuId ;//RTU ID
		public boolean showInAcitivity;//在activity中显示命令HEX数据
		public SendData(int sendTimes, String code, byte[] data, String rtuId, boolean showInAcitivity){
			this.sendTimes = sendTimes ;
			this.code = code ;
			this.data = data ;
			this.rtuId = rtuId ;
			this.showInAcitivity = showInAcitivity ;
		}
	}

	private static String tag = NetManager.class.getName() ;
	
	private LocalServer localSv;// 后台服务
	private boolean canConnectRemote;// 是否可以连接网络到远端服务
	private String remoteServerUrl;// 远端服务器URL
	private int remoteServerPort;// 远端服务器端口
	private TcpConnect tcpConnect;// tcp连接客户端
	private boolean tcpConnectOk;// 是否连接上网络

	private List<byte[]> tcpReceiveProtocolDatas;// 通过TCP通道接收的协议数据
	private List<byte[]> tcpReceiveNoProtocolDatas;// 通过TCP通道接收的非协议(调试)数据
	private List<SendData> tcpSendDatas;// 通过TCP通道发送的数据

	private Object synObj_forReceiveProtocolData;// 线程接收协议数据同步对象
	private Object synObj_forReceiveNoProtocolData;// 线程接收非协议(调试)数据同步对象
	private Object synObj_forSendData;// 线程发送数据同步对象
	private Object synObj_canConnectRemote;// 允许连接网络

	private static final int sendData_notCan = -1;// 网络未准备好，不能发送数据
	private static final int sendData_ok = 1;// 网络已经准备好，可以发送数据

	private ConnectivityManager connManager;// android操作系统联网管理器

	private static NetManager instance;

	private static ReceiveProtocolDataThread receiveProtocolDataThread;//负责接收协议数据的线程
	private static ReceiveNoProtocolDataThread receiveNoProtocolDataThread;//负责接收非协议(调试)数据的线程
	private static NetManagerThread mainThread;//负责建立网络连接及发送数据

	/**
	 * 构造方法
	 */
	private NetManager() {
		synObj_forReceiveProtocolData = new Object();
		synObj_forReceiveNoProtocolData = new Object();
		synObj_forSendData = new Object();
		synObj_canConnectRemote = new Object();
		tcpReceiveProtocolDatas = new ArrayList<byte[]>();
		tcpReceiveNoProtocolDatas = new ArrayList<byte[]>();
		tcpSendDatas = new ArrayList<SendData>();
		this.canConnectRemote = false;
	}

	/**
	 * 得到唯一实例
	 * 
	 * @return
	 */
	public static NetManager createSingle(LocalServer localSv) {
		/*
		 * 这样不行，当MainActivity重新绑定Server时，因为Server未被系统杀死，与它关联的对象都还活着，
		 * 当Activity重新绑定Server时，这些对象要重构的，尤其要传进来一些新创建的对象，要把老对象替换
		if(instance == null){
			instance = new NetManager();
			.....
		}
		*/
		instance = new NetManager();
		
		instance.localSv = localSv ;
		
		instance.connManager = (ConnectivityManager) instance.localSv.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		receiveProtocolDataThread = instance.new ReceiveProtocolDataThread(instance);
		receiveProtocolDataThread.start();
		
		receiveNoProtocolDataThread = instance.new ReceiveNoProtocolDataThread(instance);
		receiveNoProtocolDataThread.start();
		
		mainThread = instance.new NetManagerThread(instance);
		mainThread.start();
		
		return instance;
	}
	
	/**
	 * 得到唯一实例 
	 * 
	 * @return
	 */
	public static NetManager getInstance() {
		return instance;
	}
	
	/**
	 * 设置了新IP或端口号，进行新的网络连接。
	 * @param remoteServerUrl
	 * @param remoteServerPort
	 */
	public boolean createOrRecreatTcpConnect(String remoteServerUrl,Integer remoteServerPort){
		if(remoteServerUrl == null || remoteServerPort == null){
			return false ;
		}
		
		if(instance.tcpConnectOk){
			//现在已经连接网了
			if(instance.remoteServerUrl.equals(remoteServerUrl) && instance.remoteServerPort == remoteServerPort.intValue()){
				//重复设置了，不理采
				return true ;
			}else{
				//不相同
				instance.remoteServerUrl = remoteServerUrl;
				instance.remoteServerPort = remoteServerPort;
				instance.tcpConnectOk = false ;
				instance.canConnectRemote = false ;
				instance.synObj_forSendData.notifyAll() ;
				synchronized (this.synObj_canConnectRemote) {
					this.synObj_canConnectRemote.notifyAll();
				}
				try {
					//睡眠一下，等待线程执行完.
					Thread.sleep(100) ;
				} catch (InterruptedException e) {
				}finally{
					//线程执行完了，因判断是不能连接远端而进入等待。
					//线程进入等待后，可以关闭网络了
					instance.closeNet() ;
					//使能连网，线程会自动连接网络
					instance.canConnectRemote = true ;
					synchronized (this.synObj_canConnectRemote) {
						this.synObj_canConnectRemote.notifyAll();
					}
				}
				return true ;
			}
		}else{
			//网络还未连接
			instance.remoteServerUrl = remoteServerUrl;
			instance.remoteServerPort = remoteServerPort;
			//使能连网，线程会自动连接网络
			instance.canConnectRemote = true ;
			synchronized (this.synObj_canConnectRemote) {
				this.synObj_canConnectRemote.notifyAll();
			}
			return true ;
		}
	}

	/**
	 * 设置是否可以连接远端
	 * 
	 * @param value
	 */
	public void toggleConnectRemote(boolean value) {
		if ((this.canConnectRemote && value)
				|| (!this.canConnectRemote && !value)) {
		} else if (this.canConnectRemote && !value) {
			this.canConnectRemote = false;
			this.closeNet();
		} else if (!this.canConnectRemote && value) {
			this.canConnectRemote = true;
			synchronized (this.synObj_canConnectRemote) {
				this.synObj_canConnectRemote.notifyAll();
			}
		}
	}


	/**
	 * 询问是否已经联网
	 */
	public boolean isNetConnect() {
		return this.tcpConnectOk;
	}

	/**
	 * 关闭网络
	 */
	public void closeNet() {
		if (this.tcpConnect != null) {
			this.tcpConnect.closeConnect();
			this.tcpConnectOk = false;
			this.tcpConnect = null;
		}
	}
	
	/**
	 * 销毁
	 */
	public void destroy(){
		try{
			mainThread.destroy() ;
		}catch(Exception e){}
		finally{
			try{
				receiveProtocolDataThread.destroy() ;
				receiveNoProtocolDataThread.destroy() ;
			}catch(Exception e){}
			finally{
				try{
					this.closeNet() ;	
				}catch(Exception e){}
			}
		}
	}
	
	/**
	 * 发出通知网络连接同状
	 * @param statuc 为true表示连接上了，false表法未连接上
	 */
	public void notifyNetConnectStatus(boolean status) {
		CoreControl cc = new CoreControl(localSv) ;
		if (cc != null) {
			if (status) {
				cc.netConnected();
			} else {
				cc.netDisconnect();
			}
		}
	}
	/**
	 * 通知已经发送了数据
	 */
	public void notifySendedData(){
		new CoreControl(localSv).notifySendedData() ;
	}
	/**
	 * 通知无数据等待
	 */
	public void notifyNoDataWaite(){
		new CoreControl(localSv).notifyNoDataWaite() ;
	}

	/**
	 * 接收到协议数据
	 * 
	 * @param data
	 */
	public void receiveProtocolData(byte[] data) {
		synchronized (this.synObj_forReceiveProtocolData) {
			this.tcpReceiveProtocolDatas.add(data);
			this.synObj_forReceiveProtocolData.notifyAll();
		}
	}
	/**
	 * 接收到非协议数据(调试数据)
	 * 
	 * @param data
	 */
	public void receiveNoProtocolData(byte[] data) {
		synchronized (this.synObj_forReceiveNoProtocolData) {
			this.tcpReceiveNoProtocolDatas.add(data);
			this.synObj_forReceiveNoProtocolData.notifyAll();
		}
	}
	
	/**
	 * 已经成功解析了所接收到的数据
	 * 把对应所接收数据的命令数据从集合中清除
	 * @param code
	 */
	public void parsedReceiveData(String code){
		if(code != null){
			synchronized (this.synObj_forSendData) {
				int size = tcpSendDatas.size() ;
				if(size > 0){
					for(int i = 0 ; i < size ; i++){
						SendData sd = this.tcpSendDatas.get(i) ;
						if(sd.code.equals(code)){
							this.tcpSendDatas.remove(i) ;
							break ;
						}
					}
				}
				this.synObj_forSendData.notifyAll() ;
			}
		}
	}

	/**
	 * 发送网络数据 
	 * 
	 * @param data
	 * @return
	 */
	public int sendData(String code, byte[] data, String rtuId, boolean sendOnlyOnce, boolean showInActivit) {
		if(code != null && data != null){
			if (this.canConnectRemote) {
				// 允许连接网络
				if (!this.tcpConnectOk) {
					return sendData_notCan;
				} else {
					synchronized (this.synObj_forSendData) {
						if(sendOnlyOnce){
							this.tcpSendDatas.add(new SendData(StringValueForServer.commandSendMaxTimes-1, code, data, rtuId, showInActivit));
						}else{
							this.tcpSendDatas.add(new SendData(0, code, data, rtuId, showInActivit));
						}
						this.synObj_forSendData.notifyAll();
					}
					return sendData_ok;
				}
			}
		}
		return sendData_notCan;
	}
	
	/**
	 * 所给功能码的命令不在发送
	*/
	public void notSendDataByCode(String code) {
		synchronized (this.synObj_forSendData) {
			boolean found = false ;
			int size = tcpSendDatas.size() ;
			if(size > 0){
				found = doNotSendDataByCode(code) ;
				while(found){
					found = doNotSendDataByCode(code) ;
				}
			}
			this.synObj_forSendData.notifyAll();
		}
	}
	private boolean doNotSendDataByCode(String code){
		boolean found = false ;
		int size = tcpSendDatas.size() ;
		if(size > 0){
			for(int i = 0 ; i < size ; i++){
				SendData sd = this.tcpSendDatas.get(i) ;
				if(sd.code.equals(code)){
					this.tcpSendDatas.remove(i) ;
					found = true ;
					break ;
				}
			}
		}
		return found ;
	}

	
	/**
	 * 发送非协议文本数据
	 * @param str
	 */
	public void sendNoProtocolTxtData(String str){
		if(str != null && !str.equals("")){
			synchronized (this.synObj_forSendData) {
				this.tcpConnect.send(str.getBytes());
				this.synObj_forSendData.notifyAll() ;
			}
		}
	}
	
	
	/**
	 * 发送非协议16进制数据
	 * @param bs
	 */
	public void sendNoProtocolHexData(byte[] bs){
		if(bs != null && bs.length > 0){
			synchronized (this.synObj_forSendData) {
				this.tcpConnect.send(bs);
				this.synObj_forSendData.notifyAll() ;
			}
		}
	}
	
	
	/**
	 * 处理接收协议数据线程
	 * @author Administrator
	 *
	 */
	public class ReceiveProtocolDataThread extends Thread{
		private boolean loop ;
		private NetManager nm;

		public ReceiveProtocolDataThread(NetManager nm) {
			loop = true ;
			this.nm = nm;
		}
		
		/**
		 * 线程销毁
		 */
		@Override
		public void destroy() {
			loop = false ;
			synchronized (nm.synObj_forReceiveProtocolData) {
				nm.synObj_forReceiveProtocolData.notifyAll() ;
			}
			this.interrupt();
		}

		@SuppressWarnings("finally")
		@Override
		public void run() {
			while (loop) {
				try{
					if (nm.tcpReceiveProtocolDatas == null || nm.tcpReceiveProtocolDatas.size() == 0) {
						// 没有数据，等待
						synchronized (nm.synObj_forReceiveProtocolData) {
							try {
								synObj_forReceiveProtocolData.wait(); 
							} catch (InterruptedException e) {
								continue ;
							}
						}
						// 有数据到来，被唤醒
					} 
					
					if (nm.tcpReceiveProtocolDatas != null && nm.tcpReceiveProtocolDatas.size() > 0) {
						byte[] b = nm.tcpReceiveProtocolDatas.get(0);
						nm.tcpReceiveProtocolDatas.remove(0);
						
						new CoreControl(nm.localSv).receiveRtuProtocolData(b, Constant.channelTcp) ;
					}
				}catch(Exception e){
					Log.e(tag, e.getMessage()) ;
					e.printStackTrace() ;
				}finally{
					continue ;
				}
			}
		}
	}

	
	/**
	 * 处理接收非协议(调试)数据线程
	 * @author Administrator
	 *
	 */
	public class ReceiveNoProtocolDataThread extends Thread{
		private boolean loop ;
		private NetManager nm;

		public ReceiveNoProtocolDataThread(NetManager nm) {
			loop = true ;
			this.nm = nm;
		}
		
		/**
		 * 线程销毁
		 */
		@Override
		public void destroy() {
			loop = false ;
			synchronized (nm.synObj_forReceiveNoProtocolData) {
				nm.synObj_forReceiveNoProtocolData.notifyAll() ;
			}
			this.interrupt();
		}

		@SuppressWarnings("finally")
		@Override
		public void run() {
			while (loop) {
				try{
					if (nm.tcpReceiveNoProtocolDatas == null || nm.tcpReceiveNoProtocolDatas.size() == 0) {
						// 没有数据，等待
						synchronized (nm.synObj_forReceiveNoProtocolData) {
							try {
								synObj_forReceiveNoProtocolData.wait(); 
							} catch (InterruptedException e) {
								continue ;
							}
						}
						// 有数据到来，被唤醒
					} 
					
					if (nm.tcpReceiveNoProtocolDatas != null && nm.tcpReceiveNoProtocolDatas.size() > 0) {
						byte[] b = nm.tcpReceiveNoProtocolDatas.get(0);
						nm.tcpReceiveNoProtocolDatas.remove(0);
						
						new CoreControl(nm.localSv).receiveRtuNoProtocolData(b) ;
					}
				}catch(Exception e){
					Log.e(tag, e.getMessage()) ;
					e.printStackTrace() ;
				}finally{
					continue ;
				}
			}
		}
	}
	
	
	/**
	 * 主处理线程
	 * 负责建立网络连接及发送数据
	 * 
	 * @author Administrator
	 * 
	 */
	public class NetManagerThread extends Thread {
		private boolean loop ;
		private NetManager nm;

		public NetManagerThread(NetManager nm) {
			loop = true ;
			this.nm = nm;
		}
		
		/**
		 * 线程销毁
		 */
		@Override
		public void destroy() {
			loop = false ;
			synchronized (nm.synObj_forSendData) {
				nm.synObj_forSendData.notifyAll() ;
			}
			synchronized (nm.synObj_canConnectRemote) {
				nm.synObj_canConnectRemote.notifyAll() ;
			}
			this.interrupt();
		}

		@SuppressWarnings("finally")
		@Override
		public void run() {
			while (loop) {
				try{
					if (!nm.canConnectRemote) {
						// 不允许连接网络
						// 见方法toggleConnectRemote，当不允许连接网络时，已经连接的网络也要断掉
						synchronized (nm.synObj_canConnectRemote) {
							// 等待，直到改变
							try {
								nm.notifyNetConnectStatus(false) ;
								nm.synObj_canConnectRemote.wait();
								// 等待结束后，可以联网并发数据了
								// 把之前设置的要发送的数据置空
								tcpSendDatas.clear();
							} catch (InterruptedException e) {
							}
						}
						continue;
					} else {
						try {
							// 首先处理上网
							// [0]是否允许连网(即系统wifi或3G打开)，[1]可连网的通道类型,[2]等待时间
							Object[] os = nm.dealNetConnection();
							if (os != null && os[0] != null && ((Boolean) os[0]).booleanValue()) {
								// 允许连网(即系统wifi或3G打开)，然后连接服务器
								long failThenSleep = 0;
								// 创建TCP方式到服务器的连接
								failThenSleep = nm.creatTcpConnectClient();
								if (failThenSleep > 0) {
									//未成功联接远端
									nm.tcpConnectOk = false;
									tcpSendDatas.clear();
									nm.notifyNetConnectStatus(false) ;
								} else {
									//成功联接远端
									if(!nm.tcpConnectOk){
										//初次连接成功
										tcpSendDatas.clear();
									}
									nm.tcpConnectOk = true;
									nm.notifyNetConnectStatus(true) ;
								}

								if (!nm.tcpConnectOk) {
									// 不能连接到服务器，等待一会，然后再循环以再次尝试连接
									if (failThenSleep > 0) {
										Thread.sleep(failThenSleep);
									}
									continue;
								} else {
									// 已经连接到服务器
									if (nm.tcpSendDatas == null || nm.tcpSendDatas.size() == 0) {
										// 没有数据，等待
										nm.notifyNoDataWaite() ;
										
										synchronized (nm.synObj_forSendData) {
											try {
												synObj_forSendData.wait(1000);// 不用wait()，因为移动状态下，网络很可能随时断了，所以只等待X毫秒，重新循环，可及时连网
											} catch (InterruptedException e) {
											}
										}
										// 有数据到来，被唤醒
										// 在等待数据过程中网络状态可能已经改变，重新循环再次检测网络
										continue;
									} else {
										// 有要发送的数据
										
										if (nm.tcpConnect != null && nm.tcpConnectOk) {
											// 连接上网络了，网络发送数据
											synchronized (nm.synObj_forSendData) {
												SendData sd = tcpSendDatas.get(0) ;
												if(sd != null){
													nm.tcpConnect.send(sd.data);
													sd.sendTimes++ ;
													if(sd.sendTimes >= StringValueForServer.commandSendMaxTimes){
														//发送达到最大次数
														nm.tcpSendDatas.remove(0) ;
													}
													if(sd.showInAcitivity){
														(new CoreControl(localSv)).commandSendedCallBack(sd.data, sd.rtuId, sd.code, Constant.channelTcp) ;
													}
												}
												nm.synObj_forSendData.notifyAll() ;
											}
											
											nm.notifySendedData() ;
											
											//发送数据后，进行命令间等待，即下发命令有一个间隔时长
											try{
												Thread.sleep(StringValueForServer.commandInterval);
											}catch(Exception e){} ;
										}
									}
								}
							} else {
								// 当未连接到网络上，可能正在打开设备中，或不能打开设备
								// 等待一会，再次循环
								nm.tcpConnectOk = false;
								nm.notifyNetConnectStatus(false) ;
								Integer sleep = (Integer) os[2];
								if (sleep > 0) {
									Thread.sleep(sleep);
								}
								// 循环，进行再处理
								continue;
							}
						} catch (Exception exc) {
						} finally {
							continue;
						}
					}				
				}catch(Exception e){
				}finally{
					continue ;
				}
			}
		}
	}


	/**
	 * 建立TCP连接
	 */
	@SuppressWarnings("finally")
	private long creatTcpConnectClient() {
		long failThenSleep = 0;
		try {
			// 创建TCP方式到服务器的连接
			if (this.tcpConnect == null) {
				this.tcpConnect = new TcpConnect(this.remoteServerUrl, this.remoteServerPort );
				this.tcpConnect.createConnect();
			}
			
			if(this.tcpConnect != null){
				IoSession se = this.tcpConnect.getSession();
				if (se == null || !se.isConnected()) {
					// sendMessage("再次创建wifi-TCP连接") ;
					this.tcpConnect.createConnect();
					se = this.tcpConnect.getSession();
				}

				if (se != null && se.isConnected()) {
					// sendMessage("已经wifi-TCP连接上服务器") ;
					// 已经连接上服务器
				} else if (se == null) {
					// sendMessage("得到wifi-TCP连接会话为空") ;
					failThenSleep = 10000;// 等待10秒
				} else {
					// sendMessage("得到wifi-TCP连接不可用") ;
					failThenSleep = 10000;// 等待10秒
				}
			}else{
				// sendMessage("得到wifi-TCP连接不可用") ;
				failThenSleep = 10000;// 等待10秒
			}


		} catch (Exception e) {
			e.printStackTrace();
			failThenSleep = 10000;// 等待10秒
		} finally {
			return failThenSleep;
		}
	}

	/**
	 * 处理上网
	 * 
	 * @return [0]是否允许连网，[1]可连网的通道类型,[2]等待时间
	 */
	@SuppressWarnings("finally")
	private Object[] dealNetConnection() {
		Object[] rtn = null;
		try {
			// 得到已经连接的networkInfo,或者是wifi或者是3G
			//
			// NetworkInfo指的是已经联接的网络情况，
			// 对于wifi，就指手机到无线路由器之间网络联接情况，
			// 对于3G，就指手机与基站入接入商服务器之间的3G网络联接情况
			// 如果这些网络联接好了，就可以建立自己的终端到服务器之间的联接
			NetworkInfo activeNet = this.connManager.getActiveNetworkInfo();
			if (activeNet != null) {
				// wifi或3G打开了，并连接上网络
				if (!activeNet.isAvailable()) {
					// 设备成功打开，无线网络不可用，还未联接到wifi的无线路由器，或3G基站
					/*
					 * public boolean isAvailable () Indicates whether network
					 * connectivity is possible. A network is unavailable when a
					 * persistent or semi-persistent condition prevents the
					 * possibility of connecting to that network. Examples
					 * include 1.The device is out of the coverage area for any
					 * network of this type.(设备在无线信号覆盖范围外) 2.The device is on a
					 * network other than the home network (i.e., roaming), and
					 * data roaming has been disabled.(设备在家庭网络之外的网络上，但数据漫游被禁用)
					 * 3.The device's radio is turned off, e.g., because
					 * airplane mode is enabled.(航空模式启动了，设备无线被关闭) Returns true
					 * if the network is available, false otherwise
					 */
					rtn = new Object[] { false, null, 10000 };// 等待10秒
				} else if (!activeNet.isConnected()) {
					// 设备成功打开，无线网络良好，但还未联接上网络
					rtn = new Object[] { false, null, 10000 };// 等待10秒
				} else if (activeNet.isConnected()) {
					// 设备成功打开，无线网络良好，已经联接上无线网络(wifi或3G)
					// 如果wifi及3G设备都打开，那系统默认首选wifi
					rtn = new Object[] {true, activeNet.getTypeName(), 0 };// 不等待
				} else {
					// 不可知的状态
					rtn = new Object[] { false, null, 10000 };// 等待10秒
				}
			} else {
				// 无网络信息，说明wifi和3G设备还未打开
				rtn = new Object[] { null, null, 10000 };// 等待10秒
			}
		} catch (IllegalArgumentException e) {
			Log.e("netManager" ,e.getMessage()) ;
			// 作为wifi和3G设备还未打开
			rtn = new Object[] { null, null, 10000 };// 等待10秒
		} finally {
			return rtn;
		}
	}

}
