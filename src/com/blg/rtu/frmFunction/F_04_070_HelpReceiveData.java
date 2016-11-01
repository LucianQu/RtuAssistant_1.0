package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.cdA0_54.Data_A0_54;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_070_HelpReceiveData {
	
	private F_04_070 fr ;
	
	public F_04_070_HelpReceiveData(F_04_070 fr){
		this.fr = fr ;
	}
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
    	Preferences p = Preferences.getInstance() ;
    	
    	Data_A0_54 sd = (Data_A0_54)d.getSubData() ;
		
    	int has = sd.getYuLiang() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_01, 1);
			fr.cb01.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_01) ;
			fr.cb01.setChecked(false) ;
		}
		has = sd.getShuiWei();
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_02, 1);
			fr.cb02.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_02) ;
			fr.cb02.setChecked(false) ;
		}
		has = sd.getLiuLiang() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_03, 1);
			fr.cb03.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_03) ;
			fr.cb03.setChecked(false) ;
		}
		has = sd.getLiuSu() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_04, 1);
			fr.cb04.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_04) ;
			fr.cb04.setChecked(false) ;
		}
		has = sd.getZhaWei() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_05, 1);
			fr.cb05.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_05) ;
			fr.cb05.setChecked(false) ;
		}
		has = sd.getGongLu() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_06, 1);
			fr.cb06.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_06) ;
			fr.cb06.setChecked(false) ;
		}
		has = sd.getQiYa() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_07, 1);
			fr.cb07.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_07) ;
			fr.cb07.setChecked(false) ;
		}
		has = sd.getFengSu() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_08, 1);
			fr.cb08.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_08) ;
			fr.cb08.setChecked(false) ;
		}
		has = sd.getShuiWen() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_09, 1);
			fr.cb09.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_09) ;
			fr.cb09.setChecked(false) ;
		}
		has = sd.getShuiZhi() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_10, 1);
			fr.cb10.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_10) ;
			fr.cb10.setChecked(false) ;
		}
		has = sd.getTuRang() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_11, 1);
			fr.cb11.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_11) ;
			fr.cb11.setChecked(false) ;
		}
		has = sd.getZhengFa() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_12, 1);
			fr.cb12.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_12) ;
			fr.cb12.setChecked(false) ;
		}
		has = sd.getNeiCun() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_13, 1);
			fr.cb13.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_13) ;
			fr.cb13.setChecked(false) ;
		}
		has = sd.getGuTai() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_14, 1);
			fr.cb14.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_14) ;
			fr.cb14.setChecked(false) ;
		}
		has = sd.getShuiYa() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_070_item_15, 1);
			fr.cb15.setChecked(true) ;
		}else{
			p.remove(Constant.func_vk_04_070_item_15) ;
			fr.cb15.setChecked(false) ;
		}
		
	}
}
