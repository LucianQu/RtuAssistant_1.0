package com.blg.rtu.compound;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 可以设定高度的listview
 * @author Administrator
 *
 */
public class FixHeightListView extends ListView {

    /** listview高度 */
    private int listViewHeight;

    public int getListViewHeight() {
            return listViewHeight;
    }

    public void setListViewHeight(int listViewHeight) {
            this.listViewHeight = listViewHeight;
    }

    public FixHeightListView(Context context) {
            super(context);
    }

    public FixHeightListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
    }

    public FixHeightListView(Context context, AttributeSet attrs) {
            super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            // TODO Auto-generated method stub
            if (listViewHeight > -1) {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(listViewHeight, MeasureSpec.AT_MOST);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
