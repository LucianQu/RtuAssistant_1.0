package com.blg.rtu.frmFunction;


import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blg.rtu.frmChannel.ChFragment_01;
import com.blg.rtu.frmChannel.ChFragment_03;
import com.blg.rtu.frmChannel.helpCh1.ChBusi_01_Operate;
import com.blg.rtu.help.HelpSaveSetDataToFile;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.vo2xml.Help;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class F_07_010  extends FrmParent {
	public ChBusi_01_Operate chb;
	public ChFragment_01 chf;
	private TextView title ;
	
	private ProgressBar inProgress ;
	private ProgressBar outProgress ;
	
	private ImageView btn_in ;
	private ImageView btn_out ;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.queryCommandCode = Code206.cd_C2 ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cntFrmOpened = false ;
		loading = false ;
		chf = new ChFragment_01();
		chf.onAttach(this.act);
		chb = new ChBusi_01_Operate(chf) ;
	}

	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_func_07_010, container, false);

		title = (TextView)view.findViewById(R.id.f_07_010_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_07_010_Frm) ;
		inProgress = (ProgressBar)view.findViewById(R.id.paramInProgress);
		outProgress = (ProgressBar)view.findViewById(R.id.outProgress);
		
		btn_in = (ImageView)view.findViewById(R.id.btn_in);
		btn_out= (ImageView)view.findViewById(R.id.btn_out);
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
	
		btn_in.setOnClickListener(btnInLisn);
		btn_out.setOnClickListener(btnOutLisn);
		chb.toConnectNet();
		return view ;
	}

	//设置按钮点击事件
	protected Button.OnClickListener btnInLisn = new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			btn_in.setVisibility(View.GONE);
			inProgress.setVisibility(View.VISIBLE);
			if(!HelpSaveSetDataToFile.isInFileExist(chf.act)){
				new DialogAlarm().showDialog(chf.act, chf.act.getResources().getString(R.string.txtAlarmNoSetDataFile) + 
						"\n" + "请确认导入路径是否有文件：" + "\n" + "路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath()) ;	
				btn_in.setVisibility(View.VISIBLE) ;
				inProgress.setVisibility(View.GONE) ;
			}else{
				new DialogConfirm().showDialog(chf.act,
						chf.act.getResources().getString(R.string.txtConfirmInSetData) + "\n" +
				"导入路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath(),
					new DialogConfirm.CallBackInterface(){
						@Override
						public void dialogCallBack(Object o) {
							if((Boolean)o){
								readInFile();
							}else{
								btn_in.setVisibility(View.VISIBLE) ;
								inProgress.setVisibility(View.GONE) ;
							}
						}
				}) ;
			}
		}
		private void readInFile(){
			try{
				File f = HelpSaveSetDataToFile.getInFile(chf.act) ;
				new Help().in(chf.act, f) ;
				btn_in.setVisibility(View.VISIBLE) ;
				inProgress.setVisibility(View.GONE) ;
				Toast.makeText(chf.act, "导入命令数据成功", Toast.LENGTH_SHORT).show() ;
			}catch(Exception e){
				btn_in.setVisibility(View.VISIBLE) ;
				inProgress.setVisibility(View.GONE) ;
				Toast.makeText(chf.act, "导入命令数据失败", Toast.LENGTH_SHORT).show() ;
				Log.e(ChFragment_03.class.getName(), "导入命令数据失败", e) ;
			}
		}
	} ;
	
	//设置按钮点击事件
		protected Button.OnClickListener btnOutLisn = new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				btn_out.setVisibility(View.GONE) ;
				outProgress.setVisibility(View.VISIBLE) ;
				if(HelpSaveSetDataToFile.isInFileExist(chf.act)){
					new DialogConfirm().showDialog(chf.act,
							chf.act.getResources().getString(R.string.txtConfirmReplaceSetData) + "\n" + 
							"导出路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath(),
						new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){
									saveOutFile();
								}else{
									btn_out.setVisibility(View.VISIBLE) ;
									outProgress.setVisibility(View.GONE) ;
								}
							}
					}) ;			
				}else{
					new DialogConfirm().showDialog(chf.act,"是否导出配置" + "\n" +
							"导出路径：" + HelpSaveSetDataToFile.getInFile(chf.act).getPath(),
						new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){
									saveOutFile();
								}else{
									btn_out.setVisibility(View.VISIBLE) ;
									outProgress.setVisibility(View.GONE) ;
								}
							}
					}) ;			
				
				}
			}
			private void saveOutFile(){
				try{
					String xml = new Help().out(chf.act) ;
					File f = HelpSaveSetDataToFile.getInFile(chf.act) ;
					HelpSaveSetDataToFile.saveData(f, xml) ;
					btn_out.setVisibility(View.VISIBLE) ;
					outProgress.setVisibility(View.GONE) ;
					Toast.makeText(chf.act, "导出命令数据成功", Toast.LENGTH_SHORT).show() ;
					//Toast.makeText(chf.act, "路径:" + f.getPath(), Toast.LENGTH_LONG).show() ;
				}catch(Exception e){
					btn_out.setVisibility(View.VISIBLE) ;
					outProgress.setVisibility(View.GONE) ;
					Toast.makeText(chf.act, "导出命令数据失败", Toast.LENGTH_SHORT).show() ;
					Log.e(ChFragment_03.class.getName(), "导出命令数据失败", e) ;
				}
			}
		} ;
	
	/**
	 * 查询命令前进行检查
	 * @return
	 */
	@Override
	protected boolean checkBeforeQuery(boolean showDialog){
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
		this.sendRtuCommand(new CommandCreator().cd_C2(null), false) ;
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
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
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