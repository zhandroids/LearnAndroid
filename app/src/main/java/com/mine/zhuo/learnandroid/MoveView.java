package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/11/22.
 */

public class MoveView extends Button {

    private int lastX;
    private int lastY;
    private Scroller scroller;

    public MoveView(Context context) {
        super(context);
        init();
    }

    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
         scroller = new Scroller(getContext());
    }

    private void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int scrollY = getScrollY();

        Log.e("asker","scrollX = "+scrollX+"  scrollY = "+scrollY);

        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;

        Log.e("asker","deltaX = "+deltaX+"  destY = "+destY);
        scroller.startScroll(scrollX,scrollY,deltaX,deltaY,10000);
        invalidate();



    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - lastX;
                int deltaY = y - lastY;
                smoothScrollTo(x,y);

//                int translationX = (int) (getTranslationX()+deltaX);
//                int translationY = (int) (getTranslationY()+deltaY);
//
//                setTranslationX(translationX);
//                setTranslationY(translationY);

                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }

//        lastX = x;
//        lastY = y;

        return true;
    }
}
