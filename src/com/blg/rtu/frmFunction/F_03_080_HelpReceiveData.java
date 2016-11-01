package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.cdE7_F7.Data_E7_F7;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_03_080_HelpReceiveData {
	
	private F_03_080 fr ;
	
	public F_03_080_HelpReceiveData(F_03_080 fr){
		this.fr = fr ;
	}
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
    	Preferences p = Preferences.getInstance() ;
    	int has = 0 ;
    	Integer dv = null ;
    	
    	Data_E7_F7 sd = (Data_E7_F7)d.getSubData() ;
		
		has = sd.getEnable_01() ;
		dv = sd.getValue_01() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_01, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_01, "" + dv) ;
				fr.cb01.setChecked(true) ;
				fr.item01.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_01);
			p.remove(Constant.func_vk_03_080_item_01);
			fr.cb01.setChecked(false) ;
			fr.item01.setText("") ;
		}
		has = sd.getEnable_02() ;
		dv = sd.getValue_02() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_02, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_02, "" + dv) ;
				fr.cb02.setChecked(true) ;
				fr.item02.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_02);
			p.remove(Constant.func_vk_03_080_item_02);
			fr.cb02.setChecked(false) ;
			fr.item02.setText("") ;
		}
		has = sd.getEnable_03() ;
		dv = sd.getValue_03() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_03, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_03, "" + dv) ;
				fr.cb03.setChecked(true) ;
				fr.item03.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_03);
			p.remove(Constant.func_vk_03_080_item_03);
			fr.cb03.setChecked(false) ;
			fr.item03.setText("") ;
		}
		has = sd.getEnable_04() ;
		dv = sd.getValue_04() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_04, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_04, "" + dv) ;
				fr.cb04.setChecked(true) ;
				fr.item04.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_04);
			p.remove(Constant.func_vk_03_080_item_04);
			fr.cb04.setChecked(false) ;
			fr.item04.setText("") ;
		}
		has = sd.getEnable_05() ;
		dv = sd.getValue_05() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_05, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_05, "" + dv) ;
				fr.cb05.setChecked(true) ;
				fr.item05.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_05);
			p.remove(Constant.func_vk_03_080_item_05);
			fr.cb05.setChecked(false) ;
			fr.item05.setText("") ;
		}
		has = sd.getEnable_06() ;
		dv = sd.getValue_06() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_06, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_06, "" + dv) ;
				fr.cb06.setChecked(true) ;
				fr.item06.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_06);
			p.remove(Constant.func_vk_03_080_item_06);
			fr.cb06.setChecked(false) ;
			fr.item06.setText("") ;
		}
		has = sd.getEnable_07() ;
		dv = sd.getValue_07() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_07, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_07, "" + dv) ;
				fr.cb07.setChecked(true) ;
				fr.item07.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_07);
			p.remove(Constant.func_vk_03_080_item_07);
			fr.cb07.setChecked(false) ;
			fr.item07.setText("") ;
		}
		has = sd.getEnable_08() ;
		dv = sd.getValue_08() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_08, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_08, "" + dv) ;
				fr.cb08.setChecked(true) ;
				fr.item08.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_08);
			p.remove(Constant.func_vk_03_080_item_08);
			fr.cb08.setChecked(false) ;
			fr.item08.setText("") ;
		}
		has = sd.getEnable_09() ;
		dv = sd.getValue_09() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_09, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_09, "" + dv) ;
				fr.cb09.setChecked(true) ;
				fr.item09.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_09);
			p.remove(Constant.func_vk_03_080_item_09);
			fr.cb09.setChecked(false) ;
			fr.item09.setText("") ;
		}
		has = sd.getEnable_10() ;
		dv = sd.getValue_10() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_10, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_10, "" + dv) ;
				fr.cb10.setChecked(true) ;
				fr.item10.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_10);
			p.remove(Constant.func_vk_03_080_item_10);
			fr.cb10.setChecked(false) ;
			fr.item10.setText("") ;
		}
		has = sd.getEnable_11() ;
		dv = sd.getValue_11() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_11, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_11, "" + dv) ;
				fr.cb11.setChecked(true) ;
				fr.item11.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_11);
			p.remove(Constant.func_vk_03_080_item_11);
			fr.cb11.setChecked(false) ;
			fr.item11.setText("") ;
		}
		has = sd.getEnable_12() ;
		dv = sd.getValue_12() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_12, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_12, "" + dv) ;
				fr.cb12.setChecked(true) ;
				fr.item12.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_12);
			p.remove(Constant.func_vk_03_080_item_12);
			fr.cb12.setChecked(false) ;
			fr.item12.setText("") ;
		}
		has = sd.getEnable_13() ;
		dv = sd.getValue_13() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_13, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_13, "" + dv) ;
				fr.cb13.setChecked(true) ;
				fr.item13.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_13);
			p.remove(Constant.func_vk_03_080_item_13);
			fr.cb13.setChecked(false) ;
			fr.item13.setText("") ;
		}
		has = sd.getEnable_14() ;
		dv = sd.getValue_14() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_14, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_14, "" + dv) ;
				fr.cb14.setChecked(true) ;
				fr.item14.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_14);
			p.remove(Constant.func_vk_03_080_item_14);
			fr.cb14.setChecked(false) ;
			fr.item14.setText("") ;
		}
		has = sd.getEnable_15() ;
		dv = sd.getValue_15() ;
		if(has == 1){
			p.putInt(Constant.func_vk_03_080_cb_15, 1);
			if(dv != null){
				p.putString(Constant.func_vk_03_080_item_15, "" + dv) ;
				fr.cb15.setChecked(true) ;
				fr.item15.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_03_080_cb_15);
			p.remove(Constant.func_vk_03_080_item_15);
			fr.cb15.setChecked(false) ;
			fr.item15.setText("") ;
		}
		
	}
}
