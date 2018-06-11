package com.blg.rtu3;

import com.blg.rtu.frmChannel.ChFragment_04;
import com.blg.rtu.util.CallBackReturnVO;

public class FragmentCallback implements
		ChFragment_04.ChFrgCallBackInterface_04 {

	@SuppressWarnings("unused")
	private MainActivity mainAct ;

	public FragmentCallback(MainActivity mainAct){
		this.mainAct = mainAct ;
	}

	@Override
	public CallBackReturnVO callBack_ch02(String value) {
		return null;
	}

}
