package com.blg.rtu.frmFunction;

import android.widget.CompoundButton;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_08_050_HelpCheckBox {
	private F_08_050 fr ;
	
	public F_08_050_HelpCheckBox(F_08_050 fr){
		this.fr = fr ;
	}
	
    public void onCheckedChanged(CompoundButton view, boolean isChecked){
    	Preferences p = Preferences.getInstance() ;
    	if(view == fr.cb01_01_y){
            if(isChecked){fr.cb01_01_n.setChecked(false) ;fr.param.setA01_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_01, 1);
            }else{fr.cb01_01_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_01_n){
            if(isChecked){fr.cb01_01_y.setChecked(false) ;fr.param.setA01_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_01, 0);
            }else{fr.cb01_01_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_02_y){
            if(isChecked){fr.cb01_02_n.setChecked(false) ;fr.param.setA02_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_02, 1);
            }else{fr.cb01_02_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_02_n){
            if(isChecked){fr.cb01_02_y.setChecked(false) ;fr.param.setA02_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_02, 0);
            }else{fr.cb01_02_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_03_y){
            if(isChecked){fr.cb01_03_n.setChecked(false) ;fr.param.setA03_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_03, 1);
            }else{fr.cb01_03_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_03_n){
            if(isChecked){fr.cb01_03_y.setChecked(false) ;fr.param.setA03_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_03, 0);
            }else{fr.cb01_03_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_04_y){
            if(isChecked){fr.cb01_04_n.setChecked(false) ;fr.param.setA04_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_04, 1);
            }else{fr.cb01_04_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_04_n){
            if(isChecked){fr.cb01_04_y.setChecked(false) ;fr.param.setA04_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_04, 0);
            }else{fr.cb01_04_y.setChecked(true) ;} 
    	}else if(view == fr.cb01_05_y){
            if(isChecked){fr.cb01_05_n.setChecked(false) ;fr.param.setA05_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_05, 1);
            }else{fr.cb01_05_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_05_n){
            if(isChecked){fr.cb01_05_y.setChecked(false) ;fr.param.setA05_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_05, 0);
            }else{fr.cb01_05_y.setChecked(true) ;} 
    	}else if(view == fr.cb01_06_y){
            if(isChecked){fr.cb01_06_n.setChecked(false) ;fr.param.setA06_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_06, 1);
            }else{fr.cb01_06_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_06_n){
            if(isChecked){fr.cb01_06_y.setChecked(false) ;fr.param.setA06_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_06, 0);
            }else{fr.cb01_06_y.setChecked(true) ;} 
    	}else if(view == fr.cb01_07_y){
            if(isChecked){fr.cb01_07_n.setChecked(false) ;fr.param.setA07_0or1(1) ;p.putInt(Constant.func_vk_08_050_01_07, 1);
            }else{fr.cb01_07_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_07_n){
            if(isChecked){fr.cb01_07_y.setChecked(false) ;fr.param.setA07_0or1(0) ;p.putInt(Constant.func_vk_08_050_01_07, 0);
            }else{fr.cb01_07_y.setChecked(true) ;} 
    	}
    	
   	
    } 
}
