package com.blg.rtu.protocol.p206.cd96;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.util.ByteUtil;

public class Answer_96  extends ProtocolSupport{
	
	private static String tag = Answer_96.class.getName() ;

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
		
		Log.i(tag, "分析<终端密码>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_96 subD = new Data_96() ;
		d.setSubData(subD) ;
		
//		int pass = ByteUtil.BCD2Int_an(b, index, index + 1) ;
//		subD.setPassword(pass) ;
		String hex = ByteUtil.bytes2Hex_an(b, true, index, 2) ;
		subD.setPasswordHex(hex) ;
	}
}
