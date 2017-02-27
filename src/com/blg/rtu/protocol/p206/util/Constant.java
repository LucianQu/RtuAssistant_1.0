package com.blg.rtu.protocol.p206.util;

public class Constant {
	
	//字节头
	public static final byte HEAD = 0x68 ;
	//字节尾
	public static final byte TAIL = 0x16 ;
	
	public static final int Site_Control = 3 ;//控制域在RTU数据中的位置，数据是字节数组，数据组位置从0开始
	public static final int Site_RTUID = 4 ;//当无DIVS时，RTU ID在RTU数据中的位置，当有DIVS时，这个值要加1，数据是字节数组，数据组位置从0开始
	public static final int Site_Code = 9 ;//当无DIVS时，功能码在RTU数据中的位置，当有DIVS时，这个值要加1，数据是字节数组，数据组位置从0开始
	public static final int Site_Data = 10 ;//当无DIVS时，用户数据(不包括功能码)在RTU数据中的位置，当有DIVS时，这个值要加1，数据是字节数组，数据组位置从0开始

	
	public static final byte DIR_toRtu = 0 ;//下行报文，发向测控终端RTU的数据
	public static final byte DIR_phonetoRelay = 0 ;//下行报文，发向测控终端RTU的数据
	public static final byte DIR_fromRtu = 1 ;//上行报文，从测控终端RTU发来的数据
	public static final byte DIR_phoneToRtu = 1 ;//上行报文，从测控终端RTU发来的数据
	
	public static final byte DIV_yes = 1 ;//表示报文已被拆分为若干帧
	public static final byte DIV_no = 0 ;//表示报文未被拆分为若干帧

	public static final byte FCB_Default = 3 ;//FCB默认值
	public static final byte DIVS_Default = 0 ;//DIVS默认值

//	public static final byte Password_Default = 0 ;//密码的默认值
	
	public static final int Bits_Head = 3 ;//数据头字节数
	public static final int Bits_Len = 1 ;//帧长度字节数
	public static final int Bits_Control = 1 ;//控制域字节数
	public static final int Bits_RTU_ID = 5 ;//RTU ID域字节数
	public static final int Bits_Code = 1 ;//功能码字节数
	public static final int Bits_Password = 2 ;//密码字节数
	public static final int Bits_Time = 5 ;//时间标签字节数
	public static final int Bits_CRC = 1 ;//CRC域字节数（427协议用的是CRC8，一个字节）
	public static final int Bits_Tail = 1 ;//数据尾字节数
	
	
	public static final String LinkTest_F0 = "登录" ;
	public static final String LinkTest_F1 = "退出登录" ;
	public static final String LinkTest_F2 = "在线保持" ;
	public static final String LinkTest_unknow = "不能识别状态" ;
	
	public static final String Model_0 = "自报遥测" ;
	public static final String Model_1 = "自报确认" ;
	public static final String Model_2 = "遥测" ;
	public static final String Model_3 = "调试维修" ;
	
	public static final String ICCard_0 = "IC卡功能无效" ;
	public static final String ICCard_1 = "IC卡功能有效" ;

	public static final String BindValue_0 = "定值控制退出" ;
	public static final String BindValue_1 = "定值控制投入" ;

	public static final String Bump_0 = "水泵启动" ;
	public static final String Bump_1 = "水泵停止" ;

	public static final String BoxDoor_0 = "箱门开启" ;
	public static final String BoxDoor_1 = "箱门关闭" ;

	public static final String Power_0 = "AC220V供电" ;
	public static final String Power_1 = "蓄电池供电" ;

	
	//下行数据 控制域功能码
	public static final byte Down_ControlFunCode_0 = 0 ; // 发送∕确认 命令
	public static final byte Down_ControlFunCode_1 = 1 ; // 查询∕响应帧 雨量参数
	public static final byte Down_ControlFunCode_2 = 2 ; // 查询∕响应帧 水位参数
	public static final byte Down_ControlFunCode_3 = 3 ; // 查询∕响应帧 流量(水量)参数
	public static final byte Down_ControlFunCode_4 = 4 ; // 查询∕响应帧 流速参数
	public static final byte Down_ControlFunCode_5 = 5 ; // 查询∕响应帧 闸位参数
	public static final byte Down_ControlFunCode_6 = 6 ; // 查询∕响应帧 功率参数
	public static final byte Down_ControlFunCode_7 = 7 ; // 查询∕响应帧 气压参数
	public static final byte Down_ControlFunCode_8 = 8 ; // 查询∕响应帧 风速参数
	public static final byte Down_ControlFunCode_9 = 9 ; // 查询∕响应帧 水温参数
	public static final byte Down_ControlFunCode_10 = 10 ; // 查询∕响应帧 水质参数
	public static final byte Down_ControlFunCode_11 = 11 ; // 查询∕响应帧 土壤含水率参数
	public static final byte Down_ControlFunCode_12 = 12 ; // 查询∕响应帧 蒸发量参数
	public static final byte Down_ControlFunCode_13 = 13 ; // 查询∕响应帧 报警或状态参数
	//上行的14是统计雨量，所以下行的不应用14
	public static final byte Down_ControlFunCode_14 = 14 ; // 查询∕响应帧 综合参数
	public static final byte Down_ControlFunCode_15 = 15 ; //  查询∕响应帧 水压参数
	

	//上行数据 控制域功能码
	public static final byte Up_ControlFunCode_0 = 0 ; // 确认 认可
	public static final byte Up_ControlFunCode_1 = 1 ; // 自报帧 雨量参数
	public static final byte Up_ControlFunCode_2 = 2 ; // 自报帧 水位参数
	public static final byte Up_ControlFunCode_3 = 3 ; // 自报帧 流量（水量）参数
	public static final byte Up_ControlFunCode_4 = 4 ; // 自报帧 流速参数
	public static final byte Up_ControlFunCode_5 = 5 ; // 自报帧 闸位参数
	public static final byte Up_ControlFunCode_6 = 6 ; // 自报帧 功率参数
	public static final byte Up_ControlFunCode_7 = 7 ; // 自报帧 气压参数
	public static final byte Up_ControlFunCode_8 = 8 ; // 自报帧 风速参数
	public static final byte Up_ControlFunCode_9 = 9 ; // 自报帧 水温参数
	public static final byte Up_ControlFunCode_10 = 10 ; // 自报帧 水质参数
	public static final byte Up_ControlFunCode_11 = 11 ; // 自报帧 土壤含水率参数
	public static final byte Up_ControlFunCode_12 = 12 ; // 自报帧 蒸发量参数
	public static final byte Up_ControlFunCode_13 = 13 ; // 自报帧 报警或状态参数
	public static final byte Up_ControlFunCode_14 = 14 ; // 自报帧 综合参数(2012-12-15,王书超说，此处改为综合参数数据)
	//public static final byte Up_ControlFunCode_14 = 14 ; // 自报帧 统计雨量
	public static final byte Up_ControlFunCode_15 = 15 ; // 自报帧 水压参数
}
