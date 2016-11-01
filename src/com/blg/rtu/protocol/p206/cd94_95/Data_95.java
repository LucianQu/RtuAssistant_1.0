package com.blg.rtu.protocol.p206.cd94_95;

public class Data_95 {

	private String worker_A0rB ;//值班机A或B
	
	private Boolean success ;// 执行结果

	public String toString(){
		String s = "\n遥控中继站工作机切换结果： " + (success==null?"":(success?"成功":"失败")) + "\n" ;
		s += "值班机：" + worker_A0rB ;
		return s ;
	}

	public String getWorker_A0rB() {
		return worker_A0rB;
	}

	public void setWorker_A0rB(String workerA0rB) {
		worker_A0rB = workerA0rB;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
}
