package com.blg.rtu.protocol.p206.cdCB_DB;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_CB_DB extends ProtocolSupport{

	private static String tag = Answer_CB_DB.class.getName() ;

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

		Log.i(tag, "分析<RTU 主备通道>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_CB_DB subD = new Data_CB_DB() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte c = b[index] ;
		
				
		subD.setChMain(c & 3) ;
		subD.setChAssi1((c & 12) >> 2) ;
		subD.setChAssi2((c & 48) >> 4) ;
		
		return d;
	}
	
}
