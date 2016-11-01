package com.blg.rtu.protocol.p206.cdEF;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_EF extends ProtocolSupport{

	private static String tag = Answer_EF.class.getName() ;

	/**
	 * 解析上行数据
	 * @param rtuId
	 * @param b
	 * @param cp
	 * @param dataCode
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<RTU 版本号>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_EF subD = new Data_EF() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		subD.setHard1((b[index++] + 256) % 256) ;
		subD.setHard2((b[index++] + 256) % 256) ;
		subD.setHard3((b[index++] + 256) % 256) ;
		subD.setSoft1((b[index++] + 256) % 256) ;
		subD.setSoft2((b[index++] + 256) % 256) ;
		subD.setSoft3((b[index++] + 256) % 256) ;
		
		return d;
	}
	
}
