package com.blg.rtu.protocol.p206.cd23;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_23  extends ProtocolSupport{

	private static String tag = Answer_23.class.getName() ;
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
		
		Log.i(tag, "分析<查询月用水量>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_23 dd = new Data_23() ;
		d.setSubData(dd) ;
		
		dd.setQueryYear(ByteUtil.BCD2Int(b[index++])) ;
		Log.i(tag, "分析<查询月用水量>应答:" + "返回的查询年-" + dd.getQueryYear());
		
		dd.setQueryMonth(ByteUtil.BCD2Int(b[index++])) ;
		Log.i(tag, "分析<查询月用水量>应答:" + "返回的查询月-" + dd.getQueryMonth());
		
		dd.setMonthUseWater(ByteUtil.BCD2Long_an(b, index, index + 3)) ;
		Log.i(tag, "分析<查询月用水量>应答:" + "返回的月用水量-" + dd.getMonthUseWater());;
		
	}
}