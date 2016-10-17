package com.liuy.androidmdesignproject.pullautorefresh;

/**
 * @author liuy
 * @Date 2016/10/14 15:46
 * @since 3.0
 */

public class RefresaData {
    private int viewType;
    private String title;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
