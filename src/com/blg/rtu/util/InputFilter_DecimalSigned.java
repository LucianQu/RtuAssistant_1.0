package com.blg.rtu.util;

import android.text.Spanned;

public class InputFilter_DecimalSigned extends InputFilter_Digit{

	private int len ;
	
	private static final String template = "0123456789.-" ;
	
	public InputFilter_DecimalSigned(int len){
		this.len = len ;
	}
	
	/**
	 * This method is called when the buffer is going to replace the range 
	 * dstart … dend of dest with the new text from the range start … end of source. 
	 * Return the CharSequence that you would like to have placed there instead, 
	 * including an empty string if appropriate, or null to accept the original replacement. 
	 * Be careful to not to reject 0-length replacements, as this is what happens when you delete text. 
	 * Also beware that you should not attempt to make any changes to dest from this method; 
	 * you may only examine it for context. Note: If source is an instance of Spanned or Spannable, 
	 * the span objects in the source should be copied into the filtered result (i.e. the non-null return value). 
	 * copySpansFrom(Spanned, int, int, Class, Spannable, int) can be used for convenience.
	 */
	@Override
	public CharSequence filter( 
			CharSequence source, //输入的文字 
			int start, //输入的文字的开始位置 
			int end, //输入的文字的结束位置 
			Spanned dest, //原有内容 
			int dstart, //输入的文字在原有内容的开始位置
			int dend //输入的文字在原有内容的结束位置 
			) {
		if(source == null || source.equals("")){
			return source ;
		}
		CharSequence str = null;
		if(dest.length() >= this.len){
		}else{
			if(source.length() > 1){
				//一次输入多个数字，例如粘贴或程序赋值
				if(dest.length() + source.length() > this.len){
					//长度超限
				}else{
					str = this.filterMultiChar(source, start, end, dest, dstart, dend) ;
				}
			}else{
				str = this.filterSingleChar(source, start, end, dest, dstart, dend) ;
			}
		}
		if(str == null){
			str = "" ;
		}
		return str;
	}
	
	/**
	 * 输入是否合法
	 */
	protected boolean isHeFa(CharSequence source) {
		// 判断是否是合法字符
		boolean flag = true ;
		boolean find = false ;
		if(source == null || source.length() == 0){
			flag = false ;
		}else{
			char ch = 0 ;
			for (int i = 0; i < source.length(); i++) {
				ch = source.charAt(i) ;
				find = false ;
				for(int j = 0 ; j < template.length() ; j++){
					if(template.charAt(j) == ch){
						find = true ;
						break;
					}
				}
				if(!find){
					flag = false ;
					break ;
				}
			}
		}
		return flag ;
	}

}
