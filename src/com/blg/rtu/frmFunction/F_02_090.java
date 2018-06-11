package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdC8.Data_C8;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

public class F_02_090  extends FrmParent {
	
	private TextView title ;

	private TextView item01 ;
	private TextView item02 ;
	private TextView item03 ;
	private TextView item04 ;
	private TextView item05 ;
	private TextView item06 ;
	private TextView item07 ;
	private TextView item08 ;
	private TextView item09 ;
	private TextView item10 ;
	private TextView item11 ;
	private TextView item12 ;

	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_C8 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_02_090, container, false);

		title = (TextView)view.findViewById(R.id.f_02_090_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_02_090_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_02_090_Load) ;
		
		item01 = (TextView)view.findViewById(R.id.func_02_090_item01);
		item02 = (TextView)view.findViewById(R.id.func_02_090_item02);
		item03 = (TextView)view.findViewById(R.id.func_02_090_item03);
		item04 = (TextView)view.findViewById(R.id.func_02_090_item04);
		item05 = (TextView)view.findViewById(R.id.func_02_090_item05);
		item06 = (TextView)view.findViewById(R.id.func_02_090_item06);
		item07 = (TextView)view.findViewById(R.id.func_02_090_item07);
		item08 = (TextView)view.findViewById(R.id.func_02_090_item08);
		item09 = (TextView)view.findViewById(R.id.func_02_090_item09);
		item10 = (TextView)view.findViewById(R.id.func_02_090_item10);
		item11 = (TextView)view.findViewById(R.id.func_02_090_item11);
		item12 = (TextView)view.findViewById(R.id.func_02_090_item12);
		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_02_090_01) ;
		if(!str.equals(Constant.errorStr)){ item01.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_02) ;
		if(!str.equals(Constant.errorStr)){ item02.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_03) ;
		if(!str.equals(Constant.errorStr)){ item03.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_04) ;
		if(!str.equals(Constant.errorStr)){ item04.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_05) ;
		if(!str.equals(Constant.errorStr)){ item05.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_06) ;
		if(!str.equals(Constant.errorStr)){ item06.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_07) ;
		if(!str.equals(Constant.errorStr)){ item07.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_08) ;
		if(!str.equals(Constant.errorStr)){ item08.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_09) ;
		if(!str.equals(Constant.errorStr)){ item09.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_10) ;
		if(!str.equals(Constant.errorStr)){ item10.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_11) ;
		if(!str.equals(Constant.errorStr)){ item11.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_12) ;
		if(!str.equals(Constant.errorStr)){ item12.setText(str); }
		
		
		
		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_02_090_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	

	/**
	 * 查询命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeQuery(boolean showDialog){
		return true ;
	}
	
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeSet(boolean showDialog){
		return true ;
	}
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_C8(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item002(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item002(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
	}
	/**
	 * 功能项右侧图标复原
	 */
	@Override
	public void resetLabelImg(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item002(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		Data_C8 sd = (Data_C8)d.subData ;
		
		int n = sd.getNet1() ;
		if(n == 1){
			item01.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_01, "连接") ;
		}else{
			item01.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_01, "断开") ;
		}
		
		n = sd.getNet2() ;
		if(n == 1){
			item02.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_02, "连接") ;
		}else{
			item02.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_02, "断开") ;
		}
		
		n = sd.getNet3() ;
		if(n == 1){
			item03.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_03, "连接") ;
		}else{
			item03.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_03, "断开") ;
		}
		
		n = sd.getNet4() ;
		if(n == 1){
			item04.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_04, "连接") ;
		}else{
			item04.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_04, "断开") ;
		}
		
		item05.setText("" + sd.getDtuStrong()) ;
		Preferences.getInstance().putString(Constant.func_vk_02_090_05, "" + sd.getDtuStrong()) ;
		
		n = sd.getWifi() ;
		if(n == 1){
			item06.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_06, "连接") ;
		}else{
			item06.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_06, "断开") ;
		}
		
		item07.setText("" + sd.getWifiOpt()) ;
		Preferences.getInstance().putString(Constant.func_vk_02_090_07, "" + sd.getWifiOpt()) ;
		

		n = sd.getSate1() ;
		if(n == 1){
			item08.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_08, "连接") ;
		}else{
			item08.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_08, "断开") ;
		}
		
		n = sd.getSate2() ;
		if(n == 1){
			item09.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_09, "连接") ;
		}else{
			item09.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_09, "断开") ;
		}
		
		n = sd.getSate3() ;
		if(n == 1){
			item10.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_10, "连接") ;
		}else{
			item10.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_10, "断开") ;
		}
		
		n = sd.getSate4() ;
		if(n == 1){
			item11.setText("连接") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_11, "连接") ;
		}else{
			item11.setText("断开") ;
			Preferences.getInstance().putString(Constant.func_vk_02_090_11, "断开") ;
		}
		
		item12.setText("" + sd.getSateStrong()) ;
		Preferences.getInstance().putString(Constant.func_vk_02_090_12, "" + sd.getDtuStrong()) ;
		
		
		Preferences.getInstance().putString(Constant.func_vk_02_090_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
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
	
}