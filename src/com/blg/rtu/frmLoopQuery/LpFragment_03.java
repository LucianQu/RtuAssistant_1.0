package com.blg.rtu.frmLoopQuery;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.cdA1_53.Data_A1_53;
import com.blg.rtu.protocol.p206.cdC2.Data_C2;
import com.blg.rtu.protocol.p206.cdE0.Data_E0;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class LpFragment_03 extends Fragment {
	
	public MainActivity act ;
	
	public View view ;

/*	private LinearLayout linearLayout0 ;
	private LinearLayout linearLayout1 ;*/

	//private TextView itemName01 ;
	private TextView item01 ;
	private TextView item02 ;
	private TextView item03 ;
	private TextView item04 ;
/*	private TextView item03 ;
	private TextView item04 ;
	
	private TextView item06 ;
	private TextView item07 ;
	private TextView item08 ;
	private TextView item09 ;*/
	/*private Spinner item03;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03;*/
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
		view = inflater.inflate(R.layout.floopq_03, container, false);

	/*	linearLayout0 = (LinearLayout)view.findViewById(R.id.lqDiXia); 
		linearLayout1 = (LinearLayout)view.findViewById(R.id.lqZhiNeng);*/ 
		
		/*int v = Preferences.getInstance().getInt(Constant.loop_vk_01_010_01) ;
		if(v != Constant.errorInt){
			this.queryTypeSet(v) ;
		}*/
		
		//itemName01 = (TextView)view.findViewById(R.id.f_03_010_itemName);
		item01 = (TextView)view.findViewById(R.id.f_03_010_item);
		item02 = (TextView)view.findViewById(R.id.f_03_020_item);
		item03 = (TextView)view.findViewById(R.id.f_03_030_item);
		item04 = (TextView)view.findViewById(R.id.f_03_040_item);
		/*item03 = (Spinner)view.findViewById(R.id.f_03_030_item);
		spinnerAdapter03 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter03.setDropDownViewResource(R.layout.spinner_item);
		item03.setAdapter(spinnerAdapter03);*/
		
		//item03 = (TextView)view.findViewById(R.id.f_03_030_item);
		//item04 = (TextView)view.findViewById(R.id.f_03_040_item);
		
	/*	item06 = (TextView)view.findViewById(R.id.f_03_060_item);
		item07 = (TextView)view.findViewById(R.id.f_03_070_item);
		item08 = (TextView)view.findViewById(R.id.f_03_080_item);
		item09 = (TextView)view.findViewById(R.id.f_03_090_item);*/
		
		return view ;
	}
	
	/**
	 * 设置查询类型
	 * @param type
	 */
/*	public void queryTypeSet(int type){
		if(type == LpConstant.queryType_diXia){
			linearLayout0.setVisibility(View.VISIBLE) ;
			linearLayout1.setVisibility(View.GONE) ;
		}else if(type == LpConstant.queryType_zhiNeng){
			linearLayout0.setVisibility(View.GONE) ;
			linearLayout1.setVisibility(View.VISIBLE) ;
		}
	}*/
	
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
		if(afn.equals(Code206.cd_C2)) {
			Data_C2 sd = (Data_C2)d.subData ;
			
			long waterInstant = sd.getWaterInstant().longValue();
			if(waterInstant < 0) {
				waterInstant = - waterInstant;
				if ((waterInstant / 1000) > 0) {
					item04.setText(("-" + waterInstant / 1000) + "." + (waterInstant + 1000) % 1000) ;
				}else if((waterInstant / 1000) == 0){
					item04.setText("-0." + (waterInstant + 1000) % 1000) ;
				}
			}else{
				if ((waterInstant / 1000) > 0) {
					item04.setText((waterInstant / 1000) + "." + (waterInstant + 1000) % 1000) ;
				}else if((waterInstant / 1000) == 0){
					item04.setText("0." + (waterInstant + 1000) % 1000) ;
				}
			}
			
			item03.setText(sd.getWaterConsumption().longValue() + "") ;
		}else if(afn.equals(Code206.cd_E0)) {
			Data_E0 sd = (Data_E0)d.subData ;
			float v = sd.getVoltage() ;
			item01.setText("" + v) ;
		}else if(afn.equals(Code206.cd_53)) {
			Data_A1_53 sd = (Data_A1_53)d.subData ;
			Short dv = sd.getLiuLiangReportInterval();
			item02.setText("" + dv) ;
		}
		/*
		itemName01.setText(R.string.txtLoopQuery_wlType) ;
		item01.setText("") ;
		item02.setText("") ;
		item03.setText("") ;
		item04.setText("") ;
		
		item06.setText("") ;
		item07.setText("") ;
		item08.setText("") ;
		item09.setText("") ;
		
		Data_F0 sd = (Data_F0)d.subData ;
		Byte type = sd.getType() ;
		if(type != null){
			if(type.byteValue() == (byte)0xC3){
				//地下水
				this.queryTypeSet(LpConstant.queryType_diXia) ;
				type = sd.getWlType() ;
				if(type != null){
					if(type.byteValue() == 0){
						itemName01.setText("实测值") ;
					}else if(type.byteValue() == 1){
						itemName01.setText("水位高程") ;
					}else if(type.byteValue() == 2){
						itemName01.setText("水深") ;
					}else if(type.byteValue() == 3){
						itemName01.setText("水位埋深") ;
					}
				}
					
				item01.setText("" + sd.getLevel()) ;
				item02.setText("" + sd.getBaseHeight()) ;
				item03.setText("" + sd.getBuried()) ;
				item04.setText("" + sd.getTemperature()) ;
				
			}else if(type.byteValue() == (byte)0xC4){
				//智能水表
				this.queryTypeSet(LpConstant.queryType_zhiNeng) ;
				item06.setText("" + sd.getAmount()) ;
				item07.setText("" + sd.getPlus()) ;
				item08.setText("" + sd.getMinus()) ;
				item09.setText("" + sd.getInstance()) ;
			}
		}
	
	*/}	
	

}

