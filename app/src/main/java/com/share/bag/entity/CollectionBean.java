package com.share.bag.entity;

/**
 * Created by Administrator on 2018/1/17.
 */

public class CollectionBean {


    /**
     * status : 1
     * info : 收藏成功
     */

    private String status;
    private String info;
    private String type;//1 收藏， 2 取消收藏

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
