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
import com.blg.rtu.protocol.p206.cdEA_FA.Data_EA_FA;
import com.blg.rtu.protocol.p206.cdEA_FA.Param_FA;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.NumUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_03_070  extends FrmParent {
	
	private final static int requestLen5 = 5 ; 
	private final static int requestLen8 = 8 ; 

	private TextView title ;

	private Spinner item01_1;
	private EditText item01_2 ;
	private Spinner item02_1;
	private EditText item02_2 ;
	private Spinner item03_1;
	private EditText item03_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_1;
	private int spinnerPosition01_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02_1;
	private int spinnerPosition02_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_1;
	private int spinnerPosition03_1 ;


	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_EA ;
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
		View view = inflater.inflate(R.layout.f_func_03_070, container, false);

		title = (TextView)view.findViewById(R.id.f_03_070_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_03_070_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_03_070_Load) ;
		

		spinnerAdapter01_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter01_1);
		spinnerAdapter01_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter02_1);
		spinnerAdapter02_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter03_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter03_1);
		spinnerAdapter03_1.setDropDownViewResource(R.layout.spinner_item);

		item01_1 = (Spinner) view.findViewById(R.id.f_03_070_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs_1);

		item02_1 = (Spinner) view.findViewById(R.id.f_03_070_item2_1);
		item02_1.setAdapter(spinnerAdapter02_1);
		item02_1.setOnItemSelectedListener(spinLs_1);

		item03_1 = (Spinner) view.findViewById(R.id.f_03_070_item3_1);
		item03_1.setAdapter(spinnerAdapter03_1);
		item03_1.setOnItemSelectedListener(spinLs_1);

		int v = Preferences.getInstance().getInt(Constant.func_vk_03_070_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_070_02_1) ;
		if(v != Constant.errorInt){item02_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_070_03_1) ;
		if(v != Constant.errorInt){item03_1.setSelection(v);}
		
		item01_2 = (EditText)view.findViewById(R.id.f_03_070_item1_2);
		item01_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen8)});
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_070_01_2));

		item02_2 = (EditText)view.findViewById(R.id.f_03_070_item2_2);
		item02_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item02_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_070_02_2));

		item03_2 = (EditText)view.findViewById(R.id.f_03_070_item3_2);
		item03_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item03_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_070_03_2));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_03_070_01_2) ;
		if(!str.equals(Constant.errorStr)){item01_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_03_070_02_2) ;
		if(!str.equals(Constant.errorStr)){item02_2.setText(str);}

		str = Preferences.getInstance().getString(Constant.func_vk_03_070_03_2) ;
		if(!str.equals(Constant.errorStr)){item03_2.setText(str);}

		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_03_070_dt) ;
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
			if(parent == F_03_070.this.item01_1){
				spinnerPosition01_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_070_01_1, position) ;
			}else if(parent == F_03_070.this.item02_1){
				spinnerPosition02_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_070_02_1, position) ;
			}else if(parent == F_03_070.this.item03_1){
				spinnerPosition03_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_070_03_1, position) ;
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
		String e2 = spinnerAdapter02_1.getItem(spinnerPosition02_1).getId() ;
		String e3 = spinnerAdapter03_1.getItem(spinnerPosition03_1).getId() ;
		
		String v1 = item01_2.getText().toString().trim() ;
		String v2 = item02_2.getText().toString().trim() ;
		String v3 = item03_2.getText().toString().trim() ;
		
		if(e1.equals("1") && v1.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的井口高程必须填写！") ;
			}
			return false ;			
		}
		if(e2.equals("1") && v2.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的水井深度必须填写！") ;
			}
			return false ;			
		}
		if(e3.equals("1") && v3.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的探头埋深必须填写！") ;
			}
			return false ;			
		}
		
		if(!NumUtil.isDoubleNumber(v1)){
			if(showDialog){
				new DialogAlarm().showDialog(act, "井口高程不是合法数字！") ;
			}
			return false ;		
		}
		if(!NumUtil.isDoubleNumber(v2)){
			if(showDialog){
				new DialogAlarm().showDialog(act, "水井深度不是合法数字！") ;
			}
			return false ;		
		}
		if(!NumUtil.isDoubleNumber(v3)){
			if(showDialog){
				new DialogAlarm().showDialog(act, "探头埋深不是合法数字！") ;
			}
			return false ;		
		}
		
		Float f = Float.valueOf(v1) ;
		//以下写法当f为7999.99或-799.99时出错，不知道为什么
		//if(f > 7999.99 || f < -7999.99){
		//	if(showDialog){
		//		new DialogAlarm().showDialog(act, "井口高程不是有效数值(-7999.99～7999.99)！") ;
		//	}
		//	return false ;	
		//}
		Float f1 = 7999.99F, f2 = -7999.99F ;
		if(f > f1 || f < f2){
			if(showDialog){
				new DialogAlarm().showDialog(act, "井口高程不是有效数值(-7999.99～7999.99)！") ;
			}
			return false ;	
		}
		
		if(Float.valueOf(v2) > 99.99){
			if(showDialog){
				new DialogAlarm().showDialog(act, "水井深度不是有效数值(0～99.99)！") ;
			}
			return false ;	
		}
		if(Float.valueOf(v3) > 99.99){
			if(showDialog){
				new DialogAlarm().showDialog(act, "探头埋深不是有效数值(0～99.99)！") ;
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
		this.sendRtuCommand(new CommandCreator().cd_EA(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_FA p = new Param_FA() ;
		
		String e1 = spinnerAdapter01_1.getItem(spinnerPosition01_1).getId() ;
		String e2 = spinnerAdapter02_1.getItem(spinnerPosition02_1).getId() ;
		String e3 = spinnerAdapter03_1.getItem(spinnerPosition03_1).getId() ;
		
		p.setEnable_1(Integer.valueOf(e1)) ;
		p.setEnable_2(Integer.valueOf(e2)) ;
		p.setEnable_3(Integer.valueOf(e3)) ;
		
		String v1 = item01_2.getText().toString().trim() ;
		String v2 = item02_2.getText().toString().trim() ;
		String v3 = item03_2.getText().toString().trim() ;
		
		v1 = v1.equals("")?"0.0":v1 ;
		v2 = v2.equals("")?"0.0":v2 ;
		v3 = v3.equals("")?"0.0":v3 ;
		
		p.setValue_1_n7999d99To7999d99(Float.valueOf(v1)) ;//井口高程
		p.setValue_2_0To99d99(Float.valueOf(v2)) ;//水井深度
		p.setValue_3_0To99d99(Float.valueOf(v3)) ;//探头埋深

		this.sendRtuCommand(new CommandCreator().cd_FA(p, null), false) ;
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
		
		Data_EA_FA sd = (Data_EA_FA)d.subData ;

		item01_1.setSelection(sd.getEnable_1().intValue()) ;
		item01_2.setText("" + sd.getValue_1());

		item02_1.setSelection(sd.getEnable_2().intValue()) ;
		item02_2.setText("" + sd.getValue_2());

		item03_1.setSelection(sd.getEnable_3().intValue()) ;
		item03_2.setText("" + sd.getValue_3());
		
		Preferences.getInstance().putString(Constant.func_vk_03_070_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		vo.setV_03_070_item01_1(spinnerPosition01_1) ;
		vo.setV_03_070_item01_2(item01_2.getText().toString()) ;
		vo.setV_03_070_item02_1(spinnerPosition02_1) ;
		vo.setV_03_070_item02_2(item02_2.getText().toString()) ;
		vo.setV_03_070_item03_1(spinnerPosition03_1) ;
		vo.setV_03_070_item03_2(item03_2.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		item01_1.setSelection(vo.getV_03_070_item01_1()) ;
		item01_2.setText(vo.getV_03_070_item01_2()) ;
		item02_1.setSelection(vo.getV_03_070_item02_1()) ;
		item02_2.setText(vo.getV_03_070_item02_2()) ;
		item03_1.setSelection(vo.getV_03_070_item03_1()) ;
		item03_2.setText(vo.getV_03_070_item03_2()) ;
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