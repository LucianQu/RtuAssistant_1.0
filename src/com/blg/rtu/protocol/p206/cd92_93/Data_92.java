package com.blg.rtu.protocol.p206.cd92_93;

public class Data_92 {

	private Integer num ;// 水泵或阀门/闸门编码
	
	private Boolean success ;// 执行结果

	public String toString(){
		String s = "\n遥控启动水泵或阀门/闸门结果： " + (success==null?"":(success?"成功":"失败")) + "\n" ;
		s += "编号：" + num ;
		return s ;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	

}
