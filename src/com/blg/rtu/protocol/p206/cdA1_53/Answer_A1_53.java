package com.blg.rtu.protocol.p206.cdA1_53;

import android.util.Log;

import com.blg.rtu.protocol.p206.common.* ;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.util.ByteUtil;

public class Answer_A1_53 extends ProtocolSupport{

	private static String tag = Answer_A1_53.class.getName() ;
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
		
		Log.i(tag, "分析<RTU的数据自报种类及时间间隔>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		Data_A1_53 dd = new Data_A1_53() ;
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

//		short v15 = (short)((v & 0x40) >> 6) ;
		short v14 = (short)((v & 0x20) >> 5) ;
		short v13 = (short)((v & 0x10) >> 4) ;
		int v12 = (v & 0x8) >> 3 ;
		int v11 = (v & 0x4) >> 2 ;
		int v10 = (v & 0x2) >> 1 ;
		int v9 = (v & 0x1) ;

		dd.setShuiWen(v9) ;//置“1”为主动上报水温数据，清“0”为不上报水温数据；
		dd.setShuiZhi(v10) ;//置“1”为主动上报水质数据，清“0”为不上报水质数据；
		dd.setTuRang(v11) ;//置“1”为主动上报土壤含水率数据，清“0”为不上报土壤含水率数据；
		dd.setZhengFa(v12) ;//置“1”为主动上报蒸发量数据，清“0”为不上报蒸发量数据；

		dd.setBaoJing(v13) ;
		dd.setShuiYa(v14) ;
//		dd.setDianYa(v15) ;
		
//		dd.setQiWen(v13) ;//置“1”为上报气温数据，清“0”为不上报气温数据；
//		dd.setDianChi(v14) ;//置“1”为上报蓄电池电压数据，清“0”为不上报蓄电池电压数据；
//		dd.setGsmXinQiang(v15) ;//置“1”为上报GSM网络信号强度数据，清“0”为不上报GSM网络信号强度数据；
		
		Integer w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setYuLiangReportInterval(w.shortValue()) ;//雨量数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setShuiWeiReportInterval(w.shortValue()) ;//水位数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setLiuLiangReportInterval(w.shortValue()) ;//流量数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setLiuSuReportInterval(w.shortValue()) ;//流速数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setZhaWeiReportInterval(w.shortValue()) ;//闸位数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setGongLuReportInterval(w.shortValue()) ;//功率数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setQiYaReportInterval(w.shortValue()) ;//气压数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setFengSuReportInterval(w.shortValue()) ;//风速（风向）数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setShuiWenReportInterval(w.shortValue()) ;//水温数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setShuiZhiReportInterval(w.shortValue()) ;//水质数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setTuRangReportInterval(w.shortValue()) ;//土壤含水率数据 自报时间间隔
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setZhengFaReportInterval(w.shortValue()) ;//蒸发量数据 自报时间间隔

		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setBaoJingReportInterval(w.shortValue()) ; 
		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
		dd.setShuiYaReportInterval(w.shortValue()) ; 
		//w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;//电压不自报
		//dd.setDianYaReportInterval(w.shortValue()) ; 

		
//		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
//		dd.setQiWenReportInterval(w.shortValue()) ;//气温数据 自报时间间隔
//		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
//		dd.setDianChiReportInterval(w.shortValue()) ;//蓄电池电压数据 自报时间间隔
//		w = ByteUtil.BCD2Int_an(b, n, n + 1) ; n += 2 ;
//		dd.setGsmXinQiangReportInterval(w.shortValue()) ;//GSM网络信号强度数据 自报时间间隔
		//后2个字节备用

	}
}
