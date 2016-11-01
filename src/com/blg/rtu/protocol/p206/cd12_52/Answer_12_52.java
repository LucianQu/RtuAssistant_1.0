package com.blg.rtu.protocol.p206.cd12_52;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_12_52 extends ProtocolSupport{

	private static String tag = Answer_12_52.class.getName() ;

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

		Log.i(tag, "分析<RTU 工作模式>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_12_52 subD = new Data_12_52() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte c = b[index] ;
		c = (byte)(c & 0x03) ;//&0x03，使字节前6 bit清为0
				
		subD.setModel(Integer.valueOf(c)) ;
		
		return d;
	}
	
}
