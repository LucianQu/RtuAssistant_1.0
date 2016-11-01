package com.blg.rtu.protocol.p206.cd19_59;

import java.io.Serializable;


public class Param_19 implements Serializable{
	
	private static final long serialVersionUID = 201212041832001L;
	
	public static final String KEY = Param_19.class.getName() ;

	public Integer D0_has_ShuiWen_1or0 ; // D0 水温 ℃ N(3，1)
	public Integer D1_has_PH_1or0 ; // D1 pH 值 N（4，2）
	public Integer D2_has_RongJieYang_1or0 ; // D2 溶解氧 mg/L N（4，1） 
	public Integer D3_has_GaoMengSuanYan_1or0 ; // D3高锰酸盐指数	mg/L N（4，1） 
	public Integer D4_has_DianDaoLu_1or0 ; // D4 电导率 μs/cm N（5） 
	public Integer D5_has_YangHuaHuanYuanDianWei_1or0 ; // D5 氧化还原电位	mv N（5，1） 
	public Integer D6_has_ZhuoDu_1or0 ; // D6 浊度 度N（3） 
	public Integer D7_has_HuaXueXuYangLiang_1or0 ; // D7 化学需氧量 mg/L N（7，1） 
	public Integer D8_has_WuRiShengHuaXuYangLiang_1or0 ; // D8 五日生化需氧量mg/L N（5，1） 
	public Integer D9_has_AnDan_1or0 ; // D9 氨氮 mg/L N（6，2） 
	public Integer D10_has_ZhongDan_1or0 ; // D10 总氮 mg/L N（5，2）
	public Integer D11_has_Tong_1or0 ; // D11 铜 mg/L N（7，4） 
	public Integer D12_has_Xin_1or0 ; // D12 锌 mg/L N（6，4） 
	public Integer D13_has_FuHuaWu_1or0 ; // D13 氟化物 mg/L N（5，2） 
	public Integer D14_has_Xi_1or0 ; // D14 硒 mg/L N（7，5） 
	public Integer D15_has_Shen_1or0 ; // D15 砷 mg/L N（7，5） 
	public Integer D16_has_Gong_1or0 ; // D16 汞 mg/L N（7，5） 
	public Integer D17_has_Ge_1or0 ; // D17 镉 mg/L N（7，5） 
	public Integer D18_has_LuJianGe_1or0 ; // D18 六价铬 mg/L N（5，3）
	public Integer D19_has_Qian_1or0 ; // D19 铅 mg/L N（7，5）
	public Integer D20_has_QingHuaWu_1or0 ; // D20 氰化物 mg/L N（5，3）
	public Integer D21_has_HuiFaFen_1or0 ; // D21 挥发酚 mg/L N（5，3）
	public Integer D22_has_BenFen_1or0 ; // D22 苯酚 mg/L N（5，2）
	public Integer D23_has_LiuHuaWu_1or0 ; // D23 硫化物 mg/L N（5，3）
	public Integer D24_has_FenDaChangJunQun_1or0 ; // D24 粪大肠菌群个／L N（10）
	public Integer D25_has_LiuSuanYan_1or0 ; // D25 硫酸盐 mg/L N（6，2）
	public Integer D26_has_LuHuaWu_1or0 ; // D26 氯化物 mg/L N（8，2）
	public Integer D27_has_XiaoSuanYanDan_1or0 ; // D27 硝酸盐氮 mg/L N（5，2）
	public Integer D28_has_Die_1or0 ; // D28 铁 mg/L N（4，2）
	public Integer D29_has_Meng_1or0 ; // D29 锰 mg/L N（4，2）
	public Integer D30_has_ShiYouLei_1or0 ; // D30 石油类 mg/L N（4，2）
	public Integer D31_has_YinLiZhiBiaoMianHuoXingJi_1or0 ; // D31 阴离子表面活性剂mg/L N（4，2）
	public Integer D32_has_LiuLiuLiu_1or0 ; // D32 六六六 mg/L N（7，6）
	public Integer D33_has_DiDiTi_1or0 ; // D33 滴滴涕 mg/L N（7，6）
	public Integer D34_has_YouJiLuNongYao_1or0 ; // D34 有机氯农药 mg/L N（7，6）
	
	
	public Double D0_value_ShuiWen_0to99d9 ; // D0 水温 ℃ N(3，1)
	public Double D1_value_PH_0to99d99 ; // D1 pH 值 N（4，2）
	public Double D2_value_RongJieYang_0to999d9 ; // D2 溶解氧 mg/L N（4，1） 
	public Double D3_value_GaoMengSuanYan_0to999d9 ; // D3高锰酸盐指数	mg/L N（4，1） 
	public Integer D4_value_DianDaoLu_0to99999 ; // D4 电导率 μs/cm N（5） 
	public Double D5_value_YangHuaHuanYuanDianWei_0to9999d9 ; // D5 氧化还原电位	mv N（5，1） 
	public Integer D6_value_ZhuoDu_0to999 ; // D6 浊度 度N（3） 
	public Double D7_value_HuaXueXuYangLiang_0to999999d9 ; // D7 化学需氧量 mg/L N（7，1） 
	public Double D8_value_WuRiShengHuaXuYangLiang_0to9999d9 ; // D8 五日生化需氧量mg/L N（5，1） 
	public Double D9_value_AnDan_0to9999d99 ; // D9 氨氮 mg/L N（6，2） 
	public Double D10_value_ZhongDan_0to999d99 ; // D10 总氮 mg/L N（5，2）
	public Double D11_value_Tong_0to999d9999 ; // D11 铜 mg/L N（7，4） 
	public Double D12_value_Xin_0to99d9999 ; // D12 锌 mg/L N（6，4） 
	public Double D13_value_FuHuaWu_0to999d99 ; // D13 氟化物 mg/L N（5，2） 
	public Double D14_value_Xi_0to99d99999 ; // D14 硒 mg/L N（7，5） 
	public Double D15_value_Shen_0to99d99999 ; // D15 砷 mg/L N（7，5） 
	public Double D16_value_Gong_0to99d99999 ; // D16 汞 mg/L N（7，5） 
	public Double D17_value_Ge_0to99d99999 ; // D17 镉 mg/L N（7，5） 
	public Double D18_value_LuJianGe_0to99d999 ; // D18 六价铬 mg/L N（5，3）
	public Double D19_value_Qian_0to99d99999 ; // D19 铅 mg/L N（7，5）
	public Double D20_value_QingHuaWu_0to99d999 ; // D20 氰化物 mg/L N（5，3）
	public Double D21_value_HuiFaFen_0to99d999 ; // D21 挥发酚 mg/L N（5，3）
	public Double D22_value_BenFen_0to999d99 ; // D22 苯酚 mg/L N（5，2）
	public Double D23_value_LiuHuaWu_0to99d999 ; // D23 硫化物 mg/L N（5，3）
	public Integer D24_value_FenDaChangJunQun_0to9999999999 ; // D24 粪大肠菌群个／L N（10）
	public Double D25_value_LiuSuanYan_0to9999d99 ; // D25 硫酸盐 mg/L N（6，2）
	public Double D26_value_LuHuaWu_0to999999d99 ; // D26 氯化物 mg/L N（8，2）
	public Double D27_value_XiaoSuanYanDan_0to999d99 ; // D27 硝酸盐氮 mg/L N（5，2）
	public Double D28_value_Die_0to99d99 ; // D28 铁 mg/L N（4，2）
	public Double D29_value_Meng_0to99d99 ; // D29 锰 mg/L N（4，2）
	public Double D30_value_ShiYouLei_0to99d99 ; // D30 石油类 mg/L N（4，2）
	public Double D31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99 ; // D31 阴离子表面活性剂mg/L N（4，2）
	public Double D32_value_LiuLiuLiu_0to9d999999 ; // D32 六六六 mg/L N（7，6）
	public Double D33_value_DiDiTi_0to9d999999 ; // D33 滴滴涕 mg/L N（7，6）
	public Double D34_value_YouJiLuNongYao_0to9d999999 ; // D34 有机氯农药 mg/L N（7，6）
	
	
	public String toString(){
		String s = "\n水质参数种类、上限值：\n" ;
		if(D0_has_ShuiWen_1or0 != null && D0_has_ShuiWen_1or0.intValue() == 1){
			s += " 包含D0水温，其上限为：" + D0_value_ShuiWen_0to99d9 + " ℃ N(3，1)\n" ;
		}
		if(D1_has_PH_1or0 != null && D1_has_PH_1or0.intValue() == 1){
			s += " 包含D1 pH值 ，其上限为：" + D1_value_PH_0to99d99 + " N（4，2）\n" ;
		}
		if(D2_has_RongJieYang_1or0 != null && D2_has_RongJieYang_1or0.intValue() == 1){ 
			s += " 包含D2 溶解氧，其上限为：" + D2_value_RongJieYang_0to999d9 + " mg/L N（4，1）\n" ;
		}
		if(D3_has_GaoMengSuanYan_1or0 != null && D3_has_GaoMengSuanYan_1or0.intValue() == 1){
			s += " 包含D3高锰酸盐指数，其上限为：" + D3_value_GaoMengSuanYan_0to999d9 + " mg/L N（4，1）\n" ;
		}
		if(D4_has_DianDaoLu_1or0 != null && D4_has_DianDaoLu_1or0.intValue() == 1){
			s += " 包含D4 电导率，其上限为：" + D4_value_DianDaoLu_0to99999 + " μs/cm N（5）\n" ;
		}
		if(D5_has_YangHuaHuanYuanDianWei_1or0 != null && D5_has_YangHuaHuanYuanDianWei_1or0.intValue() == 1){ 
			s += " 包含D5 氧化还原电位，其上限为：" + D5_value_YangHuaHuanYuanDianWei_0to9999d9 + " mv N（5，1）\n" ;
		}
		if(D6_has_ZhuoDu_1or0 != null && D6_has_ZhuoDu_1or0.intValue() == 1){
			s += " 包含D6 浊度，其上限为：" + D6_value_ZhuoDu_0to999 + " 度N（3）\n" ;
		}
		if(D7_has_HuaXueXuYangLiang_1or0 != null && D7_has_HuaXueXuYangLiang_1or0.intValue() == 1){ 
			s += " 包含D7 化学需氧量，其上限为：" + D7_value_HuaXueXuYangLiang_0to999999d9 + " mg/L N（7，1）\n" ;
		}
		if(D8_has_WuRiShengHuaXuYangLiang_1or0 != null && D8_has_WuRiShengHuaXuYangLiang_1or0.intValue() == 1){
			s += " 包含D8 五日生化需氧量，其上限为：" + D8_value_WuRiShengHuaXuYangLiang_0to9999d9 + " mg/L N（5，1）\n" ;
		}
		if(D9_has_AnDan_1or0 != null && D9_has_AnDan_1or0.intValue() == 1){  
			s += " 包含D9 氨氮，其上限为：" + D9_value_AnDan_0to9999d99 + " mg/L N（6，2）\n" ;
		}
		if(D10_has_ZhongDan_1or0 != null && D10_has_ZhongDan_1or0.intValue() == 1){ 
			s += " 包含D10 总氮，其上限为：" + D10_value_ZhongDan_0to999d99 + " mg/L N（5，2）\n" ;
		}
		if(D11_has_Tong_1or0 != null && D11_has_Tong_1or0.intValue() == 1){  
			s += " 包含D11 铜，其上限为：" + D11_value_Tong_0to999d9999 + " mg/L N（7，4）\n" ;
		}
		if(D12_has_Xin_1or0 != null && D12_has_Xin_1or0.intValue() == 1){ 
			s += " 包含D12 锌，其上限为：" + D12_value_Xin_0to99d9999 + " mg/L N（6，4） \n" ;
		}
		if(D13_has_FuHuaWu_1or0 != null && D13_has_FuHuaWu_1or0.intValue() == 1){ 
			s += " 包含D13 氟化物，其上限为：" + D13_value_FuHuaWu_0to999d99 + " mg/L N（5，2） \n" ;
		}
		if(D14_has_Xi_1or0 != null && D14_has_Xi_1or0.intValue() == 1){  
			s += " 包含D14 硒，其上限为：" + D14_value_Xi_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D15_has_Shen_1or0 != null && D15_has_Shen_1or0.intValue() == 1){ 
			s += " 包含D15 砷，其上限为：" + D15_value_Shen_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D16_has_Gong_1or0 != null && D16_has_Gong_1or0.intValue() == 1){ 
			s += " 包含D16 汞，其上限为：" + D16_value_Gong_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D17_has_Ge_1or0 != null && D17_has_Ge_1or0.intValue() == 1){  
			s += " 包含D17 镉，其上限为：" + D17_value_Ge_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D18_has_LuJianGe_1or0 != null && D18_has_LuJianGe_1or0.intValue() == 1){ 
			s += " 包含D18 六价铬，其上限为：" + D18_value_LuJianGe_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D19_has_Qian_1or0 != null && D19_has_Qian_1or0.intValue() == 1){ 
			s += " 包含D19 铅，其上限为：" + D19_value_Qian_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D20_has_QingHuaWu_1or0 != null && D20_has_QingHuaWu_1or0.intValue() == 1){ 
			s += " 包含D20 氰化物，其上限为：" + D20_value_QingHuaWu_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D21_has_HuiFaFen_1or0 != null && D21_has_HuiFaFen_1or0.intValue() == 1){ 
			s += " 包含D21 挥发酚，其上限为：" + D21_value_HuiFaFen_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D22_has_BenFen_1or0 != null && D22_has_BenFen_1or0.intValue() == 1){ 
			s += " 包含D22 苯酚，其上限为：" + D22_value_BenFen_0to999d99 + " mg/L N（5，2）\n" ;
		}
		if(D23_has_LiuHuaWu_1or0 != null && D23_has_LiuHuaWu_1or0.intValue() == 1){ 
			s += " 包含D23 硫化物，其上限为：" + D23_value_LiuHuaWu_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D24_has_FenDaChangJunQun_1or0 != null && D24_has_FenDaChangJunQun_1or0.intValue() == 1){
			s += " 包含D24 粪大肠菌群，其上限为：" + D24_value_FenDaChangJunQun_0to9999999999 + " 个／L N（10）\n" ;
		}
		if(D25_has_LiuSuanYan_1or0 != null && D25_has_LiuSuanYan_1or0.intValue() == 1){ 
			s += " 包含D25 硫酸盐，其上限为：" + D25_value_LiuSuanYan_0to9999d99 + " mg/L N（6，2）\n" ;
		}
		if(D26_has_LuHuaWu_1or0 != null && D26_has_LuHuaWu_1or0.intValue() == 1){ 
			s += " 包含D26 氯化物，其上限为：" + D26_value_LuHuaWu_0to999999d99 + " mg/L N（8，2）\n" ;
		}
		if(D27_has_XiaoSuanYanDan_1or0 != null && D27_has_XiaoSuanYanDan_1or0.intValue() == 1){ 
			s += " 包含D27 硝酸盐氮，其上限为：" + D27_value_XiaoSuanYanDan_0to999d99 + " mg/L N（5，2）\n" ;
		}
		if(D28_has_Die_1or0 != null && D28_has_Die_1or0.intValue() == 1){
			s += " 包含D28 铁 ，其上限为：" + D28_value_Die_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D29_has_Meng_1or0 != null && D29_has_Meng_1or0.intValue() == 1){ 
			s += " 包含D29 锰，其上限为：" + D29_value_Meng_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D30_has_ShiYouLei_1or0 != null && D30_has_ShiYouLei_1or0.intValue() == 1){ 
			s += " 包含D30 石油类，其上限为：" + D30_value_ShiYouLei_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D31_has_YinLiZhiBiaoMianHuoXingJi_1or0 != null && D31_has_YinLiZhiBiaoMianHuoXingJi_1or0.intValue() == 1){
			s += " 包含D31 阴离子表面活性剂，其上限为：" + D31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D32_has_LiuLiuLiu_1or0 != null && D32_has_LiuLiuLiu_1or0.intValue() == 1){ 
			s += " 包含D32 六六六，其上限为：" + D32_value_LiuLiuLiu_0to9d999999 + " mg/L N（7，6）\n" ;
		}
		if(D33_has_DiDiTi_1or0 != null && D33_has_DiDiTi_1or0.intValue() == 1){ 
			s += " 包含D33 滴滴涕，其上限为：" + D33_value_DiDiTi_0to9d999999 + " mg/L N（7，6）\n" ;
		}
		if(D34_has_YouJiLuNongYao_1or0 != null && D34_has_YouJiLuNongYao_1or0.intValue() == 1){ 
			s += " 包含D34 有机氯农药，其上限为：" + D34_value_YouJiLuNongYao_0to9d999999 + " mg/L N（7，6）\n" ;
		}
		
		return s ;
	}


	public Integer getD0_has_ShuiWen_1or0() {
		return D0_has_ShuiWen_1or0;
	}


	public void setD0_has_ShuiWen_1or0(Integer d0HasShuiWen_1or0) {
		D0_has_ShuiWen_1or0 = d0HasShuiWen_1or0;
	}


	public Integer getD1_has_PH_1or0() {
		return D1_has_PH_1or0;
	}


	public void setD1_has_PH_1or0(Integer d1HasPH_1or0) {
		D1_has_PH_1or0 = d1HasPH_1or0;
	}


	public Integer getD2_has_RongJieYang_1or0() {
		return D2_has_RongJieYang_1or0;
	}


	public void setD2_has_RongJieYang_1or0(Integer d2HasRongJieYang_1or0) {
		D2_has_RongJieYang_1or0 = d2HasRongJieYang_1or0;
	}


	public Integer getD3_has_GaoMengSuanYan_1or0() {
		return D3_has_GaoMengSuanYan_1or0;
	}


	public void setD3_has_GaoMengSuanYan_1or0(Integer d3HasGaoMengSuanYan_1or0) {
		D3_has_GaoMengSuanYan_1or0 = d3HasGaoMengSuanYan_1or0;
	}


	public Integer getD4_has_DianDaoLu_1or0() {
		return D4_has_DianDaoLu_1or0;
	}


	public void setD4_has_DianDaoLu_1or0(Integer d4HasDianDaoLu_1or0) {
		D4_has_DianDaoLu_1or0 = d4HasDianDaoLu_1or0;
	}


	public Integer getD5_has_YangHuaHuanYuanDianWei_1or0() {
		return D5_has_YangHuaHuanYuanDianWei_1or0;
	}


	public void setD5_has_YangHuaHuanYuanDianWei_1or0(
			Integer d5HasYangHuaHuanYuanDianWei_1or0) {
		D5_has_YangHuaHuanYuanDianWei_1or0 = d5HasYangHuaHuanYuanDianWei_1or0;
	}


	public Integer getD6_has_ZhuoDu_1or0() {
		return D6_has_ZhuoDu_1or0;
	}


	public void setD6_has_ZhuoDu_1or0(Integer d6HasZhuoDu_1or0) {
		D6_has_ZhuoDu_1or0 = d6HasZhuoDu_1or0;
	}


	public Integer getD7_has_HuaXueXuYangLiang_1or0() {
		return D7_has_HuaXueXuYangLiang_1or0;
	}


	public void setD7_has_HuaXueXuYangLiang_1or0(Integer d7HasHuaXueXuYangLiang_1or0) {
		D7_has_HuaXueXuYangLiang_1or0 = d7HasHuaXueXuYangLiang_1or0;
	}


	public Integer getD8_has_WuRiShengHuaXuYangLiang_1or0() {
		return D8_has_WuRiShengHuaXuYangLiang_1or0;
	}


	public void setD8_has_WuRiShengHuaXuYangLiang_1or0(
			Integer d8HasWuRiShengHuaXuYangLiang_1or0) {
		D8_has_WuRiShengHuaXuYangLiang_1or0 = d8HasWuRiShengHuaXuYangLiang_1or0;
	}


	public Integer getD9_has_AnDan_1or0() {
		return D9_has_AnDan_1or0;
	}


	public void setD9_has_AnDan_1or0(Integer d9HasAnDan_1or0) {
		D9_has_AnDan_1or0 = d9HasAnDan_1or0;
	}


	public Integer getD10_has_ZhongDan_1or0() {
		return D10_has_ZhongDan_1or0;
	}


	public void setD10_has_ZhongDan_1or0(Integer d10HasZhongDan_1or0) {
		D10_has_ZhongDan_1or0 = d10HasZhongDan_1or0;
	}


	public Integer getD11_has_Tong_1or0() {
		return D11_has_Tong_1or0;
	}


	public void setD11_has_Tong_1or0(Integer d11HasTong_1or0) {
		D11_has_Tong_1or0 = d11HasTong_1or0;
	}


	public Integer getD12_has_Xin_1or0() {
		return D12_has_Xin_1or0;
	}


	public void setD12_has_Xin_1or0(Integer d12HasXin_1or0) {
		D12_has_Xin_1or0 = d12HasXin_1or0;
	}


	public Integer getD13_has_FuHuaWu_1or0() {
		return D13_has_FuHuaWu_1or0;
	}


	public void setD13_has_FuHuaWu_1or0(Integer d13HasFuHuaWu_1or0) {
		D13_has_FuHuaWu_1or0 = d13HasFuHuaWu_1or0;
	}


	public Integer getD14_has_Xi_1or0() {
		return D14_has_Xi_1or0;
	}


	public void setD14_has_Xi_1or0(Integer d14HasXi_1or0) {
		D14_has_Xi_1or0 = d14HasXi_1or0;
	}


	public Integer getD15_has_Shen_1or0() {
		return D15_has_Shen_1or0;
	}


	public void setD15_has_Shen_1or0(Integer d15HasShen_1or0) {
		D15_has_Shen_1or0 = d15HasShen_1or0;
	}


	public Integer getD16_has_Gong_1or0() {
		return D16_has_Gong_1or0;
	}


	public void setD16_has_Gong_1or0(Integer d16HasGong_1or0) {
		D16_has_Gong_1or0 = d16HasGong_1or0;
	}


	public Integer getD17_has_Ge_1or0() {
		return D17_has_Ge_1or0;
	}


	public void setD17_has_Ge_1or0(Integer d17HasGe_1or0) {
		D17_has_Ge_1or0 = d17HasGe_1or0;
	}


	public Integer getD18_has_LuJianGe_1or0() {
		return D18_has_LuJianGe_1or0;
	}


	public void setD18_has_LuJianGe_1or0(Integer d18HasLuJianGe_1or0) {
		D18_has_LuJianGe_1or0 = d18HasLuJianGe_1or0;
	}


	public Integer getD19_has_Qian_1or0() {
		return D19_has_Qian_1or0;
	}


	public void setD19_has_Qian_1or0(Integer d19HasQian_1or0) {
		D19_has_Qian_1or0 = d19HasQian_1or0;
	}


	public Integer getD20_has_QingHuaWu_1or0() {
		return D20_has_QingHuaWu_1or0;
	}


	public void setD20_has_QingHuaWu_1or0(Integer d20HasQingHuaWu_1or0) {
		D20_has_QingHuaWu_1or0 = d20HasQingHuaWu_1or0;
	}


	public Integer getD21_has_HuiFaFen_1or0() {
		return D21_has_HuiFaFen_1or0;
	}


	public void setD21_has_HuiFaFen_1or0(Integer d21HasHuiFaFen_1or0) {
		D21_has_HuiFaFen_1or0 = d21HasHuiFaFen_1or0;
	}


	public Integer getD22_has_BenFen_1or0() {
		return D22_has_BenFen_1or0;
	}


	public void setD22_has_BenFen_1or0(Integer d22HasBenFen_1or0) {
		D22_has_BenFen_1or0 = d22HasBenFen_1or0;
	}


	public Integer getD23_has_LiuHuaWu_1or0() {
		return D23_has_LiuHuaWu_1or0;
	}


	public void setD23_has_LiuHuaWu_1or0(Integer d23HasLiuHuaWu_1or0) {
		D23_has_LiuHuaWu_1or0 = d23HasLiuHuaWu_1or0;
	}


	public Integer getD24_has_FenDaChangJunQun_1or0() {
		return D24_has_FenDaChangJunQun_1or0;
	}


	public void setD24_has_FenDaChangJunQun_1or0(Integer d24HasFenDaChangJunQun_1or0) {
		D24_has_FenDaChangJunQun_1or0 = d24HasFenDaChangJunQun_1or0;
	}


	public Integer getD25_has_LiuSuanYan_1or0() {
		return D25_has_LiuSuanYan_1or0;
	}


	public void setD25_has_LiuSuanYan_1or0(Integer d25HasLiuSuanYan_1or0) {
		D25_has_LiuSuanYan_1or0 = d25HasLiuSuanYan_1or0;
	}


	public Integer getD26_has_LuHuaWu_1or0() {
		return D26_has_LuHuaWu_1or0;
	}


	public void setD26_has_LuHuaWu_1or0(Integer d26HasLuHuaWu_1or0) {
		D26_has_LuHuaWu_1or0 = d26HasLuHuaWu_1or0;
	}


	public Integer getD27_has_XiaoSuanYanDan_1or0() {
		return D27_has_XiaoSuanYanDan_1or0;
	}


	public void setD27_has_XiaoSuanYanDan_1or0(Integer d27HasXiaoSuanYanDan_1or0) {
		D27_has_XiaoSuanYanDan_1or0 = d27HasXiaoSuanYanDan_1or0;
	}


	public Integer getD28_has_Die_1or0() {
		return D28_has_Die_1or0;
	}


	public void setD28_has_Die_1or0(Integer d28HasDie_1or0) {
		D28_has_Die_1or0 = d28HasDie_1or0;
	}


	public Integer getD29_has_Meng_1or0() {
		return D29_has_Meng_1or0;
	}


	public void setD29_has_Meng_1or0(Integer d29HasMeng_1or0) {
		D29_has_Meng_1or0 = d29HasMeng_1or0;
	}


	public Integer getD30_has_ShiYouLei_1or0() {
		return D30_has_ShiYouLei_1or0;
	}


	public void setD30_has_ShiYouLei_1or0(Integer d30HasShiYouLei_1or0) {
		D30_has_ShiYouLei_1or0 = d30HasShiYouLei_1or0;
	}


	public Integer getD31_has_YinLiZhiBiaoMianHuoXingJi_1or0() {
		return D31_has_YinLiZhiBiaoMianHuoXingJi_1or0;
	}


	public void setD31_has_YinLiZhiBiaoMianHuoXingJi_1or0(
			Integer d31HasYinLiZhiBiaoMianHuoXingJi_1or0) {
		D31_has_YinLiZhiBiaoMianHuoXingJi_1or0 = d31HasYinLiZhiBiaoMianHuoXingJi_1or0;
	}


	public Integer getD32_has_LiuLiuLiu_1or0() {
		return D32_has_LiuLiuLiu_1or0;
	}


	public void setD32_has_LiuLiuLiu_1or0(Integer d32HasLiuLiuLiu_1or0) {
		D32_has_LiuLiuLiu_1or0 = d32HasLiuLiuLiu_1or0;
	}


	public Integer getD33_has_DiDiTi_1or0() {
		return D33_has_DiDiTi_1or0;
	}


	public void setD33_has_DiDiTi_1or0(Integer d33HasDiDiTi_1or0) {
		D33_has_DiDiTi_1or0 = d33HasDiDiTi_1or0;
	}


	public Integer getD34_has_YouJiLuNongYao_1or0() {
		return D34_has_YouJiLuNongYao_1or0;
	}


	public void setD34_has_YouJiLuNongYao_1or0(Integer d34HasYouJiLuNongYao_1or0) {
		D34_has_YouJiLuNongYao_1or0 = d34HasYouJiLuNongYao_1or0;
	}


	public Double getD0_value_ShuiWen_0to99d9() {
		return D0_value_ShuiWen_0to99d9;
	}


	public void setD0_value_ShuiWen_0to99d9(Double d0ValueShuiWen_0to999d9) {
		D0_value_ShuiWen_0to99d9 = d0ValueShuiWen_0to999d9;
	}


	public Double getD1_value_PH_0to99d99() {
		return D1_value_PH_0to99d99;
	}


	public void setD1_value_PH_0to99d99(Double d1ValuePH_0to9999d99) {
		D1_value_PH_0to99d99 = d1ValuePH_0to9999d99;
	}


	public Double getD2_value_RongJieYang_0to999d9() {
		return D2_value_RongJieYang_0to999d9;
	}


	public void setD2_value_RongJieYang_0to999d9(
			Double d2ValueRongJieYang_0to9999d9) {
		D2_value_RongJieYang_0to999d9 = d2ValueRongJieYang_0to9999d9;
	}


	public Double getD3_value_GaoMengSuanYan_0to999d9() {
		return D3_value_GaoMengSuanYan_0to999d9;
	}


	public void setD3_value_GaoMengSuanYan_0to999d9(
			Double d3ValueGaoMengSuanYan_0to9999d9) {
		D3_value_GaoMengSuanYan_0to999d9 = d3ValueGaoMengSuanYan_0to9999d9;
	}


	public Integer getD4_value_DianDaoLu_0to99999() {
		return D4_value_DianDaoLu_0to99999;
	}


	public void setD4_value_DianDaoLu_0to99999(Integer d4ValueDianDaoLu_0to99999) {
		D4_value_DianDaoLu_0to99999 = d4ValueDianDaoLu_0to99999;
	}


	public Double getD5_value_YangHuaHuanYuanDianWei_0to9999d9() {
		return D5_value_YangHuaHuanYuanDianWei_0to9999d9;
	}


	public void setD5_value_YangHuaHuanYuanDianWei_0to9999d9(
			Double d5ValueYangHuaHuanYuanDianWei_0to99999d9) {
		D5_value_YangHuaHuanYuanDianWei_0to9999d9 = d5ValueYangHuaHuanYuanDianWei_0to99999d9;
	}


	public Integer getD6_value_ZhuoDu_0to999() {
		return D6_value_ZhuoDu_0to999;
	}


	public void setD6_value_ZhuoDu_0to999(Integer d6ValueZhuoDu_0to999) {
		D6_value_ZhuoDu_0to999 = d6ValueZhuoDu_0to999;
	}


	public Double getD7_value_HuaXueXuYangLiang_0to999999d9() {
		return D7_value_HuaXueXuYangLiang_0to999999d9;
	}


	public void setD7_value_HuaXueXuYangLiang_0to999999d9(
			Double d7ValueHuaXueXuYangLiang_0to9999999d9) {
		D7_value_HuaXueXuYangLiang_0to999999d9 = d7ValueHuaXueXuYangLiang_0to9999999d9;
	}


	public Double getD8_value_WuRiShengHuaXuYangLiang_0to9999d9() {
		return D8_value_WuRiShengHuaXuYangLiang_0to9999d9;
	}


	public void setD8_value_WuRiShengHuaXuYangLiang_0to9999d9(
			Double d8ValueWuRiShengHuaXuYangLiang_0to99999d9) {
		D8_value_WuRiShengHuaXuYangLiang_0to9999d9 = d8ValueWuRiShengHuaXuYangLiang_0to99999d9;
	}


	public Double getD9_value_AnDan_0to9999d99() {
		return D9_value_AnDan_0to9999d99;
	}


	public void setD9_value_AnDan_0to9999d99(Double d9ValueAnDan_0to999999d99) {
		D9_value_AnDan_0to9999d99 = d9ValueAnDan_0to999999d99;
	}


	public Double getD10_value_ZhongDan_0to999d99() {
		return D10_value_ZhongDan_0to999d99;
	}


	public void setD10_value_ZhongDan_0to999d99(
			Double d10ValueZhongDan_0to99999d99) {
		D10_value_ZhongDan_0to999d99 = d10ValueZhongDan_0to99999d99;
	}


	public Double getD11_value_Tong_0to999d9999() {
		return D11_value_Tong_0to999d9999;
	}


	public void setD11_value_Tong_0to999d9999(
			Double d11ValueTong_0to9999999d9999) {
		D11_value_Tong_0to999d9999 = d11ValueTong_0to9999999d9999;
	}


	public Double getD12_value_Xin_0to99d9999() {
		return D12_value_Xin_0to99d9999;
	}


	public void setD12_value_Xin_0to99d9999(Double d12ValueXin_0to999999d9999) {
		D12_value_Xin_0to99d9999 = d12ValueXin_0to999999d9999;
	}


	public Double getD13_value_FuHuaWu_0to999d99() {
		return D13_value_FuHuaWu_0to999d99;
	}


	public void setD13_value_FuHuaWu_0to999d99(Double d13ValueFuHuaWu_0to99999d99) {
		D13_value_FuHuaWu_0to999d99 = d13ValueFuHuaWu_0to99999d99;
	}


	public Double getD14_value_Xi_0to99d99999() {
		return D14_value_Xi_0to99d99999;
	}


	public void setD14_value_Xi_0to99d99999(Double d14ValueXi_0to9999999d99999) {
		D14_value_Xi_0to99d99999 = d14ValueXi_0to9999999d99999;
	}


	public Double getD15_value_Shen_0to99d99999() {
		return D15_value_Shen_0to99d99999;
	}


	public void setD15_value_Shen_0to99d99999(
			Double d15ValueShen_0to9999999d99999) {
		D15_value_Shen_0to99d99999 = d15ValueShen_0to9999999d99999;
	}


	public Double getD16_value_Gong_0to99d99999() {
		return D16_value_Gong_0to99d99999;
	}


	public void setD16_value_Gong_0to99d99999(
			Double d16ValueGong_0to9999999d99999) {
		D16_value_Gong_0to99d99999 = d16ValueGong_0to9999999d99999;
	}


	public Double getD17_value_Ge_0to99d99999() {
		return D17_value_Ge_0to99d99999;
	}


	public void setD17_value_Ge_0to99d99999(Double d17ValueGe_0to9999999d99999) {
		D17_value_Ge_0to99d99999 = d17ValueGe_0to9999999d99999;
	}


	public Double getD18_value_LuJianGe_0to99d999() {
		return D18_value_LuJianGe_0to99d999;
	}


	public void setD18_value_LuJianGe_0to99d999(
			Double d18ValueLuJianGe_0to99999d999) {
		D18_value_LuJianGe_0to99d999 = d18ValueLuJianGe_0to99999d999;
	}


	public Double getD19_value_Qian_0to99d99999() {
		return D19_value_Qian_0to99d99999;
	}


	public void setD19_value_Qian_0to99d99999(
			Double d19ValueQian_0to9999999d99999) {
		D19_value_Qian_0to99d99999 = d19ValueQian_0to9999999d99999;
	}


	public Double getD20_value_QingHuaWu_0to99d999() {
		return D20_value_QingHuaWu_0to99d999;
	}


	public void setD20_value_QingHuaWu_0to99d999(
			Double d20ValueQingHuaWu_0to99999d999) {
		D20_value_QingHuaWu_0to99d999 = d20ValueQingHuaWu_0to99999d999;
	}


	public Double getD21_value_HuiFaFen_0to99d999() {
		return D21_value_HuiFaFen_0to99d999;
	}


	public void setD21_value_HuiFaFen_0to99d999(
			Double d21ValueHuiFaFen_0to99999d999) {
		D21_value_HuiFaFen_0to99d999 = d21ValueHuiFaFen_0to99999d999;
	}


	public Double getD22_value_BenFen_0to999d99() {
		return D22_value_BenFen_0to999d99;
	}


	public void setD22_value_BenFen_0to999d99(Double d22ValueBenFen_0to99999d99) {
		D22_value_BenFen_0to999d99 = d22ValueBenFen_0to99999d99;
	}


	public Double getD23_value_LiuHuaWu_0to99d999() {
		return D23_value_LiuHuaWu_0to99d999;
	}


	public void setD23_value_LiuHuaWu_0to99d999(
			Double d23ValueLiuHuaWu_0to99999d999) {
		D23_value_LiuHuaWu_0to99d999 = d23ValueLiuHuaWu_0to99999d999;
	}


	public Integer getD24_value_FenDaChangJunQun_0to9999999999() {
		return D24_value_FenDaChangJunQun_0to9999999999;
	}


	public void setD24_value_FenDaChangJunQun_0to9999999999(
			Integer d24ValueFenDaChangJunQun_0to9999999999) {
		D24_value_FenDaChangJunQun_0to9999999999 = d24ValueFenDaChangJunQun_0to9999999999;
	}


	public Double getD25_value_LiuSuanYan_0to9999d99() {
		return D25_value_LiuSuanYan_0to9999d99;
	}


	public void setD25_value_LiuSuanYan_0to9999d99(
			Double d25ValueLiuSuanYan_0to999999d99) {
		D25_value_LiuSuanYan_0to9999d99 = d25ValueLiuSuanYan_0to999999d99;
	}


	public Double getD26_value_LuHuaWu_0to999999d99() {
		return D26_value_LuHuaWu_0to999999d99;
	}


	public void setD26_value_LuHuaWu_0to999999d99(
			Double d26ValueLuHuaWu_0to99999999d99) {
		D26_value_LuHuaWu_0to999999d99 = d26ValueLuHuaWu_0to99999999d99;
	}


	public Double getD27_value_XiaoSuanYanDan_0to999d99() {
		return D27_value_XiaoSuanYanDan_0to999d99;
	}


	public void setD27_value_XiaoSuanYanDan_0to999d99(
			Double d27ValueXiaoSuanYanDan_0to999999d99) {
		D27_value_XiaoSuanYanDan_0to999d99 = d27ValueXiaoSuanYanDan_0to999999d99;
	}


	public Double getD28_value_Die_0to99d99() {
		return D28_value_Die_0to99d99;
	}


	public void setD28_value_Die_0to99d99(Double d28ValueDie_0to99999d99) {
		D28_value_Die_0to99d99 = d28ValueDie_0to99999d99;
	}


	public Double getD29_value_Meng_0to99d99() {
		return D29_value_Meng_0to99d99;
	}


	public void setD29_value_Meng_0to99d99(Double d29ValueMeng_0to99999d99) {
		D29_value_Meng_0to99d99 = d29ValueMeng_0to99999d99;
	}


	public Double getD30_value_ShiYouLei_0to99d99() {
		return D30_value_ShiYouLei_0to99d99;
	}


	public void setD30_value_ShiYouLei_0to99d99(
			Double d30ValueShiYouLei_0to99999d99) {
		D30_value_ShiYouLei_0to99d99 = d30ValueShiYouLei_0to99999d99;
	}


	public Double getD31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99() {
		return D31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99;
	}


	public void setD31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99(
			Double d31ValueYinLiZhiBiaoMianHuoXingJi_0to99999d99) {
		D31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99 = d31ValueYinLiZhiBiaoMianHuoXingJi_0to99999d99;
	}


	public Double getD32_value_LiuLiuLiu_0to9d999999() {
		return D32_value_LiuLiuLiu_0to9d999999;
	}


	public void setD32_value_LiuLiuLiu_0to9d999999(
			Double d32ValueLiuLiuLiu_0to9999999d999999) {
		D32_value_LiuLiuLiu_0to9d999999 = d32ValueLiuLiuLiu_0to9999999d999999;
	}


	public Double getD33_value_DiDiTi_0to9d999999() {
		return D33_value_DiDiTi_0to9d999999;
	}


	public void setD33_value_DiDiTi_0to9d999999(
			Double d33ValueDiDiTi_0to9999999d999999) {
		D33_value_DiDiTi_0to9d999999 = d33ValueDiDiTi_0to9999999d999999;
	}


	public Double getD34_value_YouJiLuNongYao_0to9d999999() {
		return D34_value_YouJiLuNongYao_0to9d999999;
	}


	public void setD34_value_YouJiLuNongYao_0to9d999999(
			Double d34ValueYouJiLuNongYao_0to9999999d999999) {
		D34_value_YouJiLuNongYao_0to9d999999 = d34ValueYouJiLuNongYao_0to9999999d999999;
	}




}
