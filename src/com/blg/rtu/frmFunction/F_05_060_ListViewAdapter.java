package com.blg.rtu.frmFunction;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blg.rtu.MainActivity;
import com.blg.rtu.R;

public class F_05_060_ListViewAdapter extends BaseAdapter {
	
    private MainActivity act;
    private F_05_060 fragment;
    
    public F_05_060_ListViewAdapter(MainActivity act, F_05_060 fragment) {
        this.act = act ;
        this.fragment = fragment ;
    }
    
    @Override
    public int getCount() {
        return this.fragment.logList.size();
    }
    
    @Override
    public Object getItem(int position) {
        return this.fragment.logList.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
    	ListHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(act).inflate(R.layout.listview_rtu_logs, null);

            holder = new ListHolder();
            holder.indexView = (TextView)convertView.findViewById(R.id.rtuLog_index);
            holder.hexView = (TextView)convertView.findViewById(R.id.rtuLogHex);
            
            convertView.setTag(holder);
        }else{
            holder=(ListHolder) convertView.getTag();
        }
        
        F_05_060_ListViewItem vo = this.fragment.logList.get(position) ;
        holder.indexView.setText("" + vo.index);
        holder.hexView.setText(vo.logHex);
        if(vo.loseLog != null && vo.loseLog.booleanValue()){
            holder.indexView.setTextColor(Color.RED);
            holder.hexView.setTextColor(Color.RED);
        }else{
            holder.indexView.setTextColor(Color.BLACK);
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
		TextView indexView ;
		TextView hexView ;
	}	
}

