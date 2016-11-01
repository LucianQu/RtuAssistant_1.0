package com.blg.rtu.protocol;

import java.io.Serializable;

import com.blg.rtu.util.Constant;


/**
 * 数据标识接口
 * @author Administrator
 *
 */
public class RtuData implements Serializable {
	
	private static final long serialVersionUID = 201408242315001L;
	
	public Integer channelType;//通道类型 Constant中定义
	public String rtuId ;
	public String rtuId_hex ;
	public String dataCode ;//数据所对应的功能码:
	public Object subData ;//对应各个功能码的具体数据
	public String hex ;//上报数据的十六进制


	
	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public String getDataCode() {
		return dataCode;
	}

	public String getRtuId() {
		return rtuId;
	}

	public void setRtuId(String rtuId) {
		this.rtuId = rtuId;
	}

	public String getRtuId_hex() {
		return rtuId_hex;
	}

	public void setRtuId_hex(String rtuId_hex) {
		this.rtuId_hex = rtuId_hex;
	}

	public void setDataCode(String code) {
		this.dataCode = code;
	}

	public Object getSubData() {
		return subData;
	}

	public void setSubData(Object subData) {
		this.subData = subData;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public String toString() {
		String s = "数据的十六进制 : " + (hex == null?"":hex) + "\n" ; //
		s += "通道类型：" + (channelType == null?"":	Constant.channelType(channelType.intValue())) ;
		s += "rtuId : " + (rtuId==null?"":rtuId) + "\n" ;
		s += "code : " + (dataCode == null?"":dataCode) + "\n" ; //
//		s += "clock : " + (clock == null?"":clock) + "\n" ; //
		if(this.subData  != null){
			s += "子数据：\n" + this.subData.toString() ;
		}
		return s ;
	}


}
