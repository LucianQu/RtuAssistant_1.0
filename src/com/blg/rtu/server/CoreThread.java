package com.blg.rtu.server;


import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.CommandCreator;
import com.blg.rtu.util.StringValueForServer;

public class CoreThread {
	
	private static Object synObj_Control = new Object() ;
	private static Object synObj_canAutoQuery = new Object() ;
	private static Object synObj_doAutoQuery = new Object() ;
	private static Object synObj_canAutoSet = new Object() ;
	private static Object synObj_doAutoSet = new Object() ;
	
	private static CoreThread instance ;
	
	private static LocalServer server ;
	
	private static ControlThread innerThread ;
	private static AutoQueryThread autoQueryThread ;
	private static AutoSetThread autoSetThread ;
	
	/**
	 * 	事件类型：
	 * 	无事件：0；
	 * 	连接网络：1；
	 * 	断开网络: 2；
	 * 	收到RTUID：3 ；
	 */
	private static int event ;
	
	private static Boolean netConnected ;
	private static String rtuId ;
	
	private static long lastSendAutoCommandTime = 0 ;
	
	private CoreThread(){
	}
	
	/**
	 * 本方法创建单例，只有 本地Server启动时创建本单例。
	 * @param activityProxy
	 * @return
	 */
	public static CoreThread creatSingle(LocalServer server){
		/*
		 * 这样不行，当MainActivity重新绑定Server时，因为Server未被系统杀死，与它关联的对象都还活着，当Activity重新绑定Server时，这些对象要重构的，尤其要传进来一些新创建的对象，要把老对象替换
		if(instance == null){
			instance = new CoreThread();
			.....
		}
		*/
		instance = new CoreThread() ;
		CoreThread.server = server ;
		
		event = 0 ;
		rtuId = null ;
		
		innerThread = instance.new ControlThread();
		innerThread.start();
		
		autoQueryThread = instance.new AutoQueryThread();
		autoQueryThread.start();
		
		autoSetThread = instance.new AutoSetThread();
		autoSetThread.start();
		
		return instance ;
	}
	
	/**
	 * 当Server创建本单例前，调用此方法得到的实例为空
	 * @return
	 */
	public static CoreThread getInstance(){
		return instance ;
	}
	
	/**
	 * 网络已经连接上，需要发送查询RTU地址的广播命令
	 */
	public void netConnected(){
		synchronized (synObj_Control) {
			netConnected = true ;
			event = 1 ;
			synObj_Control.notifyAll() ;
		}
	}
	/**
	 * 网络已经已经断开 
	 */
	public void netDisconnect(){
		synchronized (synObj_Control) {
			CoreThread.rtuId = null ;
			netConnected = false ;
			event = 2 ;
			synObj_Control.notifyAll() ;
		}
	}
	/**
	 * 已经收到RTU地址 
	 * @param rtuId
	 */
	public void rtuIdReceived(String rtuId){
		if(CoreThread.rtuId == null){
			//只有第一次查询时，才会产生事件，进而下发自动查询，这样可以防止手动多次查询RTU ID，而造成下发自动查询命令
			synchronized (synObj_Control) {
				CoreThread.rtuId = rtuId ;
				event = 3 ;
				synObj_Control.notifyAll() ;
			}
		}
	}
	
	/**
	 * 通过下发修改RTU ID的命令，命令成功后，新的RTU ID生效
	 * @param rtuId
	 */
	public void newRtuId(String rtuId){
		CoreThread.rtuId = rtuId ;
	}
	
	/**
	 * 对外提供RTU ID
	 * @return
	 */
	public String getRtuId(){
		return CoreThread.rtuId ;
	}
	
	/**
	 * 来自界面操作自动查询任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	public String operateAutoQuery(boolean start, boolean pause, boolean resume, boolean stop){
		return autoQueryThread.operate(start, pause, resume, stop) ;
	}

	/**
	 * 向界面通知自动查询状态
	 * @param status
	 * @return
	 */
	public void notifyAutoQueryStatus(String status){
		new CoreControl(server).notifyAutoQueryStatus(status) ;
	}
	
	/**
	 * 来自界面操作自动设置任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
	public String operateAutoSet(boolean start, boolean pause, boolean resume, boolean stop){
		return autoSetThread.operate(start, pause, resume, stop) ;
	}

	/**
	 * 向界面通知自动设置状态
	 * @param status
	 * @return
	 */
	public void notifyAutoSetStatus(String status){
		new CoreControl(server).notifyAutoSetStatus(status) ;
	}

	/**
	 * 控制线程
	 * @author Administrator
	 *
	 */
	public class ControlThread extends Thread{
		
		private long queryRtuIdTime = 0L ;
		
		@SuppressWarnings("finally")
		public void run(){
			while(true){
				try{
					synchronized (CoreThread.synObj_Control) {
						if(CoreThread.event == 1){
							//已经连接网络
							if(CoreThread.netConnected){
								//已经网络连接上了，发送查询RTU ID的命令，
								//因为当前无RTUID，不能构成协议的数据，所以用广播地址
								if(CoreThread.rtuId == null){
									long now = System.currentTimeMillis() ;
									if(now - queryRtuIdTime > StringValueForServer.commandInterval){
										queryRtuIdTime = now ;
										this.queryRtuId() ;
									}
								}
							}
							CoreThread.event = 0 ;
						}else if(CoreThread.event == 2){
							//已经断开网络
							if(!CoreThread.netConnected){
								//已经断开网络
								CoreThread.rtuId = null ;
								CoreThread.autoQueryThread.setCanAutoQuery(false) ;
								CoreThread.autoSetThread.setCanAutoSet(false) ;
							}
							CoreThread.event = 0 ;
						}else if(CoreThread.event == 3){
							//接收到RTUID
							long now = System.currentTimeMillis() ;
							if((now - lastSendAutoCommandTime) > StringValueForServer.intervalStillAtOneRtu){
								//间隔一段时间(毫秒)内，再次上线，认为是在同一个RTU上，不再发自动命令
								//超过一段时间时，可能不在一个RTU上，发自动命令
								lastSendAutoCommandTime = now ;
							}
							//可以进行默认命令查询
							CoreThread.autoQueryThread.setCanAutoQuery(true) ;
							CoreThread.autoSetThread.setCanAutoSet(true) ;
							CoreThread.event = 0 ;
						}else{
							//event=0或其他
							//无事件
							try {
								CoreThread.synObj_Control.wait();
							} catch (InterruptedException e) {
							}
						}
					}
				}catch(Exception e){
					
				}finally{
					continue ;
				}
			}
		}
		/**
		 * 查询RTU ID
		 */
		private void queryRtuId(){
			if(CoreThread.server != null && CoreThread.server.mHandler != null){
				try{
					CoreThread.server.mHandler.postDelayed(new Runnable(){
						@Override
						public void run() {
							new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_50(), true, true) ;
						}
					}, 500) ;//可能一段时间一直查询不到RTU ID，所以这里用postDelayed，等待0.5秒
				}catch(Exception e){
				}finally{}
			}
		}
		
	}
	
	
	
	/**
	 * 自动查询命令的线程
	 * @author Administrator
	 *
	 */
	public class AutoQueryThread extends Thread{
		
		private boolean canAutoQuery ;
		
		private int queryCount ;
		
		private boolean started ;//启动
		private boolean paused ;//暂停
		private boolean resumed ;//继续
		private boolean stoped ;//停止
		
		public AutoQueryThread(){
			this.canAutoQuery = false ;
			this.queryCount = 0 ;
			this.started = false ;//启动
			this.paused = false ;//暂停
			this.resumed = false ;//继续
			this.stoped = true ;//停止
		}
		
		/**
		 * 能够进行自动查询任务了
		 * @param flag
		 */
		public void setCanAutoQuery(boolean flag){
			if(flag){
				canAutoQuery = true ;
				synchronized (CoreThread.synObj_canAutoQuery) {
					CoreThread.synObj_canAutoQuery.notifyAll() ;
				}
				synchronized (CoreThread.synObj_canAutoQuery) {
					CoreThread.synObj_canAutoQuery.notifyAll() ;
				}
			}else{
				autoQueryComplete() ;
				canAutoQuery = false ;
			}
		}
		
		/**
		 * 界面来的操作
		 * @param start
		 * @param pause
		 * @param resume
		 * @param stop
		 * @return
		 */
		public String operate(boolean start, boolean pause, boolean resume, boolean stop){
			String info = null ;
			if(!CoreThread.netConnected || CoreThread.rtuId == null || !canAutoQuery){
				//不具备条件发送自动命令
				info = "操作无效，当前未连接测控器或未得到测控器ID" ;
			}else{
				if(start){
					if(this.stoped){
						//当前为停止状态才能启动
						this.started = true ;
						this.paused = false ; 
						this.resumed = false ; 
						this.stoped = false ;
						synchronized (CoreThread.synObj_doAutoQuery) {
							CoreThread.synObj_doAutoQuery.notifyAll() ;
						}
						info = "自动查询启动" ;
					}else{
						info = "启动操作无效，自动查询进行中或暂停中" ;
					}
				}else if(pause){
					if(this.started && !this.paused){
						//当前为已经启动并且非暂停状态才能暂停
						this.paused = true ; 
						this.resumed = false ; 
						info = "自动查询暂停" ;
					}else{
						if(this.paused){
							info = "暂停操作无效，自动查询已经暂停了" ;
						}else{
							info = "暂停操作无效，自动查询未启动" ;
						}
					}
				}else if(resume){
					if(this.started && this.paused && !this.resumed){
						//当前为已经启动并且暂停、未继续状态才能继续
						this.paused = false ;
						this.resumed = true ;
						synchronized (CoreThread.synObj_doAutoQuery) {
							CoreThread.synObj_doAutoQuery.notifyAll() ;
						}
						info = "自动查询继续" ;
					}else{
						if(!this.started){
							info = "暂停操作无效，自动查询未启动" ;	
						}else if(!this.paused){
							info = "继续操作无效，自动查询进行中" ;
						}else if(this.resumed){
							info = "继续操作无效，自动查询已经继续了" ;
						}
					}
				}else if(stop){
					//无条件停止
					autoQueryComplete() ;
					info = "自动查询停止" ;
					synchronized (CoreThread.synObj_doAutoQuery) {
						CoreThread.synObj_doAutoQuery.notifyAll() ;
					}
				}			
			}
			return info ;
		}
		
		/**
		 * 发送命令完成，相当于停止
		 */
		private void autoQueryComplete(){
			this.started = false ;
			this.paused = false ;
			this.resumed = false ;
			this.stoped = true ;
			this.queryCount = 0 ;
		}
		
		@SuppressWarnings("finally")
		public void run(){
			while(true){
				try{
					if(!canAutoQuery){
						//不具备条件发送自动命令
						autoQueryComplete() ;
						CoreThread.this.notifyAutoQueryStatus("停止") ;
						synchronized (CoreThread.synObj_canAutoQuery) {
							CoreThread.synObj_canAutoQuery.wait();
						}
					}else{
						//有条件发送自动命令
						if(CoreThread.netConnected && CoreThread.rtuId != null){
							//必要条件也具备
							if(this.started && !this.stoped && !this.paused){
								//已经启动，并且未停止，也未暂停或
								doAutoQuery(this.queryCount) ;
								this.queryCount++ ;
								
								if(this.resumed){
									CoreThread.this.notifyAutoQueryStatus("继续") ;
								}else if(this.started && !this.resumed){
									CoreThread.this.notifyAutoQueryStatus("启动") ;
								}
								
								synchronized (CoreThread.synObj_doAutoQuery) {
									//发送完一条命令，等待一段时间 ，即下发命令的间隔时长
									CoreThread.synObj_doAutoQuery.wait(StringValueForServer.commandInterval);
								}
							}else{
								//未启动(即停止)，或暂停中
								if(this.paused){
									CoreThread.this.notifyAutoQueryStatus("暂停") ;
								}else if(this.stoped){
									CoreThread.this.notifyAutoQueryStatus("停止") ;
								}
								synchronized (CoreThread.synObj_doAutoQuery) {
									CoreThread.synObj_doAutoQuery.wait();
								}
							}
						}else{
							//必要条件不具备
							autoQueryComplete() ;
							CoreThread.this.notifyAutoQueryStatus("停止") ;
							synchronized (CoreThread.synObj_canAutoQuery) {
								CoreThread.synObj_canAutoQuery.wait();
							}
						}
					}
				}catch(Exception e){
				}finally{
					continue ;
				}
			}
		}
		
		private void doAutoQuery(int count){
			switch(count){
			case 0 : {
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_51(CoreThread.rtuId), false, true) ;
				break;}
			case 1 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_52(CoreThread.rtuId), false, true) ;
				break;}
			case 2 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_EF(CoreThread.rtuId), false, true) ;
				break;}
			case 3 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E0(CoreThread.rtuId), false, true) ;
				break;}
			case 4 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E1(CoreThread.rtuId), false, true) ;
				break;}
			case 5 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_CF(CoreThread.rtuId), false, true) ;
				break;}
			case 6 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_C9(CoreThread.rtuId), false, true) ;
				break;}
			case 7 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_CB(CoreThread.rtuId), false, true) ;
				break;}
			case 8 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_CA(CoreThread.rtuId), false, true) ;
				break;}
			case 9 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_CC(CoreThread.rtuId), false, true) ;
				break;}
			case 10 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_CD(CoreThread.rtuId), false, true) ;
				break;}
			case 11 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_CE(CoreThread.rtuId), false, true) ;
				break;}
			case 12 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_C8(CoreThread.rtuId), false, true) ;
				break;}
			case 13 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E2(CoreThread.rtuId), false, true) ;
				break;}
			case 14 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E3(CoreThread.rtuId), false, true) ;
				break;}
			case 15 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E4(CoreThread.rtuId), false, true) ;
				break;}
			case 16 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E5(CoreThread.rtuId), false, true) ;
				break;}
			case 17 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E6(CoreThread.rtuId), false, true) ;
				break;}
			case 18 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E9(CoreThread.rtuId), false, true) ;
				break;}
			case 19 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_EA(CoreThread.rtuId), false, true) ;
				break;}
			case 20 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E7(CoreThread.rtuId), false, true) ;
				break;}
			case 21 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_E8(CoreThread.rtuId), false, true) ;
				break;}
			case 22 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_EB(CoreThread.rtuId), false, true) ;
				break;}
			case 23 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_57(CoreThread.rtuId), false, true) ;
				break;}
			case 24 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_59(CoreThread.rtuId), false, true) ;
				break;}
			case 25 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_5A(CoreThread.rtuId), false, true) ;
				break;}
			case 26 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_64(CoreThread.rtuId), false, true) ;
				break;}
			case 27 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_54(CoreThread.rtuId), false, true) ;
				break;}
			case 28 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_53(CoreThread.rtuId), false, true) ;
				break;}
			case 29 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_C5(CoreThread.rtuId), false, true) ;
				break;}
			case 30 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_55(CoreThread.rtuId), false, true) ;
				break;}
			case 31 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_56(CoreThread.rtuId), false, true) ;
				break;}
			case 32 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_5D(CoreThread.rtuId), false, true) ;
				break;}
			case 33 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_5E(CoreThread.rtuId), false, true) ;
				break;}
			case 34 :{
				new CoreControl(CoreThread.server).sendRtuCommandByTcp(new CommandCreator().cd_EC(CoreThread.rtuId), false, true) ;
				break;}
			case 35 :{
				ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
				if(obj != null){
					obj.autoQueryCommand(Code206.cd_B1) ;
				}
				break;}
			case 36 :{
				ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
				if(obj != null){
					obj.autoQueryCommand(Code206.cd_B0) ;
				}
				break;}
			case 37 :{
				ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
				if(obj != null){
					obj.autoQueryCommand(Code206.cd_ED) ;
				}
				break;}
			default : {//,,,,,
				this.autoQueryComplete() ;
				CoreThread.this.notifyAutoQueryStatus("完毕") ;
				break;
			}
			}
		}
	}

	
	/**
	 * 自动设置命令的线程
	 * @author Administrator
	 *
	 */
	public class AutoSetThread extends Thread{
		
		private boolean canAutoSet ;
		
		private int setCount ;
		
		private boolean started ;//启动
		private boolean paused ;//暂停
		private boolean resumed ;//继续
		private boolean stoped ;//停止
		
		public AutoSetThread(){
			this.canAutoSet = false ;
			this.setCount = 0 ;
			this.started = false ;//启动
			this.paused = false ;//暂停
			this.resumed = false ;//继续
			this.stoped = true ;//停止
		}
		
		/**
		 * 能够进行自动设置任务了
		 * @param flag
		 */
		public void setCanAutoSet(boolean flag){
			if(flag){
				canAutoSet = true ;
				synchronized (CoreThread.synObj_canAutoSet) {
					CoreThread.synObj_canAutoSet.notifyAll() ;
				}
				synchronized (CoreThread.synObj_canAutoSet) {
					CoreThread.synObj_canAutoSet.notifyAll() ;
				}
			}else{
				autoSetComplete() ;
				canAutoSet = false ;
			}
		}
		
		/**
		 * 界面来的操作
		 * @param start
		 * @param pause
		 * @param resume
		 * @param stop
		 * @return
		 */
		public String operate(boolean start, boolean pause, boolean resume, boolean stop){
			String info = null ;
			if(!CoreThread.netConnected || CoreThread.rtuId == null || !canAutoSet){
				//不具备条件发送自动命令
				info = "操作无效，当前未连接测控器或未得到测控器ID" ;
			}else{
				if(start){
					if(this.stoped){
						//当前为停止状态才能启动
						this.started = true ;
						this.paused = false ; 
						this.resumed = false ; 
						this.stoped = false ;
						synchronized (CoreThread.synObj_doAutoSet) {
							CoreThread.synObj_doAutoSet.notifyAll() ;
						}
						info = "自动设置启动" ;
					}else{
						info = "启动操作无效，自动设置进行中或暂停中" ;
					}
				}else if(pause){
					if(this.started && !this.paused){
						//当前为已经启动并且非暂停状态才能暂停
						this.paused = true ; 
						this.resumed = false ; 
						info = "自动设置暂停" ;
					}else{
						if(this.paused){
							info = "暂停操作无效，自动设置已经暂停了" ;
						}else{
							info = "暂停操作无效，自动设置未启动" ;
						}
					}
				}else if(resume){
					if(this.started && this.paused && !this.resumed){
						//当前为已经启动并且暂停、未继续状态才能继续
						this.paused = false ;
						this.resumed = true ;
						synchronized (CoreThread.synObj_doAutoSet) {
							CoreThread.synObj_doAutoSet.notifyAll() ;
						}
						info = "自动设置继续" ;
					}else{
						if(!this.started){
							info = "暂停操作无效，自动设置未启动" ;	
						}else if(!this.paused){
							info = "继续操作无效，自动设置进行中" ;
						}else if(this.resumed){
							info = "继续操作无效，自动设置已经继续了" ;
						}
					}
				}else if(stop){
					//无条件停止
					autoSetComplete() ;
					info = "自动设置停止" ;
					synchronized (CoreThread.synObj_doAutoSet) {
						CoreThread.synObj_doAutoSet.notifyAll() ;
					}
				}			
			}
			return info ;
		}
		
		/**
		 * 发送命令完成，相当于停止
		 */
		private void autoSetComplete(){
			this.started = false ;
			this.paused = false ;
			this.resumed = false ;
			this.stoped = true ;
			this.setCount = 0 ;
		}
		
		@SuppressWarnings("finally")
		public void run(){
			while(true){
				try{
					if(!canAutoSet){
						//不具备条件发送自动命令
						autoSetComplete() ;
						CoreThread.this.notifyAutoSetStatus("停止") ;
						synchronized (CoreThread.synObj_canAutoSet) {
							CoreThread.synObj_canAutoSet.wait();
						}
					}else{
						//有条件发送自动命令
						if(CoreThread.netConnected && CoreThread.rtuId != null){
							//必要条件也具备
							if(this.started && !this.stoped && !this.paused){
								//已经启动，并且未停止，也未暂停或
								doAutoSet(this.setCount) ;
								this.setCount++ ;
								
								if(this.resumed){
									CoreThread.this.notifyAutoSetStatus("继续") ;
								}else if(this.started && !this.resumed){
									CoreThread.this.notifyAutoSetStatus("启动") ;
								}
								
								synchronized (CoreThread.synObj_doAutoSet) {
									//发送完一条命令，等待一段时间 ，即下发命令的间隔时长
									CoreThread.synObj_doAutoSet.wait(StringValueForServer.commandInterval);
								}
							}else{
								//未启动(即停止)，或暂停中
								if(this.paused){
									CoreThread.this.notifyAutoSetStatus("暂停") ;
								}else if(this.stoped){
									CoreThread.this.notifyAutoSetStatus("停止") ;
								}
								synchronized (CoreThread.synObj_doAutoSet) {
									CoreThread.synObj_doAutoSet.wait();
								}
							}
						}else{
							//必要条件不具备
							autoSetComplete() ;
							CoreThread.this.notifyAutoSetStatus("停止") ;
							synchronized (CoreThread.synObj_canAutoSet) {
								CoreThread.synObj_canAutoSet.wait();
							}
						}
					}
				}catch(Exception e){
				}finally{
					continue ;
				}
			}
		}
		
		private void doAutoSet(int count){
			ActivityProxyHandler obj = ActivityProxyHandler.getInstance();
			if(obj != null){
				switch(count){
				case 0 : {
					obj.autoSetCommand(Code206.cd_10) ;//设置遥测终端、中继站地址
					break;}
				case 1 :{
					obj.autoSetCommand(Code206.cd_11) ;//设置遥测终端、中继站时钟
					break;}
				case 2 :{
					obj.autoSetCommand(Code206.cd_12) ;//设置遥测终端工作模式
					break;}
				case 3 :{
					obj.autoSetCommand(Code206.cd_90) ;//复位遥测终端参数和状态 
					break;}
				case 4 :{
					obj.autoSetCommand(Code206.cd_91) ;//清空遥测终端历史数据单元
					break;}
				case 5 :{
					obj.autoSetCommand(Code206.cd_F1) ;//设置电池池电压报警值
					break;}
				case 6 :{
					obj.autoSetCommand(Code206.cd_DF) ;//设置DTU工作模式
					break;}
				case 7 :{
					obj.autoSetCommand(Code206.cd_D9) ;//设置终端心跳周期
					break;}
				case 8 :{
					obj.autoSetCommand(Code206.cd_DB) ;//设置终端主备通道
					break;}
				case 9 :{
					obj.autoSetCommand(Code206.cd_DA) ;//设置GPRS接入点
					break;}
				case 10 :{
					obj.autoSetCommand(Code206.cd_DC) ;//设置中心网址
					break;}
				case 11 :{
					obj.autoSetCommand(Code206.cd_DD) ;//设置短信中心号码
					break;}
				case 12 :{
					obj.autoSetCommand(Code206.cd_DE) ;//设置卫星中心号码
					break;}
				case 13 :{
					obj.autoSetCommand(Code206.cd_D8) ;//设置AD校准命令(代替了F2命令)
					break;}
				case 14 :{
					obj.autoSetCommand(Code206.cd_F3) ;//设置仪表类型
					break;}
				case 15 :{
					obj.autoSetCommand(Code206.cd_F4) ;//设置仪表量程
					break;}
				case 16 :{
					obj.autoSetCommand(Code206.cd_F5) ;//设置仪表采集修正值
					break;}
				case 17 :{
					obj.autoSetCommand(Code206.cd_F6) ;//设置仪表AD采集校准值
					break;}
				case 18 :{
					obj.autoSetCommand(Code206.cd_F9) ;//设置仪表上电读值延时时间
					break;}
				case 19 :{
					obj.autoSetCommand(Code206.cd_FA) ;//设置井口高程，水井深度，探头埋深
					break;}
				case 20 :{
					obj.autoSetCommand(Code206.cd_F7) ;//设置数据采集种类及时间间隔
					break;}
				case 21 :{
					obj.autoSetCommand(Code206.cd_F8) ;//设置上报起始时间
					break;}
				case 22 :{
					obj.autoSetCommand(Code206.cd_FB) ;//设置水位上报种类
					break;}
				case 23 :{
					obj.autoSetCommand(Code206.cd_17) ;//设置遥测终端的水位基值、水位上下限
					break;}
				case 24 :{
					obj.autoSetCommand(Code206.cd_19) ;//设置遥测终端水质参数种类、上限值
					break;}
				case 25 :{
					obj.autoSetCommand(Code206.cd_1A) ;//设置遥测终端水质参数种类、下限值
					break;}
				case 26 :{
					obj.autoSetCommand(Code206.cd_1F) ;//设置遥测终端流量参数上限值
					break;}
				case 27 :{
					obj.autoSetCommand(Code206.cd_20) ;//设置遥测终端检测参数启报阈值及固态存储时间段间隔
					break;}
				case 28 :{
					obj.autoSetCommand(Code206.cd_A0) ;//设置遥测站需查询的实时数据种类 
					break;}
				case 29 :{
					obj.autoSetCommand(Code206.cd_A1) ;//设置遥测终端的数据自报种类及时间间隔
					break;}
				case 30 :{
					obj.autoSetCommand(Code206.cd_D5) ;//设置定时上报的时刻
					break;}
				case 31 :{
					obj.autoSetCommand(Code206.cd_15) ;//设置本次充值量
					break;}
				case 32 :{
					obj.autoSetCommand(Code206.cd_16) ;//设置遥测终端剩余水量报警值
					break;}
				case 33 :{
					obj.autoSetCommand(Code206.cd_1B) ;//设置终端站流量的表底（初始）值
					break;}
				case 34 :{
					obj.autoSetCommand(Code206.cd_FC) ;//设置日志配置表
					break;}
				case 35 :{
					obj.autoSetCommand(Code206.cd_82) ;//人工置数 遥测终端  
					break;}
				default : {//,,,,,
					this.autoSetComplete() ;
					CoreThread.this.notifyAutoSetStatus("完毕") ;
					break;
				}
				}
			}
		}
	}
}
