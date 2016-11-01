package com.blg.rtu.frmFunction;


import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd11_51.Data_11_51;
import com.blg.rtu.protocol.p206.cd11_51.Param_11;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_01_020  extends FrmParent {
	
	private TextView title ;

	private TextView item01 ;
	private TextView item02_1 ;//开始年月日
	private TextView item02_2 ;//开始时分
	private TextView item03 ;

	private DatePickerDialog item02_1_dpd ;
	private TimePickerDialog item02_2_tpd ;
	
	private ImageView btnSet ;
	private ImageView btnAdjust ;
	private ImageView btnRead ;
	
	private Param_11 param ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_51 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
		
		param = new Param_11() ;
		
		final Calendar c = Calendar.getInstance();
		final int[] ymd = new int[]{c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)} ;
		item02_1_dpd = new DatePickerDialog(act, 
				new DatePickerDialog.OnDateSetListener(){
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					monthOfYear += 1 ;
					item02_1.setText(year + "-" + (monthOfYear < 10?("0" + monthOfYear):monthOfYear) + "-" + (dayOfMonth < 10?("0" + dayOfMonth):dayOfMonth)) ;
					param.setYear(year) ;
					param.setMonth(monthOfYear) ;
					param.setDay(dayOfMonth) ;
				}
			}, ymd[0], ymd[1], ymd[2]);
		
		final int[] hm = new int[]{c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE)} ;
		item02_2_tpd = new TimePickerDialog(act,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    	item02_2.setText("" + (hourOfDay < 10?("0" + hourOfDay):hourOfDay) + ":" + (minute < 10?("0" + minute):minute) + ":00") ;
                    	param.setHour(hourOfDay) ;
                    	param.setMinute(minute) ;
                    	param.setSecond(0) ;
                    }
            }, hm[0], hm[1], true) ;
		
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_01_020, container, false);

		title = (TextView)view.findViewById(R.id.f_01_020_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_020_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_020_Load) ;
		
		item01 = (TextView)view.findViewById(R.id.func_01_020_item01);
		

		
		item02_1 = (TextView)view.findViewById(R.id.f_01_020_item02_1) ;
		item02_2 = (TextView)view.findViewById(R.id.f_01_020_item02_2) ;
		
		item02_1.setText(DateTime.yyyy_MM_dd()) ;
		item02_1.setOnClickListener(new OnClickListener(){public void onClick(View v){
			item02_1_dpd.show();
			} 
		});
		item02_2.setText(DateTime.hh_mm() + ":00") ;
		item02_2.setOnClickListener(new OnClickListener(){public void onClick(View v){
			item02_2_tpd.show();
			} 
		});
		
		param.setYear(Integer.valueOf(DateTime.yyyy())) ;
		param.setMonth(Integer.valueOf(DateTime.MM())) ;
		param.setDay(Integer.valueOf(DateTime.dd())) ;
    	param.setHour(Integer.valueOf(DateTime.HH())) ;
    	param.setMinute(Integer.valueOf(DateTime.mm())) ;
    	param.setSecond(0) ;
		
		item03 = (TextView)view.findViewById(R.id.func_01_020_item03);
		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_020_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}

		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnAdjust = (ImageView)view.findViewById(R.id.btn_adjust);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnAdjust.setOnClickListener(btnAdjustLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_020_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		setClock() ;
		
		return view ;
	}
	//设置按钮点击事件
	protected Button.OnClickListener btnAdjustLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			if(checkBeforeSet(true)){
				new DialogConfirm().showDialog(act,
						act.getResources().getString(R.string.txtConfirmSendSetCommand) ,
						new DialogConfirm.CallBackInterface(){
						@Override
						public void dialogCallBack(Object o) {
							if((Boolean)o){ 
								showLoadCover() ;
								adjustCommand() ;
							}else{
							}
						}
				}) ;
			}
		}
	} ;
	
	private Runnable updateClock = new Runnable(){
		public void run(){
			item01.setText(DateTime.yyyy_MM_dd_HH_mm_ss()) ;
			setClock() ;
		}
	} ;
	
	private void setClock(){
		act.mHandler.postDelayed(updateClock, 1000) ;
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
		this.sendRtuCommand(new CommandCreator().cd_51(null), false) ;
	}
	
	/**
	 * 设置命令，发设置时间
	 */
	@Override
	protected void setCommand(){
		this.sendRtuCommand(new CommandCreator().cd_11(this.param, null), false) ;
	}
	
	/**
	 * 较时命令，发本地时钟
	 */
	protected void adjustCommand(){
		this.sendRtuCommand(new CommandCreator().cd_11(null, null), false) ;
	}
	/**
	 * 自动设置
	 */
	@Override
	public void autoSet(){
		if(checkBeforeSet(false)){
			adjustCommand() ;
		}else{
			commandHasProblem() ;
		}
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		String clock = ((Data_11_51)d.subData).getClock() ;
		item03.setText(clock) ;
		
		Preferences.getInstance().putString(Constant.func_vk_01_020_03, clock) ;
		Preferences.getInstance().putString(Constant.func_vk_01_020_dt, this.resultDt.getText().toString()) ;
	}
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
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