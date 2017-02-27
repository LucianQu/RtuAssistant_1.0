package com.blg.rtu.protocol.p206.common;

import com.blg.rtu.protocol.p206.util.Constant;

public class ControlProtocol {
	
	public byte DIR ;//传输方向位DIR
	public byte DIV ;//拆分标志位DIV
	public byte FCB ;//帧计数位FCB
	public byte DIVS ;//拆分帧记数DIVS
	
	public byte FUNCODE ;//控制域中的功能码
	
	public boolean hasDIVS ;

	/**
	 * 分析控制域
	 * @param b
	 */
	public ControlProtocol parseControl(byte[] b) throws Exception{
		if(b == null){
			throw new Exception("出错，RTU数据为空！") ;
		}
		if(b.length < Constant.Site_Control + 1){
			throw new Exception("出错，RTU数据长度不合法，不能分析控制域！") ;
		}
		byte bb = b[Constant.Site_Control] ;
		DIR = (byte)(bb >> 7) ;
		DIV = (byte)((bb & 0x40) >> 6) ;
		FCB = (byte)((bb & 0x30) >> 4) ;
		
		FUNCODE = (byte)(bb & 0xF) ;
		
		if(DIV == 1){
			DIVS = b[Constant.Site_Control + 1] ;
			this.hasDIVS = true ;
		}else{
			DIVS = 0 ;
			this.hasDIVS = false ;
		}
		
		return this ;
	}
	
	
	/**
	 * 创建下行数据控制域
	 * @param b
	 * @param DIV
	 * @param FCB
	 * @param DIVS
	 * @throws Exception
	 */
	public byte[] createToRTUControl(byte[] b, byte DIV, byte FCB, byte DIVS, byte controlFunCode) throws Exception{
		int n = Constant.Site_Control ;
		b[n++] = (byte)(Constant.DIR_phonetoRelay << 7 | DIV << 6 | FCB << 4 | controlFunCode) ;
		if(DIV == 1){
			b[n++] = DIVS ;
			this.hasDIVS = true ;
		}else{
			this.hasDIVS = false ;
		}
		return b ;
	}

	
	
	/**
	 * 创建上行数据控制域
	 * @param b
	 * @param DIV
	 * @param FCB
	 * @param DIVS
	 * @throws Exception
	 */
	public byte[] createFromRTUControl(byte[] b, byte DIV, byte FCB, byte DIVS, byte controlFunCode) throws Exception{
		int n = Constant.Site_Control ;
		b[n++] = (byte)(Constant.DIR_fromRtu << 7 | DIV << 6 | FCB << 4 | controlFunCode) ;
		if(DIV == 1){
			b[n++] = DIVS ;
			this.hasDIVS = true ;
		}else{
			this.hasDIVS = false ;
		}
		return b ;
	}

}
