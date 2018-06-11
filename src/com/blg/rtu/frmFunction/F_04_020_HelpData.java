package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.InputFilter_DecimalSigned;
import com.blg.rtu.util.InputFilter_DecimalUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class F_04_020_HelpData {
	
	protected MainActivity act ;
	protected Resources rs  ;
	
	
	private InputFilter_DecimalSigned filter1 ;
	private InputFilter_DecimalUnSigned filter2 ;
	
	public F_04_020_HelpData(MainActivity act){
		this.act = act ;
		this.rs = this.act.getResources() ;
		this.filter1 = new InputFilter_DecimalSigned(8) ;
		this.filter2 = new InputFilter_DecimalUnSigned(5) ;
	}
	
	public class Node{
		public int index ;
		public LinearLayout itemTitleLinear ;
		public TextView itemTitle;
		
		public LinearLayout itemLinear1 ;
		public LinearLayout itemLinear2 ;
		public LinearLayout itemLinear3 ;
		
		public TextView itemName1;
		public TextView itemName2;
		public TextView itemName3;
		
		public EditText itemText1 ;
		public EditText itemText2 ;
		public EditText itemText3 ;
		
		public TextView itemUnit1;
		public TextView itemUnit2;
		public TextView itemUnit3;
		
		public View gapView ;
	}
	public Node createNode(int index, final int id1, final int id2, final int id3,
			Double value1, Double value2, Double value3){
		Node node = new Node() ;
		node.index = index ;
		node.itemTitle = this.createItemTitleTextView("水位点" + index) ;
		node.itemName1 = this.createItemTextView("水位基值") ;
		node.itemName2 = this.createItemTextView("水位下限") ;
		node.itemName3 = this.createItemTextView("水位上限") ;
		
		node.itemText1 = this.createItemEditView("") ;
		node.itemText2 = this.createItemEditView("") ;
		node.itemText3 = this.createItemEditView("") ;

		Preferences p = Preferences.getInstance() ;
		String str = "" ;
		if(value1 != null){
			node.itemText1.setText("" + value1) ;
			p.putString(Constant.func_vk_04_020_ + id1, "" + value1) ;
		}else{
			str = p.getString(Constant.func_vk_04_020_ + id1) ;
			if(!str.equals(Constant.errorStr)){node.itemText1.setText(str);}
		}
		if(value2 != null){
			node.itemText2.setText("" + value2) ;
			p.putString(Constant.func_vk_04_020_ + id2, "" + value2) ;
		}else{
			str = p.getString(Constant.func_vk_04_020_ + id2) ;
			if(!str.equals(Constant.errorStr)){node.itemText2.setText(str);}
		}
		if(value3 != null){
			node.itemText3.setText("" + value3) ;
			p.putString(Constant.func_vk_04_020_ + id3, "" + value3) ;
		}else{
			str = p.getString(Constant.func_vk_04_020_ + id3) ;
			if(!str.equals(Constant.errorStr)){node.itemText3.setText(str);}
		}
		
		node.itemText1.setId(id1) ;
		node.itemText1.setFilters(new InputFilter[]{this.filter1});
		node.itemText1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_020_ + id1));
		
		node.itemText2.setId(id2) ;
		node.itemText2.setFilters(new InputFilter[]{this.filter2});
		node.itemText2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_020_ + id2));
		
		node.itemText3.setId(id3) ;
		node.itemText3.setFilters(new InputFilter[]{this.filter2});
		node.itemText3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_020_ + id3));

		
		node.itemUnit1 = this.createItemUnitTextView() ;
		node.itemUnit2 = this.createItemUnitTextView() ;
		node.itemUnit3 = this.createItemUnitTextView() ;
		
		return node ;
	}
	
	public void addNode(LinearLayout contain, Node node){
		node.itemTitleLinear = this.createItemTitleLinearLayout(node.itemTitle) ;
		contain.addView(node.itemTitleLinear) ;
		node.itemLinear1 = this.createItemLinearLayout(node.itemName1, node.itemText1, node.itemUnit1) ;
		contain.addView(node.itemLinear1) ;
		node.itemLinear2 = this.createItemLinearLayout(node.itemName2, node.itemText2, node.itemUnit2) ;
		contain.addView(node.itemLinear2) ;
		node.itemLinear3 = this.createItemLinearLayout(node.itemName3, node.itemText3, node.itemUnit3) ;
		contain.addView(node.itemLinear3) ;
		
		//分隔线
		node.gapView = new View(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
		lp.leftMargin = 6 ;
		lp.rightMargin = 6 ;
		node.gapView.setLayoutParams(lp) ;
		node.gapView.setBackgroundColor(Color.rgb(85, 163, 255)) ;
		contain.addView(node.gapView); 
		
//		node.gapView = LayoutInflater.from(this.act).inflate(R.layout.line1, contain); 
	}
	
	
	public void removeNode(LinearLayout contain, Node node){
		contain.removeView(node.itemTitleLinear) ;
		contain.removeView(node.itemLinear1) ;
		contain.removeView(node.itemLinear2) ;
		contain.removeView(node.itemLinear3) ;
		contain.removeView(node.gapView) ;
		
		Preferences.getInstance().remove(Constant.func_vk_04_020_ + node.itemText1.getId());
		Preferences.getInstance().remove(Constant.func_vk_04_020_ + node.itemText2.getId());
		Preferences.getInstance().remove(Constant.func_vk_04_020_ + node.itemText3.getId());
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
		tv.setText(this.rs.getString(R.string.func_item_unit_m)) ;

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
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.ed_width_80), this.rs.getDimensionPixelSize(R.dimen.common_edit_height24));
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
