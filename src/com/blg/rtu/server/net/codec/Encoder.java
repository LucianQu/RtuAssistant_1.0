package com.blg.rtu.server.net.codec;

import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import java.io.*;

public class Encoder extends ProtocolEncoderAdapter {

	/**
	 * 把帧头head 0xAA及帧长度加入下行数据中
	 */
	public void encode(IoSession session, 
			Object message,
			ProtocolEncoderOutput out) throws IOException, Exception {
		byte[] data = (byte[]) message;
		int capacity = (data == null ? 0 : data.length);
		IoBuffer buffer = IoBuffer.allocate(capacity, false);
		buffer.put(data);
		buffer.flip();
		out.write(buffer);
	}

}
