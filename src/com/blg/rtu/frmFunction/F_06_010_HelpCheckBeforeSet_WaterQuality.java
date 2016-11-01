package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterQuality;
import com.blg.rtu.util.DialogAlarm;

public class F_06_010_HelpCheckBeforeSet_WaterQuality {
	
	private F_06_010 fr ;
	
	public F_06_010_HelpCheckBeforeSet_WaterQuality(F_06_010 fr){
		this.fr = fr ;
	}

	protected boolean checkBeforeSet(boolean showDialog){
		boolean returnFalg = false ;
		//水温数据
		fr.waterQualityParam = new Param_82_WaterQuality() ;
		
		boolean has = false ;
		boolean error = false ;
		Double dv = null ;
		Integer iv = null ;
		
		String value = fr.item04_01.getText().toString() ;
		if(!value.equals("")){
			dv = Double.valueOf(value) ;
			if(dv > 99.9 || dv < 0){
				if(showDialog)new DialogAlarm().showDialog(fr.act, "水温数值超过合法取值范围(0～99.9)！") ;
				returnFalg = false ;
				error = true ;
			}else{
				fr.waterQualityParam.setValue_ShuiWen_0to99d9(dv) ;
				has = true ;
				returnFalg = true ;
			}
		}
		
		if(!error){
			value = fr.item04_02.getText().toString() ;
			if(!value.equals("")){
				dv = Double.valueOf(value) ;
				if(dv > 14 || dv < 0){
					if(showDialog)new DialogAlarm().showDialog(fr.act, "PH值超过合法取值范围(0～14)！") ;
					returnFalg = false ;
					error = true ;
				}else{
					fr.waterQualityParam.setValue_PH_0to99d99(dv) ;
					has = true ;
					returnFalg = true ;
				}
			}
		}
		
		if(!error){
			value = fr.item04_03.getText().toString() ;
			if(!value.equals("")){
				dv = Double.valueOf(value) ;
				if(dv > 999.9 || dv < 0){
					if(showDialog)new DialogAlarm().showDialog(fr.act, "溶解氧数值超过合法取值范围(0～999.9)！") ;
					returnFalg = false ;
					error = true ;
				}else{
					fr.waterQualityParam.setValue_RongJieYang_0to999d9(dv) ;
					has = true ;
					returnFalg = true ;
				}
			}
		}
		
		if(!error){
			value = fr.item04_04.getText().toString() ;
			if(!value.equals("")){
				iv = Integer.valueOf(value) ;
				if(dv > 99999 || dv < 0){
					if(showDialog)new DialogAlarm().showDialog(fr.act, "电导率数值超过合法取值范围(0～99999)！") ;
					returnFalg = false ;
					error = true ;
				}else{
					fr.waterQualityParam.setValue_DianDaoLu_0to99999(iv) ;
					has = true ;
					returnFalg = true ;
				}
			}
		}
		
		if(!error){
			value = fr.item04_05.getText().toString() ;
			if(!value.equals("")){
				iv = Integer.valueOf(value) ;
				if(dv > 999 || dv < 0){
					if(showDialog)new DialogAlarm().showDialog(fr.act, "浊度数值超过合法取值范围(0～99999)！") ;
					returnFalg = false ;
					error = true ;
				}else{
					fr.waterQualityParam.setValue_ZhuoDu_0to999(iv) ;
					has = true ;
					returnFalg = true ;
				}
			}
		}
		
		
		
		if(!error && !has){
			if(showDialog)new DialogAlarm().showDialog(fr.act, "水质参数不能全部为空！") ;
			returnFalg = false ;
		}
		
		if(!returnFalg){
			fr.waterQualityParam = null ;
		}

		return returnFalg ;
	}
}

