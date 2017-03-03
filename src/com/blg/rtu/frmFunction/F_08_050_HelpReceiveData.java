package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.cdEC_FC.Data_EC_FC;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_08_050_HelpReceiveData {
	
	private F_08_050 fr ;
	
	public F_08_050_HelpReceiveData(F_08_050 fr){
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
			p.putInt(Constant.func_vk_08_050_01_01, 1);
			fr.cb01_01_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_01, 0);
			fr.cb01_01_n.setChecked(true) ;
		}
		
		v = sd.getA02() ;
		if(v == 1){
			p.putInt(Constant.func_vk_08_050_01_02, 1);
			fr.cb01_02_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_02, 0);
			fr.cb01_02_n.setChecked(true) ;
		}
		
		v = sd.getA03() ;
		if(v == 1){
			p.putInt(Constant.func_vk_08_050_01_03, 1);
			fr.cb01_03_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_03, 0);
			fr.cb01_03_n.setChecked(true) ;
		}
		
		v = sd.getA04() ;
		if(v == 1){
			p.putInt(Constant.func_vk_08_050_01_04, 1);
			fr.cb01_04_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_04, 0);
			fr.cb01_04_n.setChecked(true) ;
		}
		
		v = sd.getA05() ;
		if(v == 1){
			p.putInt(Constant.func_vk_08_050_01_05, 1);
			fr.cb01_05_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_05, 0);
			fr.cb01_05_n.setChecked(true) ;
		}
		v = sd.getA04() ;
		if(v == 1){
			p.putInt(Constant.func_vk_08_050_01_06, 1);
			fr.cb01_06_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_06, 0);
			fr.cb01_06_n.setChecked(true) ;
		}
		
		v = sd.getA05() ;
		if(v == 1){
			p.putInt(Constant.func_vk_08_050_01_07, 1);
			fr.cb01_07_y.setChecked(true) ;
		}else{
			p.putInt(Constant.func_vk_08_050_01_07, 0);
			fr.cb01_07_n.setChecked(true) ;
		}
		
	}
}
