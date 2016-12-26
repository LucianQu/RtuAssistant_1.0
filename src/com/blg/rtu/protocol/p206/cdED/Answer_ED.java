package com.blg.rtu.protocol.p206.cdED;

import android.util.Log;

import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;

public class Answer_ED extends ProtocolSupport{

	private static String tag = Answer_ED.class.getName() ;
	
	protected static int len = Constant.Bits_Head 
			+ Constant.Bits_Control
			+ Constant.Bits_RTU_ID 
			+ Constant.Bits_Code 
			+ Constant.Bits_CRC
			+ Constant.Bits_Tail ;
	
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
		
		Log.i(tag, "分析<查询日志信息>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int n, RtuData d, ControlProtocol cp) throws Exception {
		DataList_ED subD = new DataList_ED() ;
		d.setSubData(subD) ;
		String year,month,day,hour,minute;
		
		// 分析数据域
		int total = (b.length - len )/16 ;
		for(int i = 0 ; i < total ; i++){
			Data_ED dd = new Data_ED() ;
			subD.getDatas().add(dd) ;
			dd.setIndex((b[n] + 256)%256) ;
			
			year = ByteUtil.BCD2String(b, n + 1, n + 1) ;
			month = ByteUtil.BCD2String(b, n + 2, n + 2) ;
			day = ByteUtil.BCD2String(b, n + 3, n + 3) ;
			hour = ByteUtil.BCD2String(b, n + 4, n + 4) ;
			minute = ByteUtil.BCD2String(b, n + 5, n + 5) ;
			dd.setDateTime("20" + year + "-" + month + "-" + day + " " + hour + ":" + minute);
			
			if((b[n + 6] & 0xFF) == 0x00) {
				
				dd.setTypeNum("类型：GSM模块");
				if((b[n + 7] & 0xFF) == 0x00) {
					dd.setContentType("内容：上电错误");
				}else if((b[n + 7] & 0xFF) == 0x01) {
					dd.setContentType("内容：初始化错误");
				}else if((b[n + 7] & 0xFF) == 0x02) {
					dd.setContentType("内容：中心错误");
				}else if((b[n + 7] & 0xFF) == 0x03) {
					dd.setContentType("内容：信号强度弱");
					if((b[n + 8] & 0xFF) > 0) {
						dd.setCommentsType("信号强度：" + (b[n + 8] & 0xFF));
					}else{
						dd.setCommentsType("信号强度：< 0");
					}
				}else{
					dd.setContentType("内容：超出范围!");
				}
				
			}else if((b[n + 6] & 0xFF) == 0x01) {
				dd.setTypeNum("类型：计量模块");
				if((b[n + 7] & 0xFF) == 0x01) {
					dd.setContentType("内容：强磁攻击开始");
				}else if((b[n + 7] & 0xFF) == 0x02) {
					dd.setContentType("内容：强磁攻击结束");
				}else if((b[n + 7] & 0xFF) == 0x03) {
					dd.setContentType("内容：从铁电读取流量数据错误");
				}else if((b[n + 7] & 0xFF) == 0x04) {
					dd.setContentType("内容：从历史数据获取流量数据错误");
				}else if((b[n + 7] & 0xFF) == 0x05) {
					dd.setContentType("内容：设置净积");
					if((b[n + 8] & 0xFF) == 0x01) {
						dd.setCommentsType("修改源：串口");
					}else if((b[n + 8] & 0xFF) == 0x02) {
						dd.setCommentsType("修改源：Modbus");
					}else if((b[n + 8] & 0xFF) == 0x03) {
						dd.setCommentsType("修改源：206协议");
					}else{
						dd.setCommentsType("修改源：未知！");
					}
				}else if((b[n + 7] & 0xFF) == 0x06) {
					dd.setContentType("内容：设置正积");
					if((b[n + 8] & 0xFF) == 0x01) {
						dd.setCommentsType("修改源：串口");
					}else if((b[n + 8] & 0xFF) == 0x02) {
						dd.setCommentsType("修改源：Modbus");
					}else if((b[n + 8] & 0xFF) == 0x03) {
						dd.setCommentsType("修改源：206协议");
					}else{
						dd.setCommentsType("修改源：未知！");
					}
				}else if((b[n + 7] & 0xFF) == 0x07) {
					dd.setContentType("内容：设置负积");
					if((b[n + 8] & 0xFF) == 0x01) {
						dd.setCommentsType("修改源：串口");
					}else if((b[n + 8] & 0xFF) == 0x02) {
						dd.setCommentsType("修改源：Modbus");
					}else if((b[n + 8] & 0xFF) == 0x03) {
						dd.setCommentsType("修改源：206协议");
					}else{
						dd.setCommentsType("修改源：未知！");
					}
				}else if((b[n + 7] & 0xFF) == 0x08) {
					dd.setContentType("内容：复位流量参数");
				}else{
					dd.setContentType("内容：超出范围!");
				}
			}else if((b[n + 6] & 0xFF) == 0x05) {
				dd.setTypeNum("类型：电池电压");
				if((b[n + 7] & 0xFF) == 0x01) {
					dd.setContentType("内容：低压告警");
				}else if((b[n + 7] & 0xFF) == 0x02) {
					dd.setContentType("内容：低压告警解除");
				}else{
					dd.setContentType("内容：超出范围!");
				}
			}else if((b[n + 6] & 0xFF) == 0x06) {
				dd.setTypeNum("类型：RTU设备");
				if((b[n + 7] & 0xFF) == 0x01) {
					dd.setContentType("内容：恢复出厂设置");
					
					if((b[n + 8] & 0xFF) == 0x01) {
						dd.setCommentsType("修改源：串口");
					}else if((b[n + 8] & 0xFF) == 0x02) {
						dd.setCommentsType("修改源：Modbus");
					}else if((b[n + 8] & 0xFF) == 0x03) {
						dd.setCommentsType("修改源：206协议");
					}else{
						dd.setCommentsType("修改源：未知！");
					}
				}else if((b[n + 7] & 0xFF) == 0x02) {
					dd.setContentType("类型：出厂启用");
					
					if((b[n + 8] & 0xFF) == 0x01) {
						dd.setCommentsType("修改源：串口");
					}else if((b[n + 8] & 0xFF) == 0x02) {
						dd.setCommentsType("修改源：Modbus");
					}else if((b[n + 8] & 0xFF) == 0x03) {
						dd.setCommentsType("修改源：206协议");
					}else{
						dd.setCommentsType("修改源：未知！");
					}
				}else{
					dd.setContentType("内容：超出范围!");
				}
			}else{
				dd.setTypeNum("类型：超出范围!");
				dd.setContentType("内容：超出范围!");
			}
			//dd.setLogHex(ByteUtil.bytes2Hex(b, false, n , 16)) ;
			n += 16 ;
		}
	}
}
