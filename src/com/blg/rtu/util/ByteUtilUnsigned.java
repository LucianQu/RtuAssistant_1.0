package com.blg.rtu.util;

public class ByteUtilUnsigned {
	/**
	 * 无符号int类型转换成4位byte数组
	 * java没有无符号整型数据，只有有符号整数，取值范围是-2147483648~2147483647
	 * C有无符号整型数据，取值范围是0到4294967295，已经超出了java的有符号整数上限，所以只能用java的long型表示无符号整数
	 * @value bs byte[]
	 * @value value int int类型的参数
	 * @value from int
	 * @return 返回字节长度
	 * @throws Exception
	 */
	public static void int2Bytes(byte[] bs, long value, int from)throws Exception {
		int len = 4 ;
		long maxIntUnsigned = Long.valueOf(Integer.MAX_VALUE) * 2 + 1;
		if(value < 0 || value > maxIntUnsigned){
			throw new Exception("数据" + value + "超出了无符号Int型的取值范围(0~4294967295)") ;
		}
		int temp = 0 ;
		if(value > Integer.MAX_VALUE){
			temp = (Long.valueOf(value - (Integer.MAX_VALUE * 2 + 1) - 1)).intValue() ;
		}else{
			temp = Long.valueOf(value).intValue() ;
		}
		boolean b = isOutOfArrLength(bs.length, (from - 1) + len);
		if (b) {
			for (int i = (len - 1); i >= 0; i--) {
				bs[from + i] = Integer.valueOf(temp & 0xff).byteValue();// 将数据最低位保存在高字节
				temp = temp >> 8; // 向右移8位
			}
		} else {
			throw new Exception("int2Bytes时数组越界");
		}
	}

	/**
	 * 与方法int2Bytes算法一样，只是把顺序反过来
	 * @value bs byte[]
	 * @value value int int类型的参数
	 * @value from int
	 */
	public static void int2Bytes_an(byte[] bs, long value, int from)throws Exception {
		int len = 4 ;
		long maxIntUnsigned = Long.valueOf(Integer.MAX_VALUE) * 2 + 1;
		if(value < 0 || value > maxIntUnsigned){
			throw new Exception("数据" + value + "超出了无符号Int型的取值范围(0~4294967295)") ;
		}
		int temp = 0 ;
		if(value > Integer.MAX_VALUE){
			temp = (Long.valueOf(value - (Integer.MAX_VALUE * 2 + 1) - 1)).intValue() ;
		}else{
			temp = Long.valueOf(value).intValue() ;
		}
		boolean b = isOutOfArrLength(bs.length, (from - 1) + len);
		if (b) {
			for (int i = 0; i > len ; i++) {
				bs[from + i] = Integer.valueOf(temp & 0xff).byteValue();// 将最低位保存在低字节
				temp = temp >> 8; // 向右移8位
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
	public static long bytes2Int(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			long temp = 0L ;
			long s = 0;
			int s0 = bs[from + 0] ;// 数据的最高位在低字节
			int s1 = bs[from + 1] ;
			int s2 = bs[from + 2] ;
			int s3 = bs[from + 3] ;

			// 最低位S3不变
			s0 <<= 24;
			s1 <<= 16;
			s2 <<= 8;
			s = s0 | s1 | s2 | s3;
			if(s < 0){
				//s = Integer.MAX_VALUE -s ;
				temp = Integer.MAX_VALUE  ;
				temp = temp * 2 + 1 + s + 1 ;
			}
			return temp;
		} else {
			throw new Exception("byte2Int时数组越界");
		}
	}

	/**
	 * 与方法bytes2Int算法一样，只是把顺序反过来
	 * 
	 * @param b
	 * @return
	 */
	public static long bytes2Int_an(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 4);
		if (b) {
			long temp = 0L ;
			long s = 0;
			int s0 = bs[from + 0] ;// 数据的最低位在低字节
			int s1 = bs[from + 1] ;
			int s2 = bs[from + 2] ;
			int s3 = bs[from + 3] ;

			// S0不变
			s1 <<= 8;
			s2 <<= 16;
			s3 <<= 24;
			s = s0 | s1 | s2 | s3;
			if(s < 0){
				//s = Integer.MAX_VALUE -s ;
				temp = Integer.MAX_VALUE  ;
				temp = temp * 2 + 1 + s + 1 ;
			}
			return temp;
		} else {
			throw new Exception("byte2Int时数组越界");
		}
	}
	/**
	 * 无符号short类型转换成2位byte数组
	 * java没有无符号短整型数据，只有有符号短整数，取值范围是-32768~32767
	 * 若模拟无符号短整型数据，取值范围是0到65535 ，已经超出了java的有符号整数上限，所以只能用java的Int型表示无符号整数
	 * @value bs byte[]
	 * @value value int int类型的参数
	 * @value from int
	 */
	public static void short2Bytes(byte[] bs, int value, int from)throws Exception {
		int maxShortUnsigned = Integer.valueOf(Short.MAX_VALUE) * 2 + 1;
		if(value < 0 || value > maxShortUnsigned ){
			throw new Exception("数据" + value + "超出了无符号short型的取值范围(0~65535)") ;
		}
		short temp = 0 ;
		if(value > Short.MAX_VALUE){
			temp = (Integer.valueOf(value - (Short.MAX_VALUE * 2 + 1) - 1)).shortValue() ;//(Integer.valueOf(Short.MAX_VALUE - value)).shortValue() ;
		}else{
			temp = Integer.valueOf(value).shortValue() ;
		}
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			for (int i = 1; i >= 0; i--) {
				bs[from + i] = Integer.valueOf(temp & 0xff).byteValue();//将最低位保存在高字节
				temp = (short)(temp >> 8); // 向右移8位
			}
		} else {
			throw new Exception("short2Bytes时数组越界");
		}
	}
	/**
	 * 与方法short2Bytes算法一样，只是把顺序反过来
	 * @value bs byte[]
	 * @value value int int类型的参数
	 * @value from int
	 */
	public static void short2Bytes_an(byte[] bs, int value, int from)throws Exception {
		int len = 2 ;
		int maxShortUnsigned = Integer.valueOf(Short.MAX_VALUE) * 2 + 1;
		if(value < 0 || value > maxShortUnsigned ){
			throw new Exception("数据" + value + "超出了无符号short型的取值范围(0~65535)") ;
		}
		short temp = 0 ;
		if(value > Short.MAX_VALUE){
			temp = (Integer.valueOf(value - (Short.MAX_VALUE * 2 + 1) - 1)).shortValue() ;//(Integer.valueOf(Short.MAX_VALUE - value)).shortValue() ;
		}else{
			temp = Integer.valueOf(value).shortValue() ;
		}
		boolean b = isOutOfArrLength(bs.length, (from - 1) + len);
		if (b) {
			for (int i = 0; i < len; i++) {
				bs[from + i] = Integer.valueOf(temp & 0xff).byteValue();//将最低位保存在低字节
				temp = (short)(temp >> 8); // 向右移8位
			}
		} else {
			throw new Exception("short2Bytes时数组越界");
		}
	}

	/**
	 * 2位字节数组转换为短整型
	 * 
	 * @param b
	 * @return
	 */
	public static int bytes2Short(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			int s = 0;
			short s0 = Integer.valueOf(bs[from + 0] & 0xff).shortValue();// 最低位
			short s1 = Integer.valueOf(bs[from + 1] & 0xff).shortValue();

			// 最低位S1不变
			s0 <<= 8;
			s = s0 | s1 ;
			if(s < 0){
				s = (Short.MAX_VALUE * 2 + 1) + s + 1;
			}
			return s;
		} else {
			throw new Exception("bytes2Short时数组越界");
		}
	}

	/**
	 * 与方法bytes2Short算法一样，只是把顺序反过来
	 * 
	 * @param b
	 * @return
	 */
	public static int bytes2Short_an(byte[] bs, int from) throws Exception {
		boolean b = isOutOfArrLength(bs.length, (from - 1) + 2);
		if (b) {
			int s = 0;
			short s0 = Integer.valueOf(bs[from + 0] & 0xff).shortValue();// 最低位
			short s1 = Integer.valueOf(bs[from + 1] & 0xff).shortValue();

			// 最低位S0不变
			s1 <<= 8;
			s = s0 | s1 ;
			if(s < 0){
				s = (Short.MAX_VALUE * 2 + 1) + s + 1;
			}
			return s;
		} else {
			throw new Exception("bytes2Short时数组越界");
		}
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
}
