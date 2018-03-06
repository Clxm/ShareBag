package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HomeFragmentBean {
    private List<HeaderimgBean> headerimg;
    private List<ListBean> list;
    private List<AdButtomBean> ad_buttom;
    private List<AdOldnewBean> ad_oldnew;

    public List<HeaderimgBean> getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(List<HeaderimgBean> headerimg) {
        this.headerimg = headerimg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<AdButtomBean> getAd_buttom() {
        return ad_buttom;
    }

    public void setAd_buttom(List<AdButtomBean> ad_buttom) {
        this.ad_buttom = ad_buttom;
    }

    public List<AdOldnewBean> getAd_oldnew() {
        return ad_oldnew;
    }

    public void setAd_oldnew(List<AdOldnewBean> ad_oldnew) {
        this.ad_oldnew = ad_oldnew;
    }

    public static class HeaderimgBean {
        /**
         * id : 1
         * title : 11111
         * img : http://baobaoapi.ldlchat.com/Uploads/20180305/5a9cb8d0730da.png
         * create_time : 1516464000
         * month : 1
         * url : http://ywxz.ldlchat.com
         */

        private String id;
        private String title;
        private String img;
        private String create_time;
        private String month;
        private String url;

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

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ListBean {
        /**
         * id : 1
         * title : 品牌专区
         * pid : 0
         * bagthinks : [{"id":"1","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d1a4d1fd29.png","position":"休闲度假-小1","baglist_id":"1"},{"id":"1","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d1a4d1fd29.png","position":"休闲度假-小1","baglist_id":"1"},{"id":"1","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d1a4d1fd29.png","position":"休闲度假-小1","baglist_id":"1"}]
         * _child : [{"id":"4","title":"休闲度假","pid":"2","bagthinks":[{"id":"3","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d077233932.png","position":"休闲度假-大","baglist_id":"3"},{"id":"1","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d1a4d1fd29.png","position":"休闲度假-小1","baglist_id":"1"},{"id":"2","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d52e83b01b.png","position":"休闲度假-小2","baglist_id":"2"}]},{"id":"5","title":"宴会轻奢","pid":"2","bagthinks":[{"id":"9","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d29562d018.png","position":"宴会轻奢-竖","baglist_id":"9"},{"id":"10","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d2968790f1.png","position":"宴会轻奢-小1","baglist_id":"10"},{"id":"11","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d2960ca44a.png","position":"宴会轻奢-小2","baglist_id":"11"},{"id":"8","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d294c0c8e2.png","position":"宴会轻奢-横","baglist_id":"8"}]},{"id":"6","title":"商务办公","pid":"2","bagthinks":[{"id":"6","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d291acab83.png","position":"商务办公-小1","baglist_id":"6"},{"id":"7","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d292699c2a.png","position":"商务办公-小2","baglist_id":"7"},{"id":"5","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d29076cce6.png","position":"商务办公-横","baglist_id":"5"},{"id":"4","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d28f51a97f.png","position":"商务办公-竖","baglist_id":"4"}]}]
         */

        private String id;
        private String title;
        private String pid;
        private List<BagthinksBean> bagthinks;
        private List<ChildBean> _child;

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

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public List<BagthinksBean> getBagthinks() {
            return bagthinks;
        }

        public void setBagthinks(List<BagthinksBean> bagthinks) {
            this.bagthinks = bagthinks;
        }

        public List<ChildBean> get_child() {
            return _child;
        }

        public void set_child(List<ChildBean> _child) {
            this._child = _child;
        }

        public static class BagthinksBean {
            /**
             * id : 1
             * img : http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d1a4d1fd29.png
             * position : 休闲度假-小1
             * baglist_id : 1
             */

            private String id;
            private String img;
            private String position;
            private String baglist_id;

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

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getBaglist_id() {
                return baglist_id;
            }

            public void setBaglist_id(String baglist_id) {
                this.baglist_id = baglist_id;
            }
        }

        public static class ChildBean {
            /**
             * id : 4
             * title : 休闲度假
             * pid : 2
             * bagthinks : [{"id":"3","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d077233932.png","position":"休闲度假-大","baglist_id":"3"},{"id":"1","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d1a4d1fd29.png","position":"休闲度假-小1","baglist_id":"1"},{"id":"2","img":"http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d52e83b01b.png","position":"休闲度假-小2","baglist_id":"2"}]
             */

            private String id;
            private String title;
            private String pid;
            private List<BagthinksBeanX> bagthinks;

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

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public List<BagthinksBeanX> getBagthinks() {
                return bagthinks;
            }

            public void setBagthinks(List<BagthinksBeanX> bagthinks) {
                this.bagthinks = bagthinks;
            }

            public static class BagthinksBeanX {
                /**
                 * id : 3
                 * img : http://baobaoapi.ldlchat.com/Uploads/20180209/5a7d077233932.png
                 * position : 休闲度假-大
                 * baglist_id : 3
                 */

                private String id;
                private String img;
                private String position;
                private String baglist_id;

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

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getBaglist_id() {
                    return baglist_id;
                }

                public void setBaglist_id(String baglist_id) {
                    this.baglist_id = baglist_id;
                }
            }
        }
    }

    public static class AdButtomBean {
        /**
         * id : 1
         * title : 邀请好友1
         * img : http://baobaoapi.ldlchat.com/Public/headerimg/1111.png
         * time : 1516464000
         */

        private String id;
        private String title;
        private String img;
        private String time;

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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class AdOldnewBean {
        /**
         * id : 1
         * title : 以旧换新
         * img : http://baobaoapi.ldlchat.com/Public/headerimg/1111.png
         * create_time : 1520217604
         * newbaglist_id : 1
         */

        private String id;
        private String title;
        private String img;
        private String create_time;
        private String newbaglist_id;

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

        public String getNewbaglist_id() {
            return newbaglist_id;
        }

        public void setNewbaglist_id(String newbaglist_id) {
            this.newbaglist_id = newbaglist_id;
        }
    }


}
