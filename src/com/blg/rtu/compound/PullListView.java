package com.blg.rtu.compound;


import java.util.Date;


import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blg.rtu.util.DateTime;
import com.blg.rtu1.R;

public class PullListView extends ListView implements OnScrollListener {

	/*
	 * 状态转换过程:
	 * ->RELEASE_To_REFRESH(拉到位了，显示松开刷新)->REFRESHING(显示刷新)
	 * DONE(完工)->PULL_To_REFRESH(下拉刷新)
	 * ->DONE(没拉到位就推回或松开了)
	 */
	private final static int DONE = 0;
	private final static int PULL_To_REFRESH = 1;
	private final static int RELEASE_To_REFRESH = 2;
	private final static int REFRESHING = 3;
	private final static int LOADING = 4;//这个状态没有用到(没有语句state=LOADING)

	// 实际的padding的距离与界面上偏移距离的比例
	private final static int RATIO = 3;
	
	private LayoutInflater inflater;

	private LinearLayout headView;

	private TextView tipsTextview;
	private TextView lastUpdatedTextView;
	private ImageView arrowImageView;
	private ProgressBar progressBar;


	private RotateAnimation animation;
	private RotateAnimation reverseAnimation;

	// 用于保证startY的值在一个完整的touch事件中只被记录一次
	private boolean hasRecordStartY;

//	private int headContentWidth;
	private int headContentHeight;

	private int startY;
	private int firstItemIndex;//列表中，显示的第一个项目

	private int state;

	private boolean isBack;

	private OnRefreshListener refreshListener;//下拉刷新监听器

	private boolean canRefreshable;//可以执行下拉刷新
	
	private String text_pull ;
	private String text_release ;
	private String loading ;
	private String last ;


	public PullListView(Context context) {
		super(context);
		init(context);
	}

	public PullListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		Resources rs = context.getResources() ;
		setCacheColorHint(rs.getColor(R.color.transparent));
		text_pull = rs.getString(R.string.pullListView_pull) ;
		text_release = rs.getString(R.string.pullListView_release) ;
		loading = rs.getString(R.string.pullListView_loading) ;
		last = rs.getString(R.string.pullListView_last) ;
		inflater = LayoutInflater.from(context);

		headView = (LinearLayout) inflater.inflate(R.layout.listview_refresh, null);

		arrowImageView = (ImageView) headView.findViewById(R.id.head_arrowImageView);
		arrowImageView.setMinimumWidth(70);
		arrowImageView.setMinimumHeight(50);
		progressBar = (ProgressBar) headView.findViewById(R.id.head_progressBar);
		tipsTextview = (TextView) headView.findViewById(R.id.head_tipsTextView);
		lastUpdatedTextView = (TextView) headView.findViewById(R.id.head_lastUpdatedTextView);

		measureView(headView);
		headContentHeight = headView.getMeasuredHeight();
//		headContentWidth = headView.getMeasuredWidth();

		headView.setPadding(0, -1 * headContentHeight, 0, 0);
		headView.invalidate();


		addHeaderView(headView, null, false);
		setOnScrollListener(this);

		animation = new RotateAnimation(0, -180,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		animation.setInterpolator(new LinearInterpolator());
		animation.setDuration(250);
		animation.setFillAfter(true);

		reverseAnimation = new RotateAnimation(-180, 0,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		reverseAnimation.setInterpolator(new LinearInterpolator());
		reverseAnimation.setDuration(200);
		reverseAnimation.setFillAfter(true);

		state = DONE;
		canRefreshable = false;
	}

	@Override
	public void onScroll(AbsListView view , int firstVisiableItem, int visibleItemCount , int totalItemCount ) {
		firstItemIndex = firstVisiableItem;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState ) {
	}
	@Override
	public void smoothScrollToPosition(int position) {
		super.smoothScrollToPosition(position);
	}


	public boolean onTouchEvent(MotionEvent event) {

		if (canRefreshable) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (firstItemIndex == 0 && !hasRecordStartY) {
					hasRecordStartY = true;
					//在down时候记录当前位置	
					startY = (int) event.getY();
				}
				break;

			case MotionEvent.ACTION_UP:

				if (state != REFRESHING && state != LOADING) {
					if (state == DONE) {
						// 什么都不做
					}
					if (state == PULL_To_REFRESH) {
						//由下拉刷新状态，到done状态
						state = DONE;
						changeHeaderViewByState();
					}
					if (state == RELEASE_To_REFRESH) {
						//由松开刷新状态，到done状态
						state = REFRESHING;
						changeHeaderViewByState();
						onRefresh();
					}
				}

				hasRecordStartY = false;
				isBack = false;

				break;

			case MotionEvent.ACTION_MOVE:
				int tempY = (int) event.getY();

				if (!hasRecordStartY && firstItemIndex == 0) {
					//在move时候记录下位置
					hasRecordStartY = true;
					startY = tempY;
				}

				if (state != REFRESHING && hasRecordStartY && state != LOADING) {
					// 保证在设置padding的过程中，当前的位置一直是在head，否则如果当列表超出屏幕的话，当在上推的时候，列表会同时进行滚动
					// 可以松手去刷新了
					if (state == RELEASE_To_REFRESH) {
						setSelection(0);
						// 往上推了，推到了屏幕足够掩盖head的程度，但是还没有推到全部掩盖的地步
						if (((tempY - startY) / RATIO < headContentHeight) && (tempY - startY) > 0) {
							//由松开刷新状态转变到下拉刷新状态
							state = PULL_To_REFRESH;
							changeHeaderViewByState();
						}
						// 一下子推到顶了
						else if (tempY - startY <= 0) {
							//由松开刷新状态转变到done状态
							state = DONE;
							changeHeaderViewByState();
						}
						// 往下拉了，或者还没有上推到屏幕顶部掩盖head的地步
						else {
							// 不用进行特别的操作，只用更新paddingTop的值就行了
						}
					}
					// 还没有到达显示松开刷新的时候,DONE或者是PULL_To_REFRESH状态
					if (state == PULL_To_REFRESH) {
						setSelection(0);
						// 下拉到可以进入RELEASE_TO_REFRESH的状态
						if ((tempY - startY) / RATIO >= headContentHeight) {
							//由done或者下拉刷新状态转变到松开刷新
							state = RELEASE_To_REFRESH;
							isBack = true;
							changeHeaderViewByState();
						}
						// 由下拉转为上推，并上推到顶了
						else if (tempY - startY <= 0) {
							//由DOne或者下拉刷新状态转变到done状态
							state = DONE;
							changeHeaderViewByState();
						}
					}

					// done状态下
					if (state == DONE) {
						if (tempY - startY > 0) {
							state = PULL_To_REFRESH;
							changeHeaderViewByState();
						}
					}

					// 更新headView的size
					if (state == PULL_To_REFRESH) {
						headView.setPadding(0, -1 * headContentHeight + (tempY - startY) / RATIO, 0, 0);

					}

					// 更新headView的paddingTop
					if (state == RELEASE_To_REFRESH) {
						headView.setPadding(0, (tempY - startY) / RATIO - headContentHeight, 0, 0);
					}

				}

				break;
			}
		}

		return super.onTouchEvent(event);
	}

	// 当状态改变时候，调用该方法，以更新界面
	private void changeHeaderViewByState() {
		switch (state) {
		case RELEASE_To_REFRESH:
			//当前状态，松开刷新
			arrowImageView.setVisibility(View.VISIBLE);
			progressBar.setVisibility(View.GONE);
			tipsTextview.setVisibility(View.VISIBLE);
			lastUpdatedTextView.setVisibility(View.VISIBLE);

			arrowImageView.clearAnimation();
			arrowImageView.startAnimation(animation);

			tipsTextview.setText(text_release); 
			break;
		case PULL_To_REFRESH:
			progressBar.setVisibility(View.GONE);
			tipsTextview.setVisibility(View.VISIBLE);
			lastUpdatedTextView.setVisibility(View.VISIBLE);
			arrowImageView.clearAnimation();
			arrowImageView.setVisibility(View.VISIBLE);
			// 是由RELEASE_To_REFRESH状态转变来的
			//当前状态，下拉刷新
			if (isBack) {
				isBack = false;
				arrowImageView.clearAnimation();
				arrowImageView.startAnimation(reverseAnimation);

				tipsTextview.setText(text_pull);
			} else {
				tipsTextview.setText(text_pull);
			}
			break;

		case REFRESHING:
			//当前状态,正在刷新...
			headView.setPadding(0, 0, 0, 0);
			progressBar.setVisibility(View.VISIBLE);
			arrowImageView.clearAnimation();
			arrowImageView.setVisibility(View.GONE);
			tipsTextview.setText(loading);
			lastUpdatedTextView.setVisibility(View.VISIBLE);
			break;
		case DONE:
			//当前状态，done
			headView.setPadding(0, -1 * headContentHeight, 0, 0);
			progressBar.setVisibility(View.GONE);
			arrowImageView.clearAnimation();
			arrowImageView.setImageResource(R.drawable.arrow);
			tipsTextview.setText(text_pull);
			lastUpdatedTextView.setVisibility(View.VISIBLE);
			break;
		}
	}

	public void setOnRefreshListener(OnRefreshListener refreshListener) {
		this.refreshListener = refreshListener;
		canRefreshable = true;
	}

	public interface OnRefreshListener {
		public void onRefresh();
	}

	public void onRefreshComplete() {
		state = DONE;
		lastUpdatedTextView.setText(last + DateTime.yyyy_MM_dd_HH_mm_ss());
		changeHeaderViewByState();
	}

	private void onRefresh() {
		if (refreshListener != null) {
			refreshListener.onRefresh();
		}
	}

	// 此方法直接照搬自网络上的一个下拉刷新的demo，此处是“估计”headView的width以及height
	private void measureView(View child) {
		ViewGroup.LayoutParams p = child.getLayoutParams();
		if (p == null) {
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
		int lpHeight = p.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		child.measure(childWidthSpec, childHeightSpec);
	}

	@SuppressWarnings("deprecation")
	public void setAdapter(BaseAdapter adapter) {
		lastUpdatedTextView.setText(last + new Date().toLocaleString());
		super.setAdapter(adapter);
	}

}
