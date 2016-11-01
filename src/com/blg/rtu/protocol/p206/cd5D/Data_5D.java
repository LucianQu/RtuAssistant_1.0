package com.blg.rtu.protocol.p206.cd5D;

public class Data_5D {
//	ERC1 数据初始化记录 2
//	ERC2 参数变更记录2
//	ERC3 状态量变位记录 2
//	ERC4 仪表故障记录 2
//	ERC5 密码错误记录 2
//	ERC6 终端故障记录 2
//	ERC7 交流失电记录 2
//	ERC8 蓄电池电压低告警记录 2
//	ERC9 终端箱非法打开记录 2
//	ERC10 水泵故障记录 2
//	ERC11 剩余水量越限告警记录2
//	ERC12 水位超限告警记录 2
//	ERC13 水压超限告警记录2
//	ERC14 水质参数超限告警记录 2
//	ERC15 数据出错记录2
//	ERC16 发报文记录 2
//	ERC17 收报文记录 2
//	ERC18 发报文出错记录 2
//	ERC19—32 备用

	private Integer ERC1 ; // 数据初始化记录 2
	private Integer ERC2 ; // 参数变更记录2
	private Integer ERC3 ; // 状态量变位记录 2
	private Integer ERC4 ; // 仪表故障记录 2
	private Integer ERC5 ; // 密码错误记录 2
	private Integer ERC6 ; // 终端故障记录 2
	private Integer ERC7 ; // 交流失电记录 2
	private Integer ERC8 ; // 蓄电池电压低告警记录 2
	private Integer ERC9 ; // 终端箱非法打开记录 2
	private Integer ERC10  ; //水泵故障记录 2
	private Integer ERC11 ; // 剩余水量越限告警记录2
	private Integer ERC12 ; // 水位超限告警记录 2
	private Integer ERC13 ; // 水压超限告警记录2
	private Integer ERC14 ; // 水质参数超限告警记录 2
	private Integer ERC15 ; // 数据出错记录2
	private Integer ERC16 ; // 发报文记录 2
	private Integer ERC17  ; //收报文记录 2
	private Integer ERC18 ; // 发报文出错记录 2
	
	public String toString(){
		String s = "\n" ;
		s += "1 数据初始化记录:" + ERC1 + "次\n" ;
		s += "2 参数变更记录:" + ERC2 + "次\n" ;
		s += "3 状态量变位记录:" + ERC3 + "次\n" ;
		s += "4 仪表故障记录:" + ERC4 + "次\n" ;
		s += "5 密码错误记录:" + ERC5 + "次\n" ;
		s += "6 终端故障记录:" + ERC6 + "次\n" ;
		s += "7 交流失电记录:" + ERC7 + "次\n" ;
		s += "8 蓄电池电压低告警记录:" + ERC8 + "次\n" ;
		s += "9 终端箱非法打开记录:" + ERC9 + "次\n" ;
		s += "10 水泵故障记录:" + ERC10 + "次\n" ;
		s += "11 剩余水量越限告警记录:" + ERC11 + "次\n" ;
		s += "12 水位超限告警记录:" + ERC12 + "次\n" ;
		s += "13 水压超限告警记录:" + ERC13 + "次\n" ;
		s += "14 水质参数超限告警记录:" + ERC14 + "次\n" ;
		s += "15 数据出错记录:" + ERC15 + "次\n" ;
		s += "16 发报文记录:" + ERC16 + "次\n" ;
		s += "17 收报文记录:" + ERC17 + "次\n" ;
		s += "18 发报文出错记录:" + ERC18 + "次\n" ;
		
		return s ;
	}
	
	public Integer getERC1() {
		return ERC1;
	}
	public void setERC1(Integer eRC1) {
		ERC1 = eRC1;
	}
	public Integer getERC2() {
		return ERC2;
	}
	public void setERC2(Integer eRC2) {
		ERC2 = eRC2;
	}
	public Integer getERC3() {
		return ERC3;
	}
	public void setERC3(Integer eRC3) {
		ERC3 = eRC3;
	}
	public Integer getERC4() {
		return ERC4;
	}
	public void setERC4(Integer eRC4) {
		ERC4 = eRC4;
	}
	public Integer getERC5() {
		return ERC5;
	}
	public void setERC5(Integer eRC5) {
		ERC5 = eRC5;
	}
	public Integer getERC6() {
		return ERC6;
	}
	public void setERC6(Integer eRC6) {
		ERC6 = eRC6;
	}
	public Integer getERC7() {
		return ERC7;
	}
	public void setERC7(Integer eRC7) {
		ERC7 = eRC7;
	}
	public Integer getERC8() {
		return ERC8;
	}
	public void setERC8(Integer eRC8) {
		ERC8 = eRC8;
	}
	public Integer getERC9() {
		return ERC9;
	}
	public void setERC9(Integer eRC9) {
		ERC9 = eRC9;
	}
	public Integer getERC10() {
		return ERC10;
	}
	public void setERC10(Integer eRC10) {
		ERC10 = eRC10;
	}
	public Integer getERC11() {
		return ERC11;
	}
	public void setERC11(Integer eRC11) {
		ERC11 = eRC11;
	}
	public Integer getERC12() {
		return ERC12;
	}
	public void setERC12(Integer eRC12) {
		ERC12 = eRC12;
	}
	public Integer getERC13() {
		return ERC13;
	}
	public void setERC13(Integer eRC13) {
		ERC13 = eRC13;
	}
	public Integer getERC14() {
		return ERC14;
	}
	public void setERC14(Integer eRC14) {
		ERC14 = eRC14;
	}
	public Integer getERC15() {
		return ERC15;
	}
	public void setERC15(Integer eRC15) {
		ERC15 = eRC15;
	}
	public Integer getERC16() {
		return ERC16;
	}
	public void setERC16(Integer eRC16) {
		ERC16 = eRC16;
	}
	public Integer getERC17() {
		return ERC17;
	}
	public void setERC17(Integer eRC17) {
		ERC17 = eRC17;
	}
	public Integer getERC18() {
		return ERC18;
	}
	public void setERC18(Integer eRC18) {
		ERC18 = eRC18;
	}

	
	
}
