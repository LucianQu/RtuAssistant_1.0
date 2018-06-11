package com.blg.rtu.protocol.p206.cd97_98;


public class Data_97_98 {
	
	//命令设置： 0代表剩余流量和阀门控制不关联，1代表剩余流量和阀门控制关联
	
	public static final int modelNoRelev = 0 ;//不关联
	public static final int modelRelev = 1 ;//关联
	public static final int modelTiming = 2 ;//定时上线

	private Integer model ;

	public String toString(){
		String s = "\n" ;
		s += "model" + "=" + (this.model==null?"":
			this.model.intValue()==0?"剩余流量和阀门控制不关联":
				this.model.intValue()==1?"剩余流量和阀门控制关联":
							"出错，未知的关联状态"
			) ;
		return s ;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}


}
