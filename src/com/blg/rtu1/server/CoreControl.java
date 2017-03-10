package com.blg.rtu1.server;

import android.util.Log;

import com.blg.rtu.server.net.NetManager;
import com.blg.rtu.protocol.Action;
import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.Driver206;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.StringValueForServer;

public class CoreControl {
	
	private static String tag = CoreControl.class.getName() ;
	private static Long lastSendDataDT = 0L ;

	@SuppressWarnings("unused")
	private LocalServer mServer ;
	
	public CoreControl(LocalServer mServer){
		this.mServer = mServer ;
	}
	
	public void netConnected(){
		CoreThread.getInstance().netConnected() ;
		ActivityProxyHandler.getInstance().netConnected() ;
	}
	
	public void netDisconnect(){
		CoreThread.getInstance().netDisconnect() ;
		ActivityProxyHandler.getInstance().netDisconnect() ;
	}
	
	/**
	 * 通知已经发送了数据
	 */
	public void notifySendedData(){
		lastSendDataDT = System.currentTimeMillis() ;
	}
	/**
	 * 通知无数据等待
	 */
	public void notifyNoDataWaite(){
		if(StringValueForServer.noCommandTimeoutThenSendLinkCommand){
			if(System.currentTimeMillis() - lastSendDataDT > StringValueForServer.noCommandIdle){
				//发送链中测试命令，以保持网络连接，不叫RTU 断电
				String rtuId = CoreThread.getInstance().getRtuId() ;
				if(rtuId != null){
					this.sendRtuCommandByTcp(new CommandCreator().cd_02(rtuId), true, false) ;
				}
			}
		}
	}
	
	/**
	 * 分析RTU上行协议数据
	 * @param b
	 * @param channelType 通道类型
	 */
	public void receiveRtuProtocolData(byte[] b, Integer channelType){
		Driver206 driver = new Driver206() ;
		Action action = driver.analyseData(b) ;
		
		if(driver.getDataCode() != null){
			NetManager.getInstance().parsedReceiveData(driver.getDataCode()) ;
		}
		
		if(driver.getUpData() != null){
			driver.getUpData().setChannelType(channelType) ;
			
			if(action.contain(Action.commandReadRtuIdResultAction)){
				CoreThread.getInstance().rtuIdReceived(driver.getUpData().getRtuId());
			}
			
			if(action.contain(Action.commandResultAction)){
				ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
				if(obj != null){
					obj.rtuCommandResult(driver.getUpData()) ;
				}
			}
			
			if(action.contain(Action.autoReportAction)){
				ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
				if(obj != null){
					obj.rtuReportData(driver.getUpData()) ;
				}
			}
		}
		
		if(driver.getNewRtuId() != null){
			if(action.contain(Action.changeRtuIdAction)){
				CoreThread ctObj = CoreThread.getInstance() ;
				if(ctObj != null){
					ctObj.newRtuId(driver.getNewRtuId()) ;
				}
				ActivityProxyHandler ahObj = ActivityProxyHandler.getInstance();
				if(ahObj != null){
					ahObj.newRtuId(driver.getNewRtuId()) ;
				}
			}
		}
		
		if(action.contain(Action.synchronizeClock)){
			this.sendRtuCommandByTcp(new CommandCreator().cd_11(null, driver.getRtuId()), true,  false) ;
		}
		
		if(action.contain(Action.remoteConfirmAction)){
			byte[] data = driver.getDownData() ;
			if(data == null || data.length == 0){
				Log.e(tag, "分析上行数据后是确认动作，但下发字节数组为空！") ;
			}else{
				NetManager.getInstance().sendData(driver.getCommandCode(), data, driver.getRtuId(), true, false) ;
			}
		}
		if(action.contain(Action.remoteCommandAction)){
			byte[] data = driver.getDownData() ;
			if(data == null || data.length == 0){
				Log.e(tag, "分析上行数据后是远程下发命令动作，但下发字节数组为空！") ;
			}else{
				NetManager.getInstance().sendData(driver.getCommandCode(), data, driver.getRtuId(), false, false) ;
			}
		}
		
		if(action.contain(Action.noAction) || action.contain(Action.nullAction())){
			Log.e(tag, "分析上行数据后无动作！") ;
		}
		
		if(action.contain(Action.unknownAction)){
			Log.e(tag, "分析上行数据时产生不可识别的命令功能码！") ;
		}
		
		if(action.contain(Action.errorAction)){
			String error = driver.getError() ;
			Log.e(tag, "分析上行数据时出错:" + driver.getError()) ;
			if(error != null){
				error = "\n\n" + error + "\n\n" ;
				receiveRtuNoProtocolData(error.getBytes()) ;
			}
		}
	}
	/**
	 * 分析RTU上行非协议(调试)数据
	 * @param b
	 * @param channelType 通道类型
	 */
	public void receiveRtuNoProtocolData(byte[] b){
		ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
		if(obj != null){
			obj.rtuNoProtocolData(b) ;
		}
	}
	
	/**
	 *  发送远程命令
	 * @param command
	 * @param sendOnlyOnce 只发送一次
	 * @param showInActivity 在activity中回显
	 */
	public void sendRtuCommandByTcp(RtuCommand command, boolean sendOnlyOnce,  boolean showInActivity){
		Driver206 driver = new Driver206() ;
		Action action = driver.createCommand(command) ;
		if(action.contain(Action.remoteCommandAction)){
			byte[] data = driver.getDownData() ;
			if(data == null || data.length == 0){
				Log.e(tag, "构造命令时产生的下发字节数组为空！") ;
			}else{
				NetManager.getInstance().sendData(driver.getCommandCode(), data, driver.getRtuId(), sendOnlyOnce, showInActivity) ;
			}
		}
		if(action.contain(Action.remoteCommandSendOnlyOnceAction)){
			byte[] data = driver.getDownData() ;
			if(data == null || data.length == 0){
				Log.e(tag, "构造命令时产生的下发字节数组为空！") ;
			}else{
				NetManager.getInstance().sendData(driver.getCommandCode(), data, driver.getRtuId(), true, showInActivity) ;
			}
		}
		
		if(action.contain(Action.remoteConfirmAction)){
			Log.e(tag, "构造命令后的动作是远程确认，这是不正确的！") ;
		}
		
		if(action.contain(Action.noAction) || action.contain(Action.nullAction())){
			Log.e(tag, "构造命令后无动作！") ;
		}

		if(action.contain(Action.unknownAction)){
			Log.e(tag, "构造命令时产生不可识别的命令功能码！") ;
		}
		
		if(action.contain(Action.errorAction)){
			Log.e(tag, "构造命令时出错:" + driver.getError()) ;
		}
	}
	
	/**
	 * 所给功能码的命令不在发送
	*/
	public void notSendCommandByCode(String code) {
		NetManager.getInstance().notSendDataByCode(code) ;
	}

	
	/**
	 * 生成通过短信通道发送远程命令的字符串数据
	 * @param command
	 */
	public String createRtuCommandBySm(RtuCommand command, boolean showInActivity){
		String comStr = null ;
		Driver206 drv = new Driver206() ;
		Action action = drv.createCommand(command) ;
		if(action.contain(Action.remoteCommandAction)){
			byte[] data = drv.getDownData() ;
			if(showInActivity){
				this.commandSendedCallBack(data, command.getRtuId(), command.getCommandCode(), Constant.channelSm) ;
			}
			if(data == null || data.length == 0){
				Log.e(tag, "构造命令时产生的下发字节数组为空！") ;
			}else{
				comStr = ByteUtil.bytes2Hex(data, false) ;
			}
		}
		
		if(action.contain(Action.remoteConfirmAction)){
			Log.e(tag, "构造命令后的动作是远程确认，这是不正确的！") ;
		}
		
		if(action.contain(Action.noAction) || action.contain(Action.nullAction())){
			Log.e(tag, "构造命令后无动作！") ;
		}

		if(action.contain(Action.unknownAction)){
			Log.e(tag, "构造命令时产生不可识别的命令功能码！") ;
		}
		
		if(action.contain(Action.errorAction)){
			Log.e(tag, "构造命令时出错:" + drv.getError()) ;
		}
		return comStr ;
	}
	

	/**
	 * 通过TCP网络通道发送非协议文本数据
	 */
	public void sendRtuNoProtocolTxtDataByTcp(String str){
		NetManager.getInstance().sendNoProtocolTxtData(str) ;
	}
	
	/**
	 * 通过TCP网络通道发送非协议十六进制数据
	 */
	public void sendRtuNoProtocolHexDataByTcp(byte[] bs){
		NetManager.getInstance().sendNoProtocolHexData(bs) ;
	}
	
	/**
	 * 向界面通知自动查询状态
	 * @param status
	 * @return
	 */
	public void notifyAutoQueryStatus(String status){
		ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
		if(obj != null){
			obj.notifyAutoQueryStatus(status) ;
		}
	}
	
	/**
	 * 向界面通知自动设置状态
	 * @param status
	 * @return
	 */
	public void notifyAutoSetStatus(String status){
		ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
		if(obj != null){
			obj.notifyAutoSetStatus(status) ;
		}
	}

	
	
	/**
	 * 把命令数据传给activity回显
	 * @param commandData
	 */
	public void commandSendedCallBack(byte[] commandData, String rtuId, String commandCode, Integer channelType){
		if(StringValueForServer.showCommandDataHex){
			//设置可以回显
			RtuData data = new RtuData() ;
			data.channelType = channelType ;
			data.rtuId = rtuId ;
			data.dataCode = commandCode ;
			data.hex = ByteUtil.bytes2Hex(commandData, false) ;
			
			ActivityProxyHandler.getInstance().commandSendedCallBack(data) ;
		}
	}
}
