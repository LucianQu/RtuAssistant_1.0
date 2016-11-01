package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_070_HelpInitData {
	private F_04_070 fr ;
	
	public F_04_070_HelpInitData(F_04_070 fr){
		this.fr = fr ;
	}
	public void initData(){
    	Preferences p = Preferences.getInstance() ;
    	Integer ch = 0 ;
    	ch = p.getInt(Constant.func_vk_04_070_item_01);if(ch != Constant.errorInt && ch == 1){fr.cb01.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_02);if(ch != Constant.errorInt && ch == 1){fr.cb02.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_03);if(ch != Constant.errorInt && ch == 1){fr.cb03.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_04);if(ch != Constant.errorInt && ch == 1){fr.cb04.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_05);if(ch != Constant.errorInt && ch == 1){fr.cb05.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_06);if(ch != Constant.errorInt && ch == 1){fr.cb06.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_07);if(ch != Constant.errorInt && ch == 1){fr.cb07.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_08);if(ch != Constant.errorInt && ch == 1){fr.cb08.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_09);if(ch != Constant.errorInt && ch == 1){fr.cb09.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_10);if(ch != Constant.errorInt && ch == 1){fr.cb10.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_11);if(ch != Constant.errorInt && ch == 1){fr.cb11.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_12);if(ch != Constant.errorInt && ch == 1){fr.cb12.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_13);if(ch != Constant.errorInt && ch == 1){fr.cb13.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_14);if(ch != Constant.errorInt && ch == 1){fr.cb14.setChecked(true);} 
    	ch = p.getInt(Constant.func_vk_04_070_item_15);if(ch != Constant.errorInt && ch == 1){fr.cb15.setChecked(true);} 
    }
}
