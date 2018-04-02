package com.share.bag.ui.ship;

import java.util.List;

/**
 * Created by Administrator on 2018/4/2.
 */

public class ShipBean2 {


    /**
     * status : 0
     * info : [{"id":"1","ordernumber":"1521862710","old_price":"0.01","new_price":"0.01","status":"1","create_time":"1517455508","create_user":"1","update_time":null,"update_user":"1517455508","pay_status":"3","is_order":"2","deposit_num":"0.01","logistics":null,"logistics_company":null,"order_type":null,"divide":"1"},{"id":"2","ordernumber":"1521862710","old_price":"1.00","new_price":"1.00","status":"1","create_time":"1517455784","create_user":"1","update_time":null,"update_user":"1517455784","pay_status":"2","is_order":"2","deposit_num":"1.00","logistics":null,"logistics_company":null,"order_type":null,"divide":"1"},{"id":"3","ordernumber":"1521862710","old_price":"1.00","new_price":"1.00","status":"1","create_time":"1517456533","create_user":"1","update_time":null,"update_user":"1517456533","pay_status":"2","is_order":"2","deposit_num":"1.00","logistics":null,"logistics_company":null,"order_type":null,"divide":"1"},{"id":"4","ordernumber":"1521862710","old_price":"1.00","new_price":"1.00","status":"1","create_time":"1517456634","create_user":"1","update_time":null,"update_user":"1517456634","pay_status":"2","is_order":"2","deposit_num":"1.00","logistics":null,"logistics_company":null,"order_type":null,"divide":"1"}]
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
         * ordernumber : 1521862710
         * old_price : 0.01
         * new_price : 0.01
         * status : 1
         * create_time : 1517455508
         * create_user : 1
         * update_time : null
         * update_user : 1517455508
         * pay_status : 3
         * is_order : 2
         * deposit_num : 0.01
         * logistics : null
         * logistics_company : null
         * order_type : null
         * divide : 1
         */

        private String id;
        private String ordernumber;
        private String old_price;
        private String new_price;
        private String status;
        private String create_time;
        private String create_user;
        private Object update_time;
        private String update_user;
        private String pay_status;
        private String is_order;
        private String deposit_num;
        private Object logistics;
        private Object logistics_company;
        private Object order_type;
        private String divide;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrdernumber() {
            return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
            this.ordernumber = ordernumber;
        }

        public String getOld_price() {
            return old_price;
        }

        public void setOld_price(String old_price) {
            this.old_price = old_price;
        }

        public String getNew_price() {
            return new_price;
        }

        public void setNew_price(String new_price) {
            this.new_price = new_price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public Object getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Object update_time) {
            this.update_time = update_time;
        }

        public String getUpdate_user() {
            return update_user;
        }

        public void setUpdate_user(String update_user) {
            this.update_user = update_user;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getIs_order() {
            return is_order;
        }

        public void setIs_order(String is_order) {
            this.is_order = is_order;
        }

        public String getDeposit_num() {
            return deposit_num;
        }

        public void setDeposit_num(String deposit_num) {
            this.deposit_num = deposit_num;
        }

        public Object getLogistics() {
            return logistics;
        }

        public void setLogistics(Object logistics) {
            this.logistics = logistics;
        }

        public Object getLogistics_company() {
            return logistics_company;
        }

        public void setLogistics_company(Object logistics_company) {
            this.logistics_company = logistics_company;
        }

        public Object getOrder_type() {
            return order_type;
        }

        public void setOrder_type(Object order_type) {
            this.order_type = order_type;
        }

        public String getDivide() {
            return divide;
        }

        public void setDivide(String divide) {
            this.divide = divide;
        }
    }
}
