package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5.
 */

public class AddressBean {


    /**
     * status : 1
     * info : [{"id":"3","address":"河南省林州市玉林街道自以为元","create_user":"39","create_time":"1517388708","update_user":"39","update_time":"1517555353","is_type":"0","username":"卢晓昭","phone":"17801190741"},{"id":"2","address":"北京北京市海淀区黑龙家具和fd ","create_user":"39","create_time":"1517387084","update_user":null,"update_time":null,"is_type":"0","username":"韩语名2432423","phone":"1718123223423"},{"id":"4","address":"北京北京市海淀区黑龙家具和fd ","create_user":"39","create_time":"1517388709","update_user":null,"update_time":null,"is_type":"0","username":"韩语名2432423","phone":"1718123223423"},{"id":"5","address":"北京北京市海淀区黑龙家具和fd ","create_user":"39","create_time":"1517388710","update_user":null,"update_time":null,"is_type":"0","username":"韩语名2432423","phone":"1718123223423"}]
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
         * id : 3
         * address : 河南省林州市玉林街道自以为元
         * create_user : 39
         * create_time : 1517388708
         * update_user : 39
         * update_time : 1517555353
         * is_type : 0
         * username : 卢晓昭
         * phone : 17801190741
         */

        private String id;
        private String address;
        private String create_user;
        private String create_time;
        private String update_user;
        private String update_time;
        private String is_type;
        private String username;
        private String phone;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreate_user() {
            return create_user;
        }

        public void setCreate_user(String create_user) {
            this.create_user = create_user;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_user() {
            return update_user;
        }

        public void setUpdate_user(String update_user) {
            this.update_user = update_user;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getIs_type() {
            return is_type;
        }

        public void setIs_type(String is_type) {
            this.is_type = is_type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
