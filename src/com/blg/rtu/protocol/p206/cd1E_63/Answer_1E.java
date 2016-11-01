package com.blg.rtu.protocol.p206.cd1E_63;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_1E extends ProtocolSupport{

	private static String tag = Answer_1E.class.getName() ;
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

		Data_1E dd = new Data_1E() ;
		d.setSubData(dd) ;

		this.doParse(b, index, d, dd, cp) ;
		
		Log.i(tag, "分析<设置中继站工作机自动切换、自报状态>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	protected void doParse(byte[] b, int index, RtuData d, Data_1E dd, ControlProtocol cp) throws Exception {
		
		// 分析数据域
		byte v = b[index] ;
		if((v & 3) == 0){
			dd.setAutoWorkChange(0) ;
		}else if((v & 3) == 3){
			dd.setAutoWorkChange(1) ; 
		}

		if(((v >> 2) & 3) == 0){
			dd.setEnableRelay(0) ;
		}else if(((v >> 2) & 3) == 3){
			dd.setEnableRelay(1) ; 
		}
		
		if(((v >> 4) & 1) == 0){
			dd.setAutoReportPowerAlarm(0) ;
		}else if(((v >> 4) & 1) == 1){
			dd.setAutoReportPowerAlarm(1) ; 
		}
		
		if(((v >> 5) & 1) == 0){
			dd.setAutoReportWorkChange(0) ;
		}else if(((v >> 5) & 1) == 1){
			dd.setAutoReportWorkChange(1) ; 
		}
		
		if(((v >> 6) & 1) == 0){
			dd.setAutoReportFault(0) ;
		}else if(((v >> 6) & 1) == 1){
			dd.setAutoReportFault(1) ; 
		}
		
	}
}