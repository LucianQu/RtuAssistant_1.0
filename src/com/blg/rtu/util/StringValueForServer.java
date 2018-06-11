package com.blg.rtu.util;

import android.content.Context;

import com.blg.rtu3.R;

public class StringValueForServer {
	
	public static boolean showCommandDataHex ; //下发命令数据十六进制是否显示于数据窗口中
	
//	public static int defaultPassword ;
	private static String defaultPasswordHex ;
	public static int protocolPackageHead ;
	public static int protocolPackageMaxLen ;
	public static int protocolPackageMinLen ;
	public static int protocolPackageHead_1_index ;
	public static int protocolPackageHead_2_index ;
	public static int protocolPackageLenStartIndex ;
	public static int protocolPackageLenEndIndex ;
	public static int protocolPackageLenNoInclud ;//不包含于通信协议数据长度中的数据的长度
	
	public static int protocolEnableClockSyn ;//是否进行时钟同步 1为是，0为否
	public static int protocolSynClockDeviate ;//时钟相差大于以下配置时时长(分钟)时，进行时钟同步
	
	public static String protocolBroastCommandRtuId ;//广播命令Rtu ID
	
	public static int commandInterval ;//下发命令时间间隔(毫秒)
	public static int commandSendMaxTimes ;//下发命令，无结果时重发，重发的最大次数
	public static long intervalStillAtOneRtu ;//间隔一段时间(毫秒)后，再次上线，认为是在同一个RTU上，不再发自动命令
	
	
	
	public static boolean noCommandTimeoutThenSendLinkCommand ; //无命令下发超时(见下noCommandIdle配置) 时，是否下发连接链中检测命令
	public static int noCommandIdle ;//无命令下发最大时长(毫秒)，否则RTU把wifi断电了

	
	public static void initOnlyOnce(Context ctx){
		showCommandDataHex = Boolean.valueOf(ctx.getResources().getString(R.string.showCommandDataHex)) ;
		
//		defaultPassword = Integer.valueOf(ctx.getResources().getString(R.string.defaultPassword));
		String defaultPasswordHex = ctx.getResources().getString(R.string.defaultPassword);
		setDefaultPasswordHex(defaultPasswordHex) ;
		protocolPackageHead = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageHead));
		protocolPackageMaxLen = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageMaxLen));
		protocolPackageMinLen = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageMinLen));
		protocolPackageHead_1_index = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageHead_1_index));
		protocolPackageHead_2_index = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageHead_2_index));
		protocolPackageLenStartIndex = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageLenStartIndex));
		protocolPackageLenEndIndex = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageLenEndIndex));
		protocolPackageLenNoInclud = Integer.valueOf(ctx.getResources().getString(R.string.protocolPackageLenNoInclud));
		protocolEnableClockSyn = Integer.valueOf(ctx.getResources().getString(R.string.protocolEnableClockSyn));
		protocolSynClockDeviate = Integer.valueOf(ctx.getResources().getString(R.string.protocolSynClockDeviate));
		protocolBroastCommandRtuId = ctx.getResources().getString(R.string.protocolBroastCommandRtuId) ;
		commandInterval = Integer.valueOf(ctx.getResources().getString(R.string.commandInterval));
		intervalStillAtOneRtu = Long.valueOf(ctx.getResources().getString(R.string.intervalStillAtOneRtu));
		commandSendMaxTimes = Integer.valueOf(ctx.getResources().getString(R.string.commandSendMaxTimes));
		if(commandSendMaxTimes < 0){
			commandSendMaxTimes = 0 ;
		}
		noCommandTimeoutThenSendLinkCommand = Boolean.valueOf(ctx.getResources().getString(R.string.noCommandTimeoutThenSendLinkCommand)) ;
		noCommandIdle = Integer.valueOf(ctx.getResources().getString(R.string.noCommandIdle));
	}
	
	public static String getDefaultPasswordHex() {
		return defaultPasswordHex;
	}
	
	public static void setDefaultPasswordHex(String defaultPasswordHex) {
		if(defaultPasswordHex != null){
			defaultPasswordHex = defaultPasswordHex.replaceAll(" ", "") ;
		}
		if(defaultPasswordHex == null || defaultPasswordHex.equals("")){
			defaultPasswordHex = com.blg.rtu.util.Constant.defaultPasswordHex ;
		}
		
		StringValueForServer.defaultPasswordHex = defaultPasswordHex;
	}


}
