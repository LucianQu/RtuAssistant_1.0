package com.blg.rtu.protocol.p206.cdB1;

public class Data_B1 {
	
	public Double valueDbl ;
	public Long valueLng ;
	public String valueUnit ;
	public String valueFFF ;
	
	public Integer fengXiang ;//附加数据
	
	public String toString(){
		String s = "\n" ;
		s += "数值：" + (valueDbl==null?(valueLng==null?(valueFFF==null?"":valueFFF):valueLng):valueDbl) + (valueUnit==null?"":valueUnit) ;
		if(fengXiang != null){
			s += "\n风向：" + fengXiang ;
		}
		return s + "\n" ;
	}

}
