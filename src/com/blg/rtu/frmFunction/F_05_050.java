package com.blg.rtu.frmFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdB0.DataMap_B0;
import com.blg.rtu.protocol.p206.cdB0.DataVO;
import com.blg.rtu.protocol.p206.cdB0.Param_B0;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

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
import android.widget.AdapterView.OnItemSelectedListener;

public class F_05_050 extends FrmParent {
	
	private TextView title ;
	
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private int spinnerPosition ;
	
	private ImageView btnRead ;
	
	private LinearLayout dataContain ;
	private LinearLayout alarmContain ;
	
	private HashMap<String, F_05_050_HelpData.Node> dataNodes ;
	private F_05_050_HelpAlarm.Node alarmNode ; 

	private static final int commonId = 1000 ;
	private static final int firstIndex = 1 ;
	private static int newIndex = 0 ;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.dataNodes = new HashMap<String, F_05_050_HelpData.Node>() ;
		this.queryCommandCode = Code206.cd_B0 ;
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
		View view = inflater.inflate(R.layout.f_func_05_050, container, false);

		title = (TextView)view.findViewById(R.id.f_05_050_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_05_050_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_05_050_Load) ;

		//放在前面，后面接着用到它
		dataContain = (LinearLayout)view.findViewById(R.id.f_05_050_DataContain) ;
		alarmContain = (LinearLayout)view.findViewById(R.id.f_05_050_alarmContain) ;
		
		newIndex = firstIndex ;
		this.initDataNode() ;
		this.initAlarmNode() ;
		
		item01 = (Spinner) view.findViewById(R.id.f_05_050_item1);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue();
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		item01.setAdapter(spinnerAdapter);
		item01.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_05_050_01) ;
		if(v != Constant.errorInt){
			item01.setSelection(v); 
		}
		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnRead.setOnClickListener(btnReadLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_05_050_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	private void putSpinnerValue(){
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_1, "雨量参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_2, "水位参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_3, "流量（水量）参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_4, "流速参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_5, "闸位参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_6, "功率参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_7, "气压参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_8, "风速参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_9, "水温参数")) ;
		//spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_10, "水质参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_11, "土壤含水率参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_12, "蒸发量参数")) ;
		//spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_13, "报警或状态参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_14, "综合参数")) ;
		spinnerAdapter.add(new SpinnerVO("" + com.blg.rtu.protocol.p206.util.Constant.Up_ControlFunCode_15, "水压参数")) ;
	}
	
	public class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition = position ;
			Preferences.getInstance().putInt(Constant.func_vk_05_050_01, position) ;
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
		int n = Integer.valueOf(spinnerAdapter.getItem(spinnerPosition).getId()) ;
		Param_B0 param = new Param_B0() ;
		param.setDataType(n) ;
		
		this.sendRtuCommand(new CommandCreator().cd_B0(param, null), false) ;
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
		DataMap_B0 subD = (DataMap_B0)d.getSubData() ;

		//首先删除以前的界面数据
		this.removeAllDataNode();
		this.removeAllAlarmNode();

		if(subD != null){
			TreeMap<Integer, Object> dataMap = subD.getDataMap() ;
			if(dataMap != null && dataMap.size() > 0){
				int index = 1 ;//协议实现是从1开始
				DataVO data = (DataVO)dataMap.get(index) ;
				while(data != null){
					this.createDataNode(data) ;
					index++ ;
					if(data.fengXiang != null){
						this.createFengXiangNode(data) ;
					}
					data = (DataVO)dataMap.get(index) ;
				}
			}
			this.createAlarmNode(subD) ;
		}
		
		Preferences.getInstance().putString(Constant.func_vk_05_050_dt, this.resultDt.getText().toString()) ;
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
	
	//////////////////////////////////////////////
	//以下业务逻辑 
	private void initDataNode(){
		F_05_050_HelpData help = new F_05_050_HelpData(this.act) ;

		int id = newIndex * commonId ;

		Preferences pre = Preferences.getInstance() ;
		String str = pre.getString(Constant.func_vk_05_050_ + (id + 1)) ;
		while(!str.equals(Constant.errorStr)){
			F_05_050_HelpData.Node node = help.createNode(newIndex, id + 1, null) ;
			help.addNode(dataContain, node) ;
			dataNodes.put("" + newIndex, node) ;
			newIndex++ ;
			id = newIndex * commonId ;
			str = pre.getString(Constant.func_vk_05_050_ + (id + 1)) ;
		}
	}
	
	private void initAlarmNode(){
		F_05_050_HelpAlarm help = new F_05_050_HelpAlarm(this.act) ;

		Preferences pre = Preferences.getInstance() ;
		Integer alarm = pre.getInt(Constant.func_vk_05_050_alarm_ + "01") ;
		if(alarm != Constant.errorInt){
			alarmNode = help.initNode() ;
			help.addNode(alarmContain, alarmNode) ;
		}
	}
	private void createDataNode(DataVO d){
		F_05_050_HelpData help = new F_05_050_HelpData(this.act) ;

		int id = newIndex * commonId ;
		String txt = d.dataName + "：" + (d.valueDbl==null?(d.valueLng==null?"":d.valueLng): d.valueDbl) + "(" +d.valueUnit + ")" ;
		F_05_050_HelpData.Node node = help.createNode(newIndex, id + 1, txt) ; 
		help.addNode(dataContain, node) ;
		dataNodes.put("" + newIndex, node) ;
		newIndex++ ;
	}
	private void createFengXiangNode(DataVO d){
		F_05_050_HelpData help = new F_05_050_HelpData(this.act) ;

		int id = newIndex * commonId ;
		String txt = "风向：" + d.fengXiang ;
		F_05_050_HelpData.Node node = help.createNode(newIndex, id + 1, txt) ; 
		help.addNode(dataContain, node) ;
		dataNodes.put("" + newIndex, node) ;
		newIndex++ ;
	}
	
	
	private void createAlarmNode(DataMap_B0 d){
		if(d.getPower220StopAlarm() != null){
			//说明是查询命令结果
			F_05_050_HelpAlarm help = new F_05_050_HelpAlarm(this.act) ;
			this.alarmNode = help.createNode(
					d.getPower220StopAlarm(),//工作交流电停电告警；(0未发生报警，1发生报警)
					d.getStorePowerLowVoltageAlarm(),//蓄电池电压报警；(0未发生报警，1发生报警)
					d.getWaterLevelAlarm(),//水位上下限报警；(0未发生报警，1发生报警)
					d.getWaterAmountOverAlarm(),//流量超限报警； (0未发生报警，1发生报警)
					d.getWaterQualityOverAlarm(),//水质超限报警； (0未发生报警，1发生报警)
					d.getWaterAmountMeterAlarm(),//流量仪表故障报警； (0未发生报警，1发生报警)
					d.getPumpStartStopAlarm(),//水泵开停状态；(0未发生报警，1发生报警)
					d.getWaterLevelMeterAlarm(),//水位仪表故障报警； (0未发生报警，1发生报警)
					d.getWaterPressOverAlarm(),//水压超限报警； (0未发生报警，1发生报警)
					d.getWaterTemperatureAlarm(),//水温仪表故障报警； (0未发生报警，1发生报警)
					d.getIcCardAlarm(),//终端 IC 卡功能报警； (0未发生报警，1发生报警)
					d.getBindValueControlAlarm(),//定值控制报警； (0未发生报警，1发生报警)
					d.getWaterRemainAlarm(),//剩余水量的下限报警； (0未发生报警，1发生报警)
					d.getBoxDoorAlarm(),//终端箱门状态报警；(0未发生报警，1发生报警)
					d.getModelStatus(),//D0，D1—终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态。
					d.getIcCardStatus(),//D2—终端 IC 卡功能是否有效。0：无效；1：有效。
					d.getBindValueStatus(),//D3—定值控制是否投入。0：退出；1：投入。
					d.getPumpStatus(),//D4—水泵工作状态。 0：启动；1：停止。
					d.getBoxDoorStatus(),//D5—终端箱门状态。0：开启；1：关闭。
					d.getPowerStatus()// D6—电源工作状态。0：AC220V 供电；1：蓄电池供电。
					) ; 
			help.addNode(alarmContain, this.alarmNode) ;
		}else{
			//说明是设置命令结果
		}
	}
	private void removeAllDataNode(){
		F_05_050_HelpData help = new F_05_050_HelpData(this.act) ;
		newIndex-- ;
		while(newIndex >= firstIndex){
			F_05_050_HelpData.Node node = dataNodes.get("" + newIndex) ;
			if(node != null){
				help.removeNode(dataContain, node) ;
			}
			newIndex-- ;
		}
		newIndex = firstIndex ;
		dataNodes.clear() ;
	}	
	private void removeAllAlarmNode(){
		if(this.alarmNode != null){
			F_05_050_HelpAlarm help = new F_05_050_HelpAlarm(this.act) ;
			help.removeNode(alarmContain, this.alarmNode) ;
		}
	}
	
}
