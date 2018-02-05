package com.share.bag.ui.activitys.mine.address;

/**
 * Created by Administrator on 2018/2/5.
 */

public class AddBean1 {


    String id;
    String  address;
    String  username;
    String  phone;
    String is_type;

    @Override
    public String toString() {
        return "AddBean1{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", is_type='" + is_type + '\'' +
                '}';
    }

    public AddBean1(String id, String address, String username, String phone, String is_type) {
        this.id = id;
        this.address = address;
        this.username = username;
        this.phone = phone;
        this.is_type = is_type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIs_type(String is_type) {
        this.is_type = is_type;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getIs_type() {
        return is_type;
    }
}





