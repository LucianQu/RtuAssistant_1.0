package com.blg.rtu.protocol.p206.cd91;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_91 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 1 ;//数据域长度
	
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
		Param_91 p = (Param_91)params.get(Param_91.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		int typ = p.getClearType().intValue() ;
		if(typ == (byte)0x64){
			//清空全部数据
			b[index] = (byte)0x64 ;
		}else if(typ == (byte)0x04){
			//清空流量
			b[index] = (byte)0x04 ;
		}else if(typ == (byte)0x20){
			//清空日志
			b[index] = (byte)0x20 ;
		}else if(typ == (byte)0x40){
			//清空事件
			b[index] = (byte)0x40 ;
		}/*else if(typ == Param_91.clearType_4.intValue()){
			//清空水温 
			b[index] = 8 ;
		}else if(typ == Param_91.clearType_5.intValue()){
			//清空水质
			b[index] = 16 ;
		}else if(typ == Param_91.clearType_6.intValue()){
			//清空日志 
			b[index] = 32 ;
		}else if(typ == Param_91.clearType_7.intValue()){
			//清空 事件
			b[index] = 64 ;
		}else if(typ == Param_91.clearType_8.intValue()){
			//清空四个中心的补报数据
			b[index] = (byte)128 ;
		}*/
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}


}
