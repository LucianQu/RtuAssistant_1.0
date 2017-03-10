package com.blg.rtu.protocol.p206.cd41;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_41 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 4 ;//数据域长度
	
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
		Param_41 p = (Param_41)params.get(Param_41.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		//旧密码设置
		String setPassword = p.getOldPassword() ;
		byte[] bs = null;
		if(setPassword != null){
			bs = ByteUtil.hex2Bytes(setPassword) ;
			if(bs.length == 1){
				b[index++] = bs[0] ;
				b[index++] =  0 ;
			}else if(bs.length == 2){
				b[index++] = bs[0] ;
				b[index++] = bs[1] ;
			}
		}
		//新密码设置
			setPassword = p.getNewPassword() ;
			if(setPassword != null){
				//byte[] bcd = ByteUtil.int2BCD_an(passInt.intValue()) ;
				bs = ByteUtil.hex2Bytes(setPassword) ;
				if(bs.length == 1){
					b[index++] = bs[0] ;
					b[index++] =  0 ;
				}else if(bs.length == 2){
					b[index++] = bs[0] ;
					b[index++] = bs[1] ;
				}
			}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

	
}
