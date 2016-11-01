package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.cdEC_FC.Data_EC_FC;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_05_030_HelpReceiveData {
	
	private F_05_030 fr ;
	
	public F_05_030_HelpReceiveData(F_05_030 fr){
		this.fr = fr ;
	}
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
    	Preferences p = Preferences.getInstance() ;
    	int v = 0 ;
    	
    	Data_EC_FC sd = (Data_EC_FC)d.getSubData() ;
		
		v = sd.getA01() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_01_01, 1);
			fr.cb01_01_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_01_01, 0);
			fr.cb01_01_n.setChecked(true) ;
		}
		
		v = sd.getA02() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_01_02, 1);
			fr.cb01_02_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_01_02, 0);
			fr.cb01_02_n.setChecked(true) ;
		}
		
		v = sd.getA03() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_01_03, 1);
			fr.cb01_03_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_01_03, 0);
			fr.cb01_03_n.setChecked(true) ;
		}
		
		v = sd.getA04() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_01_04, 1);
			fr.cb01_04_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_01_04, 0);
			fr.cb01_04_n.setChecked(true) ;
		}
		
		v = sd.getA05() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_01_05, 1);
			fr.cb01_05_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_01_05, 0);
			fr.cb01_05_n.setChecked(true) ;
		}
		
		
		
		
		v = sd.getB01() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_01, 1);
			fr.cb02_01_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_01, 0);
			fr.cb02_01_n.setChecked(true) ;
		}
		
		v = sd.getB02() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_02, 1);
			fr.cb02_02_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_02, 0);
			fr.cb02_02_n.setChecked(true) ;
		}
		
		v = sd.getB03() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_03, 1);
			fr.cb02_03_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_03, 0);
			fr.cb02_03_n.setChecked(true) ;
		}
		
		v = sd.getB04() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_04, 1);
			fr.cb02_04_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_04, 0);
			fr.cb02_04_n.setChecked(true) ;
		}
		
		v = sd.getB05() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_05, 1);
			fr.cb02_05_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_05, 0);
			fr.cb02_05_n.setChecked(true) ;
		}		
		
		v = sd.getB06() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_06, 1);
			fr.cb02_06_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_06, 0);
			fr.cb02_06_n.setChecked(true) ;
		}		
		
		v = sd.getB07() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_07, 1);
			fr.cb02_07_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_07, 0);
			fr.cb02_07_n.setChecked(true) ;
		}		
		
		v = sd.getB08() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_08, 1);
			fr.cb02_08_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_08, 0);
			fr.cb02_08_n.setChecked(true) ;
		}		
		
		v = sd.getB09() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_09, 1);
			fr.cb02_09_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_09, 0);
			fr.cb02_09_n.setChecked(true) ;
		}		
		
		v = sd.getB10() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_02_10, 1);
			fr.cb02_10_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_02_10, 0);
			fr.cb02_10_n.setChecked(true) ;
		}		
		
		
		
		
		
		v = sd.getC01() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_03_01, 1);
			fr.cb03_01_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_03_01, 0);
			fr.cb03_01_n.setChecked(true) ;
		}
		
		v = sd.getC02() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_03_02, 1);
			fr.cb03_02_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_03_02, 0);
			fr.cb03_02_n.setChecked(true) ;
		}
		
		v = sd.getC03() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_03_03, 1);
			fr.cb03_03_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_03_03, 0);
			fr.cb03_03_n.setChecked(true) ;
		}
		
		v = sd.getC04() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_03_04, 1);
			fr.cb03_04_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_03_04, 0);
			fr.cb03_04_n.setChecked(true) ;
		}
		
		v = sd.getC05() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_03_05, 1);
			fr.cb03_05_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_03_05, 0);
			fr.cb03_05_n.setChecked(true) ;
		}		
		
		v = sd.getC06() ;
		if(v == 1){
			p.putInt(Constant.func_vk_05_030_03_06, 1);
			fr.cb03_06_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_05_030_03_06, 0);
			fr.cb03_06_n.setChecked(true) ;
		}			
	}
}
