package com.blg.rtu.protocol.p206.cdB1;

import java.util.HashMap;
import com.blg.rtu.util.DateTime;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.TailProtocol;
import com.blg.rtu.protocol.p206.util.Constant;

public class Read_B1  extends ProtocolSupport{
	
	private static final int len = Constant.Bits_Head 
							+ Constant.Bits_Control
							+ Constant.Bits_RTU_ID 
							+ Constant.Bits_Code 
						//	+ Constant.Bits_Password 
						//	+ Constant.Bits_Time 
							+ Constant.Bits_CRC
							+ Constant.Bits_Tail 
							+ 9 ;//数据域长度
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
		
		if(params == null || params.size() == 0){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		Param_B1 p = (Param_B1)params.get(Param_B1.KEY) ;
		if(p == null){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		String startDt = p.getStartDt() ;
		String endDt = p.getEndDt() ;
		
		if(startDt.length() != 13){
			throw new Exception("出错 ，开始日期格式不正确，正确格式举例: 1012-01-10 05 ") ;
		}
		if(endDt.length() != 13){
			throw new Exception("出错 ，开始日期格式不正确，正确格式举例: 1012-01-10 05 ") ;
		}
		
		int[] startGrp = DateTime.altYmdhms(startDt + ":00:00") ;
		int[] endGrp = DateTime.altYmdhms(endDt + ":00:00") ;

		Integer dataType = p.getDataType() ;
		
		Integer dataCount = p.getDataCount_0to15() ;
		if(dataCount < 1 || dataCount > 16){
			throw new Exception("出错 ，被查询参数的编码取值范围为1至16 ") ;
		}
		
		/////////////
		//构造数据
		byte[] b = new byte[len];
		int index = this.createDownDataHead(rtuId, code, b, len, dataType.byteValue()) ;

		b[index++] = (byte)((dataType << 4) + dataCount) ;
		
		b[index++] = ByteUtil.int2BCD_an(startGrp[3])[0] ;
		b[index++] = ByteUtil.int2BCD_an(startGrp[2])[0] ;
		b[index++] = ByteUtil.int2BCD_an(startGrp[1])[0] ;
		b[index++] = ByteUtil.int2BCD_an(startGrp[0] - 2000)[0] ;
		
		b[index++] = ByteUtil.int2BCD_an(endGrp[3])[0] ;
		b[index++] = ByteUtil.int2BCD_an(endGrp[2])[0] ;
		b[index++] = ByteUtil.int2BCD_an(endGrp[1])[0] ;
		b[index++] = ByteUtil.int2BCD_an(endGrp[0] - 2000)[0] ;
		
		// 数据尾(包括CRC)
		b = new TailProtocol().createTail(b);
		return b;
	}

}