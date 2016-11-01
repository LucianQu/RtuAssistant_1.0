package com.blg.rtu.protocol.p206.cdC8;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_C8 extends ProtocolSupport{

	private static String tag = Answer_C8.class.getName() ;

	/**
	 * 解析上行数据
	 * @param rtuId
	 * @param b
	 * @param cp
	 * @param dataCode
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<RTU 查询RTU在线状态>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_C8 subD = new Data_C8() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		int net = (b[index++] + 256) % 256 ;
		subD.setNet1(net & 1) ;
		subD.setNet2(net & 2) ;
		subD.setNet3(net & 4) ;
		subD.setNet4(net & 8) ;
		
		subD.setDtuStrong((b[index++] + 256) % 256) ;

		subD.setWifi((b[index++] + 256) % 256) ;
		subD.setWifiOpt((b[index++] + 256) % 256) ;
		
		int sate = (b[index++] + 256) % 256 ;
		subD.setSate1(sate & 1) ;
		subD.setSate2(sate & 2) ;
		subD.setSate3(sate & 4) ;
		subD.setSate4(sate & 8) ;
		
		subD.setSateStrong((b[index++] + 256) % 256) ;

		return d;
	}
	
}
