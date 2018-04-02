package com.share.bag.ui.activitys.mine.homepage;

import java.util.List;

/**
 * Created by Administrator on 2018/3/31.
 */

public class HomepageBean {


    /**
     * status : 1
     * info : {"username":"17801190741","name":"停机了","gender":null,"iconurl":"http://om6im9i3r.bkt.clouddn.com/2018-03-23_5ab46047ea8de.jpg","labels":["白领","啄木鸟"]}
     */

    private String status;
    private InfoBean info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * username : 17801190741
         * name : 停机了
         * gender : null
         * iconurl : http://om6im9i3r.bkt.clouddn.com/2018-03-23_5ab46047ea8de.jpg
         * labels : ["白领","啄木鸟"]
         */

        private String username;
        private String name;
        private Object gender;
        private String iconurl;
        private List<String> labels;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public List<String> getLabels() {
            return labels;
        }

        public void setLabels(List<String> labels) {
            this.labels = labels;
        }
    }
}
