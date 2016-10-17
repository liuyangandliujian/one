package com.liuy.androidmdesignproject.pullautorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.liuy.androidmdesignproject.R;
import com.liuy.androidmdesignproject.adapter.TestRecyclerAdapter;
import com.liuy.androidmdesignproject.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RefreshActivity extends AppCompatActivity {

    @BindView(R.id.refresh_listview)
    RecyclerView mListView;
    @BindView(R.id.refresh_swipelayout)
    SwipeRefreshLayout mSwipeLayout;
//    LinearLayoutManager layoutManager;
    RefreshAdapter mAdapter;
    List<RefresaData> dataList;
    private Unbinder unbinder;
    private int refrescount;
    private int scrolly;
    GridLayoutManager girdLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_main);
        unbinder = ButterKnife.bind(this);
        initListView();
    }

    private void addData(){
        for(int i=0;i<10;i++){
            RefresaData data=new RefresaData();
            data.setViewType(RefreshAdapter.ITEM_ITEM);
            data.setTitle("标题"+i);
            dataList.add(data);
        }
        RefresaData data=new RefresaData();
        data.setViewType(RefreshAdapter.ITEM_LOAD_FOOTER);
        data.setTitle("加载");
        dataList.add(data);
    }

    private void addReData(){
        for(int i=0;i<10;i++){
            RefresaData data=new RefresaData();
            data.setViewType(RefreshAdapter.ITEM_ITEM);
            data.setTitle("标题"+i);
            dataList.add(data);
        }
        RefresaData data=new RefresaData();
        data.setViewType(RefreshAdapter.ITEM_LOAD_FOOTER);
        data.setTitle("加载");
        dataList.add(data);
    }
    private void initListView(){
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataList.clear();
                        addReData();
                        mAdapter.notifyDataSetChanged();
                        mAdapter.changeMoreStatus(RefreshAdapter.PULLUP_LOAD_MORE);
                        mSwipeLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
        dataList=new ArrayList<RefresaData>();
        addData();

        //网格
        girdLayoutManager = new GridLayoutManager(this, 2);
        girdLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItemViewType(position)== RefreshAdapter.ITEM_LOAD_FOOTER ? girdLayoutManager.getSpanCount() : 1;
            }
        });
        mListView.setLayoutManager(girdLayoutManager);

//        layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mListView.setHasFixedSize(true);
//        mListView.setItemAnimator(new DefaultItemAnimator());
//        mListView.setLayoutManager(layoutManager);



//        mListView.addItemDecoration(new RecycleViewDivider(
//                this, LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.transparent)));
        mAdapter=new RefreshAdapter(this,dataList);
        mListView.setAdapter(mAdapter);
        mAdapter.setListen(new RefreshAdapter.RefreshListen() {
            @Override
            public void onLoadMore() {
                loadMore();
            }

            @Override
            public void onRefresh() {

            }
        });
        //向上滑动，当滑到底的时候,有上滑的趋势，就加载更多
        mListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrolly+=dy;
                Log.d("test","laitem="+ girdLayoutManager.findLastVisibleItemPosition()+"********count="+mAdapter.getItemCount());
                if(scrolly>0&&dy>=0){
                    if(!mSwipeLayout.isRefreshing()&&mAdapter.getLoad_more_status()==mAdapter.PULLUP_LOAD_MORE){
                        int lastVisibleItem = girdLayoutManager.findLastVisibleItemPosition();
                        Log.d("test","lastVisibleItem="+lastVisibleItem+"&&itemcount="+mAdapter.getItemCount());
                        if(lastVisibleItem+2==mAdapter.getItemCount()||lastVisibleItem+1==mAdapter.getItemCount()||lastVisibleItem==mAdapter.getItemCount()){
                            //调用Adapter里的changeMoreStatus方法来改变加载脚View的显示状态为：正在加载...
                            Log.d("test","刷新"+refrescount++);
                            loadMore();
                        }
                    }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("test","onScrollStateChanged"+newState);
//                if(!mSwipeLayout.isRefreshing()){
//                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
////                    newState==RecyclerView.SCROLL_STATE_IDLE
//                    Log.d("test","newState"+newState+"lastVisibleItem="+lastVisibleItem+"&&itemcount="+mAdapter.getItemCount());
//                    if(lastVisibleItem+1==mAdapter.getItemCount()){
//                        //调用Adapter里的changeMoreStatus方法来改变加载脚View的显示状态为：正在加载...
//                        Log.d("test","刷新"+refrescount++);
//                        mAdapter.changeMoreStatus(RefreshAdapter.ISLOADING);
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                int starti=dataList.size();
//                                for(int i=starti;i<starti+10;i++){
//                                    RefresaData data=new RefresaData();
//                                    data.setViewType(RefreshAdapter.ITEM_ITEM);
//                                    data.setTitle("标题"+i);
//                                    dataList.add(dataList.size()-1,data);
//                                }
//                                mAdapter.notifyDataSetChanged();
//                                //当加载完数据后，再恢复加载脚View的显示状态为：上拉加载更多
//                                mAdapter.changeMoreStatus(RefreshAdapter.PULLUP_LOAD_MORE);
//                            }
//                        },3000);
//                    }
//                }
            }
        });

//        mListView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if(!mSwipeLayout.isRefreshing()){
//                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
////                    newState==RecyclerView.SCROLL_STATE_IDLE
//                    Log.d("test","lastVisibleItem="+lastVisibleItem+"&&itemcount="+mAdapter.getItemCount());
//                    if(lastVisibleItem+1==mAdapter.getItemCount()){
//                        //调用Adapter里的changeMoreStatus方法来改变加载脚View的显示状态为：正在加载...
//                        Log.d("test","刷新"+refrescount++);
//                        mAdapter.changeMoreStatus(RefreshAdapter.ISLOADING);
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                int starti=dataList.size();
//                                for(int i=starti;i<starti+10;i++){
//                                    RefresaData data=new RefresaData();
//                                    data.setViewType(RefreshAdapter.ITEM_ITEM);
//                                    data.setTitle("标题"+i);
//                                    dataList.add(dataList.size()-1,data);
//                                }
//                                mAdapter.notifyDataSetChanged();
//                                //当加载完数据后，再恢复加载脚View的显示状态为：上拉加载更多
//                                mAdapter.changeMoreStatus(RefreshAdapter.PULLUP_LOAD_MORE);
//                            }
//                        },3000);
//                    }
//                }
//            }
//        });
    }

    private void loadMore(){
        mAdapter.changeMoreStatus(RefreshAdapter.ISLOADING);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //当加载完数据后，再恢复加载脚View的显示状态为：上拉加载更多
                int starti=dataList.size();
                for(int i=starti;i<starti+10;i++){
                    RefresaData data=new RefresaData();
                    data.setViewType(RefreshAdapter.ITEM_ITEM);
                    data.setTitle("标题"+i);
                    dataList.add(dataList.size()-1,data);
                }
                if(dataList.size()>60){
                    mAdapter.changeMoreStatus(RefreshAdapter.PULLUP_LOAD_FINISH);
                }else{
                    mAdapter.changeMoreStatus(RefreshAdapter.PULLUP_LOAD_MORE);
                }
                mAdapter.notifyDataSetChanged();
            }
        },3000);

    }
}
