package com.blg.rtu.frmFunction;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.compound.FixHeightListView;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdED.DataList_ED;
import com.blg.rtu.protocol.p206.cdED.Data_ED;
import com.blg.rtu.protocol.p206.cdED.Param_ED;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;
import com.blg.rtu2.server.CoreThread;

public class F_05_060  extends FrmParent {
	
	private final static int requestLen_4 = 4 ; 

	private TextView title ;

	private EditText item01  ;

	private ImageView btnRead ;
	
	private FixHeightListView logListView ;
	private F_05_060_ListViewAdapter logListViewAdapter;
	public List<F_05_060_ListViewItem> logList ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_ED ;
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
		View view = inflater.inflate(R.layout.f_func_05_060, container, false);

		title = (TextView)view.findViewById(R.id.f_05_060_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_05_060_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_05_060_Load) ;
		
		item01 = (EditText)view.findViewById(R.id.func_05_060_item01);
		item01.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(requestLen_4)});
		
		String str = Preferences.getInstance().getString(Constant.func_vk_05_060_01) ;
		if(!str.equals(Constant.errorStr)){
			item01.setText(str); 
		}
		
		item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_05_060_01));
		
		
		logList = new ArrayList<F_05_060_ListViewItem>() ;
		
		logListView  = (FixHeightListView)view.findViewById(R.id.func_05_060_listView) ;
		
        int confHeight = Integer.parseInt(this.getResources().getString(R.string.rtuLogListViewHeight));
        //下面三句，适应不同分辩率的手机
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        float value = dm.scaledDensity;
        int height = (int)(value * confHeight) ;
        logListView.setListViewHeight(height) ;
        
		logListViewAdapter = new F_05_060_ListViewAdapter(this.act, this) ;
		logListView.setAdapter(logListViewAdapter);


		
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnRead.setOnClickListener(btnReadLisn);
		
		str = Preferences.getInstance().getString(Constant.func_vk_05_060_dt) ;
		if(str != Constant.errorStr){
			this.resultDt.setText(str) ;
		}
		
		
		logListView.setOnTouchListener(new OnTouchListener(){
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

	
	/**
	 * 查询命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeQuery(boolean showDialog){
		String num = item01.getText().toString() ; 

		if(num == null || num.equals("")){
			if(showDialog){
				if(showDialog)new DialogAlarm().showDialog(act, "查询日志条数必须填写！") ;
			}
			return false ;
		} 
		
		int h = Integer.valueOf(num) ;
		if(h < 0 || h > 1024){
			if(showDialog){
				if(showDialog)new DialogAlarm().showDialog(act, "查询日志条数必须是1~1024数字！") ;
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
		String num = item01.getText().toString() ; 

		Param_ED p = new Param_ED() ;
		if(num == null || num.equals("")){
			p.setCount_0to1024(1) ;
		}else{
			p.setCount_0to1024(Integer.valueOf(num)) ;
		}
		CoreThread.getInstance().newRtuId(F_01_100.getInstance().getRtuSelectedItem().replaceAll(" ", ""));
		this.sendRtuCommand(new CommandCreator().cd_ED(p, null), false) ;
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
		this.logList.clear() ;
		this.logListViewAdapter.notifyDataSetInvalidated();
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
		
		if(this.logList.size() > StringValueForActivity.EDResultMaxCount){
			this.logList.remove(0) ;
		}
		DataList_ED sd = (DataList_ED)d.subData ;
		List<Data_ED> list = sd.getDatas() ;
		if(list != null){
			Iterator<Data_ED> it = list.iterator() ;
			F_05_060_ListViewItem lastData = null ;
			if(!logList.isEmpty()){
				lastData = logList.get(logList.size() - 1) ;
			}
			Data_ED data = null ;
			Integer index = 0 ;
			int ca = 0 ;
			Boolean lose = false ;
			while(it.hasNext()){
				data = it.next() ;
				index = data.getIndex() ;
				
				if(lastData != null){
					ca = index - lastData.index ;
					if(ca != 1 && ca != -1 && (index != 0 && index != 255)){
						lose = true ;
					}
				}
				F_05_060_ListViewItem item = new F_05_060_ListViewItem(index, "日期：" + data.getDateTime(), data.getTypeNum(), lose,data.getContentType(),(data.getCommentsType() == null ? " " : data.getCommentsType())); 
				logList.add(item) ;
				
				lastData = item ;
				lose = false ;
			}
		}
        
		logListViewAdapter.notifyDataSetInvalidated(); 	
    	//使listview停刷新出的最后一条数据
		logListView.setSelection(logList.size()-1) ;

		Preferences.getInstance().putString(Constant.func_vk_05_060_dt, this.resultDt.getText().toString()) ;
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