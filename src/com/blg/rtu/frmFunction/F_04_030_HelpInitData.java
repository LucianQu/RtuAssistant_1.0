package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_030_HelpInitData {
	private F_04_030 fr ;
	
	public F_04_030_HelpInitData(F_04_030 fr){
		this.fr = fr ;
	}
	public void initData(){
    	Preferences p = Preferences.getInstance() ;
       	String str = null ;
    	Integer ch = 0 ;
    	ch = p.getInt(Constant.func_vk_04_030_cb_01);if(ch != Constant.errorInt && ch == 1){fr.cb01.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_01);if(!str.equals(Constant.errorStr)){fr.item01.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_02);if(ch != Constant.errorInt && ch == 1){fr.cb02.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_02);if(!str.equals(Constant.errorStr)){fr.item02.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_03);if(ch != Constant.errorInt && ch == 1){fr.cb03.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_03);if(!str.equals(Constant.errorStr)){fr.item03.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_04);if(ch != Constant.errorInt && ch == 1){fr.cb04.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_04);if(!str.equals(Constant.errorStr)){fr.item04.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_05);if(ch != Constant.errorInt && ch == 1){fr.cb05.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_05);if(!str.equals(Constant.errorStr)){fr.item05.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_06);if(ch != Constant.errorInt && ch == 1){fr.cb06.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_06);if(!str.equals(Constant.errorStr)){fr.item06.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_07);if(ch != Constant.errorInt && ch == 1){fr.cb07.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_07);if(!str.equals(Constant.errorStr)){fr.item07.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_08);if(ch != Constant.errorInt && ch == 1){fr.cb08.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_08);if(!str.equals(Constant.errorStr)){fr.item08.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_09);if(ch != Constant.errorInt && ch == 1){fr.cb09.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_09);if(!str.equals(Constant.errorStr)){fr.item09.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_10);if(ch != Constant.errorInt && ch == 1){fr.cb10.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_10);if(!str.equals(Constant.errorStr)){fr.item10.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_11);if(ch != Constant.errorInt && ch == 1){fr.cb11.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_11);if(!str.equals(Constant.errorStr)){fr.item11.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_12);if(ch != Constant.errorInt && ch == 1){fr.cb12.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_12);if(!str.equals(Constant.errorStr)){fr.item12.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_13);if(ch != Constant.errorInt && ch == 1){fr.cb13.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_13);if(!str.equals(Constant.errorStr)){fr.item13.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_14);if(ch != Constant.errorInt && ch == 1){fr.cb14.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_14);if(!str.equals(Constant.errorStr)){fr.item14.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_15);if(ch != Constant.errorInt && ch == 1){fr.cb15.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_15);if(!str.equals(Constant.errorStr)){fr.item15.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_16);if(ch != Constant.errorInt && ch == 1){fr.cb16.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_16);if(!str.equals(Constant.errorStr)){fr.item16.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_17);if(ch != Constant.errorInt && ch == 1){fr.cb17.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_17);if(!str.equals(Constant.errorStr)){fr.item17.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_18);if(ch != Constant.errorInt && ch == 1){fr.cb18.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_18);if(!str.equals(Constant.errorStr)){fr.item18.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_19);if(ch != Constant.errorInt && ch == 1){fr.cb19.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_19);if(!str.equals(Constant.errorStr)){fr.item19.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_20);if(ch != Constant.errorInt && ch == 1){fr.cb20.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_20);if(!str.equals(Constant.errorStr)){fr.item20.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_21);if(ch != Constant.errorInt && ch == 1){fr.cb21.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_21);if(!str.equals(Constant.errorStr)){fr.item21.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_22);if(ch != Constant.errorInt && ch == 1){fr.cb22.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_22);if(!str.equals(Constant.errorStr)){fr.item22.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_23);if(ch != Constant.errorInt && ch == 1){fr.cb23.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_23);if(!str.equals(Constant.errorStr)){fr.item23.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_24);if(ch != Constant.errorInt && ch == 1){fr.cb24.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_24);if(!str.equals(Constant.errorStr)){fr.item24.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_25);if(ch != Constant.errorInt && ch == 1){fr.cb25.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_25);if(!str.equals(Constant.errorStr)){fr.item25.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_26);if(ch != Constant.errorInt && ch == 1){fr.cb26.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_26);if(!str.equals(Constant.errorStr)){fr.item26.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_27);if(ch != Constant.errorInt && ch == 1){fr.cb27.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_27);if(!str.equals(Constant.errorStr)){fr.item27.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_28);if(ch != Constant.errorInt && ch == 1){fr.cb28.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_28);if(!str.equals(Constant.errorStr)){fr.item28.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_29);if(ch != Constant.errorInt && ch == 1){fr.cb29.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_29);if(!str.equals(Constant.errorStr)){fr.item29.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_30);if(ch != Constant.errorInt && ch == 1){fr.cb30.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_30);if(!str.equals(Constant.errorStr)){fr.item30.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_31);if(ch != Constant.errorInt && ch == 1){fr.cb31.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_31);if(!str.equals(Constant.errorStr)){fr.item31.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_32);if(ch != Constant.errorInt && ch == 1){fr.cb32.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_32);if(!str.equals(Constant.errorStr)){fr.item32.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_33);if(ch != Constant.errorInt && ch == 1){fr.cb33.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_33);if(!str.equals(Constant.errorStr)){fr.item33.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_34);if(ch != Constant.errorInt && ch == 1){fr.cb34.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_34);if(!str.equals(Constant.errorStr)){fr.item34.setText(str);}} 
    	ch = p.getInt(Constant.func_vk_04_030_cb_35);if(ch != Constant.errorInt && ch == 1){fr.cb35.setChecked(true);str = p.getString(Constant.func_vk_04_030_item_35);if(!str.equals(Constant.errorStr)){fr.item35.setText(str);}} 
    }
}
