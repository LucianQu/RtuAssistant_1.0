package com.blg.rtu.frmChannel;



import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

public class ChFragment_02 extends Fragment {
	
	private MainActivity act ;
	
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
		view = inflater.inflate(R.layout.fch_02, container, false);
		
		startBtn = (ImageView)view.findViewById(R.id.aqStart) ;
		pauseBtn = (ImageView)view.findViewById(R.id.aqPause) ;
		resumeBtn = (ImageView)view.findViewById(R.id.aqResume) ;
		stopBtn = (ImageView)view.findViewById(R.id.aqStop) ;
		
		startBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoQuery(true, false, false, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		pauseBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoQuery(false, true, false, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		resumeBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoQuery(false, false, true, false) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		stopBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String info = act.mServerProxyHandler.operateAutoQuery(false, false, false, true) ;
				if(info != null){
					Toast.makeText(act, info, Toast.LENGTH_SHORT).show() ;
				}
			}
		}) ;
		
		statusView = (TextView)view.findViewById(R.id.aqStatus) ;
		
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
	 * 设置自动查询状态
	 * @param status
	 */
	public void setAutoQueryStatus(String status){
		statusView.setText(status) ;
	}

}
