package com.blg.rtu.frmFunction;


import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu2.MainActivity;

public class F_02_050_Help {
	
	public static boolean checkIpPort(MainActivity act, String strIp1 , String strIp2 , String strIp3, String strIp4, String strPort, String centerName, boolean showDialog){
		boolean ok = true ;
		if((strIp1 == null || strIp1.equals("")) ||
				(strIp2 == null || strIp2.equals("")) ||
				(strIp3 == null || strIp3.equals("")) ||
				(strIp4 == null || strIp4.equals("")) ||
				(strPort == null || strPort.equals(""))){
				if(showDialog)new DialogAlarm().showDialog(act, centerName + "IP地址及端口必须填写！") ;
				ok = false ;
			}else{
				int intIp1 = 0 ,intIp2 = 0 , intIp3 = 0 ,intIp4 = 0 , intPort = 0 ;
				try{
					intIp1 = Integer.valueOf(strIp1) ;
					intIp2 = Integer.valueOf(strIp2) ;
					intIp3 = Integer.valueOf(strIp3) ;
					intIp4 = Integer.valueOf(strIp4) ;
					intPort = Integer.valueOf(strPort) ;
				}catch(Exception e){
					ok = false ;
				}finally{
					if(ok){
						if((intIp1 < 0 || intIp1 > 255) ||
								(intIp2 < 0 || intIp2 > 255) ||	
								(intIp3 < 0 || intIp3 > 255) ||	
								(intIp4 < 0 || intIp4 > 255)){
							if(showDialog)new DialogAlarm().showDialog(act, centerName + "IP地址必须是0到255数值！") ;
							ok = false ;
						}
						if(ok){
							if(intPort < 0 || intPort > 65535){
								if(showDialog)new DialogAlarm().showDialog(act, centerName + "端口必须是0到65535数值！") ;
								ok = false ;
							}
						}
					}else{
						if(showDialog)new DialogAlarm().showDialog(act, centerName + "IP地址及端口必须全数字！") ;
					}
				}		
			}
		return ok ;
	}
	
}
