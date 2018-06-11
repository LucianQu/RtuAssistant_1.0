package com.blg.rtu.frmFunction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blg.rtu3.MainActivity;
import com.blg.rtu3.R;

public class F_05_040_ListViewAdapter extends BaseAdapter {
	
    private MainActivity act;
    private F_05_040 fragment;
    
    public F_05_040_ListViewAdapter(MainActivity act, F_05_040 fragment) {
        this.act = act ;
        this.fragment = fragment ;
    }
    
    @Override
    public int getCount() {
        return this.fragment.dataList.size();
    }
    
    @Override
    public Object getItem(int position) {
        return this.fragment.dataList.get(position);
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
        
        F_05_040_ListViewItem vo = this.fragment.dataList.get(position) ;
        holder.indexView.setText("" + (vo.index == null?"":vo.index)) ;
        holder.hexView.setText("" + vo.dataStr);
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

