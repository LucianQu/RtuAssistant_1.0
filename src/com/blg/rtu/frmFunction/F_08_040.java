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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd43_73.Data_43_73;
import com.blg.rtu.protocol.p206.cd43_73.Param_43;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;
import com.blg.rtu3.server.CoreThread;

public class F_08_040  extends FrmParent {
	
	private final static int requestLen3 = 3 ; 

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
	
	private Spinner item05_1;
	private EditText item05_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter05_1;
	private int spinnerPosition05_1 ;

	private Spinner item06_1;
	private EditText item06_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter06_1;
	private int spinnerPosition06_1 ;

	private Spinner item07_1;
	private EditText item07_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter07_1;
	private int spinnerPosition07_1 ;

	private Spinner item08_1;
	private EditText item08_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter08_1;
	private int spinnerPosition08_1 ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_73 ;
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
		View view = inflater.inflate(R.layout.f_func_08_040, container, false);

		title = (TextView)view.findViewById(R.id.f_08_040_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_040_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_040_Load) ;

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
		
		spinnerAdapter05_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter05_1);
		spinnerAdapter05_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter06_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter06_1);
		spinnerAdapter06_1.setDropDownViewResource(R.layout.spinner_item);

		spinnerAdapter07_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter07_1);
		spinnerAdapter07_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter08_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter08_1);
		spinnerAdapter08_1.setDropDownViewResource(R.layout.spinner_item);

		item01_1 = (Spinner) view.findViewById(R.id.f_08_040_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs_1);

		item02_1 = (Spinner) view.findViewById(R.id.f_08_040_item2_1);
		item02_1.setAdapter(spinnerAdapter02_1);
		item02_1.setOnItemSelectedListener(spinLs_1);

		item03_1 = (Spinner) view.findViewById(R.id.f_08_040_item3_1);
		item03_1.setAdapter(spinnerAdapter03_1);
		item03_1.setOnItemSelectedListener(spinLs_1);

		item04_1 = (Spinner) view.findViewById(R.id.f_08_040_item4_1);
		item04_1.setAdapter(spinnerAdapter04_1);
		item04_1.setOnItemSelectedListener(spinLs_1);
		
		item05_1 = (Spinner) view.findViewById(R.id.f_08_040_item5_1);
		item05_1.setAdapter(spinnerAdapter05_1);
		item05_1.setOnItemSelectedListener(spinLs_1);
		
		item06_1 = (Spinner) view.findViewById(R.id.f_08_040_item6_1);
		item06_1.setAdapter(spinnerAdapter06_1);
		item06_1.setOnItemSelectedListener(spinLs_1);

		item07_1 = (Spinner) view.findViewById(R.id.f_08_040_item7_1);
		item07_1.setAdapter(spinnerAdapter07_1);
		item07_1.setOnItemSelectedListener(spinLs_1);
		
		item08_1 = (Spinner) view.findViewById(R.id.f_08_040_item8_1);
		item08_1.setAdapter(spinnerAdapter08_1);
		item08_1.setOnItemSelectedListener(spinLs_1);
		
		int 
		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_02_1) ;
		if(v != Constant.errorInt){item02_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_03_1) ;
		if(v != Constant.errorInt){item03_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_04_1) ;
		if(v != Constant.errorInt){item04_1.setSelection(v);}
		
		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_05_1) ;
		if(v != Constant.errorInt){item05_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_06_1) ;
		if(v != Constant.errorInt){item06_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_07_1) ;
		if(v != Constant.errorInt){item07_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_08_040_08_1) ;
		if(v != Constant.errorInt){item08_1.setSelection(v);}
		
		
		
		item01_2 = (EditText)view.findViewById(R.id.f_08_040_item1_2);
		item01_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_01_2));

		item02_2 = (EditText)view.findViewById(R.id.f_08_040_item2_2);
		item02_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item02_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_02_2));

		item03_2 = (EditText)view.findViewById(R.id.f_08_040_item3_2);
		item03_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item03_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_03_2));

		item04_2 = (EditText)view.findViewById(R.id.f_08_040_item4_2);
		item04_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item04_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_04_2));

		item05_2 = (EditText)view.findViewById(R.id.f_08_040_item5_2);
		item05_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item05_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_05_2));

		item06_2 = (EditText)view.findViewById(R.id.f_08_040_item6_2);
		item06_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item06_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_06_2));

		item07_2 = (EditText)view.findViewById(R.id.f_08_040_item7_2);
		item07_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item07_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_07_2));

		item08_2 = (EditText)view.findViewById(R.id.f_08_040_item8_2);
		item08_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item08_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_040_08_2));
		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_040_01_2) ;
		if(!str.equals(Constant.errorStr)){item01_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_08_040_02_2) ;
		if(!str.equals(Constant.errorStr)){item02_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_08_040_03_2) ;
		if(!str.equals(Constant.errorStr)){item03_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_08_040_04_2) ;
		if(!str.equals(Constant.errorStr)){item04_2.setText(str);}
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_040_05_2) ;
		if(!str.equals(Constant.errorStr)){item05_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_08_040_06_2) ;
		if(!str.equals(Constant.errorStr)){item06_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_08_040_07_2) ;
		if(!str.equals(Constant.errorStr)){item07_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_08_040_08_2) ;
		if(!str.equals(Constant.errorStr)){item08_2.setText(str);}
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_040_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	private void putSpinnerValue_1(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "禁用")) ;
		spinnerAdapter.add(new SpinnerVO("1", "启用")) ;
	}
	OnItemSelectedListener spinLs_1 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_08_040.this.item01_1){
				spinnerPosition01_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_01_1, position) ;
			}else if(parent == F_08_040.this.item02_1){
				spinnerPosition02_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_02_1, position) ;
			}else if(parent == F_08_040.this.item03_1){
				spinnerPosition03_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_03_1, position) ;
			}else if(parent == F_08_040.this.item04_1){
				spinnerPosition04_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_04_1, position) ;
			}else if(parent == F_08_040.this.item05_1){
				spinnerPosition05_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_05_1, position) ;
			}else if(parent == F_08_040.this.item06_1){
				spinnerPosition06_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_06_1, position) ;
			}else if(parent == F_08_040.this.item07_1){
				spinnerPosition07_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_07_1, position) ;
			}else if(parent == F_08_040.this.item08_1){
				spinnerPosition08_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_08_040_08_1, position) ;
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
		this.sendRtuCommand(new CommandCreator().cd_73(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_43 p = new Param_43() ;
		
		p.setEnable_1(Integer.valueOf(spinnerAdapter01_1.getItem(spinnerPosition01_1).getId())) ;
		p.setEnable_2(Integer.valueOf(spinnerAdapter02_1.getItem(spinnerPosition02_1).getId())) ;
		p.setEnable_3(Integer.valueOf(spinnerAdapter03_1.getItem(spinnerPosition03_1).getId())) ;
		p.setEnable_4(Integer.valueOf(spinnerAdapter04_1.getItem(spinnerPosition04_1).getId())) ;
		p.setEnable_5(Integer.valueOf(spinnerAdapter05_1.getItem(spinnerPosition05_1).getId())) ;
		p.setEnable_6(Integer.valueOf(spinnerAdapter06_1.getItem(spinnerPosition06_1).getId())) ;
		p.setEnable_7(Integer.valueOf(spinnerAdapter07_1.getItem(spinnerPosition07_1).getId())) ;
		p.setEnable_8(Integer.valueOf(spinnerAdapter08_1.getItem(spinnerPosition08_1).getId())) ;
		if("".equals(item01_2.getText())) {
			p.setModBusAddr1(0) ;
		}else{
			p.setModBusAddr1(Integer.valueOf(item01_2.getText().toString().trim()));
		}
		/////
		if("".equals(item02_2.getText())) {
			p.setModBusAddr2(0) ;
		}else{
			p.setModBusAddr2(Integer.valueOf(item02_2.getText().toString().trim()));
		}
		/////
		if("".equals(item03_2.getText())) {
			p.setModBusAddr3(0) ;
		}else{
			p.setModBusAddr3(Integer.valueOf(item03_2.getText().toString().trim()));
		}
		////
		if("".equals(item04_2.getText())) {
			p.setModBusAddr4(0) ;
		}else{
			p.setModBusAddr4(Integer.valueOf(item04_2.getText().toString().trim()));
		}
		/////
		if("".equals(item05_2.getText())) {
			p.setModBusAddr5(0) ;
		}else{
			p.setModBusAddr5(Integer.valueOf(item05_2.getText().toString().trim()));
		}
		/////
		if("".equals(item06_2.getText())) {
			p.setModBusAddr6(0) ;
		}else{
			p.setModBusAddr6(Integer.valueOf(item06_2.getText().toString().trim()));
		}
		/////
		if("".equals(item07_2.getText())) {
			p.setModBusAddr7(0) ;
		}else{
			p.setModBusAddr7(Integer.valueOf(item07_2.getText().toString().trim()));
		}
		/////
		if("".equals(item08_2.getText())) {
			p.setModBusAddr8(0) ;
		}else{
			p.setModBusAddr8(Integer.valueOf(item08_2.getText().toString().trim()));
		}
		/////
		
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_43(p, null), false) ;
	}
	
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
	}
	/**
	 * 功能项右侧图标复原
	 */
	@Override
	public void resetLabelImg(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}

	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		
		Data_43_73 sd = (Data_43_73)d.subData ;

		item01_1.setSelection(sd.getEnable_1().intValue()) ;
		item01_2.setText("" + sd.getModBusAddr1());

		item02_1.setSelection(sd.getEnable_2().intValue()) ;
		item02_2.setText("" + sd.getModBusAddr2());

		item03_1.setSelection(sd.getEnable_3().intValue()) ;
		item03_2.setText("" + sd.getModBusAddr3());

		item04_1.setSelection(sd.getEnable_4().intValue()) ;
		item04_2.setText("" + sd.getModBusAddr4());
		
		item05_1.setSelection(sd.getEnable_5().intValue()) ;
		item05_2.setText("" + sd.getModBusAddr5());

		item06_1.setSelection(sd.getEnable_6().intValue()) ;
		item06_2.setText("" + sd.getModBusAddr6());

		item07_1.setSelection(sd.getEnable_7().intValue()) ;
		item07_2.setText("" + sd.getModBusAddr7());

		item08_1.setSelection(sd.getEnable_8().intValue()) ;
		item08_2.setText("" + sd.getModBusAddr8());
		
		Preferences.getInstance().putString(Constant.func_vk_08_040_dt, this.resultDt.getText().toString()) ;
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