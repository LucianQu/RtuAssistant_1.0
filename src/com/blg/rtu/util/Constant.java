package com.blg.rtu.util;

public class Constant {
	
	public static final String preferencesFileName = "comBlgRtuPref" ;//SharedPreferences文件名
	public static final int preferencesFilemode = 0 ;//0：本程序用
	
	public static final int errorInt = -999999999 ;
	public static final long errorLong = -999999999999999999L ;
	public static final float errorFloat = -9999999999999999999.99F ;
	public static final String errorStr = "-0-0" ;
	
	public final static long MinPhone = 13000000000L ; //最小手机号
	
	public final static String defaultPasswordHex = "0000" ;//不能有空格
	
	public static final int channelSm = 1 ;//短信通道
	public static final int channelTcp = 2 ;//TCP通道
	public static final String channelType(int type){
		if(type == channelSm){
			return "短信" ;
		}else if(type == channelTcp){
			return "网络" ;
		}
		return "" ;
	}
	
	public static final String derictUp = "上行" ; 
	public static final String derictDown = "下行" ; 
	
	public static final int requestPhoneLen = 11 ; 
	public static final int requestIpLen = 3 ; 
	public static final int requestPortLen = 5 ; 

	
	public static final String ch_vk_phone = "ch_vk_phone" ;//终端手机号
	public static final String ch_vk_ip1 = "ch_vk_ip1" ;//终端IP
	public static final String ch_vk_ip2 = "ch_vk_ip2" ;//终端IP
	public static final String ch_vk_ip3 = "ch_vk_ip3" ;//终端IP
	public static final String ch_vk_ip4 = "ch_vk_ip4" ;//终端IP
	public static final String ch_vk_port = "ch_vk_port" ;//终端终端口

	public static final String func_vk_01_010_01 = "vk_01_010_01" ; 
	public static final String func_vk_01_010_02 = "vk_01_010_02" ; 
	public static final String func_vk_01_010_03 = "vk_01_010_03" ; 
	public static final String func_vk_01_010_dt = "vk_01_010_dt" ; 
	public static final String func_vk_01_020_03 = "vk_01_020_03" ; 
	public static final String func_vk_01_020_dt = "vk_01_020_dt" ; 
	public static final String func_vk_01_030_01 = "vk_01_030_01" ; 
	public static final String func_vk_01_030_dt = "vk_01_030_dt" ; 
	public static final String func_vk_01_040_01 = "vk_01_040_01" ; 
	public static final String func_vk_01_040_02 = "vk_01_040_02" ; 
	public static final String func_vk_01_040_dt = "vk_01_040_dt" ; 
	public static final String func_vk_01_050_01 = "vk_01_050_01" ; 
	public static final String func_vk_01_050_dt = "vk_01_050_dt" ; 
	public static final String func_vk_01_060_01 = "vk_01_060_01" ; 
	public static final String func_vk_01_060_dt = "vk_01_060_dt" ; 
	public static final String func_vk_01_070_01 = "vk_01_070_01" ; 
	public static final String func_vk_01_070_02 = "vk_01_070_02" ; 
	public static final String func_vk_01_070_dt = "vk_01_070_dt" ; 
	public static final String func_vk_01_080_01_1 = "vk_01_080_01_1" ; 
	public static final String func_vk_01_080_01_2 = "vk_01_080_01_2" ; 
	public static final String func_vk_01_080_dt = "vk_01_080_dt" ; 
	public static final String func_vk_01_090_01 = "vk_01_090_01" ;
	public static final String func_vk_01_090_dt = "vk_01_090_dt" ;
	
	public static final String func_vk_01_100_01 = "vk_01_010_01" ; 
	public static final String func_vk_01_100_02 = "vk_01_010_02" ; 
	public static final String func_vk_01_100_03 = "vk_01_010_03" ; 
	public static final String func_vk_01_100_04 = "vk_01_010_04" ; 
	public static final String func_vk_01_100_dt = "vk_01_010_dt" ; 
	
	public static final String func_vk_02_010_01 = "vk_02_010_01" ; 
	public static final String func_vk_02_010_dt = "vk_02_010_dt" ; 
	public static final String func_vk_02_020_01 = "vk_02_020_01" ; 
	public static final String func_vk_02_020_dt = "vk_02_020_dt" ; 
	public static final String func_vk_02_030_01 = "vk_02_030_01" ; 
	public static final String func_vk_02_030_02 = "vk_02_030_02" ; 
	public static final String func_vk_02_030_03 = "vk_02_030_03" ; 
	public static final String func_vk_02_030_dt = "vk_02_030_dt" ; 
	public static final String func_vk_02_040_01 = "vk_02_040_01" ; 
	public static final String func_vk_02_040_02 = "vk_02_040_02" ; 
	public static final String func_vk_02_040_03 = "vk_02_040_03" ; 
	public static final String func_vk_02_040_dt = "vk_02_040_dt" ; 
	
	public static final String func_vk_02_050_01_1 = "vk_02_050_01_1" ; 
	public static final String func_vk_02_050_01_2_1 = "vk_02_050_01_2_1" ; 
	public static final String func_vk_02_050_01_2_2 = "vk_02_050_01_2_2" ; 
	public static final String func_vk_02_050_01_2_3 = "vk_02_050_01_2_3" ; 
	public static final String func_vk_02_050_01_2_4 = "vk_02_050_01_2_4" ; 
	public static final String func_vk_02_050_01_3 = "vk_02_050_01_3" ; 
	public static final String func_vk_02_050_01_4 = "vk_02_050_01_4" ; 
	
	public static final String func_vk_02_050_02_1 = "vk_02_050_02_1" ; 
	public static final String func_vk_02_050_02_2_1 = "vk_02_050_02_2_1" ; 
	public static final String func_vk_02_050_02_2_2 = "vk_02_050_02_2_2" ; 
	public static final String func_vk_02_050_02_2_3 = "vk_02_050_02_2_3" ; 
	public static final String func_vk_02_050_02_2_4 = "vk_02_050_02_2_4" ; 
	public static final String func_vk_02_050_02_3 = "vk_02_050_02_3" ; 
	public static final String func_vk_02_050_02_4 = "vk_02_050_02_4" ; 
	
	public static final String func_vk_02_050_03_1 = "vk_02_050_03_1" ; 
	public static final String func_vk_02_050_03_2_1 = "vk_02_050_03_2_1" ; 
	public static final String func_vk_02_050_03_2_2 = "vk_02_050_03_2_2" ; 
	public static final String func_vk_02_050_03_2_3 = "vk_02_050_03_2_3" ; 
	public static final String func_vk_02_050_03_2_4 = "vk_02_050_03_2_4" ; 
	public static final String func_vk_02_050_03_3 = "vk_02_050_03_3" ; 
	public static final String func_vk_02_050_03_4 = "vk_02_050_03_4" ; 
	
	public static final String func_vk_02_050_04_1 = "vk_02_050_04_1" ; 
	public static final String func_vk_02_050_04_2_1 = "vk_02_050_04_2_1" ; 
	public static final String func_vk_02_050_04_2_2 = "vk_02_050_04_2_2" ; 
	public static final String func_vk_02_050_04_2_3 = "vk_02_050_04_2_3" ; 
	public static final String func_vk_02_050_04_2_4 = "vk_02_050_04_2_4" ; 
	public static final String func_vk_02_050_04_3 = "vk_02_050_04_3" ; 
	public static final String func_vk_02_050_04_4 = "vk_02_050_04_4" ; 
	
	public static final String func_vk_02_050_dt = "vk_02_050_dt" ; 
	
	public static final String func_vk_02_060_01_1 = "vk_02_060_01_1" ; 
	public static final String func_vk_02_060_01_2 = "vk_02_060_01_2" ; 
	
	public static final String func_vk_02_060_02_1 = "vk_02_060_02_1" ; 
	public static final String func_vk_02_060_02_2 = "vk_02_060_02_2" ; 
	
	public static final String func_vk_02_060_03_1 = "vk_02_060_03_1" ; 
	public static final String func_vk_02_060_03_2 = "vk_02_060_03_2" ; 
	
	public static final String func_vk_02_060_04_1 = "vk_02_060_04_1" ; 
	public static final String func_vk_02_060_04_2 = "vk_02_060_04_2" ; 
	
	public static final String func_vk_02_060_dt = "vk_02_060_dt" ; 
	
	public static final String func_vk_02_070_01_1 = "vk_02_070_01_1" ; 
	public static final String func_vk_02_070_01_2 = "vk_02_070_01_2" ; 
	
	public static final String func_vk_02_070_02_1 = "vk_02_070_02_1" ; 
	public static final String func_vk_02_070_02_2 = "vk_02_070_02_2" ; 
	
	public static final String func_vk_02_070_03_1 = "vk_02_070_03_1" ; 
	public static final String func_vk_02_070_03_2 = "vk_02_070_03_2" ; 
	
	public static final String func_vk_02_070_04_1 = "vk_02_070_04_1" ; 
	public static final String func_vk_02_070_04_2 = "vk_02_070_04_2" ; 
	
	public static final String func_vk_02_070_dt = "vk_02_070_dt" ; 

	public static final String func_vk_02_080_01 = "vk_02_080_01" ; 
	public static final String func_vk_02_080_dt = "vk_02_080_dt" ; 

	public static final String func_vk_02_090_01 = "vk_02_090_01" ; 
	public static final String func_vk_02_090_02 = "vk_02_090_02" ; 
	public static final String func_vk_02_090_03 = "vk_02_090_03" ; 
	public static final String func_vk_02_090_04 = "vk_02_090_04" ; 
	public static final String func_vk_02_090_05 = "vk_02_090_05" ; 
	public static final String func_vk_02_090_06 = "vk_02_090_06" ; 
	public static final String func_vk_02_090_07 = "vk_02_090_07" ; 
	public static final String func_vk_02_090_08 = "vk_02_090_08" ; 
	public static final String func_vk_02_090_09 = "vk_02_090_09" ; 
	public static final String func_vk_02_090_10 = "vk_02_090_10" ; 
	public static final String func_vk_02_090_11 = "vk_02_090_11" ; 
	public static final String func_vk_02_090_12 = "vk_02_090_12" ; 
	public static final String func_vk_02_090_dt = "vk_02_090_dt" ; 
	
	public static final String func_vk_02_100_01 = "vk_02_100_01" ;
	public static final String func_vk_02_100_dt = "vk_02_100_dt" ;
	
	public static final String func_vk_02_110_01 = "vk_02_110_01" ; 
	public static final String func_vk_02_110_02 = "vk_02_110_02" ; 
	public static final String func_vk_02_110_03 = "vk_02_110_03" ; 
	public static final String func_vk_02_110_04 = "vk_02_110_04" ; 
	public static final String func_vk_02_110_05 = "vk_02_110_05" ; 
	public static final String func_vk_02_110_dt = "vk_02_110_dt" ;
	
	public static final String func_vk_03_010_01_1 = "vk_03_010_01_1" ; 
	public static final String func_vk_03_010_01_2 = "vk_03_010_01_2" ; 
	public static final String func_vk_03_010_02_1 = "vk_03_010_02_1" ; 
	public static final String func_vk_03_010_02_2 = "vk_03_010_02_2" ; 
	public static final String func_vk_03_010_dt = "vk_03_010_dt" ; 

	public static final String func_vk_03_011_01 = "vk_03_011_01" ; 
	public static final String func_vk_03_011_02 = "vk_03_011_02" ; 
	public static final String func_vk_03_011_03 = "vk_03_011_03" ; 
	public static final String func_vk_03_011_dt = "vk_03_011_dt" ; 

	public static final String func_vk_03_020_01_1 = "vk_03_020_01_1" ; 
	public static final String func_vk_03_020_01_2 = "vk_03_020_01_2" ; 
	public static final String func_vk_03_020_02_1 = "vk_03_020_02_1" ; 
	public static final String func_vk_03_020_02_2 = "vk_03_020_02_2" ; 
	public static final String func_vk_03_020_03_1 = "vk_03_020_03_1" ; 
	public static final String func_vk_03_020_03_2 = "vk_03_020_03_2" ; 
	public static final String func_vk_03_020_04_1 = "vk_03_020_04_1" ; 
	public static final String func_vk_03_020_04_2 = "vk_03_020_04_2" ; 
	public static final String func_vk_03_020_05_1 = "vk_03_020_05_1" ; 
	public static final String func_vk_03_020_05_2 = "vk_03_020_05_2" ; 
	public static final String func_vk_03_020_06_1 = "vk_03_020_06_1" ; 
	public static final String func_vk_03_020_06_2 = "vk_03_020_06_2" ; 
	public static final String func_vk_03_020_dt = "vk_03_020_dt" ; 
	public static final String func_vk_03_020_typeCount = "vk_03_020_typeCount" ; 
	public static final String func_vk_03_020_t_ = "vk_03_020_t_" ; 

	public static final String func_vk_03_030_01_1 = "vk_03_030_01_1" ; 
	public static final String func_vk_03_030_01_2 = "vk_03_030_01_2" ; 
	public static final String func_vk_03_030_02_1 = "vk_03_030_02_1" ; 
	public static final String func_vk_03_030_02_2 = "vk_03_030_02_2" ; 
	public static final String func_vk_03_030_03_1 = "vk_03_030_03_1" ; 
	public static final String func_vk_03_030_03_2 = "vk_03_030_03_2" ; 
	public static final String func_vk_03_030_04_1 = "vk_03_030_04_1" ; 
	public static final String func_vk_03_030_04_2 = "vk_03_030_04_2" ; 
	public static final String func_vk_03_030_05_1 = "vk_03_030_05_1" ; 
	public static final String func_vk_03_030_05_2 = "vk_03_030_05_2" ; 
	public static final String func_vk_03_030_06_1 = "vk_03_030_06_1" ; 
	public static final String func_vk_03_030_06_2 = "vk_03_030_06_2" ; 
	public static final String func_vk_03_030_dt = "vk_03_030_dt" ; 

	public static final String func_vk_03_040_01_1 = "vk_03_040_01_1" ; 
	public static final String func_vk_03_040_01_2 = "vk_03_040_01_2" ; 
	public static final String func_vk_03_040_dt = "vk_03_040_dt" ; 
	
	public static final String func_vk_03_050_01_1 = "vk_03_050_01_1" ; 
	public static final String func_vk_03_050_01_2 = "vk_03_050_01_2" ; 
	public static final String func_vk_03_050_02_1 = "vk_03_050_02_1" ; 
	public static final String func_vk_03_050_02_2 = "vk_03_050_02_2" ; 
	public static final String func_vk_03_050_03_1 = "vk_03_050_03_1" ; 
	public static final String func_vk_03_050_03_2 = "vk_03_050_03_2" ; 
	public static final String func_vk_03_050_04_1 = "vk_03_050_04_1" ; 
	public static final String func_vk_03_050_04_2 = "vk_03_050_04_2" ; 
	public static final String func_vk_03_050_dt = "vk_03_050_dt" ; 

	public static final String func_vk_03_060_01 = "vk_03_060_01" ; 
	public static final String func_vk_03_060_dt = "vk_03_060_dt" ; 

	public static final String func_vk_03_070_01_1 = "vk_03_070_01_1" ; 
	public static final String func_vk_03_070_01_2 = "vk_03_070_01_2" ; 
	public static final String func_vk_03_070_02_1 = "vk_03_070_02_1" ; 
	public static final String func_vk_03_070_02_2 = "vk_03_070_02_2" ; 
	public static final String func_vk_03_070_03_1 = "vk_03_070_03_1" ; 
	public static final String func_vk_03_070_03_2 = "vk_03_070_03_2" ; 
	public static final String func_vk_03_070_dt = "vk_03_070_dt" ; 
	

	public static final String func_vk_03_080_cb_01 = "vk_03_080_cb_01" ; 
	public static final String func_vk_03_080_cb_02 = "vk_03_080_cb_02" ; 
	public static final String func_vk_03_080_cb_03 = "vk_03_080_cb_03" ; 
	public static final String func_vk_03_080_cb_04 = "vk_03_080_cb_04" ; 
	public static final String func_vk_03_080_cb_05 = "vk_03_080_cb_05" ; 
	public static final String func_vk_03_080_cb_06 = "vk_03_080_cb_06" ; 
	public static final String func_vk_03_080_cb_07 = "vk_03_080_cb_07" ; 
	public static final String func_vk_03_080_cb_08 = "vk_03_080_cb_08" ; 
	public static final String func_vk_03_080_cb_09 = "vk_03_080_cb_09" ; 
	public static final String func_vk_03_080_cb_10 = "vk_03_080_cb_10" ; 
	public static final String func_vk_03_080_cb_11 = "vk_03_080_cb_11" ; 
	public static final String func_vk_03_080_cb_12 = "vk_03_080_cb_12" ; 
	public static final String func_vk_03_080_cb_13 = "vk_03_080_cb_13" ; 
	public static final String func_vk_03_080_cb_14 = "vk_03_080_cb_14" ; 
	public static final String func_vk_03_080_cb_15 = "vk_03_080_cb_15" ; 

	public static final String func_vk_03_080_item_01 = "vk_03_080_item_01" ; 
	public static final String func_vk_03_080_item_02 = "vk_03_080_item_02" ; 
	public static final String func_vk_03_080_item_03 = "vk_03_080_item_03" ; 
	public static final String func_vk_03_080_item_04 = "vk_03_080_item_04" ; 
	public static final String func_vk_03_080_item_05 = "vk_03_080_item_05" ; 
	public static final String func_vk_03_080_item_06 = "vk_03_080_item_06" ; 
	public static final String func_vk_03_080_item_07 = "vk_03_080_item_07" ; 
	public static final String func_vk_03_080_item_08 = "vk_03_080_item_08" ; 
	public static final String func_vk_03_080_item_09 = "vk_03_080_item_09" ; 
	public static final String func_vk_03_080_item_10 = "vk_03_080_item_10" ; 
	public static final String func_vk_03_080_item_11 = "vk_03_080_item_11" ; 
	public static final String func_vk_03_080_item_12 = "vk_03_080_item_12" ; 
	public static final String func_vk_03_080_item_13 = "vk_03_080_item_13" ; 
	public static final String func_vk_03_080_item_14 = "vk_03_080_item_14" ; 
	public static final String func_vk_03_080_item_15 = "vk_03_080_item_15" ; 
	
	public static final String func_vk_03_080_dt = "vk_03_080_dt" ; 	
	
	
	public static final String func_vk_03_090_01 = "vk_03_090_01" ; 
	public static final String func_vk_03_090_dt = "vk_03_090_dt" ; 
	
	public static final String func_vk_04_010_01 = "vk_04_010_01" ; 
	public static final String func_vk_04_010_dt = "vk_04_010_dt" ; 

	public static final String func_vk_04_020_ = "vk_04_020_" ; 
	public static final String func_vk_04_020_alarm_ = "vk_04_020_alarm_" ; 
	public static final String func_vk_04_020_dt = "vk_04_020_dt" ; 

	public static final String func_vk_04_030_cb_01 = "vk_04_030_cb_01" ; 
	public static final String func_vk_04_030_cb_02 = "vk_04_030_cb_02" ; 
	public static final String func_vk_04_030_cb_03 = "vk_04_030_cb_03" ; 
	public static final String func_vk_04_030_cb_04 = "vk_04_030_cb_04" ; 
	public static final String func_vk_04_030_cb_05 = "vk_04_030_cb_05" ; 
	public static final String func_vk_04_030_cb_06 = "vk_04_030_cb_06" ; 
	public static final String func_vk_04_030_cb_07 = "vk_04_030_cb_07" ; 
	public static final String func_vk_04_030_cb_08 = "vk_04_030_cb_08" ; 
	public static final String func_vk_04_030_cb_09 = "vk_04_030_cb_09" ; 
	public static final String func_vk_04_030_cb_10 = "vk_04_030_cb_10" ; 
	public static final String func_vk_04_030_cb_11 = "vk_04_030_cb_11" ; 
	public static final String func_vk_04_030_cb_12 = "vk_04_030_cb_12" ; 
	public static final String func_vk_04_030_cb_13 = "vk_04_030_cb_13" ; 
	public static final String func_vk_04_030_cb_14 = "vk_04_030_cb_14" ; 
	public static final String func_vk_04_030_cb_15 = "vk_04_030_cb_15" ; 
	public static final String func_vk_04_030_cb_16 = "vk_04_030_cb_16" ; 
	public static final String func_vk_04_030_cb_17 = "vk_04_030_cb_17" ; 
	public static final String func_vk_04_030_cb_18 = "vk_04_030_cb_18" ; 
	public static final String func_vk_04_030_cb_19 = "vk_04_030_cb_19" ; 
	public static final String func_vk_04_030_cb_20 = "vk_04_030_cb_20" ; 
	public static final String func_vk_04_030_cb_21 = "vk_04_030_cb_21" ; 
	public static final String func_vk_04_030_cb_22 = "vk_04_030_cb_22" ; 
	public static final String func_vk_04_030_cb_23 = "vk_04_030_cb_23" ; 
	public static final String func_vk_04_030_cb_24 = "vk_04_030_cb_24" ; 
	public static final String func_vk_04_030_cb_25 = "vk_04_030_cb_25" ; 
	public static final String func_vk_04_030_cb_26 = "vk_04_030_cb_26" ; 
	public static final String func_vk_04_030_cb_27 = "vk_04_030_cb_27" ; 
	public static final String func_vk_04_030_cb_28 = "vk_04_030_cb_28" ; 
	public static final String func_vk_04_030_cb_29 = "vk_04_030_cb_29" ; 
	public static final String func_vk_04_030_cb_30 = "vk_04_030_cb_30" ; 
	public static final String func_vk_04_030_cb_31 = "vk_04_030_cb_31" ; 
	public static final String func_vk_04_030_cb_32 = "vk_04_030_cb_32" ; 
	public static final String func_vk_04_030_cb_33 = "vk_04_030_cb_33" ; 
	public static final String func_vk_04_030_cb_34 = "vk_04_030_cb_34" ; 
	public static final String func_vk_04_030_cb_35 = "vk_04_030_cb_35" ; 

	public static final String func_vk_04_030_item_01 = "vk_04_030_item_01" ; 
	public static final String func_vk_04_030_item_02 = "vk_04_030_item_02" ; 
	public static final String func_vk_04_030_item_03 = "vk_04_030_item_03" ; 
	public static final String func_vk_04_030_item_04 = "vk_04_030_item_04" ; 
	public static final String func_vk_04_030_item_05 = "vk_04_030_item_05" ; 
	public static final String func_vk_04_030_item_06 = "vk_04_030_item_06" ; 
	public static final String func_vk_04_030_item_07 = "vk_04_030_item_07" ; 
	public static final String func_vk_04_030_item_08 = "vk_04_030_item_08" ; 
	public static final String func_vk_04_030_item_09 = "vk_04_030_item_09" ; 
	public static final String func_vk_04_030_item_10 = "vk_04_030_item_10" ; 
	public static final String func_vk_04_030_item_11 = "vk_04_030_item_11" ; 
	public static final String func_vk_04_030_item_12 = "vk_04_030_item_12" ; 
	public static final String func_vk_04_030_item_13 = "vk_04_030_item_13" ; 
	public static final String func_vk_04_030_item_14 = "vk_04_030_item_14" ; 
	public static final String func_vk_04_030_item_15 = "vk_04_030_item_15" ; 
	public static final String func_vk_04_030_item_16 = "vk_04_030_item_16" ; 
	public static final String func_vk_04_030_item_17 = "vk_04_030_item_17" ; 
	public static final String func_vk_04_030_item_18 = "vk_04_030_item_18" ; 
	public static final String func_vk_04_030_item_19 = "vk_04_030_item_19" ; 
	public static final String func_vk_04_030_item_20 = "vk_04_030_item_20" ; 
	public static final String func_vk_04_030_item_21 = "vk_04_030_item_21" ; 
	public static final String func_vk_04_030_item_22 = "vk_04_030_item_22" ; 
	public static final String func_vk_04_030_item_23 = "vk_04_030_item_23" ; 
	public static final String func_vk_04_030_item_24 = "vk_04_030_item_24" ; 
	public static final String func_vk_04_030_item_25 = "vk_04_030_item_25" ; 
	public static final String func_vk_04_030_item_26 = "vk_04_030_item_26" ; 
	public static final String func_vk_04_030_item_27 = "vk_04_030_item_27" ; 
	public static final String func_vk_04_030_item_28 = "vk_04_030_item_28" ; 
	public static final String func_vk_04_030_item_29 = "vk_04_030_item_29" ; 
	public static final String func_vk_04_030_item_30 = "vk_04_030_item_30" ; 
	public static final String func_vk_04_030_item_31 = "vk_04_030_item_31" ; 
	public static final String func_vk_04_030_item_32 = "vk_04_030_item_32" ; 
	public static final String func_vk_04_030_item_33 = "vk_04_030_item_33" ; 
	public static final String func_vk_04_030_item_34 = "vk_04_030_item_34" ; 
	public static final String func_vk_04_030_item_35 = "vk_04_030_item_35" ; 
	
	public static final String func_vk_04_030_dt = "vk_04_030_dt" ; 
	

	public static final String func_vk_04_040_cb_01 = "vk_04_040_cb_01" ; 
	public static final String func_vk_04_040_cb_02 = "vk_04_040_cb_02" ; 
	public static final String func_vk_04_040_cb_03 = "vk_04_040_cb_03" ; 
	public static final String func_vk_04_040_cb_04 = "vk_04_040_cb_04" ; 
	public static final String func_vk_04_040_cb_05 = "vk_04_040_cb_05" ; 
	public static final String func_vk_04_040_cb_06 = "vk_04_040_cb_06" ; 
	public static final String func_vk_04_040_cb_07 = "vk_04_040_cb_07" ; 
	public static final String func_vk_04_040_cb_08 = "vk_04_040_cb_08" ; 
	public static final String func_vk_04_040_cb_09 = "vk_04_040_cb_09" ; 
	public static final String func_vk_04_040_cb_10 = "vk_04_040_cb_10" ; 
	public static final String func_vk_04_040_cb_11 = "vk_04_040_cb_11" ; 
	public static final String func_vk_04_040_cb_12 = "vk_04_040_cb_12" ; 
	public static final String func_vk_04_040_cb_13 = "vk_04_040_cb_13" ; 
	public static final String func_vk_04_040_cb_14 = "vk_04_040_cb_14" ; 
	public static final String func_vk_04_040_cb_15 = "vk_04_040_cb_15" ; 
	public static final String func_vk_04_040_cb_16 = "vk_04_040_cb_16" ; 
	public static final String func_vk_04_040_cb_17 = "vk_04_040_cb_17" ; 
	public static final String func_vk_04_040_cb_18 = "vk_04_040_cb_18" ; 
	public static final String func_vk_04_040_cb_19 = "vk_04_040_cb_19" ; 
	public static final String func_vk_04_040_cb_20 = "vk_04_040_cb_20" ; 
	public static final String func_vk_04_040_cb_21 = "vk_04_040_cb_21" ; 
	public static final String func_vk_04_040_cb_22 = "vk_04_040_cb_22" ; 
	public static final String func_vk_04_040_cb_23 = "vk_04_040_cb_23" ; 
	public static final String func_vk_04_040_cb_24 = "vk_04_040_cb_24" ; 
	public static final String func_vk_04_040_cb_25 = "vk_04_040_cb_25" ; 
	public static final String func_vk_04_040_cb_26 = "vk_04_040_cb_26" ; 
	public static final String func_vk_04_040_cb_27 = "vk_04_040_cb_27" ; 
	public static final String func_vk_04_040_cb_28 = "vk_04_040_cb_28" ; 
	public static final String func_vk_04_040_cb_29 = "vk_04_040_cb_29" ; 
	public static final String func_vk_04_040_cb_30 = "vk_04_040_cb_30" ; 
	public static final String func_vk_04_040_cb_31 = "vk_04_040_cb_31" ; 
	public static final String func_vk_04_040_cb_32 = "vk_04_040_cb_32" ; 
	public static final String func_vk_04_040_cb_33 = "vk_04_040_cb_33" ; 
	public static final String func_vk_04_040_cb_34 = "vk_04_040_cb_34" ; 
	public static final String func_vk_04_040_cb_35 = "vk_04_040_cb_35" ; 

	public static final String func_vk_04_040_item_01 = "vk_04_040_item_01" ; 
	public static final String func_vk_04_040_item_02 = "vk_04_040_item_02" ; 
	public static final String func_vk_04_040_item_03 = "vk_04_040_item_03" ; 
	public static final String func_vk_04_040_item_04 = "vk_04_040_item_04" ; 
	public static final String func_vk_04_040_item_05 = "vk_04_040_item_05" ; 
	public static final String func_vk_04_040_item_06 = "vk_04_040_item_06" ; 
	public static final String func_vk_04_040_item_07 = "vk_04_040_item_07" ; 
	public static final String func_vk_04_040_item_08 = "vk_04_040_item_08" ; 
	public static final String func_vk_04_040_item_09 = "vk_04_040_item_09" ; 
	public static final String func_vk_04_040_item_10 = "vk_04_040_item_10" ; 
	public static final String func_vk_04_040_item_11 = "vk_04_040_item_11" ; 
	public static final String func_vk_04_040_item_12 = "vk_04_040_item_12" ; 
	public static final String func_vk_04_040_item_13 = "vk_04_040_item_13" ; 
	public static final String func_vk_04_040_item_14 = "vk_04_040_item_14" ; 
	public static final String func_vk_04_040_item_15 = "vk_04_040_item_15" ; 
	public static final String func_vk_04_040_item_16 = "vk_04_040_item_16" ; 
	public static final String func_vk_04_040_item_17 = "vk_04_040_item_17" ; 
	public static final String func_vk_04_040_item_18 = "vk_04_040_item_18" ; 
	public static final String func_vk_04_040_item_19 = "vk_04_040_item_19" ; 
	public static final String func_vk_04_040_item_20 = "vk_04_040_item_20" ; 
	public static final String func_vk_04_040_item_21 = "vk_04_040_item_21" ; 
	public static final String func_vk_04_040_item_22 = "vk_04_040_item_22" ; 
	public static final String func_vk_04_040_item_23 = "vk_04_040_item_23" ; 
	public static final String func_vk_04_040_item_24 = "vk_04_040_item_24" ; 
	public static final String func_vk_04_040_item_25 = "vk_04_040_item_25" ; 
	public static final String func_vk_04_040_item_26 = "vk_04_040_item_26" ; 
	public static final String func_vk_04_040_item_27 = "vk_04_040_item_27" ; 
	public static final String func_vk_04_040_item_28 = "vk_04_040_item_28" ; 
	public static final String func_vk_04_040_item_29 = "vk_04_040_item_29" ; 
	public static final String func_vk_04_040_item_30 = "vk_04_040_item_30" ; 
	public static final String func_vk_04_040_item_31 = "vk_04_040_item_31" ; 
	public static final String func_vk_04_040_item_32 = "vk_04_040_item_32" ; 
	public static final String func_vk_04_040_item_33 = "vk_04_040_item_33" ; 
	public static final String func_vk_04_040_item_34 = "vk_04_040_item_34" ; 
	public static final String func_vk_04_040_item_35 = "vk_04_040_item_35" ; 
	
	public static final String func_vk_04_040_dt = "vk_04_040_dt" ; 	
	
	

	public static final String func_vk_04_050_ = "vk_04_050_" ; 
	public static final String func_vk_04_050_alarm_ = "vk_04_050_alarm_" ; 
	public static final String func_vk_04_050_dt = "vk_04_050_dt" ; 
	
	public static final String func_vk_04_060_paramSelect = "vk_04_060_paramSelect" ; 
	public static final String func_vk_04_060_dt = "vk_04_060_dt" ; 
	public static final String func_vk_04_060_param01_1 = "vk_04_060_param01_1" ; 
	public static final String func_vk_04_060_param01_2 = "vk_04_060_param01_2" ; 
	public static final String func_vk_04_060_param01_3 = "vk_04_060_param01_3" ;
	public static final String func_vk_04_060_param02_1 = "vk_04_060_param02_1" ; 
	public static final String func_vk_04_060_param02_2 = "vk_04_060_param02_2" ; 
	public static final String func_vk_04_060_param02_3 = "vk_04_060_param02_3" ;
	public static final String func_vk_04_060_param03_1 = "vk_04_060_param03_1" ; 
	public static final String func_vk_04_060_param03_2 = "vk_04_060_param03_2" ; 
	public static final String func_vk_04_060_param03_3 = "vk_04_060_param03_3" ;
	public static final String func_vk_04_060_param04_1 = "vk_04_060_param04_1" ; 
	public static final String func_vk_04_060_param04_2 = "vk_04_060_param04_2" ; 
	public static final String func_vk_04_060_param04_3 = "vk_04_060_param04_3" ;
	public static final String func_vk_04_060_param05_1 = "vk_04_060_param05_1" ; 
	public static final String func_vk_04_060_param05_2 = "vk_04_060_param05_2" ; 
	public static final String func_vk_04_060_param05_3 = "vk_04_060_param05_3" ;
	public static final String func_vk_04_060_param06_1 = "vk_04_060_param06_1" ; 
	public static final String func_vk_04_060_param06_2 = "vk_04_060_param06_2" ; 
	public static final String func_vk_04_060_param06_3 = "vk_04_060_param06_3" ;
	public static final String func_vk_04_060_param07_1 = "vk_04_060_param07_1" ; 
	public static final String func_vk_04_060_param07_2 = "vk_04_060_param07_2" ; 
	public static final String func_vk_04_060_param07_3 = "vk_04_060_param07_3" ;
	public static final String func_vk_04_060_param08_1 = "vk_04_060_param08_1" ; 
	public static final String func_vk_04_060_param08_2 = "vk_04_060_param08_2" ; 
	public static final String func_vk_04_060_param08_3 = "vk_04_060_param08_3" ;
	public static final String func_vk_04_060_param09_1 = "vk_04_060_param09_1" ; 
	public static final String func_vk_04_060_param09_2 = "vk_04_060_param09_2" ; 
	public static final String func_vk_04_060_param09_3 = "vk_04_060_param09_3" ;
	public static final String func_vk_04_060_param10_1 = "vk_04_060_param10_1" ; 
	public static final String func_vk_04_060_param10_2 = "vk_04_060_param10_2" ; 
	public static final String func_vk_04_060_param10_3 = "vk_04_060_param10_3" ;
	public static final String func_vk_04_060_param11_1 = "vk_04_060_param11_1" ; 
	public static final String func_vk_04_060_param11_2 = "vk_04_060_param11_2" ; 
	public static final String func_vk_04_060_param11_3 = "vk_04_060_param11_3" ;
	public static final String func_vk_04_060_param12_1 = "vk_04_060_param12_1" ; 
	public static final String func_vk_04_060_param12_2 = "vk_04_060_param12_2" ; 
	public static final String func_vk_04_060_param12_3 = "vk_04_060_param12_3" ;
	public static final String func_vk_04_060_param13_1 = "vk_04_060_param13_1" ; 
	public static final String func_vk_04_060_param13_2 = "vk_04_060_param13_2" ; 
	public static final String func_vk_04_060_param13_3 = "vk_04_060_param13_3" ; 
	
	public static final String func_vk_04_070_item_01 = "vk_04_070_item_01" ; 
	public static final String func_vk_04_070_item_02 = "vk_04_070_item_02" ; 
	public static final String func_vk_04_070_item_03 = "vk_04_070_item_03" ; 
	public static final String func_vk_04_070_item_04 = "vk_04_070_item_04" ; 
	public static final String func_vk_04_070_item_05 = "vk_04_070_item_05" ; 
	public static final String func_vk_04_070_item_06 = "vk_04_070_item_06" ; 
	public static final String func_vk_04_070_item_07 = "vk_04_070_item_07" ; 
	public static final String func_vk_04_070_item_08 = "vk_04_070_item_08" ; 
	public static final String func_vk_04_070_item_09 = "vk_04_070_item_09" ; 
	public static final String func_vk_04_070_item_10 = "vk_04_070_item_10" ; 
	public static final String func_vk_04_070_item_11 = "vk_04_070_item_11" ; 
	public static final String func_vk_04_070_item_12 = "vk_04_070_item_12" ; 
	public static final String func_vk_04_070_item_13 = "vk_04_070_item_13" ; 
	public static final String func_vk_04_070_item_14 = "vk_04_070_item_14" ; 
	public static final String func_vk_04_070_item_15 = "vk_04_070_item_15" ; 
	public static final String func_vk_04_070_dt = "vk_04_070_dt" ; 
	

	public static final String func_vk_04_080_cb_01 = "vk_04_080_cb_01" ; 
	public static final String func_vk_04_080_cb_02 = "vk_04_080_cb_02" ; 
	public static final String func_vk_04_080_cb_03 = "vk_04_080_cb_03" ; 
	public static final String func_vk_04_080_cb_04 = "vk_04_080_cb_04" ; 
	public static final String func_vk_04_080_cb_05 = "vk_04_080_cb_05" ; 
	public static final String func_vk_04_080_cb_06 = "vk_04_080_cb_06" ; 
	public static final String func_vk_04_080_cb_07 = "vk_04_080_cb_07" ; 
	public static final String func_vk_04_080_cb_08 = "vk_04_080_cb_08" ; 
	public static final String func_vk_04_080_cb_09 = "vk_04_080_cb_09" ; 
	public static final String func_vk_04_080_cb_10 = "vk_04_080_cb_10" ; 
	public static final String func_vk_04_080_cb_11 = "vk_04_080_cb_11" ; 
	public static final String func_vk_04_080_cb_12 = "vk_04_080_cb_12" ; 
	public static final String func_vk_04_080_cb_13 = "vk_04_080_cb_13" ; 
	public static final String func_vk_04_080_cb_14 = "vk_04_080_cb_14" ; 

	public static final String func_vk_04_080_item_01 = "vk_04_080_item_01" ; 
	public static final String func_vk_04_080_item_02 = "vk_04_080_item_02" ; 
	public static final String func_vk_04_080_item_03 = "vk_04_080_item_03" ; 
	public static final String func_vk_04_080_item_04 = "vk_04_080_item_04" ; 
	public static final String func_vk_04_080_item_05 = "vk_04_080_item_05" ; 
	public static final String func_vk_04_080_item_06 = "vk_04_080_item_06" ; 
	public static final String func_vk_04_080_item_07 = "vk_04_080_item_07" ; 
	public static final String func_vk_04_080_item_08 = "vk_04_080_item_08" ; 
	public static final String func_vk_04_080_item_09 = "vk_04_080_item_09" ; 
	public static final String func_vk_04_080_item_10 = "vk_04_080_item_10" ; 
	public static final String func_vk_04_080_item_11 = "vk_04_080_item_11" ; 
	public static final String func_vk_04_080_item_12 = "vk_04_080_item_12" ; 
	public static final String func_vk_04_080_item_13 = "vk_04_080_item_13" ; 
	public static final String func_vk_04_080_item_14 = "vk_04_080_item_14" ; 
	
	public static final String func_vk_04_080_dt = "vk_04_080_dt" ; 	

	public static final String func_vk_04_090_01 = "vk_04_090_01" ; 
	public static final String func_vk_04_090_dt = "vk_04_090_dt" ; 

	public static final String func_vk_04_100_01 = "vk_04_100_01" ; 
	public static final String func_vk_04_100_02 = "vk_04_100_02" ; 
	public static final String func_vk_04_100_dt = "vk_04_100_dt" ; 

	public static final String func_vk_04_110_01 = "vk_04_110_01" ; 
	public static final String func_vk_04_110_02 = "vk_04_110_02" ; 
	public static final String func_vk_04_110_dt = "vk_04_110_dt" ; 

	public static final String func_vk_04_120_ = "vk_04_120_" ; 
	public static final String func_vk_04_120_dt = "vk_04_120_dt" ; 
		
	public static final String func_vk_05_010_01 = "vk_05_010_01" ; 
	public static final String func_vk_05_010_02 = "vk_05_010_02" ; 
	public static final String func_vk_05_010_03 = "vk_05_010_03" ; 
	public static final String func_vk_05_010_04 = "vk_05_010_04" ; 
	public static final String func_vk_05_010_05 = "vk_05_010_05" ; 
	public static final String func_vk_05_010_06 = "vk_05_010_06" ; 
	public static final String func_vk_05_010_07 = "vk_05_010_07" ; 
	public static final String func_vk_05_010_08 = "vk_05_010_08" ; 
	public static final String func_vk_05_010_09 = "vk_05_010_09" ; 
	public static final String func_vk_05_010_10 = "vk_05_010_10" ; 
	public static final String func_vk_05_010_11 = "vk_05_010_11" ; 
	public static final String func_vk_05_010_12 = "vk_05_010_12" ; 
	public static final String func_vk_05_010_13 = "vk_05_010_13" ; 
	public static final String func_vk_05_010_14 = "vk_05_010_14" ; 
	public static final String func_vk_05_010_15 = "vk_05_010_15" ; 
	public static final String func_vk_05_010_16 = "vk_05_010_16" ; 
	public static final String func_vk_05_010_17 = "vk_05_010_17" ; 
	public static final String func_vk_05_010_18 = "vk_05_010_18" ; 
	public static final String func_vk_05_010_19 = "vk_05_010_19" ; 
	public static final String func_vk_05_010_20 = "vk_05_010_20" ; 
	public static final String func_vk_05_010_21 = "vk_05_010_21" ; 
	public static final String func_vk_05_010_22 = "vk_05_010_22" ; 
	public static final String func_vk_05_010_23 = "vk_05_010_23" ; 
	public static final String func_vk_05_010_24 = "vk_05_010_24" ; 

	public static final String func_vk_05_010_dt = "vk_05_010_dt" ; 

	
	public static final String func_vk_05_020_01 = "vk_05_020_01" ; 
	public static final String func_vk_05_020_02 = "vk_05_020_02" ; 
	public static final String func_vk_05_020_03 = "vk_05_020_03" ; 
	public static final String func_vk_05_020_04 = "vk_05_020_04" ; 
	public static final String func_vk_05_020_05 = "vk_05_020_05" ; 
	public static final String func_vk_05_020_06 = "vk_05_020_06" ; 
	public static final String func_vk_05_020_07 = "vk_05_020_07" ; 
	public static final String func_vk_05_020_08 = "vk_05_020_08" ; 
	public static final String func_vk_05_020_09 = "vk_05_020_09" ; 
	public static final String func_vk_05_020_10 = "vk_05_020_10" ; 
	public static final String func_vk_05_020_11 = "vk_05_020_11" ; 
	public static final String func_vk_05_020_12 = "vk_05_020_12" ; 
	public static final String func_vk_05_020_13 = "vk_05_020_13" ; 
	public static final String func_vk_05_020_14 = "vk_05_020_14" ; 
	public static final String func_vk_05_020_15 = "vk_05_020_15" ; 
	public static final String func_vk_05_020_16 = "vk_05_020_16" ; 
	public static final String func_vk_05_020_17 = "vk_05_020_17" ; 
	public static final String func_vk_05_020_18 = "vk_05_020_18" ; 
	public static final String func_vk_05_020_19 = "vk_05_020_19" ; 
	public static final String func_vk_05_020_20 = "vk_05_020_20" ; 
	public static final String func_vk_05_020_21 = "vk_05_020_21" ;
	
	public static final String func_vk_05_020_dt = "vk_05_020_dt" ; 
	
	
	
	public static final String func_vk_05_030_01_01 = "vk_05_030_01_01" ; 
	public static final String func_vk_05_030_01_02 = "vk_05_030_01_02" ; 
	public static final String func_vk_05_030_01_03 = "vk_05_030_01_03" ; 
	public static final String func_vk_05_030_01_04 = "vk_05_030_01_04" ; 
	public static final String func_vk_05_030_01_05 = "vk_05_030_01_05" ; 
	
	public static final String func_vk_05_030_02_01 = "vk_05_030_02_01" ; 
	public static final String func_vk_05_030_02_02 = "vk_05_030_02_02" ; 
	public static final String func_vk_05_030_02_03 = "vk_05_030_02_03" ; 
	public static final String func_vk_05_030_02_04 = "vk_05_030_02_04" ; 
	public static final String func_vk_05_030_02_05 = "vk_05_030_02_05" ; 
	public static final String func_vk_05_030_02_06 = "vk_05_030_02_06" ; 
	public static final String func_vk_05_030_02_07 = "vk_05_030_02_07" ; 
	public static final String func_vk_05_030_02_08 = "vk_05_030_02_08" ; 
	public static final String func_vk_05_030_02_09 = "vk_05_030_02_09" ; 
	public static final String func_vk_05_030_02_10 = "vk_05_030_02_10" ; 
	
	public static final String func_vk_05_030_03_01 = "vk_05_030_03_01" ; 
	public static final String func_vk_05_030_03_02 = "vk_05_030_03_02" ; 
	public static final String func_vk_05_030_03_03 = "vk_05_030_03_03" ; 
	public static final String func_vk_05_030_03_04 = "vk_05_030_03_04" ; 
	public static final String func_vk_05_030_03_05 = "vk_05_030_03_05" ; 
	public static final String func_vk_05_030_03_06 = "vk_05_030_03_06" ; 
	
	public static final String func_vk_05_030_dt = "vk_05_030_dt" ; 
	
	public static final String func_vk_05_040_01 = "vk_05_040_01" ; 
	public static final String func_vk_05_040_02 = "vk_05_040_02" ; 
	public static final String func_vk_05_040_dt = "vk_05_040_dt" ; 
	
	public static final String func_vk_05_050_01 = "vk_05_050_01" ; 
	public static final String func_vk_05_050_ = "vk_05_050_" ; 
	public static final String func_vk_05_050_alarm_ = "vk_05_050_alarm_" ; 
	public static final String func_vk_05_050_status_ = "vk_05_050_status_" ; 
	public static final String func_vk_05_050_dt = "vk_05_050_dt" ; 
	
	public static final String func_vk_05_060_01 = "vk_05_060_01" ; 
	public static final String func_vk_05_060_dt = "vk_05_060_dt" ;
	
	public static final String func_vk_05_070_01 = "vk_05_070_01" ; 
	public static final String func_vk_05_070_02 = "vk_05_070_02" ; 
	public static final String func_vk_05_070_dt = "vk_05_070_dt" ; 

	public static final String func_vk_06_010_01 = "vk_06_010_01" ; 
	public static final String func_vk_06_010_02_ = "vk_06_010_02_" ; 
	public static final String func_vk_06_010_03 = "vk_06_010_03" ; 
	public static final String func_vk_06_010_04_01 = "vk_06_010_04_01" ; 
	public static final String func_vk_06_010_04_02 = "vk_06_010_04_02" ; 
	public static final String func_vk_06_010_04_03 = "vk_06_010_04_03" ; 
	public static final String func_vk_06_010_04_04 = "vk_06_010_04_04" ; 
	public static final String func_vk_06_010_04_05 = "vk_06_010_04_05" ; 
	public static final String func_vk_06_010_05_ = "vk_06_010_05_" ; 
	public static final String func_vk_06_010_dt = "vk_06_010_dt" ; 
	
	public static final String func_vk_06_020_01 = "vk_06_020_01" ; 
	public static final String func_vk_06_020_02 = "vk_06_020_02" ;
	public static final String func_vk_06_020_03 = "vk_06_020_03" ; 
	public static final String func_vk_06_020_dt = "vk_06_020_dt" ; 
	
	public static final String func_vk_06_030_01 = "vk_06_030_01" ; 
	public static final String func_vk_06_030_dt = "vk_06_030_dt" ; 
	
	public static final String func_vk_06_040_01 = "vk_06_040_01" ; 
	public static final String func_vk_06_040_dt = "vk_06_040_dt" ; 
	
	public static final String func_vk_06_050_01 = "vk_06_050_01" ; 
	public static final String func_vk_06_050_02 = "vk_06_050_02" ; 
	public static final String func_vk_06_050_dt = "vk_06_050_dt" ; 
	
	public static final String func_vk_08_010_01 = "vk_08_010_01" ; 
	public static final String func_vk_08_010_dt = "vk_08_010_dt" ; 
	
	public static final String func_vk_08_020_01 = "vk_08_020_01" ; 
	public static final String func_vk_08_020_02 = "vk_08_020_02" ;
	public static final String func_vk_08_020_dt = "vk_08_020_dt" ; 
	
	public static final String func_vk_08_030_01 = "vk_08_030_01" ; 
	public static final String func_vk_08_030_dt = "vk_08_030_dt" ; 
	
	public static final String func_vk_08_040_01_1 = "vk_08_040_01_1" ; 
	public static final String func_vk_08_040_01_2 = "vk_08_040_01_2" ; 
	
	public static final String func_vk_08_040_02_1 = "vk_08_040_02_1" ; 
	public static final String func_vk_08_040_02_2 = "vk_08_040_02_2" ; 
	
	public static final String func_vk_08_040_03_1 = "vk_08_040_03_1" ; 
	public static final String func_vk_08_040_03_2 = "vk_08_040_03_2" ; 
	
	public static final String func_vk_08_040_04_1 = "vk_08_040_04_1" ; 
	public static final String func_vk_08_040_04_2 = "vk_08_040_04_2" ; 
	
	public static final String func_vk_08_040_05_1 = "vk_08_040_05_1" ; 
	public static final String func_vk_08_040_05_2 = "vk_08_040_05_2" ; 
	
	public static final String func_vk_08_040_06_1 = "vk_08_040_06_1" ; 
	public static final String func_vk_08_040_06_2 = "vk_08_040_06_2" ; 
	
	public static final String func_vk_08_040_07_1 = "vk_08_040_07_1" ; 
	public static final String func_vk_08_040_07_2 = "vk_08_040_07_2" ; 
	
	public static final String func_vk_08_040_08_1 = "vk_08_040_08_1" ; 
	public static final String func_vk_08_040_08_2 = "vk_08_040_08_2" ; 
	public static final String func_vk_08_040_dt = "vk_08_040_dt" ; 
	
	public static final String func_vk_08_050_01_01 = "vk_08_050_01_01" ; 
	public static final String func_vk_08_050_01_02 = "vk_08_050_01_02" ; 
	public static final String func_vk_08_050_01_03 = "vk_08_050_01_03" ; 
	public static final String func_vk_08_050_01_04 = "vk_08_050_01_04" ; 
	public static final String func_vk_08_050_01_05 = "vk_08_050_01_05" ; 
	public static final String func_vk_08_050_01_06 = "vk_08_050_01_06" ; 
	public static final String func_vk_08_050_01_07 = "vk_08_050_01_07" ; 
	public static final String func_vk_08_050_08_2 = "vk_08_050_08_2" ; 
	public static final String func_vk_08_050_dt = "vk_08_050_dt" ; 
	
	public static final String func_vk_08_060_01 = "vk_08_060_01" ; 
	public static final String func_vk_08_060_02 = "vk_08_060_02" ;
	public static final String func_vk_08_060_03 = "vk_08_060_03" ; 
	public static final String func_vk_08_060_04 = "vk_08_060_04" ;
	public static final String func_vk_08_060_dt = "vk_08_060_dt" ; 
	
	public static final String func_vk_08_070_01 = "vk_08_070_01" ; 
	public static final String func_vk_08_070_02 = "vk_08_070_02" ;
	public static final String func_vk_08_070_03 = "vk_08_070_03" ; 
	public static final String func_vk_08_070_04 = "vk_08_070_04" ; 
	public static final String func_vk_08_070_dt = "vk_08_070_dt" ; 
	
	public static final String func_vk_08_080_01 = "vk_08_080_01" ; 
	public static final String func_vk_08_080_02 = "vk_08_080_02" ;
	public static final String func_vk_08_080_03 = "vk_08_080_03" ; 
	public static final String func_vk_08_080_dt = "vk_08_080_dt" ; 
	
	public static final String func_vk_08_090_01 = "vk_08_090_01" ; 
	public static final String func_vk_08_090_dt = "vk_08_090_dt" ; 
	
	public static final String func_vk_08_100_01 = "vk_08_100_01" ; 
	public static final String func_vk_08_100_02 = "vk_08_100_02" ;
	public static final String func_vk_08_100_03 = "vk_08_100_03" ; 
	public static final String func_vk_08_100_04 = "vk_08_100_04" ; 
	public static final String func_vk_08_100_05 = "vk_08_100_05" ;
	public static final String func_vk_08_100_06 = "vk_08_100_06" ;
	public static final String func_vk_08_100_07 = "vk_08_100_07" ; 
	public static final String func_vk_08_100_08 = "vk_08_100_08" ; 
	public static final String func_vk_08_100_09 = "vk_08_100_09" ;
	public static final String func_vk_08_100_10 = "vk_08_100_10" ;
	public static final String func_vk_08_100_dt = "vk_08_100_dt" ; 
	
	public static final String func_vk_08_101_02 = "vk_08_101_02" ; 
	public static final String func_vk_08_101_dt = "vk_01_101_dt" ; 
	
	public static final String func_vk_08_110_01 = "vk_08_110_01" ; 
	public static final String func_vk_08_110_dt = "vk_08_110_dt" ; 
	
	public static final String func_vk_08_120_01 = "vk_08_120_01" ; 
	public static final String func_vk_08_120_02 = "vk_08_120_02" ; 
	public static final String func_vk_08_120_dt = "vk_08_120_dt" ; 
	
	public static final String func_vk_08_130_01 = "vk_08_130_01" ; 
	public static final String func_vk_08_130_02 = "vk_08_130_02" ; 
	public static final String func_vk_08_130_03 = "vk_08_130_03" ; 
	public static final String func_vk_08_130_dt = "vk_08_130_dt" ; 
	
	public static final String func_vk_08_140_01 = "vk_08_140_01" ; 
	public static final String func_vk_08_140_dt = "vk_08_140_dt" ; 
	
	public static final String func_vk_08_150_01 = "vk_08_150_01" ; 
	public static final String func_vk_08_150_dt = "vk_08_150_dt" ;
	
	public static final String func_vk_08_160_01 = "vk_08_160_01" ; 
	public static final String func_vk_08_160_dt = "vk_08_160_dt" ; 
	
	public static final String loop_vk_01_010_01 = "loop_vk_01_010_01" ; 
	public static final String loop_vk_01_010_02 = "loop_vk_01_010_02" ; 

	
	
	public static final String msg_key_parcelable = "parcelable" ;
	public static final String msg_key_int1 = "int1" ;
	public static final String msg_key_int2 = "int2" ;
	public static final String msg_key_int3 = "int3" ;
	public static final String msg_key_intGroup1 = "intGroup1" ;
	public static final String msg_key_intGroup2 = "intGroup2" ;
	public static final String msg_key_double1 = "double1" ;
	public static final String msg_key_double2 = "double2" ;
	public static final String msg_key_long1 = "long1" ;
	public static final String msg_key_long2 = "long2" ;
	public static final String msg_key_string1 = "string1" ;
	public static final String msg_key_string2 = "string2" ;
	public static final String msg_key_boolean1 = "boolean1" ;
	public static final String msg_key_boolean2 = "boolean2" ;
	public static final String msg_key_byteGroup1 = "byteGroup1" ;

	public static final int msg_main_message_long = 0 ; //消息
	public static final int msg_main_message_short = 1 ; //消息
	public static final int msg_main_receiveSm = 10 ; //接收到短信的消息
	
	public static final String Action_ReceiveRtuMs = "com.blg.rtu.ReceiveRtuMs";   
	
	public static final String wifi_connect_type = "wifi_connect_type" ;
	
	

}
