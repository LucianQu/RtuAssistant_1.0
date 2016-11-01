package com.blg.rtu.protocol.p206.cdD8;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_D8 extends ProtocolSupport{

	private static String tag = Answer_D8.class.getName() ;

	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param DCtaCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<RTU AD校准命令>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_D8 subD = new Data_D8() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		int temp = (b[index++] + 256) % 256 ;
		if(temp == 0xAA){
			subD.setSuccess(false) ;
		}else{
			subD.setType(temp >> 4) ;
			subD.setChannel(temp & 0xF) ;
			
			// 分析数据域
			int tmp = ByteUtil.BCD2Int_an(b, index, index + 1) ;
			subD.setValue(tmp/100.0D) ;
			index += 2 ;
		}
		
		return d;
	}
	
}
