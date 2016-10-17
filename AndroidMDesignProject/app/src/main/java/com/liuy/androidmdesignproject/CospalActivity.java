package com.liuy.androidmdesignproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

/**
 * 折叠滑动布局
 *
 * @author liuy
 *         http://www.jianshu.com/p/f418bf95db2d
 *         toolbar学习 http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1118/2006.html
 *                     http://www.codeceo.com/article/android-toolbar-develop.html
 * @Date 2016/7/4 15:22
 * @since 3.0
 */
public class CospalActivity extends Activity {
//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cospal);

//        AppBarLayout a=null;
//        CollapsingToolbarLayout.LayoutParams b=(CollapsingToolbarLayout.LayoutParams)a.getLayoutParams();


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//// App Logo
//        toolbar.setLogo(R.mipmap.ic_launcher);
//// Title
//        toolbar.setTitle("My Title");
//// Sub Title
//        toolbar.setSubtitle("Sub title");
//
//        setSupportActionBar(toolbar);
//
//// Navigation Icon 要設定在 setSupoortActionBar 才有作用
//// 否則會出現 back button
//        toolbar.setNavigationIcon(R.drawable.ab_android);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件
                                double value = 19329.234234;
                                double mvalue = (double) Math.round(value * 100) / 100;
                                Log.d("test", "mvalue=" + mvalue);

                            }
                        }).show();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

//    @Override
//    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onPostCreate(savedInstanceState, persistentState);
//    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        return super.onCreateDescription();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
