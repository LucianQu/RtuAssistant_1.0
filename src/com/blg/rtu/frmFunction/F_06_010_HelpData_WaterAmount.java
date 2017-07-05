package com.blg.rtu.frmFunction;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class F_06_010_HelpData_WaterAmount {
	
	protected MainActivity act ;
	protected Resources rs  ;
	
	
	private InputFilter_NumberUnSigned filter1 ;
	
	public F_06_010_HelpData_WaterAmount(MainActivity act){
		this.act = act ;
		this.rs = this.act.getResources() ;
		this.filter1 = new InputFilter_NumberUnSigned(10) ;
	}
	
	public class Node{
		public int index ;
		public LinearLayout itemTitleLinear ;
		public TextView itemTitle;
		
		public LinearLayout itemLinear1 ;
		
		public TextView itemName1;
		
		public EditText itemText1 ;
		
		public TextView itemUnit1;
		
//		public View gapView ;
	}
	public Node createNode(int index, final int id1, Double value1){
		Node node = new Node() ;
		node.index = index ;
		node.itemTitle = this.createItemTitleTextView("水表" + index) ;
		node.itemName1 = this.createItemTextView("累计水量") ;
		
		node.itemText1 = this.createItemEditView("") ;
		
		//设置只是数字软件键盘
		node.itemText1.setInputType(InputType.TYPE_CLASS_NUMBER);

		Preferences p = Preferences.getInstance() ;
		String str = "" ;
		if(value1 != null){
			node.itemText1.setText("" + value1) ;
			p.putString(Constant.func_vk_06_010_05_ + id1, "" + value1) ;
		}else{
			str = p.getString(Constant.func_vk_06_010_05_ + id1) ;
			if(!str.equals(Constant.errorStr)){node.itemText1.setText(str);}
		}
		
		node.itemText1.setId(id1) ;
		node.itemText1.setFilters(new InputFilter[]{this.filter1});
		node.itemText1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_06_010_05_ + id1));

		
		node.itemUnit1 = this.createItemUnitTextView() ;
		
		return node ;
	}
	
	public void addNode(LinearLayout contain, Node node){
		node.itemTitleLinear = this.createItemTitleLinearLayout(node.itemTitle) ;
		contain.addView(node.itemTitleLinear) ;
		node.itemLinear1 = this.createItemLinearLayout(node.itemName1, node.itemText1, node.itemUnit1) ;
		contain.addView(node.itemLinear1) ;
		
	}
	
	
	public void removeNode(LinearLayout contain, Node node){
		contain.removeView(node.itemTitleLinear) ;
		contain.removeView(node.itemLinear1) ;
		
		Preferences.getInstance().remove(Constant.func_vk_06_010_05_ + node.itemText1.getId());
	}
	
	private TextView createItemTitleTextView(String title){
		TextView tv = new TextView(act) ;
		tv.setText(title) ;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.tv_width_100), LinearLayout.LayoutParams.MATCH_PARENT);
		tv.setLayoutParams(lp) ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.label);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		tv.setCompoundDrawables(drawable, null, null, null) ;
		tv.setCompoundDrawablePadding(this.rs.getDimensionPixelOffset(R.dimen.common_drawablePadding3));
		
		tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL) ;
		
		tv.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		
		return tv ;
	}
	
	private TextView createItemTextView(String name){
		TextView tv = new TextView(act) ;
		tv.setText(name) ;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.tv_width_100), LinearLayout.LayoutParams.MATCH_PARENT);
		tv.setLayoutParams(lp) ;
		lp.rightMargin = 8 ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.dot);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		tv.setCompoundDrawables(drawable, null, null, null) ;
		tv.setCompoundDrawablePadding(this.rs.getDimensionPixelOffset(R.dimen.common_drawablePadding5));
		
		tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL) ;
		
		tv.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		
		return tv ;
	}
	
	
	private TextView createItemUnitTextView(){
		TextView tv = new TextView(act) ;
		tv.setText(this.rs.getString(R.string.func_item_unit_m3_1)) ;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.tv_width_100), LinearLayout.LayoutParams.MATCH_PARENT);
		tv.setLayoutParams(lp) ;
		
		tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL) ;
		
		tv.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		
		return tv ;
	}
	
	@SuppressWarnings("deprecation")
	private EditText createItemEditView(String value){
		EditText et = new EditText(act) ;
		et.setText(value) ;
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.ed_width_100), this.rs.getDimensionPixelSize(R.dimen.common_edit_height24));
		lp.rightMargin = 9 ;
		et.setLayoutParams(lp) ;
		
		Drawable drawable = this.rs.getDrawable(R.drawable.edittext_1);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
		//et.setBackground(drawable) ;
		et.setBackgroundDrawable(drawable) ;//为了向下兼容
		
		et.setTextSize(ResourceUtils.getXmlDef(act, R.dimen.text14)) ;
		et.setTextColor(Color.BLUE) ;
		et.setSingleLine(true) ;
		
		return et ;
	}
	
	
	private LinearLayout createItemTitleLinearLayout(TextView itemTitle){
		LinearLayout ll = new LinearLayout(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, this.rs.getDimensionPixelSize(R.dimen.common_line_height30));
		ll.setLayoutParams(lp) ;
		
		ll.addView(itemTitle) ;
		
		return ll ;
	}
	
	private LinearLayout createItemLinearLayout(TextView itemName, EditText itemText, TextView itemValue){
		LinearLayout ll = new LinearLayout(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, this.rs.getDimensionPixelSize(R.dimen.common_line_height30));
		ll.setLayoutParams(lp) ;
		
		ll.addView(itemName) ;
		ll.addView(itemText) ;
		ll.addView(itemValue) ;
		
		return ll ;
	}

}
