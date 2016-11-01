package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.cdA1_53.Data_A1_53;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_080_HelpReceiveData {
	
	private F_04_080 fr ;
	
	public F_04_080_HelpReceiveData(F_04_080 fr){
		this.fr = fr ;
	}
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
    	Preferences p = Preferences.getInstance() ;
    	int has = 0 ;
    	Short dv = null ;
    	
    	Data_A1_53 sd = (Data_A1_53)d.getSubData() ;
		
		has = sd.getYuLiang() ;
		dv = sd.getYuLiangReportInterval() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_01, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_01, "" + dv) ;
				fr.cb01.setChecked(true) ;
				fr.item01.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_01);
			p.remove(Constant.func_vk_04_080_item_01);
			fr.cb01.setChecked(false) ;
			fr.item01.setText("") ;
		}
		has = sd.getShuiWei();
		dv = sd.getShuiWeiReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_02, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_02, "" + dv) ;
				fr.cb02.setChecked(true) ;
				fr.item02.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_02);
			p.remove(Constant.func_vk_04_080_item_02);
			fr.cb02.setChecked(false) ;
			fr.item02.setText("") ;
		}
		has = sd.getLiuLiang();
		dv = sd.getLiuLiangReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_03, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_03, "" + dv) ;
				fr.cb03.setChecked(true) ;
				fr.item03.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_03);
			p.remove(Constant.func_vk_04_080_item_03);
			fr.cb03.setChecked(false) ;
			fr.item03.setText("") ;
		}
		has = sd.getLiuSu();
		dv = sd.getLiuSuReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_04, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_04, "" + dv) ;
				fr.cb04.setChecked(true) ;
				fr.item04.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_04);
			p.remove(Constant.func_vk_04_080_item_04);
			fr.cb04.setChecked(false) ;
			fr.item04.setText("") ;
		}
		has = sd.getZhaWei();
		dv = sd.getZhaWeiReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_05, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_05, "" + dv) ;
				fr.cb05.setChecked(true) ;
				fr.item05.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_05);
			p.remove(Constant.func_vk_04_080_item_05);
			fr.cb05.setChecked(false) ;
			fr.item05.setText("") ;
		}
		has = sd.getGongLu();
		sd.getGongLuReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_06, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_06, "" + dv) ;
				fr.cb06.setChecked(true) ;
				fr.item06.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_06);
			p.remove(Constant.func_vk_04_080_item_06);
			fr.cb06.setChecked(false) ;
			fr.item06.setText("") ;
		}
		has = sd.getQiYa();
		dv = sd.getQiYaReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_07, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_07, "" + dv) ;
				fr.cb07.setChecked(true) ;
				fr.item07.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_07);
			p.remove(Constant.func_vk_04_080_item_07);
			fr.cb07.setChecked(false) ;
			fr.item07.setText("") ;
		}
		has = sd.getFengSu();
		dv = sd.getFengSuReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_08, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_08, "" + dv) ;
				fr.cb08.setChecked(true) ;
				fr.item08.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_08);
			p.remove(Constant.func_vk_04_080_item_08);
			fr.cb08.setChecked(false) ;
			fr.item08.setText("") ;
		}
		has = sd.getShuiWen();
		dv = sd.getShuiWenReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_09, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_09, "" + dv) ;
				fr.cb09.setChecked(true) ;
				fr.item09.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_09);
			p.remove(Constant.func_vk_04_080_item_09);
			fr.cb09.setChecked(false) ;
			fr.item09.setText("") ;
		}
		has = sd.getShuiZhi();
		dv = sd.getShuiZhiReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_10, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_10, "" + dv) ;
				fr.cb10.setChecked(true) ;
				fr.item10.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_10);
			p.remove(Constant.func_vk_04_080_item_10);
			fr.cb10.setChecked(false) ;
			fr.item10.setText("") ;
		}
		has = sd.getTuRang();
		dv = sd.getTuRangReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_11, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_11, "" + dv) ;
				fr.cb11.setChecked(true) ;
				fr.item11.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_11);
			p.remove(Constant.func_vk_04_080_item_11);
			fr.cb11.setChecked(false) ;
			fr.item11.setText("") ;
		}
		has = sd.getZhengFa();
		dv = sd.getZhengFaReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_12, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_12, "" + dv) ;
				fr.cb12.setChecked(true) ;
				fr.item12.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_12);
			p.remove(Constant.func_vk_04_080_item_12);
			fr.cb12.setChecked(false) ;
			fr.item12.setText("") ;
		}
		has = sd.getBaoJing();
		dv = sd.getBaoJingReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_13, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_13, "" + dv) ;
				fr.cb13.setChecked(true) ;
				fr.item13.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_13);
			p.remove(Constant.func_vk_04_080_item_13);
			fr.cb13.setChecked(false) ;
			fr.item13.setText("") ;
		}
		has = sd.getShuiYa();
		dv = sd.getShuiYaReportInterval();
		if(has == 1){
			p.putInt(Constant.func_vk_04_080_cb_14, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_080_item_14, "" + dv) ;
				fr.cb14.setChecked(true) ;
				fr.item14.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_080_cb_14);
			p.remove(Constant.func_vk_04_080_item_14);
			fr.cb14.setChecked(false) ;
			fr.item14.setText("") ;
		}
		
	}
}
