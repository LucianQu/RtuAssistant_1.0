package com.blg.rtu.protocol.p206.cdD2_D6;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtilUnsigned;

public class Answer_D2_D6 extends ProtocolSupport{

	private static String tag = Answer_D2_D6.class.getName() ;

	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param DCtaCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<RTU 中心网址>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_D2_D6 subD = new Data_D2_D6() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index] ;
		
		subD.setEnable_Instant(enable & 1) ;
		subD.setEnable_AccumuTotal((enable & 2) >> 1) ;
		subD.setReportType((enable & 4) >> 2) ;
		subD.setReportPrtcl((enable & 64) >> 6) ;
		subD.setEnable_D0((enable & 128) >> 7) ;
		
		return d;
	}
	
}
