package com.blg.rtu.frmFunction;

import android.widget.CheckBox;
import android.widget.EditText;

import com.blg.rtu.protocol.p206.cdA1_53.Param_A1;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class F_04_080_HelpCheckBeforeSet {
	
	private MainActivity act ;
	private F_04_080 fr ;
	
	public F_04_080_HelpCheckBeforeSet(MainActivity act, F_04_080 fr){
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
			fr.param = new Param_A1() ;
			boolean flag = true ;
		/*	flag = this.doCheck(fr.cb01, fr.item01, 1, R.string.func_04_080_item01, showDialog) ;*/
			/*if(flag){flag = this.doCheck(fr.cb02, fr.item02, 2, R.string.func_04_080_item02, showDialog) ;}*/
			if(flag){flag = this.doCheck(fr.cb03, fr.item03, 3, R.string.func_04_080_item03, showDialog) ;}
			/*if(flag){flag = this.doCheck(fr.cb04, fr.item04, 4, R.string.func_04_080_item04, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb05, fr.item05, 5, R.string.func_04_080_item05, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb06, fr.item06, 6, R.string.func_04_080_item06, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb07, fr.item07, 7, R.string.func_04_080_item07, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb08, fr.item08, 8, R.string.func_04_080_item08, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb09, fr.item09, 9, R.string.func_04_080_item09, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb10, fr.item10, 10, R.string.func_04_080_item10, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb11, fr.item11, 11, R.string.func_04_080_item11, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb12, fr.item12, 12, R.string.func_04_080_item12, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb13, fr.item13, 13, R.string.func_04_080_item13, showDialog) ;}
			if(flag){flag = this.doCheck(fr.cb14, fr.item14, 14, R.string.func_04_080_item14, showDialog) ;}*/
			return flag ;
		}
	}
	
	private boolean hasCheck(){
		/*if(fr.cb01.isChecked()){return true;}
		if(fr.cb02.isChecked()){return true;}*/
		if(fr.cb03.isChecked()){return true;}
		/*if(fr.cb04.isChecked()){return true;}
		if(fr.cb05.isChecked()){return true;}
		if(fr.cb06.isChecked()){return true;}
		if(fr.cb07.isChecked()){return true;}
		if(fr.cb08.isChecked()){return true;}
		if(fr.cb09.isChecked()){return true;}
		if(fr.cb10.isChecked()){return true;}
		if(fr.cb11.isChecked()){return true;}
		if(fr.cb12.isChecked()){return true;}
		if(fr.cb13.isChecked()){return true;}
		if(fr.cb14.isChecked()){return true;}*/
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
				Short d = Short.valueOf(tx) ;
				switch(index){
				case 1 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setYuLiang_0or1(1);fr.param.setYuLiangReportInterval_1to9999(d);}break;}
				case 2 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setShuiWei_0or1(1);fr.param.setShuiWeiReportInterval_1to9999(d);}break;}
				case 3 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setLiuLiang_0or1(1);fr.param.setLiuLiangReportInterval_1to9999(d);}break;}
				case 4 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setLiuSu_0or1(1);fr.param.setLiuSuReportInterval_1to9999(d);}break;}
				case 5 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setZhaWei_0or1(1);fr.param.setZhaWeiReportInterval_1to9999(d);}break;}
				case 6 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setGongLu_0or1(1);fr.param.setGongLuReportInterval_1to9999(d);}break;}
				case 7 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setQiYa_0or1(1);fr.param.setQiYaReportInterval_1to9999(d);}break;}
				case 8 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setFengSu_0or1(1);fr.param.setFengSuReportInterval_1to9999(d);}break;}
				case 9 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setShuiWen_0or1(1);fr.param.setShuiWenReportInterval_1to9999(d);}break;}
				case 10 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setShuiZhi_0or1(1);fr.param.setShuiZhiReportInterval_1to9999(d);}break;}
				case 11 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setTuRang_0or1(1);fr.param.setTuRangReportInterval_1to9999(d);}break;}
				case 12 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setZhengFa_0or1(1);fr.param.setZhengFaReportInterval_1to9999(d);}break;}
				case 13 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setBaoJing_0or1(1);fr.param.setBaoJingReportInterval_1to9999(d);}break;}
				case 14 : {if(d < 0 || d > 9999){if(showDialog)new DialogAlarm().showDialog(act, fr.rs.getString(stringId) + "数值超出合法范围(0~9999)！") ;flag = false ;}else{fr.param.setShuiYa_0or1(1);fr.param.setShuiYaReportInterval_1to9999(d);}break;}
				}
			}
		}
		return flag ;
	}
		
	
}
