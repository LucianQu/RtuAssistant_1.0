package com.blg.rtu.frmFunction;

import android.text.InputFilter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.InputFilter_DecimalUnSigned;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu2.R;

public class F_04_040_HelpCreateView {
	private F_04_040 fr ;
	
	public F_04_040_HelpCreateView(F_04_040 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		fr.cb01 = (CheckBox)view.findViewById(R.id.func_item_q_01); 
		fr.cb02 = (CheckBox)view.findViewById(R.id.func_item_q_02); 
		fr.cb03 = (CheckBox)view.findViewById(R.id.func_item_q_03); 
		fr.cb04 = (CheckBox)view.findViewById(R.id.func_item_q_04); 
		fr.cb05 = (CheckBox)view.findViewById(R.id.func_item_q_05); 
		fr.cb06 = (CheckBox)view.findViewById(R.id.func_item_q_06); 
		fr.cb07 = (CheckBox)view.findViewById(R.id.func_item_q_07); 
		fr.cb08 = (CheckBox)view.findViewById(R.id.func_item_q_08); 
		fr.cb09 = (CheckBox)view.findViewById(R.id.func_item_q_09); 
		fr.cb10 = (CheckBox)view.findViewById(R.id.func_item_q_10); 
		fr.cb11 = (CheckBox)view.findViewById(R.id.func_item_q_11); 
		fr.cb12 = (CheckBox)view.findViewById(R.id.func_item_q_12); 
		fr.cb13 = (CheckBox)view.findViewById(R.id.func_item_q_13); 
		fr.cb14 = (CheckBox)view.findViewById(R.id.func_item_q_14); 
		fr.cb15 = (CheckBox)view.findViewById(R.id.func_item_q_15); 
		fr.cb16 = (CheckBox)view.findViewById(R.id.func_item_q_16); 
		fr.cb17 = (CheckBox)view.findViewById(R.id.func_item_q_17); 
		fr.cb18 = (CheckBox)view.findViewById(R.id.func_item_q_18); 
		fr.cb19 = (CheckBox)view.findViewById(R.id.func_item_q_19); 
		fr.cb20 = (CheckBox)view.findViewById(R.id.func_item_q_20); 
		fr.cb21 = (CheckBox)view.findViewById(R.id.func_item_q_21); 
		fr.cb22 = (CheckBox)view.findViewById(R.id.func_item_q_22); 
		fr.cb23 = (CheckBox)view.findViewById(R.id.func_item_q_23); 
		fr.cb24 = (CheckBox)view.findViewById(R.id.func_item_q_24); 
		fr.cb25 = (CheckBox)view.findViewById(R.id.func_item_q_25); 
		fr.cb26 = (CheckBox)view.findViewById(R.id.func_item_q_26); 
		fr.cb27 = (CheckBox)view.findViewById(R.id.func_item_q_27); 
		fr.cb28 = (CheckBox)view.findViewById(R.id.func_item_q_28); 
		fr.cb29 = (CheckBox)view.findViewById(R.id.func_item_q_29); 
		fr.cb30 = (CheckBox)view.findViewById(R.id.func_item_q_30); 
		fr.cb31 = (CheckBox)view.findViewById(R.id.func_item_q_31); 
		fr.cb32 = (CheckBox)view.findViewById(R.id.func_item_q_32); 
		fr.cb33 = (CheckBox)view.findViewById(R.id.func_item_q_33); 
		fr.cb34 = (CheckBox)view.findViewById(R.id.func_item_q_34); 
		fr.cb35 = (CheckBox)view.findViewById(R.id.func_item_q_35); 	
		
		
		fr.item01 = (EditText)view.findViewById(R.id.func_04_040_item01); 
		fr.item02 = (EditText)view.findViewById(R.id.func_04_040_item02); 
		fr.item03 = (EditText)view.findViewById(R.id.func_04_040_item03); 
		fr.item04 = (EditText)view.findViewById(R.id.func_04_040_item04); 
		fr.item05 = (EditText)view.findViewById(R.id.func_04_040_item05); 
		fr.item06 = (EditText)view.findViewById(R.id.func_04_040_item06); 
		fr.item07 = (EditText)view.findViewById(R.id.func_04_040_item07); 
		fr.item08 = (EditText)view.findViewById(R.id.func_04_040_item08); 
		fr.item09 = (EditText)view.findViewById(R.id.func_04_040_item09); 
		fr.item10 = (EditText)view.findViewById(R.id.func_04_040_item10); 
		fr.item11 = (EditText)view.findViewById(R.id.func_04_040_item11); 
		fr.item12 = (EditText)view.findViewById(R.id.func_04_040_item12); 
		fr.item13 = (EditText)view.findViewById(R.id.func_04_040_item13); 
		fr.item14 = (EditText)view.findViewById(R.id.func_04_040_item14); 
		fr.item15 = (EditText)view.findViewById(R.id.func_04_040_item15); 
		fr.item16 = (EditText)view.findViewById(R.id.func_04_040_item16); 
		fr.item17 = (EditText)view.findViewById(R.id.func_04_040_item17); 
		fr.item18 = (EditText)view.findViewById(R.id.func_04_040_item18); 
		fr.item19 = (EditText)view.findViewById(R.id.func_04_040_item19); 
		fr.item20 = (EditText)view.findViewById(R.id.func_04_040_item20); 
		fr.item21 = (EditText)view.findViewById(R.id.func_04_040_item21); 
		fr.item22 = (EditText)view.findViewById(R.id.func_04_040_item22); 
		fr.item23 = (EditText)view.findViewById(R.id.func_04_040_item23); 
		fr.item24 = (EditText)view.findViewById(R.id.func_04_040_item24); 
		fr.item25 = (EditText)view.findViewById(R.id.func_04_040_item25); 
		fr.item26 = (EditText)view.findViewById(R.id.func_04_040_item26); 
		fr.item27 = (EditText)view.findViewById(R.id.func_04_040_item27); 
		fr.item28 = (EditText)view.findViewById(R.id.func_04_040_item28); 
		fr.item29 = (EditText)view.findViewById(R.id.func_04_040_item29); 
		fr.item30 = (EditText)view.findViewById(R.id.func_04_040_item30); 
		fr.item31 = (EditText)view.findViewById(R.id.func_04_040_item31); 
		fr.item32 = (EditText)view.findViewById(R.id.func_04_040_item32); 
		fr.item33 = (EditText)view.findViewById(R.id.func_04_040_item33); 
		fr.item34 = (EditText)view.findViewById(R.id.func_04_040_item34); 
		fr.item35 = (EditText)view.findViewById(R.id.func_04_040_item35); 
		
	}
	
	public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheck){
		fr.cb01.setOnCheckedChangeListener(onCheck) ;
		fr.cb02.setOnCheckedChangeListener(onCheck) ;
		fr.cb03.setOnCheckedChangeListener(onCheck) ;
		fr.cb04.setOnCheckedChangeListener(onCheck) ;
		fr.cb05.setOnCheckedChangeListener(onCheck) ;
		fr.cb06.setOnCheckedChangeListener(onCheck) ;
		fr.cb07.setOnCheckedChangeListener(onCheck) ;
		fr.cb08.setOnCheckedChangeListener(onCheck) ;
		fr.cb09.setOnCheckedChangeListener(onCheck) ;
		fr.cb10.setOnCheckedChangeListener(onCheck) ;
		fr.cb11.setOnCheckedChangeListener(onCheck) ;
		fr.cb12.setOnCheckedChangeListener(onCheck) ;
		fr.cb13.setOnCheckedChangeListener(onCheck) ;
		fr.cb14.setOnCheckedChangeListener(onCheck) ;
		fr.cb15.setOnCheckedChangeListener(onCheck) ;
		fr.cb16.setOnCheckedChangeListener(onCheck) ;
		fr.cb17.setOnCheckedChangeListener(onCheck) ;
		fr.cb18.setOnCheckedChangeListener(onCheck) ;
		fr.cb19.setOnCheckedChangeListener(onCheck) ;
		fr.cb20.setOnCheckedChangeListener(onCheck) ;
		fr.cb21.setOnCheckedChangeListener(onCheck) ;
		fr.cb22.setOnCheckedChangeListener(onCheck) ;
		fr.cb23.setOnCheckedChangeListener(onCheck) ;
		fr.cb24.setOnCheckedChangeListener(onCheck) ;
		fr.cb25.setOnCheckedChangeListener(onCheck) ;
		fr.cb26.setOnCheckedChangeListener(onCheck) ;
		fr.cb27.setOnCheckedChangeListener(onCheck) ;
		fr.cb28.setOnCheckedChangeListener(onCheck) ;
		fr.cb29.setOnCheckedChangeListener(onCheck) ;
		fr.cb30.setOnCheckedChangeListener(onCheck) ;
		fr.cb31.setOnCheckedChangeListener(onCheck) ;
		fr.cb32.setOnCheckedChangeListener(onCheck) ;
		fr.cb33.setOnCheckedChangeListener(onCheck) ;
		fr.cb34.setOnCheckedChangeListener(onCheck) ;
		fr.cb35.setOnCheckedChangeListener(onCheck) ;
	}
	
	public void setFilter(){
		fr.item01.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(4)});
		fr.item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_01));
		fr.item02.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_02));
		fr.item03.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_03));
		fr.item04.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item04.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_04));
		fr.item05.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(5)});
		fr.item05.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_05));
		fr.item06.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item06.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_06));
		fr.item07.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(3)});
		fr.item07.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_07));
		fr.item08.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item08.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_08));
		fr.item09.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item09.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_09));
		fr.item10.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(7)});
		fr.item10.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_10));
		fr.item11.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item11.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_11));
		fr.item12.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item12.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_12));
		fr.item13.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(7)});
		fr.item13.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_13));
		fr.item14.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item14.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_14));
		fr.item15.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item15.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_15));
		fr.item16.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item16.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_16));
		fr.item17.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item17.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_17));
		fr.item18.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item18.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_18));
		fr.item19.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item19.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_19));
		fr.item20.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item20.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_20));
		fr.item21.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item21.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_21));
		fr.item22.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item22.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_22));
		fr.item23.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item23.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_23));
		fr.item24.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item24.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_24));
		fr.item25.setFilters(new InputFilter[]{new InputFilter_NumberUnSigned(10)});
		fr.item25.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_25));
		fr.item26.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(7)});
		fr.item26.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_26));
		fr.item27.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(9)});
		fr.item27.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_27));
		fr.item28.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(6)});
		fr.item28.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_28));
		fr.item29.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item29.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_29));
		fr.item30.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item30.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_30));
		fr.item31.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item31.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_31));
		fr.item32.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(5)});
		fr.item32.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_32));
		fr.item33.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item33.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_33));
		fr.item34.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item34.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_34));
		fr.item35.setFilters(new InputFilter[]{new InputFilter_DecimalUnSigned(8)});
		fr.item35.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_040_item_35));		
	}

}
