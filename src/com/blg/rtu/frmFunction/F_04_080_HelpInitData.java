package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_080_HelpInitData {
	private F_04_080 fr ;
	
	public F_04_080_HelpInitData(F_04_080 fr){
		this.fr = fr ;
	}
	public void initData(){
    	Preferences p = Preferences.getInstance() ;
       	String str = null ;
    	Integer ch = 0 ;
    	ch = p.getInt(Constant.func_vk_04_080_cb_01);if(ch != Constant.errorInt && ch == 1){fr.cb01.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_01);if(!str.equals(Constant.errorStr)){fr.item01.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_02);if(ch != Constant.errorInt && ch == 1){fr.cb02.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_02);if(!str.equals(Constant.errorStr)){fr.item02.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_03);if(ch != Constant.errorInt && ch == 1){fr.cb03.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_03);if(!str.equals(Constant.errorStr)){fr.item03.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_04);if(ch != Constant.errorInt && ch == 1){fr.cb04.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_04);if(!str.equals(Constant.errorStr)){fr.item04.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_05);if(ch != Constant.errorInt && ch == 1){fr.cb05.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_05);if(!str.equals(Constant.errorStr)){fr.item05.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_06);if(ch != Constant.errorInt && ch == 1){fr.cb06.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_06);if(!str.equals(Constant.errorStr)){fr.item06.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_07);if(ch != Constant.errorInt && ch == 1){fr.cb07.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_07);if(!str.equals(Constant.errorStr)){fr.item07.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_08);if(ch != Constant.errorInt && ch == 1){fr.cb08.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_08);if(!str.equals(Constant.errorStr)){fr.item08.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_09);if(ch != Constant.errorInt && ch == 1){fr.cb09.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_09);if(!str.equals(Constant.errorStr)){fr.item09.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_10);if(ch != Constant.errorInt && ch == 1){fr.cb10.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_10);if(!str.equals(Constant.errorStr)){fr.item10.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_11);if(ch != Constant.errorInt && ch == 1){fr.cb11.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_11);if(!str.equals(Constant.errorStr)){fr.item11.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_12);if(ch != Constant.errorInt && ch == 1){fr.cb12.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_12);if(!str.equals(Constant.errorStr)){fr.item12.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_13);if(ch != Constant.errorInt && ch == 1){fr.cb13.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_13);if(!str.equals(Constant.errorStr)){fr.item13.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_080_cb_14);if(ch != Constant.errorInt && ch == 1){fr.cb14.setChecked(true);str = p.getString(Constant.func_vk_04_080_item_14);if(!str.equals(Constant.errorStr)){fr.item14.setText(str);}} 
    }
}
