package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.util.Constant;

public class ProtocolSupport {
	
	protected long clockDifference_minute ;//测控终端时钟与本地时钟差值(分钟)
	protected int meterClock_hour ;//当前测控终端时钟(时)
	
	public int getMeterClock_hour() {
		return meterClock_hour;
	}
	public long getClockDifference_minute_abs() {
		clockDifference_minute = clockDifference_minute < 0 ?(-clockDifference_minute):clockDifference_minute ;
		return clockDifference_minute;
	}
	/**
	 * 构造下行数据的前部分
	 * @param rtuId
	 * @param params
	 * @param password
	 * @param b
	 * @param len
	 * @return
	 * @throws Exception
	 */
	public int createDownDataHead(String rtuId, String dataCode, byte[] b, int len, byte controlFunCode) throws Exception {
		// 数据头
		b = new HeadProtocol().createHead(b, len);

		// 控制域
		byte DIV = Constant.DIV_no ;
		ControlProtocol cp = new ControlProtocol() ;
		b = cp.createToRTUControl(b, DIV, Constant.FCB_Default, DIV, controlFunCode);
		

		// RTU ID
		int fromSite = Constant.Site_RTUID ;
		if(cp.hasDIVS){
			fromSite += 1 ;
		}
		RtuIdProtocol rp = new RtuIdProtocol() ;
		b = rp.createRtuId(b, rtuId, fromSite);
		

		//功能码
		fromSite = Constant.Site_Code ;
		if(cp.hasDIVS){
			fromSite += 1 ;
		}
		b = new CodeProtocol().createCode(b, dataCode, fromSite) ;
		
		
		//数据域
		fromSite = Constant.Site_Data ;
		if(cp.hasDIVS){
			fromSite += 1 ;
		}
		
		return fromSite ;
	}
	
	/**
	 * 构造下行数据的尾部
	 * @param b
	 * @param password
	 * @throws Exception
	 */
	public void createDownDataTail(byte[] b, String passwordHex) throws Exception {
		// 附加域
		int n = b.length - (Constant.Bits_Password + Constant.Bits_Time + Constant.Bits_CRC + Constant.Bits_Tail) ;
		AuxProtocol ap = new AuxProtocol() ;
		b = ap.createPassword(b, n, passwordHex) ;
		
		n += 2 ;
		b = ap.createTime(b, n) ;
		
		// 数据尾(包括CRC)
		b = new TailProtocol().createTail(b);
	}
	/**
	 * 解析上行数据前部分
	 * @param rtuId
	 * @param b
	 * @param cp
	 * @param dataCode
	 * @param d
	 * @return
	 */
	public int parseUpDataHead(String rtuId, byte[] b, ControlProtocol cp, String dataCode, RtuData d){
		d.setRtuId(rtuId) ;
		
		d.setDataCode(dataCode) ;
		int index = Constant.Site_Data ;
		if(cp.hasDIVS){
			index += 1 ;
		}
		
		return index ;
	}
	
	/**
	 * 分析日期时间部分
	 */
//	protected void parseTime(RtuData d , byte[] b , int index) throws Exception {
//		DateTimeProtocol_206 pro = new DateTimeProtocol_206() ;
//		pro.parse(b, index) ;
//		DateTime206_2012 dateTime = pro.getDateTime() ;
//		
//		d.setClock(dateTime.getClock()) ;
//		this.meterClock_hour = dateTime.getHour() ;
//		this.clockDifference_minute = dateTime.getClockDifference_minute() ;
//	}

}
