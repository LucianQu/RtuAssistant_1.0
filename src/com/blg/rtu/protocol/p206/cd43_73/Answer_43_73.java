package com.blg.rtu.protocol.p206.cd43_73;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_43_73 extends ProtocolSupport{

	private static String tag = Answer_43_73.class.getName() ;

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

		Log.i(tag, "分析<中继器关联ModBus地址命令>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_43_73 subD = new Data_43_73() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_1(enable & 1) ;
		subD.setEnable_2((enable & 2) >> 1) ;
		subD.setEnable_3((enable & 4) >> 2) ;
		subD.setEnable_4((enable & 8) >> 3) ;
		subD.setEnable_5((enable & 16) >> 4) ;
		subD.setEnable_6((enable & 32) >> 5) ;
		subD.setEnable_7((enable & 64) >> 6) ;
		subD.setEnable_8((enable & 128) >> 7) ;
		
		subD.setModBusAddr1((b[index++] + 256)%256);
		subD.setModBusAddr2((b[index++] + 256)%256);
		subD.setModBusAddr3((b[index++] + 256)%256);
		subD.setModBusAddr4((b[index++] + 256)%256);
		subD.setModBusAddr5((b[index++] + 256)%256);
		subD.setModBusAddr6((b[index++] + 256)%256);
		subD.setModBusAddr7((b[index++] + 256)%256);
		subD.setModBusAddr8((b[index++] + 256)%256);
		
		return d;
	}
	
}
