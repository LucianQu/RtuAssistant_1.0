package com.blg.rtu.protocol.p206.cdEC_FC;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_EC_FC extends ProtocolSupport{

	private static String tag = Answer_EC_FC.class.getName() ;
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
		
		Log.i(tag, "分析<查询日志配置表>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] bs, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_EC_FC dd = new Data_EC_FC() ;
		d.setSubData(dd) ;
		// 分析数据域
		int a = bs[n++] ;
		int a5 = (a & 0x10) >> 4 ;
		int a4 = (a & 0x8) >> 3 ;
		int a3 = (a & 0x4) >> 2 ;
		int a2 = (a & 0x2) >> 1 ;
		int a1 = (a & 0x1) ;
		dd.setA01(a1) ; 
		dd.setA02(a2) ; 
		dd.setA03(a3) ; 
		dd.setA04(a4) ;  
		dd.setA05(a5) ; 
		
		n++ ;
		
		
		int b = bs[n++] ;
		int b8 = (b & 0x80) >> 7 ;
		int b7 = (b & 0x40) >> 6 ;
		int b6 = (b & 0x20) >> 5 ;
		int b5 = (b & 0x10) >> 4 ;
		int b4 = (b & 0x8) >> 3 ;
		int b3 = (b & 0x4) >> 2 ;
		int b2 = (b & 0x2) >> 1 ;
		int b1 = (b & 0x1) ;
		dd.setB01(b1) ; 
		dd.setB02(b2) ; 
		dd.setB03(b3) ; 
		dd.setB04(b4) ;  
		dd.setB05(b5) ; 
		dd.setB06(b6) ; 
		dd.setB07(b7) ; 
		dd.setB08(b8) ;

		b = bs[n++] ;
		int b10 = (b & 0x2) >> 1 ;
		int b9 = (b & 0x1) ;
		dd.setB09(b9) ; 
		dd.setB10(b10) ;
		
		int c = bs[n++] ;
		int c6 = (c & 0x20) >> 5 ;
		int c5 = (c & 0x10) >> 4 ;
		int c4 = (c & 0x8) >> 3 ;
		int c3 = (c & 0x4) >> 2 ;
		int c2 = (c & 0x2) >> 1 ;
		int c1 = (c & 0x1) ;
		dd.setC01(c1) ; 
		dd.setC02(c2) ; 
		dd.setC03(c3) ; 
		dd.setC04(c4) ;  
		dd.setC05(c5) ; 
		dd.setC06(c6) ; 

	}

}
