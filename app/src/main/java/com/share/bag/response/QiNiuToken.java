package com.share.bag.response;

/**
 * Created by lxm on 2018/4/24.
 */

public class QiNiuToken {

    /**
     * status : 1
     * info : :iJqmxXm9gsCVQ7-DfdMD3dAqqIo=:eyJzY29wZSI6bnVsbCwiZGVhZGxpbmUiOjE1MjQ1NjA5MTB9
     */

    private String status;
    private String info;

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
