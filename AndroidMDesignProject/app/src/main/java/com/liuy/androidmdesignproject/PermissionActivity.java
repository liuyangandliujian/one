package com.liuy.androidmdesignproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.liuy.androidmdesignproject.permission.AllowPermissions;
import com.liuy.androidmdesignproject.permission.PermissionFail;
import com.liuy.androidmdesignproject.permission.PermissionGen;
import com.liuy.androidmdesignproject.permission.PermissionSuccess;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//https://developer.android.com/training/permissions/requesting.html 官方文档
//https://developer.android.com/guide/topics/security/permissions.html#normal-dangerous
//https://developer.android.com/training/permissions/requesting.html
public class PermissionActivity extends AppCompatActivity {

    @BindView(R.id.carme)
    TextView carme;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.sdcard)
    TextView sdcard;
    private Unbinder unbinder;

    private PermissionActivity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_main);
        unbinder = ButterKnife.bind(this);
        thisActivity=this;
    }

    @OnClick(R.id.carme)
    void carme(View view) {

        if (ContextCompat.checkSelfPermission(thisActivity,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(thisActivity,
                        new String[]{Manifest.permission.CAMERA},
                        1001);

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(thisActivity,
                        new String[]{Manifest.permission.CAMERA},
                        1001);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1001: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast.makeText(thisActivity,"授权成功",Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(thisActivity,"授权失败",Toast.LENGTH_SHORT).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
//
//    @Override public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                                     int[] grantResults) {
//        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//    }
//
//    @PermissionSuccess(requestCode = 100)
//    public void doSomething(){
//        Toast.makeText(this, "carme permission is granted", Toast.LENGTH_SHORT).show();
//    }
//
//    @PermissionFail(requestCode = 100)
//    public void doFailSomething(){
//        Toast.makeText(this, "carme permission is not granted", Toast.LENGTH_SHORT).show();
//    }
//
//
//    @OnClick(R.id.phone)
//    void phone(View view) {
//
//
//    }
//
//    @OnClick(R.id.sdcard)
//    void sdcard(View view) {
//
//
//    }
}
