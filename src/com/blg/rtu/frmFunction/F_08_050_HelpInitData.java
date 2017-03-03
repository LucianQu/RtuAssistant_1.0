package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_08_050_HelpInitData {
	private F_08_050 fr ;
	
	public F_08_050_HelpInitData(F_08_050 fr){
		this.fr = fr ;
	}
	public void initData(){
    	Preferences p = Preferences.getInstance() ;
    	Integer ch = 0 ;
    	ch = p.getInt(Constant.func_vk_08_050_01_01);if(ch == Constant.errorInt || ch == 1){fr.cb01_01_y.setChecked(true);}else{fr.cb01_01_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_08_050_01_02);if(ch == Constant.errorInt || ch == 1){fr.cb01_02_y.setChecked(true);}else{fr.cb01_02_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_08_050_01_03);if(ch == Constant.errorInt || ch == 1){fr.cb01_03_y.setChecked(true);}else{fr.cb01_03_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_08_050_01_04);if(ch == Constant.errorInt || ch == 1){fr.cb01_04_y.setChecked(true);}else{fr.cb01_04_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_08_050_01_05);if(ch == Constant.errorInt || ch == 1){fr.cb01_05_y.setChecked(true);}else{fr.cb01_05_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_08_050_01_06);if(ch == Constant.errorInt || ch == 1){fr.cb01_06_y.setChecked(true);}else{fr.cb01_06_n.setChecked(true);}
    	ch = p.getInt(Constant.func_vk_08_050_01_07);if(ch == Constant.errorInt || ch == 1){fr.cb01_07_y.setChecked(true);}else{fr.cb01_07_n.setChecked(true);}

     }
}
