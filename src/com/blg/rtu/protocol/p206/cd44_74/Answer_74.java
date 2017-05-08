package com.blg.rtu.protocol.p206.cd44_74;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
//设置、查询遥测终端地址，中继站地址
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.RtuIdProtocol;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu1.LoginActivity;

public class Answer_74 extends ProtocolSupport{

	private static String tag = Answer_74.class.getName() ;
	
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

		Log.i(tag, "分析<查询中继站地址>: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}

	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		DataList_74 subD = new DataList_74() ;
		List<String> list = new ArrayList<String>();
		d.setSubData(subD) ;
		
		String[] ss = new RtuIdProtocol().parseRtuId_1(b, index,
				(index + Constant.Bits_RTU_ID - 1)) ;
		list.add(ss[0] + "-" + " ");
		
		if(!LoginActivity.instance.getCbWifiConnecyType()) {
			index = index + 5 ;
			int modbusAddr ;
			for(int i = 0; i < 8; i++) {
				ss = new RtuIdProtocol().parseRtuId_1(b, index + (i * 6),
						(index + Constant.Bits_RTU_ID - 1) + (i * 6)) ;
				modbusAddr = (b[(index + Constant.Bits_RTU_ID) + (i * 6) ] + 256)%256 ;
				list.add(ss[0] + "-" + modbusAddr);
		}
	
		subD.setRtuId(list);
	}
  }
}