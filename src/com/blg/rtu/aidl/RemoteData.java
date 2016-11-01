package com.blg.rtu.aidl;

import java.io.Serializable;

import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.protocol.RtuData;

public class RemoteData implements Serializable {
	
	private static final long serialVersionUID = 201408242315000L;
	
	public RtuData data;
	public RtuCommand command;
	public byte[] byteDatas ;
	public String strData ;
	
	public RemoteData(RtuData data, RtuCommand command){
		this.data = data ;
		this.command = command ;
	}
	
	public RemoteData(byte[] byteDatas){
		this.byteDatas = byteDatas ;
	}
	
	public RemoteData(String str){
		this.strData = str ;
	}
	
}
