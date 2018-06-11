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
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd92_93.Data_92;
import com.blg.rtu.protocol.p206.cd92_93.Data_93;
import com.blg.rtu.protocol.p206.cd92_93.Param_92_93;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;
import com.blg.rtu3.server.CoreThread;

public class F_06_020 extends FrmParent {
	
	private final static int requestLen_2 = 2 ; 
	private TextView title ;
	
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private int spinnerPosition ;
	
	private TextView item02  ;
	private TextView item03 ;
	
	private ImageView btnOpen ;
	private ImageView btnClose;
	

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
		View view = inflater.inflate(R.layout.f_func_06_020, container, false);

		title = (TextView)view.findViewById(R.id.f_06_020_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_06_020_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_06_020_Load) ;
		
		item01 = (Spinner) view.findViewById(R.id.f_06_020_item1);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		this.putSpinnerValue();
		item01.setAdapter(spinnerAdapter);
		item01.setOnItemSelectedListener(new SpinnerSelectedListener());
	/*	int v = Preferences.getInstance().getInt(Constant.func_vk_06_020_01) ;
		if(v != Constant.errorInt){
			item01.setSelection(v); 
		}*/
		
		item02 = (TextView)view.findViewById(R.id.func_06_020_item02);
		item02.setText("0") ;
		String str = "";
		/*item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_06_020_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_020_02));*/
		item03 = (TextView)view.findViewById(R.id.func_06_020_item03) ;
		str = Preferences.getInstance().getString(Constant.func_vk_06_020_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str) ;
		}

		btnOpen = (ImageView)view.findViewById(R.id.btn_open);
		btnOpen.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				if(checkBeforeQuery(true)){
					new DialogConfirm().showDialog(act,
							act.getResources().getString(R.string.txtConfirmSendOpenCommand) ,
							new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){ 
									showLoadCover() ;
									queryCommand() ;
								}else{
								}
							}
					}) ;
				}else{
					//commandHasProblem() ;
				}
			}
		}) ;
		
		btnClose = (ImageView)view.findViewById(R.id.btn_close);
		btnClose.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				if(checkBeforeSet(true)){
					new DialogConfirm().showDialog(act,
							act.getResources().getString(R.string.txtConfirmSendCloseCommand) ,
							new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){ 
									showLoadCover() ;
									setCommand() ;
								}else{
								}
							}
					}) ;
				}else{
					//commandHasProblem() ;
				}
			}
		}) ;
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		
		str = Preferences.getInstance().getString(Constant.func_vk_06_020_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	private void putSpinnerValue(){
		//spinnerAdapter.add(new SpinnerVO("" + 0, "水泵")) ;
		spinnerAdapter.add(new SpinnerVO("" + 0, "阀门")) ;
	}
	
	public class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition = position ;
			Preferences.getInstance().putInt(Constant.func_vk_06_020_01, position) ;
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}
	/**
	 * 查询命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeQuery(boolean showDialog){
		String num = item02.getText().toString() ;//
		if(num == null || num.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "启动的查询的编码号必须填写！") ;
			return false ;
		} 
		
		int numValue = Integer.valueOf(num) ;
		if(numValue < 0 || numValue > 15){
			if(showDialog)new DialogAlarm().showDialog(act, "启动的编码号必须是0~15的数字！") ;
			return false ;
		}

		return true ;
	}
	
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeSet(boolean showDialog){
		String num = item02.getText().toString() ;//
		if(num == null || num.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "关闭的编码号必须填写！") ;
			return false ;
		} 
		
		int numValue = Integer.valueOf(num) ;
		if(numValue < 0 || numValue > 15){
			if(showDialog)new DialogAlarm().showDialog(act, "关闭的编码号必须是0~15的数字！") ;
			return false ;
		}
		
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		Param_92_93 p = new Param_92_93() ;
		p.setDevice_0or15(0x0f) ;
		String num = item02.getText().toString() ;//整数部分
		
		/*if(num == null || num.equals("")){*/
		p.setNum_0to15(0) ;
		/*}else{
			p.setNum_0to15(Integer.valueOf(num)) ;
		}*/
		
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_92(p, null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_92_93 p = new Param_92_93() ;
		
		//int type = Integer.valueOf(spinnerAdapter.getItem(spinnerPosition).getId()) ;
		//if(type == 0) {
			//p.setDevice_0or15(0x00) ;
		//}else{
			p.setDevice_0or15(0x0f) ;
		//}
		//String num = item02.getText().toString() ;//整数部分
		
		//if(num == null || num.equals("")){
			p.setNum_0to15(0) ;
		//}else{
			//p.setNum_0to15(Integer.valueOf(num)) ;
		//}
		
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_93(p, null), false) ;
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item007(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item007(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item007(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
	}
	/**
	 * 功能项右侧图标复原
	 */
	@Override
	public void resetLabelImg(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item007(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item007(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 

		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_92){
				Data_92 sd = (Data_92)subD ;
				item02.setText(sd.getNum()+ "") ;
				if(sd.getSuccess()) {
					item03.setText("执行完毕") ;
				}else{
					item03.setText("未执行！") ;
				}
			}else if(subD instanceof Data_93){
				Data_93 sd = (Data_93)subD ;
				item02.setText(sd.getNum()+ "") ;
				if(sd.getSuccess()) {
					item03.setText("执行完毕") ;
				}else{
					item03.setText("未执行！") ;
				}
			}
		}
		
		
		Preferences.getInstance().putString(Constant.func_vk_06_020_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		//vo.setV_06_020_item01(spinnerPosition) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		//item01.setSelection(vo.getV_06_020_item01()); 
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
