package com.blg.rtu.protocol.p206.cd45_75;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_45_75 extends ProtocolSupport{

	private static String tag = Answer_45_75.class.getName() ;
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
		
		Log.i(tag, "分析<LCD显示内容及刷屏间隔>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] bs, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_45_75 dd = new Data_45_75() ;
		d.setSubData(dd) ;
		// 分析数据域
		int a = bs[n++] ;
		int a7 = (a & 0x40) >> 6 ;
		int a6 = (a & 0x20) >> 5 ;
		int a5 = (a & 0x10) >> 4 ;
		int a4 = (a & 0x8)  >> 3 ;
		int a3 = (a & 0x4)  >> 2 ;
		int a2 = (a & 0x2)  >> 1 ;
		int a1 = (a & 0x1) ;
		dd.setA01(a1) ; 
		dd.setA02(a2) ; 
		dd.setA03(a3) ; 
		dd.setA04(a4) ;  
		dd.setA05(a5) ; 
		dd.setA06(a6) ;  
		dd.setA07(a7) ;
		n++;//备用
		int v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setShowInterval(v1);
	}

}
