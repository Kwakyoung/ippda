package com.example.ipdda.home;

public class HomeGoodsRecommendDTO {
    private int imgv_goods_top;
    private int imgv_goods_bottom;

    public HomeGoodsRecommendDTO(int imgv_goods_top, int imgv_goods_bottom) {
        this.imgv_goods_top = imgv_goods_top;
        this.imgv_goods_bottom = imgv_goods_bottom;
    }

    public int getImgv_goods_top() {
        return imgv_goods_top;
    }

    public void setImgv_goods_top(int imgv_goods_top) {
        this.imgv_goods_top = imgv_goods_top;
    }

    public int getImgv_goods_bottom() {
        return imgv_goods_bottom;
    }

    public void setImgv_goods_bottom(int imgv_goods_bottom) {
        this.imgv_goods_bottom = imgv_goods_bottom;
    }
}
