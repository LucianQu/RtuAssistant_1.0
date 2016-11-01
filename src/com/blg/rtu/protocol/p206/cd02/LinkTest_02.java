package com.blg.rtu.protocol.p206.cd02;


import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.protocol.p206.common.*;
/**
 * 链路检测（AFN=02H）
 * 用于GPRS、CDMA登录、退出登录、在线保持。数据域：1个字节，F0登录，F1退出登录，F2在线保持。
 * @author Administrator
 */
public class LinkTest_02 extends ProtocolSupport{

	private static String tag = LinkTest_02.class.getName() ;
	/**
	 * 分析RTU 数据
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, cp, dataCode, index, d) ;
		Log.i(tag, "分析<RTU链路检测数据>: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	/**
	 * 分析RTU 数据
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private RtuData doParse(byte[] b, ControlProtocol cp, String dataCode, int index, RtuData d) throws Exception {
		Data_02 subD = new Data_02() ;
		d.setSubData(subD) ;
		
		subD.setOraData(b[index]);
		
		if((byte)b[index] == (byte)0xF0){
			subD.setStatus(Constant.LinkTest_F0) ;
		}else if((byte)b[index] == (byte)0xF1){
			subD.setStatus(Constant.LinkTest_F1) ;
		}else if((byte)b[index] == (byte)0xF2){
			subD.setStatus(Constant.LinkTest_F2) ;
		}else{
			subD.setStatus(Constant.LinkTest_unknow) ;
		}
		
		return d;
	}

}
