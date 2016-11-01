package com.blg.rtu.protocol.p206.common.protocol;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.data.* ;
import com.blg.rtu.util.DateTime;

public class DateTimeProtocol_206 {
	
	private DateTime206_2012 dateTime ;
	
	public DateTime206_2012 getDateTime() {
		return dateTime;
	}

	/**
	 * 分析日期时间部分
	 */
	public void parse(byte[] b , int index) throws Exception {
		int n = index ; 
		dateTime = new DateTime206_2012() ;

		int date = ByteUtil.BCD2Int_an(b, n, n++) ;
		int hour = ByteUtil.BCD2Int_an(b, n, n++) ;
		int minute = ByteUtil.BCD2Int_an(b, n, n++) ;
		int second = ByteUtil.BCD2Int_an(b, n, n++) ;

		dateTime.setDate(date) ;
		dateTime.setHour(hour) ;
		dateTime.setMinute(minute) ;
		dateTime.setSecond(second) ;
		
		String year = DateTime.yyyy() ;
		String month = DateTime.MM() ;

		String clock1 = year + "-" + month + "-" +
		(date < 10 ? ("0" + date) : date) + " " +
		(hour < 10 ? ("0" + hour) : hour) + "=" + 
		(minute < 10 ? ("0" + minute) : minute) ;
		
		String clock2 = clock1 + "=" +  
		(second < 10 ? ("0" + second) : second) ;
		
		dateTime.setClock(clock2) ;
		dateTime.setClockDifference_minute(DateTime.minutesBetweenyyyy_MM_dd_HH_mm(clock1, DateTime.yyyy_MM_dd_HH_mm())) ;
	}

}
