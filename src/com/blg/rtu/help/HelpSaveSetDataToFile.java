package com.blg.rtu.help;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

public class HelpSaveSetDataToFile {
	
	private static String tag = HelpSaveSetDataToFile.class.getName() ;
	
	// 准备文件夹
	public static boolean isFileExist(MainActivity act){
		File file = initFile(act) ;
		return file.exists() ;
	}
	
	public static File getFile(MainActivity act){
		return initFile(act) ;
	}
	
	private static File initFile(MainActivity act){
		Resources rs = act.getResources() ;
		String filePath = Environment.getExternalStorageDirectory() 
				+  rs.getString(R.string.fileDir) 
				+  "command"
				+  '.' 
				+ rs.getString(R.string.xmlFileExtendsName) ;
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
	public static void saveData(File file, String xml){
		if(file == null){
			return  ;
		}
		PrintWriter pw = null ;
		try{
			pw = new PrintWriter(new FileWriter(file, false));    
			pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			pw.println(xml);
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
