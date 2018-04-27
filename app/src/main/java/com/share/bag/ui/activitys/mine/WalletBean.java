package com.share.bag.ui.activitys.mine;

/**
 * Created by Administrator on 2018/3/21.
 */

public class WalletBean {


    /**
     * status : 1
     * info : {"balance":"0.00","foregift":"0.00"}
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
         * balance : 0.00
         * foregift : 0.00
         */

        private String balance;
        private String foregift;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        private String number;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getForegift() {
            return foregift;
        }

        public void setForegift(String foregift) {
            this.foregift = foregift;
        }
    }
}
