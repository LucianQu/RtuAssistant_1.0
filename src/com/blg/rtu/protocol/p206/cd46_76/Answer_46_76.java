package com.blg.rtu.protocol.p206.cd46_76;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_46_76  extends ProtocolSupport{

	private static String tag = Answer_46_76.class.getName() ;
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
		
		Log.i(tag, "分析<RTU流量实时值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_46_76 dd = new Data_46_76() ;
		d.setSubData(dd) ;
		
		int pw = ByteUtil.BCD2Int_an(b, index, index + 1) ;
		dd.setPassword(pw + "") ;
		dd.setLoraChannel((b[index] + 256)%256) ;
		
		// 分析数据域
		/*int flag = b[index + 4] ;
		b[index + 4] = (byte)(b[index + 4] & 15) ;*/
		
		long v1 = ByteUtil.BCD2Long_an(b, index + 3, index + 7) ;
		/*if(flag < 0){
			//为负
			v1 = -v1 ;
		}*/
		dd.setWaterPure(v1) ;
		
		//index +=5;
		// 分析数据域
		/*int flag1 = b[index + 4] ;
		b[index + 4] = (byte)(b[index + 4] & 127) ;
		
		long v2 = ByteUtil.BCD2Long_an(b, index, index + 4) ;
		if(flag1 < 0){
			//为负
			v2 = -v2 ;
		}
		dd.setWaterConsumption(v2) ;*/
		
	}
}