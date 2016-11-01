package com.blg.rtu.util;

public class CRC8_for_2_0 {
	
//	public int CRC8(byte[] b, int from , int end){
//		  int crc = 0;
//		  for(int i = from ; i <= end ; i++){
//			    crc = crc ^ (b[i]);
//			    for(int j = 0; j < 8; j++) {
//			      if((crc & 0x80)!=0) {
//			    	 crc ^= 0xe5;
//			    	 crc *= 2;
//			      }else{
//			    	 crc *= 2;
//			      }
//			    }
//		  }
//		  return crc;
//		}
	public int CRC8(byte[] b, int from , int end){
		  int crc = 0;
		  for(int i = from ; i <= end ; i++){
			    crc = crc ^ (b[i]);
			    for(int j = 0; j < 8; j++) {
			      if((crc & 0x80) == 0x80) {
				     crc *= 2;
			    	 crc ^= 0xe5;
			      }else{
			    	 crc *= 2;
			      }
			    }
		  }
		  return crc;
		}
	/*
	unsigned char Crc8_Check(const unsigned char *ucPtr, unsigned char ucLen,unsigned char ucCrcStartValue) 
	{
	  unsigned char crc;
	  unsigned char i;

	  crc=ucCrcStartValue;
	  while(ucLen--!=0) 
	  {
	    crc = crc^(*ucPtr);
	    for(i=0; i<8; i++) 
	    {
	      if((crc&0x80)== 0x80) 
	      {  
	        crc*=2; 
	        crc^=0xE5;                 
	      } 
	      else 
	      {       
	        crc*=2;        
	      }
	    }
	    ucPtr++;
	 }
	 return(crc);
	}
	 */
}