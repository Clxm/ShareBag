package com.share.bag.ui.fragments.home;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class HomeTalentBean {


    /**
     * status : 1
     * info : [{"id":"13","content":"测试来了","img":"","create_user":"3","time":"1520590032","baglist_id":"1","is_show":"1","img_one":null,"userinfo":{"id":"3","username":"17801190741","password":"25d55ad283aa400af464c76d713c07ad","gender":"男","iconurl":"http://om6im9i3r.bkt.clouddn.com/2018-03-21_5ab266e6f1b56.jpg","name":"去","balance":"0.00","foregift":"0.00","create_time":"1518159448","wechat":null,"alipay":null},"back":{"id":"1","title":"lapalette小马女双肩书包","originalprice":"638.00","days":"7","days_money":"42.00","img":"/Public/headerimg/1111.png","bagtype_id":"2","bagsize_id":"1","bagbrand_id":"14","create_time":"1518075476","create_user":"admin","update_time":"1518159857","update_user":"admin","status":"2","contentimg":"/Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png","is_buy":"3","material":"聚酯纤维100%","bag_toprice":"3","nowprice":"638.00","deposit":"80.00","carousel":"/Uploads/20180208/5a7bff7859df0.png,/Uploads/20180208/5a7bfe5478dd6.png,/Uploads/20180208/5a7bfe547917e.png","color":"黑色","bagpay":"1","foruser":null,"is_hot":null,"type":"1","backuser_id":"0","collection":0}}]
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
         * id : 13
         * content : 测试来了
         * img :
         * create_user : 3
         * time : 1520590032
         * baglist_id : 1
         * is_show : 1
         * img_one : null
         * userinfo : {"id":"3","username":"17801190741","password":"25d55ad283aa400af464c76d713c07ad","gender":"男","iconurl":"http://om6im9i3r.bkt.clouddn.com/2018-03-21_5ab266e6f1b56.jpg","name":"去","balance":"0.00","foregift":"0.00","create_time":"1518159448","wechat":null,"alipay":null}
         * back : {"id":"1","title":"lapalette小马女双肩书包","originalprice":"638.00","days":"7","days_money":"42.00","img":"/Public/headerimg/1111.png","bagtype_id":"2","bagsize_id":"1","bagbrand_id":"14","create_time":"1518075476","create_user":"admin","update_time":"1518159857","update_user":"admin","status":"2","contentimg":"/Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png","is_buy":"3","material":"聚酯纤维100%","bag_toprice":"3","nowprice":"638.00","deposit":"80.00","carousel":"/Uploads/20180208/5a7bff7859df0.png,/Uploads/20180208/5a7bfe5478dd6.png,/Uploads/20180208/5a7bfe547917e.png","color":"黑色","bagpay":"1","foruser":null,"is_hot":null,"type":"1","backuser_id":"0","collection":0}
         */

        private String id;
        private String content;
        private String img;
        private String create_user;
        private String time;
        private String baglist_id;
        private String is_show;
        private Object img_one;
        private UserinfoBean userinfo;
        private BackBean back;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getCreate_user() {
            return create_user;
        }

        public void setCreate_user(String create_user) {
            this.create_user = create_user;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getBaglist_id() {
            return baglist_id;
        }

        public void setBaglist_id(String baglist_id) {
            this.baglist_id = baglist_id;
        }

        public String getIs_show() {
            return is_show;
        }

        public void setIs_show(String is_show) {
            this.is_show = is_show;
        }

        public Object getImg_one() {
            return img_one;
        }

        public void setImg_one(Object img_one) {
            this.img_one = img_one;
        }

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public BackBean getBack() {
            return back;
        }

        public void setBack(BackBean back) {
            this.back = back;
        }

        public static class UserinfoBean {
            /**
             * id : 3
             * username : 17801190741
             * password : 25d55ad283aa400af464c76d713c07ad
             * gender : 男
             * iconurl : http://om6im9i3r.bkt.clouddn.com/2018-03-21_5ab266e6f1b56.jpg
             * name : 去
             * balance : 0.00
             * foregift : 0.00
             * create_time : 1518159448
             * wechat : null
             * alipay : null
             */

            private String id;
            private String username;
            private String password;
            private String gender;
            private String iconurl;
            private String name;
            private String balance;
            private String foregift;
            private String create_time;
            private Object wechat;
            private Object alipay;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getIconurl() {
                return iconurl;
            }

            public void setIconurl(String iconurl) {
                this.iconurl = iconurl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getForegift() {
                return foregift;
            }

            public void setForegift(String foregift) {
                this.foregift = foregift;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getWechat() {
                return wechat;
            }

            public void setWechat(Object wechat) {
                this.wechat = wechat;
            }

            public Object getAlipay() {
                return alipay;
            }

            public void setAlipay(Object alipay) {
                this.alipay = alipay;
            }
        }

        public static class BackBean {
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
             * bagpay : 1
             * foruser : null
             * is_hot : null
             * type : 1
             * backuser_id : 0
             * collection : 0
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
            private Object is_hot;
            private String type;
            private String backuser_id;
            private int collection;

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

            public Object getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(Object is_hot) {
                this.is_hot = is_hot;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBackuser_id() {
                return backuser_id;
            }

            public void setBackuser_id(String backuser_id) {
                this.backuser_id = backuser_id;
            }

            public int getCollection() {
                return collection;
            }

            public void setCollection(int collection) {
                this.collection = collection;
            }
        }
    }
}
