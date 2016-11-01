package com.blg.rtu.protocol.p206.cd82_;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_82 extends ProtocolSupport{
	protected static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 0 ;//数据域长度
	/**
	* 构造RTU 命令
	* @param code 功能码
	* @param controlFunCode 控制域功能码
	* @param rtuId 终端ID
	* @param params 参数
	* @param password 密码
	* @return
	* @throws Exception
	*/
	public byte[] create(String code, byte controlFunCode, String rtuId, HashMap<String , Object> params, String password) throws Exception {
		Param_82_WaterLevelList p_waterLevel = (Param_82_WaterLevelList)params.get(Param_82_WaterLevelList.KEY) ;
		Param_82_WaterTemperature p_waterTemperature = (Param_82_WaterTemperature)params.get(Param_82_WaterTemperature.KEY) ;
		Param_82_WaterQuality p_waterQuality = (Param_82_WaterQuality)params.get(Param_82_WaterQuality.KEY) ;
		Param_82_WaterAmountList p_waterAmount = (Param_82_WaterAmountList)params.get(Param_82_WaterAmountList.KEY) ;
		
		if(p_waterLevel == null && p_waterTemperature == null && p_waterQuality== null && p_waterAmount== null){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		if(p_waterLevel != null){
			//水位
			return new Write_82_WaterLevel().create(code, Constant.Down_ControlFunCode_2, rtuId, p_waterLevel, password) ;
		}else if(p_waterTemperature != null){
			return new Write_82_WaterTemperature().create(code, Constant.Down_ControlFunCode_9, rtuId, p_waterTemperature, password) ;
		}else if(p_waterQuality != null){
			return new Write_82_WaterQuality().create(code, Constant.Down_ControlFunCode_10, rtuId, p_waterQuality, password) ;
		}else if(p_waterAmount != null){
			return new Write_82_WaterAmount().create(code, Constant.Down_ControlFunCode_3, rtuId, p_waterAmount, password) ;
		}
		return null ;
	}

}
