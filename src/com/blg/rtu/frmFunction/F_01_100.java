package com.blg.rtu.frmFunction;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd44_74.DataList_44_74;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_01_100  extends FrmParent {
	
	private final static int requestLen_1 = 6 ; 
	private final static int requestLen_2 = 5 ; 
	//private final static int requestLen_3 = 14 ; 

	private TextView title ;

	private EditText item01 ;
	private EditText item02 ;

	private ImageView btnSet1 ;
	private ImageView btnRead ;
	
	private Spinner item03;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	//private int spinnerPosition ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_50 ;
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
		View view = inflater.inflate(R.layout.f_func_01_100, container, false);

		title = (TextView)view.findViewById(R.id.f_01_100_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_100_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_100_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_01_100_item01);
		item02 = (EditText)view.findViewById(R.id.func_01_100_item02);
		
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_1)});
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_100_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_100_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		item03 = (Spinner)view.findViewById(R.id.f_01_100_item3);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		item03.setAdapter(spinnerAdapter);
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_010_01));
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_010_02));
		
		
		btnSet1 = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet1.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_100_dt) ;
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
		return true ;
	}
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeSet(boolean showDialog){
		String regionNum = item01.getText().toString() ;
		String clientId = item02.getText().toString() ;
		if(regionNum == null || regionNum.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "行政区编号不能为空！") ;
			}
			return false ;
		} 
		if(regionNum.length() != 6){
			if(showDialog){
				new DialogAlarm().showDialog(act, "行政区编号必须为6位数字！") ;
			}
			return false ;
		} 
		if(clientId == null || clientId.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "终端地址不能为空！") ;
			}
			return false ;
		} 
		int len = clientId.length() ;
		if(len < requestLen_2){
			int n = requestLen_2 - len ;
			for(int i = n ; i > 0 ; i--){
				clientId = "0" + clientId ;
			}
			item02.setText(clientId) ;
		}
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_74(), true) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String regionNum = item01.getText().toString() ;
		String clientId = item02.getText().toString() ;
		//String selectId = item03.getSelectedItem().toString();
		int position = item03.getSelectedItemPosition();
		this.sendRtuCommand(new CommandCreator().cd_44(position,regionNum, clientId, null), false) ;
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
		
		Preferences p = Preferences.getInstance() ;
		
		DataList_44_74 sd = (DataList_44_74)d.subData ;
		spinnerAdapter.clear() ;
		
		for(int i = 0; i < 9; i++) {
			if(i == 0) {
				spinnerAdapter.add(new SpinnerVO("" + i, "中继器  地址："+ sd.getRtuId().get(i))) ;
			}else{
				spinnerAdapter.add(new SpinnerVO("" + i, i + "号水表地址："+ sd.getRtuId().get(i))) ;
			}
			
		}
		
		p.putString(Constant.func_vk_01_010_dt, this.resultDt.getText().toString()) ;
	}
	
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_01_010_clientId(item01.getText().toString()) ;
		vo.setV_01_010_regionNum(item02.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01.setText(vo.getV_01_010_clientId()) ;
		item02.setText(vo.getV_01_010_regionNum()) ;
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