package com.blg.rtu.protocol.p206.cd44_74;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.RtuIdProtocol;
import com.blg.rtu.protocol.p206.util.Constant;
//设置、查询遥测终端地址，中继站地址

public class Answer_44 extends ProtocolSupport{

	private static String tag = Answer_44.class.getName() ;
	
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

		Log.i(tag, "分析<设置中继站地址>: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}

	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_44 subD = new Data_44() ;
		d.setSubData(subD) ;

		String[] ss = new RtuIdProtocol().parseRtuId_1(b, index + 1 , (index + 1 + Constant.Bits_RTU_ID - 1)) ;
		int modbusAddr ;
		modbusAddr = (b[index + Constant.Bits_RTU_ID + 1] + 256)%256 ;
		subD.setRtuId(ss[0]+ "-" + modbusAddr) ;
	}
}