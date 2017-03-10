package com.blg.rtu.frmChannel.helpCh4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
//import android.widget.LinearLayout;
import android.widget.TextView;

import com.blg.rtu.frmChannel.ChFragment_04;
import com.blg.rtu1.MainActivity;
import com.blg.rtu1.R;

public class RtuDataListViewAdapter extends BaseAdapter {
	
    private MainActivity act;
    private ChFragment_04 fragment;
//    private int charCountPerLine ;
    
    public RtuDataListViewAdapter(MainActivity act, ChFragment_04 fragment) {
        this.act = act ;
        this.fragment = fragment ;
//        this.charCountPerLine = charCountPerLine  ;
    }
    
    @Override
    public int getCount() {
        return this.fragment.rtuDatas.size();
    }
    
    @Override
    public Object getItem(int position) {
        return this.fragment.rtuDatas.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
    	ListHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(act).inflate(R.layout.listview_rtu_com_results, null);

            holder = new ListHolder();
            holder.idCodeChannelView = (TextView)convertView.findViewById(R.id.rtuData_id_code_channel);
            holder.dtView = (TextView)convertView.findViewById(R.id.rtuData_dt);
            holder.hexView = (TextView)convertView.findViewById(R.id.rtuData_hex);
            
            convertView.setTag(holder);
        }else{
            holder=(ListHolder) convertView.getTag();
        }
        
        ListRtuData vo = this.fragment.rtuDatas.get(position) ;
        holder.idCodeChannelView.setText(vo.direct+ ":" + vo.rtuId + " / " + vo.code + " / " + vo.channel);
        holder.dtView.setText(vo.dt);
        
        /*
        int len = vo.hex.length() ;
        int lines = len/charCountPerLine ;
        if(len%charCountPerLine != 0){
        	lines += 1 ;
        }
        //holder.hexView.setHeight(30 + lines * 10) ;
        
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)holder.hexView.getLayoutParams() ;
        if(lines == 1){
        	params.height = 90  ;//1dp = 3
        }else{
           	if(lines == 2 ){
        		params.height = 120 ;
        	}else if(lines < 9){
        		params.height = lines * 55 ;
        	}else{
        		params.height = lines * 50 ;
        	}        	
        }
        
        holder.hexView.setLayoutParams(params);
        */
        
        
        holder.hexView.setText(vo.hex);
        if(vo.clicked){
            holder.idCodeChannelView.setTextColor(Color.BLUE);
            holder.dtView.setTextColor(Color.BLUE);
            holder.hexView.setTextColor(Color.BLUE);
        }else{
            holder.idCodeChannelView.setTextColor(Color.BLACK);
            holder.dtView.setTextColor(Color.BLACK);
            holder.hexView.setTextColor(Color.BLACK);
        }
        
		//以供事件监听用
        //holder.itemView.setTag(R.string.pullListView_item_position_key, position) ;
        
        return convertView;
    }
    
    
    @Override
	public int getItemViewType(int position) {
		return super.getItemViewType(position);
	}

	@Override
	public int getViewTypeCount() {
		return super.getViewTypeCount();
	}


	class ListHolder {
		TextView idCodeChannelView ;
		TextView dtView ;
		TextView hexView ;
	}	
}

