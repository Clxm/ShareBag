package com.share.bag.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/12/23.
 */

public class LoginBean {
    @Override
    public String toString() {
        return "LoginBean{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user.toString()+
                '}';
    }

    /**
     * status : 0
     * info : 用户名或密码错误
     * username : 17801190741
     * password : 12345678
     * type : 3
     */

    private String status;
    private String info;
    private String username;
    private String password;
    private String type;
    /**
     * user : {"id":"3","username":"17801190741","password":"25f9e794323b453885f5181f1b624d0b","gender":"男","iconurl":"/Uploads/20180208/5a7c1f8dbd6f5.png","name":"VB好女孩","balance":"0.00","foregift":"0.00","create_time":"1518159448"}
     */

    private UserBean user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        @Override
        public String toString() {
            return "UserBean{" +
                    "id='" + id + '\'' +
                    ", usernameX='" + usernameX + '\'' +
                    ", passwordX='" + passwordX + '\'' +
                    ", gender='" + gender + '\'' +
                    ", iconurl='" + iconurl + '\'' +
                    ", name='" + name + '\'' +
                    ", balance='" + balance + '\'' +
                    ", foregift='" + foregift + '\'' +
                    ", create_time='" + create_time + '\'' +
                    '}';
        }

        /**
         * id : 3
         * username : 17801190741
         * password : 25f9e794323b453885f5181f1b624d0b
         * gender : 男
         * iconurl : /Uploads/20180208/5a7c1f8dbd6f5.png
         * name : VB好女孩
         * balance : 0.00
         * foregift : 0.00
         * create_time : 1518159448
         */

        private String id;
        @SerializedName("username")
        private String usernameX;
        @SerializedName("password")
        private String passwordX;
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

        public String getUsernameX() {
            return usernameX;
        }

        public void setUsernameX(String usernameX) {
            this.usernameX = usernameX;
        }

        public String getPasswordX() {
            return passwordX;
        }

        public void setPasswordX(String passwordX) {
            this.passwordX = passwordX;
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
