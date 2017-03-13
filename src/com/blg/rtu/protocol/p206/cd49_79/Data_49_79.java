package com.blg.rtu.protocol.p206.cd49_79;

public class Data_49_79 {
	
	private int plus1Partition ;//正向第一分区系数
	private int plus2Partition ;//正向第二分区系数
	private int plus3Partition ;//正向第三分区系数
	private int plus4Partition ;//正向第四分区系数
	private int plus5Partition ;//正向第五分区系数
	
	private int minus1Partition ;//反向第一分区系数
	private int minus2Partition ;//反向第二分区系数
	private int minus3Partition ;//反向第三分区系数
	private int minus4Partition ;//反向第四分区系数
	private int minus5Partition ;//反向第五分区系数
	
	
	
	public String toString(){
		String s = "整体脉冲系数：" ; 
		s += "\n正向第一分区系数: " + plus1Partition ;
		s += "\n正向第二分区系数: " + plus2Partition ;
		s += "\n正向第三分区系数: " + plus3Partition ;
		s += "\n正向第四分区系数: " + plus4Partition ;
		s += "\n正向第五分区系数: " + plus5Partition ;
		s += "\n反向第一分区系数: " + minus1Partition ;
		s += "\n反向第二分区系数: " + minus2Partition ;
		s += "\n反向第三分区系数: " + minus3Partition ;
		s += "\n反向第四分区系数: " + minus4Partition ;
		s += "\n反向第五分区系数: " + minus5Partition ;
		return s ;
	}


	
	public int getPlus1Partition() {
		return plus1Partition;
	}


	public void setPlus1Partition(int plus1Partition) {
		this.plus1Partition = plus1Partition;
	}
	
	public int getPlus2Partition() {
		return plus2Partition;
	}


	public void setPlus2Partition(int plus2Partition) {
		this.plus2Partition = plus2Partition;
	}
	
	public int getPlus3Partition() {
		return plus3Partition;
	}


	public void setPlus3Partition(int plus3Partition) {
		this.plus3Partition = plus3Partition;
	}
	
	public int getPlus4Partition() {
		return plus4Partition;
	}


	public void setPlus4Partition(int plus4Partition) {
		this.plus4Partition = plus4Partition;
	}
	
	public int getPlus5Partition() {
		return plus5Partition;
	}


	public void setPlus5Partition(int plus5Partition) {
		this.plus5Partition = plus5Partition;
	}
	////////////////////////////////
	public int getMinus1Partition() {
		return minus1Partition;
	}


	public void setMinus1Partition(int minus1Partition) {
		this.minus1Partition = minus1Partition;
	}
	
	public int getMinus2Partition() {
		return minus2Partition;
	}


	public void setMinus2Partition(int minus2Partition) {
		this.minus2Partition = minus2Partition;
	}
	
	public int getMinus3Partition() {
		return minus3Partition;
	}


	public void setMinus3Partition(int minus3Partition) {
		this.minus3Partition = minus3Partition;
	}
	
	public int getMinus4Partition() {
		return minus4Partition;
	}


	public void setMinus4Partition(int minus4Partition) {
		this.minus4Partition = minus4Partition;
	}
	public int getMinus5Partition() {
		return minus5Partition;
	}


	public void setMinus5Partition(int minus5Partition) {
		this.minus5Partition = minus5Partition;
	}
}
