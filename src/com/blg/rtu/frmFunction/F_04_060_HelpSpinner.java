package com.blg.rtu.frmFunction;

import java.util.ArrayList;

import com.blg.rtu.util.Constant;
import com.blg.rtu.util.Preferences;
import com.blg.rtu.util.SpinnerVO;
import com.blg.rtu2.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class F_04_060_HelpSpinner implements OnItemSelectedListener {
	
	private F_04_060 fr ;
	
	public F_04_060_HelpSpinner(F_04_060 fr){
		this.fr = fr ;
	}
	
	public void findView(View view){
		this.fr.paramSelect = (Spinner) view.findViewById(R.id.f_04_060_paramSelect);
		this.fr.spinnerAdapter = new ArrayAdapter<SpinnerVO>(this.fr.act, R.layout.spinner_style, new ArrayList<SpinnerVO>());
		this.putSpinnerValue();
		this.fr.spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		// 将adapter 添加到spinner中
		this.fr.paramSelect.setAdapter(this.fr.spinnerAdapter);
		this.fr.paramSelect.setOnItemSelectedListener(this);
		
		int v = Preferences.getInstance().getInt(Constant.func_vk_04_060_paramSelect) ;
		if(v != Constant.errorInt){
			this.fr.paramSelect.setSelection(v); 
		}
	}
	
	public void putSpinnerValue(){
		this.fr.spinnerAdapter.add(new SpinnerVO("0", this.fr.rs.getString(R.string.func_04_060_param01))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("1", this.fr.rs.getString(R.string.func_04_060_param02))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("2", this.fr.rs.getString(R.string.func_04_060_param03))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("3", this.fr.rs.getString(R.string.func_04_060_param04))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("4", this.fr.rs.getString(R.string.func_04_060_param05))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("5", this.fr.rs.getString(R.string.func_04_060_param06))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("6", this.fr.rs.getString(R.string.func_04_060_param07))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("7", this.fr.rs.getString(R.string.func_04_060_param08))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("8", this.fr.rs.getString(R.string.func_04_060_param09))) ;
//		this.fr.spinnerAdapter.add(new SpinnerVO("9", this.fr.rs.getString(R.string.func_04_060_param10))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("10", this.fr.rs.getString(R.string.func_04_060_param11))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("11", this.fr.rs.getString(R.string.func_04_060_param12))) ;
		this.fr.spinnerAdapter.add(new SpinnerVO("12", this.fr.rs.getString(R.string.func_04_060_param13))) ;
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		this.fr.spinnerPosition = position ;
		Preferences.getInstance().putInt(Constant.func_vk_04_060_paramSelect, position) ;
		
		this.fr.lineParamNow.setVisibility(View.GONE) ;
		int dataId = Integer.valueOf(this.fr.spinnerAdapter.getItem(this.fr.spinnerPosition).getId()) ;
		switch(dataId){
		case 0 : {
			this.fr.lineParam01.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam01 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param01)); 
			break;
			}
		case 1 : {
			this.fr.lineParam02.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam02 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param02));
			break;
			}
		case 2 : {
			this.fr.lineParam03.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam03 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param03));
			break;
			}
		case 3 : {
			this.fr.lineParam04.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam04 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param04));
			break;
			}
		case 4 : {
			this.fr.lineParam05.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam05 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param05));
			break;
			}
		case 5 : {
			this.fr.lineParam06.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam06 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param06));
			break;
			}
		case 6 : {
			this.fr.lineParam07.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam07 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param07));
			break;
			}
		case 7 : {
			this.fr.lineParam08.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam08 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param08));
			break;
			}
		case 8 : {
			this.fr.lineParam09.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam09 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param09));
			break;
			}
		case 9 : {
			this.fr.lineParam10.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam10 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param10));
			break;
			}
		case 10 : {
			this.fr.lineParam11.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam11 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param11));
			break;
			}
		case 11 : {
			this.fr.lineParam12.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam12 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param12));
			break;
			}
		case 12 : {
			this.fr.lineParam13.setVisibility(View.VISIBLE) ;
			this.fr.lineParamNow = this.fr.lineParam13 ; 
			this.fr.paramNameSelect.setText(this.fr.rs.getString(R.string.func_04_060_param13));
			break;
			}
		}
	}
	public void onNothingSelected(AdapterView<?> arg0) {
	}

}
