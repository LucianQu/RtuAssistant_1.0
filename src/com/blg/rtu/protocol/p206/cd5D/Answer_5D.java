package com.blg.rtu.protocol.p206.cd5D;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_5D extends ProtocolSupport{

	private static String tag = Answer_5D.class.getName() ;
	/**
	 * 解析上行数据 
	 * @param rtuId RTU ID
	 * @param b 上行数据
	 * @param cp 控制域解析对象
	 * @param dataCode 数据功能吗
	 * @return
	 * @throws Exception
	 */
	public RtuData parse(String rtuId, byte[] b, ControlProtocol cp, String dataCode) throws Exception {
		RtuData d = new RtuData() ;
		int index = this.parseUpDataHead(rtuId, b, cp, dataCode, d);
		this.doParse(b, index, d, cp) ;
		
		Log.i(tag, "分析<查询遥测终端的事件记录>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		
		Data_5D subD = new Data_5D() ;
		d.setSubData(subD) ;
		subD.setERC1((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;//数据初始化记录 2
		subD.setERC2((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 参数变更记录2
		subD.setERC3((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 状态量变位记录 2
		subD.setERC4((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 仪表故障记录 2
		subD.setERC5((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 密码错误记录 2
		subD.setERC6((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 终端故障记录 2
		subD.setERC7((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 交流失电记录 2
		subD.setERC8((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 蓄电池电压低告警记录 2
		subD.setERC9((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 终端箱非法打开记录 2
		subD.setERC10((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 水泵故障记录 2
		subD.setERC11((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 剩余水量越限告警记录2
		subD.setERC12((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 水位超限告警记录 2
		subD.setERC13((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 水压超限告警记录2
		subD.setERC14((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 水质参数超限告警记录 2
		subD.setERC15((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 数据出错记录2
		subD.setERC16((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 发报文记录 2
		subD.setERC17((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 收报文记录 2
		subD.setERC18((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 发报文出错记录 2
		subD.setERC19((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// 强磁攻击记录
		subD.setERC20((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// GSM发送报文成功记录
		subD.setERC21((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// GSM模块上电总次数记录
		subD.setERC22((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// GSM模块上电成功次数记录
		subD.setERC23((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// GSM模块上线次数记录
		subD.setERC24((b[n++] + 256)%256 + ((b[n++] + 256)%256 << 8)) ;// GSM模块上线成功次数记录
		
		
	}

}