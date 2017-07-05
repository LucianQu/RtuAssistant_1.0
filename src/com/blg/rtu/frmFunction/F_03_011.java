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
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdD8.Data_D8;
import com.blg.rtu.protocol.p206.cdD8.Param_D8;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class F_03_011  extends FrmParent {
	
	private final static int requestLen5 = 5 ; 

	private TextView title ;

	private Spinner item01;
	private Spinner item02;
	private EditText item03 ;
	
	private ArrayAdapter<SpinnerVO> spinnerAdapter01;
	private int spinnerPosition01 ;

	private ArrayAdapter<SpinnerVO> spinnerAdapter02;
	private int spinnerPosition02 ;


	private ImageView btnSet ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
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
		View view = inflater.inflate(R.layout.f_func_03_011, container, false);

		title = (TextView)view.findViewById(R.id.f_03_011_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_03_011_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_03_011_Load) ;
		

		spinnerAdapter01 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue01();
		spinnerAdapter01.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue02();
		spinnerAdapter02.setDropDownViewResource(R.layout.spinner_item);
		

		item01 = (Spinner) view.findViewById(R.id.f_03_011_item1);
		item01.setAdapter(spinnerAdapter01);
		item01.setOnItemSelectedListener(spinLs01);
		

		item02 = (Spinner) view.findViewById(R.id.f_03_011_item2);
		item02.setAdapter(spinnerAdapter02);
		item02.setOnItemSelectedListener(spinLs02);


		int v = Preferences.getInstance().getInt(Constant.func_vk_03_011_01) ;
		if(v != Constant.errorInt){item01.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_011_02) ;
		if(v != Constant.errorInt){item02.setSelection(v);}

		
		
		item03 = (EditText)view.findViewById(R.id.f_03_011_item3);
		item03.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen5)});
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_011_03));

		String str = Preferences.getInstance().getString(Constant.func_vk_03_011_03) ;
		if(!str.equals(Constant.errorStr)){item03.setText(str);}


		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_03_011_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}

	private void putSpinnerValue01(){
		spinnerAdapter01.add(new SpinnerVO("1", "10位AD值")) ;
		spinnerAdapter01.add(new SpinnerVO("2", "24位AD值")) ;
	}
	private void putSpinnerValue02(){
		spinnerAdapter02.add(new SpinnerVO("0", "0")) ;
		spinnerAdapter02.add(new SpinnerVO("1", "1")) ;
		spinnerAdapter02.add(new SpinnerVO("2", "2")) ;
		spinnerAdapter02.add(new SpinnerVO("3", "3")) ;
	}
	OnItemSelectedListener spinLs01 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition01 = position ;
			Preferences.getInstance().putInt(Constant.func_vk_03_011_01, position) ;
			if(spinnerPosition01 == 1){
				item03.setText("0") ;
				item03.setEnabled(false) ;
			}else if(spinnerPosition01 == 0){
				String str = Preferences.getInstance().getString(Constant.func_vk_03_011_03) ;
				if(!str.equals(Constant.errorStr)){
					item03.setText(str);
				}else{
					item03.setText("") ;
				}
				item03.setEnabled(true) ;
			}
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};	
	OnItemSelectedListener spinLs02 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition02 = position ;
			Preferences.getInstance().putInt(Constant.func_vk_03_011_02, position) ;
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
		String v = item03.getText().toString().trim() ;
		if(v.equals("") || v.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "校准电压值必须填写！") ;
			}
			return false ;			
		}
		Double d = Double.valueOf(v) ;
		if(d < 0 || d > 99.99){
			if(showDialog){
				new DialogAlarm().showDialog(act, "校准电压值不是在合法范围(0~99.99)") ;
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
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_D8 p = new Param_D8() ;
		
		p.setType_1Or2(Integer.valueOf(spinnerAdapter01.getItem(spinnerPosition01).getId())) ;
		p.setChannel_0to3(Integer.valueOf(spinnerAdapter02.getItem(spinnerPosition02).getId())) ;
		
		String v = item03.getText().toString().trim() ;
		
		p.setValue_0to99d99(Double.valueOf(v)) ;

		
		this.sendRtuCommand(new CommandCreator().cd_D8(p, null), false) ;
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
		
		Data_D8 sd = (Data_D8)d.subData ;
		
		if(sd.getSuccess()){
			int n = sd.getType().intValue() - 1 ;
			if(n < 0 || n > 1){
				n = 0 ;
			}
			item01.setSelection(n) ;
			
			n = sd.getChannel().intValue() ;
			if(n < 0 || n > 3){
				n = 0 ;
			}
			item02.setSelection(n) ;
			item03.setText("" + sd.getValue());
			Preferences.getInstance().putString(Constant.func_vk_03_011_dt, this.resultDt.getText().toString()) ;
		}else{
			new DialogAlarm().showDialog(act, "AD校准命令失败!") ;
		}
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		/*vo.setV_03_011_item01(spinnerPosition01) ;
		vo.setV_03_011_item02(spinnerPosition02) ;
		vo.setV_03_011_item03(item03.getText().toString()) ;*/
		
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
	/*	item01.setSelection(vo.getV_03_011_item01()) ;
		item02.setSelection(vo.getV_03_011_item02()) ;
		item03.setText(vo.getV_03_011_item03());*/
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