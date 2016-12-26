package com.blg.rtu.protocol.p206.cdB1;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Answer_B1 extends ProtocolSupport{

	private static String tag = Answer_B1.class.getName() ;
	
	protected static int len = Constant.Bits_Head 
				+ Constant.Bits_Control
				+ Constant.Bits_RTU_ID 
				+ Constant.Bits_Code 
				+ Constant.Bits_CRC
				+ Constant.Bits_Tail ;
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
		
		Log.i(tag, "分析<查询遥测终端固态数据>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	protected void doParse(byte[] b, int index, RtuData d, ControlProtocol ca) throws Exception {
		DataList_B1 dataList = new DataList_B1() ;
		d.setSubData(dataList) ;
		
		int dataCd = (b[index] & 0xF0) >> 4;
		
		int dataCount = (b[index++] & 0x0F);
		dataList.setDataCount(dataCount) ;
		
		String h = ByteUtil.BCD2String(b, index, index++) ;
		String r = ByteUtil.BCD2String(b, index, index++) ;
		String m = ByteUtil.BCD2String(b, index, index++) ;
		String y = ByteUtil.BCD2String(b, index, index++) ;
		dataList.setStartDt("20" + y + "-" + m + "-" + r + " " + h) ;
		
		h = ByteUtil.BCD2String(b, index, index++) ;
		r = ByteUtil.BCD2String(b, index, index++) ;
		m = ByteUtil.BCD2String(b, index, index++) ;
		y = ByteUtil.BCD2String(b, index, index++) ;
		dataList.setEndDt("20" + y + "-" + m + "-" + r + " " + h) ;
		
		
		if(dataCd == 0){
			//雨量参数
			dataList.setDataName("雨量") ;
			this.doParseData(dataList, b, index, d, 3, false, 10.0D, "mm") ;
		}else if(dataCd == 1){
			//水位参数
			dataList.setDataName("水位") ;
			this.doParseData(dataList, b, index, d, 4, true, 1000.0D, "m") ;
		}else if(dataCd == 2){
			//流量参数
			dataList.setDataName("累计流量") ;
			this.doParseData(dataList, b, index, d, 5, false, null, "m3") ;
		}else if(dataCd == 3){
			//流速参数
			dataList.setDataName("流速") ;
			this.doParseData(dataList, b, index, d, 3, true, 1000.0D, "m/s") ;
		}else if(dataCd == 4){
			//闸位参数
			dataList.setDataName("闸位") ;
			this.doParseData(dataList, b, index, d, 3, false, 100.0D, "m") ;
		}else if(dataCd == 5){
			//功率参数
			dataList.setDataName("功率") ;
			this.doParseData(dataList, b, index, d, 3, false, null, "kw") ;
		}else if(dataCd == 6){
			//气压参数
			dataList.setDataName("气压") ;
			this.doParseData(dataList, b, index, d, 3, false, null, "100pa") ;
		}else if(dataCd == 7){
			//风速参数
			dataList.setDataName("风速") ;
			this.doParseFengSuData(dataList, b, index, d, 3, "m/s") ;
		}else if(dataCd == 8){
			//水温参数
			dataList.setDataName("水温") ;
			this.doParseData(dataList, b, index, d, 2, false, 10.0D, "℃") ;
		}else if(dataCd == 9){
			//水质参数
			//dataMap.setDataName("水质") ;
			//this.doParseData(dataMap, b, index, d, 2, true, true, 10.0D, "℃") ;
		}else if(dataCd == 10){
			//土壤含水率参数
			dataList.setDataName("土壤含水率") ;
			this.doParseData(dataList, b, index, d, 2, false, 10.0D, "") ;
//		}else if(dataCd == 11){
//			// 蒸发量参数
//			dataList.setDataName("蒸发量") ;
//			this.doParseData(dataList, b, index, d, 3, false, 10.0D, "mm") ;
//		}else if(dataCd == 11){
//			// 报警或状态参数 
//			//dataMap.setDataName("报警或状态") ;
//			//this.doParseData(dataMap, b, index, d, 3, false, 10.0D, "") ;
//		}else if(dataCd == Constant.Up_ControlFunCode_14){
//			// 统计雨量参数
//			//dataMap.setDataName("统计雨量") ;
//			//this.doParseData(dataMap, b, index, d, 3, false, 10.0D, "") ;
		}else if(dataCd == 11){
			// 水压参数
			dataList.setDataName("水压") ;
			this.doParseData(dataList, b, index, d, 4, false, 100.0D, "") ;
		}else{
			throw new Exception("当前实现不支持此数据类型:" + dataCd) ;
		}

	}
	//686A68B21100004200B1210022121602221216920000000092000000009200000000920000000092000000009200000000
	//9200000000920000000092000000009200000000920000000092000000009200000000920000000092000000009200000000
	//92000000009200000000F416
	//this.doParseData(dataList, b, index, d, 5, false, null, "m3") ;
	protected void doParseData(DataList_B1 dataList, byte[] b, int index, RtuData d, int lenPer, boolean hasFuShu, Double cuShu, String unit) throws Exception {
		int total = (b.length - (len + 9))/lenPer ;//前 9 个字节为日期和参数编号
		long bcd = 0 ;
		boolean plus = true ;
		int ffCount = 0 ;
		for(int i = 0 ; i < total ; i++){
			Data_B1 dd = new Data_B1() ;
			dataList.getDatas().add(dd) ;
			dd.valueUnit = unit ;

			
			ffCount = 0 ;
			//当数据为0xFFFF...FF时，表示无数据
			for(int j = index; j < (index + lenPer); j++){
				if(b[j] == (byte)0xFF){
					ffCount++ ;
				}
			}
			if(ffCount < lenPer){
				plus = true ;
				
				if(hasFuShu){
					int temp = b[index + lenPer -1] ;
					if(temp < 0){
						plus = false ;
						b[index + lenPer - 1] = (byte)(b[index + lenPer - 1] & 0xF) ;
					}
				}
				
				bcd = ByteUtil.BCD2Long_an(b, index, index + lenPer - 1) ;
				
				if(cuShu != null){
					dd.valueDbl = bcd/cuShu ;
				}else{
					dd.valueLng = bcd ;
				}
				
				if(!plus){
					if(cuShu != null){
						dd.valueDbl = - dd.valueDbl ;
					}else{
						dd.valueLng = - dd.valueLng ;
					}
				}
			}else{
				dd.valueFFF = "" ;
				for(int k = 0; k < ffCount; k++){
					dd.valueFFF = dd.valueFFF + "FF" ;
				}
			}
			
			index += lenPer ;
		}
	}

	protected void doParseFengSuData(DataList_B1 dataList, byte[] b, int index, RtuData d, int lenPer, String unit) throws Exception {
		int total = (b.length - len - lenPer)/lenPer ;
		
		int ffCount = 0 ;
		for(int i = 0 ; i < total ; i++){
			Data_B1 dd = new Data_B1() ;
			dataList.getDatas().add(dd) ;
			dd.valueUnit = unit ;

			
			ffCount = 0 ;
			//当数据为0xFFFF...FF时，表示无数据
			for(int j = index; j < (index + lenPer); j++){
				if(b[j] == (byte)0xFF){
					ffCount++ ;
				}
			}
			if(ffCount < lenPer){
				int temp = b[index + lenPer - 1] ;
				dd.fengXiang = temp >> 4 ;
				
				b[index + lenPer - 1] = (byte)(b[index + lenPer - 1] & 0xF) ;
				
				dd.valueLng = ByteUtil.BCD2Long_an(b, index, index + lenPer - 1) ;
			}else{
				dd.valueFFF = "" ;
				for(int k = 0; k < ffCount; k++){
					dd.valueFFF = dd.valueFFF + "FF" ;
				}
			}
			
			index += lenPer ;
		}
	}

}
