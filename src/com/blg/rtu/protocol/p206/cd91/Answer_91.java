package com.blg.rtu.protocol.p206.cd91;

import android.util.Log;
import com.blg.rtu.protocol.RtuData;
import com.blg.rtu.protocol.p206.common.ProtocolSupport;
import com.blg.rtu.protocol.p206.common.ControlProtocol;

public class Answer_91  extends ProtocolSupport{

	private static String tag = Answer_91.class.getName() ;

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
		
		Log.i(tag, "分析<清空遥测终端的历史数据单元>应答: RTU ID=" + rtuId + " 数据：" + d.getSubData().toString());
		return d;
	}
	private void doParse(byte[] b, int index, RtuData d, ControlProtocol cp) throws Exception {
		Data_91 dd = new Data_91() ;
		d.setSubData(dd) ;
		
		int i = (b[index] + 256) % 256 ;
		if(i == 1){
			dd.setClearType(Param_91.clearType_1.intValue()) ;
		}else if(i == 2){
			dd.setClearType(Param_91.clearType_2.intValue()) ;
		}else if(i == 4){
			dd.setClearType(Param_91.clearType_3.intValue()) ;
		}else if(i == 8){
			dd.setClearType(Param_91.clearType_4.intValue()) ;
		}else if(i == 16){
			dd.setClearType(Param_91.clearType_5.intValue()) ;
		}else if(i == 32){
			dd.setClearType(Param_91.clearType_6.intValue()) ;
		}else if(i == 64){
			dd.setClearType(Param_91.clearType_7.intValue()) ;
		}else if(i == 128){
			dd.setClearType(Param_91.clearType_8.intValue()) ;
		}else if(i == 255){
			dd.setClearType(Param_91.clearType_0.intValue()) ;
		}else{
			dd.setClearType(Param_91.clearType_0.intValue()) ;
		}
	}
}
