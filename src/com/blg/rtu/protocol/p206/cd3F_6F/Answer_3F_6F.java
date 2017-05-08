package com.blg.rtu.protocol.p206.cd3F_6F;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.util.ByteUtil;

public class Answer_3F_6F  extends ProtocolSupport{

	private static String tag = Answer_3F_6F.class.getName() ;
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
		
		Log.i(tag, "分析<查询脉冲常数命令>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_3F_6F subD = new Data_3F_6F() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		int v1 = ByteUtil.BCD2Int_an(b, index , index + 1) ;
		subD.setPulseConstant(v1) ;
	}
}