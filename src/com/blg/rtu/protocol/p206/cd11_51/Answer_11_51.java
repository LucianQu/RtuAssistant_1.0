package com.blg.rtu.protocol.p206.cd11_51;

import android.util.Log;
import com.blg.rtu.protocol.p206.common.* ;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.DateTime;

public class Answer_11_51 extends ProtocolSupport{

	private static String tag = Answer_11_51.class.getName() ;
	
	private long clockDifference_minute ;//测控终端时钟与本地时钟差值(分钟)
	private int meterClock_hour ;//当前测控终端时钟(时)
	
	public int getMeterClock_hour() {
		return meterClock_hour;
	}
	public long getClockDifference_minute() {
		return clockDifference_minute;
	}

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
		String clock = this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<读取RTU时钟>应答: RTU ID=" + rtuId + " 时钟：" + clock );
		return d;
	}
	private String doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_11_51 dd = new Data_11_51() ;
		d.setSubData(dd) ;
		
		
		// 分析数据域
		int second = ByteUtil.BCD2Int_an(b, n, n++) ;
		int minute = ByteUtil.BCD2Int_an(b, n, n++) ;
		int hour = ByteUtil.BCD2Int_an(b, n, n++) ;
		int date = ByteUtil.BCD2Int_an(b, n, n++) ;
		int weekMonth = (b[n] + 256) % 256 ;
		int week = weekMonth >> 5 ;
		b[n] = (byte)(b[n] & 31) ;
		int month = ByteUtil.BCD2Int_an(b, n, n++) ;
		
		int year = ByteUtil.BCD2Int_an(b, n, n++) ;

		String clock1 = DateTime.yyyy().substring(0,2) + (year < 10 ? ("0" + year) : year) + "-" +
		(month < 10 ? ("0" + month) : month) + "-" +
		(date < 10 ? ("0" + date) : date) + " " +
		(hour < 10 ? ("0" + hour) : hour) + ":" + 
		(minute < 10 ? ("0" + minute) : minute) ;
		
		String clock2 = clock1 + ":" +  
		(second < 10 ? ("0" + second) : second) ;
		
		dd.setClock(clock2) ;
		
		if(week == 0){
			//无效
			dd.setWeek("星期:无效") ;
		}else{
			if(week == 7){
				dd.setWeek("星期日") ;
			}else{
				dd.setWeek("星期" + week) ;
			}
		}
			
		this.meterClock_hour = hour ;
		
		this.clockDifference_minute = DateTime.minutesBetweenyyyy_MM_dd_HH_mm(clock1, DateTime.yyyy_MM_dd_HH_mm()) ;

		return clock2 ;
	}
	
}
