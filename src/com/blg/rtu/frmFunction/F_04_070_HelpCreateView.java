package com.blg.rtu.frmFunction;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.blg.rtu.R;

public class F_04_070_HelpCreateView {
	private F_04_070 fr ;
	
	public F_04_070_HelpCreateView(F_04_070 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		fr.cb01 = (CheckBox)view.findViewById(R.id.f_04_070_item01); 
		fr.cb02 = (CheckBox)view.findViewById(R.id.f_04_070_item02); 
		fr.cb03 = (CheckBox)view.findViewById(R.id.f_04_070_item03); 
		fr.cb04 = (CheckBox)view.findViewById(R.id.f_04_070_item04); 
		fr.cb05 = (CheckBox)view.findViewById(R.id.f_04_070_item05); 
		fr.cb06 = (CheckBox)view.findViewById(R.id.f_04_070_item06); 
		fr.cb07 = (CheckBox)view.findViewById(R.id.f_04_070_item07); 
		fr.cb08 = (CheckBox)view.findViewById(R.id.f_04_070_item08); 
		fr.cb09 = (CheckBox)view.findViewById(R.id.f_04_070_item09); 
		fr.cb10 = (CheckBox)view.findViewById(R.id.f_04_070_item10); 
		fr.cb11 = (CheckBox)view.findViewById(R.id.f_04_070_item11); 
		fr.cb12 = (CheckBox)view.findViewById(R.id.f_04_070_item12); 
		fr.cb13 = (CheckBox)view.findViewById(R.id.f_04_070_item13); 
		fr.cb14 = (CheckBox)view.findViewById(R.id.f_04_070_item14); 
		fr.cb15 = (CheckBox)view.findViewById(R.id.f_04_070_item15); 
		
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
	}


}
