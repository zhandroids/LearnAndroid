package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/11/22.
 */

public class ClickEventView extends TextView {

    static final String TAG = "ClickEventView";

    public ClickEventView(@NonNull Context context) {
        super(context);
    }

    public ClickEventView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickEventView(@NonNull Context context, @Nullable AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("asker",TAG+"            dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("asker",TAG+"           onTouchEvent");
        return super.onTouchEvent(event);
    }
}
