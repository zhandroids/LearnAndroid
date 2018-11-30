package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * @author Administrator
 */
public class HorizontalScrollViewEx extends ViewGroup {

    private Scroller mScroller;

    private VelocityTracker velocityTracker;
    private int mChildSize;
    private int mChildIndex;
    private int childViewWidth;
    private int mInterceptX;
    private int mInterceptY;

    private int mLastX;
    private int mLastY;

    public HorizontalScrollViewEx(Context context) {
        super(context);
        init();
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
        velocityTracker = VelocityTracker.obtain();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercept = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                    intercept = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(x - mInterceptX) >= Math.abs(y - mInterceptY)) {
                    intercept = true;
                } else {
                    intercept = false;
                }
                break;

            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
            default:
                break;

        }
        mLastX =x;
        mLastY =y;

        mInterceptY = y;
        mInterceptX = x;
        return intercept;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        velocityTracker.addMovement(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                scrollBy(-deltaX, 0);

                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                velocityTracker.computeCurrentVelocity(1000);
                float xVelocity = velocityTracker.getXVelocity();
                if (Math.abs(xVelocity) >= 50) {
                    mChildIndex = xVelocity > 0 ? mChildIndex - 1 : mChildIndex + 1;
                } else {
                    mChildIndex = (scrollX + childViewWidth / 2) / childViewWidth;
                }

                mChildIndex = Math.max(0, Math.min(mChildIndex, mChildSize - 1));
                int dx = mChildIndex * childViewWidth - scrollX;

                smoothScrollBy(dx, 0);
                velocityTracker.clear();

                break;
            default:
                break;
        }

        mLastX = x;
        mLastY = y;


        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = 0;
        int height = 0;
        int childCount = getChildCount();
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthSpaceMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpaceMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);

        if (childCount == 0) {
            //如果子View数量为0,设置Viewgroup本身的宽高为0
            setMeasuredDimension(0, 0);

        } else {
            View childView = getChildAt(0);
            if (widthSpaceMode == MeasureSpec.AT_MOST && heightSpaceMode == MeasureSpec.AT_MOST) {
                width = childView.getMeasuredWidth() * childCount;
                height = childView.getMeasuredHeight();
                setMeasuredDimension(width, height);

            } else if (widthSpaceMode == MeasureSpec.AT_MOST) {
                width = childView.getMeasuredWidth() * childCount;
                setMeasuredDimension(width, heightSpaceSize);


            } else if (heightSpaceMode == MeasureSpec.AT_MOST) {
                height = childView.getMeasuredHeight();
                setMeasuredDimension(widthSpaceSize, height);
            }
        }


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;

        int childCount = getChildCount();
        mChildSize = childCount;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            int childWidth = childView.getMeasuredWidth();
            childViewWidth = childWidth;
            childView.layout(childLeft, 0, childLeft + childWidth, getMeasuredHeight());
            childLeft += childWidth;


        }

    }

    private void smoothScrollBy(int dx, int dy) {
        mScroller.startScroll(getScrollX(), 0, dx, 0, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
