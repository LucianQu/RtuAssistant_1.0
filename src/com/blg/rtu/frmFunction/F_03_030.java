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

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdE4_F4.Data_E4_F4;
import com.blg.rtu.protocol.p206.cdE4_F4.Param_F4;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_03_030  extends FrmParent {
	
	private final static int requestLen5 = 5 ; 
	private final static int requestLen6 = 6 ; 

	private TextView title ;

	private Spinner item01_1;
	private EditText item01_2 ;
//	private Spinner item02_1;
//	private EditText item02_2 ;
	private Spinner item03_1;
	private EditText item03_2 ;
	private Spinner item04_1;
	private EditText item04_2 ;
	private Spinner item05_1;
	private EditText item05_2 ;
	private Spinner item06_1;
	private EditText item06_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_1;
	private int spinnerPosition01_1 ;
//	private ArrayAdapter<SpinnerVO> spinnerAdapter02_1;
//	private int spinnerPosition02_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_1;
	private int spinnerPosition03_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04_1;
	private int spinnerPosition04_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter05_1;
	private int spinnerPosition05_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter06_1;
	private int spinnerPosition06_1 ;


	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_E4 ;
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
		View view = inflater.inflate(R.layout.f_func_03_030, container, false);

		title = (TextView)view.findViewById(R.id.f_03_030_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_03_030_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_03_030_Load) ;
		

		spinnerAdapter01_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter01_1);
		spinnerAdapter01_1.setDropDownViewResource(R.layout.spinner_item);
		
//		spinnerAdapter02_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
//		this.putSpinnerValue_1(spinnerAdapter02_1);
//		spinnerAdapter02_1.setDropDownViewResource(R.layout.spinner_item);
		
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
		

		item01_1 = (Spinner) view.findViewById(R.id.f_03_030_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs_1);

//		item02_1 = (Spinner) view.findViewById(R.id.f_03_030_item2_1);
//		item02_1.setAdapter(spinnerAdapter02_1);
//		item02_1.setOnItemSelectedListener(spinLs_1);

		item03_1 = (Spinner) view.findViewById(R.id.f_03_030_item3_1);
		item03_1.setAdapter(spinnerAdapter03_1);
		item03_1.setOnItemSelectedListener(spinLs_1);

		item04_1 = (Spinner) view.findViewById(R.id.f_03_030_item4_1);
		item04_1.setAdapter(spinnerAdapter04_1);
		item04_1.setOnItemSelectedListener(spinLs_1);

		item05_1 = (Spinner) view.findViewById(R.id.f_03_030_item5_1);
		item05_1.setAdapter(spinnerAdapter05_1);
		item05_1.setOnItemSelectedListener(spinLs_1);

		item06_1 = (Spinner) view.findViewById(R.id.f_03_030_item6_1);
		item06_1.setAdapter(spinnerAdapter06_1);
		item06_1.setOnItemSelectedListener(spinLs_1);


		int v = Preferences.getInstance().getInt(Constant.func_vk_03_030_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}

//		v = Preferences.getInstance().getInt(Constant.func_vk_03_030_02_1) ;
//		if(v != Constant.errorInt){item02_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_030_03_1) ;
		if(v != Constant.errorInt){item03_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_030_04_1) ;
		if(v != Constant.errorInt){item04_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_030_05_1) ;
		if(v != Constant.errorInt){item05_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_030_06_1) ;
		if(v != Constant.errorInt){item06_1.setSelection(v);}

		
		item01_2 = (EditText)view.findViewById(R.id.f_03_030_item1_2);
		item01_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen6)});
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_030_01_2));

//		item02_2 = (EditText)view.findViewById(R.id.f_03_030_item2_2);
//		item02_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
//		item02_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_030_02_2));

		item03_2 = (EditText)view.findViewById(R.id.f_03_030_item3_2);
		item03_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item03_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_030_03_2));

		item04_2 = (EditText)view.findViewById(R.id.f_03_030_item4_2);
		item04_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen6)});
		item04_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_030_04_2));

		item05_2 = (EditText)view.findViewById(R.id.f_03_030_item5_2);
		item05_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen6)});
		item05_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_030_05_2));

		item06_2 = (EditText)view.findViewById(R.id.f_03_030_item6_2);
		item06_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen6)});
		item06_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_030_06_2));

		
		String str = Preferences.getInstance().getString(Constant.func_vk_03_030_01_2) ;
		if(!str.equals(Constant.errorStr)){item01_2.setText(str);}

//		str = Preferences.getInstance().getString(Constant.func_vk_03_030_02_2) ;
//		if(!str.equals(Constant.errorStr)){item02_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_03_030_03_2) ;
		if(!str.equals(Constant.errorStr)){item03_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_03_030_04_2) ;
		if(!str.equals(Constant.errorStr)){item04_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_03_030_05_2) ;
		if(!str.equals(Constant.errorStr)){item05_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_03_030_06_2) ;
		if(!str.equals(Constant.errorStr)){item06_2.setText(str);}

		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_03_030_dt) ;
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
			if(parent == F_03_030.this.item01_1){
				spinnerPosition01_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_030_01_1, position) ;
			}
//			else if(parent == F_03_030.this.item02_1){
//				spinnerPosition02_1 = position ;
//				Preferences.getInstance().putInt(Constant.func_vk_03_030_02_1, position) ;
//			}
			else if(parent == F_03_030.this.item03_1){
				spinnerPosition03_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_030_03_1, position) ;
			}else if(parent == F_03_030.this.item04_1){
				spinnerPosition04_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_030_04_1, position) ;
			}else if(parent == F_03_030.this.item05_1){
				spinnerPosition05_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_030_05_1, position) ;
			}else if(parent == F_03_030.this.item06_1){
				spinnerPosition06_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_030_06_1, position) ;
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
		String e1 = spinnerAdapter01_1.getItem(spinnerPosition01_1).getId() ;
//		String e2 = spinnerAdapter02_1.getItem(spinnerPosition02_1).getId() ;
		String e3 = spinnerAdapter03_1.getItem(spinnerPosition03_1).getId() ;
		String e4 = spinnerAdapter04_1.getItem(spinnerPosition04_1).getId() ;
		String e5 = spinnerAdapter05_1.getItem(spinnerPosition05_1).getId() ;
		String e6 = spinnerAdapter06_1.getItem(spinnerPosition06_1).getId() ;
		
		String v1 = item01_2.getText().toString().trim() ;
//		String v2 = item02_2.getText().toString().trim() ;
		String v3 = item03_2.getText().toString().trim() ;
		String v4 = item04_2.getText().toString().trim() ;
		String v5 = item05_2.getText().toString().trim() ;
		String v6 = item06_2.getText().toString().trim() ;
		
		if(e1.equals("1") && v1.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的仪表，其量程必须填写！") ;
			}
			return false ;			
		}
//		if(e2.equals("1") && v2.equals("")){
//			if(showDialog){
//				new DialogAlarm().showDialog(act, "设置为有效的仪表量程必须填写！") ;
//			}
//			return false ;			
//		}
		if(e3.equals("1") && v3.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的仪表，其量程必须填写！") ;
			}
			return false ;			
		}
		if(e4.equals("1") && v4.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的仪表，其量程必须填写！") ;
			}
			return false ;			
		}
		if(e5.equals("1") && v5.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的仪表，其量程必须填写！") ;
			}
			return false ;			
		}
		if(e6.equals("1") && v6.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的仪表，其量程必须填写！") ;
			}
			return false ;			
		}
		
		if(e1.equals("1") && Float.valueOf(v1) > 655.35){
			if(showDialog){
				new DialogAlarm().showDialog(act, "水位量程超过最大(655.35)限值！") ;
			}
			return false ;	
		}
		
//		if(e2.equals("1") &&Integer.valueOf(v2) > 65535){
//			if(showDialog){
//				new DialogAlarm().showDialog(act, "水质量程超过最大(65535)限值！") ;
//			}
//			return false ;	
//		}
		if(e3.equals("1") && Float.valueOf(v3) > 100.0){
			if(showDialog){
				new DialogAlarm().showDialog(act, "水温量程超过最大(100)限值！") ;
			}
			return false ;	
		}
		
		if(e4.equals("1") && Float.valueOf(v4) > 6553.5){
			if(showDialog){
				new DialogAlarm().showDialog(act, "流量量程超过最大(6553.5)限值！") ;
			}
			return false ;	
		}
		if(e5.equals("1") && Float.valueOf(v5) > 6553.5){
			if(showDialog){
				new DialogAlarm().showDialog(act, "流量量程超过最大(6553.5)限值！") ;
			}
			return false ;	
		}
		if(e6.equals("1") && Float.valueOf(v6) > 6553.5){
			if(showDialog){
				new DialogAlarm().showDialog(act, "流量量程超过最大(6553.5)限值！") ;
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
		this.sendRtuCommand(new CommandCreator().cd_E4(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_F4 p = new Param_F4() ;
		
		String e1 = spinnerAdapter01_1.getItem(spinnerPosition01_1).getId() ;
//		String e2 = spinnerAdapter02_1.getItem(spinnerPosition02_1).getId() ;
		String e3 = spinnerAdapter03_1.getItem(spinnerPosition03_1).getId() ;
		String e4 = spinnerAdapter04_1.getItem(spinnerPosition04_1).getId() ;
		String e5 = spinnerAdapter05_1.getItem(spinnerPosition05_1).getId() ;
		String e6 = spinnerAdapter06_1.getItem(spinnerPosition06_1).getId() ;
		
		p.setEnable_level_0To1(Integer.valueOf(e1)) ;
//		p.setEnable_qaulity_0To1(Integer.valueOf(e2)) ;
		p.setEnable_temperature_0To1(Integer.valueOf(e3)) ;
		p.setEnable_amount1_0To1(Integer.valueOf(e4)) ;
		p.setEnable_amount2_0To1(Integer.valueOf(e5)) ;
		p.setEnable_amount3_0To1(Integer.valueOf(e6)) ;
		
		String v1 = item01_2.getText().toString().trim() ;
//		String v2 = item02_2.getText().toString().trim() ;
		String v3 = item03_2.getText().toString().trim() ;
		String v4 = item04_2.getText().toString().trim() ;
		String v5 = item05_2.getText().toString().trim() ;
		String v6 = item06_2.getText().toString().trim() ;
		
		v1 = v1.equals("")?"0.0":v1 ;
//		v2 = v2.equals("")?"0":v2 ;
		v3 = v3.equals("")?"0":v3 ;
		v4 = v4.equals("")?"0.0":v4 ;
		v5 = v5.equals("")?"0.0":v5 ;
		v6 = v6.equals("")?"0.0":v6 ;
		
		p.setMeter_level_0To655d35(Float.valueOf(v1)) ;//水位仪表量程
//		p.setMeter_qaulity_0To65535(Integer.valueOf(v2)) ;//水质仪表量程
		p.setMeter_temperature_0To655d35(Float.valueOf(v3)) ;//水温仪表量程
		p.setMeter_amount1_0To6553d5(Float.valueOf(v4)) ;//流量仪表量程
		p.setMeter_amount2_0To6553d5(Float.valueOf(v5)) ;//流量仪表量程
		p.setMeter_amount3_0To6553d5(Float.valueOf(v6)) ;//流量仪表量程

		this.sendRtuCommand(new CommandCreator().cd_F4(p, null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item003(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item003(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item003(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		
		Data_E4_F4 sd = (Data_E4_F4)d.subData ;

		item01_1.setSelection(sd.getEnable_level().intValue()) ;
		item01_2.setText("" + sd.getMeter_level());

//		item02_1.setSelection(sd.getEnable_qaulity().intValue()) ;
//		item02_2.setText("" + sd.getMeter_qaulity());

		item03_1.setSelection(sd.getEnable_temperature().intValue()) ;
		item03_2.setText("" + sd.getMeter_temperature());

		item04_1.setSelection(sd.getEnable_amount1().intValue()) ;
		item04_2.setText("" + sd.getMeter_amount1());

		item05_1.setSelection(sd.getEnable_amount2().intValue()) ;
		item05_2.setText("" + sd.getMeter_amount2());

		item06_1.setSelection(sd.getEnable_amount3().intValue()) ;
		item06_2.setText("" + sd.getMeter_amount3());

		
		Preferences.getInstance().putString(Constant.func_vk_03_030_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
	/*	vo.setV_03_030_item01_1(spinnerPosition01_1) ;
		vo.setV_03_030_item01_2(item01_2.getText().toString()) ;
		vo.setV_03_030_item03_1(spinnerPosition03_1) ;
		vo.setV_03_030_item03_2(item03_2.getText().toString()) ;
		vo.setV_03_030_item04_1(spinnerPosition04_1) ;
		vo.setV_03_030_item04_2(item04_2.getText().toString()) ;
		vo.setV_03_030_item05_1(spinnerPosition05_1) ;
		vo.setV_03_030_item05_2(item05_2.getText().toString()) ;
		vo.setV_03_030_item06_1(spinnerPosition06_1) ;
		vo.setV_03_030_item06_2(item06_2.getText().toString()) ;*/
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
	/*	item01_1.setSelection(vo.getV_03_030_item01_1()) ;
		item01_2.setText(vo.getV_03_030_item01_2()) ;
		item03_1.setSelection(vo.getV_03_030_item03_1()) ;
		item03_2.setText(vo.getV_03_030_item03_2()) ;
		item04_1.setSelection(vo.getV_03_030_item04_1()) ;
		item04_2.setText(vo.getV_03_030_item04_2()) ;
		item05_1.setSelection(vo.getV_03_030_item05_1()) ;
		item05_2.setText(vo.getV_03_030_item05_2()) ;
		item06_1.setSelection(vo.getV_03_030_item06_1()) ;
		item06_2.setText(vo.getV_03_030_item06_2()) ;*/
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