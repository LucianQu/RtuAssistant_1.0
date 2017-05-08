package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd41.Data_41;
import com.blg.rtu.protocol.p206.cd41.Param_41;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_08_020  extends FrmParent {
	private final static int requestLen  = 5 ; 
	
	private TextView title ;

	//private EditText item01 ;
	private EditText item02 ;

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
		View view = inflater.inflate(R.layout.f_func_08_020, container, false);

		title = (TextView)view.findViewById(R.id.f_08_020_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_020_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_020_Load) ;
		
		//item01 = (EditText)view.findViewById(R.id.func_08_020_item01);
		item02 = (EditText)view.findViewById(R.id.func_08_020_item02);
		
	/*	item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen)});
		
		int pass = Preferences.getInstance().getInt(Constant.func_vk_08_020_01) ;
		if(pass != Constant.errorInt){
			item01.setText(pass + ""); 
		}*/
		
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen)});
		
		int pass = Preferences.getInstance().getInt(Constant.func_vk_08_020_02) ;
		if(pass != Constant.errorInt){
			item02.setText(pass + ""); 
		}
		
//		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_02_080_01));
		/*
		item01.addTextChangedListener(new TextWatcher(){
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
						item01.setText(str) ;
						item01.setSelection(str.length()) ;
					}
				}
				if (str == null || str.equals("")) {
					Preferences.getInstance().remove(Constant.func_vk_08_020_01);
				} else {
					Preferences.getInstance().putString(Constant.func_vk_08_020_01, str);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				strOldLen = item01.getText().toString().length() ;
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
		});*/
		
		item02.addTextChangedListener(new TextWatcher(){
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
						item02.setText(str) ;
						item02.setSelection(str.length()) ;
					}
				}
				if (str == null || str.equals("")) {
					Preferences.getInstance().remove(Constant.func_vk_08_020_02);
				} else {
					Preferences.getInstance().putString(Constant.func_vk_08_020_02, str);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				strOldLen = item02.getText().toString().length() ;
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
		});
		
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_020_dt) ;
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
		//String pass = item01.getText().toString() ; 
		String pass1 = item02.getText().toString() ;
		
	/*	if(pass == null || pass.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "旧密码必须填写！") ;
			}
			return false ;
		} */
		if(pass1 == null || pass1.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "新密码必须填写！") ;
			}
			return false ;
		} 
		
		//pass = pass.replaceAll(" ", "") ;
		pass1 = pass1.replaceAll(" ", "") ;
		
	/*	if(pass.length() != 4){
			if(showDialog){
				new DialogAlarm().showDialog(act, "旧密码必须是四位十六进制数！") ;
			}
			return false ;
		}*/
		
		if(pass1.length() != 4){
			if(showDialog){
				new DialogAlarm().showDialog(act, "新密码必须是四位十六进制数！") ;
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
		//String pass = item01.getText().toString() ; 
		String pass1 = item02.getText().toString() ; 
		//pass = pass.replaceAll(" ", "") ;
		pass1 = pass1.replaceAll(" ", "") ;

		Param_41 p = new Param_41() ;
		//p.setNewPass_0to9999(Integer.valueOf(pass)) ;
		//p.setOldPassword(pass) ;
		p.setNewPassword(pass1) ;
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_41(p, null), false) ;
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
	}
	/**
	 * 功能项右侧图标复原
	 */
	@Override
	public void resetLabelImg(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		Data_41 sd = (Data_41)d.subData ;
		
	/*	String oldPassword = sd.getOldPassword() ;
		item01.setText(oldPassword) ;
		*/
		String newPassword = sd.getNewPassword() ;
		item02.setText(newPassword) ;
		//把系统默认密码改了
//		StringValueForServer.defaultPassword = sd.getPassword() ;
		//StringValueForServer.setDefaultPasswordHex(oldPassword) ;
		
		Preferences.getInstance().putString(Constant.func_vk_08_020_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		//vo.setV_08_020_item01(item01.getText().toString()) ;
		vo.setV_08_020_item02(item02.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		//item01.setText(vo.getV_08_020_item01());
		item02.setText(vo.getV_08_020_item02());
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