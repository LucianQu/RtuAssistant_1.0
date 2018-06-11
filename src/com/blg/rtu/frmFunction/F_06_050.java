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
import com.blg.rtu.protocol.p206.cd23.Data_23;
import com.blg.rtu.protocol.p206.cd23.Param_23;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;
import com.blg.rtu3.server.CoreThread;

public class F_06_050  extends FrmParent {
	
	private final static int requestLen_2 = 2 ; 

	private TextView title ;

	private EditText item01  ;
	private EditText item02  ;
	private TextView item03 ;
	
	

	//private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_23 ;
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
		View view = inflater.inflate(R.layout.f_func_06_050, container, false);

		title = (TextView)view.findViewById(R.id.f_06_050_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_06_050_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_06_050_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_06_050_item01);
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		
		item02 = (EditText)view.findViewById(R.id.func_06_050_item02);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		
		item03 = (TextView)view.findViewById(R.id.func_06_050_item03);
		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_06_050_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_06_050_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_050_01));
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_050_02));
		
		//btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		//btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_06_050_dt) ;
		if(!str.equals(Constant.errorStr)){
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
		String year = item01.getText().toString() ;//整数部分
		String month = item02.getText().toString() ;//整数部分

		if(year == null || year.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "选择年必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(year) ;
		if(v < 0 || v > 99){
			if(showDialog)new DialogAlarm().showDialog(act, "选择年必须是0~99的数字！") ;
			return false ;
		}
		if(month == null || month.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "选择月必须填写！") ;
			return false ;
		} 
		
		v = Integer.valueOf(month) ;
		if(v < 1 || v > 12){
			if(showDialog)new DialogAlarm().showDialog(act, "选择年必须是1~12的数字！") ;
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
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		String year = item01.getText().toString() ;//整数部分
		String month = item02.getText().toString() ;//整数部分
	
		Param_23 p = new Param_23() ;
		p.setQueryYear(Integer.valueOf(year)) ;
		p.setQueryMonth(Integer.valueOf(month)) ;

		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_23(p, null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		
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
//		super.scrollTo(this.btnRead) ;
		
		Data_23 sd = (Data_23)d.subData ;
		item01.setText(sd.getQueryYear() + "") ;
		item02.setText(sd.getQueryMonth() + "") ;
	
		item03.setText(sd.getMonthUseWater() + "") ;
		
		Preferences.getInstance().putString(Constant.func_vk_06_050_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		//vo.setV_06_050_item01(item01.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		//item01.setText(vo.getV_06_050_item01()) ;
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