package com.blg.rtu.protocol.p206.cd1E_63;

import android.util.Log;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_63 extends Answer_1E{

	private static String tag = Answer_63.class.getName() ;
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

		Data_63 dd = new Data_63() ;
		d.setSubData(dd) ;

		this.doParse(b, index, d, dd, cp) ;
		
		Log.i(tag, "分析<查询中继站工作机自动切换、自报状态>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, Data_63 dd, ControlProtocol cp) throws Exception {
		
		super.doParse(b, index, d, dd, cp) ;
		
		index += 1 ;
		byte v = b[index] ;
		if((v & 1) == 0){
			dd.setWorkA(0) ;
		}else if((v & 1) == 1){
			dd.setWorkA(1) ;
		}

		if(((v >> 1) & 1) == 0){
			dd.setWorkB(0) ;
		}else if(((v >> 1) & 1) == 1){
			dd.setWorkB(1) ;
		}

		if(((v >> 2) & 1) == 0){
			dd.setWorker(0) ;
		}else if(((v >> 2) & 1) == 1){
			dd.setWorker(1) ;
		}

		if(((v >> 3) & 1) == 0){
			dd.setCanRelay(0) ;
		}else if(((v >> 3) & 1) == 1){
			dd.setCanRelay(1) ;
		}

		if(((v >> 4) & 1) == 0){
			dd.setPowerAlarm(0) ;
		}else if(((v >> 4) & 1) == 1){
			dd.setPowerAlarm(1) ;
		}

		if(((v >> 5) & 1) == 0){
			dd.setRelayFault(0) ;
		}else if(((v >> 5) & 1) == 1){
			dd.setRelayFault(1) ;
		}
		
		int size = b.length - Read_63.len - 2 / 5 ;
		String[] dts = new String[size] ;
		dd.setChangedRecord(dts) ;
		
		index += 1 ;
		for(int i = 0; i < size ; i++){
			dts[i] = this.parseTime(b, index) ;
			index += 5 ;
		}
		
		
	}
	/**
	 * 分析日期时间部分
	 */
	public String parseTime(byte[] b , int index) throws Exception {
		int n = index ; 
		int year = ByteUtil.BCD2Int_an(b, n, n++) ;
		int month = ByteUtil.BCD2Int_an(b, n, n++) ;
		int date = ByteUtil.BCD2Int_an(b, n, n++) ;
		int hour = ByteUtil.BCD2Int_an(b, n, n++) ;
		int minute = ByteUtil.BCD2Int_an(b, n, n++) ;
		
		int week = month / 100 ;
		month = month % 100 ;


		String clock = DateTime.yyyy().substring(0,2) + (year < 10 ? ("0" + year) : year) + "-" +
		(month < 10 ? ("0" + month) : month) + "-" +
		(date < 10 ? ("0" + date) : date) + " " +
		(hour < 10 ? ("0" + hour) : hour) + "=" + 
		(minute < 10 ? ("0" + minute) : minute) +
		 " 星期" + week ;
		
		return clock ;
	}

}
