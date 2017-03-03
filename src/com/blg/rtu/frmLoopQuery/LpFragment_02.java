package com.blg.rtu.frmLoopQuery;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.cd10_50.Data_10_50;
import com.blg.rtu.protocol.p206.cdD3.Data_D3;
import com.blg.rtu.protocol.p206.cdEF.Data_EF;

public class LpFragment_02 extends Fragment {
	
	public MainActivity act ;
	
	public View view ;

	private TextView item01 ;
	private TextView item02 ;
	private TextView item03 ;
	private TextView item04 ;
	
	private ImageView queryBtn;
	public boolean queryBtnFlag = false;
	private ProgressBar loopProgress ;
	
	//private TextView item05 ;
	
/*	private Spinner item04;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04;*/
	
	
	
 	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.floopq_02, container, false);
		
		item01 = (TextView)view.findViewById(R.id.f_02_010_item);
		item02 = (TextView)view.findViewById(R.id.f_02_020_item);
		item03 = (TextView)view.findViewById(R.id.f_02_030_item);
		item04 = (TextView)view.findViewById(R.id.f_02_040_item);
		loopProgress = (ProgressBar)view.findViewById(R.id.queryLoopProgress);
		queryBtn = (ImageView)view.findViewById(R.id.query_Btn);
		
		queryBtn.setOnClickListener(new queryOnClickListener()) ;
		//item05 = (TextView)view.findViewById(R.id.f_02_050_item);
		/*item04 = (Spinner)view.findViewById(R.id.f_02_040_item);
		spinnerAdapter04 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter04.setDropDownViewResource(R.layout.spinner_item);
		item04.setAdapter(spinnerAdapter04);*/
		
		return view ;
	}
	
	private class queryOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(queryBtn.getId() == v.getId()) {
				
				String info = act.mServerProxyHandler.operateAutoQuery(true, false, false, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
				if(info.equals("自动查询启动")) {
					queryBtn.setVisibility(View.GONE);
					loopProgress.setVisibility(View.VISIBLE) ;
					act.mHandler.postDelayed(new Runnable() {
						public void run() {
							loopProgress.setVisibility(View.GONE) ;
							queryBtn.setVisibility(View.VISIBLE) ;
						}
					}, 85000);
				}
				
			}
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
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(String afn, RtuData d){
		if(afn.equals(Code206.cd_D3)) {
			Data_D3 sd = (Data_D3)d.subData ;
			String waterMeterSerial = sd.getWaterMeterSerial() ;
			item01.setText(waterMeterSerial) ;
		}else if(afn.equals(Code206.cd_50)) {
			Data_10_50 sd = (Data_10_50)d.subData ;
			String rtuId = sd.getRtuId() ;
			item02.setText(rtuId) ;
		}else if(afn.equals(Code206.cd_EF)) {
			Data_EF sd = (Data_EF)d.subData ;
			String str1 = sd.getHard1() + "." + sd.getHard2() + "." + sd.getHard3() ;
			String str2 = sd.getSoft1() + "." + sd.getSoft2() + "." + sd.getSoft3() ;
			
			item03.setText(str1) ;
			item04.setText(str2) ;
		}
		
	/*	Data_F0 sd = (Data_F0)d.subData ;
		Byte link = sd.getLink() ;
		if(link != null){
			if(link.byteValue() == (byte)0x01){
				item01.setText("正在连接") ;
			}else if(link.byteValue() == (byte)0x02){
				item01.setText("在线") ;
			}else if(link.byteValue() == (byte)0x03){
				item01.setText("断开") ;
			}else{
				item01.setText("") ;
			}
		}
		
		item02.setText("" + sd.getSignal().byteValue()) ;
		
		item03.setText("" + sd.getVoltage()) ;*/
		
	/*	spinnerAdapter04.clear() ;
		
		int n = 0 ;
		Integer a = sd.getPower220StopAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "交流电停电报警")) ;
			n++ ;
		}
		a = sd.getStorePowerLowVoltageAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "蓄电池电压报警")) ;
			n++ ;
		}*/
		
		/*a = sd.getWaterLevelAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "水位上下限报警")) ;
			n++ ;
		}
		a = sd.getWaterAmountOverAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "流量超限报警")) ;
			n++ ;
		}
		a = sd.getWaterQualityOverAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "水质超限报警")) ;
			n++ ;
		}
		a = sd.getWaterAmountMeterAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "流量仪表故障报警")) ;
			n++ ;
		}
		a = sd.getPumpStartStopAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "水泵开停状态报警")) ;
			n++ ;
		}
		a = sd.getWaterLevelMeterAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "水位仪表故障报警")) ;
			n++ ;
		}
		
		a = sd.getWaterPressOverAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "水压超限报警")) ;
			n++ ;
		}
		a = sd.getIcCardAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "终端 IC 卡功能报警")) ;
			n++ ;
		}
		a = sd.getBindValueControlAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "定值控制报警")) ;
			n++ ;
		}
		a = sd.getWaterRemainAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "剩余水量的下限报警")) ;
			n++ ;
		}
		a = sd.getBoxDoorAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "终端箱门状态报警")) ;
			n++ ;
		}
		a = sd.getLongRunAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "运行时间报警 N年")) ;
			n++ ;
		}
		a = sd.getElectromagneticAlarm() ;
		if(a != null && a.intValue() == 1){
			spinnerAdapter04.add(new SpinnerVO("" + n, "强磁攻击报警")) ;
			n++ ;
		}*/
	}

}

