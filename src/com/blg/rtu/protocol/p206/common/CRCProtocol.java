package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.util.CRC8_for_2_0;
import com.blg.rtu.util.ByteUtil;

public class CRCProtocol {
	/**
	 * 生成CRC，并把CRC放入原字节数组中
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public byte[] bytesCrc_forRtu(byte b[], int startIndex, int endIndex) {
		CRC8_for_2_0 crc8 = new CRC8_for_2_0();
		int crc = crc8.CRC8(b , startIndex, endIndex);
		b[endIndex + 1] = (byte)crc;
		return b;
	}
	/**
	 * 生成CRC，并把两字节数组的CRC返回
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public byte byteCrc2(byte b[], int startIndex, int endIndex) {
		CRC8_for_2_0 crc8 = new CRC8_for_2_0();
		int crc = crc8.CRC8(b , startIndex, endIndex);
		return (byte)crc;
	}

	/**
	 * 校验和检查
	 * 
	 * @param b
	 * @return
	 */
	public boolean checkCrc(byte[] b, int startIndex, int endIndex, int crcIndex) throws Exception {
		byte crcb = this.byteCrc2(b, startIndex, endIndex);

		if ((crcb == b[crcIndex])) {
			return true;
		} else {
			byte[] che = new byte[] {b[crcIndex]};
			String hex = ByteUtil.bytes2Hex(new byte[]{crcb} , true);
			String hexche = ByteUtil.bytes2Hex(che , true);
			throw new Exception("校验和验证失败,放弃无效数据！" + " 计算是" + hex + " 返回是" + hexche, null);
		}
	}


}
