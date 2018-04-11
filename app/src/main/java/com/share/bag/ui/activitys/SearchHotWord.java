package com.share.bag.ui.activitys;

import java.util.List;

/**
 * @Author : TianFB
 * @Date : 2018/4/10
 * @Desrcibe ：
 */

public class SearchHotWord {
    /**
     * status : 1
     * info : [{"id":"1","name":"aoco","level":"100"},{"id":"2","name":"Dickies","level":"100"},{"id":"3","name":"kate","level":"100"},{"id":"4","name":"Diro","level":"100"},{"id":"5","name":"Dickies","level":"100"},{"id":"6","name":"女包","level":"100"}]
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
         * id : 1
         * name : aoco
         * level : 100
         */

        private String id;
        private String name;
        private String level;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}
