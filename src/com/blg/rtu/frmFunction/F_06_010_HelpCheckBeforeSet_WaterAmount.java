package com.blg.rtu.frmFunction;

import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterAmount;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterAmountList;
import com.blg.rtu.util.DialogAlarm;

public class F_06_010_HelpCheckBeforeSet_WaterAmount {
	
	private F_06_010 fr ;
	
	public F_06_010_HelpCheckBeforeSet_WaterAmount(F_06_010 fr){
		this.fr = fr ;
	}

	protected boolean checkBeforeSet(boolean showDialog){
		boolean returnFalg = false ;
		//水量数据
		if(fr.waterAmountWataNodes.size() == 0){
			if(showDialog)new DialogAlarm().showDialog(fr.act, "至少设置一个水量数据！") ;
		}else{
			fr.waterAmountParam = new Param_82_WaterAmountList() ;
			int index = F_06_010.firstIndex_waterAmount ;
			boolean has = false ;
			boolean error = false ;
			
			String value1 = null ;
			Long level = null ;
			
			F_06_010_HelpData_WaterAmount.Node node = fr.waterAmountWataNodes.get("" + index) ;
			while(node != null){
				value1 = node.itemText1.getText().toString() ;
				if(!value1.equals("")){
					has = true ;
					level = Long.valueOf(value1) ;
					if(level > 7999999999L || level < 0){
						if(showDialog)new DialogAlarm().showDialog(fr.act, "累计水量" + index + "数值超过合法取值范围(0～7999999999)！") ;
						error = true ;
					}

					if(error){
						break ;
					}else{
						Param_82_WaterAmount p = new Param_82_WaterAmount() ;
						p.setValue_0to7999999999(level) ;
						fr.waterAmountParam.getDataList().put(index, p) ;
						
						index++ ;
						node = fr.waterAmountWataNodes.get("" + index) ;
					}
				}else{
					if(showDialog)new DialogAlarm().showDialog(fr.act, "累计水量" + index + "数值必须填写！") ;
					error = true ;
					break ;
				}
			}
			
			if(has && !error){
				returnFalg = true ;
			}else{
				fr.waterAmountParam = null ;
			}
		}
		return returnFalg ;
	}
}
