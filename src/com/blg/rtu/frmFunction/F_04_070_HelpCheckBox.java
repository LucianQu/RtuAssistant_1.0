package com.blg.rtu.frmFunction;

import android.widget.CompoundButton;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_070_HelpCheckBox {
	private F_04_070 fr ;
	
	public F_04_070_HelpCheckBox(F_04_070 fr){
		this.fr = fr ;
	}
	
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
    	Preferences p = Preferences.getInstance() ;
    	if(buttonView == fr.cb01){
            if(!isChecked){p.remove(Constant.func_vk_04_070_item_01);}else{p.putInt(Constant.func_vk_04_070_item_01, 1);} 
    	}else if(buttonView == fr.cb02){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_02);}else{p.putInt(Constant.func_vk_04_070_item_02, 1);} 
    	}else if(buttonView == fr.cb03){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_03);}else{p.putInt(Constant.func_vk_04_070_item_03, 1);} 
    	}else if(buttonView == fr.cb04){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_04);}else{p.putInt(Constant.func_vk_04_070_item_04, 1);} 
    	}else if(buttonView == fr.cb05){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_05);}else{p.putInt(Constant.func_vk_04_070_item_05, 1);} 
    	}else if(buttonView == fr.cb06){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_06);}else{p.putInt(Constant.func_vk_04_070_item_06, 1);} 
    	}else if(buttonView == fr.cb07){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_07);}else{p.putInt(Constant.func_vk_04_070_item_07, 1);} 
    	}else if(buttonView == fr.cb08){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_08);}else{p.putInt(Constant.func_vk_04_070_item_08, 1);} 
    	}else if(buttonView == fr.cb09){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_09);}else{p.putInt(Constant.func_vk_04_070_item_09, 1);} 
    	}else if(buttonView == fr.cb10){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_10);}else{p.putInt(Constant.func_vk_04_070_item_10, 1);} 
    	}else if(buttonView == fr.cb11){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_11);}else{p.putInt(Constant.func_vk_04_070_item_11, 1);} 
    	}else if(buttonView == fr.cb12){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_12);}else{p.putInt(Constant.func_vk_04_070_item_12, 1);} 
    	}else if(buttonView == fr.cb13){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_13);}else{p.putInt(Constant.func_vk_04_070_item_13, 1);} 
    	}else if(buttonView == fr.cb14){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_14);}else{p.putInt(Constant.func_vk_04_070_item_14, 1);} 
    	}else if(buttonView == fr.cb15){
    		if(!isChecked){p.remove(Constant.func_vk_04_070_item_15);}else{p.putInt(Constant.func_vk_04_070_item_15, 1);} 
    	}
    } 
}
