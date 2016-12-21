package com.blg.rtu.frmFunction;

import android.widget.CompoundButton;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_080_HelpCheckBox {
	private F_04_080 fr ;
	
	public F_04_080_HelpCheckBox(F_04_080 fr){
		this.fr = fr ;
	}
	
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
    	Preferences p = Preferences.getInstance() ;
    	p.putInt(Constant.func_vk_04_080_cb_03, 1);
    	/*if(buttonView == fr.cb01){
            if(!isChecked){fr.item01.setText("") ;p.remove(Constant.func_vk_04_080_cb_01);}else{p.putInt(Constant.func_vk_04_080_cb_01, 1);} 
    	}else if(buttonView == fr.cb02){
    		if(!isChecked){fr.item02.setText("") ;p.remove(Constant.func_vk_04_080_cb_02);}else{p.putInt(Constant.func_vk_04_080_cb_02, 1);} 
    	}else if(buttonView == fr.cb03){
    		if(!isChecked){fr.item03.setText("") ;p.remove(Constant.func_vk_04_080_cb_03);}else{p.putInt(Constant.func_vk_04_080_cb_03, 1);} 
    	}else if(buttonView == fr.cb04){
    		if(!isChecked){fr.item04.setText("") ;p.remove(Constant.func_vk_04_080_cb_04);}else{p.putInt(Constant.func_vk_04_080_cb_04, 1);} 
    	}else if(buttonView == fr.cb05){
    		if(!isChecked){fr.item05.setText("") ;p.remove(Constant.func_vk_04_080_cb_05);}else{p.putInt(Constant.func_vk_04_080_cb_05, 1);} 
    	}else if(buttonView == fr.cb06){
    		if(!isChecked){fr.item06.setText("") ;p.remove(Constant.func_vk_04_080_cb_06);}else{p.putInt(Constant.func_vk_04_080_cb_06, 1);} 
    	}else if(buttonView == fr.cb07){
    		if(!isChecked){fr.item07.setText("") ;p.remove(Constant.func_vk_04_080_cb_07);}else{p.putInt(Constant.func_vk_04_080_cb_07, 1);} 
    	}else if(buttonView == fr.cb08){
    		if(!isChecked){fr.item08.setText("") ;p.remove(Constant.func_vk_04_080_cb_08);}else{p.putInt(Constant.func_vk_04_080_cb_08, 1);} 
    	}else if(buttonView == fr.cb09){
    		if(!isChecked){fr.item09.setText("") ;p.remove(Constant.func_vk_04_080_cb_09);}else{p.putInt(Constant.func_vk_04_080_cb_09, 1);} 
    	}else if(buttonView == fr.cb10){
    		if(!isChecked){fr.item10.setText("") ;p.remove(Constant.func_vk_04_080_cb_10);}else{p.putInt(Constant.func_vk_04_080_cb_10, 1);} 
    	}else if(buttonView == fr.cb11){
    		if(!isChecked){fr.item11.setText("") ;p.remove(Constant.func_vk_04_080_cb_11);}else{p.putInt(Constant.func_vk_04_080_cb_11, 1);} 
    	}else if(buttonView == fr.cb12){
    		if(!isChecked){fr.item12.setText("") ;p.remove(Constant.func_vk_04_080_cb_12);}else{p.putInt(Constant.func_vk_04_080_cb_12, 1);} 
    	}else if(buttonView == fr.cb13){
    		if(!isChecked){fr.item13.setText("") ;p.remove(Constant.func_vk_04_080_cb_13);}else{p.putInt(Constant.func_vk_04_080_cb_13, 1);} 
    	}else if(buttonView == fr.cb14){
    		if(!isChecked){fr.item14.setText("") ;p.remove(Constant.func_vk_04_080_cb_14);}else{p.putInt(Constant.func_vk_04_080_cb_14, 1);} 
    	}*/
    } 
}
