package com.blg.rtu.protocol;


public abstract class DriverRtu {
	
	//下行RTU的命令数据
	protected byte[] downData;
	
	//rtu上行数据
	protected RtuData upData ;

	//下发命令时设置的RTU ID，或上报数据中的RTU ID 
	protected String rtuId;// 前部分(6位数字，省2位，市2位，县2位)；后部分(测站选址范围为1-60000。中继站选址范围为60001-65534。65535 为广播地址，0 为无效地址)
	protected String rtuId_hex;//id的16进制形式
	
	//更改 测控终端 ID命令应答后，应答数据中的新的 测控终端 ID，
	protected String newRtuId;
	
	//命令的功能码
	protected String commandCode ;

	//数据中的功能码
	protected String dataCode ;
	
	//错误消息
	protected String error;
	
	/**
	 * 带参数的构造方法，参数为协议名称
	 * @param agreementName 协议名称
	 */
	public DriverRtu(){
	}

	/**
	
	/**
	 * 分析测控终端数据
	 * @param rtuId
	 * @param data
	 * @param dataHex
	 * @return
	 */
	public abstract Action analyseData(byte[] data) ;
	/**
	 * 构造针对测控终端(测控终端)的命令
	 * @param command 命令
	 * @return
	 */
	public abstract Action createCommand(RtuCommand command);
	
	/**
	 * 直接创建设置时钟命令
	 * @return
	 */
	public abstract byte[] createSetClockOrderDirect(String rtuId) ;

	/**
	 * 错误消息
	 * @return
	 */
	public String getError() {
		return error;
	}

	

	public byte[] getDownData() {
		return downData;
	}

	public void setDownData(byte[] downData) {
		this.downData = downData;
	}

	public RtuData getUpData() {
		return upData;
	}

	public void setUpData(RtuData upData) {
		this.upData = upData;
	}

	public String getRtuId() {
		return rtuId;
	}

	public void setRtuId(String rtuId) {
		this.rtuId = rtuId;
	}

	public String getNewRtuId() {
		return newRtuId;
	}

	public void setNewRtuId(String newRtuId) {
		this.newRtuId = newRtuId;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getRtuId_hex() {
		return rtuId_hex;
	}

	public void setRtuId_hex(String rtuId_hex) {
		this.rtuId_hex = rtuId_hex;
	}

	
}
