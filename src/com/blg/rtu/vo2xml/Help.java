package com.blg.rtu.vo2xml;

import java.io.*;

import com.blg.rtu.MainActivity;

public class Help {

	public String out(MainActivity act) throws Exception {
		Vo2Xml vo = new Vo2Xml();

		act.frgTool.f_01_010.outSetData(vo);
		act.frgTool.f_01_020.outSetData(vo);
		/*act.frgTool.f_01_030.outSetData(vo);*/
		act.frgTool.f_01_040.outSetData(vo);
		/*act.frgTool.f_01_050.outSetData(vo);*/
		act.frgTool.f_01_060.outSetData(vo);
		act.frgTool.f_01_070.outSetData(vo);
		act.frgTool.f_01_080.outSetData(vo);
		act.frgTool.f_02_010.outSetData(vo);
	/*	act.frgTool.f_02_020.outSetData(vo);
		act.frgTool.f_02_030.outSetData(vo);*/
		act.frgTool.f_02_040.outSetData(vo);
		act.frgTool.f_02_050.outSetData(vo);
	/*	act.frgTool.f_02_060.outSetData(vo);
		act.frgTool.f_02_070.outSetData(vo);
		act.frgTool.f_02_080.outSetData(vo);
		act.frgTool.f_02_090.outSetData(vo);*/
//		act.frgTool.f_03_010.outSetData(vo);
/*		act.frgTool.f_03_011.outSetData(vo);
		act.frgTool.f_03_020.outSetData(vo);
		act.frgTool.f_03_030.outSetData(vo);
		act.frgTool.f_03_040.outSetData(vo);
		act.frgTool.f_03_050.outSetData(vo);
		act.frgTool.f_03_060.outSetData(vo);
		act.frgTool.f_03_070.outSetData(vo);
		act.frgTool.f_03_080.outSetData(vo);*/
		act.frgTool.f_03_090.outSetData(vo);
	/*	act.frgTool.f_04_010.outSetData(vo);
		act.frgTool.f_04_020.outSetData(vo);
		act.frgTool.f_04_030.outSetData(vo);
		act.frgTool.f_04_040.outSetData(vo);
		act.frgTool.f_04_050.outSetData(vo);
		act.frgTool.f_04_060.outSetData(vo);
		act.frgTool.f_04_070.outSetData(vo);*/
		act.frgTool.f_04_080.outSetData(vo);
		act.frgTool.f_04_090.outSetData(vo);
	/*	act.frgTool.f_04_100.outSetData(vo);
		act.frgTool.f_04_110.outSetData(vo);
		act.frgTool.f_04_120.outSetData(vo);*/
		act.frgTool.f_05_010.outSetData(vo);
		act.frgTool.f_05_020.outSetData(vo);
		/*act.frgTool.f_05_030.outSetData(vo);*/
		act.frgTool.f_05_040.outSetData(vo);
		act.frgTool.f_05_050.outSetData(vo);
		act.frgTool.f_05_060.outSetData(vo);
		/*act.frgTool.f_06_010.outSetData(vo);*/

		String xml = vo.toXml();

		return xml;
	}

	public void in(MainActivity act, File f) throws Exception {
		InputStream is = null ;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(f);
			byte[] b = new byte[1024];
			int n;
			while ((n = is.read(b)) != -1) {
				out.write(b, 0, n);
			}// end while
		} catch (Exception e) {
			throw e ;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
				}// end try
			}// end if
		}// end try

		byte[] buffer = out.toByteArray();

		Vo2Xml vo = new Vo2Xml().toObject(buffer) ;

		act.frgTool.f_01_010.inSetData(vo);
		act.frgTool.f_01_010.inSetData(vo);
		act.frgTool.f_01_020.inSetData(vo);
	/*	act.frgTool.f_01_030.inSetData(vo);*/
		act.frgTool.f_01_040.inSetData(vo);
		/*act.frgTool.f_01_050.inSetData(vo);*/
		act.frgTool.f_01_060.inSetData(vo);
		act.frgTool.f_01_070.inSetData(vo);
		act.frgTool.f_01_080.inSetData(vo);
		act.frgTool.f_02_010.inSetData(vo);
		/*act.frgTool.f_02_020.inSetData(vo);
		act.frgTool.f_02_030.inSetData(vo);*/
		act.frgTool.f_02_040.inSetData(vo);
		act.frgTool.f_02_050.inSetData(vo);
	/*	act.frgTool.f_02_060.inSetData(vo);
		act.frgTool.f_02_070.inSetData(vo);
		act.frgTool.f_02_080.inSetData(vo);
		act.frgTool.f_02_090.inSetData(vo);*/
//		act.frgTool.f_03_010.inSetData(vo);
		/*act.frgTool.f_03_011.inSetData(vo);
		act.frgTool.f_03_020.inSetData(vo);
		act.frgTool.f_03_030.inSetData(vo);
		act.frgTool.f_03_040.inSetData(vo);
		act.frgTool.f_03_050.inSetData(vo);
		act.frgTool.f_03_060.inSetData(vo);
		act.frgTool.f_03_070.inSetData(vo);
		act.frgTool.f_03_080.inSetData(vo);*/
		act.frgTool.f_03_090.inSetData(vo);
	/*	act.frgTool.f_04_010.inSetData(vo);
		act.frgTool.f_04_020.inSetData(vo);
		act.frgTool.f_04_030.inSetData(vo);
		act.frgTool.f_04_040.inSetData(vo);
		act.frgTool.f_04_050.inSetData(vo);
		act.frgTool.f_04_060.inSetData(vo);
		act.frgTool.f_04_070.inSetData(vo);*/
		act.frgTool.f_04_080.inSetData(vo);
		act.frgTool.f_04_090.inSetData(vo);
	/*	act.frgTool.f_04_100.inSetData(vo);
		act.frgTool.f_04_110.inSetData(vo);
		act.frgTool.f_04_120.inSetData(vo);*/
		act.frgTool.f_05_010.inSetData(vo);
		act.frgTool.f_05_020.inSetData(vo);
	/*	act.frgTool.f_05_030.inSetData(vo);*/
		act.frgTool.f_05_040.inSetData(vo);
		act.frgTool.f_05_050.inSetData(vo);
		act.frgTool.f_05_060.inSetData(vo);
		/*act.frgTool.f_06_010.inSetData(vo);*/
	}
}
