package com.blg.rtu.protocol.p206.cd21_22;

import java.io.Serializable;

public class Param_21 implements Serializable{
	
	private static final long serialVersionUID = 201709120924003L;

	public static final String KEY = Param_21.class.getName() ;
	

	protected Integer settlementDate ;// 
	
	public String toString(){
		String s = "\n结算日：\n" ;
		s += "日期 =" + settlementDate.intValue() + "\n" ;
		return s ;
	}

	public Integer getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Integer date) {
		this.settlementDate = date;
	}

}
