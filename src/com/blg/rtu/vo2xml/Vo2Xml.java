package com.blg.rtu.vo2xml;

import com.thoughtworks.xstream.XStream;

public class Vo2Xml {
	public static String ALIAS = Vo2Xml.class.getName() ;
	
	private String v_01_010_regionNum ;
	private String v_01_010_clientId ;
	
	/*private int v_01_030_item01 ;
	private int v_01_050_item01 ;*/
	
	private int v_01_060_item01 ;
	
	private String v_01_080_item01_1 ;
	private String v_01_080_item01_2 ;

	private int v_02_010_item01 ;
	/*private int v_02_020_item01 ;*/
	
/*	private int v_02_030_item01 ;
	private int v_02_030_item02 ;
	private int v_02_030_item03 ;*/

	private String v_02_040_item01 ;
	private String v_02_040_item02 ;
	private String v_02_040_item03 ;
	
	private int v_02_050_item01_1;
	private String v_02_050_item01_2_1;
	private String v_02_050_item01_2_2;
	private String v_02_050_item01_2_3;
	private String v_02_050_item01_2_4;
	private String v_02_050_item01_3;
	private int v_02_050_item01_4;
	private int v_02_050_item02_1;
	private String v_02_050_item02_2_1;
	private String v_02_050_item02_2_2;
	private String v_02_050_item02_2_3;
	private String v_02_050_item02_2_4;
	private String v_02_050_item02_3;
	private int v_02_050_item02_4;
	private int v_02_050_item03_1;
	private String v_02_050_item03_2_1;
	private String v_02_050_item03_2_2;
	private String v_02_050_item03_2_3;
	private String v_02_050_item03_2_4;
	private String v_02_050_item03_3;
	private int v_02_050_item03_4;
	private int v_02_050_item04_1;
	private String v_02_050_item04_2_1;
	private String v_02_050_item04_2_2;
	private String v_02_050_item04_2_3;
	private String v_02_050_item04_2_4;
	private String v_02_050_item04_3;
	private int v_02_050_item04_4;

	/*private int v_02_060_item01_1;
	private String v_02_060_item01_2 ;
	private int v_02_060_item02_1;
	private String v_02_060_item02_2 ;
	private int v_02_060_item03_1;
	private String v_02_060_item03_2 ;
	private int v_02_060_item04_1;
	private String v_02_060_item04_2 ;*/

	/*private int v_02_070_item01_1;
	private String v_02_070_item01_2 ;
	private int v_02_070_item02_1;
	private String v_02_070_item02_2 ;
	private int v_02_070_item03_1;
	private String v_02_070_item03_2 ;
	private int v_02_070_item04_1;
	private String v_02_070_item04_2 ;*/

    private String v_02_080_item01 ;
	private int v_02_110_item01;
	private int v_02_110_item02;
	private int v_02_110_item03;
	private int v_02_110_item04;
	private int v_02_110_item05;
//	private int v_03_010_item01_1;
//	private String v_03_010_item01_2 ;
//	private int v_03_010_item02_1;
//	private String v_03_010_item02_2 ;

	/*private int v_03_011_item01;
	private int v_03_011_item02;
	private String v_03_011_item03 ;*/
	
	
	/*private int v_03_020_item01_1;
	private int v_03_020_item01_2 ;
	private int v_03_020_item02_1;
	private int v_03_020_item02_2 ;
	private int v_03_020_item03_1;
	private int v_03_020_item03_2 ;
	private int v_03_020_item04_1;
	private int v_03_020_item04_2 ;
	private int v_03_020_item05_1;
	private int v_03_020_item05_2 ;
	private int v_03_020_item06_1;
	private int v_03_020_item06_2 ;
	private String v_03_020_meterTypeListStr ; */

	
/*	private int v_03_030_item01_1;
	private String v_03_030_item01_2 ;
	private int v_03_030_item03_1;
	private String v_03_030_item03_2 ;
	private int v_03_030_item04_1;
	private String v_03_030_item04_2 ;
	private int v_03_030_item05_1;
	private String v_03_030_item05_2 ;
	private int v_03_030_item06_1;
	private String v_03_030_item06_2 ;*/

	/*private int v_03_040_item01_1;
	private String v_03_040_item01_2 ;*/

/*	private int v_03_050_item01_1;
	private String v_03_050_item01_2 ;
	private int v_03_050_item02_1;
	private String v_03_050_item02_2 ;
	private int v_03_050_item03_1;
	private String v_03_050_item03_2 ;
	private int v_03_050_item04_1;
	private String v_03_050_item04_2 ;*/

	private String v_03_060_item01 ;
	
	/*private int v_03_070_item01_1;
	private String v_03_070_item01_2 ;
	private int v_03_070_item02_1;
	private String v_03_070_item02_2 ;
	private int v_03_070_item03_1;
	private String v_03_070_item03_2 ;*/

	private String v_03_080_chechBoxs;
	private String v_03_080_items;
	
	private String v_03_090_item01 ;

	/*private int v_04_010_item01;*/

	private String v_04_020_itemStr;
	
	private String v_04_030_chechBoxs;
	private String v_04_030_items;
	
	private String v_04_040_chechBoxs;
	private String v_04_040_items;

	private String v_04_050_itemStr;
	
	/*private int v_04_060_select;
	private String v_04_060_param01_1 ;
	private String v_04_060_param01_2 ;
	private String v_04_060_param01_3 ;
	private String v_04_060_param02_1 ;
	private String v_04_060_param02_2 ;
	private String v_04_060_param02_3 ;
	private String v_04_060_param03_1 ; 
	private String v_04_060_param03_2 ; 
	private String v_04_060_param03_3 ;
	private String v_04_060_param04_1 ; 
	private String v_04_060_param04_2 ; 
	private String v_04_060_param04_3 ;
	private String v_04_060_param05_1 ; 
	private String v_04_060_param05_2 ; 
	private String v_04_060_param05_3 ;
	private String v_04_060_param06_1 ; 
	private String v_04_060_param06_2 ; 
	private String v_04_060_param06_3 ;
	private String v_04_060_param07_1 ; 
	private String v_04_060_param07_2 ; 
	private String v_04_060_param07_3 ;
	private String v_04_060_param08_1 ; 
	private String v_04_060_param08_2 ; 
	private String v_04_060_param08_3 ;
	private String v_04_060_param09_1 ; 
	private String v_04_060_param09_2 ; 
	private String v_04_060_param09_3 ;
	private String v_04_060_param10_1 ; 
	private String v_04_060_param10_2 ; 
	private String v_04_060_param10_3 ;
	private String v_04_060_param11_1 ; 
	private String v_04_060_param11_2 ; 
	private String v_04_060_param11_3 ;
	private String v_04_060_param12_1 ; 
	private String v_04_060_param12_2 ; 
	private String v_04_060_param12_3 ;
	private String v_04_060_param13_1 ; 
	private String v_04_060_param13_2 ; 
	private String v_04_060_param13_3 ;*/

	private String v_04_070_chechBoxs;
	
	private String v_04_080_chechBoxs;
	private String v_04_080_items;

	private String v_04_090_item01 ;
	
	private String v_04_100_item01 ;
	
	private String v_04_110_item01 ;

	private String v_04_120_itemStr;

	private String v_05_030_chechBoxs;

/*	private int v_06_010_item01;
	private String v_06_010_item02Str;
	private String v_06_010_item03 ;
	private String v_06_010_item04_01 ;
	private String v_06_010_item04_02 ;
	private String v_06_010_item04_03 ;
	private String v_06_010_item04_04 ;
	private String v_06_010_item04_05 ;
	private String v_06_010_item05Str;*/
	private String v_08_020_item01 ;
	private String v_08_020_item02 ;
	
	private String v_08_030_item01 ;
	
	private String v_08_060_item01 ;
	private String v_08_060_item02 ;
	private String v_08_060_item03 ;
	
	private String v_08_070_item01 ;
	private String v_08_070_item02 ;
	private String v_08_070_item03 ;
	
	private String v_08_080_item01 ;
	private String v_08_080_item02 ;
	private String v_08_080_item03 ;
	private int v_08_090_item01 ;
	
	private String v_08_110_item01 ;
	
	/**
	 * 对象转成xml
	 * @return
	 * @throws ACException
	 */
	public String toXml()throws Exception{
		XStream xstream = new XStream();
		xstream.alias(Vo2Xml.ALIAS , Vo2Xml.class);
		return xstream.toXML(this);
	}
	/**
	 * xml转成对象
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public Vo2Xml toObject(String xml)throws Exception{
		XStream xstream = new XStream();
		xstream.alias(Vo2Xml.ALIAS, Vo2Xml.class);
		return (Vo2Xml) xstream.fromXML(xml) ;
	}
	/**
	 * xml转成对象
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public Vo2Xml toObject(byte[] bxml)throws Exception{
		if(bxml == null || bxml.length == 0){
			throw new Exception("出错！不能将空字节数组转成Data对象！") ;
		}
		XStream xstream = new XStream();
		xstream.alias(Vo2Xml.ALIAS, Vo2Xml.class);
		return (Vo2Xml) xstream.fromXML(new String(bxml));
	}	
	
	
	public String getV_01_010_regionNum() {
		return v_01_010_regionNum;
	}
	public void setV_01_010_regionNum(String v_01_010_regionNum) {
		this.v_01_010_regionNum = v_01_010_regionNum;
	}
	public String getV_01_010_clientId() {
		return v_01_010_clientId;
	}
	public void setV_01_010_clientId(String v_01_010_clientId) {
		this.v_01_010_clientId = v_01_010_clientId;
	}
/*	public int getV_01_030_item01() {
		return v_01_030_item01;
	}
	public void setV_01_030_item01(int v_01_030_item01) {
		this.v_01_030_item01 = v_01_030_item01;
	}
	public int getV_01_050_item01() {
		return v_01_050_item01;
	}
	public void setV_01_050_item01(int v_01_050_item01) {
		this.v_01_050_item01 = v_01_050_item01;
	}*/
	public int getV_01_060_item01() {
		return v_01_060_item01;
	}
	public void setV_01_060_item01(int v_01_060_item01) {
		this.v_01_060_item01 = v_01_060_item01;
	}
	public String getV_01_080_item01_1() {
		return v_01_080_item01_1;
	}
	public void setV_01_080_item01_1(String v_01_080_item01_1) {
		this.v_01_080_item01_1 = v_01_080_item01_1;
	}
	public String getV_01_080_item01_2() {
		return v_01_080_item01_2;
	}
	public void setV_01_080_item01_2(String v_01_080_item01_2) {
		this.v_01_080_item01_2 = v_01_080_item01_2;
	}
	public int getV_02_010_item01() {
		return v_02_010_item01;
	}
	public void setV_02_010_item01(int v_02_010_item01) {
		this.v_02_010_item01 = v_02_010_item01;
	}
	/*public int getV_02_020_item01() {
		return v_02_020_item01;
	}
	public void setV_02_020_item01(int v_02_020_item01) {
		this.v_02_020_item01 = v_02_020_item01;
	}
	public int getV_02_030_item01() {
		return v_02_030_item01;
	}
	public void setV_02_030_item01(int v_02_030_item01) {
		this.v_02_030_item01 = v_02_030_item01;
	}
	public int getV_02_030_item02() {
		return v_02_030_item02;
	}
	public void setV_02_030_item02(int v_02_030_item02) {
		this.v_02_030_item02 = v_02_030_item02;
	}
	public int getV_02_030_item03() {
		return v_02_030_item03;
	}
	public void setV_02_030_item03(int v_02_030_item03) {
		this.v_02_030_item03 = v_02_030_item03;
	}*/
	public String getV_02_040_item01() {
		return v_02_040_item01;
	}
	public void setV_02_040_item01(String v_02_040_item01) {
		this.v_02_040_item01 = v_02_040_item01;
	}
	public String getV_02_040_item02() {
		return v_02_040_item02;
	}
	public void setV_02_040_item02(String v_02_040_item02) {
		this.v_02_040_item02 = v_02_040_item02;
	}
	public String getV_02_040_item03() {
		return v_02_040_item03;
	}
	public void setV_02_040_item03(String v_02_040_item03) {
		this.v_02_040_item03 = v_02_040_item03;
	}
	public int getV_02_050_item01_1() {
		return v_02_050_item01_1;
	}
	public void setV_02_050_item01_1(int v_02_050_item01_1) {
		this.v_02_050_item01_1 = v_02_050_item01_1;
	}
	public int getV_02_110_item01() {
		return v_02_110_item01;
	}
	public void setV_02_110_item01(int v_02_110_item01) {
		this.v_02_110_item01 = v_02_110_item01;
	}
	public int getV_02_110_item02() {
		return v_02_110_item02;
	}
	public void setV_02_110_item02(int v_02_110_item02) {
		this.v_02_110_item02 = v_02_110_item02;
	}
	public int getV_02_110_item03() {
		return v_02_110_item03;
	}
	public void setV_02_110_item03(int v_02_110_item03) {
		this.v_02_110_item03 = v_02_110_item03;
	}
	public int getV_02_110_item04() {
		return v_02_110_item04;
	}
	public void setV_02_110_item04(int v_02_110_item04) {
		this.v_02_110_item04 = v_02_110_item04;
	}
	public int getV_02_110_item05() {
		return v_02_110_item05;
	}
	public void setV_02_110_item05(int v_02_110_item05) {
		this.v_02_110_item05 = v_02_110_item05;
	}
	public String getV_02_050_item01_2_1() {
		return v_02_050_item01_2_1;
	}
	public void setV_02_050_item01_2_1(String v_02_050_item01_2_1) {
		this.v_02_050_item01_2_1 = v_02_050_item01_2_1;
	}
	public String getV_02_050_item01_2_2() {
		return v_02_050_item01_2_2;
	}
	public void setV_02_050_item01_2_2(String v_02_050_item01_2_2) {
		this.v_02_050_item01_2_2 = v_02_050_item01_2_2;
	}
	public String getV_02_050_item01_2_3() {
		return v_02_050_item01_2_3;
	}
	public void setV_02_050_item01_2_3(String v_02_050_item01_2_3) {
		this.v_02_050_item01_2_3 = v_02_050_item01_2_3;
	}
	public String getV_02_050_item01_2_4() {
		return v_02_050_item01_2_4;
	}
	public void setV_02_050_item01_2_4(String v_02_050_item01_2_4) {
		this.v_02_050_item01_2_4 = v_02_050_item01_2_4;
	}
	public String getV_02_050_item01_3() {
		return v_02_050_item01_3;
	}
	public void setV_02_050_item01_3(String v_02_050_item01_3) {
		this.v_02_050_item01_3 = v_02_050_item01_3;
	}
	public int getV_02_050_item01_4() {
		return v_02_050_item01_4;
	}
	public void setV_02_050_item01_4(int v_02_050_item01_4) {
		this.v_02_050_item01_4 = v_02_050_item01_4;
	}
	public int getV_02_050_item02_1() {
		return v_02_050_item02_1;
	}
	public void setV_02_050_item02_1(int v_02_050_item02_1) {
		this.v_02_050_item02_1 = v_02_050_item02_1;
	}
	public String getV_02_050_item02_2_1() {
		return v_02_050_item02_2_1;
	}
	public void setV_02_050_item02_2_1(String v_02_050_item02_2_1) {
		this.v_02_050_item02_2_1 = v_02_050_item02_2_1;
	}
	public String getV_02_050_item02_2_2() {
		return v_02_050_item02_2_2;
	}
	public void setV_02_050_item02_2_2(String v_02_050_item02_2_2) {
		this.v_02_050_item02_2_2 = v_02_050_item02_2_2;
	}
	public String getV_02_050_item02_2_3() {
		return v_02_050_item02_2_3;
	}
	public void setV_02_050_item02_2_3(String v_02_050_item02_2_3) {
		this.v_02_050_item02_2_3 = v_02_050_item02_2_3;
	}
	public String getV_02_050_item02_2_4() {
		return v_02_050_item02_2_4;
	}
	public void setV_02_050_item02_2_4(String v_02_050_item02_2_4) {
		this.v_02_050_item02_2_4 = v_02_050_item02_2_4;
	}
	public String getV_02_050_item02_3() {
		return v_02_050_item02_3;
	}
	public void setV_02_050_item02_3(String v_02_050_item02_3) {
		this.v_02_050_item02_3 = v_02_050_item02_3;
	}
	public int getV_02_050_item02_4() {
		return v_02_050_item02_4;
	}
	public void setV_02_050_item02_4(int v_02_050_item02_4) {
		this.v_02_050_item02_4 = v_02_050_item02_4;
	}
	public int getV_02_050_item03_1() {
		return v_02_050_item03_1;
	}
	public void setV_02_050_item03_1(int v_02_050_item03_1) {
		this.v_02_050_item03_1 = v_02_050_item03_1;
	}
	public String getV_02_050_item03_2_1() {
		return v_02_050_item03_2_1;
	}
	public void setV_02_050_item03_2_1(String v_02_050_item03_2_1) {
		this.v_02_050_item03_2_1 = v_02_050_item03_2_1;
	}
	public String getV_02_050_item03_2_2() {
		return v_02_050_item03_2_2;
	}
	public void setV_02_050_item03_2_2(String v_02_050_item03_2_2) {
		this.v_02_050_item03_2_2 = v_02_050_item03_2_2;
	}
	public String getV_02_050_item03_2_3() {
		return v_02_050_item03_2_3;
	}
	public void setV_02_050_item03_2_3(String v_02_050_item03_2_3) {
		this.v_02_050_item03_2_3 = v_02_050_item03_2_3;
	}
	public String getV_02_050_item03_2_4() {
		return v_02_050_item03_2_4;
	}
	public void setV_02_050_item03_2_4(String v_02_050_item03_2_4) {
		this.v_02_050_item03_2_4 = v_02_050_item03_2_4;
	}
	public String getV_02_050_item03_3() {
		return v_02_050_item03_3;
	}
	public void setV_02_050_item03_3(String v_02_050_item03_3) {
		this.v_02_050_item03_3 = v_02_050_item03_3;
	}
	public int getV_02_050_item03_4() {
		return v_02_050_item03_4;
	}
	public void setV_02_050_item03_4(int v_02_050_item03_4) {
		this.v_02_050_item03_4 = v_02_050_item03_4;
	}
	public int getV_02_050_item04_1() {
		return v_02_050_item04_1;
	}
	public void setV_02_050_item04_1(int v_02_050_item04_1) {
		this.v_02_050_item04_1 = v_02_050_item04_1;
	}
	public String getV_02_050_item04_2_1() {
		return v_02_050_item04_2_1;
	}
	public void setV_02_050_item04_2_1(String v_02_050_item04_2_1) {
		this.v_02_050_item04_2_1 = v_02_050_item04_2_1;
	}
	public String getV_02_050_item04_2_2() {
		return v_02_050_item04_2_2;
	}
	public void setV_02_050_item04_2_2(String v_02_050_item04_2_2) {
		this.v_02_050_item04_2_2 = v_02_050_item04_2_2;
	}
	public String getV_02_050_item04_2_3() {
		return v_02_050_item04_2_3;
	}
	public void setV_02_050_item04_2_3(String v_02_050_item04_2_3) {
		this.v_02_050_item04_2_3 = v_02_050_item04_2_3;
	}
	public String getV_02_050_item04_2_4() {
		return v_02_050_item04_2_4;
	}
	public void setV_02_050_item04_2_4(String v_02_050_item04_2_4) {
		this.v_02_050_item04_2_4 = v_02_050_item04_2_4;
	}
	public String getV_02_050_item04_3() {
		return v_02_050_item04_3;
	}
	public void setV_02_050_item04_3(String v_02_050_item04_3) {
		this.v_02_050_item04_3 = v_02_050_item04_3;
	}
	public int getV_02_050_item04_4() {
		return v_02_050_item04_4;
	}
	public void setV_02_050_item04_4(int v_02_050_item04_4) {
		this.v_02_050_item04_4 = v_02_050_item04_4;
	}
	/*public int getV_02_060_item01_1() {
		return v_02_060_item01_1;
	}
	public void setV_02_060_item01_1(int v_02_060_item01_1) {
		this.v_02_060_item01_1 = v_02_060_item01_1;
	}
	public String getV_02_060_item01_2() {
		return v_02_060_item01_2;
	}
	public void setV_02_060_item01_2(String v_02_060_item01_2) {
		this.v_02_060_item01_2 = v_02_060_item01_2;
	}
	public int getV_02_060_item02_1() {
		return v_02_060_item02_1;
	}
	public void setV_02_060_item02_1(int v_02_060_item02_1) {
		this.v_02_060_item02_1 = v_02_060_item02_1;
	}
	public String getV_02_060_item02_2() {
		return v_02_060_item02_2;
	}
	public void setV_02_060_item02_2(String v_02_060_item02_2) {
		this.v_02_060_item02_2 = v_02_060_item02_2;
	}
	public int getV_02_060_item03_1() {
		return v_02_060_item03_1;
	}
	public void setV_02_060_item03_1(int v_02_060_item03_1) {
		this.v_02_060_item03_1 = v_02_060_item03_1;
	}
	public String getV_02_060_item03_2() {
		return v_02_060_item03_2;
	}
	public void setV_02_060_item03_2(String v_02_060_item03_2) {
		this.v_02_060_item03_2 = v_02_060_item03_2;
	}
	public int getV_02_060_item04_1() {
		return v_02_060_item04_1;
	}
	public void setV_02_060_item04_1(int v_02_060_item04_1) {
		this.v_02_060_item04_1 = v_02_060_item04_1;
	}
	public String getV_02_060_item04_2() {
		return v_02_060_item04_2;
	}
	public void setV_02_060_item04_2(String v_02_060_item04_2) {
		this.v_02_060_item04_2 = v_02_060_item04_2;
	}*/
	/*public int getV_02_070_item01_1() {
		return v_02_070_item01_1;
	}
	public void setV_02_070_item01_1(int v_02_070_item01_1) {
		this.v_02_070_item01_1 = v_02_070_item01_1;
	}
	public String getV_02_070_item01_2() {
		return v_02_070_item01_2;
	}
	public void setV_02_070_item01_2(String v_02_070_item01_2) {
		this.v_02_070_item01_2 = v_02_070_item01_2;
	}
	public int getV_02_070_item02_1() {
		return v_02_070_item02_1;
	}
	public void setV_02_070_item02_1(int v_02_070_item02_1) {
		this.v_02_070_item02_1 = v_02_070_item02_1;
	}
	public String getV_02_070_item02_2() {
		return v_02_070_item02_2;
	}
	public void setV_02_070_item02_2(String v_02_070_item02_2) {
		this.v_02_070_item02_2 = v_02_070_item02_2;
	}
	public int getV_02_070_item03_1() {
		return v_02_070_item03_1;
	}
	public void setV_02_070_item03_1(int v_02_070_item03_1) {
		this.v_02_070_item03_1 = v_02_070_item03_1;
	}
	public String getV_02_070_item03_2() {
		return v_02_070_item03_2;
	}
	public void setV_02_070_item03_2(String v_02_070_item03_2) {
		this.v_02_070_item03_2 = v_02_070_item03_2;
	}
	public int getV_02_070_item04_1() {
		return v_02_070_item04_1;
	}
	public void setV_02_070_item04_1(int v_02_070_item04_1) {
		this.v_02_070_item04_1 = v_02_070_item04_1;
	}
	public String getV_02_070_item04_2() {
		return v_02_070_item04_2;
	}
	public void setV_02_070_item04_2(String v_02_070_item04_2) {
		this.v_02_070_item04_2 = v_02_070_item04_2;
	}*/
	public String getV_02_080_item01() {
		return v_02_080_item01;
	}
	public void setV_02_080_item01(String v_02_080_item01) {
		this.v_02_080_item01 = v_02_080_item01;
	}
//	public int getV_03_010_item01_1() {
//		return v_03_010_item01_1;
//	}
//	public void setV_03_010_item01_1(int v_03_010_item01_1) {
//		this.v_03_010_item01_1 = v_03_010_item01_1;
//	}
//	public String getV_03_010_item01_2() {
//		return v_03_010_item01_2;
//	}
//	public void setV_03_010_item01_2(String v_03_010_item01_2) {
//		this.v_03_010_item01_2 = v_03_010_item01_2;
//	}
//	public int getV_03_010_item02_1() {
//		return v_03_010_item02_1;
//	}
//	public void setV_03_010_item02_1(int v_03_010_item02_1) {
//		this.v_03_010_item02_1 = v_03_010_item02_1;
//	}
//	public String getV_03_010_item02_2() {
//		return v_03_010_item02_2;
//	}
//	public void setV_03_010_item02_2(String v_03_010_item02_2) {
//		this.v_03_010_item02_2 = v_03_010_item02_2;
//	}
	/*public int getV_03_011_item01() {
		return v_03_011_item01;
	}
	public void setV_03_011_item01(int v_03_011_item01) {
		this.v_03_011_item01 = v_03_011_item01;
	}
	public int getV_03_011_item02() {
		return v_03_011_item02;
	}
	public void setV_03_011_item02(int v_03_011_item02) {
		this.v_03_011_item02 = v_03_011_item02;
	}
	public String getV_03_011_item03() {
		return v_03_011_item03;
	}
	public void setV_03_011_item03(String v_03_011_item03) {
		this.v_03_011_item03 = v_03_011_item03;
	}
	public int getV_03_020_item01_1() {
		return v_03_020_item01_1;
	}
	public void setV_03_020_item01_1(int v_03_020_item01_1) {
		this.v_03_020_item01_1 = v_03_020_item01_1;
	}
	public int getV_03_020_item01_2() {
		return v_03_020_item01_2;
	}
	public void setV_03_020_item01_2(int v_03_020_item01_2) {
		this.v_03_020_item01_2 = v_03_020_item01_2;
	}
	public int getV_03_020_item02_1() {
		return v_03_020_item02_1;
	}
	public void setV_03_020_item02_1(int v_03_020_item02_1) {
		this.v_03_020_item02_1 = v_03_020_item02_1;
	}
	public int getV_03_020_item02_2() {
		return v_03_020_item02_2;
	}
	public void setV_03_020_item02_2(int v_03_020_item02_2) {
		this.v_03_020_item02_2 = v_03_020_item02_2;
	}
	public int getV_03_020_item03_1() {
		return v_03_020_item03_1;
	}
	public void setV_03_020_item03_1(int v_03_020_item03_1) {
		this.v_03_020_item03_1 = v_03_020_item03_1;
	}
	public int getV_03_020_item03_2() {
		return v_03_020_item03_2;
	}
	public void setV_03_020_item03_2(int v_03_020_item03_2) {
		this.v_03_020_item03_2 = v_03_020_item03_2;
	}
	public int getV_03_020_item04_1() {
		return v_03_020_item04_1;
	}
	public void setV_03_020_item04_1(int v_03_020_item04_1) {
		this.v_03_020_item04_1 = v_03_020_item04_1;
	}
	public int getV_03_020_item04_2() {
		return v_03_020_item04_2;
	}
	public void setV_03_020_item04_2(int v_03_020_item04_2) {
		this.v_03_020_item04_2 = v_03_020_item04_2;
	}
	public int getV_03_020_item05_1() {
		return v_03_020_item05_1;
	}
	public void setV_03_020_item05_1(int v_03_020_item05_1) {
		this.v_03_020_item05_1 = v_03_020_item05_1;
	}
	public int getV_03_020_item05_2() {
		return v_03_020_item05_2;
	}
	public void setV_03_020_item05_2(int v_03_020_item05_2) {
		this.v_03_020_item05_2 = v_03_020_item05_2;
	}
	public int getV_03_020_item06_1() {
		return v_03_020_item06_1;
	}
	public void setV_03_020_item06_1(int v_03_020_item06_1) {
		this.v_03_020_item06_1 = v_03_020_item06_1;
	}
	public int getV_03_020_item06_2() {
		return v_03_020_item06_2;
	}
	public void setV_03_020_item06_2(int v_03_020_item06_2) {
		this.v_03_020_item06_2 = v_03_020_item06_2;
	}
	public String getV_03_020_meterTypeListStr() {
		return v_03_020_meterTypeListStr;
	}
	public void setV_03_020_meterTypeListStr(String meterTypeListStr) {
		this.v_03_020_meterTypeListStr = meterTypeListStr;
	}
	public int getV_03_030_item01_1() {
		return v_03_030_item01_1;
	}
	public void setV_03_030_item01_1(int v_03_030_item01_1) {
		this.v_03_030_item01_1 = v_03_030_item01_1;
	}
	public String getV_03_030_item01_2() {
		return v_03_030_item01_2;
	}
	public void setV_03_030_item01_2(String v_03_030_item01_2) {
		this.v_03_030_item01_2 = v_03_030_item01_2;
	}
	public int getV_03_030_item03_1() {
		return v_03_030_item03_1;
	}
	public void setV_03_030_item03_1(int v_03_030_item03_1) {
		this.v_03_030_item03_1 = v_03_030_item03_1;
	}
	public String getV_03_030_item03_2() {
		return v_03_030_item03_2;
	}
	public void setV_03_030_item03_2(String v_03_030_item03_2) {
		this.v_03_030_item03_2 = v_03_030_item03_2;
	}
	public int getV_03_030_item04_1() {
		return v_03_030_item04_1;
	}
	public void setV_03_030_item04_1(int v_03_030_item04_1) {
		this.v_03_030_item04_1 = v_03_030_item04_1;
	}
	public String getV_03_030_item04_2() {
		return v_03_030_item04_2;
	}
	public void setV_03_030_item04_2(String v_03_030_item04_2) {
		this.v_03_030_item04_2 = v_03_030_item04_2;
	}
	public int getV_03_030_item05_1() {
		return v_03_030_item05_1;
	}
	public void setV_03_030_item05_1(int v_03_030_item05_1) {
		this.v_03_030_item05_1 = v_03_030_item05_1;
	}
	public String getV_03_030_item05_2() {
		return v_03_030_item05_2;
	}
	public void setV_03_030_item05_2(String v_03_030_item05_2) {
		this.v_03_030_item05_2 = v_03_030_item05_2;
	}
	public int getV_03_030_item06_1() {
		return v_03_030_item06_1;
	}
	public void setV_03_030_item06_1(int v_03_030_item06_1) {
		this.v_03_030_item06_1 = v_03_030_item06_1;
	}
	public String getV_03_030_item06_2() {
		return v_03_030_item06_2;
	}
	public void setV_03_030_item06_2(String v_03_030_item06_2) {
		this.v_03_030_item06_2 = v_03_030_item06_2;
	}
	public int getV_03_040_item01_1() {
		return v_03_040_item01_1;
	}
	public void setV_03_040_item01_1(int v_03_040_item01_1) {
		this.v_03_040_item01_1 = v_03_040_item01_1;
	}
	public String getV_03_040_item01_2() {
		return v_03_040_item01_2;
	}
	public void setV_03_040_item01_2(String v_03_040_item01_2) {
		this.v_03_040_item01_2 = v_03_040_item01_2;
	}
	public int getV_03_050_item01_1() {
		return v_03_050_item01_1;
	}
	public void setV_03_050_item01_1(int v_03_050_item01_1) {
		this.v_03_050_item01_1 = v_03_050_item01_1;
	}
	public String getV_03_050_item01_2() {
		return v_03_050_item01_2;
	}
	public void setV_03_050_item01_2(String v_03_050_item01_2) {
		this.v_03_050_item01_2 = v_03_050_item01_2;
	}
	public int getV_03_050_item02_1() {
		return v_03_050_item02_1;
	}
	public void setV_03_050_item02_1(int v_03_050_item02_1) {
		this.v_03_050_item02_1 = v_03_050_item02_1;
	}
	public String getV_03_050_item02_2() {
		return v_03_050_item02_2;
	}
	public void setV_03_050_item02_2(String v_03_050_item02_2) {
		this.v_03_050_item02_2 = v_03_050_item02_2;
	}
	public int getV_03_050_item03_1() {
		return v_03_050_item03_1;
	}
	public void setV_03_050_item03_1(int v_03_050_item03_1) {
		this.v_03_050_item03_1 = v_03_050_item03_1;
	}
	public String getV_03_050_item03_2() {
		return v_03_050_item03_2;
	}
	public void setV_03_050_item03_2(String v_03_050_item03_2) {
		this.v_03_050_item03_2 = v_03_050_item03_2;
	}
	public int getV_03_050_item04_1() {
		return v_03_050_item04_1;
	}
	public void setV_03_050_item04_1(int v_03_050_item04_1) {
		this.v_03_050_item04_1 = v_03_050_item04_1;
	}
	public String getV_03_050_item04_2() {
		return v_03_050_item04_2;
	}
	public void setV_03_050_item04_2(String v_03_050_item04_2) {
		this.v_03_050_item04_2 = v_03_050_item04_2;
	}*/
	public String getV_03_060_item01() {
		return v_03_060_item01;
	}
	public void setV_03_060_item01(String v_03_060_item01) {
		this.v_03_060_item01 = v_03_060_item01;
	}
	/*public int getV_03_070_item01_1() {
		return v_03_070_item01_1;
	}
	public void setV_03_070_item01_1(int v_03_070_item01_1) {
		this.v_03_070_item01_1 = v_03_070_item01_1;
	}
	public String getV_03_070_item01_2() {
		return v_03_070_item01_2;
	}
	public void setV_03_070_item01_2(String v_03_070_item01_2) {
		this.v_03_070_item01_2 = v_03_070_item01_2;
	}
	public int getV_03_070_item02_1() {
		return v_03_070_item02_1;
	}
	public void setV_03_070_item02_1(int v_03_070_item02_1) {
		this.v_03_070_item02_1 = v_03_070_item02_1;
	}
	public String getV_03_070_item02_2() {
		return v_03_070_item02_2;
	}
	public void setV_03_070_item02_2(String v_03_070_item02_2) {
		this.v_03_070_item02_2 = v_03_070_item02_2;
	}
	public int getV_03_070_item03_1() {
		return v_03_070_item03_1;
	}
	public void setV_03_070_item03_1(int v_03_070_item03_1) {
		this.v_03_070_item03_1 = v_03_070_item03_1;
	}
	public String getV_03_070_item03_2() {
		return v_03_070_item03_2;
	}
	public void setV_03_070_item03_2(String v_03_070_item03_2) {
		this.v_03_070_item03_2 = v_03_070_item03_2;
	}*/
	public String getV_03_080_chechBoxs() {
		return v_03_080_chechBoxs;
	}
	public void setV_03_080_chechBoxs(String v_03_080_chechBoxs) {
		this.v_03_080_chechBoxs = v_03_080_chechBoxs;
	}
	public String getV_03_080_items() {
		return v_03_080_items;
	}
	public void setV_03_080_items(String v_03_080_items) {
		this.v_03_080_items = v_03_080_items;
	}
	public String getV_03_090_item01() {
		return v_03_090_item01;
	}
	public void setV_03_090_item01(String v_03_090_item01) {
		this.v_03_090_item01 = v_03_090_item01;
	}
	/*public int getV_04_010_item01() {
		return v_04_010_item01;
	}
	public void setV_04_010_item01(int v_04_010_item01) {
		this.v_04_010_item01 = v_04_010_item01;
	}*/
	public String getV_04_020_itemStr() {
		return v_04_020_itemStr;
	}
	public void setV_04_020_itemStr(String v_04_020_itemStr) {
		this.v_04_020_itemStr = v_04_020_itemStr;
	}
	public String getV_04_030_chechBoxs() {
		return v_04_030_chechBoxs;
	}
	public void setV_04_030_chechBoxs(String v_04_030_chechBoxs) {
		this.v_04_030_chechBoxs = v_04_030_chechBoxs;
	}
	public String getV_04_030_items() {
		return v_04_030_items;
	}
	public void setV_04_030_items(String v_04_030_items) {
		this.v_04_030_items = v_04_030_items;
	}
	public String getV_04_040_chechBoxs() {
		return v_04_040_chechBoxs;
	}
	public void setV_04_040_chechBoxs(String v_04_040_chechBoxs) {
		this.v_04_040_chechBoxs = v_04_040_chechBoxs;
	}
	public String getV_04_040_items() {
		return v_04_040_items;
	}
	public void setV_04_040_items(String v_04_040_items) {
		this.v_04_040_items = v_04_040_items;
	}
	public String getV_04_050_itemStr() {
		return v_04_050_itemStr;
	}
	public void setV_04_050_itemStr(String v_04_050_itemStr) {
		this.v_04_050_itemStr = v_04_050_itemStr;
	}
	/*public int getV_04_060_select() {
		return v_04_060_select;
	}
	public void setV_04_060_select(int v_04_060_select) {
		this.v_04_060_select = v_04_060_select;
	}
	public String getV_04_060_param01_1() {
		return v_04_060_param01_1;
	}
	public void setV_04_060_param01_1(String v_04_060_param01_1) {
		this.v_04_060_param01_1 = v_04_060_param01_1;
	}
	public String getV_04_060_param01_2() {
		return v_04_060_param01_2;
	}
	public void setV_04_060_param01_2(String v_04_060_param01_2) {
		this.v_04_060_param01_2 = v_04_060_param01_2;
	}
	public String getV_04_060_param01_3() {
		return v_04_060_param01_3;
	}
	public void setV_04_060_param01_3(String v_04_060_param01_3) {
		this.v_04_060_param01_3 = v_04_060_param01_3;
	}
	public String getV_04_060_param03_1() {
		return v_04_060_param03_1;
	}
	public void setV_04_060_param03_1(String v_04_060_param03_1) {
		this.v_04_060_param03_1 = v_04_060_param03_1;
	}
	public String getV_04_060_param03_2() {
		return v_04_060_param03_2;
	}
	public void setV_04_060_param03_2(String v_04_060_param03_2) {
		this.v_04_060_param03_2 = v_04_060_param03_2;
	}
	public String getV_04_060_param03_3() {
		return v_04_060_param03_3;
	}
	public void setV_04_060_param03_3(String v_04_060_param03_3) {
		this.v_04_060_param03_3 = v_04_060_param03_3;
	}
	public String getV_04_060_param04_1() {
		return v_04_060_param04_1;
	}
	public void setV_04_060_param04_1(String v_04_060_param04_1) {
		this.v_04_060_param04_1 = v_04_060_param04_1;
	}
	public String getV_04_060_param04_2() {
		return v_04_060_param04_2;
	}
	public void setV_04_060_param04_2(String v_04_060_param04_2) {
		this.v_04_060_param04_2 = v_04_060_param04_2;
	}
	public String getV_04_060_param04_3() {
		return v_04_060_param04_3;
	}
	public void setV_04_060_param04_3(String v_04_060_param04_3) {
		this.v_04_060_param04_3 = v_04_060_param04_3;
	}
	public String getV_04_060_param05_1() {
		return v_04_060_param05_1;
	}
	public void setV_04_060_param05_1(String v_04_060_param05_1) {
		this.v_04_060_param05_1 = v_04_060_param05_1;
	}
	public String getV_04_060_param05_2() {
		return v_04_060_param05_2;
	}
	public void setV_04_060_param05_2(String v_04_060_param05_2) {
		this.v_04_060_param05_2 = v_04_060_param05_2;
	}
	public String getV_04_060_param05_3() {
		return v_04_060_param05_3;
	}
	public void setV_04_060_param05_3(String v_04_060_param05_3) {
		this.v_04_060_param05_3 = v_04_060_param05_3;
	}
	public String getV_04_060_param06_1() {
		return v_04_060_param06_1;
	}
	public void setV_04_060_param06_1(String v_04_060_param06_1) {
		this.v_04_060_param06_1 = v_04_060_param06_1;
	}
	public String getV_04_060_param06_2() {
		return v_04_060_param06_2;
	}
	public void setV_04_060_param06_2(String v_04_060_param06_2) {
		this.v_04_060_param06_2 = v_04_060_param06_2;
	}
	public String getV_04_060_param06_3() {
		return v_04_060_param06_3;
	}
	public void setV_04_060_param06_3(String v_04_060_param06_3) {
		this.v_04_060_param06_3 = v_04_060_param06_3;
	}
	public String getV_04_060_param07_1() {
		return v_04_060_param07_1;
	}
	public void setV_04_060_param07_1(String v_04_060_param07_1) {
		this.v_04_060_param07_1 = v_04_060_param07_1;
	}
	public String getV_04_060_param07_2() {
		return v_04_060_param07_2;
	}
	public void setV_04_060_param07_2(String v_04_060_param07_2) {
		this.v_04_060_param07_2 = v_04_060_param07_2;
	}
	public String getV_04_060_param07_3() {
		return v_04_060_param07_3;
	}
	public void setV_04_060_param07_3(String v_04_060_param07_3) {
		this.v_04_060_param07_3 = v_04_060_param07_3;
	}
	public String getV_04_060_param08_1() {
		return v_04_060_param08_1;
	}
	public void setV_04_060_param08_1(String v_04_060_param08_1) {
		this.v_04_060_param08_1 = v_04_060_param08_1;
	}
	public String getV_04_060_param08_2() {
		return v_04_060_param08_2;
	}
	public void setV_04_060_param08_2(String v_04_060_param08_2) {
		this.v_04_060_param08_2 = v_04_060_param08_2;
	}
	public String getV_04_060_param08_3() {
		return v_04_060_param08_3;
	}
	public void setV_04_060_param08_3(String v_04_060_param08_3) {
		this.v_04_060_param08_3 = v_04_060_param08_3;
	}
	public String getV_04_060_param09_1() {
		return v_04_060_param09_1;
	}
	public void setV_04_060_param09_1(String v_04_060_param09_1) {
		this.v_04_060_param09_1 = v_04_060_param09_1;
	}
	public String getV_04_060_param09_2() {
		return v_04_060_param09_2;
	}
	public void setV_04_060_param09_2(String v_04_060_param09_2) {
		this.v_04_060_param09_2 = v_04_060_param09_2;
	}
	public String getV_04_060_param09_3() {
		return v_04_060_param09_3;
	}
	public void setV_04_060_param09_3(String v_04_060_param09_3) {
		this.v_04_060_param09_3 = v_04_060_param09_3;
	}
	public String getV_04_060_param10_1() {
		return v_04_060_param10_1;
	}
	public void setV_04_060_param10_1(String v_04_060_param10_1) {
		this.v_04_060_param10_1 = v_04_060_param10_1;
	}
	public String getV_04_060_param10_2() {
		return v_04_060_param10_2;
	}
	public void setV_04_060_param10_2(String v_04_060_param10_2) {
		this.v_04_060_param10_2 = v_04_060_param10_2;
	}
	public String getV_04_060_param10_3() {
		return v_04_060_param10_3;
	}
	public void setV_04_060_param10_3(String v_04_060_param10_3) {
		this.v_04_060_param10_3 = v_04_060_param10_3;
	}
	public String getV_04_060_param11_1() {
		return v_04_060_param11_1;
	}
	public void setV_04_060_param11_1(String v_04_060_param11_1) {
		this.v_04_060_param11_1 = v_04_060_param11_1;
	}
	public String getV_04_060_param11_2() {
		return v_04_060_param11_2;
	}
	public void setV_04_060_param11_2(String v_04_060_param11_2) {
		this.v_04_060_param11_2 = v_04_060_param11_2;
	}
	public String getV_04_060_param11_3() {
		return v_04_060_param11_3;
	}
	public void setV_04_060_param11_3(String v_04_060_param11_3) {
		this.v_04_060_param11_3 = v_04_060_param11_3;
	}
	public String getV_04_060_param12_1() {
		return v_04_060_param12_1;
	}
	public void setV_04_060_param12_1(String v_04_060_param12_1) {
		this.v_04_060_param12_1 = v_04_060_param12_1;
	}
	public String getV_04_060_param12_2() {
		return v_04_060_param12_2;
	}
	public void setV_04_060_param12_2(String v_04_060_param12_2) {
		this.v_04_060_param12_2 = v_04_060_param12_2;
	}
	public String getV_04_060_param12_3() {
		return v_04_060_param12_3;
	}
	public void setV_04_060_param12_3(String v_04_060_param12_3) {
		this.v_04_060_param12_3 = v_04_060_param12_3;
	}
	public String getV_04_060_param13_1() {
		return v_04_060_param13_1;
	}
	public void setV_04_060_param13_1(String v_04_060_param13_1) {
		this.v_04_060_param13_1 = v_04_060_param13_1;
	}
	public String getV_04_060_param13_2() {
		return v_04_060_param13_2;
	}
	public void setV_04_060_param13_2(String v_04_060_param13_2) {
		this.v_04_060_param13_2 = v_04_060_param13_2;
	}
	public String getV_04_060_param13_3() {
		return v_04_060_param13_3;
	}
	public void setV_04_060_param13_3(String v_04_060_param13_3) {
		this.v_04_060_param13_3 = v_04_060_param13_3;
	}
	public String getV_04_060_param02_1() {
		return v_04_060_param02_1;
	}
	public void setV_04_060_param02_1(String v_04_060_param02_1) {
		this.v_04_060_param02_1 = v_04_060_param02_1;
	}
	public String getV_04_060_param02_2() {
		return v_04_060_param02_2;
	}
	public void setV_04_060_param02_2(String v_04_060_param02_2) {
		this.v_04_060_param02_2 = v_04_060_param02_2;
	}
	public String getV_04_060_param02_3() {
		return v_04_060_param02_3;
	}
	public void setV_04_060_param02_3(String v_04_060_param02_3) {
		this.v_04_060_param02_3 = v_04_060_param02_3;
	}*/
	public String getV_04_070_chechBoxs() {
		return v_04_070_chechBoxs;
	}
	public void setV_04_070_chechBoxs(String v_04_070_chechBoxs) {
		this.v_04_070_chechBoxs = v_04_070_chechBoxs;
	}
	public String getV_04_080_chechBoxs() {
		return v_04_080_chechBoxs;
	}
	public void setV_04_080_chechBoxs(String v_04_080_chechBoxs) {
		this.v_04_080_chechBoxs = v_04_080_chechBoxs;
	}
	public String getV_04_080_items() {
		return v_04_080_items;
	}
	public void setV_04_080_items(String v_04_080_items) {
		this.v_04_080_items = v_04_080_items;
	}
	public String getV_04_090_item01() {
		return v_04_090_item01;
	}
	public void setV_04_090_item01(String v_04_090_item01) {
		this.v_04_090_item01 = v_04_090_item01;
	}
	
	public String getV_08_030_item01() {
		return v_08_030_item01;
	}
	public void setV_08_030_item01(String v_08_030_item01) {
		this.v_08_030_item01 = v_08_030_item01;
	}
	
	public String getV_08_110_item01() {
		return v_08_110_item01;
	}
	public void setV_08_110_item01(String v_08_110_item01) {
		this.v_08_110_item01 = v_08_110_item01;
	}
	
	
	public String getV_05_030_chechBoxs() {
		return v_05_030_chechBoxs;
	}
	public void setV_05_030_chechBoxs(String v_05_030_chechBoxs) {
		this.v_05_030_chechBoxs = v_05_030_chechBoxs;
	}
	/*public int getV_06_010_item01() {
		return v_06_010_item01;
	}
	public void setV_06_010_item01(int v_06_010_item01) {
		this.v_06_010_item01 = v_06_010_item01;
	}
	public String getV_06_010_item02Str() {
		return v_06_010_item02Str;
	}
	public void setV_06_010_item02Str(String v_06_010_item02Str) {
		this.v_06_010_item02Str = v_06_010_item02Str;
	}
	public String getV_06_010_item03() {
		return v_06_010_item03;
	}
	public void setV_06_010_item03(String v_06_010_item03) {
		this.v_06_010_item03 = v_06_010_item03;
	}
	public String getV_06_010_item04_01() {
		return v_06_010_item04_01;
	}
	public void setV_06_010_item04_01(String v_06_010_item04_01) {
		this.v_06_010_item04_01 = v_06_010_item04_01;
	}
	public String getV_06_010_item04_02() {
		return v_06_010_item04_02;
	}
	public void setV_06_010_item04_02(String v_06_010_item04_02) {
		this.v_06_010_item04_02 = v_06_010_item04_02;
	}
	public String getV_06_010_item04_03() {
		return v_06_010_item04_03;
	}
	public void setV_06_010_item04_03(String v_06_010_item04_03) {
		this.v_06_010_item04_03 = v_06_010_item04_03;
	}
	public String getV_06_010_item04_04() {
		return v_06_010_item04_04;
	}
	public void setV_06_010_item04_04(String v_06_010_item04_04) {
		this.v_06_010_item04_04 = v_06_010_item04_04;
	}
	public String getV_06_010_item04_05() {
		return v_06_010_item04_05;
	}
	public void setV_06_010_item04_05(String v_06_010_item04_05) {
		this.v_06_010_item04_05 = v_06_010_item04_05;
	}*/
	public String getV_04_100_item01() {
		return v_04_100_item01;
	}
	public void setV_04_100_item01(String v_04_100_item01) {
		this.v_04_100_item01 = v_04_100_item01;
	}
	public String getV_04_110_item01() {
		return v_04_110_item01;
	}
	public void setV_04_110_item01(String v_04_110_item01) {
		this.v_04_110_item01 = v_04_110_item01;
	}
	public String getV_04_120_itemStr() {
		return v_04_120_itemStr;
	}
	public void setV_04_120_itemStr(String v_04_120_itemStr) {
		this.v_04_120_itemStr = v_04_120_itemStr;
	}
	
	public String getV_08_020_item01() {
		return v_08_020_item01 ;
	}
	public void setV_08_020_item01(String v_08_020_item01) {
		this.v_08_020_item01 = v_08_020_item01 ;
	}
	
	public String getV_08_020_item02() {
		return v_08_020_item02 ;
	}
	public void setV_08_020_item02(String v_08_020_item02) {
		this.v_08_020_item02 = v_08_020_item02 ;
	}
	
	public String getV_08_060_item01() {
		return v_08_060_item01 ;
	}
	public void setV_08_060_item01(String v_08_060_item01) {
		this.v_08_060_item01 = v_08_060_item01 ;
	}
	
	public String getV_08_060_item02() {
		return v_08_060_item02 ;
	}
	public void setV_08_060_item02(String v_08_060_item02) {
		this.v_08_060_item02 = v_08_060_item02 ;
	}
	
	public String getV_08_060_item03() {
		return v_08_060_item03 ;
	}
	public void setV_08_060_item03(String v_08_060_item03) {
		this.v_08_060_item03 = v_08_060_item03 ;
	}
	
	public String getV_08_070_item01() {
		return v_08_070_item01 ;
	}
	public void setV_08_070_item01(String v_08_070_item01) {
		this.v_08_070_item01 = v_08_070_item01 ;
	}
	
	public String getV_08_070_item02() {
		return v_08_070_item02 ;
	}
	public void setV_08_070_item02(String v_08_070_item02) {
		this.v_08_070_item02 = v_08_070_item02 ;
	}
	
	public String getV_08_070_item03() {
		return v_08_070_item03 ;
	}
	public void setV_08_070_item03(String v_08_070_item03) {
		this.v_08_070_item03 = v_08_070_item03 ;
	}
	
	public String getV_08_080_item01() {
		return v_08_080_item01 ;
	}
	public void setV_08_080_item01(String v_08_080_item01) {
		this.v_08_080_item01 = v_08_080_item01 ;
	}
	
	public String getV_08_080_item02() {
		return v_08_080_item02 ;
	}
	public void setV_08_080_item02(String v_08_080_item02) {
		this.v_08_080_item02 = v_08_080_item02 ;
	}
	
	public String getV_08_080_item03() {
		return v_08_080_item03 ;
	}
	public void setV_08_080_item03(String v_08_080_item03) {
		this.v_08_080_item03 = v_08_080_item03 ;
	}
	
	public int getV_08_090_item01() {
		return v_08_090_item01 ;
	}
	public void setV_08_090_item01(int v_08_090_item01) {
		this.v_08_090_item01 = v_08_090_item01 ;
	}
	/*public String getV_06_010_item05Str() {
		return v_06_010_item05Str;
	}
	public void setV_06_010_item05Str(String v_06_010_item05Str) {
		this.v_06_010_item05Str = v_06_010_item05Str;
	}*/
	

}
