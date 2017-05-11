package com.blg.rtu.frmFunction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd47_77.Data_47;
import com.blg.rtu.protocol.p206.cd47_77.Data_77;
import com.blg.rtu.protocol.p206.cd47_77.Param_47;
import com.blg.rtu.protocol.p206.cd47_77.Param_77;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_08_070  extends FrmParent {
	
	private final static int requestLen_1 = 1 ; //输入长度
	private final static int requestLen_9 = 9 ; //输入长度
	private TextView title ;

	//private EditText item01  ;
	private EditText item02 ;
	private EditText item03 ;
	//private EditText item04 ;
	

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_77 ;
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
		View view = inflater.inflate(R.layout.f_func_08_070, container, false);

		title = (TextView)view.findViewById(R.id.f_08_070_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_070_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_070_Load) ;
		
		//item01 = (EditText)view.findViewById(R.id.func_08_070_item01);
	/*	item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_070_01));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_070_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}*/
		
		item02 = (EditText)view.findViewById(R.id.func_08_070_item02);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_1)});
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_070_02));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_070_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		item03 = (EditText)view.findViewById(R.id.func_08_070_item03);
		item03.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_9)});
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_070_03));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_070_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}
		
		/*item04 = (EditText)view.findViewById(R.id.func_08_070_item04);
		item04.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_1)});
		item04.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_070_04));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_070_04) ;
		if(!str.equals(Constant.errorStr)){
			item04.setText(str); 
		}*/
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_070_dt) ;
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
		String value = item02.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "水表编号必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(value) ;
		if(v < 1 || v > 8){
			if(showDialog)new DialogAlarm().showDialog(act, "水表编号必须是1~8的数字！") ;
			return false ;
		}
		return true ;
	}
	
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeSet(boolean showDialog){
	/*	String value = item01.getText().toString() ;//整数部分
		
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "密码必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "密码范围必须是0~9999的数字！") ;
			return false ;
		}*/
		/////////////////////////////////////
		String /*value = item02.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "水表编号必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(value) ;
		if(v < 1 || v > 8){
			if(showDialog)new DialogAlarm().showDialog(act, "水表编号范围必须是1~8的数字！") ;
			return false ;
		}*/
		/////////////////////////////////////
		value = item03.getText().toString() ;//整数部分
		
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "负积流量必须填写！") ;
			return false ;
		} 
		value = value.replace(".", "") ;
		if(value.equals("00")) {
			value = "0" ;
		}
		int v = Integer.valueOf(value) ;
		if(v < 0 || v > 999999999){
			if(showDialog)new DialogAlarm().showDialog(act, "负积流量范围必须是0~999999999的数字！") ;
			return false ;
		}
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		Param_77 p = new Param_77() ;
		String value = item02.getText().toString() ;
		if(value == null || value.equals("")) {
			p.setMinusNum(1) ;
		}else{
			p.setMinusNum(Integer.valueOf(value)) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_77(p,null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_47 p = new Param_47() ;
	/*	String value = item01.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			p.setPassword("") ;
		}else{
			p.setPassword(value) ;
		}*/
		//////
		String /*value = item02.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			p.setLoraChannel(0) ;
		}else{
		
			p.setLoraChannel(Integer.valueOf(value)) ;
		}*/
		value = item03.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			p.setLoraChannel(0) ;
		}else{
			value = value.replace(".", "") ;
			if(value.equals("00")) {
				value = "0" ;
			}
			p.setWaterMinus(Long.valueOf(value)) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_47(p, null), false) ;
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
		long waterMinus;
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_77){
				Data_77 sd = (Data_77)subD ;
				if(sd.getWaterMinus() != null) {
				waterMinus = sd.getWaterMinus().longValue();
				if(waterMinus < 0) {
					waterMinus = - waterMinus;
					if ((waterMinus / 1000) > 0) {
						item03.setText(("-" + waterMinus / 1000) + "." + (waterMinus + 1000) % 1000) ;
					}else if((waterMinus / 1000) == 0){
						item03.setText("-0." + (waterMinus + 1000) % 1000) ;
					}
				}else{
					if ((waterMinus / 1000) > 0) {
						item03.setText((waterMinus / 1000) + "." + ((waterMinus%1000)/100 > 0 ? waterMinus%1000 :( 
								(waterMinus %100)/10 >0 ?("0" + waterMinus%1000): ("00" + (waterMinus%10 ==0?"0":waterMinus%1000)))));
					}else if((waterMinus / 1000) == 0){
						item03.setText("0" + "." + ((waterMinus%1000)/100 > 0 ? waterMinus%1000 :( 
								(waterMinus %100)/10 >0 ?("0" + waterMinus%1000): ("00" + (waterMinus%10 ==0?"0":waterMinus%1000)))));
					}
				}
				}else{
					item03.setText(sd.valueError) ;
				}
				//item02.setText(sd.getMinusNum()+"") ;
			}else if(subD instanceof Data_47){
				Data_47 sd = (Data_47)subD ;
				
				waterMinus = sd.getWaterMinus().longValue();
				if(waterMinus < 0) {
					waterMinus = - waterMinus;
					if ((waterMinus / 1000) > 0) {
						item03.setText(("-" + waterMinus / 1000) + "." + (waterMinus + 1000) % 1000) ;
					}else if((waterMinus / 1000) == 0){
						item03.setText("-0." + (waterMinus + 1000) % 1000) ;
					}
				}else{
					if ((waterMinus / 1000) > 0) {
						item03.setText((waterMinus / 1000) + "." + ((waterMinus%100)/100 > 0 ? waterMinus%1000 :( 
								(waterMinus %100)/10 >0 ?("0" + waterMinus%1000): ("00" + (waterMinus%10 ==0?"0":waterMinus%1000)))));
					}else if((waterMinus / 1000) == 0){
						item03.setText("0" + "." + ((waterMinus%100)/100 > 0 ? waterMinus%1000 :( 
								(waterMinus %100)/10 >0 ?("0" + waterMinus%1000): ("00" + (waterMinus%10 ==0?"0":waterMinus%1000)))));
					}
				}
				//item01.setText(sd.getPassword()) ;
				//item02.setText(sd.getLoraChannel()+"") ;
				//item04.setText("") ;
			}
		}
		Preferences.getInstance().putString(Constant.func_vk_08_070_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		//vo.setV_08_070_item01(item01.getText().toString()) ;
		vo.setV_08_070_item02(item02.getText().toString()) ;
		vo.setV_08_070_item03(item03.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		//item01.setText(vo.getV_08_070_item01()) ;
		item02.setText(vo.getV_08_070_item02()) ;
		item03.setText(vo.getV_08_070_item03()) ;
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