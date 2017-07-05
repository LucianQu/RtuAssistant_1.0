package com.blg.rtu.frmChannel;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.blg.rtu.frmChannel.helpCh4.ListRtuData;
import com.blg.rtu.frmChannel.helpCh4.RtuDataListViewAdapter;
import com.blg.rtu.compound.FixHeightListView;
import com.blg.rtu.help.HelpSaveProtocolDataToFile;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class ChFragment_04 extends Fragment {
	/**
	 * 定义回调接口
	 * @author Administrator
	 *
	 */
	public interface ChFrgCallBackInterface_04{
		public com.blg.rtu.util.CallBackReturnVO callBack_ch02(String value)  ;
	}
	private MainActivity act ;
	@SuppressWarnings("unused")
	private ChFrgCallBackInterface_04 callBack ;
	private View view ;
	
	private FixHeightListView rtuDatasListView ;
	private RtuDataListViewAdapter rtuDatasListViewAdapter;
	public List<ListRtuData> rtuDatas ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.callBack = (ChFrgCallBackInterface_04)this.act.getFrgCallback() ;
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
		view = inflater.inflate(R.layout.fch_04, container, false);
		
		rtuDatas = new ArrayList<ListRtuData>() ;
		
		rtuDatasListView  = (FixHeightListView)this.view.findViewById(R.id.chRtuDataListView) ;
		
		setRtuDatasListViewHeight(ResourceUtils.getXmlDef(act, R.dimen.ch_rtuDataListViewHeight_big)) ;
        
        rtuDatasListViewAdapter = new RtuDataListViewAdapter(this.act, this) ;
		rtuDatasListView.setAdapter(rtuDatasListViewAdapter);


		rtuDatasListView.setOnItemClickListener(new OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
	        	rtuDataClicked(view, position) ;
	        }
	    });
		
		rtuDatasListView.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				act.pageView_channel_OnLongClick() ;
				return false;
			}
		}) ;
		
		return view ;
	}
	/**
	 * 设置listView高
	 * @param confHeight
	 */
	public void setRtuDatasListViewHeight(int confHeight){
	        //下面三句，适应不同分辩率的手机
	        DisplayMetrics dm = this.getResources().getDisplayMetrics();
	        float value = dm.scaledDensity;
	        int height = (int)(value * confHeight) ;
	        rtuDatasListView.setListViewHeight(height) ;
	}
	
	public boolean isTcpConnected(){
		return true ;
	}
	public void sendDataByTcp(String s){
		
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
	@Override  
    public void onActivityResult(int requestCode, int resultCode, Intent data) {  
    }
	
	
	private void rtuDataClicked(View view, int position){
		for(ListRtuData vo : rtuDatas){
			vo.clicked = false ;
		}
		ListRtuData vo = rtuDatas.get(position);
		if(vo != null){
			vo.clicked = true ;
    	}
		//act.getSoundAlert().playDing() ;
		rtuDatasListViewAdapter.notifyDataSetInvalidated(); 
	}
	
	/**
	 * 接收到RTU数据
	 * @param data
	 */
	public void setRtuData(RtuData data){
		ListRtuData vo = new ListRtuData() ;
		vo.direct = Constant.derictUp ;
		//vo.direct = "命令" ;
		vo.channel = Constant.channelType(data.channelType.intValue()) ;
		vo.dt = DateTime.yyyy_MM_dd_HH_mm_ss() ;
		vo.rtuId = data.rtuId ;
		vo.code = data.dataCode ;
		vo.hex = data.hex ;
       
		vo.clicked = false ;
		
		if(rtuDatas.size() > StringValueForActivity.rutResultMaxCount){
			rtuDatas.remove(0) ;
		}
		rtuDatas.add(vo) ;
        
		rtuDatasListViewAdapter.notifyDataSetInvalidated(); 	
    	//使listview停刷新出的最后一条数据
		rtuDatasListView.setSelection(rtuDatas.size()-1) ;
		
		//文件存储
		File f = HelpSaveProtocolDataToFile.getFile(act, DateTime.yyyy_MM_dd()) ;
		HelpSaveProtocolDataToFile.saveData(f, vo) ;
	}
	
	/**
	 * 回传来的命令数据
	 * @param data
	 */
	public void setSendBackCommandData(RtuData data){
		ListRtuData vo = new ListRtuData() ;
		vo.direct = Constant.derictDown ;
		vo.channel = Constant.channelType(data.channelType.intValue()) ;
		vo.dt = DateTime.yyyy_MM_dd_HH_mm_ss() ;
		vo.rtuId = data.rtuId ;
		vo.code = data.dataCode ;
		vo.hex = data.hex ;
       
		vo.clicked = false ;
		
		rtuDatas.add(vo) ;
        
		rtuDatasListViewAdapter.notifyDataSetInvalidated(); 	
    	//使listview停刷新出的最后一条数据
		rtuDatasListView.setSelection(rtuDatas.size()-1) ;

		//文件存储
		File f = HelpSaveProtocolDataToFile.getFile(act, DateTime.yyyy_MM_dd()) ;
		HelpSaveProtocolDataToFile.saveData(f, vo) ;
	}

}
