package com.blg.rtu.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class RtuCommand implements Serializable {

	private static final long serialVersionUID = 201408242315002L;

	/**
	 * 测控终端ID
	 */
	private String rtuId;// 前部分(6位数字，省2位，市2位，县2位)；后部分(测站选址范围为1-60000。中继站选址范围为60001-65534。65535 为广播地址，0 为无效地址)

	private String commandCode ;//命令功能码
	/**
	 * 参数java Bean 集合
	 */
	private HashMap<String, Object> params;


	/**
	 * 构造方法，初始化参数据集合(HashMap对象)
	 */
	public RtuCommand() {
		params = new HashMap<String, Object>();
	}

	public String toString() {
		String s = "params:\n";
		s += this.rtuId + "\n" ;
		Set<String> keys = params.keySet();
		for (String key : keys) {
			s += key + ":" + params.get(key) + "\n";
		}
		return s;
	}

	public HashMap<String, Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}

	public String getRtuId() {
		return this.rtuId;
	}
	public void setRtuId(String rtuId) {
		this.rtuId = rtuId;
	}
	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

}
