package com.blg.rtu2;

import java.util.ArrayList;
import java.util.List;

import android.app.FragmentManager;

import com.blg.rtu.frmFunction.*;
import com.blg.rtu.frmLoopQuery.LpFragment_01;
import com.blg.rtu.frmLoopQuery.LpFragment_02;
import com.blg.rtu.frmLoopQuery.LpFragment_03;
import com.blg.rtu.frmLoopQuery.LpFragment_04;
import com.blg.rtu.frmNoProtocol.NpFragment_01;
import com.blg.rtu.frmChannel.*;

public class FragmentTool {

	private MainActivity mainAct ;
		
	public NpFragment_01 fragment_np01 ;
	
	public LpFragment_01 fragment_loopq01 ;
	public LpFragment_02 fragment_loopq02 ;
	public LpFragment_03 fragment_loopq03 ;
	public LpFragment_04 fragment_loopq04 ;
	
	public ChFragment_01 fragment_ch01 ;
	public ChFragment_02 fragment_ch02 ;
	public ChFragment_03 fragment_ch03 ;
	public ChFragment_04 fragment_ch04 ;
	public ChFragment_05 fragment_ch05 ;

	private static List<FrmParent> frms = new ArrayList<FrmParent>() ;;

	public F_01_010 f_01_010 ;
	public F_01_020 f_01_020 ;
	//public F_01_030 f_01_030 ;
	public F_01_040 f_01_040 ;
	public F_01_050 f_01_050 ;
	public F_01_060 f_01_060 ;
	public F_01_070 f_01_070 ;
	public F_01_080 f_01_080 ;
	public F_01_090 f_01_090 ;
	public F_01_100 f_01_100 ;
	
	public F_02_010 f_02_010 ;
	//public F_02_020 f_02_020 ;
	//public F_02_030 f_02_030 ;
	public F_02_040 f_02_040 ;
	public F_02_050 f_02_050 ;
	
	
/*	public F_02_060 f_02_060 ;
	public F_02_070 f_02_070 ;*/
	
	//public F_02_090 f_02_090 ;
	public F_02_100 f_02_100 ;
	
	public F_02_080 f_02_080 ;
//	public F_03_010 f_03_010 ;
	/*public F_03_011 f_03_011 ;
	public F_03_020 f_03_020 ;
	public F_03_030 f_03_030 ;
	public F_03_040 f_03_040 ;
	public F_03_050 f_03_050 ;
	public F_03_060 f_03_060 ;
	public F_03_070 f_03_070 ;
	public F_03_080 f_03_080 ;*/
	public F_03_090 f_03_090 ;
/*	public F_04_010 f_04_010 ;
	public F_04_020 f_04_020 ;
	public F_04_030 f_04_030 ;
	public F_04_040 f_04_040 ;
	public F_04_050 f_04_050 ;
	public F_04_060 f_04_060 ;
	public F_04_070 f_04_070 ;*/
	public F_04_080 f_04_080 ;
	/*public F_04_090 f_04_090 ;*/
/*	public F_04_100 f_04_100 ;
	public F_04_110 f_04_110 ;
	public F_04_120 f_04_120 ;*/
	public F_05_010 f_05_010 ;
	public F_05_020 f_05_020 ;
	//public F_05_030 f_05_030 ;
	public F_05_040 f_05_040 ;
	/*public F_05_050 f_05_050 ;*/
	public F_05_060 f_05_060 ;	//查询日志信息
	public F_05_070 f_05_070 ;	//查询遥测终端流量实时值
	
	//public F_06_010 f_06_010 ;
	public F_07_010 f_07_010 ;	//查询遥测终端流量实时值
	
	public F_02_110 f_02_110 ;	//查询/设置RTU地址命令
	
	public F_08_010 f_08_010 ;	//发送ModBus密码
	public F_08_020 f_08_020 ;	//设置ModBus配置密码
	public F_08_030 f_08_030 ;	//查询/设置ModBus地址命令
	public F_08_040 f_08_040 ;	//查询/设置中继器关联ModBus地址
	public F_08_050 f_08_050 ;	//查询/设置LCD显示内容及刷屏间隔
	public F_08_060 f_08_060 ;	//查询/设置正积流量
	public F_08_070 f_08_070 ;	//查询/设置负积流量
	public F_08_080 f_08_080 ;	//设置净积流量
	public F_08_090 f_08_090 ;	//查询/设置表口径
	public F_08_101 f_08_101 ;	//查询/设置整体脉冲系数
	public F_08_110 f_08_110 ;	//查询/设置RF频点命令
	public F_08_120 f_08_120 ;  //一键测试触发和查询结果
	public F_08_130 f_08_130 ;  //查询设置LORA时间窗口
	public F_08_140 f_08_140 ;  //设置LORA电源控制
	public F_08_150 f_08_150 ;  //设置出厂启用
	public F_08_160 f_08_160 ; //查询/设置脉冲常数
	public FragmentTool(MainActivity mainAct){
		this.mainAct = mainAct ;
		
        FragmentManager fm = this.mainAct.getFragmentManager();   
        
        fragment_np01 = (NpFragment_01)fm.findFragmentById(R.id.npFragment_01) ;
        
        fragment_loopq02 = (LpFragment_02)fm.findFragmentById(R.id.lqFragment_02) ;
        fragment_loopq03 = (LpFragment_03)fm.findFragmentById(R.id.lqFragment_03) ;
        fragment_loopq04 = (LpFragment_04)fm.findFragmentById(R.id.lqFragment_04) ;
        
  /*      fragment_ch01 = (ChFragment_01)fm.findFragmentById(R.id.chFragment_01) ;
        fragment_ch02 = (ChFragment_02)fm.findFragmentById(R.id.chFragment_02) ;
        fragment_ch03 = (ChFragment_03)fm.findFragmentById(R.id.chFragment_03) ;*/
        fragment_ch04 = (ChFragment_04)fm.findFragmentById(R.id.chFragment_04) ;
        //fragment_ch05 = (ChFragment_05)fm.findFragmentById(R.id.chFragment_05) ;
       /* f_01_010 = (F_01_010)fm.findFragmentById(R.id.f_01_010) ;
        frms.add(f_01_010);*/
        f_01_020 = (F_01_020)fm.findFragmentById(R.id.f_01_020) ;
        frms.add(f_01_020);
       /* f_01_030 = (F_01_030)fm.findFragmentById(R.id.f_01_030) ;
        frms.add(f_01_030);*/
        f_01_040 = (F_01_040)fm.findFragmentById(R.id.f_01_040) ;
        frms.add(f_01_040);
        f_01_050 = (F_01_050)fm.findFragmentById(R.id.f_01_050) ;
        frms.add(f_01_050);
        f_01_060 = (F_01_060)fm.findFragmentById(R.id.f_01_060) ;
        frms.add(f_01_060);
        f_01_070 = (F_01_070)fm.findFragmentById(R.id.f_01_070) ;
        frms.add(f_01_070);
        f_01_080 = (F_01_080)fm.findFragmentById(R.id.f_01_080) ;
        frms.add(f_01_080);
        f_01_090 = (F_01_090)fm.findFragmentById(R.id.f_01_090) ;
        frms.add(f_01_090);
        f_01_100 = (F_01_100)fm.findFragmentById(R.id.f_01_100) ;
        frms.add(f_01_100);
        
        f_02_010 = (F_02_010)fm.findFragmentById(R.id.f_02_010) ;
        frms.add(f_02_010);
     /*   f_02_020 = (F_02_020)fm.findFragmentById(R.id.f_02_020) ;
        frms.add(f_02_020);
        f_02_030 = (F_02_030)fm.findFragmentById(R.id.f_02_030) ;
        frms.add(f_02_030);*/
        f_02_040 = (F_02_040)fm.findFragmentById(R.id.f_02_040) ;
        frms.add(f_02_040);
        f_02_050 = (F_02_050)fm.findFragmentById(R.id.f_02_050) ;
        frms.add(f_02_050);
   /*     f_02_060 = (F_02_060)fm.findFragmentById(R.id.f_02_060) ;
        frms.add(f_02_060);
        f_02_070 = (F_02_070)fm.findFragmentById(R.id.f_02_070) ;
        frms.add(f_02_070);
     
        f_02_090 = (F_02_090)fm.findFragmentById(R.id.f_02_090) ;
        frms.add(f_02_090);*/
        f_02_100 = (F_02_100)fm.findFragmentById(R.id.f_02_100) ;
        frms.add(f_02_100);
        f_02_110 = (F_02_110)fm.findFragmentById(R.id.f_02_110) ;
        frms.add(f_02_110);
        f_02_080 = (F_02_080)fm.findFragmentById(R.id.f_02_080) ;
        frms.add(f_02_080);
//        f_03_010 = (F_03_010)fm.findFragmentById(R.id.f_03_010) ;
//        frms.add(f_03_010);
      /*  f_03_011 = (F_03_011)fm.findFragmentById(R.id.f_03_011) ;
        frms.add(f_03_011);
        f_03_020 = (F_03_020)fm.findFragmentById(R.id.f_03_020) ;
        frms.add(f_03_020);
        f_03_030 = (F_03_030)fm.findFragmentById(R.id.f_03_030) ;
        frms.add(f_03_030);
        f_03_040 = (F_03_040)fm.findFragmentById(R.id.f_03_040) ;
        frms.add(f_03_040);
        f_03_050 = (F_03_050)fm.findFragmentById(R.id.f_03_050) ;
        frms.add(f_03_050);
        f_03_060 = (F_03_060)fm.findFragmentById(R.id.f_03_060) ;
        frms.add(f_03_060);
        f_03_070 = (F_03_070)fm.findFragmentById(R.id.f_03_070) ;
        frms.add(f_03_070);
        f_03_080 = (F_03_080)fm.findFragmentById(R.id.f_03_080) ;
        frms.add(f_03_080);*/
        f_03_090 = (F_03_090)fm.findFragmentById(R.id.f_03_090) ;
        frms.add(f_03_090);
    /*    f_04_010 = (F_04_010)fm.findFragmentById(R.id.f_04_010) ;
        frms.add(f_04_010);
        f_04_020 = (F_04_020)fm.findFragmentById(R.id.f_04_020) ;
        frms.add(f_04_020);
        f_04_030 = (F_04_030)fm.findFragmentById(R.id.f_04_030) ;
        frms.add(f_04_030);
        f_04_040 = (F_04_040)fm.findFragmentById(R.id.f_04_040) ;
        frms.add(f_04_040);
        f_04_050 = (F_04_050)fm.findFragmentById(R.id.f_04_050) ;
        frms.add(f_04_050);
        f_04_060 = (F_04_060)fm.findFragmentById(R.id.f_04_060) ;
        frms.add(f_04_060);
        f_04_070 = (F_04_070)fm.findFragmentById(R.id.f_04_070) ;
        frms.add(f_04_070);*/
        f_04_080 = (F_04_080)fm.findFragmentById(R.id.f_04_080) ;
        frms.add(f_04_080);
    /*    f_04_090 = (F_04_090)fm.findFragmentById(R.id.f_04_090) ;
        frms.add(f_04_090);*/
  /*      f_04_100 = (F_04_100)fm.findFragmentById(R.id.f_04_100) ;
        frms.add(f_04_100);
        f_04_110 = (F_04_110)fm.findFragmentById(R.id.f_04_110) ;
        frms.add(f_04_110);
        f_04_120 = (F_04_120)fm.findFragmentById(R.id.f_04_120) ;
        frms.add(f_04_120);*/
        f_05_070 = (F_05_070)fm.findFragmentById(R.id.f_05_070) ;
        frms.add(f_05_070);
        f_05_010 = (F_05_010)fm.findFragmentById(R.id.f_05_010) ;
        frms.add(f_05_010);
        f_05_020 = (F_05_020)fm.findFragmentById(R.id.f_05_020) ;
        frms.add(f_05_020);
      /*  f_05_030 = (F_05_030)fm.findFragmentById(R.id.f_05_030) ;
        frms.add(f_05_030);*/
        f_05_040 = (F_05_040)fm.findFragmentById(R.id.f_05_040) ;
        frms.add(f_05_040);
      /*  f_05_050 = (F_05_050)fm.findFragmentById(R.id.f_05_050) ;
        frms.add(f_05_050);*/
        f_05_060 = (F_05_060)fm.findFragmentById(R.id.f_05_060) ;
        frms.add(f_05_060);
 
        /*  f_06_010 = (F_06_010)fm.findFragmentById(R.id.f_06_010) ;
        frms.add(f_06_010);*/
       /* f_07_010 = (F_07_010)fm.findFragmentById(R.id.f_07_010) ;
        frms.add(f_07_010);*/
        f_08_010 = (F_08_010)fm.findFragmentById(R.id.f_08_010) ;
        frms.add(f_08_010) ;
        f_08_020 = (F_08_020)fm.findFragmentById(R.id.f_08_020) ;
        frms.add(f_08_020) ;
        f_08_030 = (F_08_030)fm.findFragmentById(R.id.f_08_030) ;
        frms.add(f_08_030) ;
        f_08_040 = (F_08_040)fm.findFragmentById(R.id.f_08_040) ;
        frms.add(f_08_040) ;
        f_08_050 = (F_08_050)fm.findFragmentById(R.id.f_08_050) ;
        frms.add(f_08_050) ;
        f_08_060 = (F_08_060)fm.findFragmentById(R.id.f_08_060) ;
        frms.add(f_08_060) ;
        f_08_070 = (F_08_070)fm.findFragmentById(R.id.f_08_070) ;
        frms.add(f_08_070) ;
        f_08_080 = (F_08_080)fm.findFragmentById(R.id.f_08_080) ;
        frms.add(f_08_080) ;
        f_08_090 = (F_08_090)fm.findFragmentById(R.id.f_08_090) ;
        frms.add(f_08_090);
        f_08_101 = (F_08_101)fm.findFragmentById(R.id.f_08_101) ;
        frms.add(f_08_101) ;
        f_08_110 = (F_08_110)fm.findFragmentById(R.id.f_08_110) ;
        frms.add(f_08_110) ;
        f_08_120 = (F_08_120)fm.findFragmentById(R.id.f_08_120) ;
        frms.add(f_08_120) ;
        f_08_130 = (F_08_130)fm.findFragmentById(R.id.f_08_130) ;
        frms.add(f_08_130) ;
        f_08_140 = (F_08_140)fm.findFragmentById(R.id.f_08_140) ;
        frms.add(f_08_140) ;
        f_08_150 = (F_08_150)fm.findFragmentById(R.id.f_08_150) ;
        frms.add(f_08_150) ;
        f_08_160 = (F_08_160)fm.findFragmentById(R.id.f_08_160) ;
        frms.add(f_08_160) ;
	}
	
	
	public void pageViewSelected(int pageIndex) {
		switch (pageIndex) {
		case 0://第0页
			//fragment_ch01.outThisPage() ;
			break;
		case 1://第1页
			//fragment_ch01.outThisPage() ;
			break;
		case 2://第2页
			//fragment_ch01.outThisPage() ;
			break;
		case 3://第3页
			//fragment_ch01.inThisPage() ;
			break;
		}
	}
	
	/**
	 * 打开所有功能项
	 */
	public void openAllFunctionFragment(){
		for(FrmParent frm : frms){
			frm.openFuncFrm() ;
		}
	}
	
	
	
	/**
	 * 关闭所有功能项
	 */
	public void closeAllFunctionFragment(){
		for(FrmParent frm : frms){
			frm.closeFuncFrm() ;
			
		}
	}
	
	/**
	 * 功能项右侧图标复原
	 */
	public void resetLabelImgFunctionFragment(){
		for(FrmParent frm : frms){
			frm.resetLabelImg() ;
		}
	}
	
}
