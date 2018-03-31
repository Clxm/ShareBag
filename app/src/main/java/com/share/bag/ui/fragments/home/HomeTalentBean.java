package com.share.bag.ui.fragments.home;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class HomeTalentBean {

    /**
     * status : 1
     * info : [{"id":"13","content":"测试来了","img":"","create_user":"3","time":"1520590032","baglist_id":"1","is_show":"1","img_one":null,"userinfo":{"id":"3","style":null,"iconurl":"http://om6im9i3r.bkt.clouddn.com/2018-03-23_5ab46047ea8de.jpg","name":"17801190741"},"back":{"title":"lapalette小马女双肩书包","img":"/Public/headerimg/1111.png","create_time":"1518075476","contentimg":"/Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png","collection":1}}]
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
         * userinfo : {"id":"3","style":null,"iconurl":"http://om6im9i3r.bkt.clouddn.com/2018-03-23_5ab46047ea8de.jpg","name":"17801190741"}
         * back : {"title":"lapalette小马女双肩书包","img":"/Public/headerimg/1111.png","create_time":"1518075476","contentimg":"/Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png","collection":1}
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
             * style : null
             * iconurl : http://om6im9i3r.bkt.clouddn.com/2018-03-23_5ab46047ea8de.jpg
             * name : 17801190741
             */

            private String id;
            private Object style;
            private String iconurl;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Object getStyle() {
                return style;
            }

            public void setStyle(Object style) {
                this.style = style;
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
        }

        public static class BackBean {
            /**
             * title : lapalette小马女双肩书包
             * img : /Public/headerimg/1111.png
             * create_time : 1518075476
             * contentimg : /Uploads/20180208/5a7bff92abef4.png,/Uploads/20180208/5a7bfe5476f59.png,/Uploads/20180208/5a7bfe5478451.png
             * collection : 1
             */

            private String title;
            private String img;
            private String create_time;
            private String contentimg;
            private int collection;

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

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getContentimg() {
                return contentimg;
            }

            public void setContentimg(String contentimg) {
                this.contentimg = contentimg;
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
