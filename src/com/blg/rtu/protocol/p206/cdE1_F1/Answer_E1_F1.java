package com.blg.rtu.protocol.p206.cdE1_F1;

import android.util.Log;
import com.blg.rtu.util.ByteUtilUnsigned;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_E1_F1  extends ProtocolSupport{

	private static String tag = Answer_E1_F1.class.getName() ;
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
		
		Log.i(tag, "分析<RTU 电池电压报警值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_E1_F1 subD = new Data_E1_F1() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		
		int v = ByteUtilUnsigned.bytes2Short_an(b, index) ;
		
		subD.setVoltage1(v/100) ;
		subD.setVoltage2(v%100) ;
		 
	}
}