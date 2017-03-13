package com.blg.rtu.protocol.p206;

import java.util.HashMap;

import android.util.Log;

import com.blg.rtu.protocol.Action;
import com.blg.rtu.protocol.DriverRtu;
import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.protocol.p206.cd02.Confirm_02;
import com.blg.rtu.protocol.p206.cd02.Data_02;
import com.blg.rtu.protocol.p206.cd02.LinkTest_02;
import com.blg.rtu.protocol.p206.cd02.Write_02;
import com.blg.rtu.protocol.p206.cd10_50.Answer_10_50;
import com.blg.rtu.protocol.p206.cd10_50.Read_50;
import com.blg.rtu.protocol.p206.cd10_50.Write_10;
import com.blg.rtu.protocol.p206.cd11_51.Answer_11_51;
import com.blg.rtu.protocol.p206.cd11_51.Read_51;
import com.blg.rtu.protocol.p206.cd11_51.Write_11;
import com.blg.rtu.protocol.p206.cd12_52.Answer_12_52;
import com.blg.rtu.protocol.p206.cd12_52.Read_52;
import com.blg.rtu.protocol.p206.cd12_52.Write_12;
import com.blg.rtu.protocol.p206.cd15_55.Answer_15;
import com.blg.rtu.protocol.p206.cd15_55.Answer_55;
import com.blg.rtu.protocol.p206.cd15_55.Read_55;
import com.blg.rtu.protocol.p206.cd15_55.Write_15;
import com.blg.rtu.protocol.p206.cd16_56.Answer_16;
import com.blg.rtu.protocol.p206.cd16_56.Answer_56;
import com.blg.rtu.protocol.p206.cd16_56.Read_56;
import com.blg.rtu.protocol.p206.cd16_56.Write_16;
import com.blg.rtu.protocol.p206.cd17_57.Answer_17;
import com.blg.rtu.protocol.p206.cd17_57.Answer_57;
import com.blg.rtu.protocol.p206.cd17_57.Read_57;
import com.blg.rtu.protocol.p206.cd17_57.Write_17;
import com.blg.rtu.protocol.p206.cd18_58.Answer_58;
import com.blg.rtu.protocol.p206.cd19_59.Answer_19_59;
import com.blg.rtu.protocol.p206.cd19_59.Read_59;
import com.blg.rtu.protocol.p206.cd19_59.Write_19;
import com.blg.rtu.protocol.p206.cd1A_5A.Answer_1A_5A;
import com.blg.rtu.protocol.p206.cd1A_5A.Read_5A;
import com.blg.rtu.protocol.p206.cd1A_5A.Write_1A;
import com.blg.rtu.protocol.p206.cd1B.Answer_1B;
import com.blg.rtu.protocol.p206.cd1B.Write_1B;
import com.blg.rtu.protocol.p206.cd1C_60.Answer_1C_60;
import com.blg.rtu.protocol.p206.cd1C_60.Read_60;
import com.blg.rtu.protocol.p206.cd1C_60.Write_1C;
import com.blg.rtu.protocol.p206.cd1D_62.Answer_1D_62;
import com.blg.rtu.protocol.p206.cd1D_62.Read_62;
import com.blg.rtu.protocol.p206.cd1D_62.Write_1D;
import com.blg.rtu.protocol.p206.cd1E_63.Answer_1E;
import com.blg.rtu.protocol.p206.cd1E_63.Answer_63;
import com.blg.rtu.protocol.p206.cd1E_63.Read_63;
import com.blg.rtu.protocol.p206.cd1E_63.Write_1E;
import com.blg.rtu.protocol.p206.cd1F_64.Answer_1F;
import com.blg.rtu.protocol.p206.cd1F_64.Answer_64;
import com.blg.rtu.protocol.p206.cd1F_64.Read_64;
import com.blg.rtu.protocol.p206.cd1F_64.Write_1F;
import com.blg.rtu.protocol.p206.cd20.Answer_20;
import com.blg.rtu.protocol.p206.cd20.Write_20;
import com.blg.rtu.protocol.p206.cd30_31.Answer_30;
import com.blg.rtu.protocol.p206.cd30_31.Answer_31;
import com.blg.rtu.protocol.p206.cd30_31.Write_30;
import com.blg.rtu.protocol.p206.cd30_31.Write_31;
import com.blg.rtu.protocol.p206.cd32_33.Answer_32;
import com.blg.rtu.protocol.p206.cd32_33.Answer_33;
import com.blg.rtu.protocol.p206.cd32_33.Write_32;
import com.blg.rtu.protocol.p206.cd32_33.Write_33;
import com.blg.rtu.protocol.p206.cd34.Answer_34;
import com.blg.rtu.protocol.p206.cd40.Answer_40;
import com.blg.rtu.protocol.p206.cd40.Write_40;
import com.blg.rtu.protocol.p206.cd41.Answer_41;
import com.blg.rtu.protocol.p206.cd41.Write_41;
import com.blg.rtu.protocol.p206.cd42_72.Answer_42_72;
import com.blg.rtu.protocol.p206.cd42_72.Read_72;
import com.blg.rtu.protocol.p206.cd42_72.Write_42;
import com.blg.rtu.protocol.p206.cd43_73.Answer_43_73;
import com.blg.rtu.protocol.p206.cd43_73.Read_73;
import com.blg.rtu.protocol.p206.cd43_73.Write_43;
import com.blg.rtu.protocol.p206.cd44_74.Answer_44_74;
import com.blg.rtu.protocol.p206.cd44_74.Read_74;
import com.blg.rtu.protocol.p206.cd44_74.Write_44;
import com.blg.rtu.protocol.p206.cd45_75.Answer_45_75;
import com.blg.rtu.protocol.p206.cd45_75.Read_75;
import com.blg.rtu.protocol.p206.cd45_75.Write_45;
import com.blg.rtu.protocol.p206.cd46_76.Answer_46;
import com.blg.rtu.protocol.p206.cd46_76.Answer_76;
import com.blg.rtu.protocol.p206.cd46_76.Read_76;
import com.blg.rtu.protocol.p206.cd46_76.Write_46;
import com.blg.rtu.protocol.p206.cd47_77.Answer_47;
import com.blg.rtu.protocol.p206.cd47_77.Answer_77;
import com.blg.rtu.protocol.p206.cd47_77.Read_77;
import com.blg.rtu.protocol.p206.cd47_77.Write_47;
import com.blg.rtu.protocol.p206.cd48_78.Answer_48_78;
import com.blg.rtu.protocol.p206.cd48_78.Read_78;
import com.blg.rtu.protocol.p206.cd48_78.Write_48;
import com.blg.rtu.protocol.p206.cd49_79.Answer_49_79;
import com.blg.rtu.protocol.p206.cd49_79.Read_79;
import com.blg.rtu.protocol.p206.cd49_79.Write_49;
import com.blg.rtu.protocol.p206.cd4A_7A.Answer_4A_7A;
import com.blg.rtu.protocol.p206.cd4A_7A.Read_7A;
import com.blg.rtu.protocol.p206.cd4A_7A.Write_4A;
import com.blg.rtu.protocol.p206.cd5D.Answer_5D;
import com.blg.rtu.protocol.p206.cd5D.Read_5D;
import com.blg.rtu.protocol.p206.cd5E.Answer_5E;
import com.blg.rtu.protocol.p206.cd5E.Read_5E;
import com.blg.rtu.protocol.p206.cd81.Report_81;
import com.blg.rtu.protocol.p206.cd82_.Answer_82;
import com.blg.rtu.protocol.p206.cd82_.Write_82;
import com.blg.rtu.protocol.p206.cd90.Answer_90;
import com.blg.rtu.protocol.p206.cd90.Write_90;
import com.blg.rtu.protocol.p206.cd91.Answer_91;
import com.blg.rtu.protocol.p206.cd91.Write_91;
import com.blg.rtu.protocol.p206.cd92_93.Answer_92;
import com.blg.rtu.protocol.p206.cd92_93.Answer_93;
import com.blg.rtu.protocol.p206.cd92_93.Write_92;
import com.blg.rtu.protocol.p206.cd92_93.Write_93;
import com.blg.rtu.protocol.p206.cd94_95.Answer_94;
import com.blg.rtu.protocol.p206.cd94_95.Answer_95;
import com.blg.rtu.protocol.p206.cd94_95.Write_94;
import com.blg.rtu.protocol.p206.cd94_95.Write_95;
import com.blg.rtu.protocol.p206.cd96.Answer_96;
import com.blg.rtu.protocol.p206.cd96.Write_96;
import com.blg.rtu.protocol.p206.cdA0_54.Answer_A0_54;
import com.blg.rtu.protocol.p206.cdA0_54.Read_54;
import com.blg.rtu.protocol.p206.cdA0_54.Write_A0;
import com.blg.rtu.protocol.p206.cdA1_53.Answer_A1_53;
import com.blg.rtu.protocol.p206.cdA1_53.Read_53;
import com.blg.rtu.protocol.p206.cdA1_53.Write_A1;
import com.blg.rtu.protocol.p206.cdB0.Answer_B0;
import com.blg.rtu.protocol.p206.cdB0.Read_B0;
import com.blg.rtu.protocol.p206.cdB1.Answer_B1;
import com.blg.rtu.protocol.p206.cdB1.Read_B1;
import com.blg.rtu.protocol.p206.cdB2.Answer_B2;
import com.blg.rtu.protocol.p206.cdB2.Read_B2;
import com.blg.rtu.protocol.p206.cdC0.Confirm_C0;
import com.blg.rtu.protocol.p206.cdC0.Report_C0;
import com.blg.rtu.protocol.p206.cdC2.Answer_C2;
import com.blg.rtu.protocol.p206.cdC2.Read_C2;
import com.blg.rtu.protocol.p206.cdC5_D5.Answer_C5_D5;
import com.blg.rtu.protocol.p206.cdC5_D5.Read_C5;
import com.blg.rtu.protocol.p206.cdC5_D5.Write_D5;
import com.blg.rtu.protocol.p206.cdC8.Answer_C8;
import com.blg.rtu.protocol.p206.cdC8.Read_C8;
import com.blg.rtu.protocol.p206.cdC9_D9.Answer_C9_D9;
import com.blg.rtu.protocol.p206.cdC9_D9.Read_C9;
import com.blg.rtu.protocol.p206.cdC9_D9.Write_D9;
import com.blg.rtu.protocol.p206.cdCA_DA.Answer_CA_DA;
import com.blg.rtu.protocol.p206.cdCA_DA.Read_CA;
import com.blg.rtu.protocol.p206.cdCA_DA.Write_DA;
import com.blg.rtu.protocol.p206.cdCB_DB.Answer_CB_DB;
import com.blg.rtu.protocol.p206.cdCB_DB.Read_CB;
import com.blg.rtu.protocol.p206.cdCB_DB.Write_DB;
import com.blg.rtu.protocol.p206.cdCC_DC.Answer_CC_DC;
import com.blg.rtu.protocol.p206.cdCC_DC.Read_CC;
import com.blg.rtu.protocol.p206.cdCC_DC.Write_DC;
import com.blg.rtu.protocol.p206.cdCD_DD.Answer_CD_DD;
import com.blg.rtu.protocol.p206.cdCD_DD.Read_CD;
import com.blg.rtu.protocol.p206.cdCD_DD.Write_DD;
import com.blg.rtu.protocol.p206.cdCE_DE.Answer_CE_DE;
import com.blg.rtu.protocol.p206.cdCE_DE.Read_CE;
import com.blg.rtu.protocol.p206.cdCE_DE.Write_DE;
import com.blg.rtu.protocol.p206.cdCF_DF.Answer_CF_DF;
import com.blg.rtu.protocol.p206.cdCF_DF.Read_CF;
import com.blg.rtu.protocol.p206.cdCF_DF.Write_DF;
import com.blg.rtu.protocol.p206.cdD2_D6.Answer_D2_D6;
import com.blg.rtu.protocol.p206.cdD2_D6.Read_D2;
import com.blg.rtu.protocol.p206.cdD2_D6.Write_D6;
import com.blg.rtu.protocol.p206.cdD3.Answer_D3;
import com.blg.rtu.protocol.p206.cdD3.Read_D3;
import com.blg.rtu.protocol.p206.cdD4.Answer_D4;
import com.blg.rtu.protocol.p206.cdD4.Read_D4;
import com.blg.rtu.protocol.p206.cdD8.Answer_D8;
import com.blg.rtu.protocol.p206.cdD8.Write_D8;
import com.blg.rtu.protocol.p206.cdE0.Answer_E0;
import com.blg.rtu.protocol.p206.cdE0.Read_E0;
import com.blg.rtu.protocol.p206.cdE1_F1.Answer_E1_F1;
import com.blg.rtu.protocol.p206.cdE1_F1.Read_E1;
import com.blg.rtu.protocol.p206.cdE1_F1.Write_F1;
import com.blg.rtu.protocol.p206.cdE2_F2.Answer_E2_F2;
import com.blg.rtu.protocol.p206.cdE2_F2.Read_E2;
import com.blg.rtu.protocol.p206.cdE2_F2.Write_F2;
import com.blg.rtu.protocol.p206.cdE3_F3.Answer_E3_F3;
import com.blg.rtu.protocol.p206.cdE3_F3.Read_E3;
import com.blg.rtu.protocol.p206.cdE3_F3.Write_F3;
import com.blg.rtu.protocol.p206.cdE4_F4.Answer_E4_F4;
import com.blg.rtu.protocol.p206.cdE4_F4.Read_E4;
import com.blg.rtu.protocol.p206.cdE4_F4.Write_F4;
import com.blg.rtu.protocol.p206.cdE5_F5.Answer_E5_F5;
import com.blg.rtu.protocol.p206.cdE5_F5.Read_E5;
import com.blg.rtu.protocol.p206.cdE5_F5.Write_F5;
import com.blg.rtu.protocol.p206.cdE6_F6.Answer_E6_F6;
import com.blg.rtu.protocol.p206.cdE6_F6.Read_E6;
import com.blg.rtu.protocol.p206.cdE6_F6.Write_F6;
import com.blg.rtu.protocol.p206.cdE7_F7.Answer_E7_F7;
import com.blg.rtu.protocol.p206.cdE7_F7.Read_E7;
import com.blg.rtu.protocol.p206.cdE7_F7.Write_F7;
import com.blg.rtu.protocol.p206.cdE8_F8.Answer_E8_F8;
import com.blg.rtu.protocol.p206.cdE8_F8.Read_E8;
import com.blg.rtu.protocol.p206.cdE8_F8.Write_F8;
import com.blg.rtu.protocol.p206.cdE9_F9.Answer_E9_F9;
import com.blg.rtu.protocol.p206.cdE9_F9.Read_E9;
import com.blg.rtu.protocol.p206.cdE9_F9.Write_F9;
import com.blg.rtu.protocol.p206.cdEA_FA.Answer_EA_FA;
import com.blg.rtu.protocol.p206.cdEA_FA.Read_EA;
import com.blg.rtu.protocol.p206.cdEA_FA.Write_FA;
import com.blg.rtu.protocol.p206.cdEB_FB.Answer_EB_FB;
import com.blg.rtu.protocol.p206.cdEB_FB.Read_EB;
import com.blg.rtu.protocol.p206.cdEB_FB.Write_FB;
import com.blg.rtu.protocol.p206.cdEC_FC.Answer_EC_FC;
import com.blg.rtu.protocol.p206.cdEC_FC.Read_EC;
import com.blg.rtu.protocol.p206.cdEC_FC.Write_FC;
import com.blg.rtu.protocol.p206.cdED.Answer_ED;
import com.blg.rtu.protocol.p206.cdED.Read_ED;
import com.blg.rtu.protocol.p206.cdEF.Answer_EF;
import com.blg.rtu.protocol.p206.cdEF.Read_EF;
import com.blg.rtu.protocol.p206.cdF0.Answer_F0;
import com.blg.rtu.protocol.p206.cdF0.Read_F0;
import com.blg.rtu.protocol.p206.common.CodeProtocol;
import com.blg.rtu.protocol.p206.common.ControlProtocol;
import com.blg.rtu.protocol.p206.common.HeadProtocol;
import com.blg.rtu.protocol.p206.common.RtuIdProtocol;
import com.blg.rtu.protocol.p206.common.TailProtocol;
import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.StringValueForServer;


public class Driver206 extends DriverRtu {
	
	private static String tag = Driver206.class.getName() ;

	//测控终端的工作模式，RTU驱动里，一般不用全局变量，
	//但是这里存所要设置的工作模式可以这样做。
	//根据协议定义，工作模式要从主动上报数据的确认帧中下发，所以这里存储一下
	private static HashMap<String, Integer> rtuWilSetModels = new HashMap<String, Integer>() ;
	/**
	 * 分析RTU数据
	 * @param rtuId
	 * @param b
	 * @return  
	 */
	@SuppressWarnings("unused")
	@Override
	public Action analyseData(byte[] b) {
		String dataHex = null ;
		try {
			dataHex = ByteUtil.bytes2Hex(b, false) ;
			// 检查数据头合法性
			int dataLen = new HeadProtocol().checkHeadAndGetDataLen(b) ;
			// 检查数据尾合法性
			// 因为功能码为ED的命令CRC验证不正确，硬件方总说没有问题，所以此处把CRC校验去除了
			new TailProtocol().checkTail(b, dataLen, false) ;

			//进行控制域分析
			ControlProtocol ca = new ControlProtocol().parseControl(b) ;
			
			//进行RTU 地址域分析
			int index = Constant.Site_RTUID ;
			if(ca.hasDIVS){
				index += 1 ;
			}
			String[] strs = new RtuIdProtocol().parseRtuId_2(b, index, index + Constant.Bits_RTU_ID - 1) ;
			this.rtuId = strs[0] ;
			this.rtuId_hex = strs[1] ;
			
			//得到数据中的功能码
			index = Constant.Site_Code ;
			if(ca.hasDIVS){
				index += 1 ;
			}
			this.dataCode = new CodeProtocol().parseCode(b, index) ;

			
			Action action = Action.nullAction() ;
			
			if(this.dataCode == null){
				Log.e(tag, "出错，未能得到RTU数据中的功能码，不能分析数据。") ;
				action.append(Action.noAction) ;
			}
			if(this.dataCode.equalsIgnoreCase(Code206.cd_02)){
				//有关RTU 链路检测
				LinkTest_02 parse = new LinkTest_02() ;
				this.upData = parse.parse(rtuId, b, ca, dataCode) ;
				if(StringValueForServer.protocolEnableClockSyn == 1){ 
					if(parse.getClockDifference_minute_abs() > StringValueForServer.protocolSynClockDeviate){
						//进行时钟同步
						action.append(Action.synchronizeClock) ;
					}
				}
				if(this.upData != null){
					//得到从上报数据中分析出来的RTU ID
					Data_02 subD = (Data_02)this.upData.getSubData() ;
					String status = subD.getStatus() ;
					if(status != null && status.equals(Constant.LinkTest_F0)){
						//上线（登录）
						this.rtuId = this.upData.getRtuId() ;
						this.downData = new Confirm_02().create(Code206.cd_02, Constant.Down_ControlFunCode_0, rtuId , subD.getOraData(), this.getRtupassword()) ;
						this.commandCode = Code206.cd_02 ;
						action.append(Action.remoteConfirmAction) ;
					}else if(status != null && status.equals(Constant.LinkTest_F1)){
						//下线(退出登录)
					}else if(status != null && status.equals(Constant.LinkTest_F2)){
						//在线保持
					}else if(status != null && status.equals(Constant.LinkTest_unknow)){
						//不能识别的状态
					}else{
						//status为空
					}
				}
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_10)){
				//应答 - 设置遥测终端、中继站地址
				this.upData = new Answer_10_50().parse(rtuId, b, ca, dataCode) ;
				action.append(Action.changeRtuIdAction) ;
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_44)){
				//应答 - 设置遥测终端、中继站地址
				this.upData = new Answer_44_74().parse(rtuId, b, ca, dataCode) ;
				action.append(Action.changeRtuIdAction) ;
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_50)){
				//应答 - 查询遥测终端、中继站地址
				this.upData = new Answer_10_50().parse(rtuId, b, ca, dataCode) ;
				action.append(Action.commandReadRtuIdResultAction) ;
				action.append(Action.commandResultAction) ;
				
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_74)){
				//应答 - 查询遥测终端、中继站地址
				this.upData = new Answer_44_74().parse(rtuId, b, ca, dataCode) ;
				action.append(Action.commandReadRtuIdResultAction) ;
				action.append(Action.commandResultAction) ;
				
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_11)){
				//应答 - 设置遥测终端、中继站时钟
				this.upData = new Answer_11_51().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_51)){
				//应答 - 查询遥测终端、中继站时钟
				Answer_11_51 answer = new Answer_11_51() ;
				this.upData = answer.parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
				/*
				 不自动设置，手动设置，以使人员能知道时钟不正确
				if(StringValueForServer.protocolEnableClockSyn == 1){ 
					if(answer.getClockDifference_minute_abs() > StringValueForServer.protocolSynClockDeviate){
						//进行时钟同步
						action.append(Action.synchronizeClock) ;
					}
				}
				*/
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_12)){
				//应答 - 设置遥测终端工作模式
				this.upData = new Answer_12_52().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_52)){
				//应答 - 查询遥测终端工作模式
				this.upData = new Answer_12_52().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_A1)){
				//应答 - 设置遥测终端的数据自报种类及时间间隔
				this.upData = new Answer_A1_53().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_53)){
				//应答 查询遥测终端的数据自报种类及时间间隔
				this.upData = new Answer_A1_53().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_A0)){
				//应答 - 设置遥测站需查询的实时数据种类
				this.upData = new Answer_A0_54().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_54)){
				//应答 - 查询遥测站需查询的实时数据种类
				this.upData = new Answer_A0_54().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_15)){
				//应答 - 设置遥测终端本次充值量
				this.upData = new Answer_15().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_55)){
				//应答 - 查询查询遥测终端最近成功充值量和现有剩余水量
				this.upData = new Answer_55().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_16)){
				//应答 - 设置遥测终端剩余水量报警值
				this.upData = new Answer_16().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_56)){
				//应答 - 查询遥测终端的剩余水量和报警值
				this.upData = new Answer_56().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_17)){
				//应答 - 设置遥测终端的水位基值、水位上下限
				this.upData = new Answer_17().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_57)){
				//应答 - 查询遥测终端的水位基值、水位上下限及报警
				this.upData = new Answer_57().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			//该命令无应答				
			//if(this.dataCode.equalsIgnoreCase(Code206_2012.cd_18)){
			//	//应答 - 设置遥测终端水压上、下限
			//	this.upData = new Answer_18().parse(rtuId, b, cp, this.dataCode);
			//	activ.append(Action.orderResultAction) ;
			//}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_58)){
				//应答 - 查询遥测终端水压上、下限
				this.upData = new Answer_58().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_19)){
				//应答 - 设置遥测终端水质参数种类、上限值
				this.upData = new Answer_19_59().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_59)){
				//应答 - 查询遥测终端水质参数种类、上限值
				this.upData = new Answer_19_59().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_1A)){
				//应答 - 设置遥测终端水质参数种类、下限值
				this.upData = new Answer_1A_5A().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_5A)){
				//应答 - 查询遥测终端水质参数种类、下限值
				this.upData = new Answer_1A_5A().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_1B)){
				//应答 - 设置终端站流量的表底（初始）值
				this.upData = new Answer_1B().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_1F)){
				//应答 - 设置遥测终端的流量参数上限值
				this.upData = new Answer_1F().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_20)){
				//应答 - 设置遥测终端检测参数启报阈值及固态存储时间段间隔
				this.upData = new Answer_20().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_64)){
				//应答 - 查询遥测终端流量参数上限值
				this.upData = new Answer_64().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_B0)){
				//应答 - 查询遥测终端实时值 
				this.upData = new Answer_B0().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_B1)){
				//应答 - 查询遥测终端固态存储数据 
				this.upData = new Answer_B1().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_1C)){
				//应答 - 设置遥测终端转发中继引导码长
				this.upData = new Answer_1C_60().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_60)){
				//应答 - 查询遥测终端转发中继引导码长
				this.upData = new Answer_1C_60().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_1D)){
				//应答 - 设置中继站转发终端地址
				this.upData = new Answer_1D_62().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_62)){
				//应答 - 查询中继站转发终端地址
				this.upData = new Answer_1D_62().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_1E)){
				//应答 - 设置中继站工作机自动切换，自报状态
				this.upData = new Answer_1E().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_63)){
				//应答 - 查询中继站工作机状态和切换记录  
				this.upData = new Answer_63().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_30)){
				//应答 - 置遥测终端IC 卡功能有效
				this.upData = new Answer_30().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_31)){
				//应答 - 取消遥测终端IC 卡功能  
				this.upData = new Answer_31().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_32)){
				//应答 - 定值控制投入
				this.upData = new Answer_32().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_33)){
				//应答 - 定值控制退出   
				this.upData = new Answer_33().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_34)){
				//应答 - 定值量设定 
				this.upData = new Answer_34().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_B2)){
				//应答 - 查询遥测终端内存自报数据 
				this.upData = new Answer_B2().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_5D)){
				//应答 - 查询遥测终端的事件记录 
				this.upData = new Answer_5D().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_5E)){
				//应答 - 查询遥测终端状态和报警状态  
				this.upData = new Answer_5E().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_90)){
				//应答 - 复位遥测终端参数和状态 
				this.upData = new Answer_90().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_40)){
				//应答 - 设置净积
				this.upData = new Answer_40().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_91)){
				//应答 - 清空遥测终端历史数据单元  
				this.upData = new Answer_91().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_92)){
				//应答 - 遥控启动水泵或阀门/闸门 
				this.upData = new Answer_92().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_93)){
				//应答 - 遥控关闭水泵或阀门/闸门 
				this.upData = new Answer_93().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_94)){
				//应答 - 遥控终端或中继站通信机切换 
				this.upData = new Answer_94().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_95)){
				//应答 - 遥控中继站工作机切换  
				this.upData = new Answer_95().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_96)){
				//应答 - 修改遥测终端密码   
				this.upData = new Answer_96().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_41)){
				//应答 - 修改ModBus配置密码
				this.upData = new Answer_41().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_C0)){
				//遥测终端自报实时数据
				Report_C0 report = new Report_C0() ;
				this.upData = report.parse(rtuId, b, ca, this.dataCode);
				action.append(Action.autoReportAction) ;
				if(this.upData != null){
					//构造确认命令
					this.commandCode = this.dataCode ;
					Integer setModel = rtuWilSetModels.get(rtuId) ;
					if(setModel == null){
						setModel = report.getModel() ;
					}
					this.downData = new Confirm_C0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , setModel.intValue(), null, this.getRtupassword()) ;
					action.append(Action.remoteConfirmAction) ;
				}
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_81)){
				//随机自报报警数据 遥测终端 
				Report_81 report = new Report_81() ;
				this.upData = report.parse(rtuId, b, ca, this.dataCode);
				action.append(Action.autoReportAction) ;
				if(this.upData != null){
					//构造确认命令
					this.commandCode = this.dataCode ;
					Integer setModel = rtuWilSetModels.get(rtuId) ;
					if(setModel == null){
						setModel = report.getModel() ;
					}
					this.downData = new Confirm_C0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , setModel.intValue(), null, this.getRtupassword()) ;
					action.append(Action.remoteConfirmAction) ;
				}
			}else
//			大手机端  在下面实现了82命令	
//			if(this.dataCode.equalsIgnoreCase(Code206.cd_82)){
//				//人工置数 遥测终端 
//				Report_82 report = new Report_82() ;
//				this.upData = report.parse(rtuId, b, ca, this.dataCode);
//				action.append(Action.autoReportAction) ;
//				if(this.upData != null){
//					//构造确认命令
//					this.commandCode = this.dataCode ;
//					Integer setModel = rtuWilSetModels.get(rtuId) ;
//					if(setModel == null){
//						setModel = report.getModel() ;
//					}
//					this.downData = new Confirm_C0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , setModel.intValue(), null, this.getRtupassword()) ;
//					action.append(Action.remoteConfirmAction) ;
//				}
//			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E0)){
				//应答 - 查询供电方式及电压
				this.upData = new Answer_E0().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E1)){
				//应答 - 电池池电压报警值
				this.upData = new Answer_E1_F1().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F1)){
				///应答 - 设置电池池电压报警值
				this.upData = new Answer_E1_F1().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_CF)){
				//应答 - 查询DTU工作模式
				this.upData = new Answer_CF_DF().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_DF)){
				//应答 - 设置DTU工作模式
				this.upData = new Answer_CF_DF().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D3)){
				this.upData = new Answer_D3().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D4)){
				this.upData = new Answer_D4().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_EF)){
				this.upData = new Answer_EF().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_C9)){
				//应答 - 查询终端心跳周期
				this.upData = new Answer_C9_D9().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D9)){
				//应答 - 设置终端心跳周期
				this.upData = new Answer_C9_D9().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_CB)){
				//应答 - 查询终端主备通道
				this.upData = new Answer_CB_DB().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_DB)){
				//应答 - 设置终端主备通道
				this.upData = new Answer_CB_DB().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_CA)){
				//应答 - 查询GPRS接入点
				this.upData = new Answer_CA_DA().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_DA)){
				//应答 - 设置GPRS接入点
				this.upData = new Answer_CA_DA().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D2)){
				//应答 - 查询中心网址
				this.upData = new Answer_D2_D6().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_CC)){
				//应答 - 查询中心网址
				this.upData = new Answer_CC_DC().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D6)){
				//应答 - 设置中心网址
				this.upData = new Answer_D2_D6().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_DC)){
				//应答 - 设置中心网址
				this.upData = new Answer_CC_DC().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_CD)){
				//应答 - 查询短信中心号码
				this.upData = new Answer_CD_DD().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_73)){
				//应答 - 查询ModBus关联地址
				this.upData = new Answer_43_73().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_75)){
				//应答 - 查询LCD显示内容及时间间隔
				this.upData = new Answer_45_75().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_76)){
				//应答 - 查询正积流量
				this.upData = new Answer_76().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_77)){
				//应答 - 查询负积流量
				this.upData = new Answer_77().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_78)){
				//应答 - 查询表口径
				this.upData = new Answer_48_78().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_79)){
				//应答 - 查询整体脉冲系数
				this.upData = new Answer_49_79().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_7A)){
				//应答 - 查询RF频点
				this.upData = new Answer_4A_7A().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_DD)){
				//应答 - 设置短信中心号码
				this.upData = new Answer_CD_DD().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_43)){
				//应答 - 设置ModBus关联地址
				this.upData = new Answer_43_73().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_45)){
				//应答 - 设置LCD显示内容及刷屏间隔
				this.upData = new Answer_45_75().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_46)){
				//应答 - 设置正积流量
				this.upData = new Answer_46().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_47)){
				//应答 - 设置负积流量
				this.upData = new Answer_47().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_48)){
				//应答 - 设置表口径
				this.upData = new Answer_48_78().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_49)){
				//应答 - 设置整体脉冲系数
				this.upData = new Answer_49_79().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_4A)){
				//应答 - 设置RF频点
				this.upData = new Answer_4A_7A().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_CE)){
				//应答 - 查询卫星中心号码
				this.upData = new Answer_CE_DE().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_DE)){
				//应答 - 设置卫星中心号码
				this.upData = new Answer_CE_DE().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_C8)){
				//应答 - 查询RTU在线状态
				this.upData = new Answer_C8().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E2)){
				//应答 - 查询电源采集校准系数
				this.upData = new Answer_E2_F2().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F2)){
				//应答 - 设置电源采集校准系数
				this.upData = new Answer_E2_F2().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D8)){
				//应答 - 设置AD校准命令(代替了F2命令)
				this.upData = new Answer_D8().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E3)){
				//应答 - 查询仪表系数
				this.upData = new Answer_E3_F3().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F3)){
				//应答 - 设置仪表系数
				this.upData = new Answer_E3_F3().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E4)){
				//应答 - 查询仪表量程
				this.upData = new Answer_E4_F4().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F4)){
				//应答 - 设置仪表量程
				this.upData = new Answer_E4_F4().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E5)){
				//应答 - 查询仪表采集修正值
				this.upData = new Answer_E5_F5().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F5)){
				//应答 - 设置仪表采集修正值
				this.upData = new Answer_E5_F5().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E6)){
				//应答 - 查询仪表AD采集校准值
				this.upData = new Answer_E6_F6().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F6)){
				//应答 - 设置仪表AD采集校准值
				this.upData = new Answer_E6_F6().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E9)){
				//应答 - 查询仪表仪表上电读值延时时间
				this.upData = new Answer_E9_F9().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F9)){
				//应答 - 设置仪表仪表上电读值延时时间
				this.upData = new Answer_E9_F9().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_EA)){
				//应答 - 查询井口高程，水井深度，探头埋深
				this.upData = new Answer_EA_FA().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_FA)){
				//应答 - 设置井口高程，水井深度，探头埋深
				this.upData = new Answer_EA_FA().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E7)){
				//应答 - 查询数据采集种类及时间间隔
				this.upData = new Answer_E7_F7().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F7)){
				//应答 - 设置数据采集种类及时间间隔
				this.upData = new Answer_E7_F7().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_E8)){
				//应答 - 查询上报起始时间
				this.upData = new Answer_E8_F8().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F8)){
				//应答 - 设置上报起始时间
				this.upData = new Answer_E8_F8().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_EB)){
				//应答 - 查询水位上报种类
				this.upData = new Answer_EB_FB().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_FB)){
				//应答 - 设置水位上报种类
				this.upData = new Answer_EB_FB().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_EC)){
				//应答 - 查询日志配置表
				this.upData = new Answer_EC_FC().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_FC)){
				//应答 - 设置日志配置表
				this.upData = new Answer_EC_FC().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_ED)){
				//应答 - 查询日志信息
				this.upData = new Answer_ED().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else			
			if(this.dataCode.equalsIgnoreCase(Code206.cd_82)){
				//应答 - 人工置数 遥测终端  
				this.upData = new Answer_82().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_C5)){
				//应答 - 查询流量实时值
				this.upData = new Answer_C5_D5().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_72)){
				//应答 - 查询ModBus地址
				this.upData = new Answer_42_72().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else
			if(this.dataCode.equalsIgnoreCase(Code206.cd_C2)){
				//应答 - 查询定时上报的时刻
				this.upData = new Answer_C2().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_D5)){
				//应答 - 设置定时上报的时刻
				this.upData = new Answer_C5_D5().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_42)){
				//应答 - 设置定时上报的时刻
				this.upData = new Answer_42_72().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}else	
			if(this.dataCode.equalsIgnoreCase(Code206.cd_F0)){
				//应答 - 查询关键参数
				this.upData = new Answer_F0().parse(rtuId, b, ca, this.dataCode);
				action.append(Action.commandResultAction) ;
			}

			
			if(this.upData != null){
				//得到从上报数据中分析出来的RTU ID
				//this.rtuId = this.upData.getRtuId() ;
				
				//把十六进制ID放入
				this.upData.setRtuId_hex(this.rtuId_hex) ;
				//把上行数据的十六进制放入数据中
				this.upData.setHex(dataHex) ;
				
			}
			return action == null?Action.noAction:action ;
			
		} catch (Exception e) {
			if(e == null){
				this.error = "出错， 数据：" + dataHex;
				
			}else{
				if(e.getMessage() != null){
					Log.e(tag, e.getMessage());
					this.error = e.getMessage()+ " 数据：" + dataHex;
				}else{
					this.error = "出错， 数据：" + dataHex;
				}	
			}
			Log.e(tag, "数据：" + dataHex);
			return Action.errorAction;
		}
	}
	
	/**
	 * 构造针对RTU(测控终端)的命令
	 * @param command 命令
	 * @param password RTU的密码与密码
	 * @return
	 */
	@Override
	public Action createCommand(RtuCommand command) {
		try {
			HashMap<String, Object> params = command.getParams() ;
			//params可以为空，如查终端地址
//			if(params == null || params.size() == 0){
//				this.error = "出错，命令中参数集合为空，不能构建任何命令！" ;
//				Log.e(tag, error) ;
//				return Action.errorAction ;
//			}
			this.rtuId = command.getRtuId() ;
			if(this.rtuId == null || this.rtuId == null){
				this.error = "出错，命令中RTU ID为空，不能构建任何命令！" ;
				Log.e(tag, error) ;
				return Action.errorAction ;
			}
			
			this.commandCode = command.getCommandCode() ;
			if(this.commandCode == null || this.commandCode.trim().equals("")){
				this.error = "出错，命令中功能码为空，不能构建任何命令！" ;
				Log.e(tag, error) ;
				return Action.errorAction ;
			}
			
			String password = this.getRtupassword();
			
			Action activ = Action.nullAction() ;

			if(this.commandCode.equalsIgnoreCase(Code206.cd_02)){
				//链路检测
				this.downData = new Write_02().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_10)){
				//设置遥测终端、中继站地址
				this.downData = new Write_10().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_44)){
				//设置遥测终端、中继站地址
				this.downData = new Write_44().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_50)){
				//查询遥测终端、中继站地址
				this.downData = new Read_50().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_74)){
				//查询遥测终端、中继站地址
				this.downData = new Read_74().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_11)){
				//设置遥测终端、中继站时钟
				this.downData = new Write_11().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_51)){
				//查询遥测终端、中继站时钟
				this.downData = new Read_51().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_12)){
				//设置遥测终端工作模式
				this.downData = new Write_12().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_52)){
				//查询遥测终端工作模式
				this.downData = new Read_52().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_A1)){
				//设置遥测终端的数据自报种类及时间间隔
				this.downData = new Write_A1().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_53)){
				//查询遥测终端的数据自报种类及时间间隔
				this.downData = new Read_53().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_A0)){
				//设置遥测站需查询的实时数据种类
				this.downData = new Write_A0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_54)){
				//查询遥测站需查询的实时数据种类
				this.downData = new Read_54().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_15)){
				//设置遥测终端本次充值量
				this.downData = new Write_15().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_55)){
				//查询遥测终端最近成功充值量和现有剩余水量
				this.downData = new Read_55().create(this.commandCode, Constant.Down_ControlFunCode_3, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_16)){
				//设置遥测终端剩余水量报警值
				this.downData = new Write_16().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_56)){
				//查询遥测终端的剩余水量和报警值
				this.downData = new Read_56().create(this.commandCode, Constant.Down_ControlFunCode_3, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_17)){
				//设置遥测终端的水位基值、水位上下限
				this.downData = new Write_17().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_57)){
				//查询遥测终端的水位基值、水位上下限及报警
				this.downData = new Read_57().create(this.commandCode, Constant.Down_ControlFunCode_2, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_18)){
				//设置遥测终端水压上、下限
				this.downData = new Write_17().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_58)){
				//查询遥测终端水压上、下限及报警
				this.downData = new Read_57().create(this.commandCode, Constant.Down_ControlFunCode_15, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_19)){
				//设置遥测终端水质参数种类、上限值
				this.downData = new Write_19().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_59)){
				//查询遥测终端水质参数种类、上限值
				this.downData = new Read_59().create(this.commandCode, Constant.Down_ControlFunCode_10, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_1A)){
				//设置遥测终端水质参数种类、下限值
				this.downData = new Write_1A().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_5A)){
				//查询遥测终端水质参数种类、下限值
				this.downData = new Read_5A().create(this.commandCode, Constant.Down_ControlFunCode_10, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_1B)){
				//设置终端站流量的表底（初始）值
				this.downData = new Write_1B().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_1F)){
				//设置遥测终端的流量参数上限值
				this.downData = new Write_1F().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_64)){
				//查询遥测终端流量参数上限值
				this.downData = new Read_64().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_B0)){
				//查询遥测终端实时值 
				this.downData = new Read_B0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_B1)){
				//查询遥测终端固态存储数据
				this.downData = new Read_B1().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_B2)){
				//查询遥测终端内存自报数据 （如果RTU内存中有未得到应答的自报数据，则不应答）
				this.downData = new Read_B2().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				//一般情况下，自报数据都会得到应答，
				//此命令不能多发，因如果RTU有未得到应答的自报数据，就不应答命令，而上报该种数据，
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_20)){
				//设置遥测终端检测参数启报阈值及固态存储时间段间隔
				this.downData = new Write_20().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_1C)){
				//设置遥测终端转发中继引导码长
				this.downData = new Write_1C().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_60)){
				//查询遥测终端转发中继引导码长
				this.downData = new Read_60().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_1D)){
				//设置中继站转发终端地址
				this.downData = new Write_1D().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_62)){
				//查询中继站转发终端地址 
				this.downData = new Read_62().create(this.commandCode, Constant.Down_ControlFunCode_3, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_1E)){
				//设置中继站工作机自动切换，自报状态
				this.downData = new Write_1E().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_63)){
				//查询中继站工作机状态和切换记录
				this.downData = new Read_63().create(this.commandCode, Constant.Down_ControlFunCode_3, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_30)){
				//设置遥测终端IC 卡功能有效 
				this.downData = new Write_30().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_31)){
				//取消遥测终端IC 卡功能
				this.downData = new Write_31().create(this.commandCode, Constant.Down_ControlFunCode_3, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_32)){
				//定值控制投入
				this.downData = new Write_32().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId, params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_33)){
				//定值控制退出 
				this.downData = new Write_33().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_5D)){
				//查询遥测终端的事件记录 
				this.downData = new Read_5D().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_5E)){
				//查询遥测终端状态和报警状态 
				this.downData = new Read_5E().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_90)){
				//复位遥测终端参数和状态 
				this.downData = new Write_90().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_40)){
				//设置净积
				this.downData = new Write_40().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_91)){
				//清空遥测终端历史数据单元
				this.downData = new Write_91().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_92)){
				//遥控启动水泵或阀门/闸门
				this.downData = new Write_92().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_93)){
				//遥控关闭水泵或阀门/闸门
				this.downData = new Write_93().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_94)){
				//遥控终端或中继站通信机切换 
				this.downData = new Write_94().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_95)){
				//遥控中继站工作机切换  
				this.downData = new Write_95().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_96)){
				//修改遥测终端密码   
				this.downData = new Write_96().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_41)){
				//修改ModBus配置密码 
				this.downData = new Write_41().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E0)){
				//查询供电方式及电压
				this.downData = new Read_E0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E1)){
				///查询电池池电压报警值
				this.downData = new Read_E1().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F1)){
				//设置电池池电压报警值
				this.downData = new Write_F1().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_EF)){
				//查询遥测终端硬软件版本号
				this.downData = new Read_EF().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_CF)){
				//查询DTU工作模式
				this.downData = new Read_CF().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_DF)){
				//设置DTU工作模式
				this.downData = new Write_DF().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_C9)){
				//查询终端心跳周期
				this.downData = new Read_C9().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D9)){
				//设置终端心跳周期
				this.downData = new Write_D9().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_CB)){
				//查询终端主备通道
				this.downData = new Read_CB().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_DB)){
				//设置终端主备通道
				this.downData = new Write_DB().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_CA)){
				//查询GPRS接入点
				this.downData = new Read_CA().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_DA)){
				//设置GPRS接入点
				this.downData = new Write_DA().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D2)){
				//查询中心网址
				this.downData = new Read_D2().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_CC)){
				//查询中心网址
				this.downData = new Read_CC().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D6)){
				//查询中心网址
				this.downData = new Write_D6().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_DC)){
				//设置中心网址
				this.downData = new Write_DC().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_CD)){
				//查询短信中心号码
				this.downData = new Read_CD().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_73)){
				//查询ModBus关联地址
				this.downData = new Read_73().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_75)){
				//查询LCD显示内容及刷屏间隔
				this.downData = new Read_75().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else
			if(this.commandCode.equalsIgnoreCase(Code206.cd_76)){
				//查询正积流量
				this.downData = new Read_76().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_77)){
				//查询负积流量
				this.downData = new Read_77().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_78)){
				//查询表口径
				this.downData = new Read_78().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_79)){
				//查询整体脉冲系数
				this.downData = new Read_79().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_7A)){
				//查询RF频点
				this.downData = new Read_7A().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_DD)){
				//设置短信中心号码
				this.downData = new Write_DD().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_43)){
				//设置中继器关联ModBus地址
				this.downData = new Write_43().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_45)){
				//设置LCD显示内容及刷屏间隔
				this.downData = new Write_45().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_46)){
				//设置正积流量
				this.downData = new Write_46().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_47)){
				//设置负积流量
				this.downData = new Write_47().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_48)){
				//设置表口径
				this.downData = new Write_48().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_49)){
				//设置整体脉冲系数
				this.downData = new Write_49().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_4A)){
				//设置RF频点
				this.downData = new Write_4A().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_CE)){
				//查询卫星中心号码
				this.downData = new Read_CE().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_DE)){
				//设置卫星中心号码
				this.downData = new Write_DE().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_C8)){
				//查询RTU在线状态
				this.downData = new Read_C8().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E2)){
				//查询电源采集校准系数
				this.downData = new Read_E2().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F2)){
				//设置电源采集校准系数
				this.downData = new Write_F2().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E3)){
				//查询仪表系数
				this.downData = new Read_E3().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D8)){
				//设置AD校准命令(代替了F2命令)
				this.downData = new Write_D8().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F3)){
				//设置仪表系数
				this.downData = new Write_F3().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E4)){
				//查询仪表量程
				this.downData = new Read_E4().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F4)){
				//设置仪表量程
				this.downData = new Write_F4().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E5)){
				//查询仪表采集修正值
				this.downData = new Read_E5().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F5)){
				//设置仪表采集修正值
				this.downData = new Write_F5().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E6)){
				//查询仪表AD采集校准值
				this.downData = new Read_E6().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F6)){
				//设置仪表AD采集校准值
				this.downData = new Write_F6().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E9)){
				//查询仪表仪表上电读值延时时间
				this.downData = new Read_E9().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F9)){
				//设置仪表仪表上电读值延时时间
				this.downData = new Write_F9().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_EA)){
				//查询井口高程，水井深度，探头埋深
				this.downData = new Read_EA().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_FA)){
				//设置井口高程，水井深度，探头埋深
				this.downData = new Write_FA().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E7)){
				//查询数据采集种类及时间间隔
				this.downData = new Read_E7().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F7)){
				//设置数据采集种类及时间间隔
				this.downData = new Write_F7().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_E8)){
				//查询上报起始时间
				this.downData = new Read_E8().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F8)){
				//设置上报起始时间
				this.downData = new Write_F8().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_EB)){
				//查询水位上报种类
				this.downData = new Read_EB().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_FB)){
				//设置水位上报种类
				this.downData = new Write_FB().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_EC)){
				//查询水位上报种类
				this.downData = new Read_EC().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_FC)){
				//设置水位上报种类
				this.downData = new Write_FC().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_ED)){
				//查询日志信息
				this.downData = new Read_ED().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandSendOnlyOnceAction ;
			}else  
			if(this.commandCode.equalsIgnoreCase(Code206.cd_82)){
				//人工置数 遥测终端  
				this.downData = new Write_82().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandSendOnlyOnceAction ;
			}else 	
			if(this.commandCode.equalsIgnoreCase(Code206.cd_C5)){
				//查询定时上报的时刻
				this.downData = new Read_C5().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_72)){
				//查询定时上报的时刻
				this.downData = new Read_72().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_C2)){
				//查询流量实时值
				this.downData = new Read_C2().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D3)){
				//查询流量实时值
				this.downData = new Read_D3().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D4)){
				//查询SIM卡ICCID
				this.downData = new Read_D4().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_D5)){
				//设置定时上报的时刻
				this.downData = new Write_D5().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_42)){
				//设置定时上报的时刻
				this.downData = new Write_42().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			if(this.commandCode.equalsIgnoreCase(Code206.cd_F0)){
				//查询关键参数
				this.downData = new Read_F0().create(this.commandCode, Constant.Down_ControlFunCode_0, this.rtuId , params, password) ;
				activ = Action.remoteCommandAction ;
			}else 
			{
				this.error = "出错，命令中功能码(" + this.commandCode + ")不能被识别！" ;
				Log.e(tag, error) ;
				activ = Action.unknownAction ;
			}
			return activ == null?Action.noAction:activ ;
		} catch (Exception e) {
			Log.e(tag, e.getMessage());
			this.error = e.getMessage();
			return Action.errorAction;
		}
	}
	

	/**
	 * 直接创建设置时钟命令
	 * @throws  
	 */
	@Override
	public byte[] createSetClockOrderDirect(String rtuId) {
		try {
			return new Write_11().create(Code206.cd_11, Constant.Down_ControlFunCode_0, rtuId , null, this.getRtupassword()) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	

	/**
	 * 得到RTU 密码与密码
	 * @param id
	 * @return
	 */
	private String getRtupassword(){
		String passHex =  StringValueForServer.getDefaultPasswordHex() ;
		if(passHex != null){
			passHex = passHex.replaceAll(" ", "") ;
		}
		if(passHex == null || passHex.equals("")){
			passHex = com.blg.rtu.util.Constant.defaultPasswordHex ;
		}
		return passHex ;
	}

}
