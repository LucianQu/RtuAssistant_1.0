package com.blg.rtu.protocol.p206.cdD4;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_D4 extends ProtocolSupport {
	private static String tag = Answer_D4.class.getName() ;
	/**
	 * 解析上行数据
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param dataCode 数据功能码
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d) ;
		this.doParse(b, index, d, cp) ;
		
		Log.i(tag, "分析<SIM卡ICCID号>应答： RTU ID=" + rtuId + "数据" + d.getSubData().toString()) ;
		return d ;
	}
	
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) {
		Data_D4 data = new Data_D4() ;
		d.setSubData(data) ;
		byte[] bphon1 = new byte[5] ;
		byte[] bphon2 = new byte[5] ;
		byte[] bphon3 = new byte[5] ;
		byte[] bphon4 = new byte[5] ;
		
		for(int i = 0 ; i < 5 ; i++){
			bphon1[i] = checkAscii(b[index++]) ;
		}
		for(int i = 0 ; i < 5 ; i++){
			bphon2[i] = checkAscii(b[index++]) ;
		}
		for(int i = 0 ; i < 5 ; i++){
			bphon3[i] = checkAscii(b[index++]) ;
		}
		for(int i = 0 ; i < 5 ; i++){
			bphon4[i] = checkAscii(b[index++]) ;
		}
		
		String value1 = new String(bphon1).trim();
		String value2 = new String(bphon2).trim();
		String value3 = new String(bphon3).trim();
		String value4 = new String(bphon4).trim();
		
		data.setSimIccId(value1 + "-" + value2 + "-" + value3 + "-" +  value4);
	}
	public byte checkAscii(byte b) {
		if(b >= 48 && b <= 57) {
			return b;	
		}else if(b >= 65 && b <= 90) {
			return b;
		}else if(b >= 97 && b <= 122) {
			return b;
		}else{
			return b = 32 ;
		}
	}
}
