package com.blg.rtu.protocol.p206.cdA0_54;

import android.util.Log;

import com.blg.rtu.protocol.p206.common.* ;
import com.blg.rtu.protocol.RtuData;

public class Answer_A0_54 extends ProtocolSupport{

	private static String tag = Answer_A0_54.class.getName() ;
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
		
		Log.i(tag, "分析<RTU遥测站需查询的实时数据种类>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_A0_54 dd = new Data_A0_54() ;
		d.setSubData(dd) ;
		// 分析数据域
		int v = b[n++] ;
		int v8 = (v & 0x80) >> 7 ;
		int v7 = (v & 0x40) >> 6 ;
		int v6 = (v & 0x20) >> 5 ;
		int v5 = (v & 0x10) >> 4 ;
		int v4 = (v & 0x8) >> 3 ;
		int v3 = (v & 0x4) >> 2 ;
		int v2 = (v & 0x2) >> 1 ;
		int v1 = (v & 0x1) ;
		dd.setYuLiang(v1) ;//置“1”为主动上报雨量数据，清“0”为不上报雨量数据；
		dd.setShuiWei(v2) ;//置“1”为主动上报水位数据，清“0”为不上报水位数据；
		dd.setLiuLiang(v3) ;//置“1”为主动上报流量数据，清“0”为不上报流量数据；
		dd.setLiuSu(v4) ;//置“1”为主动上报流速数据，清“0”为不上报流速数据；
		dd.setZhaWei(v5) ;//置“1”为主动上报闸位数据，清“0”为不上报闸位数据；
		dd.setGongLu(v6) ;//置“1”为主动上报功率数据，清“0”为不上报功率数据；
		dd.setQiYa(v7) ;//置“1”为主动上报气压数据，清“0”为不上报气压数据；
		dd.setFengSu(v8) ;//置“1”为主动上报风速（风向）数据，清“0”为不上报风速数据；
		
		v = b[n++] ;

		int v15 = (v & 0x40) >> 6 ;
		int v14 = (v & 0x20) >> 5 ;
		int v13 = (v & 0x10) >> 4 ;
		int v12 = (v & 0x8) >> 3 ;
		int v11 = (v & 0x4) >> 2 ;
		int v10 = (v & 0x2) >> 1 ;
		int v9 = (v & 0x1) ;
		dd.setShuiWen(v9) ;//置“1”为主动上报水温数据，清“0”为不上报水温数据；
		dd.setShuiZhi(v10) ;//置“1”为主动上报水质数据，清“0”为不上报水质数据；
		dd.setTuRang(v11) ;//置“1”为主动上报土壤含水率数据，清“0”为不上报土壤含水率数据；
		dd.setZhengFa(v12) ;//置“1”为主动上报蒸发量数据，清“0”为不上报蒸发量数据；
		dd.setNeiCun(v13) ;
		dd.setGuTai(v14) ;
		dd.setShuiYa(v15) ;

	}
}
