package com.example.ipdda.goodsboard;

public class GoodsBoardReviewDTO {
    private int ImgProfile, ImgGoods, ImgReview, ReplyCnt, StarCnt;

    private String GoodsName, MemberBody, ReviewContext, MemberNickName, GoodsOption, ReviewDate;


    public GoodsBoardReviewDTO(int imgProfile, int imgGoods, int imgReview, int replyCnt, int starCnt, String goodsName, String memberBody, String reviewContext, String memberNickName, String goodsOption, String reviewDate) {
        ImgProfile = imgProfile;
        ImgGoods = imgGoods;
        ImgReview = imgReview;
        ReplyCnt = replyCnt;
        StarCnt = starCnt;
        GoodsName = goodsName;
        MemberBody = memberBody;
        ReviewContext = reviewContext;
        MemberNickName = memberNickName;
        GoodsOption = goodsOption;
        ReviewDate = reviewDate;
    }

    public int getImgProfile() {
        return ImgProfile;
    }

    public void setImgProfile(int imgProfile) {
        ImgProfile = imgProfile;
    }

    public int getImgGoods() {
        return ImgGoods;
    }

    public void setImgGoods(int imgGoods) {
        ImgGoods = imgGoods;
    }

    public int getImgReview() {
        return ImgReview;
    }

    public void setImgReview(int imgReview) {
        ImgReview = imgReview;
    }

    public int getReplyCnt() {
        return ReplyCnt;
    }

    public void setReplyCnt(int replyCnt) {
        ReplyCnt = replyCnt;
    }

    public int getStarCnt() {
        return StarCnt;
    }

    public void setStarCnt(int starCnt) {
        StarCnt = starCnt;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getMemberBody() {
        return MemberBody;
    }

    public void setMemberBody(String memberBody) {
        MemberBody = memberBody;
    }

    public String getReviewContext() {
        return ReviewContext;
    }

    public void setReviewContext(String reviewContext) {
        ReviewContext = reviewContext;
    }

    public String getMemberNickName() {
        return MemberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        MemberNickName = memberNickName;
    }

    public String getGoodsOption() {
        return GoodsOption;
    }

    public void setGoodsOption(String goodsOption) {
        GoodsOption = goodsOption;
    }

    public String getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(String reviewDate) {
        ReviewDate = reviewDate;
    }
}
