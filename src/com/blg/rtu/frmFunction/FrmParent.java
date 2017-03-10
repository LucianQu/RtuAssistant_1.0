package com.blg.rtu.frmFunction;

import android.app.Fragment;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.ServerProxyHandler;
import com.blg.rtu1.sm.SmsSender;

public abstract class FrmParent extends Fragment {
	
	protected MainActivity act ;
	
	protected FrameLayout funcFrm ;//功能内容层
	protected LinearLayout cover ;//遮盖load层

	protected Boolean cntFrmOpened ;//已经打开隐藏遮盖层
	protected Boolean loading ;//正在等待网络通信结果
	
	protected String queryCommandCode ;//查询命令的功能码

	protected TextView resultDt ;
	
	
	//功能标题点击事件
	protected Button.OnClickListener titleClickLisn = new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			if(queryCommandCode == null){
				if(!cntFrmOpened){
					openFuncFrm() ;
				}else{
					closeFuncFrm() ;
				}
				return ;
				
			}
			boolean query = false ;
			if(queryCommandCode != null){
				if(StringValueForActivity.queryWhenClickTitle){
					query = true ;
					if(StringValueForActivity.noQueryComWhenClickTitle != null
							&& !StringValueForActivity.noQueryComWhenClickTitle.equals("")
							&& StringValueForActivity.noQueryComWhenClickTitle.contains(queryCommandCode)){
						query = false ;
					}
					if(query && StringValueForActivity.autoQueryCom != null 
						&& StringValueForActivity.autoQueryCom.contains(queryCommandCode)){
						//当前功能码是软件启动时自动下发的查询命令功能码
						if(!StringValueForActivity.queryAutoQueryComWhenClickTitle){
							query = false ;
						}
					}
				}
			}
				
			//Integer ch = act.frgTool.fragment_ch01.getSelectedChannel() ;
			Integer ch = Constant.channelTcp ;
			if(ch == Constant.channelTcp){
				if(!loading){
					if(!cntFrmOpened){
						openFuncFrm() ;
						if(query){
							showLoadCover() ;
							queryCommand() ;
						}
					}else{
						closeFuncFrm() ;
					}
				}
			}else{
				//用的是短信通道、或未连接上网
				if(!cntFrmOpened){
					openFuncFrm() ;
				}else{
					closeFuncFrm() ;
				}
			}
		}
	};
	
		
	//查询按钮点击事件
	protected Button.OnClickListener btnReadLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			if(checkBeforeQuery(true)){
				boolean needConfirm = false ;//查询前需不需要确认/confirm
				//Integer ch = act.frgTool.fragment_ch01.getSelectedChannel() ;
				Integer ch = Constant.channelTcp ;
				if(ch == Constant.channelSm){
					needConfirm = true ;
				}
				if(needConfirm || StringValueForActivity.confirmWhileReadCommand){
					new DialogConfirm().showDialog(act,
							act.getResources().getString(R.string.txtConfirmSendReadCommand) ,
							new DialogConfirm.CallBackInterface(){
								@Override
								public void dialogCallBack(Object o) {
									if((Boolean)o){
										showLoadCover() ;
										queryCommand() ;
									}else{
									}
								}
						}) ;
				}else{
					showLoadCover() ;
					queryCommand() ;
				}
			}else{
				//commandHasProblem() ;
			}
		}
	} ;
	
	//设置按钮点击事件
	protected Button.OnClickListener btnSetLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			if(checkBeforeSet(true)){
				new DialogConfirm().showDialog(act,
						act.getResources().getString(R.string.txtConfirmSendSetCommand) ,
						new DialogConfirm.CallBackInterface(){
						@Override
						public void dialogCallBack(Object o) {
							if((Boolean)o){ 
								showLoadCover() ;
								setCommand() ;
							}else{
							}
						}
				}) ;
			}else{
				//commandHasProblem() ;
			}
		}
	} ;
	
	/**
	 * 打开功能内容部分窗体
	 */
	public void openFuncFrm(){
		cntFrmOpened = true ;
		funcFrm.setVisibility(View.VISIBLE) ;
	}
	
	/**
	 * 打开功能内容部分窗体
	 */
	public void closeFuncFrm(){
		cntFrmOpened = false ;
		funcFrm.setVisibility(View.GONE) ;
	}
	
	/**
	 * 打开loading窗口
	 */
	protected void showLoadCover() {
		if (!loading) {
			loading = true;
			if(cover != null){
				cover.setVisibility(View.VISIBLE);
				act.mHandler.postDelayed(new Runnable() {
					public void run() {
						hideLoadCover() ;
					}
				}, StringValueForActivity.commandResultTimout);
			}
		}
	}
	
	/**
	 * 关闭loading窗口
	 */
	protected void hideLoadCover(){
		if(cover != null){
			cover.setVisibility(View.GONE) ;
		}
		loading = false ;
	}
	
	/**
	 * 查询命令前进行检查
	 * @param showDialog
	 * @return
	 */
	protected abstract boolean checkBeforeQuery(boolean showDialog) ;
	
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	protected abstract boolean checkBeforeSet(boolean showDialog) ;
	
	/**
	 * 查询命令
	 */
	protected abstract void queryCommand() ;
	
	/**
	 * 设置命令
	 */
	protected abstract void setCommand() ;
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	protected abstract void commandHasProblem() ;
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	protected abstract void commandSended() ;

	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	protected abstract void commandSendedCallBack() ;
	
	/**
	 * 功能项右侧图标复原
	 */
	public abstract void resetLabelImg() ;
		
	/**
	 * 发送RTU命令
	 * @param com 命令a
	 * @param isBroastCommand 是否为广播命令
	 */
	public void sendRtuCommand(RtuCommand com, boolean isBroastCommand){
		//int ch = act.frgTool.fragment_ch01.getSelectedChannel() ;
		int ch = Constant.channelTcp ;
		if(ch == Constant.channelTcp){
			//tcp网络通信
			if(act.mServerProxyHandler != null && act.mServerProxyHandler.isTcpConnected()){
				if(isBroastCommand){
					act.mServerProxyHandler.sendRtuCommandByTcp(com) ;
				}else{
					String rtuId = act.mServerProxyHandler.getRtuId() ;
					if(rtuId == null){
						hideLoadCover() ;
						Toast.makeText(act, "后台服务还未得到终端地址，当前不能发送命令！", Toast.LENGTH_SHORT).show() ;
					}else{
						com.setRtuId(rtuId) ;
						act.mServerProxyHandler.sendRtuCommandByTcp(com) ;
						this.commandSended() ;
					}
				}
			}else{
				hideLoadCover() ;
				Toast.makeText(act, "网络未连接，不能发送命令！", Toast.LENGTH_SHORT).show() ;
			}
		}else
		if(ch == Constant.channelSm){
			//短信通道
			String rtuId = act.mServerProxyHandler.getRtuId() ;
			if(rtuId == null){
				hideLoadCover() ;
				Toast.makeText(act, "当前未得到终端地址，请首先发送查询终端地址的命令！", Toast.LENGTH_SHORT).show() ;
			}else{
				if(!isBroastCommand){
					com.setRtuId(rtuId) ;
				}
				String phoneNum = act.frgTool.fragment_ch01.getPhoneNumber() ;
				if(phoneNum == null || phoneNum.trim().equals("") || phoneNum.trim().length() != 11){
					hideLoadCover() ;
					Toast.makeText(act, "出错，SIM卡号码不正确！", Toast.LENGTH_SHORT).show() ;
				}else{
					Long phoneLg = Long.valueOf(phoneNum) ;
					if(phoneLg < Constant.MinPhone){
						hideLoadCover() ;
						Toast.makeText(act, "出错，SIM卡号码不正确！", Toast.LENGTH_SHORT).show() ;
					}else{
						String sm = null ;
						try {
							sm = ServerProxyHandler.getInstance().createSmCommandBySm(com);
						} catch (RemoteException e) {
							sm = null ;
							e.printStackTrace();
						}finally{
							if(sm != null && !sm.equals("")){
								SmsSender.sendSMS(act, phoneNum, sm) ;
								this.commandSended() ;
								Toast.makeText(act, "命令以短信方式已经发送！", Toast.LENGTH_SHORT).show() ;
							}else{
								hideLoadCover() ;
								Toast.makeText(act, "出错，构造短信命令数据失败！", Toast.LENGTH_SHORT).show() ;
							}
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
		if(StringValueForActivity.openWhenReceiveData){
			this.openFuncFrm() ;
		}
		this.hideLoadCover() ;
		this.resultDt.setText(DateTime.dd_HH_mm_ss()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public abstract void outSetData(Vo2Xml vo) ;
	/**
	 * 导入设置数据
	 */
	public abstract void inSetData(Vo2Xml vo) ;
	
	
	/**
	 * 自动查询，针对需要设置查询条件的
	 */
	public void autoQuery(){
		if(checkBeforeQuery(false)){
			queryCommand() ;
		}else{
			commandHasProblem() ;
		}
	}
	
	/**
	 * 自动设置
	 */
	public void autoSet(){
		if(checkBeforeSet(false)){
			setCommand() ;
		}else{
			commandHasProblem() ;
		}
	}
	/**
	 * 不成功，屏幕未显示区域不能正确滚动到，不再应用
	 * 滚动到指定位置，
	 * @param d
	 */
	public void scrollTo(View v){
		int[] location = new int[2];  
		v.getLocationOnScreen(location);  
        int offset = location[1] - act.func_scrollView.getMeasuredHeight();  
        if (offset < 0) {  
            offset = 0;  
        }
        act.func_scrollView.scrollTo(0, offset);  
	}

}
