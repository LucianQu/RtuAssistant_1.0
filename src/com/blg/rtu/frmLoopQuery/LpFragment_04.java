package com.blg.rtu.frmLoopQuery;


import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.cd5D.Data_5D;
import com.blg.rtu.protocol.p206.cd5E.Data_5E;
import com.blg.rtu.protocol.p206.cdCC_DC.Data_CC_DC;
import com.blg.rtu.protocol.p206.cdD4.Data_D4;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

public class LpFragment_04 extends Fragment {
	
	public MainActivity act ;
	
	public View view ;
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter01;
	private Spinner item02;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02;
	private Spinner item03;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03;
	private Spinner item04;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04;
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
		view = inflater.inflate(R.layout.floopq_04, container, false);
		
		item01 = (Spinner)view.findViewById(R.id.f_04_010_item);
		spinnerAdapter01 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter01.setDropDownViewResource(R.layout.spinner_item);
		item01.setAdapter(spinnerAdapter01);
		
		item02 = (Spinner)view.findViewById(R.id.f_04_020_item);
		spinnerAdapter02 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter02.setDropDownViewResource(R.layout.spinner_item);
		item02.setAdapter(spinnerAdapter02);
		
		item03 = (Spinner)view.findViewById(R.id.f_04_030_item);
		spinnerAdapter03 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter03.setDropDownViewResource(R.layout.spinner_item);
		item03.setAdapter(spinnerAdapter03);
		
		item04 = (Spinner)view.findViewById(R.id.f_04_040_item);
		spinnerAdapter04 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter04.setDropDownViewResource(R.layout.spinner_item);
		item04.setAdapter(spinnerAdapter04);
		
		return view ;
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
		if(afn.equals(Code206.cd_5E)) {
			Data_5E sd = (Data_5E)d.subData ;
			spinnerAdapter03.clear() ;
			
			int n = 0 ;
			int a = sd.getModelStatus() ;
			String str1 = "终端工作模式：";
			spinnerAdapter03.add(new SpinnerVO("" + n++, (a ==0 ? (str1 + "自报遥测") : (a == 1 ? (str1 + "自报确认") :
					(a == 2 ? (str1 + "遥测") :(str1 + "调试维修")))))) ;
			
			a = sd.getStorePowerLowVoltageAlarm() ;
			str1 = "蓄电池电压报警：" ;
			spinnerAdapter03.add(new SpinnerVO("" + n++,(a == 1 ? (str1 + "报警") : str1 + "无")));
			
			a = sd.getWaterAmountMeterAlarm() ;
			str1 = "流量仪表故障报警：" ;
			spinnerAdapter03.add(new SpinnerVO("" + n++,(a == 1 ? (str1 + "报警") : str1 + "无")));
			
			a = sd.getWaterMeterAlarm() ;
			str1 = "流量仪表反向报警：" ;
			spinnerAdapter03.add(new SpinnerVO("" + n++,(a == 1 ? (str1 + "报警") : str1 + "无")));
			
		}else if(afn.equals(Code206.cd_5D)) {
			Data_5D sd = (Data_5D)d.subData ;
			spinnerAdapter04.clear() ;
			int n = 0 ;
			int a = sd.getERC1().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "数据初始化记录：" + a + " 次")) ;
			a = sd.getERC4().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "仪表故障记录：" + a + " 次")) ;
			a = sd.getERC15().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "数据出错记录：" + a + " 次")) ;
			a = sd.getERC16().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "发报文记录：" + a + " 次")) ;
			a = sd.getERC19().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "强磁攻击记录：" + a + " 次")) ;
			a = sd.getERC20().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "GSM发送报文成功记录：" + a + " 次")) ;
			a = sd.getERC21().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "GSM模块上电总次数记录：" + a + " 次")) ;
			a = sd.getERC22().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "GSM模块上电成功次数记录：" + a + " 次")) ;
			a = sd.getERC23().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "GSM模块上线次数记录：" + a + " 次")) ;
			a = sd.getERC24().intValue() ;
			spinnerAdapter04.add(new SpinnerVO("" + n++, "GSM模块上线成功次数记录：" + a + " 次")) ;
		}else if(afn.equals(Code206.cd_CC)) {
			Data_CC_DC sd = (Data_CC_DC)d.subData ;
			
			spinnerAdapter01.clear() ;
			
			int n = 0 ;
			Integer a = sd.getEnable_1() ;
			String str1 = "" ;
			if(a != null && a.intValue() == 1){
				str1 = "中心1: " + sd.getIp_1_1()+"."+sd.getIp_1_2()+"."+sd.getIp_1_3()+"."+sd.getIp_1_4()
						+" : " + sd.getPort_1()+"  类型："+(sd.getType_1().intValue() == 0? "TCP":"UDP");
				spinnerAdapter01.add(new SpinnerVO("" + n, str1)) ;
				n++ ;
			}
			
			Integer b = sd.getEnable_2() ;
			if(b != null && b.intValue() == 1){
				str1 = "中心2: " + sd.getIp_2_1()+"."+sd.getIp_2_2()+"."+sd.getIp_2_3()+"."+sd.getIp_2_4()
						+" : " + sd.getPort_2()+"  类型："+(sd.getType_2().intValue() == 0? "TCP":"UDP");
				spinnerAdapter01.add(new SpinnerVO("" + n, str1)) ;
				n++ ;
			}
			Integer c = sd.getEnable_3() ;
			if(c != null && c.intValue() == 1){
				str1 = "中心3: " + sd.getIp_3_1()+"."+sd.getIp_3_2()+"."+sd.getIp_3_3()+"."+sd.getIp_3_4()
						+" : " + sd.getPort_3()+"  类型："+(sd.getType_3().intValue() == 0? "TCP":"UDP");
				spinnerAdapter01.add(new SpinnerVO("" + n, str1)) ;
				n++ ;
			}
			Integer dd = sd.getEnable_4() ;
			if(dd != null && dd.intValue() == 1){
				str1 = "中心4: " + sd.getIp_4_1()+"."+sd.getIp_4_2()+"."+sd.getIp_4_3()+"."+sd.getIp_4_4()
						+" : " + sd.getPort_4()+"  类型："+(sd.getType_4().intValue() == 0? "TCP":"UDP");
				spinnerAdapter01.add(new SpinnerVO("" + n, str1)) ;
				n++ ;
			}
			
		}else if(afn.equals(Code206.cd_D4)) {
			Data_D4 sd = (Data_D4)d.subData ;
			spinnerAdapter02.clear() ;
			
			int n = 0 ;
			String str1 = sd.getSimIccId();
			spinnerAdapter02.add(new SpinnerVO("" + n, str1)) ;
			
		}
	}	
	

}

