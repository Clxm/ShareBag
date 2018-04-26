package com.share.bag.ui.ship;

import java.util.List;

/**
 * @Author : TianFB
 * @Date : 2018/4/11
 * @Desrcibe ：
 */

public class ShipHttpBean4 {


    /**
     * status : 1
     * info : [{"id":"4","biglist_num":"0","nowprice":"998.00","title":"Michael Kors MK 女士Cindy大号贝壳斜挎包","img":"/Public/headerimg/1111.png","color":"黑色（金色金属件）","bagtype_id":"手提","bagsize_id":"M","bagbrand_id":"Michael Kors","ordernumber":"1517457103","end_time":"2018-04-10 09:00:09","create_time":"2018-02-01 11:51:43","day":16}]
     */

    private String status;
    private List<InfoBean> info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * id : 4
         * biglist_num : 0
         * nowprice : 998.00
         * title : Michael Kors MK 女士Cindy大号贝壳斜挎包
         * img : /Public/headerimg/1111.png
         * color : 黑色（金色金属件）
         * bagtype_id : 手提
         * bagsize_id : M
         * bagbrand_id : Michael Kors
         * ordernumber : 1517457103
         * end_time : 2018-04-10 09:00:09
         * create_time : 2018-02-01 11:51:43
         * day : 16
         */

        private String id;
        private String biglist_num;
        private String nowprice;
        private String title;
        private String img;
        private String color;
        private String bagtype_id;
        private String bagsize_id;
        private String bagbrand_id;
        private String ordernumber;
        private String end_time;
        private String create_time;
        private int day;
        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        private String orderid;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBiglist_num() {
            return biglist_num;
        }

        public void setBiglist_num(String biglist_num) {
            this.biglist_num = biglist_num;
        }

        public String getNowprice() {
            return nowprice;
        }

        public void setNowprice(String nowprice) {
            this.nowprice = nowprice;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBagtype_id() {
            return bagtype_id;
        }

        public void setBagtype_id(String bagtype_id) {
            this.bagtype_id = bagtype_id;
        }

        public String getBagsize_id() {
            return bagsize_id;
        }

        public void setBagsize_id(String bagsize_id) {
            this.bagsize_id = bagsize_id;
        }

        public String getBagbrand_id() {
            return bagbrand_id;
        }

        public void setBagbrand_id(String bagbrand_id) {
            this.bagbrand_id = bagbrand_id;
        }

        public String getOrdernumber() {
            return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
            this.ordernumber = ordernumber;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }
}
