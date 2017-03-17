package com.blg.rtu.frmChannel.helpCh1;

import java.io.File;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.blg.rtu.frmChannel.ChFragment_01;
import com.blg.rtu.frmChannel.ChFragment_03;
import com.blg.rtu.help.HelpSaveSetDataToFile;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu.vo2xml.Help;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;
/**
 * frmChannel01响应外部操作类
 * @author Administrator
 *
 */
public class ChBusi_01_Operate {
	
	private ChFragment_01 chf ;
	
	public ChBusi_01_Operate(ChFragment_01 chf){
		this.chf = chf ;
	}
	
	
	public void registerListener(){
		/*chf.btnSm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chf.btnTcp.setChecked(false) ;
				chf.btnSm.setChecked(true) ;
				
				chf.phoneNumber.requestFocus();
			}
		});*/
		//
		/*chf.btnTcp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chf.btnTcp.setChecked(true) ;
				chf.btnSm.setChecked(false) ;
				
				chf.ip1.requestFocus() ;
			}
		});*/
		//请求连接按钮点击事件
		/*chf.tcpConnect.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				//act.getSoundAlert().playDing() ;
				chf.btnTcp.setChecked(true) ;
				chf.btnSm.setChecked(false) ;
				
				if(ChBusi_01_Operate.this.checkIpAndPort(true)){
					toConnectNet() ;
				}
			}
		}) ;*/
		
		
		
		//设置按钮点击事件
		chf.in.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				chf.paramProgress.setVisibility(View.VISIBLE);
				if(!HelpSaveSetDataToFile.isInFileExist(chf.act)){
					new DialogAlarm().showDialog(chf.act, chf.act.getResources().getString(R.string.txtAlarmNoSetDataFile) + 
							"\n" + "请确认导入路径是否有文件：" + "\n" + "路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath()) ;	
					chf.paramProgress.setVisibility(View.GONE) ;
				}else{
					new DialogConfirm().showDialog(chf.act,
							chf.act.getResources().getString(R.string.txtConfirmInSetData) + "\n" +
					"导入路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath(),
						new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){
									readInFile();
								}else{
									chf.paramProgress.setVisibility(View.GONE) ;
								}
							}
					}) ;
				}
			}
			private void readInFile(){
				try{
					File f = HelpSaveSetDataToFile.getInFile(chf.act) ;
					new Help().in(chf.act, f) ;
					chf.paramProgress.setVisibility(View.GONE) ;
					Toast.makeText(chf.act, "导入命令数据成功", Toast.LENGTH_SHORT).show() ;
				}catch(Exception e){
					chf.paramProgress.setVisibility(View.GONE) ;
					Toast.makeText(chf.act, "导入命令数据失败", Toast.LENGTH_SHORT).show() ;
					Log.e(ChFragment_03.class.getName(), "导入命令数据失败", e) ;
				}
			}
		}) ;
		
		//设置按钮点击事件
		chf.out.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					chf.paramProgress.setVisibility(View.VISIBLE) ;
					if(HelpSaveSetDataToFile.isInFileExist(chf.act)){
						new DialogConfirm().showDialog(chf.act,
								chf.act.getResources().getString(R.string.txtConfirmReplaceSetData) + "\n" + 
								"导出路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath(),
							new DialogConfirm.CallBackInterface(){
								@Override
								public void dialogCallBack(Object o) {
									if((Boolean)o){
										saveOutFile();
									}else{
										chf.paramProgress.setVisibility(View.GONE) ;
									}
								}
						}) ;			
					}else{
						new DialogConfirm().showDialog(chf.act,"是否导出配置" + "\n" +
								"导出路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath(),
							new DialogConfirm.CallBackInterface(){
								@Override
								public void dialogCallBack(Object o) {
									if((Boolean)o){
										saveOutFile();
									}else{
										chf.paramProgress.setVisibility(View.GONE) ;
									}
								}
						}) ;			
					
					}
				}
				private void saveOutFile(){
					try{
						String xml = new Help().out(chf.act) ;
						File f = HelpSaveSetDataToFile.getInFile(chf.act) ;
						HelpSaveSetDataToFile.saveData(f, xml) ;
						chf.paramProgress.setVisibility(View.GONE) ;
						Toast.makeText(chf.act, "导出命令数据成功", Toast.LENGTH_SHORT).show() ;
						//Toast.makeText(chf.act, "路径:" + f.getPath(), Toast.LENGTH_LONG).show() ;
					}catch(Exception e){
						chf.paramProgress.setVisibility(View.GONE) ;
						Toast.makeText(chf.act, "导出命令数据失败", Toast.LENGTH_SHORT).show() ;
						Log.e(ChFragment_03.class.getName(), "导出命令数据失败", e) ;
					}
				}
			}) ;
		
		
		/*chf.out.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(HelpSaveSetDataToFile.isFileExist(chf.act)){
					new DialogConfirm().showDialog(chf.act,
							chf.act.getResources().getString(R.string.txtConfirmReplaceSetData) ,
						new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){
									saveOutFile();
								}else{
								}
							}
					}) ;			
				}else{
					saveOutFile();
				}
			}
			private void saveOutFile(){
				try{
					String xml = new Help().out(chf.act) ;
					File f = HelpSaveSetDataToFile.getFile(chf.act) ;
					HelpSaveSetDataToFile.saveData(f, xml) ;
					Toast.makeText(chf.act, "导出命令数据成功", Toast.LENGTH_SHORT).show() ;
				}catch(Exception e){
					Toast.makeText(chf.act, "导出命令数据失败", Toast.LENGTH_SHORT).show() ;
					Log.e(ChFragment_03.class.getName(), "导出命令数据失败", e) ;
				}
			}
		}) ;
		chf.in.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(!HelpSaveSetDataToFile.isInFileExist(chf.act)){
					new DialogAlarm().showDialog(chf.act, chf.act.getResources().getString(R.string.txtAlarmNoSetDataFile)) ;			
				}else{
					new DialogConfirm().showDialog(chf.act,
							chf.act.getResources().getString(R.string.txtConfirmInSetData) ,
						new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){
									readInFile();
								}else{
								}
							}
					}) ;
				}
			}
			private void readInFile(){
				try{
					File f = HelpSaveSetDataToFile.getInFile(chf.act) ;
					new Help().in(chf.act, f) ;
					Toast.makeText(chf.act, "导入命令数据成功", Toast.LENGTH_SHORT).show() ;
				}catch(Exception e){
					Toast.makeText(chf.act, "导入命令数据失败", Toast.LENGTH_SHORT).show() ;
					Log.e(ChFragment_03.class.getName(), "导入命令数据失败", e) ;
				}
			}
		}) ;*/
		
	}
	/**
	 * 处理默认动作
	 */
	public void defaultOperate(){
		/*chf.btnTcp.setChecked(true) ;
		if(this.checkIpAndPort(false)){
			toConnectNet() ;
		}*/
		toConnectNet() ;
	}
	
	/**
	 * 连接网络
	 */
	public void toConnectNet(){
		/*chf.tcpConnect.setVisibility(View.GONE) ;
		chf.progressBar.setVisibility(View.VISIBLE) ;
		
		String url = chf.ip1.getText().toString().trim() + "." +
				chf.ip2.getText().toString().trim() + "." +
				chf.ip3.getText().toString().trim() + "." +
				chf.ip4.getText().toString().trim() ;
		int port = Integer.valueOf(chf.port.getText().toString()) ;*/
		//waitServerStartedAndToConnectNet("10.10.100.254", 8899) ; //水表地址
		waitServerStartedAndToConnectNet("192.168.4.1", 333) ; //中继器地址
	}
	
	/**
	 * 等待后台服务启动后，生成了代理对象，进行连接网络
	 * @param url
	 * @param port
	 */
	private void waitServerStartedAndToConnectNet(final String url, final int port){
		chf.act.mHandler.postDelayed(new Runnable(){
			public void run(){
				if(chf.act.mServerProxyHandler == null){
					//递归循环
					waitServerStartedAndToConnectNet(url, port) ;
				}else{
					doToConnectNet(url, port) ;
				}
			}
		}, 500) ;		
	}
	
	/**
	 * 后台服务已经启动，连接网络
	 * @param url
	 * @param port
	 */
	private void doToConnectNet(String url, int port){
		chf.act.mServerProxyHandler.startAndConnectTcpServer(url, port) ;
		chf.act.mHandler.postDelayed(new Runnable(){
			public void run(){
				//chf.tcpConnected
				if(!chf.act.mServerProxyHandler.isTcpConnected()){
				//if(!CoreThread.getInstance().getNetStatus()){
					//closeWaitTcpConnectFlash() ;
					//if(chf.getSelectedChannel() == Constant.channelTcp){
						Toast.makeText(chf.act, "网络未连接，请检查！", Toast.LENGTH_SHORT).show() ;
					//}
				}
			}
		}, StringValueForActivity.tcpConnectTimeout) ;
	}
	/**
	 * 当网络连接上时，关闭等待网络连接的刷新动画
	 */
	public void closeWaitTcpConnectFlash(){
		chf.tcpConnect.setVisibility(View.VISIBLE) ;
		chf.progressBar.setVisibility(View.GONE) ;
	}
	
	/**
	 * 检查IP与端口的正确性
	 * @param showDialog
	 * @return
	 */
	/*private boolean checkIpAndPort(boolean showDialog){
		boolean ok = true ;

		String strIp1 = chf.ip1.getText().toString().trim() ;
		String strIp2 = chf.ip2.getText().toString().trim() ;
		String strIp3 = chf.ip3.getText().toString().trim() ;
		String strIp4 = chf.ip4.getText().toString().trim() ;
		String strPort = chf.port.getText().toString().trim() ;
		if((strIp1 == null || strIp1.equals("")) ||
			(strIp2 == null || strIp2.equals("")) ||
			(strIp3 == null || strIp3.equals("")) ||
			(strIp4 == null || strIp4.equals("")) ||
			(strPort == null || strPort.equals(""))){
			if(showDialog){
				new DialogAlarm().showDialog(chf.act, "IP地址及端口必须填写！") ;
			}
			ok = false ;
		}else{
			int intIp1 = 0 ,intIp2 = 0 , intIp3 = 0 ,intIp4 = 0 , intPort = 0 ;
			try{
				intIp1 = Integer.valueOf(strIp1) ;
				intIp2 = Integer.valueOf(strIp2) ;
				intIp3 = Integer.valueOf(strIp3) ;
				intIp4 = Integer.valueOf(strIp4) ;
				intPort = Integer.valueOf(strPort) ;
			}catch(Exception e){
				ok = false ;
			}finally{
				if(ok){
					if((intIp1 < 0 || intIp1 > 255) ||
							(intIp2 < 0 || intIp2 > 255) ||	
							(intIp3 < 0 || intIp3 > 255) ||	
							(intIp4 < 0 || intIp4 > 255)){
						if(showDialog){
							new DialogAlarm().showDialog(chf.act, "IP地址必须是0到255数值！") ;
						}
						ok = false ;
					}
					if(ok){
						if(intPort < 0 || intPort > 65535){
							if(showDialog){
								new DialogAlarm().showDialog(chf.act, "端口必须是0到65535数值！") ;
							}
							ok = false ;
						}
						if(ok){
							Preferences p = Preferences.getInstance() ;
							p.putInt(Constant.ch_vk_ip1, intIp1) ;
							p.putInt(Constant.ch_vk_ip2, intIp2) ;
							p.putInt(Constant.ch_vk_ip3, intIp3) ;
							p.putInt(Constant.ch_vk_ip4, intIp4) ;
							p.putInt(Constant.ch_vk_port, intPort) ;
						}
					}
				}else{
					if(showDialog){
						new DialogAlarm().showDialog(chf.act, "IP地址及端口必须全数字！") ;
					}
				}
			}
		}
		return ok ;
	}*/
}
