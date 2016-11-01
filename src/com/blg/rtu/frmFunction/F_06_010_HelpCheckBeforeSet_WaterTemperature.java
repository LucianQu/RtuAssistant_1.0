package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterTemperature;
import com.blg.rtu.util.DialogAlarm;

public class F_06_010_HelpCheckBeforeSet_WaterTemperature {
	
	private F_06_010 fr ;
	
	public F_06_010_HelpCheckBeforeSet_WaterTemperature(F_06_010 fr){
		this.fr = fr ;
	}

	protected boolean checkBeforeSet(boolean showDialog){
		boolean returnFalg = false ;
		//水温数据
		fr.waterTemperatureParam = new Param_82_WaterTemperature() ;
		String value = fr.item03.getText().toString() ;
		if(!value.equals("")){
			Double dv = Double.valueOf(value) ;
			if(dv > 99.9 || dv < 0){
				if(showDialog)new DialogAlarm().showDialog(fr.act, "水温数值超过合法取值范围(0～99.9)！") ;
			}else{
				fr.waterTemperatureParam.setValue_0to99d9(dv) ;
				returnFalg = true ;
			}
		}else{
			if(showDialog)new DialogAlarm().showDialog(fr.act, "水温数值必须填写！") ;
		}
		
		
		if(!returnFalg){
			fr.waterTemperatureParam = null ;
		}

		return returnFalg ;
	}
}
