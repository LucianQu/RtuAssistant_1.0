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
import com.blg.rtu.protocol.p206.cd40_70.Data_40;
import com.blg.rtu.protocol.p206.cd40_70.Data_70;
import com.blg.rtu.protocol.p206.cd40_70.Param_40;
import com.blg.rtu.protocol.p206.cd40_70.Param_70;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.InputFilter_DecimalSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;
import com.blg.rtu1.server.CoreThread;

public class F_08_080  extends FrmParent {
	
	private final static int requestLen_1 = 1 ; //输入长度

	private TextView title ;

	//private EditText item01  ;
	private EditText item02 ;
	private EditText item03 ;
	

	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_70 ;
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
		View view = inflater.inflate(R.layout.f_func_08_080, container, false);

		title = (TextView)view.findViewById(R.id.f_08_080_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_080_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_080_Load) ;
		
		/*item01 = (EditText)view.findViewById(R.id.func_08_080_item01);
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_080_01));*/
		
		/*String str = Preferences.getInstance().getString(Constant.func_vk_08_080_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}*/
		
		item02 = (EditText)view.findViewById(R.id.func_08_080_item02);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_1)});
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_080_02));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_080_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		
		item03 = (EditText)view.findViewById(R.id.func_08_080_item03);
		item03.setFilters(new InputFilter[]{new InputFilter_DecimalSigned(11)});
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_080_03));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_080_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_080_dt) ;
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
		/*String value = item01.getText().toString() ;//整数部分
		Double amount = null ;
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
		/*String value = item02.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "Lora通道必须填写！") ;
			return false ;
		} 
		
		int v = Integer.valueOf(value) ;
		if(v < 1 || v > 8){
			if(showDialog)new DialogAlarm().showDialog(act, "通道范围必须是1~8的数字！") ;
			return false ;
		}*/
		/////////////////////////////////////
		
		String value = item03.getText().toString() ;//整数部分
		
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "净积流量必须填写！") ;
			return false ;
		} 
		Double amount = null ;
		amount = Double.valueOf(value) ;
		if(amount > 999999.999 || amount < -999999.999){
			if(showDialog)new DialogAlarm().showDialog(act, " 设置净积超过合法取值范围(-999999.999～999999.999)！") ;
			return false ;
		}
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		Param_70 p = new Param_70() ;
		String value = item02.getText().toString() ;
		if(value == null || value.equals("")) {
			p.setPureNum(1) ;
		}else{
			p.setPureNum(Integer.valueOf(value)) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_70(p,null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_40 p = new Param_40() ;
		Double amount = null ;
		/*String value = item01.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			p.setPassword("") ;
		}else{
			p.setPassword(value) ;
		}*/
		//////
		/*value = item02.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			p.setLoraChannel(0) ;
		}else{
			p.setLoraChannel(Integer.valueOf(value)) ;
		}*/
		String value = item03.getText().toString() ;//整数部分
		amount = Double.valueOf(value) ;
		if(value == null || value.equals("")){
			p.setWaterPure(0.0) ;
		}else{
			p.setWaterPure(amount) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_40(p, null), false) ;
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

		Double amount ;
		long waterPure ;
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_40){
				Data_40 sd = (Data_40)subD ;
				amount = sd.getWaterPure().doubleValue();
				//item03.setText(amount + "") ;
				
				if(amount < 0) {
					amount = - amount;
					if ((amount / 1000) > 0) {
						item03.setText(("-" + amount / 1000) + "." + (amount + 1000) % 1000) ;
					}
				}else if(amount > 0){
					if ((amount / 1000) > 0) {
						item03.setText((amount / 1000) + "." + (amount + 1000) % 1000) ;
					}
				}else if(amount == 0) {
					item03.setText("0.0") ;
				}
				//item01.setText(sd.getPassword()) ;
				//item02.setText(sd.getLoraChannel()+"") ;
			}else{
				Data_70 sd = (Data_70)subD ;
				if(sd.getWaterPure() != null) {
					waterPure = sd.getWaterPure().longValue();
					if(waterPure < 0) {
						waterPure = - waterPure;
						if ((waterPure / 1000) > 0) {
							item03.setText(("-" + waterPure / 1000) + "." + (waterPure + 1000) % 1000) ;
						}else if((waterPure / 1000) == 0){
							item03.setText("-0." + (waterPure + 1000) % 1000) ;
						}
					}else{
						if ((waterPure / 1000) > 0) {
							item03.setText((waterPure / 1000) + "." + ((waterPure%1000)/100 > 0 ? waterPure%1000 :( 
									(waterPure %100)/10 >0 ?("0" + waterPure%1000): ("00" + (waterPure%10 ==0?"0":waterPure%1000)))));
						}else if((waterPure / 1000) == 0){
							item03.setText("0" + "." + ((waterPure%1000)/100 > 0 ? waterPure % 1000 :( 
									(waterPure %100)/10 >0 ?("0" + waterPure%1000): ("00" + (waterPure%10 ==0?"0":waterPure%1000)))));
						}
					}
				}else{
					item03.setText(sd.valueError) ;
				}
			}
		}
		Preferences.getInstance().putString(Constant.func_vk_08_080_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		//vo.setV_08_080_item01(item01.getText().toString()) ;
		vo.setV_08_080_item02(item02.getText().toString()) ;
		vo.setV_08_080_item03(item03.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		//item01.setText(vo.getV_08_080_item01()) ;
		item02.setText(vo.getV_08_080_item02()) ;
		item03.setText(vo.getV_08_080_item03()) ;
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