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
import com.blg.rtu.protocol.p206.cd4C_7C.Data_4C_7C;
import com.blg.rtu.protocol.p206.cd4C_7C.Param_4C;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;
import com.blg.rtu2.server.CoreThread;

public class F_08_130  extends FrmParent {
	private final static int requestLen_2 = 2 ; 
	private final static int requestLen_3 = 3 ; 
	private final static int requestLen_4 = 4 ; 
	private TextView title ;
	
	private EditText item01  ;
	private EditText item02  ;
	private EditText item03  ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_7C ;
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
		View view = inflater.inflate(R.layout.f_func_08_130, container, false);

		title = (TextView)view.findViewById(R.id.f_08_130_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_130_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_130_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_08_130_item01);
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_2)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_130_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}

		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_130_01)) ;
		//////
		item02 = (EditText)view.findViewById(R.id.func_08_130_item02);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_130_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_130_02)) ;
		/////
		item03 = (EditText)view.findViewById(R.id.func_08_130_item03);
		item03.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_3)});
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_130_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}
		
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_130_03));
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_130_dt) ;
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
		String collectTime = item01.getText().toString() ;//整数部分
		String collectCycle = item02.getText().toString() ;//整数部分
		String timeWin = item03.getText().toString() ;//整数部分
		///////
		if(collectTime == null || collectTime.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "LORA采集时间必须填写！") ;
			return false ;
		} 
		int collectT = Integer.valueOf(collectTime) ;
		if(collectT < 0 || collectT > 23){
			if(showDialog)new DialogAlarm().showDialog(act, "LORA采集时间值必须是0~23之间的数字！") ;
			return false ;
		}
		/////////
		if(collectCycle == null || collectCycle.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "LORA采集周期必须填写！") ;
			return false ;
		} 
		int collectC = Integer.valueOf(collectCycle) ;
		if(collectC < 0 || collectC > 1440){
			if(showDialog)new DialogAlarm().showDialog(act, "LORA采集周期必须是0~1440之间的数字！") ;
			return false ;
		}
		//////
		if(timeWin == null || timeWin.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "LORA时间配置窗口值必须填写！") ;
			return false ;
		} 
		
		int h = Integer.valueOf(timeWin) ;
		if(h < 6 || h > 255){
			if(showDialog)new DialogAlarm().showDialog(act, "LORA时间配置窗口值必须是6~255之间的数字！") ;
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
		this.sendRtuCommand(new CommandCreator().cd_7C(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String collectTime = item01.getText().toString() ;//整数部分
		String collectCycle = item02.getText().toString() ;//整数部分
		String timeWin = item03.getText().toString() ;//整数部分

		Param_4C p = new Param_4C() ;
		/////
		if(collectTime == null || collectTime.equals("")) {
			p.setLoraCollectTime(0) ;
		}else {
			p.setLoraCollectTime(Integer.valueOf(collectTime)) ;
		}
		/////
		if(collectCycle == null || collectCycle.equals("")) {
			p.setLoraCollectCycle(0) ;
		}else {
			p.setLoraCollectCycle(Integer.valueOf(collectCycle)) ;
		}
		/////
		if(timeWin == null || timeWin.equals("")){
			p.setLoraTimeWinSet(6) ;
		}else{
			p.setLoraTimeWinSet(Integer.valueOf(timeWin)) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_4C(p, null), false) ;
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
//		super.scrollTo(this.btnRead) ;
		
		Data_4C_7C sd = (Data_4C_7C)d.subData ;
		item01.setText(sd.getLoraCollectTime() + "") ;
		item02.setText(sd.getLoraCollectCycle() + "") ;
		item03.setText(sd.getLoraTimeWinSet() + "") ;
		
		Preferences.getInstance().putString(Constant.func_vk_08_130_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		//vo.setV_08_110_item01(item01.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		//item01.setText(vo.getV_08_110_item01()) ;
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