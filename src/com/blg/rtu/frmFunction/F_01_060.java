package com.blg.rtu.frmFunction;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd91.Data_91;
import com.blg.rtu.protocol.p206.cd91.Param_91;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_01_060  extends FrmParent {
	
	private TextView title ;
	
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private int spinnerPosition ;

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
		View view = inflater.inflate(R.layout.f_func_01_060, container, false);

		title = (TextView)view.findViewById(R.id.f_01_060_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_060_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_060_Load) ;
		
		item01 = (Spinner) view.findViewById(R.id.f_01_060_item1);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue();
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		item01.setAdapter(spinnerAdapter);
		item01.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_01_060_01) ;
		if(v != Constant.errorInt){
			item01.setSelection(v); 
		}
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ; 
		btnSet.setOnClickListener(btnSetLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_060_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	private void putSpinnerValue(){
		spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_0, "全部数据")) ;
		/*spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_1, "雨量数据")) ;
		spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_2, "水位数据")) ;*/
		spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_1, "流量数据")) ;
		/*spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_4, "水温数据")) ; 
		spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_5, "水质数据")) ;*/
		spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_2, "日志数据")) ; 
		spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_3, "事件数据")) ;
		/*spinnerAdapter.add(new SpinnerVO("" + Param_91.clearType_8, "四个中心补报数据")) ;*/
	}
	
	public class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition = position ;
			Preferences.getInstance().putInt(Constant.func_vk_01_060_01, position) ;
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
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
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		int type = spinnerPosition == 0 ? 0x64 : (spinnerPosition == 1 ? 0x04 : (spinnerPosition == 2 ? 0x20 : (spinnerPosition == 3 ? 0x40 : 0x64))) ;
		this.sendRtuCommand(new CommandCreator().cd_91((byte)type, null), false) ;
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		Data_91 sd = (Data_91)d.subData ;
		int type = sd.getClearType() ;
		String typeName = "" ;
		if(type == Param_91.clearType_0.intValue()){
			typeName = "清空全部数据" ;
		}else if(type == Param_91.clearType_1.intValue()){
			typeName = "清空遥测终端流量数据" ;
		}else if(type == Param_91.clearType_2.intValue()){
			typeName = "清空遥测终端日志数据" ;
		}else if(type == Param_91.clearType_3.intValue()){
			typeName = "清空遥测终端事件数据" ;
		}/*else if(type == Param_91.clearType_4.intValue()){
			typeName = "清空遥测终端水温数据" ;
		}else if(type == Param_91.clearType_5.intValue()){
			typeName = "清空遥测终端水质数据" ;
		}else if(type == Param_91.clearType_6.intValue()){
			typeName = "清空遥测终端日志数据" ;
		}else if(type == Param_91.clearType_7.intValue()){
			typeName = "清空遥测终端事件数据" ;
		}else if(type == Param_91.clearType_8.intValue()){
			typeName = "清空遥测终端四个中心补报数据" ;
		}*/
		
		item01.setSelection(type) ;

		Toast.makeText(act, typeName + "执行完毕！", Toast.LENGTH_LONG).show() ;
		
		Preferences.getInstance().putString(Constant.func_vk_01_060_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_01_060_item01(spinnerPosition) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01.setSelection(vo.getV_01_060_item01()); 
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