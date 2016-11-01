package com.blg.rtu.protocol.p206.cd20;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.util.ByteUtil;

public class Answer_20 extends ProtocolSupport{

	private static String tag = Answer_20.class.getName() ;
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
		
		Log.i(tag, "分析<设置遥测终端检测参数启报阈值及固态存储时间段间隔>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}

	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_20 dd = new Data_20() ;
		d.setSubData(dd) ;
		
		int temp = (b[index++] + 256) % 256 ;
		int type = temp >> 4 ;
		int countv = temp & 0xF ;
		
		int interval = (b[index++] + 256) % 256 ;
		
		dd.setDataType(type) ;
		dd.setDataCount_1to15(countv) ;
		dd.setSaveInterval_1to255(interval) ;
		
		if(type == 0){//雨量，1字节压缩BCD码，取值范围为0.1～9.9mm
			dd.setThreshold(this.parseDouble(b, index, 1, 0.1D, false)) ;
		}else if(type == 1){//水位 ，4 字节压缩BCD，取值范围为-9999.999～+9999.999，单位为m
			dd.setThreshold(this.parseDouble(b, index, 4, 0.001D, true)) ;
		}else if(type == 2){//流量(水量)，5 字节压缩BCD，为-999999.999～+999999.999，单位为m3/s，m3/h（水资源）
			dd.setThreshold(this.parseDouble(b, index, 5, 0.001D, true)) ;
		}else if(type == 3){//流速，3 字节压缩BCD。取值范围为-99.999～+99.999，单位为m/s。
			dd.setThreshold(this.parseDouble(b, index, 3, 0.001D, true)) ;
		}else if(type == 4){//闸位，3 字节压缩BCD，取值范围为0～999.99，单位为m，
			dd.setThreshold(this.parseDouble(b, index, 3, 0.01D, false)) ;
		}else if(type == 5){//功率，3 个字节压缩BCD。取值范围为0～999999，单位为kw
			dd.setThreshold(this.parseDouble(b, index, 3, 1D, false)) ;
		}else if(type == 6){//气压，3 个字节压缩BCD。取值范围为0～99999，单位为10的平方pa(100pa)
			dd.setThreshold(this.parseDouble(b, index, 3, 1D, false)) ;
		}else if(type == 7){//风速(风向)，3 个字节压缩BCD。取值范围为0～999.99，单位为m/s。
			dd.setThreshold(this.parseDouble(b, index, 3, 0.01D, false)) ;
		}else if(type == 8){//水温，为2 个字节压缩BCD。取值范围为0～99.9，单位为℃
			dd.setThreshold(this.parseDouble(b, index, 2, 0.1D, false)) ;
		}else if(type == 9){//水质，5 字节压缩BCD，为-999999.999～+999999.999，
			dd.setThreshold(this.parseDouble(b, index, 5, 0.001D, true)) ;
		}else if(type == 10){//土壤含水率，2 个字节压缩BCD。取值范围为0～999.9，无单位
			dd.setThreshold(this.parseDouble(b, index, 2, 0.1D, false)) ;
		}else if(type == 11){//蒸发量，3 个字节压缩BCD。取值范围为0～9999.9，单位为mm。
			dd.setThreshold(this.parseDouble(b, index, 3, 0.1D, false)) ;
		}else if(type == 12){//水压，4 个字节的BCD，低位在前，高位在后，取值范围为0～999999.99，单位为kPa。
			dd.setThreshold(this.parseDouble(b, index, 4, 0.01D, false)) ;
		}else{
			throw new Exception("出错，参数类型不正确！") ;
		}
		
	}
	
	private Double parseDouble(byte[] bs, int index, int bytes, Double cheng, boolean hasFu)throws Exception{
		boolean isPlus = true ;
		if(hasFu){
			if(bs[index + bytes -1] < 0){
				isPlus = false ;
				bs[index + bytes -1] = (byte)(bs[index + bytes -1] & 15) ;
			}
		}
		Integer i = ByteUtil.BCD2Int_an(bs, index, index + bytes -1) ;
		Double d = i * cheng ;
		if(!isPlus){
			d = -d ;
		}
		return d ;
	}
}
