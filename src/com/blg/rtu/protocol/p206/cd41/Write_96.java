package com.blg.rtu.protocol.p206.cd41;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_96 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 2 ;//数据域长度
	
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
		Param_96 p = (Param_96)params.get(Param_96.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		String hexPass = p.getNewPass_hex() ;
		if(hexPass != null){
			byte[] bs = ByteUtil.hex2Bytes(hexPass) ;
			if(bs.length == 1){
				b[index++] = bs[0] ;
				b[index++] =  0 ;
			}else if(bs.length == 2){
				b[index++] = bs[1] ;
				b[index++] = bs[0] ;
			}
		}else{
			Integer passInt = p.getNewPass_0to9999() ;
			if(passInt != null){
				byte[] bcd = ByteUtil.int2BCD_an(passInt.intValue()) ;
				if(bcd.length == 1){
					b[index++] = bcd[0] ;
					b[index++] =  0 ;
				}else if(bcd.length == 2){
					b[index++] = bcd[0] ;
					b[index++] = bcd[1] ;
				}
			}
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
