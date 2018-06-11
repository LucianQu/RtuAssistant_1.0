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
import android.widget.Toast;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd44_74.DataList_74;
import com.blg.rtu.protocol.p206.cd44_74.Data_44;
import com.blg.rtu.protocol.p206.cd49_79.Data_49_79;
import com.blg.rtu.protocol.p206.cd49_79.Param_49;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;
import com.blg.rtu3.server.CoreThread;

public class F_08_101  extends FrmParent {
	public static F_08_101 instance = null ;
	private final static int requestLen_4 = 4 ; 
	private TextView title ;
	private EditText item02 ;
	private ImageView btnSet1 ;
	private ImageView btnRead ;
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private Spinner item03 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter1;
	
	private TextView item04 ;
	private TextView item05 ;
	private TextView item06 ;
	private TextView item07 ;
	private TextView item08 ;
	
	//private int spinnerPosition ;
	public List<String> listZoneRatio = new ArrayList<String>() ;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_79 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		cntFrmOpened = false ;
		loading = false ;
	}
	
	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_08_101, container, false);

		title = (TextView)view.findViewById(R.id.f_08_101_Title) ;
		
		item04 = (TextView)view.findViewById(R.id.func_08_101_item06) ;
		item05 = (TextView)view.findViewById(R.id.func_08_101_item07) ;
		item06 = (TextView)view.findViewById(R.id.func_08_101_item08) ;
		item07 = (TextView)view.findViewById(R.id.func_08_101_item09) ;
		item08 = (TextView)view.findViewById(R.id.func_08_101_item10) ;
		
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_101_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_101_Load) ;
		
		item02 = (EditText)view.findViewById(R.id.func_08_101_item02);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_101_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_101_02));
		
		item01 = (Spinner)view.findViewById(R.id.f_08_101_item1);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		item01.setAdapter(spinnerAdapter);
		setSpinnerContent() ;
		item01.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
            	if (listZoneRatio.size() != 0) {
            	item02.setText(listZoneRatio.get(position)) ;
            	}else{
            		item02.setText("") ;
            	}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub    
            }
        });
		
		//////
		item03 = (Spinner)view.findViewById(R.id.f_08_101_item5);
		spinnerAdapter1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter1.setDropDownViewResource(R.layout.spinner_item);
		item03.setAdapter(spinnerAdapter1);
		setSpinnerMeter() ;
		item03.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
            	if(position == 0) {
            		item04.setText("0 - 2.1") ;
            		item05.setText("2.1 - 6.0") ;
            		item06.setText("6.0 - 22.0") ;
            		item07.setText("22.0 - 35.0") ;
            		item08.setText("35.0 - 500.0") ;
            	}else if(position == 1) {
            		item04.setText("0 - 5.2") ;
            		item05.setText("5.2 - 10.0") ;
            		item06.setText("10.0 - 60.0") ;
            		item07.setText("60.0 - 90.0") ;
            		item08.setText("90.0 - 500.0") ;
            	}else if(position == 2) {
            		item04.setText("0 - 3.3") ;
            		item05.setText("3.3 - 10.0") ;
            		item06.setText("10.0 - 30.0") ;
            		item07.setText("30.0 - 54.0") ;
            		item08.setText("54.0 - 500.0") ;
            	}else{
            		item04.setText("0 - 2.1") ;
            		item05.setText("2.1 - 6.0") ;
            		item06.setText("6.0 - 22.0") ;
            		item07.setText("22.0 - 35.0") ;
            		item08.setText("35.0 - 500.0") ;
            	}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub    
            }
        });
		//////
		
		btnSet1 = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet1.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_101_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}
		return view ;
	}
	
	private void setSpinnerContent() {
		spinnerAdapter.clear() ;
		for(int i = 0; i < 10; i++) {
			if(i < 5)
				spinnerAdapter.add(new SpinnerVO("" + i, "正向第" + (i + 1) + "分区")) ;
			else
				spinnerAdapter.add(new SpinnerVO("" + i, "反向第" + (i - 4) + "分区")) ;
		}
	}
	private void setSpinnerMeter() {
		spinnerAdapter1.clear() ;
		spinnerAdapter1.add(new SpinnerVO("" + 0, "DN100")) ;
		spinnerAdapter1.add(new SpinnerVO("" + 1, "DN50")) ;
		spinnerAdapter1.add(new SpinnerVO("" + 2, "DN80")) ;
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
		String zoneRatio = item02.getText().toString() ;
			if(zoneRatio == null || zoneRatio.equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "分区系数必须填写！") ;
				return false ;
			} 
			
			int zoneRatioValue = Integer.valueOf(zoneRatio) ;
			if(zoneRatioValue < 0 || zoneRatioValue > 9999){
				if(showDialog)new DialogAlarm().showDialog(act, "分区系数必须是1~9999的数字！") ;
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
		this.sendRtuCommand(new CommandCreator().cd_79(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_49 p = new Param_49() ;
		int position = item01.getSelectedItemPosition() ;
		String value = item02.getText().toString() ;//正向第一分区系数
		if(position == 0) {
			p.setPlus1Partition(Integer.valueOf(value)) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 1) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(Integer.valueOf(value)) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 2) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(Integer.valueOf(value)) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;		
		}else if(position == 3) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(Integer.valueOf(value)) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 4) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(Integer.valueOf(value)) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 5) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(Integer.valueOf(value)) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 6) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(Integer.valueOf(value)) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 7) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(Integer.valueOf(value)) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}else if(position == 8) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(Integer.valueOf(value)) ;
			p.setMinus5Partition(0) ;
		}else if(position == 9) {
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(Integer.valueOf(value)) ;
		}else{
			p.setPlus1Partition(0) ;
			p.setPlus2Partition(0) ;
			p.setPlus3Partition(0) ;
			p.setPlus4Partition(0) ;
			p.setPlus5Partition(0) ;
			p.setMinus1Partition(0) ;
			p.setMinus2Partition(0) ;
			p.setMinus3Partition(0) ;
			p.setMinus4Partition(0) ;
			p.setMinus5Partition(0) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_49(p, null), false) ;
	}
	
	public String getModbusAddrSelectedItem(Data_49_79 sd ) {
		int position = item01.getSelectedItemPosition() ;
		String zoneRatio ;
		if(position == 0) {
			zoneRatio = sd.getPlus1Partition() + "" ;
		}else if(position == 1) {
			zoneRatio = sd.getPlus2Partition() + "" ;
		}else if(position == 2) {
			zoneRatio = sd.getPlus3Partition() + "" ;	
		}else if(position == 3) {
			zoneRatio = sd.getPlus4Partition() + "" ;
		}else if(position == 4) {
			zoneRatio = sd.getPlus5Partition() + "" ;
		}else if(position == 5) {
			zoneRatio = sd.getMinus1Partition() + "" ;
		}else if(position == 6) {
			zoneRatio = sd.getMinus2Partition() + "" ;
		}else if(position == 7) {
			zoneRatio = sd.getMinus3Partition() + "" ;
		}else if(position == 8) {
			zoneRatio = sd.getMinus4Partition() + "" ;
		}else if(position == 9) {
			zoneRatio = sd.getMinus5Partition() + "" ;
		}else{
			zoneRatio = "" ;
		}
		
		return zoneRatio ;
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
		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_49_79){
				Data_49_79 sd = (Data_49_79)subD ;
				listZoneRatio.clear() ;
				item02.setText(getModbusAddrSelectedItem(sd)) ;
				listZoneRatio.add(sd.getPlus1Partition() + "") ;
				listZoneRatio.add(sd.getPlus2Partition() + "") ;
				listZoneRatio.add(sd.getPlus3Partition() + "") ;
				listZoneRatio.add(sd.getPlus4Partition() + "") ;
				listZoneRatio.add(sd.getPlus5Partition() + "") ;
				listZoneRatio.add(sd.getMinus1Partition() + "") ;
				listZoneRatio.add(sd.getMinus2Partition() + "") ;
				listZoneRatio.add(sd.getMinus3Partition() + "") ;
				listZoneRatio.add(sd.getMinus4Partition() + "") ;
				listZoneRatio.add(sd.getMinus5Partition() + "") ;
			}
		}
		p.putString(Constant.func_vk_08_101_dt, this.resultDt.getText().toString()) ;
	}
	
	
	/**
	 * 导出设置数据
	 */
	@Override
	public void outSetData(Vo2Xml vo){
	
		//vo.setV_01_010_regionNum(item02.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	@Override
	public void inSetData(Vo2Xml vo){
		//item02.setText(vo.getV_01_010_regionNum()) ;
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