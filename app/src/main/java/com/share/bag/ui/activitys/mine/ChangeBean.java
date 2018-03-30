package com.share.bag.ui.activitys.mine;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/3/21.
 */

public class ChangeBean {
    /**
     * status : 1
     * info : {"0":{"id":"2","type":"2","status":"0","start_time":"1521201712","end_time":null,"title":"以旧换新券","content":"部分品牌包包适用","amount":"100.00","full_money":"0.00"},"sum":200}
     * type : 2
     */

    private String status;
    private InfoBean info;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class InfoBean {
        /**
         * 0 : {"id":"2","type":"2","status":"0","start_time":"1521201712","end_time":null,"title":"以旧换新券","content":"部分品牌包包适用","amount":"100.00","full_money":"0.00"}
         * sum : 200
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private int sum;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public static class _$0Bean {
            /**
             * id : 2
             * type : 2
             * status : 0
             * start_time : 1521201712
             * end_time : null
             * title : 以旧换新券
             * content : 部分品牌包包适用
             * amount : 100.00
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




/*
    *//**
     * status : 1
     * info : {"id":"2","type":"2","status":"0","start_time":"1521201712","end_time":null,"title":"以旧换新券","content":"部分品牌包包适用","amount":"100.00","full_money":"0.00","goodsTotal":200}
     * type : 2
     *//*

    private String status;
    private InfoBean info;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class InfoBean {
        *//**
         * id : 2
         * type : 2
         * status : 0
         * start_time : 1521201712
         * end_time : null
         * title : 以旧换新券
         * content : 部分品牌包包适用
         * amount : 100.00
         * full_money : 0.00
         * goodsTotal : 200
         *//*

        private String id;
        private String type;
        private String status;
        private String start_time;
        private Object end_time;
        private String title;
        private String content;
        private String amount;
        private String full_money;
        private int goodsTotal;

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

        public int getGoodsTotal() {
            return goodsTotal;
        }

        public void setGoodsTotal(int goodsTotal) {
            this.goodsTotal = goodsTotal;
        }
    }*/
}
