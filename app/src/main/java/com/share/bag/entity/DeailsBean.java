package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */

public class DeailsBean {
    /**
     * id : 2
     * title : kate spade/ks女士三折小方包 单肩斜挎包 女包
     * originalprice : 998.00
     * days : 7
     * days_money : 63.00
     * img : ["baobaoapi.ldlchat.com/Public/headerimg/1111.png"]
     * bagtype_id : 3
     * bagsize_id : 1
     * bagbrand_id : 15
     * create_time : 1518076064
     * create_user : admin
     * update_time : 1518159951
     * update_user : admin
     * status : 2
     * contentimg : ["baobaoapi.ldlchat.com/Uploads/20180208/5a7c00a007625.png","baobaoapi.ldlchat.com/Uploads/20180208/5a7c00a009183.png"]
     * is_buy : 3
     * material : 牛皮
     * bag_toprice : 3
     * nowprice : 998.00
     * deposit : 100.00
     * carousel : ["baobaoapi.ldlchat.com/Uploads/20180208/5a7c00a0095e8.png","baobaoapi.ldlchat.com/Uploads/20180208/5a7c00a009858.png","baobaoapi.ldlchat.com/Uploads/20180208/5a7c00a009d5f.png"]
     * color : 蓝色
     * bagpay : 3
     * foruser : null
     * bagType : {"id":"3","title":"手提"}
     * bagSize : {"id":"1","title":"M"}
     * bagBrand : {"id":"15","title":"kate spadeks"}
     * comment_count : 0
     */

    private String id;
    private String title;
    private String originalprice;
    private String days;
    private String days_money;
    private String bagtype_id;
    private String bagsize_id;
    private String bagbrand_id;
    private String create_time;
    private String create_user;
    private String update_time;
    private String update_user;
    private String status;
    private String is_buy;
    private String material;
    private String bag_toprice;
    private String nowprice;
    private String deposit;
    private String color;
    private String bagpay;
    private Object foruser;
    private BagTypeBean bagType;
    private BagSizeBean bagSize;
    private BagBrandBean bagBrand;
    private String comment_count;
    private List<String> img;
    private List<String> contentimg;
    private List<String> carousel;

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

    public BagTypeBean getBagType() {
        return bagType;
    }

    public void setBagType(BagTypeBean bagType) {
        this.bagType = bagType;
    }

    public BagSizeBean getBagSize() {
        return bagSize;
    }

    public void setBagSize(BagSizeBean bagSize) {
        this.bagSize = bagSize;
    }

    public BagBrandBean getBagBrand() {
        return bagBrand;
    }

    public void setBagBrand(BagBrandBean bagBrand) {
        this.bagBrand = bagBrand;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public List<String> getContentimg() {
        return contentimg;
    }

    public void setContentimg(List<String> contentimg) {
        this.contentimg = contentimg;
    }

    public List<String> getCarousel() {
        return carousel;
    }

    public void setCarousel(List<String> carousel) {
        this.carousel = carousel;
    }

    public static class BagTypeBean {
        /**
         * id : 3
         * title : 手提
         */

        private String id;
        private String title;

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
    }

    public static class BagSizeBean {
        /**
         * id : 1
         * title : M
         */

        private String id;
        private String title;

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
    }

    public static class BagBrandBean {
        /**
         * id : 15
         * title : kate spadeks
         */

        private String id;
        private String title;

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
    }


//
//
//
//    /**
//     * id : 4
//     * title : wwww
//     * originalprice : 299.00
//     * days : 1
//     * days_money : 20.00
//     * img : ["baobaoapi.ldlchat.com/Uploads/20180105/5a4f4413e71d3.jpg"]
//     * bagtype_id : 1
//     * bagsize_id : 1
//     * bagbrand_id : 1
//     * create_time : null
//     * create_user : 1
//     * update_time : null
//     * update_user : null
//     * status : 1
//     * contentimg : ["baobaoapi.ldlchat.com/Public/headerimg/1111.png","baobaoapi.ldlchat.com/Public/headerimg/1111.png"]
//     * is_buy : null
//     * material : 羊皮
//     * bag_toprice : null
//     * nowprice : 3.00
//     * deposit : 50.00
//     * carousel : ["baobaoapi.ldlchat.com/Uploads/20180108/5a531cb6077c9.jpg","baobaoapi.ldlchat.com/Public/headerimg/1111.png","baobaoapi.ldlchat.com/Public/headerimg/1111.png"]
//     * color : 红色
//     * bagType : {"id":"1","title":"单肩"}
//     * bagSize : {"id":"1","title":"M"}
//     * bagBrand : {"id":"1","title":"adidas"}
//     */
//
//    private String id;
//    private String title;
//    private String originalprice;
//    private String days;
//    private String days_money;
//    private String bagtype_id;
//    private String bagsize_id;
//    private String bagbrand_id;
//    private String create_time;
//    private String create_user;
//    private Object update_time;
//    private Object update_user;
//    private String status;
//    private Object is_buy;
//    private String material;
//    private Object bag_toprice;
//    private String nowprice;
//    private String deposit;
//    private String color;
//    private BagTypeBean bagType;
//    private BagSizeBean bagSize;
//    private BagBrandBean bagBrand;
//    private List<String> img;
//    private List<String> contentimg;
//    private List<String> carousel;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getOriginalprice() {
//        return originalprice;
//    }
//
//    public void setOriginalprice(String originalprice) {
//        this.originalprice = originalprice;
//    }
//
//    public String getDays() {
//        return days;
//    }
//
//    public void setDays(String days) {
//        this.days = days;
//    }
//
//    public String getDays_money() {
//        return days_money;
//    }
//
//    public void setDays_money(String days_money) {
//        this.days_money = days_money;
//    }
//
//    public String getBagtype_id() {
//        return bagtype_id;
//    }
//
//    public void setBagtype_id(String bagtype_id) {
//        this.bagtype_id = bagtype_id;
//    }
//
//    public String getBagsize_id() {
//        return bagsize_id;
//    }
//
//    public void setBagsize_id(String bagsize_id) {
//        this.bagsize_id = bagsize_id;
//    }
//
//    public String getBagbrand_id() {
//        return bagbrand_id;
//    }
//
//    public void setBagbrand_id(String bagbrand_id) {
//        this.bagbrand_id = bagbrand_id;
//    }
//
//    public String getCreate_time() {
//        return create_time;
//    }
//
//    public void setCreate_time(String create_time) {
//        this.create_time = create_time;
//    }
//
//    public String getCreate_user() {
//        return create_user;
//    }
//
//    public void setCreate_user(String create_user) {
//        this.create_user = create_user;
//    }
//
//    public Object getUpdate_time() {
//        return update_time;
//    }
//
//    public void setUpdate_time(Object update_time) {
//        this.update_time = update_time;
//    }
//
//    public Object getUpdate_user() {
//        return update_user;
//    }
//
//    public void setUpdate_user(Object update_user) {
//        this.update_user = update_user;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Object getIs_buy() {
//        return is_buy;
//    }
//
//    public void setIs_buy(Object is_buy) {
//        this.is_buy = is_buy;
//    }
//
//    public String getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//
//    public Object getBag_toprice() {
//        return bag_toprice;
//    }
//
//    public void setBag_toprice(Object bag_toprice) {
//        this.bag_toprice = bag_toprice;
//    }
//
//    public String getNowprice() {
//        return nowprice;
//    }
//
//    public void setNowprice(String nowprice) {
//        this.nowprice = nowprice;
//    }
//
//    public String getDeposit() {
//        return deposit;
//    }
//
//    public void setDeposit(String deposit) {
//        this.deposit = deposit;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public BagTypeBean getBagType() {
//        return bagType;
//    }
//
//    public void setBagType(BagTypeBean bagType) {
//        this.bagType = bagType;
//    }
//
//    public BagSizeBean getBagSize() {
//        return bagSize;
//    }
//
//    public void setBagSize(BagSizeBean bagSize) {
//        this.bagSize = bagSize;
//    }
//
//    public BagBrandBean getBagBrand() {
//        return bagBrand;
//    }
//
//    public void setBagBrand(BagBrandBean bagBrand) {
//        this.bagBrand = bagBrand;
//    }
//
//    public List<String> getImg() {
//        return img;
//    }
//
//    public void setImg(List<String> img) {
//        this.img = img;
//    }
//
//    public List<String> getContentimg() {
//        return contentimg;
//    }
//
//    public void setContentimg(List<String> contentimg) {
//        this.contentimg = contentimg;
//    }
//
//    public List<String> getCarousel() {
//        return carousel;
//    }
//
//    public void setCarousel(List<String> carousel) {
//        this.carousel = carousel;
//    }
//
//    public static class BagTypeBean {
//        /**
//         * id : 1
//         * title : 单肩
//         */
//
//        private String id;
//        private String title;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//    }
//
//    public static class BagSizeBean {
//        /**
//         * id : 1
//         * title : M
//         */
//
//        private String id;
//        private String title;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//    }
//
//    public static class BagBrandBean {
//        /**
//         * id : 1
//         * title : adidas
//         */
//
//        private String id;
//        private String title;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//    }
//
//
////
////    /**
////     * id : 1
////     * title : 111111
////     * originalprice : 100.00
////     * days : 1
////     * days_money : 10.00
////     * img : ["baobaoapi.ldlchat.com/Uploads/Public/Uploads/2018-01-04/5a4da67d4f084.jpg","baobaoapi.ldlchat.com/Uploads/Public/Uploads/2018-01-04/5a4da67d4f084.jpg","baobaoapi.ldlchat.com/Uploads/Public/Uploads/2018-01-04/5a4da67d4f084.jpg"]
////     * bagtype_id : 1
////     * bagsize_id : 1
////     * bagbrand_id : 1
////     * create_time : null
////     * create_user : null
////     * update_time : 2018
////     * update_user : 0
////     * status : 1
////     * contentimg : ["baobaoapi.ldlchat.com/Public/headerimg/1111.png","baobaoapi.ldlchat.com/Public/headerimg/1111.png"]
////     * is_buy : null
////     * material : null
////     * bag_toprice : null
////     * bagType : {"id":"1","title":"单肩"}
////     * bagSize : {"id":"1","title":"XL"}
////     * bagBrand : {"id":"1","title":"adidas"}
////     */
////
////    private String id;
////    private String title;
////    private String originalprice;
////    private String days;
////    private String days_money;
////    private String bagtype_id;
////    private String bagsize_id;
////    private String bagbrand_id;
////    private Object create_time;
////    private Object create_user;
////    private String update_time;
////    private String update_user;
////    private String status;
////    private Object is_buy;
////    private Object material;
////    private Object bag_toprice;
////    private BagTypeBean bagType;
////    private BagSizeBean bagSize;
////    private BagBrandBean bagBrand;
////    private List<String> img;
////    private List<String> contentimg;
////
////    public String getId() {
////        return id;
////    }
////
////    public void setId(String id) {
////        this.id = id;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getOriginalprice() {
////        return originalprice;
////    }
////
////    public void setOriginalprice(String originalprice) {
////        this.originalprice = originalprice;
////    }
////
////    public String getDays() {
////        return days;
////    }
////
////    public void setDays(String days) {
////        this.days = days;
////    }
////
////    public String getDays_money() {
////        return days_money;
////    }
////
////    public void setDays_money(String days_money) {
////        this.days_money = days_money;
////    }
////
////    public String getBagtype_id() {
////        return bagtype_id;
////    }
////
////    public void setBagtype_id(String bagtype_id) {
////        this.bagtype_id = bagtype_id;
////    }
////
////    public String getBagsize_id() {
////        return bagsize_id;
////    }
////
////    public void setBagsize_id(String bagsize_id) {
////        this.bagsize_id = bagsize_id;
////    }
////
////    public String getBagbrand_id() {
////        return bagbrand_id;
////    }
////
////    public void setBagbrand_id(String bagbrand_id) {
////        this.bagbrand_id = bagbrand_id;
////    }
////
////    public Object getCreate_time() {
////        return create_time;
////    }
////
////    public void setCreate_time(Object create_time) {
////        this.create_time = create_time;
////    }
////
////    public Object getCreate_user() {
////        return create_user;
////    }
////
////    public void setCreate_user(Object create_user) {
////        this.create_user = create_user;
////    }
////
////    public String getUpdate_time() {
////        return update_time;
////    }
////
////    public void setUpdate_time(String update_time) {
////        this.update_time = update_time;
////    }
////
////    public String getUpdate_user() {
////        return update_user;
////    }
////
////    public void setUpdate_user(String update_user) {
////        this.update_user = update_user;
////    }
////
////    public String getStatus() {
////        return status;
////    }
////
////    public void setStatus(String status) {
////        this.status = status;
////    }
////
////    public Object getIs_buy() {
////        return is_buy;
////    }
////
////    public void setIs_buy(Object is_buy) {
////        this.is_buy = is_buy;
////    }
////
////    public Object getMaterial() {
////        return material;
////    }
////
////    public void setMaterial(Object material) {
////        this.material = material;
////    }
////
////    public Object getBag_toprice() {
////        return bag_toprice;
////    }
////
////    public void setBag_toprice(Object bag_toprice) {
////        this.bag_toprice = bag_toprice;
////    }
////
////    public BagTypeBean getBagType() {
////        return bagType;
////    }
////
////    public void setBagType(BagTypeBean bagType) {
////        this.bagType = bagType;
////    }
////
////    public BagSizeBean getBagSize() {
////        return bagSize;
////    }
////
////    public void setBagSize(BagSizeBean bagSize) {
////        this.bagSize = bagSize;
////    }
////
////    public BagBrandBean getBagBrand() {
////        return bagBrand;
////    }
////
////    public void setBagBrand(BagBrandBean bagBrand) {
////        this.bagBrand = bagBrand;
////    }
////
////    public List<String> getImg() {
////        return img;
////    }
////
////    public void setImg(List<String> img) {
////        this.img = img;
////    }
////
////    public List<String> getContentimg() {
////        return contentimg;
////    }
////
////    public void setContentimg(List<String> contentimg) {
////        this.contentimg = contentimg;
////    }
////
////    public static class BagTypeBean {
////        /**
////         * id : 1
////         * title : 单肩
////         */
////
////        private String id;
////        private String title;
////
////        public String getId() {
////            return id;
////        }
////
////        public void setId(String id) {
////            this.id = id;
////        }
////
////        public String getTitle() {
////            return title;
////        }
////
////        public void setTitle(String title) {
////            this.title = title;
////        }
////    }
////
////    public static class BagSizeBean {
////        /**
////         * id : 1
////         * title : XL
////         */
////
////        private String id;
////        private String title;
////
////        public String getId() {
////            return id;
////        }
////
////        public void setId(String id) {
////            this.id = id;
////        }
////
////        public String getTitle() {
////            return title;
////        }
////
////        public void setTitle(String title) {
////            this.title = title;
////        }
////    }
////
////    public static class BagBrandBean {
////        /**
////         * id : 1
////         * title : adidas
////         */
////
////        private String id;
////        private String title;
////
////        public String getId() {
////            return id;
////        }
////
////        public void setId(String id) {
////            this.id = id;
////        }
////
////        public String getTitle() {
////            return title;
////        }
////
////        public void setTitle(String title) {
////            this.title = title;
////        }
////    }
////
////    @Override
////    public String toString() {
////        return "DeailsBean{" +
////                "id='" + id + '\'' +
////                ", title='" + title + '\'' +
////                ", originalprice='" + originalprice + '\'' +
////                ", days='" + days + '\'' +
////                ", days_money='" + days_money + '\'' +
////                ", bagtype_id='" + bagtype_id + '\'' +
////                ", bagsize_id='" + bagsize_id + '\'' +
////                ", bagbrand_id='" + bagbrand_id + '\'' +
////                ", create_time=" + create_time +
////                ", create_user=" + create_user +
////                ", update_time='" + update_time + '\'' +
////                ", update_user='" + update_user + '\'' +
////                ", status='" + status + '\'' +
////                ", is_buy=" + is_buy +
////                ", material=" + material +
////                ", bag_toprice=" + bag_toprice +
////                ", bagType=" + bagType +
////                ", bagSize=" + bagSize +
////                ", bagBrand=" + bagBrand +
////                ", img=" + img +
////                ", contentimg=" + contentimg +
////                '}';
////    }
}
