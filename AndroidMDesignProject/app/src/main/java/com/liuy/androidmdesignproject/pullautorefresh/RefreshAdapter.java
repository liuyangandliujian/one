package com.liuy.androidmdesignproject.pullautorefresh;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.liuy.androidmdesignproject.R;

import java.util.List;

/**
 * @author liuy
 * @Date 2016/10/14 15:25
 * @since 3.0
 */

public class RefreshAdapter extends RecyclerView.Adapter {

    public static final int ITEM_HEADER = 0;
    public static final int ITEM_ITEM = 1;
    public static final int ITEM_LOAD_FOOTER = 2;

    //点击加载
    public static final int PULLUP_LOAD_MORE=0;
    //正在加载...
    public static final int ISLOADING=1;
    //加载完成
    public static final int PULLUP_LOAD_FINISH=2;
    //上拉加载的显示状态，初始为0
    private int load_more_status=0;

    private RefreshListen listen;

    public interface RefreshListen{
        void onLoadMore();
        void onRefresh();
    }

    List<RefresaData> dataList;
    private Context mContext;
    public RefreshAdapter(Context mContext, List<RefresaData> dataList){
        this.mContext=mContext;
       this.dataList=dataList;
    }

    public RefreshListen getListen() {
        return listen;
    }

    public void setListen(RefreshListen listen) {
        this.listen = listen;
    }

    public int getLoad_more_status() {
        return load_more_status;
    }

    public void setLoad_more_status(int load_more_status) {
        this.load_more_status = load_more_status;
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getViewType();
    }

    public RefresaData getItemData(int position) {
        return dataList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==ITEM_HEADER){
            View view = LayoutInflater.from(mContext).inflate(R.layout.refresh_item_header,parent,false);
            return new HeaderViewHolder(view);
        }else if(viewType==ITEM_ITEM){
            View view = LayoutInflater.from(mContext).inflate(R.layout.refresh_item_content,parent,false);
            return new ItemViewHolder(view);
        }else if(viewType==ITEM_LOAD_FOOTER){
            View view = LayoutInflater.from(mContext).inflate(R.layout.refresh_item_footer,parent,false);
            return new LoadFooterViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RefresaData data=getItemData(position);
        int viewType=getItemViewType(position);
        if(viewType==ITEM_HEADER){
            HeaderViewHolder headerViewHolder=(HeaderViewHolder)holder;
        }else if(viewType==ITEM_ITEM){
            ItemViewHolder itemViewHolder=(ItemViewHolder)holder;
            itemViewHolder.titleView.setText(data.getTitle());
        }else if(viewType==ITEM_LOAD_FOOTER){
            LoadFooterViewHolder footerViewHolder=(LoadFooterViewHolder)holder;
            switch (load_more_status){
                case PULLUP_LOAD_MORE:
                    footerViewHolder.titleView.setText("点击加载更多");
                    break;
                case ISLOADING:
                    footerViewHolder.titleView.setText("加载中...");
                    break;
                case PULLUP_LOAD_FINISH:
                    footerViewHolder.titleView.setText("加载完成");
                    break;
            }
        }
    }

    public void changeMoreStatus(int status){
        load_more_status=status;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return dataList==null?0:dataList.size();
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            titleView=(TextView)itemView.findViewById(R.id.content);
        }
    }

    class LoadFooterViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public LoadFooterViewHolder(View itemView) {
            super(itemView);
            titleView=(TextView)itemView.findViewById(R.id.footer_desc);
            titleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(load_more_status==PULLUP_LOAD_MORE){
                        if(listen!=null){
                            listen.onLoadMore();
                        }
                    }
                }
            });
        }
    }

}
