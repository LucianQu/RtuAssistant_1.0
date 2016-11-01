package com.blg.rtu.protocol.p206.cd1D_62;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.RtuIdProtocol;
import com.blg.rtu.protocol.p206.util.Constant;

public class Answer_1D_62 extends ProtocolSupport{

	private static String tag = Answer_1D_62.class.getName() ;
	
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
		this.doParse(b, index, d, cp, dataCode) ;

		Log.i(tag, "分析<中继站转发终端地址>: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}

	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp, String dataCode) throws Exception {
		
		DataMap_1D_62 subDMap = new DataMap_1D_62() ;
		d.setSubData(subDMap) ;
		
		RtuIdProtocol ra = new RtuIdProtocol() ;
		int size = 0 ;
		if(dataCode.equals(Code206.cd_1D)){
			size = (b.length - Write_1D.len)/Constant.Bits_RTU_ID ;
		}else{
			size = (b.length - Read_62.len)/Constant.Bits_RTU_ID ;
		}
		for(int i = 0 ; i < size ; i++){
			Data_1D_62 subD = new Data_1D_62() ;
			subDMap.setValue(i + 1, subD) ;
			String[] ss = ra.parseRtuId_1(b, index , (index + Constant.Bits_RTU_ID - 1)) ;
			subD.setRtuId(ss[0]) ;
			index += 5 ;
		}
	}
}