package com.blg.rtu.util;

import android.content.Context;

import com.blg.rtu3.R;

public class StringValueForActivity {
	
	
	public static boolean confirmWhileReadCommand ;//当点击查询按钮是，是否显示确认对话窗口
	public static boolean queryWhenClickTitle ;//点开标题是否下发查询命令

	public static boolean queryAutoQueryComWhenClickTitle ;//自动下发命令的，点开标题时是否不再下发查询命令
	public static String autoQueryCom ;//软件启动时自动下发命令的功能码(用,号分隔)
	public static String canSendBySM ;//可由短信通道下发命令的功能码 (用,号分隔)
	public static String noQueryComWhenClickTitle ;//点击功能项题目不需要查询的命令(当然自动查询的功能码点开题目时也不查询)
	
	public static boolean noProtocolSendNeedConfirm ;//下发非协议数据时是否显示确认对话窗口

	public static boolean openWhenReceiveData ;//收到数据是否自动打开相关内容

	public static int tcpConnectTimeout ;//当人工点击按钮连接网络时，等待连接结果的超时时长，即动画时长，单位毫秒
	public static int commandResultTimout ;//等待命令结果的超时时长，即动画时长，单位毫秒
	
	public static int noProtocolTxtMaxLen ;//非协议(调试)数据显示的最大长度 
	public static int rutResultMaxCount ;//显示RTU结果数据最大条数
	public static int B1ResultMaxCount ;//固态数据显示最大条数
	public static int EDResultMaxCount ;//日志数据显示最大条数
	
	
	
	
	public static void initOnlyOnce(Context ctx){
		confirmWhileReadCommand = Boolean.valueOf(ctx.getResources().getString(R.string.confirmWhileReadCommand));
		queryWhenClickTitle = Boolean.valueOf(ctx.getResources().getString(R.string.queryWhenClickTitle));
		
		queryAutoQueryComWhenClickTitle = Boolean.valueOf(ctx.getResources().getString(R.string.queryAutoQueryComWhenClickTitle));
		autoQueryCom = ctx.getResources().getString(R.string.autoQueryCom) ;
		canSendBySM = ctx.getResources().getString(R.string.canSendBySM) ;
		noQueryComWhenClickTitle = ctx.getResources().getString(R.string.noQueryComWhenClickTitle) ;

		noProtocolSendNeedConfirm = Boolean.valueOf(ctx.getResources().getString(R.string.noProtocolSendNeedConfirm));

		openWhenReceiveData = Boolean.valueOf(ctx.getResources().getString(R.string.openWhenReceiveData));

		tcpConnectTimeout = Integer.valueOf(ctx.getResources().getString(R.string.tcpConnectTimeout));
		commandResultTimout = Integer.valueOf(ctx.getResources().getString(R.string.commandResultTimout));
		
		noProtocolTxtMaxLen = Integer.valueOf(ctx.getResources().getString(R.string.noProtocolTxtMaxLen));
		rutResultMaxCount = Integer.valueOf(ctx.getResources().getString(R.string.rutResultMaxCount));
		B1ResultMaxCount = Integer.valueOf(ctx.getResources().getString(R.string.B1ResultMaxCount));
		EDResultMaxCount = Integer.valueOf(ctx.getResources().getString(R.string.EDResultMaxCount));
	}
	
}
