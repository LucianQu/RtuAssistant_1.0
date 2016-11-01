package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdEC_FC.Param_FC;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_05_030  extends FrmParent {
	
	private TextView title ;

	protected CheckBox cb01_01_y, cb01_01_n,
					   cb01_02_y, cb01_02_n,
					   cb01_03_y, cb01_03_n,
					   cb01_04_y, cb01_04_n,
					   cb01_05_y, cb01_05_n,
					   
					   cb02_01_y, cb02_01_n,
					   cb02_02_y, cb02_02_n,
					   cb02_03_y, cb02_03_n,
					   cb02_04_y, cb02_04_n,
					   cb02_05_y, cb02_05_n,
					   cb02_06_y, cb02_06_n,
					   cb02_07_y, cb02_07_n,
					   cb02_08_y, cb02_08_n,
					   cb02_09_y, cb02_09_n,
					   cb02_10_y, cb02_10_n,
					   
					   cb03_01_y, cb03_01_n,
					   cb03_02_y, cb03_02_n,
					   cb03_03_y, cb03_03_n,
					   cb03_04_y, cb03_04_n,
					   cb03_05_y, cb03_05_n,
					   cb03_06_y, cb03_06_n ;
	private ImageView btnSet ;
	private ImageView btnRead ;
	
	protected Param_FC param ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_EC ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
		this.param = new Param_FC() ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_05_030, container, false);

		title = (TextView)view.findViewById(R.id.f_05_030_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_05_030_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_05_030_Load) ;

		F_05_030_HelpCreateView hcv = new F_05_030_HelpCreateView(this) ;
		hcv.findView(view) ;
		hcv.setOnCheckedChangeListener(onCheck) ;
		
		new F_05_030_HelpInitData(this).initData() ;
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_05_030_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	
	private CompoundButton.OnCheckedChangeListener onCheck = new CompoundButton.OnCheckedChangeListener(){
		F_05_030_HelpCheckBox hcb = new F_05_030_HelpCheckBox(F_05_030.this) ;
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
		return true ;
	}
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_EC(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		this.sendRtuCommand(new CommandCreator().cd_FC(this.param, null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		new F_05_030_HelpReceiveData(this).receiveRtuData(d) ;
		
		Preferences.getInstance().putString(Constant.func_vk_05_030_dt, this.resultDt.getText().toString()) ;
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
	   
	    if(cb02_01_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_02_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_03_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_04_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_05_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_06_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_07_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_08_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_09_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb02_10_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	   
	    if(cb03_01_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb03_02_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb03_03_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb03_04_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb03_05_y.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;} 
	    if(cb03_06_y.isChecked()){sb1.append("1") ;}else{sb1.append("0") ;} 
	    
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
									
									if(i == 5){cb02_01_y.setChecked(true);}
									if(i == 6){cb02_02_y.setChecked(true);}
									if(i == 7){cb02_03_y.setChecked(true);}
									if(i == 8){cb02_04_y.setChecked(true);}
									if(i == 9){cb02_05_y.setChecked(true);}
									if(i == 10){cb02_06_y.setChecked(true);}
									if(i == 11){cb02_07_y.setChecked(true);}
									if(i == 12){cb02_08_y.setChecked(true);}
									if(i == 13){cb02_09_y.setChecked(true);}
									if(i == 14){cb02_10_y.setChecked(true);}
									
									if(i == 15){cb03_01_y.setChecked(true);}
									if(i == 16){cb03_02_y.setChecked(true);}
									if(i == 17){cb03_03_y.setChecked(true);}
									if(i == 18){cb03_04_y.setChecked(true);}
									if(i == 19){cb03_05_y.setChecked(true);}
									if(i == 20){cb03_06_y.setChecked(true);}
								}else{
									if(i == 0){cb01_01_n.setChecked(true);} 
									if(i == 1){cb01_02_n.setChecked(true);}
									if(i == 2){cb01_03_n.setChecked(true);}
									if(i == 3){cb01_04_n.setChecked(true);}
									if(i == 4){cb01_05_n.setChecked(true);}
									
									if(i == 5){cb02_01_n.setChecked(true);}
									if(i == 6){cb02_02_n.setChecked(true);}
									if(i == 7){cb02_03_n.setChecked(true);}
									if(i == 8){cb02_04_n.setChecked(true);}
									if(i == 9){cb02_05_n.setChecked(true);}
									if(i == 10){cb02_06_n.setChecked(true);}
									if(i == 11){cb02_07_n.setChecked(true);}
									if(i == 12){cb02_08_n.setChecked(true);}
									if(i == 13){cb02_09_n.setChecked(true);}
									if(i == 14){cb02_10_n.setChecked(true);}
									
									if(i == 15){cb03_01_n.setChecked(true);}
									if(i == 16){cb03_02_n.setChecked(true);}
									if(i == 17){cb03_03_n.setChecked(true);}
									if(i == 18){cb03_04_n.setChecked(true);}
									if(i == 19){cb03_05_n.setChecked(true);}
									if(i == 20){cb03_06_n.setChecked(true);}
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