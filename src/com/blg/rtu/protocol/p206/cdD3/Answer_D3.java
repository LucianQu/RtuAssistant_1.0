package com.blg.rtu.protocol.p206.cdD3;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_D3 extends ProtocolSupport {
	private static String tag = Answer_D3.class.getName();
	
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
		Data_D3 data = new Data_D3() ;
		d.setSubData(data);
		
		long value = ByteUtil.BCD2Long(b, index, index + 7);
		data.setWaterMeterSerial(value);
	}

}
