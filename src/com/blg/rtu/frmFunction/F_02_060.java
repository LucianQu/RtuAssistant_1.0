package com.blg.rtu.frmFunction;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdCD_DD.Data_CD_DD;
import com.blg.rtu.protocol.p206.cdCD_DD.Param_DD;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class F_02_060  extends FrmParent {
	
	private final static int requestLen32 = 32 ; 

	private TextView title ;

	private Spinner item01_1;
	private EditText item01_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_1;
	private int spinnerPosition01_1 ;

	private Spinner item02_1;
	private EditText item02_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02_1;
	private int spinnerPosition02_1 ;

	private Spinner item03_1;
	private EditText item03_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_1;
	private int spinnerPosition03_1 ;

	private Spinner item04_1;
	private EditText item04_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04_1;
	private int spinnerPosition04_1 ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_CD ;
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
		View view = inflater.inflate(R.layout.f_func_02_060, container, false);

		title = (TextView)view.findViewById(R.id.f_02_060_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_02_060_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_02_060_Load) ;
		

		spinnerAdapter01_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter01_1);
		spinnerAdapter01_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter02_1);
		spinnerAdapter02_1.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter03_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter03_1);
		spinnerAdapter03_1.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter04_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter04_1);
		spinnerAdapter04_1.setDropDownViewResource(R.layout.spinner_item);
		

		item01_1 = (Spinner) view.findViewById(R.id.f_02_060_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs_1);
		

		item02_1 = (Spinner) view.findViewById(R.id.f_02_060_item2_1);
		item02_1.setAdapter(spinnerAdapter02_1);
		item02_1.setOnItemSelectedListener(spinLs_1);


		item03_1 = (Spinner) view.findViewById(R.id.f_02_060_item3_1);
		item03_1.setAdapter(spinnerAdapter03_1);
		item03_1.setOnItemSelectedListener(spinLs_1);
		

		item04_1 = (Spinner) view.findViewById(R.id.f_02_060_item4_1);
		item04_1.setAdapter(spinnerAdapter04_1);
		item04_1.setOnItemSelectedListener(spinLs_1);
		
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_02_060_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_060_02_1) ;
		if(v != Constant.errorInt){item02_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_060_03_1) ;
		if(v != Constant.errorInt){item03_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_060_04_1) ;
		if(v != Constant.errorInt){item04_1.setSelection(v);}
		
		
		
		item01_2 = (EditText)view.findViewById(R.id.f_02_060_item1_2);
		item01_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen32)});
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_060_01_2));

		item02_2 = (EditText)view.findViewById(R.id.f_02_060_item2_2);
		item02_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen32)});
		item02_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_060_02_2));

		item03_2 = (EditText)view.findViewById(R.id.f_02_060_item3_2);
		item03_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen32)});
		item03_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_060_03_2));

		item04_2 = (EditText)view.findViewById(R.id.f_02_060_item4_2);
		item04_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen32)});
		item04_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_060_04_2));

		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_02_060_01_2) ;
		if(!str.equals(Constant.errorStr)){item01_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_02_060_02_2) ;
		if(!str.equals(Constant.errorStr)){item02_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_02_060_03_2) ;
		if(!str.equals(Constant.errorStr)){item03_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_02_060_04_2) ;
		if(!str.equals(Constant.errorStr)){item04_2.setText(str);}

		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_02_060_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	private void putSpinnerValue_1(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "无效")) ;
		spinnerAdapter.add(new SpinnerVO("1", "有效")) ;
	}
	OnItemSelectedListener spinLs_1 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_02_060.this.item01_1){
				spinnerPosition01_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_060_01_1, position) ;
			}else if(parent == F_02_060.this.item02_1){
				spinnerPosition02_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_060_02_1, position) ;
			}else if(parent == F_02_060.this.item03_1){
				spinnerPosition03_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_060_03_1, position) ;
			}else if(parent == F_02_060.this.item04_1){
				spinnerPosition04_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_060_04_1, position) ;
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
		this.sendRtuCommand(new CommandCreator().cd_CD(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_DD p = new Param_DD() ;
		
		p.setEnable_1(Integer.valueOf(spinnerAdapter01_1.getItem(spinnerPosition01_1).getId())) ;
		p.setEnable_2(Integer.valueOf(spinnerAdapter02_1.getItem(spinnerPosition02_1).getId())) ;
		p.setEnable_3(Integer.valueOf(spinnerAdapter03_1.getItem(spinnerPosition03_1).getId())) ;
		p.setEnable_4(Integer.valueOf(spinnerAdapter04_1.getItem(spinnerPosition04_1).getId())) ;
		
		String phone1 = item01_2.getText().toString().trim() ;
		String phone2 = item02_2.getText().toString().trim() ;
		String phone3 = item03_2.getText().toString().trim() ;
		String phone4 = item04_2.getText().toString().trim() ;
		
		p.setPhone1(phone1) ;
		p.setPhone2(phone2) ;
		p.setPhone3(phone3) ;
		p.setPhone4(phone4) ;

		
		this.sendRtuCommand(new CommandCreator().cd_DD(p, null), false) ;
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
//		super.scrollTo(this.btnRead) ;
		
		Data_CD_DD sd = (Data_CD_DD)d.subData ;

		item01_1.setSelection(sd.getEnable_1().intValue()) ;
		item01_2.setText("" + sd.getPhone1());

		item02_1.setSelection(sd.getEnable_2().intValue()) ;
		item02_2.setText("" + sd.getPhone2());

		item03_1.setSelection(sd.getEnable_3().intValue()) ;
		item03_2.setText("" + sd.getPhone3());

		item04_1.setSelection(sd.getEnable_4().intValue()) ;
		item04_2.setText("" + sd.getPhone4());

		
		Preferences.getInstance().putString(Constant.func_vk_02_060_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
	/*	vo.setV_02_060_item01_1(spinnerPosition01_1) ;
		vo.setV_02_060_item01_2(item01_2.getText().toString()) ;
		vo.setV_02_060_item02_1(spinnerPosition02_1) ;
		vo.setV_02_060_item02_2(item02_2.getText().toString()) ;
		vo.setV_02_060_item03_1(spinnerPosition03_1) ;
		vo.setV_02_060_item03_2(item03_2.getText().toString()) ;
		vo.setV_02_060_item04_1(spinnerPosition04_1) ;
		vo.setV_02_060_item04_2(item04_2.getText().toString()) ;*/
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
	/*	item01_1.setSelection(vo.getV_02_060_item01_1()) ;
		item01_2.setText(vo.getV_02_060_item01_2());
		item02_1.setSelection(vo.getV_02_060_item02_1()) ;
		item02_2.setText(vo.getV_02_060_item02_2());
		item03_1.setSelection(vo.getV_02_060_item03_1()) ;
		item03_2.setText(vo.getV_02_060_item03_2());
		item04_1.setSelection(vo.getV_02_060_item04_1()) ;
		item04_2.setText(vo.getV_02_060_item04_2());*/
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