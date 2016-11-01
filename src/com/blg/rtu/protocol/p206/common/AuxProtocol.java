package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.util.ByteUtil;

import com.blg.rtu.util.DateTime;

/**
 * 用户数据域中附加数据(密码、时标)
 *
 */
public class AuxProtocol {
	
	/**
	 * 分析RTU数据中的密码及密码
	 * @param b
	 * @param site_password
	 * @return  
	 */
	public String parsePassword(byte[] b , int site_password) throws Exception{
		
		return ByteUtil.bytes2Hex_an(b, true, site_password, 2) ;

//////////////////////////////////////////////////////////		
//		String key = ByteUtil.BCD2String(b , site_password , 1) ;
//		String pass = ByteUtil.BCD2String(b , site_password + 1 , 1) ;
//		
//		if(key.length() > 1){
//			key = key.substring(0,1) ;
//			pass = key.substring(1,2) +  pass ;
//		}else{
//			pass = key +  pass ;
//			key = "0" ;
//		}
//		return new int[]{Integer.parseInt(key) , Integer.parseInt(pass)} ;
	}
	
	/**
	 * 构造RTU命令中的密码及密码
	 * @param b
	 * @param site_password
	 * @param passwordHex
	 * @return
	 * @throws Exception
	 */
	public byte[] createPassword(byte[] b , int site_password , String passwordHex) throws Exception{
		if(passwordHex == null){
			throw new Exception("出错！RTU密码为空!") ;
		}
//		if(password > 9999 || password < 0){
//			throw new Exception("RTU密码(" + password + ")不正确，其取值范围是0-9999!") ;
//		}
		
		
		//根据奥特美克王书超说明，密码实现与水利部206协议定义不一样，与功能码96实现一样
		int index = site_password ; 
		if(passwordHex != null){
			byte[] bs = ByteUtil.hex2Bytes(passwordHex) ;
			if(bs.length == 1){
				b[index++] = bs[0] ;
				b[index++] =  0 ;
			}else if(bs.length == 2){
				b[index++] = bs[1] ;
				b[index++] = bs[0] ;
			}
		}
////////////////////////////////////////////////////////////		
//		byte[] bcd = ByteUtil.int2BCD_an(password.intValue()) ;
//		if(bcd.length == 1){
//			b[index++] = bcd[0] ;
//			b[index++] =  0 ;
//		}else if(bcd.length == 2){
//			b[index++] = bcd[0] ;
//			b[index++] = bcd[1] ;
//		}
////////////////////////////////////////////////////////////
//		if(password > 9 || password < 0){
//			throw new Exception("RTU密码(" + password + ")不正确，其取值范围是0-9999!") ;
//		}
//		String key = password.toString() ;
//		byte[] bkey = ByteUtil.string2BCD(key) ;
//
//		byte pass = Constant.Password_Default ;
//		
//		b[site_password] = bkey[0] ;
//		b[site_password + 1] = pass ;

		return b ;
	}
	/**
	 * 分析RTU数据中的时间标签
	 * @param b
	 * @param site_password
	 * @return Object[]{String:时间(格式例如 09 10:01:00) , int:delay}
	 */
	public String parseTime(byte[] b , int site_time) throws Exception{
//		int date = ByteUtil.BCD2Int_an(b, site_time, site_time) ;
//		int hour = ByteUtil.BCD2Int_an(b, site_time + 1, site_time + 1) ;
//		int minute = ByteUtil.BCD2Int_an(b, site_time + 2, site_time + 2) ;
//		int second = ByteUtil.BCD2Int_an(b, site_time + 3, site_time + 3) ;
//		int delay = ByteUtil.BCD2Int_an(b, site_time + 4, site_time + 4) ;
		int second = ByteUtil.BCD2Int_an(b, site_time, site_time) ;
		int minute = ByteUtil.BCD2Int_an(b, site_time + 1, site_time + 1) ;
		int hour = ByteUtil.BCD2Int_an(b, site_time + 2, site_time + 2) ;
		int date = ByteUtil.BCD2Int_an(b, site_time + 3, site_time + 3) ;
		
		return "" + (date < 10?("0" + date):date)  
	 			  + " "
				  + (hour < 10?("0" + hour):hour) + ":"
				  + (minute < 10?("0" + minute):minute) + ":"
				  + (second < 10?("0" + second):second) ;
	}
	
	/**
	 * 构造RTU命令中的密码及密码
	 * @param b
	 * @param site_password
	 * @param p_key_value
	 * @return
	 * @throws Exception
	 */
	public byte[] createTime(byte[] b , int site_time) throws Exception{
//		b[site_time] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.dd()))[0] ;
//		b[site_time + 1] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.HH()))[0] ;
//		b[site_time + 2] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.mm()))[0] ;
//		b[site_time + 3] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.ss()))[0] ;
		b[site_time] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.ss()))[0] ;
		b[site_time + 1] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.mm()))[0] ;
		b[site_time + 2] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.HH()))[0] ;
		b[site_time + 3] = ByteUtil.int2BCD_an(Integer.parseInt(DateTime.dd()))[0] ;
		
		return b ;
	}

}
