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

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd5D.Data_5D;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_05_010  extends FrmParent {
	
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
	private TextView item13 ;
	private TextView item14 ;
	private TextView item15 ;
	private TextView item16 ;
	private TextView item17 ;
	private TextView item18 ;

	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_5D ;
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
		View view = inflater.inflate(R.layout.f_func_05_010, container, false);

		title = (TextView)view.findViewById(R.id.f_05_010_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_05_010_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_05_010_Load) ;
		
		item01 = (TextView)view.findViewById(R.id.func_05_010_item01);
		item02 = (TextView)view.findViewById(R.id.func_05_010_item02);
		item03 = (TextView)view.findViewById(R.id.func_05_010_item03);
		item04 = (TextView)view.findViewById(R.id.func_05_010_item04);
		item05 = (TextView)view.findViewById(R.id.func_05_010_item05);
		item06 = (TextView)view.findViewById(R.id.func_05_010_item06);
		item07 = (TextView)view.findViewById(R.id.func_05_010_item07);
		item08 = (TextView)view.findViewById(R.id.func_05_010_item08);
		item09 = (TextView)view.findViewById(R.id.func_05_010_item09);
		item10 = (TextView)view.findViewById(R.id.func_05_010_item10);
		item11 = (TextView)view.findViewById(R.id.func_05_010_item11);
		item12 = (TextView)view.findViewById(R.id.func_05_010_item12);
		item13 = (TextView)view.findViewById(R.id.func_05_010_item13);
		item14 = (TextView)view.findViewById(R.id.func_05_010_item14);
		item15 = (TextView)view.findViewById(R.id.func_05_010_item15);
		item16 = (TextView)view.findViewById(R.id.func_05_010_item16);
		item17 = (TextView)view.findViewById(R.id.func_05_010_item17);
		item18 = (TextView)view.findViewById(R.id.func_05_010_item18);
		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_05_010_01) ;
		if(!str.equals(Constant.errorStr)){ item01.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_02) ;
		if(!str.equals(Constant.errorStr)){ item02.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_03) ;
		if(!str.equals(Constant.errorStr)){ item03.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_04) ;
		if(!str.equals(Constant.errorStr)){ item04.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_05) ;
		if(!str.equals(Constant.errorStr)){ item05.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_06) ;
		if(!str.equals(Constant.errorStr)){ item06.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_07) ;
		if(!str.equals(Constant.errorStr)){ item07.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_08) ;
		if(!str.equals(Constant.errorStr)){ item08.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_09) ;
		if(!str.equals(Constant.errorStr)){ item09.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_10) ;
		if(!str.equals(Constant.errorStr)){ item10.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_11) ;
		if(!str.equals(Constant.errorStr)){ item11.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_12) ;
		if(!str.equals(Constant.errorStr)){ item12.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_13) ;
		if(!str.equals(Constant.errorStr)){ item13.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_14) ;
		if(!str.equals(Constant.errorStr)){ item14.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_15) ;
		if(!str.equals(Constant.errorStr)){ item15.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_16) ;
		if(!str.equals(Constant.errorStr)){ item16.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_17) ;
		if(!str.equals(Constant.errorStr)){ item17.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_18) ;
		if(!str.equals(Constant.errorStr)){ item18.setText(str); }
		
		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_05_010_dt) ;
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
		this.sendRtuCommand(new CommandCreator().cd_5D(null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		Preferences p = Preferences.getInstance() ;
		Data_5D sd = (Data_5D)d.subData ;
		
		p.putString(Constant.func_vk_05_010_01, "" + sd.getERC1()) ;
		p.putString(Constant.func_vk_05_010_02, "" + sd.getERC2()) ;
		p.putString(Constant.func_vk_05_010_03, "" + sd.getERC3()) ;
		p.putString(Constant.func_vk_05_010_04, "" + sd.getERC4()) ;
		p.putString(Constant.func_vk_05_010_05, "" + sd.getERC5()) ;
		p.putString(Constant.func_vk_05_010_06, "" + sd.getERC6()) ;
		p.putString(Constant.func_vk_05_010_07, "" + sd.getERC7()) ;
		p.putString(Constant.func_vk_05_010_08, "" + sd.getERC8()) ;
		p.putString(Constant.func_vk_05_010_09, "" + sd.getERC9()) ;
		p.putString(Constant.func_vk_05_010_10, "" + sd.getERC10()) ;
		p.putString(Constant.func_vk_05_010_11, "" + sd.getERC11()) ;
		p.putString(Constant.func_vk_05_010_12, "" + sd.getERC12()) ;
		p.putString(Constant.func_vk_05_010_13, "" + sd.getERC13()) ;
		p.putString(Constant.func_vk_05_010_14, "" + sd.getERC14()) ;
		p.putString(Constant.func_vk_05_010_15, "" + sd.getERC15()) ;
		p.putString(Constant.func_vk_05_010_16, "" + sd.getERC16()) ;
		p.putString(Constant.func_vk_05_010_17, "" + sd.getERC17()) ;
		p.putString(Constant.func_vk_05_010_18, "" + sd.getERC18()) ;
		
		this.item01.setText("" + sd.getERC1()) ;
		this.item02.setText("" + sd.getERC2()) ;
		this.item03.setText("" + sd.getERC3()) ;
		this.item04.setText("" + sd.getERC4()) ;
		this.item05.setText("" + sd.getERC5()) ;
		this.item06.setText("" + sd.getERC6()) ;
		this.item07.setText("" + sd.getERC7()) ;
		this.item08.setText("" + sd.getERC8()) ;
		this.item09.setText("" + sd.getERC9()) ;
		this.item10.setText("" + sd.getERC10()) ;
		this.item11.setText("" + sd.getERC11()) ;
		this.item12.setText("" + sd.getERC12()) ;
		this.item13.setText("" + sd.getERC13()) ;
		this.item14.setText("" + sd.getERC14()) ;
		this.item15.setText("" + sd.getERC15()) ;
		this.item16.setText("" + sd.getERC16()) ;
		this.item17.setText("" + sd.getERC17()) ;
		this.item18.setText("" + sd.getERC18()) ;
		
		Preferences.getInstance().putString(Constant.func_vk_05_010_dt, this.resultDt.getText().toString()) ;
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