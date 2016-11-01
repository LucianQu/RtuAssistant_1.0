package com.blg.rtu.aidl ;  

import com.blg.rtu.aidl.ActivityAidl;
import com.blg.rtu.aidl.RemoteParcel;

interface ServiceAidl {
   
	/**
	 * 注册Activity的代理
	*/
    void registerActivityProxy(ActivityAidl proxy);
    
	/**
	 * 通过TCP网络通道发送RTU的命令
	*/
    void sendRtuCommandByTcp(in RemoteParcel parcel);
    
 	/**
	 * 所给功能码的命令不在发送
	*/
    void notSendCommandByCode(String code) ;
    
	/**
	 * 生成短信通道发送的RTU命令
	*/
    String createSmCommandBySm(in RemoteParcel parcel) ;
    
	/**
	 * 通过TCP网络通道发送非协议文本数据
	*/
    void sendRtuNoProtocolTxtDataByTcp(in RemoteParcel parcel);
    
	/**
	 * 通过TCP网络通道发送非协议十六进制数据
	*/
    void sendRtuNoProtocolHexDataByTcp(in RemoteParcel parcel);
    

	/**
	 * 处理短信形式的RTU 上行数据
	*/
    void dealSmData(String smData) ;

 	/**
	 * 设置无异常，返回true,否则返回false
	*/
    boolean startTcpConnect(String url, int port);
    
    /**
	 * 是否连接上了网络
	*/
    boolean isTcpConnected();
    
    /**
    * 得到server层所查询得来的rtu id
    */
    String getRtuId() ;
  	/**
	 * 来自界面操作自动查询任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	String operateAutoQuery(boolean start, boolean pause, boolean resume, boolean stop);
    
 	/**
	 * 来自界面操作自动设置任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	String operateAutoSet(boolean start, boolean pause, boolean resume, boolean stop);
    
    /**
    * 停止server，解除绑定Server可以系统杀死server，但是什么时杀就不定了
    */
    void stopServer() ;
    
}  
