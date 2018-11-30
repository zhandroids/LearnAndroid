package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/11/21.
 */

public class MyTextView extends TextView implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    GestureDetector gestureDetector;
    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

         gestureDetector = new GestureDetector(getContext(),this);

//        gestureDetector.setOnDoubleTapListener(this);

        //解决长按屏幕后无法拖动的现象
        gestureDetector.setIsLongpressEnabled(false);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        VelocityTracker velocityTracker = VelocityTracker.obtain();
//        velocityTracker.addMovement(event);
//        velocityTracker.computeCurrentVelocity(1000);
//
//        /*假设手指从下向上滑动  获取到的Y为负值*/
//        //x轴方向的速度
//        int xVelocity = (int) velocityTracker.getXVelocity();
//        //y轴方向的速度
//        int yVelocity = (int) velocityTracker.getYVelocity();
//
//        /*
//        * do your things
//        * */
//
//        //使用完成需要重置并回收内存
//        velocityTracker.clear();
//        velocityTracker.recycle();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.e("asker"," MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("asker"," MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("asker"," MotionEvent.ACTION_UP");
                break;
        }

        boolean consume = gestureDetector.onTouchEvent(event);
        return consume;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        //手指
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.e("asker"," onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }


    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.e("asker"," onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.e("asker","onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.e("asker","onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.e("asker","onDoubleTapEvent");
        return false;
    }
}
