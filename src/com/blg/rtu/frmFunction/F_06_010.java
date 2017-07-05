package com.blg.rtu.frmFunction;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterAmountList;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterLevelList;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterQuality;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterTemperature;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.InputFilter_DecimalUnSigned;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class F_06_010 extends FrmParent {
	
	private TextView title ;

	///////////////////////
	//参数类型选择
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private int spinnerPosition ;
	
	///////////////////////
	//水位
	protected LinearLayout waterLevelDataContain ;
	protected HashMap<String, F_06_010_HelpData_WaterLevel.Node> waterLevelWataNodes ;
	protected static final int maxCount_waterLevel = 30 ;
	protected static final int commonId_waterLevel = 1000 ;
	protected static final int firstIndex_waterLevel = 1 ;
	protected static int newIndex_waterLevel = 0 ;
	
	
	///////////////////////
	//水温
	protected LinearLayout waterTemperatureDataContain ;
	protected EditText item03  ;
	
	//////////////////////
	//水质
	protected LinearLayout waterQualityDataContain ;
	protected EditText item04_01  ;
	protected EditText item04_02  ;
	protected EditText item04_03  ;
	protected EditText item04_04  ;
	protected EditText item04_05  ;

	
	///////////////////////
	//累计水量
	protected LinearLayout waterAmountDataContain ;
	protected HashMap<String, F_06_010_HelpData_WaterAmount.Node> waterAmountWataNodes ;
	protected static final int maxCount_waterAmount = 30 ;
	protected static final int commonId_waterAmount = 1000 ;
	protected static final int firstIndex_waterAmount = 1 ;
	protected static int newIndex_waterAmount = 0 ;
	
	private ImageView btnSet ;
	private ImageView btnAdd_waterLevel ;
	private ImageView btnRemove_waterLevel;
	private ImageView btnAdd_waterAmount ;
	private ImageView btnRemove_waterAmount;
	
	
	
	protected Param_82_WaterLevelList waterLevelParam ;//水位参数
	protected Param_82_WaterTemperature waterTemperatureParam ;//水温参数
	protected Param_82_WaterQuality waterQualityParam ;//水质参数
	protected Param_82_WaterAmountList waterAmountParam ;//累计水量参数

	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.waterLevelWataNodes = new HashMap<String, F_06_010_HelpData_WaterLevel.Node>() ;
		this.waterAmountWataNodes = new HashMap<String, F_06_010_HelpData_WaterAmount.Node>() ;
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
		View view = inflater.inflate(R.layout.f_func_06_010, container, false);

		title = (TextView)view.findViewById(R.id.f_06_010_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_06_010_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_06_010_Load) ;
		
		////////////////////////////
		//参数类型选择
		item01 = (Spinner) view.findViewById(R.id.f_06_010_item01);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue();
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		item01.setAdapter(spinnerAdapter);
		item01.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_06_010_01) ;
		if(v != Constant.errorInt){
			item01.setSelection(v); 
		}
		
		
		///////////////////////////
		//水位相关
		waterLevelDataContain = (LinearLayout)view.findViewById(R.id.f_06_010_dataContainWaterLevel) ;
		newIndex_waterLevel = firstIndex_waterLevel ;
		this.initWaterLevelDataNode() ;
		
		//////////////////////////
		//水温相关
		waterTemperatureDataContain = (LinearLayout)view.findViewById(R.id.f_06_010_dataContainWaterTemperature) ;
		item03 = (EditText)view.findViewById(R.id.func_06_010_item03);
		item03.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(4)});
		String str = Preferences.getInstance().getString(Constant.func_vk_06_010_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_03));
		
		//////////////////////////
		//水质相关
		waterQualityDataContain = (LinearLayout)view.findViewById(R.id.f_06_010_dataContainWaterQuality) ;
		item04_01 = (EditText)view.findViewById(R.id.func_06_010_item04_01);
		item04_01.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(4)});
		str = Preferences.getInstance().getString(Constant.func_vk_06_010_04_01) ;
		if(!str.equals(Constant.errorStr)){
			item04_01.setText(str); 
		}
		item04_01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_04_01));
		
		item04_02 = (EditText)view.findViewById(R.id.func_06_010_item04_02);
		item04_02.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		str = Preferences.getInstance().getString(Constant.func_vk_06_010_04_02) ;
		if(!str.equals(Constant.errorStr)){
			item04_02.setText(str); 
		}
		item04_02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_04_02));

		item04_03 = (EditText)view.findViewById(R.id.func_06_010_item04_03);
		item04_03.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		str = Preferences.getInstance().getString(Constant.func_vk_06_010_04_03) ;
		if(!str.equals(Constant.errorStr)){
			item04_03.setText(str); 
		}
		item04_03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_04_03));
		
		item04_04 = (EditText)view.findViewById(R.id.func_06_010_item04_04);
		item04_04.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(5)});
		str = Preferences.getInstance().getString(Constant.func_vk_06_010_04_04) ;
		if(!str.equals(Constant.errorStr)){
			item04_04.setText(str); 
		}
		item04_04.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_04_04));
		
		item04_05 = (EditText)view.findViewById(R.id.func_06_010_item04_05);
		item04_05.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(3)});
		str = Preferences.getInstance().getString(Constant.func_vk_06_010_04_05) ;
		if(!str.equals(Constant.errorStr)){
			item04_05.setText(str); 
		}
		item04_05.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_04_05));
		

		
		///////////////////////////
		//累计水量相关
		waterAmountDataContain = (LinearLayout)view.findViewById(R.id.f_06_010_dataContainWaterAmount) ;
		newIndex_waterAmount = firstIndex_waterAmount ;
		this.initWaterAmountDataNode() ;

		
		///////////////////////////
		//功能按钮
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnAdd_waterLevel = (ImageView)view.findViewById(R.id.btn_add_1);
		btnRemove_waterLevel = (ImageView)view.findViewById(R.id.btn_remove_1);
		btnAdd_waterAmount = (ImageView)view.findViewById(R.id.btn_add_2);
		btnRemove_waterAmount = (ImageView)view.findViewById(R.id.btn_remove_2);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnAdd_waterLevel.setOnClickListener(btnAddLisn_waterLevel);
		btnRemove_waterLevel.setOnClickListener(btnRemoveLisn_waterLevel);
		btnAdd_waterAmount.setOnClickListener(btnAddLisn_waterAmount);
		btnRemove_waterAmount.setOnClickListener(btnRemoveLisn_waterAmount);
		
		str = Preferences.getInstance().getString(Constant.func_vk_06_010_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	private void putSpinnerValue(){
		spinnerAdapter.add(new SpinnerVO("0", "水位数据")) ;
		spinnerAdapter.add(new SpinnerVO("1", "水温数据")) ;
		spinnerAdapter.add(new SpinnerVO("2", "水质数据")) ;
		spinnerAdapter.add(new SpinnerVO("3", "水量数据")) ;
	}
	
	public class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition = position ;
			Preferences.getInstance().putInt(Constant.func_vk_06_010_01, position) ;
			if(spinnerPosition == 0){
				waterLevelDataContain.setVisibility(View.VISIBLE) ;
				waterTemperatureDataContain.setVisibility(View.GONE) ;
				waterQualityDataContain.setVisibility(View.GONE) ;
				waterAmountDataContain.setVisibility(View.GONE) ;
				btnAdd_waterLevel.setVisibility(View.VISIBLE) ;
				btnRemove_waterLevel.setVisibility(View.VISIBLE) ;
				btnAdd_waterAmount.setVisibility(View.GONE) ;
				btnRemove_waterAmount.setVisibility(View.GONE) ;
			}else if(spinnerPosition == 1){
				waterLevelDataContain.setVisibility(View.GONE) ;
				waterTemperatureDataContain.setVisibility(View.VISIBLE) ;
				waterQualityDataContain.setVisibility(View.GONE) ;
				waterAmountDataContain.setVisibility(View.GONE) ;
				btnAdd_waterLevel.setVisibility(View.GONE) ;
				btnRemove_waterLevel.setVisibility(View.GONE) ;
				btnAdd_waterAmount.setVisibility(View.GONE) ;
				btnRemove_waterAmount.setVisibility(View.GONE) ;
			}else if(spinnerPosition == 2){
				waterLevelDataContain.setVisibility(View.GONE) ;
				waterTemperatureDataContain.setVisibility(View.GONE) ;
				waterQualityDataContain.setVisibility(View.VISIBLE) ;
				waterAmountDataContain.setVisibility(View.GONE) ;
				btnAdd_waterLevel.setVisibility(View.GONE) ;
				btnRemove_waterLevel.setVisibility(View.GONE) ;
				btnAdd_waterAmount.setVisibility(View.GONE) ;
				btnRemove_waterAmount.setVisibility(View.GONE) ;
			}else if(spinnerPosition == 3){
				waterLevelDataContain.setVisibility(View.GONE) ;
				waterTemperatureDataContain.setVisibility(View.GONE) ;
				waterQualityDataContain.setVisibility(View.GONE) ;
				waterAmountDataContain.setVisibility(View.VISIBLE) ;
				btnAdd_waterLevel.setVisibility(View.GONE) ;
				btnRemove_waterLevel.setVisibility(View.GONE) ;
				btnAdd_waterAmount.setVisibility(View.VISIBLE) ;
				btnRemove_waterAmount.setVisibility(View.VISIBLE) ;
			}
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
		boolean returnFalg = false ;
		int n = Integer.valueOf(spinnerAdapter.getItem(spinnerPosition).getId()) ;
		if(n == 0){
			//水位数据
			returnFalg = new F_06_010_HelpCheckBeforeSet_WaterLevel(this).checkBeforeSet(showDialog) ;
		}else if(n == 1){
			//水温数据
			returnFalg = new F_06_010_HelpCheckBeforeSet_WaterTemperature(this).checkBeforeSet(showDialog) ;
		}else if(n == 2){
			//水质数据
			returnFalg = new F_06_010_HelpCheckBeforeSet_WaterQuality(this).checkBeforeSet(showDialog) ;
		}else if(n == 3){
			//累计水量数据
			returnFalg = new F_06_010_HelpCheckBeforeSet_WaterAmount(this).checkBeforeSet(showDialog) ;
		}
		return returnFalg ;
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
		int n = Integer.valueOf(spinnerAdapter.getItem(spinnerPosition).getId()) ;
		if(n == 0  && this.waterLevelParam != null){
			//水位数据
			this.sendRtuCommand(new CommandCreator().cd_82_1(this.waterLevelParam, null), false) ;
		}else if(n == 1){
			//水温数据
			this.sendRtuCommand(new CommandCreator().cd_82_2(this.waterTemperatureParam, null), false) ;
		}else if(n == 2){
			//水质数据
			this.sendRtuCommand(new CommandCreator().cd_82_3(this.waterQualityParam, null), false) ;
		}else if(n == 3){
			//累计水量数据
			this.sendRtuCommand(new CommandCreator().cd_82_4(this.waterAmountParam, null), false) ;
		}
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		Preferences.getInstance().putString(Constant.func_vk_06_010_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {/*
		vo.setV_06_010_item01(spinnerPosition) ;
		vo.setV_06_010_item03(item03.getText().toString()) ;
		vo.setV_06_010_item04_01(item04_01.getText().toString()) ;
		vo.setV_06_010_item04_02(item04_02.getText().toString()) ;
		vo.setV_06_010_item04_03(item04_03.getText().toString()) ;
		vo.setV_06_010_item04_04(item04_04.getText().toString()) ;
		vo.setV_06_010_item04_05(item04_05.getText().toString()) ;
		
		String str = null ;
		int index = firstIndex_waterLevel ;
		String value1 = null ;
		F_06_010_HelpData_WaterLevel.Node nodeWl = this.waterLevelWataNodes.get("" + index) ;
		while(nodeWl != null){
			value1 = nodeWl.itemText1.getText().toString() ;
			if(str == null){
				str = value1;
			}else{
				str += ";" + value1 ;
			}
			index++ ;
			nodeWl = this.waterLevelWataNodes.get("" + index) ;
		}
		if(str != null){
			byte[] bs = str.getBytes() ;
			String hex = ByteUtil.bytes2Hex(bs, false) ;
			if(hex != null){
				vo.setV_06_010_item02Str(hex) ;
			}
		}
		
		str = null ;
		index = firstIndex_waterAmount ;
		value1 = null ;
		F_06_010_HelpData_WaterAmount.Node nodeWa = this.waterAmountWataNodes.get("" + index) ;
		while(nodeWa != null){
			value1 = nodeWa.itemText1.getText().toString() ;
			if(str == null){
				str = value1;
			}else{
				str += ";" + value1 ;
			}
			index++ ;
			nodeWa = this.waterAmountWataNodes.get("" + index) ;
		}
		if(str != null){
			byte[] bs = str.getBytes() ;
			String hex = ByteUtil.bytes2Hex(bs, false) ;
			if(hex != null){
				vo.setV_06_010_item05Str(hex) ;
			}
		}

	*/}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {/*
		item01.setSelection(vo.getV_06_010_item01()) ;
		item03.setText(vo.getV_06_010_item03()) ;
		item04_01.setText(vo.getV_06_010_item04_01()) ;
		item04_02.setText(vo.getV_06_010_item04_02()) ;
		item04_03.setText(vo.getV_06_010_item04_03()) ;
		item04_04.setText(vo.getV_06_010_item04_04()) ;
		item04_05.setText(vo.getV_06_010_item04_05()) ;
		
		String hex = vo.getV_06_010_item02Str() ;
		if(hex != null && !hex.equals("")){
			try {
				byte[] bs = ByteUtil.hex2Bytes(hex) ;
				if(bs != null && bs.length > 0){
					//首先删除以前的界面数据
					this.removeAllWaterLevelDataNode();

					String str = new String(bs) ;
					String[] ss = str.split(";") ;
					for(int i = 0 ; i < ss.length ; i++){
						this.createWaterLevelDataNode(ss[i]) ;
					}
				}
			} catch (Exception e) {
			}
		}
		
		hex = vo.getV_06_010_item05Str() ;
		if(hex != null && !hex.equals("")){
			try {
				byte[] bs = ByteUtil.hex2Bytes(hex) ;
				if(bs != null && bs.length > 0){
					//首先删除以前的界面数据
					this.removeAllWaterAmountDataNode();

					String str = new String(bs) ;
					String[] ss = str.split(";") ;
					for(int i = 0 ; i < ss.length ; i++){
						this.createWaterAmountDataNode(ss[i]) ;
					}
				}
			} catch (Exception e) {
			}
		}

	*/}
	
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
	
	
	//添加按钮点击事件
	private Button.OnClickListener btnAddLisn_waterLevel = new Button.OnClickListener(){
		public void onClick(View v) {
			if(newIndex_waterLevel > maxCount_waterLevel){
				new DialogAlarm().showDialog(act, "水位点数已经超过最大限值！") ;
			}else{
				F_06_010_HelpData_WaterLevel help = new F_06_010_HelpData_WaterLevel(act) ;
				
				int id = newIndex_waterLevel * commonId_waterLevel ;
				F_06_010_HelpData_WaterLevel.Node node = help.createNode(newIndex_waterLevel, id + 1, null) ;
				help.addNode(waterLevelDataContain, node) ;
				waterLevelWataNodes.put("" + newIndex_waterLevel, node) ;
				newIndex_waterLevel++ ;
			}
		}
	} ;
	//删除按钮点击事件
	private Button.OnClickListener btnRemoveLisn_waterLevel = new Button.OnClickListener(){
		public void onClick(View v) {
			newIndex_waterLevel-- ;//newIndex--使其值变为当前结点索引nowIndex
			if(newIndex_waterLevel > firstIndex_waterLevel){
				F_06_010_HelpData_WaterLevel.Node node = waterLevelWataNodes.get("" + newIndex_waterLevel) ;
				if(node != null){
					new F_06_010_HelpData_WaterLevel(act).removeNode(waterLevelDataContain, node) ;
					waterLevelWataNodes.remove("" + newIndex_waterLevel) ;
				}
			}else{
				newIndex_waterLevel++ ;//newIndex++使其值变为新结点索引newIndex
			}
		}
	} ;
	
	
	//添加按钮点击事件
	private Button.OnClickListener btnAddLisn_waterAmount = new Button.OnClickListener(){
		public void onClick(View v) {
			if(newIndex_waterAmount > maxCount_waterAmount){
				new DialogAlarm().showDialog(act, "水表数已经超过最大限值！") ;
			}else{
				F_06_010_HelpData_WaterAmount help = new F_06_010_HelpData_WaterAmount(act) ;
				
				int id = newIndex_waterAmount * commonId_waterAmount ;
				F_06_010_HelpData_WaterAmount.Node node = help.createNode(newIndex_waterAmount, id + 1, null) ;
				help.addNode(waterAmountDataContain, node) ;
				waterAmountWataNodes.put("" + newIndex_waterAmount, node) ;
				newIndex_waterAmount++ ;
			}
		}
	} ;
	//删除按钮点击事件
	private Button.OnClickListener btnRemoveLisn_waterAmount = new Button.OnClickListener(){
		public void onClick(View v) {
			newIndex_waterAmount-- ;//newIndex--使其值变为当前结点索引nowIndex
			if(newIndex_waterAmount > firstIndex_waterAmount){
				F_06_010_HelpData_WaterAmount.Node node = waterAmountWataNodes.get("" + newIndex_waterAmount) ;
				if(node != null){
					new F_06_010_HelpData_WaterAmount(act).removeNode(waterAmountDataContain, node) ;
					waterAmountWataNodes.remove("" + newIndex_waterAmount) ;
				}
			}else{
				newIndex_waterAmount++ ;//newIndex++使其值变为新结点索引newIndex
			}
		}
	} ;
	
	
	//////////////////////////////////////////////
	//以下业务逻辑 
	private void initWaterLevelDataNode(){
		F_06_010_HelpData_WaterLevel help = new F_06_010_HelpData_WaterLevel(this.act) ;

		boolean has = false ;
		int id = newIndex_waterLevel * commonId_waterLevel ;

		Preferences pre = Preferences.getInstance() ;
		String str = pre.getString(Constant.func_vk_06_010_02_ + (id + 1)) ;
		while(str != Constant.errorStr){
			F_06_010_HelpData_WaterLevel.Node node = help.createNode(newIndex_waterLevel, id + 1, null) ;
			help.addNode(waterLevelDataContain, node) ;
			waterLevelWataNodes.put("" + newIndex_waterLevel, node) ;
			newIndex_waterLevel++ ;
			has = true ;
			id = newIndex_waterLevel * commonId_waterLevel ;
			str = pre.getString(Constant.func_vk_06_010_02_ + (id + 1)) ;
		}
		if(!has){
			F_06_010_HelpData_WaterLevel.Node node = help.createNode(newIndex_waterLevel, id + 1, null) ;
			help.addNode(waterLevelDataContain, node) ;
			waterLevelWataNodes.put("" + newIndex_waterLevel, node) ;
			newIndex_waterLevel++ ;
		}
	}
	
/*	private void createWaterLevelDataNode(String s){
		F_06_010_HelpData_WaterLevel help = new F_06_010_HelpData_WaterLevel(this.act) ;
		Double d = null ;
		try{
			if(s != null && !s.trim().equals("")){
				d = Double.valueOf(s) ;
			}
			
			int id = newIndex_waterLevel * commonId_waterLevel ;
			F_06_010_HelpData_WaterLevel.Node node = help.createNode(newIndex_waterLevel, id + 1, d) ; 
			help.addNode(waterLevelDataContain, node) ;
			waterLevelWataNodes.put("" + newIndex_waterLevel, node) ;
			newIndex_waterLevel++ ;
		}catch(Exception e){
		}
	}*/
		
	/*private void removeAllWaterLevelDataNode(){
		F_06_010_HelpData_WaterLevel help = new F_06_010_HelpData_WaterLevel(this.act) ;
		newIndex_waterLevel-- ;
		while(newIndex_waterLevel >= firstIndex_waterLevel){
			F_06_010_HelpData_WaterLevel.Node node = waterLevelWataNodes.get("" + newIndex_waterLevel) ;
			if(node != null){
				help.removeNode(waterLevelDataContain, node) ;
			}
			newIndex_waterLevel-- ;
		}
		newIndex_waterLevel = firstIndex_waterLevel ;
		waterLevelWataNodes.clear() ;
	}*/

	
	private void initWaterAmountDataNode(){
		F_06_010_HelpData_WaterAmount help = new F_06_010_HelpData_WaterAmount(this.act) ;

		boolean has = false ;
		int id = newIndex_waterAmount * commonId_waterAmount ;

		Preferences pre = Preferences.getInstance() ;
		String str = pre.getString(Constant.func_vk_06_010_05_ + (id + 1)) ;
		while(str != Constant.errorStr){
			F_06_010_HelpData_WaterAmount.Node node = help.createNode(newIndex_waterAmount, id + 1, null) ;
			help.addNode(waterAmountDataContain, node) ;
			waterAmountWataNodes.put("" + newIndex_waterAmount, node) ;
			newIndex_waterAmount++ ;
			has = true ;
			id = newIndex_waterAmount * commonId_waterAmount ;
			str = pre.getString(Constant.func_vk_06_010_05_ + (id + 1)) ;
		}
		if(!has){
			F_06_010_HelpData_WaterAmount.Node node = help.createNode(newIndex_waterAmount, id + 1, null) ;
			help.addNode(waterAmountDataContain, node) ;
			waterAmountWataNodes.put("" + newIndex_waterAmount, node) ;
			newIndex_waterAmount++ ;
		}
	}
	
/*	private void createWaterAmountDataNode(String s){
		F_06_010_HelpData_WaterAmount help = new F_06_010_HelpData_WaterAmount(this.act) ;
		Double d = null ;
		try{
			if(s != null && !s.trim().equals("")){
				d = Double.valueOf(s) ;
			}
			
			int id = newIndex_waterAmount * commonId_waterAmount ;
			F_06_010_HelpData_WaterAmount.Node node = help.createNode(newIndex_waterAmount, id + 1, d) ; 
			help.addNode(waterAmountDataContain, node) ;
			waterAmountWataNodes.put("" + newIndex_waterAmount, node) ;
			newIndex_waterAmount++ ;
		}catch(Exception e){
		}
	}*/
		
/*	private void removeAllWaterAmountDataNode(){
		F_06_010_HelpData_WaterAmount help = new F_06_010_HelpData_WaterAmount(this.act) ;
		newIndex_waterAmount-- ;
		while(newIndex_waterAmount >= firstIndex_waterAmount){
			F_06_010_HelpData_WaterAmount.Node node = waterAmountWataNodes.get("" + newIndex_waterAmount) ;
			if(node != null){
				help.removeNode(waterAmountDataContain, node) ;
			}
			newIndex_waterAmount-- ;
		}
		newIndex_waterAmount = firstIndex_waterAmount ;
		waterAmountWataNodes.clear() ;
	}*/
	
}
