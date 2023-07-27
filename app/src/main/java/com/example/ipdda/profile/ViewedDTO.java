package com.example.ipdda.profile;

public class ViewedDTO {
    private int imgv_img;
    private String tv_price, tv_text;
    private int imgv_img1;
    private String tv_price1, tv_text1;

    public int getImgv_img() {
        return imgv_img;
    }

    public void setImgv_img(int imgv_img) {
        this.imgv_img = imgv_img;
    }

    public String getTv_price() {
        return tv_price;
    }

    public void setTv_price(String tv_price) {
        this.tv_price = tv_price;
    }

    public String getTv_text() {
        return tv_text;
    }

    public void setTv_text(String tv_text) {
        this.tv_text = tv_text;
    }

    public int getImgv_img1() {
        return imgv_img1;
    }

    public void setImgv_img1(int imgv_img1) {
        this.imgv_img1 = imgv_img1;
    }

    public String getTv_price1() {
        return tv_price1;
    }

    public void setTv_price1(String tv_price1) {
        this.tv_price1 = tv_price1;
    }

    public String getTv_text1() {
        return tv_text1;
    }

    public void setTv_text1(String tv_text1) {
        this.tv_text1 = tv_text1;
    }

    public ViewedDTO(int imgv_img, String tv_price, String tv_text, int imgv_img1, String tv_price1, String tv_text1) {
        this.imgv_img = imgv_img;
        this.tv_price = tv_price;
        this.tv_text = tv_text;
        this.imgv_img1 = imgv_img1;
        this.tv_price1 = tv_price1;
        this.tv_text1 = tv_text1;
    }
}