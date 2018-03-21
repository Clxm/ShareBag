package com.share.bag.ui.activitys.mine.wallet;

import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */

public class RedEnvelopeBean {


    /**
     * status : 1
     * info : [{"id":"1","type":"1","status":"0","start_time":"1521201712","end_time":null,"title":"红包券","content":"部分品牌包包适用","amount":"5.00","full_money":"0.00"},{"id":"3","type":"1","status":"0","start_time":null,"end_time":null,"title":"红包券","content":"部分品牌包包适用","amount":"5.00","full_money":"0.00"},{"id":"4","type":"1","status":"0","start_time":null,"end_time":null,"title":"红包券","content":"部分品牌包包适用","amount":"5.00","full_money":"0.00"},{"id":"5","type":"1","status":"0","start_time":null,"end_time":null,"title":"红包券","content":"部分品牌包包适用","amount":"5.00","full_money":"0.00"}]
     * type : 1
     */

    private String status;
    private String type;
    private List<InfoBean> info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * id : 1
         * type : 1
         * status : 0
         * start_time : 1521201712
         * end_time : null
         * title : 红包券
         * content : 部分品牌包包适用
         * amount : 5.00
         * full_money : 0.00
         */

        private String id;
        private String type;
        private String status;
        private String start_time;
        private Object end_time;
        private String title;
        private String content;
        private String amount;
        private String full_money;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public Object getEnd_time() {
            return end_time;
        }

        public void setEnd_time(Object end_time) {
            this.end_time = end_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getFull_money() {
            return full_money;
        }

        public void setFull_money(String full_money) {
            this.full_money = full_money;
        }
    }
}
