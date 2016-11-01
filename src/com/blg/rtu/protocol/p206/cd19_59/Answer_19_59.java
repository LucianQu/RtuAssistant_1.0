package com.blg.rtu.protocol.p206.cd19_59;

import android.util.Log;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_19_59 extends ProtocolSupport{

	private static String tag = Answer_19_59.class.getName() ;
	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param dataCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);

		Data_59 dd = new Data_59() ;
		d.setSubData(dd) ;
		
		this.doParse(b, index, d, dd, cp) ;
		
		Log.i(tag, "分析<遥测终端水质参数种类、上限值>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	protected void doParse(byte[] b, int n, RtuData d, Data_59 dd, ControlProtocol cp) throws Exception {
		byte b1 = b[n++] ;
		byte b2 = b[n++] ;
		byte b3 = b[n++] ;
		byte b4 = b[n++] ;
		byte b5 = b[n++] ;
		
		if((b1 & 0x1) == 0x1){
			dd.setD0_has_ShuiWen_1or0(1) ; 
			dd.setD0_value_ShuiWen_0to99d9(ByteUtil.BCD2Int_an(b, n, n + 3)/10.0) ;
			n += 4 ;
		}else{
			dd.setD0_has_ShuiWen_1or0(0) ; 
		}
		if((b1 & 0x2) == 0x2){
			dd.setD1_has_PH_1or0(1) ;  
			dd.setD1_value_PH_0to99d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD1_has_PH_1or0(0) ;  
		}
		if((b1 & 0x4) == 0x4){
			dd.setD2_has_RongJieYang_1or0(1) ;  
			dd.setD2_value_RongJieYang_0to999d9(ByteUtil.BCD2Int_an(b, n, n + 3)/10.0) ;
			n += 4 ;
		}else{
			dd.setD2_has_RongJieYang_1or0(0) ;  
		}
		if((b1 & 0x8) == 0x8){
			dd.setD3_has_GaoMengSuanYan_1or0(1) ;  
			dd.setD3_value_GaoMengSuanYan_0to999d9(ByteUtil.BCD2Int_an(b, n, n + 3)/10.0) ;
			n += 4 ;
		}else{
			dd.setD3_has_GaoMengSuanYan_1or0(0) ;  
		}
		if((b1 & 0x10) == 0x10){
			dd.setD4_has_DianDaoLu_1or0(1) ;  
			dd.setD4_value_DianDaoLu_0to99999(ByteUtil.BCD2Int_an(b, n, n + 3)) ;
			n += 4 ;
		}else{
			dd.setD4_has_DianDaoLu_1or0(0) ;  
		}
		if((b1 & 0x20) == 0x20){
			dd.setD5_has_YangHuaHuanYuanDianWei_1or0(1) ;  
			dd.setD5_value_YangHuaHuanYuanDianWei_0to9999d9(ByteUtil.BCD2Int_an(b, n, n + 3)/10.0) ;
			n += 4 ;
		}else{
			dd.setD5_has_YangHuaHuanYuanDianWei_1or0(0) ;  
		}
		if((b1 & 0x40) == 0x40){
			dd.setD6_has_ZhuoDu_1or0(1) ;  
			dd.setD6_value_ZhuoDu_0to999(ByteUtil.BCD2Int_an(b, n, n + 3)) ;
			n += 4 ;
		}else{
			dd.setD6_has_ZhuoDu_1or0(0) ;  
		}
		if((b1 & 0x80) == 0x80){
			dd.setD7_has_HuaXueXuYangLiang_1or0(1) ;  
			dd.setD7_value_HuaXueXuYangLiang_0to999999d9(ByteUtil.BCD2Int_an(b, n, n + 3)/10.0) ;
			n += 4 ;
		}else{
			dd.setD7_has_HuaXueXuYangLiang_1or0(0) ;  
		}

		if((b2 & 0x1) == 0x1){
			dd.setD8_has_WuRiShengHuaXuYangLiang_1or0(1) ; 
			dd.setD8_value_WuRiShengHuaXuYangLiang_0to9999d9(ByteUtil.BCD2Int_an(b, n, n + 3)/10.0) ;
			n += 4 ;
		}else{
			dd.setD8_has_WuRiShengHuaXuYangLiang_1or0(0) ; 
		}
		if((b2 & 0x2) == 0x2){
			dd.setD9_has_AnDan_1or0(1) ;  
			dd.setD9_value_AnDan_0to9999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD9_has_AnDan_1or0(0) ;  
		}
		if((b2 & 0x4) == 0x4){
			dd.setD10_has_ZhongDan_1or0(1) ;  
			dd.setD10_value_ZhongDan_0to999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD10_has_ZhongDan_1or0(0) ;  
		}
		if((b2 & 0x8) == 0x8){
			dd.setD11_has_Tong_1or0(1) ;  
			dd.setD11_value_Tong_0to999d9999(ByteUtil.BCD2Int_an(b, n, n + 3)/10000.0) ;
			n += 4 ;
		}else{
			dd.setD11_has_Tong_1or0(0) ;  
		}
		if((b2 & 0x10) == 0x10){
			dd.setD12_has_Xin_1or0(1) ;  
			dd.setD12_value_Xin_0to99d9999(ByteUtil.BCD2Int_an(b, n, n + 3)/10000.0) ;
			n += 4 ;
		}else{
			dd.setD12_has_Xin_1or0(0) ;  
		}
		if((b2 & 0x20) == 0x20){
			dd.setD13_has_FuHuaWu_1or0(1) ;  
			dd.setD13_value_FuHuaWu_0to999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD13_has_FuHuaWu_1or0(0) ;  
		}
		if((b2 & 0x40) == 0x40){
			dd.setD14_has_Xi_1or0(1) ;  
			dd.setD14_value_Xi_0to99d99999(ByteUtil.BCD2Int_an(b, n, n + 3)/100000.0) ;
			n += 4 ;
		}else{
			dd.setD14_has_Xi_1or0(0) ;  
		}
		if((b2 & 0x80) == 0x80){
			dd.setD15_has_Shen_1or0(1) ;  
			dd.setD15_value_Shen_0to99d99999(ByteUtil.BCD2Int_an(b, n, n + 3)/100000.0) ;
			n += 4 ;
		}else{
			dd.setD15_has_Shen_1or0(0) ;  
		}
		

		if((b3 & 0x1) == 0x1){
			dd.setD16_has_Gong_1or0(1) ; 
			dd.setD16_value_Gong_0to99d99999(ByteUtil.BCD2Int_an(b, n, n + 3)/100000.0) ;
			n += 4 ;
		}else{
			dd.setD16_has_Gong_1or0(0) ; 
		}
		if((b3 & 0x2) == 0x2){
			dd.setD17_has_Ge_1or0(1) ;  
			dd.setD17_value_Ge_0to99d99999(ByteUtil.BCD2Int_an(b, n, n + 3)/100000.0) ;
			n += 4 ;
		}else{
			dd.setD17_has_Ge_1or0(0) ;  
		}
		if((b3 & 0x4) == 0x4){
			dd.setD18_has_LuJianGe_1or0(1) ;  
			dd.setD18_value_LuJianGe_0to99d999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000.0) ;
			n += 4 ;
		}else{
			dd.setD18_has_LuJianGe_1or0(0) ;  
		}
		if((b3 & 0x8) == 0x8){
			dd.setD19_has_Qian_1or0(1) ;  
			dd.setD19_value_Qian_0to99d99999(ByteUtil.BCD2Int_an(b, n, n + 3)/100000.0) ;
			n += 4 ;
		}else{
			dd.setD19_has_Qian_1or0(0) ;  
		}
		if((b3 & 0x10) == 0x10){
			dd.setD20_has_QingHuaWu_1or0(1) ;  
			dd.setD20_value_QingHuaWu_0to99d999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000.0) ;
			n += 4 ;
		}else{
			dd.setD20_has_QingHuaWu_1or0(0) ;  
		}
		if((b3 & 0x20) == 0x20){
			dd.setD21_has_HuiFaFen_1or0(1) ;  
			dd.setD21_value_HuiFaFen_0to99d999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000.0) ;
			n += 4 ;
		}else{
			dd.setD21_has_HuiFaFen_1or0(0) ;  
		}
		if((b3 & 0x40) == 0x40){
			dd.setD22_has_BenFen_1or0(1) ;  
			dd.setD22_value_BenFen_0to999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD22_has_BenFen_1or0(0) ;  
		}
		if((b3 & 0x80) == 0x80){
			dd.setD23_has_LiuHuaWu_1or0(1) ;  
			dd.setD23_value_LiuHuaWu_0to99d999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000.0) ;
			n += 4 ;
		}else{
			dd.setD23_has_LiuHuaWu_1or0(0) ;  
		}
		
		
		if((b4 & 0x1) == 0x1){
			dd.setD24_has_FenDaChangJunQun_1or0(1) ; 
			dd.setD24_value_FenDaChangJunQun_0to9999999999(ByteUtil.BCD2Int_an(b, n, n + 4)) ;
			n += 5 ;
		}else{
			dd.setD24_has_FenDaChangJunQun_1or0(0) ; 
		}
		if((b4 & 0x2) == 0x2){
			dd.setD25_has_LiuSuanYan_1or0(1) ;  
			dd.setD25_value_LiuSuanYan_0to9999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD25_has_LiuSuanYan_1or0(0) ;  
		}
		if((b4 & 0x4) == 0x4){
			dd.setD26_has_LuHuaWu_1or0(1) ;  
			dd.setD26_value_LuHuaWu_0to999999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD26_has_LuHuaWu_1or0(0) ;  
		}
		if((b4 & 0x8) == 0x8){
			dd.setD27_has_XiaoSuanYanDan_1or0(1) ;  
			dd.setD27_value_XiaoSuanYanDan_0to999d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD27_has_XiaoSuanYanDan_1or0(0) ;  
		}
		if((b4 & 0x10) == 0x10){
			dd.setD28_has_Die_1or0(1) ;  
			dd.setD28_value_Die_0to99d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD28_has_Die_1or0(0) ;  
		}
		if((b4 & 0x20) == 0x20){
			dd.setD29_has_Meng_1or0(1) ;  
			dd.setD29_value_Meng_0to99d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD29_has_Meng_1or0(0) ;  
		}
		if((b4 & 0x40) == 0x40){
			dd.setD30_has_ShiYouLei_1or0(1) ;  
			dd.setD30_value_ShiYouLei_0to99d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD30_has_ShiYouLei_1or0(0) ;  
		}
		if((b4 & 0x80) == 0x80){
			dd.setD31_has_YinLiZhiBiaoMianHuoXingJi_1or0(1) ;  
			dd.setD31_value_YinLiZhiBiaoMianHuoXingJi_0to99d99(ByteUtil.BCD2Int_an(b, n, n + 3)/100.0) ;
			n += 4 ;
		}else{
			dd.setD31_has_YinLiZhiBiaoMianHuoXingJi_1or0(0) ;  
		}
		

		if((b5 & 0x1) == 0x1){
			dd.setD32_has_LiuLiuLiu_1or0(1) ; 
			dd.setD32_value_LiuLiuLiu_0to9d999999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000000.0) ;
			n += 4 ;
		}else{
			dd.setD32_has_LiuLiuLiu_1or0(0) ; 
		}
		if((b5 & 0x2) == 0x2){
			dd.setD33_has_DiDiTi_1or0(1) ;  
			dd.setD33_value_DiDiTi_0to9d999999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000000.0) ;
			n += 4 ;
		}else{
			dd.setD33_has_DiDiTi_1or0(0) ;  
		}
		if((b5 & 0x4) == 0x4){
			dd.setD34_has_YouJiLuNongYao_1or0(1) ;  
			dd.setD34_value_YouJiLuNongYao_0to9d999999(ByteUtil.BCD2Int_an(b, n, n + 3)/1000000.0) ;
			n += 4 ;
		}else{
			dd.setD34_has_YouJiLuNongYao_1or0(0) ;  
		}
		
		
	}
}