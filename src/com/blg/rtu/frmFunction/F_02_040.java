package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdCA_DA.Data_CA_DA;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class F_02_040  extends FrmParent {
	
	private final static int requestLen = 32 ; 

	private TextView title ;

	private EditText item01 ;
	private EditText item02 ;
	private EditText item03 ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_CA ;
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
		View view = inflater.inflate(R.layout.f_func_02_040, container, false);

		title = (TextView)view.findViewById(R.id.f_02_040_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_02_040_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_02_040_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.f_02_040_item01);
		item02 = (EditText)view.findViewById(R.id.f_02_040_item02);
		item03 = (EditText)view.findViewById(R.id.f_02_040_item03);
		
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen)});
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen)});
		item03.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_02_040_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_02_040_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_02_040_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_040_01));
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_040_02));
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_040_03));
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_02_040_dt) ;
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
		String name = item01.getText().toString() ;
		String user = item02.getText().toString() ;
		String password = item03.getText().toString() ;
		if(name == null || name.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "GPRS接入点名称不能为空！") ;
			}
			return false ;
		} 
		if(user == null || user.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "GPRS接入点用户名不能为空！") ;
			}
			return false ;
		} 
		if(password == null || password.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "GPRS接入点用户密码不能为空！") ;
			}
			return false ;
		} 
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_CA(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String name = item01.getText().toString() ;
		String user = item02.getText().toString() ;
		String password = item03.getText().toString() ;
		this.sendRtuCommand(new CommandCreator().cd_DA(name, user, password, null), false) ;
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item002(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item002(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item002(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		
		Data_CA_DA sd = (Data_CA_DA)d.subData ;
		item01.setText(sd.getName()) ;
		item02.setText(sd.getUser()) ;
		item03.setText(sd.getPassword()) ;
		
		Preferences.getInstance().putString(Constant.func_vk_02_040_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_02_040_item01(item01.getText().toString()) ;
		vo.setV_02_040_item02(item02.getText().toString()) ;
		vo.setV_02_040_item03(item03.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01.setText(vo.getV_02_040_item01()); 
		item02.setText(vo.getV_02_040_item02()); 
		item03.setText(vo.getV_02_040_item03()); 
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