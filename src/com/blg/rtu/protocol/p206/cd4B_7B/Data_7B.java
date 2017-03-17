package com.blg.rtu.protocol.p206.cd4B_7B;

public class Data_7B {
	
	public static final String KEY = Param_4B.class.getName() ;
	
	public static final int triggerType0 = 0 ;//触发GSM测试
	public static final int triggerType1 = 1 ;//触发LORA测试
	private Integer queryResult ;// 

	public String toString(){
		String s = "\n一键测试触发结果：\n" ;
		s += "类型=" + queryResult + "\n" ;
		return s ;
	}

	public Integer getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(Integer queryResult) {
		this.queryResult = queryResult;
	}
}
