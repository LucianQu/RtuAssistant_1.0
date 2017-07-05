package com.blg.rtu.frmFunction;


import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdA0_54.Param_A0;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
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

public class F_04_070 extends FrmParent {
	
	private TextView title ;
	
	protected CheckBox cb01, cb02, cb03, cb04, cb05, cb06, cb07, cb08, cb09, 
						cb10, cb11, cb12, cb13, cb14, cb15 ;
						
	private ImageView btnSet ;
	private ImageView btnRead ;
	
	protected Resources rs  ;
	
	protected Param_A0 param ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.rs = this.act.getResources() ;
		this.queryCommandCode = Code206.cd_54 ;
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
		View view = inflater.inflate(R.layout.f_func_04_070, container, false);

		title = (TextView)view.findViewById(R.id.f_04_070_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_04_070_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_04_070_Load) ;
		
		F_04_070_HelpCreateView hcv = new F_04_070_HelpCreateView(this) ;
		hcv.findView(view) ;
		hcv.setOnCheckedChangeListener(onCheck) ;
		
		this.initData();
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_04_070_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	private CompoundButton.OnCheckedChangeListener onCheck = new CompoundButton.OnCheckedChangeListener(){
		F_04_070_HelpCheckBox hcb = new F_04_070_HelpCheckBox(F_04_070.this) ;
        @Override 
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        	hcb.onCheckedChanged(buttonView, isChecked) ;
        } 
    } ;
    
    private void initData(){
    	new F_04_070_HelpInitData(this).initData() ;
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
		return new F_04_070_HelpCheckBeforeSet(this).checkBeforeSet(showDialog) ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_54(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		this.sendRtuCommand(new CommandCreator().cd_A0(this.param, null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		new F_04_070_HelpReceiveData(this).receiveRtuData(d) ;
		
		Preferences.getInstance().putString(Constant.func_vk_04_070_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		StringBuffer sb1 = new StringBuffer() ;
		if(cb01.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb02.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb03.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb04.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb05.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb06.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb07.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb08.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb09.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb10.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb11.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb12.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb13.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb14.isChecked()){sb1.append("1;") ;}else{sb1.append("0;") ;}
		if(cb15.isChecked()){sb1.append("1") ;}else{sb1.append("0") ;}

		String s1 = sb1.toString() ;
		
		byte[] bs1 = s1.getBytes() ;
		
		String hex1 = ByteUtil.bytes2Hex(bs1, false) ;
		
		vo.setV_04_070_chechBoxs(hex1) ;
		
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		try {
			String hex1 = vo.getV_04_070_chechBoxs() ;
			if(hex1 != null && !hex1.trim().equals("") ){
				byte[] bs1 = ByteUtil.hex2Bytes(hex1) ;
				if(bs1 != null && bs1.length > 0 ){
					String s = new String(bs1) ;
					String[] ss = s.split(";") ;
					if(ss != null && ss.length > 0){
						for(int i = 0 ; i < ss.length ; i++){
							if(ss[i] != null && !ss[i].equals("")){
								if(ss[i].equals("1")){
									if(i == 0){cb01.setChecked(true);} 
									if(i == 1){cb02.setChecked(true);}
									if(i == 2){cb03.setChecked(true);}
									if(i == 3){cb04.setChecked(true);}
									if(i == 4){cb05.setChecked(true);}
									if(i == 5){cb06.setChecked(true);}
									if(i == 6){cb07.setChecked(true);}
									if(i == 7){cb08.setChecked(true);}
									if(i == 8){cb09.setChecked(true);}
									if(i == 9){cb10.setChecked(true);}
									if(i == 10){cb11.setChecked(true);}
									if(i == 11){cb12.setChecked(true);}
									if(i == 12){cb13.setChecked(true);}
									if(i == 13){cb14.setChecked(true);}
									if(i == 14){cb15.setChecked(true);}
								}else{
									if(i == 0){cb01.setChecked(false);} 
									if(i == 1){cb02.setChecked(false);}
									if(i == 2){cb03.setChecked(false);}
									if(i == 3){cb04.setChecked(false);}
									if(i == 4){cb05.setChecked(false);}
									if(i == 5){cb06.setChecked(false);}
									if(i == 6){cb07.setChecked(false);}
									if(i == 7){cb08.setChecked(false);}
									if(i == 8){cb09.setChecked(false);}
									if(i == 9){cb10.setChecked(false);}
									if(i == 10){cb11.setChecked(false);}
									if(i == 11){cb12.setChecked(false);}
									if(i == 12){cb13.setChecked(false);}
									if(i == 13){cb14.setChecked(false);}
									if(i == 14){cb15.setChecked(false);}
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
