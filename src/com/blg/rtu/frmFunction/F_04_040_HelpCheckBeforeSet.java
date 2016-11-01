package com.blg.rtu.frmFunction;

import android.widget.CheckBox;
import android.widget.EditText;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import com.blg.rtu.protocol.p206.cd1A_5A.Param_1A;
import com.blg.rtu.util.DialogAlarm;

public class F_04_040_HelpCheckBeforeSet {
	
	private MainActivity act ;
	private F_04_040 fr ;
	
	public F_04_040_HelpCheckBeforeSet(MainActivity act, F_04_040 fr){
		this.fr = fr ;
		this.act = (MainActivity)act ;
	}
	
	
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	protected boolean checkBeforeSet(boolean showDialog){
		if(!this.hasCheck()){
			if(showDialog)new DialogAlarm().showDialog(act, "未选择任何一个参数！") ; 
			return false ;
		}else{
			fr.param = new Param_1A() ;
			boolean flag = true ;
			flag = this.doCheck(fr.cb01, fr.item01, 1, R.string.func_item_q_01, showDialog) ;
			if(flag){flag = this.doCheck(fr.cb02, fr.item02, 2, R.string.func_item_q_02, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb03, fr.item03, 3, R.string.func_item_q_03, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb04, fr.item04, 4, R.string.func_item_q_04, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb05, fr.item05, 5, R.string.func_item_q_05, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb06, fr.item06, 6, R.string.func_item_q_06, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb07, fr.item07, 7, R.string.func_item_q_07, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb08, fr.item08, 8, R.string.func_item_q_08, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb09, fr.item09, 9, R.string.func_item_q_09, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb10, fr.item10, 10, R.string.func_item_q_10, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb11, fr.item11, 11, R.string.func_item_q_11, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb12, fr.item12, 12, R.string.func_item_q_12, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb13, fr.item13, 13, R.string.func_item_q_13, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb14, fr.item14, 14, R.string.func_item_q_14, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb15, fr.item15, 15, R.string.func_item_q_15, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb16, fr.item16, 16, R.string.func_item_q_16, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb17, fr.item17, 17, R.string.func_item_q_17, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb18, fr.item18, 18, R.string.func_item_q_18, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb19, fr.item19, 19, R.string.func_item_q_19, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb20, fr.item20, 20, R.string.func_item_q_20, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb21, fr.item21, 21, R.string.func_item_q_21, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb22, fr.item22, 22, R.string.func_item_q_22, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb23, fr.item23, 23, R.string.func_item_q_23, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb24, fr.item24, 24, R.string.func_item_q_24, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb25, fr.item25, 25, R.string.func_item_q_25, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb26, fr.item26, 26, R.string.func_item_q_26, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb27, fr.item27, 27, R.string.func_item_q_27, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb28, fr.item28, 28, R.string.func_item_q_28, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb29, fr.item29, 29, R.string.func_item_q_29, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb30, fr.item30, 30, R.string.func_item_q_30, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb31, fr.item31, 31, R.string.func_item_q_31, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb32, fr.item32, 32, R.string.func_item_q_32, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb33, fr.item33, 33, R.string.func_item_q_33, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb34, fr.item34, 34, R.string.func_item_q_34, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb35, fr.item35, 35, R.string.func_item_q_35, showDialog) ;}
			return flag ;
		}
	}
	
	private boolean hasCheck(){
		if(fr.cb01.isChecked()){return true;}
		if(fr.cb02.isChecked()){return true;}
		if(fr.cb03.isChecked()){return true;}
		if(fr.cb04.isChecked()){return true;}
		if(fr.cb05.isChecked()){return true;}
		if(fr.cb06.isChecked()){return true;}
		if(fr.cb07.isChecked()){return true;}
		if(fr.cb08.isChecked()){return true;}
		if(fr.cb09.isChecked()){return true;}
		if(fr.cb10.isChecked()){return true;}
		if(fr.cb11.isChecked()){return true;}
		if(fr.cb12.isChecked()){return true;}
		if(fr.cb13.isChecked()){return true;}
		if(fr.cb14.isChecked()){return true;}
		if(fr.cb15.isChecked()){return true;}
		if(fr.cb16.isChecked()){return true;}
		if(fr.cb17.isChecked()){return true;}
		if(fr.cb18.isChecked()){return true;}
		if(fr.cb19.isChecked()){return true;}
		if(fr.cb20.isChecked()){return true;}
		if(fr.cb21.isChecked()){return true;}
		if(fr.cb22.isChecked()){return true;}
		if(fr.cb23.isChecked()){return true;}
		if(fr.cb24.isChecked()){return true;}
		if(fr.cb25.isChecked()){return true;}
		if(fr.cb26.isChecked()){return true;}
		if(fr.cb27.isChecked()){return true;}
		if(fr.cb28.isChecked()){return true;}
		if(fr.cb29.isChecked()){return true;}
		if(fr.cb30.isChecked()){return true;}
		if(fr.cb31.isChecked()){return true;}
		if(fr.cb32.isChecked()){return true;}
		if(fr.cb33.isChecked()){return true;}
		if(fr.cb34.isChecked()){return true;}
		if(fr.cb35.isChecked()){return true;}
		return false ;
	}
	
	private boolean doCheck(CheckBox cb, EditText dt, int index, int stringId, boolean showDialog){
		boolean flag = true ;
		if(cb.isChecked()){
			String tx = dt.getText().toString() ;
			if(tx == null || tx.equals("")){
				flag = false ;
				if(showDialog)new DialogAlarm().showDialog(act, "选择了" + fr.rs.getString(stringId) + "，但未填写数值！") ; 
			}else{
				Double d = Double.valueOf(tx) ;
				switch(index){
				case 1 : {if(d < 0 || d > 99.9){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99)！") ;flag = false ;}else{fr.param.setD0_has_ShuiWen_1or0(1);fr.param.setD0_value_ShuiWen_0to99d9(d);}break;}
				case 2 : {if(d < 0 || d > 14){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~14)！") ;flag = false ;}else{fr.param.setD1_has_PH_1or0(1);fr.param.setD1_value_PH_0to99d99(d);}break;}
				case 3 : {if(d < 0 || d > 999.9){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.9)！") ;flag = false ;}else{fr.param.setD2_has_RongJieYang_1or0(1);fr.param.setD2_value_RongJieYang_0to999d9(d);}break;}
				case 4 : {if(d < 0 || d > 999.9){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.9)！") ;flag = false ;}else{fr.param.setD3_has_GaoMengSuanYan_1or0(1);fr.param.setD3_value_GaoMengSuanYan_0to999d9(d);}break;}
				case 5 : {if(d < 0 || d > 99999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99999)！") ;flag = false ;}else{fr.param.setD4_has_DianDaoLu_1or0(1);fr.param.setD4_value_DianDaoLu_0to99999(d.intValue());}break;}
				case 6 : {if(d < 0 || d > 9999.9){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999.9)！") ;flag = false ;}else{fr.param.setD5_has_YangHuaHuanYuanDianWei_1or0(1);fr.param.setD5_value_YangHuaHuanYuanDianWei_0to9999d9(d);}break;}
				case 7 : {if(d < 0 || d > 999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999)！") ;flag = false ;}else{fr.param.setD6_has_ZhuoDu_1or0(1);fr.param.setD6_value_ZhuoDu_0to999(d.intValue());}break;}
				case 8 : {if(d < 0 || d > 999999.9){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999999.9)！") ;flag = false ;}else{fr.param.setD7_has_HuaXueXuYangLiang_1or0(1);fr.param.setD7_value_HuaXueXuYangLiang_0to999999d9(d);}break;}
				case 9 : {if(d < 0 || d > 9999.9){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999.9)！") ;flag = false ;}else{fr.param.setD8_has_WuRiShengHuaXuYangLiang_1or0(1);fr.param.setD8_value_WuRiShengHuaXuYangLiang_0to9999d9(d);}break;}
				case 10 : {if(d < 0 || d > 9999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999.99)！") ;flag = false ;}else{fr.param.setD9_has_AnDan_1or0(1);fr.param.setD9_value_AnDan_0to9999d99(d);}break;}
				case 11 : {if(d < 0 || d > 999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.99)！") ;flag = false ;}else{fr.param.setD10_has_ZhongDan_1or0(1);fr.param.setD10_value_ZhongDan_0to999d99(d);}break;}
				case 12 : {if(d < 0 || d > 999.9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.9999)！") ;flag = false ;}else{fr.param.setD11_has_Tong_1or0(1);fr.param.setD11_value_Tong_0to999d9999(d);}break;}
				case 13 : {if(d < 0 || d > 99.9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.9999)！") ;flag = false ;}else{fr.param.setD12_has_Xin_1or0(1);fr.param.setD12_value_Xin_0to99d9999(d);}break;}
				case 14 : {if(d < 0 || d > 999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.99)！") ;flag = false ;}else{fr.param.setD13_has_FuHuaWu_1or0(1);fr.param.setD13_value_FuHuaWu_0to999d99(d);}break;}
				case 15 : {if(d < 0 || d > 99.99999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99999)！") ;flag = false ;}else{fr.param.setD14_has_Xi_1or0(1);fr.param.setD14_value_Xi_0to99d99999(d);}break;}
				case 16 : {if(d < 0 || d > 99.99999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99999)！") ;flag = false ;}else{fr.param.setD15_has_Shen_1or0(1);fr.param.setD15_value_Shen_0to99d99999(d);}break;}
				case 17 : {if(d < 0 || d > 99.99999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99999)！") ;flag = false ;}else{fr.param.setD16_has_Gong_1or0(1);fr.param.setD16_value_Gong_0to99d99999(d);}break;}
				case 18 : {if(d < 0 || d > 99.99999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99999)！") ;flag = false ;}else{fr.param.setD17_has_Ge_1or0(1);fr.param.setD17_value_Ge_0to99d99999(d);}break;}
				case 19 : {if(d < 0 || d > 99.999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.999)！") ;flag = false ;}else{fr.param.setD18_has_LuJianGe_1or0(1);fr.param.setD18_value_LuJianGe_0to99d999(d);}break;}
				case 20 : {if(d < 0 || d > 99.99999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99999)！") ;flag = false ;}else{fr.param.setD19_has_Qian_1or0(1);fr.param.setD19_value_Qian_0to99d99999(d);}break;}
				case 21 : {if(d < 0 || d > 99.999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.999)！") ;flag = false ;}else{fr.param.setD20_has_QingHuaWu_1or0(1);fr.param.setD20_value_QingHuaWu_0to99d999(d);}break;}
				case 22 : {if(d < 0 || d > 99.999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.999)！") ;flag = false ;}else{fr.param.setD21_has_HuiFaFen_1or0(1);fr.param.setD21_value_HuiFaFen_0to99d999(d);}break;}
				case 23 : {if(d < 0 || d > 999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.99)！") ;flag = false ;}else{fr.param.setD22_has_BenFen_1or0(1);fr.param.setD22_value_BenFen_0to999d99(d);}break;}
				case 24 : {if(d < 0 || d > 99.999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.999)！") ;flag = false ;}else{fr.param.setD23_has_LiuHuaWu_1or0(1);fr.param.setD23_value_LiuHuaWu_0to99d999(d);}break;}
				case 25 : {if(d < 0 || d > 9999999999D){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999999999)！") ;flag = false ;}else{fr.param.setD24_has_FenDaChangJunQun_1or0(1);fr.param.setD24_value_FenDaChangJunQun_0to9999999999(d.intValue());}break;}
				case 26 : {if(d < 0 || d > 9999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999.99)！") ;flag = false ;}else{fr.param.setD25_has_LiuSuanYan_1or0(1);fr.param.setD25_value_LiuSuanYan_0to9999d99(d);}break;}
				case 27 : {if(d < 0 || d > 999999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999999.99)！") ;flag = false ;}else{fr.param.setD26_has_LuHuaWu_1or0(1);fr.param.setD26_value_LuHuaWu_0to999999d99(d);}break;}
				case 28 : {if(d < 0 || d > 999.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~999.99)！") ;flag = false ;}else{fr.param.setD27_has_XiaoSuanYanDan_1or0(1);fr.param.setD27_value_XiaoSuanYanDan_0to999d99(d);}break;}
				case 29 : {if(d < 0 || d > 99.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99)！") ;flag = false ;}else{fr.param.setD28_has_Die_1or0(1);fr.param.setD28_value_Die_0to99d99(d);}break;}
				case 30 : {if(d < 0 || d > 99.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99)！") ;flag = false ;}else{fr.param.setD29_has_Meng_1or0(1);fr.param.setD29_value_Meng_0to99d99(d);}break;}
				case 31 : {if(d < 0 || d > 99.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99)！") ;flag = false ;}else{fr.param.setD30_has_ShiYouLei_1or0(1);fr.param.setD30_value_ShiYouLei_0to99d99(d);}break;}
				case 32 : {if(d < 0 || d > 99.99){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~99.99)！") ;flag = false ;}else{fr.param.setD31_has_YinLiZhiBiaoMianHuoXingJi_1or0(1);fr.param.setD31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99(d);}break;}
				case 33 : {if(d < 0 || d > 9.999999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9.999999)！") ;flag = false ;}else{fr.param.setD32_has_LiuLiuLiu_1or0(1);fr.param.setD32_value_LiuLiuLiu_0to9d999999(d);}break;}
				case 34 : {if(d < 0 || d > 9.999999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9.999999)！") ;flag = false ;}else{fr.param.setD33_has_DiDiTi_1or0(1);fr.param.setD33_value_DiDiTi_0to9d999999(d);}break;}
				case 35 : {if(d < 0 || d > 9.999999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9.999999)！") ;flag = false ;}else{fr.param.setD34_has_YouJiLuNongYao_1or0(1);fr.param.setD34_value_YouJiLuNongYao_0to9d999999(d);}break;}
				}
			}
		}
		return flag ;
	}
		
	
}
