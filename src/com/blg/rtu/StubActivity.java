package com.blg.rtu;

import android.os.RemoteException;
import android.util.Log;

import com.blg.rtu.aidl.ActivityAidl;
import com.blg.rtu.aidl.RemoteParcel;

import com.blg.rtu.protocol.RtuData ;
import com.blg.rtu.protocol.p206.Code206;

public class StubActivity extends ActivityAidl.Stub{
	
	private static String tag = StubActivity.class.getName() ;
	
	private static MainActivity mAct ;
	
	private static StubActivity instance ;
	
	private StubActivity(){
	}
	
	/**
	 * 创建单例，只有主Activity创建时，Activity才创建本单例
	 * @param server
	 * @return
	 */
	public static StubActivity createSingle(MainActivity mAct){
		/*
		 * 这样不行，当MainActivity重新启动，这个对象好象还有值，不死掉
		if(instance == null){
			instance = new StubActivity();
			.....
		}
		*/
		instance = new StubActivity() ;
		StubActivity.mAct = mAct ;
		return instance ;
	}
	
	/**
	 * 得到唯一实例，当主Activity未创建本单例时，此方法返回的实例为空
	 * @return
	 */
	public static StubActivity getInstance(){
		return instance ;
	}

	/**
	 * 网络连接上了
	 */
	@Override
	public void netConnected() {
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				mAct.setNetConnectedStatus(true) ;
			}
		});
	}

	/**
	 * 网络连接断了
	 */
	@Override
	public void netDisconnect() {
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				mAct.setNetConnectedStatus(false) ;
			}
		});
	}

	
	/**
	 * 在server端的Activity代理，通过回调的方式向根Activity端传来了命令结果数据
	 */
	@Override
	public void rtuCommandResult(RemoteParcel parcel) throws RemoteException {
		//Log(MessageFormat.format("rect[bottom={0},top={1},left={2},right={3},test1={4},test2={5}]", rect.bottom,rect.top,rect.left,rect.right,rect.data.test1, rect.data.test2));
		final RtuData data = parcel.packet.data ;
		Log.i(tag, data.toString()) ;
		Log.i("com.blg.rtu.StubActivity", "在server端的Activity代理，通过回调的方式向根Activity端传来了命令结果数据") ;
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				if(data.dataCode != null && !data.dataCode.equals("")){
					if(data.dataCode.equals(Code206.cd_10) || data.dataCode.equals(Code206.cd_50)){
						//设置或查询终端地址
						mAct.frgTool.f_01_010.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq02.receiveRtuData(Code206.cd_50,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_44) || data.dataCode.equals(Code206.cd_74)){
						//设置或查询终端地址
						mAct.frgTool.f_01_100.receiveRtuData(data) ;
						//mAct.frgTool.fragment_loopq02.receiveRtuData(Code206.cd_50,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_11) || data.dataCode.equals(Code206.cd_51)){
						//设置或查询遥测终端、中继站时钟返回
						mAct.frgTool.f_01_020.receiveRtuData(data) ;
					}/*else
					if(data.dataCode.equals(Code206.cd_12) || data.dataCode.equals(Code206.cd_52)){
						//设置或查询遥测终端工作模式
						mAct.frgTool.f_01_030.receiveRtuData(data) ;
					}*/else
					if(data.dataCode.equals(Code206.cd_EF) ){
						//查询遥测终端硬软件版本号
						mAct.frgTool.f_01_040.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq02.receiveRtuData(Code206.cd_EF,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_90) ){
						//复位遥测终端参数和状态
						mAct.frgTool.f_01_050.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_40) ){
						//设置净积
						mAct.frgTool.f_08_080.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_91) ){
						//清空遥测终端历史数据单元
						mAct.frgTool.f_01_060.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E0)){
						//查询供电方式及电压
						mAct.frgTool.f_01_070.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq03.receiveRtuData(Code206.cd_E0,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E1) || data.dataCode.equals(Code206.cd_F1)){
						//设置或查询电池池电压报警值
						mAct.frgTool.f_01_080.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_CF) || data.dataCode.equals(Code206.cd_DF)){
						//设置或查询DTU工作模式
						mAct.frgTool.f_02_010.receiveRtuData(data) ;
					}
					/*else
					if(data.dataCode.equals(Code206.cd_C9) || data.dataCode.equals(Code206.cd_D9)){
						//设置或查询终端心跳周期
						mAct.frgTool.f_02_020.receiveRtuData(data) ;
					}*//*else
					if(data.dataCode.equals(Code206.cd_CB) || data.dataCode.equals(Code206.cd_DB)){
						//设置或查询终端主备通道
						mAct.frgTool.f_02_030.receiveRtuData(data) ;
					}*/else
					if(data.dataCode.equals(Code206.cd_CA) || data.dataCode.equals(Code206.cd_DA)){
						//设置或查询GPRS接入点
						mAct.frgTool.f_02_040.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_D2) || data.dataCode.equals(Code206.cd_D6)){
						//设置或查询中心网址
						mAct.frgTool.f_02_110.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_CC) || data.dataCode.equals(Code206.cd_DC)){
						//设置或查询中心网址
						mAct.frgTool.f_02_050.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq04.receiveRtuData(Code206.cd_CC,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_73) || data.dataCode.equals(Code206.cd_43)){
						//设置或查询中心网址
						mAct.frgTool.f_08_040.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_75) || data.dataCode.equals(Code206.cd_45)){
						//设置或查询LCD显示内容及刷屏间隔
						mAct.frgTool.f_08_050.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_76) || data.dataCode.equals(Code206.cd_46)){
						//设置或查询正积流量
						mAct.frgTool.f_08_060.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_77) || data.dataCode.equals(Code206.cd_47)){
						//设置或查询负积流量
						mAct.frgTool.f_08_070.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_7A) || data.dataCode.equals(Code206.cd_4A)){
						//设置或查询RF频点
						mAct.frgTool.f_08_110.receiveRtuData(data) ;
					}
					/*else
					if(data.dataCode.equals(Code206.cd_CD) || data.dataCode.equals(Code206.cd_DD)){
						//设置或查询短信中心号码
						mAct.frgTool.f_02_060.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_CE) || data.dataCode.equals(Code206.cd_DE)){
						//设置或查询卫星中心号码
						mAct.frgTool.f_02_070.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_C8)){
						//查询RTU在线状态
						mAct.frgTool.f_02_090.receiveRtuData(data) ;
					}*/else
//					if(data.dataCode.equals(Code206.cd_E2) || data.dataCode.equals(Code206.cd_F2)){
//						//设置或查询电源采集校准系数
//						mAct.frgTool.f_03_010.receiveRtuData(data) ;
//					}else
			/*		if(data.dataCode.equals(Code206.cd_D8)){
						//设置AD校准命令(代替了F2命令)
						mAct.frgTool.f_03_011.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E3) || data.dataCode.equals(Code206.cd_F3)){
						//设置或查询仪表系数
						mAct.frgTool.f_03_020.receiveRtuData(data) ;
					}else*/
				/*	if(data.dataCode.equals(Code206.cd_E4) || data.dataCode.equals(Code206.cd_F4)){
						//设置或查询仪表量程
						mAct.frgTool.f_03_030.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E5) || data.dataCode.equals(Code206.cd_F5)){
						//设置或查询仪表采集修正值
						mAct.frgTool.f_03_040.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E6) || data.dataCode.equals(Code206.cd_F6)){
						//设置或查询仪表AD采集校准值
						mAct.frgTool.f_03_050.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E9) || data.dataCode.equals(Code206.cd_F9)){
						//设置或查询仪表上电读值延时时间
						mAct.frgTool.f_03_060.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_EA) || data.dataCode.equals(Code206.cd_FA)){
						//设置或查询井口高程，水井深度，探头埋深
						mAct.frgTool.f_03_070.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_E7) || data.dataCode.equals(Code206.cd_F7)){
						//设置或查询数据采集种类及时间间隔
						mAct.frgTool.f_03_080.receiveRtuData(data) ;
					}else*/
					if(data.dataCode.equals(Code206.cd_E8) || data.dataCode.equals(Code206.cd_F8)){
						//设置或查询上报起始时间
						mAct.frgTool.f_03_090.receiveRtuData(data) ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_EB) || data.dataCode.equals(Code206.cd_FB)){
						//设置或查询水位上报种类
						mAct.frgTool.f_04_010.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_57) || data.dataCode.equals(Code206.cd_17)){
						//57:查询遥测终端的水位基值、水位上下限及报警
						//17:设置遥测终端的水位基值、水位上下限
						mAct.frgTool.f_04_020.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_59) || data.dataCode.equals(Code206.cd_19)){
						//59:查询遥测终端水质参数种类、上限值
						//19:设置遥测终端水质参数种类、上限值
						mAct.frgTool.f_04_030.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_5A) || data.dataCode.equals(Code206.cd_1A)){
						//5A:查询遥测终端水质参数种类、下限值
						//1A:设置遥测终端水质参数种类、下限值
						mAct.frgTool.f_04_040.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_64) || data.dataCode.equals(Code206.cd_1F)){
						//64:查询遥测终端流量参数上限值
						//1f:设置遥测终端流量参数上限值
						mAct.frgTool.f_04_050.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_20)){
						//设置遥测终端检测参数启报阈值及固态存储时间段间隔
						mAct.frgTool.f_04_060.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_A0) || data.dataCode.equals(Code206.cd_54)){
						//54:查询遥测终端需查询的实时数据种类
						//A0:设置遥测站需查询的实时数据种类
						mAct.frgTool.f_04_070.receiveRtuData(data) ;
					}else*/
					if(data.dataCode.equals(Code206.cd_A1) || data.dataCode.equals(Code206.cd_53)){
						//53:查询遥测终端的数据自报种类及时间间隔
						//A1:设置遥测终端的数据自报种类及时间间隔
						mAct.frgTool.f_04_080.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq03.receiveRtuData(Code206.cd_53,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_5D)){
						//查询遥测终端的事件记录 
						mAct.frgTool.f_05_010.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq04.receiveRtuData(Code206.cd_5D,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_5E)){
						//查询遥测终端状态和报警状态
						mAct.frgTool.f_05_020.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq04.receiveRtuData(Code206.cd_5E,data) ;
					}else
			/*		if(data.dataCode.equals(Code206.cd_EC) || data.dataCode.equals(Code206.cd_FC)){
						//EC:查询日志配置表
						//FC:设置日志配置表
						mAct.frgTool.f_05_030.receiveRtuData(data) ;
					}else*/
					if(data.dataCode.equals(Code206.cd_B1)){
						//查询遥测终端固态存储数据 
						mAct.frgTool.f_05_040.receiveRtuData(data) ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_B0)){
						//查询遥测终端实时值 
						mAct.frgTool.f_05_050.receiveRtuData(data) ;
					}else*/
					if(data.dataCode.equals(Code206.cd_ED)){
						//查询日志信息
						mAct.frgTool.f_05_060.receiveRtuData(data) ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_82)){
						//人工置数 遥测终端应答
						mAct.frgTool.f_06_010.receiveRtuData(data) ;
					}else*/
					/*if(data.dataCode.equals(Code206.cd_C5) || data.dataCode.equals(Code206.cd_D5)){
						//设置或查询定时上报的时刻
						mAct.frgTool.f_04_090.receiveRtuData(data) ;
					}else*/
					if(data.dataCode.equals(Code206.cd_42) || data.dataCode.equals(Code206.cd_72)){
						//设置或查询ModBus地址
						mAct.frgTool.f_08_030.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_D3)){
						//查询水表出厂编号
						mAct.frgTool.f_01_090.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq02.receiveRtuData(Code206.cd_D3,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_D4)){
						//查询SIM卡ICCID
						mAct.frgTool.f_02_100.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq04.receiveRtuData(Code206.cd_D4,data) ;
					}else
					if(data.dataCode.equals(Code206.cd_96)){
						//修改遥测终端密码 
						mAct.frgTool.f_02_080.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_C2)){
						//查询水表实时值
						mAct.frgTool.f_05_070.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq03.receiveRtuData(Code206.cd_C2,data) ;
					}/*else
					if(data.dataCode.equals(Code206.cd_15) || data.dataCode.equals(Code206.cd_55)){
						//设置本次充值量或查询最近成功充值量和现有剩余水量
						mAct.frgTool.f_04_100.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_16) || data.dataCode.equals(Code206.cd_56)){
						//设置剩余水量报警值或查询遥测终端的剩余水量和报警值
						mAct.frgTool.f_04_110.receiveRtuData(data) ;
					}else
					if(data.dataCode.equals(Code206.cd_1B)){
						//设置终端站流量的表底（初始）值
						mAct.frgTool.f_04_120.receiveRtuData(data) ;
					}	
					
					////////////////////////////////////////////////////////
					//循环查询
					else
					if(data.dataCode.equals(Code206.cd_F0)){
						//循环查询关键参数
						mAct.frgTool.fragment_loopq01.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq02.receiveRtuData(data) ;
						mAct.frgTool.fragment_loopq03.receiveRtuData(data) ;
					}*/
				}
				//mAct.frgTool.fragment_ch04.setRtuData(data) ;
				mAct.getSoundAlert().playMessage() ;
			}
		});
	}

	/**
	 * 收到rtu非协议数据
	 */
	@Override
	public void rtuNoPtotocolData(RemoteParcel parcel) throws RemoteException {
		final byte[] bytes = parcel.packet.byteDatas ;
		//Log.i(tag, new String(bytes)) ;
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				mAct.frgTool.fragment_np01.receiveNoProtocolData(bytes) ;
			}
		});
	}

	/**
	 * 在server端的Activity代理，通过回调的方式向根Activity端 回传来了已经发送的命令数据
	 */
	@Override
	public void commandSendedCallBack(RemoteParcel parcel) throws RemoteException {
		final RtuData data = parcel.packet.data ;
		Log.i(tag, data.toString()) ;
		Log.i("com.blg.rtu.StubActivity", "在server端的Activity代理，通过回调的方式向根Activity端 回传来了已经发送的命令数据") ;
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				//mAct.frgTool.fragment_ch04.setSendBackCommandData(data) ;
				
				if(data.dataCode != null && !data.dataCode.equals("")){
					if(data.dataCode.equals(Code206.cd_10) || data.dataCode.equals(Code206.cd_50)){
						//设置或查询终端地址
						mAct.frgTool.f_01_010.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_44) || data.dataCode.equals(Code206.cd_74)){
						//设置或查询终端地址
						mAct.frgTool.f_01_100.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_11) || data.dataCode.equals(Code206.cd_51)){
						//设置或查询遥测终端、中继站时钟返回
						mAct.frgTool.f_01_020.commandSendedCallBack() ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_12) || data.dataCode.equals(Code206.cd_52)){
						//设置或查询遥测终端工作模式
						mAct.frgTool.f_01_030.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_EF) ){
						//查询遥测终端硬软件版本号
						mAct.frgTool.f_01_040.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_90) ){
						//复位遥测终端参数和状态
						mAct.frgTool.f_01_050.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_40) ){
						//设置净积
						mAct.frgTool.f_08_080.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_91) ){
						//清空遥测终端历史数据单元
						mAct.frgTool.f_01_060.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E0)){
						//查询供电方式及电压
						mAct.frgTool.f_01_070.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E1) || data.dataCode.equals(Code206.cd_F1)){
						//设置或查询电池池电压报警值
						mAct.frgTool.f_01_080.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_CF) || data.dataCode.equals(Code206.cd_DF)){
						//设置或查询DTU工作模式
						mAct.frgTool.f_02_010.commandSendedCallBack() ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_C9) || data.dataCode.equals(Code206.cd_D9)){
						//设置或查询终端心跳周期
						mAct.frgTool.f_02_020.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_CB) || data.dataCode.equals(Code206.cd_DB)){
						//设置或查询终端主备通道
						mAct.frgTool.f_02_030.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_CA) || data.dataCode.equals(Code206.cd_DA)){
						//设置或查询GPRS接入点
						mAct.frgTool.f_02_040.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_96)){
						//修改遥测终端密码 
						mAct.frgTool.f_02_080.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_D2) || data.dataCode.equals(Code206.cd_D6)){
						//设置或者查询协议配置
						mAct.frgTool.f_02_110.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_CC) || data.dataCode.equals(Code206.cd_DC)){
						//设置或查询中心网址
						mAct.frgTool.f_02_050.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_43) || data.dataCode.equals(Code206.cd_73)){
						//设置或查询中心网址
						mAct.frgTool.f_08_040.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_45) || data.dataCode.equals(Code206.cd_75)){
						//设置或查询LCD显示内容及刷屏间隔
						mAct.frgTool.f_08_050.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_46) || data.dataCode.equals(Code206.cd_76)){
						//设置或查询正积流量
						mAct.frgTool.f_08_060.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_47) || data.dataCode.equals(Code206.cd_77)){
						//设置或查询负积流量
						mAct.frgTool.f_08_070.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_4A) || data.dataCode.equals(Code206.cd_7A)){
						//设置或查询RF频点
						mAct.frgTool.f_08_110.commandSendedCallBack() ;
					}else
					/*if(data.dataCode.equals(Code206.cd_CD) || data.dataCode.equals(Code206.cd_DD)){
						//设置或查询短信中心号码
						mAct.frgTool.f_02_060.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_CE) || data.dataCode.equals(Code206.cd_DE)){
						//设置或查询卫星中心号码
						mAct.frgTool.f_02_070.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_C8)){
						//查询RTU在线状态
						mAct.frgTool.f_02_090.commandSendedCallBack() ;
					}else*/
//					if(data.dataCode.equals(Code206.cd_E2) || data.dataCode.equals(Code206.cd_F2)){
//						//设置或查询电源采集校准系数
//						mAct.frgTool.f_03_010.commandSendedCallBack() ;
//					}else
					/*if(data.dataCode.equals(Code206.cd_D8)){
						//设置AD校准命令(代替了F2命令)
						mAct.frgTool.f_03_011.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E3) || data.dataCode.equals(Code206.cd_F3)){
						//设置或查询仪表系数
						mAct.frgTool.f_03_020.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E4) || data.dataCode.equals(Code206.cd_F4)){
						//设置或查询仪表量程
						mAct.frgTool.f_03_030.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E5) || data.dataCode.equals(Code206.cd_F5)){
						//设置或查询仪表采集修正值
						mAct.frgTool.f_03_040.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E6) || data.dataCode.equals(Code206.cd_F6)){
						//设置或查询仪表AD采集校准值
						mAct.frgTool.f_03_050.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E9) || data.dataCode.equals(Code206.cd_F9)){
						//设置或查询仪表上电读值延时时间
						mAct.frgTool.f_03_060.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_EA) || data.dataCode.equals(Code206.cd_FA)){
						//设置或查询井口高程，水井深度，探头埋深
						mAct.frgTool.f_03_070.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_E7) || data.dataCode.equals(Code206.cd_F7)){
						//设置或查询数据采集种类及时间间隔
						mAct.frgTool.f_03_080.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_E8) || data.dataCode.equals(Code206.cd_F8)){
						//设置或查询上报起始时间
						mAct.frgTool.f_03_090.commandSendedCallBack() ;
					}else
					/*if(data.dataCode.equals(Code206.cd_EB) || data.dataCode.equals(Code206.cd_FB)){
						//设置或查询水位上报种类
						mAct.frgTool.f_04_010.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_57) || data.dataCode.equals(Code206.cd_17)){
						//57:查询遥测终端的水位基值、水位上下限及报警
						//17:设置遥测终端的水位基值、水位上下限
						mAct.frgTool.f_04_020.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_59) || data.dataCode.equals(Code206.cd_19)){
						//59:查询遥测终端水质参数种类、上限值
						//19:设置遥测终端水质参数种类、上限值
						mAct.frgTool.f_04_030.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_5A) || data.dataCode.equals(Code206.cd_1A)){
						//5A:查询遥测终端水质参数种类、下限值
						//1A:设置遥测终端水质参数种类、下限值
						mAct.frgTool.f_04_040.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_64) || data.dataCode.equals(Code206.cd_1F)){
						//64:查询遥测终端流量参数上限值
						//1f:设置遥测终端流量参数上限值
						mAct.frgTool.f_04_050.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_20)){
						//设置遥测终端检测参数启报阈值及固态存储时间段间隔
						mAct.frgTool.f_04_060.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_A0) || data.dataCode.equals(Code206.cd_54)){
						//54:查询遥测终端需查询的实时数据种类
						//A0:设置遥测站需查询的实时数据种类
						mAct.frgTool.f_04_070.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_A1) || data.dataCode.equals(Code206.cd_53)){
						//53:查询遥测终端的数据自报种类及时间间隔
						//A1:设置遥测终端的数据自报种类及时间间隔
						mAct.frgTool.f_04_080.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_5D)){
						//查询遥测终端的事件记录 
						mAct.frgTool.f_05_010.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_5E)){
						//查询遥测终端状态和报警状态
						mAct.frgTool.f_05_020.commandSendedCallBack() ;
					}else
					/*if(data.dataCode.equals(Code206.cd_EC) || data.dataCode.equals(Code206.cd_FC)){
						//EC:查询日志配置表
						//FC:设置日志配置表
						mAct.frgTool.f_05_030.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_B1)){
						//查询遥测终端固态存储数据 
						mAct.frgTool.f_05_040.commandSendedCallBack() ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_B0)){
						//查询遥测终端实时值 
						mAct.frgTool.f_05_050.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_ED)){
						//查询日志信息
						mAct.frgTool.f_05_060.commandSendedCallBack() ;
					}else
					/*if(data.dataCode.equals(Code206.cd_82)){
						//人工置数 遥测终端应答
						mAct.frgTool.f_06_010.commandSendedCallBack() ;
					}else*/
				/*	if(data.dataCode.equals(Code206.cd_C5) || data.dataCode.equals(Code206.cd_D5)){
						//设置或查询定时上报的时刻
						mAct.frgTool.f_04_090.commandSendedCallBack() ;
					}else*/
					if(data.dataCode.equals(Code206.cd_42) || data.dataCode.equals(Code206.cd_72)){
						//设置或查询定时上报的时刻
						mAct.frgTool.f_08_030.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_C2)){
						//查询流量实时值
						mAct.frgTool.f_05_070.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_D3)){
						//查询出厂编号
						mAct.frgTool.f_01_090.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_D4)){
						//查询出厂编号
						mAct.frgTool.f_02_100.commandSendedCallBack() ;
					}else
				/*	if(data.dataCode.equals(Code206.cd_15) || data.dataCode.equals(Code206.cd_55)){
						//设置遥测终端本次充值量,查询遥测终端最近成功充值量和现有剩余水量
						mAct.frgTool.f_04_100.commandSendedCallBack() ;
					}else
					if(data.dataCode.equals(Code206.cd_16) || data.dataCode.equals(Code206.cd_56)){
						//设置遥测终端剩余水量报警值,查询遥测终端的剩余水量和报警值
						mAct.frgTool.f_04_110.commandSendedCallBack() ;
					}else*/
				/*	if(data.dataCode.equals(Code206.cd_1B)){
						//设置终端站流量的表底（初始）值
						mAct.frgTool.f_04_120.commandSendedCallBack() ;
					}else*/
					
					
					////////////////////////////////////////////////////////
					//循环查询
					
					if(data.dataCode.equals(Code206.cd_F0)){
						//循环查询关键参数
						mAct.frgTool.fragment_loopq01.commandSendedCallBack() ;
					}
					
				}
			}
		});
	}
	   
	/**
	 * 后台服务启动自动查询命令
	 */
	@Override
	public void autoQueryCommand(final String code){
		if(code != null && !code.equals("")){
			mAct.mHandler.post(new Runnable(){
				@Override
				public void run() {
					if(code.equals(Code206.cd_B1)){
						//查询水表历史数据
						mAct.frgTool.f_05_040.autoQuery() ;
					}else
				/*	if(code.equals(Code206.cd_B0)){
						//查询遥测终端实时值 
						mAct.frgTool.f_05_050.autoQuery() ;
					}else*/
					if(code.equals(Code206.cd_ED)){
						//查询日志信息
						mAct.frgTool.f_05_060.autoQuery() ;
					}else{
						//未实现的
						Log.e(tag, "未实现的自动查询命令" + code) ;
					}
				}
			});
		}
	}
	
	/**
	 * 后台服务启动自动设置命令
	 */
	@Override
	public void autoSetCommand(final String code){
		if(code != null && !code.equals("")){
			mAct.mHandler.post(new Runnable(){
				@Override
				public void run() {
					if(code.equals(Code206.cd_10)){//设置遥测终端、中继站地址
						mAct.frgTool.f_01_010.autoSet() ;
					}else
					if(code.equals(Code206.cd_11)){//设置遥测终端、中继站时钟
						mAct.frgTool.f_01_020.autoSet() ;
					}else
				/*	if(code.equals(Code206.cd_12)){//设置遥测终端工作模式
						mAct.frgTool.f_01_030.autoSet() ;
					}else*/
					if(code.equals(Code206.cd_90)){//复位遥测终端参数和状态 
						mAct.frgTool.f_01_050.autoSet() ;
					}else
					if(code.equals(Code206.cd_91)){//清空遥测终端历史数据单元 
						mAct.frgTool.f_01_060.autoSet() ;
					}else
					if(code.equals(Code206.cd_F1)){//设置电池池电压报警值
						mAct.frgTool.f_01_080.autoSet() ;
					}else
					if(code.equals(Code206.cd_DF)){//设置DTU工作模式
						mAct.frgTool.f_02_010.autoSet() ;
					}else
					/*if(code.equals(Code206.cd_D9)){//设置终端心跳周期
						mAct.frgTool.f_02_020.autoSet() ;
					}else
					if(code.equals(Code206.cd_DB)){//设置终端主备通道
						mAct.frgTool.f_02_030.autoSet() ;
					}else*/
					if(code.equals(Code206.cd_DA)){//设置GPRS接入点
						mAct.frgTool.f_02_040.autoSet() ;
					}else
					if(code.equals(Code206.cd_DC)){//设置中心网址
						mAct.frgTool.f_02_050.autoSet() ;
					}else
					/*if(code.equals(Code206.cd_DD)){//设置短信中心号码
						mAct.frgTool.f_02_060.autoSet() ;
					}else
					if(code.equals(Code206.cd_DE)){//设置卫星中心号码
						mAct.frgTool.f_02_070.autoSet() ;
					}else
					if(code.equals(Code206.cd_D8)){//设置AD校准命令(代替了F2命令)
						mAct.frgTool.f_03_011.autoSet() ;
					}else
					if(code.equals(Code206.cd_F3)){//设置仪表类型
						mAct.frgTool.f_03_020.autoSet() ;
					}else
					if(code.equals(Code206.cd_F4)){//设置仪表量程
						mAct.frgTool.f_03_030.autoSet() ;
					}else
					if(code.equals(Code206.cd_F5)){//设置仪表采集修正值
						mAct.frgTool.f_03_040.autoSet() ;
					}else
					if(code.equals(Code206.cd_F6)){//设置仪表AD采集校准值
						mAct.frgTool.f_03_050.autoSet() ;
					}else
					if(code.equals(Code206.cd_F9)){//设置仪表上电读值延时时间
						mAct.frgTool.f_03_060.autoSet() ;
					}else
					if(code.equals(Code206.cd_FA)){//设置井口高程，水井深度，探头埋深
						mAct.frgTool.f_03_070.autoSet() ;
					}else
					if(code.equals(Code206.cd_F7)){//设置数据采集种类及时间间隔
						mAct.frgTool.f_03_080.autoSet() ;
					}else*/
					if(code.equals(Code206.cd_F8)){//设置上报起始时间
						mAct.frgTool.f_03_090.autoSet() ;
					}else
					if(code.equals(Code206.cd_D6)){//设置上报协议配置
						mAct.frgTool.f_02_110.autoSet() ;
					}else
					if(code.equals(Code206.cd_96)){//设置上报协议配置
						mAct.frgTool.f_02_080.autoSet() ;
					}else
					/*if(code.equals(Code206.cd_FB)){//设置水位上报种类
						mAct.frgTool.f_04_010.autoSet() ;
					}else
					if(code.equals(Code206.cd_17)){//设置遥测终端的水位基值、水位上下限
						mAct.frgTool.f_04_020.autoSet() ;
					}else
					if(code.equals(Code206.cd_19)){//设置遥测终端水质参数种类、上限值
						mAct.frgTool.f_04_030.autoSet() ;
					}else
					if(code.equals(Code206.cd_1A)){//设置遥测终端水质参数种类、下限值
						mAct.frgTool.f_04_040.autoSet() ;
					}else
					if(code.equals(Code206.cd_1F)){//设置遥测终端流量参数上限值
						mAct.frgTool.f_04_050.autoSet() ;
					}else
					if(code.equals(Code206.cd_20)){//设置遥测终端检测参数启报阈值及固态存储时间段间隔
						mAct.frgTool.f_04_060.autoSet() ;
					}else
					if(code.equals(Code206.cd_A0)){//设置遥测站需查询的实时数据种类 
						mAct.frgTool.f_04_070.autoSet() ;
					}else*/
					if(code.equals(Code206.cd_A1)){//设置遥测终端的数据自报种类及时间间隔
						mAct.frgTool.f_04_080.autoSet() ;
					}/*else
					if(code.equals(Code206.cd_D5)){//设置定时上报的时刻
						mAct.frgTool.f_04_090.autoSet() ;
					}else
					if(code.equals(Code206.cd_15)){//设置遥测终端本次充值量
						mAct.frgTool.f_04_100.autoSet() ;
					}else
					if(code.equals(Code206.cd_16)){//设置遥测终端剩余水量报警值
						mAct.frgTool.f_04_110.autoSet() ;
					}else
					if(code.equals(Code206.cd_1B)){//设置终端站流量的表底（初始）值
						mAct.frgTool.f_04_120.autoSet() ;
					}else
					if(code.equals(Code206.cd_FC)){//设置日志配置表
						mAct.frgTool.f_05_030.autoSet() ;
					}else
					if(code.equals(Code206.cd_82)){//人工置数 遥测终端  
						mAct.frgTool.f_06_010.autoSet() ;
					}*/
					else{
						//未实现的
						Log.e(tag, "未实现的自动设置命令" + code) ;
					}
				}
			});
		}
	}
	
	/**
	 * 在server端的Activity代理，通过回调的方式向根Activity端传来了主动上报数据
	 */
	@Override
	public void rtuReportData(RemoteParcel parcel) throws RemoteException {
		final RtuData data = parcel.packet.data ;
		Log.i(tag, data.toString()) ;
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				//mAct.frgTool.fragment_ch04.setRtuData(data) ;
			}
		});
	}

	/**
	 * 在server端的Activity代理，通过回调的方式向根Activity端传来了个改RTU ID命令成功后的新的RTU ID
	 */
	@Override
	public void newRtuId(String id) throws RemoteException {
		//当前，此处没有业务逻辑
	}
	
	/**
	 * 向界面通知自动查询状态
	 * @param status
	 * @return
	 */
	@Override
	public void notifyAutoQueryStatus(final String status){
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				//mAct.frgTool.fragment_ch02.setAutoQueryStatus(status) ;
			}
		});
		
	}
	/**
	 * 向界面通知自动设置状态
	 * @param status
	 * @return
	 */
	@Override
	public void notifyAutoSetStatus(final String status){
		mAct.mHandler.post(new Runnable(){
			@Override
			public void run() {
				//mAct.frgTool.fragment_ch03.setAutoSetStatus(status) ;
			}
		});
		
	}

}
