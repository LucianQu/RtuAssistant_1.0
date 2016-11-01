package com.blg.rtu.protocol.p206.cd90;

import java.io.Serializable;

public class Param_90  implements Serializable{

	private static final long serialVersionUID = 201212101119001L;

	public static final String KEY = Param_90.class.getName() ;


	public static final Integer resetType_1 = 1 ;//代表遥测终端复位，重新开始运行，参数不变
	public static final Integer resetType_2 = 2 ;//代表遥测终端复位，重新开始运行，遥测终端参数恢复出厂默认值，需要重新配置参数。但是终端内的历史数据不变

	
	private Integer resetType ;//复位类型
	


	public String toString(){
		String s = "\n复位遥测终端参数和状态：类型: " + (resetType==null?"":(resetType.intValue()==resetType_1.intValue()?"终端复位，重新开始运行，参数不变":(resetType.intValue()==resetType_2.intValue()?"终端复位，重新开始运行，遥测终端参数恢复出厂默认值":""))) + "\n" ;
		return s ;
	}



	public Integer getResetType() {
		return resetType;
	}

	public void setResetType(Integer resetType) {
		this.resetType = resetType;
	}

}
