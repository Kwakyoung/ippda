package com.example.ipdda.profile;

public class SubDTO {
    private int imgGoodsList,goodsCnt,goodsPrice,choiceNum;
    private String storeName,goodsName,insertDate;

    public int getImgGoodsList() {
        return imgGoodsList;
    }

    public void setImgGoodsList(int imgGoodsList) {
        this.imgGoodsList = imgGoodsList;
    }

    public int getGoodsCnt() {
        return goodsCnt;
    }

    public void setGoodsCnt(int goodsCnt) {
        this.goodsCnt = goodsCnt;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    public void setChoiceNum(int choiceNum) {
        this.choiceNum = choiceNum;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public SubDTO(int imgGoodsList, int goodsCnt, int goodsPrice, String storeName, String goodsName, int choiceNum, String insertDate) {
        this.imgGoodsList = imgGoodsList;
        this.goodsCnt = goodsCnt;
        this.goodsPrice = goodsPrice;
        this.storeName = storeName;
        this.goodsName = goodsName;
        this.choiceNum = choiceNum;
        this.insertDate = insertDate;
    }
    public SubDTO(int imgGoodsList, int goodsPrice, String storeName, String goodsName, int choiceNum, String insertDate) {
        this.imgGoodsList = imgGoodsList;
        this.goodsPrice = goodsPrice;
        this.storeName = storeName;
        this.goodsName = goodsName;
        this.choiceNum = choiceNum;
        this.insertDate = insertDate;
    }
}
