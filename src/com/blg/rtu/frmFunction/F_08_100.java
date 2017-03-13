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
import com.blg.rtu.protocol.p206.cd49_79.Data_49_79;
import com.blg.rtu.protocol.p206.cd49_79.Param_49;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class F_08_100  extends FrmParent {
	
	private final static int requestLen_4 = 4 ; //输入长度
	private TextView title ;

	private EditText item01 ;
	private EditText item02 ;
	private EditText item03 ;
	private EditText item04 ;
	private EditText item05 ;
	private EditText item06 ;
	private EditText item07 ;
	private EditText item08 ;
	private EditText item09 ;
	private EditText item10 ;
	
	private ImageView btnSet ;
	private ImageView btnRead ;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_79 ;
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
		View view = inflater.inflate(R.layout.f_func_08_100, container, false);

		title = (TextView)view.findViewById(R.id.f_08_100_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_08_100_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_08_100_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_08_100_item1);
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_01));
		
		String str = Preferences.getInstance().getString(Constant.func_vk_08_100_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		item02 = (EditText)view.findViewById(R.id.func_08_100_item2);
		item02.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_02));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_02) ;
		if(!str.equals(Constant.errorStr)){
			item02.setText(str); 
		}
		item03 = (EditText)view.findViewById(R.id.func_08_100_item3);
		item03.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_03));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_03) ;
		if(!str.equals(Constant.errorStr)){
			item03.setText(str); 
		}
		item04 = (EditText)view.findViewById(R.id.func_08_100_item4);
		item04.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item04.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_04));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_04) ;
		if(!str.equals(Constant.errorStr)){
			item04.setText(str); 
		}
		
		item05 = (EditText)view.findViewById(R.id.func_08_100_item5);
		item05.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item05.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_05));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_05) ;
		if(!str.equals(Constant.errorStr)){
			item05.setText(str); 
		}
		//////////////////////////////////////////
		item06 = (EditText)view.findViewById(R.id.func_08_100_item6);
		item06.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item06.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_06));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_06) ;
		if(!str.equals(Constant.errorStr)){
			item06.setText(str); 
		}
		
		item07 = (EditText)view.findViewById(R.id.func_08_100_item7);
		item07.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item07.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_07));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_07) ;
		if(!str.equals(Constant.errorStr)){
			item07.setText(str); 
		}
		item08 = (EditText)view.findViewById(R.id.func_08_100_item8);
		item08.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item08.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_08));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_08) ;
		if(!str.equals(Constant.errorStr)){
			item08.setText(str); 
		}
		item09 = (EditText)view.findViewById(R.id.func_08_100_item9);
		item09.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item09.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_09));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_09) ;
		if(!str.equals(Constant.errorStr)){
			item09.setText(str); 
		}
		
		item10 = (EditText)view.findViewById(R.id.func_08_100_item10);
		item10.setFilters(new InputFilter[]{new InputFilter.LengthFilter(requestLen_4)});
		item10.addTextChangedListener(new MyTextWatcher(Constant.func_vk_08_100_10));
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_10) ;
		if(!str.equals(Constant.errorStr)){
			item10.setText(str); 
		}
		/////////////////////////////////////////
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_08_100_dt) ;
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
		String 
		value = item01.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第一分区系数必须填写！") ;
			return false ;
		} 
		int v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第一分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item02.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第二分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第二分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item03.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第三分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第三分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item04.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第四分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第四分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item05.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第五分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "正向第五分区系数必须是0~9999的数字！") ;
			return false ;
		}
	////////////////////////////////////////////////////////////
		value = item06.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第一分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第一分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item07.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第二分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第二分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item08.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第三分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第三分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item09.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第四分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第四分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		value = item10.getText().toString() ;//整数部分
		if(value == null || value.equals("")){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第五分区系数必须填写！") ;
			return false ;
		} 
		v = Integer.valueOf(value) ;
		if(v < 0 || v > 9999){
			if(showDialog)new DialogAlarm().showDialog(act, "反向第五分区系数必须是0~9999的数字！") ;
			return false ;
		}
		
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		this.sendRtuCommand(new CommandCreator().cd_79(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_49 p = new Param_49() ;
		String 
		value = item01.getText().toString() ;//正向第一分区系数
		if(value == null || value.equals("")){
			p.setPlus1Partition(0) ;
		}else{
			p.setPlus1Partition(Integer.valueOf(value)) ;
		}
		value = item02.getText().toString() ;//正向第二分区系数
		if(value == null || value.equals("")){
			p.setPlus2Partition(0) ;
		}else{
			p.setPlus2Partition(Integer.valueOf(value)) ;
		}
		value = item03.getText().toString() ;//正向第三分区系数
		if(value == null || value.equals("")){
			p.setPlus3Partition(0) ;
		}else{
			p.setPlus3Partition(Integer.valueOf(value)) ;
		}
		value = item04.getText().toString() ;//正向第四分区系数
		if(value == null || value.equals("")){
			p.setPlus4Partition(0) ;
		}else{
			p.setPlus4Partition(Integer.valueOf(value)) ;
		}
		value = item05.getText().toString() ;//正向第五分区系数
		if(value == null || value.equals("")){
			p.setPlus5Partition(0) ;
		}else{
			p.setPlus5Partition(Integer.valueOf(value)) ;
		}
		////////////////////////////
		value = item06.getText().toString() ;//反向第一分区系数
		if(value == null || value.equals("")){
			p.setMinus1Partition(0) ;
		}else{
			p.setMinus1Partition(Integer.valueOf(value)) ;
		}
		value = item07.getText().toString() ;//反向第二分区系数
		if(value == null || value.equals("")){
			p.setMinus2Partition(0) ;
		}else{
			p.setMinus2Partition(Integer.valueOf(value)) ;
		}
		value = item08.getText().toString() ;//反向第三分区系数
		if(value == null || value.equals("")){
			p.setMinus3Partition(0) ;
		}else{
			p.setMinus3Partition(Integer.valueOf(value)) ;
		}
		value = item09.getText().toString() ;//反向第四分区系数
		if(value == null || value.equals("")){
			p.setMinus4Partition(0) ;
		}else{
			p.setMinus4Partition(Integer.valueOf(value)) ;
		}
		value = item10.getText().toString() ;//反向第五分区系数
		if(value == null || value.equals("")){
			p.setMinus5Partition(0) ;
		}else{
			p.setMinus5Partition(Integer.valueOf(value)) ;
		}
		
		this.sendRtuCommand(new CommandCreator().cd_49(p, null), false) ;
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
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item006(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		Object subD = d.subData ;
		if(subD != null){
			if(subD instanceof Data_49_79){
				Data_49_79 sd = (Data_49_79)subD ;
				item01.setText(sd.getPlus1Partition() + "") ;
				item02.setText(sd.getPlus2Partition() + "") ;
				item03.setText(sd.getPlus3Partition() + "") ;
				item04.setText(sd.getPlus4Partition() + "") ;
				item05.setText(sd.getPlus5Partition() + "") ;
				item06.setText(sd.getMinus1Partition() + "") ;
				item07.setText(sd.getMinus2Partition() + "") ;
				item08.setText(sd.getMinus3Partition() + "") ;
				item09.setText(sd.getMinus4Partition() + "") ;
				item10.setText(sd.getMinus5Partition() + "") ;
			}
		}
		Preferences.getInstance().putString(Constant.func_vk_08_100_dt, this.resultDt.getText().toString()) ;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		//vo.setV_05_070_item01(item01.getText().toString()) ;
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		//item01.setText(vo.getV_04_110_item01()) ;
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