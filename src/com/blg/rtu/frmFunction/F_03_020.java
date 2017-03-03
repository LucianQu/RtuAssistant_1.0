package com.blg.rtu.frmFunction;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.protocol.p206.cdE3_F3.Data_E3_F3;
import com.blg.rtu.protocol.p206.cdE3_F3.Param_F3;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.DialogConfirm;
import com.blg.rtu.util.ImageUtil;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu.vo2xml.Vo2Xml;

public class F_03_020  extends FrmParent {
	
	public static final int terminateWhile = 200 ;
	
	private TextView title ;

	private Spinner item01_1;
	private Spinner item01_2 ;
	private Spinner item02_1;
	private Spinner item02_2 ;
	private Spinner item03_1;
	private Spinner item03_2 ;
	private Spinner item04_1;
	private Spinner item04_2 ;
	private Spinner item05_1;
	private Spinner item05_2 ;
	private Spinner item06_1;
	private Spinner item06_2 ;
	
	private ArrayAdapter<SpinnerVO> spinnerAdapter01_1;
	private int spinnerPosition01_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02_1;
	private int spinnerPosition02_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_1;
	private int spinnerPosition03_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04_1;
	private int spinnerPosition04_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter05_1;
	private int spinnerPosition05_1 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter06_1;
	private int spinnerPosition06_1 ;

	private ArrayAdapter<SpinnerVO> spinnerAdapter01_2;
	private int spinnerPosition01_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter02_2;
	private int spinnerPosition02_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter03_2;
	private int spinnerPosition03_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter04_2;
	private int spinnerPosition04_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter05_2;
	private int spinnerPosition05_2 ;
	private ArrayAdapter<SpinnerVO> spinnerAdapter06_2;
	private int spinnerPosition06_2 ;



	private LinearLayout dataContain ;

	private ImageView btnSet ;
	private ImageView btnRead ;
	private ImageView btnAdd ;
	private ImageView btnRemove;
	
	private TreeMap<String, F_03_020_Help.Node> dataNodes ;
	private static final int maxCount = 30 ;
	public static final int firstId = 100 ;//必须大于等于100，因为TreeMap排序时，"t10"小于"t2"
	private static int newId = firstId ;
	private static final String nameLabel = "n" ;


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = (MainActivity)activity ;
		this.dataNodes = new TreeMap<String, F_03_020_Help.Node>(new Comparator<String>() {//对treeMap排序
            public int compare(String o1, String o2) {
                //如果有空值，直接返回0
                if (o1 == null || o2 == null)
                    return 0; 
               return o1.compareTo(o2) ;
            }
		});
		this.queryCommandCode = Code206.cd_E3 ;
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
		View view = inflater.inflate(R.layout.f_func_03_020, container, false);

		title = (TextView)view.findViewById(R.id.f_03_020_Title) ;
		funcFrm = (FrameLayout)view.findViewById(R.id.f_03_020_Frm) ;
		cover = (LinearLayout)view.findViewById(R.id.f_03_020_Load) ;
		
		//放在前面，后面要用到它
		dataContain = (LinearLayout)view.findViewById(R.id.f_03_030_dataContain) ;
		initMeterType() ;

		initSpinner_1(view) ;
		initSpinner_2(view) ;
		putSpinnerValue_2() ;


		btnSet = (ImageView)view.findViewById(R.id.btn_set);
		btnRead = (ImageView)view.findViewById(R.id.btn_read);
		btnAdd = (ImageView)view.findViewById(R.id.btn_add);
		btnRemove = (ImageView)view.findViewById(R.id.btn_remove);
		
		resultDt = (TextView)view.findViewById(R.id.resultDatetime);
		
		//设置监听器
		title.setOnClickListener(titleClickLisn) ;
		btnSet.setOnClickListener(btnSetLisn);
		btnRead.setOnClickListener(btnReadLisn);
		btnAdd.setOnClickListener(btnAddLisn);
		btnRemove.setOnClickListener(btnRemoveLisn);
		
		String str = Preferences.getInstance().getString(Constant.func_vk_03_020_dt) ;
		if(!str.equals(Constant.errorStr)){
			this.resultDt.setText(str) ;
		}

		return view ;
	}
	
	//添加按钮点击事件
	private Button.OnClickListener btnAddLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			if(dataNodes.size() > maxCount){
				new DialogAlarm().showDialog(act, "仪表种类已经超过最大限值！") ;
			}else{
				F_03_020_Help help = new F_03_020_Help(act, F_03_020.this) ;
				
				String id = Constant.func_vk_03_020_t_ + newId  ;
				F_03_020_Help.Node node = help.createNode(id, id + nameLabel, null, null) ;
				help.addNode(dataContain, node) ;
				dataNodes.put("" + id, node) ;
				
				newId++ ;
				
				Preferences.getInstance().putInt(Constant.func_vk_03_020_typeCount, dataNodes.size());
			}
		}
	} ;
	//删除按钮点击事件
	private Button.OnClickListener btnRemoveLisn = new Button.OnClickListener(){
		public void onClick(View v) {
			if(dataNodes.size() > 0){
				if(hasChecked()){
					new DialogConfirm().showDialog(act, "确实删除选中的仪表类型吗？"  ,
						new DialogConfirm.CallBackInterface(){
							@Override
							public void dialogCallBack(Object o) {
								if((Boolean)o){
									F_03_020_Help help = new F_03_020_Help(act, F_03_020.this) ;
									Set<Map.Entry<String, F_03_020_Help.Node>> set = null ;
									Iterator<Map.Entry<String, F_03_020_Help.Node>> it = null ;
									Map.Entry<String, F_03_020_Help.Node> ent = null ;
									F_03_020_Help.Node node = null ;
									boolean finded = true ;
									while(finded){
										finded = false ;
										set = dataNodes.entrySet() ;
										it = set.iterator() ;
										while(!finded && it.hasNext()){
											ent = it.next() ;
											node = ent.getValue() ;
											if(node.itemCheck.isChecked()){
												finded = true ;
												help.removeNode(dataContain, node) ;
												dataNodes.remove(ent.getKey()) ;
												Preferences.getInstance().putInt(Constant.func_vk_03_020_typeCount, dataNodes.size());
												//newId-- ;此处不能用newId--，因为几个数据项，中间的被删除过，而最后的没有被删除，这样最后的ID就可能较大，这些若newId--了，那么新生成的ID可能就与最后的项ID重复了
											}
										}
									}
									if(dataNodes.size() == 0){
										initMeterType() ;
									}
									putSpinnerValue_2() ;
								} 
							}
						}
					) ;
				}
			}
			
			
		}
		
		private boolean hasChecked(){
			boolean flag = false ;
			if(dataNodes.size() > 0){
				Iterator<F_03_020_Help.Node> it = dataNodes.values().iterator() ;
				F_03_020_Help.Node node = null ;
				while(it.hasNext()){
					node = it.next() ;
					if(node.itemCheck.isChecked()){
						flag = true ;
						break ;
					}
				}
			}
			return flag ;
		}
	} ;
	
	
	/**
	 * 初始化仪表类型
	 */
	protected void initMeterType(){
		dataNodes.clear() ;
		F_03_020_Help help = new F_03_020_Help(this.act, F_03_020.this) ;
		Preferences p = Preferences.getInstance() ;
		int total = p.getInt(Constant.func_vk_03_020_typeCount) ;
		if(total != Constant.errorInt && total > 0){
			int terminate = 0 ;
			int count = 0 ;
			int index = firstId ;
			while(count < total && terminate <= terminateWhile){
				String num = p.getString(Constant.func_vk_03_020_t_ + index) ;
				if(!num.equals(Constant.errorStr)){
					String name = p.getString(Constant.func_vk_03_020_t_ + index + nameLabel) ;
					String id = Constant.func_vk_03_020_t_ + index  ;
					F_03_020_Help.Node node = help.createNode(id, id + nameLabel, num, name) ;
					help.addNode(dataContain, node) ;
					dataNodes.put("" + id, node) ;
					count++ ;
				}
				terminate++ ;
				index++ ;
				newId++ ;
			}
		}else{
			help.createFromEmpty(p, firstId, nameLabel) ;
			initMeterType() ;
		}
	}
	
	protected void initSpinner_1(View view){
		spinnerAdapter01_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter01_1);
		spinnerAdapter01_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter02_1);
		spinnerAdapter02_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter03_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter03_1);
		spinnerAdapter03_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter04_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter04_1);
		spinnerAdapter04_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter05_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter05_1);
		spinnerAdapter05_1.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter06_1 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue_1(spinnerAdapter06_1);
		spinnerAdapter06_1.setDropDownViewResource(R.layout.spinner_item);
		

		item01_1 = (Spinner) view.findViewById(R.id.f_03_020_item1_1);
		item01_1.setAdapter(spinnerAdapter01_1);
		item01_1.setOnItemSelectedListener(spinLs01);

		item02_1 = (Spinner) view.findViewById(R.id.f_03_020_item2_1);
		item02_1.setAdapter(spinnerAdapter02_1);
		item02_1.setOnItemSelectedListener(spinLs01);

		item03_1 = (Spinner) view.findViewById(R.id.f_03_020_item3_1);
		item03_1.setAdapter(spinnerAdapter03_1);
		item03_1.setOnItemSelectedListener(spinLs01);

		item04_1 = (Spinner) view.findViewById(R.id.f_03_020_item4_1);
		item04_1.setAdapter(spinnerAdapter04_1);
		item04_1.setOnItemSelectedListener(spinLs01);

		item05_1 = (Spinner) view.findViewById(R.id.f_03_020_item5_1);
		item05_1.setAdapter(spinnerAdapter05_1);
		item05_1.setOnItemSelectedListener(spinLs01);

		item06_1 = (Spinner) view.findViewById(R.id.f_03_020_item6_1);
		item06_1.setAdapter(spinnerAdapter06_1);
		item06_1.setOnItemSelectedListener(spinLs01);


		int v = Preferences.getInstance().getInt(Constant.func_vk_03_020_01_1) ;
		if(v != Constant.errorInt){item01_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_02_1) ;
		if(v != Constant.errorInt){item02_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_03_1) ;
		if(v != Constant.errorInt){item03_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_04_1) ;
		if(v != Constant.errorInt){item04_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_05_1) ;
		if(v != Constant.errorInt){item05_1.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_06_1) ;
		if(v != Constant.errorInt){item06_1.setSelection(v);}		
	}

	protected void initSpinner_2(View view){
		spinnerAdapter01_2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter01_2.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter02_2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter02_2.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter03_2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter03_2.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter04_2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter04_2.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter05_2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter05_2.setDropDownViewResource(R.layout.spinner_item);
		
		spinnerAdapter06_2 = new ArrayAdapter<SpinnerVO>(this.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		spinnerAdapter06_2.setDropDownViewResource(R.layout.spinner_item);
		

		item01_2 = (Spinner) view.findViewById(R.id.f_03_020_item1_2);
		item01_2.setAdapter(spinnerAdapter01_2);
		item01_2.setOnItemSelectedListener(spinLs_2);

		item02_2 = (Spinner) view.findViewById(R.id.f_03_020_item2_2);
		item02_2.setAdapter(spinnerAdapter02_2);
		item02_2.setOnItemSelectedListener(spinLs_2);

		item03_2 = (Spinner) view.findViewById(R.id.f_03_020_item3_2);
		item03_2.setAdapter(spinnerAdapter03_2);
		item03_2.setOnItemSelectedListener(spinLs_2);

		item04_2 = (Spinner) view.findViewById(R.id.f_03_020_item4_2);
		item04_2.setAdapter(spinnerAdapter04_2);
		item04_2.setOnItemSelectedListener(spinLs_2);

		item05_2 = (Spinner) view.findViewById(R.id.f_03_020_item5_2);
		item05_2.setAdapter(spinnerAdapter05_2);
		item05_2.setOnItemSelectedListener(spinLs_2);

		item06_2 = (Spinner) view.findViewById(R.id.f_03_020_item6_2);
		item06_2.setAdapter(spinnerAdapter06_2);
		item06_2.setOnItemSelectedListener(spinLs_2);


		int v = Preferences.getInstance().getInt(Constant.func_vk_03_020_01_2) ;
		if(v != Constant.errorInt){item01_2.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_02_2) ;
		if(v != Constant.errorInt){item02_2.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_03_2) ;
		if(v != Constant.errorInt){item03_2.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_04_2) ;
		if(v != Constant.errorInt){item04_2.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_05_2) ;
		if(v != Constant.errorInt){item05_2.setSelection(v);}

		v = Preferences.getInstance().getInt(Constant.func_vk_03_020_06_2) ;
		if(v != Constant.errorInt){item06_2.setSelection(v);}
	}
	
	protected void putSpinnerValue_2(){
		this.putSpinnerValue2(spinnerAdapter01_2);
		this.putSpinnerValue2(spinnerAdapter02_2);
		this.putSpinnerValue2(spinnerAdapter03_2);
		this.putSpinnerValue2(spinnerAdapter04_2);
		this.putSpinnerValue2(spinnerAdapter05_2);
		this.putSpinnerValue2(spinnerAdapter06_2);
	}
	
	private void putSpinnerValue_1(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.add(new SpinnerVO("0", "无效")) ;
		spinnerAdapter.add(new SpinnerVO("1", "有效")) ;
	}
	
	protected void putSpinnerValue2(ArrayAdapter<SpinnerVO> spinnerAdapter){
		spinnerAdapter.clear() ;
		putSpinnerValue_2_(spinnerAdapter) ;
	}
	
	private void putSpinnerValue_2_(ArrayAdapter<SpinnerVO> spinnerAdapter){
		if(dataNodes.size() > 0){
			//对key排序，所以取key
			Iterator<String> it = dataNodes.keySet().iterator() ;
			String key = null ;
			F_03_020_Help.Node node = null ;
			String num = null ;
			String name = null ;
			boolean ok = false ;
			while(it.hasNext()){
				key = it.next() ;
				if(key != null && !key.equals("")){
					node = dataNodes.get(key) ;
					if(node.itemNum != null){
						num = node.itemNum.getText().toString() ;
						if(num != null && !num.trim().equals("")){
							ok = true ;
						}
					}
					if(ok){
						ok = false ;
						if(node.itemName != null){
							name = node.itemName.getText().toString() ;
							if(name != null && !name.trim().equals("")){
								ok = true ;
							}
						}
					}
					if(ok){
						spinnerAdapter.add(new SpinnerVO(num, name)) ;
					}
					ok = false ;
				}
			}
		}
	}


	OnItemSelectedListener spinLs01 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_03_020.this.item01_1){
				spinnerPosition01_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_01_1, position) ;
			}else if(parent == F_03_020.this.item02_1){
				spinnerPosition02_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_02_1, position) ;
			}else if(parent == F_03_020.this.item03_1){
				spinnerPosition03_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_03_1, position) ;
			}else if(parent == F_03_020.this.item04_1){
				spinnerPosition04_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_04_1, position) ;
			}else if(parent == F_03_020.this.item05_1){
				spinnerPosition05_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_05_1, position) ;
			}else if(parent == F_03_020.this.item06_1){
				spinnerPosition06_1 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_06_1, position) ;
			}
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};	
////////
	OnItemSelectedListener spinLs_2 = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			if(parent == F_03_020.this.item01_2){
				spinnerPosition01_2 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_01_2, position) ;
			}else if(parent == F_03_020.this.item02_2){
				spinnerPosition02_2 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_02_2, position) ;
			}else if(parent == F_03_020.this.item03_2){
				spinnerPosition03_2 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_03_2, position) ;
			}else if(parent == F_03_020.this.item04_2){
				spinnerPosition04_2 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_04_2, position) ;
			}else if(parent == F_03_020.this.item05_2){
				spinnerPosition05_2 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_05_2, position) ;
			}else if(parent == F_03_020.this.item06_2){
				spinnerPosition06_2 = position ;
				Preferences.getInstance().putInt(Constant.func_vk_03_020_06_2, position) ;
			}
		}
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};	
	
	/*private void clear(){
		F_03_020_Help help = new F_03_020_Help(act, this) ;
		help.clear(dataContain, dataNodes) ;
		this.dataNodes.clear() ;
		newId = firstId ;
		
		Preferences.getInstance().putInt(Constant.func_vk_03_020_typeCount, 0);
	}*/
	
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
		this.sendRtuCommand(new CommandCreator().cd_E3(null), false) ;
	}
	
	/**
	 * 设置命令
	 */
	@Override
	protected void setCommand(){
		Param_F3 p = new Param_F3() ;
		
		String e1 = spinnerAdapter01_1.getItem(spinnerPosition01_1).getId() ;
		String e2 = spinnerAdapter02_1.getItem(spinnerPosition02_1).getId() ;
		String e3 = spinnerAdapter03_1.getItem(spinnerPosition03_1).getId() ;
		String e4 = spinnerAdapter04_1.getItem(spinnerPosition04_1).getId() ;
		String e5 = spinnerAdapter05_1.getItem(spinnerPosition05_1).getId() ;
		String e6 = spinnerAdapter06_1.getItem(spinnerPosition06_1).getId() ;
		
		p.setEnable_level_0To1(Integer.valueOf(e1)) ;
		p.setEnable_qaulity_0To1(Integer.valueOf(e2)) ;
		p.setEnable_temperature_0To1(Integer.valueOf(e3)) ;
		p.setEnable_amount1_0To1(Integer.valueOf(e4)) ;
		p.setEnable_amount2_0To1(Integer.valueOf(e5)) ;
		p.setEnable_amount3_0To1(Integer.valueOf(e6)) ;
		
		String v1 = spinnerAdapter01_2.getItem(spinnerPosition01_2).getId() ;
		String v2 = spinnerAdapter02_2.getItem(spinnerPosition02_2).getId() ;
		String v3 = spinnerAdapter03_2.getItem(spinnerPosition03_2).getId() ;
		String v4 = spinnerAdapter04_2.getItem(spinnerPosition04_2).getId() ;
		String v5 = spinnerAdapter05_2.getItem(spinnerPosition05_2).getId() ;
		String v6 = spinnerAdapter06_2.getItem(spinnerPosition06_2).getId() ;
		
		p.setMeter_level_0To255(Integer.valueOf(v1)) ;//水位仪表种类
		p.setMeter_qaulity_0To255(Integer.valueOf(v2)) ;//水质仪表种类
		p.setMeter_temperature_0To255(Integer.valueOf(v3)) ;//水温仪表种类
		p.setMeter_amount1_0To255(Integer.valueOf(v4)) ;//流量仪表种类
		p.setMeter_amount2_0To255(Integer.valueOf(v5)) ;//流量仪表种类
		p.setMeter_amount3_0To255(Integer.valueOf(v6)) ;//流量仪表种类

		this.sendRtuCommand(new CommandCreator().cd_F3(p, null), false) ;
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item003(this.act), null, ImageUtil.getTitlRightImg_blue(this.act), null);
	}
	
	/**
	 * 命令已经由后台服务通过网络成功发送后的回调
	 */
	@Override
	public void commandSendedCallBack(){
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item003(this.act), null, ImageUtil.getTitlRightImg_red(this.act), null); 
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
		this.title.setCompoundDrawables(ImageUtil.getTitlLeftImg_item003(this.act), null, ImageUtil.getTitlRightImg_green(this.act), null); 
//		super.scrollTo(this.btnRead) ;
		
		Data_E3_F3 sd = (Data_E3_F3)d.subData ;

		item01_1.setSelection(sd.getEnable_level().intValue()) ;
		itemXY_2_SetSelection(item01_2, sd.getMeter_level());

		item02_1.setSelection(sd.getEnable_qaulity().intValue()) ;
		itemXY_2_SetSelection(item02_2, sd.getMeter_qaulity());

		item03_1.setSelection(sd.getEnable_temperature().intValue()) ;
		itemXY_2_SetSelection(item03_2, sd.getMeter_temperature());

		item04_1.setSelection(sd.getEnable_amount1().intValue()) ;
		itemXY_2_SetSelection(item04_2, sd.getMeter_amount1());

		item05_1.setSelection(sd.getEnable_amount2().intValue()) ;
		itemXY_2_SetSelection(item05_2, sd.getMeter_amount2());

		item06_1.setSelection(sd.getEnable_amount3().intValue()) ;
		itemXY_2_SetSelection(item06_2, sd.getMeter_amount3());

		
		Preferences.getInstance().putString(Constant.func_vk_03_020_dt, this.resultDt.getText().toString()) ;
	}
	
	private void itemXY_2_SetSelection(Spinner item, int meterType){
		if(dataNodes.size() > 0){
			Iterator<F_03_020_Help.Node> it = dataNodes.values().iterator() ;
			F_03_020_Help.Node node = null ;
			String num = null ;
			int count = 0 ;
			while(it.hasNext()){
				node = it.next() ;
				if(node.itemNum != null){
					num = node.itemNum.getText().toString() ;
					if(num != null && !num.trim().equals("")){
						if(Integer.valueOf(num) == meterType){
							item.setSelection(count) ;
						}
					}
				}
				count++ ;
			}
		}
		
	}
	
	
	
	@Override
	public void outSetData(Vo2Xml vo) {
	}

	@Override
	public void inSetData(Vo2Xml vo) {
	}

	/**
	 * 导出设置数据
	 */
	/*public void outSetData(Vo2Xml vo) {
		vo.setV_03_020_item01_1(spinnerPosition01_1) ;
		vo.setV_03_020_item01_2(spinnerPosition01_2) ;
		vo.setV_03_020_item02_1(spinnerPosition02_1) ;
		vo.setV_03_020_item02_2(spinnerPosition02_2) ;
		vo.setV_03_020_item03_1(spinnerPosition03_1) ;
		vo.setV_03_020_item03_2(spinnerPosition03_2) ;
		vo.setV_03_020_item04_1(spinnerPosition04_1) ;
		vo.setV_03_020_item04_2(spinnerPosition04_2) ;
		vo.setV_03_020_item05_1(spinnerPosition05_1) ;
		vo.setV_03_020_item05_2(spinnerPosition05_2) ;
		vo.setV_03_020_item06_1(spinnerPosition06_1) ;
		vo.setV_03_020_item06_2(spinnerPosition06_2) ;
		
		StringBuffer sb = new StringBuffer() ;
		boolean first = true ;
		Preferences p = Preferences.getInstance() ;
		int total = p.getInt(Constant.func_vk_03_020_typeCount) ;
		if(total != Constant.errorInt && total > 0){
			int terminate = 0 ;
			int count = 0 ;
			int index = firstId ;
			while(count < total && terminate <= terminateWhile){
				String num = p.getString(Constant.func_vk_03_020_t_ + index) ;
				if(!num.equals(Constant.errorStr)){
					String name = p.getString(Constant.func_vk_03_020_t_ + index + nameLabel) ;
					if(name != null && !name.trim().equals("")){
						if(first){
							first = false ;
							sb.append(num + ",.," + name.trim()) ;
						}else{
							sb.append(";,;" + num + ",.," + name.trim()) ;
						}
					}
					count++ ;
				}
				terminate++ ;
				index++ ;
			}
		}
		String s = sb.toString() ;
		byte[] b = s.getBytes() ;
		String hex = ByteUtil.bytes2Hex(b, false) ;
		vo.setV_03_020_meterTypeListStr(hex) ;
	}*/
	/**
	 * 导入设置数据
	 */
	/*public void inSetData(Vo2Xml vo) {
		boolean ok = false ;
		String hex = vo.getV_03_020_meterTypeListStr() ;
		if(hex != null && !hex.trim().equals("")){
			try{
				byte[] b = ByteUtil.hex2Bytes(hex) ;
				String s = new String(b) ;
				if(s != null && !s.equals("")){
					String[] meters = s.split(";.;") ;
					if(meters != null && meters.length > 0){
						//本地清空
						clear() ;
						
						F_03_020_Help help = new F_03_020_Help(act, this) ;
						Preferences p = Preferences.getInstance() ;
						int index = firstId ;
						int count = 1 ;
						String[] numName = null ;
						for(int i = 0 ; i < meters.length ; i++){
							numName = meters[i].split(",.,") ;
							if(numName != null && numName.length == 2){
								help.createFromInput(p, count, index, nameLabel, numName[0], numName[1]) ;
								count ++ ;
								index++ ;
							}
						}
						initMeterType() ;
						putSpinnerValue_2() ;
						ok = true ;
					}
				}
			}catch(Exception e){
				Log.e("F_03_020", "仪表类型转换出错" , e) ;
			}
		}
		if(ok){
			item01_1.setSelection(vo.getV_03_020_item01_1()) ;
			item01_2.setSelection(vo.getV_03_020_item01_2()) ;
			item02_1.setSelection(vo.getV_03_020_item02_1()) ;
			item02_2.setSelection(vo.getV_03_020_item02_2()) ;
			item03_1.setSelection(vo.getV_03_020_item03_1()) ;
			item03_2.setSelection(vo.getV_03_020_item03_2()) ;
			item04_1.setSelection(vo.getV_03_020_item04_1()) ;
			item04_2.setSelection(vo.getV_03_020_item04_2()) ;
			item05_1.setSelection(vo.getV_03_020_item05_1()) ;
			item05_2.setSelection(vo.getV_03_020_item05_2()) ;
			item06_1.setSelection(vo.getV_03_020_item06_1()) ;
			item06_2.setSelection(vo.getV_03_020_item06_2()) ;
		}
	}
	*/
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