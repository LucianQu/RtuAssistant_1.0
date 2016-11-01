package com.blg.rtu.util;

import android.text.InputFilter;
import android.text.Spanned;

public abstract class InputFilter_Digit implements InputFilter{

	@Override
	public abstract CharSequence filter(
			CharSequence source, 
			int start, int end,
			Spanned dest, 
			int dstart, 
			int dend) ;

	protected abstract boolean isHeFa(CharSequence source) ;
	/**
	 * 输入的是多个字符
	 * @param source
	 * @param start
	 * @param end
	 * @param dest
	 * @param dstart
	 * @param dend
	 * @return
	 */
	protected CharSequence filterMultiChar(
			CharSequence source, //输入的文字 
			int start, //输入的文字的开始位置 
			int end, //输入的文字的结束位置 
			Spanned dest, //原有内容 
			int dstart, //输入的文字在原有内容的开始位置
			int dend //输入的文字在原有内容的结束位置 
			){
		CharSequence str = null;
		boolean ok = false ;
		if(this.isHeFa(source)){
			//合法数字
			if(source != null && source.length() > 0){
				int dians = this.countDian(source) ;
				int fuHaos = this.countFuHao(source) ;
				if(dians > 1 || fuHaos > 1){
					//多个小数点或负号
				}else{
					//先处理小数点
					if(dians == 1){
						//输入内容有一个小数点
						if(this.countDian(dest) > 0){
							//原有内容也有小数点
						}else{
							//原有内容没有小数点
							boolean flag = this.isStartDian(source) ;
							if(flag && dstart == 0){
								//输入内容在原来内容的开始位置，开始位置不能有小数点
							}else{
								ok = true ;
							}
						}
					}else{
						//输入内容无小数点
						ok = true ;
					}
					
					
					if(ok){
						//再处理负号
						if(fuHaos == 1){
							//输入内容有一个负号
							boolean flag = this.isStartFuHao(source) ;
							if(!flag){
								//负号不在最前面
							}else{
								//负号在最前面
								if(this.isStartFuHao(dest)){
									//原有内容也有负号
								}else{
									//原有内容没有负号
									if(dstart != 0){
										//输入内容不在原来内容的开始位置 
									}else{
										ok = true;
									}
								}
							}
						}else{
							//输入内容无负号
							ok = true ;
						}
					}
					
					if(ok){
						str = source ;
					}
				}				
			}
		}
		return str ;
	}
	
	/**
	 * 输入的是单个字符
	 * @param source
	 * @param start
	 * @param end
	 * @param dest
	 * @param dstart
	 * @param dend
	 * @return
	 */
	protected CharSequence filterSingleChar(
			CharSequence source, //输入的文字 
			int start, //输入的文字的开始位置 
			int end, //输入的文字的结束位置 
			Spanned dest, //原有内容 
			int dstart, //输入的文字在原有内容的开始位置
			int dend //输入的文字在原有内容的结束位置 
			){
		CharSequence str = null;
		if(isHeFa(source)){
			if(source != null && source.length() > 0){
				if(source.charAt(0) == '.'){
					//输入的是小数 点
					if(dstart > 0){
						//不是第一个位置输入，第一个位置不能放.
						if(dstart == 1){
							//第二个位置输入
							if(dest.length() > 0 && dest.charAt(0) != '-'){
								//原有内容第一个不是负号
								str = source ;
							}
						}else{
							//不是第一二位置
							if(countDian(dest) == 0){
								//原来内容不存在小数 点
								str = source ;
							}
						}
					}
				}else if(source.charAt(0) == '-'){
					//输入的是负号
					if(dstart == 0){
						//是第一个位置输入，其他位置不能输入负号
						str = source ;
					}
				}else{
					str = source ;
				}
			}
		}
		return str;
	}
	
	
	/**
	 * 小数点个数
	 * @param dest
	 * @return
	 */
	protected int countDian(CharSequence source){
		int flag = 0 ;
		for(int i = 0 ; i < source.length() ; i++){
			if(source.charAt(i) == '.'){
				//存在.
				flag++ ;
			}
		}
		return flag ;
	}
	/**
	 * 小数点个数
	 * @param dest
	 * @return
	 */
	protected int countDian(Spanned dest){
		int flag = 0 ;
		for(int i = 0 ; i < dest.length() ; i++){
			if(dest.charAt(i) == '.'){
				//存在.
				flag++ ;
			}
		}
		return flag ;
	}
	
	/**
	 * 负号个数
	 * @param dest
	 * @return
	 */
	protected int countFuHao(CharSequence source){
		int flag = 0 ;
		for(int i = 0 ; i < source.length() ; i++){
			if(source.charAt(i) == '.'){
				//存在.
				flag++ ;
			}
		}
		return flag ;
	}
	/**
	 * 负号个数
	 * @param dest
	 * @return
	 */
	protected int countFuHao(Spanned dest){
		int flag = 0 ;
		for(int i = 0 ; i < dest.length() ; i++){
			if(dest.charAt(i) == '.'){
				//存在.
				flag++ ;
			}
		}
		return flag ;
	}
	
	/**
	 * 是否以小数点开头
	 * @param source
	 * @return
	 */
	protected boolean isStartDian(CharSequence source){
		boolean flag = false ;
		if(source.length() > 0 && source.charAt(0) == '.'){
			flag = true ;
		}
		return flag ;
	}
	/**
	 * 是否以小数点开头
	 * @param dest
	 * @return
	 */
	protected boolean isStartDian(Spanned dest){
		boolean flag = false ;
		if(dest.length() > 0 && dest.charAt(0) == '.'){
			flag = true ;
		}
		return flag ;
	}
	/**
	 * 是否以负号开头
	 * @param source
	 * @return
	 */
	protected boolean isStartFuHao(CharSequence source){
		boolean flag = false ;
		if(source.length() > 0 && source.charAt(0) == '-'){
			flag = true ;
		}
		return flag ;
	}
	/**
	 * 是否以负号开头
	 * @param dest
	 * @return
	 */
	protected boolean isStartFuHao(Spanned dest){
		boolean flag = false ;
		if(dest.length() > 0 && dest.charAt(0) == '-'){
			flag = true ;
		}
		return flag ;
	}

}
