package com.liuy.androidmdesignproject.enventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * @author liuy
 * @Date 2016/8/29 17:53
 * @since 3.0
 */
public class RootViewGourp extends FrameLayout {
    public RootViewGourp(Context context) {
        super(context);
    }

    public RootViewGourp(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RootViewGourp(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("test","RootViewGourp dispatchTouchEvent"+ev.getAction());
        if(ev.getAction()==MotionEvent.ACTION_DOWN||ev.getAction()==MotionEvent.ACTION_UP){
             return super.dispatchTouchEvent(ev);
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("test","RootViewGourp onInterceptTouchEvent"+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("test","RootViewGourp onTouchEvent"+event.getAction());
        return super.onTouchEvent(event);
    }
}
