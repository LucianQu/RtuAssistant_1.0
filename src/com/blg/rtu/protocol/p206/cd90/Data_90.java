package com.blg.rtu.protocol.p206.cd90;

public class Data_90 {

	private Boolean success ;// 执行结果

	public String toString(){
		String s = "\n复位遥测终端参数和状态： " + (success==null?"":(success?"成功":"失败")) + "\n" ;
		return s ;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	

}
