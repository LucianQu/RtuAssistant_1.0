package com.blg.rtu.protocol.p206.cdA0_54;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;

public class Write_A0 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 2;//数据域长度
	
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
		Param_A0 param = (Param_A0)params.get(Param_A0.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}

		int value = 0 ;
		
		Integer d = param.getYuLiang_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x1 ;
		}
		
		d = param.getShuiWei_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x2 ;
		}
		
		d = param.getLiuLiang_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x4 ;
		}
		
		d = param.getLiuSu_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x8 ;
		}
		
		d = param.getZhaWei_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x10 ;
		}
		
		d = param.getGongLu_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x20 ;
		}
		
		d = param.getQiYa_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x40 ;
		}
		
		d = param.getFengSu_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x80 ;
		}
		
		byte flag1 = (byte)value ;
		
		value = 0 ;
		d = param.getShuiWen_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x1 ;
		}
		
		d = param.getShuiZhi_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x2 ;
		}
		
		d = param.getTuRang_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x4 ;
		}
		
		d = param.getZhengFa_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x8 ;
		}

		d = param.getNeiCun_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x10 ;
		}

		d = param.getGuTai_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x20 ;
		}

		d = param.getShuiYa_0or1() ;
		if(d != null && d.intValue() == 1){
			value = value | 0x40 ;
		}
		
		
		//D15备用
		
		byte flag2 = (byte)value ;
		

		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

		b[n++] = flag1 ;
		b[n++] = flag2 ;
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

}
