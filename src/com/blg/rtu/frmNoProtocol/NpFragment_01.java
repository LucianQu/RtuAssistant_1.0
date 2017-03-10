package com.blg.rtu.frmNoProtocol;


import java.io.File;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.blg.rtu.help.HelpSaveNoProtocolDataToFile;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class NpFragment_01 extends Fragment {
	
	private MainActivity act ;
	
	private View view ;
	
	private ScrollView scrollView ;
	
	private TextView noProtocolData ;
	

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
		view = inflater.inflate(R.layout.fnp_01, container, false);
		scrollView = (ScrollView)view.findViewById(R.id.noProtocolDataScroll) ;
		noProtocolData = (TextView)view.findViewById(R.id.noProtocolData) ;
		return view ;
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
	 * 收到非协议（调试）数据
	 * @param data
	 */
	public void receiveNoProtocolData(byte[] data){
		if(data != null && data.length > 0){
//			String str = ChangeCode.changeGBK2UTF8( new String(data)) ;
			String str = new String(data) ;
			String txt = noProtocolData.getText().toString() ;
			int txtLen = txt.length() ;
			if(txtLen > StringValueForActivity.noProtocolTxtMaxLen){
				txt = txt.substring(txtLen - StringValueForActivity.noProtocolTxtMaxLen) ;
				noProtocolData.setText(txt) ;
			}
			noProtocolData.append(str) ;
			
			scrollView.fullScroll(ScrollView.FOCUS_DOWN); //滚动到底部
			//scrollView.fullScroll(ScrollView.FOCUS_UP); //滚动到顶部
			
			//文件存储
			File f = HelpSaveNoProtocolDataToFile.getFile(act, DateTime.yyyy_MM_dd()) ;
			HelpSaveNoProtocolDataToFile.saveData(f, str) ;
		}
	}
	

}
