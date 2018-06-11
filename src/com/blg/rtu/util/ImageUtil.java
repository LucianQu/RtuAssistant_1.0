package com.blg.rtu.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.blg.rtu3.R;

public class ImageUtil {
	
	private static Drawable titlRightImg_gray, titlRightImg_blue, titlRightImg_green, titlRightImg_red, titlRightImg_problem ;
	private static Drawable titlLeftImg_item001, titlLeftImg_item002, titlLeftImg_item003,titlLeftImg_item004, 
	titlLeftImg_item005, titlLeftImg_item006, titlLeftImg_item007 ;
	
	public static Drawable getTitlRightImg_red(Context ctx){
		if(titlRightImg_red == null){
			Resources res = ctx.getResources();
			titlRightImg_red = res.getDrawable(R.drawable.lb_red);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlRightImg_red.setBounds(0, 0, titlRightImg_red.getMinimumWidth(), titlRightImg_red.getMinimumHeight());
		}
		return titlRightImg_red ;
	}
	
	public static Drawable getTitlRightImg_green(Context ctx){
		if(titlRightImg_green == null){
			Resources res = ctx.getResources();
			titlRightImg_green = res.getDrawable(R.drawable.lb_green);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlRightImg_green.setBounds(0, 0, titlRightImg_green.getMinimumWidth(), titlRightImg_green.getMinimumHeight());
		}
		return titlRightImg_green ;
	}

	
	public static Drawable getTitlRightImg_blue(Context ctx){
		if(titlRightImg_blue == null){
			Resources res = ctx.getResources();
			titlRightImg_blue = res.getDrawable(R.drawable.lb_blue);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlRightImg_blue.setBounds(0, 0, titlRightImg_blue.getMinimumWidth(), titlRightImg_blue.getMinimumHeight());
		}
		return titlRightImg_blue ;
	}

	
	public static Drawable getTitlRightImg_gray(Context ctx){
		if(titlRightImg_gray == null){
			Resources res = ctx.getResources();
			titlRightImg_gray = res.getDrawable(R.drawable.lb_gray);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlRightImg_gray.setBounds(0, 0, titlRightImg_gray.getMinimumWidth(), titlRightImg_gray.getMinimumHeight());
		}
		return titlRightImg_gray ;
	}
	
	public static Drawable getTitlRightImg_problem(Context ctx){
		if(titlRightImg_problem == null){
			Resources res = ctx.getResources();
			titlRightImg_problem = res.getDrawable(R.drawable.lb_problem);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlRightImg_problem.setBounds(0, 0, titlRightImg_problem.getMinimumWidth(), titlRightImg_problem.getMinimumHeight());
		}
		return titlRightImg_problem ;
	}
	
	
	public static Drawable getTitlLeftImg_item001(Context ctx){
		if(titlLeftImg_item001 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item001 = res.getDrawable(R.drawable.item001);
			//setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item001.setBounds(0, 0, titlLeftImg_item001.getMinimumWidth(), titlLeftImg_item001.getMinimumHeight());
		}
		return titlLeftImg_item001 ;
	}
	
	public static Drawable getTitlLeftImg_item002(Context ctx){
		if(titlLeftImg_item002 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item002 = res.getDrawable(R.drawable.item002);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item002.setBounds(0, 0, titlLeftImg_item002.getMinimumWidth(), titlLeftImg_item002.getMinimumHeight());
		}
		return titlLeftImg_item002 ;
	}
	
	public static Drawable getTitlLeftImg_item003(Context ctx){
		if(titlLeftImg_item003 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item003 = res.getDrawable(R.drawable.item003);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item003.setBounds(0, 0, titlLeftImg_item003.getMinimumWidth(), titlLeftImg_item003.getMinimumHeight());
		}
		return titlLeftImg_item003 ;
	}
	
	public static Drawable getTitlLeftImg_item004(Context ctx){
		if(titlLeftImg_item004 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item004 = res.getDrawable(R.drawable.item004);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item004.setBounds(0, 0, titlLeftImg_item004.getMinimumWidth(), titlLeftImg_item004.getMinimumHeight());
		}
		return titlLeftImg_item004 ;
	}
	
	public static Drawable getTitlLeftImg_item005(Context ctx){
		if(titlLeftImg_item005 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item005 = res.getDrawable(R.drawable.item005);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item005.setBounds(0, 0, titlLeftImg_item005.getMinimumWidth(), titlLeftImg_item005.getMinimumHeight());
		}
		return titlLeftImg_item005 ;
	}
	
	public static Drawable getTitlLeftImg_item006(Context ctx){
		if(titlLeftImg_item006 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item006 = res.getDrawable(R.drawable.item006);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item006.setBounds(0, 0, titlLeftImg_item006.getMinimumWidth(), titlLeftImg_item006.getMinimumHeight());
		}
		return titlLeftImg_item006 ;
	}
	public static Drawable getTitlLeftImg_item007(Context ctx){
		if(titlLeftImg_item007 == null){
			Resources res = ctx.getResources();
			titlLeftImg_item007 = res.getDrawable(R.drawable.item007);
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
			titlLeftImg_item007.setBounds(0, 0, titlLeftImg_item007.getMinimumWidth(), titlLeftImg_item007.getMinimumHeight());
		}
		return titlLeftImg_item007 ;
	}
	
	
	
}
