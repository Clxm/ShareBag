package com.share.bag.ui.activitys;

/**
 * @Author : TianFB
 * @Date : 2018/4/27
 * @Desrcibe ：
 */

public class WithdrawBean {

    /**
     * status : 0
     * info : 余额不足，无法提现
     * uid : 64
     */

    private String status;
    private String info;
    private String uid;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
