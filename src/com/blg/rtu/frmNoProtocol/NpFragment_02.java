package com.blg.rtu.frmNoProtocol;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.StringValueForActivity;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class NpFragment_02 extends Fragment {
	/**
	 * 定义回调接口
	 * @author Administrator
	 *
	 */
	public interface NpFrgCallBackInterface_02{
		public com.blg.rtu.util.CallBackReturnVO callBack_ch02(String value)  ;
	}
	private MainActivity act ;
	@SuppressWarnings("unused")
	private NpFrgCallBackInterface_02 callBack ;
	
	private View view ;
	
	private ImageView flag ;
	private EditText npInput ;
	private ImageView sendBtn ;
	private ImageView clearBtn ;
	

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
		view = inflater.inflate(R.layout.fnp_02, container, false);
		flag = (ImageView)view.findViewById(R.id.npInputFlag) ;
		npInput = (EditText)view.findViewById(R.id.npInput) ;
		sendBtn = (ImageView)view.findViewById(R.id.npSend) ;
		clearBtn = (ImageView)view.findViewById(R.id.npClear) ;

		flag.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				act.npFragmentLinear_02.setVisibility(View.GONE) ;
				act.npFragmentLinear_03.setVisibility(View.VISIBLE) ;
				this.closeKeyboard() ;
			}
			//关闭软键盘  
			 private void closeKeyboard() {  
			     InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);  
			     imm.hideSoftInputFromWindow(npInput.getWindowToken(), 0);  
			}  
		}) ;
		
		sendBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				sendNoProtocolData() ;
			}
		}) ;
		
		clearBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clearNoProtocolData() ;
			}
		}) ;
		
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
	
	private void sendNoProtocolData(){
		if(StringValueForActivity.noProtocolSendNeedConfirm){
			new DialogConfirm().showDialog(act,
					act.getResources().getString(R.string.txtConfirmSend) ,
					new DialogConfirm.CallBackInterface(){
						@Override
						public void dialogCallBack(Object o) {
							if((Boolean)o){
								doSendNoProtocolData() ;
							}else{
							}
						}
				}) ;
		}else{
			doSendNoProtocolData() ;
		}
	}
	
	private void doSendNoProtocolData(){
		if(act.mServerProxyHandler != null && act.mServerProxyHandler.isTcpConnected()){
			String str = this.npInput.getText().toString() ;
			
			if(str == null || str.equals("")){
				Toast.makeText(act, "发送内容不能为空，请输入内容！", Toast.LENGTH_SHORT).show() ;
			}else{
				str = str.trim() ;
				if(str.equals("")){
					Toast.makeText(act, "发送内容不能为空，请输入内容！", Toast.LENGTH_SHORT).show() ;
				}else{
					this.act.mServerProxyHandler.sendRtuNoProtocolTxtDataByTcp(str) ;
				}
			}
		}else{
			Toast.makeText(act, "网络未连接，不能发送数据！", Toast.LENGTH_SHORT).show() ;
		}
	}
	private void clearNoProtocolData(){
		new DialogConfirm().showDialog(act,
				act.getResources().getString(R.string.txtConfirmClear) ,
				new DialogConfirm.CallBackInterface(){
					@Override
					public void dialogCallBack(Object o) {
						if((Boolean)o){
							npInput.setText("") ; 
						}else{
						}
					}
			}) ;
	}

}
