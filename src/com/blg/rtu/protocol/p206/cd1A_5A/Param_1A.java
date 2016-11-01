package com.blg.rtu.protocol.p206.cd1A_5A;

import com.blg.rtu.protocol.p206.cd19_59.Param_19;

public class Param_1A extends Param_19{
	
	private static final long serialVersionUID = 201212042351001L;
	
	public static final String KEY = Param_1A.class.getName() ;
	
	
	public String toString(){
		String s = "\n水质参数种类、下限值：\n" ;
		if(D0_has_ShuiWen_1or0 != null && D0_has_ShuiWen_1or0.intValue() == 1){
			s += " 包含D0水温，其下限为：" + D0_value_ShuiWen_0to99d9 + " ℃ N(3，1)\n" ;
		}
		if(D1_has_PH_1or0 != null && D1_has_PH_1or0.intValue() == 1){
			s += " 包含D1 pH值 ，其下限为：" + D1_value_PH_0to99d99 + " N（4，2）\n" ;
		}
		if(D2_has_RongJieYang_1or0 != null && D2_has_RongJieYang_1or0.intValue() == 1){ 
			s += " 包含D2 溶解氧，其下限为：" + D2_value_RongJieYang_0to999d9 + " mg/L N（4，1）\n" ;
		}
		if(D3_has_GaoMengSuanYan_1or0 != null && D3_has_GaoMengSuanYan_1or0.intValue() == 1){
			s += " 包含D3高锰酸盐指数，其下限为：" + D3_value_GaoMengSuanYan_0to999d9 + " mg/L N（4，1）\n" ;
		}
		if(D4_has_DianDaoLu_1or0 != null && D4_has_DianDaoLu_1or0.intValue() == 1){
			s += " 包含D4 电导率，其下限为：" + D4_value_DianDaoLu_0to99999 + " μs/cm N（5）\n" ;
		}
		if(D5_has_YangHuaHuanYuanDianWei_1or0 != null && D5_has_YangHuaHuanYuanDianWei_1or0.intValue() == 1){ 
			s += " 包含D5 氧化还原电位，其下限为：" + D5_value_YangHuaHuanYuanDianWei_0to9999d9 + " mv N（5，1）\n" ;
		}
		if(D6_has_ZhuoDu_1or0 != null && D6_has_ZhuoDu_1or0.intValue() == 1){
			s += " 包含D6 浊度，其下限为：" + D6_value_ZhuoDu_0to999 + " 度N（3）\n" ;
		}
		if(D7_has_HuaXueXuYangLiang_1or0 != null && D7_has_HuaXueXuYangLiang_1or0.intValue() == 1){ 
			s += " 包含D7 化学需氧量，其下限为：" + D7_value_HuaXueXuYangLiang_0to999999d9 + " mg/L N（7，1）\n" ;
		}
		if(D8_has_WuRiShengHuaXuYangLiang_1or0 != null && D8_has_WuRiShengHuaXuYangLiang_1or0.intValue() == 1){
			s += " 包含D8 五日生化需氧量，其下限为：" + D8_value_WuRiShengHuaXuYangLiang_0to9999d9 + " mg/L N（5，1）\n" ;
		}
		if(D9_has_AnDan_1or0 != null && D9_has_AnDan_1or0.intValue() == 1){  
			s += " 包含D9 氨氮，其下限为：" + D9_value_AnDan_0to9999d99 + " mg/L N（6，2）\n" ;
		}
		if(D10_has_ZhongDan_1or0 != null && D10_has_ZhongDan_1or0.intValue() == 1){ 
			s += " 包含D10 总氮，其下限为：" + D10_value_ZhongDan_0to999d99 + " mg/L N（5，2）\n" ;
		}
		if(D11_has_Tong_1or0 != null && D11_has_Tong_1or0.intValue() == 1){  
			s += " 包含D11 铜，其下限为：" + D11_value_Tong_0to999d9999 + " mg/L N（7，4）\n" ;
		}
		if(D12_has_Xin_1or0 != null && D12_has_Xin_1or0.intValue() == 1){ 
			s += " 包含D12 锌，其下限为：" + D12_value_Xin_0to99d9999 + " mg/L N（6，4） \n" ;
		}
		if(D13_has_FuHuaWu_1or0 != null && D13_has_FuHuaWu_1or0.intValue() == 1){ 
			s += " 包含D13 氟化物，其下限为：" + D13_value_FuHuaWu_0to999d99 + " mg/L N（5，2） \n" ;
		}
		if(D14_has_Xi_1or0 != null && D14_has_Xi_1or0.intValue() == 1){  
			s += " 包含D14 硒，其下限为：" + D14_value_Xi_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D15_has_Shen_1or0 != null && D15_has_Shen_1or0.intValue() == 1){ 
			s += " 包含D15 砷，其下限为：" + D15_value_Shen_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D16_has_Gong_1or0 != null && D16_has_Gong_1or0.intValue() == 1){ 
			s += " 包含D16 汞，其下限为：" + D16_value_Gong_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D17_has_Ge_1or0 != null && D17_has_Ge_1or0.intValue() == 1){  
			s += " 包含D17 镉，其下限为：" + D17_value_Ge_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D18_has_LuJianGe_1or0 != null && D18_has_LuJianGe_1or0.intValue() == 1){ 
			s += " 包含D18 六价铬，其下限为：" + D18_value_LuJianGe_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D19_has_Qian_1or0 != null && D19_has_Qian_1or0.intValue() == 1){ 
			s += " 包含D19 铅，其下限为：" + D19_value_Qian_0to99d99999 + " mg/L N（7，5）\n" ;
		}
		if(D20_has_QingHuaWu_1or0 != null && D20_has_QingHuaWu_1or0.intValue() == 1){ 
			s += " 包含D20 氰化物，其下限为：" + D20_value_QingHuaWu_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D21_has_HuiFaFen_1or0 != null && D21_has_HuiFaFen_1or0.intValue() == 1){ 
			s += " 包含D21 挥发酚，其下限为：" + D21_value_HuiFaFen_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D22_has_BenFen_1or0 != null && D22_has_BenFen_1or0.intValue() == 1){ 
			s += " 包含D22 苯酚，其下限为：" + D22_value_BenFen_0to999d99 + " mg/L N（5，2）\n" ;
		}
		if(D23_has_LiuHuaWu_1or0 != null && D23_has_LiuHuaWu_1or0.intValue() == 1){ 
			s += " 包含D23 硫化物，其下限为：" + D23_value_LiuHuaWu_0to99d999 + " mg/L N（5，3）\n" ;
		}
		if(D24_has_FenDaChangJunQun_1or0 != null && D24_has_FenDaChangJunQun_1or0.intValue() == 1){
			s += " 包含D24 粪大肠菌群，其下限为：" + D24_value_FenDaChangJunQun_0to9999999999 + " 个／L N（10）\n" ;
		}
		if(D25_has_LiuSuanYan_1or0 != null && D25_has_LiuSuanYan_1or0.intValue() == 1){ 
			s += " 包含D25 硫酸盐，其下限为：" + D25_value_LiuSuanYan_0to9999d99 + " mg/L N（6，2）\n" ;
		}
		if(D26_has_LuHuaWu_1or0 != null && D26_has_LuHuaWu_1or0.intValue() == 1){ 
			s += " 包含D26 氯化物，其下限为：" + D26_value_LuHuaWu_0to999999d99 + " mg/L N（8，2）\n" ;
		}
		if(D27_has_XiaoSuanYanDan_1or0 != null && D27_has_XiaoSuanYanDan_1or0.intValue() == 1){ 
			s += " 包含D27 硝酸盐氮，其下限为：" + D27_value_XiaoSuanYanDan_0to999d99 + " mg/L N（5，2）\n" ;
		}
		if(D28_has_Die_1or0 != null && D28_has_Die_1or0.intValue() == 1){
			s += " 包含D28 铁 ，其下限为：" + D28_value_Die_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D29_has_Meng_1or0 != null && D29_has_Meng_1or0.intValue() == 1){ 
			s += " 包含D29 锰，其下限为：" + D29_value_Meng_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D30_has_ShiYouLei_1or0 != null && D30_has_ShiYouLei_1or0.intValue() == 1){ 
			s += " 包含D30 石油类，其下限为：" + D30_value_ShiYouLei_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D31_has_YinLiZhiBiaoMianHuoXingJi_1or0 != null && D31_has_YinLiZhiBiaoMianHuoXingJi_1or0.intValue() == 1){
			s += " 包含D31 阴离子表面活性剂，其下限为：" + D31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99 + " mg/L N（4，2）\n" ;
		}
		if(D32_has_LiuLiuLiu_1or0 != null && D32_has_LiuLiuLiu_1or0.intValue() == 1){ 
			s += " 包含D32 六六六，其下限为：" + D32_value_LiuLiuLiu_0to9d999999 + " mg/L N（7，6）\n" ;
		}
		if(D33_has_DiDiTi_1or0 != null && D33_has_DiDiTi_1or0.intValue() == 1){ 
			s += " 包含D33 滴滴涕，其下限为：" + D33_value_DiDiTi_0to9d999999 + " mg/L N（7，6）\n" ;
		}
		if(D34_has_YouJiLuNongYao_1or0 != null && D34_has_YouJiLuNongYao_1or0.intValue() == 1){ 
			s += " 包含D34 有机氯农药，其下限为：" + D34_value_YouJiLuNongYao_0to9d999999 + " mg/L N（7，6）\n" ;
		}
		
		return s ;
	}

}
