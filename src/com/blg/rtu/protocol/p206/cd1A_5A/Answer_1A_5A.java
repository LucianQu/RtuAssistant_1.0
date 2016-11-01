package com.blg.rtu.protocol.p206.cd1A_5A;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.cd19_59.Answer_19_59;

public class Answer_1A_5A extends Answer_19_59{

	private static String tag = Answer_1A_5A.class.getName() ;
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

		Data_5A dd = new Data_5A() ;
		d.setSubData(dd) ;
		
		this.doParse(b, index, d, dd, cp) ;
		
		Log.i(tag, "分析<遥测终端水质参数种类、下限值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}

}