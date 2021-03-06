package com.blg.rtu.protocol.p206.cdE4_F4;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtilUnsigned;

public class Answer_E4_F4 extends ProtocolSupport{

	private static String tag = Answer_E4_F4.class.getName() ;

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

		Log.i(tag, "分析<RTU 仪表量程>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_E4_F4 subD = new Data_E4_F4() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_level(enable & 1) ;
//		subD.setEnable_qaulity((enable & 2) >> 1) ;
		subD.setEnable_temperature((enable & 4) >> 2) ;
		subD.setEnable_amount1((enable & 8) >> 3) ;
		subD.setEnable_amount2((enable & 16) >> 4) ;
		subD.setEnable_amount3((enable & 32) >> 5) ;
		
		// 分析数据域
		subD.setMeter_level((ByteUtilUnsigned.bytes2Short_an(b, index))/100.0F) ;
		index += 2 ;
//		subD.setMeter_qaulity((ByteUtilUnsigned.bytes2Short_an(b, index))) ;
		index += 2 ;
		subD.setMeter_temperature((ByteUtilUnsigned.bytes2Short_an(b, index))/10.0F) ;
		index += 2 ;
		subD.setMeter_amount1((ByteUtilUnsigned.bytes2Short_an(b, index))/10.0F) ;
		index += 2 ;
		subD.setMeter_amount2((ByteUtilUnsigned.bytes2Short_an(b, index))/10.0F) ;
		index += 2 ;
		subD.setMeter_amount3((ByteUtilUnsigned.bytes2Short_an(b, index))/10.0F) ;
		index += 2 ;
		
		return d;
	}
	
}
