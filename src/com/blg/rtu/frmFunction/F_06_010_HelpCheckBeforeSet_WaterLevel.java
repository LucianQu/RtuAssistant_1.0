package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterLevel;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterLevelList;
import com.blg.rtu.util.DialogAlarm;

public class F_06_010_HelpCheckBeforeSet_WaterLevel {
	
	private F_06_010 fr ;
	
	public F_06_010_HelpCheckBeforeSet_WaterLevel(F_06_010 fr){
		this.fr = fr ;
	}

	protected boolean checkBeforeSet(boolean showDialog){
		boolean returnFalg = false ;
		//水位数据
		if(fr.waterLevelWataNodes.size() == 0){
			if(showDialog)new DialogAlarm().showDialog(fr.act, "至少设置一个水位数据！") ;
		}else{
			fr.waterLevelParam = new Param_82_WaterLevelList() ;
			int index = F_06_010.firstIndex_waterLevel ;
			boolean has = false ;
			boolean error = false ;
			
			String value1 = null ;
			Double level = null ;
			
			F_06_010_HelpData_WaterLevel.Node node = fr.waterLevelWataNodes.get("" + index) ;
			while(node != null){
				value1 = node.itemText1.getText().toString() ;
				if(!value1.equals("")){
					has = true ;
					level = Double.valueOf(value1) ;
					if(level > 9999.999 || level < -9999.999){
						if(showDialog)new DialogAlarm().showDialog(fr.act, "水位" + index + "数值超过合法取值范围(-9999.999～9999.999)！") ;
						error = true ;
					}

					if(error){
						break ;
					}else{
						Param_82_WaterLevel p = new Param_82_WaterLevel() ;
						p.setValue_n9999d999to9999d999(level) ;
						fr.waterLevelParam.getDataList().put(index, p) ;
						
						index++ ;
						node = fr.waterLevelWataNodes.get("" + index) ;
					}
				}else{
					if(showDialog)new DialogAlarm().showDialog(fr.act, "水位" + index + "数值必须填写！") ;
					error = true ;
					break ;
				}
			}
			
			if(has && !error){
				returnFalg = true ;
			}else{
				fr.waterLevelParam = null ;
			}
		}
		return returnFalg ;
	}
}
