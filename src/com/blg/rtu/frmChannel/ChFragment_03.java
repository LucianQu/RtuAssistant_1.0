package com.blg.rtu.frmChannel;



//import java.io.File;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class ChFragment_03 extends Fragment {
	
	private MainActivity act ;
	
//	private ImageView out ;
//	private ImageView in ;
	private ImageView startBtn ;
	private ImageView pauseBtn ;
	private ImageView resumeBtn ;
	private ImageView stopBtn ;
	
	private TextView statusView ;
	
	private View view ;
	
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
		view = inflater.inflate(R.layout.fch_03, container, false);
		
//		out = (ImageView)view.findViewById(R.id.asOut) ;
//		in = (ImageView)view.findViewById(R.id.asIn) ;
		startBtn = (ImageView)view.findViewById(R.id.asStart) ;
		pauseBtn = (ImageView)view.findViewById(R.id.asPause) ;
		resumeBtn = (ImageView)view.findViewById(R.id.asResume) ;
		stopBtn = (ImageView)view.findViewById(R.id.asStop) ;
		
//		out.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				if(HelpSaveSetDataToFile.isFileExist(act)){
//					new DialogConfirm().showDialog(act,
//						act.getResources().getString(R.string.txtConfirmReplaceSetData) ,
//						new DialogConfirm.CallBackInterface(){
//							@Override
//							public void dialogCallBack(Object o) {
//								if((Boolean)o){
//									saveOutFile();
//								}else{
//								}
//							}
//					}) ;			
//				}else{
//					saveOutFile();
//				}
//			}
//			private void saveOutFile(){
//				try{
//					String xml = new Help().out(act) ;
//					File f = HelpSaveSetDataToFile.getFile(act) ;
//					HelpSaveSetDataToFile.saveData(f, xml) ;
//					Toast.makeText(act, "导出命令数据成功", Toast.LENGTH_SHORT).show() ;
//				}catch(Exception e){
//					Toast.makeText(act, "导出命令数据失败", Toast.LENGTH_SHORT).show() ;
//					Log.e(ChFragment_03.class.getName(), "导出命令数据失败", e) ;
//				}
//			}
//		}) ;
//		in.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				if(!HelpSaveSetDataToFile.isFileExist(act)){
//					new DialogAlarm().showDialog(act, act.getResources().getString(R.string.txtAlarmNoSetDataFile)) ;			
//				}else{
//					new DialogConfirm().showDialog(act,
//						act.getResources().getString(R.string.txtConfirmInSetData) ,
//						new DialogConfirm.CallBackInterface(){
//							@Override
//							public void dialogCallBack(Object o) {
//								if((Boolean)o){
//									readInFile();
//								}else{
//								}
//							}
//					}) ;
//				}
//			}
//			private void readInFile(){
//				try{
//					File f = HelpSaveSetDataToFile.getFile(act) ;
//					new Help().in(act, f) ;
//					Toast.makeText(act, "导入命令数据成功", Toast.LENGTH_SHORT).show() ;
//				}catch(Exception e){
//					Toast.makeText(act, "导入命令数据失败", Toast.LENGTH_SHORT).show() ;
//					Log.e(ChFragment_03.class.getName(), "导入命令数据失败", e) ;
//				}
//			}
//		}) ;
		startBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoSet(true, false, false, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		pauseBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoSet(false, true, false, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		resumeBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoSet(false, false, true, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		stopBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoSet(false, false, false, true) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		
		statusView = (TextView)view.findViewById(R.id.asStatus) ;
		
		return view ;
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
	
	/**
	 * 设置自动设置状态
	 * @param status
	 */
	public void setAutoSetStatus(String status){
		statusView.setText(status) ;
	}

}
