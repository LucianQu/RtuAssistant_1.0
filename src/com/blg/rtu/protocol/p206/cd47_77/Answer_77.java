package com.blg.rtu.protocol.p206.cd47_77;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_77  extends ProtocolSupport{

	private static String tag = Answer_77.class.getName() ;
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
		
		Log.i(tag, "分析<RTU设置负积>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_77 dd = new Data_77() ;
		d.setSubData(dd) ;
		
		dd.setLoraChannel((b[index++] + 256)%256) ;
		b[index + 4] =(byte)(b[index + 4] & 0xF );
		long v1 = ByteUtil.BCD2Long_an(b, index, index + 4) ;
		dd.setWaterMinus(v1) ;
	}
}