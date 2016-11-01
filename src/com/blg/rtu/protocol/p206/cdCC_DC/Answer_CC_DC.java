package com.blg.rtu.protocol.p206.cdCC_DC;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtilUnsigned;

public class Answer_CC_DC extends ProtocolSupport{

	private static String tag = Answer_CC_DC.class.getName() ;

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
		Data_CC_DC subD = new Data_CC_DC() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_1(enable & 1) ;
		subD.setEnable_2((enable & 2) >> 1) ;
		subD.setEnable_3((enable & 4) >> 2) ;
		subD.setEnable_4((enable & 8) >> 3) ;
		
		subD.setIp_1_1((b[index++] + 256) % 256) ;
		subD.setIp_1_2((b[index++] + 256) % 256) ;
		subD.setIp_1_3((b[index++] + 256) % 256) ;
		subD.setIp_1_4((b[index++] + 256) % 256) ;
		subD.setPort_1(ByteUtilUnsigned.bytes2Short(b, index)) ;
		index += 2 ;
		subD.setType_1((int)(b[index++] & 1)) ;
		
		subD.setIp_2_1((b[index++] + 256) % 256) ;
		subD.setIp_2_2((b[index++] + 256) % 256) ;
		subD.setIp_2_3((b[index++] + 256) % 256) ;
		subD.setIp_2_4((b[index++] + 256) % 256) ;
		subD.setPort_2(ByteUtilUnsigned.bytes2Short(b, index)) ;
		index += 2 ;
		subD.setType_2((int)(b[index++] & 1)) ;
		
		subD.setIp_3_1((b[index++] + 256) % 256) ;
		subD.setIp_3_2((b[index++] + 256) % 256) ;
		subD.setIp_3_3((b[index++] + 256) % 256) ;
		subD.setIp_3_4((b[index++] + 256) % 256) ;
		subD.setPort_3(ByteUtilUnsigned.bytes2Short(b, index)) ;
		index += 2 ;
		subD.setType_3((int)(b[index++] & 1)) ;
		
		subD.setIp_4_1((b[index++] + 256) % 256) ;
		subD.setIp_4_2((b[index++] + 256) % 256) ;
		subD.setIp_4_3((b[index++] + 256) % 256) ;
		subD.setIp_4_4((b[index++] + 256) % 256) ;
		subD.setPort_4(ByteUtilUnsigned.bytes2Short(b, index)) ;
		index += 2 ;
		subD.setType_4((int)(b[index++] & 1)) ;
		
		
		return d;
	}
	
}
