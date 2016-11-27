package com.blg.rtu.help;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.PrintWriter;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;
import android.widget.Filter;

public class HelpSaveSetDataToFile {
	
	private static String tag = HelpSaveSetDataToFile.class.getName() ;
	
	// 准备文件夹
	public static boolean isFileExist(MainActivity act){
		File file = initFile(act) ;
		return file.exists() ;
	}
	public static boolean isInFileExist(MainActivity act){
		File file = initInFile(act) ;
		return file.exists() ;
	}
	
	public static File getFile(MainActivity act){
		return initFile(act) ;
	}
	
	public static File getInFile(MainActivity act){
		return initInFile(act) ;
	}
	
	private static File initFile(MainActivity act){
		Resources rs = act.getResources() ;
		String filePath = Environment.getExternalStorageDirectory() 
				+  rs.getString(R.string.fileDir) 
				+  "WaterMeter_CFG"
				+  '.' 
				+ rs.getString(R.string.xmlFileExtendsName) ;
		// /storage/sdcard1/rtuAssistant/WaterMeter_CFG.xml //storage Default location: Internal storage
		// /storage/emulated/0/rtuAssistant/WaterMeter_CFG.xml //storage Default location: SD 卡
		// /rtuAssistant/
		Log.i(tag, filePath);
		File file = new File(filePath);
		File dir = file.getParentFile() ;
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return file ;
	}
	
	private static File initInFile(MainActivity act) {
		Resources rs = act.getResources();
		String filePath = Environment.getExternalStorageDirectory().toString() + "/";
		final String fileName = "WaterMeter_CFG" + '.' + rs.getString(R.string.xmlFileExtendsName);
		
		Log.i(tag,filePath);
		File file = new File(filePath);
		
		/*File[] files = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File arg0) {
				return arg0.getName().endsWith(".xml");
			}
		});
		
		
		for(File fileConfig:files) {
			if(fileConfig.getName().equals(fileName)) {
				return fileConfig;
			}
		}
		*/
		return search(file, fileName, act);
	}

	 private static File search(File fileold, String key, MainActivity act)
	  {
		 Resources rs = act.getResources();
	   try{
			 File[] files=fileold.listFiles();
			 if(files.length>0)
			 {
			   for(int j=0;j<files.length;j++) 
			   { 
				  if(!files[j].isDirectory())
				  {
					  if(files[j].getName().indexOf(key)> -1) 
					  { 
						  Log.i(tag,files[j].getPath());
						 return files[j];
					  }
				  }else{ 
					 search(files[j],key,act); 
				  }
			   } 
			 } 
	   }
	   catch(Exception e)
	   { 
		   Log.i(tag, "file is not found");
	   }
	   return new File(Environment.getExternalStorageDirectory() 
				+  rs.getString(R.string.fileDir) 
				+  "WaterMeter_CFG"
				+  '.' 
				+ rs.getString(R.string.xmlFileExtendsName));
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
