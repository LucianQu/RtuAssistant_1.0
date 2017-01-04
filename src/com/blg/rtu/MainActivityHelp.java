package com.blg.rtu;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivityHelp {

	private MainActivity mainAct;
	@SuppressWarnings("unused")
	private View pageView_noProtocol;// Tab第0页
	@SuppressWarnings("unused")
	private View pageView_loopQuery;// Tab第1页
	private View pageView_function;// Tab第2页
	@SuppressWarnings("unused")
	private View pageView_channel;// Tab第3页
	
	private ImageView openMainAll ;
	private ImageView closeMainAll ;
	private ImageView openSubAll ;
	private ImageView closeSubAll ;
	private ImageView labelImgReset ;

	private LinearLayout funcTitle_01;// 功能菜单标题
	private LinearLayout func_01;// 功能菜单内容

	private LinearLayout funcTitle_02; 
	private LinearLayout func_02; 

/*	private LinearLayout funcTitle_03; 
	private LinearLayout func_03; 

	private LinearLayout funcTitle_04; 
	private LinearLayout func_04; */

	private LinearLayout funcTitle_05; 
	private LinearLayout func_05; 

/*	private LinearLayout funcTitle_06; 
	private LinearLayout func_06; 
*/
	private LinearLayout funcTitle_07;
	private LinearLayout func_07;
	public MainActivityHelp(MainActivity mainAct, View pageView_noProtocol, View pageView_loopQuery, View pageView_function) {
		this.mainAct = mainAct;
		this.pageView_noProtocol = pageView_noProtocol;
		this.pageView_loopQuery = pageView_loopQuery ;
		this.pageView_function = pageView_function;
		//this.pageView_channel = pageView_channel;
	}

	public void onCreateView() {
		openSubAll = (ImageView) pageView_function.findViewById(R.id.openSubAll) ;
		closeSubAll = (ImageView) pageView_function.findViewById(R.id.closeSubAll) ;
		openMainAll = (ImageView) pageView_function.findViewById(R.id.openMainAll2);
		closeMainAll = (ImageView) pageView_function.findViewById(R.id.closeMainAll2);
		
		labelImgReset = (ImageView) pageView_function.findViewById(R.id.labelImgReset);
		openSubAll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainAct.frgTool.openAllFunctionFragment() ;
			}
		});
		openMainAll.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				openFunc_0X(func_01) ;
				openFunc_0X(func_02) ;
				//openFunc_0X(func_03) ;
				//openFunc_0X(func_04) ;
				openFunc_0X(func_05) ;
				//openFunc_0X(func_06) ;
				openFunc_0X(func_07);
				}
		}) ;
		
		closeSubAll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainAct.frgTool.closeAllFunctionFragment() ;
			}
		});
		closeMainAll.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				closeFunc_0X(func_01) ;
				closeFunc_0X(func_02) ;
				//closeFunc_0X(func_03) ;
				//closeFunc_0X(func_04) ;
				closeFunc_0X(func_05) ;
				//closeFunc_0X(func_06) ;
				closeFunc_0X(func_07);
				
			}
		}) ;
		
		labelImgReset.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				mainAct.frgTool.resetLabelImgFunctionFragment() ;
				//return true;//return true时，点击(短按)事件将不响应
			}
		}) ;
		
		
		//////////////////////////
		
		funcTitle_01 = (LinearLayout) pageView_function.findViewById(R.id.f_01_title);
		func_01 = (LinearLayout) pageView_function.findViewById(R.id.f_func_01);

		funcTitle_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_01) ;
			}
		});
		
		funcTitle_02 = (LinearLayout) pageView_function.findViewById(R.id.f_02_title);
		func_02 = (LinearLayout) pageView_function.findViewById(R.id.f_func_02);

		funcTitle_02.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_02) ;
			}
		});
		
	/*	funcTitle_03 = (LinearLayout) pageView_function.findViewById(R.id.f_03_title);
		func_03 = (LinearLayout) pageView_function.findViewById(R.id.f_func_03);

		funcTitle_03.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_03) ;
			}
		});*/
		
	/*	funcTitle_04 = (LinearLayout) pageView_function.findViewById(R.id.f_04_title);
		func_04 = (LinearLayout) pageView_function.findViewById(R.id.f_func_04);

		funcTitle_04.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_04) ;
			}
		});*/
		
		funcTitle_05 = (LinearLayout) pageView_function.findViewById(R.id.f_05_title);
		func_05 = (LinearLayout) pageView_function.findViewById(R.id.f_func_05);

		funcTitle_05.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_05) ;
			}
		});
		
	/*	funcTitle_06 = (LinearLayout) pageView_function.findViewById(R.id.f_06_title);
		func_06 = (LinearLayout) pageView_function.findViewById(R.id.f_func_06);

		funcTitle_06.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_06) ;
			}
		});*/
		
		funcTitle_07 = (LinearLayout) pageView_function.findViewById(R.id.f_07_title);
		func_07 = (LinearLayout) pageView_function.findViewById(R.id.f_func_07);
		funcTitle_07.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openCloseFunc_0X(func_07) ;
			}
		});
		
		closeFunc_0X(func_01) ;
		closeFunc_0X(func_02) ;
		//closeFunc_0X(func_04) ;
		closeFunc_0X(func_05) ;
		closeFunc_0X(func_07);
		
		
	}
	
	private void openCloseFunc_0X(LinearLayout funcLinear){
		int vis = funcLinear.getVisibility();
		if (vis == View.VISIBLE) {
			funcLinear.setVisibility(View.GONE);
		} else {
			funcLinear.setVisibility(View.VISIBLE);
		}
	}
	
	private void openFunc_0X(LinearLayout funcLinear){
		funcLinear.setVisibility(View.VISIBLE);
	}
	
	private void closeFunc_0X(LinearLayout funcLinear){
		funcLinear.setVisibility(View.GONE);
	}

}
