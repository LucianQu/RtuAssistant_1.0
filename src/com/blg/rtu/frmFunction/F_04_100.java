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
import com.blg.rtu.protocol.p206.cd15_55.Data_15;
import com.blg.rtu.protocol.p206.cd15_55.Data_55;
import com.blg.rtu.protocol.p206.cd15_55.Param_15;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class F_04_100  extends FrmParent {
	
	private final static int requestLen_8 = 8 ; 

	private TextView title ;

	private EditText item01  ;
	private TextView item02 ;
	
	

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_55 ;
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
		View view = inflater.inflate(R.layout.f_func_04_100, container, false);

		title = (TextView)view.findViewById(R.id.f_04_100_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_04_100_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_04_100_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_04_100_item01);
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_8)});
		
		item02 = (TextView)view.findViewById(R.id.func_04_100_item02);
		
		
		String str = Preferences.getInstance().getString(Constant.func_vk_04_100_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_04_100_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_100_01));
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_04_100_dt) ;
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
		String value = item01.getText().toString() ;//整数部分

		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "充值水量必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(value) ;
		if(v < 0 || v > 99999999){
			if(showDialog)new DialogAlarm().showDialog(act, "充值水量必须是0~99999999的数字！") ;
			return false ;
		}

		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_55(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String value = item01.getText().toString() ;//整数部分

		Param_15 p = new Param_15() ;
		if(value == null || value.equals("")){
			p.setWaterAmount_0to99999999(0) ;
		}else{
			p.setWaterAmount_0to99999999(Integer.valueOf(value)) ;
		}
		this.sendRtuCommand(new CommandCreator().cd_15(p, null), false) ;
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
//		super.scrollTo(this.btnRead) ;
		
		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_55){
				Data_55 sd = (Data_55)subD ;
				item01.setText(sd.getWaterAmount() + "") ;
				item02.setText(sd.getWaterRemain() + "") ;
			}else if(subD instanceof Data_15){
				Data_15 sd = (Data_15)d.subData ;
				item01.setText(sd.getWaterAmount() + "") ;
				item02.setText("") ;
			}
		}
		Preferences.getInstance().putString(Constant.func_vk_04_100_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		vo.setV_04_100_item01(item01.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		item01.setText(vo.getV_04_100_item01()) ;
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