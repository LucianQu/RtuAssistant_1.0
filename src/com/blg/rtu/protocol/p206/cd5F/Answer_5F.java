package com.blg.rtu.protocol.p206.cd5F;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;


public class Answer_5F extends ProtocolSupport{

	private static String tag = Answer_5F.class.getName() ;
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
		
		Log.i(tag, "分析<查询水泵电机实时工作数据>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_5F subD = new Data_5F() ;
		d.setSubData(subD) ;
		subD.setVolt_A((b[n++] + 256)%256) ;//数据初始化记录 2
		subD.setVolt_B((b[n++] + 256)%256) ;// 参数变更记录2
		subD.setVolt_C((b[n++] + 256)%256) ;// 状态量变位记录 2
		subD.setCurrent_A((b[n++] + 256)%256) ;// 仪表故障记录 2
		subD.setCurrent_B((b[n++] + 256)%256) ;// 密码错误记录 2
		subD.setCurrent_C((b[n++] + 256)%256) ;// 终端故障记录 2
	}

}