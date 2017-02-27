package com.blg.rtu.protocol.p206.cd44_74;

import java.util.HashMap;

import com.blg.rtu.protocol.p206.common.*;
import com.blg.rtu.protocol.p206.util.Constant;

public class Write_44 extends ProtocolSupport{

	private static final int len = Constant.Bits_Head 
										+ Constant.Bits_Control
										+ Constant.Bits_RTU_ID 
										+ Constant.Bits_Code 
										+ Constant.Bits_Password 
										+ Constant.Bits_Time 
										+ Constant.Bits_CRC
										+ Constant.Bits_Tail 
										+ 10 ;//数据域长度

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
		Param_44 param = (Param_44)params.get(Param_44.KEY) ;
		if(param == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		/////////////////////////////
		//构造数据
		byte[] b = new byte[len];
		
		int fromSite = this.createDownDataHead(rtuId, code, b, len, controlFunCode) ;

		String newId = param.getNewId() ;
		String hexNewId = param.getHexNewId() ;
		int selectId = param.getSelectPosition() ;
		if(newId != null){
			//b = new RtuIdProtocol().createRtuId(b, newId, fromSite);
			b = new RtuIdProtocol().createSelectRtuId(b, selectId, newId, fromSite);
		}else if(hexNewId != null){
			b = new RtuIdProtocol().createRtuId_hex(b, hexNewId, fromSite);
		}else{
			throw new Exception("出错，未提供终端新地址！") ;
		}
		
		this.createDownDataTail(b, password) ;
		
		return b;
	}

}
