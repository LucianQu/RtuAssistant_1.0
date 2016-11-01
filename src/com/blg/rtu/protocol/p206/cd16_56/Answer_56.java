package com.blg.rtu.protocol.p206.cd16_56;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_56  extends ProtocolSupport{

	private static String tag = Answer_56.class.getName() ;
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
		
		Log.i(tag, "分析<RTU剩余水量及报警值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_56 dd = new Data_56() ;
		d.setSubData(dd) ;
		
		// 分析数据域
		int v1 = ByteUtil.BCD2Int_an(b, index, index + 2) ;
		dd.setWaterRemainAlarm(v1) ;
		
		index += 3 ;
		
		// 分析数据域
		int flag = b[index + 4] ;
		b[index + 4] = (byte)(b[index + 4] & 127) ;
		
		long v2 = ByteUtil.BCD2Long_an(b, index, index + 4) ;
		if(flag < 0){
			//为负
			v2 = -v2 ;
		}
		dd.setWaterRemain(v2) ;
		
	}
}