package com.blg.rtu.frmFunction;


import java.util.ArrayList;
import java.util.List;

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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd10_50.Data_10_50;
import com.blg.rtu.protocol.p206.cd44_74.DataList_74;
import com.blg.rtu.protocol.p206.cd44_74.Data_44;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_01_100  extends FrmParent {
	public static F_01_100 instance = null ;
	private final static int requestLen_6 = 6 ; 
	private final static int requestLen_5 = 5 ; 
	private final static int requestLen_3 = 3 ; 
	//private final static int requestLen_3 = 14 ; 

	private TextView title ;

	private EditText item01 ;
	private EditText item02 ;
	private EditText item04 ;
	
	private ImageView btnSet1 ;
	private ImageView btnRead ;
	
	private Spinner item03;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	//private int spinnerPosition ;
	public List<String> listRtuId = new ArrayList<String>();
	public List<String> listModbusAddr = new ArrayList<String>() ;
	
	private int m_currMeter  = 99;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_50 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		cntFrmOpened = false ;
		loading = false ;
	}
	
	public static F_01_100 getInstance(){
		return instance ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_01_100, container, false);

		title = (TextView)view.findViewById(R.id.f_01_100_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_100_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_100_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_01_100_item01);
		item02 = (EditText)view.findViewById(R.id.func_01_100_item02);
		item04 = (EditText)view.findViewById(R.id.func_01_100_item04) ;
		
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_6)});
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_5)});
		item04.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_3)}) ;
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_100_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_100_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		str = Preferences.getInstance().getString(Constant.func_vk_01_100_04) ;
		if(!str.equals(Constant.errorStr)){
			item04.setText(str); 
		}
		
		item03 = (Spinner)view.findViewById(R.id.f_01_100_item3);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		item03.setAdapter(spinnerAdapter);
		item03.setOnItemSelectedListener(new OnItemSelectedListener() {

            //当选中某一个数据项时触发该方法
            /*
             * parent接收的是被选择的数据项所属的 Spinner对象，
             * view参数接收的是显示被选择的数据项的TextView对象
             * position接收的是被选择的数据项在适配器中的位置
             * id被选择的数据项的行号
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
            	
				String rtuId = getRtuSelectedItem() ;
				item01.setText(rtuId.substring(0, 6).trim()) ;
				item02.setText(rtuId.substring(6).trim()) ;
				item04.setText(getModbusAddrSelectedItem());
				/*if(item03.getSelectedItemPosition() != 0) {
					item04.setText(temp[1]);
				}else{
					item04.setText("");
				}*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub    
            }
        });
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_100_01));
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_100_02));
		item04.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_100_04));
		
		btnSet1 = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet1.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_100_dt) ;
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
		String regionNum = item01.getText().toString() ;
		String clientId = item02.getText().toString() ;
		String modbusAddr = item04.getText().toString() ;
		int position = item03.getSelectedItemPosition();
		///////
		if(position != 0) {
			if(modbusAddr == null || modbusAddr.equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "ModBus地址必须填写！") ;
				return false ;
			} 
			
			int modbusAddrValue = Integer.valueOf(modbusAddr) ;
			if(modbusAddrValue < 1 || modbusAddrValue > 247){
				if(showDialog)new DialogAlarm().showDialog(act, "ModBus地址必须是1~247的数字！") ;
				return false ;
			}
		}
		////////////////////////
		if(regionNum == null || regionNum.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "行政区编号不能为空！") ;
			}
			return false ;
		}
		if(regionNum.length() != 6){
			if(showDialog){
				new DialogAlarm().showDialog(act, "行政区编号必须为6位数字！") ;
			}
			return false ;
		} 
		////////////////////////
		if(clientId == null || clientId.equals("") ){
			if(showDialog){
				new DialogAlarm().showDialog(act, "终端地址不能为空！") ;
			}
			return false ;
		} 
		int len = clientId.length() ;
		if(len < requestLen_5){
			int n = requestLen_5 - len ;
			for(int i = n ; i > 0 ; i--){
				clientId = "0" + clientId ;
			}
			item02.setText(clientId) ;
		}
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		CoreThread.getInstance().newRtuId(getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_74(), true) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		String regionNum = item01.getText().toString() ;
		String clientId = item02.getText().toString() ;
		int position = item03.getSelectedItemPosition();
		int modbusAddrValue ;
		if(position != 0) {
			String modbusAddr = item04.getText().toString() ;
			modbusAddrValue = Integer.valueOf(modbusAddr) ;
		}else{
			item04.setText("") ;
			modbusAddrValue = 1 ;
		}
		
		m_currMeter = position ;
		CoreThread.getInstance().newRtuId(getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_44(position, modbusAddrValue, regionNum, clientId, null), false) ;
	}
	
	public String getRtuSelectedItem() {
		if(!CoreThread.getInstance().getNetStatus()) {
			//Toast.makeText(this.act, "网络未连接，请检查！", Toast.LENGTH_SHORT).show() ;
			return "";
		}
		if(listRtuId.size() == 0) {
			return "10101065535" ;
		}
		int position1 = item03.getSelectedItemPosition() ;
		if(position1 > 8 || position1 < 0 ) {
			position1 = 0 ;
		}
		
		return listRtuId.get(position1) ;
	}
	public String getModbusAddrSelectedItem() {
		int position = item03.getSelectedItemPosition() ;
		if(position > 8 || position < 0 ) {
			position = 0 ;
		}
		return listModbusAddr.get(position) ;
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
//		super.scrollTo(this.btnRead) ;
		Preferences p = Preferences.getInstance() ;
		String[] temp = null ;
		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_44){
				Data_44 sd = (Data_44)subD ;
				temp = sd.getRtuId().split("-") ;
				String rtuId = temp[0] ;
				String modbusAddr = temp[1] ;
				listRtuId.set(item03.getSelectedItemPosition(), rtuId) ;
				listModbusAddr.set(item03.getSelectedItemPosition(), modbusAddr) ;
				item01.setText(rtuId.substring(0, 6).trim()) ;
				item02.setText(rtuId.substring(6).trim()) ;
				if(item03.getSelectedItemPosition() != 0) {
					item04.setText(temp[1]);
				}else{
					item04.setText("");
				}
			}else if(subD instanceof DataList_74){
				DataList_74 sd = (DataList_74)d.subData ;
				spinnerAdapter.clear() ;
				listRtuId.clear();
				listModbusAddr.clear() ;
				for(int i = 0; i < 9; i++) {
					if(i == 0) {
						temp = sd.getRtuId().get(i).split("-") ;
						spinnerAdapter.add(new SpinnerVO("" + i, " 中继器 ："+ temp[0])) ;
						listRtuId.add(sd.getRtuId().get(i).split("-")[0]) ;
						listModbusAddr.add(sd.getRtuId().get(i).split("-")[1]) ;
					}else{
						temp = sd.getRtuId().get(i).split("-") ;
						spinnerAdapter.add(new SpinnerVO("" + i, i + "号水表："+ temp[0])) ;
						listRtuId.add(sd.getRtuId().get(i).split("-")[0]) ;
						listModbusAddr.add(sd.getRtuId().get(i).split("-")[1]) ;
					}
				}
					//temp = getRtuSelectedItem();
					String rtuId = getRtuSelectedItem();
					item01.setText(rtuId.substring(0, 6).trim()) ;
					item02.setText(rtuId.substring(6).trim()) ;
					item04.setText(getModbusAddrSelectedItem());
				
			}else if(subD instanceof Data_10_50){
				Data_10_50 sd = (Data_10_50)d.subData ;
				spinnerAdapter.clear() ;
				listRtuId.clear();
				listModbusAddr.clear() ;
				String rtuId = sd.getRtuId() ;
				spinnerAdapter.add(new SpinnerVO("" + 0, " 水表地址 ："+ rtuId)) ;
			}
		}
		p.putString(Constant.func_vk_01_010_dt, this.resultDt.getText().toString()) ;
	}
	
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
		vo.setV_01_010_clientId(item01.getText().toString()) ;
		vo.setV_01_010_regionNum(item02.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		item01.setText(vo.getV_01_010_clientId()) ;
		item02.setText(vo.getV_01_010_regionNum()) ;
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