package com.blg.rtu.frmFunction;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.blg.rtu.R;

public class F_08_050_HelpCreateView {
	private F_08_050 fr ;
	
	public F_08_050_HelpCreateView(F_08_050 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		fr.cb01_01_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_01_y); 
		fr.cb01_01_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_01_n);
		fr.cb01_02_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_02_y);  
		fr.cb01_02_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_02_n);
		fr.cb01_03_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_03_y);  
		fr.cb01_03_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_03_n);
		fr.cb01_04_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_04_y);  
		fr.cb01_04_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_04_n);
		fr.cb01_05_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_05_y);  
		fr.cb01_05_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_05_n);
		fr.cb01_06_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_06_y);  
		fr.cb01_06_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_06_n);
		fr.cb01_07_y = (CheckBox)view.findViewById(R.id.f_08_050_item01_07_y);  
		fr.cb01_07_n = (CheckBox)view.findViewById(R.id.f_08_050_item01_07_n);
		
	}
	
	public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheck){
		fr.cb01_01_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_01_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_02_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_02_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_03_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_03_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_04_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_04_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_05_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_05_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_06_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_06_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_07_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb01_07_n.setOnCheckedChangeListener(onCheck) ;
	}

}
