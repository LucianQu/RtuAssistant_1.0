package com.blg.rtu.protocol.p206.cdB0;

public class DataVO {
	
	public String dataName ;
	public Double valueDbl ;
	public Long valueLng ;
	public String valueUnit ;
	
	public Integer fengXiang ;//附加数据
	
	public String toString(){
		String s = "\n" ;
		s += dataName + "：" + (valueDbl==null?(valueLng==null?"":valueLng):valueDbl) + (valueUnit==null?"":valueUnit) ;
		if(fengXiang != null){
			s += "\n风向：" + fengXiang ;
		}
		return s + "\n" ;
	}

}
