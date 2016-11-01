package com.blg.rtu.protocol.p206.cd20;

import java.util.HashMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_20 extends ProtocolSupport{

	private static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 0;//数据域长度

	/**
	* 构造RTU 命令
	* @param code 功能码
	* @param controlFunCode 控制域功能码
	* @param rtuId 终端ID
	* @param params 参数
	* @param password 密码
	* @return
	* @throws Exception
	*/
	public byte[] create(String code, byte controlFunCode, String rtuId, HashMap<String , Object> params, String password) throws Exception {
		Param_20 p = (Param_20)params.get(Param_20.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		int countv = p.getDataCount_1to15() ;
		if(countv < 1 || countv > 15){
			throw new Exception("出错，被设置参数的编号取值范围必须是1至15！") ;
		}

		int intv = p.getSaveInterval_1to255() ;
		if(intv < 1 || intv > 255){
			throw new Exception("出错，固态存储时间段间隔取值范围必须是1至255！") ;
		}
		
		int type = p.getDataType() ;

		int length = len  ;
		length += 2 ;//前面两个字节
		if(type == 0){//雨量，1字节压缩BCD码，取值范围为0.1～9.9mm
			length += 1 ;
		}else if(type == 1){//水位 ，4 字节压缩BCD，取值范围为-9999.999～+9999.999，单位为m
			length += 4 ;
		}else if(type == 2){//流量(水量)，5 字节压缩BCD，为-999999.999～+999999.999，单位为m3/s，m3/h（水资源）
			length += 5 ;
		}else if(type == 3){//流速，3 字节压缩BCD。取值范围为-99.999～+99.999，单位为m/s。
			length += 3 ;
		}else if(type == 4){//闸位，3 字节压缩BCD，取值范围为0～999.99，单位为m，
			length += 3 ;
		}else if(type == 5){//功率，3 个字节压缩BCD。取值范围为0～999999，单位为kw
			length += 3 ;
		}else if(type == 6){//气压，3 个字节压缩BCD。取值范围为0～99999，单位为10的平方pa(100pa)
			length += 3 ;
		}else if(type == 7){//风速(风向)，3 个字节压缩BCD。取值范围为0～999.99，单位为m/s。
			length += 3 ;
		}else if(type == 8){//水温，为2 个字节压缩BCD。取值范围为0～99.9，单位为℃
			length += 2 ;
		}else if(type == 9){//水质，5 字节压缩BCD，为-999999.999～+999999.999，
			length += 5 ;
		}else if(type == 10){//土壤含水率，2 个字节压缩BCD。取值范围为0～999.9，无单位
			length += 2 ;
		}else if(type == 11){//蒸发量，3 个字节压缩BCD。取值范围为0～9999.9，单位为mm。
			length += 3 ;
		}else if(type == 12){//水压，4 个字节的BCD，低位在前，高位在后，取值范围为0～999999.99，单位为kPa。
			length += 4 ;
		}else{
			throw new Exception("出错，参数类型不正确！") ;
		}
		
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[length];
		
		int n = this.createDownDataHead(rtuId, code, b, length, controlFunCode) ;

		b[n++] = (byte)((type << 4) + countv) ;
		b[n++] = (byte)(intv) ;
		
		Double db = p.getThreshold() ;
		
		if(type == 0){//雨量，1字节压缩BCD码，取值范围为0.1～9.9mm
			if(db < 0.1 || db > 9.9){
				throw new Exception("出错，雨量启报阈值不在合法取值范围0.1～9.9！") ;
			}
			n = this.dealData(db, 10.0, b, n, 1) ;//1字节压缩BCD码
		}else if(type == 1){//水位 ，4 字节压缩BCD，取值范围为-9999.999～+9999.999，单位为m
			if(db < -9999.999 || db > 9999.999){
				throw new Exception("出错，水位启报阈值不在合法取值范围-9999.999～+9999.999！") ;
			}
			n = this.dealData(db, 1000.0, b, n, 4) ;//4字节压缩BCD码
		}else if(type == 2){//流量(水量)，5 字节压缩BCD，为-999999.999～+999999.999，单位为m3/s，m3/h（水资源）
			if(db < -999999.999 || db > 999999.999){
				throw new Exception("出错，流量启报阈值不在合法取值范围-999999.999～+999999.999！") ;
			}
			n = this.dealData(db, 1000.0, b, n, 5) ;//4字节压缩BCD码
		}else if(type == 3){//流速，3 字节压缩BCD。取值范围为-99.999～+99.999，单位为m/s。
			if(db < -99.999 || db > 99.999){
				throw new Exception("出错，流速启报阈值不在合法取值范围-99.999～+99.999！") ;
			}
			n = this.dealData(db, 1000.0, b, n, 3) ;//3字节压缩BCD码
		}else if(type == 4){//闸位，3 字节压缩BCD，取值范围为0～999.99，单位为m，
			if(db < 0 || db > 999.99){
				throw new Exception("出错，闸位启报阈值不在合法取值范围0～999.99！") ;
			}
			n = this.dealData(db, 100.0, b, n, 3) ; 
		}else if(type == 5){//功率，3 个字节压缩BCD。取值范围为0～999999，单位为kw
			if(db < 0 || db > 999999){
				throw new Exception("出错，功率启报阈值不在合法取值范围0～999999！") ;
			}
			n = this.dealData(db, 1, b, n, 3) ; 
		}else if(type == 6){//气压，3 个字节压缩BCD。取值范围为0～99999，单位为10的平方pa(100pa)
			if(db < 0 || db > 99999){
				throw new Exception("出错，气压启报阈值不在合法取值范围0～99999！") ;
			}
			n = this.dealData(db, 1, b, n, 3) ; 
		}else if(type == 7){//风速(风向)，3 个字节压缩BCD。取值范围为0～999.99，单位为m/s。
			if(db < 0 || db > 999.99){
				throw new Exception("出错，风速(风向)启报阈值不在合法取值范围0～999.99！") ;
			}
			n = this.dealData(db, 100.0, b, n, 3) ; 
		}else if(type == 8){//水温，为2 个字节压缩BCD。取值范围为0～99.9，单位为℃
			if(db < 0 || db > 99.9){
				throw new Exception("出错，水温启报阈值不在合法取值范围0～99.9！") ;
			}
			n = this.dealData(db, 10.0, b, n, 2) ; 
		}else if(type == 9){//水质，5 字节压缩BCD，为-999999.999～+999999.999，
			if(db < -999999.999 || db > 999999.999){
				throw new Exception("出错，水质启报阈值不在合法取值范围-999999.999～+999999.999！") ;
			}
			n = this.dealData(db, 1000.0, b, n, 5) ; 
		}else if(type == 10){//土壤含水率，2 个字节压缩BCD。取值范围为0～999.9，无单位
			if(db < 0 || db > 999.9){
				throw new Exception("出错，土壤含水率启报阈值不在合法取值范围0～999.9！") ;
			}
			n = this.dealData(db, 10.0, b, n, 2) ; 
		}else if(type == 11){//蒸发量，3 个字节压缩BCD。取值范围为0～9999.9，单位为mm。
			if(db < 0 || db > 9999.9){
				throw new Exception("出错，蒸发量启报阈值不在合法取值范围0～9999.9！") ;
			}
			n = this.dealData(db, 10.0, b, n, 3) ; 
		}else if(type == 12){//水压，4 个字节的BCD，低位在前，高位在后，取值范围为0～999999.99，单位为kPa。
			if(db < 0 || db > 999999.99){
				throw new Exception("出错，水压启报阈值不在合法取值范围0～999999.99！") ;
			}
			n = this.dealData(db, 100.0, b, n, 4) ; 
		} 
		
		this.createDownDataTail(b, password) ;
		
		return b;
		
	}
	
	private int dealData(Double db, double cheng, byte[] b, int index, int bytes){
		boolean plus = true ;
		if(db < 0){
			db = - db ;
			plus = false ;
		}
		byte[] bcd = ByteUtil.int2BCD_an(Double.valueOf(db * cheng).intValue()) ;
		index = this.setValue2Byets(bcd, b, index, bytes) ;
		if(!plus){
			b[index - 1] = (byte)(0xF0 | b[index - 1]) ;
		}
		return index ;
	}
	
	private int setValue2Byets(byte[] bcd, byte[] b, int index, int bytes){
		if(bytes == 1){
			b[index++] = bcd[0] ;
		}else if(bytes == 2){
			if(bcd.length == 1){
				b[index++] = bcd[0] ;
				b[index++] = 0 ;
			}else if(bcd.length == 2){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
			}
		}else if(bytes == 3){
			if(bcd.length == 1){
				b[index++] = bcd[0] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 2){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = 0 ;
			}else if(bcd.length == 3){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
			}	
		}else if(bytes == 4){
			if(bcd.length == 1){
				b[index++] = bcd[0] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 2){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 3){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = 0 ;
			}else if(bcd.length == 4){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = bcd[3] ;
			}	
		}else if(bytes == 5){
			if(bcd.length == 1){
				b[index++] = bcd[0] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 2){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 3){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 4){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = bcd[3] ;
				b[index++] = 0 ;
			}else if(bcd.length == 5){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = bcd[3] ;
				b[index++] = bcd[4] ;
			}
		}else if(bytes == 6){
			if(bcd.length == 1){
				b[index++] = bcd[0] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 2){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 3){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 4){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = bcd[3] ;
				b[index++] = 0 ;
				b[index++] = 0 ;
			}else if(bcd.length == 5){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = bcd[3] ;
				b[index++] = bcd[4] ;
				b[index++] = 0 ;
			}else if(bcd.length == 6){
				b[index++] = bcd[0] ;
				b[index++] = bcd[1] ;
				b[index++] = bcd[2] ;
				b[index++] = bcd[3] ;
				b[index++] = bcd[4] ;
				b[index++] = bcd[5] ;
			}
		}
		return index ;
	}


}
