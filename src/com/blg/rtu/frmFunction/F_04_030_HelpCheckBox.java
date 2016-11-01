package com.blg.rtu.frmFunction;

import android.widget.CompoundButton;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_030_HelpCheckBox {
	private F_04_030 fr ;
	
	public F_04_030_HelpCheckBox(F_04_030 fr){
		this.fr = fr ;
	}
	
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
    	Preferences p = Preferences.getInstance() ;
    	if(buttonView == fr.cb01){
            if(!isChecked){fr.item01.setText("") ;p.remove(Constant.func_vk_04_030_cb_01);}else{p.putInt(Constant.func_vk_04_030_cb_01, 1);} 
    	}else if(buttonView == fr.cb02){
    		if(!isChecked){fr.item02.setText("") ;p.remove(Constant.func_vk_04_030_cb_02);}else{p.putInt(Constant.func_vk_04_030_cb_02, 1);} 
    	}else if(buttonView == fr.cb03){
    		if(!isChecked){fr.item03.setText("") ;p.remove(Constant.func_vk_04_030_cb_03);}else{p.putInt(Constant.func_vk_04_030_cb_03, 1);} 
    	}else if(buttonView == fr.cb04){
    		if(!isChecked){fr.item04.setText("") ;p.remove(Constant.func_vk_04_030_cb_04);}else{p.putInt(Constant.func_vk_04_030_cb_04, 1);} 
    	}else if(buttonView == fr.cb05){
    		if(!isChecked){fr.item05.setText("") ;p.remove(Constant.func_vk_04_030_cb_05);}else{p.putInt(Constant.func_vk_04_030_cb_05, 1);} 
    	}else if(buttonView == fr.cb06){
    		if(!isChecked){fr.item06.setText("") ;p.remove(Constant.func_vk_04_030_cb_06);}else{p.putInt(Constant.func_vk_04_030_cb_06, 1);} 
    	}else if(buttonView == fr.cb07){
    		if(!isChecked){fr.item07.setText("") ;p.remove(Constant.func_vk_04_030_cb_07);}else{p.putInt(Constant.func_vk_04_030_cb_07, 1);} 
    	}else if(buttonView == fr.cb08){
    		if(!isChecked){fr.item08.setText("") ;p.remove(Constant.func_vk_04_030_cb_08);}else{p.putInt(Constant.func_vk_04_030_cb_08, 1);} 
    	}else if(buttonView == fr.cb09){
    		if(!isChecked){fr.item09.setText("") ;p.remove(Constant.func_vk_04_030_cb_09);}else{p.putInt(Constant.func_vk_04_030_cb_09, 1);} 
    	}else if(buttonView == fr.cb10){
    		if(!isChecked){fr.item10.setText("") ;p.remove(Constant.func_vk_04_030_cb_10);}else{p.putInt(Constant.func_vk_04_030_cb_10, 1);} 
    	}else if(buttonView == fr.cb11){
    		if(!isChecked){fr.item11.setText("") ;p.remove(Constant.func_vk_04_030_cb_11);}else{p.putInt(Constant.func_vk_04_030_cb_11, 1);} 
    	}else if(buttonView == fr.cb12){
    		if(!isChecked){fr.item12.setText("") ;p.remove(Constant.func_vk_04_030_cb_12);}else{p.putInt(Constant.func_vk_04_030_cb_12, 1);} 
    	}else if(buttonView == fr.cb13){
    		if(!isChecked){fr.item13.setText("") ;p.remove(Constant.func_vk_04_030_cb_13);}else{p.putInt(Constant.func_vk_04_030_cb_13, 1);} 
    	}else if(buttonView == fr.cb14){
    		if(!isChecked){fr.item14.setText("") ;p.remove(Constant.func_vk_04_030_cb_14);}else{p.putInt(Constant.func_vk_04_030_cb_14, 1);} 
    	}else if(buttonView == fr.cb15){
    		if(!isChecked){fr.item15.setText("") ;p.remove(Constant.func_vk_04_030_cb_15);}else{p.putInt(Constant.func_vk_04_030_cb_15, 1);} 
    	}else if(buttonView == fr.cb16){
    		if(!isChecked){fr.item16.setText("") ;p.remove(Constant.func_vk_04_030_cb_16);}else{p.putInt(Constant.func_vk_04_030_cb_16, 1);} 
    	}else if(buttonView == fr.cb17){
    		if(!isChecked){fr.item17.setText("") ;p.remove(Constant.func_vk_04_030_cb_17);}else{p.putInt(Constant.func_vk_04_030_cb_17, 1);} 
    	}else if(buttonView == fr.cb18){
    		if(!isChecked){fr.item18.setText("") ;p.remove(Constant.func_vk_04_030_cb_18);}else{p.putInt(Constant.func_vk_04_030_cb_18, 1);} 
    	}else if(buttonView == fr.cb19){
    		if(!isChecked){fr.item19.setText("") ;p.remove(Constant.func_vk_04_030_cb_19);}else{p.putInt(Constant.func_vk_04_030_cb_19, 1);} 
    	}else if(buttonView == fr.cb20){
    		if(!isChecked){fr.item20.setText("") ;p.remove(Constant.func_vk_04_030_cb_20);}else{p.putInt(Constant.func_vk_04_030_cb_20, 1);} 
    	}else if(buttonView == fr.cb21){
    		if(!isChecked){fr.item21.setText("") ;p.remove(Constant.func_vk_04_030_cb_21);}else{p.putInt(Constant.func_vk_04_030_cb_21, 1);} 
    	}else if(buttonView == fr.cb22){
    		if(!isChecked){fr.item22.setText("") ;p.remove(Constant.func_vk_04_030_cb_22);}else{p.putInt(Constant.func_vk_04_030_cb_22, 1);} 
    	}else if(buttonView == fr.cb23){
    		if(!isChecked){fr.item23.setText("") ;p.remove(Constant.func_vk_04_030_cb_23);}else{p.putInt(Constant.func_vk_04_030_cb_23, 1);} 
    	}else if(buttonView == fr.cb24){
    		if(!isChecked){fr.item24.setText("") ;p.remove(Constant.func_vk_04_030_cb_24);}else{p.putInt(Constant.func_vk_04_030_cb_24, 1);} 
    	}else if(buttonView == fr.cb25){
    		if(!isChecked){fr.item25.setText("") ;p.remove(Constant.func_vk_04_030_cb_25);}else{p.putInt(Constant.func_vk_04_030_cb_25, 1);} 
    	}else if(buttonView == fr.cb26){
    		if(!isChecked){fr.item26.setText("") ;p.remove(Constant.func_vk_04_030_cb_26);}else{p.putInt(Constant.func_vk_04_030_cb_26, 1);} 
    	}else if(buttonView == fr.cb27){
    		if(!isChecked){fr.item27.setText("") ;p.remove(Constant.func_vk_04_030_cb_27);}else{p.putInt(Constant.func_vk_04_030_cb_27, 1);} 
    	}else if(buttonView == fr.cb28){
    		if(!isChecked){fr.item28.setText("") ;p.remove(Constant.func_vk_04_030_cb_28);}else{p.putInt(Constant.func_vk_04_030_cb_28, 1);} 
    	}else if(buttonView == fr.cb29){
    		if(!isChecked){fr.item29.setText("") ;p.remove(Constant.func_vk_04_030_cb_29);}else{p.putInt(Constant.func_vk_04_030_cb_29, 1);} 
    	}else if(buttonView == fr.cb30){
    		if(!isChecked){fr.item30.setText("") ;p.remove(Constant.func_vk_04_030_cb_30);}else{p.putInt(Constant.func_vk_04_030_cb_30, 1);} 
    	}else if(buttonView == fr.cb31){
    		if(!isChecked){fr.item31.setText("") ;p.remove(Constant.func_vk_04_030_cb_31);}else{p.putInt(Constant.func_vk_04_030_cb_31, 1);} 
    	}else if(buttonView == fr.cb32){
    		if(!isChecked){fr.item32.setText("") ;p.remove(Constant.func_vk_04_030_cb_32);}else{p.putInt(Constant.func_vk_04_030_cb_32, 1);} 
    	}else if(buttonView == fr.cb33){
    		if(!isChecked){fr.item33.setText("") ;p.remove(Constant.func_vk_04_030_cb_33);}else{p.putInt(Constant.func_vk_04_030_cb_33, 1);} 
    	}else if(buttonView == fr.cb34){
    		if(!isChecked){fr.item34.setText("") ;p.remove(Constant.func_vk_04_030_cb_34);}else{p.putInt(Constant.func_vk_04_030_cb_34, 1);} 
    	}else if(buttonView == fr.cb35){
    		if(!isChecked){fr.item35.setText("") ;p.remove(Constant.func_vk_04_030_cb_35);}else{p.putInt(Constant.func_vk_04_030_cb_35, 1);} 
    	}
    } 
}
