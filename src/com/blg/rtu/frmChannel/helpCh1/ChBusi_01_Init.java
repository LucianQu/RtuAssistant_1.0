package com.blg.rtu.frmChannel.helpCh1;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blg.rtu.frmChannel.ChFragment_01;
import com.blg.rtu3.R;

/**
 * frmChannel01初化划类
 * @author Administrator
 *
 */
public class ChBusi_01_Init {
	
	private ChFragment_01 chf ;
	
	public ChBusi_01_Init(ChFragment_01 chf){
		this.chf = chf ;
	}
	
	public void initView(Context ctx){
	/*	chf.btnGr = (RadioGroup) chf.view.findViewById(R.id.chSelectRadio);
		chf.btnSm = (RadioButton)chf.view.findViewById(R.id.chSm) ;
		chf.btnTcp = (RadioButton)chf.view.findViewById(R.id.chTcp) ;

		Preferences p = Preferences.getInstance() ;
		
		chf.phoneNumber = (EditText)chf.view.findViewById(R.id.chPhoneNumber) ;
		chf.phoneNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Constant.requestPhoneLen)});
		String str = p.getString(Constant.ch_vk_phone) ;
		if(!str.equals(Constant.errorStr)){
			chf.phoneNumber.setText(str) ; 
		}
	
		chf.ip1 = (EditText)chf.view.findViewById(R.id.tcpIp_1) ;
		chf.ip1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Constant.requestIpLen)});
		int v = p.getInt(Constant.ch_vk_ip1) ;
		if(v != Constant.errorInt){
			chf.ip1.setText(v + "") ; 
		}else{
			chf.ip1.setText(ctx.getResources().getString(R.string.wifi_ip1)) ; 
		}
		
		chf.ip2 = (EditText)chf.view.findViewById(R.id.tcpIp_2) ;
		chf.ip2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Constant.requestIpLen)});
		v = p.getInt(Constant.ch_vk_ip2) ;
		if(v != Constant.errorInt){
			chf.ip2.setText(v + "") ; 
		}else{
			chf.ip2.setText(ctx.getResources().getString(R.string.wifi_ip2)) ; 
		}
		
		chf.ip3 = (EditText)chf.view.findViewById(R.id.tcpIp_3) ;
		chf.ip3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Constant.requestIpLen)});
		v = p.getInt(Constant.ch_vk_ip3) ;
		if(v != Constant.errorInt){
			chf.ip3.setText(v + "") ; 
		}else{
			chf.ip3.setText(ctx.getResources().getString(R.string.wifi_ip3)) ; 
		}
		
		chf.ip4 = (EditText)chf.view.findViewById(R.id.tcpIp_4) ;
		chf.ip4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Constant.requestIpLen)});
		v = p.getInt(Constant.ch_vk_ip4) ;
		if(v != Constant.errorInt){
			chf.ip4.setText(v + "") ; 
		}else{
			chf.ip4.setText(ctx.getResources().getString(R.string.wifi_ip4)) ; 
		}
		
		chf.port = (EditText)chf.view.findViewById(R.id.tcpPort) ;
		chf.port.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Constant.requestPortLen)});
		v = p.getInt(Constant.ch_vk_port) ;
		if(v != Constant.errorInt){
			chf.port.setText(v + "") ; 
		}else{
			chf.port.setText(ctx.getResources().getString(R.string.wifi_port)) ; 
		}
		
		chf.progressBar = (ProgressBar) chf.view.findViewById(R.id.tcpProgress);*/
		/*chf.tcpConnect = (ImageView) chf.view.findViewById(R.id.tcpConnect);*/
		chf.paramProgress = (ProgressBar)chf.view.findViewById(R.id.paramProgress);
		chf.tcpConnectStatus = (TextView)chf.view.findViewById(R.id.tcpConnectStatus) ;
		chf.tcpConnectStatus.setText(chf.act.getResources().getString(R.string.tcpStatus) + chf.act.getResources().getString(R.string.noConnected)) ;	
		
		chf.out = (ImageView)chf.view.findViewById(R.id.asOut) ;
		chf.in = (ImageView)chf.view.findViewById(R.id.asIn) ;

	}
}
