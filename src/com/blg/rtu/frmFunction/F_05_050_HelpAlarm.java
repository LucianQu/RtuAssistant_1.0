package com.blg.rtu.frmFunction;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

public class F_05_050_HelpAlarm {
	
	protected MainActivity act ;
	protected Resources rs  ;
	
	public F_05_050_HelpAlarm(MainActivity act){
		this.act = act ;
		this.rs = this.act.getResources() ;
	}
	public class Node{
		public LinearLayout alarmTitleLinear ;
		public TextView alarmTitle;
		
		public LinearLayout alarmLinear01 ;//power220StopAlarm ;//工作交流电停电告警；(0未发生报警，1发生报警)
		public LinearLayout alarmLinear02 ;//storePowerLowVoltageAlarm ;//蓄电池电压报警；(0未发生报警，1发生报警)
		public LinearLayout alarmLinear03 ;//waterLevelAlarm ;//水位上下限报警；(0未发生报警，1发生报警)
		public LinearLayout alarmLinear04 ;//waterAmountOverAlarm ;//流量超限报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear05 ;//waterQualityOverAlarm ;//水质超限报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear06 ;//waterAmountMeterAlarm ;//流量仪表故障报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear07 ;//pumpStartStopAlarm ;//水泵开停状态；(0未发生报警，1发生报警)
		public LinearLayout alarmLinear08 ;//waterLevelMeterAlarm ;//水位仪表故障报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear09 ;//waterPressOverAlarm ;//水压超限报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear10 ;//waterTemperatureAlarm ;//水温仪表故障； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear11 ;//icCardAlarm ;//终端 IC 卡功能报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear12 ;//bindValueControlAlarm ;//定值控制报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear13 ;//waterRemainAlarm ;//剩余水量的下限报警； (0未发生报警，1发生报警)
		public LinearLayout alarmLinear14 ;//boxDoorAlarm ;//终端箱门状态报警；(0未发生报警，1发生报警)
		public LinearLayout statusLinear01 ;//modelStatus ;//D0，D1—终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态。
		public LinearLayout statusLinear02 ;//icCardStatus ;//D2—终端 IC 卡功能是否有效。0：无效；1：有效。 
		public LinearLayout statusLinear03 ;//bindValueStatus ;//D3—定值控制是否投入。0：退出；1：投入。 
		public LinearLayout statusLinear04 ;//pumpStatus ;//D4—水泵工作状态。 0：启动；1：停止。 
		public LinearLayout statusLinear05 ;//boxDoorStatus ;//D5—终端箱门状态。0：开启；1：关闭。 
		public LinearLayout statusLinear06 ;//powerStatus ;//D6—电源工作状态。0：AC220V 供电；1：蓄电池供电。 
		

		public TextView alarm01 ;//power220StopAlarm ;//工作交流电停电告警；(0未发生报警，1发生报警)
		public TextView alarm02 ;//storePowerLowVoltageAlarm ;//蓄电池电压报警；(0未发生报警，1发生报警)
		public TextView alarm03 ;//waterLevelAlarm ;//水位上下限报警；(0未发生报警，1发生报警)
		public TextView alarm04 ;//waterAmountOverAlarm ;//流量超限报警； (0未发生报警，1发生报警)
		public TextView alarm05 ;//waterQualityOverAlarm ;//水质超限报警； (0未发生报警，1发生报警)
		public TextView alarm06 ;//waterAmountMeterAlarm ;//流量仪表故障报警； (0未发生报警，1发生报警)
		public TextView alarm07 ;//pumpStartStopAlarm ;//水泵开停状态；(0未发生报警，1发生报警)
		public TextView alarm08 ;//waterLevelMeterAlarm ;//水位仪表故障报警； (0未发生报警，1发生报警)
		public TextView alarm09 ;//waterPressOverAlarm ;//水压超限报警； (0未发生报警，1发生报警)
		public TextView alarm10 ;//waterTemperatureAlarm ;//水温仪表故障； (0未发生报警，1发生报警)
		public TextView alarm11 ;//icCardAlarm ;//终端 IC 卡功能报警； (0未发生报警，1发生报警)
		public TextView alarm12 ;//bindValueControlAlarm ;//定值控制报警； (0未发生报警，1发生报警)
		public TextView alarm13 ;//waterRemainAlarm ;//剩余水量的下限报警； (0未发生报警，1发生报警)
		public TextView alarm14 ;//boxDoorAlarm ;//终端箱门状态报警；(0未发生报警，1发生报警)
		public TextView status01 ;//modelStatus ;//D0，D1—终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态。
		public TextView status02 ;//icCardStatus ;//D2—终端 IC 卡功能是否有效。0：无效；1：有效。 
		public TextView status03 ;//bindValueStatus ;//D3—定值控制是否投入。0：退出；1：投入。 
		public TextView status04 ;//pumpStatus ;//D4—水泵工作状态。 0：启动；1：停止。 
		public TextView status05 ;//boxDoorStatus ;//D5—终端箱门状态。0：开启；1：关闭。 
		public TextView status06 ;//powerStatus ;//D6—电源工作状态。0：AC220V 供电；1：蓄电池供电。 

		public View gapView ;
	}
	
	public Node initNode(){
		Node node = new Node() ;
		node.alarmTitle = this.createAlarmTitleTextView("报警状态") ;
		
		Preferences p = Preferences.getInstance() ;
		int alarm01 = p.getInt(Constant.func_vk_05_050_alarm_ + "01") ;
		int alarm02 = p.getInt(Constant.func_vk_05_050_alarm_ + "02") ;
		int alarm03 = p.getInt(Constant.func_vk_05_050_alarm_ + "03") ;
		int alarm04 = p.getInt(Constant.func_vk_05_050_alarm_ + "04") ;
		int alarm05 = p.getInt(Constant.func_vk_05_050_alarm_ + "05") ;
		int alarm06 = p.getInt(Constant.func_vk_05_050_alarm_ + "06") ;
		int alarm07 = p.getInt(Constant.func_vk_05_050_alarm_ + "07") ;
		int alarm08 = p.getInt(Constant.func_vk_05_050_alarm_ + "08") ;
		int alarm09 = p.getInt(Constant.func_vk_05_050_alarm_ + "09") ;
		int alarm10 = p.getInt(Constant.func_vk_05_050_alarm_ + "10") ;
		int alarm11 = p.getInt(Constant.func_vk_05_050_alarm_ + "11") ;
		int alarm12 = p.getInt(Constant.func_vk_05_050_alarm_ + "12") ;
		int alarm13 = p.getInt(Constant.func_vk_05_050_alarm_ + "13") ;
		int alarm14 = p.getInt(Constant.func_vk_05_050_alarm_ + "14") ;
		int status01 = p.getInt(Constant.func_vk_05_050_status_ + "01") ;
		int status02 = p.getInt(Constant.func_vk_05_050_status_ + "02") ;
		int status03 = p.getInt(Constant.func_vk_05_050_status_ + "03") ;
		int status04 = p.getInt(Constant.func_vk_05_050_status_ + "04") ;
		int status05 = p.getInt(Constant.func_vk_05_050_status_ + "05") ;
		int status06 = p.getInt(Constant.func_vk_05_050_status_ + "06") ;

		node.alarm01 = this.createAlarmTextView("工作交流电停电告警", alarm01==1?"报警":"无", alarm01, true) ;
		node.alarm02 = this.createAlarmTextView("蓄电池电压报警", alarm02==1?"报警":"无", alarm02, true) ;
		node.alarm03 = this.createAlarmTextView("水位上下限报警", alarm03==1?"报警":"无", alarm03, true) ;
		node.alarm04 = this.createAlarmTextView("流量超限报警", alarm04==1?"报警":"无", alarm04, true) ;
		node.alarm05 = this.createAlarmTextView("水质超限报警", alarm05==1?"报警":"无", alarm05, true) ;
		node.alarm06 = this.createAlarmTextView("流量仪表故障报警", alarm06==1?"报警":"无", alarm06, true) ;
		node.alarm07 = this.createAlarmTextView("水泵开停状态", alarm07==1?"报警":"无", alarm07, true) ;
		node.alarm08 = this.createAlarmTextView("水位仪表故障报警", alarm08==1?"报警":"无", alarm08, true) ;
		node.alarm09 = this.createAlarmTextView("水压超限报警", alarm09==1?"报警":"无", alarm09, true) ;
		node.alarm10 = this.createAlarmTextView("水温仪表故障报警", alarm10==1?"报警":"无", alarm10, true) ;
		node.alarm11 = this.createAlarmTextView("终端 IC卡功能报警", alarm11==1?"报警":"无", alarm11, true) ;
		node.alarm12 = this.createAlarmTextView("定值控制报警", alarm12==1?"报警":"无", alarm12, true) ;
		node.alarm13 = this.createAlarmTextView("剩余水量的下限报警", alarm13==1?"报警":"无", alarm13, true) ;
		node.alarm14 = this.createAlarmTextView("终端箱门状态报警", alarm14==1?"报警":"无", alarm14, true) ;
		
		node.status01 = this.createAlarmTextView("终端的工作模式", status01==0?"自报遥测":(status01==1?"自报确认":(status01==2?"遥测":(status01==2?"调试维修":""))), status01, false) ;
		node.status02 = this.createAlarmTextView("IC卡功能是否有效", status02==1?"有效":"无效", status02, false) ;
		node.status03 = this.createAlarmTextView("定值控制是否投入", status03==1?"投入":"退出", status03, false) ;
		node.status04 = this.createAlarmTextView("水泵工作状态", status04==1?"停止":"启动", status04, false) ;
		node.status05 = this.createAlarmTextView("终端箱门状态", status05==1?"关闭":"开启", status05, false) ;
		node.status06 = this.createAlarmTextView("电源工作状态", status06==1?"蓄电池供电":"AC220V 供电", status06, false) ;

		return node ;
	}
//	d.getModelStatus(),//D0，D1—终端的工作模式。00H，终端在自报、遥测工作状态；01H，终端在自报确认工作状态；02H，—终端在遥测工作状态；03H，终端在调试或维修状态。
//	d.getIcCardStatus(),//D2—终端 IC 卡功能是否有效。0：无效；1：有效。
//	d.getBindValueStatus(),//D3—定值控制是否投入。0：退出；1：投入。
//	d.getPumpStatus(),//D4—水泵工作状态。 0：启动；1：停止。
//	d.getBoxDoorStatus(),//D5—终端箱门状态。0：开启；1：关闭。
//	d.getPowerStatus()// D6—电源工作状态。0：AC220V 供电；1：蓄电池供电。
	
	public Node createNode(int alarm01, int alarm02, int alarm03, int alarm04, int alarm05, int alarm06, int alarm07, int alarm08, int alarm09, int alarm10, int alarm11, int alarm12, int alarm13, int alarm14,
			int status01,int status02,int status03,int status04,int status05,int status06

			){
		Node node = new Node() ;
		node.alarmTitle = this.createAlarmTitleTextView("报警状态") ;
		
		node.alarm01 = this.createAlarmTextView("工作交流电停电告警", alarm01==1?"报警":"无", alarm01, true) ;
		node.alarm02 = this.createAlarmTextView("蓄电池电压报警", alarm02==1?"报警":"无", alarm02, true) ;
		node.alarm03 = this.createAlarmTextView("水位上下限报警", alarm03==1?"报警":"无", alarm03, true) ;
		node.alarm04 = this.createAlarmTextView("流量超限报警", alarm04==1?"报警":"无", alarm04, true) ;
		node.alarm05 = this.createAlarmTextView("水质超限报警", alarm05==1?"报警":"无", alarm05, true) ;
		node.alarm06 = this.createAlarmTextView("流量仪表故障报警", alarm06==1?"报警":"无", alarm06, true) ;
		node.alarm07 = this.createAlarmTextView("水泵开停状态", alarm07==1?"报警":"无", alarm07, true) ;
		node.alarm08 = this.createAlarmTextView("水位仪表故障报警", alarm08==1?"报警":"无", alarm08, true) ;
		node.alarm09 = this.createAlarmTextView("水压超限报警", alarm09==1?"报警":"无", alarm09, true) ;
		node.alarm10 = this.createAlarmTextView("水温仪表故障报警", alarm10==1?"报警":"无", alarm10, true) ;
		node.alarm11 = this.createAlarmTextView("终端 IC卡功能报警", alarm11==1?"报警":"无", alarm11, true) ;
		node.alarm12 = this.createAlarmTextView("定值控制报警", alarm12==1?"报警":"无", alarm12, true) ;
		node.alarm13 = this.createAlarmTextView("剩余水量的下限报警", alarm13==1?"报警":"无", alarm13, true) ;
		node.alarm14 = this.createAlarmTextView("终端箱门状态报警", alarm14==1?"报警":"无", alarm14, true) ;
		
		node.status01 = this.createAlarmTextView("终端的工作模式", status01==0?"自报遥测":(status01==1?"自报确认":(status01==2?"遥测":(status01==2?"调试维修":""))), status01, false) ;
		node.status02 = this.createAlarmTextView("IC卡功能是否有效", status02==1?"有效":"无效", status02, false) ;
		node.status03 = this.createAlarmTextView("定值控制是否投入", status03==1?"投入":"退出", status03, false) ;
		node.status04 = this.createAlarmTextView("水泵工作状态", status04==1?"停止":"启动", status04, false) ;
		node.status05 = this.createAlarmTextView("终端箱门状态", status05==1?"关闭":"开启", status05, false) ;
		node.status06 = this.createAlarmTextView("电源工作状态", status06==1?"蓄电池供电":"AC220V 供电", status06, false) ;

		Preferences p = Preferences.getInstance() ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "01", alarm01) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "02", alarm02) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "03", alarm03) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "04", alarm04) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "05", alarm05) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "06", alarm06) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "07", alarm07) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "08", alarm08) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "09", alarm09) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "10", alarm10) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "11", alarm11) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "12", alarm12) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "13", alarm13) ;
		p.putInt(Constant.func_vk_05_050_alarm_ + "14", alarm14) ;
		p.putInt(Constant.func_vk_05_050_status_ + "01", status01) ;
		p.putInt(Constant.func_vk_05_050_status_ + "02", status02) ;
		p.putInt(Constant.func_vk_05_050_status_ + "03", status03) ;
		p.putInt(Constant.func_vk_05_050_status_ + "04", status04) ;
		p.putInt(Constant.func_vk_05_050_status_ + "05", status05) ;
		p.putInt(Constant.func_vk_05_050_status_ + "06", status06) ;
		
		return node ;
	}
	public void addNode(LinearLayout contain, Node node){
		//分隔线
		node.gapView = new View(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
		lp.leftMargin = 6 ;
		lp.rightMargin = 6 ;
		node.gapView.setLayoutParams(lp) ;
		node.gapView.setBackgroundColor(Color.rgb(85, 163, 255)) ;
		contain.addView(node.gapView); 

		node.alarmTitleLinear = this.createLinearLayout(node.alarmTitle) ;
		contain.addView(node.alarmTitleLinear) ;
		
		node.alarmLinear01 = this.createLinearLayout(node.alarm01) ;
		contain.addView(node.alarmLinear01) ;
		
		node.alarmLinear02 = this.createLinearLayout(node.alarm02) ;
		contain.addView(node.alarmLinear02) ;
		
		node.alarmLinear03 = this.createLinearLayout(node.alarm03) ;
		contain.addView(node.alarmLinear03) ;
		
		node.alarmLinear04 = this.createLinearLayout(node.alarm04) ;
		contain.addView(node.alarmLinear04) ;
		
		node.alarmLinear05 = this.createLinearLayout(node.alarm05) ;
		contain.addView(node.alarmLinear05) ;
		
		node.alarmLinear06 = this.createLinearLayout(node.alarm06) ;
		contain.addView(node.alarmLinear06) ;
		
		node.alarmLinear07 = this.createLinearLayout(node.alarm07) ;
		contain.addView(node.alarmLinear07) ;
		
		node.alarmLinear08 = this.createLinearLayout(node.alarm08) ;
		contain.addView(node.alarmLinear08) ;
		
		node.alarmLinear09 = this.createLinearLayout(node.alarm09) ;
		contain.addView(node.alarmLinear09) ;
		
		node.alarmLinear10 = this.createLinearLayout(node.alarm10) ;
		contain.addView(node.alarmLinear10) ;
		
		node.alarmLinear11 = this.createLinearLayout(node.alarm11) ;
		contain.addView(node.alarmLinear11) ;
		
		node.alarmLinear12 = this.createLinearLayout(node.alarm12) ;
		contain.addView(node.alarmLinear12) ;
		
		node.alarmLinear13 = this.createLinearLayout(node.alarm13) ;
		contain.addView(node.alarmLinear13) ;
		
		node.alarmLinear14 = this.createLinearLayout(node.alarm14) ;
		contain.addView(node.alarmLinear14) ;
		
		node.statusLinear01 = this.createLinearLayout(node.status01) ;
		contain.addView(node.statusLinear01) ;
		
		node.statusLinear02 = this.createLinearLayout(node.status02) ;
		contain.addView(node.statusLinear02) ;
		
		node.statusLinear03 = this.createLinearLayout(node.status03) ;
		contain.addView(node.statusLinear03) ;
		
		node.statusLinear04 = this.createLinearLayout(node.status04) ;
		contain.addView(node.statusLinear04) ;
		
		node.statusLinear05 = this.createLinearLayout(node.status05) ;
		contain.addView(node.statusLinear05) ;
		
		node.statusLinear06 = this.createLinearLayout(node.status06) ;
		contain.addView(node.statusLinear06) ;
	}
	
	public void removeNode(LinearLayout contain, Node node){
		contain.removeView(node.gapView) ;
		contain.removeView(node.alarmTitleLinear) ;
		contain.removeView(node.alarmLinear01) ;
		contain.removeView(node.alarmLinear02) ;
		contain.removeView(node.alarmLinear03) ;
		contain.removeView(node.alarmLinear04) ;
		contain.removeView(node.alarmLinear05) ;
		contain.removeView(node.alarmLinear06) ;
		contain.removeView(node.alarmLinear07) ;
		contain.removeView(node.alarmLinear08) ;
		contain.removeView(node.alarmLinear09) ;
		contain.removeView(node.alarmLinear10) ;
		contain.removeView(node.alarmLinear11) ;
		contain.removeView(node.alarmLinear12) ;
		contain.removeView(node.alarmLinear13) ;
		contain.removeView(node.alarmLinear14) ;
		contain.removeView(node.statusLinear01) ;
		contain.removeView(node.statusLinear02) ;
		contain.removeView(node.statusLinear03) ;
		contain.removeView(node.statusLinear04) ;
		contain.removeView(node.statusLinear05) ;
		contain.removeView(node.statusLinear06) ;
		
		Preferences p = Preferences.getInstance() ;
		p.remove(Constant.func_vk_05_050_alarm_ + "01" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "02" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "03" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "04" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "05" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "06" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "07" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "08" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "09" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "10" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "11" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "12" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "13" ) ;
		p.remove(Constant.func_vk_05_050_alarm_ + "14" ) ;
		p.remove(Constant.func_vk_05_050_status_ + "01" ) ;
		p.remove(Constant.func_vk_05_050_status_ + "02" ) ;
		p.remove(Constant.func_vk_05_050_status_ + "03" ) ;
		p.remove(Constant.func_vk_05_050_status_ + "04" ) ;
		p.remove(Constant.func_vk_05_050_status_ + "05" ) ;
		p.remove(Constant.func_vk_05_050_status_ + "06" ) ;
	}
	
	
	private TextView createAlarmTitleTextView(String title){
		TextView tv = new TextView(act) ;
		tv.setText(title) ;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.tv_width_100), LinearLayout.LayoutParams.MATCH_PARENT);
		tv.setLayoutParams(lp) ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.label);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		tv.setCompoundDrawables(drawable, null, null, null) ;
		tv.setCompoundDrawablePadding(this.rs.getDimensionPixelOffset(R.dimen.common_drawablePadding3));
		
		tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL) ;
		
		tv.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		
		return tv ;
	}
	private TextView createAlarmTextView(String name, String alarmName, int isAlarm, boolean flag){
		TextView tv = new TextView(act) ;
		tv.setText(name + "：" + alarmName) ;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
		tv.setLayoutParams(lp) ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.dot);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		tv.setCompoundDrawables(drawable, null, null, null) ;
		tv.setCompoundDrawablePadding(this.rs.getDimensionPixelOffset(R.dimen.common_drawablePadding5));
		
		tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL) ;
		
		tv.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		
		if(isAlarm == 1 && flag){
			tv.setTextColor(Color.RED) ;
		}
		
		return tv ;
	}
	private LinearLayout createLinearLayout(TextView view){
		LinearLayout ll = new LinearLayout(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, this.rs.getDimensionPixelSize(R.dimen.common_line_height30));
		ll.setLayoutParams(lp) ;
		
		ll.addView(view) ;
		
		return ll ;
	}
	

}
