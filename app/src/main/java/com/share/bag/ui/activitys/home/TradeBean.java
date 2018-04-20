package com.share.bag.ui.activitys.home;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 */

public class TradeBean {

    /**
     * status : 1
     * info : [{"id":"10","img":"/Public/headerimg/1111.png","color":"裸色","originalprice":"1115.00","title":"DUNE Betsey裸色麂皮质感雕花标牌长款手拿包晚宴派对","nowprice":"1000.00","islive":"false"}]
     */

    private String status;
    /**
     * id : 10
     * img : /Public/headerimg/1111.png
     * color : 裸色
     * originalprice : 1115.00
     * title : DUNE Betsey裸色麂皮质感雕花标牌长款手拿包晚宴派对
     * nowprice : 1000.00
     * islive : false
     */

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
        private String id;
        private String img;
        private String color;
        private String originalprice;
        private String title;
        private String nowprice;
        private String islive;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getOriginalprice() {
            return originalprice;
        }

        public void setOriginalprice(String originalprice) {
            this.originalprice = originalprice;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNowprice() {
            return nowprice;
        }

        public void setNowprice(String nowprice) {
            this.nowprice = nowprice;
        }

        public String getIslive() {
            return islive;
        }

        public void setIslive(String islive) {
            this.islive = islive;
        }
    }
}
