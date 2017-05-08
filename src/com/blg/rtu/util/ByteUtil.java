package com.blg.rtu.util;

import android.annotation.SuppressLint;
import java.util.Locale;


public class ByteUtil {
	/**
	 * 字节转存二进制
	 * 
	 * @param b byte
	 * @throws Exception
	 * @return String
	 */
	public String byte2Binary(byte b) throws Exception {
		int n = (b + 256) % 256 + 256;
		try {
			return Integer.toBinaryString(n).substring(1);
		} catch (Exception e) {
			throw new Exception("字节转换成二进制的字符串出错！", null);
		}
	}
	/**
	 * 字节转存8位二进制
	 * 
	 * @param b
	 *            byte
	 * @throws Exception
	 * @return String
	 */
	public String byte2bit8Binary(byte b) throws Exception {
		String s = this.byte2Binary(b);
		int len = s.length();
		for (int i = 0; i < 8 - len; i++) {
			s = "0" + s;
		}
		return s;
	}

	/**
	 * double转换byte
	 * 
	 * @param bs byte[]
	 * @param value double double类型的参数
	 * @param from int
	 */
	public static void double2Bytes(byte[] bs, double value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 8);
		if (b) {
			Long l = Double.doubleToLongBits(value);
			long2Bytes(bs, l, from);
		} else {
			throw new Exception("double2Bytes时数组越界");
		}
	}

	/**
	 * double转换byte，字节顺序是倒的
	 * 
	 * @param bs byte[]
	 * @param value double double类型的参数
	 * @param from int
	 */
	public static void double2Bytes_an(byte[] bs, double value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 8);
		if (b) {
			Long l = Double.doubleToLongBits(value);
			long2Bytes_an(bs, l, from);
		} else {
			throw new Exception("double2Bytes时数组越界");
		}
	}

	/**
	 * byte转换double
	 * 
	 * @param bs byte[]
	 * @param from int
	 */
	public static double bytes2Double(byte[] bs, int from) throws Exception {
		long l = bytes2Long(bs, from);
		return Double.longBitsToDouble(l);
	}

	/**
	 * byte转换double，字节顺序是倒的
	 * 
	 * @param bs byte[]
	 * @param from int
	 */
	public static double bytes2Double_an(byte[] bs, int from) throws Exception {
		long l = bytes2Long_an(bs, from);
		return Double.longBitsToDouble(l);
	}

	/**
	 * float转换byte
	 * 
	 * @value bs byte[]
	 * @value value float float类型的参数
	 * @value from int
	 */
	public static void float2Bytes(byte[] bs, float value, int from)
			throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			Integer it = Float.floatToIntBits(value);
			int2Bytes(bs, it, from);
		} else {
			throw new Exception("float2Bytes时数组越界");
		}
	}

	/**
	 * float转换byte，字节顺序是倒的
	 * 
	 * @value bs byte[]
	 * @value value float float类型的参数
	 * @value from int
	 */
	public static void float2Bytes_an(byte[] bs, float value, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			Integer it = Float.floatToIntBits(value);
			int2Bytes_an(bs, it, from);
		} else {
			throw new Exception("float2Bytes时数组越界");
		}
	}

	/**
	 * byte转换float
	 * 
	 * @value bs byte[]
	 * @value from int
	 */
	public static float bytes2Float(byte[] bs, int from) throws Exception {
		int i = bytes2Int(bs, from);
		return Float.intBitsToFloat(i);
	}

	/**
	 * byte转换float，字节顺序是倒的
	 * 
	 * @value bs byte[]
	 * @value from int
	 */
	public static float bytes2Float_an(byte[] bs, int from) throws Exception {
		int i = bytes2Int_an(bs, from);
		return Float.intBitsToFloat(i);
	}


	/**
	 * 转换long型为byte数组
	 * 
	 * @value bs byte[]
	 * @value value long
	 * @value from int
	 */
	public static void long2Bytes(byte[] bs, long value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 8);
		if (b) {
			for (int i = 7; i >= 0; i--) {
				bs[from + i] = Long.valueOf(value & 0xff).byteValue();// 将最低位保存在最低位
				value = value >> 8; // 向右移8位
			}
		} else {
			throw new Exception("long2Bytes时数组越界");
		}
	}

	/**
	 * 转换long型为byte数组，字节顺序是倒的
	 * 
	 * @value bs byte[]
	 * @value value long
	 * @value from int
	 */
	public static void long2Bytes_an(byte[] bs, long value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 8);
		if (b) {
			for (int i = 0; i < 8; i++) {
				bs[from + i] = Long.valueOf(value & 0xff).byteValue();// 将最低位保存在最低位
				value = value >> 8; // 向右移8位
			}
		} else {
			throw new Exception("long2Bytes时数组越界");
		}
	}

	/**
	 * 8位字节数组转换为长整型
	 * 
	 * @param bs byte[]
	 * @param from int
	 * @return
	 */
	public static long bytes2Long(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 8);
		if (b) {
			long s = 0;
			long s0 = bs[from + 0] & 0xff ;//后面 & 0xFF不能去除，经实验，去了，负数就解析不正确了
			long s1 = bs[from + 1] & 0xff ;
			long s2 = bs[from + 2] & 0xff ;
			long s3 = bs[from + 3] & 0xff ;
			long s4 = bs[from + 4] & 0xff ;
			long s5 = bs[from + 5] & 0xff ;
			long s6 = bs[from + 6] & 0xff ;
			long s7 = bs[from + 7] & 0xff ;

			// s7不变
			s6 <<= 8;
			s5 <<= 16;
			s4 <<= 24;
			s3 <<= 8 * 4;
			s2 <<= 8 * 5;
			s1 <<= 8 * 6;
			s0 <<= 8 * 7;
			s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
			return s;
		} else {
			throw new Exception("byte2Long时数组越界");
		}
	}

	/**
	 * 8位字节数组转换为长整型，字节顺序是倒的
	 * 
	 * @param bs byte[]
	 * @param from int
	 * @return
	 */
	public static long bytes2Long_an(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 8);
		if (b) {
			long s = 0;
			long s0 = bs[from + 0] & 0xff ;//后面 & 0xFF不能去除，经实验，去了，负数就解析不正确了
			long s1 = bs[from + 1] & 0xff ;
			long s2 = bs[from + 2] & 0xff ;
			long s3 = bs[from + 3] & 0xff ;
			long s4 = bs[from + 4] & 0xff ;
			long s5 = bs[from + 5] & 0xff ;
			long s6 = bs[from + 6] & 0xff ;
			long s7 = bs[from + 7] & 0xff ;

			// s0不变
			s1 <<= 8;
			s2 <<= 16;
			s3 <<= 24;
			s4 <<= 8 * 4;
			s5 <<= 8 * 5;
			s6 <<= 8 * 6;
			s7 <<= 8 * 7;
			s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
			return s;
		} else {
			throw new Exception("byte2Long时数组越界");
		}
	}

	/**
	 * int类型转换成4位byte数组
	 * 
	 * @value bs byte[]
	 * @value value int int类型的参数
	 * @value from int
	 */
	public static void int2Bytes(byte[] bs, int value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			for (int i = 3; i >= 0; i--) {
				bs[from + i] = Integer.valueOf(value & 0xff).byteValue();// 将最低位保存在高字节
				value = value >> 8; // 向右移8位
			}
		} else {
			throw new Exception("int2Bytes时数组越界");
		}
	}

	/**
	 * int类型转换成4位byte数组，字节顺序是倒的
	 * 
	 * @value bs byte[]
	 * @value value int int类型的参数
	 * @value from int
	 */
	public static void int2Bytes_an(byte[] bs, int value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			for (int i = 0; i < 4; i++) {
				bs[from + i] = Integer.valueOf(value & 0xff).byteValue();// 将最低位保存在低字节
				value = value >> 8; // 向右移8位
			}
		} else {
			throw new Exception("int2Bytes时数组越界");
		}
	}

	/**
	 * 4位字节数组转换为整型
	 * 
	 * @param b
	 * @return
	 */
	public static int bytes2Int(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			int s = 0;
			int s0 = bs[from + 0] & 0xff ;//后面 & 0xFF不能去除，经实验，去了，负数就解析不正确了
			int s1 = bs[from + 1] & 0xff ;
			int s2 = bs[from + 2] & 0xff ;
			int s3 = bs[from + 3] & 0xff ;

			// s3不变
			s2 <<= 8;
			s1 <<= 16;
			s0 <<= 24;
			s = s0 | s1 | s2 | s3;
			return s;
		} else {
			throw new Exception("byte2Int时数组越界");
		}
	}
	

	/**
	 * 4位字节数组转换为整型，字节顺序是倒的
	 * 
	 * @param b
	 * @return
	 */
	public static int bytes2Int_an(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			int s = 0;
			int s0 = bs[from + 0] & 0xff ;//后面 & 0xFF不能去除，经实验，去了，负数就解析不正确了
			int s1 = bs[from + 1] & 0xff ;
			int s2 = bs[from + 2] & 0xff ;
			int s3 = bs[from + 3] & 0xff ;

			// s0不变
			s1 <<= 8;
			s2 <<= 16;
			s3 <<= 24;
			s = s0 | s1 | s2 | s3;
			return s;
		} else {
			throw new Exception("byte2Int时数组越界");
		}
	}
	


	/**
	 * short类型转换成byte数组
	 * 
	 * @value bs byte[]
	 * @value value short
	 * @value from int
	 */
	public static void short2Bytes(byte[] bs, short value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			for (int i = 1; i >= 0 ; i--) {
				bs[from + i] = Integer.valueOf(value & 0xff).byteValue();// 将低位保存在高字节
				value = (short) (value >> 8); // 向右移8位
			}
		} else {
			throw new Exception("short2Bytes时数组越界");
		}
	}
	

	/**
	 * short类型转换成byte数组，字节顺序是倒的
	 * 
	 * @value bs byte[]
	 * @value value short
	 * @value from int
	 */
	public static void short2Bytes_an(byte[] bs, short value, int from)throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			for (int i = 0; i < 2; i++) {
				bs[from + i] = Integer.valueOf(value & 0xff).byteValue();// 将最低位保存在低字节
				value = (short) (value >> 8); // 向右移8位
			}
		} else {
			throw new Exception("short2Bytes时数组越界");
		}
	}

	/**
	 * short类型转换成byte数组
	 * 
	 * @value value short
	 * @value from int
	 */
	public static byte[] short2Bytes(short value)throws Exception {
		byte[] bs = new byte[2] ;
		for (int i = 1; i >= 0 ; i--) {
			bs[i] = (byte)(value & 0xff) ;// 将低位保存在高字节
			value = (short) (value >> 8); // 向右移8位
		}
		return bs ;
	}

	/**
	 * short类型转换成byte数组，字节顺序是倒的
	 * 
	 * @value value short
	 * @value from int
	 */
	public static byte[] short2Bytes_an(short value)throws Exception {
		byte[] bs = new byte[2] ;
		for (int i = 0; i < 2; i++) {
			bs[i] = (byte)(value & 0xff) ;// 将最低位保存在低字节
			value = (short) (value >> 8); // 向右移8位
		}
		return bs ;
	}

	/**
	 * 2位字节数组转换为短整型
	 * 
	 * @param b
	 * @return
	 */
	public static short bytes2Short(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			int s = 0;
			int s0 = bs[from + 0] & 0xff ; 
			int s1 = bs[from + 1] & 0xff ;

			// s1不变
			s0 <<= 8;
			s = s0 | s1;
			return (short) s;

		} else {
			throw new Exception("byte2Short时数组越界");
		}
	}

	/**
	 * 2位字节数组转换为短整型，字节顺序是倒的
	 * 
	 * @param b
	 * @return
	 */
	public static short bytes2Short_an(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			int s = 0;
			int s0 = bs[from + 0] & 0xff ; 
			int s1 = bs[from + 1] & 0xff ;

			// s0不变
			s1 <<= 8;
			s = s0 | s1;
			return (short) s;

		} else {
			throw new Exception("byte2Short时数组越界");
		}
	}
	/**
	 * 字符到一字节转换
	 * 
	 * @value bs byte[]
	 * @value ch char char类型的参数
	 * @value index int
	 * @return
	 */
	public static void char2Bytes(byte[] bs, char ch, int index)throws Exception {
		boolean b = isOutOfArrLength(bs.length, index);
		if (b) {
			bs[index] = (byte) ch;
		} else {
			throw new Exception("char2Bytes时数组越界");
		}
	}

	/**
	 * 一字节转换为字符
	 * 
	 * @param b
	 * @value index int
	 * @return
	 */
	public static char bytes2Char(byte[] bs, int index) throws Exception {
		boolean b = isOutOfArrLength(bs.length, index);
		if (b) {
			return (char) bs[index];
		} else {
			throw new Exception("byte2Char时数组越界");
		}
	}

	/**
	 * 字符串型数字转成byte
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static byte string2byte(String s) throws Exception {
		int n = 0;
		try {
			n = Integer.parseInt(s);
		} catch (Exception e) {
			throw new Exception("字符串型数字字节时出错，不是合法数字:" + s, null);
		}
		return (byte) n;
	}

	/**
	 * 字符串转换成byte数组
	 * 
	 * @value bs byte[]
	 * @value str String
	 * @value from int
	 * @return
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static int string2Bytes(byte[] bs, String str, int from)throws Exception {
		byte[] bb = str.getBytes("GBK");
		boolean b = isOutOfArrLength(bs.length, from + bb.length);
		if (b) {
			for (int i = 0; i < bb.length; i++) {
				bs[from + i] = bb[i];
			}
		} else {
			throw new Exception("string2Bytes时数组越界");
		}
		return bb.length ;
	}

	/**
	 * 字符串转换成byte数组
	 * 
	 * @value bs byte[]
	 * @value str String
	 * @value from int
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static String bytes2String(byte[] bs, int from, int end)throws Exception {
		byte[] bb = new byte[end - from + 1];
		for (int i = from; i <= end; i++) {
			bb[i] = bs[i];
		}
		return new String(bb);
	}

	/**
	 * 判断数组下标是否越界
	 * 
	 * @value bsLength 数组总长度
	 * @value toSite 数组偏移量
	 * @return
	 */
	private static boolean isOutOfArrLength(int bsLength, int toSite) {
		if (bsLength > toSite) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * 字节数组转换成十六进制的字符串 
	 * 
	 * @param b byte[]
	 * @param hasBlank 16进制是否用空格分隔
	 * @return String
	 */
	public static String bytes2Hex(byte[] src, boolean hasBlank){  
	    StringBuilder stringBuilder = new StringBuilder("");  
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }  
	    for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String str = Integer.toHexString(v);  
	        if (str.length() < 2) {  
	        	str = "0" + str;
	        }  
			if (hasBlank) {
				if (i == 0) {
					stringBuilder.append(str);  
				} else {
					stringBuilder.append(" " + str);  
				}
			} else {
				stringBuilder.append(str); 
			}
	    }  
	    return stringBuilder.toString().toUpperCase(Locale.US);
	}  
	/**
	 * 字节数组转换成十六进制的字符串 
	 * 
	 * @param b byte[]
	 * @param hasBlank 16进制是否用空格分隔
	 * @return String
	 */
	public static String bytes2Hex_an(byte[] src, boolean hasBlank){  
	    StringBuilder stringBuilder = new StringBuilder("");  
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }  
	    for (int i = src.length - 1; i >= 0 ; i--) {  
	        int v = src[i] & 0xFF;  
	        String str = Integer.toHexString(v);  
	        if (str.length() < 2) {  
	        	str = "0" + str;
	        }  
			if (hasBlank) {
				if (i == src.length - 1) {
					stringBuilder.append(str);  
				} else {
					stringBuilder.append(" " + str);  
				}
			} else {
				stringBuilder.append(str); 
			}
	    }  
	    return stringBuilder.toString().toUpperCase(Locale.US);
	}  
	/**
	 * 字节数组转换成十六进制的字符串 
	 * 
	 * @param b byte[]
	 * @param hasBlank 16进制是否用空格分隔
	 * @param from  
	 * @param len 
	 * @return String
	 */
	public static String bytes2Hex(byte[] src, boolean hasBlank, int from, int len){  
	    if (src == null || src.length <= 0 || src.length < from + len) {  
	        return null;  
	    }  
		byte[] bb = new byte[len];
		for (int i = 0 ; i < len; i++) {
			bb[i] = src[from + i];
		}
	    return bytes2Hex(bb, hasBlank) ;
	}  
	/**
	 * 字节数组转换成十六进制的字符串 
	 * 
	 * @param b byte[]
	 * @param hasBlank 16进制是否用空格分隔
	 * @param from  
	 * @param len 
	 * @return String
	 */
	public static String bytes2Hex_an(byte[] src, boolean hasBlank, int from, int len){  
	    if (src == null || src.length <= 0 || src.length < from + len) {  
	        return null;  
	    }  
		byte[] bb = new byte[len];
		for (int i = 0 ; i < len; i++) {
			bb[i] = src[from + i];
		}
	    return bytes2Hex_an(bb, hasBlank) ;
	}  
	/** 
	 * 十六进制转字节数组
	 * @param hexString the hex string 
	 * @return byte[] 
	 */  
	@SuppressLint("DefaultLocale")
	public static byte[] hex2Bytes(String src) throws Exception {  
	    if (src == null || src.equals("")) {  
	        return null;  
	    }  
	    src = src.toUpperCase(Locale.ENGLISH);  
	    int length = src.length() / 2;  
	    char[] hexChars = src.toCharArray();  
	    byte[] d = new byte[length];  
	    for (int i = 0; i < length; i++) {  
	        int pos = i * 2;  
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
	    }  
	    return d;  
	}  

	/**
	 * Convert char to byte
	 * @param c char
	 * @return byte
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}	 
	 

	/**
	 * 整形转成BCD编码
	 * 
	 * @param l
	 * @return
	 */
	public static byte[] int2BCD(int i) {
		String str = "" + i;
		byte[] b = null;
		if (str.length() % 2 == 0) {
			b = new byte[str.length() / 2];
		} else {
			b = new byte[(str.length() / 2) + 1];
		}
		encodeBCD(str, b, 0, b.length);

		return b;
	}
	/**
	 * 整形转成BCD编码，字节顺序是倒的
	 * 
	 * @param l
	 * @return
	 */
	public static byte[] int2BCD_an(int i) {
		String str = "" + i;
		byte[] b = null;
		if (str.length() % 2 == 0) {
			b = new byte[str.length() / 2];
		} else {
			b = new byte[(str.length() / 2) + 1];
		}
		encodeBCD_an(str, b, 0, b.length);

		return b;
	}

	/**
	 * 长整形转成BCD编码
	 * 
	 * @param l
	 * @return
	 */
	public static byte[] long2BCD(long l) {
		String str = "" + l;
		byte[] b = null;
		if (str.length() % 2 == 0) {
			b = new byte[str.length() / 2];
		} else {
			b = new byte[(str.length() / 2) + 1];
		}
		encodeBCD(str, b, 0, b.length);

		return b;
	}

	/**
	 * 长整形转成BCD编码，字节顺序是倒的
	 * 
	 * @param l
	 * @return
	 */
	public static byte[] long2BCD_an(long l) {
		String str = "" + l;
		byte[] b = null;
		if (str.length() % 2 == 0) {
			b = new byte[str.length() / 2];
		} else {
			b = new byte[(str.length() / 2) + 1];
		}
		encodeBCD_an(str, b, 0, b.length);

		return b;
	}

	/**
	 * 字符串型数字转成BCD编码
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static byte[] string2BCD(String s) throws Exception {
		if (!NumUtil.isPlusIntNumber(s)) {
			throw new Exception("字符串型数字转成BCD编码时出错，不是合法数字:" + s, null);
		}
		long l = 0l;
		try {
			l = Long.parseLong(s);
		} catch (Exception e) {
			throw new Exception("字符串型数字转成BCD编码时出错，不是合法数字:" + s, null);
		}
		return long2BCD(l);
	}

	/**
	 * 字符串型数字转成BCD编码，字节顺序是倒的
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static byte[] string2BCD_an(String s) throws Exception {
		if (!NumUtil.isPlusIntNumber(s)) {
			throw new Exception("字符串型数字转成BCD编码时出错，不是合法数字:" + s, null);
		}
		long l = 0l;
		try {
			l = Long.parseLong(s);
		} catch (Exception e) {
			throw new Exception("字符串型数字转成BCD编码时出错，不是合法数字:" + s, null);
		}
		return long2BCD_an(l);
	}

	/**
	 * BCD编码转成整型
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static int BCD2Int(byte b) throws Exception {
		String str = "";
		str = decodeBCD(new byte[] { b }, 0, 1);
		int n = 0;
		try {
			n = Integer.parseInt(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}

	/**
	 * BCD编码转成整型，字节顺序是倒的
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static int BCD2Int_an(byte b) throws Exception {
		String str = "";
		str = decodeBCD_an(new byte[] { b }, 0, 1);
		int n = 0;
		try {
			n = Integer.parseInt(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}

	/**
	 * BCD编码转成整型
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static int BCD2Int(byte[] b, int startIndex, int endIndex)throws Exception {
		String str = "";
		str = decodeBCD(b, startIndex, endIndex - startIndex + 1);
		int n = 0;
		try {
			n = Integer.parseInt(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}

	/**
	 * BCD编码转成整型，字节顺序是倒的
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static int BCD2Int_an(byte[] b, int startIndex, int endIndex)throws Exception {
		String str = "";
		str = decodeBCD_an(b, startIndex, endIndex - startIndex + 1);
		int n = 0;
		try {
			n = Integer.parseInt(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}

	/**
	 * BCD编码转成字符串型
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static long BCD2Long(byte[] b, int startIndex, int endIndex)throws Exception {
		String str = "";
		str = decodeBCD(b, startIndex, endIndex - startIndex + 1);
		long n = 0;
		try {
			n = Long.parseLong(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}


	/**
	 * BCD编码转成字符串型，字节顺序是倒的
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static long BCD2Long_an(byte[] b, int startIndex, int endIndex)throws Exception {
		String str = "";
		str = decodeBCD_an(b, startIndex, endIndex - startIndex + 1);
		long n = 0;
		try {
			n = Long.parseLong(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}
	
	public static double BCD2Double_an(byte[] b, int startIndex, int endIndex)throws Exception {
		String str = "";
		str = decodeBCD_an(b, startIndex, endIndex - startIndex + 1);
		double n = 0;
		try {
			n = Double.parseDouble(str);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), null);
		}
		return n;
	}

	/**
	 * BCD编码转成字符串型
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static String BCD2String(byte[] b, int startIndex, int endIndex) throws Exception {
		return decodeBCD(b, startIndex, endIndex - startIndex + 1);
	}

	/**
	 * BCD编码转成字符串型，字节顺序是倒的
	 * 
	 * @param b
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public static String BCD2String_an(byte[] b, int startIndex, int endIndex) throws Exception {
		return decodeBCD_an(b, startIndex, endIndex - startIndex + 1);
	}

	/**
	 * 编码BCD，例如1387编码成  13  87，顺序是正的 
	 * @param value
	 * @param dest
	 * @param startIndex
	 * @param length
	 */
	private static void encodeBCD(String value, byte[] dest, int startIndex, int length) {
		if (value == null || !value.matches("\\d*")) {
			throw new java.lang.IllegalArgumentException();
		}
		int[] tmpInts = new int[2 * length];
		int index = value.length() - 1;
		for (int i = tmpInts.length - 1; i >= 0 && index >= 0; i--, index--) {
			tmpInts[i] = value.charAt(index) - '0';
		}
		for (int i = startIndex, j = 0; i < startIndex + length; i++, j++) {
			dest[i] = (byte) (tmpInts[2 * j] * 16 + tmpInts[2 * j + 1]);
		}
	}

	/**
	 * 编码BCD，例如1387编码成  87  13，顺序是倒的 
	 * @param value
	 * @param dest
	 * @param startIndex
	 * @param length
	 */
	private static void encodeBCD_an(String value, byte[] dest, int startIndex, int length) {
		if (value == null || !value.matches("\\d*")) {
			throw new java.lang.IllegalArgumentException();
		}
		
		int[] tmpInts = new int[2 * length];
		
		int index = value.length() - 1;
		
		for (int i = 0; i <= tmpInts.length - 1 && index >= 0; i++, index--) {
			tmpInts[i] = value.charAt(index) - '0';
		}
		
		for (int i = startIndex, j = 0; i < startIndex + length; i++, j++) {
			dest[i] = (byte) (tmpInts[2 * j + 1] * 16 + tmpInts[2 * j] );
		}
	}

	/**
	 * 解码BCD，顺序是正的
	 * @param src
	 * @param startIndex
	 * @param length
	 * @return
	 */
	private static String decodeBCD(byte[] src, int startIndex, int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = startIndex; i < startIndex + length ; i++) {
			int value = (src[i] + 256) % 256;
			sb.append((char) (value / 16 + '0')).append((char) (value % 16 + '0'));
			value++;
		}
		String result = sb.toString();
		if (!result.matches("\\d*")) {
			throw new java.lang.IllegalArgumentException();
		}
		return result;
	}

	/**
	 * 编码BCD，顺序是倒的
	 * @param src
	 * @param startIndex
	 * @param length
	 * @return
	 */
	private static String decodeBCD_an(byte[] src, int startIndex, int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = (startIndex + length - 1); i >= startIndex; i--) {
			int value = (src[i] + 256) % 256;
			sb.append((char) (value / 16 + '0')).append((char) (value % 16 + '0'));
		}

		String result = sb.toString();
		if (!result.matches("\\d*")) {
			throw new java.lang.IllegalArgumentException();
		}
		return result;
	}

//	public static void main(String[] args) throws Exception {
//		// 帧头 + 帧长度 + 终端ID + 功能码 + 数据
//		int len = 2 + 4 + 4 + 2 + (4 + 4);
//
//		byte[] b = new byte[len];
//		ByteUtil.int2Bytes(b, 1234567890, 0);
//		int v1 = ByteUtil.bytes2Int(b, 0);
//		System.out.println(v1);
//
//		b = new byte[len];
//		ByteUtil.short2Bytes(b, (short) -1234, 0);
//		short v2 = ByteUtil.bytes2Short(b, 0);
//		System.out.println(v2);
//
//		b = new byte[len];
//		ByteUtil.long2Bytes(b, 4638387438405602509L, 0);
//		long v3 = ByteUtil.bytes2Long(b, 0);
//		System.out.println(v3);
//
//		b = new byte[len];
//		ByteUtil.float2Bytes(b, (float) -123456.45, 0);
//		float v4 = ByteUtil.bytes2Float(b, 0);
//		System.out.println(v4);
//
//		b = new byte[len];
//		ByteUtil.double2Bytes(b, -256.1234567890123D, 0);
//		double v5 = ByteUtil.bytes2Double(b, 0);
//		System.out.println(v5);
//
//	}
}
