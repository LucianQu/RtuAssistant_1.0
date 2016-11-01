package com.blg.rtu.protocol.p206.cd1E_63;

public class Data_63 extends Data_1E {

	protected Integer workA ;//置“1” 为工作机A 机正常，清“0” 为工作机A 机故障；
	protected Integer workB ;//置“1” 为工作机B 机正常，清“0” 为工作机B 机故障；
	protected Integer worker ;//置“1” 为工作机A 机现为值班机，清“0” 为工作机B 机现为值班机；
	protected Integer canRelay ;//置“1” 为中继站允许转发，清“0” 为中继站不允许转发；
	protected Integer powerAlarm ;//置“1” 为电源报警，清“0” 为电源正常；
	protected Integer relayFault ;//置“1” 为中继故障报警，清“0” 为中继正常；
//	1) D0——置“1” 为工作机A 机正常，清“0” 为工作机A 机故障；
//	2) D1——置“1” 为工作机B 机正常，清“0” 为工作机B 机故障；
//	3) D2——置“1” 为工作机A 机现为值班机，清“0” 为工作机B 机现为值班机；
//	4) D3——置“1” 为中继站允许转发，清“0” 为中继站不允许转发；
//	5) D4——置“1” 为电源报警，清“0” 为电源正常；
//	6) D5——置“1” 为中继故障报警，清“0” 为中继正常；
//	7) D6，D7——备用。
	
	protected String[] changedRecord ;//中继站最近切换记录
	
	public String toString(){
		String s = super.toString() ;
		s += "\n工作机A" + "=" + (this.workA==null?"":(workA == 1?"正常":"故障")) ;
		s += "\n工作机B" + "=" + (this.workB==null?"":(workB == 1?"正常":"故障")) ;
		s += "\n值班机" + "=" + (this.worker==null?"":(worker == 1?"工作机A":"工作机B")) ;
		s += "\n中继站允许转发" + "=" + (this.canRelay==null?"":(canRelay == 1?"是":"否")) ;
		s += "\n电源报警" + "=" + (this.powerAlarm==null?"":(powerAlarm == 1?"是":"否")) ;
		s += "\n中继故障报警" + "=" + (this.relayFault==null?"":(relayFault == 1?"是":"否")) ;
		if(changedRecord != null && changedRecord.length > 0){
			s += "\n中继站最近切换记录:\n" ;
			for(int i = 0 ; i < changedRecord.length ; i++){
				s += "    " + changedRecord[i] + "\n";
			}
		}
		return s ;
	}

	public Integer getWorkA() {
		return workA;
	}

	public void setWorkA(Integer workA) {
		this.workA = workA;
	}

	public Integer getWorkB() {
		return workB;
	}

	public void setWorkB(Integer workB) {
		this.workB = workB;
	}

	public Integer getWorker() {
		return worker;
	}

	public void setWorker(Integer worker) {
		this.worker = worker;
	}

	public Integer getCanRelay() {
		return canRelay;
	}

	public void setCanRelay(Integer canRelay) {
		this.canRelay = canRelay;
	}

	public Integer getPowerAlarm() {
		return powerAlarm;
	}

	public void setPowerAlarm(Integer powerAlarm) {
		this.powerAlarm = powerAlarm;
	}

	public Integer getRelayFault() {
		return relayFault;
	}

	public void setRelayFault(Integer relayFault) {
		this.relayFault = relayFault;
	}

	public String[] getChangedRecord() {
		return changedRecord;
	}

	public void setChangedRecord(String[] changedRecord) {
		this.changedRecord = changedRecord;
	}


}
