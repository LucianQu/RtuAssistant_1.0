package com.blg.rtu.frmFunction;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class F_03_020_Help {
	
	protected MainActivity act ;
	protected F_03_020 frm ;
	protected Resources rs  ;
	
	
	private InputFilter_NumberUnSigned filter ;
	
	public F_03_020_Help(MainActivity act, F_03_020 frm){
		this.act = act ;
		this.frm = frm ;
		this.rs = this.act.getResources() ;
		this.filter = new InputFilter_NumberUnSigned(3) ;
	}
	
	/**
	 * 初始化
	 * @param p
	 * @param firstId
	 * @param nameLabel
	 */
	public void createFromEmpty(Preferences p, int firstId, String nameLabel){
//	       0  ：无
//	       1  ：  //麦克水位计、水温计
//	       2  ：  //OTT 气泡水位计
//	       3  ：  //OTT 雷达水位计
//	       4  ：  //坎贝尔 压力水位计
//	       5  ：//OTT 压力水位、水温计
//	       6  ：//4_20mA 
		int count = 0 ;
		int index = firstId ;
		p.putString(Constant.func_vk_03_020_t_ + index, "00") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "无") ;
		count++ ; index++ ;

		p.putString(Constant.func_vk_03_020_t_ + index, "01") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "麦克水位计、水温计") ;
		count++ ; index++ ;

		p.putString(Constant.func_vk_03_020_t_ + index, "02") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "OTT气泡水位计") ;
		count++ ; index++ ;

		p.putString(Constant.func_vk_03_020_t_ + index, "03") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "OTT雷达水位计") ;
		count++ ; index++ ;

		p.putString(Constant.func_vk_03_020_t_ + index, "04") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "坎贝尔压力水位计") ;
		count++ ; index++ ;

		p.putString(Constant.func_vk_03_020_t_ + index, "05") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "OTT压力水位、水温计") ;
		count++ ; index++ ;

		p.putString(Constant.func_vk_03_020_t_ + index, "06") ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, "4_20mA") ;
		count++ ; index++ ;

		p.putInt(Constant.func_vk_03_020_typeCount, count) ;	
	}
	
	/**
	 * 导入
	 * @param p
	 * @param count 总数
	 * @param id ID
	 * @param nameLabel
	 * @param num
	 * @param name
	 */
	public void createFromInput(Preferences p, int count, int index, String nameLabel , String num, String name){
		p.putString(Constant.func_vk_03_020_t_ + index, num) ;
		p.putString(Constant.func_vk_03_020_t_ + index + nameLabel, name) ;
		p.putInt(Constant.func_vk_03_020_typeCount, count) ;	
	}
	
	/**
	 * 清空
	 * @param dataContain
	 * @param dataNodes
	 */
	public void clear(LinearLayout dataContain,TreeMap<String, F_03_020_Help.Node> dataNodes){
		Set<Map.Entry<String, F_03_020_Help.Node>> set = dataNodes.entrySet() ;
		Iterator<Map.Entry<String, F_03_020_Help.Node>> it = set.iterator() ;
		Map.Entry<String, F_03_020_Help.Node> ent = null ;
		F_03_020_Help.Node node = null ;
		while(it.hasNext()){
			ent = it.next() ;
			node = ent.getValue() ;
			removeNode(dataContain, node) ;
		}
	}
	
	
	
	public class Node{
		public String idNum ;
		public String idName ;
		public LinearLayout itemLinear ;
		public CheckBox itemCheck ;
		public EditText itemNum ;
		public EditText itemName ;
	}
	public class ThisTextWatcher implements TextWatcher{
		private EditText editText ;
		private String prefId ;
		private Integer maxNum ;
		
		public ThisTextWatcher(EditText editText, String prefId, Integer maxNum){
			this.editText = editText ;
			this.prefId = prefId ;
			this.maxNum = maxNum ;
		}
		
		public void afterTextChanged(Editable ev) {
			// s:变化后的所有字符
			String str = ev.toString().trim();
			if(maxNum != null){
				try{
					if(str != null && !str.trim().equals("")){
						if(Integer.valueOf(str).intValue() > this.maxNum.intValue()){
							new DialogAlarm().showDialog(act, "仪表编号不能大于255") ;
							editText.setText("") ;
							Preferences.getInstance().putString(this.prefId, "");
							return ;
						}
					}
				}catch(Exception e){
				}
			}
			
			if(maxNum != null){
				//是编号
				if (str != null && !str.equals("")) {
					Preferences p = Preferences.getInstance() ;
					int total = p.getInt(Constant.func_vk_03_020_typeCount) ;
					if(total != Constant.errorInt && total > 0){
						boolean repeat = false ;
						int terminate = 0 ;
						int count = 0 ;
						int index = F_03_020.firstId ;
						while((count < total && !repeat) && terminate <= F_03_020.terminateWhile){
							String num = p.getString(Constant.func_vk_03_020_t_ + index) ;
							if(!num.equals(Constant.errorStr)){
								if(num.equals(str)){
									repeat = true ;
									break ;
								}
								count++ ;
							}
							terminate++ ;
							index++ ;
						}
						if(repeat){
							new DialogAlarm().showDialog(act, "编号重复了") ;
							Preferences.getInstance().putString(this.prefId, "");
							editText.setText("") ;
						}else{
							Preferences.getInstance().putString(this.prefId, str);
						}
					}
				}else{
					//编号为空了
					Preferences.getInstance().putString(this.prefId, "");
				}
			}else{
				//是名称
				Preferences.getInstance().putString(this.prefId, str);
			}
			frm.putSpinnerValue_2();
		}
		/**
		 * s:变化前的所有字符； start:字符开始的位置； count:变化前的总字节数；after:变化后的字节数
		 */
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}

		/**
		 * s:变化前的所有字符； start:字符开始的位置； count:变化前的总字节数；after:变化后的字节数
		 */
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		}

	}
	
	
	public Node createNode(String idNum, String idName,
			String num, String name){
		Node node = new Node() ;
		node.idNum = idNum ;
		node.idName = idName ;
		node.itemCheck = this.createItemCheckView() ;
		node.itemNum = this.createItemNumEditView(num) ;
		node.itemName = this.createItemNameEditView(name) ;
		
		node.itemNum.setFilters(new InputFilter[]{this.filter});
		node.itemNum.addTextChangedListener(new ThisTextWatcher(node.itemNum, node.idNum, 255));
		
		//设置只是数字软件键盘
		node.itemNum.setInputType(InputType.TYPE_CLASS_NUMBER);

		
		node.itemName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		node.itemName.addTextChangedListener(new ThisTextWatcher(node.itemName, node.idName, null));
		
		if(num == null){
			//当新增加时，还未填写数据，先占上，防止用户增加后，只填写了name而没有填写num,则系统在初始化时，得不到这项数据
			Preferences.getInstance().putString(node.idNum, "");
			Preferences.getInstance().putString(node.idName, "");
		}

		return node ;
	}
	
	private CheckBox createItemCheckView(){
		CheckBox cb = new CheckBox(act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.ed_width_40), LinearLayout.LayoutParams.MATCH_PARENT);
		lp.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT  ;
		cb.setLayoutParams(lp) ;
		return cb ;
	}
	
	@SuppressWarnings("deprecation")
	private EditText createItemNumEditView(String value){
		EditText et = new EditText(act) ;
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.ed_width_40), this.rs.getDimensionPixelSize(R.dimen.common_edit_height24));
		lp.rightMargin = 40 ;
		et.setLayoutParams(lp) ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.edittext_1);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		//et.setBackground(drawable) ;
		et.setBackgroundDrawable(drawable) ;//为了向下兼容
		
		et.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		et.setTextColor(Color.BLUE) ;
		et.setSingleLine(true) ;
		if(value != null && !value.trim().equals("")){
			et.setText(value) ;
		}else{
			et.setHint("编号") ;
		}
		
		return et ;
	}
	
	private EditText createItemNameEditView(String value){
		EditText et = new EditText(act) ;
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.ed_width_180), this.rs.getDimensionPixelSize(R.dimen.common_edit_height24));
		et.setLayoutParams(lp) ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.edittext_1);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		//et.setBackground(drawable) ;
		et.setBackgroundDrawable(drawable) ;//为了向下兼容
		
		et.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		et.setTextColor(Color.BLUE) ;
		et.setSingleLine(true) ;
		if(value != null && !value.trim().equals("")){
			et.setText(value) ;
		}else{
			et.setHint("名称") ;
		}
		
		return et ;
	}
	
	public void addNode(LinearLayout contain, Node node){
		node.itemLinear = this.createItemLinearLayout(node.itemCheck, node.itemNum, node.itemName) ;
		node.itemLinear.setGravity(Gravity.CENTER_VERTICAL)  ;
		contain.addView(node.itemLinear) ;
	}
	
	
	public void removeNode(LinearLayout contain, Node node){
		contain.removeView(node.itemLinear) ;
		contain.removeView(node.itemCheck) ;
		contain.removeView(node.itemNum) ;
		contain.removeView(node.itemName) ;
		Preferences.getInstance().remove(node.idNum);
		Preferences.getInstance().remove(node.idName);
	}
	
	private LinearLayout createItemLinearLayout(CheckBox itemCheck, EditText itemNum, EditText itemName){
		LinearLayout ll = new LinearLayout(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, this.rs.getDimensionPixelSize(R.dimen.common_line_height35));
		ll.setLayoutParams(lp) ;
		
		ll.addView(itemCheck) ;
		ll.addView(itemNum) ;
		ll.addView(itemName) ;
		
		return ll ;
	}

}
