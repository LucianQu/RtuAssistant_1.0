package com.blg.rtu.protocol.p206.cdE3_F3;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_E3_F3 extends ProtocolSupport{

	private static String tag = Answer_E3_F3.class.getName() ;

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

		Log.i(tag, "分析<RTU 仪表系数>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_E3_F3 subD = new Data_E3_F3() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_level(enable & 1) ;
		subD.setEnable_qaulity((enable & 2) >> 1) ;
		subD.setEnable_temperature((enable & 4) >> 2) ;
		subD.setEnable_amount1((enable & 8) >> 3) ;
		subD.setEnable_amount2((enable & 16) >> 4) ;
		subD.setEnable_amount3((enable & 32) >> 5) ;
		
		// 分析数据域
		subD.setMeter_level((b[index++] + 256) % 256) ;
		subD.setMeter_qaulity((b[index++] + 256) % 256) ;
		subD.setMeter_temperature((b[index++] + 256) % 256) ;
		subD.setMeter_amount1((b[index++] + 256) % 256) ;
		subD.setMeter_amount2((b[index++] + 256) % 256) ;
		subD.setMeter_amount3((b[index++] + 256) % 256) ;
		
		return d;
	}
	
}
