package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.protocol.p206.util.Constant;
import com.blg.rtu.util.ByteUtil;
import com.blg.rtu.util.ByteUtilUnsigned;

public class RtuIdProtocol {
	
	/**
	 * 分析的RTU ID
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public String[] parseRtuId_1(byte[] bs , int startIndex, int endIndex)throws Exception{
		String id = null ;
		//String hex = null ;
		try{
		/*	byte firstByte = bs[startIndex] ;
			if(firstByte == 0){
				//水文测站编码方式
				id = ByteUtil.BCD2String(bs , startIndex , startIndex + 4) ;
			}else{*/
				//水资源测站编码方式
				String preId = ByteUtil.BCD2String(bs , startIndex , startIndex + 2) ;
				int tailId =  ByteUtilUnsigned.bytes2Short_an(bs, startIndex + 3) ;
				id = preId +" " + tailId ;
			//}
			//hex = ByteUtil.bytes2Hex(bs, true, startIndex, (endIndex - startIndex + 1)) ;
		}catch(Exception e){
			throw new Exception("分析RTU ID时出错!" + e.getMessage() , null) ;
		}
		return new String[]{id} ;
	}
	/**
	 * 分析的RTU ID
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public String[] parseRtuId_2(byte[] bs , int startIndex, int endIndex)throws Exception{
		String id = null ;
		String hex = null ;
		try{
		/*	byte firstByte = bs[startIndex] ;
			if(firstByte == 0){
				//水文测站编码方式
				id = ByteUtil.BCD2String(bs , startIndex , startIndex + 4) ;
			}else{*/
				//水资源测站编码方式
				String preId = ByteUtil.BCD2String(bs , startIndex , startIndex + 2) ;
				int tailId =  ByteUtilUnsigned.bytes2Short_an(bs, startIndex + 3) ;
				id = preId +  tailId ;
			//}
			
			hex = ByteUtil.bytes2Hex(bs, true, startIndex, (endIndex - startIndex + 1)) ;
			
		}catch(Exception e){
			throw new Exception("分析RTU ID时出错!" + e.getMessage() , null) ;
		}
		return new String[]{id, hex} ;
	}
	/**
	 * 创建RTU地址
	 * @param id RTU ID
	 * @param idType  RTU ID类型
	 * @param b 命令字节数组数据
	 * @param idSite RTU ID在数组中的位置
	 * @return
	 * @throws Exception
	 */
	public byte[] createRtuId(byte[] b, String id , int idSite)throws Exception{
		if(id == null || id.trim().equals("")){
			throw new Exception("出错，RTU ID为空，") ;
		}
		id = id.trim() ;

		int n = idSite ; 

		//水资源测站编码
		String preId = id.substring(0 , 6) ;
		String tailId = id.substring(6) ;
		byte[] cityNo_b = ByteUtil.string2BCD(preId) ;
		if(cityNo_b == null){
			throw new Exception("RTU ID不合法，其城市编号转成BCD编码时出错！" , null) ;
		}else{
			if(cityNo_b.length == 1) {
				b[n++] = 0 ;
				b[n++] = 0 ;
				b[n++] = cityNo_b[0] ;
			}else if(cityNo_b.length == 2) {
				b[n++] = 0 ;
				b[n++] = cityNo_b[0] ;
				b[n++] = cityNo_b[1] ;
			}else if(cityNo_b.length == 3) {
				b[n++] = cityNo_b[0] ;
				b[n++] = cityNo_b[1] ;
				b[n++] = cityNo_b[2] ;
			}
			}
			ByteUtilUnsigned.short2Bytes_an(b, Integer.parseInt(tailId), n) ;
		return b ;
	}
	
	/**
	 * 创建RTU地址
	 * @param selectId 选择下发的RTU ID
	 * @param id RTU ID
	 * @param idType  RTU ID类型
	 * @param b 命令字节数组数据
	 * @param idSite RTU ID在数组中的位置
	 * @return
	 * @throws Exception
	 */
	public byte[] createSelectRtuId(byte[] b, int selectPosition, String id , int idSite)throws Exception{
		
		if(selectPosition < 0 || selectPosition > 8) {
			throw new Exception("出错，选择下发的地址超出范围") ;
		}
		
		if(id == null || id.trim().equals("")){
			throw new Exception("出错，RTU ID为空，") ;
		}
		id = id.trim() ;
		
		int n = idSite ; 
		b[n++] = (byte) selectPosition ;
		//水资源测站编码
		String preId = id.substring(0 , 6) ;
		String tailId = id.substring(6) ;
		byte[] cityNo_b = ByteUtil.string2BCD(preId) ;
		if(cityNo_b == null){
			throw new Exception("select  RTU ID不合法，其城市编号转成BCD编码时出错！" , null) ;
		}else{
			if(cityNo_b.length == 1) {
				b[n++] = 0 ;
				b[n++] = 0 ;
				b[n++] = cityNo_b[0] ;
			}else if(cityNo_b.length == 2) {
				b[n++] = 0 ;
				b[n++] = cityNo_b[0] ;
				b[n++] = cityNo_b[1] ;
			}else if(cityNo_b.length == 3) {
				b[n++] = cityNo_b[0] ;
				b[n++] = cityNo_b[1] ;
				b[n++] = cityNo_b[2] ;
			}
		}
		ByteUtilUnsigned.short2Bytes_an(b, Integer.parseInt(tailId), n) ;
		
		return b ;
	}
	
	
	/**
	 * 创建RTU地址，参数是16进制
	 * @param b
	 * @param hexRtuId
	 * @param idSite
	 * @return
	 * @throws Exception
	 */
	public byte[] createRtuId_hex(byte[] b, String hexRtuId , int idSite)throws Exception{
		String id = hexRtuId.toString() ;
		if(id == null || id.trim().equals("")){
			throw new Exception("出错，RTU ID为空，") ;
		}
		id = id.trim() ;

	
		byte[] bs = ByteUtil.hex2Bytes(id) ;
		for(int i = idSite, j = 0 ; i < idSite + 5 && j < bs.length ; i++, j++ ){
			b[i] = bs[j] ;
		}
		return b ;
	}
		
	
	public static void main(String[] args) throws Exception{
		String rtuId = "0012345678" ;
		
		byte[] b = new byte[100] ;
		
		RtuIdProtocol t = new RtuIdProtocol() ;
		t.createRtuId(b, rtuId, Constant.Site_RTUID) ;
		
	}
}

