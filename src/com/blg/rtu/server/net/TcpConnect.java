package com.blg.rtu.server.net;

import java.net.InetSocketAddress;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import android.util.Log;

import com.blg.rtu.server.net.codec.CodecFactory;

public class TcpConnect {

	private String host;
	private int port;

	private IoConnector connector;
	private IoSession session;


	public TcpConnect(String host, int port) {
		this.host = host;
		this.port = port;
	}

	/**
	 * 创建网络连接
	 */
	public void createConnect() {
		try {
			session = null;
			connector = null;

			connector = new NioSocketConnector();

			connector.setHandler(new TcpIoHandler());

			// 不加protocol过滤器，不能发送数据，编解码过滤器
			connector.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new CodecFactory()));

			//SocketSessionConfig dcfg = (SocketSessionConfig)connector.getSessionConfig();

			ConnectFuture connFuture = connector.connect(new InetSocketAddress(this.host, this.port));
			connFuture.awaitUninterruptibly();
			session = connFuture.getSession();
		} catch (Exception e) {
			session = null;
			connector = null;
		} finally {
		}
	}

	/**
	 * 关闭网络连接
	 */
	public void closeConnect() {
		try {
			if (this.session != null && this.session.isConnected()) {
				this.session.close(true);
			}
		} catch (Exception e) {
		} finally {
			session = null;
			connector = null;
		}
	}

	/**
	 * 得到网络连接会话
	 * 
	 * @return
	 */
	public IoSession getSession() {
		return this.session;
	}

	/**
	 * TCP网络发送数据
	 * 
	 * @param buffer
	 */
	public void send(byte[] buffer) {
		try {
			if (this.session != null && this.session.isConnected()) {
				this.session.write(buffer);
			}
		} catch (Exception e) {
		} finally {
		}
	}

	/**
	 * TCP网络连接会话IO操作的工作类，主要完成TCP网络接收数据
	 * 
	 * @author Administrator
	 * 
	 */
	public static class TcpIoHandler extends IoHandlerAdapter {
		
		private static String tag = TcpIoHandler.class.getName() ;

		@Override
		public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
			//super.exceptionCaught(session, cause);
			Log.e(tag, "TcpIoHandler", cause);
		}

		@Override
		public void messageReceived(IoSession session, Object message) throws Exception {
			byte[] data = null;
			if (message instanceof IoBuffer) {
				IoBuffer buffer = (IoBuffer) message;
				data = buffer.array();

			} else if (message instanceof byte[]) {
				data = (byte[]) message;
			}
			NetManager nm = NetManager.getInstance();
			if (nm != null) {
				nm.receiveProtocolData(data) ;
			}
		}

		@Override
		public void messageSent(IoSession session, Object message)
				throws Exception {
			super.messageSent(session, message);
		}

		@Override
		public void sessionClosed(IoSession session) throws Exception {
			super.sessionClosed(session);
		}

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			super.sessionCreated(session);
		}

		@Override
		public void sessionIdle(IoSession session, IdleStatus status)
				throws Exception {
			super.sessionIdle(session, status);
		}

		@Override
		public void sessionOpened(IoSession session) throws Exception {
			super.sessionOpened(session);
		}

	}

}