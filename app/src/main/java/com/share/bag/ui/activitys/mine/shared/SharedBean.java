package com.share.bag.ui.activitys.mine.shared;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */

public class SharedBean {



    /**
     * status : 1
     * info : [{"id":"1","title":"lapalette小马女双肩书包","color":"黑色","img":"/Public/headerimg/1111.png","material":"聚酯纤维100%","status":"审核中","bagbrand_id":"adidas","bagsize_id":"M","days_money":"42.00","nowprice":"0.00","create_time":"2018-02-08,15:37:56","type":1},{"id":"3","title":"Kipling凯浦林手提包轻便单肩包","color":" 藏青30周年欢乐猴印花","img":"/Public/headerimg/1111.png","material":"涤纶","status":"审核失败","bagbrand_id":"Kipling","bagsize_id":"M","days_money":"42.00","nowprice":"0.00","create_time":"2018-02-08,15:51:41","type":3},{"id":"64","title":"丝芙伦民族风手拿包女大容量真皮包包","color":null,"img":null,"material":"hj","status":"审核中","bagbrand_id":null,"bagsize_id":"M","days_money":null,"nowprice":"","create_time":"2018-04-26,16:57:41","type":1}]
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
         * color : 黑色
         * img : /Public/headerimg/1111.png
         * material : 聚酯纤维100%
         * status : 审核中
         * bagbrand_id : adidas
         * bagsize_id : M
         * days_money : 42.00
         * nowprice : 0.00
         * create_time : 2018-02-08,15:37:56
         * type : 1
         */

        private String id;
        private String title;
        private String color;
        private String img;
        private String material;
        private String status;
        private String bagbrand_id;
        private String bagsize_id;
        private String days_money;
        private String nowprice;
        private String create_time;
        private int type;

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

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBagbrand_id() {
            return bagbrand_id;
        }

        public void setBagbrand_id(String bagbrand_id) {
            this.bagbrand_id = bagbrand_id;
        }

        public String getBagsize_id() {
            return bagsize_id;
        }

        public void setBagsize_id(String bagsize_id) {
            this.bagsize_id = bagsize_id;
        }

        public String getDays_money() {
            return days_money;
        }

        public void setDays_money(String days_money) {
            this.days_money = days_money;
        }

        public String getNowprice() {
            return nowprice;
        }

        public void setNowprice(String nowprice) {
            this.nowprice = nowprice;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
