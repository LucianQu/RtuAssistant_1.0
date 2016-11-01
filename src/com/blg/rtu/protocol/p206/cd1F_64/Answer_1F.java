package com.blg.rtu.protocol.p206.cd1F_64;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_1F extends ProtocolSupport{

	private static String tag = Answer_1F.class.getName() ;
	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param dataCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;
		
		Log.i(tag, "分析<设置遥测终端的流量参数上限值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		int total = (b.length - Write_1F.len)/5 ;
		
		DataMap_1F_64 dataMap = new DataMap_1F_64() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		boolean plus = true ;
		//681D68301100000A1C1F 0000123000 0000234000 0000345678 000012160753006716
		for(int i = 0 ; i < total ; i++){
			plus = true ;
			Data_1F_64 dd = new Data_1F_64() ;
			dataMap.setValue(i + 1, dd) ;
			
			int temp = b[index + 4] ;
			if(temp < 0){
				plus = false ;
				b[index + 4] = (byte)(b[index + 4] & 0x0F) ;
			}
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 4) ;
			if(plus){
				dd.setWaterAmountParamUpLimit(bcd/1000.0D) ;
			}else{
				dd.setWaterAmountParamUpLimit(-(bcd/1000.0D)) ;
			}
			
			index += 5 ;
		}
	}
}