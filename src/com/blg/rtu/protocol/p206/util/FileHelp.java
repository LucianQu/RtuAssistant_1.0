package com.blg.rtu.protocol.p206.util;

import java.io.*;

public class FileHelp {

	/**
	 * 得到文件数据
	 * @param filePath
	 * @return
	 */
	public byte[] getFile(String filePath){
		if(filePath == null){
			return null ;
		}
		byte[] b = null ;
		File f = null ;
		FileInputStream in = null ;
		try {
			f = new File(filePath) ;
			if(f.exists()){
				in = new FileInputStream(f) ;
				if(in != null){
					b = new byte[in.available()] ;
					in.read(b) ;
				}
			}
		} catch (Exception e) {
		}finally{
			if(in != null){
				try {
					in.close() ;
				} catch (IOException e) {
				}
			}
		}
		
		return b ;
	}
}
