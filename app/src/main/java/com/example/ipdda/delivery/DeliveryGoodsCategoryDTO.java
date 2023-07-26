package com.example.ipdda.delivery;

public class DeliveryGoodsCategoryDTO {

    private int ImgRes1 , ImgRes2, ImgRes3, ImgRes4;
    private String CategoryName1, CategoryName2, CategoryName3, CategoryName4;

    public DeliveryGoodsCategoryDTO(int imgRes1, int imgRes2, int imgRes3, int imgRes4, String categoryName1, String categoryName2, String categoryName3, String categoryName4) {

        ImgRes1 = imgRes1;
        ImgRes2 = imgRes2;
        ImgRes3 = imgRes3;
        ImgRes4 = imgRes4;
        CategoryName1 = categoryName1;
        CategoryName2 = categoryName2;
        CategoryName3 = categoryName3;
        CategoryName4 = categoryName4;
    }

    public int getImgRes1() {
        return ImgRes1;
    }

    public void setImgRes1(int imgRes1) {
        ImgRes1 = imgRes1;
    }

    public int getImgRes2() {
        return ImgRes2;
    }

    public void setImgRes2(int imgRes2) {
        ImgRes2 = imgRes2;
    }

    public int getImgRes3() {
        return ImgRes3;
    }

    public void setImgRes3(int imgRes3) {
        ImgRes3 = imgRes3;
    }

    public int getImgRes4() {
        return ImgRes4;
    }

    public void setImgRes4(int imgRes4) {
        ImgRes4 = imgRes4;
    }

    public String getCategoryName1() {
        return CategoryName1;
    }

    public void setCategoryName1(String categoryName1) {
        CategoryName1 = categoryName1;
    }

    public String getCategoryName2() {
        return CategoryName2;
    }

    public void setCategoryName2(String categoryName2) {
        CategoryName2 = categoryName2;
    }

    public String getCategoryName3() {
        return CategoryName3;
    }

    public void setCategoryName3(String categoryName3) {
        CategoryName3 = categoryName3;
    }

    public String getCategoryName4() {
        return CategoryName4;
    }

    public void setCategoryName4(String categoryName4) {
        CategoryName4 = categoryName4;
    }
}
