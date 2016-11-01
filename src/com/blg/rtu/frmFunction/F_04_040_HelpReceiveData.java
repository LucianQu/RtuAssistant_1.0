package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.cd1A_5A.Data_5A;
import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;

public class F_04_040_HelpReceiveData {
	
	private F_04_040 fr ;
	
	public F_04_040_HelpReceiveData(F_04_040 fr){
		this.fr = fr ;
	}
	/**
	 * 收到数据
	 * @param d
	 */
	public void receiveRtuData(RtuData d){
    	Preferences p = Preferences.getInstance() ;
    	int has = 0 ;
    	Double dv = null ;
    	Integer iv = null ;
    	
    	Data_5A sd = (Data_5A)d.getSubData() ;
		
		has = sd.getD0_has_ShuiWen_1or0() ;
		dv = sd.getD0_value_ShuiWen_0to99d9() ;
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_01, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_01, "" + dv) ;
				fr.cb01.setChecked(true) ;
				fr.item01.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_01);
			p.remove(Constant.func_vk_04_040_item_01);
			fr.cb01.setChecked(false) ;
			fr.item01.setText("") ;
		}
		has = sd.getD1_has_PH_1or0();
		dv = sd.getD1_value_PH_0to99d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_02, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_02, "" + dv) ;
				fr.cb02.setChecked(true) ;
				fr.item02.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_02);
			p.remove(Constant.func_vk_04_040_item_02);
			fr.cb02.setChecked(false) ;
			fr.item02.setText("") ;
		}
		has = sd.getD2_has_RongJieYang_1or0();
		dv = sd.getD2_value_RongJieYang_0to999d9();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_03, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_03, "" + dv) ;
				fr.cb03.setChecked(true) ;
				fr.item03.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_03);
			p.remove(Constant.func_vk_04_040_item_03);
			fr.cb03.setChecked(false) ;
			fr.item03.setText("") ;
		}
		has = sd.getD3_has_GaoMengSuanYan_1or0();
		dv = sd.getD3_value_GaoMengSuanYan_0to999d9();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_04, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_04, "" + dv) ;
				fr.cb04.setChecked(true) ;
				fr.item04.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_04);
			p.remove(Constant.func_vk_04_040_item_04);
			fr.cb04.setChecked(false) ;
			fr.item04.setText("") ;
		}
		has = sd.getD4_has_DianDaoLu_1or0();
		iv = sd.getD4_value_DianDaoLu_0to99999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_05, 1);
			if(iv != null){
				p.putString(Constant.func_vk_04_040_item_05, "" + iv) ;
				fr.cb05.setChecked(true) ;
				fr.item05.setText("" + iv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_05);
			p.remove(Constant.func_vk_04_040_item_05);
			fr.cb05.setChecked(false) ;
			fr.item05.setText("") ;
		}
		has = sd.getD5_has_YangHuaHuanYuanDianWei_1or0();
		sd.getD5_value_YangHuaHuanYuanDianWei_0to9999d9();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_06, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_06, "" + dv) ;
				fr.cb06.setChecked(true) ;
				fr.item06.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_06);
			p.remove(Constant.func_vk_04_040_item_06);
			fr.cb06.setChecked(false) ;
			fr.item06.setText("") ;
		}
		has = sd.getD6_has_ZhuoDu_1or0();
		iv = sd.getD6_value_ZhuoDu_0to999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_07, 1);
			if(iv != null){
				p.putString(Constant.func_vk_04_040_item_07, "" + iv) ;
				fr.cb07.setChecked(true) ;
				fr.item07.setText("" + iv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_07);
			p.remove(Constant.func_vk_04_040_item_07);
			fr.cb07.setChecked(false) ;
			fr.item07.setText("") ;
		}
		has = sd.getD7_has_HuaXueXuYangLiang_1or0();
		dv = sd.getD7_value_HuaXueXuYangLiang_0to999999d9();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_08, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_08, "" + dv) ;
				fr.cb08.setChecked(true) ;
				fr.item08.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_08);
			p.remove(Constant.func_vk_04_040_item_08);
			fr.cb08.setChecked(false) ;
			fr.item08.setText("") ;
		}
		has = sd.getD8_has_WuRiShengHuaXuYangLiang_1or0();
		dv = sd.getD8_value_WuRiShengHuaXuYangLiang_0to9999d9();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_09, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_09, "" + dv) ;
				fr.cb09.setChecked(true) ;
				fr.item09.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_09);
			p.remove(Constant.func_vk_04_040_item_09);
			fr.cb09.setChecked(false) ;
			fr.item09.setText("") ;
		}
		has = sd.getD9_has_AnDan_1or0();
		dv = sd.getD9_value_AnDan_0to9999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_10, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_10, "" + dv) ;
				fr.cb10.setChecked(true) ;
				fr.item10.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_10);
			p.remove(Constant.func_vk_04_040_item_10);
			fr.cb10.setChecked(false) ;
			fr.item10.setText("") ;
		}
		has = sd.getD10_has_ZhongDan_1or0();
		dv = sd.getD10_value_ZhongDan_0to999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_11, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_11, "" + dv) ;
				fr.cb11.setChecked(true) ;
				fr.item11.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_11);
			p.remove(Constant.func_vk_04_040_item_11);
			fr.cb11.setChecked(false) ;
			fr.item11.setText("") ;
		}
		has = sd.getD11_has_Tong_1or0();
		dv = sd.getD11_value_Tong_0to999d9999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_12, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_12, "" + dv) ;
				fr.cb12.setChecked(true) ;
				fr.item12.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_12);
			p.remove(Constant.func_vk_04_040_item_12);
			fr.cb12.setChecked(false) ;
			fr.item12.setText("") ;
		}
		has = sd.getD12_has_Xin_1or0();
		dv = sd.getD11_value_Tong_0to999d9999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_13, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_13, "" + dv) ;
				fr.cb13.setChecked(true) ;
				fr.item13.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_13);
			p.remove(Constant.func_vk_04_040_item_13);
			fr.cb13.setChecked(false) ;
			fr.item13.setText("") ;
		}
		has = sd.getD13_has_FuHuaWu_1or0();
		dv = sd.getD13_value_FuHuaWu_0to999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_14, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_14, "" + dv) ;
				fr.cb14.setChecked(true) ;
				fr.item14.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_14);
			p.remove(Constant.func_vk_04_040_item_14);
			fr.cb14.setChecked(false) ;
			fr.item14.setText("") ;
		}
		has = sd.getD14_has_Xi_1or0();
		dv = sd.getD14_value_Xi_0to99d99999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_15, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_15, "" + dv) ;
				fr.cb15.setChecked(true) ;
				fr.item15.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_15);
			p.remove(Constant.func_vk_04_040_item_15);
			fr.cb15.setChecked(false) ;
			fr.item15.setText("") ;
		}
		has = sd.getD15_has_Shen_1or0();
		dv = sd.getD15_value_Shen_0to99d99999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_16, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_16, "" + dv) ;
				fr.cb16.setChecked(true) ;
				fr.item16.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_16);
			p.remove(Constant.func_vk_04_040_item_16);
			fr.cb16.setChecked(false) ;
			fr.item16.setText("") ;
		}
		has = sd.getD16_has_Gong_1or0();
		dv = sd.getD16_value_Gong_0to99d99999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_17, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_17, "" + dv) ;
				fr.cb17.setChecked(true) ;
				fr.item17.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_17);
			p.remove(Constant.func_vk_04_040_item_17);
			fr.cb17.setChecked(false) ;
			fr.item17.setText("") ;
		}
		has = sd.getD17_has_Ge_1or0();
		dv = sd.getD17_value_Ge_0to99d99999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_18, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_18, "" + dv) ;
				fr.cb18.setChecked(true) ;
				fr.item18.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_18);
			p.remove(Constant.func_vk_04_040_item_18);
			fr.cb18.setChecked(false) ;
			fr.item18.setText("") ;
		}
		has = sd.getD18_has_LuJianGe_1or0();
		dv = sd.getD18_value_LuJianGe_0to99d999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_19, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_19, "" + dv) ;
				fr.cb19.setChecked(true) ;
				fr.item19.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_19);
			p.remove(Constant.func_vk_04_040_item_19);
			fr.cb19.setChecked(false) ;
			fr.item19.setText("") ;
		}
		has = sd.getD19_has_Qian_1or0();
		dv = sd.getD19_value_Qian_0to99d99999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_20, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_20, "" + dv) ;
				fr.cb20.setChecked(true) ;
				fr.item20.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_20);
			p.remove(Constant.func_vk_04_040_item_20);
			fr.cb20.setChecked(false) ;
			fr.item20.setText("") ;
		}
		has = sd.getD20_has_QingHuaWu_1or0();
		dv = sd.getD20_value_QingHuaWu_0to99d999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_21, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_21, "" + dv) ;
				fr.cb21.setChecked(true) ;
				fr.item21.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_21);
			p.remove(Constant.func_vk_04_040_item_21);
			fr.cb21.setChecked(false) ;
			fr.item21.setText("") ;
		}
		has = sd.getD21_has_HuiFaFen_1or0();
		dv = sd.getD21_value_HuiFaFen_0to99d999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_22, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_22, "" + dv) ;
				fr.cb22.setChecked(true) ;
				fr.item22.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_22);
			p.remove(Constant.func_vk_04_040_item_22);
			fr.cb22.setChecked(false) ;
			fr.item22.setText("") ;
		}
		has = sd.getD22_has_BenFen_1or0();
		dv = sd.getD22_value_BenFen_0to999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_23, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_23, "" + dv) ;
				fr.cb23.setChecked(true) ;
				fr.item23.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_23);
			p.remove(Constant.func_vk_04_040_item_23);
			fr.cb23.setChecked(false) ;
			fr.item23.setText("") ;
		}
		has = sd.getD23_has_LiuHuaWu_1or0();
		dv = sd.getD23_value_LiuHuaWu_0to99d999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_24, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_24, "" + dv) ;
				fr.cb24.setChecked(true) ;
				fr.item24.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_24);
			p.remove(Constant.func_vk_04_040_item_24);
			fr.cb24.setChecked(false) ;
			fr.item24.setText("") ;
		}
		has = sd.getD24_has_FenDaChangJunQun_1or0();
		iv = sd.getD24_value_FenDaChangJunQun_0to9999999999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_25, 1);
			if(iv != null){
				p.putString(Constant.func_vk_04_040_item_25, "" + iv) ;
				fr.cb25.setChecked(true) ;
				fr.item25.setText("" + iv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_25);
			p.remove(Constant.func_vk_04_040_item_25);
			fr.cb25.setChecked(false) ;
			fr.item25.setText("") ;
		}
		has = sd.getD25_has_LiuSuanYan_1or0();
		dv = sd.getD25_value_LiuSuanYan_0to9999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_26, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_26, "" + dv) ;
				fr.cb26.setChecked(true) ;
				fr.item26.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_26);
			p.remove(Constant.func_vk_04_040_item_26);
			fr.cb26.setChecked(false) ;
			fr.item26.setText("") ;
		}
		has = sd.getD26_has_LuHuaWu_1or0();
		dv = sd.getD26_value_LuHuaWu_0to999999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_27, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_27, "" + dv) ;
				fr.cb27.setChecked(true) ;
				fr.item27.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_27);
			p.remove(Constant.func_vk_04_040_item_27);
			fr.cb27.setChecked(false) ;
			fr.item27.setText("") ;
		}
		has = sd.getD27_has_XiaoSuanYanDan_1or0();
		dv = sd.getD27_value_XiaoSuanYanDan_0to999d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_28, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_28, "" + dv) ;
				fr.cb28.setChecked(true) ;
				fr.item28.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_28);
			p.remove(Constant.func_vk_04_040_item_28);
			fr.cb28.setChecked(false) ;
			fr.item28.setText("") ;
		}
		has = sd.getD28_has_Die_1or0();
		dv = sd.getD28_value_Die_0to99d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_29, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_29, "" + dv) ;
				fr.cb29.setChecked(true) ;
				fr.item29.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_29);
			p.remove(Constant.func_vk_04_040_item_29);
			fr.cb29.setChecked(false) ;
			fr.item29.setText("") ;
		}
		has = sd.getD29_has_Meng_1or0();
		dv = sd.getD29_value_Meng_0to99d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_30, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_30, "" + dv) ;
				fr.cb30.setChecked(true) ;
				fr.item30.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_30);
			p.remove(Constant.func_vk_04_040_item_30);
			fr.cb30.setChecked(false) ;
			fr.item30.setText("") ;
		}
		has = sd.getD30_has_ShiYouLei_1or0();
		dv = sd.getD30_value_ShiYouLei_0to99d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_31, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_31, "" + dv) ;
				fr.cb31.setChecked(true) ;
				fr.item31.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_31);
			p.remove(Constant.func_vk_04_040_item_31);
			fr.cb31.setChecked(false) ;
			fr.item31.setText("") ;
		}
		has = sd.getD31_has_YinLiZhiBiaoMianHuoXingJi_1or0();
		dv = sd.getD31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_32, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_32, "" + dv) ;
				fr.cb32.setChecked(true) ;
				fr.item32.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_32);
			p.remove(Constant.func_vk_04_040_item_32);
			fr.cb32.setChecked(false) ;
			fr.item32.setText("") ;
		}
		has = sd.getD32_has_LiuLiuLiu_1or0();
		dv = sd.getD32_value_LiuLiuLiu_0to9d999999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_33, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_33, "" + dv) ;
				fr.cb33.setChecked(true) ;
				fr.item33.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_33);
			p.remove(Constant.func_vk_04_040_item_33);
			fr.cb33.setChecked(false) ;
			fr.item33.setText("") ;
		}
		has = sd.getD33_has_DiDiTi_1or0();
		dv = sd.getD33_value_DiDiTi_0to9d999999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_34, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_34, "" + dv) ;
				fr.cb34.setChecked(true) ;
				fr.item34.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_34);
			p.remove(Constant.func_vk_04_040_item_34);
			fr.cb34.setChecked(false) ;
			fr.item34.setText("") ;
		}
		has = sd.getD34_has_YouJiLuNongYao_1or0();
		dv = sd.getD34_value_YouJiLuNongYao_0to9d999999();
		if(has == 1){
			p.putInt(Constant.func_vk_04_040_cb_35, 1);
			if(dv != null){
				p.putString(Constant.func_vk_04_040_item_35, "" + dv) ;
				fr.cb35.setChecked(true) ;
				fr.item35.setText("" + dv) ;
			}
		}else{
			p.remove(Constant.func_vk_04_040_cb_35);
			p.remove(Constant.func_vk_04_040_item_35);
			fr.cb35.setChecked(false) ;
			fr.item35.setText("") ;
		}
	}
}
