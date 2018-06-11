package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.ResourceUtils;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class F_05_050_HelpData {
	
	protected MainActivity act ;
	protected Resources rs  ;
	
	public F_05_050_HelpData(MainActivity act){
		this.act = act ;
		this.rs = this.act.getResources() ;
	}
	
	public class Node{
		public int index ;
		public int id ;
		public LinearLayout itemLinear  ;
		
		public TextView item;
	}
	
	
	public Node createNode(int index, final int id, String txt){
		Node node = new Node() ;
		node.index = index ;
		node.id = id ;
		node.item = this.createItemTextView(txt) ;

		Preferences p = Preferences.getInstance() ;
		String str = "" ;
		if(txt != null){
			node.item.setText(txt) ;
			p.putString(Constant.func_vk_05_050_ + id, txt) ;
		}else{
			str = p.getString(Constant.func_vk_05_050_ + id) ;
			if(!str.equals(Constant.errorStr)){node.item.setText(str);}
		}
		
		return node ;
	}
	
	public void addNode(LinearLayout contain, Node node){
		node.itemLinear = this.createItemLinearLayout(node.item) ;
		contain.addView(node.itemLinear) ;
	}
	
	
	public void removeNode(LinearLayout contain, Node node){
		contain.removeView(node.itemLinear) ;
		
		Preferences.getInstance().remove(Constant.func_vk_05_050_ + node.id);
	}
	
	private TextView createItemTextView(String name){
		TextView tv = new TextView(act) ;
		tv.setText(name) ;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(this.rs.getDimensionPixelSize(R.dimen.tv_width_300), LinearLayout.LayoutParams.MATCH_PARENT);
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

	private LinearLayout createItemLinearLayout(TextView item){
		LinearLayout ll = new LinearLayout(this.act) ;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, this.rs.getDimensionPixelSize(R.dimen.common_line_height30));
		ll.setLayoutParams(lp) ;
		
		ll.addView(item) ;
		
		return ll ;
	}

}
