package com.blg.rtu.frmFunction;

import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.InputFilter_NumberUnSigned;
import com.blg.rtu3.R;

public class F_04_080_HelpCreateView {
	private F_04_080 fr ;
	
	public F_04_080_HelpCreateView(F_04_080 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		/*fr.cb01 = (CheckBox)view.findViewById(R.id.f_item_cb_01); 
		fr.cb02 = (CheckBox)view.findViewById(R.id.f_item_cb_02); */
		fr.cb03 = (CheckBox)view.findViewById(R.id.f_item_cb_03); 
		/*fr.cb04 = (CheckBox)view.findViewById(R.id.f_item_cb_04); 
		fr.cb05 = (CheckBox)view.findViewById(R.id.f_item_cb_05); 
		fr.cb06 = (CheckBox)view.findViewById(R.id.f_item_cb_06); 
		fr.cb07 = (CheckBox)view.findViewById(R.id.f_item_cb_07); 
		fr.cb08 = (CheckBox)view.findViewById(R.id.f_item_cb_08); 
		fr.cb09 = (CheckBox)view.findViewById(R.id.f_item_cb_09); 
		fr.cb10 = (CheckBox)view.findViewById(R.id.f_item_cb_10); 
		fr.cb11 = (CheckBox)view.findViewById(R.id.f_item_cb_11); 
		fr.cb12 = (CheckBox)view.findViewById(R.id.f_item_cb_12); 
		fr.cb13 = (CheckBox)view.findViewById(R.id.f_item_cb_13); 
		fr.cb14 = (CheckBox)view.findViewById(R.id.f_item_cb_14); */
		
		
		/*fr.item01 = (EditText)view.findViewById(R.id.f_04_080_item01); 
		fr.item02 = (EditText)view.findViewById(R.id.f_04_080_item02);*/ 
		fr.item03 = (EditText)view.findViewById(R.id.f_04_080_item03); 
		/*fr.item04 = (EditText)view.findViewById(R.id.f_04_080_item04); 
		fr.item05 = (EditText)view.findViewById(R.id.f_04_080_item05); 
		fr.item06 = (EditText)view.findViewById(R.id.f_04_080_item06); 
		fr.item07 = (EditText)view.findViewById(R.id.f_04_080_item07); 
		fr.item08 = (EditText)view.findViewById(R.id.f_04_080_item08); 
		fr.item09 = (EditText)view.findViewById(R.id.f_04_080_item09); 
		fr.item10 = (EditText)view.findViewById(R.id.f_04_080_item10); 
		fr.item11 = (EditText)view.findViewById(R.id.f_04_080_item11); 
		fr.item12 = (EditText)view.findViewById(R.id.f_04_080_item12); 
		fr.item13 = (EditText)view.findViewById(R.id.f_04_080_item13); 
		fr.item14 = (EditText)view.findViewById(R.id.f_04_080_item14); */
	}
	
	public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheck){
	/*	fr.cb01.setOnCheckedChangeListener(onCheck) ;
		fr.cb02.setOnCheckedChangeListener(onCheck) ;*/
		fr.cb03.setOnCheckedChangeListener(onCheck) ;
		/*fr.cb04.setOnCheckedChangeListener(onCheck) ;
		fr.cb05.setOnCheckedChangeListener(onCheck) ;
		fr.cb06.setOnCheckedChangeListener(onCheck) ;
		fr.cb07.setOnCheckedChangeListener(onCheck) ;
		fr.cb08.setOnCheckedChangeListener(onCheck) ;
		fr.cb09.setOnCheckedChangeListener(onCheck) ;
		fr.cb10.setOnCheckedChangeListener(onCheck) ;
		fr.cb11.setOnCheckedChangeListener(onCheck) ;
		fr.cb12.setOnCheckedChangeListener(onCheck) ;
		fr.cb13.setOnCheckedChangeListener(onCheck) ;
		fr.cb14.setOnCheckedChangeListener(onCheck) ;*/
	}
	
	public void setFilter(){
		InputFilter[] inFilt = new InputFilter[]{new InputFilter_NumberUnSigned(4)} ;
		/*fr.item01.setFilters(inFilt);
		fr.item01.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_01));
		fr.item02.setFilters(inFilt);
		fr.item02.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_02));*/
		fr.item03.setFilters(inFilt);
		fr.item03.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_03));
		/*fr.item04.setFilters(inFilt);
		fr.item04.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_04));
		fr.item05.setFilters(inFilt);
		fr.item05.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_05));
		fr.item06.setFilters(inFilt);
		fr.item06.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_06));
		fr.item07.setFilters(inFilt);
		fr.item07.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_07));
		fr.item08.setFilters(inFilt);
		fr.item08.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_08));
		fr.item09.setFilters(inFilt);
		fr.item09.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_09));
		fr.item10.setFilters(inFilt);
		fr.item10.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_10));
		fr.item11.setFilters(inFilt);
		fr.item11.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_11));
		fr.item12.setFilters(inFilt);
		fr.item12.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_12));
		fr.item13.setFilters(inFilt);
		fr.item13.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_13));
		fr.item14.setFilters(inFilt);
		fr.item14.addTextChangedListener(new MyTextWatcher(Constant.func_vk_04_080_item_14));*/
		
		//设置只是数字软件键盘
		/*fr.item01.setInputType(InputType.TYPE_CLASS_NUMBER); 
		fr.item02.setInputType(InputType.TYPE_CLASS_NUMBER);*/
		fr.item03.setInputType(InputType.TYPE_CLASS_NUMBER);
		/*fr.item04.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item05.setInputType(InputType.TYPE_CLASS_NUMBER); 
		fr.item06.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item07.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item08.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item09.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item10.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item11.setInputType(InputType.TYPE_CLASS_NUMBER); 
		fr.item12.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item13.setInputType(InputType.TYPE_CLASS_NUMBER);
		fr.item14.setInputType(InputType.TYPE_CLASS_NUMBER);*/
	}

}
