package com.blg.rtu.protocol.p206.cdE7_F7;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_F7 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
									+ Constant.Bits_Control
									+ Constant.Bits_RTU_ID 
									+ Constant.Bits_Code 
									+ Constant.Bits_Password 
									+ Constant.Bits_Time 
									+ Constant.Bits_CRC
									+ Constant.Bits_Tail 
									+ 34 ;//数据域长度
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
		Param_F7 param = (Param_F7)params.get(Param_F7.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];

		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int enable = param.getEnable_01()==null?0:(param.getEnable_01().intValue()) ;
		enable += param.getEnable_02()==null?0:(param.getEnable_02().intValue() << 1) ;
		enable += param.getEnable_03()==null?0:(param.getEnable_03().intValue() << 2) ;
		enable += param.getEnable_04()==null?0:(param.getEnable_04().intValue() << 3) ;
		enable += param.getEnable_05()==null?0:(param.getEnable_05().intValue() << 4) ;
		enable += param.getEnable_06()==null?0:(param.getEnable_06().intValue() << 5) ;
		enable += param.getEnable_07()==null?0:(param.getEnable_07().intValue() << 6) ;
		enable += param.getEnable_08()==null?0:(param.getEnable_08().intValue() << 7) ;
		b[n++] = (byte)enable ;
		
		enable = param.getEnable_09()==null?0:(param.getEnable_09().intValue()) ;
		enable += param.getEnable_10()==null?0:(param.getEnable_10().intValue() << 1) ;
		enable += param.getEnable_11()==null?0:(param.getEnable_11().intValue() << 2) ;
		enable += param.getEnable_12()==null?0:(param.getEnable_12().intValue() << 3) ;
		enable += param.getEnable_13()==null?0:(param.getEnable_13().intValue() << 4) ;
		enable += param.getEnable_14()==null?0:(param.getEnable_14().intValue() << 5) ;
		enable += param.getEnable_15()==null?0:(param.getEnable_15().intValue() << 6) ;
		b[n++] = (byte)enable ;	
		
		byte[] bb = null ;
		Integer v = param.getValue_01_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_02_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_03_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_04_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_05_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_06_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_07_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_08_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_09_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_10_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_11_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_12_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_13_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_14_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		v = param.getValue_15_1TO999() ;
		if(v == null){
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else{
			bb = ByteUtil.int2BCD_an(v) ;
			if(bb.length == 1){
				b[n++] = bb[0] ;
				b[n++] = 0 ;
			}else if(bb.length == 2){
				b[n++] = bb[0] ;
				b[n++] = bb[1] ;
			}
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
