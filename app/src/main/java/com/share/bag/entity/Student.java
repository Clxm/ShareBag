package com.share.bag.entity;

/**
 * Created by Administrator on 2018/1/26.
 */

public class Student {
    String stitle;//简介
    String sbagsize_title;// 尺寸
    String smaterial;//材质
//    String  //商品编号



    String sbagBrand_title; //品牌
    String  sbagBrand_color;//颜色
    String  scontentimg;//图片1
    String  scontentimg2;//图片2
    public Student(String title, String title1, String color, String material, String title2, String description_1, String description_2) {

        this.stitle=title;
        this.sbagBrand_title = title1;
        this.sbagBrand_color = color;
        this.smaterial = material;
        this.sbagsize_title = title2;
        this.scontentimg = description_1;
        this.scontentimg2 = description_2;

    }



    public String getStitle() {
        return stitle;
    }

    public String getSbagsize_title() {
        return sbagsize_title;
    }

    public String getSmaterial() {
        return smaterial;
    }

    public String getSbagBrand_title() {
        return sbagBrand_title;
    }

    public String getSbagBrand_color() {
        return sbagBrand_color;
    }

    public String getScontentimg() {
        return scontentimg;
    }

    public String getScontentimg2() {
        return scontentimg2;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public void setSbagsize_title(String sbagsize_title) {
        this.sbagsize_title = sbagsize_title;
    }

    public void setSmaterial(String smaterial) {
        this.smaterial = smaterial;
    }

    public void setSbagBrand_title(String sbagBrand_title) {
        this.sbagBrand_title = sbagBrand_title;
    }

    public void setSbagBrand_color(String sbagBrand_color) {
        this.sbagBrand_color = sbagBrand_color;
    }

    public void setScontentimg(String scontentimg) {
        this.scontentimg = scontentimg;
    }

    public void setScontentimg2(String scontentimg2) {
        this.scontentimg2 = scontentimg2;
    }






    @Override
    public String toString() {
        return "Student{" +
                "stitle='" + stitle + '\'' +
                ", sbagsize_title='" + sbagsize_title + '\'' +
                ", smaterial='" + smaterial + '\'' +
                ", sbagBrand_title='" + sbagBrand_title + '\'' +
                ", sbagBrand_color='" + sbagBrand_color + '\'' +
                ", scontentimg='" + scontentimg + '\'' +
                ", scontentimg2='" + scontentimg2 + '\'' +
                '}';
    }
}
