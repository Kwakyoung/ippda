package com.example.ipdda.delivery;

public class DeliveryStoreCategoryDTO {

    private int ImgResMain, ImgResSub1, ImgResSub2, Delivery_tip, Review_cnt, Store_star ;
    private String Store_name;

    public DeliveryStoreCategoryDTO(int imgResMain, int imgResSub1, int imgResSub2, int delivery_tip, int review_cnt, int store_star, String store_name) {
        ImgResMain = imgResMain;
        ImgResSub1 = imgResSub1;
        ImgResSub2 = imgResSub2;
        Delivery_tip = delivery_tip;
        Review_cnt = review_cnt;
        Store_star = store_star;
        Store_name = store_name;
    }

    public int getImgResMain() {
        return ImgResMain;
    }

    public void setImgResMain(int imgResMain) {
        ImgResMain = imgResMain;
    }

    public int getImgResSub1() {
        return ImgResSub1;
    }

    public void setImgResSub1(int imgResSub1) {
        ImgResSub1 = imgResSub1;
    }

    public int getImgResSub2() {
        return ImgResSub2;
    }

    public void setImgResSub2(int imgResSub2) {
        ImgResSub2 = imgResSub2;
    }

    public int getDelivery_tip() {
        return Delivery_tip;
    }

    public void setDelivery_tip(int delivery_tip) {
        Delivery_tip = delivery_tip;
    }

    public int getReview_cnt() {
        return Review_cnt;
    }

    public void setReview_cnt(int review_cnt) {
        Review_cnt = review_cnt;
    }

    public int getStore_star() {
        return Store_star;
    }

    public void setStore_star(int store_star) {
        Store_star = store_star;
    }

    public String getStore_name() {
        return Store_name;
    }

    public void setStore_name(String store_name) {
        Store_name = store_name;
    }
}
