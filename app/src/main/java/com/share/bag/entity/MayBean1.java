package com.share.bag.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/1/31.
 */

public class MayBean1 {


    /**
     * status : 1
     * info : {"appid":"wx38f75c7fdb68b2bf","noncestr":"1517367374","package":"Sign=WXPay","partnerid":"1497536522","prepayid":"wx20180131105614c2ffeaa28d0112894436","timestamp":"1517367374","sign":"e51217ec8e1c96207404ecb27fc8aab7"}
     */

    private String status;
    private InfoBean info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * appid : wx38f75c7fdb68b2bf
         * noncestr : 1517367374
         * package : Sign=WXPay
         * partnerid : 1497536522
         * prepayid : wx20180131105614c2ffeaa28d0112894436
         * timestamp : 1517367374
         * sign : e51217ec8e1c96207404ecb27fc8aab7
         */

        private String appid;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private String timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
