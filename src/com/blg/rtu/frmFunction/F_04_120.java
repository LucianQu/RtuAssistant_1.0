package com.blg.rtu.frmFunction;


import java.util.HashMap;
import java.util.TreeMap;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cd1B.DataMap_1B;
import com.blg.rtu.protocol.p206.cd1B.Data_1B;
import com.blg.rtu.protocol.p206.cd1B.ParamMap_1B;
import com.blg.rtu.protocol.p206.cd1B.Param_1B;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.vo2xml.Vo2Xml;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class F_04_120 extends FrmParent {
	
	private TextView title ;
	
	private ImageView btnSet ;
	private ImageView btnAdd ;
	private ImageView btnRemove;
	
	private LinearLayout dataContain ;
	
	private HashMap<String, F_04_120_HelpData.Node> dataNodes ;
	
	private static final int maxCount = 30 ;
	private static final int commonId = 1000 ;
	private static final int firstIndex = 1 ;
	private static int newIndex = 0 ;
	
	
	private ParamMap_1B pm ;//下发的设置参数据集合


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.dataNodes = new HashMap<String, F_04_120_HelpData.Node>() ;
		this.queryCommandCode = null ;
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
		View view = inflater.inflate(R.layout.f_func_04_120, container, false);

		title = (TextView)view.findViewById(R.id.f_04_120_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_04_120_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_04_120_Load) ;
		dataContain = (LinearLayout)view.findViewById(R.id.f_04_120_dataContain) ;
		
		newIndex = firstIndex ;
		this.initDataNode() ;
		
		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnAdd = (ImageView)view.findViewById(R.id.btn_add);
		btnRemove = (ImageView)view.findViewById(R.id.btn_remove);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnAdd.setOnClickListener(btnAddLisn);
		btnRemove.setOnClickListener(btnRemoveLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_04_120_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}

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
		boolean returnFalg = false ;
		if(this.dataNodes.size() == 0){
			if(showDialog)new DialogAlarm().showDialog(act, "至少设置一个表底值数据！") ;
		}else{
			this.pm = new ParamMap_1B() ;
			int index = firstIndex ;
			boolean has = false ;
			boolean error = false ;
			
			String value1 = null ;
			Long amount = null ;
			
			F_04_120_HelpData.Node node = this.dataNodes.get("" + index) ;
			while(node != null){
				value1 = node.itemText1.getText().toString() ;
				if(!value1.equals("")){
					has = true ;
					amount = Long.valueOf(value1) ;
					if(amount > 7999999999L || amount < 0){
						if(showDialog)new DialogAlarm().showDialog(act, "水表" + index + "底值超过合法取值范围(0～7999999999)！") ;
						error = true ;
					}

					if(error){
						break ;
					}else{
						Param_1B p = new Param_1B() ;
						p.setInitWaterAmount_0to7999999999(amount) ;
						this.pm.getParamMap().put(index, p) ;
						
						index++ ;
						node = this.dataNodes.get("" + index) ;
					}
				}else{
					if(showDialog)new DialogAlarm().showDialog(act, "水表" + index + "底值必须填写！") ;
					error = true ;
					break ;
				}
			}
			
			if(has && !error){
				returnFalg = true ;
			}else{
				this.pm = null ;
			}
		}
		return returnFalg ;
	}
	
	/**
	 * 查询命令
	 */
	@Override
	protected void queryCommand(){
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		if(this.pm != null){
			this.sendRtuCommand(new CommandCreator().cd_1B(this.pm, null), false) ;
		}
	}
	
	/**
	 * 查询或设置命令发送前检查出问题后的回调
	 */
	@Override
	public void commandHasProblem(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_problem(this.act), null);
	}
	
	/**
	 * 命令已经成功发送给后台服务后的回调
	 */
	@Override
	public void commandSended(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
	}
	/**
	 * 功能项右侧图标复原
	 */
	@Override
	public void resetLabelImg(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item001(this.act), null, ImageUtil.getTitlRightImg_gray(this.act), null); 
	}
	
	/**
	 * 收到数据
	 * @param d
	 */
	@Override
	public void receiveRtuData(RtuData d){
		super.receiveRtuData(d) ;
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item004(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
		//首先删除以前的界面数据
		this.removeAllDataNode();

		DataMap_1B subD = (DataMap_1B)d.getSubData() ;
		if(subD != null){
			TreeMap<Integer, Data_1B> dataMap = subD.getDataMap() ;
			if(dataMap != null && dataMap.size() > 0){
				int index = 1 ;//协议实现是从1开始
				Data_1B data = dataMap.get(index) ;
				while(data != null){
					this.createDataNode(data) ;
					index++ ;
					data = dataMap.get(index) ;
				}
			}
		}
		
		Preferences.getInstance().putString(Constant.func_vk_04_120_dt, this.resultDt.getText().toString()) ;
	}
	
	
	/**
	 * 导出设置数据
	 */
	public void outSetData(Vo2Xml vo) {
		String str = null ;
		int index = firstIndex ;
		String value1 = null ;
		F_04_120_HelpData.Node node = this.dataNodes.get("" + index) ;
		while(node != null){
			value1 = node.itemText1.getText().toString() ;
			if(str == null){
				str = value1;
			}else{
				str += ";" + value1 ;
			}
			index++ ;
			node = this.dataNodes.get("" + index) ;
		}
		if(str != null){
			byte[] bs = str.getBytes() ;
			String hex = ByteUtil.bytes2Hex(bs, false) ;
			if(hex != null){
				vo.setV_04_120_itemStr(hex) ;
			}
		}
	}
	/**
	 * 导入设置数据
	 */
	public void inSetData(Vo2Xml vo) {
		String hex = vo.getV_04_120_itemStr() ;
		if(hex != null && !hex.equals("")){
			try {
				byte[] bs = ByteUtil.hex2Bytes(hex) ;
				if(bs != null && bs.length > 0){
					//首先删除以前的界面数据
					this.removeAllDataNode();

					String str = new String(bs) ;
					String[] ss = str.split(";") ;
					for(int i = 0 ; i < ss.length ; i++){
						this.createDataNode(ss[i]) ;
					}
				}
			} catch (Exception e) {
			}
		}
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
	
	
	//添加按钮点击事件
	private Button.OnClickListener btnAddLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			if(newIndex > maxCount){
				new DialogAlarm().showDialog(act, "水位测点数已经超过最大限值！") ;
			}else{
				F_04_120_HelpData help = new F_04_120_HelpData(act) ;
				
				int id = newIndex * commonId ;
				F_04_120_HelpData.Node node = help.createNode(newIndex, id + 1, null) ;
				help.addNode(dataContain, node) ;
				dataNodes.put("" + newIndex, node) ;
				newIndex++ ;
			}
		}
	} ;
	//删除按钮点击事件
	private Button.OnClickListener btnRemoveLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			newIndex-- ;//newIndex--使其值变为当前结点索引nowIndex
			if(newIndex > firstIndex){
				F_04_120_HelpData.Node node = dataNodes.get("" + newIndex) ;
				if(node != null){
					new F_04_120_HelpData(act).removeNode(dataContain, node) ;
					dataNodes.remove("" + newIndex) ;
				}
			}else{
				newIndex++ ;//newIndex++使其值变为新结点索引newIndex
			}
		}
	} ;
	
	
	//////////////////////////////////////////////
	//以下业务逻辑 
	private void initDataNode(){
		F_04_120_HelpData help = new F_04_120_HelpData(this.act) ;

		boolean has = false ;
		int id = newIndex * commonId ;

		Preferences pre = Preferences.getInstance() ;
		String str = pre.getString(Constant.func_vk_04_120_ + (id + 1)) ;
		while(str != Constant.errorStr){
			F_04_120_HelpData.Node node = help.createNode(newIndex, id + 1, null) ;
			help.addNode(dataContain, node) ;
			dataNodes.put("" + newIndex, node) ;
			newIndex++ ;
			has = true ;
			id = newIndex * commonId ;
			str = pre.getString(Constant.func_vk_04_120_ + (id + 1)) ;
		}
		if(!has){
			F_04_120_HelpData.Node node = help.createNode(newIndex, id + 1, null) ;
			help.addNode(dataContain, node) ;
			dataNodes.put("" + newIndex, node) ;
			newIndex++ ;
		}
	}
	
	private void createDataNode(Data_1B d){
		F_04_120_HelpData help = new F_04_120_HelpData(this.act) ;

		int id = newIndex * commonId ;
		
		F_04_120_HelpData.Node node = help.createNode(newIndex, id + 1, d.getInitWaterAmount()) ; 
		help.addNode(dataContain, node) ;
		dataNodes.put("" + newIndex, node) ;
		newIndex++ ;
	}
	
	private void createDataNode(String s){
		F_04_120_HelpData help = new F_04_120_HelpData(this.act) ;
		Long d = null ;
		try{
			if(s != null && !s.trim().equals("")){
				d = Long.valueOf(s) ;
			}
			
			int id = newIndex * commonId ;
			F_04_120_HelpData.Node node = help.createNode(newIndex, id + 1, d) ; 
			help.addNode(dataContain, node) ;
			dataNodes.put("" + newIndex, node) ;
			newIndex++ ;
		}catch(Exception e){
		}
	}
	
	private void removeAllDataNode(){
		F_04_120_HelpData help = new F_04_120_HelpData(this.act) ;
		newIndex-- ;
		while(newIndex >= firstIndex){
			F_04_120_HelpData.Node node = dataNodes.get("" + newIndex) ;
			if(node != null){
				help.removeNode(dataContain, node) ;
			}
			newIndex-- ;
		}
		newIndex = firstIndex ;
		dataNodes.clear() ;
	}
	
}
