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
import com.blg.rtu.protocol.p206.cdCC_DC.Data_CC_DC;
import com.blg.rtu.protocol.p206.cdCC_DC.Param_DC;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;
import com.blg.rtu2.server.CoreThread;

public class F_02_050  extends FrmParent {
	
	private final static int requestLen3 = 3 ; 
	private final static int requestLen5 = 5 ; 

	private TextView title ;

	private Spinner item01_1;
	private EditText item01_2_1;
	private EditText item01_2_2;
	private EditText item01_2_3;
	private EditText item01_2_4;
	private EditText item01_3;
	private Spinner item01_4;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_1;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_4;
	private int spinnerPosition01_1 ;
	private int spinnerPosition01_4 ;

	private Spinner item02_1;
	private EditText item02_2_1;
	private EditText item02_2_2;
	private EditText item02_2_3;
	private EditText item02_2_4;
	private EditText item02_3;
	private Spinner item02_4;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02_1;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02_4;
	private int spinnerPosition02_1 ;
	private int spinnerPosition02_4 ;

	private Spinner item03_1;
	private EditText item03_2_1;
	private EditText item03_2_2;
	private EditText item03_2_3;
	private EditText item03_2_4;
	private EditText item03_3;
	private Spinner item03_4;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_1;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_4;
	private int spinnerPosition03_1 ;
	private int spinnerPosition03_4 ;

	private Spinner item04_1;
	private EditText item04_2_1;
	private EditText item04_2_2;
	private EditText item04_2_3;
	private EditText item04_2_4;
	private EditText item04_3;
	private Spinner item04_4;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04_1;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04_4;
	private int spinnerPosition04_1 ;
	private int spinnerPosition04_4 ;
	
	
	

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_CC ;
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
		View view = inflater.inflate(R.layout.f_func_02_050, container, false);

		title = (TextView)view.findViewById(R.id.f_02_050_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_02_050_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_02_050_Load) ;
		

		spinnerAdapter01_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter01_1);
		spinnerAdapter01_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter01_4 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_4(spinnerAdapter01_4);
		spinnerAdapter01_4.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter02_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter02_1);
		spinnerAdapter02_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02_4 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_4(spinnerAdapter02_4);
		spinnerAdapter02_4.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter03_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter03_1);
		spinnerAdapter03_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter03_4 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_4(spinnerAdapter03_4);
		spinnerAdapter03_4.setDropDownViewResource(R.layout.spinner_item);
		

		spinnerAdapter04_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter04_1);
		spinnerAdapter04_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter04_4 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_4(spinnerAdapter04_4);
		spinnerAdapter04_4.setDropDownViewResource(R.layout.spinner_item);
		

		item01_1 = (Spinner) view.findViewById(R.id.f_02_050_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs);

		item01_4 = (Spinner) view.findViewById(R.id.f_02_050_item1_4);
		item01_4.setAdapter(spinnerAdapter01_4);
		item01_4.setOnItemSelectedListener(spinLs);
		

		item02_1 = (Spinner) view.findViewById(R.id.f_02_050_item2_1);
		item02_1.setAdapter(spinnerAdapter02_1);
		item02_1.setOnItemSelectedListener(spinLs);

		item02_4 = (Spinner) view.findViewById(R.id.f_02_050_item2_4);
		item02_4.setAdapter(spinnerAdapter02_4);
		item02_4.setOnItemSelectedListener(spinLs);


		item03_1 = (Spinner) view.findViewById(R.id.f_02_050_item3_1);
		item03_1.setAdapter(spinnerAdapter03_1);
		item03_1.setOnItemSelectedListener(spinLs);

		item03_4 = (Spinner) view.findViewById(R.id.f_02_050_item3_4);
		item03_4.setAdapter(spinnerAdapter03_4);
		item03_4.setOnItemSelectedListener(spinLs);
		

		item04_1 = (Spinner) view.findViewById(R.id.f_02_050_item4_1);
		item04_1.setAdapter(spinnerAdapter04_1);
		item04_1.setOnItemSelectedListener(spinLs);

		item04_4 = (Spinner) view.findViewById(R.id.f_02_050_item4_4);
		item04_4.setAdapter(spinnerAdapter04_4);
		item04_4.setOnItemSelectedListener(spinLs);
		
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_02_050_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_01_4) ;
		if(v != Constant.errorInt){item01_4.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_02_1) ;
		if(v != Constant.errorInt){item02_1.setSelection(v);}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_02_4) ;
		if(v != Constant.errorInt){item02_4.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_03_1) ;
		if(v != Constant.errorInt){item03_1.setSelection(v);}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_03_4) ;
		if(v != Constant.errorInt){item03_4.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_04_1) ;
		if(v != Constant.errorInt){item04_1.setSelection(v);}
		v = Preferences.getInstance().getInt(Constant.func_vk_02_050_04_4) ;
		if(v != Constant.errorInt){item04_4.setSelection(v);}
		
		
		
		item01_2_1 = (EditText)view.findViewById(R.id.f_02_050_item1_2_1);
		item01_2_2 = (EditText)view.findViewById(R.id.f_02_050_item1_2_2);
		item01_2_3 = (EditText)view.findViewById(R.id.f_02_050_item1_2_3);
		item01_2_4 = (EditText)view.findViewById(R.id.f_02_050_item1_2_4);
		item01_3 = (EditText)view.findViewById(R.id.f_02_050_item1_3);
		item01_2_1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item01_2_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item01_2_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item01_2_4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item01_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item01_2_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_01_2_1));
		item01_2_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_01_2_2));
		item01_2_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_01_2_3));
		item01_2_4.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_01_2_4));
		item01_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_01_3));

		
		item02_2_1 = (EditText)view.findViewById(R.id.f_02_050_item2_2_1);
		item02_2_2 = (EditText)view.findViewById(R.id.f_02_050_item2_2_2);
		item02_2_3 = (EditText)view.findViewById(R.id.f_02_050_item2_2_3);
		item02_2_4 = (EditText)view.findViewById(R.id.f_02_050_item2_2_4);
		item02_3 = (EditText)view.findViewById(R.id.f_02_050_item2_3);
		item02_2_1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item02_2_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item02_2_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item02_2_4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item02_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item02_2_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_02_2_1));
		item02_2_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_02_2_2));
		item02_2_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_02_2_3));
		item02_2_4.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_02_2_4));
		item02_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_02_3));
		
		
		item03_2_1 = (EditText)view.findViewById(R.id.f_02_050_item3_2_1);
		item03_2_2 = (EditText)view.findViewById(R.id.f_02_050_item3_2_2);
		item03_2_3 = (EditText)view.findViewById(R.id.f_02_050_item3_2_3);
		item03_2_4 = (EditText)view.findViewById(R.id.f_02_050_item3_2_4);
		item03_3 = (EditText)view.findViewById(R.id.f_02_050_item3_3);
		item03_2_1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item03_2_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item03_2_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item03_2_4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item03_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item03_2_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_03_2_1));
		item03_2_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_03_2_2));
		item03_2_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_03_2_3));
		item03_2_4.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_03_2_4));
		item03_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_03_3));
		
		
		item04_2_1 = (EditText)view.findViewById(R.id.f_02_050_item4_2_1);
		item04_2_2 = (EditText)view.findViewById(R.id.f_02_050_item4_2_2);
		item04_2_3 = (EditText)view.findViewById(R.id.f_02_050_item4_2_3);
		item04_2_4 = (EditText)view.findViewById(R.id.f_02_050_item4_2_4);
		item04_3 = (EditText)view.findViewById(R.id.f_02_050_item4_3);
		item04_2_1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item04_2_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item04_2_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item04_2_4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item04_3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item04_2_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_04_2_1));
		item04_2_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_04_2_2));
		item04_2_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_04_2_3));
		item04_2_4.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_04_2_4));
		item04_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_050_04_3));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_02_050_01_2_1) ;
		if(!str.equals(Constant.errorStr)){item01_2_1.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_01_2_2) ;
		if(!str.equals(Constant.errorStr)){item01_2_2.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_01_2_3) ;
		if(!str.equals(Constant.errorStr)){item01_2_3.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_01_2_4) ;
		if(!str.equals(Constant.errorStr)){item01_2_4.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_01_3) ;
		if(!str.equals(Constant.errorStr)){item01_3.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_02_050_02_2_1) ;
		if(!str.equals(Constant.errorStr)){item02_2_1.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_02_2_2) ;
		if(!str.equals(Constant.errorStr)){item02_2_2.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_02_2_3) ;
		if(!str.equals(Constant.errorStr)){item02_2_3.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_02_2_4) ;
		if(!str.equals(Constant.errorStr)){item02_2_4.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_02_3) ;
		if(!str.equals(Constant.errorStr)){item02_3.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_02_050_03_2_1) ;
		if(!str.equals(Constant.errorStr)){item03_2_1.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_03_2_2) ;
		if(!str.equals(Constant.errorStr)){item03_2_2.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_03_2_3) ;
		if(!str.equals(Constant.errorStr)){item03_2_3.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_03_2_4) ;
		if(!str.equals(Constant.errorStr)){item03_2_4.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_03_3) ;
		if(!str.equals(Constant.errorStr)){item03_3.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_02_050_04_2_1) ;
		if(!str.equals(Constant.errorStr)){item04_2_1.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_04_2_2) ;
		if(!str.equals(Constant.errorStr)){item04_2_2.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_04_2_3) ;
		if(!str.equals(Constant.errorStr)){item04_2_3.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_04_2_4) ;
		if(!str.equals(Constant.errorStr)){item04_2_4.setText(str);}
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_04_3) ;
		if(!str.equals(Constant.errorStr)){item04_3.setText(str);}

		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_02_050_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	private void putSpinnerValue_1(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "无效")) ;
		spinnerAdapter.add(new SpinnerVO("1", "有效")) ;
	}
	
	private void putSpinnerValue_4(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "TCP")) ;
		spinnerAdapter.add(new SpinnerVO("1", "UDP")) ;
	}
	
	OnItemSelectedListener spinLs = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_02_050.this.item01_1){
				spinnerPosition01_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_01_1, position) ;
			}else if(parent == F_02_050.this.item01_4){
				spinnerPosition01_4 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_01_4, position) ;
			}else if(parent == F_02_050.this.item02_1){
				spinnerPosition02_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_02_1, position) ;
			}else if(parent == F_02_050.this.item02_4){
				spinnerPosition02_4 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_02_4, position) ;
			}else if(parent == F_02_050.this.item03_1){
				spinnerPosition03_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_03_1, position) ;
			}else if(parent == F_02_050.this.item03_4){
				spinnerPosition03_4 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_03_4, position) ;
			}else if(parent == F_02_050.this.item04_1){
				spinnerPosition04_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_04_1, position) ;
			}else if(parent == F_02_050.this.item04_4){
				spinnerPosition04_4 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_02_050_04_4, position) ;
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
		boolean ok = true ;
		
		String strIp1 = item01_2_1.getText().toString().trim() ;
		String strIp2 = item01_2_2.getText().toString().trim() ;
		String strIp3 = item01_2_3.getText().toString().trim() ;
		String strIp4 = item01_2_4.getText().toString().trim() ;
		String strPort = item01_3.getText().toString().trim() ;
		ok = F_02_050_Help.checkIpPort(act, strIp1, strIp2, strIp3, strIp4 ,strPort, "中心一", showDialog) ;
		if(ok){
			strIp1 = item02_2_1.getText().toString().trim() ;
			strIp2 = item02_2_2.getText().toString().trim() ;
			strIp3 = item02_2_3.getText().toString().trim() ;
			strIp4 = item02_2_4.getText().toString().trim() ;
			strPort = item02_3.getText().toString().trim() ;
			ok = F_02_050_Help.checkIpPort(act, strIp1, strIp2, strIp3, strIp4 ,strPort, "中心二", showDialog) ;
			if(ok){
				strIp1 = item03_2_1.getText().toString().trim() ;
				strIp2 = item03_2_2.getText().toString().trim() ;
				strIp3 = item03_2_3.getText().toString().trim() ;
				strIp4 = item03_2_4.getText().toString().trim() ;
				strPort = item03_3.getText().toString().trim() ;
				ok = F_02_050_Help.checkIpPort(act, strIp1, strIp2, strIp3, strIp4 ,strPort, "中心三", showDialog) ;
				if(ok){
					strIp1 = item04_2_1.getText().toString().trim() ;
					strIp2 = item04_2_2.getText().toString().trim() ;
					strIp3 = item04_2_3.getText().toString().trim() ;
					strIp4 = item04_2_4.getText().toString().trim() ;
					strPort = item04_3.getText().toString().trim() ;
					ok = F_02_050_Help.checkIpPort(act, strIp1, strIp2, strIp3, strIp4 ,strPort, "中心四", showDialog) ;
				}
			}
		}
		
		return ok ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_CC(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_DC p = new Param_DC() ;
		
		p.setEnable_1(Integer.valueOf(spinnerAdapter01_1.getItem(spinnerPosition01_1).getId())) ;
		p.setEnable_2(Integer.valueOf(spinnerAdapter02_1.getItem(spinnerPosition02_1).getId())) ;
		p.setEnable_3(Integer.valueOf(spinnerAdapter03_1.getItem(spinnerPosition03_1).getId())) ;
		p.setEnable_4(Integer.valueOf(spinnerAdapter04_1.getItem(spinnerPosition04_1).getId())) ;
		
		p.setType_1(Integer.valueOf(spinnerAdapter01_4.getItem(spinnerPosition01_4).getId())) ;
		p.setType_2(Integer.valueOf(spinnerAdapter02_4.getItem(spinnerPosition02_4).getId())) ;
		p.setType_3(Integer.valueOf(spinnerAdapter03_4.getItem(spinnerPosition03_4).getId())) ;
		p.setType_4(Integer.valueOf(spinnerAdapter04_4.getItem(spinnerPosition04_4).getId())) ;
		
		String strIp1 = item01_2_1.getText().toString().trim() ;
		String strIp2 = item01_2_2.getText().toString().trim() ;
		String strIp3 = item01_2_3.getText().toString().trim() ;
		String strIp4 = item01_2_4.getText().toString().trim() ;
		String strPort = item01_3.getText().toString().trim() ;
		p.setIp_1_1_0to254(Integer.valueOf(strIp1)) ;
		p.setIp_1_2_0to254(Integer.valueOf(strIp2)) ;
		p.setIp_1_3_0to254(Integer.valueOf(strIp3)) ;
		p.setIp_1_4_0to254(Integer.valueOf(strIp4)) ;
		p.setPort_1_0to65535(Integer.valueOf(strPort)) ;
		
		
		strIp1 = item02_2_1.getText().toString().trim() ;
		strIp2 = item02_2_2.getText().toString().trim() ;
		strIp3 = item02_2_3.getText().toString().trim() ;
		strIp4 = item02_2_4.getText().toString().trim() ;
		strPort = item02_3.getText().toString().trim() ;
		p.setIp_2_1_0to254(Integer.valueOf(strIp1)) ;
		p.setIp_2_2_0to254(Integer.valueOf(strIp2)) ;
		p.setIp_2_3_0to254(Integer.valueOf(strIp3)) ;
		p.setIp_2_4_0to254(Integer.valueOf(strIp4)) ;
		p.setPort_2_0to65535(Integer.valueOf(strPort)) ;
		
		
		strIp1 = item03_2_1.getText().toString().trim() ;
		strIp2 = item03_2_2.getText().toString().trim() ;
		strIp3 = item03_2_3.getText().toString().trim() ;
		strIp4 = item03_2_4.getText().toString().trim() ;
		strPort = item03_3.getText().toString().trim() ;
		p.setIp_3_1_0to254(Integer.valueOf(strIp1)) ;
		p.setIp_3_2_0to254(Integer.valueOf(strIp2)) ;
		p.setIp_3_3_0to254(Integer.valueOf(strIp3)) ;
		p.setIp_3_4_0to254(Integer.valueOf(strIp4)) ;
		p.setPort_3_0to65535(Integer.valueOf(strPort)) ;
		
		
		
		strIp1 = item04_2_1.getText().toString().trim() ;
		strIp2 = item04_2_2.getText().toString().trim() ;
		strIp3 = item04_2_3.getText().toString().trim() ;
		strIp4 = item04_2_4.getText().toString().trim() ;
		strPort = item04_3.getText().toString().trim() ;
		p.setIp_4_1_0to254(Integer.valueOf(strIp1)) ;
		p.setIp_4_2_0to254(Integer.valueOf(strIp2)) ;
		p.setIp_4_3_0to254(Integer.valueOf(strIp3)) ;
		p.setIp_4_4_0to254(Integer.valueOf(strIp4)) ;
		p.setPort_4_0to65535(Integer.valueOf(strPort)) ;
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_DC(p, null), false) ;
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
		
		Data_CC_DC sd = (Data_CC_DC)d.subData ;

		item01_1.setSelection(sd.getEnable_1().intValue()) ;
		item01_2_1.setText("" + sd.getIp_1_1());
		item01_2_2.setText("" + sd.getIp_1_2());
		item01_2_3.setText("" + sd.getIp_1_3());
		item01_2_4.setText("" + sd.getIp_1_4());
		item01_3.setText("" + sd.getPort_1());
		item01_4.setSelection(sd.getType_1().intValue()) ;

		item02_1.setSelection(sd.getEnable_2().intValue()) ;
		item02_2_1.setText("" + sd.getIp_2_1());
		item02_2_2.setText("" + sd.getIp_2_2());
		item02_2_3.setText("" + sd.getIp_2_3());
		item02_2_4.setText("" + sd.getIp_2_4());
		item02_3.setText("" + sd.getPort_2());
		item02_4.setSelection(sd.getType_2().intValue()) ;

		item03_1.setSelection(sd.getEnable_3().intValue()) ;
		item03_2_1.setText("" + sd.getIp_3_1());
		item03_2_2.setText("" + sd.getIp_3_2());
		item03_2_3.setText("" + sd.getIp_3_3());
		item03_2_4.setText("" + sd.getIp_3_4());
		item03_3.setText("" + sd.getPort_3());
		item03_4.setSelection(sd.getType_3().intValue()) ;

		item04_1.setSelection(sd.getEnable_4().intValue()) ;
		item04_2_1.setText("" + sd.getIp_4_1());
		item04_2_2.setText("" + sd.getIp_4_2());
		item04_2_3.setText("" + sd.getIp_4_3());
		item04_2_4.setText("" + sd.getIp_4_4());
		item04_3.setText("" + sd.getPort_4());
		item04_4.setSelection(sd.getType_4().intValue()) ;

		
		Preferences.getInstance().putString(Constant.func_vk_02_050_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_02_050_item01_1(spinnerPosition01_1) ;
		vo.setV_02_050_item01_2_1(item01_2_1.getText().toString()) ;
		vo.setV_02_050_item01_2_2(item01_2_2.getText().toString()) ;
		vo.setV_02_050_item01_2_3(item01_2_3.getText().toString()) ;
		vo.setV_02_050_item01_2_4(item01_2_4.getText().toString()) ;
		vo.setV_02_050_item01_3(item01_3.getText().toString()) ;
		vo.setV_02_050_item01_4(spinnerPosition01_4) ;
		
		vo.setV_02_050_item02_1(spinnerPosition02_1) ;
		vo.setV_02_050_item02_2_1(item02_2_1.getText().toString()) ;
		vo.setV_02_050_item02_2_2(item02_2_2.getText().toString()) ;
		vo.setV_02_050_item02_2_3(item02_2_3.getText().toString()) ;
		vo.setV_02_050_item02_2_4(item02_2_4.getText().toString()) ;
		vo.setV_02_050_item02_3(item02_3.getText().toString()) ;
		vo.setV_02_050_item02_4(spinnerPosition02_4) ;

		vo.setV_02_050_item03_1(spinnerPosition03_1) ;
		vo.setV_02_050_item03_2_1(item03_2_1.getText().toString()) ;
		vo.setV_02_050_item03_2_2(item03_2_2.getText().toString()) ;
		vo.setV_02_050_item03_2_3(item03_2_3.getText().toString()) ;
		vo.setV_02_050_item03_2_4(item03_2_4.getText().toString()) ;
		vo.setV_02_050_item03_3(item03_3.getText().toString()) ;
		vo.setV_02_050_item03_4(spinnerPosition03_4) ;

		vo.setV_02_050_item04_1(spinnerPosition04_1) ;
		vo.setV_02_050_item04_2_1(item04_2_1.getText().toString()) ;
		vo.setV_02_050_item04_2_2(item04_2_2.getText().toString()) ;
		vo.setV_02_050_item04_2_3(item04_2_3.getText().toString()) ;
		vo.setV_02_050_item04_2_4(item04_2_4.getText().toString()) ;
		vo.setV_02_050_item04_3(item04_3.getText().toString()) ;
		vo.setV_02_050_item04_4(spinnerPosition04_4) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01_1.setSelection(vo.getV_02_050_item01_1()) ;
		item01_2_1.setText(vo.getV_02_050_item01_2_1());
		item01_2_2.setText(vo.getV_02_050_item01_2_2());
		item01_2_3.setText(vo.getV_02_050_item01_2_3());
		item01_2_4.setText(vo.getV_02_050_item01_2_4());
		item01_3.setText(vo.getV_02_050_item01_3());
		item01_4.setSelection(vo.getV_02_050_item01_4()) ;
		
		item02_1.setSelection(vo.getV_02_050_item02_1()) ;
		item02_2_1.setText(vo.getV_02_050_item02_2_1());
		item02_2_2.setText(vo.getV_02_050_item02_2_2());
		item02_2_3.setText(vo.getV_02_050_item02_2_3());
		item02_2_4.setText(vo.getV_02_050_item02_2_4());
		item02_3.setText(vo.getV_02_050_item02_3());
		item02_4.setSelection(vo.getV_02_050_item02_4()) ;

		item03_1.setSelection(vo.getV_02_050_item03_1()) ;
		item03_2_1.setText(vo.getV_02_050_item03_2_1());
		item03_2_2.setText(vo.getV_02_050_item03_2_2());
		item03_2_3.setText(vo.getV_02_050_item03_2_3());
		item03_2_4.setText(vo.getV_02_050_item03_2_4());
		item03_3.setText(vo.getV_02_050_item03_3());
		item03_4.setSelection(vo.getV_02_050_item03_4()) ;

		item04_1.setSelection(vo.getV_02_050_item04_1()) ;
		item04_2_1.setText(vo.getV_02_050_item04_2_1());
		item04_2_2.setText(vo.getV_02_050_item04_2_2());
		item04_2_3.setText(vo.getV_02_050_item04_2_3());
		item04_2_4.setText(vo.getV_02_050_item04_2_4());
		item04_3.setText(vo.getV_02_050_item04_3());
		item04_4.setSelection(vo.getV_02_050_item04_4()) ;
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