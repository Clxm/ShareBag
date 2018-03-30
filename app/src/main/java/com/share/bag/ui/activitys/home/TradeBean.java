package com.share.bag.ui.activitys.home;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 */

public class TradeBean {


    /**
     * status : 1
     * info : [{"id":"8","img":"/Public/headerimg/1111.png","originalprice":"500.00","title":"COACH 蔻驰 女士牛皮迷你手提斜挎饺子包","nowprice":"1000.00","islive":"false"},{"id":"9","img":"/Public/headerimg/1111.png","originalprice":"500.00","title":"Michael Kors MK 女士纯皮大号链条斜挎包","nowprice":"1000.00","islive":"false"},{"id":"10","img":"/Public/headerimg/1111.png","originalprice":"500.00","title":"DUNE Betsey裸色麂皮质感雕花标牌长款手拿包晚宴派对","nowprice":"1000.00","islive":"false"}]
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
         * id : 8
         * img : /Public/headerimg/1111.png
         * originalprice : 500.00
         * title : COACH 蔻驰 女士牛皮迷你手提斜挎饺子包
         * nowprice : 1000.00
         * islive : false
         */

        private String id;
        private String img;
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
