package com.example.ipdda.goodslist;

public class GoodsListDTO {
    private int GOODS_MAIN_IMAGE, GOODS_PRICE;
    private String GOODS_NAME, STORE_NAME;

    public GoodsListDTO(int GOODS_MAIN_IMAGE, int GOODS_PRICE, String GOODS_NAME, String STORE_NAME) {
        this.GOODS_MAIN_IMAGE = GOODS_MAIN_IMAGE;
        this.GOODS_PRICE = GOODS_PRICE;
        this.GOODS_NAME = GOODS_NAME;
        this.STORE_NAME = STORE_NAME;
    }

    public int getGOODS_MAIN_IMAGE() {
        return GOODS_MAIN_IMAGE;
    }

    public void setGOODS_MAIN_IMAGE(int GOODS_MAIN_IMAGE) {
        this.GOODS_MAIN_IMAGE = GOODS_MAIN_IMAGE;
    }

    public int getGOODS_PRICE() {
        return GOODS_PRICE;
    }

    public void setGOODS_PRICE(int GOODS_PRICE) {
        this.GOODS_PRICE = GOODS_PRICE;
    }

    public String getGOODS_NAME() {
        return GOODS_NAME;
    }

    public void setGOODS_NAME(String GOODS_NAME) {
        this.GOODS_NAME = GOODS_NAME;
    }

    public String getSTORE_NAME() {
        return STORE_NAME;
    }

    public void setSTORE_NAME(String STORE_NAME) {
        this.STORE_NAME = STORE_NAME;
    }
}
