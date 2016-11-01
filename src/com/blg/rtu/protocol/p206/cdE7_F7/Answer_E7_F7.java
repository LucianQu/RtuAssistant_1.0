package com.blg.rtu.protocol.p206.cdE7_F7;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_E7_F7 extends ProtocolSupport{

	private static String tag = Answer_E7_F7.class.getName() ;

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

		Log.i(tag, "分析<RTU 数据采集种类及时间间隔>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_E7_F7 subD = new Data_E7_F7() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		int enable = (b[index++] + 256) % 256 ;
		subD.setEnable_01(enable & 1) ;
		subD.setEnable_02((enable & 2) >> 1) ;
		subD.setEnable_03((enable & 4) >> 2) ;
		subD.setEnable_04((enable & 8) >> 3) ;
		subD.setEnable_05((enable & 16) >> 4) ;
		subD.setEnable_06((enable & 32) >> 5) ;
		subD.setEnable_07((enable & 64) >> 6) ;
		subD.setEnable_08((enable & 128) >> 7) ;
		
		enable = (b[index++] + 256) % 256 ;
		subD.setEnable_09(enable & 1) ;
		subD.setEnable_10((enable & 2) >> 1) ;
		subD.setEnable_11((enable & 4) >> 2) ;
		subD.setEnable_12((enable & 8) >> 3) ;
		subD.setEnable_13((enable & 16) >> 4) ;
		subD.setEnable_14((enable & 32) >> 5) ;
		subD.setEnable_15((enable & 64) >> 6) ;
		
		
		// 分析数据域
		subD.setValue_01(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_02(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_03(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_04(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_05(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_06(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_07(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_08(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_09(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_10(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_11(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_12(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_13(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_14(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		subD.setValue_15(ByteUtil.BCD2Int_an(b, index++, index++)) ;
		
		return d;
	}
	
}
