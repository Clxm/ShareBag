package com.share.bag.ui.activitys.mine.cabinet;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */

public class CabinetBean {


    /**
     * status : 1
     * info : [{"number":"0","color":"黑色（金色金属件）","material":"牛皮革","title":"Michael Kors MK 女士Cindy大号贝壳斜挎包","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"adidas","bagpay":"3","id":"4","order_id":"9","baglist_id":"4","old_price":"4.00","new_price":"4.00","discount_price":"0.00","discount_id":"4","deposit":"1.00","end_time":"1523322009","status":"2","renew_price":null},{"number":"0","color":"berry-酒红","material":"PU","title":"秋冬新款女包 Dune商务时尚通勤漆皮单肩斜挎手提凯莉包 ","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"adidas","bagpay":"1","id":"5","order_id":"12","baglist_id":"5","old_price":"5.00","new_price":"5.00","discount_price":"0.00","discount_id":"4","deposit":"1.00","end_time":"1523322009","status":"2","renew_price":null}]
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
         * number : 0
         * color : 黑色（金色金属件）
         * material : 牛皮革
         * title : Michael Kors MK 女士Cindy大号贝壳斜挎包
         * img : /Public/headerimg/1111.png
         * bagtype_id : 单肩
         * bagsize_id : M
         * bagbrand_id : adidas
         * bagpay : 3
         * id : 4
         * order_id : 9
         * baglist_id : 4
         * old_price : 4.00
         * new_price : 4.00
         * discount_price : 0.00
         * discount_id : 4
         * deposit : 1.00
         * end_time : 1523322009
         * status : 2
         * renew_price : null
         */

        private String number;
        private String color;
        private String material;
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
        private String end_time;
        private String status;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        private String day;
        private Object renew_price;


        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
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

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
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
