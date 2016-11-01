package com.blg.rtu.protocol.p206.cdD8;


public class Data_D8 {

	private Boolean success ;

	private Integer type ;//1:10位 AD值  ; 2: 24位AD值
	private Integer channel ;//取值0--3
	
	private Double value ;//校准系数
	
	public Data_D8(){
		this.success = true ;
	}
	

	public String toString(){
		String s = "\n" ;
		if(this.success){
			s += "AD校准系数：" + "\n" +
					" 结果：" + (success?"成功":"失败")+ "\n" + 
					" 类型：" + (type.intValue() == 1?"10位 AD值":"24位AD值")+ "\n" + 
					" 通道：" + channel+ "\n" + 
					" 校准系数：" + value + "\n" ;
		}else{
			s += "AD校准系数：" + "\n" +
					" 结果：" + (success?"成功":"失败")+ "\n" ;
		}
		return s ;
	}


	public Boolean getSuccess() {
		return success;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getChannel() {
		return channel;
	}


	public void setChannel(Integer channel) {
		this.channel = channel;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}

}
