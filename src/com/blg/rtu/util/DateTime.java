package com.blg.rtu.util;

import java.util.*;
import java.text.SimpleDateFormat;

public class DateTime {

	public static long now() {
		return new Date().getTime();
	}

	public static String yyyy() {
		return new SimpleDateFormat("yyyy", Locale.US).format(new Date(System.currentTimeMillis()));
	}
	public static String yyyy(Date date) {
		return new SimpleDateFormat("yyyy", Locale.US).format(date);
	}
	public static String yyyy(String yyyy) {
		return new SimpleDateFormat("yyyy", Locale.US).format(yyyy);
	}
	public static String yy() {
		return new SimpleDateFormat("yy", Locale.US).format(new Date(System.currentTimeMillis()));
	}

	public static String MM() {
		return new SimpleDateFormat("MM", Locale.US).format(new Date(System.currentTimeMillis()));
	}

	public static String dd() {
		return new SimpleDateFormat("dd", Locale.US).format(new Date(System.currentTimeMillis()));
	}

	public static String HH() {
		return new SimpleDateFormat("HH", Locale.US).format(new Date(System.currentTimeMillis()));
	}

	public static String mm() {
		return new SimpleDateFormat("mm", Locale.US).format(new Date(System.currentTimeMillis()));
	}

	public static String ss() {
		return new SimpleDateFormat("ss", Locale.US).format(new Date(System.currentTimeMillis()));
	}
	
	//星期一：Monday 星期二:Tuesday 星期三：Wednesday星期四：Thursday星期五：Friday星期六：Saturday星期日：Sunday 
	//返回 Mon, Tue Wed Thu Fri Sat Sun
	public static String week_Str(){
		return new SimpleDateFormat("EE", Locale.US).format(System.currentTimeMillis()); 	
	}
	public static Integer week_Int(){
		String str = week_Str() ;
		Integer flag = 0 ;
		if(str != null){
			if(str.equals("Mon")){
				flag = 1 ;
			}else if(str.equals("Tue")){
				flag = 2 ;
			}else if(str.equals("Wed")){
				flag = 3 ;
			}else if(str.equals("Thu")){
				flag = 4 ;
			}else if(str.equals("Fri")){
				flag = 5 ;
			}else if(str.equals("Sat")){
				flag = 6 ;
			}else if(str.equals("Sun")){
				flag = 7 ;
			}
		}
		return flag ;
	}

	//////////////////////////////////////////////////////////////
	
	public static String dd_HH_mm_ss() {
		return new SimpleDateFormat("dd HH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}

	//////////////////////////////////////////////////////////////

	public static String yyyy_MM_dd_HH_mm_ss() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyy_MM_dd_HH_mm() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyy_MM_dd_HH() {
		return new SimpleDateFormat("yyyy-MM-dd HH", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyy_MM_dd() {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyy_MM() {
		return new SimpleDateFormat("yyyy-MM", Locale.US).format(System.currentTimeMillis());
	}

	
	public static String yyyy_MM_dd_HH_mm_ss(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
	}
	public static String yyyy_MM_dd_HH_mm(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(date);
	}
	public static String yyyy_MM_dd_HH(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH", Locale.US).format(date);
	}
	public static String yyyy_MM_dd(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date);
	}
	public static String yyyy_MM(Date date) {
		return new SimpleDateFormat("yyyy-MM", Locale.US).format(date);
	}

	
	public static String yyyy_MM_dd_HH_mm_ss(String date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
	}
	public static String yyyy_MM_dd_HH_mm(String date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(date);
	}
	public static String yyyy_MM_dd_HH(String date) {
		return new SimpleDateFormat("yyyy-MM-dd HH", Locale.US).format(date);
	}
	public static String yyyy_MM_dd(String date) {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date);
	}
	public static String yyyy_MM(String date) {
		return new SimpleDateFormat("yyyy-MM", Locale.US).format(date);
	}
	
	public static String yyyyMMddHHmmss() {
		return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyyMMddHHmm() {
		return new SimpleDateFormat("yyyyMMddHHmm", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyyMMddHH() {
		return new SimpleDateFormat("yyyyMMddHH", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyyMMdd() {
		return new SimpleDateFormat("yyyyMMdd", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyyMM() {
		return new SimpleDateFormat("yyyyMM", Locale.US).format(System.currentTimeMillis());
	}
	
	public static String yyyyMMddHHmmss(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(date);
	}
	public static String yyyyMMddHHmm(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmm", Locale.US).format(date);
	}
	public static String yyyyMMddHH(Date date) {
		return new SimpleDateFormat("yyyyMMddHH", Locale.US).format(date);
	}
	public static String yyyyMMdd(Date date) {
		return new SimpleDateFormat("yyyyMMdd", Locale.US).format(date);
	}
	public static String yyyyMM(Date date) {
		return new SimpleDateFormat("yyyyMM", Locale.US).format(date);
	}
	
	public static String yyyyMMddHHmmss(String date) {
		return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(date);
	}
	public static String yyyyMMddHHmm(String date) {
		return new SimpleDateFormat("yyyyMMddHHmm", Locale.US).format(date);
	}
	public static String yyyyMMddHH(String date) {
		return new SimpleDateFormat("yyyyMMddHH", Locale.US).format(date);
	}
	public static String yyyyMMdd(String date) {
		return new SimpleDateFormat("yyyyMMdd", Locale.US).format(date);
	}
	public static String yyyyMM(String date) {
		return new SimpleDateFormat("yyyyMM", Locale.US).format(date);
	}
	
	//////////////////////////////////////////////////////////////

	public static String yy_MM_dd_HH_mm_ss() {
		return new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}
	public static String yy_MM_dd_HH_mm() {
		return new SimpleDateFormat("yy-MM-dd HH:mm", Locale.US).format(System.currentTimeMillis());
	}
	public static String yy_MM_dd_HH() {
		return new SimpleDateFormat("yy-MM-dd HH", Locale.US).format(System.currentTimeMillis());
	}
	public static String yy_MM_dd() {
		return new SimpleDateFormat("yy-MM-dd", Locale.US).format(System.currentTimeMillis());
	}
	public static String yy_MM() {
		return new SimpleDateFormat("yy-MM", Locale.US).format(System.currentTimeMillis());
	}

	
	public static String yy_MM_dd_HH_mm_ss(Date date) {
		return new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.US).format(date);
	}
	public static String yy_MM_dd_HH_mm(Date date) {
		return new SimpleDateFormat("yy-MM-dd HH:mm", Locale.US).format(date);
	}
	public static String yy_MM_dd_HH(Date date) {
		return new SimpleDateFormat("yy-MM-dd HH", Locale.US).format(date);
	}
	public static String yy_MM_dd(Date date) {
		return new SimpleDateFormat("yy-MM-dd", Locale.US).format(date);
	}
	public static String yy_MM(Date date) {
		return new SimpleDateFormat("yy-MM", Locale.US).format(date);
	}

	
	public static String yy_MM_dd_HH_mm_ss(String date) {
		return new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.US).format(date);
	}
	public static String yy_MM_dd_HH_mm(String date) {
		return new SimpleDateFormat("yy-MM-dd HH:mm", Locale.US).format(date);
	}
	public static String yy_MM_dd_HH(String date) {
		return new SimpleDateFormat("yy-MM-dd HH", Locale.US).format(date);
	}
	public static String yy_MM_dd(String date) {
		return new SimpleDateFormat("yy-MM-dd", Locale.US).format(date);
	}
	public static String yy_MM(String date) {
		return new SimpleDateFormat("yy-MM", Locale.US).format(date);
	}
	
	public static String yyMMddhhmmss() {
		return new SimpleDateFormat("yyMMddHHmmss", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyMMddhhmm() {
		return new SimpleDateFormat("yyMMddHHmm", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyMMddhh() {
		return new SimpleDateFormat("yyMMddHH", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyMMdd() {
		return new SimpleDateFormat("yyMMdd", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyMM() {
		return new SimpleDateFormat("yyMM", Locale.US).format(System.currentTimeMillis());
	}
	
	public static String yyMMddhhmmss(Date date) {
		return new SimpleDateFormat("yyMMddHHmmss", Locale.US).format(date);
	}
	public static String yyMMddhhmm(Date date) {
		return new SimpleDateFormat("yyMMddHHmm", Locale.US).format(date);
	}
	public static String yyMMddhh(Date date) {
		return new SimpleDateFormat("yyMMddHH", Locale.US).format(date);
	}
	public static String yyMMdd(Date date) {
		return new SimpleDateFormat("yyMMdd", Locale.US).format(date);
	}
	public static String yyMM(Date date) {
		return new SimpleDateFormat("yyMM", Locale.US).format(date);
	}
	
	public static String yyMMddhhmmss(String date) {
		return new SimpleDateFormat("yyMMddHHmmss", Locale.US).format(date);
	}
	public static String yyMMddhhmm(String date) {
		return new SimpleDateFormat("yyMMddHHmm", Locale.US).format(date);
	}
	public static String yyMMddhh(String date) {
		return new SimpleDateFormat("yyMMddHH", Locale.US).format(date);
	}
	public static String yyMMdd(String date) {
		return new SimpleDateFormat("yyMMdd", Locale.US).format(date);
	}
	public static String yyMM(String date) {
		return new SimpleDateFormat("yyMM", Locale.US).format(date);
	}
	

	//////////////////////////////////////////////////////////////

	public static String yyyyMMdd_HH_mm_ss() {
		return new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyyMMdd_HH_mm() {
		return new SimpleDateFormat("yyyyMMdd HH:mm", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyyyMMdd_HH() {
		return new SimpleDateFormat("yyyyMMdd HH", Locale.US).format(System.currentTimeMillis());
	}
	
	public static String yyyyMMdd_HH_mm_ss(Date date) {
		return new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.US).format(date);
	}
	public static String yyyyMMdd_HH_mm(Date date) {
		return new SimpleDateFormat("yyyyMMdd HH:mm", Locale.US).format(date);
	}
	public static String yyyyMMdd_HH(Date date) {
		return new SimpleDateFormat("yyyyMMdd HH", Locale.US).format(date);
	}

	
	public static String yyyyMMdd_HH_mm_ss(String date) {
		return new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.US).format(date);
	}
	public static String yyyyMMdd_HH_mm(String date) {
		return new SimpleDateFormat("yyyyMMdd HH:mm", Locale.US).format(date);
	}
	public static String yyyyMMdd_HH(String date) {
		return new SimpleDateFormat("yyyyMMdd HH", Locale.US).format(date);
	}
	
	

	//////////////////////////////////////////////////////////////

	public static String yyMMdd_HH_mm_ss() {
		return new SimpleDateFormat("yyMMdd HH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyMMdd_HH_mm() {
		return new SimpleDateFormat("yyMMdd HH:mm", Locale.US).format(System.currentTimeMillis());
	}
	public static String yyMMdd_HH() {
		return new SimpleDateFormat("yyMMdd HH", Locale.US).format(System.currentTimeMillis());
	}
	
	public static String yyMMdd_HH_mm_ss(Date date) {
		return new SimpleDateFormat("yyMMdd HH:mm:ss", Locale.US).format(date);
	}
	public static String yyMMdd_HH_mm(Date date) {
		return new SimpleDateFormat("yyMMdd HH:mm", Locale.US).format(date);
	}
	public static String yyMMdd_HH(Date date) {
		return new SimpleDateFormat("yyMMdd HH", Locale.US).format(date);
	}

	
	public static String yyMMdd_HH_mm_ss(String date) {
		return new SimpleDateFormat("yyMMdd HH:mm:ss", Locale.US).format(date);
	}
	public static String yyMMdd_HH_mm(String date) {
		return new SimpleDateFormat("yyMMdd HH:mm", Locale.US).format(date);
	}
	public static String yyMMdd_HH(String date) {
		return new SimpleDateFormat("yyMMdd HH", Locale.US).format(date);
	}
	
   /////////////////////////////////////////	
	
	
	public static String dd_hh_mm_ss() {
		return new SimpleDateFormat("ddHH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}
	public static String ddhhmmss() {
		return new SimpleDateFormat("ddHHmmss", Locale.US).format(System.currentTimeMillis());
	}
	
	public static String hh_mm_ss() {
		return new SimpleDateFormat("HH:mm:ss", Locale.US).format(System.currentTimeMillis());
	}
	public static String hhmmss() {
		return new SimpleDateFormat("HHmmss", Locale.US).format(System.currentTimeMillis());
	}
	
	public static String hh_mm() {
		return new SimpleDateFormat("HH:mm", Locale.US).format(System.currentTimeMillis());
	}
	
    //////////////////////////////////////////////////////////////////////////
	
	public static Date dateFrom_yyyy_MM_dd_HH_mm_ss(String yyyy_MM_dd_HH_mm_ss) throws Exception {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(yyyy_MM_dd_HH_mm_ss);
	}
	public static Date dateFrom_yyyy_MM_dd_HH_mm(String yyyy_MM_dd_HH_mm) throws Exception {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).parse(yyyy_MM_dd_HH_mm);
	}
	public static Date dateFrom_yyyy_MM_dd_HH(String yyyy_MM_dd_HH) throws Exception {
		return new SimpleDateFormat("yyyy-MM-dd HH", Locale.US).parse(yyyy_MM_dd_HH);
	}
	public static Date dateFrom_yyyy_MM_dd(String yyyy_MM_dd) throws Exception {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(yyyy_MM_dd);
	}
	
	public static Date dateFrom_yyyyMMddHHmmss(String yyyyMMddHHmmss) throws Exception {
		return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(yyyyMMddHHmmss);
	}
	public static Date dateFrom_yyyyMMddHHmm(String yyyyMMddHHmm) throws Exception {
		return new SimpleDateFormat("yyyyMMddHHmm", Locale.US).parse(yyyyMMddHHmm);
	}
	public static Date dateFrom_yyyyMMddHH(String yyyyMMddHH) throws Exception {
		return new SimpleDateFormat("yyyyMMddHH", Locale.US).parse(yyyyMMddHH);
	}
	public static Date dateFrom_yyyyMMdd(String yyyyMMdd) throws Exception {
		return new SimpleDateFormat("yyyyMMdd", Locale.US).parse(yyyyMMdd);
	}
	
    //////////////////////////////////////////////////////////////////////////

	
	/**
	 * 两个日期间相差秒钟数
	 */
	public static long secondsBetweenyyyy_MM_dd_HH_mm_ss(String yyyy_MM_dd_HH_mm_ss_1 , String yyyy_MM_dd_HH_mm_ss_2)throws Exception{
		return ((dateFrom_yyyy_MM_dd_HH_mm_ss(yyyy_MM_dd_HH_mm_ss_1).getTime()-dateFrom_yyyy_MM_dd_HH_mm_ss(yyyy_MM_dd_HH_mm_ss_2).getTime())/1000);
	}
	/**
	 * 两个日期间相差秒钟数
	 */
	public static long secondsBetweenyyyyMMddHHmmss(String yyyyMMddHHmmss_1 , String yyyyMMddHHmmss_2)throws Exception{
		return ((dateFrom_yyyyMMddHHmmss(yyyyMMddHHmmss_1).getTime()-dateFrom_yyyyMMddHHmmss(yyyyMMddHHmmss_2).getTime())/1000) ;
	}
	/**
	 * 两个日期间相差分钟数
	 */
	public static long minutesBetweenyyyy_MM_dd_HH_mm(String yyyy_MM_dd_HH_mm_1 , String yyyy_MM_dd_HH_mm_2)throws Exception{
		return ((dateFrom_yyyy_MM_dd_HH_mm(yyyy_MM_dd_HH_mm_1).getTime()-dateFrom_yyyy_MM_dd_HH_mm(yyyy_MM_dd_HH_mm_2).getTime())/1000)/60 ;
	}
	/**
	 * 两个日期间相差分钟数
	 */
	public static long minutesBetweenyyyyMMddHHmm(String yyyyMMddHHmm_1 , String yyyyMMddHHmm_2)throws Exception{
		return ((dateFrom_yyyyMMddHHmm(yyyyMMddHHmm_1).getTime()-dateFrom_yyyyMMddHHmm(yyyyMMddHHmm_2).getTime())/1000)/60 ;
	}
	/**
	 * 两个日期相差小时数
	 */
	public static long hoursBetweenyyyy_MM_dd_HH(String yyyy_MM_dd_HH_1 , String yyyy_MM_dd_HH_2)throws Exception{
		return (((dateFrom_yyyy_MM_dd_HH(yyyy_MM_dd_HH_1).getTime()-dateFrom_yyyy_MM_dd_HH(yyyy_MM_dd_HH_2).getTime())/1000)/60)/60 ;
	}
	/**
	 * 两个日期相差小时数
	 */
	public static long hoursBetweenyyyyMMddHH(String yyyyMMddHH_1 , String yyyyMMddHH_2)throws Exception{
		return (((dateFrom_yyyy_MM_dd_HH(yyyyMMddHH_1).getTime()-dateFrom_yyyy_MM_dd_HH(yyyyMMddHH_2).getTime())/1000)/60)/60 ;
	}
	/**
	 * 两个日期相差天数
	 */
	public static long hoursBetweenyyyy_MM_dd(String yyyy_MM_dd_1 , String yyyy_MM_dd_2)throws Exception{
		return ((((dateFrom_yyyy_MM_dd_HH(yyyy_MM_dd_1).getTime()-dateFrom_yyyy_MM_dd_HH(yyyy_MM_dd_2).getTime())/1000)/60)/60)/24 ;
	}
	/**
	 * 两个日期相差天数
	 */
	public static long hoursBetweenyyyyMMdd(String yyyyMMdd_1 , String yyyyMMdd_2)throws Exception{
		return ((((dateFrom_yyyy_MM_dd_HH(yyyyMMdd_1).getTime()-dateFrom_yyyy_MM_dd_HH(yyyyMMdd_2).getTime())/1000)/60)/60)/24 ;
	}
	

	//////////////////////////////////////////////////////////////////////////

	/**
	 * 字符串型日期(2009-09-10)转成年月日数组
	 * @param yyyy_MM_DD
	 * @return
	 */
	public static int[] yyyy_MM_dd_2_ymdGroup(String yyyy_MM_DD){
		int y = Integer.parseInt(yyyy_MM_DD.substring(0 , 4)) ;
		int m = Integer.parseInt(yyyy_MM_DD.substring(5 , 7)) ;
		int d = Integer.parseInt(yyyy_MM_DD.substring(8 , 10)) ;
		return new int[]{y,m,d} ;
	}
	/**
	 * 字符串型日期(2009-09-10 00)转成年月日时数组
	 * @param yyyy_MM_DD
	 * @return
	 */
	public static int[] yyyy_MM_dd_HH_2_ymdhGroup(String yyyy_MM_DD_HH){
		int y = Integer.parseInt(yyyy_MM_DD_HH.substring(0 , 4)) ;
		int m = Integer.parseInt(yyyy_MM_DD_HH.substring(5 , 7)) ;
		int d = Integer.parseInt(yyyy_MM_DD_HH.substring(8 , 10)) ;
		int h = Integer.parseInt(yyyy_MM_DD_HH.substring(11 , 13)) ;
		return new int[]{y,m,d,h} ;
	}
	/**
	 * 字符串型日期(2009-09-10 00:00)转成年月日时分数组
	 * @param yyyy_MM_DD
	 * @return
	 */
	public static int[] yyyy_MM_dd_HH_MM_2_ymdhmGroup(String yyyy_MM_DD_HH_MM){
		int y = Integer.parseInt(yyyy_MM_DD_HH_MM.substring(0 , 4)) ;
		int m = Integer.parseInt(yyyy_MM_DD_HH_MM.substring(5 , 7)) ;
		int d = Integer.parseInt(yyyy_MM_DD_HH_MM.substring(8 , 10)) ;
		int h = Integer.parseInt(yyyy_MM_DD_HH_MM.substring(11 , 13)) ;
		int mm = Integer.parseInt(yyyy_MM_DD_HH_MM.substring(14 , 16)) ;
		return new int[]{y,m,d,h,mm} ;
	}
	/**
	 * 字符串型日期(2009-09-10 00:00)转成年月日时分秒数组
	 * @param yyyy_MM_DD
	 * @return
	 */
	public static int[] yyyy_MM_dd_HH_MM_SS_2_ymdhmsGroup(String yyyy_MM_DD_HH_MM_SS){
		int y = Integer.parseInt(yyyy_MM_DD_HH_MM_SS.substring(0 , 4)) ;
		int m = Integer.parseInt(yyyy_MM_DD_HH_MM_SS.substring(5 , 7)) ;
		int d = Integer.parseInt(yyyy_MM_DD_HH_MM_SS.substring(8 , 10)) ;
		int h = Integer.parseInt(yyyy_MM_DD_HH_MM_SS.substring(11 , 13)) ;
		int mm = Integer.parseInt(yyyy_MM_DD_HH_MM_SS.substring(14 , 16)) ;
		int s = Integer.parseInt(yyyy_MM_DD_HH_MM_SS.substring(17 , 19)) ;
		return new int[]{y,m,d,h,mm,s} ;
	}
	


	//////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * 得到过去x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String lastXHour_yyyy_MM_dd_HH(String yyyy_MM_dd_HH , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyy-MM-dd HH", Locale.US).parse(yyyy_MM_dd_HH);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd_HH(date) ;
	}
	/**
	 * 得到过去x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String lastXHour_yyyy_MM_dd_HH_mm(String yyyy_MM_dd_HH_mm , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).parse(yyyy_MM_dd_HH_mm);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd_HH_mm(date) ;
	}
	/**
	 * 得到过去x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String lastXHour_yyyy_MM_dd_HH_mm_ss(String yyyy_MM_dd_HH_mm_ss , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(yyyy_MM_dd_HH_mm_ss);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd_HH_mm_ss(date) ;
	}
	/**
	 * 得到过去x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String lastXHour_yyyyMMddHH(String yyyyMMddHH , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMddHH", Locale.US).parse(yyyyMMddHH);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMddHH(date) ;
	}
	/**
	 * 得到过去x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String lastXHour_yyyyMMddHHmm(String yyyyMMddHHmm , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMddHHmm", Locale.US).parse(yyyyMMddHHmm);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMddHHmm(date) ;
	}
	/**
	 * 得到前x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String lastXHour_yyyyMMddHHmmss(String yyyyMMddHHmmss , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(yyyyMMddHHmmss);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMddHHmmss(date) ;
	}

	
	/**
	 * 得到x小时前对应的日期(年月日时)
	 * @return
	 */
	public static String lastXHour_yyyy_MM_dd_HH(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd_HH(date) ;
	}
	/**
	 * 得到x小时前对应的日期(年月日时分)
	 * @return
	 */
	public static String lastXHour_yyyy_MM_dd_HH_mm(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd_HH_mm(date) ;
	}
	/**
	 * 得到x小时前对应的日期(年月日时分秒)
	 * @return
	 */
	public static String lastXHour_yyyy_MM_dd_HH_mm_ss(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd_HH_mm_ss(date) ;
	}
	/**
	 * 得到x小时前对应的日期(年月日时)
	 * @return
	 */
	public static String lastXHour_yyyyMMddHH(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMddHH(date) ;
	}
	/**
	 * 得到x小时前对应的日期(年月日时分)
	 * @return
	 */
	public static String lastXHour_yyyyMMddHHmm(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMddHHmm(date) ;
	}
	/**
	 * 得到x小时前对应的日期(年月日时分秒)
	 * @return
	 */
	public static String lastXHour_yyyyMMddHHmmss(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMddHHmmss(date) ;
	}

   //////////////////////////////////////////////////////////////////
	
	
	/**
	 * 得到将来x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String nextXHour_yyyy_MM_dd_HH(String yyyy_MM_dd_HH , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyy-MM-dd HH", Locale.US).parse(yyyy_MM_dd_HH);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd_HH(date) ;
	}
	/**
	 * 得到将来x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String nextXHour_yyyy_MM_dd_HH_mm(String yyyy_MM_dd_HH_mm , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).parse(yyyy_MM_dd_HH_mm);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd_HH_mm(date) ;
	}	/**
	 * 得到将来x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String nextXHour_yyyy_MM_dd_HH_mm_ss(String yyyy_MM_dd_HH_mm_ss , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(yyyy_MM_dd_HH_mm_ss);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd_HH_mm_ss(date) ;
	}
	/**
	 * 得到将来x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String nextXHour_yyyyMMddHH(String yyyyMMddHH , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMddHH", Locale.US).parse(yyyyMMddHH);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMddHH(date) ;
	}
	/**
	 * 得到将来x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String nextXHour_yyyyMMddHHmm(String yyyyMMddHHmm , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMddHHmm", Locale.US).parse(yyyyMMddHHmm);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMddHHmm(date) ;
	}	/**
	 * 得到将来x小时对应的日期
	 * @param ymdhm
	 * @return
	 */
	public static String nextXHour_yyyyMMddHHmmss(String yyyyMMddHHmmss , int xhour) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(yyyyMMddHHmmss);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMddHHmmss(date) ;
	}


	/**
	 * 得到x小时后对应的日期(年月日时)
	 * @return
	 */
	public static String nextXHour_yyyy_MM_dd_HH(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd_HH(date) ;
	}
	/**
	 * 得到x小时后对应的日期(年月日时分)
	 * @return
	 */
	public static String nextXHour_yyyy_MM_dd_HH_mm(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd_HH_mm(date) ;
	}
	/**
	 * 得到x小时后对应的日期(年月日时分秒)
	 * @return
	 */
	public static String nextXHour_yyyy_MM_dd_HH_mm_ss(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd_HH_mm_ss(date) ;
	}
	

	/**
	 * 得到x小时后对应的日期(年月日时)
	 * @return
	 */
	public static String nextXHour_yyyyMMddHH(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMddHH(date) ;
	}
	/**
	 * 得到x小时后对应的日期(年月日时分)
	 * @return
	 */
	public static String nextXHour_yyyyMMddHHmm(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMddHHmm(date) ;
	}
	/**
	 * 得到x小时后对应的日期(年月日时分秒)
	 * @return
	 */
	public static String nextXHour_yyyyMMddHHmmss(int xhour){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, xhour);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMddHHmmss(date) ;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////

	/**
	 * 得到过去x天日期
	 * @return
	 */
	public static String lastXDay_yyyy_MM_dd(String yyyy_MM_dd , int xday) throws Exception {
		Date d = new SimpleDateFormat("yyyy_MM_dd", Locale.US).parse(yyyy_MM_dd);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.DAY_OF_YEAR, -xday);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd(date) ;
	}
	/**
	 * 得到过去x天日期
	 * @return
	 */
	public static String lastXDay_yyyyMMdd(String yyyyMMdd , int xday) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMdd", Locale.US).parse(yyyyMMdd);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.DAY_OF_YEAR, -xday);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMdd(date) ;
	}
	/**
	 * 得到过去x天日期
	 * @return
	 */
	public static String lastXDay_yyyy_MM_dd(int xday){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -xday);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd(date) ;
	}
	/**
	 * 得到过去x天日期
	 * @return
	 */
	public static String lastXDay_yyyyMMdd(int xday){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -xday);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMdd(date) ;
	}

	
	////////////////////////////////////////////////////////////
	

	/**
	 * 得到将来x天日期
	 * @return
	 */
	public static String nextXDay_yyyy_MM_dd(String yyyy_MM_dd , int xday) throws Exception {
		Date d = new SimpleDateFormat("yyyy_MM_dd", Locale.US).parse(yyyy_MM_dd);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.DAY_OF_YEAR, xday);
		Date date = cal.getTime() ;
		return DateTime.yyyy_MM_dd(date) ;
	}
	/**
	 * 得到将来x天日期
	 * @return
	 */
	public static String nextXDay_yyyyMMdd(String yyyyMMdd , int xday) throws Exception {
		Date d = new SimpleDateFormat("yyyyMMdd", Locale.US).parse(yyyyMMdd);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(d);			
		cal.add(Calendar.DAY_OF_YEAR, xday);
		Date date = cal.getTime() ;
		return DateTime.yyyyMMdd(date) ;
	}
	/**
	 * 得到将来x天日期
	 * @return
	 */
	public static String nextXDay_yyyy_MM_dd(int xday){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, xday);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM_dd(date) ;
	}
	/**
	 * 得到将来x天日期
	 * @return
	 */
	public static String nextXDay_yyyyMMdd(int xday){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, xday);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyyMMdd(date) ;
	}

	
	////////////////////////////////////////////////////////////
	

	/**
	 * 得到昨天
	 * @return
	 */
	public static String yesterday_yyyy_MM_dd(int thisYear , int thisMonth , int thisDay){
		int yesterday = 0 ;
		int lastYear = 0 ;
		int lastMonth = 0 ;
		if(thisDay == 1){
			if(thisMonth == 1 || thisMonth == 2 || thisMonth == 4 || thisMonth == 6 || thisMonth == 8 || thisMonth == 9 || thisMonth == 11 ){
				yesterday = 31 ;
			}else if( thisMonth == 3){
				if(isLeapYear(thisYear)){
					yesterday = 29 ;
				}else{
					yesterday = 28 ;
				}
			}else {
				yesterday = 30 ;
			}
			
			if(thisMonth == 1){
				lastYear = thisYear - 1 ;
				lastMonth = 12 ;
			}else{
				lastYear = thisYear ;
				lastMonth = thisMonth - 1 ; 
			}
		}else{
			yesterday = thisDay - 1 ;
			lastMonth = thisMonth ; 
			lastYear = thisYear ;
		}
		return lastYear + "-" 
			+ (lastMonth > 9?(lastMonth + ""):("0" + lastMonth)) + "-" 
			+ (yesterday > 9?(yesterday + ""):("0" + yesterday)) ;
		
	}
	
	/**
	 * 得到明天
	 * @return
	 */
	public static String tomorrow_yyyy_MM_dd(int thisYear , int thisMonth , int thisDay){
		int tomorrow = 0 ;
		int year = 0 ;
		int month = 0 ;
		if(thisDay == 31){
			if(thisMonth == 1 || thisMonth == 3 || thisMonth == 5 || thisMonth == 7 || thisMonth == 8 || thisMonth == 10){
				year = thisYear ;
				month = thisMonth + 1 ;
				tomorrow = 1 ;
			}else if(thisMonth == 12){
				year = thisYear + 1 ;
				month = 1 ;
				tomorrow = 1 ;
			}else{
				//不存在这种情况
			}
		}else if(thisDay == 30){
			if(thisMonth == 4 || thisMonth == 6 || thisMonth == 9 || thisMonth == 11){
				year = thisYear ;
				month = thisMonth + 1 ;
				tomorrow = 1 ;
			}else{
				year = thisYear ;
				month = thisMonth ;
				tomorrow = 31 ;
			}
		}else if(thisDay == 29){
			if(thisMonth == 2){
				year = thisYear ;
				month = thisMonth + 1 ;
				tomorrow = 1 ;
			}else{
				year = thisYear ;
				month = thisMonth ;
				tomorrow = 30 ;
			}
		}else if(thisDay == 28){
			if(thisMonth == 2){
				if(!isLeapYear(thisYear)){
					year = thisYear ;
					month = thisMonth + 1 ;
					tomorrow = 1 ;
				}else{
					year = thisYear ;
					month = thisMonth ;
					tomorrow = 29 ;
				}
			}else{
				year = thisYear ;
				month = thisMonth ;
				tomorrow = 29 ;
			}
		}else{
			year = thisYear ;
			month = thisMonth ;
			tomorrow = thisDay + 1 ;
		}
		return year + "-" 
			+ (month > 9?(month + ""):("0" + month)) + "-" 
			+ (tomorrow > 9?(tomorrow + ""):("0" + tomorrow)) ;
	}
	
	
   ///////////////////////////////////////////////////
	
	/**
	 * 得到上月份
	 * @return
	 */
	public static String lastMonth_ym(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -((Integer.parseInt(dd()))));
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM(date) ;
	}
	/**
	 * 得到上月份
	 * @return
	 */
	public static String lastMonth_ym(int thisMonth){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		if(thisMonth == 2){
			cal.add(Calendar.DAY_OF_YEAR, - 30);
		}else{
			cal.add(Calendar.DAY_OF_YEAR, - 32);
		}
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM(date) ;
	}
	/**
	 * 得到上月份
	 * @return
	 */
	public static String lastMonth_ym(int year , int thisMonth){
		thisMonth = thisMonth - 1 ;
		if(thisMonth == 0){
			year = year - 1 ;
			thisMonth = 12 ;
		}
		return  ("" + year) + "-" + (thisMonth<10?("0"+thisMonth):(""+thisMonth)) ;
	}
	/**
	 * 得到上月份
	 * @return
	 */
	public static String lastMonth_ymd(int year , int thisMonth , int thisDate){
		thisMonth = thisMonth - 1 ;
		if(thisMonth == 0){
			year = year - 1 ;
			thisMonth = 12 ;
		}
		if(thisMonth == 2){
			if(isLeapYear(year)){
				if(thisDate > 29){
					thisDate = 29 ;
				}
			}else{
				if(thisDate > 28){
					thisDate = 28 ;
				}
			}
		}else if(thisMonth == 4 || thisMonth == 6 || thisMonth == 9 || thisMonth == 11){
			if(thisDate > 30){
				thisDate = 30 ;
			}
			
		}
		return  ("" + year) + "-" + (thisMonth<10?("0"+thisMonth):(""+thisMonth)) + "-" + (thisDate<10?("0"+thisDate):(""+thisDate)) ;
	}
	/**
	 * 得到上上月份
	 * @return
	 */
	public static String lastLastMonth_ym(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -((Integer.parseInt(dd())) + 32));
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy_MM(date) ;
	}
	/**
	 * 得到上年度
	 * @return
	 */
	public static String lastYear(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, - 365);
		date.setTime(cal.getTimeInMillis());			
		return DateTime.yyyy(date) ;
	}
	
	/**
	 * d1比d2日期更近返回1(d1>d2),相等返回0，更远返回-1(d1<d2)
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compareDateStrByChar(String d1 , String d2){
		int r = 0 ;
		if(d1 == null || d2 == null || d1.length() != d2.length()){
			return r ;
		}
		for(int i = 0 ; i < d1.length() ; i++){
			if(d1.charAt(i)>d2.charAt(i)){
				return 1 ;
			}else{
				if(d1.charAt(i)<d2.charAt(i)){
					return -1 ;
				}
			}
		}
		return r ;
	}
	
	/**
	 * 字符串型转变为整数
	 * @param str
	 * @return
	 */
	public static long dateTime_str2int(String str){
		if(str == null || str.trim().equals("")){
			return 0L ;
		}
		str = str.replaceAll("-", "") ;
		str = str.replaceAll(":", "") ;
		str = str.replaceAll(" ", "") ;
		return Long.parseLong(str) ;
	}
	

	public static String[] yearGroup1() {
		String years[] = null;
		int thisYear = Integer.parseInt((new SimpleDateFormat("yyyy", Locale.US))
				.format(System.currentTimeMillis()));
		int len = (thisYear - 2005) + 1;
		years = new String[len];
		for (int i = 0; i < len; i++)
			years[i] = "" + (thisYear - i);

		return years;
	}

	public static String[] yearGroup2() {
		String[] years = { "1900", "1901", "1902", "1903", "1904", "1905",
				"1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913",
				"1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921",
				"1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929",
				"1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937",
				"1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945",
				"1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953",
				"1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961",
				"1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
				"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977",
				"1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985",
				"1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993",
				"1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001",
				"2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
				"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029" };
		return years;
	}

	public static String[] monthGroup() {
		String[] month = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12" };
		return month;
	}

	public static String[] dateGroup() {
		String[] date = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		return date;
	}

	public static String[] timeGroup() {
		String[] time = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23" };
		return time;
	}
	

	/**
	 * 判断是否为润年
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return new GregorianCalendar().isLeapYear(year) ;
    }
	

	/**
	 * 两个日期比较(格式如 2008-09-09 00:00:00)
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean oneCompareTow( String one , String two){
		one = one.replaceAll("-", "") ;
		one = one.replaceAll(" ", "") ;
		one = one.replaceAll(":", "") ;
		two = two.replaceAll("-", "") ;
		two = two.replaceAll(" ", "") ;
		two = two.replaceAll(":", "") ;
		Long onel = Long.parseLong(one) ;
		Long twol = Long.parseLong(two) ;
		if(onel.longValue() >= twol.longValue()){
			return true ;
		}else{
			return false ;
		}
		
	}
	/**
	 * 将2009-02-12格式的日期分解为年 月 日字符串数组
	 * @param ymd
	 * @return
	 */
	public static String[] altYmd(String ymd){
		if(ymd == null || ymd.length() < 10){
			return null ;
		}
		String[] s = new String[3] ;
		s[0] = ymd.substring(0 , 4) ;
		s[1] = ymd.substring(5 , 7) ;
		if(s[1].charAt(0) == '0'){
			s[1] = s[1].substring(1 , s[1].length()) ;
		}
		s[2] = ymd.substring(8,10) ;
		if(s[2].charAt(0) == '0'){
			s[2] = s[2].substring(1 , s[2].length()) ;
		}
		return s ;
	}
	/**
	 * 将2009-02-12格式的日期分解为年 月 日字符串数组
	 * @param ymd
	 * @return
	 */
	public static int[] altYmdhms(String ymdhms) throws Exception{
		if(ymdhms == null || ymdhms.length() != 19){
			throw new Exception("上期格式不正确，正确的格式为 yyyy-MM-dd hh:mm:ss") ;
		}
		String[] sg1 = ymdhms.split(" ") ;
		String[] sg1_1 = sg1[0].split("-") ;
		String[] sg1_2 = sg1[1].split(":") ;
		
		int[] ig = new int[6] ;
		ig[0] = Integer.parseInt(sg1_1[0]) ;
		ig[1] = Integer.parseInt(sg1_1[1]) ;
		ig[2] = Integer.parseInt(sg1_1[2]) ;

		ig[3] = Integer.parseInt(sg1_2[0]) ;
		ig[4] = Integer.parseInt(sg1_2[1]) ;
		ig[5] = Integer.parseInt(sg1_2[2]) ;
		
		return ig ;
	}
	

	public static String getWeek(int wk) {
		if (wk == 1) {
			return "日";
		} else if (wk == 2) {
			return "一";
		} else if (wk == 3) {
			return "二";
		} else if (wk == 4) {
			return "三";
		} else if (wk == 5) {
			return "四";
		} else if (wk == 6) {
			return "五";
		} else if (wk == 7) {
			return "六";
		}
		return "";
	}


	public static String dateGroupTo_yyyy_MM_dd_HH_mm_ss(int[] yymdhms) {
		if (yymdhms[0] > 2000) {
			return yymdhms[0] + "-"
					+ (yymdhms[1] < 10 ? ("0" + yymdhms[1]) : yymdhms[1]) + "-"
					+ (yymdhms[2] < 10 ? ("0" + yymdhms[2]) : yymdhms[2]) + " "
					+ (yymdhms[3] < 10 ? ("0" + yymdhms[3]) : yymdhms[3]) + ":"
					+ (yymdhms[4] < 10 ? ("0" + yymdhms[4]) : yymdhms[4]) + ":"
					+ (yymdhms[5] < 10 ? ("0" + yymdhms[5]) : yymdhms[5]);
		} else {
			return Integer.parseInt(yyyy()) / 100 + yymdhms[0] + "-"
					+ (yymdhms[1] < 10 ? ("0" + yymdhms[1]) : yymdhms[1]) + "-"
					+ (yymdhms[2] < 10 ? ("0" + yymdhms[2]) : yymdhms[2]) + " "
					+ (yymdhms[3] < 10 ? ("0" + yymdhms[3]) : yymdhms[3]) + ":"
					+ (yymdhms[4] < 10 ? ("0" + yymdhms[4]) : yymdhms[4]) + ":"
					+ (yymdhms[5] < 10 ? ("0" + yymdhms[5]) : yymdhms[5]);

		}
	}

	public static String dateGroupTo_yyyy_MM_dd_HH_mm_ss(Integer[] yymdhms) {
		if (yymdhms[0] > 2000) {
			return yymdhms[0] + "-"
					+ (yymdhms[1] < 10 ? ("0" + yymdhms[1]) : yymdhms[1]) + "-"
					+ (yymdhms[2] < 10 ? ("0" + yymdhms[2]) : yymdhms[2]) + " "
					+ (yymdhms[3] < 10 ? ("0" + yymdhms[3]) : yymdhms[3]) + ":"
					+ (yymdhms[4] < 10 ? ("0" + yymdhms[4]) : yymdhms[4]) + ":"
					+ (yymdhms[5] < 10 ? ("0" + yymdhms[5]) : yymdhms[5]);
		} else {
			return Integer.parseInt(yyyy()) / 100 + yymdhms[0] + "-"
					+ (yymdhms[1] < 10 ? ("0" + yymdhms[1]) : yymdhms[1]) + "-"
					+ (yymdhms[2] < 10 ? ("0" + yymdhms[2]) : yymdhms[2]) + " "
					+ (yymdhms[3] < 10 ? ("0" + yymdhms[3]) : yymdhms[3]) + ":"
					+ (yymdhms[4] < 10 ? ("0" + yymdhms[4]) : yymdhms[4]) + ":"
					+ (yymdhms[5] < 10 ? ("0" + yymdhms[5]) : yymdhms[5]);

		}
	}
	
	/**
	 * 得到从今天起往前一个月的日期列表
	 * 要求不能存在两个以上月的日期（如上月是二月，今天是3月1日）
	 * 不包括当天日期及上月份与当前日相同的日期
	 * @return
	 */
	public static ArrayList<MonthDateVO> createOneMonthDate(){
		ArrayList<MonthDateVO> list = new ArrayList<MonthDateVO>() ;

		int thisTotal = 0 ;
		int beforTotal = 0 ;
		int year = Integer.parseInt(yyyy()) ;
		int month = Integer.parseInt(MM()) ;
		int date = Integer.parseInt(dd()) ;
		
		int beforeYear = year ;
		int beforeMonth = month - 1 ;
		int beforeDate = 31 ;
		thisTotal = date ;
		beforTotal = 31 - thisTotal ;
		if(month == 1){
			beforeYear = year - 1 ;
			beforeMonth = 12 ;
			beforeDate = 31 ;
		}
		if(month == 3){
			beforeMonth = 2 ;
			if(isLeapYear(year)){
				beforeDate = 29 ;
				if(beforTotal > 29){
					beforTotal = 29 ;
				}
			}else{
				beforeDate = 28 ;
				if(beforTotal > 28){
					beforTotal = 28 ;
				}
			}
			
		}
		switch(month){
			case 2 : { beforeMonth = 1 ; beforeDate = 31 ; break ;}
			case 4 : { beforeMonth = 3 ; beforeDate = 31 ; break ;}
			case 5 : { beforeMonth = 4 ; beforeDate = 30 ; break ;}
			case 6 : { beforeMonth = 5 ; beforeDate = 31 ; break ;}
			case 7 : { beforeMonth = 6 ; beforeDate = 30 ; break ;}
			case 8 : { beforeMonth = 7 ; beforeDate = 31 ; break ;}
			case 9 : { beforeMonth = 8 ; beforeDate = 31 ; break ;}
			case 10 : { beforeMonth = 9 ; beforeDate = 30 ; break ;}
			case 11 : { beforeMonth = 10 ; beforeDate = 31 ; break ;}
			case 12 : { beforeMonth = 11 ; beforeDate = 30 ; break ;}
		}
		int n = 0 ;
		DateTime dt = new DateTime() ;
		for(int i = thisTotal ; i > 0 ; i--){
			MonthDateVO vo = dt.new MonthDateVO() ;
			vo.setDate(year + "-" + month + "-" + (date - n)) ;
			vo.setIndex(date - n + "") ;
			if(date - n != date){
				list.add(vo) ;
			}
			n++ ;
		}
		n = 0 ;
		for(int i = beforTotal ; i > 0 ; i--){
			MonthDateVO vo = dt.new MonthDateVO() ;
			vo.setDate(beforeYear + "-" + beforeMonth + "-" + (beforeDate - n)) ;
			vo.setIndex(beforeDate - n + "") ;
			if(beforeDate - n != date){
				list.add(vo) ;
			}
			n++ ;
		}
		return list ;
	}
		
	public class MonthDateVO {

		public String date ;
		public String index ;
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getIndex() {
			return index;
		}
		public void setIndex(String index) {
			this.index = index;
		}

	}

}
