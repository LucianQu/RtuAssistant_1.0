package com.blg.rtu.protocol.p206.cd82_;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_82_WaterTemperature extends ProtocolSupport {
	private static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 2;// 数据域长度

	/**
	 * 构造RTU 命令
	 * 
	 * @param code  功能码
	 * @param controlFunCode 控制域功能码
	 * @param rtuId 终端ID
	 * @param params 参数
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, Param_82_WaterTemperature param, String password) throws Exception {
		// ///////////////////////////
		// 构造数据
		byte[] b = new byte[len + 4];//4字节状态与报警数据字节

		int n = this.createDownDataHead(rtuId, code, b, len, controlFunCode);

		Double value = param.getValue_0to99d9();
		if (value == null) {
			throw new Exception("出错，水温不能为空。");
		}
		if (value < 0 || value > 99.9) {
			throw new Exception("出错，充值水量只能取0至99.9间的数据。");
		}

		Long intV = Double.valueOf(value * 10.0).longValue();
		byte[] bb = ByteUtil.long2BCD_an(intV);
		if (bb.length == 1) {
			b[n++] = bb[0];
			b[n++] = 0;
		} else if (bb.length == 2) {
			b[n++] = bb[0];
			b[n++] = bb[1];
		} 

		this.createDownDataTail(b, password);

		return b;
	}

}