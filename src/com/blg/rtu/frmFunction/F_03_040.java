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
import com.blg.rtu.protocol.p206.cdE5_F5.Data_E5_F5;
import com.blg.rtu.protocol.p206.cdE5_F5.Param_F5;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.NumUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_03_040  extends FrmParent {
	
	private final static int requestLen7 = 7 ; 

	private TextView title ;

	private Spinner item01_1;
	private EditText item01_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_1;
	private int spinnerPosition01_1 ;


	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_E5 ;
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
		View view = inflater.inflate(R.layout.f_func_03_040, container, false);

		title = (TextView)view.findViewById(R.id.f_03_040_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_03_040_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_03_040_Load) ;
		

		spinnerAdapter01_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue01_1();
		spinnerAdapter01_1.setDropDownViewResource(R.layout.spinner_item);
		
		item01_1 = (Spinner) view.findViewById(R.id.f_03_040_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs01_1);

		int v = Preferences.getInstance().getInt(Constant.func_vk_03_040_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}

		item01_2 = (EditText)view.findViewById(R.id.f_03_040_item1_2);
		item01_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen7)});
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_03_040_01_2));

		
		String str = Preferences.getInstance().getString(Constant.func_vk_03_040_01_2) ;
		if(!str.equals(Constant.errorStr)){item01_2.setText(str);}


		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_03_040_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}

	private void putSpinnerValue01_1(){
		spinnerAdapter01_1.add(new SpinnerVO("0", "无效")) ;
		spinnerAdapter01_1.add(new SpinnerVO("1", "有效")) ;
	}
	OnItemSelectedListener spinLs01_1 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition01_1 = position ;
			Preferences.getInstance().putInt(Constant.func_vk_03_040_01_1, position) ;
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
		
		String v1 = item01_2.getText().toString().trim() ;

		
		if(e1.equals("1") && v1.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "设置为有效的仪表采集修正值必须填写！") ;
			}
			return false ;			
		}
		
		if(!NumUtil.isDoubleNumber(v1)){
			if(showDialog){
				new DialogAlarm().showDialog(act, "水位采集修正值不是合法数字！") ;
			}
			return false ;		
		}
		
		Float f = Float.valueOf(v1) ;
		//以下写法当f为30.999或-30.999时出错，不知道为什么
		//if(f > 30.999 || f < -30.999){
		//	if(showDialog){
		//		new DialogAlarm().showDialog(act, "井口高程不是有效数值(-30.999～30.999)！") ;
		//	}
		//	return false ;	
		//}
		Float f1 = 30.999F, f2 = -30.999F ;
		if(f > f1 || f < f2){
			if(showDialog){
				new DialogAlarm().showDialog(act, "水位采集修正值不是有效值(-30.999～30.999)！") ;
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
		this.sendRtuCommand(new CommandCreator().cd_E5(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_F5 p = new Param_F5() ;
		
		String e1 = spinnerAdapter01_1.getItem(spinnerPosition01_1).getId() ;
		
		p.setEnable_level_0To1(Integer.valueOf(e1)) ;
		
		String v1 = item01_2.getText().toString().trim() ;
		
		v1 = v1.equals("")?"0":v1 ;
		
		p.setMeter_level_n30d999to30d999(Double.valueOf(v1)) ;//水位仪表采集修正值

		this.sendRtuCommand(new CommandCreator().cd_F5(p, null), false) ;
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
		
		Data_E5_F5 sd = (Data_E5_F5)d.subData ;

		item01_1.setSelection(sd.getEnable_level().intValue()) ;
		item01_2.setText("" + sd.getMeter_level());

		
		Preferences.getInstance().putString(Constant.func_vk_03_040_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
	/*	vo.setV_03_040_item01_1(spinnerPosition01_1) ;
		vo.setV_03_040_item01_2(item01_2.getText().toString()) ;*/
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		/*item01_1.setSelection(vo.getV_03_040_item01_1()) ;
		item01_2.setText(vo.getV_03_040_item01_2()) ;*/
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