package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd5E.Data_5E;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_05_020  extends FrmParent {
	
	private TextView title ;

	//private TextView item01 ;//工作交流电停电告警
	private TextView item02 ;					//蓄电池电压报警
	/*private TextView item03 ;//水位超限报警
	private TextView item04 ;//流量超限报警
	private TextView item05 ;//水质超限报警
*/	private TextView item06 ;					//流量仪表故障报警
/*	private TextView item07 ;//水泵开停状态
	private TextView item08 ;//水位仪表故障报警
	private TextView item09 ;//水压超限报警
	private TextView item10 ;//水温仪表故障报警
	private TextView item11 ;//终端IC卡功能报警
	private TextView item12 ;//定制控制报警
	private TextView item13 ;//剩余水量的下限报警
	private TextView item14 ;//终端箱门状态报警
	*/
	private TextView item21 ;//流量仪表反向报警
	
	private TextView item15 ;//终端工作模式
	/*	//数据域后两个字节
		//D0,D1--终端的工作模式。	00H,终端在自报、遥测工作状态；
								01H,遥测终端在自报确认工作状态
		 * 						02H,终端在遥测工作状态
		 * 						03H,终端在调试或维修状态
		 * D2-D15备用
		 * 
	private TextView item16 ;//IC卡功能是否有效
	private TextView item17 ;//定制控制是否投入
	private TextView item18 ;//水泵工作状态
	private TextView item19 ;//终端箱门状态
	private TextView item20 ;//电源工作状态
*/
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_5E ;
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
		View view = inflater.inflate(R.layout.f_func_05_020, container, false);

		title = (TextView)view.findViewById(R.id.f_05_020_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_05_020_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_05_020_Load) ;
		
		item15 = (TextView)view.findViewById(R.id.func_05_020_item15);
		
		//item01 = (TextView)view.findViewById(R.id.func_05_020_item01);
		item02 = (TextView)view.findViewById(R.id.func_05_020_item02);
		/*item03 = (TextView)view.findViewById(R.id.func_05_020_item03);
		item04 = (TextView)view.findViewById(R.id.func_05_020_item04);
		item05 = (TextView)view.findViewById(R.id.func_05_020_item05);*/
		item06 = (TextView)view.findViewById(R.id.func_05_020_item06);
		/*item07 = (TextView)view.findViewById(R.id.func_05_020_item07);
		item08 = (TextView)view.findViewById(R.id.func_05_020_item08);
		item09 = (TextView)view.findViewById(R.id.func_05_020_item09);
		item10 = (TextView)view.findViewById(R.id.func_05_020_item10);
		item11 = (TextView)view.findViewById(R.id.func_05_020_item11);
		item12 = (TextView)view.findViewById(R.id.func_05_020_item12);
		item13 = (TextView)view.findViewById(R.id.func_05_020_item13);
		item14 = (TextView)view.findViewById(R.id.func_05_020_item14);*/
	
		/*item16 = (TextView)view.findViewById(R.id.func_05_020_item16);
		item17 = (TextView)view.findViewById(R.id.func_05_020_item17);
		item18 = (TextView)view.findViewById(R.id.func_05_020_item18);
		item19 = (TextView)view.findViewById(R.id.func_05_020_item19);
		item20 = (TextView)view.findViewById(R.id.func_05_020_item20);*/
		item21 = (TextView)view.findViewById(R.id.func_05_020_item21);
		
		
		String /*str = Preferences.getInstance().getString(Constant.func_vk_05_020_01) ;
		if(!str.equals(Constant.errorStr)){ item01.setText(str); }*/
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_15) ;
		if(!str.equals(Constant.errorStr)){ item15.setText(str); }
		
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_02) ;
		if(!str.equals(Constant.errorStr)){ item02.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_03) ;
		/*if(!str.equals(Constant.errorStr)){ item03.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_04) ;
		if(!str.equals(Constant.errorStr)){ item04.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_05) ;
		if(!str.equals(Constant.errorStr)){ item05.setText(str); }*/
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_06) ;
		if(!str.equals(Constant.errorStr)){ item06.setText(str); }
		/*str = Preferences.getInstance().getString(Constant.func_vk_05_020_07) ;
		if(!str.equals(Constant.errorStr)){ item07.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_08) ;
		if(!str.equals(Constant.errorStr)){ item08.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_09) ;
		if(!str.equals(Constant.errorStr)){ item09.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_10) ;
		if(!str.equals(Constant.errorStr)){ item10.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_11) ;
		if(!str.equals(Constant.errorStr)){ item11.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_12) ;
		if(!str.equals(Constant.errorStr)){ item12.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_13) ;
		if(!str.equals(Constant.errorStr)){ item13.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_14) ;
		if(!str.equals(Constant.errorStr)){ item14.setText(str); }*/
		
		/*str = Preferences.getInstance().getString(Constant.func_vk_05_020_16) ;
		if(!str.equals(Constant.errorStr)){ item16.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_17) ;
		if(!str.equals(Constant.errorStr)){ item17.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_18) ;
		if(!str.equals(Constant.errorStr)){ item18.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_19) ;
		if(!str.equals(Constant.errorStr)){ item19.setText(str); }
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_20) ;
		if(!str.equals(Constant.errorStr)){ item20.setText(str); }*/
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_21) ;
		if(!str.equals(Constant.errorStr)){ item21.setText(str); }
		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_05_020_dt) ;
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
		return true ;
	}
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_5E(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
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
		Preferences p = Preferences.getInstance() ;
		Data_5E sd = (Data_5E)d.subData ;
		
		//int n01 = sd.getPower220StopAlarm() ;//工作交流电停电告警；(0未发生报警，1发生报警)
		int n02 = sd.getStorePowerLowVoltageAlarm() ;//蓄电池电压报警；(0未发生报警，1发生报警)
		/*int n03 = sd.getWaterLevelAlarm() ;//水位上下限报警；(0未发生报警，1发生报警)
		int n04 = sd.getWaterAmountOverAlarm() ;//流量超限报警； (0未发生报警，1发生报警)
		int n05 = sd.getWaterQualityOverAlarm() ;//水质超限报警； (0未发生报警，1发生报警)
*/		int n06 = sd.getWaterAmountMeterAlarm() ;//流量仪表故障报警； (0未发生报警，1发生报警)
	/*	int n07 = sd.getPumpStartStopAlarm() ;//水泵开停状态；(0未发生报警，1发生报警)
		int n08 = sd.getWaterLevelMeterAlarm() ;//水位仪表故障报警； (0未发生报警，1发生报警)
		int n09 = sd.getWaterPressOverAlarm() ;//水压超限报警； (0未发生报警，1发生报警)
		int n10 = sd.getWaterTemperatureAlarm();//水温仪表故障报警； (0未发生报警，1发生报警)
		int n11 = sd.getIcCardAlarm() ;//终端 IC 卡功能报警； (0未发生报警，1发生报警)
		int n12 = sd.getBindValueControlAlarm() ;//定值控制报警； (0未发生报警，1发生报警)
		int n13 = sd.getWaterRemainAlarm() ;//剩余水量的下限报警； (0未发生报警，1发生报警)
		int n14 = sd.getBoxDoorAlarm() ;//终端箱门状态报警；(0未发生报警，1发生报警)
*/		int n21 = sd.getWaterMeterAlarm() ;//流量仪表反向报警

		int n15 = sd.getModelStatus() ;//终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态；
		/*int n16 = sd.getIcCardStatus() ;//终端 IC 卡功能是否有效。0：无效；1：有效； 
		int n17 = sd.getBindValueStatus() ;//定值控制是否投入。0：退出；1：投入； 
		int n18 = sd.getPumpStatus() ;//水泵工作状态。 0：启动；1：停止； 
		int n19 = sd.getBoxDoorStatus() ;//终端箱门状态。0：开启；1：关闭； 
		int n20 = sd.getPowerStatus() ;//电源工作状态。0：AC220V 供电；1：蓄电池供电； 
*/		
		p.putString(Constant.func_vk_05_020_15, (n15 == 0?"自报遥测":(n15 == 1?"自报确认":(n15 == 2?"遥测":(n15 == 3?"调试维修":""))))) ;
		//p.putString(Constant.func_vk_05_020_01, n01 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_02, n02 == 1?"报警":"无") ;
		/*p.putString(Constant.func_vk_05_020_03, n03 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_04, n04 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_05, n05 == 1?"报警":"无") ;*/
		p.putString(Constant.func_vk_05_020_06, n06 == 1?"报警":"无") ;
		/*p.putString(Constant.func_vk_05_020_07, n07 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_08, n08 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_09, n09 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_10, n10 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_11, n11 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_12, n12 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_13, n13 == 1?"报警":"无") ;
		p.putString(Constant.func_vk_05_020_14, n14 == 1?"报警":"无") ;*/
		p.putString(Constant.func_vk_05_020_21, n21 == 1?"报警":"无") ;
		
		
		/*
		p.putString(Constant.func_vk_05_020_16, n16 == 1?"有效":"无效") ;
		p.putString(Constant.func_vk_05_020_17, n17 == 1?"投入":"退出") ;
		p.putString(Constant.func_vk_05_020_18, n18 == 1?"停止":"启动") ;
		p.putString(Constant.func_vk_05_020_19, n19 == 1?"关闭":"开启") ;
		p.putString(Constant.func_vk_05_020_20, n20 == 1?"蓄电池":"220V") ;*/
		
		//this.item01.setText(n01 == 1?"报警":"无") ;
		
		this.item15.setText(n15 == 0?"自报遥测":(n15 == 1?"自报确认":(n15 == 2?"遥测":(n15 == 3?"调试维修":"")))) ;
		this.item02.setText(n02 == 1?"报警":"无") ;
		/*this.item03.setText(n03 == 1?"报警":"无") ;
		this.item04.setText(n04 == 1?"报警":"无") ;
		this.item05.setText(n05 == 1?"报警":"无") ;*/
		this.item06.setText(n06 == 1?"报警":"无") ;
	/*	this.item07.setText(n07 == 1?"报警":"无") ;
		this.item08.setText(n08 == 1?"报警":"无") ;
		this.item09.setText(n09 == 1?"报警":"无") ;
		this.item10.setText(n10 == 1?"报警":"无") ;
		this.item11.setText(n11 == 1?"报警":"无") ;
		this.item12.setText(n12 == 1?"报警":"无") ;
		this.item13.setText(n13 == 1?"报警":"无") ;
		this.item14.setText(n14 == 1?"报警":"无") ;*/
		
		this.item21.setText(n21 == 1?"报警":"无") ;
		
		
		/*
		this.item16.setText(n16 == 1?"有效":"无效") ;
		this.item17.setText(n17 == 1?"投入":"退出") ;
		this.item18.setText(n18 == 1?"停止":"启动") ;
		this.item19.setText(n19 == 1?"关闭":"开启") ;
		this.item20.setText(n20 == 1?"蓄电池":"220V") ;*/
	
		
		Preferences.getInstance().putString(Constant.func_vk_05_020_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		
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