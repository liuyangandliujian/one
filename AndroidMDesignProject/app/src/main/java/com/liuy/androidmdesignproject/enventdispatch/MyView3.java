package com.liuy.androidmdesignproject.enventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * @author liuy
 * @Date 2016/8/29 17:52
 * @since 3.0
 */
public class MyView3 extends TextView{
    public MyView3(Context context) {
        super(context);
    }

    public MyView3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("test","MyView3 dispatchTouchEvent"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("test","MyView3 onTouchEvent"+event.getAction());
        return super.onTouchEvent(event);
    }

}
