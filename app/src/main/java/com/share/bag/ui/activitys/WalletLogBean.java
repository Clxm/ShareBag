package com.share.bag.ui.activitys;

import java.util.List;

/**
 * @Author : TianFB
 * @Date : 2018/4/27
 * @Desrcibe ：
 */

public class WalletLogBean {
    /**
     * status : 1
     * info : [{"id":"1","user_id":"51","create_time":"2018-03-10 12:16:06","type":"1","content":"租包","num":"10","status":"1"}]
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
         * user_id : 51
         * create_time : 2018-03-10 12:16:06
         * type : 1
         * content : 租包
         * num : 10
         * status : 1
         */

        private String id;
        private String user_id;
        private String create_time;
        private String type;
        private String content;
        private String num;
        private String status;

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

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
