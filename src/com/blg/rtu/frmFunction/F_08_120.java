package com.blg.rtu.frmFunction;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd4B_7B.Data_4B;
import com.blg.rtu.protocol.p206.cd4B_7B.Data_7B;
import com.blg.rtu.protocol.p206.cd4B_7B.Param_4B;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_08_120 extends FrmParent {
	
	private TextView title ;
	
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private int spinnerPosition ;
	
	private TextView item02 ;
	
	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_7B ;
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
		View view = inflater.inflate(R.layout.f_func_08_120, container, false);

		title = (TextView)view.findViewById(R.id.f_08_120_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_120_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_120_Load) ;
		
		item01 = (Spinner) view.findViewById(R.id.f_08_120_item1);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		this.putSpinnerValue();
		item01.setAdapter(spinnerAdapter);
		item01.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_08_120_01) ;
		if(v != Constant.errorInt){
			item01.setSelection(v); 
		}
		
		item02 = (TextView)view.findViewById(R.id.func_08_120_item02) ;
		String str = Preferences.getInstance().getString(Constant.func_vk_08_120_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str) ;
		}
		
		
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_120_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	private void putSpinnerValue(){
		spinnerAdapter.add(new SpinnerVO("" + Param_4B.triggerType0, "GSM测试")) ;
		spinnerAdapter.add(new SpinnerVO("" + Param_4B.triggerType1, "LORA测试")) ;
	}
	
	public class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition = position ;
			Preferences.getInstance().putInt(Constant.func_vk_08_120_01, position) ;
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
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_7B(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator()
		.cd_4B(Integer.valueOf(spinnerAdapter.getItem(spinnerPosition).getId()), null), false) ;
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

		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_4B){
				Data_4B sd = (Data_4B)subD ;
				item01.setSelection(sd.getTriggerType()); 
				item02.setText("") ;
			}else if(subD instanceof Data_7B){
				Data_7B sd = (Data_7B)subD ;
				item02.setText(sd.getQueryResult() + "") ;
			}
		}
		
		
		Preferences.getInstance().putString(Constant.func_vk_08_120_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		//vo.setV_02_010_item01(spinnerPosition) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		//item01.setSelection(vo.getV_02_010_item01()); 
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
