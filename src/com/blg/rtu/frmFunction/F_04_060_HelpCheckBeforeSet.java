package com.blg.rtu.frmFunction;


import com.blg.rtu.protocol.p206.cd20.Param_20;
import com.blg.rtu.util.DialogAlarm;
import com.blg.rtu2.MainActivity;
import com.blg.rtu2.R;

public class F_04_060_HelpCheckBeforeSet {
	
	private MainActivity act ;
	private F_04_060 fr ;
	
	public F_04_060_HelpCheckBeforeSet(MainActivity act, F_04_060 fr){
		this.fr = fr ;
		this.act = (MainActivity)act ;
	}

	/**
	 * 设置命令前进行检查
	 * @return
	 */
	protected boolean checkBeforeSet(boolean showDialog){
		boolean flag = true ;
		String paramName = null ;
		String temp = null ;
		Integer number = 0 ;
		Integer interval = 0 ;
		Double db = 0.0 ;
		int id = Integer.valueOf(this.fr.spinnerAdapter.getItem(this.fr.spinnerPosition).getId()) ;
		switch(id){
		case 0 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param01) ;
			temp = this.fr.param01_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param01_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param01_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0.1 || db > 9.9){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0.1~9.9)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 1 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param02) ;
			temp = this.fr.param02_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param02_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param02_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < -9999.999 || db > 9999.999){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(-9999.999~9999.999)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 2 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param03) ;
			temp = this.fr.param03_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param03_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param03_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < -999999.999 || db > 999999.999){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(-999999.999~999999.999)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 3 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param04) ;
			temp = this.fr.param04_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param04_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param04_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < -99.999 || db > 99.999){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(-99.999~99.999)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 4 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param05) ;
			temp = this.fr.param05_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param05_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param05_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 999.99){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~999.99)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 5 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param06) ;
			temp = this.fr.param06_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param06_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param06_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 999999){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~999999)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 6 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param07) ;
			temp = this.fr.param07_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param07_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param07_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 99999){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~99999)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 7 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param08) ;
			temp = this.fr.param08_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param08_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param08_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 999.99){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~999.99)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 8 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param09) ;
			temp = this.fr.param09_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param09_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param09_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 99.9){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~99.9)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 9 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param10) ;
			temp = this.fr.param10_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param10_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param10_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < -999999.999 || db > 999999.999){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(-999999.999~999999.999)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 10 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param11) ;
			temp = this.fr.param11_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param11_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param11_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 999.9){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~999.9)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 11 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param12) ;
			temp = this.fr.param12_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param12_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param12_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 9999.9){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~9999.9)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		case 12 : {
			paramName = this.fr.rs.getString(R.string.func_04_060_param13) ;
			temp = this.fr.param13_1.getText().toString() ;
			if(temp == null || temp.trim().equals("")){
				if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "参数编号必须填写！") ;
				flag = false ;
			}
			if(flag){
				number = Integer.valueOf(temp) ;
				flag = checkNumber(number, paramName, showDialog) ;
				if(flag){
					temp = this.fr.param13_2.getText().toString() ;
					if(temp == null || temp.trim().equals("")){
						if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "存储间隔必须填写！") ;
						flag = false ;
					}
					if(flag){
						interval = Integer.valueOf(temp) ;
						flag = checkInterval(interval, paramName, showDialog) ;
						if(flag){
							temp = this.fr.param13_3.getText().toString() ;
							if(temp == null || temp.trim().equals("")){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值必须填写！") ;
								flag = false ;
							}
							db = Double.valueOf(temp) ;
							if(db < 0 || db > 999999.99){
								if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "启报阈值超出合法范围(0~999999.99)") ;
								flag = false ;
							}
						}
					}
				}
			}
			break;
			}
		}
		
		if(flag){
			fr.param = new Param_20() ;
			fr.param.setDataType(id) ;
			fr.param.setDataCount_1to15(number) ;
			fr.param.setSaveInterval_1to255(interval) ;
			fr.param.setThreshold(db) ;
		}

		return flag ;
	}
	
	private boolean checkNumber(int number, String paramName, boolean showDialog){
		if(number < 1 || number > 15){
			if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "的参数编号超出合法范围(1~15)") ;
			return false ;
		}else{
			return true ;
		}
	}
	private boolean checkInterval(int interval, String paramName, boolean showDialog){
		if(interval < 1 || interval > 255){
			if(showDialog)new DialogAlarm().showDialog(act, "出错，" + paramName + "的固态存储时间段间隔超出合法范围(1~255)") ;
			return false ;
		}else{
			return true ;
		}
	}

}
