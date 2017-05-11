package com.blg.rtu.protocol.p206.cdD3_3E;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_D3_3E extends ProtocolSupport {
	private static String tag = Answer_D3_3E.class.getName();
	
	/**
	 * 解析上行数据
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param dataCode 数据功能码
	 * @return 
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d) ;
		this.doParse(b, index, d, cp);
		
		Log.i(tag, "分析<RTU出厂编号>应答： RTU ID=" + rtuId + " 数据" + d.getSubData().toString());
		return d;
	}

	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception{
		Data_D3_3E data = new Data_D3_3E() ;
		d.setSubData(data);
		
		String value = ByteUtil.BCD2String(b, index, index + 1);
		String value1 = ByteUtil.BCD2String(b, index + 2, index + 3);
		String value2 = ByteUtil.BCD2String(b, index + 4, index + 5);
		String value3 = ByteUtil.BCD2String(b, index + 6, index + 6);
		data.setWaterMeterSerial(value + " " + value1 + " " + value2  + " " + value3);
	}

}
