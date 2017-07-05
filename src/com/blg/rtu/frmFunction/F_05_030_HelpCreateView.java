package com.blg.rtu.frmFunction;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.blg.rtu2.R;

public class F_05_030_HelpCreateView {
	private F_05_030 fr ;
	
	public F_05_030_HelpCreateView(F_05_030 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		fr.cb01_01_y = (CheckBox)view.findViewById(R.id.f_05_030_item01_01_y); 
		fr.cb01_01_n = (CheckBox)view.findViewById(R.id.f_05_030_item01_01_n);
		fr.cb01_02_y = (CheckBox)view.findViewById(R.id.f_05_030_item01_02_y);  
		fr.cb01_02_n = (CheckBox)view.findViewById(R.id.f_05_030_item01_02_n);
		fr.cb01_03_y = (CheckBox)view.findViewById(R.id.f_05_030_item01_03_y);  
		fr.cb01_03_n = (CheckBox)view.findViewById(R.id.f_05_030_item01_03_n);
		fr.cb01_04_y = (CheckBox)view.findViewById(R.id.f_05_030_item01_04_y);  
		fr.cb01_04_n = (CheckBox)view.findViewById(R.id.f_05_030_item01_04_n);
		fr.cb01_05_y = (CheckBox)view.findViewById(R.id.f_05_030_item01_05_y);  
		fr.cb01_05_n = (CheckBox)view.findViewById(R.id.f_05_030_item01_05_n);
		
		fr.cb02_01_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_01_y);  
		fr.cb02_01_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_01_n);
		fr.cb02_02_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_02_y);  
		fr.cb02_02_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_02_n);
		fr.cb02_03_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_03_y);  
		fr.cb02_03_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_03_n);
		fr.cb02_04_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_04_y);  
		fr.cb02_04_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_04_n);
		fr.cb02_05_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_05_y);  
		fr.cb02_05_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_05_n);
		fr.cb02_06_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_06_y);  
		fr.cb02_06_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_06_n);
		fr.cb02_07_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_07_y);  
		fr.cb02_07_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_07_n);
		fr.cb02_08_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_08_y);  
		fr.cb02_08_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_08_n);
		fr.cb02_09_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_09_y);  
		fr.cb02_09_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_09_n);
		fr.cb02_10_y = (CheckBox)view.findViewById(R.id.f_05_030_item02_10_y);  
		fr.cb02_10_n = (CheckBox)view.findViewById(R.id.f_05_030_item02_10_n);
		
		fr.cb03_01_y = (CheckBox)view.findViewById(R.id.f_05_030_item03_01_y);  
		fr.cb03_01_n = (CheckBox)view.findViewById(R.id.f_05_030_item03_01_n);
		fr.cb03_02_y = (CheckBox)view.findViewById(R.id.f_05_030_item03_02_y);  
		fr.cb03_02_n = (CheckBox)view.findViewById(R.id.f_05_030_item03_02_n);
		fr.cb03_03_y = (CheckBox)view.findViewById(R.id.f_05_030_item03_03_y);  
		fr.cb03_03_n = (CheckBox)view.findViewById(R.id.f_05_030_item03_03_n);
		fr.cb03_04_y = (CheckBox)view.findViewById(R.id.f_05_030_item03_04_y);  
		fr.cb03_04_n = (CheckBox)view.findViewById(R.id.f_05_030_item03_04_n);
		fr.cb03_05_y = (CheckBox)view.findViewById(R.id.f_05_030_item03_05_y);  
		fr.cb03_05_n = (CheckBox)view.findViewById(R.id.f_05_030_item03_05_n);
		fr.cb03_06_y = (CheckBox)view.findViewById(R.id.f_05_030_item03_06_y);  
		fr.cb03_06_n = (CheckBox)view.findViewById(R.id.f_05_030_item03_06_n);
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

		fr.cb02_01_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_01_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_02_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_02_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_03_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_03_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_04_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_04_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_05_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_05_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_06_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_06_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_07_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_07_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_08_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_08_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_09_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_09_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_10_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb02_10_n.setOnCheckedChangeListener(onCheck) ;

		fr.cb03_01_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_01_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_02_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_02_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_03_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_03_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_04_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_04_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_05_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_05_n.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_06_y.setOnCheckedChangeListener(onCheck) ;
		fr.cb03_06_n.setOnCheckedChangeListener(onCheck) ;		
	}

}
