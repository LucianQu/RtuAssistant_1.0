package com.blg.rtu.frmChannel;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.frmChannel.helpCh1.ChBusi_01_Action;
import com.blg.rtu.frmChannel.helpCh1.ChBusi_01_Init;
import com.blg.rtu.frmChannel.helpCh1.ChBusi_01_Operate;
import com.blg.rtu.util.Constant;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ChFragment_01 extends Fragment {
	//public static final String TAG = ChFragment_01.class.getSimpleName() ;
	public MainActivity act ;
	
	public View view ;

	public RadioGroup btnGr ;
	public RadioButton btnSm ;
	public RadioButton btnTcp ;
	
	public EditText phoneNumber ;
	public EditText ip1 ;
	public EditText ip2 ;
	public EditText ip3 ;
	public EditText ip4 ;
	public EditText port ;
	
	public ProgressBar progressBar ;
	public ImageView tcpConnect ;
	
	public TextView tcpConnectStatus ;//tcp网络连接状态显示
	
	public Boolean tcpConnected ;//tcp网络已经连接上
	
	public ImageView out ;//导出
	public ImageView in ;//导入

	
	private ChBusi_01_Init busiInit ;//初化划
	private ChBusi_01_Action busiAction ;//内部行为
	private ChBusi_01_Operate busiOperate ;//外部人工操作
	
 	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.tcpConnected = false ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		busiInit = new ChBusi_01_Init(this) ;
		busiAction = new ChBusi_01_Action(this) ;
		busiOperate = new ChBusi_01_Operate(this) ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fch_01, container, false);
		
		busiInit.initView(act) ;

		busiOperate.registerListener() ;
		
		//this.defaultOperate() ;
		
		return view ;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void defaultOperate(){
		this.busiOperate.defaultOperate() ;
	}

	/**
	 * 通过划屏，移入本界面
	 */
	public void inThisPage(){
		this.busiAction.inThisPage() ;
	}
	
	/**
	 * 通过划屏，移出本界面
	 */
	public void outThisPage(){
		this.busiAction.outThisPage() ;
	}
	
	/**
	 * 得到输入的手机号
	 * @return
	 */
	public String getPhoneNumber(){
		return this.phoneNumber.getText().toString() ;
	}
	
	/**
	 * 得到所选择的通道
	 * @return
	 */
	public Integer getSelectedChannel(){
		int id = btnGr.getCheckedRadioButtonId() ;
		if(id == btnSm.getId()){
			return Constant.channelSm ;
		}else if(id == btnTcp.getId()){
			return Constant.channelTcp ;
		}
		return null ;
	}
	
	/**
	 * 设置网络连接状态
	 * @param isConnected
	 */
	public void setNetConnectedStatus(boolean isConnected) {
		this.tcpConnected = isConnected ;
		if(this.tcpConnected){
			//网络已经连接
			tcpConnectStatus.setText(act.getResources().getString(R.string.tcpStatus) + act.getResources().getString(R.string.connected)) ;
			busiOperate.closeWaitTcpConnectFlash() ;
		}else{
			//网络已经断开
			tcpConnectStatus.setText(act.getResources().getString(R.string.tcpStatus) + act.getResources().getString(R.string.disconnected)) ;
		}
	}
	
	/**
	 * 当网络连接上时，关闭等待网络连接的刷新动画
	 */
	public void closeWaitTcpConnectFlash(){
		busiOperate.closeWaitTcpConnectFlash() ;
	}


}
