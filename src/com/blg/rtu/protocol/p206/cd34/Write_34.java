package com.blg.rtu.protocol.p206.cd34;

import java.util.HashMap;

import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_34 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 5 ;//数据域长度
	
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
		Param_34 p = (Param_34)params.get(Param_34.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int index = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;
		
		index = this.setValue(b, index, p) ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}
		
	private int setValue(byte[] b, int n , Param_34 param)throws Exception{
		Long v = param.getBindValue_0to9999999999() ;
		
		if(v == null){
			throw new Exception("出错，定值为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999999999L){
			throw new Exception("出错，定值超过其取值范围0至9999999999！") ;
		}
		byte[] bbd = ByteUtil.long2BCD_an(v) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bbd.length == 3){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = 0 ;
			b[n++] = 0 ;
		}else if(bbd.length == 4){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
			b[n++] = 0 ;
		}else if(bbd.length == 5){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
			b[n++] = bbd[2] ;
			b[n++] = bbd[3] ;
			b[n++] = bbd[4] ;
		}
		
		return n ;
	}


}