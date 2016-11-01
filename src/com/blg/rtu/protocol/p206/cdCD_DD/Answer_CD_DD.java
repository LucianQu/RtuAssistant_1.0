package com.blg.rtu.protocol.p206.cdCD_DD;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_CD_DD extends ProtocolSupport{

	private static String tag = Answer_CD_DD.class.getName() ;

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

		Log.i(tag, "分析<RTU 短信中心号码>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_CD_DD subD = new Data_CD_DD() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_1(enable & 1) ;
		subD.setEnable_2((enable & 2) >> 1) ;
		subD.setEnable_3((enable & 4) >> 2) ;
		subD.setEnable_4((enable & 8) >> 3) ;
		
		// 分析数据域
		byte[] bphon1 = new byte[32] ;
		byte[] bphon2 = new byte[32] ;
		byte[] bphon3 = new byte[32] ;
		byte[] bphon4 = new byte[32] ;
		for(int i = 0 ; i < 32 ; i++){
			bphon1[i] = b[index++] ;
		}
		for(int i = 0 ; i < 32 ; i++){
			bphon2[i] = b[index++] ;
		}
		for(int i = 0 ; i < 32 ; i++){
			bphon3[i] = b[index++] ;
		}
		for(int i = 0 ; i < 32 ; i++){
			bphon4[i] = b[index++] ;
		}
			
		subD.setPhone1((new String(bphon1)).trim()) ;
		subD.setPhone2((new String(bphon2)).trim()) ;
		subD.setPhone3((new String(bphon3)).trim()) ;
		subD.setPhone4((new String(bphon4)).trim()) ;
		
		
		return d;
	}
	
}
