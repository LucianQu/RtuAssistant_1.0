package com.blg.rtu.protocol.p206.cdED;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Answer_ED extends ProtocolSupport{

	private static String tag = Answer_ED.class.getName() ;
	
	protected static int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail ;
	
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
		
		Log.i(tag, "分析<查询日志信息>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		DataList_ED subD = new DataList_ED() ;
		d.setSubData(subD) ;
		// 分析数据域
		int total = (b.length - len )/16 ;
		for(int i = 0 ; i < total ; i++){
			Data_ED dd = new Data_ED() ;
			subD.getDatas().add(dd) ;
			
			dd.setIndex((b[n] + 256)%256) ;
			dd.setLogHex(ByteUtil.bytes2Hex(b, false, n , 16)) ;
			n += 16 ;
		}
	}
}
