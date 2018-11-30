package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2018/11/22.
 */

public class ClickEventViewGroup extends FrameLayout {

    static final String TAG = "ClickEventViewGroup";

    public ClickEventViewGroup(@NonNull Context context) {
        super(context);
    }

    public ClickEventViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickEventViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("asker",TAG+getId()+"           dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("asker",TAG+getId()+"           onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("asker",TAG+getId()+"           onTouchEvent");
        return super.onTouchEvent(event);
    }
}
