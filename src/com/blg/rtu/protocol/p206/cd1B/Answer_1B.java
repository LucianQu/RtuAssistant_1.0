package com.blg.rtu.protocol.p206.cd1B;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.util.Constant;

public class Answer_1B extends ProtocolSupport{
	
	protected static int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
						//	+ Constant.Bits_Password 
						//	+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 0 ;//数据域长度

	private static String tag = Answer_1B.class.getName() ;
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
		
		Log.i(tag, "分析<设置表底值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		int total = (b.length - len)/5 ;
		
		DataMap_1B dataMap = new DataMap_1B() ;
		d.setSubData(dataMap) ;
		
		long bcd = 0 ;
		int flag = 0 ;
		for(int i = 0 ; i < total ; i++){
			Data_1B dd = new Data_1B() ;
			dataMap.setValue(i + 1, dd) ;
			
			flag = b[index + 4] ;
			b[index + 4] = (byte)(b[index + 4] & 127) ;
			
			bcd = ByteUtil.BCD2Long_an(b, index, index + 4) ;
			if(flag < 0){
				//为负
				bcd = -bcd ;
			}
			dd.setInitWaterAmount(bcd) ;
			
			index += 5 ;
		}
	}
}