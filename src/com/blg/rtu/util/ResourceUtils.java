package com.blg.rtu.util;

import android.content.Context;
import android.util.TypedValue;

public class ResourceUtils {

	private static TypedValue mTmpValue = new TypedValue();

	private ResourceUtils() {
	}

	/**
	 * 直接得到配置文件的配置原值
	 * 因为：
	 * getDimension()、getDimensionPixelOffset()和getDimensionPixelSize()三个函数获取绝对尺寸，android已经把配置值转成绝对尺寸
	 * @param context
	 * @param id
	 * @return
	 */
	public static int getXmlDef(Context context, int id) {
		synchronized (mTmpValue) {
			TypedValue value = mTmpValue;
			context.getResources().getValue(id, value, true);
			return (int) TypedValue.complexToFloat(value.data);
		}
	}
}