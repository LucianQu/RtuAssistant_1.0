package com.blg.rtu.protocol.p206.cdB2;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_B2  extends ProtocolSupport{

	private static String tag = Answer_B2.class.getName() ;
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
		
		Log.i(tag, "分析<查询终端内存自报数据>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		
		Data_B2 subd = new Data_B2() ;
		d.setSubData(subd) ;
		
		int v = ByteUtil.BCD2Int_an(b[n++]) ;
		String mm = v < 10?("0" + v):("" + v) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String hh = v < 10?("0" + v):("" + v) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String dd = v < 10?("0" + v):("" + v) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String m = v < 10?("0" + v):("" + v) ;
		
		subd.setStartDt(m + "-" + dd + " " + hh + "=" + mm) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String emm = v < 10?("0" + v):("" + v) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String ehh = v < 10?("0" + v):("" + v) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String edd = v < 10?("0" + v):("" + v) ;
		
		v = ByteUtil.BCD2Int_an(b[n++]) ;
		String em = v < 10?("0" + v):("" + v) ;
		
		subd.setEndDt(em + "-" + edd + " " + ehh + "=" + emm) ;
		
	}

}
