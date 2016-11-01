package com.blg.rtu.protocol.p206.cd91;

import java.io.Serializable;


public class Param_91 implements Serializable{

	private static final long serialVersionUID = 201212101129001L;

	public static final String KEY = Param_91.class.getName() ;


	public static final Integer clearType_0 = 0 ;//清空全部
	public static final Integer clearType_1 = 1 ;//清空雨量
	public static final Integer clearType_2 = 2 ;//清空水位
	public static final Integer clearType_3 = 3 ;//清空 流量
	public static final Integer clearType_4 = 4 ;//清空水温 
	public static final Integer clearType_5 = 5 ;//清空水质
	public static final Integer clearType_6 = 6 ;//清空日志 
	public static final Integer clearType_7 = 7 ;//清空 事件
	public static final Integer clearType_8 = 8 ;//清空四个中心的补报数据

	private Integer clearType ;//清空类型
	


	public String toString(){
		String s = "\n清空遥测终端的历史数据单元：类型: " + 
				(clearType==null?""
				:(clearType.intValue()==clearType_0.intValue()?"清空全部"
				:(clearType.intValue()==clearType_1.intValue()?"清空雨量"
				:(clearType.intValue()==clearType_2.intValue()?"清空水位"
				:(clearType.intValue()==clearType_3.intValue()?"清空流量"
				:(clearType.intValue()==clearType_4.intValue()?"清空水温"
				:(clearType.intValue()==clearType_5.intValue()?"清空水质"
				:(clearType.intValue()==clearType_6.intValue()?"清空日志"
				:(clearType.intValue()==clearType_7.intValue()?"清空事件"
				:(clearType.intValue()==clearType_8.intValue()?"清空补报数据"
				:""
				)))))))))) 
		+ "\n" ;
		return s ;
	}



	public Integer getClearType() {
		return clearType;
	}

	public void setClearType(Integer clearType) {
		this.clearType = clearType;
	}


}
