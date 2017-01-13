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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.automic.watersource.utils.Utils;
import com.blg.rtu.LoginActivity;
import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
//import com.blg.rtu.help.HelpSaveSetDataToFile;
//import com.blg.rtu.util.DialogConfirm;
//import com.blg.rtu.util.DialogAlarm;
//import com.blg.rtu.vo2xml.Help;
import com.blg.rtu.SplashActivity;

public class ChFragment_05 extends Fragment {
	private MainActivity act ;
	private LinearLayout ll_exit;
		
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
		view = inflater.inflate(R.layout.fch_05, container, false);
		ll_exit = (LinearLayout) view.findViewById(R.id.exitSystem) ;
		
		ll_exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 LoginActivity.instance.setCbSaveStatus(false);
				 Intent intent = new Intent(MainActivity.instance, LoginActivity.class);
		          startActivity(intent);
		          MainActivity.instance.finish();
			}
		});
		
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
	
	
	

}
