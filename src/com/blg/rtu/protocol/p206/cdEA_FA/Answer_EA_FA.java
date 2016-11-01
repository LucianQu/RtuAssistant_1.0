package com.blg.rtu.protocol.p206.cdEA_FA;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_EA_FA extends ProtocolSupport{

	private static String tag = Answer_EA_FA.class.getName() ;

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

		Log.i(tag, "分析<RTU 井口高程，水井深度，探头埋深>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_EA_FA subD = new Data_EA_FA() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_1(enable & 1) ;
		subD.setEnable_2((enable & 2) >> 1) ;
		subD.setEnable_3((enable & 4) >> 2) ;
		
		// 分析数据域
		int flag = b[index + 2] ;
		b[index + 2] = (byte)(b[index + 2] & 127) ;
		
		int v = ByteUtil.BCD2Int_an(b, index, index + 2);
		if(flag < 0){
			//为负
			v = -v ;
		}
		subD.setValue_1(v/100.0F) ;
		index += 3 ;
		
		v = ByteUtil.BCD2Int_an(b, index, index + 1);
		subD.setValue_2(v/100.0F) ;
		index += 2 ;
		
		v = ByteUtil.BCD2Int_an(b, index, index + 1);
		subD.setValue_3(v/100.0F) ;
		index += 2 ;

		return d;
	}
	
}
