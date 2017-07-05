package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd45_75.Data_45_75;
import com.blg.rtu.protocol.p206.cd45_75.Param_45;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;
import com.blg.rtu2.server.CoreThread;

public class F_08_050  extends FrmParent {
	
	private TextView title ;
	private final static int requestLen3 = 4 ; 
	protected CheckBox cb01_01_y, cb01_01_n,
					   cb01_02_y, cb01_02_n,
					   cb01_03_y, cb01_03_n,
					   cb01_04_y, cb01_04_n,
					   cb01_05_y, cb01_05_n,
					   cb01_06_y, cb01_06_n,
					   cb01_07_y, cb01_07_n;
					  
	private EditText item02 ;
	private ImageView btnSet ;
	private ImageView btnRead ;
	
	protected Param_45 param ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_75 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
		this.param = new Param_45() ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_08_050, container, false);

		title = (TextView)view.findViewById(R.id.f_08_050_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_050_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_050_Load) ;

		F_08_050_HelpCreateView hcv = new F_08_050_HelpCreateView(this) ;
		hcv.findView(view) ;
		hcv.setOnCheckedChangeListener(onCheck) ;
		
		new F_08_050_HelpInitData(this).initData() ;
		
		item02 = (EditText)view.findViewById(R.id.func_08_050_item02_01);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen3)});
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_050_08_2));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_050_08_2) ;
		if(!str.equals(Constant.errorStr)){item02.setText(str);}
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_050_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	
	private CompoundButton.OnCheckedChangeListener onCheck = new CompoundButton.OnCheckedChangeListener(){
		F_08_050_HelpCheckBox hcb = new F_08_050_HelpCheckBox(F_08_050.this) ;
        @Override 
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        	hcb.onCheckedChanged(buttonView, isChecked) ;
        } 
    } ;
	

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
		String value = item02.getText().toString() ;//整数部分

		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "屏幕刷新间隔必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "屏幕刷新间隔必须是0~9999的数字！") ;
			return false ;
		}

		return true ;
	}
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_75(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String value = item02.getText().toString() ;//整数部分

		if(value == null || value.equals("")){
			this.param.setShowInterval0to9999(0) ;
		}else{
			this.param.setShowInterval0to9999(Integer.valueOf(value)) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_45(this.param, null), false) ;
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
		new F_08_050_HelpReceiveData(this).receiveRtuData(d) ;
		Data_45_75 sd = (Data_45_75)d.subData ;

		item02.setText("" + sd.getShowInterval());
	
		Preferences.getInstance().putString(Constant.func_vk_08_050_dt, this.resultDt.getText().toString()) ;
	}
	
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		StringBuffer sb1 = new StringBuffer() ;
		if(cb01_01_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb01_02_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb01_03_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb01_04_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb01_05_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	   
	    
		String s1 = sb1.toString() ;
		
		byte[] bs1 = s1.getBytes() ;
		
		String hex1 = ByteUtil.bytes2Hex(bs1, false) ;
		
		vo.setV_05_030_chechBoxs(hex1) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		try {
			String hex1 = vo.getV_05_030_chechBoxs() ;
			if(hex1 != null && !hex1.trim().equals("")){
				byte[] bs1 = ByteUtil.hex2Bytes(hex1) ;
				if(bs1 != null && bs1.length > 0 ){
					String s = new String(bs1) ;
					String[] ss = s.split(";") ;
					if(ss != null && ss.length > 0){
						for(int i = 0 ; i < ss.length ; i++){
							if(ss[i] != null && !ss[i].equals("")){
								if(ss[i].equals("1")){
									if(i == 0){cb01_01_y.setChecked(true);} 
									if(i == 1){cb01_02_y.setChecked(true);}
									if(i == 2){cb01_03_y.setChecked(true);}
									if(i == 3){cb01_04_y.setChecked(true);}
									if(i == 4){cb01_05_y.setChecked(true);}
									
								
								}else{
									if(i == 0){cb01_01_n.setChecked(true);} 
									if(i == 1){cb01_02_n.setChecked(true);}
									if(i == 2){cb01_03_n.setChecked(true);}
									if(i == 3){cb01_04_n.setChecked(true);}
									if(i == 4){cb01_05_n.setChecked(true);}
									
				
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
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