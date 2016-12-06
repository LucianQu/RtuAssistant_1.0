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

		/*if(id.startsWith("00")){
			//水文测站编码
			//if(!id.startsWith("00")){
			//	throw new Exception("水文测站 ID不合法，不是以00开头！" , null) ;
			//}
			byte[] idb = ByteUtil.string2BCD_an(id) ;
			if(idb == null || idb.length == 0){
				throw new Exception("RTU ID不合法，转成BCD编码时出错！" , null) ;
			}else{
				if(idb.length == 1){
					b[n++] = idb[0] ;
					b[n++] = 0 ;
					b[n++] = 0 ;
					b[n++] = 0 ;
					b[n++] = 0 ;
				}else if(idb.length == 2){
					b[n++] = idb[0] ;
					b[n++] = idb[1] ;
					b[n++] = 0 ;
					b[n++] = 0 ;
					b[n++] = 0 ;
				}else if(idb.length == 3){
					b[n++] = idb[0] ;
					b[n++] = idb[1] ;
					b[n++] = idb[2] ;
					b[n++] = 0 ;
					b[n++] = 0 ;
				}else if(idb.length == 4){
					b[n++] = idb[0] ;
					b[n++] = idb[1] ;
					b[n++] = idb[2] ;
					b[n++] = idb[3] ;
					b[n++] = 0 ;
				}else if(idb.length == 5){
					b[n++] = idb[0] ;
					b[n++] = idb[1] ;
					b[n++] = idb[2] ;
					b[n++] = idb[3] ;
					b[n++] = idb[4] ;
				}
			}
		}else{*/
			//水资源测站编码
			String preId = id.substring(0 , 6) ;
			String tailId = id.substring(6) ;
			byte[] cityNo_b = ByteUtil.string2BCD(preId) ;
			if(cityNo_b == null){
				throw new Exception("RTU ID不合法，其城市编号转成BCD编码时出错！" , null) ;
			}/*else if(cityNo_b.length != 3){
				throw new Exception("RTU ID不合法，其城市编号不为六位！" , null) ;
			}*/else{
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
		//}
		
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

