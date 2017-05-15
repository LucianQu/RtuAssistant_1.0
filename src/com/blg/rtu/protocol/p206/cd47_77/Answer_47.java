package com.blg.rtu.protocol.p206.cd47_77;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_47  extends ProtocolSupport{

	private static String tag = Answer_47.class.getName() ;
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
		Data_47 dd = new Data_47() ;
		d.setSubData(dd) ;
		
		/*int pw = ByteUtil.BCD2Int_an(b, index, index + 1) ;
		dd.setPassword(pw + "") ;
		dd.setLoraChannel((b[index + 2] + 256)%256) ;*/
		b[index + 4] = (byte)(b[index + 4] & 15) ;
		long v1 = ByteUtil.BCD2Long_an(b, index , index + 4) ;
		dd.setWaterMinus(v1) ;
	}
}