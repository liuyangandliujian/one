package com.liuy.androidmdesignproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.text.SpannableString;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class EnventDispatchActivity extends AppCompatActivity {

//    @BindView(R.id.txt1)
//    TextView txtOneView;
//    @BindView(R.id.edtv1)
//    EditText testEDV;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdispatch);
        unbinder = ButterKnife.bind(this);

    }


//    @OnClick({R.id.txt1, R.id.txt2})
    void hello(View view) {
        if (view.getId() == R.id.txt1) {
            Toast.makeText(this, view.getX()+"$$"+view.getLeft()+"$$"+view.getTranslationX(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "你好22", Toast.LENGTH_SHORT).show();
        }

    }


}
