package com.example.ipdda.profile;

public class RecvCircleDTO {
    private int imgv_img;
    private String tv_text;

    public RecvCircleDTO(int imgv_img, String tv_text) {
        this.imgv_img = imgv_img;
        this.tv_text = tv_text;
    }

    public int getImgv_img() {
        return imgv_img;
    }

    public void setImgv_img(int imgv_img) {
        this.imgv_img = imgv_img;
    }

    public String getTv_text() {
        return tv_text;
    }

    public void setTv_text(String tv_text) {
        this.tv_text = tv_text;
    }
}
