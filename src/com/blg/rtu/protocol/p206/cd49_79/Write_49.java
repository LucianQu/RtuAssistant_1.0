package com.blg.rtu.protocol.p206.cd49_79;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.*;
import com.blg.rtu.util.ByteUtil;

public class Write_49 extends ProtocolSupport{
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
							+ Constant.Bits_Password 
							+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 20;//数据域长度
	
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
		Param_49 param = (Param_49)params.get(Param_49.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}

		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

	
		Integer 
		v = param.getPlus1Partition() ;
		if(v == null){
			throw new Exception("出错，正向第一分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，正向第一分区超过其取值范围0至9999！") ;
		}
		byte[] bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getPlus2Partition() ;
		if(v == null){
			throw new Exception("出错，正向第二分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，正向第二分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getPlus3Partition() ;
		if(v == null){
			throw new Exception("出错，正向第三分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，正向第三分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getPlus4Partition() ;
		if(v == null){
			throw new Exception("出错，正向第四分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，正向第四分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getPlus5Partition() ;
		if(v == null){
			throw new Exception("出错，正向第五分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，正向第五分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getMinus1Partition() ;
		if(v == null){
			throw new Exception("出错，反向第一分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，反向第一分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getMinus2Partition() ;
		if(v == null){
			throw new Exception("出错，反向第二分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，反向第二分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getMinus3Partition() ;
		if(v == null){
			throw new Exception("出错，反向第三分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，反向第三分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getMinus4Partition() ;
		if(v == null){
			throw new Exception("出错，反向第四分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，反向第四分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		v = param.getMinus5Partition() ;
		if(v == null){
			throw new Exception("出错，反向第五分区系数为空，其必须提供！") ;
		}
		if(v < 0 || v > 9999){
			throw new Exception("出错，反向第五分区超过其取值范围0至9999！") ;
		}
		bbd = ByteUtil.int2BCD_an(v.intValue()) ;
		if(bbd.length == 1){
			b[n++] = bbd[0] ;
			b[n++] = 0 ;
 		}else if(bbd.length == 2){
			b[n++] = bbd[0] ;
			b[n++] = bbd[1] ;
 		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}
}
