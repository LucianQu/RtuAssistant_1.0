package com.blg.rtu.util;


public class ChangeCode {
	  public ChangeCode() {
	  }
	  public static String changeUTF162UTF8(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("utf-16") , "utf-8") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }
	  public static String changeUTF162GBK(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("utf-16") , "GBK") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }

	  //////////////////////////////////////////////////////
	  
	  public static String changeUTF82GB(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("utf-8") , "gb2312") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }
	  
	  public static String changeUTF82ISO(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("utf-8") , "ISO8859-1") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }
	  public static String changeUTF82GBK(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("utf-8") , "GBK") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }
	  
///////////////////////////////////////////////////////////
	  
	  public static String changeISO2GBK(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("ISO8859-1") , "GBK") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }
	  

	  public static String changeISO2GB(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("ISO8859-1") , "gb2312") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }

	  public static String changeISO2Utf8(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("ISO8859-1") , "utf-8") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }

	  public static String changeISO2Utf16(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("ISO8859-1") , "utf-16") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }

	  //////////////////////////////////////////
	  
		  
	  
	  public static String changeGBK2UTF8(String str){
		  if(str == null){
			  return null ;
		  }
	    String s = "" ;
	    try{
	      s = new String(str.getBytes("GBK") , "utf-8") ;
	      s = s.replaceAll("'" , "\'") ;
	    }catch(Exception e){
	      return str ;
	    }
	    return s ;
	  }

	
	  public static String changeGBK2ISO(String str){
		  if(str == null){
			  return null ;
		  }
		    String s = "" ;
		    try{
		      s = new String(str.getBytes("GBK"), "ISO8859-1") ;
		      s = s.replaceAll("'" , "\'") ;
		    }catch(Exception e){
		      return str ;
		    }
		    return s ;
		  }
	  
	  
	 
	  public static String changeGB2ISO(String str){
		  if(str == null){
			  return null ;
		  }
		    String s = "" ;
		    try{
		      s = new String(str.getBytes("gb2312"), "ISO8859-1") ;
		      s = s.replaceAll("'" , "\'") ;
		    }catch(Exception e){
		      return str ;
		    }
		    return s ;
		  }
	  
	  public static String changeURLCode(String str){
		  if(str == null){
			  return null ;
		  }
		    String s = "" ;
		    try{
		      s = java.net.URLEncoder.encode(str,"GBK") ;
		    }catch(Exception e){
		      return str ;
		    }
		    return s ;
		  }
	  public static String anChangeURLCode(String str){
		  if(str == null){
			  return null ;
		  }
		    String s = "" ;
		    try{
		      s = java.net.URLDecoder.decode(str,"GBK") ;
		    }catch(Exception e){
		      return str ;
		    }
		    return s ;
		  }

	  public static String anChangeURLCode1(String str){
		  if(str == null){
			  return null ;
		  }
		    String s = "" ;
		    try{
		      s = java.net.URLDecoder.decode(str,"UFT-8") ;
		    }catch(Exception e){
		      return str ;
		    }
		    return s ;
		  }


	}
