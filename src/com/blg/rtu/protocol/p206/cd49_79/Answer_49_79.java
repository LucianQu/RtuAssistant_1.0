package com.blg.rtu.protocol.p206.cd49_79;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_49_79 extends ProtocolSupport{

	private static String tag = Answer_49_79.class.getName() ;
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
		
		Log.i(tag, "分析<整体脉冲系数>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] bs, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_49_79 dd = new Data_49_79() ;
		d.setSubData(dd) ;
		// 分析数据域
		
		int 
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setPlus1Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setPlus2Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setPlus3Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setPlus4Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setPlus5Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setMinus1Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setMinus2Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setMinus3Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setMinus4Partition(v1);
		n = n + 2;
		v1 = ByteUtil.BCD2Int_an(bs, n, n + 1) ;
		dd.setMinus5Partition(v1);
		
	}

}
