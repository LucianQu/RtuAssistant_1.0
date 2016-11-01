package com.blg.rtu.protocol.p206.cdCE_DE;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;

public class Answer_CE_DE extends ProtocolSupport{

	private static String tag = Answer_CE_DE.class.getName() ;

	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param DCtaCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;

		Log.i(tag, "分析<RTU 卫星中心号码>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private RtuData doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_CE_DE subD = new Data_CE_DE() ;
		d.setSubData(subD) ;
		
		// 分析数据域
		byte enable = b[index++] ;
		subD.setEnable_1(enable & 1) ;
		subD.setEnable_2((enable & 2) >> 1) ;
		subD.setEnable_3((enable & 4) >> 2) ;
		subD.setEnable_4((enable & 8) >> 3) ;
		
		// 分析数据域
		byte[] bsate1 = new byte[6] ;
		byte[] bsate2 = new byte[6] ;
		byte[] bsate3 = new byte[6] ;
		byte[] bsate4 = new byte[6] ;
		for(int i = 0 ; i < 6 ; i++){
			bsate1[i] = b[index++] ;
		}
		for(int i = 0 ; i < 6 ; i++){
			bsate2[i] = b[index++] ;
		}
		for(int i = 0 ; i < 6 ; i++){
			bsate3[i] = b[index++] ;
		}
		for(int i = 0 ; i < 6 ; i++){
			bsate4[i] = b[index++] ;
		}
		String str = (new String(bsate1)).trim() ;	
		subD.setSate1(str==null?"000000":(str.equals("")?"000000":str)) ;
		str = (new String(bsate2)).trim() ;	
		subD.setSate2(str==null?"000000":(str.equals("")?"000000":str)) ;
		str = (new String(bsate3)).trim() ;	
		subD.setSate3(str==null?"000000":(str.equals("")?"000000":str)) ;
		str = (new String(bsate4)).trim() ;	
		subD.setSate4(str==null?"000000":(str.equals("")?"000000":str)) ;
		
		
		return d;
	}
	
}
