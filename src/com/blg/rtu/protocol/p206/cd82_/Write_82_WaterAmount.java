package com.blg.rtu.protocol.p206.cd82_;

import java.util.TreeMap;

import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_82_WaterAmount extends ProtocolSupport {
	public static final int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code
			+ Constant.Bits_Password 
			+ Constant.Bits_Time 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail 
			+ 0;// 数据域长度

	/**
	 * 构造RTU 命令
	 * 
	 * @param code 功能码
	 * @param controlFunCode 控制域功能码
	 * @param rtuId 终端ID
	 * @param params 参数
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, Param_82_WaterAmountList param, String password) throws Exception {
		TreeMap<Integer, Param_82_WaterAmount> paramMap = param.getDataList() ;
		if (paramMap == null) {
			throw new Exception("出错，未提供参数Bean集合！");
		}
		if (paramMap.size() == 0) {
			throw new Exception("出错，未提供参数Bean！");
		}

		// ///////////////////////////
		// 构造数据
		int length = len + 5 * paramMap.size() + 4 ;//5 * paramMap.size()为累计水量数据，后+4为状态与报警位
		byte[] b = new byte[length];

		int index = this.createDownDataHead(rtuId, code, b, length, controlFunCode);

		int firstKey = paramMap.firstKey();
		int count = 1;
		for (int i = firstKey; i < (firstKey + paramMap.size()); i++) {
			index = this.setValue(count, b, index, paramMap.get(i));
			count++;
		}

		this.createDownDataTail(b, password);

		return b;
	}

	private int setValue(int count, byte[] b, int n, Param_82_WaterAmount param) throws Exception {
		boolean plus = true;
		Long v = param.getValue_0to7999999999() ;

		if (v == null) {
			throw new Exception("出错，第" + count + "累计水量为空，其必须提供！");
		}

		if (v < 0 || v > 7999999999L) {
			throw new Exception("出错，第" + count + "个累计水量取值超过其取值范围0至7999999999！");
		}

		if (v < 0.0) {
			plus = false;
			v = -v;
		}

		byte[] bb = ByteUtil.long2BCD_an(v);
		if (bb.length == 1) {
			b[n++] = bb[0];
			b[n++] = 0;
			b[n++] = 0;
			b[n++] = 0;
			b[n] = 0;
		} else if (bb.length == 2) {
			b[n++] = bb[0];
			b[n++] = bb[1];
			b[n++] = 0;
			b[n++] = 0;
			b[n] = 0;
		} else if (bb.length == 3) {
			b[n++] = bb[0];
			b[n++] = bb[1];
			b[n++] = bb[2];
			b[n++] = 0;
			b[n] = 0;
		} else if (bb.length == 4) {
			b[n++] = bb[0];
			b[n++] = bb[1];
			b[n++] = bb[2];
			b[n++] = bb[3];
			b[n] = 0;
		} else if (bb.length == 5) {
			b[n++] = bb[0];
			b[n++] = bb[1];
			b[n++] = bb[2];
			b[n++] = bb[3];
			b[n] = bb[4];
		}
		if (!plus) {
			b[n] = (byte) (b[n] | (byte) 0xF0);
		}
		n++;

		return n;
	}

}