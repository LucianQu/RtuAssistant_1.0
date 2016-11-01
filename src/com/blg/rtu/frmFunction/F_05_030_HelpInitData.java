package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_05_030_HelpInitData {
	private F_05_030 fr ;
	
	public F_05_030_HelpInitData(F_05_030 fr){
		this.fr = fr ;
	}
	public void initData(){
    	Preferences p = Preferences.getInstance() ;
    	Integer ch = 0 ;
    	ch = p.getInt(Constant.func_vk_05_030_01_01);if(ch == Constant.errorInt || ch == 1){fr.cb01_01_y.setChecked(true);}else{fr.cb01_01_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_01_02);if(ch == Constant.errorInt || ch == 1){fr.cb01_02_y.setChecked(true);}else{fr.cb01_02_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_01_03);if(ch == Constant.errorInt || ch == 1){fr.cb01_03_y.setChecked(true);}else{fr.cb01_03_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_01_04);if(ch == Constant.errorInt || ch == 1){fr.cb01_04_y.setChecked(true);}else{fr.cb01_04_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_01_05);if(ch == Constant.errorInt || ch == 1){fr.cb01_05_y.setChecked(true);}else{fr.cb01_05_n.setChecked(true);}
    	
    	ch = p.getInt(Constant.func_vk_05_030_02_01);if(ch == Constant.errorInt || ch == 1){fr.cb02_01_y.setChecked(true);}else{fr.cb02_01_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_02);if(ch == Constant.errorInt || ch == 1){fr.cb02_02_y.setChecked(true);}else{fr.cb02_02_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_03);if(ch == Constant.errorInt || ch == 1){fr.cb02_03_y.setChecked(true);}else{fr.cb02_03_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_04);if(ch == Constant.errorInt || ch == 1){fr.cb02_04_y.setChecked(true);}else{fr.cb02_04_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_05);if(ch == Constant.errorInt || ch == 1){fr.cb02_05_y.setChecked(true);}else{fr.cb02_05_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_06);if(ch == Constant.errorInt || ch == 1){fr.cb02_06_y.setChecked(true);}else{fr.cb02_06_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_07);if(ch == Constant.errorInt || ch == 1){fr.cb02_07_y.setChecked(true);}else{fr.cb02_07_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_08);if(ch == Constant.errorInt || ch == 1){fr.cb02_08_y.setChecked(true);}else{fr.cb02_08_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_09);if(ch == Constant.errorInt || ch == 1){fr.cb02_09_y.setChecked(true);}else{fr.cb02_09_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_02_10);if(ch == Constant.errorInt || ch == 1){fr.cb02_10_y.setChecked(true);}else{fr.cb02_10_n.setChecked(true);}
    	
    	ch = p.getInt(Constant.func_vk_05_030_03_01);if(ch == Constant.errorInt || ch == 1){fr.cb03_01_y.setChecked(true);}else{fr.cb03_01_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_03_02);if(ch == Constant.errorInt || ch == 1){fr.cb03_02_y.setChecked(true);}else{fr.cb03_02_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_03_03);if(ch == Constant.errorInt || ch == 1){fr.cb03_03_y.setChecked(true);}else{fr.cb03_03_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_03_04);if(ch == Constant.errorInt || ch == 1){fr.cb03_04_y.setChecked(true);}else{fr.cb03_04_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_03_05);if(ch == Constant.errorInt || ch == 1){fr.cb03_05_y.setChecked(true);}else{fr.cb03_05_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_05_030_03_06);if(ch == Constant.errorInt || ch == 1){fr.cb03_06_y.setChecked(true);}else{fr.cb03_06_n.setChecked(true);}

     }
}
