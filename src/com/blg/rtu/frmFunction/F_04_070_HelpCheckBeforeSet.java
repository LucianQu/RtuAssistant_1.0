package com.blg.rtu.frmFunction;


import com.blg.rtu.protocol.p206.cdA0_54.Param_A0;

public class F_04_070_HelpCheckBeforeSet {
	
	private F_04_070 fr ;
	
	public F_04_070_HelpCheckBeforeSet(F_04_070 fr){
		this.fr = fr ;
	}
	
	/**
	 * 设置命令前进行检查
	 * @return
	 */
	protected boolean checkBeforeSet(boolean showDialog){
//		if(!this.hasCheck()){
//			if(showDialog)new DialogAlarm().showDialog(act, "未选择任何一个参数！") ; 
//			return false ;
//		}else{
			fr.param = new Param_A0() ;
			int flag =  0 ;
			if(fr.cb01.isChecked()){flag = 1 ; } fr.param.setYuLiang_0or1(flag) ; flag = 0 ;
			if(fr.cb02.isChecked()){flag = 1 ; } fr.param.setShuiWei_0or1(flag) ; flag = 0 ;
			if(fr.cb03.isChecked()){flag = 1 ; } fr.param.setLiuLiang_0or1(flag) ; flag = 0 ;
			if(fr.cb04.isChecked()){flag = 1 ; } fr.param.setLiuSu_0or1(flag) ; flag = 0 ;
			if(fr.cb05.isChecked()){flag = 1 ; } fr.param.setZhaWei_0or1(flag) ; flag = 0 ;
			if(fr.cb06.isChecked()){flag = 1 ; } fr.param.setGongLu_0or1(flag) ; flag = 0 ;
			if(fr.cb07.isChecked()){flag = 1 ; } fr.param.setQiYa_0or1(flag) ; flag = 0 ;
			if(fr.cb08.isChecked()){flag = 1 ; } fr.param.setFengSu_0or1(flag) ; flag = 0 ;
			if(fr.cb09.isChecked()){flag = 1 ; } fr.param.setShuiWen_0or1(flag) ; flag = 0 ;
			if(fr.cb10.isChecked()){flag = 1 ; } fr.param.setShuiZhi_0or1(flag) ; flag = 0 ;
			if(fr.cb11.isChecked()){flag = 1 ; } fr.param.setTuRang_0or1(flag) ; flag = 0 ;
			if(fr.cb12.isChecked()){flag = 1 ; } fr.param.setZhengFa_0or1(flag) ; flag = 0 ;
			if(fr.cb13.isChecked()){flag = 1 ; } fr.param.setNeiCun_0or1(flag) ; flag = 0 ;
			if(fr.cb14.isChecked()){flag = 1 ; } fr.param.setGuTai_0or1(flag) ; flag = 0 ;
			if(fr.cb15.isChecked()){flag = 1 ; } fr.param.setShuiYa_0or1(flag) ; flag = 0 ;
			
			return true ;
//		}
	}
	
	protected boolean hasCheck(){
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
		return false ;
	}
	
	
}
