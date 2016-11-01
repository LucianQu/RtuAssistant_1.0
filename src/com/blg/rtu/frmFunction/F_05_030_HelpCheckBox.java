package com.blg.rtu.frmFunction;

import android.widget.CompoundButton;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_05_030_HelpCheckBox {
	private F_05_030 fr ;
	
	public F_05_030_HelpCheckBox(F_05_030 fr){
		this.fr = fr ;
	}
	
    public void onCheckedChanged(CompoundButton view, boolean isChecked){
    	Preferences p = Preferences.getInstance() ;
    	if(view == fr.cb01_01_y){
            if(isChecked){fr.cb01_01_n.setChecked(false) ;fr.param.setA01_0or1(1) ;p.putInt(Constant.func_vk_05_030_01_01, 1);
            }else{fr.cb01_01_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_01_n){
            if(isChecked){fr.cb01_01_y.setChecked(false) ;fr.param.setA01_0or1(0) ;p.putInt(Constant.func_vk_05_030_01_01, 0);
            }else{fr.cb01_01_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_02_y){
            if(isChecked){fr.cb01_02_n.setChecked(false) ;fr.param.setA02_0or1(1) ;p.putInt(Constant.func_vk_05_030_01_02, 1);
            }else{fr.cb01_02_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_02_n){
            if(isChecked){fr.cb01_02_y.setChecked(false) ;fr.param.setA02_0or1(0) ;p.putInt(Constant.func_vk_05_030_01_02, 0);
            }else{fr.cb01_02_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_03_y){
            if(isChecked){fr.cb01_03_n.setChecked(false) ;fr.param.setA03_0or1(1) ;p.putInt(Constant.func_vk_05_030_01_03, 1);
            }else{fr.cb01_03_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_03_n){
            if(isChecked){fr.cb01_03_y.setChecked(false) ;fr.param.setA03_0or1(0) ;p.putInt(Constant.func_vk_05_030_01_03, 0);
            }else{fr.cb01_03_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_04_y){
            if(isChecked){fr.cb01_04_n.setChecked(false) ;fr.param.setA04_0or1(1) ;p.putInt(Constant.func_vk_05_030_01_04, 1);
            }else{fr.cb01_04_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_04_n){
            if(isChecked){fr.cb01_04_y.setChecked(false) ;fr.param.setA04_0or1(0) ;p.putInt(Constant.func_vk_05_030_01_04, 0);
            }else{fr.cb01_04_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb01_05_y){
            if(isChecked){fr.cb01_05_n.setChecked(false) ;fr.param.setA05_0or1(1) ;p.putInt(Constant.func_vk_05_030_01_05, 1);
            }else{fr.cb01_05_n.setChecked(true) ;} 
    	}else if(view == fr.cb01_05_n){
            if(isChecked){fr.cb01_05_y.setChecked(false) ;fr.param.setA05_0or1(0) ;p.putInt(Constant.func_vk_05_030_01_05, 0);
            }else{fr.cb01_05_y.setChecked(true) ;} 
    	}else
    	
    	
    	if(view == fr.cb02_01_y){
            if(isChecked){fr.cb02_01_n.setChecked(false) ;fr.param.setB01_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_01, 1);
            }else{fr.cb02_01_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_01_n){
            if(isChecked){fr.cb02_01_y.setChecked(false) ;fr.param.setB01_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_01, 0);
            }else{fr.cb02_01_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_02_y){
            if(isChecked){fr.cb02_02_n.setChecked(false) ;fr.param.setB02_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_02, 1);
            }else{fr.cb02_02_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_02_n){
            if(isChecked){fr.cb02_02_y.setChecked(false) ;fr.param.setB02_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_02, 0);
            }else{fr.cb02_02_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_03_y){
            if(isChecked){fr.cb02_03_n.setChecked(false) ;fr.param.setB03_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_03, 1);
            }else{fr.cb02_03_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_03_n){
            if(isChecked){fr.cb02_03_y.setChecked(false) ;fr.param.setB03_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_03, 0);
            }else{fr.cb02_03_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_04_y){
            if(isChecked){fr.cb02_04_n.setChecked(false) ;fr.param.setB04_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_04, 1);
            }else{fr.cb02_04_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_04_n){
            if(isChecked){fr.cb02_04_y.setChecked(false) ;fr.param.setB04_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_04, 0);
            }else{fr.cb02_04_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_05_y){
            if(isChecked){fr.cb02_05_n.setChecked(false) ;fr.param.setB05_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_05, 1);
            }else{fr.cb02_05_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_05_n){
            if(isChecked){fr.cb02_05_y.setChecked(false) ;fr.param.setB05_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_05, 0);
            }else{fr.cb02_05_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_06_y){
            if(isChecked){fr.cb02_06_n.setChecked(false) ;fr.param.setB06_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_06, 1);
            }else{fr.cb02_06_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_06_n){
            if(isChecked){fr.cb02_06_y.setChecked(false) ;fr.param.setB06_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_06, 0);
            }else{fr.cb02_06_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_07_y){
            if(isChecked){fr.cb02_07_n.setChecked(false) ;fr.param.setB07_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_07, 1);
            }else{fr.cb02_07_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_07_n){
            if(isChecked){fr.cb02_07_y.setChecked(false) ;fr.param.setB07_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_07, 0);
            }else{fr.cb02_07_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_08_y){
            if(isChecked){fr.cb02_08_n.setChecked(false) ;fr.param.setB08_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_08, 1);
            }else{fr.cb02_08_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_08_n){
            if(isChecked){fr.cb02_08_y.setChecked(false) ;fr.param.setB08_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_08, 0);
            }else{fr.cb02_08_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_09_y){
            if(isChecked){fr.cb02_09_n.setChecked(false) ;fr.param.setB09_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_09, 1);
            }else{fr.cb02_09_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_09_n){
            if(isChecked){fr.cb02_09_y.setChecked(false) ;fr.param.setB09_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_09, 0);
            }else{fr.cb02_09_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb02_10_y){
            if(isChecked){fr.cb02_10_n.setChecked(false) ;fr.param.setB10_0or1(1) ;p.putInt(Constant.func_vk_05_030_02_10, 1);
            }else{fr.cb02_10_n.setChecked(true) ;} 
    	}else if(view == fr.cb02_10_n){
            if(isChecked){fr.cb02_10_y.setChecked(false) ;fr.param.setB10_0or1(0) ;p.putInt(Constant.func_vk_05_030_02_10, 0);
            }else{fr.cb02_10_y.setChecked(true) ;} 
    	}else
        	
        	
    	if(view == fr.cb03_01_y){
            if(isChecked){fr.cb03_01_n.setChecked(false) ;fr.param.setC01_0or1(1) ;p.putInt(Constant.func_vk_05_030_03_01, 1);
            }else{fr.cb03_01_n.setChecked(true) ;} 
    	}else if(view == fr.cb03_01_n){
            if(isChecked){fr.cb03_01_y.setChecked(false) ;fr.param.setC01_0or1(0) ;p.putInt(Constant.func_vk_05_030_03_01, 0);
            }else{fr.cb03_01_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb03_02_y){
            if(isChecked){fr.cb03_02_n.setChecked(false) ;fr.param.setC02_0or1(1) ;p.putInt(Constant.func_vk_05_030_03_02, 1);
            }else{fr.cb03_02_n.setChecked(true) ;} 
    	}else if(view == fr.cb03_02_n){
            if(isChecked){fr.cb03_02_y.setChecked(false) ;fr.param.setC02_0or1(0) ;p.putInt(Constant.func_vk_05_030_03_02, 0);
            }else{fr.cb03_02_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb03_03_y){
            if(isChecked){fr.cb03_03_n.setChecked(false) ;fr.param.setC03_0or1(1) ;p.putInt(Constant.func_vk_05_030_03_03, 1);
            }else{fr.cb03_03_n.setChecked(true) ;} 
    	}else if(view == fr.cb03_03_n){
            if(isChecked){fr.cb03_03_y.setChecked(false) ;fr.param.setC03_0or1(0) ;p.putInt(Constant.func_vk_05_030_03_03, 0);
            }else{fr.cb03_03_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb03_04_y){
            if(isChecked){fr.cb03_04_n.setChecked(false) ;fr.param.setC04_0or1(1) ;p.putInt(Constant.func_vk_05_030_03_04, 1);
            }else{fr.cb03_04_n.setChecked(true) ;} 
    	}else if(view == fr.cb03_04_n){
            if(isChecked){fr.cb03_04_y.setChecked(false) ;fr.param.setC04_0or1(0) ;p.putInt(Constant.func_vk_05_030_03_04, 0);
            }else{fr.cb03_04_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb03_05_y){
            if(isChecked){fr.cb03_05_n.setChecked(false) ;fr.param.setC05_0or1(1) ;p.putInt(Constant.func_vk_05_030_03_05, 1);
            }else{fr.cb03_05_n.setChecked(true) ;} 
    	}else if(view == fr.cb03_05_n){
            if(isChecked){fr.cb03_05_y.setChecked(false) ;fr.param.setC05_0or1(0) ;p.putInt(Constant.func_vk_05_030_03_05, 0);
            }else{fr.cb03_05_y.setChecked(true) ;} 
    	}else 
    	if(view == fr.cb03_06_y){
            if(isChecked){fr.cb03_06_n.setChecked(false) ;fr.param.setC06_0or1(1) ;p.putInt(Constant.func_vk_05_030_03_06, 1);
            }else{fr.cb03_06_n.setChecked(true) ;} 
    	}else if(view == fr.cb03_06_n){
            if(isChecked){fr.cb03_06_y.setChecked(false) ;fr.param.setC06_0or1(0) ;p.putInt(Constant.func_vk_05_030_03_06, 0);
            }else{fr.cb03_06_y.setChecked(true) ;} 
    	}
    	
    	
   	
    } 
}
