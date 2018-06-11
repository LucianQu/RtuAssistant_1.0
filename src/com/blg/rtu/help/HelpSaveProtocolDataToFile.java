package com.blg.rtu.help;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.blg.rtu.frmChannel.helpCh4.ListRtuData;
import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

public class HelpSaveProtocolDataToFile {
	
	private static String tag = HelpSaveProtocolDataToFile.class.getName() ;
	
	// 准备文件夹
	public static File getFile(MainActivity act, String yyyy_mm_dd){
		Resources rs = act.getResources() ;
		String filePath = Environment.getExternalStorageDirectory() 
				+  rs.getString(R.string.fileDir) 
				+  yyyy_mm_dd + "_命令结果"
				+  '.' 
				+ rs.getString(R.string.fileExtendsName) ;
		File file = new File(filePath);
		File dir = file.getParentFile() ;
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return file ;
	}
	
	/**
	 * 删除文件
	 * @param file
	 */
	public static void deleteFile(File file){
		try{
			if(file != null && file.exists()){
				file.delete() ;
			}
		}catch(Exception e){} 
	}
	
	//存储数据
	public static void saveData(File file, ListRtuData vo){
		if(file == null){
			return  ;
		}
		PrintWriter pw = null ;
		try{
			pw = new PrintWriter(new FileWriter(file, true));    
			pw.println(vo.direct+ ":" + vo.rtuId + " / " + vo.code + " / " + vo.channel);
			pw.println(vo.dt);
			pw.println(vo.hex);
			pw.println("===========================================================");
			pw.flush() ;
		}catch(Exception e){
			Log.e(tag , "文件存储数据出错！") ;
		}finally{
			if(pw != null){
				try{
					pw.close() ;
				}catch(Exception e){}
			}
		}
	}

}
