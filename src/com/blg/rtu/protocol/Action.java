package com.blg.rtu.protocol ;


public class Action {
	private int op;

	
	/**
	 * 没有动作
	 */
	private static final Action nullAction = new Action(0);
	/**
	 * 没有动作
	 */
	public static final Action noAction = new Action(1);

	/**
	 * 向测控端回复确认
	 */
	public static final Action remoteConfirmAction = new Action(2);
	
	/**
	 * 向测控端发命令 ，命令有应答(有命令结果)，可以发送多次
	 */
	public static final Action remoteCommandAction = new Action(4);
	
	/**
	 * 向测控端发命令 ，命令有应答(有命令结果)，只发送一次
	 */
	public static final Action remoteCommandSendOnlyOnceAction = new Action(8);
	
	/**
	 * 读RTU ID命令结果
	 */
	public static final Action commandReadRtuIdResultAction = new Action(16);
	
	/**
	 * 命令结果
	 */
	public static final Action commandResultAction = new Action(32);
	
	/**
	 * 主动上报数据
	 */
	public static final Action autoReportAction = new Action(64);

	/**
	 * 修改测控终端ID
	 */
	public static final Action changeRtuIdAction = new Action(128);

	/**
	 * 同步测控终端与通信中间件时钟，即对测控终端较时
	 */
	public static final Action synchronizeClock = new Action(256);
	
	/**
	 * 未知的命令
	 */
	public static final Action unknownAction = new Action(512);

	/**
	 * 出错
	 */
	public static final Action errorAction = new Action(1024);

	private Action(int op) {
		this.op = op;
	}

	/**
	 * 得到空Action
	 * @return
	 */
	public static Action nullAction(){
		return new Action(nullAction.op) ;
	}
	
	//当前Action中，是否存在上面预定义的某一个Action
	public boolean contain(Action action) {
		return (this.op & action.op) != 0;
	}

	//在一个Action中加入另外一个Action,
	public void append(Action action) {
		this.op = (this.op | action.op);
	}

	/**
	 * 比较两个Action是否想等
	 * @param Action Action
	 * @return boolean
	 */
	public boolean equals(Action action) {
		return this.op == action.op;
	}
	
	public String toString(){
		return this.op + "" ;
	}
	
	public static void main(String[] args){
		int t1 = 31 ;//11111
		System.out.println(t1 ^ (t1>>1)) ;
		System.out.println(t1<<1) ;
		System.out.println(t1>>4) ;
		System.out.println(t1>>6) ;
		
	}
}

