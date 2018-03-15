package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/13.
 */

public class TalentBean {


    /**
     * status : 1
     * info : [{"id":"6","content":"123      ","img":"/Uploads/20180308/5aa0a688b18d7.jpg,/Uploads/20180308/5aa0a645694d2.png","create_user":"1","time":"1520240612","baglist_id":"3","userinfo":{"id":"1","username":"13371161938","password":"e10adc3949ba59abbe56e057f20f883e","gender":"男","iconurl":"/Uploads/20180208/5a7c1f8dbd6f5.png","name":"宋哥","balance":"0.00","foregift":"0.00","create_time":"1518158162"}},{"id":"4","content":"22","img":"/Uploads/20180308/5aa0a6275092c.png,/Uploads/20180308/5aa0a67dbb63d.jpg","create_user":"2","time":"1520240612","baglist_id":"2","userinfo":{"id":"2","username":"17801237923","password":"e10adc3949ba59abbe56e057f20f883e","gender":"男","iconurl":"/Uploads/20180208/5a7c1f8dbd6f5.png","name":"王","balance":"0.00","foregift":"0.00","create_time":"1518158279"}},{"id":"7","content":"测试1","img":"/Uploads/20180308/5aa0a67234ece.png,/Uploads/20180308/5aa0a666c396e.png","create_user":"1","time":"1520410414","baglist_id":"20","userinfo":{"id":"1","username":"13371161938","password":"e10adc3949ba59abbe56e057f20f883e","gender":"男","iconurl":"/Uploads/20180208/5a7c1f8dbd6f5.png","name":"宋哥","balance":"0.00","foregift":"0.00","create_time":"1518158162"}},{"id":"13","content":"测试来了","img":"","create_user":"3","time":"1520590032","baglist_id":"1","userinfo":{"id":"3","username":"17801190741","password":"25f9e794323b453885f5181f1b624d0b","gender":"男","iconurl":"/Uploads/20180208/5a7c1f8dbd6f5.png","name":"卢","balance":"0.00","foregift":"0.00","create_time":"1518159448"}}]
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
         * id : 6
         * content : 123
         * img : /Uploads/20180308/5aa0a688b18d7.jpg,/Uploads/20180308/5aa0a645694d2.png
         * create_user : 1
         * time : 1520240612
         * baglist_id : 3
         * userinfo : {"id":"1","username":"13371161938","password":"e10adc3949ba59abbe56e057f20f883e","gender":"男","iconurl":"/Uploads/20180208/5a7c1f8dbd6f5.png","name":"宋哥","balance":"0.00","foregift":"0.00","create_time":"1518158162"}
         */

        private String id;
        private String content;
        private String img;
        private String create_user;
        private String time;
        private String baglist_id;
        private UserinfoBean userinfo;

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

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public static class UserinfoBean {
            /**
             * id : 1
             * username : 13371161938
             * password : e10adc3949ba59abbe56e057f20f883e
             * gender : 男
             * iconurl : /Uploads/20180208/5a7c1f8dbd6f5.png
             * name : 宋哥
             * balance : 0.00
             * foregift : 0.00
             * create_time : 1518158162
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
        }
    }
}
