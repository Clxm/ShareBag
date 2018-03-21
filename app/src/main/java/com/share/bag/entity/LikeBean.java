package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */

public class LikeBean {


    /**
     * status : 1
     * info : [{"id":"1","title":"lapalette小马女双肩书包","originalprice":"638.00","days":"7","days_money":"42.00","img":"/Public/headerimg/1111.png","bagtype_id":"2","bagsize_id":"1","bagbrand_id":"14","create_time":"1518075476","create_user":"admin","update_time":"1518159857","update_user":"admin","status":"2","contentimg":"/Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png","is_buy":"3","material":"聚酯纤维100%","bag_toprice":"3","nowprice":"638.00","deposit":"80.00","carousel":"/Uploads/20180208/5a7bff7859df0.png,/Uploads/20180208/5a7bfe5478dd6.png,/Uploads/20180208/5a7bfe547917e.png","color":"黑色","bagpay":"3","foruser":null},{"id":"20","title":"njoylife金属圆环手提包白色小包复古斜挎单肩包小方包真皮女包","originalprice":"328.00","days":"5","days_money":"20.00","img":"/Public/headerimg/1111.png","bagtype_id":"1","bagsize_id":"1","bagbrand_id":"20","create_time":"1518160946","create_user":"admin","update_time":"1518167493","update_user":"admin","status":"2","contentimg":"/Uploads/20180209/5a7d4c326c12a.png,/Uploads/20180209/5a7d4c326c3b0.png,/Uploads/20180209/5a7d4c326c6e1.png,/Uploads/20180209/5a7d4c326c902.png,/Uploads/20180209/5a7d4c326cb8e.png,/Uploads/20180209/5a7d4c326d31e.png","is_buy":"3","material":"头层牛皮","bag_toprice":"3","nowprice":"328.00","deposit":"99.00","carousel":"/Uploads/20180209/5a7d4c326d4b8.png,/Uploads/20180209/5a7d4c326d5ee.png,/Uploads/20180209/5a7d4c326d74d.png","color":"黑色","bagpay":"3","foruser":null},{"id":"2","title":"kate spade/ks女士三折小方包 单肩斜挎包 女包","originalprice":"998.00","days":"7","days_money":"63.00","img":"/Public/headerimg/1111.png","bagtype_id":"3","bagsize_id":"1","bagbrand_id":"15","create_time":"1518076064","create_user":"admin","update_time":"1518159951","update_user":"admin","status":"2","contentimg":"/Uploads/20180208/5a7c00a007625.png,/Uploads/20180208/5a7c00a009183.png","is_buy":"3","material":"牛皮","bag_toprice":"3","nowprice":"998.00","deposit":"100.00","carousel":"/Uploads/20180208/5a7c00a0095e8.png,/Uploads/20180208/5a7c00a009858.png,/Uploads/20180208/5a7c00a009d5f.png","color":"蓝色","bagpay":"3","foruser":null},{"id":"3","title":"Kipling凯浦林手提包轻便单肩包","originalprice":"698.00","days":"7","days_money":"42.00","img":"/Public/headerimg/1111.png","bagtype_id":"3","bagsize_id":"1","bagbrand_id":"16","create_time":"1518076301","create_user":"admin","update_time":"1518160050","update_user":"admin","status":"2","contentimg":"/Uploads/20180208/5a7c018d63465.png,/Uploads/20180208/5a7c018d65d5c.png","is_buy":"3","material":"涤纶","bag_toprice":"3","nowprice":"698.00","deposit":"100.00","carousel":"/Uploads/20180208/5a7c018d662a0.png,/Uploads/20180208/5a7c018d6674d.png,/Uploads/20180208/5a7c018d66d1e.png","color":" 藏青30周年欢乐猴印花","bagpay":"3","foruser":null}]
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
         * id : 1
         * title : lapalette小马女双肩书包
         * originalprice : 638.00
         * days : 7
         * days_money : 42.00
         * img : /Public/headerimg/1111.png
         * bagtype_id : 2
         * bagsize_id : 1
         * bagbrand_id : 14
         * create_time : 1518075476
         * create_user : admin
         * update_time : 1518159857
         * update_user : admin
         * status : 2
         * contentimg : /Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png
         * is_buy : 3
         * material : 聚酯纤维100%
         * bag_toprice : 3
         * nowprice : 638.00
         * deposit : 80.00
         * carousel : /Uploads/20180208/5a7bff7859df0.png,/Uploads/20180208/5a7bfe5478dd6.png,/Uploads/20180208/5a7bfe547917e.png
         * color : 黑色
         * bagpay : 3
         * foruser : null
         */

        private String id;
        private String title;
        private String originalprice;
        private String days;
        private String days_money;
        private String img;
        private String bagtype_id;
        private String bagsize_id;
        private String bagbrand_id;
        private String create_time;
        private String create_user;
        private String update_time;
        private String update_user;
        private String status;
        private String contentimg;
        private String is_buy;
        private String material;
        private String bag_toprice;
        private String nowprice;
        private String deposit;
        private String carousel;
        private String color;
        private String bagpay;
        private Object foruser;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOriginalprice() {
            return originalprice;
        }

        public void setOriginalprice(String originalprice) {
            this.originalprice = originalprice;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getDays_money() {
            return days_money;
        }

        public void setDays_money(String days_money) {
            this.days_money = days_money;
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

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getCreate_user() {
            return create_user;
        }

        public void setCreate_user(String create_user) {
            this.create_user = create_user;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getUpdate_user() {
            return update_user;
        }

        public void setUpdate_user(String update_user) {
            this.update_user = update_user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getContentimg() {
            return contentimg;
        }

        public void setContentimg(String contentimg) {
            this.contentimg = contentimg;
        }

        public String getIs_buy() {
            return is_buy;
        }

        public void setIs_buy(String is_buy) {
            this.is_buy = is_buy;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getBag_toprice() {
            return bag_toprice;
        }

        public void setBag_toprice(String bag_toprice) {
            this.bag_toprice = bag_toprice;
        }

        public String getNowprice() {
            return nowprice;
        }

        public void setNowprice(String nowprice) {
            this.nowprice = nowprice;
        }

        public String getDeposit() {
            return deposit;
        }

        public void setDeposit(String deposit) {
            this.deposit = deposit;
        }

        public String getCarousel() {
            return carousel;
        }

        public void setCarousel(String carousel) {
            this.carousel = carousel;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBagpay() {
            return bagpay;
        }

        public void setBagpay(String bagpay) {
            this.bagpay = bagpay;
        }

        public Object getForuser() {
            return foruser;
        }

        public void setForuser(Object foruser) {
            this.foruser = foruser;
        }
    }
}
