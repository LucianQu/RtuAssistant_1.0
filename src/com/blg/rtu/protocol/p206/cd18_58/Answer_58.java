package com.blg.rtu.protocol.p206.cd18_58;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.protocol.AlarmProtocol_206;

public class Answer_58 extends ProtocolSupport{

	private static String tag = Answer_58.class.getName() ;
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
		
		Log.i(tag, "分析<查询遥测终端水压上、下限值及报警>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		int total = (b.length - Read_58.len - 2)/8 ;
		
		DataMap_58 dataMap = new DataMap_58() ;
		d.setSubData(dataMap) ;
		
		int bcd = 0 ;
		for(int i = 0 ; i < total ; i++){
			Data_58 dd = new Data_58() ;
			dataMap.setValue(i + 1, dd) ;
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 3) ;
			dd.setWaterPressDownLimit(bcd/100.0D) ;
			
			index += 4 ;
			bcd = ByteUtil.BCD2Int_an(b, index, index + 3) ;
			dd.setWaterPressUpLimit(bcd/100.0D) ;
			
			index += 4 ;
		}
		
		AlarmProtocol_206 alarmProto = new AlarmProtocol_206() ;
		alarmProto.parse(b, index, dataMap) ;
		
		
	}
}
