package com.blg.rtu.protocol.p206;


public class Code206 {

	public static final String agreementName = "p206_2012" ;
	
	///////////////////////////////////////////////
	//功能码都为16进制的字符串
	public static final String cd_02 = "02" ;//链路检测（AFN=02H）
	
	public static final String cd_10 = "10" ; //设置遥测终端、中继站地址
	public static final String cd_50 = "50" ; //查询遥测终端、中继站地址
	
	public static final String cd_44 = "44" ; //设置遥测终端、中继站地址
	public static final String cd_74 = "74" ; //查询遥测终端、中继站地址
	
	public static final String cd_11 = "11" ; //设置遥测终端、中继站时钟
	public static final String cd_51 = "51" ; //查询遥测终端、中继站时钟
	
	public static final String cd_12 = "12" ; //设置遥测终端工作模式
	public static final String cd_52 = "52" ; //查询遥测终端工作模式
	
	public static final String cd_A0 = "A0" ; //设置遥测站需查询的实时数据种类 
	public static final String cd_54 = "54" ; //查询遥测终端需查询的实时数据种类
	
	public static final String cd_A1 = "A1" ; //设置遥测终端的数据自报种类及时间间隔 
	public static final String cd_53 = "53" ; //查询遥测终端的数据自报种类及时间间隔
	
	public static final String cd_15 = "15" ; //设置遥测终端本次充值量
	public static final String cd_55 = "55" ; //查询遥测终端最近成功充值量和现有剩余水量

	public static final String cd_16 = "16" ; //设置遥测终端剩余水量报警值
	public static final String cd_56 = "56" ; //查询遥测终端的剩余水量和报警值

	public static final String cd_17 = "17" ; //设置遥测终端的水位基值、水位上下限
	public static final String cd_57 = "57" ; //查询遥测终端的水位基值、水位上下限及报警

	public static final String cd_18 = "18" ; //设置遥测终端水压上、下限
	public static final String cd_58 = "58" ; //查询遥测终端水压上、下限

	public static final String cd_19 = "19" ; //设置遥测终端水质参数种类、上限值
	public static final String cd_59 = "59" ; //查询遥测终端水质参数种类、上限值

	public static final String cd_1A = "1A" ; //设置遥测终端水质参数种类、下限值
	public static final String cd_5A = "5A" ; //查询遥测终端下限值水质参数种类、下限值

	public static final String cd_1B = "1B" ; //设置终端站流量的表底（初始）值

	public static final String cd_1C = "1C" ; //设置遥测终端转发中继引导码长
	public static final String cd_60 = "60" ; //查询遥测终端转发中继引导码长 

	public static final String cd_1D = "1D" ; //设置中继站转发终端地址
	public static final String cd_62 = "62" ; //查询中继站转发终端地址 

	public static final String cd_1E = "1E" ; //设置中继站工作机自动切换，自报状态
	public static final String cd_63 = "63" ; //查询中继站工作机状态和切换记录  

	public static final String cd_1F = "1F" ; //设置遥测终端流量参数上限值
	public static final String cd_64 = "64" ; //查询遥测终端流量参数上限值

	public static final String cd_20 = "20" ; //设置遥测终端检测参数启报阈值及固态存储时间段间隔
	
	public static final String cd_30 = "30" ; //置遥测终端IC 卡功能有效 
	public static final String cd_31 = "31" ; //取消遥测终端IC 卡功能 
	
	public static final String cd_32 = "32" ; //定值控制投入 
	public static final String cd_33 = "33" ; //定值控制退出 
	
	public static final String cd_34 = "34" ; //定值量设定 
	
	
	public static final String cd_5D = "5D" ; //查询遥测终端的事件记录 
	public static final String cd_5E = "5E" ; //查询遥测终端状态和报警状态 
	public static final String cd_5F = "5F" ; //查询水泵电机实时工作数据 
	public static final String cd_61 = "61" ; //查询遥测终端图像记录 

	public static final String cd_81 = "81" ; //随机自报报警数据 遥测终端 
	public static final String cd_82 = "82" ; //人工置数 遥测终端  
	public static final String cd_C0 = "C0" ; //遥测终端自报实时数据
	
	public static final String cd_90 = "90" ; //复位遥测终端参数和状态 
	public static final String cd_91 = "91" ; //清空遥测终端历史数据单元 
	public static final String cd_92 = "92" ; //遥控启动水泵或阀门/闸门 
	public static final String cd_93 = "93" ; //遥控关闭水泵或阀门/闸门 
	public static final String cd_94 = "94" ; //遥控终端或中继站通信机切换 
	public static final String cd_95 = "95" ; //遥控中继站工作机切换 
	public static final String cd_96 = "96" ; //修改遥测终端密码 
	
	public static final String cd_B0 = "B0" ; //查询遥测终端实时值 
	public static final String cd_B1 = "B1" ; //查询遥测终端固态存储数据 
	public static final String cd_B2 = "B2" ; //查询遥测终端内存自报数据 

	/////////////////////////////
	//扩展命令
	public static final String cd_E0 = "E0" ; //查询供电方式及电压
	public static final String cd_E1 = "E1" ; //查询电池池电压报警值
	public static final String cd_F1 = "F1" ; //设置电池池电压报警值
	public static final String cd_EF = "EF" ; //查询遥测终端硬软件版本号
	public static final String cd_CF = "CF" ; //查询DTU工作模式
	public static final String cd_DF = "DF" ; //设置DTU工作模式
	public static final String cd_C9 = "C9" ; //查询终端心跳周期
	public static final String cd_D9 = "D9" ; //设置终端心跳周期
	public static final String cd_CB = "CB" ; //查询终端主备通道
	public static final String cd_DB = "DB" ; //设置终端主备通道
	public static final String cd_CA = "CA" ; //查询GPRS接入点
	public static final String cd_DA = "DA" ; //设置GPRS接入点
	public static final String cd_CC = "CC" ; //查询中心网址
	public static final String cd_DC = "DC" ; //设置中心网址
	public static final String cd_CD = "CD" ; //查询短信中心号码
	public static final String cd_DD = "DD" ; //设置短信中心号码
	public static final String cd_43 = "43" ; //设置中继器关联ModBus地址
	public static final String cd_73 = "73" ; //查询中继器关联ModBus地址
	public static final String cd_CE = "CE" ; //查询卫星中心号码
	public static final String cd_DE = "DE" ; //设置卫星中心号码
	public static final String cd_C8 = "C8" ; //查询RTU在线状态
	public static final String cd_E2 = "E2" ; //查询电源采集校准系数
	public static final String cd_F2 = "F2" ; //设置电源采集校准系数
	public static final String cd_D8 = "D8" ; //设置AD校准命令(代替了F2命令)
	public static final String cd_D2 = "D2" ; //查询定时报协议格式
	public static final String cd_D6 = "D6" ; //设置定时报协议格式
	public static final String cd_D4 = "D4" ; //查询ICCID协议格式
	public static final String cd_D3 = "D3" ; //查询水表出厂编号
	public static final String cd_E3 = "E3" ; //查询仪表类型
	public static final String cd_F3 = "F3" ; //设置仪表类型
	public static final String cd_E4 = "E4" ; //查询仪表量程
	public static final String cd_F4 = "F4" ; //设置仪表量程
	public static final String cd_E5 = "E5" ; //查询仪表采集修正值
	public static final String cd_F5 = "F5" ; //设置仪表采集修正值
	public static final String cd_E6 = "E6" ; //查询仪表AD采集校准值
	public static final String cd_F6 = "F6" ; //设置仪表AD采集校准值
	public static final String cd_E9 = "E9" ; //查询仪表上电读值延时时间
	public static final String cd_F9 = "F9" ; //设置仪表上电读值延时时间
	public static final String cd_EA = "EA" ; //查询井口高程，水井深度，探头埋深
	public static final String cd_FA = "FA" ; //设置井口高程，水井深度，探头埋深
	public static final String cd_E7 = "E7" ; //查询数据采集种类及时间间隔
	public static final String cd_F7 = "F7" ; //设置数据采集种类及时间间隔
	public static final String cd_E8 = "E8" ; //查询上报起始时间
	public static final String cd_F8 = "F8" ; //设置上报起始时间
	public static final String cd_EB = "EB" ; //查询水位上报种类
	public static final String cd_FB = "FB" ; //设置水位上报种类
	public static final String cd_EC = "EC" ; //查询日志配置表
	public static final String cd_FC = "FC" ; //设置日志配置表
	
	public static final String cd_75 = "75" ; //查询LCD显示内容及刷屏间隔
	public static final String cd_45 = "45" ; //设置LCD显示内容及刷屏间隔
	
	public static final String cd_ED = "ED" ; //查询日志信息
	public static final String cd_D5 = "D5" ; //设置定时上报的时刻
	public static final String cd_C5 = "C5" ; //查询定时上报的时刻

	public static final String cd_42 = "42" ; //设置ModBus地址
	public static final String cd_72 = "72" ; //查询ModBus地址
	
	public static final String cd_4A = "4A" ; //设置RF频点
	public static final String cd_7A = "7A" ; //查询RF频点
	
	public static final String cd_4C = "4C" ; //设置LORA时间窗口
	public static final String cd_7C = "7C" ; //查询LORA时间窗口
	
	public static final String cd_F0 = "F0" ; //查询关键参数
	public static final String cd_C2 = "C2" ; //查询遥测终端流量实时值
	
	public static final String cd_76 = "76" ; //查询正积流量
	public static final String cd_46 = "46" ; //设置正积流量
	
	public static final String cd_77 = "77" ; //查询负积流量
	public static final String cd_47 = "47" ; //设置负积流量
	
	public static final String cd_78 = "78" ; //查询表口径
	public static final String cd_48 = "48" ; //设置表口径
	
	public static final String cd_79 = "79" ; //查询整体脉冲系数
	public static final String cd_49 = "49" ; //设置整体脉冲系数
	
	public static final String cd_7B = "7B" ; //查询一键触发测试结果
	public static final String cd_4B = "4B" ; //设置一键触发测试
	
	public static final String cd_4D = "4D" ; //设置LORA电源控制命令
	public static final String cd_4E = "4E" ; //设置出厂启用
	
	public static final String cd_40 = "40" ; //设置净积流量
	public static final String cd_70 = "70" ; //查询净积流量
	public static final String cd_41 = "41" ; //设置ModBus配置密码
	public static final String cd_4F = "4F" ; //发送ModBus密码
	public static final String cd_3F = "3F" ; //设置脉冲常数
	public static final String cd_6F = "6F" ; //查询脉冲常数
	public String getCodeName(String code) {
		String name = (code.equals(cd_02) ? "链路检测" : 
		
		(code.equals(cd_10) ? "设置遥测终端、中继站地址" : 
		(code.equals(cd_50) ? "查询遥测终端、中继站地址" : 
		
		(code.equals(cd_42) ? "设置ModBus地址" : 
		(code.equals(cd_72) ? "查询ModBus地址" : 
			
		(code.equals(cd_44) ? "设置遥测终端、中继站地址" : 
		(code.equals(cd_74) ? "查询遥测终端、中继站地址" : 
			
		(code.equals(cd_11) ? "设置遥测终端、中继站时钟" : 
		(code.equals(cd_51) ? "查询遥测终端、中继站时钟" : 
		
		(code.equals(cd_12) ? "设置遥测终端工作模式" : 
		(code.equals(cd_52) ? "查询遥测终端工作模式" : 
		
		(code.equals(cd_A0) ? "设置遥测站需查询的实时数据种类 " : 
		(code.equals(cd_54) ? "查询遥测终端需查询的实时数据种类" : 
		
		(code.equals(cd_A1) ? "设置遥测终端的数据自报种类及时间间隔" :  
		(code.equals(cd_53) ? "查询遥测终端的数据自报种类及时间间隔" : 
		
		(code.equals(cd_15) ? "设置遥测终端本次充值量" : 
		(code.equals(cd_55) ? "查询遥测终端最近成功充值量和现有剩余水量" : 

		(code.equals(cd_16) ? "设置遥测终端剩余水量报警值" : 
		(code.equals(cd_56) ? "查询遥测终端的剩余水量和报警值" : 

		(code.equals(cd_17) ? "设置遥测终端的水位基值、水位上下限" : 
		(code.equals(cd_57) ? "查询遥测终端的水位基值、水位上下限及报警" : 

		(code.equals(cd_18) ? "设置遥测终端水压上、下限" : 
		(code.equals(cd_58) ? "查询遥测终端水压上、下限" : 

		(code.equals(cd_19) ? "设置遥测终端水质参数种类、上限值" : 
		(code.equals(cd_59) ? "查询遥测终端水质参数种类、上限值" : 

		(code.equals(cd_1A) ? "设置遥测终端水质参数种类、下限值" : 
		(code.equals(cd_5A) ? "查询遥测终端下限值水质参数种类、下限值" : 

		(code.equals(cd_1B) ? "设置终端站流量的表底（初始）值" : 

		(code.equals(cd_1C) ? "设置遥测终端转发中继引导码长" : 
		(code.equals(cd_60) ? "查询遥测终端转发中继引导码长 " : 

		(code.equals(cd_1D) ? "设置中继站转发终端地址" : 
		(code.equals(cd_62) ? "查询中继站转发终端地址 " : 

		(code.equals(cd_1E) ? "设置中继站工作机自动切换，自报状态" : 
		(code.equals(cd_63) ? "查询中继站工作机状态和切换记录" :   

		(code.equals(cd_1F) ? "设置遥测终端流量参数上限值" : 
		(code.equals(cd_64) ? "查询遥测终端流量参数上限值" : 

		(code.equals(cd_20) ? "设置遥测终端检测参数启报阈值及固态存储时间段间隔" : 
		
		(code.equals(cd_30) ? "置遥测终端IC 卡功能有效 " : 
		(code.equals(cd_31) ? "取消遥测终端IC 卡功能" :  
		
		(code.equals(cd_32) ? "定值控制投入" :  
		(code.equals(cd_33) ? "定值控制退出" :  
		
		(code.equals(cd_34) ? "定值量设定" :  
		
		
		(code.equals(cd_5D) ? "查询遥测终端的事件记录" :  
		(code.equals(cd_5E) ? "查询遥测终端状态和报警状态 " : 
		(code.equals(cd_5F) ? "查询水泵电机实时工作数据 " : 
		(code.equals(cd_61) ? "查询遥测终端图像记录 " : 

		(code.equals(cd_81) ? "随机自报报警数据 遥测终端 " : 
		(code.equals(cd_82) ? "人工置数 遥测终端  " : 
		(code.equals(cd_C0) ? "遥测终端自报实时数据" : 
		
		(code.equals(cd_90) ? "复位遥测终端参数和状态 " : 
		(code.equals(cd_91) ? "清空遥测终端历史数据单元 " : 
		(code.equals(cd_92) ? "遥控启动水泵或阀门/闸门" :  
		(code.equals(cd_93) ? "遥控关闭水泵或阀门/闸门 " : 
		(code.equals(cd_94) ? "遥控终端或中继站通信机切换" :  
		(code.equals(cd_95) ? "遥控中继站工作机切换 " : 
		(code.equals(cd_96) ? "修改遥测终端密码 " : 
		
		(code.equals(cd_B0) ? "查询遥测终端实时值" :  
		(code.equals(cd_B1) ? "查询遥测终端固态存储数据 " : 
		(code.equals(cd_B2) ? "查询遥测终端内存自报数据 " : 
		
		/////////////////////////////
		//扩展命令
		(code.equals(cd_EF) ? "查询遥测终端硬件软件版本号 " : 
		(code.equals(cd_E0) ? "查询供电方式及电压 " : 
		(code.equals(cd_E1) ? "查询电池池电压报警值 " : 
		(code.equals(cd_F1) ? "设置电池池电压报警值 " : 
		(code.equals(cd_CF) ? "查询DTU工作模式" : 
		(code.equals(cd_DF) ? "设置DTU工作模式" : 
		(code.equals(cd_C9) ? "查询终端心跳周期" : 
		(code.equals(cd_D9) ? "设置终端心跳周期" : 
		(code.equals(cd_CB) ? "查询主备通道" : 
		(code.equals(cd_DB) ? "设置主备通道" : 
		(code.equals(cd_CA) ? "查询GPRS接入点" : 
		(code.equals(cd_DA) ? "设置GPRS接入点" : 
		(code.equals(cd_CC) ? "查询中心网址" : 
		(code.equals(cd_DC) ? "设置中心网址" : 
		(code.equals(cd_CD) ? "查询短信中心号码" : 
		(code.equals(cd_DD) ? "设置短信中心号码" :
			
		(code.equals(cd_43) ? "设置中继器关联ModBus地址" : 
		(code.equals(cd_73) ? "查询中继器关联ModBus地址" :	
			
		(code.equals(cd_CE) ? "查询卫星中心号码" : 
		(code.equals(cd_DE) ? "设置卫星中心号码" : 
		(code.equals(cd_C8) ? "查询RTU在线状态" : 
		(code.equals(cd_E2) ? "查询电源采集校准系数" : 
		(code.equals(cd_F2) ? "设置电源采集校准系数" : 
		(code.equals(cd_D8) ? "设置AD校准命令" : 
		(code.equals(cd_E3) ? "查询仪表系数" : 
		(code.equals(cd_F3) ? "设置仪表系数" : 
		(code.equals(cd_E4) ? "查询仪表量程" : 
		(code.equals(cd_F4) ? "设置仪表量程" : 
		(code.equals(cd_E5) ? "查询仪表采集修正值" : 
		(code.equals(cd_F5) ? "设置仪表采集修正值" : 
		(code.equals(cd_E6) ? "查询仪表AD采集校准值" : 
		(code.equals(cd_F6) ? "设置仪表AD采集校准值" : 
		(code.equals(cd_E9) ? "查询仪表上电读值延时时间" : 
		(code.equals(cd_F9) ? "设置仪表上电读值延时时间" : 
		(code.equals(cd_EA) ? "查询井口高程，水井深度，探头埋深" : 
		(code.equals(cd_FA) ? "设置井口高程，水井深度，探头埋深" : 
		(code.equals(cd_E7) ? "查询数据采集种类及时间间隔" : 
		(code.equals(cd_F7) ? "设置数据采集种类及时间间隔" : 
		(code.equals(cd_E8) ? "查询上报起始时间" : 
		(code.equals(cd_F8) ? "设置上报起始时间" : 
		(code.equals(cd_EB) ? "查询水位上报种类" : 
		(code.equals(cd_FB) ? "设置水位上报种类" : 
		(code.equals(cd_EC) ? "查询日志配置表" : 
		(code.equals(cd_FC) ? "设置日志配置表" :
		(code.equals(cd_75) ? "查询LCD显示内容及刷屏间隔" : 
		(code.equals(cd_45) ? "设置LCD显示内容及刷屏间隔" :	
		(code.equals(cd_ED) ? "查询日志信息" : 
		(code.equals(cd_D5) ? "设置定时上报的时刻" :
		(code.equals(cd_C5) ? "查询定时上报的时刻" : 
		(code.equals(cd_F0) ? "查询关键参数" : 
		(code.equals(cd_C2) ? "终端流量实时值" : 
		(code.equals(cd_D3) ? "查询水表出厂编号" : 	
		(code.equals(cd_D4) ? "查询SIM卡ICCID" : 	
		(code.equals(cd_D2) ? "查询上报协议配置" : 	
		(code.equals(cd_D6) ? "查询设置上报协议配置" : 
		(code.equals(cd_46) ? "设置正积流量" : 
		(code.equals(cd_76) ? "查询正积流量" : 	
		(code.equals(cd_47) ? "设置负积流量" : 	
		(code.equals(cd_77) ? "查询负积流量" : 	
		(code.equals(cd_40) ? "设置净积流量" : 
		(code.equals(cd_70) ? "查询净积流量" : 
		(code.equals(cd_41) ? "设置ModBus配置密码" : 
		(code.equals(cd_7A) ? "查询RF频点" : 	
		(code.equals(cd_4A) ? "设置RF频点" : 
		(code.equals(cd_78) ? "查询表口径" : 	
		(code.equals(cd_48) ? "设置表口径" : 
		(code.equals(cd_79) ? "查询整体脉冲系数" : 	
		(code.equals(cd_49) ? "设置整体脉冲系数" : 
		(code.equals(cd_7B) ? "查询一键测试结果" : 	
		(code.equals(cd_4B) ? "设置一键测试" : 
		(code.equals(cd_7C) ? "查询LORA时间窗口" : 	
		(code.equals(cd_4C) ? "设置LORA时间窗口" :
		(code.equals(cd_4D) ? "LORA电源控制命令" : 
		(code.equals(cd_4E) ? "设置出厂启用" : 
		(code.equals(cd_4F) ? "发送ModBus密码" : 
		(code.equals(cd_3F) ? "设置脉冲常数" : 
		(code.equals(cd_6F) ? "查询脉冲常数" : 
		"")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
		))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))) ;
		return name ;
	}
}

