package com.blg.rtu.protocol.p206.cd1A_5A;

import java.util.HashMap;
import com.blg.rtu.protocol.p206.cd19_59.Write_19;

public class Write_1A  extends Write_19{

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
		Param_1A p = (Param_1A)params.get(Param_1A.KEY) ;
		if(p == null ){
			throw new Exception("出错，未提供参数Bean！") ;
		}
		return this.creatData(code, controlFunCode, rtuId, p, password) ;
	}

}
