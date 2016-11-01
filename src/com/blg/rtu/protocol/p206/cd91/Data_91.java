package com.blg.rtu.protocol.p206.cd91;

public class Data_91 {
	
	private Integer clearType ;//清空类型

	public String toString(){
		String s = "\n清空遥测终端的历史数据单元：类型: " + 
				(clearType==null?""
				:(clearType.intValue()==Param_91.clearType_1.intValue()?"清空雨量"
				:(clearType.intValue()==Param_91.clearType_2.intValue()?"清空水位"
				:(clearType.intValue()==Param_91.clearType_3.intValue()?"清空流量"
				:(clearType.intValue()==Param_91.clearType_4.intValue()?"清空水温"
				:(clearType.intValue()==Param_91.clearType_5.intValue()?"清空水质"
				:(clearType.intValue()==Param_91.clearType_6.intValue()?"清空日志"
				:(clearType.intValue()==Param_91.clearType_7.intValue()?"清空事件"
				:(clearType.intValue()==Param_91.clearType_8.intValue()?"清空补报数据"
				:(clearType.intValue()==Param_91.clearType_0.intValue()?"清空全部"
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
