package com.blg.rtu.frmLoopQuery;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdF0.Data_F0;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
//import com.leaking.slideswitch.SlideSwitch;
//import com.leaking.slideswitch.SlideSwitch.SlideListener;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

public class LpFragment_01 extends Fragment {
	//implements SlideListener
	
	public MainActivity act ;
	
	public View view ;
	
	private Spinner item01;
	private ArrayAdapter<SpinnerVO> spinnerAdapter1;
	
	private Spinner item02;
	private ArrayAdapter<SpinnerVO> spinnerAdapter2;

	private TextView item03 ;
	
	private ImageView onceBtn ;
	private boolean onceStartFlag = false;
	private boolean loopStartFlag = false;
	//private ImageView startBtn ;
	//private ImageView stopBtn ;
	//SlideSwitch slide;
	
	private ProgressBar loopProgress ;

	private int sended;
	private int receiveed;
	
	private static LoopThread loopThread ;
	private static Object synObj ;
	
	private boolean startLoopQuery ;
	
	private int loopWaitSecond ;

	
 	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		
//		if(loopThread == null){
//			synObj = new Object() ;
//			
//			loopThread = new LoopThread(this) ;
//			loopThread.start() ;
//		}
		synObj = new Object() ;
		
		loopThread = new LoopThread(this) ;
		loopThread.start() ;
		
		
		startLoopQuery = false ;
		loopWaitSecond = Integer.MAX_VALUE ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sended = 0 ;
		receiveed = 0 ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.floopq_01, container, false);
		
		item01 = (Spinner)view.findViewById(R.id.f_01_010_item1);
		spinnerAdapter1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue1();
		spinnerAdapter1.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		item01.setAdapter(spinnerAdapter1);
		item01.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		//注意，此处取值，在LpFragment_03中也进行子同样的取值
		int type = Preferences.getInstance().getInt(Constant.loop_vk_01_010_01) ;
		if(type != Constant.errorInt){
			item01.setSelection(type); 
		}else{
			type = 0 ;
		}
		
		item02 = (Spinner)view.findViewById(R.id.f_01_010_item2);
		spinnerAdapter2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue2();
		spinnerAdapter2.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		item02.setAdapter(spinnerAdapter2);
		item02.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		int v = Preferences.getInstance().getInt(Constant.loop_vk_01_010_02) ;
		if(v != Constant.errorInt){
			item02.setSelection(v); 
		}
		
		item03 = (TextView)view.findViewById(R.id.f_01_010_item03);
		
		item03.setText(sended + "/" + receiveed) ;
		
	/*	startBtn = (ImageView)view.findViewById(R.id.lqStart);
		stopBtn = (ImageView)view.findViewById(R.id.lqStop);
		startBtn.setOnClickListener(new btnOnClickListener()) ;
		stopBtn.setOnClickListener(new btnOnClickListener()) ;
		*/
		loopProgress = (ProgressBar)view.findViewById(R.id.loopProgress);
		onceBtn = (ImageView)view.findViewById(R.id.lqOnce);
		onceBtn.setOnClickListener(new btnOnClickListener()) ;
		
		//slide = (SlideSwitch) view.findViewById(R.id.swit1);
		//slide.setState(false);
		//slide.setSlideListener(this);
		
		return view ;
	}
	
	private void putSpinnerValue1(){
		spinnerAdapter1.add(new SpinnerVO("0", "智能水表")) ;
		//spinnerAdapter1.add(new SpinnerVO("1", "地下水")) ;
	}
	
	private void putSpinnerValue2(){
		spinnerAdapter2.add(new SpinnerVO("4", "4秒")) ;
		spinnerAdapter2.add(new SpinnerVO("5", "5秒")) ;
		spinnerAdapter2.add(new SpinnerVO("6", "6秒")) ;
		spinnerAdapter2.add(new SpinnerVO("7", "7秒")) ;
		spinnerAdapter2.add(new SpinnerVO("8", "8秒")) ;
		spinnerAdapter2.add(new SpinnerVO("9", "9秒")) ;
		spinnerAdapter2.add(new SpinnerVO("10", "10秒")) ;
		spinnerAdapter2.add(new SpinnerVO("15", "15秒")) ;
		spinnerAdapter2.add(new SpinnerVO("20", "20秒")) ;
		spinnerAdapter2.add(new SpinnerVO("30", "30秒")) ;
		spinnerAdapter2.add(new SpinnerVO("60", "60秒")) ;
		spinnerAdapter2.add(new SpinnerVO("90", "90秒")) ;
		spinnerAdapter2.add(new SpinnerVO("120", "120秒")) ;
		spinnerAdapter2.add(new SpinnerVO("300", "300秒")) ;
	}
	
	private class SpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent.getId() == item01.getId()){
				Preferences.getInstance().putInt(Constant.loop_vk_01_010_01, position) ;
				if(position == LpConstant.queryType_diXia){
					queryTypeSet(LpConstant.queryType_diXia) ;
				}else if(position == LpConstant.queryType_zhiNeng){
					queryTypeSet(LpConstant.queryType_zhiNeng) ;
				}
				item03.setText(sended + "/" + receiveed) ;
				//下面这句去除，原因是：当人工选择查询类型后，然后开始查询，当收到数据后，程序会
				//重置查询类型选择，当所选类型与实际RTU类型不一致时，那将产生事件而调用本方法onItemSelected，
				//这时若存在下句，则将停止查询，而这种情况不需要停止查询的，所以去除下句
				//stopLoopQuery() ;
			}else if(parent.getId() == item02.getId()){
				Preferences.getInstance().putInt(Constant.loop_vk_01_010_02, position) ;
				SpinnerVO vo = (SpinnerVO)item02.getSelectedItem() ;
				loopWaitSecond = Integer.valueOf(vo.getId()) ;
			}
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}
	
	private class btnOnClickListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			if(onceBtn.getId() == v.getId()){
				if(!loopStartFlag){
					onceStartFlag = true;
					startLoopQuery() ;
					onceBtn.setVisibility(View.GONE) ;
					loopProgress.setVisibility(View.VISIBLE) ;
					act.mHandler.postDelayed(new Runnable() {
						public void run() {
							onceStartFlag = false;
							stopLoopQuery();
							loopProgress.setVisibility(View.GONE) ;
							onceBtn.setVisibility(View.VISIBLE) ;
						}
					}, 3500);
				}
			}
		}
	}
	
	private void startLoopQuery(){
		//int ch = act.frgTool.fragment_ch01.getSelectedChannel() ;
		int ch = Constant.channelTcp;
		if(ch == Constant.channelTcp){
			//tcp网络通信
			if(act.mServerProxyHandler != null && act.mServerProxyHandler.isTcpConnected()){
				String rtuId = act.mServerProxyHandler.getRtuId() ;
				if(rtuId == null){
					Toast.makeText(act, "后台服务还未得到终端地址，当前不能进行循环查询", Toast.LENGTH_SHORT).show() ;
				}else{
					doStartLoopQuery(rtuId) ;
				}
			}else{
				Toast.makeText(act, "网络未连接，不能进行循环查询", Toast.LENGTH_SHORT).show() ;
			}
		}else{
			Toast.makeText(act, "当前选择短信通道，不能进行循环查询", Toast.LENGTH_SHORT).show() ;
		}
	}
	
	private void doStartLoopQuery(String rtuId){
		//startBtn.setVisibility(View.GONE) ;
		//stopBtn.setVisibility(View.VISIBLE) ;
		//loopProgress.setVisibility(View.VISIBLE) ;
		sended = 0 ;
		receiveed = 0 ;
		
		startLoopQuery = true ;
		SpinnerVO vo = (SpinnerVO)item02.getSelectedItem() ;
		loopWaitSecond = Integer.valueOf(vo.getId()) ;
		
		synchronized(synObj){
			synObj.notifyAll() ;
		}
	}
	
	private void stopLoopQuery(){
		//startBtn.setVisibility(View.VISIBLE) ;
		//stopBtn.setVisibility(View.GONE) ;
		//loopProgress.setVisibility(View.GONE) ;
		
		startLoopQuery = false ;
		
		//通知后台，不再发送循环查询命令
		if(act != null && act.mServerProxyHandler != null){
			act.mServerProxyHandler.notSendCommandByCode(Code206.cd_F0) ;
		}
	}
	
	private void queryTypeSet(int type){
	/*	this.act.frgTool.fragment_loopq03.queryTypeSet(type) ;*/
	}
	
/*	@Override
	public void open() {
		// TODO Auto-generated method stub
		//txt.setText("first switch is opend, and set the second one is 'slideable'");
		//slide.setSlideable(true);
		startLoopQuery();
		loopStartFlag = true;
	}*/
/*
	@Override
	public void close() {
		// TODO Auto-generated method stub 
		//txt.setText("first switch is closed,and set the second one is 'unslideable'");
		//slide.setSlideable(false);
		stopLoopQuery();
		loopStartFlag = false;
	}*/
	
	@Override
	public void onResume() {
		super.onResume();
	}
	@Override
	public void onPause() {
		super.onPause();
		stopLoopQuery() ;
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	

	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	public void commandSendedCallBack(){
		this.sended++ ;
		item03.setText(sended + "/" + receiveed) ;
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
		Data_F0 sd = (Data_F0)d.subData ;
		Byte type = sd.getType() ;
		if(type != null){
			if(type.byteValue() == (byte)0xC3){
				//地下水
				item01.setSelection(LpConstant.queryType_diXia); 
				receiveed++ ;
				if(onceStartFlag) {
					onceStartFlag = false;
					stopLoopQuery();
					loopProgress.setVisibility(View.GONE) ;
					onceBtn.setVisibility(View.VISIBLE) ;
				}
			}else if(type.byteValue() == (byte)0xC4){
				//智能水表
				item01.setSelection(LpConstant.queryType_zhiNeng); 
				receiveed++ ;
				if(onceStartFlag) {
					onceStartFlag = false;
					stopLoopQuery();
					loopProgress.setVisibility(View.GONE) ;
					onceBtn.setVisibility(View.VISIBLE) ;
				}
			}
			item03.setText(sended + "/" + receiveed) ;
		}
	}
	
	public class LoopThread extends Thread{
		private LpFragment_01 frag ;
		
		public LoopThread(LpFragment_01 frag){
			this.frag = frag ;
		}
		
		public void run(){
			while(true){
				try{
					if(!startLoopQuery){
						synchronized(synObj){
							synObj.wait() ;
						}
					}
					if(startLoopQuery){
						this.frag.act.mHandler.post(new Runnable(){
							public void run(){
								//int ch = act.frgTool.fragment_ch01.getSelectedChannel() ;
								int ch =  Constant.channelTcp ;
								if(ch == Constant.channelTcp){
									//tcp网络通信
									if(act.mServerProxyHandler != null && act.mServerProxyHandler.isTcpConnected()){
										String rtuId = act.mServerProxyHandler.getRtuId() ;
										if(rtuId == null){
											Toast.makeText(act, "后台服务还未得到终端地址，当前不能进行循环查询", Toast.LENGTH_SHORT).show() ;
										}else{
											RtuCommand com = new CommandCreator().cd_F0(rtuId) ;
											act.mServerProxyHandler.sendRtuCommandByTcp(com) ;
										}
									}else{
										Toast.makeText(act, "网络未连接，不能进行循环查询", Toast.LENGTH_SHORT).show() ;
									}
								}else{
									Toast.makeText(act, "当前选择短信通道，不能进行循环查询", Toast.LENGTH_SHORT).show() ;
								}
							}
						});
						
						Thread.sleep(loopWaitSecond * 1000) ;
					}
					
				}catch(Exception e){
				}
			}
		}
	}

}

