package com.blg.rtu.protocol.p206.cdCA_DA;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_CA_DA extends ProtocolSupport{

	private static String tag = Answer_CA_DA.class.getName() ;

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

		Log.i(tag, "分析<RTU GRPS接入点>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_CA_DA subD = new Data_CA_DA() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte[] bname = new byte[32] ;
		byte[] uname = new byte[32] ;
		byte[] pname = new byte[32] ;
		for(int i = 0 ; i < 32 ; i++){
			bname[i] = b[index++] ;
		}
		for(int i = 0 ; i < 32 ; i++){
			uname[i] = b[index++] ;
		}
		for(int i = 0 ; i < 32 ; i++){
			pname[i] = b[index++] ;
		}
			
		subD.setName((new String(bname)).trim()) ;
		subD.setUser((new String(uname)).trim()) ;
		subD.setPassword((new String(pname)).trim()) ;
		
		return d;
	}
	
}
