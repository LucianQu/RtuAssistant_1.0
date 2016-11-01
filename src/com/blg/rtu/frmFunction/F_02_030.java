package com.blg.rtu.frmFunction;

import java.util.ArrayList;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdCB_DB.Data_CB_DB;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class F_02_030 extends FrmParent {
	
	private TextView title ;
	
	private Spinner item01;
	private Spinner item02;
	private Spinner item03;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03;
	private int spinnerPosition01 ;
	private int spinnerPosition02 ;
	private int spinnerPosition03 ;
	
	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_CB ;
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
		View view = inflater.inflate(R.layout.f_func_02_030, container, false);

		title = (TextView)view.findViewById(R.id.f_02_030_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_02_030_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_02_030_Load) ;

		spinnerAdapter01 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue1();
		spinnerAdapter01.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue2and3(spinnerAdapter02);
		spinnerAdapter02.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter03 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue2and3(spinnerAdapter03);
		spinnerAdapter03.setDropDownViewResource(R.layout.spinner_item);

		item01 = (Spinner) view.findViewById(R.id.f_02_030_item1);
		item01.setAdapter(spinnerAdapter01);
		item01.setOnItemSelectedListener(spinLs);
		
		item02 = (Spinner) view.findViewById(R.id.f_02_030_item2);
		item02.setAdapter(spinnerAdapter02);
		item02.setOnItemSelectedListener(spinLs);
		
		item03 = (Spinner) view.findViewById(R.id.f_02_030_item3);
		item03.setAdapter(spinnerAdapter03);
		item03.setOnItemSelectedListener(spinLs);
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_02_030_01) ;
		if(v != Constant.errorInt){
			item01.setSelection(v); 
		}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_030_02) ;
		if(v != Constant.errorInt){
			item02.setSelection(v); 
		}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_030_03) ;
		if(v != Constant.errorInt){
			item03.setSelection(v); 
		}
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_02_030_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	private void putSpinnerValue1(){
		spinnerAdapter01.add(new SpinnerVO("0", "GPRS通道")) ;
		spinnerAdapter01.add(new SpinnerVO("1", "GSM通道")) ;
		spinnerAdapter01.add(new SpinnerVO("2", "卫星通道")) ;
	}
	
	private void putSpinnerValue2and3(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "无")) ;
		spinnerAdapter.add(new SpinnerVO("1", "GPRS通道")) ;
		spinnerAdapter.add(new SpinnerVO("2", "GSM通道")) ;
		spinnerAdapter.add(new SpinnerVO("3", "卫星通道")) ;
	}
	
	OnItemSelectedListener spinLs = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_02_030.this.item01){
				spinnerPosition01 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_030_01, position) ;
			}else if(parent == F_02_030.this.item02){
				spinnerPosition02 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_030_02, position) ;
			}else if(parent == F_02_030.this.item03){
				spinnerPosition03 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_030_03, position) ;
			}
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};	
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
		this.sendRtuCommand(new CommandCreator().cd_CB(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		this.sendRtuCommand(new CommandCreator().cd_DB(
			(Integer.valueOf(spinnerAdapter01.getItem(spinnerPosition01).getId()) + 1),
			Integer.valueOf(spinnerAdapter02.getItem(spinnerPosition02).getId()),
			Integer.valueOf(spinnerAdapter03.getItem(spinnerPosition03).getId()), null), false) ;
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
		
		Data_CB_DB sd = (Data_CB_DB)d.getSubData() ;
		item01.setSelection(sd.getChMain().intValue()-1); 
		item02.setSelection(sd.getChAssi1().intValue()); 
		item03.setSelection(sd.getChAssi2().intValue()); 

		Preferences.getInstance().putString(Constant.func_vk_02_030_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_02_030_item01(spinnerPosition01) ;
		vo.setV_02_030_item02(spinnerPosition02) ;
		vo.setV_02_030_item03(spinnerPosition03) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01.setSelection(vo.getV_02_030_item01()); 
		item02.setSelection(vo.getV_02_030_item02()); 
		item03.setSelection(vo.getV_02_030_item03()); 
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
