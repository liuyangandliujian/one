package com.liuy.androidmdesignproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

/**
 * toolbar使用详解
 */
public class ToolBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //设置导航图标
        toolbar.setNavigationIcon(R.mipmap.cs_home_item_ec_back);
        //设置Logo
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        toolbar.setLogo(null);
//        toolbar.getLogo().setVisible(false,false);
        //设置标题
        toolbar.setTitle("我的主页3");
        //设置标题颜色
        toolbar.setTitleTextColor(getResources().getColor(R.color.highlight_color_orangered));
        //设置子标题
        toolbar.setSubtitle("Subtitle");
//        setSupportActionBar(toolbar);

        //设置右上角的填充菜单
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
//        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(ToolBarActivity.this, "功能1", Toast.LENGTH_SHORT).show();
                } else if (menuItemId == R.id.action_notification) {
                    Toast.makeText(ToolBarActivity.this, "功能2", Toast.LENGTH_SHORT).show();
                } else if (menuItemId == R.id.action_item1) {
                    Toast.makeText(ToolBarActivity.this, "功能3", Toast.LENGTH_SHORT).show();
                } else if (menuItemId == R.id.action_item2) {
                    Toast.makeText(ToolBarActivity.this, "功能4", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

}
