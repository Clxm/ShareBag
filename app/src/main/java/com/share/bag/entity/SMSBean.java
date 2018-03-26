package com.share.bag.entity;

/**
 * Created by Administrator on 2017/12/23.
 */

public class SMSBean {

    /**
     * status : 1
     * info : 发送成功
     */

    private String status;
    private String info;
    /**
     * phone : 1780119074
     */

    private String phone;

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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
