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

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd10_50.Data_10_50;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_01_010  extends FrmParent {
	
	private final static int requestLen_1 = 6 ; 
	private final static int requestLen_2 = 5 ; 
	//private final static int requestLen_3 = 14 ; 

	private TextView title ;

	private EditText item01 ;
	private EditText item02 ;
	//private EditText item03 ;

	private ImageView btnSet1 ;
	//private ImageView btnSet2 ;
	private ImageView btnRead ;
	

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
		View view = inflater.inflate(R.layout.f_func_01_010, container, false);

		title = (TextView)view.findViewById(R.id.f_01_010_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_010_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_010_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_01_010_item01);
		item02 = (EditText)view.findViewById(R.id.func_01_010_item02);
		//item03 = (EditText)view.findViewById(R.id.func_01_010_item03);
		
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_1)});
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		//item03.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_3)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_010_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_010_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
	/*	str = Preferences.getInstance().getString(Constant.func_vk_01_010_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}*/
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_010_01));
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_010_02));
		
		/*item03.addTextChangedListener(new TextWatcher(){
			private int strOldLen = 0 ;
			@Override
			public void afterTextChanged(Editable edt) {
				String str = edt.toString() ;
				int strNowLen = str.length() ;
				if(strNowLen > strOldLen){
					//不是删除操作
					if(strOldLen % 3 == 2){
						String str1 = str.substring(0, strNowLen - 1) ;
						String str2 = str.substring(strNowLen - 1) ;
						str = str1 + " " + str2 ;
						item03.setText(str) ;
						item03.setSelection(str.length()) ;
					}
				}
				if (str == null || str.equals("")) {
					Preferences.getInstance().remove(Constant.func_vk_01_010_03);
				} else {
					Preferences.getInstance().putString(Constant.func_vk_01_010_03, str);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				strOldLen = item03.getText().toString().length() ;
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
		});*/
		
		btnSet1 = (ImageView)view.findViewById(R.id.btn_set);
		//btnSet2 = (ImageView)view.findViewById(R.id.btn_set_2);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet1.setOnClickListener(btnSetLisn);
		//btnSet2.setOnClickListener(btnSetLisn_);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_010_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	
	/*//设置按钮点击事件
	protected Button.OnClickListener btnSetLisn_ = new Button.OnClickListener(){
		public void onClick(View v) {
			if(checkBeforeSet_(true)){
				new DialogConfirm().showDialog(act,
						act.getResources().getString(R.string.txtConfirmSendSetCommand) ,
						new DialogConfirm.CallBackInterface(){
						@Override
						public void dialogCallBack(Object o) {
							if((Boolean)o){ 
								showLoadCover() ;
								setCommand_() ;
							}else{
							}
						}
				}) ;
			}
		}
	} ;*/
	
	
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
	 * 设置命令前进行检查
	 * @return
	 */
	/*protected boolean checkBeforeSet_(boolean showDialog){
		String hexId = item03.getText().toString() ;
		if(hexId == null || hexId.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "十六进制终端地址不能为空！") ;
			}
			return false ;
		} 
		hexId = hexId.replaceAll(" ", "") ;
		if(hexId.length() != 10){
			if(showDialog){
				new DialogAlarm().showDialog(act, "行政区编号必须为10位十六进制字符！") ;
			}
			return false ;
		} 
		
		return true ;
	}*/
	

	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_50(), true) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String regionNum = item01.getText().toString() ;
		String clientId = item02.getText().toString() ;
		
		this.sendRtuCommand(new CommandCreator().cd_10(regionNum, clientId, null), false) ;
	}
	
	/**
	 * 设置命令
	 *//*
	protected void setCommand_(){
		String hexId = item03.getText().toString() ;
		hexId = hexId.replaceAll(" ", "") ;
		
		this.sendRtuCommand(new CommandCreator().cd_10_(hexId, null), false) ;
	}*/
	
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
		
		Data_10_50 sd = (Data_10_50)d.subData ;
		String rtuId = sd.getRtuId() ;
		if(rtuId != null && rtuId.length() > 6){
			item01.setText(rtuId.substring(0, 6)) ;
			item02.setText(rtuId.substring(6)) ;
			//item03.setText(sd.getRtuIdHex()) ;
			//p.putString(Constant.func_vk_01_010_03, d.getRtuId_hex()) ;
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