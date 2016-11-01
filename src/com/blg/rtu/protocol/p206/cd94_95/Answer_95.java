package com.blg.rtu.protocol.p206.cd94_95;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_95  extends ProtocolSupport{
	
	private static String tag = Answer_95.class.getName() ;

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
		
		Log.i(tag, "分析<遥控中继站工作机切换>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_95 dd = new Data_95() ;
		d.setSubData(dd) ;
		
		byte db = b[index] ;
		if(db == 9){
			dd.setWorker_A0rB("A") ;
		}else if(db == 6){
			dd.setWorker_A0rB("B") ;
		}
		if(((db & 0xF) >> 4) == 0xA){
			dd.setSuccess(true) ;
		}

	}
}
