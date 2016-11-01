package com.blg.rtu.protocol.p206.cd82_;


import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Write_82_WaterQuality extends ProtocolSupport {
	protected static final int len = Constant.Bits_Head 
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
	 * @param params  参数
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public byte[] create(String code, byte controlFunCode, String rtuId, Param_82_WaterQuality p, String password) throws Exception {

		byte[] tb = new byte[5 + 4 * 40 + 1];
		int n = 5;
		Double v = p.getValue_ShuiWen_0to99d9() ;
		if (v != null) {
			tb[0] = (byte)(tb[0] & 1) ;
			n = this.setDoubleValue(tb, 0, 0x1, n, v, 10);
		}
		v = p.getValue_PH_0to99d99() ;
		if (v != null) {
			tb[0] = (byte)(tb[0] & 2) ;
			n = this.setDoubleValue(tb, 0, 0x2, n, v, 100);
		}
		v = p.getValue_RongJieYang_0to999d9() ;
		if (v != null) {
			tb[0] = (byte)(tb[0] & 4) ;
			n = this.setDoubleValue(tb, 0, 0x4, n, v, 10);
		}
//		v = p.getGaoMengSuanYan_0to999d9() ;
//		if (v != null) {
//			tb[0] = (byte)(tb[0] & 8) ;
//			n = this.setDoubleValue(tb, 0, 0x8, n, v, 10);
//		}
		Integer i = p.getValue_DianDaoLu_0to99999() ;
		if (i != null) {
			tb[0] = (byte)(tb[0] & 16) ;
			n = this.setIntegerValue(tb, 0, 0x10, n, i, 4);
		}
//		v = p.getYangHuaHuanYuanDianWei_0to9999d9() ;
//		if (v != null) {
//			tb[0] = (byte)(tb[0] & 32) ;
//			n = this.setDoubleValue(tb, 0, 0x20, n, v, 10);
//		}
		i = p.getValue_ZhuoDu_0to999() ;
		if (i != null) {
			tb[0] = (byte)(tb[0] & 64) ;
			n = this.setIntegerValue(tb, 0, 0x40, n, i, 4);
		}
//		if (p.getD7_has_HuaXueXuYangLiang_1or0() != null
//				&& p.getD7_has_HuaXueXuYangLiang_1or0().intValue() == 1) {
//			tb[0] = (byte)(tb[0] & 128) ;
//			n = this.setDoubleValue(tb, 0, 0x80, n,
//					p.getD7_value_HuaXueXuYangLiang_0to999999d9(), 10);
//		}
//		if (p.getD8_has_WuRiShengHuaXuYangLiang_1or0() != null
//				&& p.getD8_has_WuRiShengHuaXuYangLiang_1or0().intValue() == 1) {
//			tb[1] = (byte)(tb[1] & 1) ;
//			n = this.setDoubleValue(tb, 1, 0x1, n,
//					p.getD8_value_WuRiShengHuaXuYangLiang_0to9999d9(), 10);
//		}
//		if (p.getD9_has_AnDan_1or0() != null
//				&& p.getD9_has_AnDan_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x2, n,
//					p.getD9_value_AnDan_0to9999d99(), 100);
//		}
//		if (p.getD10_has_ZhongDan_1or0() != null
//				&& p.getD10_has_ZhongDan_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x4, n,
//					p.getD10_value_ZhongDan_0to999d99(), 100);
//		}
//		if (p.getD11_has_Tong_1or0() != null
//				&& p.getD11_has_Tong_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x8, n,
//					p.getD11_value_Tong_0to999d9999(), 10000);
//		}
//		if (p.getD12_has_Xin_1or0() != null
//				&& p.getD12_has_Xin_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x10, n,
//					p.getD12_value_Xin_0to99d9999(), 10000);
//		}
//		if (p.getD13_has_FuHuaWu_1or0() != null
//				&& p.getD13_has_FuHuaWu_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x20, n,
//					p.getD13_value_FuHuaWu_0to999d99(), 100);
//		}
//		if (p.getD14_has_Xi_1or0() != null
//				&& p.getD14_has_Xi_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x40, n,
//					p.getD14_value_Xi_0to99d99999(), 100000);
//		}
//		if (p.getD15_has_Shen_1or0() != null
//				&& p.getD15_has_Shen_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 1, 0x80, n,
//					p.getD15_value_Shen_0to99d99999(), 100000);
//		}
//		if (p.getD16_has_Gong_1or0() != null
//				&& p.getD16_has_Gong_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x1, n,
//					p.getD16_value_Gong_0to99d99999(), 100000);
//		}
//		if (p.getD17_has_Ge_1or0() != null
//				&& p.getD17_has_Ge_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x2, n,
//					p.getD17_value_Ge_0to99d99999(), 100000);
//		}
//		if (p.getD18_has_LuJianGe_1or0() != null
//				&& p.getD18_has_LuJianGe_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x4, n,
//					p.getD18_value_LuJianGe_0to99d999(), 1000);
//		}
//		if (p.getD19_has_Qian_1or0() != null
//				&& p.getD19_has_Qian_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x8, n,
//					p.getD19_value_Qian_0to99d99999(), 100000);
//		}
//		if (p.getD20_has_QingHuaWu_1or0() != null
//				&& p.getD20_has_QingHuaWu_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x10, n,
//					p.getD20_value_QingHuaWu_0to99d999(), 1000);
//		}
//		if (p.getD21_has_HuiFaFen_1or0() != null
//				&& p.getD21_has_HuiFaFen_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x20, n,
//					p.getD21_value_HuiFaFen_0to99d999(), 1000);
//		}
//		if (p.getD22_has_BenFen_1or0() != null
//				&& p.getD22_has_BenFen_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x40, n,
//					p.getD22_value_BenFen_0to999d99(), 100);
//		}
//		if (p.getD23_has_LiuHuaWu_1or0() != null
//				&& p.getD23_has_LiuHuaWu_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 2, 0x80, n,
//					p.getD23_value_LiuHuaWu_0to99d999(), 1000);
//		}
//		if (p.getD24_has_FenDaChangJunQun_1or0() != null
//				&& p.getD24_has_FenDaChangJunQun_1or0().intValue() == 1) {
//			n = this.setIntegerValue(tb, 3, 0x1, n,
//					p.getD24_value_FenDaChangJunQun_0to9999999999(), 5);
//		}
//		if (p.getD25_has_LiuSuanYan_1or0() != null
//				&& p.getD25_has_LiuSuanYan_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x2, n,
//					p.getD25_value_LiuSuanYan_0to9999d99(), 100);
//		}
//		if (p.getD26_has_LuHuaWu_1or0() != null
//				&& p.getD26_has_LuHuaWu_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x4, n,
//					p.getD26_value_LuHuaWu_0to999999d99(), 100);
//		}
//		if (p.getD27_has_XiaoSuanYanDan_1or0() != null
//				&& p.getD27_has_XiaoSuanYanDan_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x8, n,
//					p.getD27_value_XiaoSuanYanDan_0to999d99(), 100);
//		}
//		if (p.getD28_has_Die_1or0() != null
//				&& p.getD28_has_Die_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x10, n,
//					p.getD28_value_Die_0to99d99(), 100);
//		}
//		if (p.getD29_has_Meng_1or0() != null
//				&& p.getD29_has_Meng_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x20, n,
//					p.getD29_value_Meng_0to99d99(), 100);
//		}
//		if (p.getD30_has_ShiYouLei_1or0() != null
//				&& p.getD30_has_ShiYouLei_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x40, n,
//					p.getD30_value_ShiYouLei_0to99d99(), 100);
//		}
//		if (p.getD31_has_YinLiZhiBiaoMianHuoXingJi_1or0() != null
//				&& p.getD31_has_YinLiZhiBiaoMianHuoXingJi_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 3, 0x80, n,
//					p.getD31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99(), 100);
//		}
//		if (p.getD32_has_LiuLiuLiu_1or0() != null
//				&& p.getD32_has_LiuLiuLiu_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 4, 0x1, n,
//					p.getD32_value_LiuLiuLiu_0to9d999999(), 1000000);
//		}
//		if (p.getD33_has_DiDiTi_1or0() != null
//				&& p.getD33_has_DiDiTi_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 4, 0x2, n,
//					p.getD33_value_DiDiTi_0to9d999999(), 1000000);
//		}
//		if (p.getD34_has_YouJiLuNongYao_1or0() != null
//				&& p.getD34_has_YouJiLuNongYao_1or0().intValue() == 1) {
//			n = this.setDoubleValue(tb, 4, 0x4, n,
//					p.getD34_value_YouJiLuNongYao_0to9d999999(), 1000000);
//		}

		// ///////////////////////////
		// 构造数据
		int length = len + n;
		byte[] b = new byte[length];

		int index = this.createDownDataHead(rtuId, code, b, length, controlFunCode);

		for (int j = 0; j < n; j++) {
			b[index + j] = tb[j];
		}

		this.createDownDataTail(b, password);

		return b;
	}

	protected int setDoubleValue(byte[] tb, int n1, int huoV, int n2, Double v, int chengV) throws Exception {
		Integer vi = (v == null ? 0 : Double.valueOf(v * chengV).intValue());
		return this.setIntegerValue(tb, n1, huoV, n2, vi, 4);
	}

	protected int setIntegerValue(byte[] tb, int n1, int huoV, int n2, Integer v, int intLen) throws Exception {
		tb[n1] = (byte) (tb[n1] | huoV);
		v = (v == null ? 0 : v);
		byte[] bbd = ByteUtil.int2BCD_an(v);
		if (intLen == 4) {
			if (bbd.length == 1) {
				tb[n2++] = bbd[0];
				tb[n2++] = 0;
				tb[n2++] = 0;
				tb[n2++] = 0;
			} else if (bbd.length == 2) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = 0;
				tb[n2++] = 0;
			} else if (bbd.length == 3) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = bbd[2];
				tb[n2++] = 0;
			} else if (bbd.length == 4) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = bbd[2];
				tb[n2++] = bbd[3];
			}
		} else {
			if (bbd.length == 1) {
				tb[n2++] = bbd[0];
				tb[n2++] = 0;
				tb[n2++] = 0;
				tb[n2++] = 0;
				tb[n2++] = 0;
			} else if (bbd.length == 2) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = 0;
				tb[n2++] = 0;
				tb[n2++] = 0;
			} else if (bbd.length == 3) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = bbd[2];
				tb[n2++] = 0;
				tb[n2++] = 0;
			} else if (bbd.length == 4) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = bbd[2];
				tb[n2++] = bbd[3];
				tb[n2++] = 0;
			} else if (bbd.length == 5) {
				tb[n2++] = bbd[0];
				tb[n2++] = bbd[1];
				tb[n2++] = bbd[2];
				tb[n2++] = bbd[3];
				tb[n2++] = bbd[4];
			}
		}
		return n2;
	}

}