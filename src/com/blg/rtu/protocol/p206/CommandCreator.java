package com.blg.rtu.protocol.p206;

import com.blg.rtu.protocol.RtuCommand;
import com.blg.rtu.protocol.p206.Code206;
import com.blg.rtu.protocol.p206.cd02.Param_02;
import com.blg.rtu.protocol.p206.cd10_50.Param_10;
import com.blg.rtu.protocol.p206.cd11_51.Param_11;
import com.blg.rtu.protocol.p206.cd12_52.Param_12;
import com.blg.rtu.protocol.p206.cd15_55.Param_15;
import com.blg.rtu.protocol.p206.cd16_56.Param_16;
import com.blg.rtu.protocol.p206.cd17_57.ParamMap_17;
import com.blg.rtu.protocol.p206.cd19_59.Param_19;
import com.blg.rtu.protocol.p206.cd1A_5A.Param_1A;
import com.blg.rtu.protocol.p206.cd1B.ParamMap_1B;
import com.blg.rtu.protocol.p206.cd1F_64.ParamMap_1F;
import com.blg.rtu.protocol.p206.cd20.Param_20;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterAmountList;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterLevelList;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterQuality;
import com.blg.rtu.protocol.p206.cd82_.Param_82_WaterTemperature;
import com.blg.rtu.protocol.p206.cd90.Param_90;
import com.blg.rtu.protocol.p206.cd91.Param_91;
import com.blg.rtu.protocol.p206.cd96.Param_96;
import com.blg.rtu.protocol.p206.cdA0_54.Param_A0;
import com.blg.rtu.protocol.p206.cdA1_53.Param_A1;
import com.blg.rtu.protocol.p206.cdB0.Param_B0;
import com.blg.rtu.protocol.p206.cdB1.Param_B1;
import com.blg.rtu.protocol.p206.cdC5_D5.Param_D5;
import com.blg.rtu.protocol.p206.cdC9_D9.Param_D9;
import com.blg.rtu.protocol.p206.cdCA_DA.Param_DA;
import com.blg.rtu.protocol.p206.cdCB_DB.Param_DB;
import com.blg.rtu.protocol.p206.cdCC_DC.Param_DC;
import com.blg.rtu.protocol.p206.cdCD_DD.Param_DD;
import com.blg.rtu.protocol.p206.cdCE_DE.Param_DE;
import com.blg.rtu.protocol.p206.cdCF_DF.Param_DF;
import com.blg.rtu.protocol.p206.cdD2_D6.Param_D6;
import com.blg.rtu.protocol.p206.cdD8.Param_D8;
import com.blg.rtu.protocol.p206.cdE1_F1.Param_F1;
import com.blg.rtu.protocol.p206.cdE2_F2.Param_F2;
import com.blg.rtu.protocol.p206.cdE3_F3.Param_F3;
import com.blg.rtu.protocol.p206.cdE4_F4.Param_F4;
import com.blg.rtu.protocol.p206.cdE5_F5.Param_F5;
import com.blg.rtu.protocol.p206.cdE6_F6.Param_F6;
import com.blg.rtu.protocol.p206.cdE7_F7.Param_F7;
import com.blg.rtu.protocol.p206.cdE8_F8.Param_F8;
import com.blg.rtu.protocol.p206.cdE9_F9.Param_F9;
import com.blg.rtu.protocol.p206.cdEA_FA.Param_FA;
import com.blg.rtu.protocol.p206.cdEB_FB.Param_FB;
import com.blg.rtu.protocol.p206.cdEC_FC.Param_FC;
import com.blg.rtu.protocol.p206.cdED.Param_ED;
import com.blg.rtu.util.StringValueForServer;

public class CommandCreator {

	
	public RtuCommand cd_02(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId) ; 
		com.setCommandCode(Code206.cd_02) ;
		Param_02 p = new Param_02() ;
		p.setType(Param_02.type_F2) ;
		com.getParams().put(Param_02.KEY, p) ;
		return com ;
	}

	public RtuCommand cd_10(String regionNum, String clientId, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_10) ;
		com.setRtuId(rtuId);
		Param_10 p = new Param_10() ;
		p.setNewId(regionNum + clientId) ;
		com.getParams().put(Param_10.KEY, p) ;
		return com ;
	}

	public RtuCommand cd_10_(String hexId, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_10) ;
		com.setRtuId(rtuId);
		Param_10 p = new Param_10() ;
		p.setHexNewId(hexId) ;
		com.getParams().put(Param_10.KEY, p) ;
		return com ;
	}
	
	public RtuCommand cd_50(){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(StringValueForServer.protocolBroastCommandRtuId) ;//用广播命令的RTU ID
		com.setCommandCode(Code206.cd_50) ;
		return com ;
	}
	public RtuCommand cd_11(Param_11 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_11) ;
		com.setRtuId(rtuId);
		if(p != null){
			com.getParams().put(Param_11.KEY, p);
		}
		return com ;
	}
	
	public RtuCommand cd_51(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_51) ;
		return com ;
	}
	
	
	public RtuCommand cd_12(int mode, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_12) ;
		com.setRtuId(rtuId);
		Param_12 p = new Param_12() ;
		p.setModel_0to3(mode) ;
		com.getParams().put(Param_12.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_52(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_52) ;
		return com ;
	}
	
	public RtuCommand cd_15(Param_15 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_15) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_15.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_16(Param_16 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_16) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_16.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_55(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_55) ;
		return com ;
	}
	
	public RtuCommand cd_56(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_56) ;
		return com ;
	}
	
	public RtuCommand cd_1B(ParamMap_1B p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_1B) ;
		com.setRtuId(rtuId);
		com.getParams().put(ParamMap_1B.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_90(int type, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_90) ;
		Param_90 p = new Param_90() ;
		p.setResetType(type) ;
		com.getParams().put(Param_90.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_91(int type, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_91) ;
		Param_91 p = new Param_91() ;
		p.setClearType(type) ;
		com.getParams().put(Param_91.KEY, p);
		return com ;
	}

	//////////////////////////////
	//扩展命令
	public RtuCommand cd_E0(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E0) ;
		return com ;
	}
	
	public RtuCommand cd_E1(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E1) ;
		return com ;
	}
	
	public RtuCommand cd_F1(Param_F1 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F1) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F1.KEY, p);
		return com ;
	}

	
	public RtuCommand cd_EF(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_EF) ;
		return com ;
	}

	public RtuCommand cd_CF(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_CF) ;
		return com ;
	}
	
	public RtuCommand cd_DF(int mode, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_DF) ;
		com.setRtuId(rtuId);
		Param_DF p = new Param_DF() ;
		p.setModel_0to2(mode) ;
		com.getParams().put(Param_DF.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_C9(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_C9) ;
		return com ;
	}
	
	public RtuCommand cd_D9(int interval, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_D9) ;
		com.setRtuId(rtuId);
		Param_D9 p = new Param_D9() ;
		p.setInterval_0to10(interval) ;
		com.getParams().put(Param_D9.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_CB(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_CB) ;
		return com ;
	}
	
	public RtuCommand cd_DB(int chMain, int chAssi1, int chAssi2, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_DB) ;
		com.setRtuId(rtuId);
		Param_DB p = new Param_DB() ;
		p.setChMain_0to3(chMain) ;
		p.setChAssi1_0to3(chAssi1) ;
		p.setChAssi2_0to3(chAssi2) ;
		com.getParams().put(Param_DB.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_CA(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_CA) ;
		return com ;
	}
	
	public RtuCommand cd_DA(String name, String user, String password, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_DA) ;
		com.setRtuId(rtuId);
		Param_DA p = new Param_DA() ;
		p.setName_1to32(name) ;
		p.setUser_1to32(user) ;
		p.setPassword_1to32(password) ;
		com.getParams().put(Param_DA.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_CC(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_CC) ;
		return com ;
	}
	public RtuCommand cd_D2(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_D2) ;
		return com ;
	}
	
	public RtuCommand cd_DC(Param_DC p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_DC) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_DC.KEY, p);
		return com ;
	}
	public RtuCommand cd_D6(Param_D6 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_D6) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_D6.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_CD(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_CD) ;
		return com ;
	}
	
	public RtuCommand cd_DD(Param_DD p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_DD) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_DD.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_CE(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_CE) ;
		return com ;
	}
	
	public RtuCommand cd_DE(Param_DE p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_DE) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_DE.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_96(Param_96 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_96) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_96.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_C8(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_C8) ;
		return com ;
	}
	
	public RtuCommand cd_E2(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E2) ;
		return com ;
	}
	
	public RtuCommand cd_F2(Param_F2 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F2) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F2.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_D8(Param_D8 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_D8) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_D8.KEY, p);
		return com ;
	}
	
	
	public RtuCommand cd_E3(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E3) ;
		return com ;
	}
	
	public RtuCommand cd_F3(Param_F3 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F3) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F3.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_E4(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E4) ;
		return com ;
	}
	
	public RtuCommand cd_F4(Param_F4 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F4) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F4.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_E5(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E5) ;
		return com ;
	}
	
	public RtuCommand cd_F5(Param_F5 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F5) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F5.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_E6(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E6) ;
		return com ;
	}
	
	public RtuCommand cd_F6(Param_F6 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F6) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F6.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_E9(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E9) ;
		return com ;
	}
	
	public RtuCommand cd_F9(Param_F9 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F9) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F9.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_EA(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_EA) ;
		return com ;
	}
	
	public RtuCommand cd_FA(Param_FA p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_FA) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_FA.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_E7(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E7) ;
		return com ;
	}
	
	public RtuCommand cd_F7(Param_F7 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F7) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F7.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_E8(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_E8) ;
		return com ;
	}
	
	public RtuCommand cd_F8(Param_F8 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F8) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_F8.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_EB(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_EB) ;
		return com ;
	}
	
	public RtuCommand cd_FB(Param_FB p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_FB) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_FB.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_57(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_57) ;
		return com ;
	}
	
	public RtuCommand cd_17(ParamMap_17 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_17) ;
		com.setRtuId(rtuId);
		com.getParams().put(ParamMap_17.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_59(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_59) ;
		return com ;
	}
	
	public RtuCommand cd_19(Param_19 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_19) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_19.KEY, p);
		return com ;
	}
	
	
	public RtuCommand cd_5A(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_5A) ;
		return com ;
	}
	
	public RtuCommand cd_1A(Param_1A p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_1A) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_1A.KEY, p);
		return com ;
	}
	
	
	public RtuCommand cd_64(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_64) ;
		return com ;
	}
	
	public RtuCommand cd_1F(ParamMap_1F p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_1F) ;
		com.setRtuId(rtuId);
		com.getParams().put(ParamMap_1F.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_20(Param_20 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_20) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_20.KEY, p);
		return com ;
	}
	

	public RtuCommand cd_54(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_54) ;
		return com ;
	}
	
	public RtuCommand cd_A0(Param_A0 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_A0) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_A0.KEY, p);
		return com ;
	}
	

	public RtuCommand cd_53(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_53) ;
		return com ;
	}
	
	public RtuCommand cd_A1(Param_A1 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_A1) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_A1.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_C5(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_C5) ;
		return com ;
	}
	
	public RtuCommand cd_D5(Param_D5 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_D5) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_D5.KEY, p);
		return com ;
	}

	public RtuCommand cd_5D(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_5D) ;
		return com ;
	}

	public RtuCommand cd_5E(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_5E) ;
		return com ;
	}
	

	public RtuCommand cd_EC(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_EC) ;
		return com ;
	}

	public RtuCommand cd_FC(Param_FC p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_FC) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_FC.KEY, p);
		return com ;
	}
	
	
	public RtuCommand cd_B0(Param_B0 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_B0) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_B0.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_B1(Param_B1 p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_B1) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_B1.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_ED(Param_ED p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_ED) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_ED.KEY, p);
		return com ;
	}
	
	public RtuCommand cd_82_1(Param_82_WaterLevelList p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_82) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_82_WaterLevelList.KEY, p);
		return com ;
	}
	public RtuCommand cd_82_2(Param_82_WaterTemperature p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_82) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_82_WaterTemperature.KEY, p);
		return com ;
	}
	public RtuCommand cd_82_3(Param_82_WaterQuality p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_82) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_82_WaterQuality.KEY, p);
		return com ;
	}
	public RtuCommand cd_82_4(Param_82_WaterAmountList p, String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_82) ;
		com.setRtuId(rtuId);
		com.getParams().put(Param_82_WaterAmountList.KEY, p);
		return com ;
	}
	
	
	public RtuCommand cd_F0(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setCommandCode(Code206.cd_F0) ;
		com.setRtuId(rtuId);
		return com ;
	}
	public RtuCommand cd_C2(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_C2) ;
		return com ;
	}
	
	public RtuCommand cd_D3(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_D3) ;
		return com ;
	}
	public RtuCommand cd_D4(String rtuId){
		RtuCommand com = new RtuCommand() ;
		com.setRtuId(rtuId);
		com.setCommandCode(Code206.cd_D4) ;
		return com ;
	}

}
