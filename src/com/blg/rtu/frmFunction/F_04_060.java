package com.blg.rtu.frmFunction;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd20.Data_20;
import com.blg.rtu.protocol.p206.cd20.Param_20;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class F_04_060 extends FrmParent {
	
	private TextView title ;
	protected TextView paramNameSelect ;
	
	protected Spinner paramSelect;
	protected ArrayAdapter<SpinnerVO> spinnerAdapter;
	protected int spinnerPosition ;
	
	protected LinearLayout lineParamNow ;
	protected LinearLayout lineParam01,lineParam02,lineParam03,lineParam04,lineParam05,lineParam06,lineParam07,lineParam08,lineParam09,lineParam10,lineParam11,lineParam12,lineParam13 ;
	protected EditText param01_1, param01_2, param01_3,
	   param02_1, param02_2, param02_3,
	   param03_1, param03_2, param03_3,
	   param04_1, param04_2, param04_3,
	   param05_1, param05_2, param05_3,
	   param06_1, param06_2, param06_3,
	   param07_1, param07_2, param07_3,
	   param08_1, param08_2, param08_3,
	   param09_1, param09_2, param09_3,
	   param10_1, param10_2, param10_3,
	   param11_1, param11_2, param11_3,
	   param12_1, param12_2, param12_3,
	   param13_1, param13_2, param13_3 ;
	
	protected ImageView btnSet ;
	
	protected Resources rs  ;
	
	protected Param_20 param ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.rs = this.act.getResources() ;
		this.queryCommandCode = null ;
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
		View view = inflater.inflate(R.layout.f_func_04_060, container, false);

		title = (TextView)view.findViewById(R.id.f_04_060_Title) ;
		paramNameSelect = (TextView)view.findViewById(R.id.func_04_060_paramNameSelect) ;
				
		funcFrm = (FrameLayout)view.findViewById(R.id.f_04_060_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_04_060_Load) ;
		
		new F_04_060_HelpSpinner(this).findView(view) ;
		
		F_04_060_HelpCreateView hView = new F_04_060_HelpCreateView(this) ;
		hView.findView(view) ;
		hView.initValue();
		hView.setFilter() ;
		hView.setTextWatcher() ;
		
		lineParamNow = lineParam01 ;
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_04_060_dt) ;
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
		return new F_04_060_HelpCheckBeforeSet(this.act, this).checkBeforeSet(showDialog) ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		//此项目无查询命令
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		this.sendRtuCommand(new CommandCreator().cd_20(this.param, null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		Data_20 subD = (Data_20)d.getSubData() ;
		int type = subD.getDataType() ;
		if(type >= 0 && type <= 12){
			paramSelect.setSelection(type) ;
		}
		if(type == 0){//雨量，1字节压缩BCD码，取值范围为0.1～9.9mm
			param01_1.setText("" + subD.getDataCount_1to15());
			param01_2.setText("" + subD.getSaveInterval_1to255()) ;
			param01_3.setText("" + subD.getThreshold()) ;
		}else if(type == 1){//水位 ，4 字节压缩BCD，取值范围为-9999.999～+9999.999，单位为m
			param02_1.setText("" + subD.getDataCount_1to15());
			param02_2.setText("" + subD.getSaveInterval_1to255()) ;
			param02_3.setText("" + subD.getThreshold()) ;
		}else if(type == 2){//流量(水量)，5 字节压缩BCD，为-999999.999～+999999.999，单位为m3/s，m3/h（水资源）
			param03_1.setText("" + subD.getDataCount_1to15());
			param03_2.setText("" + subD.getSaveInterval_1to255()) ;
			param03_3.setText("" + subD.getThreshold()) ;
		}else if(type == 3){//流速，3 字节压缩BCD。取值范围为-99.999～+99.999，单位为m/s。
			param04_1.setText("" + subD.getDataCount_1to15());
			param04_2.setText("" + subD.getSaveInterval_1to255()) ;
			param04_3.setText("" + subD.getThreshold()) ;
		}else if(type == 4){//闸位，3 字节压缩BCD，取值范围为0～999.99，单位为m，
			param05_1.setText("" + subD.getDataCount_1to15());
			param05_2.setText("" + subD.getSaveInterval_1to255()) ;
			param05_3.setText("" + subD.getThreshold()) ;
		}else if(type == 5){//功率，3 个字节压缩BCD。取值范围为0～999999，单位为kw
			param06_1.setText("" + subD.getDataCount_1to15());
			param06_2.setText("" + subD.getSaveInterval_1to255()) ;
			param06_3.setText("" + subD.getThreshold().intValue()) ;
		}else if(type == 6){//气压，3 个字节压缩BCD。取值范围为0～99999，单位为10的平方pa(100pa)
			param07_1.setText("" + subD.getDataCount_1to15());
			param07_2.setText("" + subD.getSaveInterval_1to255()) ;
			param07_3.setText("" + subD.getThreshold().intValue()) ;
		}else if(type == 7){//风速(风向)，3 个字节压缩BCD。取值范围为0～999.99，单位为m/s。
			param08_1.setText("" + subD.getDataCount_1to15());
			param08_2.setText("" + subD.getSaveInterval_1to255()) ;
			param08_3.setText("" + subD.getThreshold()) ;
		}else if(type == 8){//水温，为2 个字节压缩BCD。取值范围为0～99.9，单位为℃
			param09_1.setText("" + subD.getDataCount_1to15());
			param09_2.setText("" + subD.getSaveInterval_1to255()) ;
			param09_3.setText("" + subD.getThreshold()) ;
		}else if(type == 9){//水质，5 字节压缩BCD，为-999999.999～+999999.999，
			param10_1.setText("" + subD.getDataCount_1to15());
			param10_2.setText("" + subD.getSaveInterval_1to255()) ;
			param10_3.setText("" + subD.getThreshold()) ;
		}else if(type == 10){//土壤含水率，2 个字节压缩BCD。取值范围为0～999.9，无单位
			param11_1.setText("" + subD.getDataCount_1to15());
			param11_2.setText("" + subD.getSaveInterval_1to255()) ;
			param11_3.setText("" + subD.getThreshold()) ;
		}else if(type == 11){//蒸发量，3 个字节压缩BCD。取值范围为0～9999.9，单位为mm。
			param12_1.setText("" + subD.getDataCount_1to15());
			param12_2.setText("" + subD.getSaveInterval_1to255()) ;
			param12_3.setText("" + subD.getThreshold()) ;
		}else if(type == 12){//水压，4 个字节的BCD，低位在前，高位在后，取值范围为0～999999.99，单位为kPa。
			param13_1.setText("" + subD.getDataCount_1to15());
			param13_2.setText("" + subD.getSaveInterval_1to255()) ;
			param13_3.setText("" + subD.getThreshold()) ;
		}
		
		
		Preferences.getInstance().putString(Constant.func_vk_04_060_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {/*
		vo.setV_04_060_select(spinnerPosition) ;
		vo.setV_04_060_param01_1(param01_1.getText().toString()) ;
		vo.setV_04_060_param01_2(param01_2.getText().toString()) ;
		vo.setV_04_060_param01_3(param01_3.getText().toString()) ;
		vo.setV_04_060_param02_1(param02_1.getText().toString()) ;
		vo.setV_04_060_param02_2(param02_2.getText().toString()) ;
		vo.setV_04_060_param02_3(param02_3.getText().toString()) ;
		vo.setV_04_060_param03_1(param03_1.getText().toString()) ;
		vo.setV_04_060_param03_2(param03_2.getText().toString()) ;
		vo.setV_04_060_param03_3(param03_3.getText().toString()) ;
		vo.setV_04_060_param04_1(param04_1.getText().toString()) ;
		vo.setV_04_060_param04_2(param04_2.getText().toString()) ; 
		vo.setV_04_060_param04_3(param04_3.getText().toString()) ;
		vo.setV_04_060_param05_1(param05_1.getText().toString()) ;
		vo.setV_04_060_param05_2(param05_2.getText().toString()) ; 
		vo.setV_04_060_param05_3(param05_3.getText().toString()) ;
		vo.setV_04_060_param06_1(param06_1.getText().toString()) ;
		vo.setV_04_060_param06_2(param06_2.getText().toString()) ; 
		vo.setV_04_060_param06_3(param06_3.getText().toString()) ;
		vo.setV_04_060_param07_1(param07_1.getText().toString()) ;
		vo.setV_04_060_param07_2(param07_2.getText().toString()) ; 
		vo.setV_04_060_param07_3(param07_3.getText().toString()) ;
		vo.setV_04_060_param08_1(param08_1.getText().toString()) ;
		vo.setV_04_060_param08_2(param08_2.getText().toString()) ; 
		vo.setV_04_060_param08_3(param08_3.getText().toString()) ;
		vo.setV_04_060_param09_1(param09_1.getText().toString()) ;
		vo.setV_04_060_param09_2(param09_2.getText().toString()) ; 
		vo.setV_04_060_param09_3(param09_3.getText().toString()) ;
		vo.setV_04_060_param10_1(param10_1.getText().toString()) ;
		vo.setV_04_060_param10_2(param10_2.getText().toString()) ; 
		vo.setV_04_060_param10_3(param10_3.getText().toString()) ;
		vo.setV_04_060_param11_1(param11_1.getText().toString()) ;
		vo.setV_04_060_param11_2(param11_2.getText().toString()) ; 
		vo.setV_04_060_param11_3(param11_3.getText().toString()) ;
		vo.setV_04_060_param12_1(param12_1.getText().toString()) ;
		vo.setV_04_060_param12_2(param12_2.getText().toString()) ; 
		vo.setV_04_060_param12_3(param12_3.getText().toString()) ;
		vo.setV_04_060_param13_1(param13_1.getText().toString()) ;
		vo.setV_04_060_param13_2(param13_2.getText().toString()) ; 
		vo.setV_04_060_param13_3(param13_3.getText().toString()) ;
	*/}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {/*
		paramSelect.setSelection(vo.getV_04_060_select()) ;
		param01_1.setText(vo.getV_04_060_param01_1()) ;
		param01_2.setText(vo.getV_04_060_param01_2()) ;
		param01_3.setText(vo.getV_04_060_param01_3()) ;
		param02_1.setText(vo.getV_04_060_param02_1()) ;
		param02_2.setText(vo.getV_04_060_param02_2()) ;
		param02_3.setText(vo.getV_04_060_param02_3()) ;
		param03_1.setText(vo.getV_04_060_param03_1()) ;
		param03_2.setText(vo.getV_04_060_param03_2()) ;
		param03_3.setText(vo.getV_04_060_param03_3()) ;
		param04_1.setText(vo.getV_04_060_param04_1()) ;
		param04_2.setText(vo.getV_04_060_param04_2()) ; 
		param04_3.setText(vo.getV_04_060_param04_3()) ;
		param05_1.setText(vo.getV_04_060_param05_1()) ;
		param05_2.setText(vo.getV_04_060_param05_2()) ; 
		param05_3.setText(vo.getV_04_060_param05_3()) ;
		param06_1.setText(vo.getV_04_060_param06_1()) ;
		param06_2.setText(vo.getV_04_060_param06_2()) ; 
		param06_3.setText(vo.getV_04_060_param06_3()) ;
		param07_1.setText(vo.getV_04_060_param07_1()) ;
		param07_2.setText(vo.getV_04_060_param07_2()) ; 
		param07_3.setText(vo.getV_04_060_param07_3()) ;
		param08_1.setText(vo.getV_04_060_param08_1()) ;
		param08_2.setText(vo.getV_04_060_param08_2()) ; 
		param08_3.setText(vo.getV_04_060_param08_3()) ;
		param09_1.setText(vo.getV_04_060_param09_1()) ;
		param09_2.setText(vo.getV_04_060_param09_2()) ; 
		param09_3.setText(vo.getV_04_060_param09_3()) ;
		param10_1.setText(vo.getV_04_060_param10_1()) ;
		param10_2.setText(vo.getV_04_060_param10_2()) ; 
		param10_3.setText(vo.getV_04_060_param10_3()) ;
		param11_1.setText(vo.getV_04_060_param11_1()) ;
		param11_2.setText(vo.getV_04_060_param11_2()) ; 
		param11_3.setText(vo.getV_04_060_param11_3()) ;
		param12_1.setText(vo.getV_04_060_param12_1()) ;
		param12_2.setText(vo.getV_04_060_param12_2()) ; 
		param12_3.setText(vo.getV_04_060_param12_3()) ;
		param13_1.setText(vo.getV_04_060_param13_1()) ;
		param13_2.setText(vo.getV_04_060_param13_2()) ; 
		param13_3.setText(vo.getV_04_060_param13_3()) ;
	*/}
	
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
