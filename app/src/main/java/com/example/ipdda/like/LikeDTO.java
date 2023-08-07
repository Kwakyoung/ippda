package com.example.ipdda.like;

public class LikeDTO {
    private int imgv_img, imgv_like;
    private String tv_shop, tv_price;

    public LikeDTO(int imgv_img, int imgv_like, String tv_shop, String tv_price) {
        this.imgv_img = imgv_img;
        this.imgv_like = imgv_like;
        this.tv_shop = tv_shop;
        this.tv_price = tv_price;
    }

    public int getImgv_img() {
        return imgv_img;
    }

    public void setImgv_img(int imgv_img) {
        this.imgv_img = imgv_img;
    }

    public int getImgv_like() {
        return imgv_like;
    }

    public void setImgv_like(int imgv_like) {
        this.imgv_like = imgv_like;
    }

    public String getTv_shop() {
        return tv_shop;
    }

    public void setTv_shop(String tv_shop) {
        this.tv_shop = tv_shop;
    }

    public String getTv_price() {
        return tv_price;
    }

    public void setTv_price(String tv_price) {
        this.tv_price = tv_price;
    }
}
