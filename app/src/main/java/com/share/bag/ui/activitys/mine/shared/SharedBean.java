package com.share.bag.ui.activitys.mine.shared;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */

public class SharedBean {


    /**
     * status : 1
     * info : [{"id":"2","title":"kate spade/ks女士三折小方包 单肩斜挎包 女包","days_money":"63.00","img":"/Public/headerimg/1111.png","bagtype_id":"手提","bagsize_id":"M","bagbrand_id":"kate spadeks","status":"上架中","material":"牛皮","time":1522221970},{"id":"23","title":"艾丹妮真皮女包单肩包斜挎包女士手提大包包","days_money":"20.00","img":"/Uploads/20180209/5a7d4de731acb.png","bagtype_id":"手提","bagsize_id":"M","bagbrand_id":"艾丹妮","status":"上架中","material":"牛皮","time":1522221970},{"id":"20","title":"njoylife金属圆环手提包白色小包复古斜挎单肩包小方包真皮女包","days_money":"20.00","img":"/Public/headerimg/1111.png","bagtype_id":"单肩","bagsize_id":"M","bagbrand_id":"injoylife","status":"上架中","material":"头层牛皮","time":1522221970},{"id":"4","title":"Michael Kors MK 女士Cindy大号贝壳斜挎包","days_money":"63.00","img":"/Public/headerimg/1111.png","bagtype_id":"手提","bagsize_id":"M","bagbrand_id":"Michael Kors","status":"上架中","material":"牛皮革","time":1522221970},{"id":"1","title":"lapalette小马女双肩书包","days_money":"42.00","img":"/Public/headerimg/1111.png","bagtype_id":"双肩","bagsize_id":"M","bagbrand_id":"lapalette","status":"上架中","material":"聚酯纤维100%","time":1522221970},{"id":"3","title":"Kipling凯浦林手提包轻便单肩包","days_money":"42.00","img":"/Public/headerimg/1111.png","bagtype_id":"手提","bagsize_id":"M","bagbrand_id":"Kipling","status":"上架中","material":"涤纶","time":1522221970}]
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
         * id : 2
         * title : kate spade/ks女士三折小方包 单肩斜挎包 女包
         * days_money : 63.00
         * img : /Public/headerimg/1111.png
         * bagtype_id : 手提
         * bagsize_id : M
         * bagbrand_id : kate spadeks
         * status : 上架中
         * material : 牛皮
         * time : 1522221970
         */

        private String id;
        private String title;
        private String days_money;
        private String img;
        private String bagtype_id;
        private String bagsize_id;
        private String bagbrand_id;
        private String status;
        private String material;
        private int time;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
