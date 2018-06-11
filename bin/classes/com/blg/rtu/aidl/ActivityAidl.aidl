package com.blg.rtu.aidl ;  

import com.blg.rtu.aidl.RemoteParcel;

interface ActivityAidl{
	// 收到rtu命令结果数据,把其传Activity层
    void rtuCommandResult(in RemoteParcel parcel);
    // 收到rtu非协议(调试)数据
    void rtuNoPtotocolData(in RemoteParcel parcel) ;
	// 把rtu命令回传给Activity层以显示，以及更新命令发送状态
    void commandSendedCallBack(in RemoteParcel parcel);
 
    //后台服务启动自动查询命令
	void autoQueryCommand(String code);
    //后台服务启动自动设置命令
	void autoSetCommand(String code);

	// 收到rtu主动上报数据,把其传Activity层
    void rtuReportData(in RemoteParcel parcel);
	// 新RTU地址,把其传Activity层
    void newRtuId(String id);
    //网络连接上了,通知Activity层
    void netConnected() ;
    //网络连接断了,通知Activity层  
    void netDisconnect() ;
    //向界面通知自动查询状态
	void notifyAutoQueryStatus(String status);
    //向界面通知自动设置状态
	void notifyAutoSetStatus(String status);
     
}  