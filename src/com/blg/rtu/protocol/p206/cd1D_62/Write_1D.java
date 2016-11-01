package com.blg.rtu.protocol.p206.cd1D_62;

import java.util.HashMap;
import java.util.TreeMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_1D extends ProtocolSupport{

	public static final int len = Constant.Bits_Head 
										+ Constant.Bits_Control
										+ Constant.Bits_RTU_ID 
										+ Constant.Bits_Code 
										+ Constant.Bits_Password 
										+ Constant.Bits_Time 
										+ Constant.Bits_CRC
										+ Constant.Bits_Tail 
										+ 0 ;//数据域长度

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
		ParamMap_1D paramMapObj = (ParamMap_1D)params.get(ParamMap_1D.KEY) ;
		if(paramMapObj == null ){
			throw new Exception("出错，未提供参数Bean集合对象！") ;
		}
		
		TreeMap<Integer , Param_1D> paramMap = paramMapObj.getParamMap() ;
		if(paramMap == null ){
			throw new Exception("出错，未提供参数Bean集合！") ;
		}
		if(paramMap.size() == 0){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		
		/////////////////////////////
		//构造数据
		int length = len + 5 * paramMap.size() ;
		byte[] b = new byte[length];
		
		int index = this.createDownDataHead(rtuId, code, b, length, controlFunCode) ;
		
		int firstKey = paramMap.firstKey() ;
		int count = 1 ;
		for(int i = firstKey ; i < (firstKey + paramMap.size()) ; i++){
			index = this.setValue(count, b, index, paramMap.get(i)) ;
			count ++ ;
		}

		this.createDownDataTail(b, password) ;
		
		return b;
	}
	private int setValue(int count , byte[] b, int n , Param_1D param)throws Exception{
		String newId = param.getRtuId() ;
		b = new RtuIdProtocol().createRtuId(b, newId, n);
		return n ;
	}
}
