package com.liuy.androidmdesignproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuy.androidmdesignproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuy
 * @Date 2016/8/12 09:53
 * @since 3.0
 */
public class TestRecyclerAdapter extends RecyclerView.Adapter {

    private List<String> dataList;
    private LayoutInflater mInflater;
    public static final int HEAD_VIEW = 0;
    public static final int BODY_GIRD_VIEW = 1;
    public static final int BODY_LIST_VIEW = 2;
    public static final int FOOT_VIEW = 3;
    private View headerView;
    private LayoutType layoutType;

    //    private List<View> mHeaderViews;
//    private List<View> mFootViews;
//    static final ArrayList<View> EMPTY_INFO_LIST =
//            new ArrayList<View>();
    public enum LayoutType {
        LINERLAOUT,
        GRIDLAYOUT;
    }

    public TestRecyclerAdapter(Context context, List<String> dataList, View headerView, LayoutType layoutType) {
        this.dataList = dataList;
        mInflater = LayoutInflater.from(context);
        this.headerView = headerView;
        this.layoutType = layoutType;
//        if (mHeaderViews == null) {
//            this.mHeaderViews = EMPTY_INFO_LIST;
//        } else {
//            this.mHeaderViews = mHeaderViews;
//        }
//        if (mHeaderViews == null) {
//            this.mFootViews = EMPTY_INFO_LIST;
//        } else {
//            this.mFootViews = mFootViews;
//        }
    }
//
//    public int getHeadersCount() {
//        return mHeaderViews.size();
//    }
//
//    public int getFootersCount() {
//        return mFootViews.size();
//    }

    public boolean isHasheaderView() {
        return headerView != null;
    }

    @Override
    public int getItemViewType(int position) {

        if (isHasheaderView() && position == 0) {
            return HEAD_VIEW;
        }
        if(layoutType==LayoutType.GRIDLAYOUT){
            return BODY_GIRD_VIEW;
        }else{
            return BODY_LIST_VIEW;
        }
    }

    public String getItemData(int position) {
        if (isHasheaderView()) {
            dataList.get(position - 1);
        }
        return dataList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEAD_VIEW) {
//            View headerView = mInflater.inflate(R.layout.activity_recycleview_headerview, null);
            HeaderViewHolder viewHolder = new HeaderViewHolder(headerView);
            return viewHolder;
        } else if(viewType==BODY_GIRD_VIEW){
            View litemView = mInflater.inflate(R.layout.activity_recycleview_griditem, null);
            GridItemViewHolder viewHolder = new GridItemViewHolder(litemView);
            return viewHolder;
        }else{
            View litemView = mInflater.inflate(R.layout.activity_recycleview_listitem, null);
            ListItemViewHolder viewHolder = new ListItemViewHolder(litemView);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEAD_VIEW) {
            //可处理 可不处理
//            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
//            headerViewHolder.refreshData(dataList.get(position));
        } else if(getItemViewType(position)==BODY_GIRD_VIEW){
            GridItemViewHolder listItemViewHolder = (GridItemViewHolder) holder;
            listItemViewHolder.refreshData(getItemData(position));
        }else {
            ListItemViewHolder listItemViewHolder = (ListItemViewHolder) holder;
            listItemViewHolder.refreshData(getItemData(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            initview(itemView);
        }

        private void initview(View itemView) {
            nameView = (TextView) itemView.findViewById(R.id.header_name);
            nameView.setText("asdfffffff");
        }

        private void refreshData(String name) {
            nameView.setText(name);
        }
    }

    private class ListItemViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            initview(itemView);
        }

        private void initview(View itemView) {
            nameView = (TextView) itemView.findViewById(R.id.item_name);
        }

        private void refreshData(String name) {
            nameView.setText(name);
        }
    }

    private class GridItemViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView;

        public GridItemViewHolder(View itemView) {
            super(itemView);
            initview(itemView);
        }

        private void initview(View itemView) {
            nameView = (TextView) itemView.findViewById(R.id.item_name);
        }

        private void refreshData(String name) {
            nameView.setText(name);
        }
    }
}
