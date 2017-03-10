package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdE1_F1.Data_E1_F1;
import com.blg.rtu.protocol.p206.cdE1_F1.Param_F1;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class F_01_080  extends FrmParent {
	
	private final static int requestLen_1 = 3 ; 
	private final static int requestLen_2 = 2 ; 

	private TextView title ;

	private EditText item01_1 ;
	private EditText item01_2 ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_E1 ;
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
		View view = inflater.inflate(R.layout.f_func_01_080, container, false);

		title = (TextView)view.findViewById(R.id.f_01_080_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_080_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_080_Load) ;
		
		item01_1 = (EditText)view.findViewById(R.id.func_01_080_item01_1);
		item01_2 = (EditText)view.findViewById(R.id.func_01_080_item01_2);
		
		item01_1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_1)});
		item01_2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_080_01_1) ;
		if(!str.equals(Constant.errorStr)){
			item01_1.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_080_01_2) ;
		if(!str.equals(Constant.errorStr)){
			item01_2.setText(str); 
		}
		
		item01_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_080_01_1));
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_080_01_2));
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_080_dt) ;
		if(str != Constant.errorStr){
			this.resultDt.setText(str) ;
		}

		return view ;
	}

	
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
		String voltage1 = item01_1.getText().toString() ;//整数部分
		String voltage2 = item01_2.getText().toString() ;//小数部分

		if((voltage1 == null || voltage1.equals("")) && (voltage2 == null || voltage2.equals("")) ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "电池电压报警值必须填写！") ;
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
		this.sendRtuCommand(new CommandCreator().cd_E1(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String voltage1 = item01_1.getText().toString() ;//整数部分
		String voltage2 = item01_2.getText().toString() ;//小数部分

		Param_F1 p = new Param_F1() ;
		if(voltage1 == null || voltage1.equals("")){
			p.setVoltage1(0) ;
		}else{
			p.setVoltage1(Integer.valueOf(voltage1)) ;
		}
		
		if(voltage2 == null || voltage2.equals("")){
			p.setVoltage2(0) ;
		}else{
			p.setVoltage2(Integer.valueOf(voltage2)) ;
		}
		
		this.sendRtuCommand(new CommandCreator().cd_F1(p, null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		
		Data_E1_F1 sd = (Data_E1_F1)d.subData ;
		item01_1.setText(sd.getVoltage1() + "") ;
		item01_2.setText(sd.getVoltage2() + "") ;
		
		Preferences.getInstance().putString(Constant.func_vk_01_080_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_01_080_item01_1(item01_1.getText().toString()) ;
		vo.setV_01_080_item01_2(item01_2.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01_1.setText(vo.getV_01_080_item01_1()) ;
		item01_2.setText(vo.getV_01_080_item01_2()) ;
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