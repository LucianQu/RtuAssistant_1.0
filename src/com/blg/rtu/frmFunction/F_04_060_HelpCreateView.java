package com.blg.rtu.frmFunction;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.InputFilter_DecimalSigned;
import com.blg.rtu.util.InputFilter_DecimalUnSigned;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu.util.Preferences;
import com.blg.rtu1.R;

import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class F_04_060_HelpCreateView {
	private F_04_060 fr ;
	
	public F_04_060_HelpCreateView(F_04_060 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		this.fr.lineParam01 = (LinearLayout)view.findViewById(R.id.f_04_060_param01) ; 
		this.fr.lineParam02 = (LinearLayout)view.findViewById(R.id.f_04_060_param02) ; 
		this.fr.lineParam03 = (LinearLayout)view.findViewById(R.id.f_04_060_param03) ; 
		this.fr.lineParam04 = (LinearLayout)view.findViewById(R.id.f_04_060_param04) ; 
		this.fr.lineParam05 = (LinearLayout)view.findViewById(R.id.f_04_060_param05) ; 
		this.fr.lineParam06 = (LinearLayout)view.findViewById(R.id.f_04_060_param06) ; 
		this.fr.lineParam07 = (LinearLayout)view.findViewById(R.id.f_04_060_param07) ; 
		this.fr.lineParam08 = (LinearLayout)view.findViewById(R.id.f_04_060_param08) ; 
		this.fr.lineParam09 = (LinearLayout)view.findViewById(R.id.f_04_060_param09) ; 
		this.fr.lineParam10 = (LinearLayout)view.findViewById(R.id.f_04_060_param10) ; 
		this.fr.lineParam11 = (LinearLayout)view.findViewById(R.id.f_04_060_param11) ; 
		this.fr.lineParam12 = (LinearLayout)view.findViewById(R.id.f_04_060_param12) ; 
		this.fr.lineParam13 = (LinearLayout)view.findViewById(R.id.f_04_060_param13) ; 	
		
		this.fr.param01_1 = (EditText)view.findViewById(R.id.f_04_060_param01_1) ; 
		this.fr.param01_2 = (EditText)view.findViewById(R.id.f_04_060_param01_2) ; 
		this.fr.param01_3 = (EditText)view.findViewById(R.id.f_04_060_param01_3) ; 
		this.fr.param02_1 = (EditText)view.findViewById(R.id.f_04_060_param02_1) ;   
		this.fr.param02_2 = (EditText)view.findViewById(R.id.f_04_060_param02_2) ;   
		this.fr.param02_3 = (EditText)view.findViewById(R.id.f_04_060_param02_3) ; 
		this.fr.param03_1 = (EditText)view.findViewById(R.id.f_04_060_param03_1) ;   
		this.fr.param03_2 = (EditText)view.findViewById(R.id.f_04_060_param03_2) ;   
		this.fr.param03_3 = (EditText)view.findViewById(R.id.f_04_060_param03_3) ; 
		this.fr.param04_1 = (EditText)view.findViewById(R.id.f_04_060_param04_1) ;   
		this.fr.param04_2 = (EditText)view.findViewById(R.id.f_04_060_param04_2) ;   
		this.fr.param04_3 = (EditText)view.findViewById(R.id.f_04_060_param04_3) ; 
		this.fr.param05_1 = (EditText)view.findViewById(R.id.f_04_060_param05_1) ;   
		this.fr.param05_2 = (EditText)view.findViewById(R.id.f_04_060_param05_2) ;   
		this.fr.param05_3 = (EditText)view.findViewById(R.id.f_04_060_param05_3) ; 
		this.fr.param06_1 = (EditText)view.findViewById(R.id.f_04_060_param06_1) ;   
		this.fr.param06_2 = (EditText)view.findViewById(R.id.f_04_060_param06_2) ;   
		this.fr.param06_3 = (EditText)view.findViewById(R.id.f_04_060_param06_3) ; 
		this.fr.param07_1 = (EditText)view.findViewById(R.id.f_04_060_param07_1) ;   
		this.fr.param07_2 = (EditText)view.findViewById(R.id.f_04_060_param07_2) ;   
		this.fr.param07_3 = (EditText)view.findViewById(R.id.f_04_060_param07_3) ; 
		this.fr.param08_1 = (EditText)view.findViewById(R.id.f_04_060_param08_1) ;   
		this.fr.param08_2 = (EditText)view.findViewById(R.id.f_04_060_param08_2) ;   
		this.fr.param08_3 = (EditText)view.findViewById(R.id.f_04_060_param08_3) ; 
		this.fr.param09_1 = (EditText)view.findViewById(R.id.f_04_060_param09_1) ;   
		this.fr.param09_2 = (EditText)view.findViewById(R.id.f_04_060_param09_2) ;   
		this.fr.param09_3 = (EditText)view.findViewById(R.id.f_04_060_param09_3) ; 
		this.fr.param10_1 = (EditText)view.findViewById(R.id.f_04_060_param10_1) ;   
		this.fr.param10_2 = (EditText)view.findViewById(R.id.f_04_060_param10_2) ;   
		this.fr.param10_3 = (EditText)view.findViewById(R.id.f_04_060_param10_3) ; 
		this.fr.param11_1 = (EditText)view.findViewById(R.id.f_04_060_param11_1) ;   
		this.fr.param11_2 = (EditText)view.findViewById(R.id.f_04_060_param11_2) ;   
		this.fr.param11_3 = (EditText)view.findViewById(R.id.f_04_060_param11_3) ; 
		this.fr.param12_1 = (EditText)view.findViewById(R.id.f_04_060_param12_1) ;   
		this.fr.param12_2 = (EditText)view.findViewById(R.id.f_04_060_param12_2) ;   
		this.fr.param12_3 = (EditText)view.findViewById(R.id.f_04_060_param12_3) ; 
		this.fr.param13_1 = (EditText)view.findViewById(R.id.f_04_060_param13_1) ;   
		this.fr.param13_2 = (EditText)view.findViewById(R.id.f_04_060_param13_2) ;   
		this.fr.param13_3 = (EditText)view.findViewById(R.id.f_04_060_param13_3) ; 
	}
	
	public void initValue(){
	   	Preferences p = Preferences.getInstance() ;
       	String str = null ;
    	str = p.getString(Constant.func_vk_04_060_param01_1);if(!str.equals(Constant.errorStr)){fr.param01_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param01_2);if(!str.equals(Constant.errorStr)){fr.param01_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param01_3);if(!str.equals(Constant.errorStr)){fr.param01_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param02_1);if(!str.equals(Constant.errorStr)){fr.param02_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param02_2);if(!str.equals(Constant.errorStr)){fr.param02_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param02_3);if(!str.equals(Constant.errorStr)){fr.param02_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param03_1);if(!str.equals(Constant.errorStr)){fr.param03_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param03_2);if(!str.equals(Constant.errorStr)){fr.param03_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param03_3);if(!str.equals(Constant.errorStr)){fr.param03_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param04_1);if(!str.equals(Constant.errorStr)){fr.param04_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param04_2);if(!str.equals(Constant.errorStr)){fr.param04_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param04_3);if(!str.equals(Constant.errorStr)){fr.param04_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param05_1);if(!str.equals(Constant.errorStr)){fr.param05_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param05_2);if(!str.equals(Constant.errorStr)){fr.param05_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param05_3);if(!str.equals(Constant.errorStr)){fr.param05_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param06_1);if(!str.equals(Constant.errorStr)){fr.param06_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param06_2);if(!str.equals(Constant.errorStr)){fr.param06_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param06_3);if(!str.equals(Constant.errorStr)){fr.param06_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param07_1);if(!str.equals(Constant.errorStr)){fr.param07_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param07_2);if(!str.equals(Constant.errorStr)){fr.param07_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param07_3);if(!str.equals(Constant.errorStr)){fr.param07_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param08_1);if(!str.equals(Constant.errorStr)){fr.param08_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param08_2);if(!str.equals(Constant.errorStr)){fr.param08_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param08_3);if(!str.equals(Constant.errorStr)){fr.param08_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param09_1);if(!str.equals(Constant.errorStr)){fr.param09_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param09_2);if(!str.equals(Constant.errorStr)){fr.param09_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param09_3);if(!str.equals(Constant.errorStr)){fr.param09_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param10_1);if(!str.equals(Constant.errorStr)){fr.param10_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param10_2);if(!str.equals(Constant.errorStr)){fr.param10_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param10_3);if(!str.equals(Constant.errorStr)){fr.param10_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param11_1);if(!str.equals(Constant.errorStr)){fr.param11_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param11_2);if(!str.equals(Constant.errorStr)){fr.param11_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param11_3);if(!str.equals(Constant.errorStr)){fr.param11_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param12_1);if(!str.equals(Constant.errorStr)){fr.param12_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param12_2);if(!str.equals(Constant.errorStr)){fr.param12_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param12_3);if(!str.equals(Constant.errorStr)){fr.param12_3.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param13_1);if(!str.equals(Constant.errorStr)){fr.param13_1.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param13_2);if(!str.equals(Constant.errorStr)){fr.param13_2.setText(str); } 
    	str = p.getString(Constant.func_vk_04_060_param13_3);if(!str.equals(Constant.errorStr)){fr.param13_3.setText(str); } 
		
	}
	
	public void setFilter(){
		InputFilter[] fils1 = new InputFilter[]{new InputFilter_NumberUnSigned(2)} ;
		this.fr.param01_1.setFilters(fils1);
		this.fr.param02_1.setFilters(fils1);
		this.fr.param03_1.setFilters(fils1);
		this.fr.param04_1.setFilters(fils1);
		this.fr.param05_1.setFilters(fils1);
		this.fr.param06_1.setFilters(fils1);
		this.fr.param07_1.setFilters(fils1);
		this.fr.param08_1.setFilters(fils1);
		this.fr.param09_1.setFilters(fils1);
		this.fr.param10_1.setFilters(fils1);
		this.fr.param11_1.setFilters(fils1);
		this.fr.param12_1.setFilters(fils1);
		this.fr.param13_1.setFilters(fils1);
		
		InputFilter[] fils2 = new InputFilter[]{new InputFilter_NumberUnSigned(3)} ;
		this.fr.param01_2.setFilters(fils2); 
		this.fr.param02_2.setFilters(fils2);
		this.fr.param03_2.setFilters(fils2);
		this.fr.param04_2.setFilters(fils2);
		this.fr.param05_2.setFilters(fils2);
		this.fr.param06_2.setFilters(fils2);
		this.fr.param07_2.setFilters(fils2);
		this.fr.param08_2.setFilters(fils2);
		this.fr.param09_2.setFilters(fils2);
		this.fr.param10_2.setFilters(fils2);
		this.fr.param11_2.setFilters(fils2);
		this.fr.param12_2.setFilters(fils2);
		this.fr.param13_2.setFilters(fils2);
		
		this.fr.param01_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(3)});
		this.fr.param02_3.setFilters(new InputFilter[]{new InputFilter_DecimalSigned(9)});
		this.fr.param03_3.setFilters(new InputFilter[]{new InputFilter_DecimalSigned(11)});
		this.fr.param04_3.setFilters(new InputFilter[]{new InputFilter_DecimalSigned(7)});
		this.fr.param05_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		this.fr.param06_3.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(6)});
		this.fr.param07_3.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(5)});
		this.fr.param08_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		this.fr.param09_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(4)});
		this.fr.param10_3.setFilters(new InputFilter[]{new InputFilter_DecimalSigned(11)});
		this.fr.param11_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		this.fr.param12_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		this.fr.param13_3.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(9)});
	}
	
	public void setTextWatcher(){
		this.fr.param01_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param01_1)); 
		this.fr.param01_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param01_2)); 
		this.fr.param01_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param01_3));
		this.fr.param02_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param02_1)); 
		this.fr.param02_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param02_2)); 
		this.fr.param02_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param02_3));
		this.fr.param03_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param03_1)); 
		this.fr.param03_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param03_2)); 
		this.fr.param03_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param03_3));
		this.fr.param04_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param04_1)); 
		this.fr.param04_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param04_2)); 
		this.fr.param04_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param04_3));
		this.fr.param05_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param05_1)); 
		this.fr.param05_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param05_2)); 
		this.fr.param05_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param05_3));
		this.fr.param06_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param06_1)); 
		this.fr.param06_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param06_2)); 
		this.fr.param06_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param06_3));
		this.fr.param07_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param07_1)); 
		this.fr.param07_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param07_2)); 
		this.fr.param07_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param07_3));
		this.fr.param08_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param08_1)); 
		this.fr.param08_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param08_2)); 
		this.fr.param08_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param08_3));
		this.fr.param09_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param09_1)); 
		this.fr.param09_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param09_2)); 
		this.fr.param09_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param09_3));
		this.fr.param10_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param10_1)); 
		this.fr.param10_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param10_2)); 
		this.fr.param10_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param10_3));
		this.fr.param11_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param11_1)); 
		this.fr.param11_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param11_2)); 
		this.fr.param11_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param11_3));
		this.fr.param12_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param12_1)); 
		this.fr.param12_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param12_2)); 
		this.fr.param12_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param12_3));
		this.fr.param13_1.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param13_1)); 
		this.fr.param13_2.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param13_2)); 
		this.fr.param13_3.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_060_param13_3)); 
	}
}
