package com.liuy.androidmdesignproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.liuy.androidmdesignproject.adapter.TestRecyclerAdapter;
import com.liuy.androidmdesignproject.recycleviewutils.EndlessRecyclerOnScrollListener;
import com.liuy.androidmdesignproject.recycleviewutils.utils.RecyclerViewStateUtils;
import com.liuy.androidmdesignproject.recycleviewutils.weight.LoadingFooter;
import com.liuy.androidmdesignproject.widget.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuy
 * @Date 2016/8/12 09:32
 * @since 3.0
 */
public class TestComplexViewActivity extends Activity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rlistview);
        initRecyclerView();
    }

    private void initRecyclerView() {

//        LinearLayoutManager:线性布局,横向或者纵向滑动列表
//        GridLayoutManager:表格布局
//        StaggeredGridLayoutManager:流式布局,例如瀑布流效果

//        RecyclerView.Adapter 可以托管的数据集合,为每一项Item创建视图并且绑定数据
//        RecyclerView.ViewHolder 承载Item视图的子布局
//        RecyclerView.LayoutManager 负责Item视图的布局的显示管理
//        RecyclerView.ItemDecoration 给每一项Item添加子View,例如可以进行割线之类
//        RecyclerView.ItemAnimator 负责处理数据添加或者删除时候的动画效果

        mRecyclerView.addOnScrollListener(mOnScrollListener);

        //设置固定大小
        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(
//                this, LinearLayoutManager.VERTICAL, 100, getResources().getColor(R.color.transparent)));




        List<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            dataList.add("item" + i);
        }
        View headerView = LayoutInflater.from(this).inflate(R.layout.activity_recycleview_headerview, null);


        final TestRecyclerAdapter adapter = new TestRecyclerAdapter(this, dataList,headerView, TestRecyclerAdapter.LayoutType.GRIDLAYOUT);

        //网格
        final GridLayoutManager girdLayoutManager = new GridLayoutManager(this, 2);

        girdLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position)==TestRecyclerAdapter.HEAD_VIEW ? girdLayoutManager.getSpanCount() : 1;
            }
        });
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        //给RecyclerView设置布局管理器 https://github.com/chiuki/android-recyclerview/tree/master/app/src/main/java/com/sqisland/android/recyclerview
        mRecyclerView.setLayoutManager(girdLayoutManager);

//        GridLayoutManager manager = new GridLayoutManager(this, 2);
//        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) mRecyclerView.getAdapter(), manager.getSpanCount()));
//        mRecyclerView.setLayoutManager(manager);

        //列表
        //创建线性布局
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
//        // OrientationHelper.HORIZONTAL 水平方向
//        // OrientationHelper.VERTICAL 垂直方向
//        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
//       //给RecyclerView设置布局管理器
//        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }


    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener() {

        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);

//            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
//            if(state == LoadingFooter.State.Loading) {
//                Log.d("@Cundong", "the state is Loading, just wait..");
//                return;
//            }

//            if (mCurrentCounter < TOTAL_COUNTER) {
//                // loading more
                RecyclerViewStateUtils.setFooterViewState(TestComplexViewActivity.this, mRecyclerView, 10, LoadingFooter.State.Loading, null);
//                requestData();
//            } else {
//                //the end
//                RecyclerViewStateUtils.setFooterViewState(EndlessGridLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);
//            }
        }
    };
}
