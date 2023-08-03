package com.example.ipdda.search;

public class SearchCategoryDTO {
    private int imgv;
    private String category;

    public SearchCategoryDTO(int imgv, String category) {
        this.imgv = imgv;
        this.category = category;
    }

    public int getImgv() {
        return imgv;
    }

    public void setImgv(int imgv) {
        this.imgv = imgv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
