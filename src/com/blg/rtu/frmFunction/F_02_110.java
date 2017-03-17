package com.blg.rtu.frmFunction;


import java.util.ArrayList;

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

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdD2_D6.Data_D2_D6;
import com.blg.rtu.protocol.p206.cdD2_D6.Param_D6;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_02_110  extends FrmParent {
	

	private TextView title ;

	private Spinner item01;
	private Spinner item02;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02;
	private int spinnerPosition01 ;
	private int spinnerPosition02 ;

	private Spinner item03;
	private Spinner item04;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04;
	private int spinnerPosition03 ;
	private int spinnerPosition04 ;

	private Spinner item05;
	private ArrayAdapter<SpinnerVO> spinnerAdapter05;
	private int spinnerPosition05 ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_D2 ;
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
		View view = inflater.inflate(R.layout.f_func_02_110, container, false);

		title = (TextView)view.findViewById(R.id.f_02_110_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_02_110_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_02_110_Load) ;
		

		spinnerAdapter01 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter01);
		spinnerAdapter01.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_2(spinnerAdapter02);
		spinnerAdapter02.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter03 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_3(spinnerAdapter03);
		spinnerAdapter03.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter04 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_4(spinnerAdapter04);
		spinnerAdapter04.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter05 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_4(spinnerAdapter05);
		spinnerAdapter05.setDropDownViewResource(R.layout.spinner_item);
		

		item01 = (Spinner) view.findViewById(R.id.f_02_110_item1);
		item01.setAdapter(spinnerAdapter01);
		item01.setOnItemSelectedListener(spinLs);

		item02 = (Spinner) view.findViewById(R.id.f_02_110_item2);
		item02.setAdapter(spinnerAdapter02);
		item02.setOnItemSelectedListener(spinLs);
		

		item03 = (Spinner) view.findViewById(R.id.f_02_110_item3);
		item03.setAdapter(spinnerAdapter03);
		item03.setOnItemSelectedListener(spinLs);

		item04 = (Spinner) view.findViewById(R.id.f_02_110_item4);
		item04.setAdapter(spinnerAdapter04);
		item04.setOnItemSelectedListener(spinLs);


		item05 = (Spinner) view.findViewById(R.id.f_02_110_item5);
		item05.setAdapter(spinnerAdapter05);
		item05.setOnItemSelectedListener(spinLs);

		
		int v = Preferences.getInstance().getInt(Constant.func_vk_02_110_01) ;
		if(v != Constant.errorInt){item01.setSelection(v);}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_110_02) ;
		if(v != Constant.errorInt){item02.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_110_03) ;
		if(v != Constant.errorInt){item03.setSelection(v);}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_110_04) ;
		if(v != Constant.errorInt){item04.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_110_05) ;
		if(v != Constant.errorInt){item05.setSelection(v);}
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_02_110_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	private void putSpinnerValue_1(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "开启")) ;
		spinnerAdapter.add(new SpinnerVO("1", "关闭")) ;
	}
	
	private void putSpinnerValue_2(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "C1")) ;
		spinnerAdapter.add(new SpinnerVO("1", "C0")) ;
	}
	private void putSpinnerValue_3(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "正积")) ;
		spinnerAdapter.add(new SpinnerVO("1", "净积")) ;
	}
	
	private void putSpinnerValue_4(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "上报")) ;
		spinnerAdapter.add(new SpinnerVO("1", "不上报")) ;
	}
	
	
	OnItemSelectedListener spinLs = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_02_110.this.item01){
				spinnerPosition01 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_110_01, position) ;
			}else if(parent == F_02_110.this.item02){
				spinnerPosition02 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_110_02, position) ;
			}else if(parent == F_02_110.this.item03){
				spinnerPosition03 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_110_03, position) ;
			}else if(parent == F_02_110.this.item04){
				spinnerPosition04 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_110_04, position) ;
			}else if(parent == F_02_110.this.item05){
				spinnerPosition05 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_110_05, position) ;
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
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_D2(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_D6 p = new Param_D6() ;
		
		p.setEnable_1(Integer.valueOf(spinnerAdapter01.getItem(spinnerPosition01).getId())) ;
		p.setEnable_2(Integer.valueOf(spinnerAdapter02.getItem(spinnerPosition02).getId())) ;
		p.setEnable_3(Integer.valueOf(spinnerAdapter03.getItem(spinnerPosition03).getId())) ;
		p.setEnable_4(Integer.valueOf(spinnerAdapter04.getItem(spinnerPosition04).getId())) ;
		p.setEnable_5(Integer.valueOf(spinnerAdapter05.getItem(spinnerPosition05).getId())) ;
		
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_D6(p, null), false) ;
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
		
		Data_D2_D6 sd = (Data_D2_D6)d.subData ;

		item01.setSelection(sd.getEnable_D0().intValue()) ;
		item02.setSelection(sd.getReportPrtcl().intValue()) ;

		item03.setSelection(sd.getReportType().intValue()) ;
		item04.setSelection(sd.getEnable_AccumuTotal().intValue()) ;

		item05.setSelection(sd.getEnable_Instant().intValue()) ;
		
		Preferences.getInstance().putString(Constant.func_vk_02_110_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_02_110_item01(spinnerPosition01) ;
		
		vo.setV_02_110_item02(spinnerPosition02) ;
		vo.setV_02_110_item03(spinnerPosition03) ;

		vo.setV_02_110_item04(spinnerPosition04) ;
		vo.setV_02_110_item05(spinnerPosition05) ;
	}

	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01.setSelection(vo.getV_02_110_item01()) ;
		item02.setSelection(vo.getV_02_110_item02()) ;
		item03.setSelection(vo.getV_02_110_item03()) ;
		item04.setSelection(vo.getV_02_110_item04()) ;
		item05.setSelection(vo.getV_02_110_item05()) ;

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