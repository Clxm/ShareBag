package com.share.bag.ui.activitys.mine.cabinet;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */

public class CabinetBean {

    /**
     * status : 1
     * info : [{"title":"lapalette小马女双肩书包","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"adidas","bagpay":"已租","id":"1","order_id":"6","baglist_id":"1","old_price":"1.00","new_price":"1.00","discount_price":"0.00","discount_id":"1","deposit":"1.00","end_time":null,"status":"1","renew_price":null},{"title":"kate spade/ks女士三折小方包 单肩斜挎包 女包","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"adidas","bagpay":"已租","id":"2","order_id":"7","baglist_id":"2","old_price":"2.00","new_price":"2.00","discount_price":"0.00","discount_id":"2","deposit":"1.00","end_time":null,"status":"1","renew_price":null},{"title":"Kipling凯浦林手提包轻便单肩包","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"adidas","bagpay":"正常","id":"3","order_id":"8","baglist_id":"3","old_price":"3.00","new_price":"3.00","discount_price":"0.00","discount_id":"3","deposit":"1.00","end_time":null,"status":"2","renew_price":null},{"title":"Michael Kors MK 女士Cindy大号贝壳斜挎包","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"adidas","bagpay":"正常","id":"4","order_id":"9","baglist_id":"4","old_price":"4.00","new_price":"4.00","discount_price":"0.00","discount_id":"4","deposit":"1.00","end_time":null,"status":"2","renew_price":null}]
     */

    private int status;
    private List<InfoBean> info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
         * title : lapalette小马女双肩书包
         * img : /Public/headerimg/1111.png
         * bagtype_id : 单肩
         * bagsize_id : M
         * bagbrand_id : adidas
         * bagpay : 已租
         * id : 1
         * order_id : 6
         * baglist_id : 1
         * old_price : 1.00
         * new_price : 1.00
         * discount_price : 0.00
         * discount_id : 1
         * deposit : 1.00
         * end_time : null
         * status : 1
         * renew_price : null
         */

        private String title;
        private String img;
        private String bagtype_id;
        private String bagsize_id;
        private String bagbrand_id;
        private String bagpay;
        private String id;
        private String order_id;
        private String baglist_id;
        private String old_price;
        private String new_price;
        private String discount_price;
        private String discount_id;
        private String deposit;
        private Object end_time;
        private String status;
        private Object renew_price;

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

        public String getBagpay() {
            return bagpay;
        }

        public void setBagpay(String bagpay) {
            this.bagpay = bagpay;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getBaglist_id() {
            return baglist_id;
        }

        public void setBaglist_id(String baglist_id) {
            this.baglist_id = baglist_id;
        }

        public String getOld_price() {
            return old_price;
        }

        public void setOld_price(String old_price) {
            this.old_price = old_price;
        }

        public String getNew_price() {
            return new_price;
        }

        public void setNew_price(String new_price) {
            this.new_price = new_price;
        }

        public String getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(String discount_price) {
            this.discount_price = discount_price;
        }

        public String getDiscount_id() {
            return discount_id;
        }

        public void setDiscount_id(String discount_id) {
            this.discount_id = discount_id;
        }

        public String getDeposit() {
            return deposit;
        }

        public void setDeposit(String deposit) {
            this.deposit = deposit;
        }

        public Object getEnd_time() {
            return end_time;
        }

        public void setEnd_time(Object end_time) {
            this.end_time = end_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRenew_price() {
            return renew_price;
        }

        public void setRenew_price(Object renew_price) {
            this.renew_price = renew_price;
        }
    }
}
