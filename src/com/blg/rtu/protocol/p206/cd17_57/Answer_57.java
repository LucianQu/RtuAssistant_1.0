package com.blg.rtu.protocol.p206.cd17_57;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.protocol.AlarmProtocol_206;

public class Answer_57 extends ProtocolSupport{

	private static String tag = Answer_57.class.getName() ;
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
		
		Log.i(tag, "分析<查询遥测终端的水位基值、水位上下限及报警>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		int total = (b.length - Read_57.len - 2)/7 ;//2：报警字节
		
		DataMap_17_57 dataMap = new DataMap_17_57() ;
		d.setSubData(dataMap) ;
		
		boolean plus = true ;
		byte temp = 0 ;
		int bcd ;
		for(int i = 0 ; i < total ; i++){
			Data_17_57 dd = new Data_17_57() ;
			dataMap.setValue(i + 1, dd) ;
			
			temp = b[index + 2] ;
			if(temp < 0){
				plus = false ;
				b[index + 2] = (byte)(b[index + 2] & 127) ;
			}

			bcd = ByteUtil.BCD2Int_an(b, index, index + 2) ;
			if(plus){
				dd.setWaterLevelBase(bcd/100.0D) ;
			}else{
				dd.setWaterLevelBase(-(bcd/100.0D)) ;
			}
			index += 3 ;
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 1) ;
			dd.setWaterLevelDownLimit(bcd/100.0D) ;
			index += 2 ;
			
			bcd = ByteUtil.BCD2Int_an(b, index, index + 1) ;
			dd.setWaterLevelUpLimit(bcd/100.0D) ;
			index += 2 ;
		}
		
		AlarmProtocol_206 alarmProto = new AlarmProtocol_206() ;
		alarmProto.parse(b, index, dataMap) ;
	}
}