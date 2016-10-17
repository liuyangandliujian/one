package com.liuy.androidmdesignproject;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.liuy.androidmdesignproject.widget.StatusBarCompatTest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt1)
    TextView txtOneView;
    @BindView(R.id.edtv1)
    EditText testEDV;

    private Unbinder unbinder;

    private StringBuffer sb=new StringBuffer();
    private SpannableString txtString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StatusBarCompatTest.compat(this,getResources().getColor(R.color.colorPrimary));
//        StatusBarCompatTest.compat(this,getResources().getColor(R.color.colorPrimary));

//        int color = getResources().getColor(R.color.colorPrimary);
//        StatusBarCompat.setStatusBarColor(this, color);
//        StatusBarCompat2.setStatusBarColor(this, color);
//        StatusBarCompat2.setStatusBarColor(this);
//           StatusBarCompat.compat(this,color);



        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
//        StatusBarCompatTest.compat(this, color);
//        StatusBarCompat.init(this, Color.parseColor("#303F9F"));


//        SpannableString str=new SpannableString(sb);
//        testEDV.setText(str);

//        testEDV.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                return false;
//            }
//        });
//
//        testEDV.removeTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.d("test","beforeTextChanged");
//                Log.d("test",s+"-"+start+"-"+count+"-"+after);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("test","onTextChanged");
//                Log.d("test",s+"-"+start+"-"+count+"-"+before);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

//        testEDV.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                if(start>1){
//                    String str=s.toString().substring(start-1,start);
//                    //表示向前删除
//                    if(str.equals("#")&&after==0){
//                         //找到前面的#
//                        str.inde
//                    }
//                }
//
//
//                Log.d("test","beforeTextChanged");
//                Log.d("test",s+"-"+start+"-"+count+"-"+after);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("test","onTextChanged");
//                Log.d("test",s+"-"+start+"-"+count+"-"+before);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d("test","afterTextChanged");
//            }
//        });

    }


    @OnClick({R.id.txt1, R.id.txt2})
    void hello(View view) {
        if (view.getId() == R.id.txt1) {
            Toast.makeText(this, view.getX()+"$$"+view.getLeft()+"$$"+view.getTranslationX(), Toast.LENGTH_SHORT).show();

//            Toast.makeText(this, "你好11221", Toast.LENGTH_SHORT).show();
//            txtOneView.setText("解绑了");
//            int color = getResources().getColor(R.color.wh);
//        StatusBarCompat.setStatusBarColor(this, color);
//        StatusBarCompat2.setStatusBarColor(this, color);
//        StatusBarCompat2.setStatusBarColor(this);
//           StatusBarCompat.compat(this,color);

//            StatusBarCompatTest.compat(this, 0xFFFFFF);
        } else {
            Toast.makeText(this, "你好22", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 去图片颜色
     *
     * @param map
     */
    private void getRGB(Bitmap map) {
        Palette.from(map).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant =
                        palette.getVibrantSwatch();
                if (vibrant != null) {
//                    titleView.setBackgroundColor(
//                            vibrant.getRgb());
//                    titleView.setTextColor(
//                            vibrant.getTitleTextColor());
                }
            }
        });
    }

}
