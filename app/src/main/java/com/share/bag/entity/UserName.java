package com.share.bag.entity;

/**
 * Created by Administrator on 2018/2/1.
 */

public class UserName {
    String name;

    public UserName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
