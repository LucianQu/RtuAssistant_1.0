package com.blg.rtu.frmFunction;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.blg.rtu.compound.FixHeightListView;
import com.blg.rtu.help.HelpSaveSolidDataToFile;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdB1.DataList_B1;
import com.blg.rtu.protocol.p206.cdB1.Data_B1;
import com.blg.rtu.protocol.p206.cdB1.Param_B1;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;
import com.blg.rtu3.server.CoreThread;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TimePicker;

public class F_05_040 extends FrmParent {
	
	private TextView title ;
	
	private Spinner item01_1;
	private ArrayAdapter<SpinnerVO> spinnerAdapter;
	private int spinnerPosition ;
	
	private EditText item01_2;//参数编号

	private TextView item02_1 ;//开始年月日
	private TextView item02_2 ;//开始时
	private TextView item03_1 ;//截止年月日
	private TextView item03_2 ;//截止时

	private DatePickerDialog item02_1_dpd ;
	private DatePickerDialog item03_1_dpd ;
	
	private TimePickerDialog item02_2_tpd ;
	private TimePickerDialog item03_2_tpd ;
	

	private ImageView btnRead ;

	private FixHeightListView dataListView ;
	private F_05_040_ListViewAdapter dataListViewAdapter;
	public List<F_05_040_ListViewItem> dataList ;


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_B1 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
		
		final Calendar c = Calendar.getInstance();
		final int[] ymd = new int[]{c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)} ;
		item02_1_dpd = new DatePickerDialog(act, 
				new DatePickerDialog.OnDateSetListener(){
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					monthOfYear += 1 ;
					item02_1.setText(year + "-" + (monthOfYear < 10?("0" + monthOfYear):monthOfYear) + "-" + (dayOfMonth < 10?("0" + dayOfMonth):dayOfMonth)) ;
				}
			}, ymd[0], ymd[1], ymd[2]);
		
		item03_1_dpd = new DatePickerDialog(act, 
				new DatePickerDialog.OnDateSetListener(){
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					monthOfYear += 1 ;
					item03_1.setText(year + "-" + (monthOfYear < 10?("0" + monthOfYear):monthOfYear) + "-" + (dayOfMonth < 10?("0" + dayOfMonth):dayOfMonth)) ;
				}
			}, ymd[0], ymd[1], ymd[2]);
		
		
		item02_2_tpd = new TimePickerDialog(act,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    	item02_2.setText("" + (hourOfDay < 10?("0" + hourOfDay):hourOfDay) ) ;
                    	
                    }
            }, 0, 0, true) ;
		
		int hour = c.get(Calendar.HOUR_OF_DAY) ;
		item03_2_tpd = new TimePickerDialog(act,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    	item03_2.setText("" + (hourOfDay < 10?("0" + hourOfDay):hourOfDay) ) ;
                    	
                    }
            }, hour, 0, true) ;


	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_05_040, container, false);

		title = (TextView)view.findViewById(R.id.f_05_040_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_05_040_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_05_040_Load) ;

		item01_1 = (Spinner) view.findViewById(R.id.f_05_040_item01_1);
		spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue();
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		item01_1.setAdapter(spinnerAdapter);
		item01_1.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_05_040_01) ;
		if(v != Constant.errorInt){
			item01_1.setSelection(v); 
		}
		
		item01_2 = (EditText) view.findViewById(R.id.f_05_040_item01_2);
		item01_2.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(2)});

		String str = Preferences.getInstance().getString(Constant.func_vk_05_040_02) ;
		if(!str.equals(Constant.errorStr)){
			item01_2.setText(str); 
		}
		
		item01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_05_040_02));
		
		item02_1 = (TextView)view.findViewById(R.id.f_05_040_item02_1) ;
		item02_2 = (TextView)view.findViewById(R.id.f_05_040_item02_2) ;
		item03_1 = (TextView)view.findViewById(R.id.f_05_040_item03_1) ;
		item03_2 = (TextView)view.findViewById(R.id.f_05_040_item03_2) ;
		
		item02_1.setText(DateTime.yyyy_MM_dd()) ;
		item02_1.setOnClickListener(new OnClickListener(){public void onClick(View v){
			item02_1_dpd.show();
			} 
		});
		item02_2.setText("00") ;
		item02_2.setOnClickListener(new OnClickListener(){public void onClick(View v){
			item02_2_tpd.show();
			} 
		});
		
		
		item03_1.setText(DateTime.yyyy_MM_dd()) ;
		item03_1.setOnClickListener(new OnClickListener(){public void onClick(View v){
			item03_1_dpd.show();
			} 
		});
		item03_2.setText(DateTime.HH()) ;
		item03_2.setOnClickListener(new OnClickListener(){public void onClick(View v){
			item03_2_tpd.show();
			} 
		});

		
		
		dataList = new ArrayList<F_05_040_ListViewItem>() ;
		
		dataListView  = (FixHeightListView)view.findViewById(R.id.func_05_040_listView) ;
		
        int confHeight = Integer.parseInt(this.getResources().getString(R.string.rtuLogListViewHeight));
        //下面三句，适应不同分辩率的手机
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        float value = dm.scaledDensity;
        int height = (int)(value * confHeight) ;
        dataListView.setListViewHeight(height) ;
        
		dataListViewAdapter = new F_05_040_ListViewAdapter(this.act, this) ;
		dataListView.setAdapter(dataListViewAdapter);


		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_05_040_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		
		dataListView.setOnTouchListener(new OnTouchListener(){
		   @Override
		   public boolean onTouch(View v, MotionEvent event) {
			    int eventAction = event.getActionMasked();
			    switch(eventAction){
			    case MotionEvent.ACTION_DOWN:
			    	act.func_scrollView.requestDisallowInterceptTouchEvent(true);
			    	break;
			    case MotionEvent.ACTION_MOVE:
			    	break;
			    case MotionEvent.ACTION_UP:
			    	break;
			    case MotionEvent.ACTION_CANCEL:
			    	act.func_scrollView.requestDisallowInterceptTouchEvent(false);
			    	break;
			    default:
			    	break;
			    }
			    return false;//返回false,其他的控件就不滚动了
		   }
		});
		
		
		
		return view ;
	}
	
	private void putSpinnerValue(){
		/*spinnerAdapter.add(new SpinnerVO("0", "雨量参数")) ;
		spinnerAdapter.add(new SpinnerVO("1", "水位参数")) ;*/
		spinnerAdapter.add(new SpinnerVO("2", "流量（水量）参数")) ;
	/*	spinnerAdapter.add(new SpinnerVO("3", "流速参数")) ;
		spinnerAdapter.add(new SpinnerVO("4", "闸位参数")) ;
		spinnerAdapter.add(new SpinnerVO("5", "功率参数")) ;
		spinnerAdapter.add(new SpinnerVO("6", "气压参数")) ;
		spinnerAdapter.add(new SpinnerVO("7", "风速参数")) ;
		spinnerAdapter.add(new SpinnerVO("8", "水温参数")) ;
		//spinnerAdapter.add(new SpinnerVO("9" , "水质参数")) ;
		spinnerAdapter.add(new SpinnerVO("10", "土壤含水率参数")) ;
		spinnerAdapter.add(new SpinnerVO("11", "水压参数")) ;*/
	}
	
	public class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			spinnerPosition = position ;
			Preferences.getInstance().putInt(Constant.func_vk_05_040_01, position) ;
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}
	

	
	/**
	 * 查询命令前进行检查
	 * @param showDialog
	 * @return
	 */
	@Override
	protected boolean checkBeforeQuery(boolean showDialog){
		String str = item01_2.getText().toString() ;
		if(str == null || str.equals("")){
			if(showDialog){
				new DialogAlarm().showDialog(act, "出错，参数编号必须填写!") ;
			}
			return false ;
		}
		int number = Integer.valueOf(str) ;
		if(number < 1 || number > 15){
			if(showDialog){
				new DialogAlarm().showDialog(act, "出错，参数编号超出合法范围(1~15)") ;
			}
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
		return true ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
		String id = spinnerAdapter.getItem(spinnerPosition).getId() ;
		if(id == null || id.equals("")){
			return ;
		}
		int n = Integer.valueOf(id) ;
		Param_B1 param = new Param_B1() ;
		param.setDataType(n) ;
		
		param.setDataCount_0to15(Integer.valueOf(item01_2.getText().toString())) ;
		
		param.setStartDt(item02_1.getText().toString() + " " + item02_2.getText().toString()) ;
		param.setEndDt(item03_1.getText().toString() + " " + item03_2.getText().toString()) ;
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_B1(param, null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
		this.dataList.clear() ;
		this.dataListViewAdapter.notifyDataSetInvalidated();
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
	}
	/**
	 * 功能项右侧图标复原
	 */
	@Override
	public void resetLabelImg(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item005(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		
		if(this.dataList.size() > StringValueForActivity.B1ResultMaxCount){
			this.dataList.remove(0) ;
		}
		//文件存储
		File f = HelpSaveSolidDataToFile.getFile(act, DateTime.yyyy_MM_dd()) ;
		
		DataList_B1 sd = (DataList_B1)d.getSubData() ;
		F_05_040_ListViewItem itemStartDt = new F_05_040_ListViewItem(null, "开始时间：" + sd.getStartDt()) ;
		dataList.add(itemStartDt) ;
		HelpSaveSolidDataToFile.saveData(f, itemStartDt.dataStr) ;
		
		String dateStart = sd.getStartDt();
		Log.i("----开始时间", dateStart);
		byte[] dateBuff=dateStart.getBytes();
		
		
		F_05_040_ListViewItem itemEndDt = new F_05_040_ListViewItem(null, "截止时间：" + sd.getEndDt()) ;
		dataList.add(itemEndDt) ;
		HelpSaveSolidDataToFile.saveData(f, itemEndDt.dataStr) ;
		
		List<Data_B1> list = sd.getDatas() ;
		if(list != null){
			Iterator<Data_B1> it = list.iterator() ;
			Data_B1 data = null ;
			String vStr = null ;
			int count = 1 ;
			while(it.hasNext()){
				data = it.next() ;
				vStr = (data.valueDbl!=null?data.valueDbl.toString():(data.valueLng!=null?data.valueLng.toString():(data.valueFFF!=null?data.valueFFF:""))) ;
				vStr += data.fengXiang!= null?data.fengXiang.toString():"" ;
				vStr += data.valueUnit!= null?data.valueUnit:"" ;
				F_05_040_ListViewItem item = new F_05_040_ListViewItem(count++ , dateDisplay(count - 1,dateBuff) + "  " + sd.getDataName() + ":" + vStr) ;
				dataList.add(item) ;
				HelpSaveSolidDataToFile.saveData(f, item.dataStr) ;
			}
		}
		dataListViewAdapter.notifyDataSetInvalidated(); 	
    	//使listview停在最后一条数据
		dataListView.setSelection(dataList.size()-1) ;

		Preferences.getInstance().putString(Constant.func_vk_05_040_dt, this.resultDt.getText().toString()) ;
		
	}
	
	public  String dateDisplay(Integer index, byte[] b) {
		int year,month,day,hour,minute = 10;
		int n = 0 ;
		int dateBuffer[] = new int [4];
		int num = 0 ;
		year =  charToByte(b[n++]) * 1000 + charToByte(b[n++]) * 100 + 
				charToByte(b[n++]) * 10 + charToByte(b[n++]);
		n++;
		month = charToByte(b[n++]) * 10 + charToByte(b[n++]);
		n++;
		day = charToByte(b[n++]) * 10 + charToByte(b[n++]);
		n++;
		hour = charToByte(b[n++]) * 10 + charToByte(b[n++]);
		num = 0;
		dateBuffer[num++] = year;
		dateBuffer[num++] = month;
		dateBuffer[num++] = day;
		dateBuffer[num++] = hour;
		
	/*	if(index <= 12 && index > 6) {
			num = 1;
			dateBuffer = Increase_Hour(dateBuffer , num);
		}else if(index > 12 && index <= 18) {
			num = 2;
			dateBuffer = Increase_Hour(dateBuffer , num);
		}*/
		num = (index - 1) / 2 ;
		if(num > 0 && num <=8) {
			dateBuffer = Increase_Hour(dateBuffer , num);
		}
		
		
		//minute = index <= 6 ? minute * (index - 1) : (index <= 12 ? minute * (index - 7) : minute * (index - 13));
		minute = index%2 == 1 ? 0 : 30;
		
		return dateBuffer[0] + "-" + (dateBuffer[1] < 10 ? "0" + dateBuffer[1] : dateBuffer[1])+ "-" 
				+ (dateBuffer[2] < 10 ? "0" + dateBuffer[2] : dateBuffer[2]) + "  " + 
				(dateBuffer[3] < 10 ? "0" + dateBuffer[3] : dateBuffer[3]) + " " + ":" + " "+ 
				(minute < 10 ? "0" + minute : minute) + "  ";
	}
	
	private static int charToByte(byte b) {
		if(b >= 48 && b <= 57) {
			b = (byte)(b - 48);		
		}else if(b >= 65 && b <= 90) {
			b = (byte)(b - 55);
		}else if(b >= 97 && b <= 122) {
			b = (byte)(b - 87);
		}
		return b;
	}
	
	private static int[] Increase_Hour(int[] b , int hourAddNum) {
		int Year,Month,DayOfMonth,Hours,n = 0;
		Year = b[n++];
		Month = b[n++];
		DayOfMonth = b[n++];
		Hours = b[n++];
		for(int i = 0; i < hourAddNum; i++) {
	        Hours++;
	        if(Hours > 23)
	        {
	            Hours = 0;
	            DayOfMonth++;
	            switch (Month)
	            {
	                case 1:
	                case 3:
	                case 5:
	                case 7:
	                case 8:
	                case 10:
	                case 12:
	                    if(DayOfMonth > 31)
	                    {
	                        DayOfMonth = 1;
	                        Month++;
	                        if(Month > 12)
	                        {
	                            Month = 1;
	                            Year++;
	                        }
	                    }
	                    break;
	                case 4:
	                case 6:
	                case 9:
	                case 11:
	                    if (DayOfMonth > 30)
	                    {
	                        DayOfMonth = 1;
	                        Month++;
	                    }
	                    break;
	                case 2:
	                    if((((Year%4)==0)&&((Year%100)!=0))||(Year%400==0))
	                    {
	                        if(DayOfMonth > 29)
	                        {
	                            DayOfMonth = 1;
	                            Month++;
	                        }
	                    }
	                    else
	                    {
	                        if(DayOfMonth > 28)
	                        {
	                            DayOfMonth=1;
	                            Month++;
	                        }
	                    }
	                    break;
	                default:
	                    break;
	            }
	        }
	    
		}
		n = 0;
		b[n++] = Year;
		b[n++] = Month;
		b[n++] = DayOfMonth;
		b[n++] = Hours;
		return b;
	}
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		
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
