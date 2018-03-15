package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */

public class CommentBean {
    /**
     * status : 1
     * data : [{"id":"3","user_id":"3","content":"测试","img":null,"baglist_id":"1","create_time":"1520406105","create_user":"3","update_time":"1520406105","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"4","user_id":"3","content":"测试","img":null,"baglist_id":"1","create_time":"1520406141","create_user":"3","update_time":"1520406141","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"5","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f8e981be9b.jpg","baglist_id":"1","create_time":"1520406168","create_user":"3","update_time":"1520406168","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"6","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f8f330ede2.jpg","baglist_id":"1","create_time":"1520406323","create_user":"3","update_time":"1520406323","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"7","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f90c274992.jpg","baglist_id":"1","create_time":"1520406722","create_user":"3","update_time":"1520406722","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"8","user_id":"3","content":"试试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f929f3ab08.jpg","baglist_id":"1","create_time":"1520407199","create_user":"3","update_time":"1520407199","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"9","user_id":"3","content":"这就好了","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f92b011e44.jpg","baglist_id":"1","create_time":"1520407216","create_user":"3","update_time":"1520407216","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"10","user_id":"3","content":"这就好了","img":null,"baglist_id":"1","create_time":"1520407880","create_user":"3","update_time":"1520407880","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"11","user_id":"3","content":"这是我发布的动态之一，总之换算比较全面","img":null,"baglist_id":"1","create_time":"1520494020","create_user":"3","update_time":"1520494020","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}}]
     */

    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * user_id : 3
         * content : 测试
         * img : null
         * baglist_id : 1
         * create_time : 1520406105
         * create_user : 3
         * update_time : 1520406105
         * update_user : 3
         * user : {"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}
         */

        private String id;
        private String user_id;
        private String content;
        private Object img;
        private String baglist_id;
        private String create_time;
        private String create_user;
        private String update_time;
        private String update_user;
        private UserBean user;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getImg() {
            return img;
        }

        public void setImg(Object img) {
            this.img = img;
        }

        public String getBaglist_id() {
            return baglist_id;
        }

        public void setBaglist_id(String baglist_id) {
            this.baglist_id = baglist_id;
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * name : 卢
             * username : 17801190741
             * iconurl : http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png
             * create_time : 1518159448
             * labels : ["白领","啄木鸟"]
             */

            private String name;
            private String username;
            private String iconurl;
            private String create_time;
            private List<String> labels;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getIconurl() {
                return iconurl;
            }

            public void setIconurl(String iconurl) {
                this.iconurl = iconurl;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public List<String> getLabels() {
                return labels;
            }

            public void setLabels(List<String> labels) {
                this.labels = labels;
            }
        }
    }


//    /**
//     * status : 1
//     * data : [{"id":"1","user_id":"39","content":"评论测试","img":null,"baglist_id":"1","create_time":"1516464000","create_user":"17801190741","update_time":"1516464000","update_user":"17801190741","user":null},{"id":"3","user_id":"3","content":"测试","img":null,"baglist_id":"1","create_time":"1520406105","create_user":"3","update_time":"1520406105","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"4","user_id":"3","content":"测试","img":null,"baglist_id":"1","create_time":"1520406141","create_user":"3","update_time":"1520406141","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"5","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f8e981be9b.jpg","baglist_id":"1","create_time":"1520406168","create_user":"3","update_time":"1520406168","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"6","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f8f330ede2.jpg","baglist_id":"1","create_time":"1520406323","create_user":"3","update_time":"1520406323","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"7","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f90c274992.jpg","baglist_id":"1","create_time":"1520406722","create_user":"3","update_time":"1520406722","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"8","user_id":"3","content":"试试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f929f3ab08.jpg","baglist_id":"1","create_time":"1520407199","create_user":"3","update_time":"1520407199","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"9","user_id":"3","content":"这就好了","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f92b011e44.jpg","baglist_id":"1","create_time":"1520407216","create_user":"3","update_time":"1520407216","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"10","user_id":"3","content":"这就好了","img":null,"baglist_id":"1","create_time":"1520407880","create_user":"3","update_time":"1520407880","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}},{"id":"11","user_id":"3","content":"这是我发布的动态之一，总之换算比较全面","img":null,"baglist_id":"1","create_time":"1520494020","create_user":"3","update_time":"1520494020","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":["白领","啄木鸟"]}}]
//     */
//
//    private String status;
//    private List<DataBean> data;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//        /**
//         * id : 1
//         * user_id : 39
//         * content : 评论测试
//         * img : null
//         * baglist_id : 1
//         * create_time : 1516464000
//         * create_user : 17801190741
//         * update_time : 1516464000
//         * update_user : 17801190741
//         * user : null
//         */
//
//        private String id;
//        private String user_id;
//        private String content;
//        private String img;
//        private String baglist_id;
//        private String create_time;
//        private String create_user;
//        private String update_time;
//        private String update_user;
//        private Object user;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getUser_id() {
//            return user_id;
//        }
//
//        public void setUser_id(String user_id) {
//            this.user_id = user_id;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public String getImg() {
//            return img;
//        }
//
//        public void setImg(String img) {
//            this.img = img;
//        }
//
//        public String getBaglist_id() {
//            return baglist_id;
//        }
//
//        public void setBaglist_id(String baglist_id) {
//            this.baglist_id = baglist_id;
//        }
//
//        public String getCreate_time() {
//            return create_time;
//        }
//
//        public void setCreate_time(String create_time) {
//            this.create_time = create_time;
//        }
//
//        public String getCreate_user() {
//            return create_user;
//        }
//
//        public void setCreate_user(String create_user) {
//            this.create_user = create_user;
//        }
//
//        public String getUpdate_time() {
//            return update_time;
//        }
//
//        public void setUpdate_time(String update_time) {
//            this.update_time = update_time;
//        }
//
//        public String getUpdate_user() {
//            return update_user;
//        }
//
//        public void setUpdate_user(String update_user) {
//            this.update_user = update_user;
//        }
//
//        public Object getUser() {
//            return user;
//        }
//
//        public void setUser(Object user) {
//            this.user = user;
//        }
//    }

//
//    /**
//     * status : 1
//     * data : [{"id":"1","user_id":"39","content":"评论测试","img":null,"baglist_id":"1","create_time":"1516464000","create_user":"17801190741","update_time":"1516464000","update_user":"17801190741","user":null},{"id":"3","user_id":"3","content":"测试","img":null,"baglist_id":"1","create_time":"1520406105","create_user":"3","update_time":"1520406105","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"4","user_id":"3","content":"测试","img":null,"baglist_id":"1","create_time":"1520406141","create_user":"3","update_time":"1520406141","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"5","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f8e981be9b.jpg","baglist_id":"1","create_time":"1520406168","create_user":"3","update_time":"1520406168","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"6","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f8f330ede2.jpg","baglist_id":"1","create_time":"1520406323","create_user":"3","update_time":"1520406323","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"7","user_id":"3","content":"测试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f90c274992.jpg","baglist_id":"1","create_time":"1520406722","create_user":"3","update_time":"1520406722","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"8","user_id":"3","content":"试试","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f929f3ab08.jpg","baglist_id":"1","create_time":"1520407199","create_user":"3","update_time":"1520407199","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"9","user_id":"3","content":"这就好了","img":"http://om6im9i3r.bkt.clouddn.com/2018-03-07_5a9f92b011e44.jpg","baglist_id":"1","create_time":"1520407216","create_user":"3","update_time":"1520407216","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}},{"id":"10","user_id":"3","content":"这就好了","img":null,"baglist_id":"1","create_time":"1520407880","create_user":"3","update_time":"1520407880","update_user":"3","user":{"name":"卢","username":"17801190741","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","create_time":"1518159448","labels":"白领"}}]
//     */
//
//    private String status;
//    private List<DataBean> data;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//        /**
//         * id : 1
//         * user_id : 39
//         * content : 评论测试
//         * img : null
//         * baglist_id : 1
//         * create_time : 1516464000
//         * create_user : 17801190741
//         * update_time : 1516464000
//         * update_user : 17801190741
//         * user : null
//         */
//
//        private String id;
//        private String user_id;
//        private String content;
//        private Object img;
//        private String baglist_id;
//        private String create_time;
//        private String create_user;
//        private String update_time;
//        private String update_user;
//        private Object user;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getUser_id() {
//            return user_id;
//        }
//
//        public void setUser_id(String user_id) {
//            this.user_id = user_id;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public Object getImg() {
//            return img;
//        }
//
//        public void setImg(Object img) {
//            this.img = img;
//        }
//
//        public String getBaglist_id() {
//            return baglist_id;
//        }
//
//        public void setBaglist_id(String baglist_id) {
//            this.baglist_id = baglist_id;
//        }
//
//        public String getCreate_time() {
//            return create_time;
//        }
//
//        public void setCreate_time(String create_time) {
//            this.create_time = create_time;
//        }
//
//        public String getCreate_user() {
//            return create_user;
//        }
//
//        public void setCreate_user(String create_user) {
//            this.create_user = create_user;
//        }
//
//        public String getUpdate_time() {
//            return update_time;
//        }
//
//        public void setUpdate_time(String update_time) {
//            this.update_time = update_time;
//        }
//
//        public String getUpdate_user() {
//            return update_user;
//        }
//
//        public void setUpdate_user(String update_user) {
//            this.update_user = update_user;
//        }
//
//        public Object getUser() {
//            return user;
//        }
//
//        public void setUser(Object user) {
//            this.user = user;
//        }
//    }
}
