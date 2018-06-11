package com.blg.rtu.frmFunction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
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
import com.blg.rtu.protocol.p206.cdD3_3E.Data_D3_3E;
import com.blg.rtu.protocol.p206.cdD3_3E.Param_3E;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;
import com.blg.rtu3.server.CoreThread;

public class F_01_090 extends FrmParent {

	private TextView title ;
	private EditText item01 ;
	
	private ImageView btnRead ;
	private ImageView btnSet ;
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_D3;
	}
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
	}

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_01_090, container, false);
		
		title = (TextView)view.findViewById(R.id.f_01_090_Title);
		funcFrm = (FrameLayout)view.findViewById(R.id.f_01_090_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_01_090_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_01_090_item1) ;
		item01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(17)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_01_090_01) ;
		if(!str.equals(Constant.errorStr)) {
			item01.setText(str);
		}
		//item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_01_090_01));
		item01.addTextChangedListener(new TextWatcher(){
			private int strOldLen = 0 ;
			@Override
			public void afterTextChanged(Editable edt) {
				String str = edt.toString() ;
				int strNowLen = str.length() ;
				if(strNowLen > strOldLen){
					//不是删除操作
					if(strOldLen % 5 == 4){
						String str1 = str.substring(0, strNowLen - 1) ;
						String str2 = str.substring(strNowLen - 1) ;
						str = str1 + " " + str2 ;
						item01.setText(str) ;
						item01.setSelection(str.length()) ;
					}
				}
				if (str == null || str.equals("")) {
					Preferences.getInstance().remove(Constant.func_vk_01_090_01);
				} else {
					Preferences.getInstance().putString(Constant.func_vk_01_090_01, str);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				strOldLen = item01.getText().toString().length() ;
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
		});
		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		resultDt = (TextView) view.findViewById(R.id.resultDatetime) ;
		
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn) ;
		btnRead.setOnClickListener(btnReadLisn) ;
		
		str = Preferences.getInstance().getString(Constant.func_vk_01_090_dt) ;
		if(!str.equals(Constant.errorStr)) {
			this.resultDt.setText(str);
		}
		return view ;
	}

	/**
	 * 查询命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeQuery(boolean showDialog) {
		return true;
	}

	@Override
	protected boolean checkBeforeSet(boolean showDialog) {
		String meterSerical = item01.getText().toString() ;
		if(meterSerical == null || "".equals(meterSerical)) {
			if(showDialog)new DialogAlarm().showDialog(act, "出厂ID必须填写！") ;
			return false ;
		}
		
		if(meterSerical.replaceAll(" ", "").length() != 14) {
			if(showDialog)new DialogAlarm().showDialog(act, "出厂ID必须为14位数字！") ;
			return false ;
		}
		
		return true;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand() {
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_D3(null), false) ;
	}

	@Override
	protected void setCommand() {
		String meterSerical = item01.getText().toString() ;
		
		Param_3E p = new Param_3E() ;
		p.setWaterMeterSerial(meterSerical.replaceAll(" ", "")) ;
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_3E(p, null), false) ;
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	protected void commandHasProblem() {
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
		
	}
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	protected void commandSended() {
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null) ;
	}

	@Override
	public void commandSendedCallBack() {
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null);
	}

	@Override
	public void resetLabelImg() {
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null);
	}
	
	
	
	@Override
	public void receiveRtuData(RtuData d) {
		super.receiveRtuData(d);
		String waterMeterSerial;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null);
		Object subD = d.subData;
		if(subD != null) {
			if(subD instanceof Data_D3_3E) {
				Data_D3_3E sd = (Data_D3_3E)subD ;
				waterMeterSerial = sd.getWaterMeterSerial();
				if(waterMeterSerial != null) {
					item01.setText(waterMeterSerial);
				}else{
					item01.setText("");
				}
			}
		}
		Preferences.getInstance().putString(Constant.func_vk_01_090_dt, this.resultDt.getText().toString()) ;
	}



	@Override
	public void outSetData(Vo2Xml vo) {
	}

	@Override
	public void inSetData(Vo2Xml vo) {
	}



	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}



	@Override
	public void onResume() {
		super.onResume();
	}



	@Override
	public void onPause() {
		super.onPause();
	}



	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
}
