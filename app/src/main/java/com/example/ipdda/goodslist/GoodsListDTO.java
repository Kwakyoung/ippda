package com.example.ipdda.goodslist;

public class GoodsListDTO {
    private int ImgGoodsList1, ImgGoodsList2, GoodsPrice1, GoodsPrice2 ;

    private String StoreName1, GoodsName1 , StoreName2, GoodsName2;

    public GoodsListDTO(int imgGoodsList1, int imgGoodsList2, int goodsPrice1, int goodsPrice2, String storeName1, String goodsName1, String storeName2, String goodsName2) {
        ImgGoodsList1 = imgGoodsList1;
        ImgGoodsList2 = imgGoodsList2;
        GoodsPrice1 = goodsPrice1;
        GoodsPrice2 = goodsPrice2;
        StoreName1 = storeName1;
        GoodsName1 = goodsName1;
        StoreName2 = storeName2;
        GoodsName2 = goodsName2;
    }

    public int getImgGoodsList1() {
        return ImgGoodsList1;
    }

    public void setImgGoodsList1(int imgGoodsList1) {
        ImgGoodsList1 = imgGoodsList1;
    }

    public int getImgGoodsList2() {
        return ImgGoodsList2;
    }

    public void setImgGoodsList2(int imgGoodsList2) {
        ImgGoodsList2 = imgGoodsList2;
    }

    public int getGoodsPrice1() {
        return GoodsPrice1;
    }

    public void setGoodsPrice1(int goodsPrice1) {
        GoodsPrice1 = goodsPrice1;
    }

    public int getGoodsPrice2() {
        return GoodsPrice2;
    }

    public void setGoodsPrice2(int goodsPrice2) {
        GoodsPrice2 = goodsPrice2;
    }

    public String getStoreName1() {
        return StoreName1;
    }

    public void setStoreName1(String storeName1) {
        StoreName1 = storeName1;
    }

    public String getGoodsName1() {
        return GoodsName1;
    }

    public void setGoodsName1(String goodsName1) {
        GoodsName1 = goodsName1;
    }

    public String getStoreName2() {
        return StoreName2;
    }

    public void setStoreName2(String storeName2) {
        StoreName2 = storeName2;
    }

    public String getGoodsName2() {
        return GoodsName2;
    }

    public void setGoodsName2(String goodsName2) {
        GoodsName2 = goodsName2;
    }
}
