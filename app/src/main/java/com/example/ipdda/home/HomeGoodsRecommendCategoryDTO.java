package com.example.ipdda.home;

public class HomeGoodsRecommendCategoryDTO {

    private int imgv_category;

    private String tv_category;

    public HomeGoodsRecommendCategoryDTO(int imgv_category, String tv_category) {
        this.imgv_category = imgv_category;
        this.tv_category = tv_category;
    }

    public int getImgv_category() {
        return imgv_category;
    }

    public void setImgv_category(int imgv_category) {
        this.imgv_category = imgv_category;
    }

    public String getTv_category() {
        return tv_category;
    }

    public void setTv_category(String tv_category) {
        this.tv_category = tv_category;
    }
}
